package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import android.content.Context;
import android.database.Cursor;
import android.support.p001v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.InspectionsAdapter */
public final class InspectionsAdapter extends CursorAdapter {

    /* renamed from: a */
    static final SimpleDateFormat f5295a = new SimpleDateFormat("HH:mm dd-MM-yyyy", Locale.ROOT);

    /* renamed from: b */
    private final Context f5296b;

    /* renamed from: c */
    private final LayoutInflater f5297c;

    public InspectionsAdapter(Context context, InspectionsTable.DataCursor dataCursor) {
        super(context, (Cursor) dataCursor, 2);
        this.f5296b = context;
        this.f5297c = LayoutInflater.from(context);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        InspectionsTable.DataCursor dataCursor = (InspectionsTable.DataCursor) cursor;
        TextView textView = (TextView) view.findViewById(16908309);
        ProgressBar progressBar = (ProgressBar) view.findViewById(16908301);
        ImageView imageView = (ImageView) view.findViewById(16908293);
        ((TextView) view.findViewById(16908308)).setText(dataCursor.getTitle());
        progressBar.setProgress((int) (dataCursor.getProgress() * ((float) progressBar.getMax())));
        ((TextView) view.findViewById(16908304)).setText(f5295a.format(Long.valueOf(dataCursor.getCreationDate().getTime())));
        if (dataCursor.hasProjectServerId()) {
            textView.setText(Schema.getProjects().getProjectName(dataCursor.getProjectServerId().longValue()));
        } else {
            textView.setText(dataCursor.getDescription());
        }
        int formCount = dataCursor.getStats().getFormCount(dataCursor.getFormServerId());
        int formOrdinal = dataCursor.getFormOrdinal();
        if (formCount <= 1 || formOrdinal <= -1) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setImageDrawable(IconUtil.get(context, formOrdinal));
        imageView.setVisibility(0);
    }

    public InspectionsTable.DataCursor getCursor() {
        return (InspectionsTable.DataCursor) super.getCursor();
    }

    public InspectionsTable.DataCursor getItem(int i) {
        return (InspectionsTable.DataCursor) super.getItem(i);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f5297c.inflate(C1352R.layout.inspections_item, viewGroup, false);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
