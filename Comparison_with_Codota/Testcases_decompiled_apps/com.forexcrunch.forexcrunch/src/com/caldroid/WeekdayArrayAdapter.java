package com.caldroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import org.achartengine.renderer.DefaultRenderer;

public class WeekdayArrayAdapter extends ArrayAdapter<String> {
    public static int textColor = DefaultRenderer.TEXT_COLOR;

    public WeekdayArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int position) {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        if (((String) getItem(position)).length() <= 3) {
            textView.setTextSize(2, 12.0f);
        } else {
            textView.setTextSize(2, 11.0f);
        }
        textView.setTextColor(textColor);
        textView.setGravity(17);
        return textView;
    }
}
