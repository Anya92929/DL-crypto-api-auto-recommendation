package com.parse;

import com.parse.ParseFacebookUtils;
import com.parse.Task;
import com.parse.auth.ParseAuthenticationProvider;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParseClassName("_User")
public class ParseUser extends ParseObject {
    private static final String CURRENT_USER_FILENAME = "currentUser";
    private static Map<String, ParseAuthenticationProvider> authenticationProviders = new HashMap();
    private static boolean autoUserEnabled;
    private static ParseUser currentUser;
    private static boolean currentUserMatchesDisk = false;
    private static final Object currentUserMutex = new Object();
    /* access modifiers changed from: private */
    public final JSONObject authData = new JSONObject();
    private boolean isCurrentUser = false;
    /* access modifiers changed from: private */
    public boolean isLazy = false;
    /* access modifiers changed from: private */
    public boolean isNew;
    /* access modifiers changed from: private */
    public final Set<String> linkedServiceNames = new HashSet();
    private String password;
    private final Set<String> readOnlyLinkedServiceNames = Collections.unmodifiableSet(this.linkedServiceNames);
    private String sessionToken;

    static ParseUser logInLazyUser(String authType, JSONObject authData2) {
        ParseUser user;
        synchronized (currentUserMutex) {
            user = (ParseUser) ParseObject.create(ParseUser.class);
            user.isCurrentUser = true;
            user.isLazy = true;
            try {
                user.authData.put(authType, authData2);
                user.linkedServiceNames.add(authType);
                currentUser = user;
                currentUserMatchesDisk = false;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }

    /* access modifiers changed from: package-private */
    public boolean isLazy() {
        boolean z;
        synchronized (this.mutex) {
            z = this.isLazy;
        }
        return z;
    }

    public boolean isAuthenticated() {
        boolean z;
        synchronized (this.mutex) {
            z = isLazy() || !(this.sessionToken == null || getCurrentUser() == null || !getObjectId().equals(getCurrentUser().getObjectId()));
        }
        return z;
    }

    public void remove(String key) {
        if ("username".equals(key)) {
            throw new IllegalArgumentException("Can't remove the username key.");
        }
        super.remove(key);
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObjectForSaving(Map<String, ParseFieldOperation> operations) {
        JSONObject objectJSON;
        synchronized (this.mutex) {
            objectJSON = super.toJSONObjectForSaving(operations);
            if (this.sessionToken != null) {
                try {
                    objectJSON.put("session_token", this.sessionToken);
                } catch (JSONException e) {
                    throw new RuntimeException("could not attach key: auth_data");
                } catch (JSONException e2) {
                    throw new RuntimeException("could not encode value for key: sessionToken");
                }
            }
            if (this.authData.length() > 0) {
                objectJSON.put("auth_data", this.authData);
            }
        }
        return objectJSON;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObjectForDataFile() {
        JSONObject objectJSON;
        synchronized (this.mutex) {
            objectJSON = super.toJSONObjectForDataFile();
            if (this.sessionToken != null) {
                try {
                    objectJSON.put("session_token", this.sessionToken);
                } catch (JSONException e) {
                    throw new RuntimeException("could not attach key: auth_data");
                } catch (JSONException e2) {
                    throw new RuntimeException("could not encode value for key: sessionToken");
                }
            }
            if (this.authData.length() > 0) {
                objectJSON.put("auth_data", this.authData);
            }
        }
        return objectJSON;
    }

    /* access modifiers changed from: package-private */
    public void mergeFromObject(ParseObject other) {
        synchronized (this.mutex) {
            super.mergeFromObject(other);
            if (other instanceof ParseUser) {
                this.sessionToken = ((ParseUser) other).sessionToken;
                this.isNew = ((ParseUser) other).isNew();
                Iterator<String> key = this.authData.keys();
                while (key.hasNext()) {
                    key.next();
                    key.remove();
                }
                Iterator<String> key2 = ((ParseUser) other).authData.keys();
                while (key2.hasNext()) {
                    String k = key2.next();
                    try {
                        this.authData.put(k, ((ParseUser) other).authData.get(k));
                    } catch (JSONException e) {
                        throw new RuntimeException("A JSONException occurred where one was not possible.");
                    }
                }
                this.linkedServiceNames.clear();
                this.linkedServiceNames.addAll(((ParseUser) other).linkedServiceNames);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeFromServer(JSONObject object, boolean completeData) {
        synchronized (this.mutex) {
            super.mergeFromServer(object, completeData);
            if (object.has("session_token")) {
                try {
                    this.sessionToken = object.getString("session_token");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                } catch (JSONException e3) {
                    throw new RuntimeException(e3.getMessage());
                }
            }
            if (object.has("auth_data")) {
                JSONObject newData = object.getJSONObject("auth_data");
                Iterator i = newData.keys();
                while (i.hasNext()) {
                    String key = i.next();
                    this.authData.put(key, newData.get(key));
                    if (!newData.isNull(key)) {
                        this.linkedServiceNames.add(key);
                    }
                    synchronizeAuthData(key);
                }
            }
            if (object.has("is_new")) {
                this.isNew = object.getBoolean("is_new");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentUser() {
        boolean z;
        synchronized (this.mutex) {
            z = this.isCurrentUser;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void cleanUpAuthData() {
        synchronized (this.mutex) {
            if (isCurrentUser()) {
                Iterator<String> i = this.authData.keys();
                while (i.hasNext()) {
                    String key = i.next();
                    if (this.authData.isNull(key)) {
                        i.remove();
                        this.linkedServiceNames.remove(key);
                        if (authenticationProviders.containsKey(key)) {
                            authenticationProviders.get(key).restoreAuthentication((JSONObject) null);
                        }
                    }
                }
            }
        }
    }

    public void setUsername(String username) {
        put("username", username);
    }

    public String getUsername() {
        return getString("username");
    }

    public void setPassword(String password2) {
        synchronized (this.mutex) {
            this.password = password2;
            this.dirty = true;
        }
    }

    public void setEmail(String email) {
        put(ParseFacebookUtils.Permissions.User.EMAIL, email);
    }

    public String getEmail() {
        return getString(ParseFacebookUtils.Permissions.User.EMAIL);
    }

    public void put(String key, Object value) {
        synchronized (this.mutex) {
            if ("username".equals(key)) {
                stripAnonymity();
            }
            super.put(key, value);
        }
    }

    /* access modifiers changed from: private */
    public void stripAnonymity() {
        synchronized (this.mutex) {
            if (ParseAnonymousUtils.isLinked(this)) {
                this.linkedServiceNames.remove("anonymous");
                try {
                    this.authData.put("anonymous", JSONObject.NULL);
                    this.dirty = true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void restoreAnonymity(JSONObject anonymousData) {
        synchronized (this.mutex) {
            if (anonymousData != null) {
                this.linkedServiceNames.add("anonymous");
                try {
                    this.authData.put("anonymous", anonymousData);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String getSessionToken() {
        String str;
        synchronized (this.mutex) {
            str = this.sessionToken;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public void validateSave() {
        synchronized (this.mutex) {
            if (getObjectId() == null) {
                throw new IllegalArgumentException("Cannot save a ParseUser until it has been signed up. Call signUp first.");
            } else if (!isAuthenticated() && isDirty() && !getObjectId().equals(getCurrentUser().getObjectId())) {
                throw new IllegalArgumentException("Cannot save a ParseUser that is not authenticated.");
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.parse.Task<java.lang.Void>, com.parse.Task] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.parse.Task<java.lang.Void> saveAsync(com.parse.Task<java.lang.Void> r4) {
        /*
            r3 = this;
            java.lang.Object r1 = r3.mutex
            monitor-enter(r1)
            boolean r0 = r3.isLazy()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x000f
            com.parse.Task r0 = r3.resolveLazinessAsync(r4)     // Catch:{ all -> 0x001e }
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
        L_0x000e:
            return r0
        L_0x000f:
            com.parse.Task r0 = super.saveAsync(r4)     // Catch:{ all -> 0x001e }
            com.parse.ParseUser$1 r2 = new com.parse.ParseUser$1     // Catch:{ all -> 0x001e }
            r2.<init>()     // Catch:{ all -> 0x001e }
            com.parse.Task r0 = r0.onSuccess(r2)     // Catch:{ all -> 0x001e }
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            goto L_0x000e
        L_0x001e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.saveAsync(com.parse.Task):com.parse.Task");
    }

    /* access modifiers changed from: package-private */
    public void validateDelete() {
        synchronized (this.mutex) {
            super.validateDelete();
            if (!isAuthenticated() && isDirty()) {
                throw new IllegalArgumentException("Cannot delete a ParseUser that is not authenticated.");
            }
        }
    }

    public ParseUser fetch() throws ParseException {
        return (ParseUser) super.fetch();
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchAsync(Task<Void> toAwait) {
        Task<TContinuationResult> onSuccessTask;
        synchronized (this.mutex) {
            if (isLazy()) {
                onSuccessTask = Task.forResult(this);
            } else {
                onSuccessTask = super.fetchAsync(toAwait).onSuccessTask(new Continuation<T, Task<T>>() {
                    public Task<T> then(Task<T> task) throws Exception {
                        synchronized (ParseUser.this.mutex) {
                            ParseUser.this.cleanUpAuthData();
                            if (ParseUser.this.isCurrentUser()) {
                                ParseUser.saveCurrentUser(ParseUser.this);
                            }
                        }
                        return task;
                    }
                });
            }
        }
        return onSuccessTask;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.parse.ParseCommand constructSaveCommand(java.util.Map<java.lang.String, com.parse.ParseFieldOperation> r5, java.lang.String r6) throws com.parse.ParseException {
        /*
            r4 = this;
            java.lang.Object r2 = r4.mutex
            monitor-enter(r2)
            com.parse.ParseCommand r0 = super.constructSaveCommand(r5, r6)     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            r0 = 0
        L_0x000b:
            return r0
        L_0x000c:
            java.lang.String r1 = r4.password     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = "user_password"
            java.lang.String r3 = r4.password     // Catch:{ all -> 0x0028 }
            r0.put((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0028 }
        L_0x0017:
            org.json.JSONObject r1 = r4.authData     // Catch:{ all -> 0x0028 }
            int r1 = r1.length()     // Catch:{ all -> 0x0028 }
            if (r1 <= 0) goto L_0x0026
            java.lang.String r1 = "auth_data"
            org.json.JSONObject r3 = r4.authData     // Catch:{ all -> 0x0028 }
            r0.put((java.lang.String) r1, (org.json.JSONObject) r3)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            goto L_0x000b
        L_0x0028:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.constructSaveCommand(java.util.Map, java.lang.String):com.parse.ParseCommand");
    }

    /* access modifiers changed from: private */
    public ParseCommand constructSignUpCommand(Map<String, ParseFieldOperation> operations, String sessionToken2) throws ParseException {
        ParseCommand command = constructSaveCommand(operations, sessionToken2);
        command.setOp("user_signup");
        return command;
    }

    /* access modifiers changed from: private */
    public ParseCommand constructSignUpOrLoginCommand(Map<String, ParseFieldOperation> operations) throws ParseException {
        ParseCommand command;
        synchronized (this.mutex) {
            command = new ParseCommand("user_signup_or_login", (String) null);
            JSONObject params = toJSONObjectForSaving(operations);
            Iterator keys = params.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                try {
                    Object value = params.get(key);
                    if (value instanceof JSONObject) {
                        command.put(key, (JSONObject) value);
                    } else if (value instanceof JSONArray) {
                        command.put(key, (JSONArray) value);
                    } else if (value instanceof String) {
                        command.put(key, (String) value);
                    } else {
                        command.put(key, params.getInt(key));
                    }
                } catch (JSONException e) {
                }
            }
            if (this.password != null) {
                command.put("user_password", this.password);
            }
        }
        return command;
    }

    private static ParseCommand constructPasswordResetCommand(String email, String sessionToken2) {
        ParseCommand command = new ParseCommand("user_request_password_reset", sessionToken2);
        command.put(ParseFacebookUtils.Permissions.User.EMAIL, email);
        return command;
    }

    private Task<Void> signUpAsync() {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) throws Exception {
                return ParseUser.this.signUpAsync(task);
            }
        });
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.parse.Task<java.lang.Void>, com.parse.Task] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.parse.Task<java.lang.Void> signUpAsync(com.parse.Task<java.lang.Void> r6) {
        /*
            r5 = this;
            r4 = 1
            java.lang.Object r3 = r5.mutex
            monitor-enter(r3)
            java.lang.String r1 = getCurrentSessionToken()     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = r5.getUsername()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0018
            java.lang.String r2 = r5.getUsername()     // Catch:{ all -> 0x0020 }
            int r2 = r2.length()     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x0023
        L_0x0018:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Username cannot be missing or blank"
            r2.<init>(r4)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            throw r2
        L_0x0023:
            java.lang.String r2 = r5.password     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x002f
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Password cannot be missing or blank"
            r2.<init>(r4)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x002f:
            java.lang.String r2 = r5.getObjectId()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0060
            org.json.JSONObject r2 = r5.authData     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r4 = "anonymous"
            boolean r2 = r2.has(r4)     // Catch:{ JSONException -> 0x0051 }
            if (r2 == 0) goto L_0x0058
            org.json.JSONObject r2 = r5.authData     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r4 = "anonymous"
            java.lang.Object r2 = r2.get(r4)     // Catch:{ JSONException -> 0x0051 }
            java.lang.Object r4 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x0051 }
            if (r2 != r4) goto L_0x0058
            com.parse.Task r2 = r5.saveAsync(r6)     // Catch:{ JSONException -> 0x0051 }
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
        L_0x0050:
            return r2
        L_0x0051:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0020 }
            r2.<init>(r0)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0058:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Cannot sign up a user that has already signed up."
            r2.<init>(r4)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0060:
            java.util.LinkedList r2 = r5.operationSetQueue     // Catch:{ all -> 0x0020 }
            int r2 = r2.size()     // Catch:{ all -> 0x0020 }
            if (r2 <= r4) goto L_0x0070
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Cannot sign up a user that is already signing up."
            r2.<init>(r4)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0070:
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x00d0
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            boolean r2 = com.parse.ParseAnonymousUtils.isLinked(r2)     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x00d0
            boolean r2 = r5.isCurrentUser()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x008e
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Attempt to merge currentUser with itself."
            r2.<init>(r4)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x008e:
            r5.checkForChangesToMutableContainers()     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            r2.checkForChangesToMutableContainers()     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            r2.copyChangesFrom(r5)     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            r4 = 1
            r2.dirty = r4     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = r5.password     // Catch:{ all -> 0x0020 }
            r2.setPassword(r4)     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = r5.getUsername()     // Catch:{ all -> 0x0020 }
            r2.setUsername(r4)     // Catch:{ all -> 0x0020 }
            r5.revert()     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser r2 = getCurrentUser()     // Catch:{ all -> 0x0020 }
            com.parse.Task r2 = r2.saveAsync(r6)     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser$4 r4 = new com.parse.ParseUser$4     // Catch:{ all -> 0x0020 }
            r4.<init>()     // Catch:{ all -> 0x0020 }
            com.parse.Task r2 = r2.onSuccess(r4)     // Catch:{ all -> 0x0020 }
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0050
        L_0x00d0:
            com.parse.ParseUser$5 r2 = new com.parse.ParseUser$5     // Catch:{ all -> 0x0020 }
            r2.<init>()     // Catch:{ all -> 0x0020 }
            com.parse.Task r2 = com.parse.Task.call(r2)     // Catch:{ all -> 0x0020 }
            com.parse.Continuation r4 = com.parse.TaskQueue.waitFor(r6)     // Catch:{ all -> 0x0020 }
            com.parse.Task r2 = r2.continueWithTask(r4)     // Catch:{ all -> 0x0020 }
            com.parse.ParseUser$6 r4 = new com.parse.ParseUser$6     // Catch:{ all -> 0x0020 }
            r4.<init>(r1)     // Catch:{ all -> 0x0020 }
            com.parse.Task r2 = r2.onSuccessTask(r4)     // Catch:{ all -> 0x0020 }
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.signUpAsync(com.parse.Task):com.parse.Task");
    }

    public void signUp() throws ParseException {
        Parse.waitForTask(signUpAsync());
    }

    public void signUpInBackground(SignUpCallback callback) {
        Parse.callbackOnMainThreadAsync(signUpAsync(), callback);
    }

    private static ParseCommand constructLogInCommand(String username, String password2) {
        ParseCommand command = new ParseCommand("user_login", (String) null);
        command.put("username", username);
        command.put("user_password", password2);
        return command;
    }

    private static Task<ParseUser> logInAsync(String username, String password2) {
        if (username == null) {
            throw new IllegalArgumentException("Must specify a username for the user to log in with");
        } else if (password2 != null) {
            return constructLogInCommand(username, password2).performAsync().onSuccess(new Continuation<Object, ParseUser>() {
                public ParseUser then(Task<Object> task) throws Exception {
                    if (task.getResult() == JSONObject.NULL) {
                        throw new ParseException((int) ParseException.OBJECT_NOT_FOUND, "invalid login credentials");
                    }
                    ParseUser user = (ParseUser) ParseObject.create(ParseUser.class);
                    user.handleFetchResult((JSONObject) task.getResult());
                    ParseUser.saveCurrentUser(user);
                    return user;
                }
            });
        } else {
            throw new IllegalArgumentException("Must specify a password for the user to log in with");
        }
    }

    public static ParseUser logIn(String username, String password2) throws ParseException {
        return (ParseUser) Parse.waitForTask(logInAsync(username, password2));
    }

    public static void logInInBackground(String username, String password2, LogInCallback callback) {
        Parse.callbackOnMainThreadAsync(logInAsync(username, password2), callback);
    }

    public static ParseUser getCurrentUser() {
        ParseUser parseUser;
        synchronized (currentUserMutex) {
            checkApplicationContext();
            if (currentUser != null) {
                parseUser = currentUser;
            } else if (currentUserMatchesDisk) {
                if (isAutomaticUserEnabled()) {
                    ParseAnonymousUtils.lazyLogIn();
                }
                parseUser = currentUser;
            } else {
                currentUserMatchesDisk = true;
                ParseObject user = getFromDisk(Parse.applicationContext, CURRENT_USER_FILENAME);
                if (user == null) {
                    if (isAutomaticUserEnabled()) {
                        ParseAnonymousUtils.lazyLogIn();
                    }
                    parseUser = currentUser;
                } else {
                    currentUser = (ParseUser) user;
                    currentUser.isCurrentUser = true;
                    parseUser = currentUser;
                }
            }
        }
        return parseUser;
    }

    static String getCurrentSessionToken() {
        synchronized (currentUserMutex) {
            if (getCurrentUser() == null) {
                return null;
            }
            String sessionToken2 = getCurrentUser().getSessionToken();
            return sessionToken2;
        }
    }

    /* access modifiers changed from: private */
    public static void saveCurrentUser(ParseUser user) {
        synchronized (currentUserMutex) {
            checkApplicationContext();
            if (currentUser != user) {
                logOut();
            }
            synchronized (user.mutex) {
                user.isCurrentUser = true;
                user.synchronizeAllAuthData();
                user.saveToDisk(Parse.applicationContext, CURRENT_USER_FILENAME);
            }
            currentUserMatchesDisk = true;
            currentUser = user;
        }
    }

    public static void logOut() {
        synchronized (currentUserMutex) {
            checkApplicationContext();
            if (currentUser != null) {
                synchronized (currentUser.mutex) {
                    for (String authType : currentUser.getLinkedServiceNames()) {
                        currentUser.logOutWith(authType);
                    }
                    currentUser.isCurrentUser = false;
                    currentUser.sessionToken = null;
                }
            }
            currentUserMatchesDisk = true;
            currentUser = null;
            new File(Parse.getParseDir(), CURRENT_USER_FILENAME).delete();
        }
    }

    private static Task<Void> requestPasswordResetAsync(String email) {
        return constructPasswordResetCommand(email, getCurrentSessionToken()).performAsync().makeVoid();
    }

    public static void requestPasswordReset(String email) throws ParseException {
        Parse.waitForTask(requestPasswordResetAsync(email));
    }

    public static void requestPasswordResetInBackground(String email, RequestPasswordResetCallback callback) {
        Parse.callbackOnMainThreadAsync(requestPasswordResetAsync(email), callback);
    }

    private static void checkApplicationContext() {
        if (Parse.applicationContext == null) {
            throw new RuntimeException("You must call Parse.initialize(context, oauthKey, oauthSecret) before using the Parse library.");
        }
    }

    public ParseUser fetchIfNeeded() throws ParseException {
        return (ParseUser) super.fetchIfNeeded();
    }

    /* access modifiers changed from: package-private */
    public Set<String> getLinkedServiceNames() {
        Set<String> set;
        synchronized (this.mutex) {
            set = this.readOnlyLinkedServiceNames;
        }
        return set;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void synchronizeAuthData(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.Object r3 = r5.mutex
            monitor-enter(r3)
            boolean r2 = r5.isCurrentUser()     // Catch:{ all -> 0x0015 }
            if (r2 != 0) goto L_0x000b
            monitor-exit(r3)     // Catch:{ all -> 0x0015 }
        L_0x000a:
            return
        L_0x000b:
            java.util.Map<java.lang.String, com.parse.auth.ParseAuthenticationProvider> r2 = authenticationProviders     // Catch:{ all -> 0x0015 }
            boolean r2 = r2.containsKey(r6)     // Catch:{ all -> 0x0015 }
            if (r2 != 0) goto L_0x0018
            monitor-exit(r3)     // Catch:{ all -> 0x0015 }
            goto L_0x000a
        L_0x0015:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0015 }
            throw r2
        L_0x0018:
            java.util.Map<java.lang.String, com.parse.auth.ParseAuthenticationProvider> r2 = authenticationProviders     // Catch:{ all -> 0x0015 }
            java.lang.Object r0 = r2.get(r6)     // Catch:{ all -> 0x0015 }
            com.parse.auth.ParseAuthenticationProvider r0 = (com.parse.auth.ParseAuthenticationProvider) r0     // Catch:{ all -> 0x0015 }
            org.json.JSONObject r2 = r5.authData     // Catch:{ all -> 0x0015 }
            java.lang.String r4 = r0.getAuthType()     // Catch:{ all -> 0x0015 }
            org.json.JSONObject r2 = r2.optJSONObject(r4)     // Catch:{ all -> 0x0015 }
            boolean r1 = r0.restoreAuthentication(r2)     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0033
            r5.unlinkFromAsync(r6)     // Catch:{ all -> 0x0015 }
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0015 }
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.synchronizeAuthData(java.lang.String):void");
    }

    private void synchronizeAllAuthData() {
        synchronized (this.mutex) {
            if (this.authData != null) {
                Iterator<String> authTypes = this.authData.keys();
                while (authTypes.hasNext()) {
                    synchronizeAuthData(authTypes.next());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> unlinkFromAsync(final String authType) {
        Task<Void> continueWithTask;
        synchronized (this.mutex) {
            if (authType == null) {
                continueWithTask = Task.forResult(null);
            } else {
                continueWithTask = Task.forResult(null).continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) throws Exception {
                        Task<Void> forResult;
                        synchronized (ParseUser.this.mutex) {
                            if (ParseUser.this.authData.has(authType)) {
                                ParseUser.this.authData.put(authType, JSONObject.NULL);
                                ParseUser.this.dirty = true;
                                forResult = ParseUser.this.saveAsync();
                            } else {
                                forResult = Task.forResult(null);
                            }
                        }
                        return forResult;
                    }
                });
            }
        }
        return continueWithTask;
    }

    static void registerAuthenticationProvider(ParseAuthenticationProvider provider) {
        authenticationProviders.put(provider.getAuthType(), provider);
        if (getCurrentUser() != null) {
            getCurrentUser().synchronizeAuthData(provider.getAuthType());
        }
    }

    static Task<ParseUser> logInWithAsync(String authType) {
        if (authenticationProviders.containsKey(authType)) {
            return logInWithAsync(authenticationProviders.get(authType));
        }
        throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
    }

    static Task<ParseUser> logInWithAsync(final String authType, final JSONObject authData2) {
        final Continuation<Void, Task<ParseUser>> logInWithTask = new Continuation<Void, Task<ParseUser>>() {
            public Task<ParseUser> then(Task<Void> task) throws Exception {
                final ParseUser user = (ParseUser) ParseObject.create(ParseUser.class);
                try {
                    user.authData.put(authType, authData2);
                    user.linkedServiceNames.add(authType);
                    final Map<String, ParseFieldOperation> operations = user.startSave();
                    final ParseCommand command = user.constructSignUpOrLoginCommand(operations);
                    Task<TContinuationResult> continueWithTask = command.performAsync().continueWithTask(new Continuation<Object, Task<Object>>() {
                        public Task<Object> then(Task<Object> task) throws Exception {
                            user.handleSaveResult(command.f1758op, (JSONObject) task.getResult(), operations);
                            return null;
                        }
                    });
                    final String str = authType;
                    return continueWithTask.onSuccess(new Continuation<Object, ParseUser>() {
                        public ParseUser then(Task<Object> task) throws Exception {
                            ParseUser parseUser;
                            synchronized (user.mutex) {
                                user.synchronizeAuthData(str);
                                ParseUser.saveCurrentUser(user);
                                parseUser = user;
                            }
                            return parseUser;
                        }
                    });
                } catch (JSONException e) {
                    throw new ParseException(e);
                }
            }
        };
        final ParseUser user = getCurrentUser();
        if (user != null) {
            synchronized (user.mutex) {
                if (ParseAnonymousUtils.isLinked(user)) {
                    if (user.isLazy()) {
                        final JSONObject oldAnonymousData = user.authData.optJSONObject("anonymous");
                        Task<ParseUser> enqueue = user.taskQueue.enqueue(new Continuation<Void, Task<ParseUser>>() {
                            public Task<ParseUser> then(Task<Void> task) throws Exception {
                                Task forResult = Task.forResult(null);
                                final ParseUser parseUser = ParseUser.this;
                                final String str = authType;
                                final JSONObject jSONObject = authData2;
                                Task continueWithTask = forResult.continueWithTask(new Continuation<Void, Task<Void>>() {
                                    public Task<Void> then(Task<Void> task) throws Exception {
                                        Task<Void> access$11;
                                        synchronized (parseUser.mutex) {
                                            parseUser.stripAnonymity();
                                            parseUser.authData.put(str, jSONObject);
                                            parseUser.linkedServiceNames.add(str);
                                            access$11 = parseUser.resolveLazinessAsync(task);
                                        }
                                        return access$11;
                                    }
                                });
                                final ParseUser parseUser2 = ParseUser.this;
                                final String str2 = authType;
                                final JSONObject jSONObject2 = oldAnonymousData;
                                return continueWithTask.continueWithTask(new Continuation<Void, Task<ParseUser>>() {
                                    public Task<ParseUser> then(Task<Void> task) throws Exception {
                                        Task<ParseUser> forResult;
                                        synchronized (parseUser2.mutex) {
                                            if (task.isFaulted()) {
                                                parseUser2.authData.remove(str2);
                                                parseUser2.linkedServiceNames.remove(str2);
                                                parseUser2.restoreAnonymity(jSONObject2);
                                                forResult = Task.forError(task.getError());
                                            } else if (task.isCancelled()) {
                                                forResult = Task.cancelled();
                                            } else {
                                                forResult = Task.forResult(parseUser2);
                                            }
                                        }
                                        return forResult;
                                    }
                                });
                            }
                        });
                        return enqueue;
                    }
                    Task<TContinuationResult> continueWithTask = user.linkWithAsync(authType, authData2).continueWithTask(new Continuation<Void, Task<ParseUser>>() {
                        public Task<ParseUser> then(Task<Void> task) throws Exception {
                            if (task.isFaulted() && (task.getError() instanceof ParseException) && ((ParseException) task.getError()).getCode() == 208) {
                                return Task.forResult(null).continueWithTask(Continuation.this);
                            }
                            if (task.isCancelled()) {
                                return Task.cancelled();
                            }
                            return Task.forResult(user);
                        }
                    });
                    return continueWithTask;
                }
            }
        }
        return Task.forResult(null).continueWithTask(logInWithTask);
    }

    /* access modifiers changed from: private */
    public Task<Void> resolveLazinessAsync(Task<Void> toAwait) {
        Task<TContinuationResult> onSuccess;
        synchronized (this.mutex) {
            if (!isLazy()) {
                onSuccess = Task.forResult(null);
            } else if (this.linkedServiceNames.size() == 0) {
                onSuccess = signUpAsync(toAwait).onSuccess(new Continuation<Void, Void>() {
                    public Void then(Task<Void> task) throws Exception {
                        synchronized (ParseUser.this.mutex) {
                            ParseUser.this.isLazy = false;
                        }
                        return null;
                    }
                });
            } else {
                final Capture<Map<String, ParseFieldOperation>> operations = new Capture<>();
                onSuccess = Task.call(new Callable<Map<String, ParseFieldOperation>>() {
                    public Map<String, ParseFieldOperation> call() throws Exception {
                        return ParseUser.this.startSave();
                    }
                }).onSuccessTask(TaskQueue.waitFor(toAwait)).onSuccessTask(new Continuation<Map<String, ParseFieldOperation>, Task<Object>>() {
                    public Task<Object> then(Task<Map<String, ParseFieldOperation>> task) throws Exception {
                        operations.set(task.getResult());
                        return ParseUser.this.constructSignUpOrLoginCommand((Map) operations.get()).performAsync();
                    }
                }).onSuccess(new Continuation<Object, Void>() {
                    public Void then(Task<Object> task) throws Exception {
                        synchronized (ParseUser.this.mutex) {
                            JSONObject commandResult = (JSONObject) task.getResult();
                            ParseUser.this.handleSaveResult("create", commandResult, (Map) operations.get());
                            if (commandResult.optBoolean("is_new")) {
                                ParseUser.this.isLazy = false;
                            } else {
                                ParseUser newUser = (ParseUser) ParseObject.create(ParseUser.class);
                                newUser.handleFetchResult(commandResult);
                                ParseUser.saveCurrentUser(newUser);
                            }
                        }
                        return null;
                    }
                });
            }
        }
        return onSuccess;
    }

    private static Task<JSONObject> authenticateAsync(ParseAuthenticationProvider authenticator) {
        final Task<TResult>.TaskCompletionSource create = Task.create();
        authenticator.authenticate(new ParseAuthenticationProvider.ParseAuthenticationCallback() {
            public void onSuccess(JSONObject authData) {
                Task.TaskCompletionSource.this.setResult(authData);
            }

            public void onCancel() {
                Task.TaskCompletionSource.this.setCancelled();
            }

            public void onError(Throwable error) {
                Task.TaskCompletionSource.this.setError(new ParseException(error));
            }
        });
        return create.getTask();
    }

    private static Task<ParseUser> logInWithAsync(final ParseAuthenticationProvider authenticator) {
        return authenticateAsync(authenticator).onSuccessTask(new Continuation<JSONObject, Task<ParseUser>>() {
            public Task<ParseUser> then(Task<JSONObject> task) throws Exception {
                return ParseUser.logInWithAsync(ParseAuthenticationProvider.this.getAuthType(), task.getResult());
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> linkWithAsync(final String authType, final JSONObject authData2, final Task<Void> toAwait) {
        Task<Void> continueWithTask;
        final JSONObject oldAnonymousData = authData2.optJSONObject("anonymous");
        synchronized (this.mutex) {
            continueWithTask = Task.call(new Callable<Void>() {
                public Void call() throws Exception {
                    synchronized (ParseUser.this.mutex) {
                        ParseUser.this.authData.put(authType, authData2);
                        ParseUser.this.linkedServiceNames.add(authType);
                        ParseUser.this.stripAnonymity();
                        ParseUser.this.dirty = true;
                    }
                    return null;
                }
            }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) throws Exception {
                    return ParseUser.this.saveAsync(toAwait);
                }
            }).continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) throws Exception {
                    synchronized (ParseUser.this.mutex) {
                        if (task.isFaulted() || task.isCancelled()) {
                            ParseUser.this.restoreAnonymity(oldAnonymousData);
                        } else {
                            ParseUser.this.synchronizeAuthData(authType);
                        }
                    }
                    return task;
                }
            });
        }
        return continueWithTask;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> linkWithAsync(final String authType, final JSONObject authData2) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) throws Exception {
                return ParseUser.this.linkWithAsync(authType, authData2, task);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Task<Void> linkWithAsync(String authType) {
        if (authenticationProviders.containsKey(authType)) {
            return linkWithAsync(authenticationProviders.get(authType));
        }
        throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
    }

    private Task<Void> linkWithAsync(final ParseAuthenticationProvider authenticator) {
        return authenticateAsync(authenticator).onSuccessTask(new Continuation<JSONObject, Task<Void>>() {
            public Task<Void> then(Task<JSONObject> task) throws Exception {
                return ParseUser.this.linkWithAsync(authenticator.getAuthType(), task.getResult());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void logOutWith(String authType) {
        synchronized (this.mutex) {
            if (authenticationProviders.containsKey(authType) && this.linkedServiceNames.contains(authType)) {
                logOutWith(authenticationProviders.get(authType));
            }
        }
    }

    private void logOutWith(ParseAuthenticationProvider provider) {
        provider.deauthenticate();
    }

    public boolean isNew() {
        boolean z;
        synchronized (this.mutex) {
            z = this.isNew;
        }
        return z;
    }

    static void disableAutomaticUser() {
        autoUserEnabled = false;
    }

    public static void enableAutomaticUser() {
        autoUserEnabled = true;
    }

    static boolean isAutomaticUserEnabled() {
        return autoUserEnabled;
    }

    public static ParseQuery<ParseUser> getQuery() {
        return ParseQuery.getQuery(ParseUser.class);
    }

    static void clearCurrentUserFromMemory() {
        synchronized (currentUserMutex) {
            currentUser = null;
            currentUserMatchesDisk = false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }
}
