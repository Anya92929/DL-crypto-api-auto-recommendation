package com.parse;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.parse.Task;
import com.parse.codec.binary.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Parse {
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_NONE = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARNING = 5;
    private static final String TAG = "com.parse.Parse";
    static Context applicationContext;
    static String applicationId;
    static String clientKey;
    static ParseCommandCache commandCache = null;
    private static final DateFormat dateFormat;
    static final Object lock = new Object();
    private static int logLevel = 6;
    static int maxKeyValueCacheBytes = 2097152;
    static int maxKeyValueCacheFiles = 1000;
    static int maxParseFileSize = 10485760;
    static Executor uiThreadExecutor = new Executor() {
        public void execute(Runnable command) {
            new Handler(Looper.getMainLooper()).post(command);
        }
    };

    static {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        format.setTimeZone(new SimpleTimeZone(0, "GMT"));
        dateFormat = format;
    }

    private Parse() {
        throw new AssertionError();
    }

    public static void initialize(Context context, String applicationId2, String clientKey2) {
        applicationId = applicationId2;
        clientKey = clientKey2;
        if (context != null) {
            applicationContext = context.getApplicationContext();
            checkCacheApplicationId();
            new Thread("Parse.initialize Disk Check & Starting Command Cache") {
                public void run() {
                    Parse.getCommandCache();
                }
            }.start();
        }
    }

    public static void setLogLevel(int logLevel2) {
        logLevel = logLevel2;
    }

    public static int getLogLevel() {
        return logLevel;
    }

    private static void log(int messageLogLevel, String tag, String message, Throwable tr) {
        if (messageLogLevel < logLevel) {
            return;
        }
        if (tr == null) {
            Log.println(logLevel, tag, message);
        } else {
            Log.println(logLevel, tag, String.valueOf(message) + 10 + Log.getStackTraceString(tr));
        }
    }

    static void logV(String tag, String message, Throwable tr) {
        log(2, tag, message, tr);
    }

    static void logV(String tag, String message) {
        logV(tag, message, (Throwable) null);
    }

    static void logD(String tag, String message, Throwable tr) {
        log(3, tag, message, tr);
    }

    static void logD(String tag, String message) {
        logD(tag, message, (Throwable) null);
    }

    static void logI(String tag, String message, Throwable tr) {
        log(4, tag, message, tr);
    }

    static void logI(String tag, String message) {
        logI(tag, message, (Throwable) null);
    }

    static void logW(String tag, String message, Throwable tr) {
        log(5, tag, message, tr);
    }

    static void logW(String tag, String message) {
        logW(tag, message, (Throwable) null);
    }

    static void logE(String tag, String message, Throwable tr) {
        log(6, tag, message, tr);
    }

    static void logE(String tag, String message) {
        logE(tag, message, (Throwable) null);
    }

    static void setContextIfNeeded(Context context) {
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    static File getParseDir() {
        File dir;
        synchronized (lock) {
            checkContext();
            dir = applicationContext.getDir("Parse", 0);
        }
        return dir;
    }

    static void recursiveDelete(File file) {
        synchronized (lock) {
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    recursiveDelete(f);
                }
            }
            file.delete();
        }
    }

    static void checkCacheApplicationId() {
        synchronized (lock) {
            if (applicationId != null) {
                File applicationIdFile = new File(getParseDir(), "applicationId");
                if (applicationIdFile.exists()) {
                    boolean matches = false;
                    try {
                        RandomAccessFile f = new RandomAccessFile(applicationIdFile, "r");
                        byte[] bytes = new byte[((int) f.length())];
                        f.readFully(bytes);
                        f.close();
                        matches = new String(bytes, "UTF-8").equals(applicationId);
                    } catch (FileNotFoundException | IOException e) {
                    }
                    if (!matches) {
                        recursiveDelete(getParseDir());
                    }
                }
                try {
                    FileOutputStream out = new FileOutputStream(new File(getParseDir(), "applicationId"));
                    out.write(applicationId.getBytes("UTF-8"));
                    out.close();
                } catch (FileNotFoundException | IOException | UnsupportedEncodingException e2) {
                }
            }
        }
    }

    static File getKeyValueCacheDir() {
        File parseCacheDir;
        synchronized (lock) {
            checkContext();
            parseCacheDir = new File(applicationContext.getCacheDir(), "ParseKeyValueCache");
            if (!parseCacheDir.isDirectory() && !parseCacheDir.mkdir()) {
                throw new RuntimeException("could not create Parse cache directory");
            }
        }
        return parseCacheDir;
    }

    static File getKeyValueCacheFile(String key) {
        final String suffix = String.valueOf('.') + key;
        File[] matches = getKeyValueCacheDir().listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(suffix);
            }
        });
        if (matches == null || matches.length == 0) {
            return null;
        }
        return matches[0];
    }

    static long getKeyValueCacheAge(File cacheFile) {
        String name = cacheFile.getName();
        try {
            return Long.parseLong(name.substring(0, name.indexOf(46)));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    static File createKeyValueCacheFile(String key) {
        return new File(getKeyValueCacheDir(), String.valueOf(String.valueOf(new Date().getTime())) + '.' + key);
    }

    static void clearCacheDir() {
        File[] entries = getKeyValueCacheDir().listFiles();
        if (entries != null) {
            for (File delete : entries) {
                delete.delete();
            }
        }
    }

    static void saveToKeyValueCache(String key, String value) {
        int i = 0;
        File prior = getKeyValueCacheFile(key);
        if (prior != null) {
            prior.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(createKeyValueCacheFile(key));
            out.write(value.getBytes("UTF-8"));
            out.close();
        } catch (IOException | UnsupportedEncodingException e) {
        }
        File[] files = getKeyValueCacheDir().listFiles();
        int numFiles = files.length;
        int numBytes = 0;
        for (File file : files) {
            numBytes = (int) (((long) numBytes) + file.length());
        }
        if (numFiles > maxKeyValueCacheFiles || numBytes > maxKeyValueCacheBytes) {
            Arrays.sort(files, new Comparator<File>() {
                public int compare(File f1, File f2) {
                    int dateCompare = Long.valueOf(f1.lastModified()).compareTo(Long.valueOf(f2.lastModified()));
                    return dateCompare != 0 ? dateCompare : f1.getName().compareTo(f2.getName());
                }
            });
            int length = files.length;
            while (i < length) {
                File file2 = files[i];
                numFiles--;
                numBytes = (int) (((long) numBytes) - file2.length());
                file2.delete();
                if (numFiles > maxKeyValueCacheFiles || numBytes > maxKeyValueCacheBytes) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    static void clearFromKeyValueCache(String key) {
        File file = getKeyValueCacheFile(key);
        if (file != null) {
            file.delete();
        }
    }

    static String loadFromKeyValueCache(String key, long maxAgeMilliseconds) {
        File file = getKeyValueCacheFile(key);
        if (file == null) {
            return null;
        }
        Date now = new Date();
        if (getKeyValueCacheAge(file) < Math.max(0, now.getTime() - maxAgeMilliseconds)) {
            return null;
        }
        file.setLastModified(now.getTime());
        try {
            RandomAccessFile f = new RandomAccessFile(file, "r");
            byte[] bytes = new byte[((int) f.length())];
            f.readFully(bytes);
            f.close();
            return new String(bytes, "UTF-8");
        } catch (IOException e) {
            logE(TAG, "error reading from cache", e);
            return null;
        }
    }

    static Object jsonFromKeyValueCache(String key, long maxAgeMilliseconds) {
        String raw = loadFromKeyValueCache(key, maxAgeMilliseconds);
        if (raw == null) {
            return null;
        }
        try {
            return new JSONTokener(raw).nextValue();
        } catch (JSONException e) {
            logE(TAG, "corrupted cache for " + key, e);
            clearFromKeyValueCache(key);
            return null;
        }
    }

    static ParseCommandCache getCommandCache() {
        ParseCommandCache parseCommandCache;
        synchronized (lock) {
            if (commandCache == null) {
                checkContext();
                commandCache = new ParseCommandCache(applicationContext);
            }
            parseCommandCache = commandCache;
        }
        return parseCommandCache;
    }

    static void checkInit() {
        if (applicationId == null) {
            throw new RuntimeException("applicationId is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
        } else if (clientKey == null) {
            throw new RuntimeException("clientKey is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
        }
    }

    static void checkContext() {
        if (applicationContext == null) {
            throw new RuntimeException("applicationContext is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
        }
    }

    static boolean hasPermission(String permission) {
        checkContext();
        return applicationContext.checkCallingOrSelfPermission(permission) == 0;
    }

    static void requirePermission(String permission) {
        if (!hasPermission(permission)) {
            throw new IllegalStateException("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"" + permission + "\" />");
        }
    }

    static List<Object> convertArrayToList(JSONArray array) {
        List<Object> new_array = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Object oldValue = array.opt(i);
            Object newValue = decodeJSONObject(oldValue);
            if (newValue != null) {
                new_array.add(newValue);
            } else {
                new_array.add(oldValue);
            }
        }
        return new_array;
    }

    static Map<String, Object> convertJSONObjectToMap(JSONObject object) {
        Map<String, Object> outputMap = new HashMap<>();
        Iterator<String> it = object.keys();
        while (it.hasNext()) {
            String key = it.next();
            Object value = object.opt(key);
            Object decodedObject = decodeJSONObject(value);
            if (decodedObject != null) {
                outputMap.put(key, decodedObject);
            } else if (value instanceof JSONArray) {
                outputMap.put(key, convertArrayToList((JSONArray) value));
            } else {
                outputMap.put(key, value);
            }
        }
        return outputMap;
    }

    static Object decodeJSONObject(Object object) {
        if (!(object instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) object;
        if (jsonObject.optString("__op", (String) null) != null) {
            try {
                return ParseFieldOperations.decode(jsonObject);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            String typeString = jsonObject.optString("__type", (String) null);
            if (typeString == null) {
                return convertJSONObjectToMap(jsonObject);
            }
            if (typeString.equals("Date")) {
                return parseDate(jsonObject.optString("iso"));
            }
            if (typeString.equals("Bytes")) {
                return Base64.decodeBase64(jsonObject.optString("base64"));
            }
            if (typeString.equals("Pointer")) {
                return ParseObject.createWithoutData(jsonObject.optString("className"), jsonObject.optString("objectId"));
            }
            if (typeString.equals("File")) {
                return new ParseFile(jsonObject.optString("name"), jsonObject.optString("url"));
            }
            if (typeString.equals("GeoPoint")) {
                try {
                    return new ParseGeoPoint(jsonObject.getDouble("latitude"), jsonObject.getDouble("longitude"));
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            } else if (typeString.equals("Object")) {
                JSONObject nested = new JSONObject();
                try {
                    nested.put("data", jsonObject);
                    ParseObject output = ParseObject.createWithoutData(jsonObject.optString("className"), (String) null);
                    output.mergeAfterFetch(nested, true);
                    return output;
                } catch (JSONException e3) {
                    throw new RuntimeException(e3);
                }
            } else if (typeString.equals("Relation")) {
                return new ParseRelation(jsonObject.optString("className", (String) null));
            } else {
                return null;
            }
        }
    }

    static JSONObject encodeJSONObject(Object object, boolean allowParseObjects) {
        try {
            if (object instanceof Date) {
                return dateToObject((Date) object);
            }
            if (object instanceof byte[]) {
                JSONObject json = new JSONObject();
                json.put("__type", "Bytes");
                json.put("base64", Base64.encodeBase64String((byte[]) object));
                return json;
            } else if (object instanceof ParseObject) {
                if (allowParseObjects) {
                    return parseObjectToJSONPointer((ParseObject) object);
                }
                throw new IllegalArgumentException("ParseObjects not allowed here");
            } else if (object instanceof ParseFile) {
                ParseFile file = (ParseFile) object;
                JSONObject json2 = new JSONObject();
                json2.put("__type", "File");
                json2.put("url", file.getUrl());
                json2.put("name", file.getName());
                return json2;
            } else if (object instanceof ParseGeoPoint) {
                ParseGeoPoint point = (ParseGeoPoint) object;
                JSONObject json3 = new JSONObject();
                json3.put("__type", "GeoPoint");
                json3.put("latitude", point.getLatitude());
                json3.put("longitude", point.getLongitude());
                return json3;
            } else if (object instanceof ParseACL) {
                return ((ParseACL) object).toJSONObject();
            } else {
                if (object instanceof Map) {
                    JSONObject json4 = new JSONObject();
                    for (Map.Entry<String, Object> pair : ((Map) object).entrySet()) {
                        json4.put(pair.getKey(), maybeEncodeJSONObject(pair.getValue(), allowParseObjects));
                    }
                    return json4;
                } else if (object instanceof ParseRelation) {
                    return ((ParseRelation) object).encodeToJSON();
                } else {
                    return null;
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isValidType(Object value) {
        return (value instanceof JSONObject) || (value instanceof JSONArray) || (value instanceof String) || (value instanceof Number) || (value instanceof Boolean) || value == JSONObject.NULL || (value instanceof ParseObject) || (value instanceof ParseACL) || (value instanceof ParseFile) || (value instanceof ParseGeoPoint) || (value instanceof Date) || (value instanceof byte[]) || (value instanceof List) || (value instanceof Map) || (value instanceof ParseRelation);
    }

    static JSONArray encodeAsJSONArray(List<Object> list, boolean allowParseObjects) {
        JSONArray new_array = new JSONArray();
        for (Object o : list) {
            if (!isValidType(o)) {
                throw new IllegalArgumentException("invalid type for value in array: " + o.getClass().toString());
            }
            new_array.put(maybeEncodeJSONObject(o, allowParseObjects));
        }
        return new_array;
    }

    static Object maybeEncodeJSONObject(Object value, boolean allowParseObjects) {
        if (value instanceof List) {
            return encodeAsJSONArray((List) value, allowParseObjects);
        }
        if (value instanceof ParseFieldOperation) {
            try {
                return ((ParseFieldOperation) value).encode();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            Object json = encodeJSONObject(value, allowParseObjects);
            if (json != null) {
                return json;
            }
            return value;
        }
    }

    static Object maybeReferenceAndEncode(Object value) {
        if (!(value instanceof ParseObject) || ((ParseObject) value).getObjectId() != null) {
            return maybeEncodeJSONObject(value, true);
        }
        throw new IllegalStateException("unable to encode an association with an unsaved ParseObject");
    }

    static JSONObject parseObjectToJSONPointer(ParseObject pointedTo) {
        JSONObject json = new JSONObject();
        try {
            if (pointedTo.getObjectId() != null) {
                json.put("__type", "Pointer");
                json.put("className", pointedTo.getClassName());
                json.put("objectId", pointedTo.getObjectId());
            } else {
                json.put("__type", "Pointer");
                json.put("className", pointedTo.getClassName());
                json.put("localId", pointedTo.getOrCreateLocalId());
            }
            return json;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Date parseDate(java.lang.String r5) {
        /*
            java.lang.Object r2 = lock
            monitor-enter(r2)
            java.text.DateFormat r1 = dateFormat     // Catch:{ ParseException -> 0x000b }
            java.util.Date r1 = r1.parse(r5)     // Catch:{ ParseException -> 0x000b }
            monitor-exit(r2)     // Catch:{ all -> 0x0023 }
        L_0x000a:
            return r1
        L_0x000b:
            r0 = move-exception
            java.lang.String r1 = "com.parse.Parse"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = "could not parse date: "
            r3.<init>(r4)     // Catch:{ all -> 0x0023 }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x0023 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0023 }
            logE(r1, r3, r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)     // Catch:{ all -> 0x0023 }
            r1 = 0
            goto L_0x000a
        L_0x0023:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.Parse.parseDate(java.lang.String):java.util.Date");
    }

    static String encodeDate(Date date) {
        String format;
        synchronized (lock) {
            format = dateFormat.format(date);
        }
        return format;
    }

    static JSONObject dateToObject(Date date) {
        JSONObject object = new JSONObject();
        String iso = encodeDate(date);
        try {
            object.put("__type", "Date");
            object.put("iso", iso);
            return object;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    static Iterable<String> keys(JSONObject object) {
        final JSONObject finalObject = object;
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return finalObject.keys();
            }
        };
    }

    static boolean isContainerObject(Object object) {
        return (object instanceof JSONObject) || (object instanceof JSONArray) || (object instanceof ParseACL) || (object instanceof ParseGeoPoint) || (object instanceof List) || (object instanceof Map);
    }

    static Number addNumbers(Number first, Number second) {
        if (first instanceof Double) {
            return Double.valueOf(first.doubleValue() + second.doubleValue());
        }
        if (first instanceof Long) {
            return Long.valueOf(first.longValue() + second.longValue());
        }
        if (first instanceof Float) {
            return Float.valueOf(first.floatValue() + second.floatValue());
        }
        if (first instanceof Short) {
            return Integer.valueOf(first.shortValue() + second.shortValue());
        }
        if (first instanceof Byte) {
            return Integer.valueOf(first.byteValue() + second.byteValue());
        }
        return Integer.valueOf(first.intValue() + second.intValue());
    }

    static String join(Collection<String> items, String delimiter) {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> iter = items.iterator();
        if (iter.hasNext()) {
            buffer.append(iter.next());
            while (iter.hasNext()) {
                buffer.append(delimiter);
                buffer.append(iter.next());
            }
        }
        return buffer.toString();
    }

    static <T> T waitForTask(Task<T> task) throws ParseException {
        try {
            task.waitForCompletion();
            if (task.isFaulted()) {
                Exception error = task.getError();
                if (error instanceof ParseException) {
                    throw ((ParseException) error);
                } else if (error instanceof RuntimeException) {
                    throw ((RuntimeException) error);
                } else {
                    throw new RuntimeException(error);
                }
            } else if (!task.isCancelled()) {
                return task.getResult();
            } else {
                throw new RuntimeException(new CancellationException());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static <T> Task<T> callbackOnMainThreadAsync(Task<T> task, ParseCallback<T> callback) {
        return callbackOnMainThreadAsync(task, callback, false);
    }

    static <T> Task<T> callbackOnMainThreadAsync(Task<T> task, final ParseCallback<T> callback, final boolean reportCancellation) {
        if (callback == null) {
            return task;
        }
        final Task<TResult>.TaskCompletionSource create = Task.create();
        task.continueWith(new Continuation<T, Void>() {
            public Void then(final Task<T> task) throws Exception {
                if (!task.isCancelled() || reportCancellation) {
                    Executor executor = Parse.uiThreadExecutor;
                    final Task.TaskCompletionSource taskCompletionSource = create;
                    final ParseCallback parseCallback = callback;
                    executor.execute(new Runnable() {
                        public void run() {
                            boolean isCancelled;
                            try {
                                Exception error = task.getError();
                                if (error == null || (task.getError() instanceof ParseException)) {
                                    parseCallback.internalDone(task.getResult(), (ParseException) error);
                                    if (!isCancelled) {
                                        if (task.isFaulted()) {
                                            taskCompletionSource.setError(task.getError());
                                        } else {
                                            taskCompletionSource.setResult(task.getResult());
                                        }
                                    }
                                } else if (error instanceof RuntimeException) {
                                    throw ((RuntimeException) error);
                                } else {
                                    throw new RuntimeException(error);
                                }
                            } finally {
                                if (task.isCancelled()) {
                                    taskCompletionSource.setCancelled();
                                } else if (task.isFaulted()) {
                                    taskCompletionSource.setError(task.getError());
                                } else {
                                    taskCompletionSource.setResult(task.getResult());
                                }
                            }
                        }
                    });
                } else {
                    create.setCancelled();
                }
                return null;
            }
        });
        return create.getTask();
    }
}
