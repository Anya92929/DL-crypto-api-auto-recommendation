package p006nl.volkerinfradesign.checkandroid.services.tasks;

import android.os.AsyncTask;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.environments.Account;

/* renamed from: nl.volkerinfradesign.checkandroid.services.tasks.TasksService */
public final class TasksService extends AsyncTask<TasksParam, Void, C1252ig> {

    /* renamed from: a */
    private final TasksCallback f4942a;

    public TasksService(TasksCallback tasksCallback) {
        this.f4942a = tasksCallback;
    }

    public static void download(TasksParam tasksParam, TasksCallback tasksCallback) {
        m6032a(download(tasksParam), tasksCallback);
    }

    public static C1252ig download(TasksParam tasksParam) {
        HttpURLConnection httpURLConnection;
        Exception exc;
        OutputStream outputStream;
        byte[] bytes = m6031a(tasksParam).toString().getBytes();
        int i = 0;
        Exception exc2 = null;
        while (i < 3) {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getTasksPOSTUrl().openConnection();
                try {
                    httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    outputStream.close();
                    JsonArray validateResponse = validateResponse(IOUtils.toString(httpURLConnection2.getInputStream()));
                    filterInvalidTasks(validateResponse);
                    C1252ig igVar = new C1252ig(validateResponse);
                    IOUtils.close(httpURLConnection2);
                    return igVar;
                } catch (Exception e) {
                    Exception exc3 = e;
                    httpURLConnection = httpURLConnection2;
                    e = exc3;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                    IOUtils.close(httpURLConnection);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
                try {
                    exc = new IOException(IOUtils.toString(httpURLConnection.getErrorStream()));
                } catch (Exception e3) {
                    exc = e;
                }
                if (httpURLConnection != null) {
                    try {
                        if (!AppState.getInstance().hasValidSession(httpURLConnection)) {
                            C1252ig igVar2 = new C1252ig(true, exc);
                            IOUtils.close(httpURLConnection);
                            return igVar2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        IOUtils.close(httpURLConnection);
                        throw th;
                    }
                }
                IOUtils.close(httpURLConnection);
                i++;
                exc2 = exc;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                IOUtils.close(httpURLConnection);
                throw th;
            }
        }
        return new C1252ig(exc2);
    }

    public static JsonArray validateResponse(String str) {
        JsonElement parse;
        if (!StringUtils.isNotBlank(str) || (parse = new JsonParser().parse(str)) == null || !parse.isJsonArray()) {
            return new JsonArray();
        }
        return parse.getAsJsonArray();
    }

    public static JsonElement filterInvalidTasks(JsonArray jsonArray) {
        JsonArray jsonArray2 = new JsonArray();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            if (next.isJsonObject()) {
                JsonObject asJsonObject = next.getAsJsonObject();
                if (asJsonObject.has("title") && asJsonObject.has("id") && asJsonObject.has("companyId") && asJsonObject.has(Account.MODIFIED)) {
                }
            }
            jsonArray2.add(next);
            it.remove();
        }
        return jsonArray2;
    }

    /* access modifiers changed from: protected */
    public C1252ig doInBackground(TasksParam... tasksParamArr) {
        return download(tasksParamArr[0]);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.f4942a != null) {
            this.f4942a.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled(C1252ig igVar) {
        super.onCancelled(igVar);
        if (this.f4942a != null) {
            this.f4942a.onError(igVar != null ? igVar.f4395d : null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(C1252ig igVar) {
        super.onPostExecute(igVar);
        m6032a(igVar, this.f4942a);
    }

    /* renamed from: a */
    private static void m6032a(C1252ig igVar, TasksCallback tasksCallback) {
        if (tasksCallback == null) {
            return;
        }
        if (igVar.f4393b) {
            tasksCallback.onSessionExpired(igVar.f4395d);
        } else if (igVar.f4392a) {
            tasksCallback.onSuccess(igVar.f4394c);
        } else {
            tasksCallback.onError(igVar.f4395d);
        }
    }

    /* renamed from: a */
    private static JsonObject m6031a(TasksParam tasksParam) {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("finishActions", tasksParam.finishedTasks);
        jsonObject3.add("delegateActions", tasksParam.delegatedTasks);
        jsonObject.add("session", AppState.getInstance().getSIDJSON());
        jsonObject.add("params", jsonObject2);
        jsonObject.add("content", jsonObject3);
        return jsonObject;
    }
}
