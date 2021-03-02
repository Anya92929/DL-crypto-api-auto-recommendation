package com.tapcrowd.app.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.List;

public class ThumbsAdapter extends BaseAdapter {
    private List<Object> content;
    private Context context;
    private FastImageLoader fil = new FastImageLoader();
    private int layout;

    public ThumbsAdapter(Context context2, List<Object> content2, int layout2) {
        this.context = context2;
        this.content = content2;
        this.layout = layout2;
    }

    public int getCount() {
        return this.content.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(this.layout, (ViewGroup) null);
        }
        TextView text = (TextView) convertView.findViewById(C0846R.C0847id.text);
        TextView sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
        TextView sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
        TextView sub3 = (TextView) convertView.findViewById(C0846R.C0847id.sub3);
        ImageView icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
        Object o = this.content.get(position);
        if (!(o instanceof TCListObject)) {
            return new View(this.context);
        }
        TCListObject tlo = (TCListObject) o;
        setText(text, tlo.getText());
        setText(sub1, tlo.getSub1());
        setText(sub2, tlo.getSub2());
        setText(sub3, tlo.getSub3());
        if (icon == null) {
            return convertView;
        }
        icon.setImageDrawable((Drawable) null);
        if (tlo.getImg() == null) {
            icon.setVisibility(8);
            return convertView;
        }
        this.fil.DisplayImage(tlo.getImg(), icon);
        return convertView;
    }

    private void setText(TextView tv, String text) {
        if (tv == null) {
            return;
        }
        if (text == null) {
            tv.setVisibility(8);
        } else {
            tv.setText(text);
        }
    }
}
