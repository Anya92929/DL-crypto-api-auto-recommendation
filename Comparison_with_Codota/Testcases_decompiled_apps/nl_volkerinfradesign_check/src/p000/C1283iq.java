package p000;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.MainActivity;

/* renamed from: iq */
public final class C1283iq extends AsyncTask<String, Void, C1282ip> {

    /* renamed from: a */
    final C1282ip f4492a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MainActivity f4493b;

    public C1283iq(MainActivity mainActivity) {
        this.f4493b = mainActivity;
        this.f4492a = new C1282ip((Context) mainActivity);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p000.C1282ip doInBackground(java.lang.String... r8) {
        /*
            r7 = this;
            r2 = 0
            nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
            nl.volkerinfradesign.checkandroid.environments.Model r0 = r0.getModel()
            nl.volkerinfradesign.checkandroid.environments.Logger r4 = r0.getLogger()
            java.lang.String r0 = "https://androidquery.appspot.com/api/market?app="
            r0 = 0
            r0 = r8[r0]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            r1.<init>()     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.lang.String r3 = "https://androidquery.appspot.com/api/market?app="
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.nio.charset.Charset r3 = org.apache.commons.p009io.Charsets.UTF_8     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.lang.String r3 = r3.name()     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r3)     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0071, all -> 0x009e }
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            java.lang.String r1 = "PUT"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r0.connect()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            java.lang.String r1 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r1)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            com.google.gson.JsonParser r3 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r3.<init>()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            com.google.gson.JsonElement r1 = r3.parse((java.lang.String) r1)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            java.lang.String r3 = "version"
            com.google.gson.JsonElement r1 = r1.get(r3)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            java.lang.String r3 = r1.getAsString()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            ip r1 = new ip     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r1.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            if (r0 == 0) goto L_0x006f
            r0.disconnect()
        L_0x006f:
            r0 = r1
        L_0x0070:
            return r0
        L_0x0071:
            r0 = move-exception
            r1 = r2
        L_0x0073:
            java.io.InputStream r3 = r1.getErrorStream()     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r3)     // Catch:{ Exception -> 0x008c }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ Exception -> 0x008c }
            r5.<init>(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = "Error in retrieving version."
            r4.logError(r3, r5)     // Catch:{ Exception -> 0x008c }
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r1.disconnect()
        L_0x008a:
            r0 = r2
            goto L_0x0070
        L_0x008c:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = "Error in retrieving version."
            r4.logError(r3, r0)     // Catch:{ all -> 0x0096 }
            goto L_0x0085
        L_0x0096:
            r0 = move-exception
            r2 = r1
        L_0x0098:
            if (r2 == 0) goto L_0x009d
            r2.disconnect()
        L_0x009d:
            throw r0
        L_0x009e:
            r0 = move-exception
            goto L_0x0098
        L_0x00a0:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0098
        L_0x00a4:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0073
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1283iq.doInBackground(java.lang.String[]):ip");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C1282ip ipVar) {
        super.onPostExecute(ipVar);
        try {
            if (this.f4492a != null && this.f4492a.compareTo(ipVar) < 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f4493b);
                builder.setTitle("Nieuwe versie beschikbaar");
                builder.setMessage("Er is een nieuwe versie beschikbaar. Wilt u nu updaten? Verzend voor dat u update al uw formulieren.");
                builder.setPositiveButton("Nu updaten", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            C1283iq.this.f4493b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + C1283iq.this.f4493b.getPackageName())));
                        } catch (ActivityNotFoundException e) {
                            C1283iq.this.f4493b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + C1283iq.this.f4493b.getPackageName())));
                        }
                        dialogInterface.dismiss();
                        C1283iq.this.f4493b.finish();
                    }
                });
                builder.setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        } catch (Exception e) {
            AppState.getInstance().getModel().getLogger().logError("Error in retrieving version.", e);
        }
    }
}
