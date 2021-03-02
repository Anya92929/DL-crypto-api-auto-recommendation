package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.NewsSimpleListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import java.util.ArrayList;

public class SearchResultsActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView list;
    private DisplayImageOptions options;
    private News searchResults;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.search_results_activity);
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        this.list = (ListView) findViewById(C0089R.idSearchResults.list);
        this.list.setOnItemClickListener(this);
        String query = "";
        if (getIntent().hasExtra("searchQuery")) {
            query = getIntent().getStringExtra("searchQuery");
        }
        TextView tvQuery = (TextView) findViewById(C0089R.idSearchResults.query);
        tvQuery.setText(tvQuery.getText().toString().replace("*", "\"" + query + "\""));
        this.searchResults = NewsController.getInstance(this).getSearchResults();
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        Post item = ((NewsSimpleListAdapter) this.list.getAdapter()).getItems().get(position);
        addReadPostToPreferences(item.getId());
        NewsController.getInstance(this).setSelectedPost(item);
        startActivity(new Intent(this, NewsContentActivity.class));
    }

    private void addReadPostToPreferences(int id) {
        int category = ((NewsSimpleListAdapter) this.list.getAdapter()).getCategory();
        ArrayList<Integer> readMsgIds = Utils.createIdsList(this, category);
        if (readMsgIds.isEmpty()) {
            readMsgIds.add(Integer.valueOf(id));
        } else if (!readMsgIds.contains(Integer.valueOf(id))) {
            readMsgIds.add(Integer.valueOf(id));
        }
        Utils.idListToPreferences(this, readMsgIds, category);
    }

    public void onResume() {
        if (this.list.getAdapter() != null || this.searchResults == null) {
            ((NewsSimpleListAdapter) this.list.getAdapter()).notifyDataSetChanged();
        } else {
            this.list.setAdapter(new NewsSimpleListAdapter(this, C0089R.layout.news_simple_list_item, this.searchResults.getPostsList(), this.options, 0));
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }
}
