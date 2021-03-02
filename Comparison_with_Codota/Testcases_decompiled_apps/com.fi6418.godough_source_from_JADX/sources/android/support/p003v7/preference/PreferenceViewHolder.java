package android.support.p003v7.preference;

import android.support.p003v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/* renamed from: android.support.v7.preference.PreferenceViewHolder */
public class PreferenceViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: k */
    private final SparseArray<View> f2519k = new SparseArray<>(4);

    PreferenceViewHolder(View view) {
        super(view);
        this.f2519k.put(16908310, view.findViewById(16908310));
        this.f2519k.put(16908304, view.findViewById(16908304));
        this.f2519k.put(16908294, view.findViewById(16908294));
        this.f2519k.put(C0268R.C0270id.icon_frame, view.findViewById(C0268R.C0270id.icon_frame));
    }

    public View findViewById(int i) {
        View view = this.f2519k.get(i);
        if (view == null && (view = this.itemView.findViewById(i)) != null) {
            this.f2519k.put(i, view);
        }
        return view;
    }
}
