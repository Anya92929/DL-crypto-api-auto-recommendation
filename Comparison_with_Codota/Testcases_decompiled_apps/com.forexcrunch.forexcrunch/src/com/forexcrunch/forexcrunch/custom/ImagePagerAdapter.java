package com.forexcrunch.forexcrunch.custom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.NewsContentActivity;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import java.util.ArrayList;

public class ImagePagerAdapter extends PagerAdapter {
    /* access modifiers changed from: private */
    public Activity activity;
    private boolean enabled;
    int height = 0;
    private ImageLoader imageLoader;
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public ArrayList<Post> items;
    private DisplayImageOptions options;
    int width = 0;

    public ImagePagerAdapter(ArrayList<Post> items2, Activity activity2, ImageLoader imageLoader2, DisplayImageOptions options2) {
        this.items = items2;
        this.imageLoader = imageLoader2;
        this.options = options2;
        this.inflater = activity2.getLayoutInflater();
        this.activity = activity2;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    public void finishUpdate(View container) {
    }

    public int getCount() {
        return this.items.size();
    }

    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = this.inflater.inflate(C0089R.layout.item_pager_image, view, false);
        ImageView imageView = (ImageView) imageLayout.findViewById(C0089R.C0090id.image);
        final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(C0089R.C0090id.loading);
        ((TextView) imageLayout.findViewById(C0089R.idPagerItem.banner_title)).setText(this.items.get(position).getTitle());
        String date = this.items.get(position).getDate();
        ((TextView) imageLayout.findViewById(C0089R.idPagerItem.banner_time)).setText(date.substring(0, date.length() - 3));
        if (this.items.get(position).getThumbnail() == null || this.items.get(position).getThumbnail().equals("null")) {
            imageView.setImageResource(C0089R.drawable.placeholder);
        } else {
            this.imageLoader.displayImage(this.items.get(position).getThumbnail(), imageView, this.options, new SimpleImageLoadingListener() {
                public void onLoadingStarted(String imageUri, View view) {
                    spinner.setVisibility(0);
                }

                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    if (view.getWidth() == 0 || view.getHeight() == 0) {
                        ImagePagerAdapter.this.width = NewsController.getInstance(ImagePagerAdapter.this.activity).getPagerWidth();
                        ImagePagerAdapter.this.height = NewsController.getInstance(ImagePagerAdapter.this.activity).getPagerHeight();
                        if (ImagePagerAdapter.this.width == 0) {
                            ((ImageView) view).setImageBitmap(GuiUtil.scaleBitmap(ImagePagerAdapter.this.activity, loadedImage, 400, 150));
                        } else {
                            ((ImageView) view).setImageBitmap(GuiUtil.scaleBitmap(ImagePagerAdapter.this.activity, loadedImage, ImagePagerAdapter.this.width, ImagePagerAdapter.this.height));
                        }
                    } else {
                        ImagePagerAdapter.this.width = view.getWidth();
                        ImagePagerAdapter.this.height = view.getHeight();
                        NewsController.getInstance(ImagePagerAdapter.this.activity).setPagerHeight(ImagePagerAdapter.this.height);
                        NewsController.getInstance(ImagePagerAdapter.this.activity).setPagerWidth(ImagePagerAdapter.this.width);
                        ((ImageView) view).setImageBitmap(GuiUtil.scaleBitmap(ImagePagerAdapter.this.activity, loadedImage, ImagePagerAdapter.this.width, ImagePagerAdapter.this.height));
                    }
                    spinner.setVisibility(8);
                }
            });
        }
        ((ViewPager) view).addView(imageLayout, 0);
        final int pos = position;
        ViewGroup viewGroup = view;
        imageLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int category = 0;
                switch (pos) {
                    case 0:
                        category = 0;
                        break;
                    case 1:
                        category = 38;
                        break;
                    case 2:
                        category = News.EUR_USD_FORECAST;
                        break;
                }
                ImagePagerAdapter.this.addReadPostToPreferences(((Post) ImagePagerAdapter.this.items.get(pos)).getId(), category);
                NewsController.getInstance(ImagePagerAdapter.this.activity).setSelectedPost((Post) ImagePagerAdapter.this.items.get(pos));
                v.getContext().startActivity(new Intent(v.getContext(), NewsContentActivity.class));
            }
        });
        return imageLayout;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(View container) {
    }

    public void setPagingEnabled(boolean enabled2) {
        this.enabled = enabled2;
    }

    /* access modifiers changed from: private */
    public void addReadPostToPreferences(int id, int category) {
        ArrayList<Integer> readMsgIds = Utils.createIdsList(this.activity, category);
        if (readMsgIds.isEmpty()) {
            readMsgIds.add(Integer.valueOf(id));
        } else if (!readMsgIds.contains(Integer.valueOf(id))) {
            readMsgIds.add(Integer.valueOf(id));
        }
        Utils.idListToPreferences(this.activity, readMsgIds, category);
    }
}
