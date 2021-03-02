package p052pt.lumberapps.frases;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.p021v7.p023b.C0515k;
import android.util.Log;
import android.webkit.WebView;
import com.google.android.gms.C1204R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: pt.lumberapps.frases.b */
public class C2047b {

    /* renamed from: d */
    private static final int f7724d = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: a */
    private final Context f7725a;

    /* renamed from: b */
    private String f7726b;

    /* renamed from: c */
    private String f7727c;

    /* renamed from: e */
    private C2054f f7728e;

    /* renamed from: f */
    private StringBuffer f7729f;

    public C2047b(Context context) {
        this(context, PreferenceManager.getDefaultSharedPreferences(context));
    }

    public C2047b(Context context, SharedPreferences sharedPreferences) {
        this.f7728e = C2054f.NONE;
        this.f7729f = null;
        this.f7725a = context;
        this.f7726b = sharedPreferences.getString("PREFS_VERSION_KEY", "");
        Log.d("ChangeLog", "lastVersion: " + this.f7726b);
        try {
            this.f7727c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f7727c = "";
            Log.e("ChangeLog", "could not get version name from manifest!");
            e.printStackTrace();
        }
        Log.d("ChangeLog", "appVersion: " + this.f7727c);
    }

    /* renamed from: a */
    private AlertDialog m8318a(boolean z) {
        WebView webView = new WebView(this.f7725a);
        if (f7724d >= 11) {
            C2053e.m8328a(webView);
        }
        webView.setBackgroundColor(0);
        webView.loadDataWithBaseURL((String) null, m8321b(z), "text/html", "UTF-8", (String) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f7725a);
        builder.setTitle(this.f7725a.getResources().getString(z ? C1204R.string.changelog_full_title : C1204R.string.changelog_title)).setView(webView).setCancelable(false).setPositiveButton(this.f7725a.getResources().getString(C1204R.string.changelog_ok_button), new C2051c(this));
        if (!z) {
            builder.setNegativeButton(C1204R.string.changelog_show_full, new C2052d(this));
        }
        return builder.create();
    }

    /* renamed from: a */
    private void m8320a(C2054f fVar) {
        if (this.f7728e != fVar) {
            m8323c();
            if (fVar == C2054f.ORDERED) {
                this.f7729f.append("<div class='list'><ol>\n");
            } else if (fVar == C2054f.UNORDERED) {
                this.f7729f.append("<div class='list'><ul>\n");
            }
            this.f7728e = fVar;
        }
    }

    /* renamed from: b */
    private String m8321b(boolean z) {
        this.f7729f = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f7725a.getResources().openRawResource(C1204R.raw.changelog)));
            boolean z2 = false;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String trim = readLine.trim();
                    char charAt = trim.length() > 0 ? trim.charAt(0) : 0;
                    if (charAt == '$') {
                        m8323c();
                        String trim2 = trim.substring(1).trim();
                        if (!z) {
                            if (this.f7726b.equals(trim2)) {
                                z2 = true;
                            } else if (trim2.equals("END_OF_CHANGE_LOG")) {
                                z2 = false;
                            }
                        }
                    } else if (!z2) {
                        switch (charAt) {
                            case C0515k.AppCompatTheme_actionModeCopyDrawable:
                                m8323c();
                                this.f7729f.append("<div class='freetext'>" + trim.substring(1).trim() + "</div>\n");
                                break;
                            case C0515k.AppCompatTheme_actionModeSelectAllDrawable:
                                m8320a(C2054f.ORDERED);
                                this.f7729f.append("<li>" + trim.substring(1).trim() + "</li>\n");
                                break;
                            case C0515k.AppCompatTheme_actionModeFindDrawable:
                                m8323c();
                                this.f7729f.append("<div class='title'>" + trim.substring(1).trim() + "</div>\n");
                                break;
                            case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                                m8320a(C2054f.UNORDERED);
                                this.f7729f.append("<li>" + trim.substring(1).trim() + "</li>\n");
                                break;
                            case C0515k.AppCompatTheme_alertDialogCenterButtons:
                                m8323c();
                                this.f7729f.append("<div class='subtitle'>" + trim.substring(1).trim() + "</div>\n");
                                break;
                            default:
                                m8323c();
                                this.f7729f.append(trim + "\n");
                                break;
                        }
                    }
                } else {
                    m8323c();
                    bufferedReader.close();
                    return this.f7729f.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8322b() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f7725a).edit();
        edit.putString("PREFS_VERSION_KEY", this.f7727c);
        edit.commit();
    }

    /* renamed from: c */
    private void m8323c() {
        if (this.f7728e == C2054f.ORDERED) {
            this.f7729f.append("</ol></div>\n");
        } else if (this.f7728e == C2054f.UNORDERED) {
            this.f7729f.append("</ul></div>\n");
        }
        this.f7728e = C2054f.NONE;
    }

    /* renamed from: a */
    public AlertDialog mo10189a() {
        return m8318a(true);
    }
}
