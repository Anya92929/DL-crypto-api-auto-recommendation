package p006nl.volkerinfradesign.checkandroid.p007ui.tasks;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp;
import p006nl.volkerinfradesign.checkandroid.util.SimpleTextWatcher;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DelegateTaskFragment */
public class DelegateTaskFragment extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public EditText f5487aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public EditText f5488ak;

    /* renamed from: al */
    private ListView f5489al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public C1696a f5490am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public C1697b f5491an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public String f5492ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public ProgressBar f5493ap;

    /* renamed from: aq */
    private final TextWatcher f5494aq = new SimpleTextWatcher() {
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            String unused = DelegateTaskFragment.this.f5492ao = editable.toString().trim();
            if (DelegateTaskFragment.this.f5491an != null) {
                DelegateTaskFragment.this.f5491an.cancel(true);
            }
            if (StringUtils.isNotBlank(DelegateTaskFragment.this.f5492ao)) {
                new C1697b(DelegateTaskFragment.this.f5492ao).m6350a();
            } else {
                DelegateTaskFragment.this.f5490am.clear();
            }
        }
    };

    /* renamed from: ar */
    private final AdapterView.OnItemClickListener f5495ar = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Accounts.Profile.Person unused = DelegateTaskFragment.this.f5496as = (Accounts.Profile.Person) DelegateTaskFragment.this.f5490am.getItem(i);
            ((InputMethodManager) DelegateTaskFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(DelegateTaskFragment.this.f5487aj.getWindowToken(), 0);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: as */
    public Accounts.Profile.Person f5496as;

    /* renamed from: at */
    private DelegateTaskFragmentParent f5497at;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DelegateTaskFragment$DelegateTaskFragmentParent */
    public interface DelegateTaskFragmentParent {
        void personInChargeSelected(String str, Accounts.Profile.Person person);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.delegate_dialog, (ViewGroup) null);
        this.f5488ak = (EditText) inflate.findViewById(C1352R.C1354id.reason);
        this.f5493ap = (ProgressBar) inflate.findViewById(C1352R.C1354id.progress);
        this.f5487aj = (EditText) inflate.findViewById(C1352R.C1354id.input);
        this.f5487aj.addTextChangedListener(this.f5494aq);
        this.f5489al = (ListView) inflate.findViewById(C1352R.C1354id.list);
        this.f5489al.setChoiceMode(1);
        this.f5489al.setOnItemClickListener(this.f5495ar);
        this.f5489al.setEmptyView(inflate.findViewById(C1352R.C1354id.empty));
        ListView listView = this.f5489al;
        C1696a aVar = new C1696a();
        this.f5490am = aVar;
        listView.setAdapter(aVar);
        builder.setView(inflate);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String trim = DelegateTaskFragment.this.f5488ak.getText().toString().trim();
                if (DelegateTaskFragment.this.f5496as != null) {
                    DelegateTaskFragment.this.m6349l().personInChargeSelected(trim, DelegateTaskFragment.this.f5496as);
                    DelegateTaskFragment.this.dismiss();
                    return;
                }
                Toast.makeText(DelegateTaskFragment.this.getActivity(), "Er is geen persoon geselecteerd.", 1).show();
            }
        });
        return builder.create();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f5491an != null) {
            this.f5491an.cancel(true);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DelegateTaskFragment$a */
    final class C1696a extends ArrayAdapter<PersonImp> {

        /* renamed from: b */
        private final LayoutInflater f5502b;

        private C1696a() {
            super(DelegateTaskFragment.this.getActivity(), 17367063, new ArrayList());
            this.f5502b = DelegateTaskFragment.this.getActivity().getLayoutInflater();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f5502b.inflate(17367063, viewGroup, false);
            }
            PersonImp personImp = (PersonImp) getItem(i);
            ((TextView) view.findViewById(16908308)).setText(personImp.name);
            ((TextView) view.findViewById(16908309)).setText(personImp.email);
            return view;
        }

        public long getItemId(int i) {
            return ((PersonImp) getItem(i)).f4912id;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DelegateTaskFragment$b */
    final class C1697b extends AsyncTask<String, Void, List<PersonImp>> {

        /* renamed from: b */
        private final String f5504b;

        /* renamed from: c */
        private final Gson f5505c;

        private C1697b(String str) {
            this.f5505c = new GsonBuilder().registerTypeAdapter(PersonImp.class, PersonImp.DESERIALIZER).create();
            this.f5504b = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6350a() {
            executeOnExecutor(THREAD_POOL_EXECUTOR, new String[]{this.f5504b});
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            C1697b unused = DelegateTaskFragment.this.f5491an = this;
            DelegateTaskFragment.this.f5493ap.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00d7  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp> doInBackground(java.lang.String... r12) {
            /*
                r11 = this;
                r3 = 0
                r5 = 0
                r4 = r5
            L_0x0003:
                r0 = 5
                if (r4 >= r0) goto L_0x00e5
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
                r0.<init>()
                java.lang.String r1 = "query"
                r6 = r12[r5]
                r0.addProperty((java.lang.String) r1, (java.lang.String) r6)
                com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
                r1.<init>()
                java.lang.String r6 = "session"
                nl.volkerinfradesign.checkandroid.AppState r7 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()
                com.google.gson.JsonObject r7 = r7.getSIDJSON()
                r1.add(r6, r7)
                java.lang.String r6 = "params"
                r1.add(r6, r0)
                nl.volkerinfradesign.checkandroid.AppState r0 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ Exception -> 0x00ec, all -> 0x00e7 }
                java.net.URL r0 = r0.getUserFinderUrl()     // Catch:{ Exception -> 0x00ec, all -> 0x00e7 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00ec, all -> 0x00e7 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00ec, all -> 0x00e7 }
                r6 = 1
                r0.setDoOutput(r6)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r6 = 60000(0xea60, float:8.4078E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r6 = 60000(0xea60, float:8.4078E-41)
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                java.lang.String r6 = "Content-Type"
                java.lang.String r7 = "text/json; charset=utf-8"
                r0.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                com.google.gson.stream.JsonWriter r6 = new com.google.gson.stream.JsonWriter     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r7.<init>(r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                com.google.gson.Gson r7 = r11.f5505c     // Catch:{ all -> 0x00cd }
                r7.toJson((com.google.gson.JsonElement) r1, (com.google.gson.stream.JsonWriter) r6)     // Catch:{ all -> 0x00cd }
                r6.close()     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                com.google.gson.stream.JsonReader r6 = new com.google.gson.stream.JsonReader     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                java.io.InputStream r7 = r0.getInputStream()     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r1.<init>(r7)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                r6.<init>(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                com.google.gson.JsonParser r1 = new com.google.gson.JsonParser     // Catch:{ all -> 0x00b0 }
                r1.<init>()     // Catch:{ all -> 0x00b0 }
                com.google.gson.JsonElement r1 = r1.parse((com.google.gson.stream.JsonReader) r6)     // Catch:{ all -> 0x00b0 }
                com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch:{ all -> 0x00b0 }
                java.lang.String r7 = "result"
                com.google.gson.JsonElement r1 = r1.get(r7)     // Catch:{ all -> 0x00b0 }
                com.google.gson.JsonArray r1 = r1.getAsJsonArray()     // Catch:{ all -> 0x00b0 }
                java.util.Iterator r7 = r1.iterator()     // Catch:{ all -> 0x00b0 }
            L_0x0096:
                boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00b0 }
                if (r1 == 0) goto L_0x00db
                java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00b0 }
                com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1     // Catch:{ all -> 0x00b0 }
                com.google.gson.Gson r8 = r11.f5505c     // Catch:{ all -> 0x00b0 }
                java.lang.Class<nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp> r9 = p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp.class
                java.lang.Object r1 = r8.fromJson((com.google.gson.JsonElement) r1, r9)     // Catch:{ all -> 0x00b0 }
                nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp r1 = (p006nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp) r1     // Catch:{ all -> 0x00b0 }
                r2.add(r1)     // Catch:{ all -> 0x00b0 }
                goto L_0x0096
            L_0x00b0:
                r1 = move-exception
                r6.close()     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                throw r1     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
            L_0x00b5:
                r1 = move-exception
                r10 = r1
                r1 = r0
                r0 = r10
            L_0x00b9:
                nl.volkerinfradesign.checkandroid.AppState r2 = p006nl.volkerinfradesign.checkandroid.AppState.getInstance()     // Catch:{ all -> 0x00e9 }
                r2.invalidateLogin(r1)     // Catch:{ all -> 0x00e9 }
                r0.printStackTrace()     // Catch:{ all -> 0x00e9 }
                if (r1 == 0) goto L_0x00c8
                r1.disconnect()
            L_0x00c8:
                int r0 = r4 + 1
                r4 = r0
                goto L_0x0003
            L_0x00cd:
                r1 = move-exception
                r6.close()     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                throw r1     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
            L_0x00d2:
                r1 = move-exception
                r3 = r0
                r0 = r1
            L_0x00d5:
                if (r3 == 0) goto L_0x00da
                r3.disconnect()
            L_0x00da:
                throw r0
            L_0x00db:
                r6.close()     // Catch:{ Exception -> 0x00b5, all -> 0x00d2 }
                if (r0 == 0) goto L_0x00e3
                r0.disconnect()
            L_0x00e3:
                r0 = r2
            L_0x00e4:
                return r0
            L_0x00e5:
                r0 = r3
                goto L_0x00e4
            L_0x00e7:
                r0 = move-exception
                goto L_0x00d5
            L_0x00e9:
                r0 = move-exception
                r3 = r1
                goto L_0x00d5
            L_0x00ec:
                r0 = move-exception
                r1 = r3
                goto L_0x00b9
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.tasks.DelegateTaskFragment.C1697b.doInBackground(java.lang.String[]):java.util.List");
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            C1697b unused = DelegateTaskFragment.this.f5491an = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<PersonImp> list) {
            super.onPostExecute(list);
            C1697b unused = DelegateTaskFragment.this.f5491an = null;
            if (DelegateTaskFragment.this.f5493ap != null) {
                DelegateTaskFragment.this.f5493ap.setVisibility(4);
            }
            if (DelegateTaskFragment.this.f5490am != null) {
                DelegateTaskFragment.this.f5490am.clear();
                if (StringUtils.isNotBlank(DelegateTaskFragment.this.f5492ao) && list != null && !list.isEmpty()) {
                    DelegateTaskFragment.this.f5490am.addAll(list);
                }
            }
            if (StringUtils.isNotBlank(DelegateTaskFragment.this.f5492ao) && !this.f5504b.equals(DelegateTaskFragment.this.f5492ao)) {
                new C1697b(DelegateTaskFragment.this.f5492ao).m6350a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public DelegateTaskFragmentParent m6349l() {
        if (this.f5497at == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null || !(parentFragment instanceof DelegateTaskFragmentParent)) {
                parentFragment = getActivity();
            }
            this.f5497at = (DelegateTaskFragmentParent) parentFragment;
        }
        return this.f5497at;
    }
}
