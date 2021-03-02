package com.tapcrowd.app.modules.wizard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import com.tapcrowd.app.utils.C1216LO;

public class WizardActivity extends SherlockActivity {
    private ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setContentView((int) C0846R.layout.layout_wizard);
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        setupActionbar();
        setupViewpager();
    }

    public void setupActionbar() {
        ActionBar ab = getSupportActionBar();
        if (((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navbarTitleImage)) == null) {
            Bitmap bg = C1216LO.getNavbarBackground(this);
            int height = bg.getHeight();
            Bitmap result = Bitmap.createBitmap(bg.getWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);
            canvas.drawBitmap(bg, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
            Bitmap logo = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navbarTitleImage)).getBitmap();
            Bitmap scaled = Bitmap.createScaledBitmap(logo, (int) (((double) logo.getWidth()) * (((double) height) / ((double) logo.getHeight()))), height, true);
            canvas.drawBitmap(scaled, (float) ((canvas.getWidth() - scaled.getWidth()) / 2), BitmapDescriptorFactory.HUE_RED, (Paint) null);
            ab.setBackgroundDrawable(new BitmapDrawable(getResources(), result));
            ab.setDisplayShowTitleEnabled(false);
            return;
        }
        String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
        if (color.length() == 8) {
            color = color.substring(2);
        }
        ab.setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + getString(C0846R.string.app_name).toUpperCase() + "</font>"));
        ab.setBackgroundDrawable(new ColorDrawable(C1216LO.getLo(C1216LO.navbarColor)));
        ab.setDisplayShowTitleEnabled(true);
    }

    public void setupViewpager() {
        this.viewPager = (ViewPager) findViewById(C0846R.C0847id.viewerpager);
        this.viewPager.setAdapter(new ViewpagerAdapater());
    }

    public class ViewpagerAdapater extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public int getCount() {
            return 3;
        }

        public ViewpagerAdapater() {
            this.layoutInflater = WizardActivity.this.getLayoutInflater();
        }

        public Object instantiateItem(View collection, int position) {
            TextView view = new TextView(WizardActivity.this);
            view.setText(String.valueOf(position));
            ((ViewPager) collection).addView(view);
            return view;
        }

        public void destroyItem(View collection, int position, Object object) {
            ((ViewPager) collection).removeView((View) object);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isViewFromObject(android.view.View r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = r4
                android.view.View r0 = (android.view.View) r0
                if (r3 != r0) goto L_0x0007
                r1 = 1
            L_0x0006:
                return r1
            L_0x0007:
                r1 = 0
                goto L_0x0006
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.wizard.WizardActivity.ViewpagerAdapater.isViewFromObject(android.view.View, java.lang.Object):boolean");
        }

        public void finishUpdate(View arg0) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }
    }

    public void next(View v) {
        Bundle bundle = getIntent().getExtras();
        Intent intent = new Intent(this, TCLauncher.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
