package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p001v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.SubFormDownloadDialog */
public class SubFormDownloadDialog extends DialogFragment {

    /* renamed from: aj */
    private SubFormDownloadParent f5186aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public TextView f5187ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public View f5188al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public View f5189am;

    /* renamed from: an */
    private Button f5190an;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.SubFormDownloadDialog$SubFormDownloadParent */
    public interface SubFormDownloadParent {
        App getApp();

        void onSubFormDownloaded(InspectionItemKey inspectionItemKey, int i);
    }

    /* renamed from: a */
    public static final SubFormDownloadDialog m6183a(InspectionItemKey inspectionItemKey, int i) {
        SubFormDownloadDialog subFormDownloadDialog = new SubFormDownloadDialog();
        Bundle bundle = new Bundle(2);
        bundle.putParcelable("sub_form_download_dialog:inspection_key", inspectionItemKey);
        bundle.putInt("sub_form_download_dialog:controller_position", i);
        subFormDownloadDialog.setArguments(bundle);
        return subFormDownloadDialog;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.ins3_sub_form_download_dialog, (ViewGroup) null);
        this.f5188al = inflate.findViewById(C1352R.C1354id.loading);
        this.f5189am = inflate.findViewById(C1352R.C1354id.error);
        this.f5187ak = (TextView) this.f5189am.findViewById(C1352R.C1354id.desc);
        this.f5190an = (Button) this.f5189am.findViewById(C1352R.C1354id.retry);
        this.f5190an.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new C1608a().mo10020a();
            }
        });
        builder.setIcon(C1352R.C1353drawable.ic_action_download);
        builder.setTitle("Downloaden");
        builder.setView(inflate);
        new C1608a().mo10020a();
        return builder.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public SubFormDownloadParent m6187l() {
        if (this.f5186aj == null) {
            Object parentFragment = getParentFragment();
            if (!(parentFragment instanceof SubFormDownloadParent)) {
                parentFragment = getActivity();
            }
            this.f5186aj = (SubFormDownloadParent) parentFragment;
        }
        return this.f5186aj;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.SubFormDownloadDialog$a */
    final class C1608a extends AsyncTask<Long, Void, Exception> {
        private C1608a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SubFormDownloadDialog.this.f5189am.setVisibility(4);
            SubFormDownloadDialog.this.f5188al.setVisibility(0);
            SubFormDownloadDialog.this.f5187ak.setText((CharSequence) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10020a() {
            long subFormServerId = ((InspectionItemKey) SubFormDownloadDialog.this.getArguments().getParcelable("sub_form_download_dialog:inspection_key")).getSubFormServerId();
            executeOnExecutor(SERIAL_EXECUTOR, new Long[]{Long.valueOf(subFormServerId)});
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Exception doInBackground(Long... lArr) {
            try {
                for (Form save : Form.download(ArrayUtils.toPrimitive(lArr))) {
                    save.save();
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return e;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Exception exc) {
            super.onPostExecute(exc);
            if (exc != null) {
                SubFormDownloadDialog.this.f5189am.setVisibility(0);
                SubFormDownloadDialog.this.f5188al.setVisibility(4);
                SubFormDownloadDialog.this.f5187ak.setText(exc.toString());
            } else if (SubFormDownloadDialog.this.getParentFragment() != null && SubFormDownloadDialog.this.getParentFragment().isVisible()) {
                int i = SubFormDownloadDialog.this.getArguments().getInt("sub_form_download_dialog:controller_position");
                SubFormDownloadDialog.this.m6187l().onSubFormDownloaded((InspectionItemKey) SubFormDownloadDialog.this.getArguments().getParcelable("sub_form_download_dialog:inspection_key"), i);
                SubFormDownloadDialog.this.dismiss();
            }
        }
    }
}
