package com.tapcrowd.app.utils;

import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.List;

public class TCCheckboxAdapter extends ArrayAdapter<Object> {
    protected int defaultImage;
    protected FastImageLoader fil;
    protected List<String> ids;
    List<Object> items;
    protected int layout;
    protected onCheckboxClickListener listener;
    protected int textColor;

    public interface onCheckboxClickListener {
        void onCheckboxClicked(List<String> list);
    }

    public TCCheckboxAdapter(List<Object> list, onCheckboxClickListener onCheckboxClickListener2) {
        this(list, 0, onCheckboxClickListener2);
    }

    public TCCheckboxAdapter(List<Object> list, int defaultImage2, onCheckboxClickListener listener2) {
        super(App.act, 0, list);
        this.fil = new FastImageLoader();
        this.layout = C0846R.layout.cell_tcobject_checkbox;
        this.textColor = C1216LO.getLo(C1216LO.textcolor);
        this.defaultImage = 0;
        this.ids = new ArrayList();
        this.items = new ArrayList();
        this.defaultImage = defaultImage2;
        this.listener = listener2;
        this.items.addAll(list);
    }

    public List<String> getIds() {
        return this.ids;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Object o = getItem(position);
        if (!(o instanceof TCListObject)) {
            return new View(getContext());
        }
        TCListObject tlo = (TCListObject) o;
        if (tlo.getRemove()) {
            View convertView2 = LayoutInflater.from(getContext()).inflate(C0846R.layout.cell_tcremove, (ViewGroup) null);
            DisplayMetrics dm = parent.getContext().getResources().getDisplayMetrics();
            Holder holder = new Holder((Holder) null);
            holder.sub1 = (TextView) convertView2.findViewById(C0846R.C0847id.dismissundo);
            holder.sub1.setText("Undo Delete");
            holder.sub1.setWidth(dm.widthPixels / 2);
            holder.text = (TextView) convertView2.findViewById(C0846R.C0847id.dismisstext);
            holder.text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
            holder.text.setWidth(dm.widthPixels / 2);
            convertView2.setTag("dismissed");
            return convertView2;
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
        holder2.checkbox.setOnCheckedChangeListener(new CheckChangedListener(tlo.getId(), convertView));
        if (this.ids.contains(tlo.getId())) {
            convertView.setBackgroundColor(getContext().getResources().getColor(17170459));
            holder2.checkbox.setChecked(true);
        } else {
            convertView.setBackgroundColor(0);
            holder2.checkbox.setChecked(false);
        }
        return convertView;
    }

    protected class CheckChangedListener implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: id */
        String f2130id;

        /* renamed from: v */
        View f2131v;

        public CheckChangedListener(String id, View v) {
            this.f2130id = id;
            this.f2131v = v;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked && !TCCheckboxAdapter.this.ids.contains(this.f2130id)) {
                TCCheckboxAdapter.this.ids.add(this.f2130id);
                this.f2131v.setBackgroundColor(TCCheckboxAdapter.this.getContext().getResources().getColor(17170459));
            } else if (!isChecked && TCCheckboxAdapter.this.ids.contains(this.f2130id)) {
                TCCheckboxAdapter.this.ids.remove(this.f2130id);
                this.f2131v.setBackgroundColor(0);
            }
            if (TCCheckboxAdapter.this.listener != null) {
                TCCheckboxAdapter.this.listener.onCheckboxClicked(TCCheckboxAdapter.this.ids);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setText(TextView tv, String text) {
        if (text == null) {
            tv.setVisibility(8);
        } else {
            tv.setText(text);
        }
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public void publishResults(CharSequence constraint, Filter.FilterResults results) {
                TCCheckboxAdapter.this.clear();
                TCCheckboxAdapter.this.addAll((List) results.values);
                TCCheckboxAdapter.this.notifyDataSetChanged();
            }

            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence constraint) {
                CharSequence constraint2 = constraint.toString().toLowerCase();
                Filter.FilterResults result = new Filter.FilterResults();
                List<Object> filt = new ArrayList<>();
                List<Object> buffer = new ArrayList<>();
                if (constraint2 == null || constraint2.toString().length() <= 0) {
                    result.count = TCCheckboxAdapter.this.items.size();
                    result.values = TCCheckboxAdapter.this.items;
                } else {
                    boolean isDiacritical = false;
                    int l = constraint2.length();
                    for (int i = 0; i < l; i++) {
                        if (constraint2.charAt(i) > 127) {
                            isDiacritical = true;
                        }
                    }
                    int l2 = TCCheckboxAdapter.this.items.size();
                    for (int i2 = 0; i2 < l2; i2++) {
                        if (TCCheckboxAdapter.this.items.get(i2).getClass() == TCListObject.class) {
                            TCListObject tlo = (TCListObject) TCCheckboxAdapter.this.items.get(i2);
                            String text = tlo.getText().toLowerCase();
                            if (!isDiacritical) {
                                text = Normalizer.removeDiacritic(text);
                            }
                            if (text.contains(constraint2) || (tlo.getSearch() != null && tlo.getSearch().toLowerCase().contains(constraint2))) {
                                buffer.add(tlo);
                            }
                        } else {
                            buffer.add(TCCheckboxAdapter.this.items.get(i2));
                        }
                    }
                    int l3 = buffer.size();
                    for (int i3 = 0; i3 < l3; i3++) {
                        Object buf = buffer.get(i3);
                        if (buf.getClass() != String.class) {
                            filt.add(buf);
                        } else if (i3 + 1 < l3 && buffer.get(i3 + 1).getClass() == TCListObject.class) {
                            filt.add(buf);
                        }
                    }
                    result.count = filt.size();
                    result.values = filt;
                }
                return result;
            }
        };
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
