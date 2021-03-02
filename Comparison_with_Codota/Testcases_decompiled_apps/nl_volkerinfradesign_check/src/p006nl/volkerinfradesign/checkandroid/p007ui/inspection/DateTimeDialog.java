package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Locale;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.DateTimeDialog */
public class DateTimeDialog extends DialogFragment {

    /* renamed from: aj */
    private C1561a f5049aj;

    /* renamed from: ak */
    private RadioGroup f5050ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public Calendar f5051al;

    /* renamed from: am */
    private InspectionItemKey f5052am;

    /* renamed from: an */
    private RadioButton f5053an;

    /* renamed from: ao */
    private RadioButton f5054ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public DatePicker f5055ap;

    /* renamed from: aq */
    private final DialogInterface.OnClickListener f5056aq = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            DateTimeDialog.this.m6082o().onValueChanged((InspectionItemKey) DateTimeDialog.this.getArguments().getParcelable("check:item_key"), i == -3 ? null : DateTimeDialog.this.f5051al);
            dialogInterface.dismiss();
        }
    };

    /* renamed from: ar */
    private final RadioGroup.OnCheckedChangeListener f5057ar = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == C1352R.C1354id.date) {
                DateTimeDialog.this.f5055ap.setVisibility(0);
                DateTimeDialog.this.f5061av.setVisibility(4);
                return;
            }
            DateTimeDialog.this.f5061av.setVisibility(0);
            DateTimeDialog.this.f5055ap.setVisibility(4);
        }
    };

    /* renamed from: as */
    private final DatePicker.OnDateChangedListener f5058as = new DatePicker.OnDateChangedListener() {
        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            DateTimeDialog.this.m6079l().set(1, i);
            DateTimeDialog.this.m6079l().set(2, i2);
            DateTimeDialog.this.m6079l().set(5, i3);
        }
    };

    /* renamed from: at */
    private final TimePicker.OnTimeChangedListener f5059at = new TimePicker.OnTimeChangedListener() {
        public void onTimeChanged(TimePicker timePicker, int i, int i2) {
            DateTimeDialog.this.m6079l().set(11, i);
            DateTimeDialog.this.m6079l().set(12, i2);
        }
    };

    /* renamed from: au */
    private FrameLayout f5060au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public TimePicker f5061av;

    /* renamed from: aw */
    private C1562b f5062aw;

    /* renamed from: ax */
    private LinearLayout f5063ax;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.DateTimeDialog$a */
    interface C1561a {
        void onValueChanged(InspectionItemKey inspectionItemKey, Calendar calendar);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.DateTimeDialog$b */
    enum C1562b {
        DATE {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo9898a(DatePicker datePicker, RadioButton radioButton, TimePicker timePicker, RadioButton radioButton2, RadioGroup radioGroup) {
                radioGroup.setVisibility(8);
                datePicker.setVisibility(0);
                radioButton2.setVisibility(8);
            }
        },
        DATETIME {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo9898a(DatePicker datePicker, RadioButton radioButton, TimePicker timePicker, RadioButton radioButton2, RadioGroup radioGroup) {
                radioGroup.setVisibility(0);
                radioButton.setSelected(true);
                datePicker.setVisibility(0);
                timePicker.setVisibility(4);
            }
        },
        TIME {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo9898a(DatePicker datePicker, RadioButton radioButton, TimePicker timePicker, RadioButton radioButton2, RadioGroup radioGroup) {
                radioGroup.setVisibility(8);
                datePicker.setVisibility(8);
                timePicker.setVisibility(0);
            }
        };

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo9898a(DatePicker datePicker, RadioButton radioButton, TimePicker timePicker, RadioButton radioButton2, RadioGroup radioGroup);
    }

    public static final DateTimeDialog newDateInstance(InspectionItemConstants.ItemCursor itemCursor) {
        return m6074a("Datum", C1562b.DATE, itemCursor);
    }

    public static final DateTimeDialog newDateTimeInstance(InspectionItemConstants.ItemCursor itemCursor) {
        return m6074a("Datum & tijd", C1562b.DATETIME, itemCursor);
    }

    public static final DateTimeDialog newTimeInstance(InspectionItemConstants.ItemCursor itemCursor) {
        return m6074a("Tijd", C1562b.TIME, itemCursor);
    }

    /* renamed from: a */
    private static DateTimeDialog m6074a(String str, C1562b bVar, InspectionItemConstants.ItemCursor itemCursor) {
        DateTimeDialog dateTimeDialog = new DateTimeDialog();
        Bundle bundle = new Bundle();
        Long l = (Long) itemCursor.getValue();
        bundle.putString("check:title", str);
        bundle.putString("check:dialog_type", bVar.name());
        bundle.putParcelable("check:item_key", itemCursor.getKey());
        bundle.putLong("check:calendar_millis", l == null ? System.currentTimeMillis() : l.longValue());
        dateTimeDialog.setArguments(bundle);
        return dateTimeDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            long j = bundle.getLong("check:calendar_millis", Long.MIN_VALUE);
            if (j != Long.MIN_VALUE) {
                this.f5051al = Calendar.getInstance(Locale.getDefault());
                this.f5051al.setTimeInMillis(j);
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Calendar l = m6079l();
        this.f5063ax = (LinearLayout) getActivity().getLayoutInflater().inflate(C1352R.layout.ins_2_dialog_date_time_input, (ViewGroup) null);
        this.f5050ak = (RadioGroup) this.f5063ax.findViewById(C1352R.C1354id.buttons);
        this.f5050ak.setOnCheckedChangeListener(this.f5057ar);
        this.f5053an = (RadioButton) this.f5050ak.findViewById(C1352R.C1354id.date);
        this.f5054ao = (RadioButton) this.f5050ak.findViewById(C1352R.C1354id.time);
        this.f5060au = (FrameLayout) this.f5063ax.findViewById(C1352R.C1354id.pickers);
        this.f5055ap = (DatePicker) this.f5060au.findViewById(C1352R.C1354id.datePicker);
        this.f5055ap.setCalendarViewShown(false);
        this.f5055ap.init(l.get(1), l.get(2), l.get(5), this.f5058as);
        this.f5061av = (TimePicker) this.f5060au.findViewById(C1352R.C1354id.timePicker);
        this.f5061av.setIs24HourView(true);
        this.f5061av.setCurrentHour(Integer.valueOf(l.get(11)));
        this.f5061av.setCurrentMinute(Integer.valueOf(l.get(12)));
        this.f5061av.setOnTimeChangedListener(this.f5059at);
        m6081n().mo9898a(this.f5055ap, this.f5053an, this.f5061av, this.f5054ao, this.f5050ak);
        builder.setIcon(C1352R.C1353drawable.ic_action_date);
        builder.setTitle(getArguments().getString("check:title"));
        builder.setView(this.f5063ax);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, this.f5056aq);
        if (m6080m().hasValue()) {
            builder.setNeutralButton("Wissen", this.f5056aq);
        }
        return builder.create();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("check:calendar_millis", m6079l().getTimeInMillis());
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public Calendar m6079l() {
        if (this.f5051al == null) {
            this.f5051al = Calendar.getInstance(Locale.getDefault());
            this.f5051al.setTimeInMillis(getArguments().getLong("check:calendar_millis"));
        }
        return this.f5051al;
    }

    /* renamed from: m */
    private InspectionItemKey m6080m() {
        if (this.f5052am == null) {
            this.f5052am = (InspectionItemKey) getArguments().getParcelable("check:item_key");
        }
        return this.f5052am;
    }

    /* renamed from: n */
    private C1562b m6081n() {
        if (this.f5062aw == null) {
            this.f5062aw = C1562b.valueOf(getArguments().getString("check:dialog_type"));
        }
        return this.f5062aw;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public C1561a m6082o() {
        if (this.f5049aj == null) {
            Object parentFragment = getParentFragment();
            if (!(parentFragment instanceof C1561a)) {
                parentFragment = getActivity();
            }
            this.f5049aj = (C1561a) parentFragment;
        }
        return this.f5049aj;
    }
}
