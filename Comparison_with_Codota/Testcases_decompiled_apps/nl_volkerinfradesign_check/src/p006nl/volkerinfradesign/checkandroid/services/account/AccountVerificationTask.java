package p006nl.volkerinfradesign.checkandroid.services.account;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;

/* renamed from: nl.volkerinfradesign.checkandroid.services.account.AccountVerificationTask */
public final class AccountVerificationTask extends AsyncTask<String, Void, C1250ie> {

    /* renamed from: a */
    private final AccountVerificationCallback f4939a;

    public AccountVerificationTask(AccountVerificationCallback accountVerificationCallback) {
        this.f4939a = accountVerificationCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.f4939a != null) {
            this.f4939a.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public C1250ie doInBackground(String... strArr) {
        JsonWriter jsonWriter;
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        HttpURLConnection httpURLConnection = null;
        JsonObject jsonObject = new JsonObject();
        String str = strArr[0];
        String str2 = strArr[1];
        C1250ie ieVar = new C1250ie();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("passCode", str2);
        jsonObject2.addProperty("email", str);
        jsonObject.add("params", jsonObject2);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getUserSessionUrl().openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                jsonWriter = new JsonWriter(new OutputStreamWriter(httpURLConnection2.getOutputStream()));
                create.toJson((JsonElement) jsonObject, jsonWriter);
                jsonWriter.close();
                String trim = IOUtils.toString(httpURLConnection2.getInputStream()).trim();
                if (!trim.contains("sessionId") || !trim.contains("userInfo")) {
                    ieVar.f4386a = new NullPointerException("There is no response.");
                } else {
                    JsonObject asJsonObject = new JsonParser().parse(trim).getAsJsonObject();
                    ieVar.f4387b = asJsonObject.get("sessionId").getAsString();
                    ieVar.f4388c = asJsonObject.get("userInfo").getAsJsonObject();
                }
                IOUtils.close(httpURLConnection2);
            } catch (Exception e) {
                Exception exc = e;
                httpURLConnection = httpURLConnection2;
                e = exc;
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
                String iOUtils = IOUtils.toString(httpURLConnection.getErrorStream());
                Matcher matcher = Pattern.compile("<title>(.*)<\\/title>").matcher(iOUtils);
                if (matcher.find() && matcher.groupCount() == 1) {
                    iOUtils = matcher.group(1);
                }
                ieVar.f4386a = new IOException(iOUtils);
            } catch (Exception e3) {
                ieVar.f4386a = e;
            } catch (Throwable th3) {
                th = th3;
            }
            IOUtils.close(httpURLConnection);
            return ieVar;
        }
        return ieVar;
    }

    /* access modifiers changed from: protected */
    public void onCancelled(C1250ie ieVar) {
        super.onCancelled(ieVar);
        if (this.f4939a != null) {
            this.f4939a.onError(ieVar.f4386a);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(C1250ie ieVar) {
        super.onPostExecute(ieVar);
        if (this.f4939a == null) {
            return;
        }
        if (ieVar.f4386a != null) {
            this.f4939a.onError(ieVar.f4386a);
        } else {
            this.f4939a.onSuccess(ieVar.f4388c, ieVar.f4387b);
        }
    }
}
