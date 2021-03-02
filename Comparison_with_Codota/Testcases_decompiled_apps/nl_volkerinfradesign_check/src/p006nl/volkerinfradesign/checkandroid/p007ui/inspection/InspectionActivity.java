package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.p004v7.app.AppCompatActivity;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.set.ListOrderedSet;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.OnBackPressedObservable;
import p006nl.volkerinfradesign.checkandroid.background.AllInService;
import p006nl.volkerinfradesign.checkandroid.data.tree.Company;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragmentParent;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.InspectionActivity */
public class InspectionActivity extends AppCompatActivity implements InspectionFragmentParent {
    public static final String RESULT_UPLOAD_INSPECTIONS = "result_upload_inspections";

    /* renamed from: k */
    private final ListOrderedSet<OnBackPressedObservable.OnBackPressedObserver> f5081k = new ListOrderedSet<>();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final ListOrderedSet<InspectionFragmentParent.InspectionParentObserver> f5082l = new ListOrderedSet<>();

    public static Intent getIntent(Context context, InspectionKey inspectionKey, boolean z) {
        return getIntent(context, inspectionKey, z, 0);
    }

    public static final Intent getIntent(Context context, FormRef formRef, Company company) {
        Intent intent = new Intent(context, InspectionActivity.class);
        intent.putExtra("inspection_activity:title", formRef.getTitle());
        intent.putExtra("inspection_activity:form_ref", formRef);
        intent.putExtra("inspection_activity:company", company);
        return intent;
    }

    public static Intent getIntent(Context context, InspectionKey inspectionKey, boolean z, int i) {
        Intent intent = new Intent(context, InspectionActivity.class);
        intent.putExtra("inspection_activity:title", inspectionKey.getTitle());
        intent.putExtra("inspection_activity:inspection_key", inspectionKey);
        intent.putExtra("inspection_activity:is_preview", z);
        intent.putExtra("inspection_activity:icon_id", i);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        InspectionFragment newInstance;
        super.onCreate(bundle);
        Intent intent = getIntent();
        boolean hasExtra = intent.hasExtra("inspection_activity:inspection_key");
        int intExtra = getIntent().getIntExtra("inspection_activity:icon_id", 0);
        ActionBarCompat actionBarCompat = new ActionBarCompat(this);
        setTheme(m6097b().getModel().getCustomTheme().getMainStyle());
        actionBarCompat.setDisplayHomeAsUpEnabled(true);
        actionBarCompat.setTitle(intent.getStringExtra("inspection_activity:title"));
        if (intExtra != 0) {
            actionBarCompat.setIcon(intExtra);
        }
        if (bundle == null) {
            if (hasExtra) {
                newInstance = InspectionFragment.newInstance((InspectionKey) intent.getParcelableExtra("inspection_activity:inspection_key"), intent.getBooleanExtra("inspection_activity:is_preview", false));
            } else {
                newInstance = InspectionFragment.newInstance((FormRef) intent.getSerializableExtra("inspection_activity:form_ref"), (Company) intent.getSerializableExtra("inspection_activity:company"));
            }
            getSupportFragmentManager().beginTransaction().add(16908290, newInstance, "inspection_activity:inspection_fragment_tag").commit();
        }
    }

    public void onSendInspectionClicked(InspectionFragment inspectionFragment, InspectionKey inspectionKey, Location location) {
        float f = inspectionKey.getprogress();
        if (f < 1.0f) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(C1352R.C1353drawable.ic_action_send_now);
            builder.setTitle("Niet afgerond");
            builder.setMessage(C1352R.string.incomplete_inspection_message);
            builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    OrderedIterator it = InspectionActivity.this.f5082l.iterator();
                    while (it.hasNext()) {
                        ((InspectionFragmentParent.InspectionParentObserver) it.next()).scrollToFirstInvalid();
                    }
                }
            });
            builder.show();
            return;
        }
        Intent intent = new Intent();
        InspectionsTable inspectionData = Schema.getInspectionData();
        inspectionKey.setLocation(location);
        intent.putExtra(RESULT_UPLOAD_INSPECTIONS, true);
        intent.putExtra("inspection_activity:result_inspection_id", inspectionKey.getInspectionId());
        intent.putExtra("inspection_activity:result_progress", f);
        setResult(-1, intent);
        if (inspectionData.setPending() > 0 || inspectionData.hasPending(false)) {
            m6097b().notifyDataSetChanged();
            AllInService.start(getApplicationContext());
        }
        finish();
    }

    public void onDeleteInspectionClicked(InspectionFragment inspectionFragment, final InspectionKey inspectionKey) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Waarschuwing!");
        builder.setCancelable(true);
        builder.setMessage("Weet u zeker dat u het formulier wilt weggooien?");
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("inspection_activity:result_inspection_deleted", true);
                InspectionActivity.this.setResult(-1, intent);
                inspectionKey.delete();
                InspectionActivity.this.finish();
            }
        });
        builder.show();
    }

    public void registerInspectionActivityObserver(InspectionFragmentParent.InspectionParentObserver inspectionParentObserver) {
        this.f5082l.add(inspectionParentObserver);
    }

    public void unregisterInspectionActivityObserver(InspectionFragmentParent.InspectionParentObserver inspectionParentObserver) {
        this.f5082l.remove((Object) inspectionParentObserver);
    }

    /* renamed from: b */
    private App m6097b() {
        return (App) getApplication();
    }

    public void registerOnBackPressedObserver(OnBackPressedObservable.OnBackPressedObserver onBackPressedObserver) {
        this.f5081k.add(onBackPressedObserver);
    }

    public void unregisterOnBackPressedObserver(OnBackPressedObservable.OnBackPressedObserver onBackPressedObserver) {
        this.f5081k.remove((Object) onBackPressedObserver);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:4:0x0017, LOOP_START, PHI: r0 
      PHI: (r0v1 boolean) = (r0v0 boolean), (r0v5 boolean) binds: [B:0:0x0000, B:4:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r3 = this;
            r0 = 0
            org.apache.commons.collections4.set.ListOrderedSet<nl.volkerinfradesign.checkandroid.OnBackPressedObservable$OnBackPressedObserver> r1 = r3.f5081k
            org.apache.commons.collections4.OrderedIterator r1 = r1.iterator()
        L_0x0007:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r0 = r1.next()
            nl.volkerinfradesign.checkandroid.OnBackPressedObservable$OnBackPressedObserver r0 = (p006nl.volkerinfradesign.checkandroid.OnBackPressedObservable.OnBackPressedObserver) r0
            boolean r0 = r0.onActivityBackPressed()
            if (r0 == 0) goto L_0x0007
        L_0x0019:
            if (r0 != 0) goto L_0x001e
            super.onBackPressed()
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionActivity.onBackPressed():void");
    }
}
