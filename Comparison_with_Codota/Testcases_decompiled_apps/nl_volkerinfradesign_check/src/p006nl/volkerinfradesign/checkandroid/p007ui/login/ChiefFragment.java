package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.ChiefWrapper;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp;
import p006nl.volkerinfradesign.checkandroid.util.SimpleTextWatcher;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.ChiefFragment */
public class ChiefFragment extends DialogFragment {

    /* renamed from: aj */
    private EditText f5369aj;

    /* renamed from: ak */
    private ListView f5370ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public C1650a f5371al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public C1651b f5372am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public String f5373an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public ImageView f5374ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public ProgressBar f5375ap;

    /* renamed from: aq */
    private final TextWatcher f5376aq = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            String unused = ChiefFragment.this.f5373an = editable.toString().trim();
            if (ChiefFragment.this.f5372am != null) {
                ChiefFragment.this.f5372am.cancel(true);
            }
            if (StringUtils.isNotBlank(ChiefFragment.this.f5373an)) {
                new C1651b(ChiefFragment.this.f5373an).m6278a();
            } else {
                ChiefFragment.this.f5371al.clear();
            }
        }
    };

    /* renamed from: ar */
    private final AdapterView.OnItemClickListener f5377ar = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ChiefFragment.this.m6277l().personInChargeSelected((ChiefWrapper) ChiefFragment.this.f5371al.getItem(i));
            ChiefFragment.this.dismiss();
        }
    };

    /* renamed from: as */
    private PersonInChargeFragmentParent f5378as;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.ChiefFragment$PersonInChargeFragmentParent */
    public interface PersonInChargeFragmentParent {
        void personInChargeSelected(ChiefWrapper chiefWrapper);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.person_in_charge_content, (ViewGroup) null);
        this.f5374ao = (ImageView) inflate.findViewById(C1352R.C1354id.search);
        this.f5375ap = (ProgressBar) inflate.findViewById(C1352R.C1354id.progress);
        this.f5369aj = (EditText) inflate.findViewById(C1352R.C1354id.input);
        this.f5369aj.addTextChangedListener(this.f5376aq);
        this.f5370ak = (ListView) inflate.findViewById(C1352R.C1354id.list);
        this.f5370ak.setOnItemClickListener(this.f5377ar);
        this.f5370ak.setEmptyView(inflate.findViewById(C1352R.C1354id.empty));
        ListView listView = this.f5370ak;
        C1650a aVar = new C1650a();
        this.f5371al = aVar;
        listView.setAdapter(aVar);
        builder.setIcon(C1352R.C1353drawable.ic_action_account);
        builder.setTitle("Leidinggevende");
        builder.setView(inflate);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setNeutralButton("Wissen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ChiefFragment.this.m6277l().personInChargeSelected((ChiefWrapper) null);
                ChiefFragment.this.dismiss();
            }
        });
        return builder.create();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f5372am != null) {
            this.f5372am.cancel(true);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.ChiefFragment$a */
    final class C1650a extends ArrayAdapter<ChiefWrapper> {

        /* renamed from: b */
        private final LayoutInflater f5383b;

        private C1650a() {
            super(ChiefFragment.this.getActivity(), 17367063, new ArrayList());
            this.f5383b = ChiefFragment.this.getActivity().getLayoutInflater();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f5383b.inflate(17367063, viewGroup, false);
            }
            ChiefWrapper chiefWrapper = (ChiefWrapper) getItem(i);
            ((TextView) view.findViewById(16908308)).setText(chiefWrapper.getName());
            ((TextView) view.findViewById(16908309)).setText(chiefWrapper.getEmail());
            return view;
        }

        public long getItemId(int i) {
            return ((ChiefWrapper) getItem(i)).getId();
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.ChiefFragment$b */
    final class C1651b extends AsyncTask<String, Void, List<JsonObject>> {

        /* renamed from: b */
        private final String f5385b;

        /* renamed from: c */
        private final Gson f5386c;

        private C1651b(String str) {
            this.f5386c = new GsonBuilder().registerTypeAdapter(PersonImp.class, PersonImp.DESERIALIZER).create();
            this.f5385b = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6278a() {
            executeOnExecutor(THREAD_POOL_EXECUTOR, new String[]{this.f5385b});
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            C1651b unused = ChiefFragment.this.f5372am = this;
            ChiefFragment.this.f5374ao.setVisibility(4);
            ChiefFragment.this.f5375ap.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<com.google.gson.JsonObject> doInBackground(java.lang.String... r11) {
            /*
                r10 = this;
                r3 = 0
                r5 = 0
                r4 = r5
            L_0x0003:
                r0 = 5
                if (r4 >= r0) goto L_0x00df
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
                r0.<init>()
                java.lang.String r1 = "query"
                r6 = r11[r5]
                r0.addProperty((java.lang.String) r1, (java.lang.String) r6)
                com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
                r1.<init>()
                java.lang.String r6 = "session"
                nl.volkerinfradesign.checkandroid.AppState r7 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
                com.google.gson.JsonObject r7 = r7.getSIDJSON()
                r1.add(r6, r7)
                java.lang.String r6 = "params"
                r1.add(r6, r0)
                nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00e6, all -> 0x00e1 }
                java.net.URL r0 = r0.getUserFinderUrl()     // Catch:{ Exception -> 0x00e6, all -> 0x00e1 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00e6, all -> 0x00e1 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00e6, all -> 0x00e1 }
                r6 = 1
                r0.setDoOutput(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r6 = 60000(0xea60, float:8.4078E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r6 = 60000(0xea60, float:8.4078E-41)
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                java.lang.String r6 = "Content-Type"
                java.lang.String r7 = "text/json; charset=utf-8"
                r0.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                com.google.gson.stream.JsonWriter r6 = new com.google.gson.stream.JsonWriter     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r7.<init>(r8)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r6.<init>(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                com.google.gson.Gson r7 = r10.f5386c     // Catch:{ all -> 0x00c7 }
                r7.toJson((com.google.gson.JsonElement) r1, (com.google.gson.stream.JsonWriter) r6)     // Catch:{ all -> 0x00c7 }
                r6.close()     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                com.google.gson.stream.JsonReader r6 = new com.google.gson.stream.JsonReader     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                java.io.InputStream r7 = r0.getInputStream()     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r1.<init>(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                r6.<init>(r1)     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                com.google.gson.JsonParser r1 = new com.google.gson.JsonParser     // Catch:{ all -> 0x00aa }
                r1.<init>()     // Catch:{ all -> 0x00aa }
                com.google.gson.JsonElement r1 = r1.parse((com.google.gson.stream.JsonReader) r6)     // Catch:{ all -> 0x00aa }
                com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ all -> 0x00aa }
                java.lang.String r7 = "result"
                com.google.gson.JsonElement r1 = r1.get(r7)     // Catch:{ all -> 0x00aa }
                com.google.gson.JsonArray r1 = r1.getAsJsonArray()     // Catch:{ all -> 0x00aa }
                java.util.Iterator r7 = r1.iterator()     // Catch:{ all -> 0x00aa }
            L_0x0096:
                boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00aa }
                if (r1 == 0) goto L_0x00d5
                java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00aa }
                com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1     // Catch:{ all -> 0x00aa }
                com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ all -> 0x00aa }
                r2.add(r1)     // Catch:{ all -> 0x00aa }
                goto L_0x0096
            L_0x00aa:
                r1 = move-exception
                r6.close()     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                throw r1     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
            L_0x00af:
                r1 = move-exception
                r9 = r1
                r1 = r0
                r0 = r9
            L_0x00b3:
                nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x00e3 }
                r2.invalidateLogin(r1)     // Catch:{ all -> 0x00e3 }
                r0.printStackTrace()     // Catch:{ all -> 0x00e3 }
                if (r1 == 0) goto L_0x00c2
                r1.disconnect()
            L_0x00c2:
                int r0 = r4 + 1
                r4 = r0
                goto L_0x0003
            L_0x00c7:
                r1 = move-exception
                r6.close()     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                throw r1     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
            L_0x00cc:
                r1 = move-exception
                r3 = r0
                r0 = r1
            L_0x00cf:
                if (r3 == 0) goto L_0x00d4
                r3.disconnect()
            L_0x00d4:
                throw r0
            L_0x00d5:
                r6.close()     // Catch:{ Exception -> 0x00af, all -> 0x00cc }
                if (r0 == 0) goto L_0x00dd
                r0.disconnect()
            L_0x00dd:
                r0 = r2
            L_0x00de:
                return r0
            L_0x00df:
                r0 = r3
                goto L_0x00de
            L_0x00e1:
                r0 = move-exception
                goto L_0x00cf
            L_0x00e3:
                r0 = move-exception
                r3 = r1
                goto L_0x00cf
            L_0x00e6:
                r0 = move-exception
                r1 = r3
                goto L_0x00b3
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.login.ChiefFragment.C1651b.doInBackground(java.lang.String[]):java.util.List");
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            C1651b unused = ChiefFragment.this.f5372am = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<JsonObject> list) {
            super.onPostExecute(list);
            C1651b unused = ChiefFragment.this.f5372am = null;
            if (!(ChiefFragment.this.f5374ao == null || ChiefFragment.this.f5375ap == null)) {
                ChiefFragment.this.f5374ao.setVisibility(0);
                ChiefFragment.this.f5375ap.setVisibility(4);
            }
            if (ChiefFragment.this.f5371al != null) {
                ChiefFragment.this.f5371al.clear();
                if (StringUtils.isNotBlank(ChiefFragment.this.f5373an) && list != null && !list.isEmpty()) {
                    for (JsonObject chiefWrapper : list) {
                        ChiefFragment.this.f5371al.add(new ChiefWrapper(chiefWrapper));
                    }
                }
            }
            if (StringUtils.isNotBlank(ChiefFragment.this.f5373an) && !this.f5385b.equals(ChiefFragment.this.f5373an)) {
                new C1651b(ChiefFragment.this.f5373an).m6278a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public PersonInChargeFragmentParent m6277l() {
        if (this.f5378as == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null) {
                parentFragment = getActivity();
            }
            this.f5378as = (PersonInChargeFragmentParent) parentFragment;
        }
        return this.f5378as;
    }
}
