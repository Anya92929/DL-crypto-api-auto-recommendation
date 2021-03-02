package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p006nl.volkerinfradesign.checkandroid.p007ui.drawing.DrawActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.DateTimeDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragmentParent;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.LocationFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.OverviewController;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.OverviewFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ProjectsFragment2;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.SubFormDownloadDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.TextDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment;
import p006nl.volkerinfradesign.checkandroid.util.CursorUtil;
import p006nl.volkerinfradesign.checkandroid.util.SimpleLocationListener;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.InspectionFragment */
public final class InspectionFragment extends Fragment implements DateTimeDialog.C1561a, LocationFragment.LocationFragmentParent, OverviewFragment.OverviewFragmentParent, ProjectsFragment2.ProjectsParent, SubFormDownloadDialog.SubFormDownloadParent, TextDialog.C1610a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LinearLayout f5086a;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public C1576b f5087aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public Location f5088ak;

    /* renamed from: al */
    private InspectionItemKey f5089al;

    /* renamed from: am */
    private final LocationListener f5090am = new SimpleLocationListener() {
        public void onLocationChanged(Location location) {
            Location unused = InspectionFragment.this.f5088ak = location;
        }
    };

    /* renamed from: an */
    private final InspectionFragmentParent.InspectionParentObserver f5091an = new InspectionFragmentParent.InspectionParentObserver() {
        public boolean scrollToFirstInvalid() {
            boolean z;
            OrderedIterator it = InspectionFragment.this.f5093ap.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                if (((PageFragment.PageObserver) it.next()).scrollToFirstInvalid() || z2) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z;
            }
            if (z2) {
                InspectionFragment.this.m6105a(true);
            }
            return z2;
        }

        public boolean onActivityBackPressed() {
            return InspectionFragment.this.getChildFragmentManager().popBackStackImmediate();
        }
    };

    /* renamed from: ao */
    private int f5092ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public final ListOrderedSet<PageFragment.PageObserver> f5093ap = new ListOrderedSet<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinearLayout f5094b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f5095c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f5096d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f5097e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Button f5098f;

    /* renamed from: g */
    private InspectionFragmentParent f5099g;

    /* renamed from: h */
    private Boolean f5100h;

    /* renamed from: i */
    private boolean f5101i = false;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.InspectionFragment$b */
    enum C1576b {
        DOWNLOADING_FORM {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public C1576b mo9953a(InspectionFragment inspectionFragment, Bundle bundle, Object... objArr) {
                inspectionFragment.f5086a.setVisibility(0);
                inspectionFragment.f5094b.setVisibility(8);
                inspectionFragment.f5095c.setVisibility(8);
                inspectionFragment.f5098f.setEnabled(false);
                inspectionFragment.f5096d.setText("Bezig met het downloaden van: " + ((FormRef) inspectionFragment.getArguments().getSerializable("inspection_fragment_3:form_ref")).getTitle());
                return this;
            }
        },
        DOWNLOAD_FAILED {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public C1576b mo9953a(InspectionFragment inspectionFragment, Bundle bundle, Object... objArr) {
                inspectionFragment.f5086a.setVisibility(8);
                inspectionFragment.f5094b.setVisibility(0);
                inspectionFragment.f5095c.setVisibility(8);
                inspectionFragment.f5098f.setEnabled(true);
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Exception)) {
                    inspectionFragment.f5097e.setVisibility(8);
                } else {
                    inspectionFragment.f5097e.setText(objArr[0].toString());
                    inspectionFragment.f5097e.setVisibility(0);
                }
                return this;
            }
        },
        SHOWING_INSPECTION {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public C1576b mo9953a(InspectionFragment inspectionFragment, Bundle bundle, Object... objArr) {
                InspectionKey inspectionKey = objArr[0];
                inspectionFragment.f5086a.setVisibility(8);
                inspectionFragment.f5094b.setVisibility(8);
                inspectionFragment.f5095c.setVisibility(0);
                if (bundle == null) {
                    C1254ii.m5550a(inspectionFragment, C1254ii.m5546a(inspectionKey), inspectionKey.getTitle(), false);
                }
                inspectionFragment.getActivity().invalidateOptionsMenu();
                return this;
            }
        };

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C1576b mo9953a(InspectionFragment inspectionFragment, Bundle bundle, Object... objArr);
    }

    public static final InspectionFragment newInstance(InspectionKey inspectionKey, boolean z) {
        InspectionFragment inspectionFragment = new InspectionFragment();
        Bundle bundle = new Bundle(2);
        bundle.putParcelable("inspection_fragment_3:inspection_key", inspectionKey);
        bundle.putBoolean("inspection_fragment_3:is_preview", z);
        inspectionFragment.setArguments(bundle);
        return inspectionFragment;
    }

    public static final InspectionFragment newInstance(FormRef formRef, Company company) {
        InspectionFragment inspectionFragment = new InspectionFragment();
        Bundle bundle = new Bundle(3);
        bundle.putSerializable("inspection_fragment_3:form_ref", formRef);
        bundle.putSerializable("inspection_fragment_3:company", company);
        bundle.putBoolean("inspection_fragment_3:is_preview", false);
        inspectionFragment.setArguments(bundle);
        return inspectionFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5101i = bundle.getBoolean("inspection_fragment_3:mark_invalid", false);
            this.f5087aj = C1576b.valueOf(bundle.getString("inspection_fragment_3:fragment_state"));
            this.f5088ak = (Location) bundle.getParcelable("inspection_fragment_3:saved_location");
            this.f5089al = (InspectionItemKey) bundle.getParcelable("inspection_fragment_3:picture_picker_key");
        } else if (getArguments().containsKey("inspection_fragment_3:inspection_key")) {
            this.f5087aj = C1576b.SHOWING_INSPECTION;
        } else {
            FormRef formRef = (FormRef) getArguments().getSerializable("inspection_fragment_3:form_ref");
            Company company = (Company) getArguments().getSerializable("inspection_fragment_3:company");
            if (formRef == null || company == null || !formRef.hasForm()) {
                this.f5087aj = C1576b.DOWNLOADING_FORM;
                return;
            }
            getArguments().putParcelable("inspection_fragment_3:inspection_key", formRef.getForm().newInstance(company, (LongSparseArray<String>) null, (InspectionsTable.InitialLocation) null));
            this.f5087aj = C1576b.SHOWING_INSPECTION;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.ins3_inspection_content, viewGroup, false);
        this.f5086a = (LinearLayout) inflate.findViewById(C1352R.C1354id.downloadingForm);
        this.f5094b = (LinearLayout) inflate.findViewById(C1352R.C1354id.downloadFailed);
        this.f5095c = (FrameLayout) inflate.findViewById(C1352R.C1354id.showingInspection);
        this.f5096d = (TextView) inflate.findViewById(C1352R.C1354id.downloadingDesc);
        this.f5097e = (TextView) inflate.findViewById(C1352R.C1354id.downloadFailedDesc);
        this.f5098f = (Button) inflate.findViewById(C1352R.C1354id.retryButton);
        this.f5098f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new C1575a().mo9948a();
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5087aj.mo9953a(this, bundle, (InspectionKey) getArguments().getParcelable("inspection_fragment_3:inspection_key"));
        if (this.f5087aj == C1576b.DOWNLOADING_FORM) {
            new C1575a().mo9948a();
        }
        getParent().registerInspectionActivityObserver(this.f5091an);
        getParent().registerOnBackPressedObserver(this.f5091an);
        m6112l();
    }

    public void onResume() {
        super.onResume();
        m6113m();
    }

    /* renamed from: l */
    private boolean m6112l() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION");
        int checkSelfPermission3 = ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (checkSelfPermission == 0 && checkSelfPermission2 == 0 && checkSelfPermission3 == 0) {
            return true;
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        return false;
    }

    /* renamed from: m */
    private void m6113m() {
        if (!isPreview()) {
            LocationManager locationManager = (LocationManager) getActivity().getSystemService("location");
            for (String requestLocationUpdates : locationManager.getProviders(true)) {
                locationManager.requestLocationUpdates(requestLocationUpdates, 700, BitmapDescriptorFactory.HUE_RED, this.f5090am);
            }
        }
    }

    public void onPause() {
        ((LocationManager) getActivity().getSystemService("location")).removeUpdates(this.f5090am);
        super.onPause();
    }

    public void onDestroyView() {
        getParent().unregisterInspectionActivityObserver(this.f5091an);
        getParent().unregisterOnBackPressedObserver(this.f5091an);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("inspection_fragment_3:mark_invalid", this.f5101i);
        bundle.putString("inspection_fragment_3:fragment_state", this.f5087aj.name());
        bundle.putParcelable("inspection_fragment_3:saved_location", this.f5088ak);
        bundle.putParcelable("inspection_fragment_3:picture_picker_key", this.f5089al);
    }

    public void showDescriptiveImage(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        C1254ii.m5549a(this, (Fragment) ImagesFragment.m6088a(itemCursor), itemCursor.getTitle());
    }

    public void showInputDialog(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        C1254ii.m5552a(this, pageFragment, itemCursor);
    }

    public void changeRemark(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        C1254ii.m5554b(this, pageFragment, itemCursor);
    }

    public void showProjectDetails(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        C1254ii.m5549a(this, (Fragment) ProjectsFragment2.newInstance(itemCursor.getInspectionKey(), isPreview()), itemCursor.getTitle());
    }

    public boolean isPreview() {
        if (this.f5100h == null) {
            this.f5100h = Boolean.valueOf(getArguments().getBoolean("inspection_fragment_3:is_preview", false));
        }
        return this.f5100h.booleanValue();
    }

    public boolean markInvalidItems() {
        return this.f5101i;
    }

    public void onLocationChanged(InspectionItemKey inspectionItemKey, LatLng latLng, boolean z) {
        inspectionItemKey.setCustomLocation(latLng);
        if (z) {
            getChildFragmentManager().popBackStackImmediate();
        }
        OrderedIterator it = this.f5093ap.iterator();
        while (it.hasNext()) {
            ((PageFragment.PageObserver) it.next()).changeData();
        }
    }

    public void onProjectSelected(InspectionKey inspectionKey, long j) {
        inspectionKey.setProjectSelected(j);
        getChildFragmentManager().popBackStackImmediate();
        OrderedIterator it = this.f5093ap.iterator();
        while (it.hasNext()) {
            ((PageFragment.PageObserver) it.next()).changeData();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6105a(boolean z) {
        this.f5101i = z;
        getActivity().invalidateOptionsMenu();
        OrderedIterator it = this.f5093ap.iterator();
        while (it.hasNext()) {
            ((PageFragment.PageObserver) it.next()).notifyDataSetChanged();
        }
    }

    public boolean setValue(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor, Object obj) {
        boolean value = itemCursor.setValue(obj, this.f5088ak);
        getActivity().invalidateOptionsMenu();
        OrderedIterator it = this.f5093ap.iterator();
        while (it.hasNext()) {
            ((PageFragment.PageObserver) it.next()).invalidateFooter();
        }
        return value;
    }

    public boolean setInapplicable(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor, boolean z) {
        boolean inapplicable = itemCursor.setInapplicable(z, this.f5088ak);
        getActivity().invalidateOptionsMenu();
        OrderedIterator it = this.f5093ap.iterator();
        while (it.hasNext()) {
            ((PageFragment.PageObserver) it.next()).invalidateFooter();
        }
        return inapplicable;
    }

    public void onRemarkChanged(InspectionItemKey inspectionItemKey, String str) {
        if (inspectionItemKey.setRemark(str, this.f5088ak)) {
            OrderedIterator it = this.f5093ap.iterator();
            while (it.hasNext()) {
                ((PageFragment.PageObserver) it.next()).changeData();
            }
        }
    }

    public void onValueChanged(InspectionItemKey inspectionItemKey, Calendar calendar) {
        m6102a((Object) calendar, inspectionItemKey);
    }

    public void onValueChanged(InspectionItemKey inspectionItemKey, String str) {
        m6102a((Object) str, inspectionItemKey);
    }

    /* renamed from: a */
    private void m6102a(Object obj, InspectionItemKey inspectionItemKey) {
        if (inspectionItemKey.setValue(obj, this.f5088ak)) {
            OrderedIterator it = this.f5093ap.iterator();
            while (it.hasNext()) {
                ((PageFragment.PageObserver) it.next()).notifyDataSetChanged();
            }
        }
        getActivity().invalidateOptionsMenu();
    }

    public App getApp() {
        return (App) getActivity().getApplication();
    }

    public InspectionFragmentParent getParent() {
        if (this.f5099g == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null || !(parentFragment instanceof InspectionFragmentParent)) {
                parentFragment = getActivity();
            }
            this.f5099g = (InspectionFragmentParent) parentFragment;
        }
        return this.f5099g;
    }

    public void showSubInspection(OverviewController overviewController, OverviewController.OverviewItemController overviewItemController) {
        if (overviewItemController.hasInspection()) {
            m6103a(overviewItemController.getInspection(), overviewController.getPosition(), overviewItemController.getTitle());
        } else {
            Toast.makeText(getActivity(), "Er is geen inspectie beschikbaar", 0).show();
        }
    }

    public void showSubInspection(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        if (itemCursor.hasTriggeredCondition()) {
            int position = pageFragment.getPosition();
            if (!itemCursor.hasSubForm()) {
                AppState.getInstance().log().mo8931i("Has a triggered condition, but no subform");
                C1254ii.m5551a(this, itemCursor.getKey(), position);
                return;
            }
            InspectionKey a = m6099a(itemCursor);
            if (a != null) {
                m6103a(a, position, itemCursor.getTitle());
            }
        }
    }

    /* renamed from: a */
    private InspectionKey m6099a(InspectionItemConstants.ItemCursor itemCursor) {
        if (!itemCursor.hasTriggeredCondition() || itemCursor.hasSubInspections() || itemCursor.addSubInspection()) {
            CursorUtil newInstance = CursorUtil.newInstance(itemCursor.getSubInspections(false));
            try {
                return ((InspectionsTable.DataCursor) newInstance.getFirst()).getKey();
            } finally {
                newInstance.closeQuietly();
            }
        } else {
            Toast.makeText(getActivity(), "Kon geen subvragen aanmaken. Neem contact op met uw beheerder.", 1);
            return null;
        }
    }

    public void onSubFormDownloaded(InspectionItemKey inspectionItemKey, int i) {
        InspectionItemConstants.ItemCursor itemCursor = (InspectionItemConstants.ItemCursor) CursorUtil.newInstance(inspectionItemKey.get()).getFirst();
        try {
            InspectionKey a = m6099a(itemCursor);
            if (a != null) {
                m6103a(a, i, itemCursor.getTitle());
            } else {
                Toast.makeText(getActivity(), "Kon het formulier niet downloaden. Bestaat deze nog wel?", 1);
            }
        } finally {
            CursorUtil.closeQuietly(itemCursor);
        }
    }

    /* renamed from: a */
    private void m6103a(InspectionKey inspectionKey, int i, String str) {
        if (inspectionKey == null) {
            Toast.makeText(getActivity(), "Kon het formulier niet aanmaken. Is het formulier wel goed gedownload?", 1);
        } else {
            C1254ii.m5549a(this, C1254ii.m5547a(inspectionKey, str, i + 1), str);
        }
    }

    public void showCustomLocationFragment(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        C1254ii.m5549a(this, (Fragment) LocationFragment.newInstance(itemCursor, isPreview()), itemCursor.getTitle());
    }

    public void showPicture(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor, PictureKey pictureKey, int i) {
        C1254ii.m5549a(this, (Fragment) ImagesFragment.m6089a(itemCursor, i), itemCursor.getTitle());
    }

    public void pickPicture(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        Intent intent = new Intent("android.intent.action.PICK");
        this.f5089al = itemCursor.getKey();
        intent.setType("image/*");
        startActivityForResult(intent, 9021);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            r8 = this;
            r6 = -1
            r2 = 0
            super.onActivityResult(r9, r10, r11)
            if (r10 != r6) goto L_0x0166
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r0 = r8.f5089al
            if (r0 == 0) goto L_0x0166
            android.os.Bundle r0 = r8.getArguments()
            java.lang.String r1 = "inspection_fragment_3:inspection_key"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            nl.volkerinfradesign.checkandroid.database.InspectionKey r0 = (p006nl.volkerinfradesign.checkandroid.database.InspectionKey) r0
            switch(r9) {
                case 1209: goto L_0x0038;
                case 1213: goto L_0x00a3;
                case 1214: goto L_0x00d8;
                case 9021: goto L_0x00f8;
                default: goto L_0x001a;
            }
        L_0x001a:
            r0.invalidateProgress()
            r8.f5089al = r2
            org.apache.commons.collections4.set.ListOrderedSet<nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver> r0 = r8.f5093ap
            org.apache.commons.collections4.OrderedIterator r1 = r0.iterator()
        L_0x0025:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0166
            java.lang.Object r0 = r1.next()
            nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver r0 = (p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment.PageObserver) r0
            r0.notifyDataSetChanged()
            r0.invalidateFooter()
            goto L_0x0025
        L_0x0038:
            nl.volkerinfradesign.checkandroid.App r1 = r8.getApp()     // Catch:{ Exception -> 0x007b }
            java.io.File r1 = r1.getTempFile()     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r3 = r8.f5089al     // Catch:{ Exception -> 0x007b }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r4 = r8.f5089al     // Catch:{ Exception -> 0x007b }
            android.location.Location r5 = r8.getLocation()     // Catch:{ Exception -> 0x007b }
            r4.registerPicture(r1, r5)     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r1 = r8.f5089al     // Catch:{ Exception -> 0x007b }
            android.location.Location r4 = r8.getLocation()     // Catch:{ Exception -> 0x007b }
            r1.setValue(r3, r4)     // Catch:{ Exception -> 0x007b }
            int r1 = r8.m6114n()     // Catch:{ Exception -> 0x007b }
            int r3 = r8.f5092ao     // Catch:{ Exception -> 0x007b }
            if (r3 == r6) goto L_0x001a
            if (r1 == r6) goto L_0x001a
            int r3 = r8.f5092ao     // Catch:{ Exception -> 0x007b }
            if (r1 <= r3) goto L_0x001a
            android.net.Uri r3 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x007b }
            long r4 = (long) r1     // Catch:{ Exception -> 0x007b }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r3, r4)     // Catch:{ Exception -> 0x007b }
            android.support.v4.app.FragmentActivity r3 = r8.getActivity()     // Catch:{ Exception -> 0x007b }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x007b }
            r4 = 0
            r5 = 0
            r3.delete(r1, r4, r5)     // Catch:{ Exception -> 0x007b }
            goto L_0x001a
        L_0x007b:
            r1 = move-exception
            java.lang.String r3 = "No way"
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00b9 }
            android.util.Log.e(r3, r1)     // Catch:{ all -> 0x00b9 }
            r0.invalidateProgress()
            r8.f5089al = r2
            org.apache.commons.collections4.set.ListOrderedSet<nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver> r0 = r8.f5093ap
            org.apache.commons.collections4.OrderedIterator r1 = r0.iterator()
        L_0x0090:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0166
            java.lang.Object r0 = r1.next()
            nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver r0 = (p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment.PageObserver) r0
            r0.notifyDataSetChanged()
            r0.invalidateFooter()
            goto L_0x0090
        L_0x00a3:
            nl.volkerinfradesign.checkandroid.App r1 = r8.getApp()     // Catch:{ Exception -> 0x007b }
            java.io.File r1 = r1.getTempFile()     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r3 = r8.f5089al     // Catch:{ Exception -> 0x007b }
            android.location.Location r4 = r8.getLocation()     // Catch:{ Exception -> 0x007b }
            r3.registerPicture(r1, r4)     // Catch:{ Exception -> 0x007b }
            r0.invalidateProgress()     // Catch:{ Exception -> 0x007b }
            goto L_0x001a
        L_0x00b9:
            r1 = move-exception
            r0.invalidateProgress()
            r8.f5089al = r2
            org.apache.commons.collections4.set.ListOrderedSet<nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver> r0 = r8.f5093ap
            org.apache.commons.collections4.OrderedIterator r2 = r0.iterator()
        L_0x00c5:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0165
            java.lang.Object r0 = r2.next()
            nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver r0 = (p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment.PageObserver) r0
            r0.notifyDataSetChanged()
            r0.invalidateFooter()
            goto L_0x00c5
        L_0x00d8:
            nl.volkerinfradesign.checkandroid.App r1 = r8.getApp()     // Catch:{ Exception -> 0x007b }
            java.io.File r1 = r1.getTempFile()     // Catch:{ Exception -> 0x007b }
            android.location.Location r3 = r8.getLocation()     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r4 = r8.f5089al     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.PictureKey r1 = r4.registerPicture(r1, r3)     // Catch:{ Exception -> 0x007b }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r4 = r8.f5089al     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = r1.getGuid()     // Catch:{ Exception -> 0x007b }
            r4.setValue(r1, r3)     // Catch:{ Exception -> 0x007b }
            r0.invalidateProgress()     // Catch:{ Exception -> 0x007b }
            goto L_0x001a
        L_0x00f8:
            nl.volkerinfradesign.checkandroid.App r1 = r8.getApp()     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            java.io.File r3 = r1.getTempFile()     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            android.net.Uri r1 = r11.getData()     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r4 = r8.f5089al     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            android.content.Context r5 = p006nl.volkerinfradesign.checkandroid.App.getAppContext()     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            java.io.InputStream r1 = r5.openInputStream(r1)     // Catch:{ Exception -> 0x012e, all -> 0x015f }
            org.apache.commons.p009io.FileUtils.copyInputStreamToFile(r1, r3)     // Catch:{ Exception -> 0x016c }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r5 = r8.f5089al     // Catch:{ Exception -> 0x016c }
            android.location.Location r6 = r8.f5088ak     // Catch:{ Exception -> 0x016c }
            r5.registerPicture(r3, r6)     // Catch:{ Exception -> 0x016c }
            nl.volkerinfradesign.checkandroid.database.InspectionItemKey r3 = r8.f5089al     // Catch:{ Exception -> 0x016c }
            android.location.Location r5 = r8.getLocation()     // Catch:{ Exception -> 0x016c }
            r3.setValue(r4, r5)     // Catch:{ Exception -> 0x016c }
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r1)     // Catch:{ Exception -> 0x007b }
            goto L_0x001a
        L_0x012e:
            r1 = move-exception
            r1 = r2
        L_0x0130:
            android.support.v4.app.FragmentActivity r3 = r8.getActivity()     // Catch:{ all -> 0x0167 }
            java.lang.String r4 = "Kan de foto niet selecteren. Waarschijnlijk ondersteunt uw gallerij dit niet."
            r5 = 1
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r4, r5)     // Catch:{ all -> 0x0167 }
            r3.show()     // Catch:{ all -> 0x0167 }
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r1)     // Catch:{ Exception -> 0x007b }
            r0.invalidateProgress()
            r8.f5089al = r2
            org.apache.commons.collections4.set.ListOrderedSet<nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver> r0 = r8.f5093ap
            org.apache.commons.collections4.OrderedIterator r1 = r0.iterator()
        L_0x014c:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0166
            java.lang.Object r0 = r1.next()
            nl.volkerinfradesign.checkandroid.ui.inspection.controllers.PageFragment$PageObserver r0 = (p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment.PageObserver) r0
            r0.notifyDataSetChanged()
            r0.invalidateFooter()
            goto L_0x014c
        L_0x015f:
            r1 = move-exception
            r3 = r2
        L_0x0161:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r3)     // Catch:{ Exception -> 0x007b }
            throw r1     // Catch:{ Exception -> 0x007b }
        L_0x0165:
            throw r1
        L_0x0166:
            return
        L_0x0167:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0161
        L_0x016c:
            r3 = move-exception
            goto L_0x0130
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    /* renamed from: n */
    private int m6114n() {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor query = getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "datetaken"}, (String) null, (String[]) null, "datetaken DESC");
            try {
                if (query.moveToFirst()) {
                    int i = query.getInt(query.getColumnIndex("_id"));
                    try {
                        IOUtils.closeQuietly((Closeable) query);
                        return i;
                    } catch (Exception e) {
                        return i;
                    }
                } else {
                    try {
                        IOUtils.closeQuietly((Closeable) query);
                    } catch (Exception e2) {
                    }
                    return -1;
                }
            } catch (Exception e3) {
                cursor = query;
                try {
                    IOUtils.closeQuietly((Closeable) cursor);
                } catch (Exception e4) {
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                cursor2 = query;
                try {
                    IOUtils.closeQuietly((Closeable) cursor2);
                } catch (Exception e5) {
                }
                throw th;
            }
        } catch (Exception e6) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((Closeable) cursor2);
            throw th;
        }
    }

    public void setProjectSelected(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor, long j) {
        if (itemCursor.setProjectSelected(j, this.f5088ak)) {
            OrderedIterator it = this.f5093ap.iterator();
            while (it.hasNext()) {
                ((PageFragment.PageObserver) it.next()).changeData();
            }
        }
        getActivity().invalidateOptionsMenu();
    }

    public void deletePicture(PageFragment pageFragment, final InspectionItemConstants.ItemCursor itemCursor, final PictureKey pictureKey) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(C1352R.C1353drawable.ic_action_delete);
        builder.setTitle("Verwijderen");
        builder.setMessage("Afbeelding echt verwijderen?");
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                itemCursor.removeSignature(pictureKey, InspectionFragment.this.getLocation());
                pictureKey.delete();
                itemCursor.setValue(itemCursor.getValue(), InspectionFragment.this.getLocation());
                itemCursor.getInspectionKey().invalidateProgress();
                dialogInterface.dismiss();
                OrderedIterator it = InspectionFragment.this.f5093ap.iterator();
                while (it.hasNext()) {
                    PageFragment.PageObserver pageObserver = (PageFragment.PageObserver) it.next();
                    pageObserver.notifyDataSetChanged();
                    pageObserver.invalidateFooter();
                }
            }
        });
        builder.show();
    }

    public void takeDrawing(InspectionItemConstants.ItemCursor itemCursor) {
        this.f5089al = itemCursor.getKey();
        startActivityForResult(new Intent(getActivity(), DrawActivity.class), 1213);
    }

    public void takePicture(InspectionItemConstants.ItemCursor itemCursor) {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") == 0) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            try {
                this.f5092ao = m6114n();
                File ensureTempFile = getApp().ensureTempFile();
                this.f5089al = itemCursor.getKey();
                intent.putExtra("output", Uri.fromFile(ensureTempFile));
                startActivityForResult(intent, 1209);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 12);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length != 0 && iArr[0] == 0) {
            switch (i) {
                case 14:
                    m6113m();
                    return;
                default:
                    return;
            }
        }
    }

    public void registerObserver(PageFragment.PageObserver pageObserver) {
        this.f5093ap.add(pageObserver);
    }

    public void unregisterObserver(PageFragment.PageObserver pageObserver) {
        this.f5093ap.remove((Object) pageObserver);
    }

    public void popSubForm(PageFragment pageFragment, int i) {
        if (i > 0) {
            getChildFragmentManager().popBackStackImmediate();
        }
    }

    public Location getLocation() {
        return this.f5088ak;
    }

    public void onSendInspectionClicked(PageFragment pageFragment) {
        getParent().onSendInspectionClicked(this, (InspectionKey) getArguments().getParcelable("inspection_fragment_3:inspection_key"), getLocation());
    }

    public void onDeleteInspectionClicked(PageFragment pageFragment) {
        getParent().onDeleteInspectionClicked(this, (InspectionKey) getArguments().getParcelable("inspection_fragment_3:inspection_key"));
    }

    public void showSubInspectionsList(PageFragment pageFragment, InspectionItemConstants.ItemCursor itemCursor) {
        C1254ii.m5549a(this, OverviewFragment.newInstance(itemCursor, pageFragment.getPosition() + 1, markInvalidItems()), itemCursor.getTitle());
    }

    public void onTakeSignatureClicked(InspectionItemConstants.ItemCursor itemCursor) {
        this.f5089al = itemCursor.getKey();
        startActivityForResult(new Intent(getActivity(), DrawActivity.class), 1214);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.InspectionFragment$a */
    final class C1575a extends AsyncTask<Long, Void, List<Form>> {
        private C1575a() {
        }

        /* renamed from: a */
        public void mo9948a() {
            executeOnExecutor(THREAD_POOL_EXECUTOR, ArrayUtils.toObject(new long[]{((FormRef) InspectionFragment.this.getArguments().getSerializable("inspection_fragment_3:form_ref")).getServerId()}));
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            C1576b unused = InspectionFragment.this.f5087aj = C1576b.DOWNLOADING_FORM.mo9953a(InspectionFragment.this, (Bundle) null, new Object[0]);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<Form> doInBackground(Long... lArr) {
            try {
                return Form.download(ArrayUtils.toPrimitive(lArr));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<Form> list) {
            super.onPostExecute(list);
            if (!InspectionFragment.this.isVisible()) {
                return;
            }
            if (list == null || list.isEmpty()) {
                C1576b unused = InspectionFragment.this.f5087aj = C1576b.DOWNLOAD_FAILED.mo9953a(InspectionFragment.this, (Bundle) null, new Object[0]);
                return;
            }
            Form form = list.get(0);
            InspectionKey newInstance = form.newInstance((Company) InspectionFragment.this.getArguments().getSerializable("inspection_fragment_3:company"), (LongSparseArray<String>) null, (InspectionsTable.InitialLocation) null);
            form.save();
            InspectionFragment.this.getArguments().putParcelable("inspection_fragment_3:inspection_key", newInstance);
            C1576b unused2 = InspectionFragment.this.f5087aj = C1576b.SHOWING_INSPECTION.mo9953a(InspectionFragment.this, (Bundle) null, newInstance);
        }
    }
}
