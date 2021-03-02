package android.support.p004v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.p001v4.view.KeyEventCompat;
import android.support.p001v4.widget.CursorAdapter;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.SearchView */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: a */
    static final C0582a f2188a = new C0582a();

    /* renamed from: c */
    private static final boolean f2189c;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public CursorAdapter f2190A;

    /* renamed from: B */
    private boolean f2191B;

    /* renamed from: C */
    private CharSequence f2192C;

    /* renamed from: D */
    private boolean f2193D;

    /* renamed from: E */
    private boolean f2194E;

    /* renamed from: F */
    private int f2195F;

    /* renamed from: G */
    private boolean f2196G;

    /* renamed from: H */
    private CharSequence f2197H;

    /* renamed from: I */
    private CharSequence f2198I;

    /* renamed from: J */
    private boolean f2199J;

    /* renamed from: K */
    private int f2200K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public SearchableInfo f2201L;

    /* renamed from: M */
    private Bundle f2202M;

    /* renamed from: N */
    private final TintManager f2203N;

    /* renamed from: O */
    private Runnable f2204O;

    /* renamed from: P */
    private final Runnable f2205P;

    /* renamed from: Q */
    private Runnable f2206Q;

    /* renamed from: R */
    private final WeakHashMap<String, Drawable.ConstantState> f2207R;

    /* renamed from: S */
    private final View.OnClickListener f2208S;

    /* renamed from: T */
    private final TextView.OnEditorActionListener f2209T;

    /* renamed from: U */
    private final AdapterView.OnItemClickListener f2210U;

    /* renamed from: V */
    private final AdapterView.OnItemSelectedListener f2211V;

    /* renamed from: W */
    private TextWatcher f2212W;

    /* renamed from: b */
    View.OnKeyListener f2213b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final SearchAutoComplete f2214d;

    /* renamed from: e */
    private final View f2215e;

    /* renamed from: f */
    private final View f2216f;

    /* renamed from: g */
    private final View f2217g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ImageView f2218h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ImageView f2219i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final ImageView f2220j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final ImageView f2221k;

    /* renamed from: l */
    private final View f2222l;

    /* renamed from: m */
    private final ImageView f2223m;

    /* renamed from: n */
    private final Drawable f2224n;

    /* renamed from: o */
    private final int f2225o;

    /* renamed from: p */
    private final int f2226p;

    /* renamed from: q */
    private final Intent f2227q;

    /* renamed from: r */
    private final Intent f2228r;

    /* renamed from: s */
    private final CharSequence f2229s;

    /* renamed from: t */
    private OnQueryTextListener f2230t;

    /* renamed from: u */
    private OnCloseListener f2231u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View.OnFocusChangeListener f2232v;

    /* renamed from: w */
    private OnSuggestionListener f2233w;

    /* renamed from: x */
    private View.OnClickListener f2234x;

    /* renamed from: y */
    private boolean f2235y;

    /* renamed from: z */
    private boolean f2236z;

    /* renamed from: android.support.v7.widget.SearchView$OnCloseListener */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* renamed from: android.support.v7.widget.SearchView$OnQueryTextListener */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* renamed from: android.support.v7.widget.SearchView$OnSuggestionListener */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        f2189c = z;
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2204O = new Runnable() {
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    SearchView.f2188a.mo4484a(inputMethodManager, SearchView.this, 0);
                }
            }
        };
        this.f2205P = new Runnable() {
            public void run() {
                SearchView.this.m3293i();
            }
        };
        this.f2206Q = new Runnable() {
            public void run() {
                if (SearchView.this.f2190A != null && (SearchView.this.f2190A instanceof C1182gz)) {
                    SearchView.this.f2190A.changeCursor((Cursor) null);
                }
            }
        };
        this.f2207R = new WeakHashMap<>();
        this.f2208S = new View.OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.f2218h) {
                    SearchView.this.m3305o();
                } else if (view == SearchView.this.f2220j) {
                    SearchView.this.m3302n();
                } else if (view == SearchView.this.f2219i) {
                    SearchView.this.m3298l();
                } else if (view == SearchView.this.f2221k) {
                    SearchView.this.m3306p();
                } else if (view == SearchView.this.f2214d) {
                    SearchView.this.m3308r();
                }
            }
        };
        this.f2213b = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.f2201L == null) {
                    return false;
                }
                if (SearchView.this.f2214d.isPopupShowing() && SearchView.this.f2214d.getListSelection() != -1) {
                    return SearchView.this.m3269a(view, i, keyEvent);
                }
                if (SearchView.this.f2214d.m3311a() || !KeyEventCompat.hasNoModifiers(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.m3257a(0, (String) null, SearchView.this.f2214d.getText().toString());
                return true;
            }
        };
        this.f2209T = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.m3298l();
                return true;
            }
        };
        this.f2210U = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean unused = SearchView.this.m3264a(i, 0, (String) null);
            }
        };
        this.f2211V = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                boolean unused = SearchView.this.m3280c(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f2212W = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.m3278c(charSequence);
            }

            public void afterTextChanged(Editable editable) {
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0505R.styleable.SearchView, i, 0);
        this.f2203N = obtainStyledAttributes.getTintManager();
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(C0505R.styleable.SearchView_layout, C0505R.layout.abc_search_view), this, true);
        this.f2214d = (SearchAutoComplete) findViewById(C0505R.C0507id.search_src_text);
        this.f2214d.setSearchView(this);
        this.f2215e = findViewById(C0505R.C0507id.search_edit_frame);
        this.f2216f = findViewById(C0505R.C0507id.search_plate);
        this.f2217g = findViewById(C0505R.C0507id.submit_area);
        this.f2218h = (ImageView) findViewById(C0505R.C0507id.search_button);
        this.f2219i = (ImageView) findViewById(C0505R.C0507id.search_go_btn);
        this.f2220j = (ImageView) findViewById(C0505R.C0507id.search_close_btn);
        this.f2221k = (ImageView) findViewById(C0505R.C0507id.search_voice_btn);
        this.f2223m = (ImageView) findViewById(C0505R.C0507id.search_mag_icon);
        this.f2216f.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_queryBackground));
        this.f2217g.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_submitBackground));
        this.f2218h.setImageDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_searchIcon));
        this.f2219i.setImageDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_goIcon));
        this.f2220j.setImageDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_closeIcon));
        this.f2221k.setImageDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_voiceIcon));
        this.f2223m.setImageDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_searchIcon));
        this.f2224n = obtainStyledAttributes.getDrawable(C0505R.styleable.SearchView_searchHintIcon);
        this.f2225o = obtainStyledAttributes.getResourceId(C0505R.styleable.SearchView_suggestionRowLayout, C0505R.layout.abc_search_dropdown_item_icons_2line);
        this.f2226p = obtainStyledAttributes.getResourceId(C0505R.styleable.SearchView_commitIcon, 0);
        this.f2218h.setOnClickListener(this.f2208S);
        this.f2220j.setOnClickListener(this.f2208S);
        this.f2219i.setOnClickListener(this.f2208S);
        this.f2221k.setOnClickListener(this.f2208S);
        this.f2214d.setOnClickListener(this.f2208S);
        this.f2214d.addTextChangedListener(this.f2212W);
        this.f2214d.setOnEditorActionListener(this.f2209T);
        this.f2214d.setOnItemClickListener(this.f2210U);
        this.f2214d.setOnItemSelectedListener(this.f2211V);
        this.f2214d.setOnKeyListener(this.f2213b);
        this.f2214d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f2232v != null) {
                    SearchView.this.f2232v.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(C0505R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f2229s = obtainStyledAttributes.getText(C0505R.styleable.SearchView_defaultQueryHint);
        this.f2192C = obtainStyledAttributes.getText(C0505R.styleable.SearchView_queryHint);
        int i2 = obtainStyledAttributes.getInt(C0505R.styleable.SearchView_android_imeOptions, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i3 = obtainStyledAttributes.getInt(C0505R.styleable.SearchView_android_inputType, -1);
        if (i3 != -1) {
            setInputType(i3);
        }
        setFocusable(obtainStyledAttributes.getBoolean(C0505R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        this.f2227q = new Intent("android.speech.action.WEB_SEARCH");
        this.f2227q.addFlags(268435456);
        this.f2227q.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f2228r = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f2228r.addFlags(268435456);
        this.f2222l = findViewById(this.f2214d.getDropDownAnchor());
        if (this.f2222l != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                m3273b();
            } else {
                m3277c();
            }
        }
        m3263a(this.f2235y);
        m3294j();
    }

    @TargetApi(11)
    /* renamed from: b */
    private void m3273b() {
        this.f2222l.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SearchView.this.m3307q();
            }
        });
    }

    /* renamed from: c */
    private void m3277c() {
        this.f2222l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                SearchView.this.m3307q();
            }
        });
    }

    public int getSuggestionRowLayout() {
        return this.f2225o;
    }

    public int getSuggestionCommitIconResId() {
        return this.f2226p;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2201L = searchableInfo;
        if (this.f2201L != null) {
            if (f2189c) {
                m3297k();
            }
            m3294j();
        }
        this.f2196G = f2189c && m3283d();
        if (this.f2196G) {
            this.f2214d.setPrivateImeOptions("nm");
        }
        m3263a(isIconified());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2202M = bundle;
    }

    public void setImeOptions(int i) {
        this.f2214d.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f2214d.getImeOptions();
    }

    public void setInputType(int i) {
        this.f2214d.setInputType(i);
    }

    public int getInputType() {
        return this.f2214d.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f2194E || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f2214d.requestFocus(i, rect);
        if (requestFocus) {
            m3263a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f2194E = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f2214d.clearFocus();
        this.f2194E = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.f2230t = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f2231u = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f2232v = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.f2233w = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2234x = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f2214d.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.f2214d.setText(charSequence);
        if (charSequence != null) {
            this.f2214d.setSelection(this.f2214d.length());
            this.f2198I = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m3298l();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2192C = charSequence;
        m3294j();
    }

    public CharSequence getQueryHint() {
        if (this.f2192C != null) {
            return this.f2192C;
        }
        if (!f2189c || this.f2201L == null || this.f2201L.getHintId() == 0) {
            return this.f2229s;
        }
        return getContext().getText(this.f2201L.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f2235y != z) {
            this.f2235y = z;
            m3263a(z);
            m3294j();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.f2235y;
    }

    public void setIconified(boolean z) {
        if (z) {
            m3302n();
        } else {
            m3305o();
        }
    }

    public boolean isIconified() {
        return this.f2236z;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f2191B = z;
        m3263a(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.f2191B;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f2193D = z;
        if (this.f2190A instanceof C1182gz) {
            ((C1182gz) this.f2190A).mo8260a(z ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.f2193D;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f2190A = cursorAdapter;
        this.f2214d.setAdapter(this.f2190A);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f2190A;
    }

    public void setMaxWidth(int i) {
        this.f2195F = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f2195F;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case ExploreByTouchHelper.INVALID_ID:
                if (this.f2195F <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f2195F, size);
                    break;
                }
            case 0:
                if (this.f2195F <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f2195F;
                    break;
                }
            case 1073741824:
                if (this.f2195F > 0) {
                    size = Math.min(this.f2195F, size);
                    break;
                }
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0505R.dimen.abc_search_view_preferred_width);
    }

    /* renamed from: a */
    private void m3263a(boolean z) {
        boolean z2;
        int i;
        boolean z3 = true;
        int i2 = 8;
        this.f2236z = z;
        int i3 = z ? 0 : 8;
        if (!TextUtils.isEmpty(this.f2214d.getText())) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f2218h.setVisibility(i3);
        m3274b(z2);
        View view = this.f2215e;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        if (this.f2223m.getDrawable() != null && !this.f2235y) {
            i2 = 0;
        }
        this.f2223m.setVisibility(i2);
        m3289g();
        if (z2) {
            z3 = false;
        }
        m3279c(z3);
        m3286f();
    }

    @TargetApi(8)
    /* renamed from: d */
    private boolean m3283d() {
        if (this.f2201L == null || !this.f2201L.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f2201L.getVoiceSearchLaunchWebSearch()) {
            intent = this.f2227q;
        } else if (this.f2201L.getVoiceSearchLaunchRecognizer()) {
            intent = this.f2228r;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    private boolean m3285e() {
        return (this.f2191B || this.f2196G) && !isIconified();
    }

    /* renamed from: b */
    private void m3274b(boolean z) {
        int i = 8;
        if (this.f2191B && m3285e() && hasFocus() && (z || !this.f2196G)) {
            i = 0;
        }
        this.f2219i.setVisibility(i);
    }

    /* renamed from: f */
    private void m3286f() {
        int i = 8;
        if (m3285e() && (this.f2219i.getVisibility() == 0 || this.f2221k.getVisibility() == 0)) {
            i = 0;
        }
        this.f2217g.setVisibility(i);
    }

    /* renamed from: g */
    private void m3289g() {
        boolean z = true;
        int i = 0;
        boolean z2 = !TextUtils.isEmpty(this.f2214d.getText());
        if (!z2 && (!this.f2235y || this.f2199J)) {
            z = false;
        }
        ImageView imageView = this.f2220j;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f2220j.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: h */
    private void m3290h() {
        post(this.f2205P);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m3293i() {
        int[] iArr = this.f2214d.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f2216f.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2217g.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f2205P);
        post(this.f2206Q);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void setImeVisibility(boolean z) {
        if (z) {
            post(this.f2204O);
            return;
        }
        removeCallbacks(this.f2204O);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* renamed from: a */
    public void mo4422a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3269a(View view, int i, KeyEvent keyEvent) {
        int length;
        if (this.f2201L == null || this.f2190A == null || keyEvent.getAction() != 0 || !KeyEventCompat.hasNoModifiers(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return m3264a(this.f2214d.getListSelection(), 0, (String) null);
        }
        if (i == 21 || i == 22) {
            if (i == 21) {
                length = 0;
            } else {
                length = this.f2214d.length();
            }
            this.f2214d.setSelection(length);
            this.f2214d.setListSelection(0);
            this.f2214d.clearListSelection();
            f2188a.mo4486a(this.f2214d, true);
            return true;
        }
        if (!(i == 19 && this.f2214d.getListSelection() == 0)) {
        }
        return false;
    }

    /* renamed from: b */
    private CharSequence m3272b(CharSequence charSequence) {
        if (!this.f2235y || this.f2224n == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f2214d.getTextSize()) * 1.25d);
        this.f2224n.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f2224n), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: j */
    private void m3294j() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2214d;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m3272b(queryHint));
    }

    @TargetApi(8)
    /* renamed from: k */
    private void m3297k() {
        int i = 1;
        this.f2214d.setThreshold(this.f2201L.getSuggestThreshold());
        this.f2214d.setImeOptions(this.f2201L.getImeOptions());
        int inputType = this.f2201L.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2201L.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f2214d.setInputType(inputType);
        if (this.f2190A != null) {
            this.f2190A.changeCursor((Cursor) null);
        }
        if (this.f2201L.getSuggestAuthority() != null) {
            this.f2190A = new C1182gz(getContext(), this, this.f2201L, this.f2207R);
            this.f2214d.setAdapter(this.f2190A);
            C1182gz gzVar = (C1182gz) this.f2190A;
            if (this.f2193D) {
                i = 2;
            }
            gzVar.mo8260a(i);
        }
    }

    /* renamed from: c */
    private void m3279c(boolean z) {
        int i;
        if (!this.f2196G || isIconified() || !z) {
            i = 8;
        } else {
            i = 0;
            this.f2219i.setVisibility(8);
        }
        this.f2221k.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3278c(CharSequence charSequence) {
        boolean z = true;
        Editable text = this.f2214d.getText();
        this.f2198I = text;
        boolean z2 = !TextUtils.isEmpty(text);
        m3274b(z2);
        if (z2) {
            z = false;
        }
        m3279c(z);
        m3289g();
        m3286f();
        if (this.f2230t != null && !TextUtils.equals(charSequence, this.f2197H)) {
            this.f2230t.onQueryTextChange(charSequence.toString());
        }
        this.f2197H = charSequence.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m3298l() {
        Editable text = this.f2214d.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f2230t == null || !this.f2230t.onQueryTextSubmit(text.toString())) {
                if (this.f2201L != null) {
                    m3257a(0, (String) null, text.toString());
                }
                setImeVisibility(false);
                m3301m();
            }
        }
    }

    /* renamed from: m */
    private void m3301m() {
        this.f2214d.dismissDropDown();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m3302n() {
        if (!TextUtils.isEmpty(this.f2214d.getText())) {
            this.f2214d.setText("");
            this.f2214d.requestFocus();
            setImeVisibility(true);
        } else if (!this.f2235y) {
        } else {
            if (this.f2231u == null || !this.f2231u.onClose()) {
                clearFocus();
                m3263a(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m3305o() {
        m3263a(false);
        this.f2214d.requestFocus();
        setImeVisibility(true);
        if (this.f2234x != null) {
            this.f2234x.onClick(this);
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(8)
    /* renamed from: p */
    public void m3306p() {
        if (this.f2201L != null) {
            SearchableInfo searchableInfo = this.f2201L;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m3254a(this.f2227q, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m3270b(this.f2228r, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4421a() {
        m3263a(isIconified());
        m3290h();
        if (this.f2214d.hasFocus()) {
            m3308r();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3290h();
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        m3263a(true);
        this.f2214d.setImeOptions(this.f2200K);
        this.f2199J = false;
    }

    public void onActionViewExpanded() {
        if (!this.f2199J) {
            this.f2199J = true;
            this.f2200K = this.f2214d.getImeOptions();
            this.f2214d.setImeOptions(this.f2200K | 33554432);
            this.f2214d.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m3307q() {
        int i;
        int i2;
        if (this.f2222l.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f2216f.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (this.f2235y) {
                i = resources.getDimensionPixelSize(C0505R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(C0505R.dimen.abc_dropdownitem_icon_width);
            } else {
                i = 0;
            }
            this.f2214d.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + i);
            }
            this.f2214d.setDropDownHorizontalOffset(i2);
            this.f2214d.setDropDownWidth((i + ((this.f2222l.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3264a(int i, int i2, String str) {
        if (this.f2233w != null && this.f2233w.onSuggestionClick(i)) {
            return false;
        }
        m3275b(i, 0, (String) null);
        setImeVisibility(false);
        m3301m();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m3280c(int i) {
        if (this.f2233w != null && this.f2233w.onSuggestionSelect(i)) {
            return false;
        }
        m3281d(i);
        return true;
    }

    /* renamed from: d */
    private void m3281d(int i) {
        Editable text = this.f2214d.getText();
        Cursor cursor = this.f2190A.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.f2190A.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    /* renamed from: b */
    private boolean m3275b(int i, int i2, String str) {
        Cursor cursor = this.f2190A.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        m3258a(m3255a(cursor, i2, str));
        return true;
    }

    /* renamed from: a */
    private void m3258a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f2214d.setText(charSequence);
        this.f2214d.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3257a(int i, String str, String str2) {
        getContext().startActivity(m3256a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* renamed from: a */
    private Intent m3256a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2198I);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f2202M != null) {
            intent.putExtra("app_data", this.f2202M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f2189c) {
            intent.setComponent(this.f2201L.getSearchActivity());
        }
        return intent;
    }

    @TargetApi(8)
    /* renamed from: a */
    private Intent m3254a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    @TargetApi(8)
    /* renamed from: b */
    private Intent m3270b(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i;
        String str4 = null;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.f2202M != null) {
            bundle.putParcelable("app_data", this.f2202M);
        }
        Intent intent3 = new Intent(intent);
        String str5 = "free_form";
        if (Build.VERSION.SDK_INT >= 8) {
            Resources resources = getResources();
            if (searchableInfo.getVoiceLanguageModeId() != 0) {
                str5 = resources.getString(searchableInfo.getVoiceLanguageModeId());
            }
            if (searchableInfo.getVoicePromptTextId() != 0) {
                str2 = resources.getString(searchableInfo.getVoicePromptTextId());
            } else {
                str2 = null;
            }
            if (searchableInfo.getVoiceLanguageId() != 0) {
                str = resources.getString(searchableInfo.getVoiceLanguageId());
            } else {
                str = null;
            }
            if (searchableInfo.getVoiceMaxResults() != 0) {
                str3 = str5;
                i = searchableInfo.getVoiceMaxResults();
            } else {
                str3 = str5;
                i = 1;
            }
        } else {
            str = null;
            str2 = null;
            str3 = str5;
            i = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str3);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: a */
    private Intent m3255a(Cursor cursor, int i, String str) {
        int i2;
        String a;
        try {
            String a2 = C1182gz.m5238a(cursor, "suggest_intent_action");
            if (a2 == null && Build.VERSION.SDK_INT >= 8) {
                a2 = this.f2201L.getSuggestIntentAction();
            }
            if (a2 == null) {
                a2 = "android.intent.action.SEARCH";
            }
            String a3 = C1182gz.m5238a(cursor, "suggest_intent_data");
            if (f2189c && a3 == null) {
                a3 = this.f2201L.getSuggestIntentData();
            }
            if (!(a3 == null || (a = C1182gz.m5238a(cursor, "suggest_intent_data_id")) == null)) {
                a3 = a3 + "/" + Uri.encode(a);
            }
            return m3256a(a2, a3 == null ? null : Uri.parse(a3), C1182gz.m5238a(cursor, "suggest_intent_extra_data"), C1182gz.m5238a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException e2) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", runtimeException);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m3308r() {
        f2188a.mo4485a(this.f2214d);
        f2188a.mo4487b(this.f2214d);
    }

    /* renamed from: a */
    static boolean m3265a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a */
        private int f2249a;

        /* renamed from: b */
        private SearchView f2250b;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0505R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2249a = getThreshold();
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f2250b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f2249a = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m3311a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f2250b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m3265a(getContext())) {
                    SearchView.f2188a.mo4486a(this, true);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f2250b.mo4421a();
        }

        public boolean enoughToFilter() {
            return this.f2249a <= 0 || super.enoughToFilter();
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
                        this.f2250b.clearFocus();
                        this.f2250b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$a */
    static class C0582a {

        /* renamed from: a */
        private Method f2251a;

        /* renamed from: b */
        private Method f2252b;

        /* renamed from: c */
        private Method f2253c;

        /* renamed from: d */
        private Method f2254d;

        C0582a() {
            try {
                this.f2251a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2251a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f2252b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2252b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                this.f2253c = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f2253c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            Class<InputMethodManager> cls2 = InputMethodManager.class;
            try {
                this.f2254d = cls2.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f2254d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4485a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f2251a != null) {
                try {
                    this.f2251a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo4487b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f2252b != null) {
                try {
                    this.f2252b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4486a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f2253c != null) {
                try {
                    this.f2253c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4484a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.f2254d != null) {
                try {
                    this.f2254d.invoke(inputMethodManager, new Object[]{Integer.valueOf(i), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }
    }
}
