package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.help.HelpActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.AccountActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerListView */
public class DrawerListView extends ListView {

    /* renamed from: a */
    private MainActivity f5414a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View.OnClickListener f5415b = new View.OnClickListener() {
        public void onClick(View view) {
            App app = (App) DrawerListView.this.getActivity().getApplication();
            switch (C16695.f5424a[((DrawerItem) view.getTag()).ordinal()]) {
                case 1:
                    MainActivity activity = DrawerListView.this.getActivity();
                    activity.startActivity(new Intent(activity, AccountActivity.class));
                    return;
                case 2:
                    MainActivity activity2 = DrawerListView.this.getActivity();
                    activity2.startActivity(new Intent(activity2, HelpActivity.class));
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AtomicInteger f5416c = new AtomicInteger();

    /* renamed from: d */
    private final View.OnClickListener f5417d = new View.OnClickListener() {
        public void onClick(View view) {
            switch (DrawerListView.this.f5416c.incrementAndGet()) {
                case 1:
                    new C1671a().executeOnExecutor(C1671a.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                case 5:
                    new LogTask(DrawerListView.this.getActivity()).executeOnExecutor(LogTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: e */
    private boolean f5418e = false;

    /* renamed from: f */
    private final DataSetObserver f5419f = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            DrawerAdapter adapter = DrawerListView.this.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }

        public void onInvalidated() {
            super.onInvalidated();
            DrawerAdapter adapter = DrawerListView.this.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetInvalidated();
            }
        }
    };

    public DrawerListView(Context context) {
        super(context);
        m6299a(context);
    }

    public DrawerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6299a(context);
    }

    public DrawerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6299a(context);
    }

    public MainActivity getActivity() {
        return this.f5414a;
    }

    public DrawerAdapter getAdapter() {
        ListAdapter adapter = super.getAdapter();
        if (adapter instanceof WrapperListAdapter) {
            adapter = ((WrapperListAdapter) adapter).getWrappedAdapter();
        }
        return (DrawerAdapter) adapter;
    }

    public DrawerItem getCheckedDrawerItem() {
        int checkedItemPosition = getCheckedItemPosition();
        switch (checkedItemPosition) {
            case -1:
                return null;
            default:
                return DrawerItem.values()[checkedItemPosition];
        }
    }

    public void onUserChanged() {
        DrawerAdapter adapter = getAdapter();
        if (adapter != null) {
            List unused = adapter.f5428d = Collections.unmodifiableList(DrawerItem.getAdapterContent());
            adapter.notifyDataSetChanged();
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f5418e) {
            throw new IllegalStateException();
        }
        super.setAdapter(listAdapter);
    }

    public void setChoiceMode(int i) {
        if (this.f5418e) {
            throw new IllegalStateException();
        }
        super.setChoiceMode(i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5414a != null) {
            ((App) this.f5414a.getApplication()).registerDataSetObserver(this.f5419f);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5414a != null) {
            ((App) this.f5414a.getApplication()).unregisterDataSetObserver(this.f5419f);
        }
    }

    /* access modifiers changed from: private */
    public App getApp() {
        return (App) getActivity().getApplication();
    }

    /* renamed from: a */
    private void m6299a(Context context) {
        this.f5414a = (MainActivity) context;
        App app = (App) this.f5414a.getApplication();
        try {
            PackageInfo packageInfo = app.getPackageManager().getPackageInfo(app.getPackageName(), 0);
            TextView textView = (TextView) inflate(context, C1352R.layout.drawer_footer, (ViewGroup) null);
            textView.setText("versie: " + packageInfo.versionName);
            textView.setOnClickListener(this.f5417d);
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DrawerListView.this.getActivity().startActivity(new Intent(DrawerListView.this.getApp(), LogActivity.class));
                    return true;
                }
            });
            addFooterView(textView, (Object) null, false);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        setAdapter((ListAdapter) new DrawerAdapter());
        this.f5418e = true;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerListView$DrawerAdapter */
    public class DrawerAdapter extends BaseAdapter {

        /* renamed from: b */
        private final EnumMap<DrawerItem, View> f5426b;

        /* renamed from: c */
        private final LayoutInflater f5427c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public List<DrawerItem> f5428d;

        private DrawerAdapter() {
            this.f5426b = new EnumMap<>(DrawerItem.class);
            this.f5427c = LayoutInflater.from(DrawerListView.this.getContext());
            this.f5428d = Collections.unmodifiableList(DrawerItem.getAdapterContent());
            this.f5426b.put(DrawerItem.B_NEW_FORM, this.f5427c.inflate(C1352R.layout.drawer_new_form, DrawerListView.this, false));
            this.f5426b.put(DrawerItem.C_OPEN_FORMS, this.f5427c.inflate(C1352R.layout.drawer_open_forms, DrawerListView.this, false));
            this.f5426b.put(DrawerItem.D_FINISHED_FORMS, this.f5427c.inflate(C1352R.layout.drawer_sent_forms, DrawerListView.this, false));
            this.f5426b.put(DrawerItem.E_TODOS, this.f5427c.inflate(C1352R.layout.drawer_todos, DrawerListView.this, false));
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public int getCount() {
            return this.f5428d.size();
        }

        public DrawerItem getItem(int i) {
            try {
                return this.f5428d.get(i);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return null;
            }
        }

        public long getItemId(int i) {
            return (long) getItem(i).ordinal();
        }

        public int getItemViewType(int i) {
            return getItem(i).getViewType();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            DrawerItem item = getItem(i);
            switch (getItemViewType(i)) {
                case 1:
                    view2 = view;
                    break;
                case 2:
                    if (view == null) {
                        view2 = this.f5427c.inflate(C1352R.layout.drawer_button, viewGroup, false);
                    } else {
                        view2 = view;
                    }
                    Button button = (Button) view2;
                    button.setOnClickListener(DrawerListView.this.f5415b);
                    button.setTag(item);
                    button.setText(item.getText(DrawerListView.this.getContext()));
                    break;
                default:
                    View view3 = this.f5426b.get(item);
                    switch (item) {
                        case C_OPEN_FORMS:
                            m6303a(view3, Schema.getInspectionData().getOpenCount(false));
                            return view3;
                        case D_FINISHED_FORMS:
                            m6303a(view3, Schema.getInspectionData().getPendingCount(false));
                            return view3;
                        case E_TODOS:
                            m6303a(view3, DrawerListView.this.getApp().getModel().getTasks().getCount());
                            return view3;
                        default:
                            return view3;
                    }
            }
            if (view2 == null) {
                view2 = this.f5427c.inflate(C1352R.layout.category, viewGroup, false);
            }
            ((TextView) view2).setText(item.getText(DrawerListView.this.getContext()));
            return view2;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public boolean hasStableIds() {
            return true;
        }

        public int indexOf(DrawerItem drawerItem) {
            return this.f5428d.indexOf(drawerItem);
        }

        public boolean isEnabled(int i) {
            DrawerItem item = getItem(i);
            return item != null && item.isEnabled();
        }

        /* renamed from: a */
        private void m6303a(View view, int i) {
            TextView textView = (TextView) view.findViewById(16908304);
            switch (i) {
                case 0:
                    textView.setVisibility(8);
                    return;
                default:
                    textView.setText(Integer.toString(i));
                    textView.setVisibility(0);
                    return;
            }
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerListView$NoViewerDialog */
    public static class NoViewerDialog extends DialogFragment {
        public static NoViewerDialog newInstance(DrawerItem drawerItem) {
            NoViewerDialog noViewerDialog = new NoViewerDialog();
            Bundle bundle = new Bundle(1);
            bundle.putString("drawer_item_name", drawerItem.name());
            noViewerDialog.setArguments(bundle);
            return noViewerDialog;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            final boolean z = DrawerItem.valueOf(getArguments().getString("drawer_item_name")).getMime() == "application/pdf";
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setIcon(z ? C1352R.C1353drawable.ic_file_pdf : C1352R.C1353drawable.ic_file_doc);
            builder.setTitle(z ? "Geen PDF reader" : "Geen Word viewer");
            builder.setMessage("Er is geen " + (z ? "PDF reader" : "Word viewer") + " beschikbaar op uw telefoon. Wilt u er nu eentje downloaden?");
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    NoViewerDialog.this.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("market://search?q=" + (z ? "pdf reader" : "word viewer"))));
                }
            });
            return builder.create();
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerListView$a */
    class C1671a extends AsyncTask<Void, Void, Void> {
        private C1671a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                Thread.sleep(2000);
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            DrawerListView.this.f5416c.set(0);
        }
    }
}
