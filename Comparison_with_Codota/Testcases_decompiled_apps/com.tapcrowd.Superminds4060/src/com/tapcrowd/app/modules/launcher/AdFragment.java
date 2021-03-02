package com.tapcrowd.app.modules.launcher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.List;

public class AdFragment extends SherlockFragment {
    private static final int AD_HEIGHT = 55;
    int active = 0;
    /* access modifiers changed from: private */
    public List<AdView> adlist;
    List<TCObject> ads;
    private ViewGroup container;
    private FastImageLoader fil;
    private AdHelper.Carousel initialCarousel;
    private boolean retained;

    /* renamed from: v */
    private View f2057v;

    public static AdFragment newInstance() {
        return new AdFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container2, Bundle savedInstanceState) {
        if (this.f2057v == null) {
            this.f2057v = inflater.inflate(C0846R.layout.ads, container2, false);
        } else {
            ((ViewGroup) this.f2057v.getParent()).removeView(this.f2057v);
            this.retained = true;
        }
        return this.f2057v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            this.container = (ViewGroup) getView().findViewById(C0846R.C0847id.container);
            this.fil = new FastImageLoader();
            if (this.initialCarousel != null) {
                setCarousel(this.initialCarousel);
            }
        }
    }

    public void setCarousel(AdHelper.Carousel carousel) {
        if (this.adlist != null) {
            for (AdView ad : this.adlist) {
                ad.timer.cancel();
            }
        }
        if (getView() == null) {
            this.initialCarousel = carousel;
        } else if (!App.tablet || this.adlist == null) {
            this.adlist = new ArrayList();
            List<AdHelper.C1192Ad> ads2 = carousel.getAds();
            Activity act = getActivity();
            this.container.removeAllViews();
            int len = ads2.size();
            for (int i = 0; i < len; i++) {
                final AdHelper.C1192Ad ad2 = ads2.get(i);
                final int current = i;
                final int next = i + 1 > len + -1 ? 0 : i + 1;
                final ImageView iv = new ImageView(act);
                iv.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) TypedValue.applyDimension(1, 55.0f, act.getResources().getDisplayMetrics())));
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (ad2.getWebsite() != null && !ad2.getWebsite().equals("")) {
                            Actions.openWebview(AdFragment.this, ad2.getWebsite());
                        }
                    }
                });
                this.fil.getBitmap(ad2.getImage(), new FastImageLoader.LoadBitmapListener() {
                    public void bitmapLoaded(Bitmap bitmap) {
                        if (bitmap != null) {
                            iv.setImageBitmap(bitmap);
                            iv.setBackgroundColor(bitmap.getPixel(0, 0));
                        }
                    }
                });
                if (carousel.getAds().size() == 1) {
                    this.container.addView(iv);
                } else {
                    this.adlist.add(new AdView(new CountDownTimer((long) ad2.getTime(), (long) ad2.getTime()) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            for (AdView ad : AdFragment.this.adlist) {
                                ad.unset();
                            }
                            ((AdView) AdFragment.this.adlist.get(current)).out();
                            ((AdView) AdFragment.this.adlist.get(next)).mo8284in();
                            ((AdView) AdFragment.this.adlist.get(next)).start();
                        }
                    }, iv, this.container, act));
                }
            }
            if (this.adlist.size() > 1) {
                this.adlist.get(0).show();
                this.adlist.get(0).start();
            }
            if (carousel.getAds().size() == 0) {
                this.container.setVisibility(8);
                this.f2057v.findViewById(C0846R.C0847id.sep).setVisibility(8);
                return;
            }
            this.container.setVisibility(0);
            this.f2057v.findViewById(C0846R.C0847id.sep).setVisibility(0);
        }
    }

    private static class AdView {
        private ImageView imageview;
        TranslateAnimation slidein;
        TranslateAnimation slideout;
        /* access modifiers changed from: private */
        public CountDownTimer timer;

        public AdView(CountDownTimer timer2, ImageView imageview2, ViewGroup parent, Context context) {
            this.timer = timer2;
            this.imageview = imageview2;
            parent.addView(this.imageview);
            this.slidein = new TranslateAnimation((float) ((Activity) context).getWindowManager().getDefaultDisplay().getWidth(), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.slideout = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, (float) (-((Activity) context).getWindowManager().getDefaultDisplay().getWidth()), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.slidein.setDuration(500);
            this.slideout.setDuration(500);
            this.slideout.setFillAfter(true);
            this.slideout.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    AdView.this.hide();
                }
            });
            this.slidein.setFillAfter(true);
            hide();
        }

        public void unset() {
            this.timer.cancel();
            hide();
        }

        public void hide() {
            this.imageview.setVisibility(8);
        }

        public void show() {
            this.imageview.setVisibility(0);
        }

        /* renamed from: in */
        public void mo8284in() {
            this.imageview.setVisibility(0);
            this.imageview.startAnimation(this.slidein);
        }

        public void out() {
            this.imageview.setVisibility(0);
            this.imageview.startAnimation(this.slideout);
        }

        public void start() {
            this.timer.start();
        }
    }
}
