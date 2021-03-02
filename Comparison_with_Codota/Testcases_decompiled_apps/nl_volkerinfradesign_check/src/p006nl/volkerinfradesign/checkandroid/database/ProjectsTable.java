package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.environments.UpdateResult;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.ProjectsTable */
public class ProjectsTable extends Table {
    public static final String CODE = "code";
    public static final String COMPANY_SERVER_ID = "company_server_id";
    public static final String DELETED = "deleted";
    public static final String MODIFIED_DATE = "mod_date";
    public static final String SERVER_ID = "server_id";
    public static final String TITLE = "title";

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ProjectsTable$ProjectsCursor */
    public interface ProjectsCursor extends ViTaCursor {
        String getCode();

        long getCompanyServerId();

        long getServerId();

        String getTitle();
    }

    ProjectsTable() {
        super("projects");
        putColumn("title", Column.DataType.TEXT);
        putColumn(CODE, Column.DataType.TEXT);
        putColumn("server_id", Column.DataType.TEXT);
        putColumn("company_server_id", Column.DataType.INTEGER);
        putColumn("mod_date", Column.DataType.INTEGER);
        putColumn("deleted", Column.DataType.INTEGER).notNull().defaultValue((Number) 0);
    }

    public String getProjectName(long j) {
        String str = null;
        ViTaCursor query = query(new String[]{"title"}, "server_id = ?", new String[]{Long.toString(j)}, (String) null, (String) null, (String) null, "1");
        try {
            if (query.moveToFirst()) {
                str = query.getString(0);
            }
            return str;
        } finally {
            query.close();
        }
    }

    public ProjectsCursor getProjects(Company company) {
        return (ProjectsCursor) query("company_server_id = ?", new String[]{Long.toString(company.getServerId())}, new String[0]);
    }

    public void insertOrUpdate(ContentValues contentValues, long j) {
        if (Schema.getProjects().update(contentValues, "server_id = ?", new String[]{Long.toString(j)}) == 0) {
            Schema.getProjects().insertWithOnConflict(contentValues, ViTa.ConflictAlogrithm.REPLACE);
        }
    }

    public void putProject(long j, String str, String str2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("company_server_id", Long.valueOf(j2));
        contentValues.put("server_id", Long.valueOf(j));
        contentValues.put("title", str);
        contentValues.put(CODE, str2);
        insertOrUpdate(contentValues, j);
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1473a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ProjectsCursor mo9431a(InspectionKey inspectionKey, CharSequence charSequence) {
        String str = "company_server_id = ? and deleted = 0";
        String[] strArr = {Long.toString(inspectionKey.f4800c)};
        if (charSequence != null && charSequence.length() > 0) {
            String charSequence2 = charSequence.toString();
            str = str + " and (code like '" + charSequence2 + "%' or " + "title" + " like '" + charSequence2 + "%')";
        }
        return (ProjectsCursor) query(str, strArr, new String[0]);
    }

    public UpdateResult update(long j, int i) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String asString;
        long timeInMillis = Calendar.getInstance(Locale.getDefault()).getTimeInMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            Gson create = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jsonObject = new JsonObject();
            int max = Math.max(0, Math.min(i, 10));
            jsonObject.add("session", AppState.getInstance().getSIDJSON());
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("companyId", (Number) Long.valueOf(j));
            jsonObject2.addProperty("limit", (Number) Integer.valueOf(max));
            jsonObject.add("params", jsonObject2);
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) AppState.getInstance().getProjectsGETUrl().openConnection();
            try {
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setRequestProperty("Content-Type", "text/json; charset=utf-8");
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.connect();
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(httpURLConnection3.getOutputStream(), CharEncoding.UTF_8));
                create.toJson((JsonElement) jsonObject, jsonWriter);
                jsonWriter.close();
                JsonArray asJsonArray = ((JsonObject) new JsonParser().parse(new JsonReader(new InputStreamReader(httpURLConnection3.getInputStream())))).get("result").getAsJsonObject().get("projects").getAsJsonArray();
                ListOrderedSet listOrderedSet = new ListOrderedSet();
                Iterator<JsonElement> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    ContentValues contentValues = new ContentValues();
                    JsonObject jsonObject3 = (JsonObject) it.next();
                    long asLong = jsonObject3.get("id").getAsLong();
                    if (jsonObject3.has("title")) {
                        asString = jsonObject3.get("title").getAsString();
                    } else {
                        asString = jsonObject3.get(ActionColumns.DESCRIPTION).getAsString();
                    }
                    String asString2 = jsonObject3.get(CODE).getAsString();
                    contentValues.put("title", asString);
                    contentValues.put(CODE, asString2);
                    contentValues.put("server_id", Long.valueOf(asLong));
                    contentValues.put("company_server_id", Long.valueOf(j));
                    contentValues.put("mod_date", Long.valueOf(timeInMillis));
                    contentValues.put("deleted", 0);
                    if (update(contentValues, "server_id = ?", new String[]{Long.toString(asLong)}) == 0) {
                        Schema.getProjects().insert(contentValues);
                    }
                    listOrderedSet.add(Long.valueOf(asLong));
                }
                ContentValues contentValues2 = new ContentValues();
                String[] strArr = new String[(listOrderedSet.size() + 1)];
                strArr[0] = Long.toString(j);
                contentValues2.put("deleted", 1);
                String str = "(";
                int i2 = 0;
                while (i2 < listOrderedSet.size()) {
                    str = str + (i2 == listOrderedSet.size() + -1 ? "?)" : "?, ");
                    strArr[i2 + 1] = ((Long) listOrderedSet.get(i2)).toString();
                    i2++;
                }
                delete("server_id = 0 or server_id is null", (String[]) null);
                update(contentValues2, "company_server_id = ? and server_id not in " + str, strArr);
                UpdateResultImp updateResultImp = new UpdateResultImp(true, (Exception) null);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.close(httpURLConnection3);
                return updateResultImp;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection3;
                try {
                    AppState.getInstance().invalidateLogin(httpURLConnection);
                    UpdateResultImp updateResultImp2 = new UpdateResultImp(false, e);
                    IOUtils.closeQuietly((InputStream) null);
                    IOUtils.close(httpURLConnection);
                    return updateResultImp2;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    IOUtils.closeQuietly((InputStream) null);
                    IOUtils.close(httpURLConnection2);
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.close(httpURLConnection2);
                throw th;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
            AppState.getInstance().invalidateLogin(httpURLConnection);
            UpdateResultImp updateResultImp22 = new UpdateResultImp(false, e);
            IOUtils.closeQuietly((InputStream) null);
            IOUtils.close(httpURLConnection);
            return updateResultImp22;
        } catch (Throwable th4) {
            th = th4;
            IOUtils.closeQuietly((InputStream) null);
            IOUtils.close(httpURLConnection2);
            throw th;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ProjectsTable$a */
    class C1473a extends ViTaCursor.Instance implements ProjectsCursor {
        public C1473a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public String getCode() {
            return getString(ProjectsTable.CODE);
        }

        public long getCompanyServerId() {
            return getLong("company_server_id");
        }

        public long getServerId() {
            return getLong("server_id");
        }

        public String getTitle() {
            return getString("title");
        }
    }
}
