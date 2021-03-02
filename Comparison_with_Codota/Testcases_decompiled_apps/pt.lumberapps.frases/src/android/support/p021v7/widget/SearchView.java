package android.support.p021v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p009v4.app.NotificationCompat;
import android.support.p009v4.p010a.p011a.C0026a;
import android.support.p009v4.widget.C0412m;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0509e;
import android.support.p021v7.view.C0523d;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.google.android.gms.actions.SearchIntents;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.SearchView */
public class SearchView extends C0634ce implements C0523d {

    /* renamed from: a */
    static final C0658db f1257a = new C0658db();

    /* renamed from: b */
    private static final boolean f1258b = (Build.VERSION.SDK_INT >= 8);

    /* renamed from: A */
    private boolean f1259A;

    /* renamed from: B */
    private boolean f1260B;

    /* renamed from: C */
    private int f1261C;

    /* renamed from: D */
    private boolean f1262D;

    /* renamed from: E */
    private CharSequence f1263E;

    /* renamed from: F */
    private boolean f1264F;

    /* renamed from: G */
    private int f1265G;

    /* renamed from: H */
    private SearchableInfo f1266H;

    /* renamed from: I */
    private Bundle f1267I;

    /* renamed from: J */
    private Runnable f1268J;

    /* renamed from: K */
    private final Runnable f1269K;

    /* renamed from: L */
    private Runnable f1270L;

    /* renamed from: M */
    private final WeakHashMap f1271M;

    /* renamed from: c */
    private final SearchAutoComplete f1272c;

    /* renamed from: d */
    private final View f1273d;

    /* renamed from: e */
    private final View f1274e;

    /* renamed from: f */
    private final ImageView f1275f;

    /* renamed from: g */
    private final ImageView f1276g;

    /* renamed from: h */
    private final ImageView f1277h;

    /* renamed from: i */
    private final ImageView f1278i;

    /* renamed from: j */
    private final ImageView f1279j;

    /* renamed from: k */
    private final Drawable f1280k;

    /* renamed from: l */
    private final int f1281l;

    /* renamed from: m */
    private final int f1282m;

    /* renamed from: n */
    private final Intent f1283n;

    /* renamed from: o */
    private final Intent f1284o;

    /* renamed from: p */
    private final CharSequence f1285p;

    /* renamed from: q */
    private C0660dd f1286q;

    /* renamed from: r */
    private C0659dc f1287r;

    /* renamed from: s */
    private View.OnFocusChangeListener f1288s;

    /* renamed from: t */
    private C0661de f1289t;

    /* renamed from: u */
    private View.OnClickListener f1290u;

    /* renamed from: v */
    private boolean f1291v;

    /* renamed from: w */
    private boolean f1292w;

    /* renamed from: x */
    private C0412m f1293x;

    /* renamed from: y */
    private boolean f1294y;

    /* renamed from: z */
    private CharSequence f1295z;

    /* renamed from: android.support.v7.widget.SearchView$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C0662df();

        /* renamed from: a */
        boolean f1296a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1296a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1296a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1296a));
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete */
    public class SearchAutoComplete extends C0584ai {

        /* renamed from: a */
        private int f1297a;

        /* renamed from: b */
        private SearchView f1298b;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0506b.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1297a = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int b = C0026a.m124b(getResources());
            int a = C0026a.m123a(getResources());
            return (b < 960 || a < 720 || configuration.orientation != 2) ? (b >= 600 || (b >= 640 && a >= 480)) ? 192 : 160 : NotificationCompat.FLAG_LOCAL_ONLY;
        }

        public boolean enoughToFilter() {
            return this.f1297a <= 0 || super.enoughToFilter();
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1298b.mo2777d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1298b.clearFocus();
                        this.f1298b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1298b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m2619a(getContext())) {
                    SearchView.f1257a.mo3298a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1298b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1297a = i;
        }
    }

    /* renamed from: a */
    private Intent m2615a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1263E);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1267I != null) {
            intent.putExtra("app_data", this.f1267I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1258b) {
            intent.setComponent(this.f1266H.getSearchActivity());
        }
        return intent;
    }

    /* renamed from: a */
    private void m2616a(int i, String str, String str2) {
        getContext().startActivity(m2615a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* renamed from: a */
    private void m2618a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f1292w = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1272c.getText());
        this.f1275f.setVisibility(i2);
        m2621b(z3);
        this.f1273d.setVisibility(z ? 8 : 0);
        if (this.f1279j.getDrawable() != null && !this.f1291v) {
            i = 0;
        }
        this.f1279j.setVisibility(i);
        m2626h();
        if (z3) {
            z2 = false;
        }
        m2622c(z2);
        m2625g();
    }

    /* renamed from: a */
    static boolean m2619a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: b */
    private CharSequence m2620b(CharSequence charSequence) {
        if (!this.f1291v || this.f1280k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1272c.getTextSize()) * 1.25d);
        this.f1280k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1280k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: b */
    private void m2621b(boolean z) {
        int i = 8;
        if (this.f1294y && m2624f() && hasFocus() && (z || !this.f1262D)) {
            i = 0;
        }
        this.f1276g.setVisibility(i);
    }

    /* renamed from: c */
    private void m2622c(boolean z) {
        int i;
        if (!this.f1262D || mo2775c() || !z) {
            i = 8;
        } else {
            i = 0;
            this.f1276g.setVisibility(8);
        }
        this.f1278i.setVisibility(i);
    }

    @TargetApi(8)
    /* renamed from: e */
    private boolean m2623e() {
        if (this.f1266H == null || !this.f1266H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1266H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1283n;
        } else if (this.f1266H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1284o;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* renamed from: f */
    private boolean m2624f() {
        return (this.f1294y || this.f1262D) && !mo2775c();
    }

    /* renamed from: g */
    private void m2625g() {
        int i = 8;
        if (m2624f() && (this.f1276g.getVisibility() == 0 || this.f1278i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1274e.setVisibility(i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0509e.abc_search_view_preferred_width);
    }

    /* renamed from: h */
    private void m2626h() {
        boolean z = true;
        int i = 0;
        boolean z2 = !TextUtils.isEmpty(this.f1272c.getText());
        if (!z2 && (!this.f1291v || this.f1264F)) {
            z = false;
        }
        ImageView imageView = this.f1277h;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f1277h.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: i */
    private void m2627i() {
        post(this.f1269K);
    }

    /* renamed from: k */
    private void m2628k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1272c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m2620b(queryHint));
    }

    @TargetApi(8)
    /* renamed from: l */
    private void m2629l() {
        int i = 1;
        this.f1272c.setThreshold(this.f1266H.getSuggestThreshold());
        this.f1272c.setImeOptions(this.f1266H.getImeOptions());
        int inputType = this.f1266H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1266H.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1272c.setInputType(inputType);
        if (this.f1293x != null) {
            this.f1293x.mo1879a((Cursor) null);
        }
        if (this.f1266H.getSuggestAuthority() != null) {
            this.f1293x = new C0663dg(getContext(), this, this.f1266H, this.f1271M);
            this.f1272c.setAdapter(this.f1293x);
            C0663dg dgVar = (C0663dg) this.f1293x;
            if (this.f1259A) {
                i = 2;
            }
            dgVar.mo3308a(i);
        }
    }

    /* renamed from: m */
    private void m2630m() {
        Editable text = this.f1272c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1286q == null || !this.f1286q.mo3301a(text.toString())) {
                if (this.f1266H != null) {
                    m2616a(0, (String) null, text.toString());
                }
                setImeVisibility(false);
                m2631n();
            }
        }
    }

    /* renamed from: n */
    private void m2631n() {
        this.f1272c.dismissDropDown();
    }

    /* renamed from: o */
    private void m2632o() {
        if (!TextUtils.isEmpty(this.f1272c.getText())) {
            this.f1272c.setText("");
            this.f1272c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1291v) {
        } else {
            if (this.f1287r == null || !this.f1287r.mo3300a()) {
                clearFocus();
                m2618a(true);
            }
        }
    }

    /* renamed from: p */
    private void m2633p() {
        m2618a(false);
        this.f1272c.requestFocus();
        setImeVisibility(true);
        if (this.f1290u != null) {
            this.f1290u.onClick(this);
        }
    }

    /* renamed from: q */
    private void m2634q() {
        f1257a.mo3297a(this.f1272c);
        f1257a.mo3299b(this.f1272c);
    }

    /* access modifiers changed from: private */
    public void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1268J);
            return;
        }
        removeCallbacks(this.f1268J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1272c.setText(charSequence);
        this.f1272c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: a */
    public void mo2197a() {
        if (!this.f1264F) {
            this.f1264F = true;
            this.f1265G = this.f1272c.getImeOptions();
            this.f1272c.setImeOptions(this.f1265G | 33554432);
            this.f1272c.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2773a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: a */
    public void mo2774a(CharSequence charSequence, boolean z) {
        this.f1272c.setText(charSequence);
        if (charSequence != null) {
            this.f1272c.setSelection(this.f1272c.length());
            this.f1263E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m2630m();
        }
    }

    /* renamed from: b */
    public void mo2198b() {
        mo2774a((CharSequence) "", false);
        clearFocus();
        m2618a(true);
        this.f1272c.setImeOptions(this.f1265G);
        this.f1264F = false;
    }

    /* renamed from: c */
    public boolean mo2775c() {
        return this.f1292w;
    }

    public void clearFocus() {
        this.f1260B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1272c.clearFocus();
        this.f1260B = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2777d() {
        m2618a(mo2775c());
        m2627i();
        if (this.f1272c.hasFocus()) {
            m2634q();
        }
    }

    public int getImeOptions() {
        return this.f1272c.getImeOptions();
    }

    public int getInputType() {
        return this.f1272c.getInputType();
    }

    public int getMaxWidth() {
        return this.f1261C;
    }

    public CharSequence getQuery() {
        return this.f1272c.getText();
    }

    public CharSequence getQueryHint() {
        return this.f1295z != null ? this.f1295z : (!f1258b || this.f1266H == null || this.f1266H.getHintId() == 0) ? this.f1285p : getContext().getText(this.f1266H.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.f1282m;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.f1281l;
    }

    public C0412m getSuggestionsAdapter() {
        return this.f1293x;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1269K);
        post(this.f1270L);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (mo2775c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1261C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1261C, size);
                    break;
                }
            case 0:
                if (this.f1261C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1261C;
                    break;
                }
            case 1073741824:
                if (this.f1261C > 0) {
                    size = Math.min(this.f1261C, size);
                    break;
                }
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m2618a(savedState.f1296a);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1296a = mo2775c();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m2627i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1260B || !isFocusable()) {
            return false;
        }
        if (mo2775c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1272c.requestFocus(i, rect);
        if (requestFocus) {
            m2618a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1267I = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m2632o();
        } else {
            m2633p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1291v != z) {
            this.f1291v = z;
            m2618a(z);
            m2628k();
        }
    }

    public void setImeOptions(int i) {
        this.f1272c.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1272c.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1261C = i;
        requestLayout();
    }

    public void setOnCloseListener(C0659dc dcVar) {
        this.f1287r = dcVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1288s = onFocusChangeListener;
    }

    public void setOnQueryTextListener(C0660dd ddVar) {
        this.f1286q = ddVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1290u = onClickListener;
    }

    public void setOnSuggestionListener(C0661de deVar) {
        this.f1289t = deVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1295z = charSequence;
        m2628k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1259A = z;
        if (this.f1293x instanceof C0663dg) {
            ((C0663dg) this.f1293x).mo3308a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1266H = searchableInfo;
        if (this.f1266H != null) {
            if (f1258b) {
                m2629l();
            }
            m2628k();
        }
        this.f1262D = f1258b && m2623e();
        if (this.f1262D) {
            this.f1272c.setPrivateImeOptions("nm");
        }
        m2618a(mo2775c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1294y = z;
        m2618a(mo2775c());
    }

    public void setSuggestionsAdapter(C0412m mVar) {
        this.f1293x = mVar;
        this.f1272c.setAdapter(this.f1293x);
    }
}
