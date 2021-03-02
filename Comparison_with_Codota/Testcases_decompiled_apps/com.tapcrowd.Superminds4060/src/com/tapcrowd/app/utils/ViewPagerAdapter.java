package com.tapcrowd.app.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<Object> content;
    private Context context;
    private FastImageLoader fil;
    private Fragment host;
    private int layout;
    private String metaType;

    public ViewPagerAdapter(Context context2, List<Object> content2, int layout2) {
        this(context2, content2, layout2, (Fragment) null, (String) null);
    }

    public ViewPagerAdapter(Context context2, List<Object> content2, int layout2, Fragment host2, String metaType2) {
        this.context = context2;
        this.content = content2;
        this.layout = layout2;
        this.host = host2;
        this.metaType = metaType2;
        this.fil = new FastImageLoader();
    }

    public int getCount() {
        return this.content.size();
    }

    public CharSequence getPageTitle(int position) {
        Object o = this.content.get(position);
        if (o instanceof TCListObject) {
            return ((TCListObject) o).getText();
        }
        return "";
    }

    public Object instantiateItem(ViewGroup collection, int position) {
        View convertView = LayoutInflater.from(this.context).inflate(this.layout, (ViewGroup) null);
        TextView text = (TextView) convertView.findViewById(C0846R.C0847id.text);
        TextView sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
        TextView sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
        TextView sub3 = (TextView) convertView.findViewById(C0846R.C0847id.sub3);
        ImageView icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
        Object o = this.content.get(position);
        if (o instanceof TCListObject) {
            TCListObject tlo = (TCListObject) o;
            setText(text, tlo.getText());
            setText(sub1, tlo.getSub1());
            setText(sub2, tlo.getSub2());
            setText(sub3, tlo.getSub3());
            if (icon != null) {
                icon.setImageDrawable((Drawable) null);
                if (tlo.getImg() == null) {
                    icon.setVisibility(8);
                } else {
                    this.fil.DisplayImage(tlo.getImg(), icon);
                }
            }
            if (this.metaType != null) {
                C1232UI.AddMetaData(this.host, this.metaType, tlo.getId(), convertView);
            }
            collection.addView(convertView);
            return convertView;
        }
        View v = new View(this.context);
        collection.addView(v);
        return v;
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

    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    public void finishUpdate(View arg0) {
    }

    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(View arg0) {
    }
}
