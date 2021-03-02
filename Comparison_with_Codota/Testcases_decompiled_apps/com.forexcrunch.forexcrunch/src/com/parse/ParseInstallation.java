package com.parse;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.analytics.tracking.android.ModelFields;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@ParseClassName("_Installation")
public class ParseInstallation extends ParseObject {
    private static final String STORAGE_LOCATION = "currentInstallation";
    private static final String TAG = "com.parse.ParseInstallation";
    static ParseInstallation currentInstallation = null;
    private static final List<String> readonlyFields = Arrays.asList(new String[]{"deviceType", "installationId", "deviceToken", "timeZone", ModelFields.APP_VERSION, ModelFields.APP_NAME, "parseVersion"});

    /* access modifiers changed from: package-private */
    public void setDefaultValues() {
        super.setDefaultValues();
        super.put("deviceType", "android");
        super.put("installationId", getOrCreateCurrentInstallationId());
    }

    public static synchronized ParseInstallation getCurrentInstallation() {
        ParseInstallation parseInstallation;
        synchronized (ParseInstallation.class) {
            if (currentInstallation != null) {
                parseInstallation = currentInstallation;
            } else {
                ParseObject installation = getFromDisk(Parse.applicationContext, STORAGE_LOCATION);
                if (installation == null) {
                    currentInstallation = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                } else {
                    currentInstallation = (ParseInstallation) installation;
                    Parse.logV(TAG, "Successfully deserialized Installation object");
                }
                parseInstallation = currentInstallation;
            }
        }
        return parseInstallation;
    }

    public static ParseQuery<ParseInstallation> getQuery() {
        return ParseQuery.getQuery(ParseInstallation.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC, Splitter:B:34:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String getOrCreateCurrentInstallationId() {
        /*
            java.lang.Class<com.parse.ParseInstallation> r7 = com.parse.ParseInstallation.class
            monitor-enter(r7)
            com.parse.ParseInstallation r6 = currentInstallation     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x000f
            com.parse.ParseInstallation r6 = currentInstallation     // Catch:{ all -> 0x007b }
            java.lang.String r5 = r6.getInstallationId()     // Catch:{ all -> 0x007b }
        L_0x000d:
            monitor-exit(r7)
            return r5
        L_0x000f:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x007b }
            java.io.File r6 = com.parse.Parse.getParseDir()     // Catch:{ all -> 0x007b }
            java.lang.String r8 = "installationId"
            r4.<init>(r6, r8)     // Catch:{ all -> 0x007b }
            r2 = 0
            boolean r6 = r4.exists()     // Catch:{ IOException -> 0x0063 }
            if (r6 != 0) goto L_0x003e
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ IOException -> 0x0063 }
            java.lang.String r5 = r6.toString()     // Catch:{ IOException -> 0x0063 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0063 }
            java.lang.String r6 = "rw"
            r3.<init>(r4, r6)     // Catch:{ IOException -> 0x0063 }
            r3.writeBytes(r5)     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            r3.close()     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            if (r3 == 0) goto L_0x000d
            r3.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x000d
        L_0x003c:
            r6 = move-exception
            goto L_0x000d
        L_0x003e:
            java.lang.String r6 = "com.parse.ParseInstallation"
            java.lang.String r8 = "Reading legacy file for installation ID"
            com.parse.Parse.logV(r6, r8)     // Catch:{ IOException -> 0x0063 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0063 }
            java.lang.String r6 = "r"
            r3.<init>(r4, r6)     // Catch:{ IOException -> 0x0063 }
            long r8 = r3.length()     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            int r6 = (int) r8     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            byte[] r0 = new byte[r6]     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            r3.readFully(r0)     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            r5.<init>(r0)     // Catch:{ IOException -> 0x0083, all -> 0x0080 }
            if (r3 == 0) goto L_0x000d
            r3.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x000d
        L_0x0061:
            r6 = move-exception
            goto L_0x000d
        L_0x0063:
            r1 = move-exception
        L_0x0064:
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x000d
            r2.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x000d
        L_0x0072:
            r6 = move-exception
            goto L_0x000d
        L_0x0074:
            r6 = move-exception
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.close()     // Catch:{ IOException -> 0x007e }
        L_0x007a:
            throw r6     // Catch:{ all -> 0x007b }
        L_0x007b:
            r6 = move-exception
            monitor-exit(r7)
            throw r6
        L_0x007e:
            r8 = move-exception
            goto L_0x007a
        L_0x0080:
            r6 = move-exception
            r2 = r3
            goto L_0x0075
        L_0x0083:
            r1 = move-exception
            r2 = r3
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseInstallation.getOrCreateCurrentInstallationId():java.lang.String");
    }

    public String getInstallationId() {
        return getString("installationId");
    }

    /* access modifiers changed from: package-private */
    public void checkKeyIsMutable(String key) throws IllegalArgumentException {
        synchronized (this.mutex) {
            if (readonlyFields.contains(key)) {
                throw new IllegalArgumentException("Cannot change " + key + " property of an installation object.");
            }
        }
    }

    public void put(String key, Object value) throws IllegalArgumentException {
        synchronized (this.mutex) {
            checkKeyIsMutable(key);
            super.put(key, value);
        }
    }

    public void remove(String key) {
        synchronized (this.mutex) {
            checkKeyIsMutable(key);
            super.remove(key);
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(Task<Void> toAwait) {
        Task<TContinuationResult> onSuccessTask;
        synchronized (this.mutex) {
            updateTimezone();
            updateVersionInfo();
            super.put("installationId", getOrCreateCurrentInstallationId());
            super.put("deviceType", "android");
            onSuccessTask = super.saveAsync(toAwait).onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) throws Exception {
                    ParseInstallation.maybeFlushToDisk(ParseInstallation.this);
                    return task;
                }
            });
        }
        return onSuccessTask;
    }

    public void saveEventually(SaveCallback callback) {
        synchronized (this.mutex) {
            updateTimezone();
            updateVersionInfo();
            super.put("installationId", getOrCreateCurrentInstallationId());
            super.put("deviceType", "android");
            super.saveEventually(callback);
        }
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchAsync(final Task<Void> toAwait) {
        Task<Void> result;
        Task<TContinuationResult> continueWithTask;
        synchronized (this.mutex) {
            if (getObjectId() == null) {
                result = saveAsync(toAwait);
            } else {
                result = Task.forResult(null);
            }
            continueWithTask = result.onSuccessTask(new Continuation<Void, Task<T>>() {
                public Task<T> then(Task<Void> task) throws Exception {
                    return ParseInstallation.super.fetchAsync(toAwait);
                }
            }).continueWithTask(new Continuation<T, Task<T>>() {
                public Task<T> then(Task<T> task) throws Exception {
                    ParseInstallation.maybeFlushToDisk(ParseInstallation.this);
                    return task;
                }
            });
        }
        return continueWithTask;
    }

    private void updateTimezone() {
        String zone = TimeZone.getDefault().getID();
        if ((zone.indexOf(47) > 0 || zone.equals("GMT")) && !zone.equals(get("timeZone"))) {
            super.put("timeZone", zone);
        }
    }

    private void updateVersionInfo() {
        boolean z;
        boolean z2 = false;
        synchronized (this.mutex) {
            try {
                String packageName = Parse.applicationContext.getPackageName();
                PackageManager pm = Parse.applicationContext.getPackageManager();
                String appVersion = pm.getPackageInfo(packageName, 0).versionName;
                String appName = pm.getApplicationLabel(pm.getApplicationInfo(packageName, 0)).toString();
                if (appName != null && !appName.equals(get(ModelFields.APP_NAME))) {
                    super.put(ModelFields.APP_NAME, appName);
                }
                if (appVersion != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!appVersion.equals(get(ModelFields.APP_VERSION))) {
                    z2 = true;
                }
                if (z2 && z) {
                    super.put(ModelFields.APP_VERSION, appVersion);
                }
            } catch (PackageManager.NameNotFoundException e) {
                Parse.logW(TAG, "Cannot load package info; will not be saved to installation");
            }
            if (!"1.3.4".equals(get("parseVersion"))) {
                super.put("parseVersion", "1.3.4");
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void maybeFlushToDisk(ParseInstallation installation) {
        synchronized (ParseInstallation.class) {
            if (currentInstallation == installation) {
                installation.saveToDisk(Parse.applicationContext, STORAGE_LOCATION);
            }
        }
    }

    static synchronized void clearCurrentInstallationFromMemory() {
        synchronized (ParseInstallation.class) {
            currentInstallation = null;
        }
    }

    static synchronized void clearCurrentInstallationFromDisk(Context context) {
        synchronized (ParseInstallation.class) {
            currentInstallation = null;
            ParseObject.deleteDiskObject(context, STORAGE_LOCATION);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }
}
