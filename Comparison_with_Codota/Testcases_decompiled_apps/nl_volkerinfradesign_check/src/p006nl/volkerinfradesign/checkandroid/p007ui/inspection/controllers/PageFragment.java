package p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers;

import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment */
public interface PageFragment {

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver */
    public interface PageObserver {
        void changeData();

        void invalidateFooter();

        void notifyDataSetChanged();

        boolean scrollToFirstInvalid();
    }

    InspectionItemConstants.ItemCursor getItem(long j);

    InspectionKey getKey();

    int getPosition();

    String getTitle();
}
