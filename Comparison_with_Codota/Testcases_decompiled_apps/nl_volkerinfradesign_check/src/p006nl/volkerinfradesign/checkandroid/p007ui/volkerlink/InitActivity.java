package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import java.util.Set;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitActivity */
public interface InitActivity {
    long getFormId();

    SetupState getState();

    boolean hasCompanies();

    boolean hasForm();

    void notifyDownloadFinished(Set<Company> set);

    void notifyRootChanged();

    void onInitDialogCancelled();

    void onSelectCompanyClicked();

    void setState(SetupState setupState);

    void showProgress(boolean z);
}
