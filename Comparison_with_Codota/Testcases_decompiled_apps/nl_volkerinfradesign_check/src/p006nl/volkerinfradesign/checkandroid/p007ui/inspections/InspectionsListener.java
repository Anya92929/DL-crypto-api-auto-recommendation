package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.InspectionsListener */
public interface InspectionsListener {
    void onInspectionDeleted(InspectionsTable.DataCursor dataCursor, int i, long j);

    @Deprecated
    void onOpenInspectionClicked(InspectionsTable.DataCursor dataCursor, int i, long j);

    void uploadInspections();
}
