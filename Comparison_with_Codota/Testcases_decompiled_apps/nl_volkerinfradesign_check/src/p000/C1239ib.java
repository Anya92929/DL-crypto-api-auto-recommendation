package p000;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentValues;
import android.database.CursorWindow;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.Theme;
import p006nl.volkerinfradesign.checkandroid.environments.UpdateResult;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.AccountInfoStep;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.AccountKeyImp;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.CheckEnvironment;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.ProfileImp;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ColumnEditor;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

@Deprecated
/* renamed from: ib */
public final class C1239ib extends Table implements Accounts {

    /* renamed from: a */
    final AccountManager f4361a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final CheckEnvironment f4362c;

    /* renamed from: d */
    private final Handler f4363d;

    /* renamed from: e */
    private final C1244b f4364e = new C1244b() {

        /* renamed from: b */
        private final String[] f4367b = {Accounts.VerificationStep.E_CODE_SENT.ordinalString()};

        /* renamed from: c */
        private final String f4368c = "verification_step < ?";

        /* renamed from: a */
        public int mo8501a(ContentValues contentValues) {
            return C1239ib.this.update(contentValues, "verification_step < ?", this.f4367b);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final DataSetObservable f4365f = new DataSetObservable();

    /* renamed from: ib$b */
    interface C1244b {
        /* renamed from: a */
        int mo8501a(ContentValues contentValues);
    }

    public C1239ib(CheckEnvironment checkEnvironment) {
        super("accounts_table");
        this.f4362c = checkEnvironment;
        this.f4361a = AccountManager.get(checkEnvironment.params.context);
        this.f4363d = new Handler(checkEnvironment.params.context.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case -2:
                        C1239ib.this.f4365f.notifyInvalidated();
                        return;
                    case -1:
                        C1239ib.this.f4365f.notifyChanged();
                        return;
                    default:
                        return;
                }
            }
        };
        putColumn("email", Column.DataType.TEXT);
        putColumn("type", Column.DataType.TEXT);
        putColumn("item_type_ordinal", Column.DataType.INTEGER).notNull();
        putColumn("creation_date", Column.DataType.INTEGER).notNull();
        putColumn("account_fingerprint", Column.DataType.TEXT).notNull();
        putColumn("verification_step", Column.DataType.INTEGER).notNull().defaultValue((Number) Integer.valueOf(Accounts.VerificationStep.A_PENDING_VERIFICATION.ordinal()));
        putColumn("selected", Column.DataType.INTEGER).notNull().defaultValue((Boolean) false);
        putColumn("first_name", Column.DataType.TEXT);
        putColumn("middle_name", Column.DataType.TEXT);
        putColumn("last_name", Column.DataType.TEXT);
        putColumn("vca_number", Column.DataType.TEXT);
        putColumn("phone_mobile", Column.DataType.TEXT);
        putColumn("birth_day", Column.DataType.INTEGER);
        putColumn("account_info_modified", Column.DataType.INTEGER).notNull().defaultValue(ColumnEditor.LiteralValue.CURRENT_TIMESTAMP);
        putColumn("account_info_updated", Column.DataType.INTEGER).notNull().defaultValue((Number) Integer.valueOf(AccountInfoStep.A_INITIAL_VALUES.ordinal()));
        putColumn("server_id", Column.DataType.INTEGER);
        putColumn("theme_color", Column.DataType.TEXT);
        putColumn("help_number", Column.DataType.TEXT);
        putColumn("company_logo_local", Column.DataType.TEXT);
        putColumn("company_logo_ext", Column.DataType.TEXT);
        putColumn("person_in_charge_name", Column.DataType.TEXT);
        putColumn("person_in_charge_email", Column.DataType.TEXT);
        putColumn("person_in_charge_id", Column.DataType.INTEGER);
    }

    public Accounts.AccountKey addUser(String str) {
        String trim = str.trim();
        ViTaCursor query = query("email = ? and item_type_ordinal = ?", new String[]{trim, Integer.toString(Accounts.AccontRecordType.D_CUSTOM_CHILD.ordinal())}, new String[0]);
        try {
            if (!query.moveToFirst()) {
                ContentValues contentValues = new ContentValues(5);
                contentValues.put("email", trim);
                contentValues.put("item_type_ordinal", Integer.valueOf(Accounts.AccontRecordType.D_CUSTOM_CHILD.ordinal()));
                contentValues.put("creation_date", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("type", this.f4362c.params.accountType);
                contentValues.put("account_fingerprint", Base64.encodeToString((trim + this.f4362c.params.accountType).getBytes(), 0));
                AccountKeyImp accountKeyImp = new AccountKeyImp(this.f4362c.params, insertOrThrow(contentValues));
                this.f4363d.sendEmptyMessage(-1);
                return accountKeyImp;
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    public boolean exists(String str) {
        ViTaCursor query = query("email = ? and item_type_ordinal = ?", new String[]{str, Integer.toString(Accounts.AccontRecordType.D_CUSTOM_CHILD.ordinal())}, new String[0]);
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    public Accounts.AccountCursor getAll() {
        return (Accounts.AccountCursor) query((String[]) null, (String) null, (String[]) null, (String) null, (String) null, "item_type_ordinal, email, type, creation_date DESC, _id");
    }

    public Accounts.AccountKey getKey(long j) {
        return new AccountKeyImp(this.f4362c.params, j);
    }

    public Accounts.AccountKey getKey(String str) {
        Accounts.AccountCursor accountCursor = (Accounts.AccountCursor) query((String[]) null, "email = ?", new String[]{str}, (String) null, (String) null, "item_type_ordinal, email, type, creation_date DESC, _id", "1");
        try {
            if (accountCursor.moveToFirst()) {
                return accountCursor.getKey();
            }
            throw new IllegalArgumentException("The email is not available in the database!");
        } finally {
            accountCursor.close();
        }
    }

    public Accounts.AccountCursor getSelected() {
        return (Accounts.AccountCursor) query("selected", (String[]) null, new String[0]);
    }

    public boolean hasPending() {
        ViTaCursor query = query(new String[]{"_id"}, "(item_type_ordinal = ? or item_type_ordinal = ?) and verification_step = ?", new String[]{Accounts.AccontRecordType.B_DEVICE_CHILD.ordinalString(), Accounts.AccontRecordType.D_CUSTOM_CHILD.ordinalString(), Accounts.VerificationStep.A_PENDING_VERIFICATION.ordinalString()}, (String) null, (String) null, (String) null, "1");
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    public boolean hasSelected() {
        ViTaCursor query = query("selected", (String[]) null, new String[0]);
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    public boolean invalidateAccounts() {
        boolean z = false;
        boolean z2 = m5524f() || mo8477a();
        if (z2) {
            this.f4363d.sendEmptyMessage(-1);
        }
        if (m5525g() || z2) {
            z = true;
        }
        if (z) {
            this.f4363d.sendEmptyMessage(-1);
        }
        if (z) {
            this.f4363d.sendEmptyMessage(-1);
        }
        return z;
    }

    public boolean isEmpty() {
        boolean z = true;
        ViTaCursor query = query("item_type_ordinal = ? or item_type_ordinal = ?", new String[]{Integer.toString(Accounts.AccontRecordType.B_DEVICE_CHILD.ordinal()), Integer.toString(Accounts.AccontRecordType.D_CUSTOM_CHILD.ordinal())}, "_id");
        try {
            if (query.moveToFirst()) {
                z = false;
            }
            return z;
        } finally {
            query.close();
        }
    }

    public void registerObserver(DataSetObserver dataSetObserver) {
        this.f4365f.registerObserver(dataSetObserver);
    }

    public void removeAccount(Accounts.AccountCursor accountCursor) {
        if (delete("_id = ?", new String[]{Long.toString(accountCursor.getId())}) > 0) {
            this.f4363d.sendEmptyMessage(-1);
        }
    }

    public boolean removeAccounts(long... jArr) {
        boolean z = true;
        if (jArr == null || jArr.length <= 0) {
            return false;
        }
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(jArr);
        if (delete("_id in " + argumenter.getSelection(true), argumenter.getSelectionArgs()) <= 0) {
            z = false;
        }
        if (isEmpty()) {
            this.f4363d.sendEmptyMessage(-2);
            return z;
        }
        this.f4363d.sendEmptyMessage(-1);
        return z;
    }

    public String requestAccountCode(String str) {
        JsonWriter jsonWriter;
        HttpURLConnection httpURLConnection = null;
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();
        new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("email", str);
        jsonObject.add("params", jsonObject2);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getPassCodeUrl().openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                jsonWriter = new JsonWriter(new OutputStreamWriter(httpURLConnection2.getOutputStream()));
                create.toJson((JsonElement) jsonObject, jsonWriter);
                jsonWriter.close();
                if (IOUtils.toString(httpURLConnection2.getInputStream()).trim().equals("OK")) {
                    IOUtils.close(httpURLConnection2);
                    return "OK";
                }
                IOUtils.close(httpURLConnection2);
                return null;
            } catch (IOException e) {
                httpURLConnection = httpURLConnection2;
                try {
                    String headerField = httpURLConnection.getHeaderField("X-Error-Message");
                    IOUtils.close(httpURLConnection);
                    return headerField;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.close(httpURLConnection);
                    throw th;
                }
            } catch (Exception e2) {
                httpURLConnection = httpURLConnection2;
                IOUtils.close(httpURLConnection);
                return "Unknown error, check internet connection";
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                IOUtils.close(httpURLConnection);
                throw th;
            }
        } catch (IOException e3) {
            String headerField2 = httpURLConnection.getHeaderField("X-Error-Message");
            IOUtils.close(httpURLConnection);
            return headerField2;
        } catch (Exception e4) {
            IOUtils.close(httpURLConnection);
            return "Unknown error, check internet connection";
        }
    }

    public void setSelected(Accounts.AccountKey accountKey) {
        ContentValues contentValues = new ContentValues(1);
        Long e = m5523e();
        contentValues.put("selected", 0);
        update(contentValues, (String) null, (String[]) null);
        contentValues.put("selected", 1);
        update(contentValues, "_id = ?", new String[]{Long.toString(accountKey.getId())});
        if (e == null || e.longValue() != accountKey.getId()) {
            mo8480b();
        }
    }

    public void unregisterObserver(DataSetObserver dataSetObserver) {
        this.f4365f.unregisterObserver(dataSetObserver);
    }

    public synchronized UpdateResult downloadAccountInfo() {
        return m5510a(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0144, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0145, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0148, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0149, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x014a, code lost:
        r14 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0172, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0176, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0177, code lost:
        r1 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0177 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v7 java.net.HttpURLConnection) = (r2v5 java.net.HttpURLConnection), (r2v14 java.net.HttpURLConnection), (r2v14 java.net.HttpURLConnection), (r2v14 java.net.HttpURLConnection), (r2v14 java.net.HttpURLConnection), (r2v14 java.net.HttpURLConnection), (r2v14 java.net.HttpURLConnection), (r2v5 java.net.HttpURLConnection) binds: [B:31:0x0134, B:17:0x00ee, B:19:0x00f1, B:20:?, B:47:0x0173, B:25:0x0127, B:26:?, B:14:0x00c9] A[DONT_GENERATE, DONT_INLINE], Splitter:B:14:0x00c9] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p006nl.volkerinfradesign.checkandroid.environments.UpdateResult m5510a(boolean r16) {
        /*
            r15 = this;
            r8 = 0
            r9 = 0
            r7 = 0
            com.google.gson.GsonBuilder r0 = new com.google.gson.GsonBuilder
            r0.<init>()
            com.google.gson.GsonBuilder r0 = r0.serializeNulls()
            java.lang.Class<nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp> r1 = p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp.class
            com.google.gson.JsonDeserializer<nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp> r2 = p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp.DESERIALIZER
            com.google.gson.GsonBuilder r0 = r0.registerTypeAdapter(r1, r2)
            com.google.gson.GsonBuilder r0 = r0.setPrettyPrinting()
            com.google.gson.Gson r10 = r0.create()
            com.google.gson.JsonObject r11 = new com.google.gson.JsonObject
            r11.<init>()
            r1 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "email"
            r5 = 0
            r6 = 0
            r0 = r15
            nl.volkerinfradesign.checkandroid.tables.ViTaCursor r0 = r0.query(r1, r2, r3, r4, r5, r6)
            ib$a r0 = (p000.C1239ib.C1243a) r0
            java.lang.String r1 = "session"
            nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
            com.google.gson.JsonObject r2 = r2.getSIDJSON()
            r11.add(r1, r2)
            r1 = 0
            r4 = r1
            r2 = r7
            r3 = r8
        L_0x0040:
            boolean r1 = r0.moveToPosition(r4)     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x017c
            java.lang.String r1 = r0.getEmail()     // Catch:{ all -> 0x016b }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x0058
            r1 = r2
            r2 = r3
        L_0x0052:
            int r3 = r4 + 1
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x0040
        L_0x0058:
            if (r16 != 0) goto L_0x00c7
            com.google.gson.JsonObject r5 = new com.google.gson.JsonObject     // Catch:{ all -> 0x016b }
            r5.<init>()     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "email"
            java.lang.String r6 = r0.getEmail()     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "firstName"
            java.lang.String r6 = r0.getFirstName()     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "middleName"
            java.lang.String r6 = r0.getMiddleName()     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "lastName"
            java.lang.String r6 = r0.getLastName()     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "phoneMobile"
            java.lang.String r6 = r0.getPhoneMobile()     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "birthDate"
            long r6 = r0.getBirthDayMillis()     // Catch:{ all -> 0x016b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.Number) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "vcaNumber"
            java.lang.String r6 = r0.getVcaNumber()     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "modified"
            long r6 = r0.m5534c()     // Catch:{ all -> 0x016b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x016b }
            r5.addProperty((java.lang.String) r1, (java.lang.Number) r6)     // Catch:{ all -> 0x016b }
            java.lang.String r6 = "chiefId"
            boolean r1 = r0.mo8505b()     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x0132
            long r12 = r0.mo8504a()     // Catch:{ all -> 0x016b }
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x016b }
        L_0x00bf:
            r5.addProperty((java.lang.String) r6, (java.lang.Number) r1)     // Catch:{ all -> 0x016b }
            java.lang.String r1 = "content"
            r11.add(r1, r5)     // Catch:{ all -> 0x016b }
        L_0x00c7:
            if (r16 == 0) goto L_0x0134
            nl.volkerinfradesign.checkandroid.AppState r1 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.net.URL r1 = r1.getUserGETUrl()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r2 = r1
        L_0x00d8:
            r1 = 1
            r2.setDoInput(r1)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r1 = 1
            r2.setDoOutput(r1)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            com.google.gson.stream.JsonWriter r1 = new com.google.gson.stream.JsonWriter     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.io.OutputStream r6 = r2.getOutputStream()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r10.toJson((com.google.gson.JsonElement) r11, (com.google.gson.stream.JsonWriter) r1)     // Catch:{ all -> 0x0144 }
            r1.close()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.lang.String r1 = org.apache.commons.p009io.IOUtils.toString((java.io.InputStream) r1)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            com.google.gson.stream.JsonReader r5 = new com.google.gson.stream.JsonReader     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.io.StringReader r6 = new java.io.StringReader     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            com.google.gson.JsonParser r1 = new com.google.gson.JsonParser     // Catch:{ all -> 0x0172 }
            r1.<init>()     // Catch:{ all -> 0x0172 }
            com.google.gson.JsonElement r1 = r1.parse((com.google.gson.stream.JsonReader) r5)     // Catch:{ all -> 0x0172 }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = "userInfo"
            com.google.gson.JsonElement r1 = r1.get(r6)     // Catch:{ all -> 0x0172 }
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = r0.getEmail()     // Catch:{ all -> 0x0172 }
            r15.m5511a((com.google.gson.Gson) r10, (com.google.gson.JsonObject) r1, (java.lang.String) r6)     // Catch:{ all -> 0x0172 }
            if (r16 != 0) goto L_0x0170
            r1 = 1
        L_0x0127:
            r5.close()     // Catch:{ Exception -> 0x019a, all -> 0x0177 }
            org.apache.commons.p009io.IOUtils.close(r2)     // Catch:{ all -> 0x016b }
            r14 = r2
            r2 = r1
            r1 = r14
            goto L_0x0052
        L_0x0132:
            r1 = 0
            goto L_0x00bf
        L_0x0134:
            nl.volkerinfradesign.checkandroid.AppState r1 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.net.URL r1 = r1.getUserPOSTUrl()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            r2 = r1
            goto L_0x00d8
        L_0x0144:
            r5 = move-exception
            r1.close()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            throw r5     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
        L_0x0149:
            r1 = move-exception
            r14 = r1
            r1 = r2
            r2 = r3
            r3 = r14
        L_0x014e:
            android.content.Context r5 = p006nl.volkerinfradesign.checkandroid.App.getAppContext()     // Catch:{ all -> 0x0195 }
            java.lang.String r6 = "Er ging iets mis bij het laden van uw profiel"
            r7 = 1
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r7)     // Catch:{ all -> 0x0195 }
            r5.show()     // Catch:{ all -> 0x0195 }
            nl.volkerinfradesign.checkandroid.AppState r5 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x0195 }
            r5.invalidateLogin(r1)     // Catch:{ all -> 0x0195 }
            r3.printStackTrace()     // Catch:{ all -> 0x0195 }
            org.apache.commons.p009io.IOUtils.close(r1)     // Catch:{ all -> 0x016b }
            goto L_0x0052
        L_0x016b:
            r1 = move-exception
            r0.close()
            throw r1
        L_0x0170:
            r1 = 0
            goto L_0x0127
        L_0x0172:
            r1 = move-exception
            r5.close()     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
            throw r1     // Catch:{ Exception -> 0x0149, all -> 0x0177 }
        L_0x0177:
            r1 = move-exception
        L_0x0178:
            org.apache.commons.p009io.IOUtils.close(r2)     // Catch:{ all -> 0x016b }
            throw r1     // Catch:{ all -> 0x016b }
        L_0x017c:
            r0.close()
            if (r3 == 0) goto L_0x018e
            android.os.Handler r0 = r15.f4363d
            r1 = -1
            r0.sendEmptyMessage(r1)
            nl.volkerinfradesign.checkandroid.environments.implementation.UpdateResultImp r0 = new nl.volkerinfradesign.checkandroid.environments.implementation.UpdateResultImp
            r1 = 1
            r0.<init>((boolean) r1, (java.lang.Exception) r9)
        L_0x018d:
            return r0
        L_0x018e:
            nl.volkerinfradesign.checkandroid.environments.implementation.UpdateResultImp r0 = new nl.volkerinfradesign.checkandroid.environments.implementation.UpdateResultImp
            r1 = 0
            r0.<init>((boolean) r1, (java.lang.Exception) r9)
            goto L_0x018d
        L_0x0195:
            r2 = move-exception
            r14 = r2
            r2 = r1
            r1 = r14
            goto L_0x0178
        L_0x019a:
            r3 = move-exception
            r14 = r2
            r2 = r1
            r1 = r14
            goto L_0x014e
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1239ib.m5510a(boolean):nl.volkerinfradesign.checkandroid.environments.UpdateResult");
    }

    /* renamed from: a */
    private void m5511a(Gson gson, JsonObject jsonObject, String str) throws IOException {
        ContentValues contentValues = new ContentValues(1);
        if (jsonObject.has("firstName")) {
            contentValues.put("first_name", jsonObject.get("firstName").getAsString().trim());
        }
        if (jsonObject.has("middleName")) {
            contentValues.put("middle_name", jsonObject.get("middleName").getAsString().trim());
        }
        if (jsonObject.has("lastName")) {
            contentValues.put("last_name", jsonObject.get("lastName").getAsString().trim());
        }
        if (jsonObject.has("phoneMobile")) {
            contentValues.put("phone_mobile", jsonObject.get("phoneMobile").getAsString().trim());
        }
        if (jsonObject.has("vca")) {
            JsonObject asJsonObject = jsonObject.get("vca").getAsJsonObject();
            if (asJsonObject.has("number")) {
                contentValues.put("vca_number", asJsonObject.get("number").getAsString().trim());
            }
        }
        if (jsonObject.has("birthDate")) {
            contentValues.put("birth_day", Long.valueOf(jsonObject.get("birthDate").getAsLong()));
        }
        if (jsonObject.has("chief")) {
            PersonImp personImp = (PersonImp) gson.fromJson((JsonElement) jsonObject.get("chief").getAsJsonObject(), PersonImp.class);
            contentValues.put("person_in_charge_email", personImp.getEmail());
            contentValues.put("person_in_charge_name", personImp.getName());
            contentValues.put("person_in_charge_id", Long.valueOf(personImp.getServerId()));
        } else {
            contentValues.putNull("person_in_charge_email");
            contentValues.putNull("person_in_charge_name");
            contentValues.putNull("person_in_charge_id");
        }
        if (jsonObject.has("theme")) {
            JsonObject asJsonObject2 = jsonObject.get("theme").getAsJsonObject();
            if (asJsonObject2.has("color")) {
                contentValues.put("theme_color", asJsonObject2.get("color").getAsString());
            }
            if (asJsonObject2.has("companyPictureUrl")) {
                contentValues.put("company_logo_ext", asJsonObject2.get("companyPictureUrl").getAsString());
            }
        }
        if (jsonObject.has("helpdesk")) {
            JsonObject asJsonObject3 = jsonObject.get("helpdesk").getAsJsonObject();
            if (asJsonObject3.has("phone")) {
                contentValues.put("help_number", asJsonObject3.get("phone").getAsString());
            }
        }
        contentValues.put("account_info_updated", Integer.valueOf(AccountInfoStep.C_UPDATED.ordinal()));
        update(contentValues, "email = ?", new String[]{str});
    }

    public synchronized UpdateResult updateAccountInfo() {
        return m5510a(false);
    }

    public String verifyAccountCode(String str, int i) {
        JsonWriter jsonWriter;
        HttpURLConnection httpURLConnection = null;
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("passCode", (Number) Integer.valueOf(i));
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
                    IOUtils.close(httpURLConnection2);
                    return null;
                }
                JsonObject jsonObject3 = (JsonObject) new JsonParser().parse(trim);
                AppState.getInstance().setSID(jsonObject3.get("sessionId").getAsString());
                addUser(str);
                m5511a(create, jsonObject3.getAsJsonObject("userInfo"), str);
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("verification_step", Integer.valueOf(Accounts.VerificationStep.G_FINISHED.ordinal()));
                update(contentValues, "email = ? and item_type_ordinal = ?", new String[]{str, Accounts.AccontRecordType.D_CUSTOM_CHILD.ordinalString()});
                this.f4363d.sendEmptyMessage(-1);
                IOUtils.close(httpURLConnection2);
                return "OK";
            } catch (IOException e) {
                httpURLConnection = httpURLConnection2;
                try {
                    String headerField = httpURLConnection.getHeaderField("X-Error-Message");
                    IOUtils.close(httpURLConnection);
                    return headerField;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.close(httpURLConnection);
                    throw th;
                }
            } catch (Exception e2) {
                httpURLConnection = httpURLConnection2;
                IOUtils.close(httpURLConnection);
                return "Unknown error, check internet connection";
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                IOUtils.close(httpURLConnection);
                throw th;
            }
        } catch (IOException e3) {
            String headerField2 = httpURLConnection.getHeaderField("X-Error-Message");
            IOUtils.close(httpURLConnection);
            return headerField2;
        } catch (Exception e4) {
            IOUtils.close(httpURLConnection);
            return "Unknown error, check internet connection";
        }
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1243a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8477a() {
        Accounts.AccontRecordType[] accontRecordTypeArr = {Accounts.AccontRecordType.C_CUSTOM_HEADER, Accounts.AccontRecordType.A_DEVICE_HEADER};
        int length = accontRecordTypeArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            Accounts.AccontRecordType accontRecordType = accontRecordTypeArr[i];
            ViTaCursor query = query("item_type_ordinal = ?", new String[]{Integer.toString(accontRecordType.ordinal())}, new String[0]);
            try {
                if (!query.moveToFirst()) {
                    ContentValues contentValues = new ContentValues(1);
                    contentValues.put("item_type_ordinal", Integer.valueOf(accontRecordType.ordinal()));
                    contentValues.put("creation_date", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("account_fingerprint", Base64.encode(accontRecordType.name().getBytes(), 0));
                    insertOrThrow(contentValues);
                    z = true;
                }
                query.close();
                i++;
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        return z;
    }

    /* renamed from: a */
    public Accounts.AccountCursor mo8475a(long j) {
        return (Accounts.AccountCursor) query("_id = ?", new String[]{Long.toString(j)}, new String[0]);
    }

    /* renamed from: b */
    public boolean mo8481b(long j) {
        ViTaCursor query = query(new String[]{"_id"}, "_id = ?", new String[]{Long.toString(j)}, (String) null, (String) null, (String) null, "1");
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8480b() {
        this.f4363d.sendEmptyMessage(-1);
    }

    /* renamed from: d */
    private Set<String> m5522d() {
        int i = 0;
        ViTaCursor query = query("account_fingerprint is not null", (String[]) null, "account_fingerprint");
        HashSet hashSet = new HashSet();
        while (query.moveToPosition(i)) {
            try {
                hashSet.add(query.getString(0));
                i++;
            } finally {
                query.close();
            }
        }
        return hashSet;
    }

    /* renamed from: e */
    private Long m5523e() {
        Long l = null;
        ViTaCursor query = query(new String[]{"_id"}, "selected is not null or selected != ?", new String[]{"0"}, (String) null, (String) null, (String) null, "1");
        try {
            if (query.moveToFirst()) {
                l = Long.valueOf(query.getLong(0));
            }
            return l;
        } finally {
            query.close();
        }
    }

    /* renamed from: f */
    private boolean m5524f() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("verification_step", Accounts.VerificationStep.A_PENDING_VERIFICATION.ordinalString());
        if (this.f4364e.mo8501a(contentValues) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m5520a(String str) {
        return str.endsWith(".exchange") || str.endsWith(".eas");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5514a(C1243a aVar, String str) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("company_logo_local", str);
        contentValues.put("account_info_updated", Integer.valueOf(AccountInfoStep.B_CHANGED.ordinal()));
        if (!(update(contentValues, "email = ?", new String[]{aVar.getEmail()}) > 0)) {
            return false;
        }
        this.f4363d.sendEmptyMessage(-1);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5515a(C1243a aVar, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("theme_color", str);
        contentValues.put("help_number", str2);
        contentValues.put("company_logo_ext", str3);
        contentValues.put("account_info_updated", Integer.valueOf(AccountInfoStep.B_CHANGED.ordinal()));
        if (!(update(contentValues, "email = ?", new String[]{aVar.getEmail()}) > 0)) {
            return false;
        }
        this.f4363d.sendEmptyMessage(-1);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5516a(C1243a aVar, String str, String str2, String str3, String str4, Calendar calendar, String str5) {
        return mo8478a(aVar.getEmail(), str, str2, str3, str4, calendar, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (String) null, str5);
    }

    /* renamed from: a */
    public boolean mo8478a(String str, String str2, String str3, String str4, String str5, Calendar calendar, String str6, String str7, String str8, String str9, Long l, String str10, String str11, String str12) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", str2);
        contentValues.put("middle_name", str3);
        contentValues.put("last_name", str4);
        contentValues.put("vca_number", str5);
        contentValues.put("phone_mobile", str12);
        contentValues.put("birth_day", Long.valueOf(calendar.getTimeInMillis()));
        if (l == null || !StringUtils.isNotBlank(str11)) {
            contentValues.putNull("person_in_charge_id");
            contentValues.putNull("person_in_charge_name");
            contentValues.putNull("person_in_charge_email");
        } else {
            contentValues.put("person_in_charge_id", l);
            contentValues.put("person_in_charge_name", str10);
            contentValues.put("person_in_charge_email", str11);
        }
        if (str6 != null) {
            contentValues.put("theme_color", str6);
        }
        if (str7 != null) {
            contentValues.put("help_number", str7);
        }
        if (str8 != null) {
            contentValues.put("company_logo_local", str8);
        }
        if (str9 != null) {
            contentValues.put("company_logo_ext", str9);
        }
        contentValues.put("account_info_updated", Integer.valueOf(AccountInfoStep.B_CHANGED.ordinal()));
        contentValues.put("account_info_updated", Integer.valueOf(AccountInfoStep.B_CHANGED.ordinal()));
        contentValues.put("account_info_modified", Long.valueOf(System.currentTimeMillis()));
        if (!(update(contentValues, "email = ?", new String[]{str}) > 0)) {
            return false;
        }
        this.f4363d.sendEmptyMessage(-1);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5513a(String[] strArr) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("selected", 0);
        update(contentValues, (String) null, (String[]) null);
        contentValues.put("selected", 1);
        update(contentValues, "_id = ?", strArr);
    }

    /* renamed from: g */
    private boolean m5525g() {
        boolean z;
        boolean z2;
        Set<String> d = m5522d();
        ArrayList arrayList = new ArrayList();
        Account[] accounts = this.f4361a.getAccounts();
        int length = accounts.length;
        int i = 0;
        boolean z3 = false;
        while (i < length) {
            Account account = accounts[i];
            String str = account.type;
            if (m5520a(str)) {
                String encodeToString = Base64.encodeToString((account.name + str).getBytes(), 0);
                arrayList.add(encodeToString);
                if (!d.contains(encodeToString)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("email", account.name);
                    contentValues.put("type", str);
                    contentValues.put("account_fingerprint", encodeToString);
                    contentValues.put("creation_date", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("item_type_ordinal", Integer.valueOf(Accounts.AccontRecordType.B_DEVICE_CHILD.ordinal()));
                    insert(contentValues);
                    z2 = true;
                    i++;
                    z3 = z2;
                }
            }
            z2 = z3;
            i++;
            z3 = z2;
        }
        if (!arrayList.isEmpty()) {
            String str2 = "item_type_ordinal = ? and account_fingerprint not in (";
            String[] strArr = new String[(arrayList.size() + 1)];
            strArr[0] = Integer.toString(Accounts.AccontRecordType.B_DEVICE_CHILD.ordinal());
            int i2 = 0;
            while (i2 < arrayList.size()) {
                strArr[i2 + 1] = (String) arrayList.get(i2);
                i2++;
                str2 = str2 + "?,";
            }
            z = z3 || delete(new StringBuilder().append(str2.substring(0, str2.length() + -1)).append(")").toString(), strArr) > 0;
        } else {
            AppState.getInstance().log().mo8931i("copying accounts: " + new GsonBuilder().setPrettyPrinting().create().toJson((Object) this.f4361a.getAccounts()));
            z = z3;
        }
        if (!z) {
            return false;
        }
        this.f4363d.sendEmptyMessage(-1);
        return true;
    }

    /* renamed from: ib$a */
    final class C1243a extends ViTaCursor.Instance implements Accounts.AccountCursor {
        public C1243a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        /* renamed from: a */
        public long mo8504a() {
            return getLong("person_in_charge_id");
        }

        /* renamed from: b */
        public boolean mo8505b() {
            return !isNull("person_in_charge_id");
        }

        public AccountInfoStep getAccountInfoStep() {
            return AccountInfoStep.values()[getInt("account_info_updated")];
        }

        public Calendar getBirthDay() {
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            instance.setTimeInMillis(getBirthDayMillis());
            return instance;
        }

        public long getBirthDayMillis() {
            return getLong("birth_day");
        }

        public String getCompanyLogoExternalPath() {
            return getString("company_logo_ext");
        }

        public String getCompanyLogoLocalPath() {
            return getString("company_logo_local");
        }

        public String getEmail() {
            return getString("email");
        }

        public String getFirstName() {
            return getString("first_name");
        }

        public String getFullName() {
            String middleName = getMiddleName();
            return getFirstName() + ((middleName == null || middleName.length() == 0) ? " " : " " + middleName + " ") + getLastName();
        }

        public String getHelpNumber() {
            return getString("help_number");
        }

        public Accounts.AccontRecordType getItemType() {
            return Accounts.AccontRecordType.values()[getInt("item_type_ordinal")];
        }

        public Accounts.AccountKey getKey() {
            return new AccountKeyImp(C1239ib.this.f4362c.params, getId());
        }

        public String getLastName() {
            return getString("last_name");
        }

        public String getMiddleName() {
            return getString("middle_name");
        }

        public long getServerId() {
            return getLong("server_id");
        }

        public String getThemeColor() {
            return getString("theme_color");
        }

        public String getType() {
            return getString("type");
        }

        public String getVcaNumber() {
            return getString("vca_number");
        }

        public String getPhoneMobile() {
            return getString("phone_mobile");
        }

        public Accounts.VerificationStep getVerificationStep() {
            return Accounts.VerificationStep.values()[getInt("verification_step")];
        }

        public boolean hasBirthDay() {
            return !isNull("birth_day");
        }

        public boolean hasServerId() {
            return !isNull("server_id");
        }

        public boolean isSelected() {
            return getBoolean("selected");
        }

        public boolean save(String str, String str2, String str3, String str4, Calendar calendar, String str5) {
            boolean a = C1239ib.this.m5516a(this, str, str2, str3, str4, calendar, str5);
            CursorWindow window = getWindow();
            int position = getPosition();
            window.putString(str, position, getColumnIndex("first_name"));
            window.putString(str2, position, getColumnIndex("middle_name"));
            window.putString(str3, position, getColumnIndex("last_name"));
            window.putString(str5, position, getColumnIndex("phone_mobile"));
            window.putString(str4, position, getColumnIndex("vca_number"));
            window.putLong(calendar.getTimeInMillis(), position, getColumnIndex("birth_day"));
            return a;
        }

        public boolean saveCompanyPicturepath(String str) {
            return C1239ib.this.m5514a(this, str);
        }

        public boolean saveTheme(String str, String str2, String str3) {
            return C1239ib.this.m5515a(this, str, str2, str3);
        }

        public void setSelected() {
            C1239ib.this.m5513a(getIdAsStringArray());
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public long m5534c() {
            return getLong("account_info_modified");
        }

        public Theme getTheme() {
            String themeColor = getThemeColor();
            if (themeColor != null) {
                try {
                    return Theme.valueOf(themeColor);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            return Theme.DEFAULT;
        }

        public Accounts.Profile.Person getPersonInCharge() {
            String str = null;
            if (isNull("person_in_charge_id")) {
                return null;
            }
            long j = getLong("person_in_charge_id");
            String string = isNull("person_in_charge_name") ? null : getString("person_in_charge_name");
            if (!isNull("person_in_charge_email")) {
                str = getString("person_in_charge_email");
            }
            return new PersonImp(j, str, string);
        }
    }

    /* renamed from: a */
    public Accounts.Profile mo8476a(AccountKeyImp accountKeyImp) {
        return new ProfileImp(this.f4362c.params.nameSpace, accountKeyImp);
    }
}
