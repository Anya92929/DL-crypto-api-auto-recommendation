package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.LogTask */
public final class LogTask extends AsyncTask<Void, Void, C1281io> {

    /* renamed from: a */
    private final SimpleDateFormat f5445a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* renamed from: b */
    private final MainActivity f5446b;

    public LogTask(MainActivity mainActivity) {
        this.f5446b = mainActivity;
    }

    /* renamed from: a */
    private App m6316a() {
        return (App) this.f5446b.getApplication();
    }

    /* access modifiers changed from: protected */
    public C1281io doInBackground(Void... voidArr) {
        Intent intent;
        String str;
        String str2;
        IOException e = null;
        try {
            File createTempFile = File.createTempFile("log_report_", ".csv", m6316a().getExternalCacheDir());
            Calendar instance = Calendar.getInstance();
            Uri parse = Uri.parse("file://" + m6316a().getModel().getLogger().writeReport(createTempFile).getAbsolutePath());
            try {
                str2 = ("Check! log rapport van " + this.f5445a.format(instance.getTime())) + "(" + m6316a().getPackageManager().getPackageInfo(m6316a().getPackageName(), 0).versionCode + ")";
            } catch (PackageManager.NameNotFoundException e2) {
                str2 = str;
            }
            intent = new Intent("android.intent.action.SEND");
            try {
                intent.setType("text/csv");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"apps@volkerinfradesign.nl"});
                intent.putExtra("android.intent.extra.SUBJECT", str2);
                intent.putExtra("android.intent.extra.TEXT", "Log rapport gegenereerd door: " + m6316a().getModel().getAccount().getEmail() + ". Het rapport is te vinden in de bijlage.");
                intent.putExtra("android.intent.extra.STREAM", parse);
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            IOException iOException = e4;
            intent = null;
            e = iOException;
        }
        return new C1281io(e, intent);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(C1281io ioVar) {
        super.onPostExecute(ioVar);
        if (ioVar.mo8630c()) {
            Toast.makeText(this.f5446b, "Kan geen rapport genereren:\n\n" + ioVar.mo8628a().toString(), 1).show();
            AppState.getInstance().log().mo8930e("Could not generate log!", ioVar.mo8628a());
            return;
        }
        this.f5446b.startActivity(Intent.createChooser(ioVar.mo8629b(), "Send email..."));
    }
}
