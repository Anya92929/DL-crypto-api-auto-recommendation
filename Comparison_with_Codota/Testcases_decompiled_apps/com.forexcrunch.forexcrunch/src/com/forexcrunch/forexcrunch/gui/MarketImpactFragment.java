package com.forexcrunch.forexcrunch.gui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.MarketImpactCalDetails;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

public class MarketImpactFragment extends Fragment implements View.OnClickListener {
    /* access modifiers changed from: private */
    public Button btnInstruments;
    /* access modifiers changed from: private */
    public String[] captions;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    /* access modifiers changed from: private */
    public int instrumentItemIndex = 0;
    private MarketImpactCalDetails marketCalDetails;
    private DisplayImageOptions options;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0089R.layout.market_cal_details, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.marketCalDetails = NewsController.getInstance(getActivity()).getMarketCalDetails();
        this.options = new DisplayImageOptions.Builder().displayer(new SimpleBitmapDisplayer()).build();
        this.btnInstruments = (Button) getView().findViewById(C0089R.idMarketCalDetails.btnInstruments);
        this.btnInstruments.setOnClickListener(this);
        this.captions = getResources().getStringArray(C0089R.array.caption_array);
        showMarketImpacts();
    }

    public void showMarketImpacts() {
        RadioGroup group = (RadioGroup) getView().findViewById(C0089R.idMarketCalDetails.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case C0089R.idMarketCalDetails.charts:
                        MarketImpactFragment.this.showCharts();
                        return;
                    case C0089R.idMarketCalDetails.radar:
                        MarketImpactFragment.this.showRadar();
                        return;
                    default:
                        return;
                }
            }
        });
        if (group.getCheckedRadioButtonId() == -1) {
            ((RadioButton) getView().findViewById(C0089R.idMarketCalDetails.charts)).setChecked(true);
        }
    }

    /* access modifiers changed from: protected */
    public void showRadar() {
        showImage(this.marketCalDetails.getURLRadar(), (ImageView) getView().findViewById(C0089R.idMarketCalDetails.image));
    }

    /* access modifiers changed from: protected */
    public void showCharts() {
        showImage(this.marketCalDetails.getURLChart(), (ImageView) getView().findViewById(C0089R.idMarketCalDetails.image));
    }

    private void showImage(String url, ImageView imgView) {
        this.imageLoader.displayImage(url, imgView, this.options, new ImageLoadingListener() {
            public void onLoadingStarted(String imageUri, View view) {
            }

            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            }

            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (loadedImage != null) {
                    ((ImageView) view).setImageBitmap(loadedImage);
                }
            }

            public void onLoadingCancelled(String imageUri, View view) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void changeInstrumentAndCaption(String caption) {
        int checkedId = ((RadioGroup) getView().findViewById(C0089R.idMarketCalDetails.radioGroup)).getCheckedRadioButtonId();
        String url = "";
        getChartImageByInstrumentAndCaption(caption);
        getRadarImageByLegsCenterAndCaption(caption);
        if (checkedId != -1) {
            switch (checkedId) {
                case C0089R.idMarketCalDetails.charts:
                    url = this.marketCalDetails.getURLChart();
                    break;
                case C0089R.idMarketCalDetails.radar:
                    url = this.marketCalDetails.getURLRadar();
                    break;
            }
            showImage(url, (ImageView) getView().findViewById(C0089R.idMarketCalDetails.image));
        }
    }

    private void getRadarImageByLegsCenterAndCaption(String caption) {
        String newLegs = "legs=" + Utils.getInstrumentByCaption(caption);
        String center = "center=" + caption;
        String caption2 = "caption=" + caption;
        String oldLegs = "";
        String oldCenter = "";
        String oldCaption = "";
        String originalUrl = this.marketCalDetails.getURLRadar();
        String[] params = originalUrl.split("\\?")[1].split("\\&");
        for (int i = 0; i < params.length; i++) {
            if (params[i].contains("legs")) {
                oldLegs = params[i];
            } else if (params[i].contains("caption")) {
                oldCaption = params[i];
            } else if (params[i].contains("center")) {
                oldCenter = params[i];
            }
        }
        if (!oldLegs.equals("") && !oldCaption.equals("") && !oldCenter.equals("")) {
            originalUrl = originalUrl.replace(oldLegs, newLegs).replace(oldCaption, caption2).replace(oldCenter, center);
            Log.e("GENERATED RADAR URL", originalUrl);
        }
        this.marketCalDetails.setURLRadar(originalUrl);
    }

    private void getChartImageByInstrumentAndCaption(String caption) {
        String newInstrument = "instrument=" + Utils.getInstrumentByCaption(caption);
        String caption2 = "caption=" + caption;
        String oldInstrument = "";
        String oldCaption = "";
        String originalUrl = this.marketCalDetails.getURLChart();
        String[] params = originalUrl.split("\\?")[1].split("\\&");
        for (int i = 0; i < params.length; i++) {
            if (params[i].contains("instrument")) {
                oldInstrument = params[i];
            } else if (params[i].contains("caption")) {
                oldCaption = params[i];
            }
        }
        if (!oldCaption.equals("") && !oldInstrument.equals("")) {
            originalUrl = originalUrl.replace(oldCaption, caption2).replace(oldInstrument, newInstrument);
            Log.e("GENERATED CHART URL", originalUrl);
        }
        this.marketCalDetails.setURLChart(originalUrl);
    }

    private void showInstrumentAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(C0089R.string.select).setSingleChoiceItems(C0089R.array.caption_array, this.instrumentItemIndex, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MarketImpactFragment.this.instrumentItemIndex = which;
                MarketImpactFragment.this.changeInstrumentAndCaption(MarketImpactFragment.this.captions[which]);
                MarketImpactFragment.this.btnInstruments.setText(MarketImpactFragment.this.captions[which]);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.idMarketCalDetails.btnInstruments:
                showInstrumentAlert();
                return;
            default:
                return;
        }
    }
}
