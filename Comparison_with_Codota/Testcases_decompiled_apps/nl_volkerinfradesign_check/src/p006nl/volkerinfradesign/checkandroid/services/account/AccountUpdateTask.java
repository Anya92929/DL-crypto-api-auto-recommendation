package p006nl.volkerinfradesign.checkandroid.services.account;

import android.os.AsyncTask;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.CheckEnvironment;

/* renamed from: nl.volkerinfradesign.checkandroid.services.account.AccountUpdateTask */
public final class AccountUpdateTask extends AsyncTask<Account, Void, C1249id> {

    /* renamed from: a */
    private final CheckEnvironment f4936a;

    /* renamed from: b */
    private final AccountUpdateCallback f4937b;

    /* renamed from: c */
    private final boolean f4938c;

    public AccountUpdateTask(CheckEnvironment checkEnvironment, AccountUpdateCallback accountUpdateCallback) {
        this.f4936a = checkEnvironment;
        this.f4937b = accountUpdateCallback;
        this.f4938c = accountUpdateCallback.isDownloadOnly();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Exception} */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Exception] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p000.C1249id doInBackground(p006nl.volkerinfradesign.checkandroid.environments.Account... r7) {
        /*
            r6 = this;
            r1 = 0
            r0 = 0
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            r2 = r7[r0]
            java.lang.String r3 = "session"
            nl.volkerinfradesign.checkandroid.AppState r5 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
            com.google.gson.JsonObject r5 = r5.getSIDJSON()
            r4.add(r3, r5)
            boolean r3 = r6.f4938c
            if (r3 != 0) goto L_0x0023
            java.lang.String r3 = "content"
            com.google.gson.JsonObject r2 = r6.m6028a((p006nl.volkerinfradesign.checkandroid.environments.Account) r2)
            r4.add(r3, r2)
        L_0x0023:
            r2 = r0
            r3 = r1
        L_0x0025:
            r0 = 3
            if (r2 >= r0) goto L_0x00e4
            boolean r0 = r6.f4938c     // Catch:{ Exception -> 0x00b0 }
            if (r0 == 0) goto L_0x0098
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00b0 }
            java.net.URL r0 = r0.getUserGETUrl()     // Catch:{ Exception -> 0x00b0 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00b0 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b0 }
            r1 = r0
        L_0x003b:
            r0 = 1
            r1.setDoInput(r0)     // Catch:{ Exception -> 0x00b0 }
            r0 = 1
            r1.setDoOutput(r0)     // Catch:{ Exception -> 0x00b0 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00a8 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x00a8 }
            org.apache.commons.p009io.IOUtils.write((byte[]) r0, (java.io.OutputStream) r3)     // Catch:{ all -> 0x00a8 }
            r3.flush()     // Catch:{ Exception -> 0x00b0 }
            r3.close()     // Catch:{ Exception -> 0x00b0 }
            java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r0 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r0)     // Catch:{ Exception -> 0x00b0 }
            com.google.gson.JsonParser r3 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00b0 }
            r3.<init>()     // Catch:{ Exception -> 0x00b0 }
            com.google.gson.JsonElement r0 = r3.parse((java.lang.String) r0)     // Catch:{ Exception -> 0x00b0 }
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r3 = "userInfo"
            com.google.gson.JsonElement r0 = r0.get(r3)     // Catch:{ Exception -> 0x00b0 }
            com.google.gson.JsonObject r3 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r0 = "theme"
            com.google.gson.JsonElement r0 = r3.get(r0)     // Catch:{ Exception -> 0x00b0 }
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r5 = "companyPictureUrl"
            com.google.gson.JsonElement r0 = r0.get(r5)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x00b0 }
            java.io.File r5 = r6.m6029a((java.lang.String) r0)     // Catch:{ Exception -> 0x00b0 }
            id r0 = new id     // Catch:{ Exception -> 0x00b0 }
            r0.<init>((com.google.gson.JsonObject) r3, (java.io.File) r5)     // Catch:{ Exception -> 0x00b0 }
            org.apache.commons.p009io.IOUtils.close(r1)
        L_0x0097:
            return r0
        L_0x0098:
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00b0 }
            java.net.URL r0 = r0.getUserPOSTUrl()     // Catch:{ Exception -> 0x00b0 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00b0 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b0 }
            r1 = r0
            goto L_0x003b
        L_0x00a8:
            r0 = move-exception
            r3.flush()     // Catch:{ Exception -> 0x00b0 }
            r3.close()     // Catch:{ Exception -> 0x00b0 }
            throw r0     // Catch:{ Exception -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x00d4 }
            java.io.InputStream r5 = r1.getErrorStream()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r5)     // Catch:{ Exception -> 0x00d4 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00d4 }
        L_0x00be:
            if (r1 == 0) goto L_0x00d7
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x00df }
            boolean r0 = r0.hasValidSession(r1)     // Catch:{ all -> 0x00df }
            if (r0 != 0) goto L_0x00d7
            id r0 = new id     // Catch:{ all -> 0x00df }
            r2 = 1
            r0.<init>((boolean) r2, (java.lang.Exception) r3)     // Catch:{ all -> 0x00df }
            org.apache.commons.p009io.IOUtils.close(r1)
            goto L_0x0097
        L_0x00d4:
            r3 = move-exception
            r3 = r0
            goto L_0x00be
        L_0x00d7:
            org.apache.commons.p009io.IOUtils.close(r1)
            int r0 = r2 + 1
            r2 = r0
            goto L_0x0025
        L_0x00df:
            r0 = move-exception
            org.apache.commons.p009io.IOUtils.close(r1)
            throw r0
        L_0x00e4:
            id r0 = new id
            r0.<init>(r3)
            goto L_0x0097
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateTask.doInBackground(nl.volkerinfradesign.checkandroid.environments.Account[]):id");
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.f4937b != null) {
            this.f4937b.onUpdateStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled(C1249id idVar) {
        super.onCancelled(idVar);
        if (this.f4937b != null) {
            this.f4937b.onUpdateFailed(idVar != null ? idVar.f4384d : null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(C1249id idVar) {
        super.onPostExecute(idVar);
        if (this.f4937b == null) {
            return;
        }
        if (idVar.f4385e) {
            this.f4937b.onSessionExpired(idVar.f4384d);
        } else if (idVar.f4381a) {
            this.f4937b.onUpdateSuccess(idVar.f4382b, idVar.f4383c);
        } else {
            this.f4937b.onUpdateFailed(idVar.f4384d);
        }
    }

    /* renamed from: a */
    private JsonObject m6028a(Account account) {
        Long l = null;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", account.getEmail());
        jsonObject.addProperty("firstName", account.getFirstName());
        jsonObject.addProperty("middleName", account.getMiddleName());
        jsonObject.addProperty("lastName", account.getLastName());
        jsonObject.addProperty("phoneMobile", account.getPhoneMobile());
        jsonObject.addProperty("birthDate", (Number) account.hasBirthDay() ? Long.valueOf(account.getBirthDay().getTimeInMillis()) : null);
        jsonObject.addProperty("vcaNumber", account.getVcaNumber());
        jsonObject.addProperty(Account.MODIFIED, (Number) Long.valueOf(account.getModified()));
        if (account.hasChief()) {
            l = Long.valueOf(account.getChief().getId());
        }
        jsonObject.addProperty("chiefId", (Number) l);
        return jsonObject;
    }

    /* renamed from: a */
    private File m6029a(String str) {
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(new File(App.getInternalFilesDir() + "/logos"), "companylogo.png");
            inputStream = new URL(str).openStream();
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    IOUtils.copy(inputStream, (OutputStream) fileOutputStream3);
                    fileOutputStream3.flush();
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((OutputStream) fileOutputStream3);
                    return file;
                } catch (IOException e) {
                    fileOutputStream = fileOutputStream3;
                    inputStream2 = inputStream;
                    IOUtils.closeQuietly(inputStream2);
                    IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                    throw th;
                }
            } catch (IOException e2) {
                fileOutputStream = null;
                inputStream2 = inputStream;
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                throw th;
            }
        } catch (IOException e3) {
            fileOutputStream = null;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly((OutputStream) fileOutputStream2);
            throw th;
        }
    }
}
