package p006nl.volkerinfradesign.checkandroid.p007ui.tasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.environments.OriginKey;
import p006nl.volkerinfradesign.checkandroid.environments.UpdateResult;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.InspectionLoaderDialog */
public final class InspectionLoaderDialog extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public View f5511aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public View f5512ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public TextView f5513al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public Button f5514am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public C1702b f5515an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public C1701a f5516ao;

    /* renamed from: ap */
    private InspectionLoaderParent f5517ap;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.InspectionLoaderDialog$InspectionLoaderParent */
    public interface InspectionLoaderParent {
        void onInspectionDownloaded(OriginKey originKey);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.InspectionLoaderDialog$b */
    enum C1702b {
        DOWNLOADING {
            /* renamed from: a */
            public C1702b mo10270a(InspectionLoaderDialog inspectionLoaderDialog, Object... objArr) {
                inspectionLoaderDialog.f5511aj.setVisibility(0);
                inspectionLoaderDialog.f5512ak.setVisibility(4);
                inspectionLoaderDialog.f5514am.setEnabled(false);
                return this;
            }
        },
        FAILED {
            /* renamed from: a */
            public C1702b mo10270a(InspectionLoaderDialog inspectionLoaderDialog, Object... objArr) {
                boolean z = objArr != null && objArr.length > 0;
                inspectionLoaderDialog.f5511aj.setVisibility(4);
                inspectionLoaderDialog.f5512ak.setVisibility(0);
                inspectionLoaderDialog.f5514am.setEnabled(true);
                inspectionLoaderDialog.f5513al.setText(z ? objArr[0].toString() : null);
                return this;
            }
        };

        /* renamed from: a */
        public abstract C1702b mo10270a(InspectionLoaderDialog inspectionLoaderDialog, Object... objArr);
    }

    public static InspectionLoaderDialog newInstance(OriginKey originKey) {
        InspectionLoaderDialog inspectionLoaderDialog = new InspectionLoaderDialog();
        Bundle bundle = new Bundle(2);
        bundle.putParcelable("inspection_loader_dialog:inspection_key", originKey);
        inspectionLoaderDialog.setArguments(bundle);
        return inspectionLoaderDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5515an = bundle == null ? C1702b.DOWNLOADING : C1702b.valueOf(bundle.getString("inspection_loader_dialog:state"));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.inspection_download_dialog, (ViewGroup) null);
        this.f5511aj = inflate.findViewById(C1352R.C1354id.downloadingContainer);
        this.f5512ak = inflate.findViewById(C1352R.C1354id.failedContainer);
        this.f5513al = (TextView) inflate.findViewById(C1352R.C1354id.failedDesc);
        this.f5514am = (Button) inflate.findViewById(C1352R.C1354id.retryButton);
        this.f5514am.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new C1701a().mo10265a();
            }
        });
        builder.setIcon(C1352R.C1353drawable.ic_action_download);
        builder.setTitle("Downloaden");
        builder.setView(inflate);
        if (this.f5515an == C1702b.DOWNLOADING) {
            new C1701a().mo10265a();
        }
        return builder.create();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f5516ao != null) {
            this.f5516ao.cancel(true);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.InspectionLoaderDialog$a */
    final class C1701a extends AsyncTask<OriginKey, Void, UpdateResult> {
        private C1701a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10265a() {
            executeOnExecutor(THREAD_POOL_EXECUTOR, new OriginKey[]{(OriginKey) InspectionLoaderDialog.this.getArguments().getParcelable("inspection_loader_dialog:inspection_key")});
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            C1701a unused = InspectionLoaderDialog.this.f5516ao = this;
            C1702b unused2 = InspectionLoaderDialog.this.f5515an = C1702b.DOWNLOADING.mo10270a(InspectionLoaderDialog.this, new Object[0]);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public UpdateResult doInBackground(OriginKey... originKeyArr) {
            return Schema.getInspectionData().downloadInspection(originKeyArr[0]);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(UpdateResult updateResult) {
            super.onPostExecute(updateResult);
            C1701a unused = InspectionLoaderDialog.this.f5516ao = null;
            if (updateResult.isSuccess()) {
                InspectionLoaderDialog.this.dismiss();
                InspectionLoaderDialog.this.m6368l().onInspectionDownloaded((OriginKey) InspectionLoaderDialog.this.getArguments().getParcelable("inspection_loader_dialog:inspection_key"));
                return;
            }
            C1702b unused2 = InspectionLoaderDialog.this.f5515an = C1702b.FAILED.mo10270a(InspectionLoaderDialog.this, updateResult.getError());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public InspectionLoaderParent m6368l() {
        if (this.f5517ap == null) {
            Object parentFragment = getParentFragment();
            if (!(parentFragment instanceof InspectionLoaderParent)) {
                parentFragment = getActivity();
            }
            this.f5517ap = (InspectionLoaderParent) parentFragment;
        }
        return this.f5517ap;
    }
}
