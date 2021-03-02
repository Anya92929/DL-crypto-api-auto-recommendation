package p000;

import android.support.p001v4.app.DialogFragment;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentTransaction;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.DateTimeDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.OverviewFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.SubFormDownloadDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.TextDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageExpandableListFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageListFragment;

/* renamed from: ii */
public final class C1254ii {
    /* renamed from: a */
    public static void m5549a(InspectionFragment inspectionFragment, Fragment fragment, String str) {
        m5550a(inspectionFragment, fragment, str, true);
    }

    /* renamed from: a */
    public static void m5550a(InspectionFragment inspectionFragment, Fragment fragment, String str, boolean z) {
        FragmentTransaction beginTransaction = inspectionFragment.getChildFragmentManager().beginTransaction();
        String a = m5548a(str);
        beginTransaction.setCustomAnimations(C1352R.anim.slide_in_right, C1352R.anim.slide_out_left, 17432578, 17432579);
        beginTransaction.replace(C1352R.C1354id.showingInspection, fragment, (String) null);
        beginTransaction.setBreadCrumbTitle((CharSequence) a);
        beginTransaction.setBreadCrumbShortTitle((CharSequence) a);
        if (z) {
            beginTransaction.addToBackStack((String) null);
        }
        beginTransaction.commit();
    }

    /* renamed from: a */
    public static void m5552a(InspectionFragment inspectionFragment, PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        DialogFragment a;
        InspectionItemType type = itemCursor.getType();
        FragmentManager childFragmentManager = inspectionFragment.getChildFragmentManager();
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("inspection_fragment:dialog_fragment_tag");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        String a2 = m5548a(itemCursor.getTitle());
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        switch (type) {
            case DATE:
                a = DateTimeDialog.newDateInstance(itemCursor);
                break;
            case TIME:
                a = DateTimeDialog.newTimeInstance(itemCursor);
                break;
            case DATETIME:
                a = DateTimeDialog.newDateTimeInstance(itemCursor);
                break;
            case FLOAT:
            case INTEGER:
            case STRING:
                a = TextDialog.m6192a(itemCursor);
                break;
            default:
                throw new IllegalArgumentException("There is no dialog for the type: " + type.name());
        }
        beginTransaction.setBreadCrumbTitle((CharSequence) a2);
        beginTransaction.setBreadCrumbShortTitle((CharSequence) a2);
        a.show(beginTransaction, "inspection_fragment:dialog_fragment_tag");
    }

    /* renamed from: a */
    public static void m5551a(InspectionFragment inspectionFragment, InspectionItemKey inspectionItemKey, int i) {
        FragmentManager childFragmentManager = inspectionFragment.getChildFragmentManager();
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("inspection_fragment:dialog_fragment_tag");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        String a = m5548a(inspectionItemKey.getTitle());
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.setBreadCrumbTitle((CharSequence) a);
        beginTransaction.setBreadCrumbShortTitle((CharSequence) a);
        SubFormDownloadDialog.m6183a(inspectionItemKey, i).show(beginTransaction, "inspection_fragment:dialog_fragment_tag");
    }

    /* renamed from: a */
    public static void m5553a(OverviewFragment overviewFragment, InspectionItemKey inspectionItemKey, int i) {
        FragmentManager childFragmentManager = overviewFragment.getChildFragmentManager();
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("inspection_fragment:dialog_fragment_tag");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        String a = m5548a(inspectionItemKey.getTitle());
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.setBreadCrumbTitle((CharSequence) a);
        beginTransaction.setBreadCrumbShortTitle((CharSequence) a);
        SubFormDownloadDialog.m6183a(inspectionItemKey, i).show(beginTransaction, "inspection_fragment:dialog_fragment_tag");
    }

    /* renamed from: b */
    public static void m5554b(InspectionFragment inspectionFragment, PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        FragmentManager childFragmentManager = inspectionFragment.getChildFragmentManager();
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("inspection_fragment:dialog_fragment_tag");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        String a = m5548a(itemCursor.getTitle());
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.setBreadCrumbTitle((CharSequence) a);
        beginTransaction.setBreadCrumbShortTitle((CharSequence) a);
        TextDialog.m6194b(itemCursor).show(beginTransaction, "inspection_fragment:dialog_fragment_tag");
    }

    /* renamed from: a */
    static String m5548a(String str) {
        return str.length() > 8 ? str.substring(0, 8) + "..." : str;
    }

    /* renamed from: a */
    public static Fragment m5546a(InspectionKey inspectionKey) {
        return m5547a(inspectionKey, inspectionKey.getTitle(), 0);
    }

    /* renamed from: a */
    public static Fragment m5547a(InspectionKey inspectionKey, String str, int i) {
        if (inspectionKey.hasHeaders()) {
            return PageExpandableListFragment.newInstance(inspectionKey, str, i);
        }
        return PageListFragment.newInstance(inspectionKey, str, i);
    }
}
