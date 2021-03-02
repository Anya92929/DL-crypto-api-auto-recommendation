package p000;

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.database.InspectionConstants;
import p006nl.volkerinfradesign.checkandroid.environments.Logger;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;
import p010uk.p011co.senab.photoview.IPhotoView;

/* renamed from: ic */
public final class C1245ic extends Table implements Logger {

    /* renamed from: a */
    private static final SimpleDateFormat f4372a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: c */
    private static final TypeAdapter<Throwable> f4373c = new TypeAdapter<Throwable>() {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, Throwable th) throws IOException {
            StackTraceElement[] stackTrace = th.getStackTrace();
            String message = th.getMessage();
            jsonWriter.beginObject();
            jsonWriter.name("class").value(th.getClass().getName());
            jsonWriter.name("message");
            if (message != null) {
                jsonWriter.value(message);
            } else {
                jsonWriter.nullValue();
            }
            jsonWriter.name("trace");
            jsonWriter.beginArray();
            for (StackTraceElement stackTraceElement : stackTrace) {
                jsonWriter.beginObject();
                jsonWriter.name(InspectionConstants.FILE).value(stackTraceElement.getFileName());
                jsonWriter.name("class").value(stackTraceElement.getClassName());
                jsonWriter.name("method").value(stackTraceElement.getMethodName());
                jsonWriter.name("line").value((long) stackTraceElement.getLineNumber());
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }

        /* renamed from: a */
        public Throwable read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException();
        }
    };

    /* renamed from: d */
    private final Model f4374d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Gson f4375e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Gson f4376f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ListOrderedSet<C1248a> f4377g = new ListOrderedSet<>();

    public C1245ic(Model model) {
        super("logger");
        this.f4374d = model;
        GsonBuilder registerTypeAdapter = new GsonBuilder().serializeNulls().registerTypeAdapter(Throwable.class, f4373c);
        this.f4375e = registerTypeAdapter.create();
        this.f4376f = registerTypeAdapter.setPrettyPrinting().create();
        putColumn("verbosity", Column.DataType.TEXT).notNull();
        putColumn("message", Column.DataType.TEXT).notNull();
        putColumn("throwable", Column.DataType.TEXT);
        putColumn("creation_date", Column.DataType.INTEGER);
    }

    public void logError(String str, Throwable th) {
        m5539a(Logger.Verbosity.ERROR, str, th);
    }

    public void info(String str) {
        m5539a(Logger.Verbosity.INFO, str, (Throwable) null);
    }

    public Logger.LogCursor get(Logger.Verbosity... verbosityArr) {
        String[] strArr;
        String str;
        boolean z;
        if (ArrayUtils.isEmpty((Object[]) verbosityArr)) {
            strArr = null;
            str = null;
        } else {
            int length = verbosityArr.length;
            strArr = new String[length];
            String str2 = "(";
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    z = true;
                } else {
                    z = false;
                }
                strArr[i] = verbosityArr[i].name();
                str2 = str2 + (z ? "?)" : "?, ");
            }
            str = "verbosity in " + str2;
        }
        return (Logger.LogCursor) query((String[]) null, str, strArr, (String) null, (String) null, "creation_date desc");
    }

    public File writeReport(File file) throws IOException {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1248a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: a */
    private void m5539a(Logger.Verbosity verbosity, String str, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("verbosity", verbosity.name());
        contentValues.put("message", str);
        contentValues.put("creation_date", Long.valueOf(System.currentTimeMillis()));
        if (th != null) {
            contentValues.put("throwable", this.f4375e.toJson((Object) th, (Type) Throwable.class));
        }
        delete(String.format("%s < (select max(%s) from %s) - %d", new Object[]{"_id", "_id", "logger", Integer.valueOf(IPhotoView.DEFAULT_ZOOM_DURATION)}), (String[]) null);
        insertOrThrow(contentValues);
    }

    /* renamed from: ic$a */
    final class C1248a extends ViTaCursor.Instance implements Logger.LogCursor {

        /* renamed from: b */
        private final JsonParser f4380b = new JsonParser();

        public C1248a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
            C1245ic.this.f4377g.add(this);
        }

        public String getMessage() {
            return getString("message");
        }

        public String getThrowable(boolean z, boolean z2) {
            JsonObject asJsonObject = this.f4380b.parse(getString("throwable")).getAsJsonObject();
            if (!z) {
                asJsonObject.remove("trace");
            }
            return z2 ? C1245ic.this.f4376f.toJson((JsonElement) asJsonObject) : C1245ic.this.f4375e.toJson((JsonElement) asJsonObject);
        }

        public Logger.Verbosity getVerbosity() {
            return Logger.Verbosity.valueOf(getString("verbosity"));
        }

        public boolean hasThrowable() {
            return !isNull("throwable");
        }

        public void close() {
            C1245ic.this.f4377g.remove((Object) this);
            super.close();
        }
    }
}
