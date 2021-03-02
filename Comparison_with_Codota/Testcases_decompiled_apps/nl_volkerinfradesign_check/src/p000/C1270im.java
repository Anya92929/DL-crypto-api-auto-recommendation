package p000;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.ProjectsTable;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemView;

/* renamed from: im */
public final class C1270im {

    /* renamed from: a */
    final RadioGroup f4448a;

    /* renamed from: b */
    final RadioGroup f4449b;

    /* renamed from: c */
    final RadioGroup f4450c;

    /* renamed from: d */
    final FrameLayout f4451d;

    /* renamed from: e */
    final LinearLayout f4452e;

    /* renamed from: f */
    final LinearLayout f4453f;

    /* renamed from: g */
    final Button f4454g;

    /* renamed from: h */
    final Button f4455h;

    /* renamed from: i */
    final Button f4456i;

    /* renamed from: j */
    final Button f4457j;

    /* renamed from: k */
    final RadioButton f4458k;

    /* renamed from: l */
    final RadioButton f4459l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final ItemView f4460m;

    /* renamed from: n */
    private final LinearLayout.LayoutParams f4461n = new LinearLayout.LayoutParams(-1, -2);

    /* renamed from: o */
    private final View.OnClickListener f4462o = new View.OnClickListener() {
        public void onClick(View view) {
            C1270im.this.f4460m.mo10064b();
        }
    };

    /* renamed from: p */
    private final View.OnClickListener f4463p = new View.OnClickListener() {
        public void onClick(View view) {
            C1270im.this.f4460m.mo10057a();
        }
    };

    /* renamed from: q */
    private final CompoundButton.OnCheckedChangeListener f4464q = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < C1270im.this.f4452e.getChildCount()) {
                    CheckBox checkBox = (CheckBox) C1270im.this.f4452e.getChildAt(i2);
                    if (checkBox.isChecked()) {
                        arrayList.add((String) checkBox.getTag());
                    }
                    i = i2 + 1;
                } else {
                    C1270im.this.f4460m.mo10060a((Object) arrayList.toArray(new String[arrayList.size()]));
                    return;
                }
            }
        }
    };

    /* renamed from: r */
    private final RadioGroup.OnCheckedChangeListener f4465r = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            View findViewById = radioGroup.findViewById(i);
            if (findViewById != null) {
                C1270im.this.f4460m.mo10058a(((Long) findViewById.getTag()).longValue());
            }
        }
    };

    /* renamed from: s */
    private final View.OnClickListener f4466s = new View.OnClickListener() {
        public void onClick(View view) {
            String str = (String) view.getTag();
            C1270im.this.f4460m.mo10060a((Object) str);
            C1270im.this.m5592a(str);
        }
    };

    /* renamed from: t */
    private final View.OnClickListener f4467t = new View.OnClickListener() {
        public void onClick(View view) {
            boolean z = view.getId() == C1352R.C1354id.yes;
            C1270im.this.f4460m.mo10060a((Object) Boolean.valueOf(z));
            C1270im.this.f4448a.clearCheck();
            (z ? C1270im.this.f4458k : C1270im.this.f4459l).setChecked(true);
        }
    };

    /* renamed from: u */
    private final View.OnClickListener f4468u = new View.OnClickListener() {
        public void onClick(View view) {
            C1270im.this.f4460m.onTakeSignatureClicked();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5592a(String str) {
        int childCount = this.f4449b.getChildCount();
        this.f4449b.clearCheck();
        for (int i = 0; i < childCount; i++) {
            RadioButton radioButton = (RadioButton) this.f4449b.getChildAt(i);
            if (StringUtils.equals(str, (String) radioButton.getTag())) {
                radioButton.setChecked(true);
                return;
            }
        }
    }

    public C1270im(ItemView itemView) {
        this.f4460m = itemView;
        this.f4451d = (FrameLayout) itemView.findViewById(C1352R.C1354id.widgets);
        this.f4453f = (LinearLayout) itemView.findViewById(C1352R.C1354id.projectsContainer);
        this.f4453f.setTag(new InspectionItemType[]{InspectionItemType.PROJECTS});
        this.f4450c = (RadioGroup) this.f4453f.findViewById(C1352R.C1354id.projects);
        this.f4456i = (Button) this.f4453f.findViewById(C1352R.C1354id.moreProjects);
        if (itemView.f5253c) {
            this.f4456i.setVisibility(8);
        } else {
            this.f4456i.setOnClickListener(this.f4463p);
        }
        this.f4457j = (Button) this.f4451d.findViewById(C1352R.C1354id.signatureButton);
        this.f4457j.setTag(new InspectionItemType[]{InspectionItemType.SIGNATURE});
        this.f4457j.setOnClickListener(this.f4468u);
        this.f4454g = (Button) this.f4451d.findViewById(C1352R.C1354id.textInput);
        this.f4454g.setTag(new InspectionItemType[]{InspectionItemType.STRING, InspectionItemType.INTEGER, InspectionItemType.FLOAT});
        this.f4454g.setOnClickListener(this.f4462o);
        this.f4455h = (Button) this.f4451d.findViewById(C1352R.C1354id.dateInput);
        this.f4455h.setTag(new InspectionItemType[]{InspectionItemType.DATE, InspectionItemType.TIME, InspectionItemType.DATETIME});
        this.f4455h.setOnClickListener(this.f4462o);
        this.f4448a = (RadioGroup) this.f4451d.findViewById(C1352R.C1354id.booleanChoice);
        this.f4448a.setTag(new InspectionItemType[]{InspectionItemType.BOOLEAN});
        this.f4458k = (RadioButton) this.f4448a.findViewById(C1352R.C1354id.yes);
        this.f4459l = (RadioButton) this.f4448a.findViewById(C1352R.C1354id.f4652no);
        this.f4449b = (RadioGroup) this.f4451d.findViewById(C1352R.C1354id.singleChoice);
        this.f4449b.setTag(new InspectionItemType[]{InspectionItemType.SINGLECHOICE});
        this.f4452e = (LinearLayout) this.f4451d.findViewById(C1352R.C1354id.multiChoice);
        this.f4452e.setTag(new InspectionItemType[]{InspectionItemType.MULTICHOICE});
    }

    /* renamed from: a */
    public void mo8617a() {
        boolean z;
        InspectionItemType inspectionItemType = this.f4460m.f5271u;
        if (this.f4460m.f5257g || this.f4460m.f5253c) {
            z = false;
        } else {
            z = true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4451d.getChildCount()) {
                View childAt = this.f4451d.getChildAt(i2);
                if (ArrayUtils.contains((Object[]) (InspectionItemType[]) childAt.getTag(), (Object) inspectionItemType)) {
                    childAt.setVisibility(0);
                    switch (inspectionItemType) {
                        case STRING:
                        case DATE:
                        case TIME:
                        case DATETIME:
                        case INTEGER:
                        case FLOAT:
                            ((TextView) childAt).setText(this.f4460m.f5262l ? this.f4460m.f5270t : null);
                            childAt.setEnabled(z);
                            break;
                        case BOOLEAN:
                            Boolean bool = (Boolean) this.f4460m.f5274x;
                            this.f4458k.setEnabled(z);
                            this.f4459l.setEnabled(z);
                            this.f4458k.setOnClickListener(this.f4467t);
                            this.f4459l.setOnClickListener(this.f4467t);
                            this.f4448a.clearCheck();
                            if (bool != null) {
                                (bool.booleanValue() ? this.f4458k : this.f4459l).setChecked(true);
                                break;
                            } else {
                                break;
                            }
                        case PROJECTS:
                            Long selectedProjectId = this.f4460m.f5275y.getSelectedProjectId();
                            ProjectsTable.ProjectsCursor projects = this.f4460m.f5275y.getProjects();
                            boolean z2 = z && projects != null && projects.moveToFirst();
                            this.f4450c.removeAllViews();
                            this.f4450c.setEnabled(z2);
                            this.f4450c.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            int i3 = 0;
                            boolean z3 = false;
                            while (projects != null && projects.moveToPosition(i3) && i3 < 5) {
                                RadioButton radioButton = null;
                                boolean z4 = selectedProjectId != null && projects.getServerId() == selectedProjectId.longValue();
                                boolean z5 = z4 || z3;
                                switch (i3) {
                                    case 4:
                                        if (selectedProjectId != null && !z5 && !z4) {
                                            while (true) {
                                                if (projects.moveToNext()) {
                                                    if (projects.getServerId() == selectedProjectId.longValue()) {
                                                        radioButton = m5589a(projects, i3 + 1, z2, true);
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                    default:
                                        radioButton = m5589a(projects, i3 + 1, z2, z4);
                                        break;
                                }
                                if (radioButton != null) {
                                    this.f4450c.addView(radioButton);
                                }
                                i3++;
                                z3 = z5;
                            }
                            this.f4450c.setOnCheckedChangeListener(this.f4465r);
                            break;
                        case SINGLECHOICE:
                            JsonArray jsonArray = this.f4460m.f5272v;
                            String str = (String) this.f4460m.f5274x;
                            if (jsonArray.size() == 0 && str != null) {
                                jsonArray.add(new JsonPrimitive(str));
                            }
                            this.f4449b.removeAllViews();
                            this.f4449b.setEnabled(z);
                            for (int i4 = 0; i4 < jsonArray.size(); i4++) {
                                String asString = jsonArray.get(i4).getAsString();
                                RadioButton radioButton2 = new RadioButton(this.f4460m.getContext());
                                radioButton2.setText(asString);
                                radioButton2.setTag(asString);
                                radioButton2.setId(i4 + 1);
                                radioButton2.setLayoutParams(this.f4461n);
                                radioButton2.setEnabled(z);
                                radioButton2.setOnClickListener(this.f4466s);
                                this.f4449b.addView(radioButton2);
                            }
                            m5592a(str);
                            break;
                        case MULTICHOICE:
                            JsonArray jsonArray2 = this.f4460m.f5272v;
                            String[] strArr = (String[]) this.f4460m.f5274x;
                            if (jsonArray2.size() == 0 && strArr != null && strArr.length > 0) {
                                for (String jsonPrimitive : strArr) {
                                    jsonArray2.add(new JsonPrimitive(jsonPrimitive));
                                }
                            }
                            this.f4452e.removeAllViews();
                            this.f4452e.setEnabled(z);
                            int i5 = 0;
                            while (jsonArray2 != null && i5 < jsonArray2.size()) {
                                String asString2 = jsonArray2.get(i5).getAsString();
                                CheckBox checkBox = new CheckBox(this.f4460m.getContext());
                                checkBox.setId(i5 + 1);
                                checkBox.setText(asString2);
                                checkBox.setTag(asString2);
                                checkBox.setChecked(strArr != null && ArrayUtils.contains((Object[]) strArr, (Object) asString2));
                                checkBox.setOnCheckedChangeListener(this.f4464q);
                                checkBox.setLayoutParams(this.f4461n);
                                checkBox.setEnabled(z);
                                this.f4452e.addView(checkBox);
                                i5++;
                            }
                            break;
                    }
                } else {
                    childAt.setVisibility(8);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private RadioButton m5589a(ProjectsTable.ProjectsCursor projectsCursor, int i, boolean z, boolean z2) {
        RadioButton radioButton = new RadioButton(this.f4460m.getContext());
        radioButton.setText(projectsCursor.getCode() + " | " + projectsCursor.getTitle());
        radioButton.setTag(Long.valueOf(projectsCursor.getServerId()));
        radioButton.setId(i);
        radioButton.setChecked(z2);
        radioButton.setLayoutParams(this.f4461n);
        radioButton.setEnabled(z);
        return radioButton;
    }

    /* renamed from: b */
    public void mo8618b() {
    }
}
