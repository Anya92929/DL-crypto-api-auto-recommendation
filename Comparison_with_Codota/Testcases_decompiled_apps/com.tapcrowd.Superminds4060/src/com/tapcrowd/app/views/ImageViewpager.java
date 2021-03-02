package com.tapcrowd.app.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.Gallery;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.List;

public class ImageViewpager extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ImageViewpagerAdapter adapter;
    /* access modifiers changed from: private */
    public OnClickListener clickListener;
    /* access modifiers changed from: private */
    public boolean isCounterVisible = true;
    private onPageChangedListener pageListener;
    private ViewGroup pager;
    private ViewPager viewpager;

    public interface OnClickListener {
        boolean onClick(int i, String str);
    }

    public enum PagerPosition {
        Below,
        Over,
        Gone
    }

    public interface onPageChangedListener {
        void onPageChanged(int i);
    }

    public ImageViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        construct();
    }

    private void construct() {
        LayoutInflater.from(getContext()).inflate(C0846R.layout.view_image_viewpager, this, true);
        this.viewpager = (ViewPager) findViewById(C0846R.C0847id.viewpager);
        this.pager = (ViewGroup) findViewById(C0846R.C0847id.pagers);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.clickListener = listener;
    }

    public void setOnPageChangedListener(onPageChangedListener listener) {
        this.pageListener = listener;
    }

    public void showImages(List<String> urls) {
        if (urls.size() == 0) {
            setVisibility(8);
        }
        this.adapter = new ImageViewpagerAdapter(getContext(), urls);
        this.viewpager.setAdapter(this.adapter);
        this.viewpager.setOnPageChangeListener(this);
        this.pager.removeAllViews();
        if (urls.size() > 1) {
            this.pager.setVisibility(0);
            C1232UI.getColorOverlay((int) C0846R.drawable.viewpager_marker_active, C1216LO.getLo(C1216LO.launcherTextColor));
            C1232UI.getColorOverlay((int) C0846R.drawable.viewpager_marker_inactive, C1216LO.getLo(C1216LO.launcherTextColor));
            int i = 0;
            while (i < urls.size()) {
                ImageView iv = new ImageView(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
                lp.leftMargin = 2;
                lp.rightMargin = 2;
                iv.setLayoutParams(lp);
                iv.setBackgroundDrawable(getResources().getDrawable(i == 0 ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
                this.pager.addView(iv);
                i++;
            }
            return;
        }
        this.pager.setVisibility(4);
    }

    public void setPagerPosition(PagerPosition pos) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -2);
        if (pos == PagerPosition.Below) {
            params.addRule(3, C0846R.C0847id.viewpager);
        } else if (pos == PagerPosition.Over) {
            params.addRule(8, C0846R.C0847id.viewpager);
        } else if (pos == PagerPosition.Gone) {
            this.pager.setVisibility(8);
        }
        this.pager.setLayoutParams(params);
    }

    public void showCounter(boolean isVisible) {
        this.isCounterVisible = isVisible;
    }

    public void setDpHeight(int height) {
        if (height != -1) {
            height = (int) Converter.convertDpToPixel((float) height, getContext());
        }
        RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) this.viewpager.getLayoutParams();
        param.height = height;
        this.viewpager.setLayoutParams(param);
    }

    public ImageViewpagerAdapter getAdapter() {
        return this.adapter;
    }

    public ViewPager getViewPager() {
        return this.viewpager;
    }

    private class ImageViewpagerAdapter extends PagerAdapter {
        private FastImageLoader fil = new FastImageLoader();
        /* access modifiers changed from: private */
        public List<String> urls;

        public ImageViewpagerAdapter(Context context, List<String> urls2) {
            this.urls = urls2;
        }

        public int getCount() {
            return this.urls.size();
        }

        public Object instantiateItem(ViewGroup container, final int position) {
            View view = LayoutInflater.from(ImageViewpager.this.getContext()).inflate(C0846R.layout.detailviewpager_cell, (ViewGroup) null);
            final View spinner = view.findViewById(C0846R.C0847id.spinner);
            spinner.setVisibility(0);
            final ImageView icon = (ImageView) view.findViewById(C0846R.C0847id.icon);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fil.getBitmap(this.urls.get(position), new FastImageLoader.LoadBitmapListener() {
                public void bitmapLoaded(Bitmap bitmap) {
                    icon.setImageBitmap(bitmap);
                    spinner.setVisibility(8);
                }
            });
            icon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (ImageViewpager.this.clickListener == null || ImageViewpager.this.clickListener.onClick(position, (String) ImageViewpagerAdapter.this.urls.get(position))) {
                        String images = "";
                        for (String url : ImageViewpagerAdapter.this.urls) {
                            images = String.valueOf(images) + url + ",";
                        }
                        Intent intent = new Intent(ImageViewpager.this.getContext(), Gallery.class);
                        intent.putExtra("urls", images);
                        intent.putExtra("index", position);
                        ImageViewpager.this.getContext().startActivity(intent);
                    }
                }
            });
            TextView count = (TextView) view.findViewById(C0846R.C0847id.count);
            count.setText(String.valueOf(position + 1) + "/" + getCount());
            if (!ImageViewpager.this.isCounterVisible) {
                count.setVisibility(8);
            }
            container.addView(view);
            return view;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
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
            throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.views.ImageViewpager.ImageViewpagerAdapter.isViewFromObject(android.view.View, java.lang.Object):boolean");
        }

        public void finishUpdate(View arg0) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        public void startUpdate(View arg0) {
        }
    }

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    public void onPageSelected(int position) {
        if (this.pageListener != null) {
            this.pageListener.onPageChanged(position);
        }
        int i = 0;
        int len = this.pager.getChildCount();
        while (i < len) {
            ((ImageView) this.pager.getChildAt(i)).setBackgroundDrawable(((Activity) getContext()).getResources().getDrawable(i == position ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
            i++;
        }
    }
}
