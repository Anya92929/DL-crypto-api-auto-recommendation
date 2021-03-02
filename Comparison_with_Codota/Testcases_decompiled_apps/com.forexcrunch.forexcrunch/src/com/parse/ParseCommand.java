package com.parse;

import com.google.android.gcm.GCMConstants;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.parse.Task;
import com.parse.codec.digest.DigestUtils;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

class ParseCommand {
    private static int CONNECTION_TIMEOUT = 10000;
    private static int INITIAL_DELAY = 1000;
    private static int SOCKET_TIMEOUT = 10000;
    static final ScheduledExecutorService networkThreadPool = Executors.newScheduledThreadPool(5);
    static HttpClient testClient = null;
    /* access modifiers changed from: private */
    public int attemptsMade = 0;
    private HttpClient client;
    /* access modifiers changed from: private */
    public AtomicReference<Task<Object>.TaskCompletionSource> currentTask = new AtomicReference<>();
    /* access modifiers changed from: private */
    public long delay = 0;
    private String localId;

    /* renamed from: op */
    String f1758op;
    JSONObject params;
    /* access modifiers changed from: private */
    public HttpPost post;
    /* access modifiers changed from: private */
    public boolean retryEnabled = false;
    private final String sessionToken;

    ParseCommand(String theOp, String sessionToken2) {
        this.f1758op = theOp;
        this.params = new JSONObject();
        this.sessionToken = sessionToken2;
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIMEOUT);
        this.client = testClient != null ? testClient : new DefaultHttpClient(httpParameters);
        maybeSetupHttpProxy();
    }

    ParseCommand(JSONObject json) throws JSONException {
        this.f1758op = json.getString("op");
        this.params = json.getJSONObject("params");
        this.localId = json.optString("localId", (String) null);
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIMEOUT);
        this.client = testClient != null ? testClient : new DefaultHttpClient(httpParameters);
        maybeSetupHttpProxy();
        if (json.has("session_token")) {
            this.sessionToken = json.getString("session_token");
        } else {
            this.sessionToken = ParseUser.getCurrentSessionToken();
        }
    }

    /* access modifiers changed from: package-private */
    public void put(String key, String value) {
        try {
            this.params.put(key, value);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void put(String key, int value) {
        try {
            this.params.put(key, value);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void put(String key, long value) {
        try {
            this.params.put(key, value);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void put(String key, JSONArray value) {
        try {
            this.params.put(key, value);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void put(String key, JSONObject value) {
        try {
            this.params.put(key, value);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void setOp(String theOp) {
        this.f1758op = theOp;
    }

    /* access modifiers changed from: package-private */
    public String getLocalId() {
        return this.localId;
    }

    /* access modifiers changed from: package-private */
    public void setLocalId(String theLocalId) {
        this.localId = theLocalId;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObject() {
        try {
            JSONObject answer = new JSONObject();
            answer.put("op", this.f1758op);
            answer.put("params", this.params);
            if (this.localId != null) {
                answer.put("localId", this.localId);
            }
            answer.put("session_token", this.sessionToken != null ? this.sessionToken : JSONObject.NULL);
            return answer;
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public String getCacheKey() {
        try {
            String json = toDeterministicString(this.params);
            if (this.sessionToken != null) {
                json = String.valueOf(json) + this.sessionToken;
            }
            return "ParseCommand." + this.f1758op + "." + "2" + "." + DigestUtils.md5Hex(json);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    static String toDeterministicString(Object o) throws JSONException {
        JSONStringer stringer = new JSONStringer();
        addToStringer(stringer, o);
        return stringer.toString();
    }

    static void addToStringer(JSONStringer stringer, Object o) throws JSONException {
        if (o instanceof JSONObject) {
            stringer.object();
            JSONObject object = (JSONObject) o;
            Iterator<String> keyIterator = object.keys();
            ArrayList<String> keys = new ArrayList<>();
            while (keyIterator.hasNext()) {
                keys.add(keyIterator.next());
            }
            Collections.sort(keys);
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                stringer.key(key);
                addToStringer(stringer, object.opt(key));
            }
            stringer.endObject();
        } else if (o instanceof JSONArray) {
            JSONArray array = (JSONArray) o;
            stringer.array();
            for (int i = 0; i < array.length(); i++) {
                addToStringer(stringer, array.get(i));
            }
            stringer.endArray();
        } else {
            stringer.value(o);
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Object> performAsync() {
        return performAsync(false);
    }

    /* access modifiers changed from: package-private */
    public ParseException connectionFailed(String message, Exception e) {
        return new ParseException(100, String.valueOf(message) + ": " + e.getClass().getName() + ": " + e.getMessage());
    }

    /* access modifiers changed from: package-private */
    public void preparePost() throws ParseException {
        Iterator<String> keys = this.params.keys();
        JSONObject fullParams = new JSONObject();
        while (keys.hasNext()) {
            try {
                String key = keys.next();
                fullParams.put(key, this.params.get(key));
            } catch (JSONException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        fullParams.put("v", "a1.3.4");
        fullParams.put("iid", ParseInstallation.getCurrentInstallation().getInstallationId());
        fullParams.put("uuid", UUID.randomUUID().toString());
        if (this.sessionToken != null) {
            fullParams.put("session_token", this.sessionToken);
        }
        this.post = new HttpPost(String.format("%s/%s/%s", new Object[]{ParseObject.server, "2", this.f1758op}));
        try {
            StringEntity entity = new StringEntity(fullParams.toString(), "UTF8");
            entity.setContentType("application/json");
            this.post.setEntity(entity);
            OAuthConsumer consumer = new CommonsHttpOAuthConsumer(Parse.applicationId, Parse.clientKey);
            consumer.setTokenWithSecret((String) null, "");
            try {
                consumer.sign((Object) this.post);
            } catch (OAuthMessageSignerException e2) {
                throw new ParseException((int) ParseException.NOT_INITIALIZED, e2.getMessage());
            } catch (OAuthExpectationFailedException e3) {
                throw new ParseException((int) ParseException.NOT_INITIALIZED, e3.getMessage());
            } catch (OAuthCommunicationException e4) {
                throw new ParseException((int) ParseException.NOT_INITIALIZED, e4.getMessage());
            }
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException(e5.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Object> performAsync(final boolean saveToCache) {
        Parse.checkInit();
        final Task<TResult>.TaskCompletionSource create = Task.create();
        this.currentTask.set(create);
        Task.call(new Callable<Void>() {
            public Void call() throws Exception {
                ParseCommand.this.resolveLocalIds();
                if (ParseCommand.this.post != null && ParseCommand.this.post.getURI().getHost().equals(ParseObject.server)) {
                    return null;
                }
                ParseCommand.this.preparePost();
                return null;
            }
        }).continueWithTask(new Continuation<Void, Task<JSONObject>>() {
            public Task<JSONObject> then(Task<Void> task) throws Exception {
                return ParseCommand.this.sendRequestWithRetriesAsync();
            }
        }).onSuccess(new Continuation<JSONObject, Object>() {
            public Object then(Task<JSONObject> task) throws Exception {
                JSONObject result = task.getResult();
                try {
                    if (result.has(GCMConstants.EXTRA_ERROR)) {
                        throw new ParseException(result.getInt("code"), result.getString(GCMConstants.EXTRA_ERROR));
                    }
                    Object answer = result.get("result");
                    if (saveToCache) {
                        Parse.saveToKeyValueCache(ParseCommand.this.getCacheKey(), answer.toString());
                    }
                    return answer;
                } catch (JSONException e) {
                    throw ParseCommand.this.connectionFailed("corrupted json", e);
                }
            }
        }).continueWithTask(new Continuation<Object, Task<Void>>() {
            public Task<Void> then(Task<Object> task) throws Exception {
                if (task.isCancelled()) {
                    create.trySetCancelled();
                    return null;
                } else if (task.isFaulted()) {
                    create.trySetError(task.getError());
                    return null;
                } else {
                    create.trySetResult(task.getResult());
                    return null;
                }
            }
        });
        return create.getTask();
    }

    /* access modifiers changed from: private */
    public Task<JSONObject> sendRequestWithRetriesAsync() {
        return sendRequestAsync(this.client, this.post).continueWithTask(new Continuation<JSONObject, Task<JSONObject>>() {
            public Task<JSONObject> then(Task<JSONObject> task) {
                if (((Task.TaskCompletionSource) ParseCommand.this.currentTask.get()).getTask().isCancelled()) {
                    return Task.cancelled();
                }
                ParseCommand parseCommand = ParseCommand.this;
                parseCommand.attemptsMade = parseCommand.attemptsMade + 1;
                if (!task.isFaulted() || !(task.getError() instanceof ParseException) || !ParseCommand.this.retryEnabled || ParseCommand.this.attemptsMade >= 5) {
                    return task;
                }
                Parse.logI("com.parse.ParseCommand", "Fetch failed. Waiting " + ParseCommand.this.delay + " milliseconds before attempt #" + (ParseCommand.this.attemptsMade + 1));
                final Task<TResult>.TaskCompletionSource create = Task.create();
                ParseCommand.networkThreadPool.schedule(new Runnable() {
                    public void run() {
                        create.setResult(null);
                    }
                }, ParseCommand.this.delay, TimeUnit.MILLISECONDS);
                return create.getTask().continueWithTask(new Continuation<Void, Task<JSONObject>>() {
                    public Task<JSONObject> then(Task<Void> task) {
                        ParseCommand.this.calculateNextDelay();
                        return ParseCommand.this.sendRequestWithRetriesAsync();
                    }
                });
            }
        });
    }

    private void maybeSetupHttpProxy() {
        String host = System.getProperty("http.proxyHost");
        String portString = System.getProperty("http.proxyPort");
        if (host != null && host.length() != 0 && portString != null && portString.length() != 0) {
            this.client.getParams().setParameter("http.route.default-proxy", new HttpHost(host, Integer.parseInt(portString), ImageDownloader.SCHEME_HTTP));
        }
    }

    private Task<JSONObject> sendRequestAsync(final HttpClient client2, final HttpPost post2) {
        if (this.currentTask.get().getTask().isCancelled()) {
            return Task.cancelled();
        }
        return Task.call(new Callable<JSONObject>() {
            public JSONObject call() throws Exception {
                try {
                    try {
                        return new JSONObject(new JSONTokener(new BufferedReader(new InputStreamReader(client2.execute(post2).getEntity().getContent(), "UTF-8"), 8192).readLine()));
                    } catch (JSONException e) {
                        throw ParseCommand.this.connectionFailed("bad json response", e);
                    }
                } catch (ClientProtocolException e2) {
                    throw ParseCommand.this.connectionFailed("bad protocol", e2);
                } catch (IOException e3) {
                    throw ParseCommand.this.connectionFailed("i/o failure", e3);
                }
            }
        }, networkThreadPool);
    }

    /* access modifiers changed from: private */
    public void calculateNextDelay() {
        this.delay *= 2;
    }

    public void enableRetrying() {
        this.retryEnabled = true;
        this.delay = ((long) INITIAL_DELAY) + ((long) (((double) INITIAL_DELAY) * Math.random()));
    }

    public static void setInitialDelay(double seconds) {
        INITIAL_DELAY = (int) (1000.0d * seconds);
    }

    public void cancel() {
        Task<Object>.TaskCompletionSource curr = this.currentTask.get();
        if (curr != null) {
            curr.trySetCancelled();
        }
        if (this.post != null) {
            this.post.abort();
        }
    }

    private static void getLocalPointersIn(Object container, ArrayList<JSONObject> localPointers) throws JSONException {
        if (container instanceof JSONObject) {
            JSONObject object = (JSONObject) container;
            if (!"Pointer".equals(object.opt("__type")) || !object.has("localId")) {
                Iterator<String> keyIterator = object.keys();
                while (keyIterator.hasNext()) {
                    getLocalPointersIn(object.get(keyIterator.next()), localPointers);
                }
            } else {
                localPointers.add((JSONObject) container);
                return;
            }
        }
        if (container instanceof JSONArray) {
            JSONArray array = (JSONArray) container;
            for (int i = 0; i < array.length(); i++) {
                getLocalPointersIn(array.get(i), localPointers);
            }
        }
    }

    public void maybeChangeServerOperation() throws JSONException {
        String objectId;
        if (this.localId != null && (objectId = LocalIdManager.getDefaultInstance().getObjectId(this.localId)) != null) {
            this.localId = null;
            JSONObject data = this.params.optJSONObject("data");
            if (data != null) {
                data.put("objectId", objectId);
            }
            if (this.f1758op.equals("create")) {
                this.f1758op = "update";
            }
        }
    }

    public void resolveLocalIds() {
        try {
            Object data = this.params.get("data");
            ArrayList<JSONObject> localPointers = new ArrayList<>();
            getLocalPointersIn(data, localPointers);
            Iterator<JSONObject> it = localPointers.iterator();
            while (it.hasNext()) {
                JSONObject pointer = it.next();
                String objectId = LocalIdManager.getDefaultInstance().getObjectId((String) pointer.get("localId"));
                if (objectId == null) {
                    throw new IllegalStateException("Tried to serialize a command referencing a new, unsaved object.");
                }
                pointer.put("objectId", objectId);
                pointer.remove("localId");
            }
            maybeChangeServerOperation();
        } catch (JSONException e) {
        }
    }

    public void retainLocalIds() {
        if (this.localId != null) {
            LocalIdManager.getDefaultInstance().retainLocalIdOnDisk(this.localId);
        }
        try {
            Object data = this.params.get("data");
            ArrayList<JSONObject> localPointers = new ArrayList<>();
            getLocalPointersIn(data, localPointers);
            Iterator<JSONObject> it = localPointers.iterator();
            while (it.hasNext()) {
                LocalIdManager.getDefaultInstance().retainLocalIdOnDisk((String) it.next().get("localId"));
            }
        } catch (JSONException e) {
        }
    }

    public void releaseLocalIds() {
        if (this.localId != null) {
            LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk(this.localId);
        }
        try {
            Object data = this.params.get("data");
            ArrayList<JSONObject> localPointers = new ArrayList<>();
            getLocalPointersIn(data, localPointers);
            Iterator<JSONObject> it = localPointers.iterator();
            while (it.hasNext()) {
                LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk((String) it.next().get("localId"));
            }
        } catch (JSONException e) {
        }
    }
}
