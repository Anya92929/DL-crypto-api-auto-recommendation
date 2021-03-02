package p006nl.volkerinfradesign.checkandroid.p007ui.tasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p001v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.database.InspectionConstants;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DownloadFormDialog */
public class DownloadFormDialog extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public ViewGroup f5506aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public ViewGroup f5507ak;

    /* renamed from: al */
    private Button f5508al;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DownloadFormDialog$DownloadFormDialogParent */
    public interface DownloadFormDialogParent {
        void onFormDownloaded(long j);
    }

    /* renamed from: a */
    static DownloadFormDialog m6354a(long j, long[] jArr) {
        DownloadFormDialog downloadFormDialog = new DownloadFormDialog();
        Bundle bundle = new Bundle(1);
        bundle.putLongArray("server_ids", jArr);
        bundle.putLong(InspectionConstants.ACTION_ID, j);
        downloadFormDialog.setArguments(bundle);
        return downloadFormDialog;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.ins_2_loading_dialog, (ViewGroup) null);
        this.f5506aj = (ViewGroup) inflate.findViewById(C1352R.C1354id.loading);
        this.f5507ak = (ViewGroup) inflate.findViewById(C1352R.C1354id.error);
        this.f5508al = (Button) this.f5507ak.findViewById(C1352R.C1354id.retryButton);
        this.f5508al.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DownloadFormDialog.this.m6358l();
            }
        });
        builder.setView(inflate);
        builder.setTitle("Downloaden");
        builder.setIcon(C1352R.C1353drawable.ic_action_download);
        m6358l();
        return builder.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m6358l() {
        new C1699a().executeOnExecutor(C1699a.SERIAL_EXECUTOR, ArrayUtils.toObject(getArguments().getLongArray("server_ids")));
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.DownloadFormDialog$a */
    class C1699a extends AsyncTask<Long, Void, Exception> {
        private C1699a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Exception doInBackground(Long... lArr) {
            try {
                for (Form save : Form.download(ArrayUtils.toPrimitive(lArr))) {
                    save.save();
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return e;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Exception exc) {
            super.onPostExecute(exc);
            long j = DownloadFormDialog.this.getArguments().getLong(InspectionConstants.ACTION_ID);
            if (exc != null) {
                DownloadFormDialog.this.f5507ak.setVisibility(0);
                DownloadFormDialog.this.f5506aj.setVisibility(4);
            } else if (DownloadFormDialog.this.getParentFragment() != null && DownloadFormDialog.this.getParentFragment().isVisible()) {
                ((DownloadFormDialogParent) DownloadFormDialog.this.getParentFragment()).onFormDownloaded(j);
                DownloadFormDialog.this.dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            DownloadFormDialog.this.f5507ak.setVisibility(4);
            DownloadFormDialog.this.f5506aj.setVisibility(0);
        }
    }
}
