package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.AccountActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.LoginActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink.InitStepsView;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitStepsFragment */
public class InitStepsFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f5552a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f5553b = false;

    /* renamed from: c */
    private final InitStepsView.InitViewObserver f5554c = new InitStepsView.InitViewObserver() {
        public void onDownloadCompaniesClicked() {
            InitStepsFragment.this.m6404b();
        }

        public void onDownloadFormClicked() {
            InitStepsFragment.this.m6407c();
        }

        public void onLoginClicked() {
            InitStepsFragment.this.startActivityForResult(new Intent(InitStepsFragment.this.getActivity(), LoginActivity.class), 666);
        }

        public void onPickCompanyClicked() {
            InitStepsFragment.this.mo10319a().onSelectCompanyClicked();
        }

        public void onRetryCompaniesClicked() {
            InitStepsFragment.this.m6404b();
        }

        public void onRetryDownloadFormClicked() {
            InitStepsFragment.this.m6407c();
        }

        public void onShowUserClicked() {
            InitStepsFragment.this.getActivity().startActivity(new Intent(InitStepsFragment.this.getActivity(), AccountActivity.class));
        }
    };

    public InitStepsView getView() {
        return (InitStepsView) super.getView();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 666 && i2 == -1) {
            mo10319a().setState(SetupState.DOWNLOAD_FORM);
            getView().setState(SetupState.DOWNLOAD_FORM);
            m6407c();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof InitActivity)) {
            throw new IllegalStateException("The activity must implement the InitFragment.InitActivity interface!");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1352R.layout.volker_link_init_steps_view, viewGroup, false);
    }

    public void onDestroyView() {
        getView().setInitViewObserver((InitStepsView.InitViewObserver) null);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        InitStepsView initStepsView = (InitStepsView) view;
        initStepsView.setState(mo10319a().getState());
        initStepsView.setInitViewObserver(this.f5554c);
        switch (mo10319a().getState()) {
            case RE_DOWNLOAD_COMPANIES:
            case DOWNLOAD_COMPANIES:
                m6404b();
                return;
            case RE_DOWNLOAD_FORM:
            case DOWNLOAD_FORM:
                m6407c();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InitActivity mo10319a() {
        return (InitActivity) getActivity();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6404b() {
        if (this.f5553b) {
            return;
        }
        if (m6409d().getModel().getAccount() == null) {
            Toast.makeText(getActivity(), "Geen gebruiker beschikbaar!", 1).show();
        } else {
            new AsyncTask<Void, Void, C1286ir>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public C1286ir doInBackground(Void... voidArr) {
                    try {
                        return new C1286ir(Root.download());
                    } catch (IOException e) {
                        IOException iOException = e;
                        iOException.printStackTrace();
                        return new C1286ir(iOException);
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void onPostExecute(C1286ir irVar) {
                    boolean z = false;
                    super.onPostExecute(irVar);
                    boolean unused = InitStepsFragment.this.f5553b = false;
                    InitActivity a = InitStepsFragment.this.mo10319a();
                    if (InitStepsFragment.this.f5552a || InitStepsFragment.this.f5553b) {
                        z = true;
                    }
                    a.showProgress(z);
                    InitStepsFragment.this.getView().setCompaniesDownloadEnabled(true);
                    if (irVar.mo8642c()) {
                        InitStepsFragment.this.mo10319a().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                        InitStepsFragment.this.getView().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                        Toast.makeText(InitStepsFragment.this.getActivity(), irVar.mo8640a().toString(), 1).show();
                    } else if (irVar.mo8643d()) {
                        irVar.mo8641b().save();
                        InitStepsFragment.this.mo10319a().notifyRootChanged();
                        InitStepsFragment.this.mo10319a().setState(SetupState.FINISHED);
                        InitStepsFragment.this.getView().setState(SetupState.FINISHED);
                    } else {
                        InitStepsFragment.this.mo10319a().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                        InitStepsFragment.this.getView().setState(SetupState.RE_DOWNLOAD_COMPANIES);
                        Toast.makeText(InitStepsFragment.this.getActivity(), "Er zijn geen bedrijven beschikbaar", 1).show();
                    }
                }

                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    super.onPreExecute();
                    boolean unused = InitStepsFragment.this.f5553b = true;
                    InitStepsFragment.this.mo10319a().showProgress(true);
                    InitStepsFragment.this.getView().setCompaniesDownloadEnabled(false);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6407c() {
        if (!this.f5552a) {
            new AsyncTask<Long, Void, C1287is>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public C1287is doInBackground(Long... lArr) {
                    try {
                        return new C1287is(Form.download(ArrayUtils.toPrimitive(lArr)));
                    } catch (Exception e) {
                        Exception exc = e;
                        exc.printStackTrace();
                        return new C1287is(exc);
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void onPostExecute(C1287is isVar) {
                    boolean z = false;
                    super.onPostExecute(isVar);
                    boolean unused = InitStepsFragment.this.f5552a = false;
                    InitActivity a = InitStepsFragment.this.mo10319a();
                    if (InitStepsFragment.this.f5552a || InitStepsFragment.this.f5553b) {
                        z = true;
                    }
                    a.showProgress(z);
                    InitStepsFragment.this.getView().setFormDownloadEnabled(true);
                    if (isVar.mo8646c()) {
                        InitStepsFragment.this.mo10319a().setState(SetupState.RE_DOWNLOAD_FORM);
                        InitStepsFragment.this.getView().setState(SetupState.RE_DOWNLOAD_FORM);
                        Toast.makeText(InitStepsFragment.this.getActivity(), isVar.mo8644a().toString(), 1).show();
                    } else if (isVar.mo8647d()) {
                        isVar.mo8645b().save();
                        if (InitStepsFragment.this.mo10319a().hasForm()) {
                            InitStepsFragment.this.mo10319a().setState(SetupState.DOWNLOAD_COMPANIES);
                            InitStepsFragment.this.getView().setState(SetupState.DOWNLOAD_COMPANIES);
                            InitStepsFragment.this.m6404b();
                            return;
                        }
                        Toast.makeText(InitStepsFragment.this.getActivity(), "Het formulier is niet (meer) beschikbaar.", 1).show();
                    } else {
                        InitStepsFragment.this.mo10319a().setState(SetupState.RE_DOWNLOAD_FORM);
                        InitStepsFragment.this.getView().setState(SetupState.RE_DOWNLOAD_FORM);
                        Toast.makeText(InitStepsFragment.this.getActivity(), "Het formulier kan niet gedownload worden.", 1).show();
                    }
                }

                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    super.onPreExecute();
                    boolean unused = InitStepsFragment.this.f5552a = true;
                    InitStepsFragment.this.mo10319a().showProgress(true);
                    InitStepsFragment.this.getView().setFormDownloadEnabled(false);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Long[]{Long.valueOf(mo10319a().getFormId())});
        }
    }

    /* renamed from: d */
    private App m6409d() {
        return (App) getActivity().getApplication();
    }
}
