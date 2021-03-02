package com.tapcrowd.app.modules.sessions;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.p000v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.C1216LO;

public class FestivalSessionsFragment extends TCFragment implements TabHost.OnTabChangeListener {
    private FragmentTabHost mTabHost;

    public static FestivalSessionsFragment newInstance() {
        return new FestivalSessionsFragment();
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.festival_session_tabs, container, false);
        this.mTabHost = (FragmentTabHost) v.findViewById(16908306);
        this.mTabHost.setup(getActivity(), getChildFragmentManager(), C0846R.C0847id.realtabcontent);
        this.mTabHost.addTab(newTab(getString(C0846R.string.timeline)), TimeLineFragment.class, (Bundle) null);
        this.mTabHost.addTab(newTab(getString(C0846R.string.bystage)), SessionsByStageFragment.class, (Bundle) null);
        this.mTabHost.addTab(newTab(getString(C0846R.string.alphabetically)), SessionsAlfaListFragment.class, (Bundle) null);
        this.mTabHost.setOnTabChangedListener(this);
        this.mTabHost.getTabWidget().setDividerDrawable((Drawable) null);
        onTabChanged(this.mTabHost.getCurrentTabTag());
        return v;
    }

    public TabHost.TabSpec newTab(String text) {
        View view = LayoutInflater.from(getActivity()).inflate(C0846R.layout.tab_layout, (ViewGroup) null);
        view.findViewById(C0846R.C0847id.sep).setVisibility(0);
        ((TextView) view.findViewById(C0846R.C0847id.tabtitle)).setText(text);
        view.findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh));
        return this.mTabHost.newTabSpec(text).setIndicator(view);
    }

    public void onTabChanged(String tabId) {
        int len = this.mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < len; i++) {
            View tab = this.mTabHost.getTabWidget().getChildTabViewAt(i);
            tab.findViewById(C0846R.C0847id.tabtitle).setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolor)));
            ((TextView) tab.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
        }
        View current = this.mTabHost.getCurrentTabView();
        current.findViewById(C0846R.C0847id.tabtitle).setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh)));
        ((TextView) current.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColorHigh));
    }

    private class TabDrawable extends ShapeDrawable {
        private final Paint fillpaint = new Paint(getPaint());
        private final Paint strokepaint;

        public TabDrawable(Shape s, int fill) {
            super(s);
            this.fillpaint.setColor(fill);
            this.strokepaint = new Paint(this.fillpaint);
            this.strokepaint.setStyle(Paint.Style.STROKE);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            shape.draw(canvas, this.fillpaint);
            shape.draw(canvas, this.strokepaint);
        }
    }
}
