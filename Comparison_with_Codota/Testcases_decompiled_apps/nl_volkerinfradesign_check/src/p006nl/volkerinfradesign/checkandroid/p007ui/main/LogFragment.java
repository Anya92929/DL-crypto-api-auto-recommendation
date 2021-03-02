package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.p001v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.HashSet;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.Logger;
import p006nl.volkerinfradesign.checkandroid.util.LongSparseBooleanArray;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.LogFragment */
public class LogFragment extends ListFragment {

    /* renamed from: aj */
    private LongSparseBooleanArray f5435aj;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Logger.Verbosity[] f5436i = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5436i = (Logger.Verbosity[]) bundle.getSerializable("log_activity:verbosities");
            this.f5435aj = (LongSparseBooleanArray) bundle.getParcelable("log_activity:show_traces");
            return;
        }
        this.f5435aj = new LongSparseBooleanArray();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.log_menu_2, menu);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyText("Geen logs aanwezig");
        setListAdapter(new C1675a());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [nl.volkerinfradesign.checkandroid.environments.Logger$Verbosity[], java.io.Serializable] */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("log_activity:verbosities", this.f5436i);
        bundle.putParcelable("log_activity:show_traces", this.f5435aj);
    }

    public void onDestroyView() {
        getListAdapter().changeCursor((Cursor) null);
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1352R.C1354id.filter) {
            return super.onOptionsItemSelected(menuItem);
        }
        m6313l();
        return true;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        boolean z;
        super.onListItemClick(listView, view, i, j);
        C1675a listAdapter = getListAdapter();
        LongSparseBooleanArray longSparseBooleanArray = this.f5435aj;
        if (!((Boolean) this.f5435aj.get(j, false)).booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        longSparseBooleanArray.put(j, Boolean.valueOf(z));
        m6308a(view, listAdapter.getItem(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6308a(View view, Logger.LogCursor logCursor) {
        String str;
        TextView textView = (TextView) view.findViewById(16908308);
        TextView textView2 = (TextView) view.findViewById(16908309);
        String name = logCursor.getVerbosity().name();
        if (logCursor.hasThrowable()) {
            str = name + ": " + logCursor.getThrowable(((Boolean) this.f5435aj.get(logCursor.getId(), false)).booleanValue(), true);
        } else {
            str = name;
        }
        textView.setText(logCursor.getMessage());
        textView2.setText(str);
    }

    public C1675a getListAdapter() {
        return (C1675a) super.getListAdapter();
    }

    /* renamed from: l */
    private void m6313l() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final Logger.Verbosity[] values = Logger.Verbosity.values();
        final int length = values.length;
        CharSequence[] charSequenceArr = new CharSequence[length];
        final boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            charSequenceArr[i] = values[i].toString();
            zArr[i] = ArrayUtils.contains((Object[]) this.f5436i, (Object) values[i]);
        }
        builder.setTitle("Filteren");
        builder.setMultiChoiceItems(charSequenceArr, zArr, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                zArr[i] = z;
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < length; i2++) {
                    if (zArr[i2]) {
                        hashSet.add(values[i2]);
                    }
                }
                Logger.Verbosity[] unused = LogFragment.this.f5436i = (Logger.Verbosity[]) hashSet.toArray(new Logger.Verbosity[hashSet.size()]);
                LogFragment.this.getListAdapter().changeCursor(LogFragment.this.m6314m().getModel().getLogger().get(LogFragment.this.f5436i));
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public App m6314m() {
        return (App) getActivity().getApplication();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.LogFragment$a */
    final class C1675a extends CursorAdapter {

        /* renamed from: b */
        private final LayoutInflater f5444b = LogFragment.this.getActivity().getLayoutInflater();

        public C1675a() {
            super(LogFragment.this.getActivity(), LogFragment.this.m6314m().getModel().getLogger().get(LogFragment.this.f5436i), 0);
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return this.f5444b.inflate(17367063, viewGroup, false);
        }

        public void bindView(View view, Context context, Cursor cursor) {
            LogFragment.this.m6308a(view, (Logger.LogCursor) cursor);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int i) {
            return getItem(i).hasThrowable();
        }

        /* renamed from: a */
        public Logger.LogCursor getItem(int i) {
            return (Logger.LogCursor) super.getItem(i);
        }
    }
}
