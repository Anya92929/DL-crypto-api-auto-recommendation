package p006nl.volkerinfradesign.checkandroid.services.logout;

import android.os.AsyncTask;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;

/* renamed from: nl.volkerinfradesign.checkandroid.services.logout.LogoutTask */
public final class LogoutTask extends AsyncTask<JsonElement, Object, C1251if> {

    /* renamed from: a */
    private final LogoutCallback f4941a;

    public LogoutTask(LogoutCallback logoutCallback) {
        this.f4941a = logoutCallback;
    }

    /* renamed from: a */
    private byte[] m6030a(JsonElement jsonElement) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("session", jsonElement);
        return jsonObject.toString().getBytes();
    }

    /* access modifiers changed from: protected */
    public C1251if doInBackground(JsonElement[] jsonElementArr) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        byte[] a = m6030a(jsonElementArr[0]);
        int i = 0;
        Exception exc = null;
        while (i < 3) {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getLogoutUrl().openConnection();
                try {
                    httpURLConnection2.setFixedLengthStreamingMode(a.length);
                    httpURLConnection2.setDoOutput(true);
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(a);
                    outputStream.flush();
                    outputStream.close();
                    C1251if ifVar = new C1251if();
                    IOUtils.close(httpURLConnection2);
                    return ifVar;
                } catch (Exception e) {
                    Exception exc2 = e;
                    httpURLConnection = httpURLConnection2;
                    e = exc2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                    IOUtils.close(httpURLConnection);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    exc = new IOException(IOUtils.toString(httpURLConnection.getErrorStream()));
                } catch (Exception e3) {
                    exc = e;
                }
                if (httpURLConnection != null) {
                    try {
                        if (!AppState.getInstance().hasValidSession(httpURLConnection)) {
                            C1251if ifVar2 = new C1251if(true, exc);
                            IOUtils.close(httpURLConnection);
                            return ifVar2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        IOUtils.close(httpURLConnection);
                        throw th;
                    }
                }
                IOUtils.close(httpURLConnection);
                i++;
            }
        }
        return new C1251if(exc);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.f4941a != null) {
            this.f4941a.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled(C1251if ifVar) {
        super.onCancelled(ifVar);
        if (this.f4941a != null) {
            this.f4941a.onError(ifVar != null ? ifVar.f4391c : null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(C1251if ifVar) {
        super.onPostExecute(ifVar);
        if (this.f4941a == null) {
            return;
        }
        if (ifVar.f4389a) {
            this.f4941a.onSuccess();
        } else if (ifVar.f4390b) {
            this.f4941a.onSessionExpired(ifVar.f4391c);
        } else {
            this.f4941a.onError(ifVar.f4391c);
        }
    }
}
