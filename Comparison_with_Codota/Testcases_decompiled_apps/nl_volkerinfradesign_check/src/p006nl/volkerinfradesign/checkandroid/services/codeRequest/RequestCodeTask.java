package p006nl.volkerinfradesign.checkandroid.services.codeRequest;

import android.os.AsyncTask;
import android.util.Pair;

/* renamed from: nl.volkerinfradesign.checkandroid.services.codeRequest.RequestCodeTask */
public final class RequestCodeTask extends AsyncTask<String, Void, Pair<Boolean, Exception>> {

    /* renamed from: a */
    private final RequestCodeCallback f4940a;

    public RequestCodeTask(RequestCodeCallback requestCodeCallback) {
        this.f4940a = requestCodeCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.f4940a != null) {
            this.f4940a.onStart();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A[Catch:{ Exception -> 0x00a6, all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.Boolean, java.lang.Exception> doInBackground(java.lang.String... r10) {
        /*
            r9 = this;
            r1 = 0
            r2 = 0
            r8 = 1
            com.google.gson.GsonBuilder r0 = new com.google.gson.GsonBuilder
            r0.<init>()
            com.google.gson.GsonBuilder r0 = r0.setPrettyPrinting()
            com.google.gson.Gson r3 = r0.create()
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
            r0.<init>()
            java.lang.String r5 = "email"
            r6 = r10[r2]
            r0.addProperty((java.lang.String) r5, (java.lang.String) r6)
            java.lang.String r5 = "params"
            r4.add(r5, r0)
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00b5, all -> 0x00a9 }
            java.net.URL r0 = r0.getPassCodeUrl()     // Catch:{ Exception -> 0x00b5, all -> 0x00a9 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00b5, all -> 0x00a9 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b5, all -> 0x00a9 }
            r5 = 1
            r0.setDoInput(r5)     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            r5 = 1
            r0.setDoOutput(r5)     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            com.google.gson.stream.JsonWriter r5 = new com.google.gson.stream.JsonWriter     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            r3.toJson((com.google.gson.JsonElement) r4, (com.google.gson.stream.JsonWriter) r5)     // Catch:{ all -> 0x0071 }
            r5.close()     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            java.lang.String r3 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r3)     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            java.lang.String r4 = "OK"
            boolean r2 = r3.equals(r4)     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            org.apache.commons.p009io.IOUtils.close(r0)
            r0 = r1
            r1 = r2
        L_0x0067:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.<init>(r1, r0)
            return r2
        L_0x0071:
            r1 = move-exception
            r5.close()     // Catch:{ Exception -> 0x0076, all -> 0x00af }
            throw r1     // Catch:{ Exception -> 0x0076, all -> 0x00af }
        L_0x0076:
            r1 = move-exception
            r3 = r0
        L_0x0078:
            java.io.InputStream r0 = r3.getErrorStream()     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            java.lang.String r0 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            java.lang.String r4 = "<title>(.*)<\\/title>"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            java.util.regex.Matcher r4 = r4.matcher(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            boolean r5 = r4.find()     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            if (r5 == 0) goto L_0x00b9
            int r5 = r4.groupCount()     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            if (r5 != r8) goto L_0x00b9
            r0 = 1
            java.lang.String r0 = r4.group(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            r4 = r0
        L_0x009c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00a6, all -> 0x00b3 }
        L_0x00a1:
            org.apache.commons.p009io.IOUtils.close(r3)
            r1 = r2
            goto L_0x0067
        L_0x00a6:
            r0 = move-exception
            r0 = r1
            goto L_0x00a1
        L_0x00a9:
            r0 = move-exception
            r3 = r1
        L_0x00ab:
            org.apache.commons.p009io.IOUtils.close(r3)
            throw r0
        L_0x00af:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x00ab
        L_0x00b3:
            r0 = move-exception
            goto L_0x00ab
        L_0x00b5:
            r0 = move-exception
            r3 = r1
            r1 = r0
            goto L_0x0078
        L_0x00b9:
            r4 = r0
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.services.codeRequest.RequestCodeTask.doInBackground(java.lang.String[]):android.util.Pair");
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Pair<Boolean, Exception> pair) {
        super.onCancelled(pair);
        if (this.f4940a != null) {
            this.f4940a.onError(pair != null ? (Exception) pair.second : null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Pair<Boolean, Exception> pair) {
        super.onPostExecute(pair);
        if (this.f4940a == null) {
            return;
        }
        if (pair.first == null || !((Boolean) pair.first).booleanValue()) {
            this.f4940a.onError(pair != null ? (Exception) pair.second : null);
        } else {
            this.f4940a.onSuccess();
        }
    }
}
