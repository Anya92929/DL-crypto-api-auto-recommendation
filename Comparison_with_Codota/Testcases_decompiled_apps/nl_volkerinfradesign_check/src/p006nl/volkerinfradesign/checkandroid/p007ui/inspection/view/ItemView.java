package p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.ActionColumns;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p006nl.volkerinfradesign.checkandroid.p007ui.browser.BrowserActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.view.ItemView */
public final class ItemView extends LinearLayout {

    /* renamed from: B */
    private static final String f5208B = (ItemView.class.getName() + ":");

    /* renamed from: C */
    private static final String f5209C = (f5208B + "item_id");

    /* renamed from: D */
    private static final String f5210D = (f5208B + "intrinsic_state");

    /* renamed from: E */
    private static final String f5211E = (f5208B + "is_preview");

    /* renamed from: F */
    private static final String f5212F = (f5208B + "mark_invalid");

    /* renamed from: G */
    private static final String f5213G = (f5208B + "title");

    /* renamed from: H */
    private static final String f5214H = (f5208B + ActionColumns.DESCRIPTION);

    /* renamed from: I */
    private static final String f5215I = (f5208B + "is_required");

    /* renamed from: J */
    private static final String f5216J = (f5208B + "is_pic_required");

    /* renamed from: K */
    private static final String f5217K = (f5208B + "is_inapplicable");

    /* renamed from: L */
    private static final String f5218L = (f5208B + "is_inapplicable_possible");

    /* renamed from: M */
    private static final String f5219M = (f5208B + "has_triggered_condition");

    /* renamed from: N */
    private static final String f5220N = (f5208B + "has_pics");

    /* renamed from: O */
    private static final String f5221O = (f5208B + "has_remark");

    /* renamed from: P */
    private static final String f5222P = (f5208B + "type");

    /* renamed from: Q */
    private static final String f5223Q = (f5208B + InspectionItemConstants.REMARK);

    /* renamed from: R */
    private static final String f5224R = (f5208B + "has_value");

    /* renamed from: S */
    private static final String f5225S = (f5208B + "value");

    /* renamed from: T */
    private static final String f5226T = (f5208B + "string_value");

    /* renamed from: U */
    private static final String f5227U = (f5208B + InspectionItemConstants.CHOICES);

    /* renamed from: V */
    private static final String f5228V = (f5208B + "inspection_key");

    /* renamed from: W */
    private static final String f5229W = (f5208B + "images");

    /* renamed from: aa */
    private static final String f5230aa = (f5208B + "custom_location_required");

    /* renamed from: ab */
    private static final String f5231ab = (f5208B + "has_custom_location");

    /* renamed from: ac */
    private static final String f5232ac = (f5208B + "desc_img_file");

    /* renamed from: ad */
    private static final String f5233ad = (f5208B + "desc_img_file");

    /* renamed from: ae */
    private static final String f5234ae = (f5208B + "buttons_expanded");

    /* renamed from: af */
    private static final String f5235af = (f5208B + InspectionItemConstants.HYPERLINKS);

    /* renamed from: A */
    public String f5236A;

    /* renamed from: a */
    ItemViewObserver f5237a;

    /* renamed from: ag */
    private C1260ik f5238ag;

    /* renamed from: ah */
    private C1265il f5239ah;

    /* renamed from: ai */
    private C1270im f5240ai;

    /* renamed from: aj */
    private C1279in f5241aj;

    /* renamed from: ak */
    private View f5242ak;

    /* renamed from: al */
    private View f5243al;

    /* renamed from: am */
    private Button f5244am;

    /* renamed from: an */
    private Button f5245an;

    /* renamed from: ao */
    private TextView f5246ao;

    /* renamed from: ap */
    private TextView f5247ap;

    /* renamed from: aq */
    private TextView f5248aq;

    /* renamed from: ar */
    private View f5249ar;

    /* renamed from: as */
    private LinearLayout f5250as;

    /* renamed from: at */
    private final View.OnClickListener f5251at = new View.OnClickListener() {
        public void onClick(View view) {
            if (ItemView.this.f5237a != null) {
                ItemView.this.f5237a.onSubFormButtonClicked(ItemView.this.f5252b);
            }
        }
    };

    /* renamed from: b */
    long f5252b;

    /* renamed from: c */
    public boolean f5253c;

    /* renamed from: d */
    boolean f5254d;

    /* renamed from: e */
    boolean f5255e;

    /* renamed from: f */
    boolean f5256f;

    /* renamed from: g */
    public boolean f5257g;

    /* renamed from: h */
    public boolean f5258h;

    /* renamed from: i */
    boolean f5259i;

    /* renamed from: j */
    public boolean f5260j;

    /* renamed from: k */
    public boolean f5261k;

    /* renamed from: l */
    public boolean f5262l;

    /* renamed from: m */
    public boolean f5263m;

    /* renamed from: n */
    public boolean f5264n;

    /* renamed from: o */
    public boolean f5265o;

    /* renamed from: p */
    public boolean f5266p;

    /* renamed from: q */
    String f5267q;

    /* renamed from: r */
    String f5268r;

    /* renamed from: s */
    String f5269s;

    /* renamed from: t */
    public String f5270t;

    /* renamed from: u */
    public InspectionItemType f5271u;

    /* renamed from: v */
    public JsonArray f5272v;

    /* renamed from: w */
    JsonArray f5273w;

    /* renamed from: x */
    public Object f5274x;

    /* renamed from: y */
    public InspectionKey f5275y;

    /* renamed from: z */
    public PictureKey[] f5276z;

    public ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putLong(f5209C, this.f5252b);
        bundle.putBoolean(f5211E, this.f5253c);
        bundle.putBoolean(f5212F, this.f5254d);
        bundle.putBoolean(f5215I, this.f5256f);
        bundle.putBoolean(f5216J, this.f5263m);
        bundle.putBoolean(f5217K, this.f5257g);
        bundle.putBoolean(f5218L, this.f5258h);
        bundle.putBoolean(f5219M, this.f5259i);
        bundle.putBoolean(f5220N, this.f5260j);
        bundle.putBoolean(f5221O, this.f5261k);
        bundle.putBoolean(f5224R, this.f5262l);
        bundle.putBoolean(f5230aa, this.f5264n);
        bundle.putBoolean(f5231ab, this.f5265o);
        bundle.putString(f5213G, this.f5267q);
        bundle.putString(f5214H, this.f5268r);
        bundle.putString(f5222P, this.f5271u.name());
        bundle.putString(f5223Q, this.f5269s);
        bundle.putString(f5225S, this.f5274x.toString());
        bundle.putString(f5226T, this.f5270t);
        bundle.putString(f5227U, this.f5272v.toString());
        bundle.putString(f5232ac, this.f5236A);
        bundle.putParcelable(f5210D, super.onSaveInstanceState());
        bundle.putParcelable(f5228V, this.f5275y);
        bundle.putParcelableArray(f5229W, this.f5276z);
        bundle.putBoolean(f5234ae, this.f5266p);
        if (this.f5273w != null) {
            bundle.putString(f5235af, this.f5273w.toString());
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        String string = bundle.getString(f5227U);
        String string2 = bundle.getString(f5235af, (String) null);
        this.f5252b = bundle.getLong(f5209C);
        this.f5253c = bundle.getBoolean(f5211E);
        this.f5254d = bundle.getBoolean(f5212F);
        this.f5256f = bundle.getBoolean(f5215I);
        this.f5263m = bundle.getBoolean(f5216J);
        this.f5257g = bundle.getBoolean(f5217K);
        this.f5258h = bundle.getBoolean(f5218L);
        this.f5259i = bundle.getBoolean(f5219M);
        this.f5260j = bundle.getBoolean(f5220N);
        this.f5261k = bundle.getBoolean(f5221O);
        this.f5262l = bundle.getBoolean(f5224R);
        this.f5264n = bundle.getBoolean(f5230aa);
        this.f5265o = bundle.getBoolean(f5231ab);
        this.f5267q = bundle.getString(f5213G);
        this.f5268r = bundle.getString(f5214H);
        this.f5271u = InspectionItemType.valueOf(bundle.getString(f5222P));
        this.f5269s = bundle.getString(f5223Q);
        this.f5274x = this.f5271u.getValue(bundle.getString(f5225S));
        this.f5270t = bundle.getString(f5226T);
        this.f5236A = bundle.getString(f5232ac);
        if (string != null) {
            this.f5272v = new JsonParser().parse(string).getAsJsonArray();
        }
        if (string2 != null) {
            try {
                this.f5273w = new JsonParser().parse(string2).getAsJsonArray();
            } catch (Exception e) {
                this.f5273w = null;
            }
        }
        this.f5275y = (InspectionKey) bundle.getParcelable(f5228V);
        this.f5276z = (PictureKey[]) bundle.getParcelableArray(f5229W);
        this.f5266p = bundle.getBoolean(f5234ae);
        super.onRestoreInstanceState(bundle.getParcelable(f5210D));
    }

    public void setInspectionItem(InspectionKey inspectionKey, InspectionItemConstants.ItemCursor itemCursor, boolean z, boolean z2, boolean z3) {
        JsonArray jsonArray;
        String str = null;
        if (itemCursor != null && !itemCursor.isClosed()) {
            this.f5252b = itemCursor.getId();
            this.f5253c = z;
            this.f5254d = z2;
            this.f5255e = itemCursor.isValid();
            this.f5267q = itemCursor.getTitle();
            this.f5268r = itemCursor.getDescription();
            this.f5256f = itemCursor.isRequired();
            this.f5263m = itemCursor.isPictureRequired();
            this.f5257g = itemCursor.isInapplicable();
            this.f5258h = itemCursor.isInapplicablePossible();
            this.f5276z = itemCursor.getImages();
            this.f5260j = this.f5276z != null && this.f5276z.length > 0;
            this.f5261k = itemCursor.hasRemark();
            this.f5271u = itemCursor.getType();
            setValue(itemCursor);
            this.f5269s = itemCursor.getRemark();
            if (this.f5271u.hasChoices()) {
                jsonArray = itemCursor.getChoices();
            } else {
                jsonArray = null;
            }
            this.f5272v = jsonArray;
            this.f5275y = inspectionKey;
            this.f5264n = itemCursor.isCustomLocationRequired();
            this.f5265o = itemCursor.hasCustomlocation();
            if (itemCursor.hasDescriptiveImageUrl()) {
                str = itemCursor.getDescriptiveImageUrl();
            }
            this.f5236A = str;
            this.f5266p = z3;
            this.f5273w = itemCursor.getHyperlinks();
        }
        m6206i();
    }

    private void setValue(InspectionItemConstants.ItemCursor itemCursor) {
        switch (itemCursor.getType()) {
            case HEADER:
            case PROJECTS:
                this.f5262l = false;
                this.f5274x = null;
                this.f5270t = null;
                this.f5259i = false;
                return;
            default:
                this.f5262l = itemCursor.hasValue();
                this.f5274x = itemCursor.getValue();
                this.f5270t = itemCursor.getStringValue();
                this.f5259i = itemCursor.hasTriggeredCondition();
                return;
        }
    }

    /* renamed from: i */
    private void m6206i() {
        int i;
        boolean z;
        boolean z2 = true;
        this.f5246ao.setText(this.f5267q);
        this.f5248aq.setVisibility(this.f5256f ? 0 : 4);
        if (StringUtils.isNotBlank(this.f5268r)) {
            this.f5247ap.setText(this.f5268r);
            this.f5247ap.setVisibility(0);
        } else {
            this.f5247ap.setVisibility(8);
        }
        Button button = this.f5245an;
        if (this.f5259i) {
            i = 0;
        } else {
            i = 8;
        }
        button.setVisibility(i);
        Button button2 = this.f5245an;
        if (!this.f5257g) {
            z = true;
        } else {
            z = false;
        }
        button2.setEnabled(z);
        if (this.f5261k) {
            this.f5244am.setVisibility(0);
            this.f5244am.setText(this.f5269s);
            this.f5244am.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ItemView.this.f5237a != null) {
                        ItemView.this.f5237a.onRemarkClicked(ItemView.this.f5252b);
                    }
                }
            });
            Button button3 = this.f5244am;
            if (this.f5253c) {
                z2 = false;
            }
            button3.setEnabled(z2);
        } else {
            this.f5244am.setVisibility(8);
        }
        if (!this.f5254d || this.f5255e) {
            this.f5243al.setBackgroundColor(getResources().getColor(C1352R.color.vw_text_white));
        } else {
            this.f5243al.setBackgroundColor(getResources().getColor(C1352R.color.invalid_card_red));
        }
        m6207j();
        this.f5238ag.mo8594a();
        this.f5240ai.mo8617a();
        this.f5241aj.mo8626a();
        this.f5239ah.mo8605a();
    }

    /* renamed from: j */
    private void m6207j() {
        this.f5250as.removeAllViews();
        if (this.f5273w != null) {
            this.f5249ar.setVisibility(0);
            Iterator<JsonElement> it = this.f5273w.iterator();
            while (it.hasNext()) {
                JsonElement next = it.next();
                try {
                    if (next instanceof JsonObject) {
                        String asString = ((JsonObject) next).get("title").getAsString();
                        final String asString2 = ((JsonObject) next).get("hyperlink").getAsString();
                        Button button = new Button(getContext());
                        button.setText(asString + " (" + asString2 + ")");
                        this.f5250as.addView(button);
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(ItemView.this.getContext(), BrowserActivity.class);
                                intent.putExtra("url", asString2);
                                ItemView.this.getContext().startActivity(intent);
                            }
                        });
                        button.setTypeface((Typeface) null, 2);
                        button.setBackgroundResource(C1352R.C1353drawable.selectable_item_bg_transparent_drawer_selector_light_gray);
                        button.setGravity(3);
                        button.setAllCaps(false);
                        if (Build.VERSION.SDK_INT >= 23) {
                            button.setTextAppearance(16973892);
                        } else {
                            button.setTextAppearance(getContext(), 16973892);
                        }
                        button.setTextColor(getResources().getColor(C1352R.color.holo_blue_dark));
                    }
                } catch (Exception e) {
                }
            }
            return;
        }
        this.f5249ar.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f5240ai.mo8618b();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5243al = findViewById(C1352R.C1354id.itemContainer);
        this.f5246ao = (TextView) findViewById(16908308);
        this.f5247ap = (TextView) findViewById(16908309);
        this.f5245an = (Button) findViewById(C1352R.C1354id.subFormButton);
        this.f5248aq = (TextView) findViewById(C1352R.C1354id.reguired_hint);
        this.f5244am = (Button) findViewById(C1352R.C1354id.remark_text);
        this.f5242ak = findViewById(C1352R.C1354id.options_divider_bottom);
        this.f5249ar = findViewById(C1352R.C1354id.hyperlinksContainer);
        this.f5250as = (LinearLayout) findViewById(C1352R.C1354id.hyperlinksList);
        this.f5245an.setOnClickListener(this.f5251at);
        this.f5238ag = new C1260ik(this);
        this.f5240ai = new C1270im(this);
        this.f5241aj = new C1279in(this);
        this.f5239ah = new C1265il(this);
        m6206i();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5238ag.mo8595a(i, i2, i3, i4);
        this.f5239ah.mo8606a(i, i2, i3, i4);
    }

    public void setObserver(ItemViewObserver itemViewObserver) {
        this.f5237a = itemViewObserver;
    }

    /* renamed from: a */
    public void mo10059a(C1260ik ikVar) {
        if (this.f5237a != null) {
            this.f5237a.onDescriptiveImageClicked(this.f5252b);
        }
    }

    /* renamed from: a */
    public void mo10060a(Object obj) {
        if (this.f5237a != null) {
            InspectionItemConstants.ItemCursor onValueChanged = this.f5237a.onValueChanged(obj, this.f5252b);
            setValue(onValueChanged);
            this.f5255e = onValueChanged.isValid();
            m6206i();
        }
    }

    /* renamed from: a */
    public void mo10058a(long j) {
        if (this.f5237a != null) {
            this.f5237a.onProjectSelected(this.f5252b, j);
        }
    }

    /* renamed from: a */
    public void mo10057a() {
        if (this.f5237a != null) {
            this.f5237a.onMoreProjectsClicked(this.f5252b);
        }
    }

    /* renamed from: b */
    public void mo10064b() {
        if (this.f5237a != null) {
            this.f5237a.onInputButtonClicked(this.f5252b);
        }
    }

    /* renamed from: a */
    public void mo10062a(PictureKey pictureKey, int i) {
        if (this.f5237a != null) {
            this.f5237a.onPictureClicked(this.f5252b, pictureKey, i);
        }
    }

    /* renamed from: a */
    public void mo10061a(PictureKey pictureKey) {
        if (this.f5237a != null) {
            this.f5237a.onPictureDeleteClicked(this.f5252b, pictureKey);
        }
    }

    /* renamed from: c */
    public void mo10065c() {
        if (this.f5237a != null) {
            this.f5237a.onTakePictureClicked(this.f5252b);
        }
    }

    /* renamed from: d */
    public void mo10066d() {
        if (this.f5237a != null) {
            this.f5237a.onTakeDrawingClicked(this.f5252b);
        }
    }

    /* renamed from: e */
    public void mo10067e() {
        if (this.f5237a != null) {
            this.f5237a.onPicturePickerClicked(this.f5252b);
        }
    }

    /* renamed from: a */
    public void mo10063a(boolean z) {
        if (this.f5237a != null) {
            InspectionItemConstants.ItemCursor onInapplicableChanged = this.f5237a.onInapplicableChanged(this.f5252b, z);
            this.f5257g = onInapplicableChanged.isInapplicable();
            this.f5255e = onInapplicableChanged.isValid();
            m6206i();
        }
    }

    /* renamed from: f */
    public void mo10068f() {
        if (this.f5237a != null) {
            this.f5237a.onCustomLocationClicked(this.f5252b);
        }
    }

    /* renamed from: g */
    public void mo10069g() {
        if (this.f5237a != null) {
            this.f5237a.onRemarkClicked(this.f5252b);
        }
    }

    /* renamed from: h */
    public void mo10070h() {
        this.f5266p = !this.f5266p;
        this.f5241aj.mo8626a();
        if (this.f5237a != null) {
            this.f5237a.onMoreOptionsClicked(this.f5252b, this.f5266p);
        }
    }

    public void onTakeSignatureClicked() {
        if (this.f5237a != null) {
            this.f5237a.onTakeSignatureClicked(this.f5252b);
        }
    }
}
