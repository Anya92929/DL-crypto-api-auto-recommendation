package com.tapcrowd.app.utils;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TCListObject2 {
    public boolean arrow = false;
    public int celLayout;
    public Drawable defaultDrawable = null;
    public int defaultImage = 0;

    /* renamed from: id */
    public String f2134id;
    public String img = null;
    public HashMap<Integer, String> params = new HashMap<>();
    public Date time;

    public TCListObject2() {
    }

    public TCListObject2(String id, HashMap<Integer, String> params2, int celLayout2, int defaultImage2, String img2, boolean arrow2) {
        this.f2134id = id;
        this.params = params2;
        this.celLayout = celLayout2;
        this.defaultImage = defaultImage2;
        this.img = img2;
        this.arrow = arrow2;
    }

    public void setField(int key, String value) {
        this.params.put(Integer.valueOf(key), value);
    }

    public static class TCListObjectAdapter2 extends ArrayAdapter<TCListObject2> {
        private FastImageLoader fil = new FastImageLoader();
        private LayoutInflater mInflater = LayoutInflater.from(App.act);
        int selectedindex = -1;

        public TCListObjectAdapter2(List list) {
            super(App.act, 0, list);
        }

        public void setSelectedIndex(int selectedindex2, ListView lv) {
            this.selectedindex = selectedindex2;
            lv.invalidateViews();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            try {
                Object o = getItem(position);
                if (o.getClass() == TCListObject2.class) {
                    TCListObject2 tlo = (TCListObject2) getItem(position);
                    convertView = this.mInflater.inflate(tlo.celLayout, (ViewGroup) null);
                    if (position == this.selectedindex) {
                        convertView.setBackgroundColor(C1216LO.getLo(C1216LO.tableviewHighlight));
                    } else {
                        convertView.setBackgroundColor(0);
                    }
                    for (Integer intValue : tlo.params.keySet()) {
                        int id = intValue.intValue();
                        String value = tlo.params.get(Integer.valueOf(id));
                        TextView tv2 = (TextView) convertView.findViewById(id);
                        if (value == null) {
                            tv2.setVisibility(8);
                        }
                        tv2.setText(value);
                        tv2.setTextColor(C1216LO.getLo(C1216LO.textcolor));
                    }
                    ImageView icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                    icon.setVisibility(0);
                    if (tlo.img != null && !tlo.img.equals("")) {
                        this.fil.DisplayImage(tlo.img, icon, icon.getLayoutParams().height, icon.getLayoutParams().width);
                    } else if (tlo.defaultImage != 0) {
                        icon.setImageResource(tlo.defaultImage);
                    } else {
                        icon.setVisibility(8);
                    }
                    if (tlo.arrow) {
                        convertView.findViewById(C0846R.C0847id.arrow).setVisibility(0);
                    }
                    return convertView;
                }
                if (o.getClass() == String.class) {
                    if (position == 0) {
                        position = 1;
                    }
                    if (convertView == null) {
                        convertView = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                        tv = (TextView) convertView.findViewById(C0846R.C0847id.text);
                        convertView.setTag(tv);
                    } else {
                        try {
                            tv = (TextView) convertView.getTag();
                        } catch (Exception e) {
                            convertView = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                            tv = (TextView) convertView.findViewById(C0846R.C0847id.text);
                            convertView.setTag(tv);
                            if (position > 0) {
                                Log.d("TapCrowd", "ConvertView fail - this: " + ((TCListObject2) getItem(position)).getClass() + "   prev:" + ((TCListObject2) getItem(position - 1)).getClass());
                            } else {
                                Log.d("TapCrowd", "ConvertView fail - pos = 0");
                            }
                        }
                    }
                    tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                    tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                    tv.setText((String) o);
                    return convertView;
                }
                return convertView;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
