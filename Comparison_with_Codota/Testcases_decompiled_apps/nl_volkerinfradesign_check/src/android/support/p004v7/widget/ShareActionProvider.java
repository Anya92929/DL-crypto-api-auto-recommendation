package android.support.p004v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.p001v4.view.ActionProvider;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.widget.ActivityChooserModel;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.widget.ShareActionProvider */
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: a */
    private int f2255a = 4;

    /* renamed from: b */
    private final C0585b f2256b = new C0585b();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f2257c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f2258d = DEFAULT_SHARE_HISTORY_FILE_NAME;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnShareTargetSelectedListener f2259e;

    /* renamed from: f */
    private ActivityChooserModel.OnChooseActivityListener f2260f;

    /* renamed from: android.support.v7.widget.ShareActionProvider$OnShareTargetSelectedListener */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f2257c = context;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f2259e = onShareTargetSelectedListener;
        m3318a();
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f2257c);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.m3119a(this.f2257c, this.f2258d));
        }
        TypedValue typedValue = new TypedValue();
        this.f2257c.getTheme().resolveAttribute(C0505R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(TintManager.getDrawable(this.f2257c, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(C0505R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(C0505R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public boolean hasSubMenu() {
        return true;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel a = ActivityChooserModel.m3119a(this.f2257c, this.f2258d);
        PackageManager packageManager = this.f2257c.getPackageManager();
        int a2 = a.mo4021a();
        int min = Math.min(a2, this.f2255a);
        for (int i = 0; i < min; i++) {
            ResolveInfo a3 = a.mo4023a(i);
            subMenu.add(0, i, i, a3.loadLabel(packageManager)).setIcon(a3.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2256b);
        }
        if (min < a2) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f2257c.getString(C0505R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < a2; i2++) {
                ResolveInfo a4 = a.mo4023a(i2);
                addSubMenu.add(0, i2, i2, a4.loadLabel(packageManager)).setIcon(a4.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2256b);
            }
        }
    }

    public void setShareHistoryFileName(String str) {
        this.f2258d = str;
        m3318a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                m3319a(intent);
            }
        }
        ActivityChooserModel.m3119a(this.f2257c, this.f2258d).mo4024a(intent);
    }

    /* renamed from: android.support.v7.widget.ShareActionProvider$b */
    class C0585b implements MenuItem.OnMenuItemClickListener {
        private C0585b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent b = ActivityChooserModel.m3119a(ShareActionProvider.this.f2257c, ShareActionProvider.this.f2258d).mo4026b(menuItem.getItemId());
            if (b == null) {
                return true;
            }
            String action = b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.m3319a(b);
            }
            ShareActionProvider.this.f2257c.startActivity(b);
            return true;
        }
    }

    /* renamed from: a */
    private void m3318a() {
        if (this.f2259e != null) {
            if (this.f2260f == null) {
                this.f2260f = new C0584a();
            }
            ActivityChooserModel.m3119a(this.f2257c, this.f2258d).mo4025a(this.f2260f);
        }
    }

    /* renamed from: android.support.v7.widget.ShareActionProvider$a */
    class C0584a implements ActivityChooserModel.OnChooseActivityListener {
        private C0584a() {
        }

        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            if (ShareActionProvider.this.f2259e == null) {
                return false;
            }
            ShareActionProvider.this.f2259e.onShareTargetSelected(ShareActionProvider.this, intent);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3319a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}
