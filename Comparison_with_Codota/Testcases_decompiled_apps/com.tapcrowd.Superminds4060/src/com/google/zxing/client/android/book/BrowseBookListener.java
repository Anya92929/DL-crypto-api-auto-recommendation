package com.google.zxing.client.android.book;

import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.View;
import android.widget.AdapterView;
import com.google.zxing.client.android.LocaleManager;
import java.util.List;

final class BrowseBookListener implements AdapterView.OnItemClickListener {
    private final SearchBookContentsActivity activity;
    private final List<SearchBookContentsResult> items;

    BrowseBookListener(SearchBookContentsActivity activity2, List<SearchBookContentsResult> items2) {
        this.activity = activity2;
        this.items = items2;
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        int itemOffset;
        if (position >= 1 && position - 1 < this.items.size()) {
            String pageId = this.items.get(itemOffset).getPageId();
            String query = SearchBookContentsResult.getQuery();
            if (LocaleManager.isBookSearchUrl(this.activity.getISBN()) && !pageId.isEmpty()) {
                String uri = this.activity.getISBN();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://books.google." + LocaleManager.getBookSearchCountryTLD(this.activity) + "/books?id=" + uri.substring(uri.indexOf(61) + 1) + "&pg=" + pageId + "&vq=" + query));
                intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                this.activity.startActivity(intent);
            }
        }
    }
}
