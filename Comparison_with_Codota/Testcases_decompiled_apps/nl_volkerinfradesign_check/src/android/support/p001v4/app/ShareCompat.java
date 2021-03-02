package android.support.p001v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.p001v4.content.IntentCompat;
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
    public static C0098a f402a;

    /* renamed from: android.support.v4.app.ShareCompat$a */
    interface C0098a {
        /* renamed from: a */
        String mo740a(CharSequence charSequence);

        /* renamed from: a */
        void mo741a(MenuItem menuItem, IntentBuilder intentBuilder);
    }

    /* renamed from: android.support.v4.app.ShareCompat$b */
    static class C0099b implements C0098a {
        C0099b() {
        }

        /* renamed from: a */
        public void mo741a(MenuItem menuItem, IntentBuilder intentBuilder) {
            menuItem.setIntent(intentBuilder.createChooserIntent());
        }

        /* renamed from: a */
        public String mo740a(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            m413a(sb, charSequence, 0, charSequence.length());
            return sb.toString();
        }

        /* renamed from: a */
        private static void m413a(StringBuilder sb, CharSequence charSequence, int i, int i2) {
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
    }

    /* renamed from: android.support.v4.app.ShareCompat$c */
    static class C0100c extends C0099b {
        C0100c() {
        }

        /* renamed from: a */
        public void mo741a(MenuItem menuItem, IntentBuilder intentBuilder) {
            C0006af.m16a(menuItem, intentBuilder.mo701a(), intentBuilder.getIntent());
            if (mo742a(menuItem)) {
                menuItem.setIntent(intentBuilder.createChooserIntent());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo742a(MenuItem menuItem) {
            return !menuItem.hasSubMenu();
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$d */
    static class C0101d extends C0100c {
        C0101d() {
        }

        /* renamed from: a */
        public String mo740a(CharSequence charSequence) {
            return C0007ag.m17a(charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo742a(MenuItem menuItem) {
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f402a = new C0101d();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f402a = new C0100c();
        } else {
            f402a = new C0099b();
        }
    }

    public static String getCallingPackage(Activity activity) {
        String callingPackage = activity.getCallingPackage();
        if (callingPackage == null) {
            return activity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE);
        }
        return callingPackage;
    }

    public static ComponentName getCallingActivity(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return (ComponentName) activity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        }
        return callingActivity;
    }

    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        f402a.mo741a(menuItem, intentBuilder);
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
        }
        configureMenuItem(findItem, intentBuilder);
    }

    /* renamed from: android.support.v4.app.ShareCompat$IntentBuilder */
    public static class IntentBuilder {

        /* renamed from: a */
        private Activity f403a;

        /* renamed from: b */
        private Intent f404b = new Intent().setAction("android.intent.action.SEND");

        /* renamed from: c */
        private CharSequence f405c;

        /* renamed from: d */
        private ArrayList<String> f406d;

        /* renamed from: e */
        private ArrayList<String> f407e;

        /* renamed from: f */
        private ArrayList<String> f408f;

        /* renamed from: g */
        private ArrayList<Uri> f409g;

        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder(activity);
        }

        private IntentBuilder(Activity activity) {
            this.f403a = activity;
            this.f404b.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, activity.getPackageName());
            this.f404b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, activity.getComponentName());
            this.f404b.addFlags(524288);
        }

        public Intent getIntent() {
            if (this.f406d != null) {
                m408a("android.intent.extra.EMAIL", this.f406d);
                this.f406d = null;
            }
            if (this.f407e != null) {
                m408a("android.intent.extra.CC", this.f407e);
                this.f407e = null;
            }
            if (this.f408f != null) {
                m408a("android.intent.extra.BCC", this.f408f);
                this.f408f = null;
            }
            boolean z = this.f409g != null && this.f409g.size() > 1;
            boolean equals = this.f404b.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (!z && equals) {
                this.f404b.setAction("android.intent.action.SEND");
                if (this.f409g == null || this.f409g.isEmpty()) {
                    this.f404b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f404b.putExtra("android.intent.extra.STREAM", this.f409g.get(0));
                }
                this.f409g = null;
            }
            if (z && !equals) {
                this.f404b.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.f409g == null || this.f409g.isEmpty()) {
                    this.f404b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f404b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f409g);
                }
            }
            return this.f404b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Activity mo701a() {
            return this.f403a;
        }

        /* renamed from: a */
        private void m408a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f404b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f404b.putExtra(str, strArr);
        }

        /* renamed from: a */
        private void m409a(String str, String[] strArr) {
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

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f405c);
        }

        public void startChooser() {
            this.f403a.startActivity(createChooserIntent());
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.f405c = charSequence;
            return this;
        }

        public IntentBuilder setChooserTitle(@StringRes int i) {
            return setChooserTitle(this.f403a.getText(i));
        }

        public IntentBuilder setType(String str) {
            this.f404b.setType(str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.f404b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            this.f404b.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.f404b.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            if (!this.f404b.getAction().equals("android.intent.action.SEND")) {
                this.f404b.setAction("android.intent.action.SEND");
            }
            this.f409g = null;
            this.f404b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            Uri uri2 = (Uri) this.f404b.getParcelableExtra("android.intent.extra.STREAM");
            if (uri2 == null) {
                return setStream(uri);
            }
            if (this.f409g == null) {
                this.f409g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.f404b.removeExtra("android.intent.extra.STREAM");
                this.f409g.add(uri2);
            }
            this.f409g.add(uri);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            if (this.f406d != null) {
                this.f406d = null;
            }
            this.f404b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            if (this.f406d == null) {
                this.f406d = new ArrayList<>();
            }
            this.f406d.add(str);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            m409a("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            this.f404b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            if (this.f407e == null) {
                this.f407e = new ArrayList<>();
            }
            this.f407e.add(str);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            m409a("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            this.f404b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder addEmailBcc(String str) {
            if (this.f408f == null) {
                this.f408f = new ArrayList<>();
            }
            this.f408f.add(str);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            m409a("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder setSubject(String str) {
            this.f404b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$IntentReader */
    public static class IntentReader {

        /* renamed from: a */
        private Activity f410a;

        /* renamed from: b */
        private Intent f411b;

        /* renamed from: c */
        private String f412c;

        /* renamed from: d */
        private ComponentName f413d;

        /* renamed from: e */
        private ArrayList<Uri> f414e;

        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        private IntentReader(Activity activity) {
            this.f410a = activity;
            this.f411b = activity.getIntent();
            this.f412c = ShareCompat.getCallingPackage(activity);
            this.f413d = ShareCompat.getCallingActivity(activity);
        }

        public boolean isShareIntent() {
            String action = this.f411b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.f411b.getAction());
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f411b.getAction());
        }

        public String getType() {
            return this.f411b.getType();
        }

        public CharSequence getText() {
            return this.f411b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getHtmlText() {
            String stringExtra = this.f411b.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    return Html.toHtml((Spanned) text);
                }
                if (text != null) {
                    return ShareCompat.f402a.mo740a(text);
                }
            }
            return stringExtra;
        }

        public Uri getStream() {
            return (Uri) this.f411b.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int i) {
            if (this.f414e == null && isMultipleShare()) {
                this.f414e = this.f411b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.f414e != null) {
                return this.f414e.get(i);
            }
            if (i == 0) {
                return (Uri) this.f411b.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }

        public int getStreamCount() {
            if (this.f414e == null && isMultipleShare()) {
                this.f414e = this.f411b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.f414e != null) {
                return this.f414e.size();
            }
            return this.f411b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        public String[] getEmailTo() {
            return this.f411b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String[] getEmailCc() {
            return this.f411b.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailBcc() {
            return this.f411b.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String getSubject() {
            return this.f411b.getStringExtra("android.intent.extra.SUBJECT");
        }

        public String getCallingPackage() {
            return this.f412c;
        }

        public ComponentName getCallingActivity() {
            return this.f413d;
        }

        public Drawable getCallingActivityIcon() {
            if (this.f413d == null) {
                return null;
            }
            try {
                return this.f410a.getPackageManager().getActivityIcon(this.f413d);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.f412c == null) {
                return null;
            }
            try {
                return this.f410a.getPackageManager().getApplicationIcon(this.f412c);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.f412c == null) {
                return null;
            }
            PackageManager packageManager = this.f410a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f412c, 0));
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e);
                return null;
            }
        }
    }
}
