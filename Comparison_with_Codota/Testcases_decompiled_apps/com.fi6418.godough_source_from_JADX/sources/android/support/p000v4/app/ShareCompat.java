package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.content.IntentCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.ShareCompat */
public class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static ShareCompatImpl f696a;

    /* renamed from: android.support.v4.app.ShareCompat$IntentBuilder */
    public class IntentBuilder {

        /* renamed from: a */
        private Activity f697a;

        /* renamed from: b */
        private Intent f698b = new Intent().setAction("android.intent.action.SEND");

        /* renamed from: c */
        private CharSequence f699c;

        /* renamed from: d */
        private ArrayList<String> f700d;

        /* renamed from: e */
        private ArrayList<String> f701e;

        /* renamed from: f */
        private ArrayList<String> f702f;

        /* renamed from: g */
        private ArrayList<Uri> f703g;

        private IntentBuilder(Activity activity) {
            this.f697a = activity;
            this.f698b.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, activity.getPackageName());
            this.f698b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, activity.getComponentName());
            this.f698b.addFlags(524288);
        }

        /* renamed from: a */
        private void m600a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f698b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f698b.putExtra(str, strArr);
        }

        /* renamed from: a */
        private void m601a(String str, String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[(strArr.length + length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }

        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder(activity);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Activity mo1070a() {
            return this.f697a;
        }

        public IntentBuilder addEmailBcc(String str) {
            if (this.f702f == null) {
                this.f702f = new ArrayList<>();
            }
            this.f702f.add(str);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            m601a("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            if (this.f701e == null) {
                this.f701e = new ArrayList<>();
            }
            this.f701e.add(str);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            m601a("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            if (this.f700d == null) {
                this.f700d = new ArrayList<>();
            }
            this.f700d.add(str);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            m601a("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            Uri uri2 = (Uri) this.f698b.getParcelableExtra("android.intent.extra.STREAM");
            if (uri2 == null) {
                return setStream(uri);
            }
            if (this.f703g == null) {
                this.f703g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.f698b.removeExtra("android.intent.extra.STREAM");
                this.f703g.add(uri2);
            }
            this.f703g.add(uri);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f699c);
        }

        public Intent getIntent() {
            if (this.f700d != null) {
                m600a("android.intent.extra.EMAIL", this.f700d);
                this.f700d = null;
            }
            if (this.f701e != null) {
                m600a("android.intent.extra.CC", this.f701e);
                this.f701e = null;
            }
            if (this.f702f != null) {
                m600a("android.intent.extra.BCC", this.f702f);
                this.f702f = null;
            }
            boolean z = this.f703g != null && this.f703g.size() > 1;
            boolean equals = this.f698b.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (!z && equals) {
                this.f698b.setAction("android.intent.action.SEND");
                if (this.f703g == null || this.f703g.isEmpty()) {
                    this.f698b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f698b.putExtra("android.intent.extra.STREAM", this.f703g.get(0));
                }
                this.f703g = null;
            }
            if (z && !equals) {
                this.f698b.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.f703g == null || this.f703g.isEmpty()) {
                    this.f698b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f698b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f703g);
                }
            }
            return this.f698b;
        }

        public IntentBuilder setChooserTitle(int i) {
            return setChooserTitle(this.f697a.getText(i));
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.f699c = charSequence;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            this.f698b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            this.f698b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            if (this.f700d != null) {
                this.f700d = null;
            }
            this.f698b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            this.f698b.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.f698b.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            if (!this.f698b.getAction().equals("android.intent.action.SEND")) {
                this.f698b.setAction("android.intent.action.SEND");
            }
            this.f703g = null;
            this.f698b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public IntentBuilder setSubject(String str) {
            this.f698b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.f698b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setType(String str) {
            this.f698b.setType(str);
            return this;
        }

        public void startChooser() {
            this.f697a.startActivity(createChooserIntent());
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$IntentReader */
    public class IntentReader {

        /* renamed from: a */
        private Activity f704a;

        /* renamed from: b */
        private Intent f705b;

        /* renamed from: c */
        private String f706c;

        /* renamed from: d */
        private ComponentName f707d;

        /* renamed from: e */
        private ArrayList<Uri> f708e;

        private IntentReader(Activity activity) {
            this.f704a = activity;
            this.f705b = activity.getIntent();
            this.f706c = ShareCompat.getCallingPackage(activity);
            this.f707d = ShareCompat.getCallingActivity(activity);
        }

        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        public ComponentName getCallingActivity() {
            return this.f707d;
        }

        public Drawable getCallingActivityIcon() {
            if (this.f707d == null) {
                return null;
            }
            try {
                return this.f704a.getPackageManager().getActivityIcon(this.f707d);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.f706c == null) {
                return null;
            }
            try {
                return this.f704a.getPackageManager().getApplicationIcon(this.f706c);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.f706c == null) {
                return null;
            }
            PackageManager packageManager = this.f704a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f706c, 0));
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e);
                return null;
            }
        }

        public String getCallingPackage() {
            return this.f706c;
        }

        public String[] getEmailBcc() {
            return this.f705b.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.f705b.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.f705b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String stringExtra = this.f705b.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    return Html.toHtml((Spanned) text);
                }
                if (text != null) {
                    return ShareCompat.f696a.escapeHtml(text);
                }
            }
            return stringExtra;
        }

        public Uri getStream() {
            return (Uri) this.f705b.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int i) {
            if (this.f708e == null && isMultipleShare()) {
                this.f708e = this.f705b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.f708e != null) {
                return this.f708e.get(i);
            }
            if (i == 0) {
                return (Uri) this.f705b.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }

        public int getStreamCount() {
            if (this.f708e == null && isMultipleShare()) {
                this.f708e = this.f705b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            return this.f708e != null ? this.f708e.size() : this.f705b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        public String getSubject() {
            return this.f705b.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.f705b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.f705b.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f705b.getAction());
        }

        public boolean isShareIntent() {
            String action = this.f705b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.f705b.getAction());
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImpl */
    interface ShareCompatImpl {
        void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder);

        String escapeHtml(CharSequence charSequence);
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImplBase */
    class ShareCompatImplBase implements ShareCompatImpl {
        ShareCompatImplBase() {
        }

        /* renamed from: a */
        private static void m603a(StringBuilder sb, CharSequence charSequence, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                char charAt = charSequence.charAt(i3);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#" + charAt + ";");
                } else if (charAt == ' ') {
                    while (i3 + 1 < i2 && charSequence.charAt(i3 + 1) == ' ') {
                        sb.append("&nbsp;");
                        i3++;
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i3++;
            }
        }

        public void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
            menuItem.setIntent(intentBuilder.createChooserIntent());
        }

        public String escapeHtml(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            m603a(sb, charSequence, 0, charSequence.length());
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImplICS */
    class ShareCompatImplICS extends ShareCompatImplBase {
        ShareCompatImplICS() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1111a(MenuItem menuItem) {
            return !menuItem.hasSubMenu();
        }

        public void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
            ShareCompatICS.configureMenuItem(menuItem, intentBuilder.mo1070a(), intentBuilder.getIntent());
            if (mo1111a(menuItem)) {
                menuItem.setIntent(intentBuilder.createChooserIntent());
            }
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImplJB */
    class ShareCompatImplJB extends ShareCompatImplICS {
        ShareCompatImplJB() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1111a(MenuItem menuItem) {
            return false;
        }

        public String escapeHtml(CharSequence charSequence) {
            return ShareCompatJB.escapeHtml(charSequence);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f696a = new ShareCompatImplJB();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f696a = new ShareCompatImplICS();
        } else {
            f696a = new ShareCompatImplBase();
        }
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
        }
        configureMenuItem(findItem, intentBuilder);
    }

    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        f696a.configureMenuItem(menuItem, intentBuilder);
    }

    public static ComponentName getCallingActivity(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? (ComponentName) activity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY) : callingActivity;
    }

    public static String getCallingPackage(Activity activity) {
        String callingPackage = activity.getCallingPackage();
        return callingPackage == null ? activity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE) : callingPackage;
    }
}
