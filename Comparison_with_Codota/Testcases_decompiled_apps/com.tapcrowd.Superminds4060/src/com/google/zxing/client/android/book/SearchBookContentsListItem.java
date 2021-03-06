package com.google.zxing.client.android.book;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.client.android.C0776R;
import java.util.Locale;

public final class SearchBookContentsListItem extends LinearLayout {
    private TextView pageNumberView;
    private TextView snippetView;

    SearchBookContentsListItem(Context context) {
        super(context);
    }

    public SearchBookContentsListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.pageNumberView = (TextView) findViewById(C0776R.C0777id.page_number_view);
        this.snippetView = (TextView) findViewById(C0776R.C0777id.snippet_view);
    }

    public void set(SearchBookContentsResult result) {
        this.pageNumberView.setText(result.getPageNumber());
        String snippet = result.getSnippet();
        if (snippet.isEmpty()) {
            this.snippetView.setText("");
        } else if (result.getValidSnippet()) {
            String lowerQuery = SearchBookContentsResult.getQuery().toLowerCase(Locale.getDefault());
            String lowerSnippet = snippet.toLowerCase(Locale.getDefault());
            Spannable styledSnippet = new SpannableString(snippet);
            StyleSpan boldSpan = new StyleSpan(1);
            int queryLength = lowerQuery.length();
            int offset = 0;
            while (true) {
                int pos = lowerSnippet.indexOf(lowerQuery, offset);
                if (pos < 0) {
                    this.snippetView.setText(styledSnippet);
                    return;
                } else {
                    styledSnippet.setSpan(boldSpan, pos, pos + queryLength, 0);
                    offset = pos + queryLength;
                }
            }
        } else {
            this.snippetView.setText(snippet);
        }
    }
}
