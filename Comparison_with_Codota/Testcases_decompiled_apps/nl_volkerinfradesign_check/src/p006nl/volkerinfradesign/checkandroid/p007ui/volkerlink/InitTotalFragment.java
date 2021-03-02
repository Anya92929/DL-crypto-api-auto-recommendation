package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.LoginActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink.InitTotalView;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitTotalFragment */
public class InitTotalFragment extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f5585a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f5586b;

    /* renamed from: c */
    private final InitTotalView.OnLoginClickedObserver f5587c = new InitTotalView.OnLoginClickedObserver() {
        public void onLoginClicked() {
            InitTotalFragment.this.startActivityForResult(new Intent(InitTotalFragment.this.getActivity(), LoginActivity.class), 333);
        }
    };

    /* renamed from: d */
    private final int f5588d = 333;

    public InitTotalView getView() {
        return (InitTotalView) super.getView();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 333 && i2 == -1) {
            mo10352a().setState(SetupState.DOWNLOAD_FORM);
            getView().setState(SetupState.DOWNLOAD_FORM);
            m6428d();
            m6426c();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        mo10352a().onInitDialogCancelled();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1352R.layout.volker_link_init_total_view, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        InitTotalView initTotalView = (InitTotalView) view;
        initTotalView.setState(mo10352a().getState());
        initTotalView.setLoginClickedObserver(this.f5587c);
        m6428d();
        switch (mo10352a().getState()) {
            case DOWNLOAD_FORM:
            case RE_DOWNLOAD_FORM:
                m6426c();
                return;
            case DOWNLOAD_COMPANIES:
            case RE_DOWNLOAD_COMPANIES:
                m6423b();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InitActivity mo10352a() {
        return (InitActivity) getActivity();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6423b() {
        if (!this.f5586b) {
            new C1724a().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6426c() {
        if (!this.f5585a) {
            new C1725b().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Long[]{Long.valueOf(mo10352a().getFormId())});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6428d() {
        switch (mo10352a().getState()) {
            case DOWNLOAD_FORM:
            case RE_DOWNLOAD_FORM:
            case DOWNLOAD_COMPANIES:
            case RE_DOWNLOAD_COMPANIES:
                getDialog().setTitle("Laden...");
                return;
            case NO_USER:
                getDialog().setTitle("Geen gebruiker!");
                return;
            case FINISHED:
                getDialog().setTitle("Klaar!");
                return;
            default:
                return;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitTotalFragment$a */
    class C1724a extends AsyncTask<Void, Void, C1286ir> {
        private C1724a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1286ir doInBackground(Void... voidArr) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                return new C1286ir(Root.download());
            } catch (IOException e) {
                IOException iOException = e;
                long currentTimeMillis2 = (currentTimeMillis + 5000) - System.currentTimeMillis();
                iOException.printStackTrace();
                if (currentTimeMillis2 > 0) {
                    try {
                        Thread.sleep(currentTimeMillis2);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                return new C1286ir(iOException);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C1286ir irVar) {
            boolean z = false;
            super.onPostExecute(irVar);
            boolean unused = InitTotalFragment.this.f5586b = false;
            InitActivity a = InitTotalFragment.this.mo10352a();
            if (InitTotalFragment.this.f5585a || InitTotalFragment.this.f5586b) {
                z = true;
            }
            a.showProgress(z);
            if (irVar.mo8642c()) {
                if (InitTotalFragment.this.isAdded()) {
                    InitTotalFragment.this.mo10352a().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                    InitTotalFragment.this.getView().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                    InitTotalFragment.this.m6428d();
                    Toast.makeText(InitTotalFragment.this.getActivity(), irVar.mo8640a().toString(), 1).show();
                    InitTotalFragment.this.m6423b();
                }
            } else if (irVar.mo8643d()) {
                irVar.mo8641b().save();
                if (InitTotalFragment.this.isAdded()) {
                    InitTotalFragment.this.mo10352a().notifyRootChanged();
                    InitTotalFragment.this.mo10352a().setState(SetupState.FINISHED);
                    InitTotalFragment.this.getView().setState(SetupState.FINISHED);
                    InitTotalFragment.this.m6428d();
                    InitTotalFragment.this.mo10352a().notifyDownloadFinished(irVar.mo8641b().getAllCompanies());
                    InitTotalFragment.this.dismiss();
                }
            } else if (InitTotalFragment.this.isAdded()) {
                InitTotalFragment.this.mo10352a().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                InitTotalFragment.this.getView().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                InitTotalFragment.this.m6428d();
                Toast.makeText(InitTotalFragment.this.getActivity(), "Er zijn geen bedrijven beschikbaar", 1).show();
                InitTotalFragment.this.m6423b();
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = InitTotalFragment.this.f5586b = true;
            InitTotalFragment.this.mo10352a().showProgress(true);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitTotalFragment$b */
    class C1725b extends AsyncTask<Long, Void, C1287is> {
        private C1725b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1287is doInBackground(Long... lArr) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                return new C1287is(Form.download(ArrayUtils.toPrimitive(lArr)));
            } catch (Exception e) {
                Exception exc = e;
                long currentTimeMillis2 = (currentTimeMillis + 5000) - System.currentTimeMillis();
                exc.printStackTrace();
                if (currentTimeMillis2 > 0) {
                    try {
                        Thread.sleep(currentTimeMillis2);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                return new C1287is(exc);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C1287is isVar) {
            super.onPostExecute(isVar);
            boolean unused = InitTotalFragment.this.f5585a = false;
            if (isVar.mo8646c()) {
                if (InitTotalFragment.this.isAdded()) {
                    InitTotalFragment.this.mo10352a().setState(SetupState.RE_DOWNLOAD_FORM);
                    InitTotalFragment.this.getView().setState(SetupState.RE_DOWNLOAD_FORM);
                    InitTotalFragment.this.m6428d();
                    Toast.makeText(InitTotalFragment.this.getActivity(), "Het formulier kan niet gedownload worden. Het wordt nogmaals geprobeerd:\n\n" + isVar.mo8644a().toString(), 1).show();
                    InitTotalFragment.this.m6426c();
                }
            } else if (isVar.mo8647d()) {
                isVar.mo8645b().save();
                if (InitTotalFragment.this.isAdded() && InitTotalFragment.this.mo10352a().hasForm()) {
                    InitTotalFragment.this.mo10352a().setState(SetupState.DOWNLOAD_COMPANIES);
                    InitTotalFragment.this.getView().setState(SetupState.DOWNLOAD_COMPANIES);
                    InitTotalFragment.this.m6428d();
                    InitTotalFragment.this.m6423b();
                }
            } else if (InitTotalFragment.this.isAdded()) {
                InitTotalFragment.this.mo10352a().setState(SetupState.RE_DOWNLOAD_FORM);
                InitTotalFragment.this.getView().setState(SetupState.RE_DOWNLOAD_FORM);
                InitTotalFragment.this.m6428d();
                Toast.makeText(InitTotalFragment.this.getActivity(), "Het formulier kan niet gedownload worden. Het wordt nogmaals geprobeerd", 1).show();
                InitTotalFragment.this.m6426c();
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = InitTotalFragment.this.f5585a = true;
            InitTotalFragment.this.mo10352a().showProgress(true);
        }
    }
}
