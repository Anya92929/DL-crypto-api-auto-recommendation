package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.location.Location;
import p006nl.volkerinfradesign.checkandroid.OnBackPressedObservable;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.InspectionFragmentParent */
public interface InspectionFragmentParent extends OnBackPressedObservable {

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.InspectionFragmentParent$InspectionParentObserver */
    public interface InspectionParentObserver extends OnBackPressedObservable.OnBackPressedObserver {
        boolean scrollToFirstInvalid();
    }

    void onDeleteInspectionClicked(InspectionFragment inspectionFragment, InspectionKey inspectionKey);

    void onSendInspectionClicked(InspectionFragment inspectionFragment, InspectionKey inspectionKey, Location location);

    void registerInspectionActivityObserver(InspectionParentObserver inspectionParentObserver);

    void unregisterInspectionActivityObserver(InspectionParentObserver inspectionParentObserver);
}
