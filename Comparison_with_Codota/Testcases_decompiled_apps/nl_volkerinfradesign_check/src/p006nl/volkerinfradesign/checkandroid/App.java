package p006nl.volkerinfradesign.checkandroid;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.Calendar;
import java.util.GregorianCalendar;
import p006nl.volkerinfradesign.checkandroid.background.CheckReceiver;
import p006nl.volkerinfradesign.checkandroid.background.CheckService;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.tables.Settings;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;
import p006nl.volkerinfradesign.checkandroid.util.AESEncrypter;

/* renamed from: nl.volkerinfradesign.checkandroid.App */
public abstract class App extends Application {

    /* renamed from: a */
    private static Context f4613a = null;

    /* renamed from: b */
    private static AESEncrypter f4614b = null;

    /* renamed from: c */
    private final CheckReceiver f4615c = new CheckReceiver() {
        public void onExceptionThrown(Exception exc) {
            AppState.getInstance().log().mo8930e("CheckService has thrown an error.", exc);
            exc.printStackTrace();
        }

        public void onFormsSaved(long[] jArr) {
            App.this.notifyDataSetChanged();
        }

        public void onStructureSaved() {
            App.this.m5769d();
            App.this.notifyDataSetChanged();
        }

        public void onTaskDownloaded() {
            App.this.m5770e();
            App.this.notifyDataSetChanged();
        }
    };

    /* renamed from: d */
    private final DataSetObservable f4616d = new DataSetObservable();

    /* renamed from: e */
    private Root f4617e;

    /* renamed from: f */
    private Calendar f4618f;

    /* renamed from: g */
    private Calendar f4619g;

    /* renamed from: h */
    private Calendar f4620h;

    public abstract String getAppName();

    public static Context getAppContext() {
        return f4613a;
    }

    public static File getInternalFilesDir() {
        return getAppContext().getFilesDir();
    }

    public static AESEncrypter getAesEncrypter() {
        if (f4614b == null) {
            f4614b = new AESEncrypter();
        }
        return f4614b;
    }

    public Model getModel() {
        return AppState.getInstance().getModel();
    }

    public File getTempFile() {
        return new File(getExternalCacheDir(), "temp_picture_file.jpg");
    }

    public File ensureTempFile() throws IOException {
        File tempFile = getTempFile();
        tempFile.getParentFile().mkdirs();
        tempFile.createNewFile();
        if (tempFile.exists() && tempFile.isFile()) {
            return tempFile;
        }
        throw new IOException("Could not create temp picture location.");
    }

    public Root getRoot() {
        if (this.f4617e == null) {
            this.f4617e = Root.loadRecent();
        }
        return this.f4617e;
    }

    public AppState getState() {
        return AppState.getInstance();
    }

    public boolean isUpdateAccountInfoTime() {
        return getUpdateAccountInfoTime().getTimeInMillis() + 604800000 < GregorianCalendar.getInstance().getTimeInMillis();
    }

    public boolean isStructureUpdateTime() {
        return m5766b().getTimeInMillis() + 10800000 < Calendar.getInstance().getTimeInMillis();
    }

    public boolean isTasksUpdateTime() {
        return m5768c().getTimeInMillis() + 10800000 < Calendar.getInstance().getTimeInMillis();
    }

    public Root loadRoot(boolean z) {
        this.f4617e = Root.loadRecent();
        if (z) {
            Root.removeOld();
        }
        return this.f4617e;
    }

    public void notifyDataSetChanged() {
        this.f4616d.notifyChanged();
    }

    public void onCreate() {
        super.onCreate();
        f4613a = getApplicationContext();
        ViTa.init(new Settings(this).setDatabaseName("database_name").setVersion(37).setOnVersionChangedListener(Settings.OnVersionChangedListener.WIPE_INSTANCE));
        AppState.m5772a(this, getAppName().toLowerCase());
        Schema.init(this, AppState.getInstance().getModel());
        FileSystem.init(getDir("file_system", 0), 37);
        registerReceiver(this.f4615c, CheckService.getFilter());
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                try {
                    AppState.getInstance().log().mo8930e("Uncaught exception", th);
                } catch (Error | Exception e) {
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f4616d.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f4616d.unregisterObserver(dataSetObserver);
    }

    /* renamed from: a */
    private SharedPreferences m5764a() {
        return getSharedPreferences(AppState.getInstance().getName() + "_" + 37, 0);
    }

    public Calendar getUpdateAccountInfoTime() {
        if (this.f4620h == null) {
            this.f4620h = GregorianCalendar.getInstance();
            this.f4620h.setTimeInMillis(m5764a().getLong("check:context_update_time", Long.MIN_VALUE));
        }
        return this.f4620h;
    }

    /* renamed from: b */
    private Calendar m5766b() {
        if (this.f4618f == null) {
            this.f4618f = Calendar.getInstance();
            this.f4618f.setTimeInMillis(m5764a().getLong("structure_update_time", Long.MIN_VALUE));
        }
        return this.f4618f;
    }

    /* renamed from: c */
    private Calendar m5768c() {
        if (this.f4619g == null) {
            this.f4619g = Calendar.getInstance();
            this.f4619g.setTimeInMillis(m5764a().getLong("tasks_update_time", Long.MIN_VALUE));
        }
        return this.f4619g;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5769d() {
        this.f4618f = Calendar.getInstance();
        m5764a().edit().putLong("structure_update_time", this.f4618f.getTimeInMillis()).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5770e() {
        this.f4619g = Calendar.getInstance();
        m5764a().edit().putLong("tasks_update_time", this.f4619g.getTimeInMillis()).apply();
    }

    public void setUpdateAccountInfoTime() {
        this.f4620h = GregorianCalendar.getInstance();
        m5764a().edit().putLong("check:context_update_time", this.f4620h.getTimeInMillis()).apply();
    }
}
