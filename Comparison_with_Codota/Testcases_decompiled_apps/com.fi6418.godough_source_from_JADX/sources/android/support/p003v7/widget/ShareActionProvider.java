package android.support.p003v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.p000v4.view.ActionProvider;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.ActivityChooserModel;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.support.p003v7.internal.widget.TintManager;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.widget.ShareActionProvider */
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: a */
    private int f3122a = 4;

    /* renamed from: b */
    private final ShareMenuItemOnMenuItemClickListener f3123b = new ShareMenuItemOnMenuItemClickListener();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f3124c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f3125d = DEFAULT_SHARE_HISTORY_FILE_NAME;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnShareTargetSelectedListener f3126e;

    /* renamed from: f */
    private ActivityChooserModel.OnChooseActivityListener f3127f;

    /* renamed from: android.support.v7.widget.ShareActionProvider$OnShareTargetSelectedListener */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    /* renamed from: android.support.v7.widget.ShareActionProvider$ShareActivityChooserModelPolicy */
    class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        private ShareActivityChooserModelPolicy() {
        }

        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            if (ShareActionProvider.this.f3126e == null) {
                return false;
            }
            ShareActionProvider.this.f3126e.onShareTargetSelected(ShareActionProvider.this, intent);
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ShareActionProvider$ShareMenuItemOnMenuItemClickListener */
    class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private ShareMenuItemOnMenuItemClickListener() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent chooseActivity = ActivityChooserModel.get(ShareActionProvider.this.f3124c, ShareActionProvider.this.f3125d).chooseActivity(menuItem.getItemId());
            if (chooseActivity == null) {
                return true;
            }
            String action = chooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.m2251a(chooseActivity);
            }
            ShareActionProvider.this.f3124c.startActivity(chooseActivity);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f3124c = context;
    }

    /* renamed from: a */
    private void m2250a() {
        if (this.f3126e != null) {
            if (this.f3127f == null) {
                this.f3127f = new ShareActivityChooserModelPolicy();
            }
            ActivityChooserModel.get(this.f3124c, this.f3125d).setOnChooseActivityListener(this.f3127f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2251a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f3124c);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.f3124c, this.f3125d));
        }
        TypedValue typedValue = new TypedValue();
        this.f3124c.getTheme().resolveAttribute(C0235R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(TintManager.getDrawable(this.f3124c, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(C0235R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(C0235R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel activityChooserModel = ActivityChooserModel.get(this.f3124c, this.f3125d);
        PackageManager packageManager = this.f3124c.getPackageManager();
        int activityCount = activityChooserModel.getActivityCount();
        int min = Math.min(activityCount, this.f3122a);
        for (int i = 0; i < min; i++) {
            ResolveInfo activity = activityChooserModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.f3123b);
        }
        if (min < activityCount) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f3124c.getString(C0235R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < activityCount; i2++) {
                ResolveInfo activity2 = activityChooserModel.getActivity(i2);
                addSubMenu.add(0, i2, i2, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f3123b);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f3126e = onShareTargetSelectedListener;
        m2250a();
    }

    public void setShareHistoryFileName(String str) {
        this.f3125d = str;
        m2250a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                m2251a(intent);
            }
        }
        ActivityChooserModel.get(this.f3124c, this.f3125d).setIntent(intent);
    }
}
