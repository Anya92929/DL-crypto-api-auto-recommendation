package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.CommentsListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.Comment;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;
import com.google.analytics.tracking.android.EasyTracker;
import java.util.ArrayList;
import java.util.Iterator;

public class CommentsActivity extends Activity implements AdListener {
    private DfpAdView adView;
    ExpandableListView list;
    TextView tvCommentsCount;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.comments_activity);
        ArrayList<Comment> commentList = NewsController.getInstance(this).getSelectedPost().getComments();
        this.tvCommentsCount = (TextView) findViewById(C0089R.idCommentsActivity.tvCommentsCount);
        this.list = (ExpandableListView) findViewById(C0089R.idCommentsActivity.list);
        this.list.setAdapter(new CommentsListAdapter(this, getParentList(commentList)));
        this.tvCommentsCount.setText(Utils.insertZeroIfLessThanTen(commentList.size()));
        createAd();
    }

    private ArrayList<Comment> getParentList(ArrayList<Comment> commentList) {
        ArrayList<Comment> parentList = new ArrayList<>();
        Iterator<Comment> it = commentList.iterator();
        while (it.hasNext()) {
            Comment comment = it.next();
            if (comment.getParent() == 0) {
                parentList.add(comment);
            }
        }
        return parentList;
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.list.setIndicatorBounds(this.list.getRight() - 40, this.list.getWidth());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    private void createAd() {
        this.adView = new DfpAdView((Activity) this, new AdSize(320, 50), "/16866187/mobapp_320x50");
        ((LinearLayout) findViewById(C0089R.idCommentsActivity.f53ad)).addView(this.adView);
        this.adView.loadAd(new AdRequest());
        this.adView.setAdListener(this);
    }

    public void onDismissScreen(C0165Ad arg0) {
    }

    public void onFailedToReceiveAd(C0165Ad arg0, AdRequest.ErrorCode arg1) {
    }

    public void onLeaveApplication(C0165Ad arg0) {
    }

    public void onPresentScreen(C0165Ad arg0) {
    }

    public void onReceiveAd(C0165Ad arg0) {
    }
}
