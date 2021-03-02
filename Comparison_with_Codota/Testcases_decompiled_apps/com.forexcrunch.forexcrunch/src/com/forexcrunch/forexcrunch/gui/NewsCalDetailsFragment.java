package com.forexcrunch.forexcrunch.gui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.NewsCalDetailsListAdapter;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.NewsCalDetails;
import java.util.ArrayList;

public class NewsCalDetailsFragment extends ListFragment {
    ArrayList<NewsCalDetails> newsCalDetailsList;
    public TextView tvDate;
    public TextView tvProvider;
    public TextView tvTitle;
    WebView webView;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.newsCalDetailsList = NewsController.getInstance(getActivity()).getNewsCalDetailsList();
        if (this.newsCalDetailsList == null || this.newsCalDetailsList.isEmpty()) {
            getListView().setEmptyView(noItems(getResources().getString(C0089R.string.no_items)));
        } else {
            setListAdapter(new NewsCalDetailsListAdapter(getActivity(), C0089R.layout.news_list_item_calendar_details, this.newsCalDetailsList));
        }
    }

    private TextView noItems(String text) {
        TextView emptyView = new TextView(getActivity());
        emptyView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        emptyView.setTextColor(getResources().getColor(17170444));
        emptyView.setText(text);
        emptyView.setTextSize(14.0f);
        emptyView.setVisibility(0);
        emptyView.setGravity(17);
        ((ViewGroup) getListView().getParent()).addView(emptyView);
        return emptyView;
    }

    public void onListItemClick(ListView l, View view, int position, long id) {
        super.onListItemClick(l, view, position, id);
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.news_calendar_details_fragment_dialog_background);
        dialog.setContentView(C0089R.layout.news_calendar_details_fragment_dialog);
        ((TextView) dialog.findViewById(C0089R.C0090id.NewsCalendarDetailsFragmentDialog_tvTitle)).setText(this.newsCalDetailsList.get(position).getTitle());
        ((TextView) dialog.findViewById(C0089R.C0090id.NewsCalendarDetailsFragmentDialog_tvDate)).setText(this.newsCalDetailsList.get(position).getDateTime().getFormattedString());
        ((TextView) dialog.findViewById(C0089R.C0090id.NewsCalendarDetailsFragmentDialog_tvProvider)).setText(this.newsCalDetailsList.get(position).getProvider());
        this.webView = (WebView) dialog.findViewById(C0089R.C0090id.NewsCalendarDetailsFragmentDialog_webView);
        this.webView.setBackgroundColor(getResources().getColor(C0089R.color.bg_lectura));
        setHTMLContent(this.newsCalDetailsList.get(position).getNewscalendarContent().getContent());
        dialog.show();
    }

    private void setHTMLContent(String content) {
        this.webView.getSettings().setDefaultTextEncodingName("utf-8");
        this.webView.loadDataWithBaseURL((String) null, "<html><head><style type='text/css'>img {width:" + getResources().getInteger(C0089R.integer.html_dialog_width) + "px; height:auto;} * {width:" + getResources().getInteger(C0089R.integer.html_dialog_width) + "px; height:auto;}</style><body>" + content + "</body></html>", "text/html", "utf-8", (String) null);
        this.webView.setWebViewClient(new CustomWebViewClient(this, (CustomWebViewClient) null));
    }

    private class CustomWebViewClient extends WebViewClient {
        private CustomWebViewClient() {
        }

        /* synthetic */ CustomWebViewClient(NewsCalDetailsFragment newsCalDetailsFragment, CustomWebViewClient customWebViewClient) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
            Intent linkIntent = new Intent(NewsCalDetailsFragment.this.getActivity(), WebViewActivity.class);
            linkIntent.putExtra("url", url);
            NewsCalDetailsFragment.this.startActivity(linkIntent);
            return true;
        }
    }
}
