package p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view;

import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.view.ItemViewObserver */
public interface ItemViewObserver {
    void onCustomLocationClicked(long j);

    void onDescriptiveImageClicked(long j);

    InspectionItemConstants.ItemCursor onInapplicableChanged(long j, boolean z);

    void onInputButtonClicked(long j);

    void onMoreOptionsClicked(long j, boolean z);

    void onMoreProjectsClicked(long j);

    void onPictureClicked(long j, PictureKey pictureKey, int i);

    void onPictureDeleteClicked(long j, PictureKey pictureKey);

    void onPicturePickerClicked(long j);

    InspectionItemConstants.ItemCursor onProjectSelected(long j, long j2);

    void onRemarkClicked(long j);

    void onSubFormButtonClicked(long j);

    void onTakeDrawingClicked(long j);

    void onTakePictureClicked(long j);

    void onTakeSignatureClicked(long j);

    InspectionItemConstants.ItemCursor onValueChanged(Object obj, long j);
}
