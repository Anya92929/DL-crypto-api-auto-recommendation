package com.tapcrowd.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.Gallery;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.List;

public class DetailImageViewpagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    Context context;
    FastImageLoader fil;
    List<String> images = new ArrayList();
    boolean local = false;
    LinearLayout markers;
    ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;

    public DetailImageViewpagerAdapter(Context context2, List<String> images2, LinearLayout markers2) {
        this.context = context2;
        this.images = images2;
        this.markers = markers2;
        this.fil = new FastImageLoader();
        if (markers2 != null) {
            markers2.setVisibility(8);
        }
    }

    public DetailImageViewpagerAdapter(Context context2, List<String> images2, LinearLayout markers2, ImageView.ScaleType scaleType2) {
        this.context = context2;
        this.images = images2;
        this.markers = markers2;
        this.scaleType = scaleType2;
        this.fil = new FastImageLoader();
        if (markers2 != null) {
            markers2.setVisibility(8);
        }
    }

    public DetailImageViewpagerAdapter(Context context2, List<String> images2, LinearLayout markers2, boolean local2) {
        this.context = context2;
        this.images = images2;
        this.markers = markers2;
        this.local = local2;
        this.fil = new FastImageLoader();
        if (markers2 != null) {
            markers2.setVisibility(8);
        }
    }

    public int getCount() {
        return this.images.size();
    }

    public Object instantiateItem(View collection, int position) {
        ViewPager viewPager = (ViewPager) collection;
        viewPager.setOnPageChangeListener(this);
        View view = ((Activity) this.context).getLayoutInflater().inflate(C0846R.layout.detailviewpager_cell, (ViewGroup) null);
        View spinner = view.findViewById(C0846R.C0847id.spinner);
        spinner.setVisibility(0);
        final ImageView icon = (ImageView) view.findViewById(C0846R.C0847id.icon);
        TextView count = (TextView) view.findViewById(C0846R.C0847id.count);
        icon.setScaleType(this.scaleType);
        if (this.local) {
            Bitmap bm = decodeSampledBitmapFromFile(this.images.get(position), ((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth(), (int) TypedValue.applyDimension(1, 120.0f, this.context.getResources().getDisplayMetrics()));
            Bitmap bitmap = bm;
            try {
                int orientation = new ExifInterface(this.images.get(position)).getAttributeInt("Orientation", 1);
                Matrix m = new Matrix();
                if (orientation == 3) {
                    m.postRotate(180.0f);
                    bitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                } else if (orientation == 6) {
                    m.postRotate(90.0f);
                    bitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                } else if (orientation == 8) {
                    m.postRotate(270.0f);
                    bitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            spinner.setVisibility(8);
            icon.setImageBitmap(bitmap);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            final View view2 = spinner;
            this.fil.getBitmap(this.images.get(position), new FastImageLoader.LoadBitmapListener() {
                public void bitmapLoaded(Bitmap bitmap) {
                    icon.setImageBitmap(bitmap);
                    view2.setVisibility(8);
                }
            });
        }
        final int i = position;
        icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String urls = "";
                for (String url : DetailImageViewpagerAdapter.this.images) {
                    urls = String.valueOf(urls) + url + ",";
                }
                Intent intent = new Intent(DetailImageViewpagerAdapter.this.context, Gallery.class);
                intent.putExtra("local", DetailImageViewpagerAdapter.this.local);
                intent.putExtra("urls", urls);
                intent.putExtra("index", i);
                DetailImageViewpagerAdapter.this.context.startActivity(intent);
            }
        });
        if (this.images.size() == 1) {
            count.setVisibility(8);
        }
        count.setText(String.valueOf(position + 1) + "/" + this.images.size());
        viewPager.addView(view);
        return view;
    }

    public static Bitmap decodeSampledBitmapFromFile(String path, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        int height = options.outHeight;
        int width = options.outWidth;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int inSampleSize = 1;
        if (height > reqHeight) {
            inSampleSize = Math.round(((float) height) / ((float) reqHeight));
        }
        if (width / inSampleSize > reqWidth) {
            inSampleSize = Math.round(((float) width) / ((float) reqWidth));
        }
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.utils.DetailImageViewpagerAdapter.isViewFromObject(android.view.View, java.lang.Object):boolean");
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

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    public void onPageSelected(int position) {
        if (this.markers != null) {
            int i = 0;
            int len = this.markers.getChildCount();
            while (i < len) {
                ((ImageView) this.markers.getChildAt(i)).setBackgroundDrawable(((Activity) this.context).getResources().getDrawable(i == position ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
                i++;
            }
        }
    }
}
