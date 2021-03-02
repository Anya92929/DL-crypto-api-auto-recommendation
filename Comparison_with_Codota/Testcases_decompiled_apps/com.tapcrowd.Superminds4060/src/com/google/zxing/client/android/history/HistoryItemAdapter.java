package com.google.zxing.client.android.history;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.Result;
import com.google.zxing.client.android.C0776R;
import java.util.ArrayList;

final class HistoryItemAdapter extends ArrayAdapter<HistoryItem> {
    private final Activity activity;

    HistoryItemAdapter(Activity activity2) {
        super(activity2, C0776R.layout.history_list_item, new ArrayList());
        this.activity = activity2;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LinearLayout layout;
        String title;
        String detail;
        if (view instanceof LinearLayout) {
            layout = (LinearLayout) view;
        } else {
            layout = (LinearLayout) LayoutInflater.from(this.activity).inflate(C0776R.layout.history_list_item, viewGroup, false);
        }
        HistoryItem item = (HistoryItem) getItem(position);
        Result result = item.getResult();
        if (result != null) {
            title = result.getText();
            detail = item.getDisplayAndDetails();
        } else {
            Resources resources = getContext().getResources();
            title = resources.getString(C0776R.string.history_empty);
            detail = resources.getString(C0776R.string.history_empty_detail);
        }
        ((TextView) layout.findViewById(C0776R.C0777id.history_title)).setText(title);
        ((TextView) layout.findViewById(C0776R.C0777id.history_detail)).setText(detail);
        return layout;
    }
}
