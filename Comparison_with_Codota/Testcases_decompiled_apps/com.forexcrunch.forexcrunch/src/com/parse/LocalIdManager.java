package com.parse;

import java.io.File;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class LocalIdManager {
    private static LocalIdManager defaultInstance;
    private File diskPath = new File(Parse.getParseDir(), "LocalId");
    private Random random;

    public static synchronized LocalIdManager getDefaultInstance() {
        LocalIdManager localIdManager;
        synchronized (LocalIdManager.class) {
            if (defaultInstance == null) {
                defaultInstance = new LocalIdManager();
            }
            localIdManager = defaultInstance;
        }
        return localIdManager;
    }

    private class MapEntry {
        String objectId;
        int retainCount;

        private MapEntry() {
        }

        /* synthetic */ MapEntry(LocalIdManager localIdManager, MapEntry mapEntry) {
            this();
        }
    }

    private LocalIdManager() {
        this.diskPath.mkdirs();
        this.random = new Random();
    }

    private boolean isLocalId(String localId) {
        if (!localId.startsWith("local_")) {
            return false;
        }
        for (int i = 6; i < localId.length(); i++) {
            char c = localId.charAt(i);
            if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) {
                return false;
            }
        }
        return true;
    }

    private synchronized MapEntry getMapEntry(String localId) {
        MapEntry entry;
        if (!isLocalId(localId)) {
            throw new IllegalStateException("Tried to get invalid local id: \"" + localId + "\".");
        }
        File file = new File(this.diskPath, localId);
        if (!file.exists()) {
            entry = new MapEntry(this, (MapEntry) null);
        } else {
            JSONObject json = ParseObject.getDiskObject(file);
            entry = new MapEntry(this, (MapEntry) null);
            entry.retainCount = json.optInt("retainCount", 0);
            entry.objectId = json.optString("objectId", (String) null);
        }
        return entry;
    }

    private synchronized void putMapEntry(String localId, MapEntry entry) {
        if (!isLocalId(localId)) {
            throw new IllegalStateException("Tried to get invalid local id: \"" + localId + "\".");
        }
        JSONObject json = new JSONObject();
        try {
            json.put("retainCount", entry.retainCount);
            if (entry.objectId != null) {
                json.put("objectId", entry.objectId);
            }
            File file = new File(this.diskPath, localId);
            if (!this.diskPath.exists()) {
                this.diskPath.mkdirs();
            }
            ParseObject.saveDiskObject(file, json);
        } catch (JSONException je) {
            throw new IllegalStateException("Error creating local id map entry.", je);
        }
    }

    private synchronized void removeMapEntry(String localId) {
        if (!isLocalId(localId)) {
            throw new IllegalStateException("Tried to get invalid local id: \"" + localId + "\".");
        }
        new File(this.diskPath, localId).delete();
    }

    /* access modifiers changed from: package-private */
    public synchronized String createLocalId() {
        String localId;
        localId = "local_" + Long.toHexString(this.random.nextLong());
        if (!isLocalId(localId)) {
            throw new IllegalStateException("Generated an invalid local id: \"" + localId + "\". " + "This should never happen. Contact us at https://parse.com/help");
        }
        return localId;
    }

    /* access modifiers changed from: package-private */
    public synchronized void retainLocalIdOnDisk(String localId) {
        MapEntry entry = getMapEntry(localId);
        entry.retainCount++;
        putMapEntry(localId, entry);
    }

    /* access modifiers changed from: package-private */
    public synchronized void releaseLocalIdOnDisk(String localId) {
        MapEntry entry = getMapEntry(localId);
        entry.retainCount--;
        if (entry.retainCount > 0) {
            putMapEntry(localId, entry);
        } else {
            removeMapEntry(localId);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String getObjectId(String localId) {
        return getMapEntry(localId).objectId;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setObjectId(String localId, String objectId) {
        MapEntry entry = getMapEntry(localId);
        if (entry.retainCount > 0) {
            if (entry.objectId != null) {
                throw new IllegalStateException("Tried to set an objectId for a localId that already has one.");
            }
            entry.objectId = objectId;
            putMapEntry(localId, entry);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean clear() throws java.io.IOException {
        /*
            r6 = this;
            r3 = 0
            monitor-enter(r6)
            java.io.File r4 = r6.diskPath     // Catch:{ all -> 0x003e }
            java.lang.String[] r2 = r4.list()     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x000c
        L_0x000a:
            monitor-exit(r6)
            return r3
        L_0x000c:
            int r4 = r2.length     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x000a
            int r4 = r2.length     // Catch:{ all -> 0x003e }
        L_0x0010:
            if (r3 < r4) goto L_0x0014
            r3 = 1
            goto L_0x000a
        L_0x0014:
            r1 = r2[r3]     // Catch:{ all -> 0x003e }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x003e }
            java.io.File r5 = r6.diskPath     // Catch:{ all -> 0x003e }
            r0.<init>(r5, r1)     // Catch:{ all -> 0x003e }
            boolean r5 = r0.delete()     // Catch:{ all -> 0x003e }
            if (r5 != 0) goto L_0x0041
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            java.lang.String r5 = "Unable to delete file "
            r4.<init>(r5)     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r4 = r4.append(r1)     // Catch:{ all -> 0x003e }
            java.lang.String r5 = " in localId cache."
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x003e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x003e }
            r3.<init>(r4)     // Catch:{ all -> 0x003e }
            throw r3     // Catch:{ all -> 0x003e }
        L_0x003e:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.LocalIdManager.clear():boolean");
    }
}
