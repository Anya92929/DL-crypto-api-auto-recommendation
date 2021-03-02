package com.parse;

import com.parse.ParseObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseQuery<T extends ParseObject> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$parse$ParseQuery$CachePolicy = null;
    private static final String TAG = "com.parse.ParseQuery";
    /* access modifiers changed from: private */
    public CachePolicy cachePolicy;
    private String className;
    /* access modifiers changed from: private */
    public ParseCommand currentCommand;
    private HashMap<String, Object> extraOptions;
    private ArrayList<String> include;
    /* access modifiers changed from: private */
    public boolean isRunning;
    /* access modifiers changed from: private */
    public Object isRunningLock;
    private int limit;
    private long maxCacheAge;
    private long objectsParsed;
    private String order;
    /* access modifiers changed from: private */
    public long queryReceived;
    /* access modifiers changed from: private */
    public long querySent;
    private long queryStart;
    private ArrayList<String> selectedKeys;
    private int skip;
    private boolean trace;
    private HashMap<String, Object> where;

    public enum CachePolicy {
        IGNORE_CACHE,
        CACHE_ONLY,
        NETWORK_ONLY,
        CACHE_ELSE_NETWORK,
        NETWORK_ELSE_CACHE,
        CACHE_THEN_NETWORK
    }

    private interface CallableWithCachePolicy<TResult> {
        TResult call(CachePolicy cachePolicy);
    }

    private interface CommandDelegate<T> {
        Task<T> runFromCacheAsync();

        Task<T> runOnNetworkAsync(boolean z);
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$parse$ParseQuery$CachePolicy() {
        int[] iArr = $SWITCH_TABLE$com$parse$ParseQuery$CachePolicy;
        if (iArr == null) {
            iArr = new int[CachePolicy.values().length];
            try {
                iArr[CachePolicy.CACHE_ELSE_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CachePolicy.CACHE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CachePolicy.CACHE_THEN_NETWORK.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CachePolicy.IGNORE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[CachePolicy.NETWORK_ELSE_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[CachePolicy.NETWORK_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$com$parse$ParseQuery$CachePolicy = iArr;
        }
        return iArr;
    }

    /* renamed from: or */
    public static <T extends ParseObject> ParseQuery<T> m2151or(List<ParseQuery<T>> queries) {
        List<ParseQuery<? extends T>> localList = new ArrayList<>();
        String className2 = null;
        int i = 0;
        while (i < queries.size()) {
            if (className2 == null || queries.get(i).className.equals(className2)) {
                className2 = queries.get(i).className;
                localList.add(queries.get(i));
                i++;
            } else {
                throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
            }
        }
        if (localList.size() != 0) {
            return new ParseQuery<>(className2).whereSatifiesAnyOf(localList);
        }
        throw new IllegalArgumentException("Can't take an or of an empty list of queries");
    }

    public ParseQuery(Class<T> subclass) {
        this(ParseObject.getClassName(subclass));
    }

    public ParseQuery(String theClassName) {
        this.isRunningLock = new Object();
        this.currentCommand = null;
        this.isRunning = false;
        this.extraOptions = null;
        this.className = theClassName;
        this.limit = -1;
        this.skip = 0;
        this.where = new HashMap<>();
        this.include = new ArrayList<>();
        this.cachePolicy = CachePolicy.IGNORE_CACHE;
        this.maxCacheAge = Long.MAX_VALUE;
        this.trace = false;
        this.extraOptions = new HashMap<>();
    }

    public static <T extends ParseObject> ParseQuery<T> getQuery(Class<T> subclass) {
        return new ParseQuery<>(subclass);
    }

    public static <T extends ParseObject> ParseQuery<T> getQuery(String className2) {
        return new ParseQuery<>(className2);
    }

    @Deprecated
    public static ParseQuery<ParseUser> getUserQuery() {
        return ParseUser.getQuery();
    }

    private void checkIfRunning() {
        checkIfRunning(false);
    }

    private void checkIfRunning(boolean grabLock) {
        synchronized (this.isRunningLock) {
            if (this.isRunning) {
                throw new RuntimeException("This query has an outstanding network connection. You have to wait until it's done.");
            } else if (grabLock) {
                this.isRunning = true;
            }
        }
    }

    private Object maybeEncodeSubQueries(Object value) throws JSONException {
        if (!(value instanceof JSONObject)) {
            return value;
        }
        JSONObject json = (JSONObject) value;
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object object = json.opt(key);
            if (object instanceof ParseQuery) {
                JSONObject realData = ((ParseQuery) object).getFindParams();
                if (!realData.isNull("data")) {
                    realData.put("where", realData.get("data"));
                    realData.remove("data");
                }
                realData.put("className", realData.remove("classname"));
                json.put(key, realData);
            } else if (object instanceof JSONObject) {
                json.put(key, maybeEncodeSubQueries(object));
            }
        }
        return json;
    }

    /* access modifiers changed from: package-private */
    public JSONObject getFindParams() {
        JSONObject params = new JSONObject();
        try {
            params.put("classname", this.className);
            JSONObject whereData = new JSONObject();
            for (String key : this.where.keySet()) {
                if (key.equals("$or")) {
                    JSONArray array = new JSONArray();
                    for (ParseQuery<?> query : (List) this.where.get(key)) {
                        if (query.limit >= 0) {
                            throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
                        } else if (query.skip > 0) {
                            throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
                        } else if (query.order != null) {
                            throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
                        } else if (!query.include.isEmpty()) {
                            throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
                        } else if (query.selectedKeys != null) {
                            throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
                        } else {
                            JSONObject object = query.getFindParams();
                            if (!object.isNull("data")) {
                                array.put(object.get("data"));
                            } else {
                                array.put(new JSONObject());
                            }
                        }
                    }
                    whereData.put(key, array);
                } else {
                    whereData.put(key, Parse.maybeReferenceAndEncode(maybeEncodeSubQueries(this.where.get(key))));
                }
            }
            params.put("data", whereData);
            if (this.limit >= 0) {
                params.put("limit", this.limit);
            }
            if (this.skip > 0) {
                params.put("skip", this.skip);
            }
            if (this.order != null) {
                params.put("order", this.order);
            }
            if (!this.include.isEmpty()) {
                params.put("include", Parse.join(this.include, ","));
            }
            if (this.selectedKeys != null) {
                params.put("fields", Parse.join(this.selectedKeys, ","));
            }
            if (this.trace) {
                params.put("trace", "1");
            }
            for (String key2 : this.extraOptions.keySet()) {
                params.put(key2, Parse.maybeReferenceAndEncode(this.extraOptions.get(key2)));
            }
            return params;
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private ParseCommand makeFindCommand(String sessionToken) {
        ParseCommand command = new ParseCommand("find", sessionToken);
        JSONObject params = getFindParams();
        Iterator<String> keys = params.keys();
        while (keys.hasNext()) {
            try {
                String key = keys.next();
                command.put(key, params.get(key).toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return command;
    }

    /* access modifiers changed from: private */
    public List<T> convertFindResponse(JSONObject response) throws JSONException {
        ArrayList<T> answer = new ArrayList<>();
        JSONArray results = response.getJSONArray("results");
        if (results == null) {
            Parse.logD(TAG, "null results in find response");
        } else {
            String resultClassName = response.optString("className");
            if (resultClassName == "") {
                resultClassName = this.className;
            }
            for (int i = 0; i < results.length(); i++) {
                T object = ParseObject.createWithoutData(resultClassName, (String) null);
                object.mergeAfterFetch(results.getJSONObject(i), this.selectedKeys == null);
                answer.add(object);
            }
        }
        this.objectsParsed = System.nanoTime();
        if (response.has("trace")) {
            Parse.logD("ParseQuery", String.valueOf(String.valueOf("Query pre-processing took " + (this.querySent - this.queryStart) + " milliseconds\n") + response.get("trace") + "\n") + "Client side parsing took " + (this.objectsParsed - this.queryReceived) + " millisecond\n");
        }
        return answer;
    }

    private <TResult> Task<TResult> runCommandWithPolicyAsync(final CommandDelegate<TResult> c, CachePolicy policy) {
        switch ($SWITCH_TABLE$com$parse$ParseQuery$CachePolicy()[policy.ordinal()]) {
            case 1:
            case 3:
                return c.runOnNetworkAsync(true);
            case 2:
                return c.runFromCacheAsync();
            case 4:
                return c.runFromCacheAsync().continueWithTask(new Continuation<TResult, Task<TResult>>() {
                    public Task<TResult> then(Task<TResult> task) throws Exception {
                        if (!task.isFaulted() || !(task.getError() instanceof ParseException)) {
                            return task;
                        }
                        return c.runOnNetworkAsync(true);
                    }
                });
            case 5:
                return c.runOnNetworkAsync(false).continueWithTask(new Continuation<TResult, Task<TResult>>() {
                    public Task<TResult> then(Task<TResult> task) throws Exception {
                        if (!task.isFaulted() || !(task.getError() instanceof ParseException) || ((ParseException) task.getError()).getCode() != 100) {
                            return task;
                        }
                        return c.runFromCacheAsync();
                    }
                });
            case 6:
                throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
            default:
                throw new RuntimeException("Unknown cache policy: " + this.cachePolicy);
        }
    }

    /* access modifiers changed from: private */
    public Task<Integer> countWithCachePolicyAsync(CachePolicy policy) {
        return runCommandWithPolicyAsync(new CommandDelegate<Integer>() {
            public Task<Integer> runOnNetworkAsync(boolean retry) {
                return ParseQuery.this.countFromNetworkAsync();
            }

            public Task<Integer> runFromCacheAsync() {
                return Task.call(new Callable<Integer>() {
                    public Integer call() throws Exception {
                        return ParseQuery.this.countFromCache();
                    }
                }, ParseCommand.networkThreadPool);
            }
        }, policy);
    }

    /* access modifiers changed from: package-private */
    public Task<List<T>> findWithCachePolicyAsync(CachePolicy policy) {
        return runCommandWithPolicyAsync(new CommandDelegate<List<T>>() {
            public Task<List<T>> runOnNetworkAsync(boolean retry) {
                return ParseQuery.this.findFromNetworkAsync(retry);
            }

            public Task<List<T>> runFromCacheAsync() {
                return Task.call(new Callable<List<T>>() {
                    public List<T> call() throws Exception {
                        return ParseQuery.this.findFromCache();
                    }
                }, ParseCommand.networkThreadPool);
            }
        }, policy);
    }

    /* access modifiers changed from: private */
    public Task<T> getFirstWithCachePolicyAsync(CachePolicy policy) {
        this.limit = -1;
        return findWithCachePolicyAsync(policy).continueWith(new Continuation<List<T>, T>() {
            public T then(Task<List<T>> task) throws Exception {
                if (task.getResult() != null && task.getResult().size() > 0) {
                    return (ParseObject) task.getResult().get(0);
                }
                throw new ParseException((int) ParseException.OBJECT_NOT_FOUND, "no results found for query");
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<T> getWithCachePolicyAsync(String objectId, CachePolicy policy) {
        this.skip = -1;
        this.where = new HashMap<>();
        this.where.put("objectId", objectId);
        return getFirstWithCachePolicyAsync(policy);
    }

    public void cancel() {
        synchronized (this.isRunningLock) {
            if (this.currentCommand != null) {
                this.currentCommand.cancel();
                this.currentCommand = null;
            }
            this.isRunning = false;
        }
    }

    public List<T> find() throws ParseException {
        return (List) Parse.waitForTask(doWithRunningCheck(new Callable<Task<List<T>>>() {
            public Task<List<T>> call() throws Exception {
                return ParseQuery.this.findWithCachePolicyAsync(ParseQuery.this.cachePolicy);
            }
        }));
    }

    public T getFirst() throws ParseException {
        return (ParseObject) Parse.waitForTask(doWithRunningCheck(new Callable<Task<T>>() {
            public Task<T> call() throws Exception {
                return ParseQuery.this.getFirstWithCachePolicyAsync(ParseQuery.this.cachePolicy);
            }
        }));
    }

    /* access modifiers changed from: private */
    public Task<List<T>> findFromNetworkAsync(final boolean shouldRetry) {
        this.currentCommand = makeFindCommand(ParseUser.getCurrentSessionToken());
        return Task.call(new Callable<Void>() {
            public Void call() throws Exception {
                if (!shouldRetry) {
                    return null;
                }
                ParseQuery.this.currentCommand.enableRetrying();
                return null;
            }
        }).onSuccessTask(new Continuation<Void, Task<List<T>>>() {
            public Task<List<T>> then(Task<Void> task) throws Exception {
                ArrayList<T> answer = new ArrayList<>();
                if (ParseQuery.this.currentCommand == null) {
                    return Task.forResult(answer);
                }
                boolean caching = ParseQuery.this.cachePolicy != CachePolicy.IGNORE_CACHE;
                ParseQuery.this.querySent = System.nanoTime();
                return ParseQuery.this.currentCommand.performAsync(caching).onSuccess(new Continuation<Object, List<T>>() {
                    public List<T> then(Task<Object> task) throws Exception {
                        ParseQuery.this.queryReceived = System.nanoTime();
                        return ParseQuery.this.convertFindResponse((JSONObject) task.getResult());
                    }
                });
            }
        });
    }

    public void setCachePolicy(CachePolicy newCachePolicy) {
        checkIfRunning();
        this.cachePolicy = newCachePolicy;
    }

    public CachePolicy getCachePolicy() {
        return this.cachePolicy;
    }

    public void setMaxCacheAge(long maxAgeInMilliseconds) {
        this.maxCacheAge = maxAgeInMilliseconds;
    }

    public long getMaxCacheAge() {
        return this.maxCacheAge;
    }

    /* access modifiers changed from: private */
    public List<T> findFromCache() throws ParseException {
        Object cached = Parse.jsonFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), this.maxCacheAge);
        if (cached == null) {
            throw new ParseException((int) ParseException.CACHE_MISS, "results not cached");
        } else if (!(cached instanceof JSONObject)) {
            throw new ParseException((int) ParseException.CACHE_MISS, "the cache contains the wrong datatype");
        } else {
            try {
                return convertFindResponse((JSONObject) cached);
            } catch (JSONException e) {
                throw new ParseException((int) ParseException.CACHE_MISS, "the cache contains corrupted json");
            }
        }
    }

    /* access modifiers changed from: private */
    public Integer countFromCache() throws ParseException {
        Object cached = Parse.jsonFromKeyValueCache(makeCountCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), this.maxCacheAge);
        if (cached == null) {
            throw new ParseException((int) ParseException.CACHE_MISS, "results not cached");
        } else if (!(cached instanceof JSONObject)) {
            throw new ParseException((int) ParseException.CACHE_MISS, "the cache contains the wrong datatype");
        } else {
            try {
                return Integer.valueOf(((JSONObject) cached).getInt("count"));
            } catch (JSONException e) {
                throw new ParseException((int) ParseException.CACHE_MISS, "the cache contains corrupted json");
            }
        }
    }

    private <TResult> Task<TResult> doWithRunningCheck(Callable<Task<TResult>> runnable) {
        Task<TResult> task;
        checkIfRunning(true);
        try {
            task = runnable.call();
        } catch (Exception e) {
            task = Task.forError(e);
        }
        return task.continueWithTask(new Continuation<TResult, Task<TResult>>() {
            public Task<TResult> then(Task<TResult> task) throws Exception {
                synchronized (ParseQuery.this.isRunningLock) {
                    ParseQuery.this.isRunning = false;
                    ParseQuery.this.currentCommand = null;
                }
                return task;
            }
        });
    }

    private <TResult> void doInBackground(final CallableWithCachePolicy<Task<TResult>> callable, final ParseCallback<TResult> callback) {
        Parse.callbackOnMainThreadAsync(doWithRunningCheck(new Callable<Task<TResult>>() {
            public Task<TResult> call() throws Exception {
                if (ParseQuery.this.cachePolicy != CachePolicy.CACHE_THEN_NETWORK) {
                    return (Task) callable.call(ParseQuery.this.cachePolicy);
                }
                Task<TResult> findTask = Parse.callbackOnMainThreadAsync((Task) callable.call(CachePolicy.CACHE_ONLY), callback);
                final CallableWithCachePolicy callableWithCachePolicy = callable;
                return findTask.continueWithTask(new Continuation<TResult, Task<TResult>>() {
                    public Task<TResult> then(Task<TResult> task) throws Exception {
                        return task.isCancelled() ? task : (Task) callableWithCachePolicy.call(CachePolicy.NETWORK_ONLY);
                    }
                });
            }
        }), callback);
    }

    public void findInBackground(FindCallback<T> callback) {
        this.queryStart = System.nanoTime();
        doInBackground(new CallableWithCachePolicy<Task<List<T>>>() {
            public Task<List<T>> call(CachePolicy cachePolicy) {
                return ParseQuery.this.findWithCachePolicyAsync(cachePolicy);
            }
        }, callback);
    }

    public void getFirstInBackground(GetCallback<T> callback) {
        doInBackground(new CallableWithCachePolicy<Task<T>>() {
            public Task<T> call(CachePolicy cachePolicy) {
                return ParseQuery.this.getFirstWithCachePolicyAsync(cachePolicy);
            }
        }, callback);
    }

    private ParseCommand makeCountCommand(String sessionToken) {
        ParseCommand command = makeFindCommand(sessionToken);
        command.put("limit", 0);
        command.put("count", 1);
        return command;
    }

    public int count() throws ParseException {
        return ((Integer) Parse.waitForTask(doWithRunningCheck(new Callable<Task<Integer>>() {
            public Task<Integer> call() throws Exception {
                return ParseQuery.this.countWithCachePolicyAsync(ParseQuery.this.cachePolicy);
            }
        }))).intValue();
    }

    /* access modifiers changed from: private */
    public Task<Integer> countFromNetworkAsync() {
        boolean caching = this.cachePolicy != CachePolicy.IGNORE_CACHE;
        this.currentCommand = makeCountCommand(ParseUser.getCurrentSessionToken());
        return this.currentCommand.performAsync(caching).continueWith(new Continuation<Object, Integer>() {
            public Integer then(Task<Object> task) throws Exception {
                return Integer.valueOf(((JSONObject) task.getResult()).optInt("count"));
            }
        });
    }

    public void countInBackground(CountCallback callback) {
        this.queryStart = System.nanoTime();
        doInBackground(new CallableWithCachePolicy<Task<Integer>>() {
            public Task<Integer> call(CachePolicy cachePolicy) {
                return ParseQuery.this.countWithCachePolicyAsync(cachePolicy);
            }
        }, callback);
    }

    public T get(final String theObjectId) throws ParseException {
        return (ParseObject) Parse.waitForTask(doWithRunningCheck(new Callable<Task<T>>() {
            public Task<T> call() throws Exception {
                return ParseQuery.this.getWithCachePolicyAsync(theObjectId, ParseQuery.this.cachePolicy);
            }
        }));
    }

    public boolean hasCachedResult() {
        return Parse.loadFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), this.maxCacheAge) != null;
    }

    public void clearCachedResult() {
        Parse.clearFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey());
    }

    public static void clearAllCachedResults() {
        Parse.clearCacheDir();
    }

    public void getInBackground(final String objectId, GetCallback<T> callback) {
        doInBackground(new CallableWithCachePolicy<Task<T>>() {
            public Task<T> call(CachePolicy cachePolicy) {
                return ParseQuery.this.getWithCachePolicyAsync(objectId, cachePolicy);
            }
        }, callback);
    }

    public ParseQuery<T> whereEqualTo(String key, Object value) {
        checkIfRunning();
        if (value instanceof Date) {
            value = Parse.dateToObject((Date) value);
        }
        this.where.put(key, value);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addCondition(java.lang.String r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r5 = this;
            r5.checkIfRunning()
            r2 = 0
            java.lang.Object r8 = com.parse.Parse.maybeReferenceAndEncode(r8)
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r5.where
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r5.where
            java.lang.Object r1 = r3.get(r6)
            boolean r3 = r1 instanceof org.json.JSONObject
            if (r3 == 0) goto L_0x001d
            r2 = r1
            org.json.JSONObject r2 = (org.json.JSONObject) r2
        L_0x001d:
            if (r2 != 0) goto L_0x0024
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
        L_0x0024:
            r2.put(r7, r8)     // Catch:{ JSONException -> 0x002d }
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r5.where
            r3.put(r6, r2)
            return
        L_0x002d:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = r0.getMessage()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseQuery.addCondition(java.lang.String, java.lang.String, java.lang.Object):void");
    }

    public ParseQuery<T> whereLessThan(String key, Object value) {
        addCondition(key, "$lt", value);
        return this;
    }

    public ParseQuery<T> whereNotEqualTo(String key, Object value) {
        addCondition(key, "$ne", value);
        return this;
    }

    public ParseQuery<T> whereGreaterThan(String key, Object value) {
        addCondition(key, "$gt", value);
        return this;
    }

    public ParseQuery<T> whereLessThanOrEqualTo(String key, Object value) {
        addCondition(key, "$lte", value);
        return this;
    }

    public ParseQuery<T> whereGreaterThanOrEqualTo(String key, Object value) {
        addCondition(key, "$gte", value);
        return this;
    }

    public ParseQuery<T> whereContainedIn(String key, Collection<? extends Object> values) {
        JSONArray array = new JSONArray();
        for (Object val : values) {
            array.put(Parse.maybeReferenceAndEncode(val));
        }
        addCondition(key, "$in", array);
        return this;
    }

    public ParseQuery<T> whereContainsAll(String key, Collection<?> values) {
        JSONArray array = new JSONArray();
        for (Object val : values) {
            array.put(Parse.maybeReferenceAndEncode(val));
        }
        addCondition(key, "$all", array);
        return this;
    }

    public ParseQuery<T> whereMatchesQuery(String key, ParseQuery<?> query) {
        addCondition(key, "$inQuery", query);
        return this;
    }

    public ParseQuery<T> whereDoesNotMatchQuery(String key, ParseQuery<?> query) {
        addCondition(key, "$notInQuery", query);
        return this;
    }

    public ParseQuery<T> whereMatchesKeyInQuery(String key, String keyInQuery, ParseQuery<?> query) {
        JSONObject condition = new JSONObject();
        try {
            condition.put("key", keyInQuery);
            condition.put("query", query);
            addCondition(key, "$select", condition);
            return this;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public ParseQuery<T> whereDoesNotMatchKeyInQuery(String key, String keyInQuery, ParseQuery<?> query) {
        JSONObject condition = new JSONObject();
        try {
            condition.put("key", keyInQuery);
            condition.put("query", query);
            addCondition(key, "$dontSelect", condition);
            return this;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private ParseQuery<T> whereSatifiesAnyOf(List<ParseQuery<? extends T>> queries) {
        this.where.put("$or", queries);
        return this;
    }

    public ParseQuery<T> whereNotContainedIn(String key, Collection<? extends Object> values) {
        JSONArray array = new JSONArray();
        for (Object val : values) {
            array.put(Parse.maybeReferenceAndEncode(val));
        }
        addCondition(key, "$nin", array);
        return this;
    }

    public ParseQuery<T> whereNear(String key, ParseGeoPoint point) {
        addCondition(key, "$nearSphere", point);
        return this;
    }

    public ParseQuery<T> whereWithinMiles(String key, ParseGeoPoint point, double maxDistance) {
        whereWithinRadians(key, point, maxDistance / ParseGeoPoint.EARTH_MEAN_RADIUS_MILE);
        return this;
    }

    public ParseQuery<T> whereWithinKilometers(String key, ParseGeoPoint point, double maxDistance) {
        whereWithinRadians(key, point, maxDistance / ParseGeoPoint.EARTH_MEAN_RADIUS_KM);
        return this;
    }

    public ParseQuery<T> whereWithinRadians(String key, ParseGeoPoint point, double maxDistance) {
        addCondition(key, "$nearSphere", point);
        addCondition(key, "$maxDistance", Double.valueOf(maxDistance));
        return this;
    }

    public ParseQuery<T> whereWithinGeoBox(String key, ParseGeoPoint southwest, ParseGeoPoint northeast) {
        ArrayList<Object> array = new ArrayList<>();
        array.add(Parse.maybeReferenceAndEncode(southwest));
        array.add(Parse.maybeReferenceAndEncode(northeast));
        HashMap<String, ArrayList<Object>> dictionary = new HashMap<>();
        dictionary.put("$box", array);
        addCondition(key, "$within", dictionary);
        return this;
    }

    public ParseQuery<T> whereMatches(String key, String regex) {
        addCondition(key, "$regex", regex);
        return this;
    }

    public ParseQuery<T> whereMatches(String key, String regex, String modifiers) {
        addCondition(key, "$regex", regex);
        if (modifiers.length() != 0) {
            addCondition(key, "$options", modifiers);
        }
        return this;
    }

    public ParseQuery<T> whereContains(String key, String substring) {
        whereMatches(key, Pattern.quote(substring));
        return this;
    }

    public ParseQuery<T> whereStartsWith(String key, String prefix) {
        whereMatches(key, "^" + Pattern.quote(prefix));
        return this;
    }

    public ParseQuery<T> whereEndsWith(String key, String suffix) {
        whereMatches(key, String.valueOf(Pattern.quote(suffix)) + "$");
        return this;
    }

    public void include(String key) {
        checkIfRunning();
        this.include.add(key);
    }

    public void selectKeys(Collection<String> keys) {
        checkIfRunning();
        if (this.selectedKeys == null) {
            this.selectedKeys = new ArrayList<>();
        }
        this.selectedKeys.addAll(keys);
    }

    public ParseQuery<T> whereExists(String key) {
        addCondition(key, "$exists", true);
        return this;
    }

    public ParseQuery<T> whereDoesNotExist(String key) {
        addCondition(key, "$exists", false);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ParseQuery<T> whereRelatedTo(ParseObject parent, String key) {
        addCondition("$relatedTo", "object", Parse.maybeReferenceAndEncode(parent));
        addCondition("$relatedTo", "key", key);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ParseQuery<T> redirectClassNameForKey(String key) {
        this.extraOptions.put("redirectClassNameForKey", key);
        return this;
    }

    public ParseQuery<T> orderByAscending(String key) {
        checkIfRunning();
        this.order = key;
        return this;
    }

    public ParseQuery<T> addAscendingOrder(String key) {
        checkIfRunning();
        if (this.order == null) {
            this.order = key;
        } else {
            this.order = String.valueOf(this.order) + "," + key;
        }
        return this;
    }

    public ParseQuery<T> orderByDescending(String key) {
        checkIfRunning();
        this.order = "-" + key;
        return this;
    }

    public ParseQuery<T> addDescendingOrder(String key) {
        checkIfRunning();
        if (this.order == null) {
            this.order = "-" + key;
        } else {
            this.order = String.valueOf(this.order) + ",-" + key;
        }
        return this;
    }

    public void setLimit(int newLimit) {
        checkIfRunning();
        this.limit = newLimit;
    }

    public void setTrace(boolean shouldTrace) {
        this.trace = shouldTrace;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setSkip(int newSkip) {
        checkIfRunning();
        this.skip = newSkip;
    }

    public int getSkip() {
        return this.skip;
    }

    public String getClassName() {
        return this.className;
    }
}
