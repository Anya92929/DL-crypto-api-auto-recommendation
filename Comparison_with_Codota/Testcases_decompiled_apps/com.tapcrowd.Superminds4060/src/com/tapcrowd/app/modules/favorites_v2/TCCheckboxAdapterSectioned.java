package com.tapcrowd.app.modules.favorites_v2;

import android.annotation.SuppressLint;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.TCCheckboxAdapter;
import com.tapcrowd.app.utils.TCListObject;
import java.util.List;

@SuppressLint({"ViewConstructor"})
class TCCheckboxAdapterSectioned extends TCCheckboxAdapter {
    public TCCheckboxAdapterSectioned(List<Object> list, TCCheckboxAdapter.onCheckboxClickListener onCheckboxClickListener) {
        super(list, onCheckboxClickListener);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Object o = getItem(position);
        if (o.getClass() == String.class) {
            View convertView2 = LayoutInflater.from(getContext()).inflate(C0846R.layout.separator, (ViewGroup) null);
            TextView tv = (TextView) convertView2.findViewById(C0846R.C0847id.text);
            convertView2.setTag("sep");
            C1232UI.setFont(tv);
            tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
            tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
            tv.setText((String) o);
            return convertView2;
        } else if (!(o instanceof TCListObject)) {
            return new View(getContext());
        } else {
            TCListObject tlo = (TCListObject) o;
            if (tlo.getRemove()) {
                View convertView3 = LayoutInflater.from(getContext()).inflate(C0846R.layout.cell_tcremove, (ViewGroup) null);
                DisplayMetrics dm = parent.getContext().getResources().getDisplayMetrics();
                Holder holder = new Holder((Holder) null);
                holder.sub1 = (TextView) convertView3.findViewById(C0846R.C0847id.dismissundo);
                holder.sub1.setText("Undo Delete");
                holder.sub1.setWidth(dm.widthPixels / 2);
                holder.text = (TextView) convertView3.findViewById(C0846R.C0847id.dismisstext);
                holder.text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
                holder.text.setWidth(dm.widthPixels / 2);
                convertView3.setTag("dismissed");
                return convertView3;
            }
            if (convertView == null || convertView.getTag() == null || !convertView.getTag().equals("tlo")) {
                convertView = LayoutInflater.from(getContext()).inflate(this.layout, (ViewGroup) null);
                C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.text));
                C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub1));
                C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub2));
                convertView.setTag("tlo");
            }
            Holder holder2 = new Holder((Holder) null);
            holder2.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
            holder2.sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
            holder2.sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
            holder2.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
            holder2.arrow = (ImageView) convertView.findViewById(C0846R.C0847id.arrow);
            holder2.checkbox = (CheckBox) convertView.findViewById(C0846R.C0847id.checkbox);
            holder2.text.setTextColor(this.textColor);
            holder2.sub1.setTextColor(this.textColor);
            holder2.sub2.setTextColor(this.textColor);
            convertView.setBackgroundColor(0);
            setText(holder2.text, tlo.getText());
            setText(holder2.sub1, tlo.getSub1());
            setText(holder2.sub2, tlo.getSub2());
            holder2.arrow.setVisibility(0);
            holder2.icon.setVisibility(8);
            if (tlo.getImg() != null) {
                if (this.defaultImage != 0) {
                    if (C1216LO.getLoDrawable(C1216LO.placeholder) != null) {
                        holder2.icon.setImageDrawable(C1216LO.getLoDrawable(C1216LO.placeholder));
                    } else if (tlo.getDefaultresource() != C0846R.drawable.icon) {
                        holder2.icon.setImageDrawable(C1232UI.getColorOverlay(this.defaultImage, C1216LO.getLo(C1216LO.placeholderOverlayColor)));
                    } else {
                        holder2.icon.setImageResource(this.defaultImage);
                    }
                }
                if (!tlo.getImg().equals("")) {
                    this.fil.DisplayImage(tlo.getImg(), holder2.icon, holder2.icon.getLayoutParams().height, holder2.icon.getLayoutParams().width);
                }
            }
            holder2.checkbox.setOnCheckedChangeListener(new TCCheckboxAdapter.CheckChangedListener(tlo.getId(), convertView));
            if (this.ids.contains(tlo.getId())) {
                convertView.setBackgroundColor(getContext().getResources().getColor(17170459));
                holder2.checkbox.setChecked(true);
            } else {
                convertView.setBackgroundColor(0);
                holder2.checkbox.setChecked(false);
            }
            return convertView;
        }
    }

    private static class Holder {
        ImageView arrow;
        CheckBox checkbox;
        ImageView icon;
        TextView sub1;
        TextView sub2;
        TextView text;

        private Holder() {
        }

        /* synthetic */ Holder(Holder holder) {
            this();
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
