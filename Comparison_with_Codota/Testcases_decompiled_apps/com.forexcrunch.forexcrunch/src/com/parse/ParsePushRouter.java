package com.parse;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.google.analytics.tracking.android.ModelFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParsePushRouter {
    static final /* synthetic */ boolean $assertionsDisabled = (!ParsePushRouter.class.desiredAssertionStatus());
    private static final Pattern CHANNEL_PATTERN = Pattern.compile("^$|^[a-zA-Z][A-Za-z0-9_-]*$");
    private static final String LEGACY_ROUTE_LOCATION = "persistentCallbacks";
    private static final String STATE_LOCATION = "pushState";
    private static final String TAG = "com.parse.ParsePushRouter";
    static Map<String, CallbackFactory> channelRoutes = null;
    static Set<String> channels = new HashSet();
    static CallbackFactory defaultRoute = null;
    private static boolean hasLoadedStateFromDisk = $assertionsDisabled;
    static JSONObject history = null;
    static String ignoreAfter = null;
    static String lastTime = null;
    static int maxHistory = 10;

    ParsePushRouter() {
    }

    static class CallbackFactory {
        Class<? extends PushCallback> clazz;
        JSONObject contextData;

        CallbackFactory(JSONObject definition) throws ClassNotFoundException {
            Parse.logD(ParsePushRouter.TAG, "Creating factory for class " + definition.optString("name"));
            this.clazz = Class.forName(definition.optString("name"));
            if (this.clazz == null) {
                throw new ClassNotFoundException("Missing class definition in " + definition);
            }
            this.contextData = definition.optJSONObject("data");
        }

        CallbackFactory(Class<? extends PushCallback> aClass, JSONObject aContextData) {
            this.clazz = aClass;
            this.contextData = aContextData;
        }

        /* access modifiers changed from: package-private */
        public PushCallback newCallback() throws IllegalAccessException, InstantiationException {
            PushCallback callback = (PushCallback) this.clazz.newInstance();
            callback.setLocalData(this.contextData);
            return callback;
        }

        /* access modifiers changed from: package-private */
        public JSONObject toJSON() {
            try {
                JSONObject object = new JSONObject();
                object.put("name", this.clazz.getCanonicalName());
                object.putOpt("data", this.contextData);
                return object;
            } catch (JSONException e) {
                Parse.logE(ParsePushRouter.TAG, "Failed to encode route: " + e.getMessage());
                return null;
            }
        }

        protected CallbackFactory() {
        }

        /* access modifiers changed from: package-private */
        public boolean requiresSubscription() {
            return true;
        }
    }

    private static void saveEventually(final Context context, final ParseInstallation installation) {
        installation.saveEventually(new SaveCallback() {
            public void done(ParseException e) {
                if (e != null) {
                    Parse.logE(ParsePushRouter.TAG, "Failed to save installation eventually", e);
                    return;
                }
                ParsePushRouter.ensureStateIsLoaded(context);
                synchronized (ParsePushRouter.class) {
                    ParsePushRouter.channels.clear();
                    ParsePushRouter.channels.addAll(installation.getList("channels"));
                }
                if (!ParsePushRouter.hasRoutes(context)) {
                    Parse.logD(ParsePushRouter.TAG, "Shutting down push service. No remaining channels");
                    context.stopService(new Intent(context, PushService.class));
                }
                final Context context = context;
                new BackgroundTask<Void>((ParseCallback) null) {
                    public Void run() throws ParseException {
                        ParsePushRouter.saveStateToDisk(context);
                        return null;
                    }
                }.execute(new Void[0]);
            }
        });
    }

    public static synchronized boolean hasRoutes(Context context) {
        boolean z;
        synchronized (ParsePushRouter.class) {
            ensureStateIsLoaded(context);
            z = (defaultRoute != null || (channelRoutes != null && !channelRoutes.isEmpty()) || !getSubscriptions(context).isEmpty()) ? true : $assertionsDisabled;
        }
        return z;
    }

    static synchronized void ensureStateIsLoaded(Context context) {
        CallbackFactory callbackFactory = null;
        synchronized (ParsePushRouter.class) {
            if (!hasLoadedStateFromDisk) {
                hasLoadedStateFromDisk = true;
                defaultRoute = null;
                channelRoutes = new HashMap();
                history = new JSONObject();
                JSONObject jsonData = ParseObject.getDiskObject(context, LEGACY_ROUTE_LOCATION);
                if (jsonData != null) {
                    Parse.logD(TAG, "Loading legacy route map: " + jsonData.toString());
                    parseChannelRoutes(jsonData);
                    channels.clear();
                    channels.addAll(channelRoutes.keySet());
                    ParseInstallation installation = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                    installation.addAllUnique("channels", channelRoutes.keySet());
                    saveEventually(context, installation);
                    ParseObject.deleteDiskObject(context, LEGACY_ROUTE_LOCATION);
                }
                JSONObject jsonData2 = ParseObject.getDiskObject(context, STATE_LOCATION);
                if (jsonData2 != null) {
                    parseChannelRoutes(jsonData2.optJSONObject("routes"));
                    JSONObject defaultDefinition = jsonData2.optJSONObject("defaultRoute");
                    if (defaultDefinition != null) {
                        try {
                            callbackFactory = new CallbackFactory(defaultDefinition);
                        } catch (ClassNotFoundException e) {
                            Parse.logE(TAG, "Default route references undefined class: " + e.getMessage());
                        } catch (ClassCastException e2) {
                            Parse.logE(TAG, "Default route references class which is not a PushCallback: " + e2.getMessage());
                        }
                    }
                    defaultRoute = callbackFactory;
                    lastTime = jsonData2.optString("lastTime", (String) null);
                    ignoreAfter = jsonData2.optString("ignoreAfter", (String) null);
                    JSONArray added = jsonData2.optJSONArray("addChannels");
                    if (added != null) {
                        List<String> channels2 = new ArrayList<>();
                        for (int i = 0; i < added.length(); i++) {
                            channels2.add(added.optString(i));
                        }
                        ParseInstallation installation2 = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                        installation2.addUnique("channels", channels2);
                        saveEventually(context, installation2);
                    }
                    JSONArray removed = jsonData2.optJSONArray("removeChannels");
                    if (removed != null) {
                        List<String> channels3 = new ArrayList<>();
                        for (int i2 = 0; i2 < removed.length(); i2++) {
                            channels3.add(removed.optString(i2));
                        }
                        ParseInstallation installation3 = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                        installation3.removeAll("channels", channels3);
                        saveEventually(context, installation3);
                    }
                    if (jsonData2.has("installation")) {
                        ParseInstallation installation4 = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                        installation4.mergeAfterFetch(jsonData2.optJSONObject("installation"), true);
                        List<String> fromJSON = installation4.getList("channels");
                        if (fromJSON != null) {
                            synchronized (channels) {
                                channels.clear();
                                channels.addAll(fromJSON);
                            }
                        }
                    } else if (jsonData2.has("channels")) {
                        JSONArray channelsArray = jsonData2.optJSONArray("channels");
                        synchronized (channels) {
                            for (int i3 = 0; i3 < channelsArray.length(); i3++) {
                                channels.add(channelsArray.optString(i3));
                            }
                        }
                    }
                    if (jsonData2.has(Constants.HISTORY_CALENDAR_DETAILS)) {
                        history = jsonData2.optJSONObject(Constants.HISTORY_CALENDAR_DETAILS);
                    }
                }
            }
        }
    }

    private static void parseChannelRoutes(JSONObject channelMap) {
        if (channelMap != null) {
            channelRoutes.clear();
            Iterator<String> channels2 = channelMap.keys();
            while (channels2.hasNext()) {
                String channel = channels2.next();
                JSONObject definition = null;
                try {
                    definition = channelMap.getJSONObject(channel);
                    channelRoutes.put(channel, new CallbackFactory(definition));
                } catch (JSONException e) {
                    Parse.logE(TAG, "Failed to parse push route " + definition);
                } catch (ClassNotFoundException e2) {
                    Parse.logE(TAG, "Route references missing class: " + e2.getMessage());
                } catch (ClassCastException e3) {
                    Parse.logE(TAG, "Route references class which is not a PushCallback: " + e3.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void saveStateToDisk(Context context) {
        synchronized (ParsePushRouter.class) {
            ensureStateIsLoaded(context);
            try {
                JSONObject serializedData = new JSONObject();
                serializedData.put("version", 3);
                if (defaultRoute != null) {
                    serializedData.putOpt("defaultRoute", defaultRoute.toJSON());
                }
                JSONObject channelMap = new JSONObject();
                for (String channel : channelRoutes.keySet()) {
                    channelMap.putOpt(channel, channelRoutes.get(channel).toJSON());
                }
                serializedData.putOpt("routes", channelMap);
                serializedData.put("channels", new JSONArray(channels));
                serializedData.putOpt("lastTime", lastTime);
                serializedData.putOpt(Constants.HISTORY_CALENDAR_DETAILS, history);
                serializedData.putOpt("ignoreAfter", ignoreAfter);
                ParseObject.saveDiskObject(context, STATE_LOCATION, serializedData);
            } catch (JSONException e) {
                Parse.logE(TAG, "Failed to save push routes to disk" + e.getMessage());
            }
        }
        return;
    }

    static synchronized void insertIntoHistory(String newId, String newTimestamp) {
        synchronized (ParsePushRouter.class) {
            try {
                history.putOpt(newId, newTimestamp);
            } catch (JSONException e) {
            }
            String youngestCut = null;
            if ($assertionsDisabled || maxHistory > 0) {
                while (history.length() > maxHistory) {
                    Iterator<String> itr = history.keys();
                    String oldestId = itr.next();
                    String oldestTime = history.optString(oldestId);
                    while (itr.hasNext()) {
                        String id = itr.next();
                        String time = history.optString(id);
                        if (time.compareTo(oldestTime) < 0) {
                            oldestId = id;
                            oldestTime = time;
                        }
                    }
                    history.remove(oldestId);
                    youngestCut = oldestTime;
                }
                if (youngestCut != null) {
                    ignoreAfter = youngestCut;
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    static synchronized boolean addChannelRoute(Context context, String channel, JSONObject localData, Class<? extends PushCallback> clazz) {
        boolean isNew;
        synchronized (ParsePushRouter.class) {
            ensureStateIsLoaded(context);
            try {
                if (channelRoutes.put(channel, new CallbackFactory(clazz, new JSONObject(localData.toString()))) == null) {
                    isNew = true;
                } else {
                    isNew = false;
                }
                if (isNew) {
                    ParseInstallation installation = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                    installation.addUnique("channels", channel);
                    saveEventually(context, installation);
                }
            } catch (JSONException e) {
                Parse.logE(TAG, "Impossible exception when deserializing a serialized JSON string: " + e.getMessage());
                isNew = false;
            }
        }
        return isNew;
    }

    static boolean addChannelRoute(Context context, String channel, Class<? extends Activity> clazz, int icon) {
        if (channel == null) {
            throw new NullPointerException("invalid channel: you cannot subscribe to null");
        } else if (!CHANNEL_PATTERN.matcher(channel).matches()) {
            throw new IllegalArgumentException("invalid channel name: " + channel);
        } else {
            JSONObject localData = dataForActivity(context, clazz, icon);
            if (localData == null) {
                return $assertionsDisabled;
            }
            return addChannelRoute(context, channel, localData, (Class<? extends PushCallback>) StandardPushCallback.class);
        }
    }

    static JSONObject dataForActivity(Context context, Class<? extends Activity> clazz, int icon) {
        String appName;
        getApplicationId(context);
        String packageName = context.getPackageName();
        PackageManager pm = context.getPackageManager();
        try {
            CharSequence appChars = pm.getApplicationInfo(packageName, 0).loadLabel(pm);
            if (appChars != null) {
                appName = appChars.toString();
            } else {
                appName = null;
            }
            ComponentName componentName = new ComponentName(context, clazz);
            String activityClass = componentName.getClassName();
            String activityPackage = componentName.getPackageName();
            JSONObject localData = new JSONObject();
            try {
                localData.put("icon", icon);
                localData.put(ModelFields.APP_NAME, appName);
                localData.put("activityClass", activityClass);
                localData.put("activityPackage", activityPackage);
                return localData;
            } catch (JSONException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Parse.logE(TAG, "missing package " + packageName, e2);
            return null;
        }
    }

    static void setDefaultRoute(Context context, Class<? extends Activity> clazz, int icon) {
        ensureStateIsLoaded(context);
        if (clazz == null) {
            defaultRoute = null;
        } else {
            JSONObject localData = dataForActivity(context, clazz, icon);
            if (localData == null) {
                localData = new JSONObject();
            }
            defaultRoute = new CallbackFactory(StandardPushCallback.class, localData);
        }
        saveStateToDisk(context);
    }

    static synchronized boolean removeChannelRoute(Context context, String channel) {
        boolean z = true;
        synchronized (ParsePushRouter.class) {
            ensureStateIsLoaded(context);
            if (channelRoutes.remove(channel) != null) {
                ParseInstallation installation = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                installation.removeAll("channels", Arrays.asList(new String[]{channel}));
                saveEventually(context, installation);
            } else {
                z = false;
            }
        }
        return z;
    }

    static synchronized Set<String> getSubscriptions(Context context) {
        Set<String> unmodifiableSet;
        synchronized (ParsePushRouter.class) {
            ensureStateIsLoaded(context);
            unmodifiableSet = Collections.unmodifiableSet(channels);
        }
        return unmodifiableSet;
    }

    static synchronized String getApplicationId(Context context) {
        String cached;
        synchronized (ParsePushRouter.class) {
            JSONObject oauth = ParseObject.getDiskObject(context, "oauth");
            if (oauth == null) {
                oauth = new JSONObject();
            }
            cached = oauth.optString("key");
            if (cached == "") {
                String applicationId = ParseObject.getApplicationId();
                try {
                    oauth.put("key", applicationId);
                } catch (JSONException e) {
                    Parse.logE(TAG, "JSONException in getApplicationId()", e);
                }
                ParseObject.saveDiskObject(context, "oauth", oauth);
                cached = applicationId;
            }
        }
        return cached;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void handlePushData(com.parse.PushService r7, java.lang.String r8, org.json.JSONObject r9) {
        /*
            r0 = 0
            java.lang.Class<com.parse.PushService> r4 = com.parse.PushService.class
            monitor-enter(r4)
            java.util.Map<java.lang.String, com.parse.ParsePushRouter$CallbackFactory> r3 = channelRoutes     // Catch:{ all -> 0x0077 }
            java.lang.Object r2 = r3.get(r8)     // Catch:{ all -> 0x0077 }
            com.parse.ParsePushRouter$CallbackFactory r2 = (com.parse.ParsePushRouter.CallbackFactory) r2     // Catch:{ all -> 0x0077 }
            if (r2 != 0) goto L_0x0034
            com.parse.ParsePushRouter$CallbackFactory r3 = defaultRoute     // Catch:{ all -> 0x0077 }
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = "com.parse.ParsePushRouter"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "Received push "
            r5.<init>(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = " that has no handler"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0077 }
            com.parse.Parse.logW(r3, r5)     // Catch:{ all -> 0x0077 }
            monitor-exit(r4)     // Catch:{ all -> 0x0077 }
        L_0x0031:
            return
        L_0x0032:
            com.parse.ParsePushRouter$CallbackFactory r2 = defaultRoute     // Catch:{ all -> 0x0077 }
        L_0x0034:
            com.parse.PushCallback r0 = r2.newCallback()     // Catch:{ IllegalAccessException -> 0x005a, InstantiationException -> 0x007a }
            monitor-exit(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "com.parse.ParsePushRouter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "received push on channel "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.parse.Parse.logD(r3, r4)
            r0.setService(r7)
            r0.setPushData(r9)
            r0.setChannel(r8)
            r0.run()
            goto L_0x0031
        L_0x005a:
            r1 = move-exception
            java.lang.String r3 = "com.parse.ParsePushRouter"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "illegal access to "
            r5.<init>(r6)     // Catch:{ all -> 0x0077 }
            java.lang.Class<? extends com.parse.PushCallback> r6 = r2.clazz     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = r6.getCanonicalName()     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0077 }
            com.parse.Parse.logE(r3, r5, r1)     // Catch:{ all -> 0x0077 }
            monitor-exit(r4)     // Catch:{ all -> 0x0077 }
            goto L_0x0031
        L_0x0077:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0077 }
            throw r3
        L_0x007a:
            r1 = move-exception
            java.lang.String r3 = "com.parse.ParsePushRouter"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "could not instantiate "
            r5.<init>(r6)     // Catch:{ all -> 0x0077 }
            java.lang.Class<? extends com.parse.PushCallback> r6 = r2.clazz     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = r6.getCanonicalName()     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0077 }
            com.parse.Parse.logE(r3, r5, r1)     // Catch:{ all -> 0x0077 }
            monitor-exit(r4)     // Catch:{ all -> 0x0077 }
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParsePushRouter.handlePushData(com.parse.PushService, java.lang.String, org.json.JSONObject):void");
    }

    static void routePush(final PushService service, final JSONObject message) {
        boolean dirty = $assertionsDisabled;
        final String channel = message.optString("channel", (String) null);
        try {
            if (message.has("time")) {
                if (lastTime == null || message.optString("time").compareTo(lastTime) > 0) {
                    lastTime = message.optString("time");
                    dirty = true;
                }
                if (ignoreAfter != null && message.optString("time").compareTo(ignoreAfter) <= 0) {
                    Parse.logD(TAG, "Ignoring very old push " + message.toString());
                    if (!dirty) {
                        return;
                    }
                    return;
                }
            }
            if (channel != null) {
                if (!isSubscribedToChannel(service, channel)) {
                    new BackgroundTask<Boolean>(new ParseCallback<Boolean>() {
                        /* access modifiers changed from: package-private */
                        public void internalDone(Boolean returnValue, ParseException e) {
                            if (returnValue != null && returnValue.booleanValue()) {
                                ParsePushRouter.saveStateToDisk(PushService.this);
                                ParsePushRouter.routePush(PushService.this, message);
                            }
                        }
                    }) {
                        public Boolean run() throws ParseException {
                            ParseInstallation installation = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                            Parse.logI(ParsePushRouter.TAG, "refetching installation to check for out of sync channel subscription in channel " + channel);
                            installation.fetch();
                            List<String> fromInstallation = installation.getList("channels");
                            synchronized (ParsePushRouter.class) {
                                ParsePushRouter.channels.clear();
                                ParsePushRouter.channels.addAll(fromInstallation);
                                ParsePushRouter.saveStateToDisk(service);
                            }
                            return Boolean.valueOf(ParsePushRouter.isSubscribedToChannel(service, channel));
                        }
                    }.execute(new Void[0]);
                    if (dirty) {
                        saveStateToDisk(service);
                        return;
                    }
                    return;
                }
            }
            if (message.has("push_id")) {
                String id = message.optString("push_id");
                if (history.has(id)) {
                    Parse.logD(TAG, "Ignoring redundant push " + message.toString());
                    if (dirty) {
                        saveStateToDisk(service);
                        return;
                    }
                    return;
                }
                insertIntoHistory(id, message.optString("time"));
                dirty = true;
            } else if (message.has("time") && (lastTime == null || message.optString("time").compareTo(lastTime) > 0)) {
                lastTime = message.optString("time");
                dirty = true;
            }
            if (dirty) {
                saveStateToDisk(service);
            }
            handlePushData(service, channel, message.optJSONObject("data"));
        } finally {
            if (dirty) {
                saveStateToDisk(service);
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized boolean isSubscribedToChannel(Context context, String channel) {
        boolean z = true;
        synchronized (ParsePushRouter.class) {
            if (!channels.contains(channel)) {
                CallbackFactory factory = channelRoutes.get(channel);
                if (factory == null || factory.requiresSubscription()) {
                    z = $assertionsDisabled;
                }
            }
        }
        return z;
    }

    static class SingletonFactory extends CallbackFactory {
        PushCallback singleton;

        SingletonFactory(PushCallback callback) {
            this.singleton = callback;
        }

        /* access modifiers changed from: package-private */
        public JSONObject toJSON() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public PushCallback newCallback() {
            return this.singleton;
        }

        /* access modifiers changed from: package-private */
        public boolean requiresSubscription() {
            return ParsePushRouter.$assertionsDisabled;
        }
    }

    static void addSingletonRoute(Context context, String channel, PushCallback callback) {
        ensureStateIsLoaded(context);
        if (channel != null) {
            channelRoutes.put(channel, new SingletonFactory(callback));
        } else {
            defaultRoute = new SingletonFactory(callback);
        }
    }

    static synchronized JSONObject getPushRequestJSON(Context context) {
        JSONObject request;
        synchronized (ParsePushRouter.class) {
            ensureStateIsLoaded(context);
            request = new JSONObject();
            try {
                request.put("installation_id", ParseInstallation.getCurrentInstallation().getInstallationId());
                request.put("oauth_key", getApplicationId(context));
                request.put("v", "a1.3.4");
                if (lastTime == null) {
                    request.put("last", JSONObject.NULL);
                } else {
                    request.put("last", lastTime);
                }
                if (history.length() != 0) {
                    JSONArray knownIds = new JSONArray();
                    Iterator<String> itr = history.keys();
                    while (itr.hasNext()) {
                        knownIds.put(itr.next());
                    }
                    request.put("last_seen", knownIds);
                }
                request.putOpt("ignore_after", ignoreAfter);
            } catch (JSONException e) {
                Parse.logE(TAG, "unexpected JSONException", e);
                request = null;
            }
        }
        return request;
    }

    static void clearStateFromMemory() {
        hasLoadedStateFromDisk = $assertionsDisabled;
        channelRoutes = null;
        defaultRoute = null;
        lastTime = null;
        channels = new HashSet();
        history = null;
    }

    static void clearStateFromDisk(Context context) {
        clearStateFromMemory();
        ParseObject.deleteDiskObject(context, LEGACY_ROUTE_LOCATION);
        ParseObject.deleteDiskObject(context, STATE_LOCATION);
    }
}
