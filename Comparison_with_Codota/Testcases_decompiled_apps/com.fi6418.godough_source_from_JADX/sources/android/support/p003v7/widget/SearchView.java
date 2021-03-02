package android.support.p003v7.widget;

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
import android.support.p000v4.view.KeyEventCompat;
import android.support.p000v4.widget.CursorAdapter;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.view.CollapsibleActionView;
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
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.SearchView */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: a */
    static final AutoCompleteTextViewReflector f3055a = new AutoCompleteTextViewReflector();

    /* renamed from: c */
    private static final boolean f3056c = (Build.VERSION.SDK_INT >= 8);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public CursorAdapter f3057A;

    /* renamed from: B */
    private boolean f3058B;

    /* renamed from: C */
    private CharSequence f3059C;

    /* renamed from: D */
    private boolean f3060D;

    /* renamed from: E */
    private boolean f3061E;

    /* renamed from: F */
    private int f3062F;

    /* renamed from: G */
    private boolean f3063G;

    /* renamed from: H */
    private CharSequence f3064H;

    /* renamed from: I */
    private CharSequence f3065I;

    /* renamed from: J */
    private boolean f3066J;

    /* renamed from: K */
    private int f3067K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public SearchableInfo f3068L;

    /* renamed from: M */
    private Bundle f3069M;

    /* renamed from: N */
    private final TintManager f3070N;

    /* renamed from: O */
    private Runnable f3071O;

    /* renamed from: P */
    private final Runnable f3072P;

    /* renamed from: Q */
    private Runnable f3073Q;

    /* renamed from: R */
    private final WeakHashMap<String, Drawable.ConstantState> f3074R;

    /* renamed from: S */
    private final View.OnClickListener f3075S;

    /* renamed from: T */
    private final TextView.OnEditorActionListener f3076T;

    /* renamed from: U */
    private final AdapterView.OnItemClickListener f3077U;

    /* renamed from: V */
    private final AdapterView.OnItemSelectedListener f3078V;

    /* renamed from: W */
    private TextWatcher f3079W;

    /* renamed from: b */
    View.OnKeyListener f3080b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final SearchAutoComplete f3081d;

    /* renamed from: e */
    private final View f3082e;

    /* renamed from: f */
    private final View f3083f;

    /* renamed from: g */
    private final View f3084g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ImageView f3085h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ImageView f3086i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final ImageView f3087j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final ImageView f3088k;

    /* renamed from: l */
    private final View f3089l;

    /* renamed from: m */
    private final ImageView f3090m;

    /* renamed from: n */
    private final Drawable f3091n;

    /* renamed from: o */
    private final int f3092o;

    /* renamed from: p */
    private final int f3093p;

    /* renamed from: q */
    private final Intent f3094q;

    /* renamed from: r */
    private final Intent f3095r;

    /* renamed from: s */
    private final CharSequence f3096s;

    /* renamed from: t */
    private OnQueryTextListener f3097t;

    /* renamed from: u */
    private OnCloseListener f3098u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View.OnFocusChangeListener f3099v;

    /* renamed from: w */
    private OnSuggestionListener f3100w;

    /* renamed from: x */
    private View.OnClickListener f3101x;

    /* renamed from: y */
    private boolean f3102y;

    /* renamed from: z */
    private boolean f3103z;

    /* renamed from: android.support.v7.widget.SearchView$AutoCompleteTextViewReflector */
    class AutoCompleteTextViewReflector {

        /* renamed from: a */
        private Method f3116a;

        /* renamed from: b */
        private Method f3117b;

        /* renamed from: c */
        private Method f3118c;

        /* renamed from: d */
        private Method f3119d;

        AutoCompleteTextViewReflector() {
            try {
                this.f3116a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f3116a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f3117b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f3117b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                this.f3118c = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f3118c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            Class<InputMethodManager> cls2 = InputMethodManager.class;
            try {
                this.f3119d = cls2.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f3119d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5993a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.f3119d != null) {
                try {
                    this.f3119d.invoke(inputMethodManager, new Object[]{Integer.valueOf(i), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5994a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f3116a != null) {
                try {
                    this.f3116a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5995a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f3118c != null) {
                try {
                    this.f3118c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5996b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f3117b != null) {
                try {
                    this.f3117b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

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

    /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete */
    public class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a */
        private int f3120a;

        /* renamed from: b */
        private SearchView f3121b;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0235R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f3120a = getThreshold();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m2247a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public boolean enoughToFilter() {
            return this.f3120a <= 0 || super.enoughToFilter();
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f3121b.mo5943a();
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
                        this.f3121b.clearFocus();
                        this.f3121b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f3121b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m2198a(getContext())) {
                    SearchView.f3055a.mo5995a(this, true);
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
            this.f3121b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f3120a = i;
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3071O = new Runnable() {
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    SearchView.f3055a.mo5993a(inputMethodManager, SearchView.this, 0);
                }
            }
        };
        this.f3072P = new Runnable() {
            public void run() {
                SearchView.this.m2225j();
            }
        };
        this.f3073Q = new Runnable() {
            public void run() {
                if (SearchView.this.f3057A != null && (SearchView.this.f3057A instanceof SuggestionsAdapter)) {
                    SearchView.this.f3057A.changeCursor((Cursor) null);
                }
            }
        };
        this.f3074R = new WeakHashMap<>();
        this.f3075S = new View.OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.f3085h) {
                    SearchView.this.m2237p();
                } else if (view == SearchView.this.f3087j) {
                    SearchView.this.m2236o();
                } else if (view == SearchView.this.f3086i) {
                    SearchView.this.m2232m();
                } else if (view == SearchView.this.f3088k) {
                    SearchView.this.m2238q();
                } else if (view == SearchView.this.f3081d) {
                    SearchView.this.m2240s();
                }
            }
        };
        this.f3080b = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.f3068L == null) {
                    return false;
                }
                if (SearchView.this.f3081d.isPopupShowing() && SearchView.this.f3081d.getListSelection() != -1) {
                    return SearchView.this.m2202a(view, i, keyEvent);
                }
                if (SearchView.this.f3081d.m2247a() || !KeyEventCompat.hasNoModifiers(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.m2189a(0, (String) null, SearchView.this.f3081d.getText().toString());
                return true;
            }
        };
        this.f3076T = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.m2232m();
                return true;
            }
        };
        this.f3077U = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean unused = SearchView.this.m2197a(i, 0, (String) null);
            }
        };
        this.f3078V = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                boolean unused = SearchView.this.m2196a(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f3079W = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.m2210c(charSequence);
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0235R.styleable.SearchView, i, 0);
        this.f3070N = obtainStyledAttributes.getTintManager();
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(C0235R.styleable.SearchView_layout, C0235R.layout.abc_search_view), this, true);
        this.f3081d = (SearchAutoComplete) findViewById(C0235R.C0237id.search_src_text);
        this.f3081d.setSearchView(this);
        this.f3082e = findViewById(C0235R.C0237id.search_edit_frame);
        this.f3083f = findViewById(C0235R.C0237id.search_plate);
        this.f3084g = findViewById(C0235R.C0237id.submit_area);
        this.f3085h = (ImageView) findViewById(C0235R.C0237id.search_button);
        this.f3086i = (ImageView) findViewById(C0235R.C0237id.search_go_btn);
        this.f3087j = (ImageView) findViewById(C0235R.C0237id.search_close_btn);
        this.f3088k = (ImageView) findViewById(C0235R.C0237id.search_voice_btn);
        this.f3090m = (ImageView) findViewById(C0235R.C0237id.search_mag_icon);
        this.f3083f.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_queryBackground));
        this.f3084g.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_submitBackground));
        this.f3085h.setImageDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_searchIcon));
        this.f3086i.setImageDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_goIcon));
        this.f3087j.setImageDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_closeIcon));
        this.f3088k.setImageDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_voiceIcon));
        this.f3090m.setImageDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_searchIcon));
        this.f3091n = obtainStyledAttributes.getDrawable(C0235R.styleable.SearchView_searchHintIcon);
        this.f3092o = obtainStyledAttributes.getResourceId(C0235R.styleable.SearchView_suggestionRowLayout, C0235R.layout.abc_search_dropdown_item_icons_2line);
        this.f3093p = obtainStyledAttributes.getResourceId(C0235R.styleable.SearchView_commitIcon, 0);
        this.f3085h.setOnClickListener(this.f3075S);
        this.f3087j.setOnClickListener(this.f3075S);
        this.f3086i.setOnClickListener(this.f3075S);
        this.f3088k.setOnClickListener(this.f3075S);
        this.f3081d.setOnClickListener(this.f3075S);
        this.f3081d.addTextChangedListener(this.f3079W);
        this.f3081d.setOnEditorActionListener(this.f3076T);
        this.f3081d.setOnItemClickListener(this.f3077U);
        this.f3081d.setOnItemSelectedListener(this.f3078V);
        this.f3081d.setOnKeyListener(this.f3080b);
        this.f3081d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f3099v != null) {
                    SearchView.this.f3099v.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(C0235R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f3096s = obtainStyledAttributes.getText(C0235R.styleable.SearchView_defaultQueryHint);
        this.f3059C = obtainStyledAttributes.getText(C0235R.styleable.SearchView_queryHint);
        int i2 = obtainStyledAttributes.getInt(C0235R.styleable.SearchView_android_imeOptions, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i3 = obtainStyledAttributes.getInt(C0235R.styleable.SearchView_android_inputType, -1);
        if (i3 != -1) {
            setInputType(i3);
        }
        setFocusable(obtainStyledAttributes.getBoolean(C0235R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        this.f3094q = new Intent("android.speech.action.WEB_SEARCH");
        this.f3094q.addFlags(268435456);
        this.f3094q.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f3095r = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f3095r.addFlags(268435456);
        this.f3089l = findViewById(this.f3081d.getDropDownAnchor());
        if (this.f3089l != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                m2209c();
            } else {
                m2212d();
            }
        }
        m2195a(this.f3102y);
        m2228k();
    }

    @TargetApi(8)
    /* renamed from: a */
    private Intent m2186a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: a */
    private Intent m2187a(Cursor cursor, int i, String str) {
        int i2;
        String columnString;
        try {
            String columnString2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
            if (columnString2 == null && Build.VERSION.SDK_INT >= 8) {
                columnString2 = this.f3068L.getSuggestIntentAction();
            }
            if (columnString2 == null) {
                columnString2 = "android.intent.action.SEARCH";
            }
            String columnString3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
            if (f3056c && columnString3 == null) {
                columnString3 = this.f3068L.getSuggestIntentData();
            }
            if (!(columnString3 == null || (columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id")) == null)) {
                columnString3 = columnString3 + "/" + Uri.encode(columnString);
            }
            return m2188a(columnString2, columnString3 == null ? null : Uri.parse(columnString3), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), i, str);
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

    /* renamed from: a */
    private Intent m2188a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f3065I);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f3069M != null) {
            intent.putExtra("app_data", this.f3069M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f3056c) {
            intent.setComponent(this.f3068L.getSearchActivity());
        }
        return intent;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2189a(int i, String str, String str2) {
        getContext().startActivity(m2188a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* renamed from: a */
    private void m2190a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    /* renamed from: a */
    private void m2195a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f3103z = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f3081d.getText());
        this.f3085h.setVisibility(i2);
        m2206b(z3);
        this.f3082e.setVisibility(z ? 8 : 0);
        ImageView imageView = this.f3090m;
        if (!this.f3102y) {
            i = 0;
        }
        imageView.setVisibility(i);
        m2221h();
        if (z3) {
            z2 = false;
        }
        m2211c(z2);
        m2220g();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2196a(int i) {
        if (this.f3100w != null && this.f3100w.onSuggestionSelect(i)) {
            return false;
        }
        m2215e(i);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2197a(int i, int i2, String str) {
        if (this.f3100w != null && this.f3100w.onSuggestionClick(i)) {
            return false;
        }
        m2207b(i, 0, (String) null);
        setImeVisibility(false);
        m2233n();
        return true;
    }

    /* renamed from: a */
    static boolean m2198a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2202a(View view, int i, KeyEvent keyEvent) {
        if (this.f3068L == null || this.f3057A == null || keyEvent.getAction() != 0 || !KeyEventCompat.hasNoModifiers(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return m2197a(this.f3081d.getListSelection(), 0, (String) null);
        }
        if (i == 21 || i == 22) {
            this.f3081d.setSelection(i == 21 ? 0 : this.f3081d.length());
            this.f3081d.setListSelection(0);
            this.f3081d.clearListSelection();
            f3055a.mo5995a(this.f3081d, true);
            return true;
        }
        if (!(i == 19 && this.f3081d.getListSelection() == 0)) {
        }
        return false;
    }

    @TargetApi(8)
    /* renamed from: b */
    private Intent m2203b(Intent intent, SearchableInfo searchableInfo) {
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
        if (this.f3069M != null) {
            bundle.putParcelable("app_data", this.f3069M);
        }
        Intent intent3 = new Intent(intent);
        String str5 = "free_form";
        if (Build.VERSION.SDK_INT >= 8) {
            Resources resources = getResources();
            if (searchableInfo.getVoiceLanguageModeId() != 0) {
                str5 = resources.getString(searchableInfo.getVoiceLanguageModeId());
            }
            str2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
            str = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
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

    /* renamed from: b */
    private CharSequence m2205b(CharSequence charSequence) {
        if (!this.f3102y || this.f3091n == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f3081d.getTextSize()) * 1.25d);
        this.f3091n.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f3091n), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: b */
    private void m2206b(boolean z) {
        int i = 8;
        if (this.f3058B && m2218f() && hasFocus() && (z || !this.f3063G)) {
            i = 0;
        }
        this.f3086i.setVisibility(i);
    }

    /* renamed from: b */
    private boolean m2207b(int i, int i2, String str) {
        Cursor cursor = this.f3057A.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        m2190a(m2187a(cursor, i2, str));
        return true;
    }

    @TargetApi(11)
    /* renamed from: c */
    private void m2209c() {
        this.f3089l.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SearchView.this.m2239r();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2210c(CharSequence charSequence) {
        boolean z = true;
        Editable text = this.f3081d.getText();
        this.f3065I = text;
        boolean z2 = !TextUtils.isEmpty(text);
        m2206b(z2);
        if (z2) {
            z = false;
        }
        m2211c(z);
        m2221h();
        m2220g();
        if (this.f3097t != null && !TextUtils.equals(charSequence, this.f3064H)) {
            this.f3097t.onQueryTextChange(charSequence.toString());
        }
        this.f3064H = charSequence.toString();
    }

    /* renamed from: c */
    private void m2211c(boolean z) {
        int i;
        if (!this.f3063G || isIconified() || !z) {
            i = 8;
        } else {
            i = 0;
            this.f3086i.setVisibility(8);
        }
        this.f3088k.setVisibility(i);
    }

    /* renamed from: d */
    private void m2212d() {
        this.f3089l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                SearchView.this.m2239r();
            }
        });
    }

    /* renamed from: e */
    private void m2215e(int i) {
        Editable text = this.f3081d.getText();
        Cursor cursor = this.f3057A.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.f3057A.convertToString(cursor);
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

    @TargetApi(8)
    /* renamed from: e */
    private boolean m2216e() {
        if (this.f3068L == null || !this.f3068L.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f3068L.getVoiceSearchLaunchWebSearch()) {
            intent = this.f3094q;
        } else if (this.f3068L.getVoiceSearchLaunchRecognizer()) {
            intent = this.f3095r;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* renamed from: f */
    private boolean m2218f() {
        return (this.f3058B || this.f3063G) && !isIconified();
    }

    /* renamed from: g */
    private void m2220g() {
        int i = 8;
        if (m2218f() && (this.f3086i.getVisibility() == 0 || this.f3088k.getVisibility() == 0)) {
            i = 0;
        }
        this.f3084g.setVisibility(i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0235R.dimen.abc_search_view_preferred_width);
    }

    /* renamed from: h */
    private void m2221h() {
        boolean z = true;
        int i = 0;
        boolean z2 = !TextUtils.isEmpty(this.f3081d.getText());
        if (!z2 && (!this.f3102y || this.f3066J)) {
            z = false;
        }
        ImageView imageView = this.f3087j;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f3087j.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: i */
    private void m2224i() {
        post(this.f3072P);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m2225j() {
        int[] iArr = this.f3081d.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f3083f.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f3084g.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* renamed from: k */
    private void m2228k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f3081d;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m2205b(queryHint));
    }

    @TargetApi(8)
    /* renamed from: l */
    private void m2229l() {
        int i = 1;
        this.f3081d.setThreshold(this.f3068L.getSuggestThreshold());
        this.f3081d.setImeOptions(this.f3068L.getImeOptions());
        int inputType = this.f3068L.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f3068L.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f3081d.setInputType(inputType);
        if (this.f3057A != null) {
            this.f3057A.changeCursor((Cursor) null);
        }
        if (this.f3068L.getSuggestAuthority() != null) {
            this.f3057A = new SuggestionsAdapter(getContext(), this, this.f3068L, this.f3074R);
            this.f3081d.setAdapter(this.f3057A);
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.f3057A;
            if (this.f3060D) {
                i = 2;
            }
            suggestionsAdapter.setQueryRefinement(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m2232m() {
        Editable text = this.f3081d.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f3097t == null || !this.f3097t.onQueryTextSubmit(text.toString())) {
                if (this.f3068L != null) {
                    m2189a(0, (String) null, text.toString());
                }
                setImeVisibility(false);
                m2233n();
            }
        }
    }

    /* renamed from: n */
    private void m2233n() {
        this.f3081d.dismissDropDown();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m2236o() {
        if (!TextUtils.isEmpty(this.f3081d.getText())) {
            this.f3081d.setText("");
            this.f3081d.requestFocus();
            setImeVisibility(true);
        } else if (!this.f3102y) {
        } else {
            if (this.f3098u == null || !this.f3098u.onClose()) {
                clearFocus();
                m2195a(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m2237p() {
        m2195a(false);
        this.f3081d.requestFocus();
        setImeVisibility(true);
        if (this.f3101x != null) {
            this.f3101x.onClick(this);
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(8)
    /* renamed from: q */
    public void m2238q() {
        if (this.f3068L != null) {
            SearchableInfo searchableInfo = this.f3068L;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m2186a(this.f3094q, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m2203b(this.f3095r, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m2239r() {
        if (this.f3089l.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f3083f.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int dimensionPixelSize = this.f3102y ? resources.getDimensionPixelSize(C0235R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(C0235R.dimen.abc_dropdownitem_icon_width) : 0;
            this.f3081d.getDropDownBackground().getPadding(rect);
            this.f3081d.setDropDownHorizontalOffset(isLayoutRtl ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f3081d.setDropDownWidth((dimensionPixelSize + ((this.f3089l.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m2240s() {
        f3055a.mo5994a(this.f3081d);
        f3055a.mo5996b(this.f3081d);
    }

    /* access modifiers changed from: private */
    public void setImeVisibility(boolean z) {
        if (z) {
            post(this.f3071O);
            return;
        }
        removeCallbacks(this.f3071O);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f3081d.setText(charSequence);
        this.f3081d.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5943a() {
        m2195a(isIconified());
        m2224i();
        if (this.f3081d.hasFocus()) {
            m2240s();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5944a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void clearFocus() {
        this.f3061E = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f3081d.clearFocus();
        this.f3061E = false;
    }

    public int getImeOptions() {
        return this.f3081d.getImeOptions();
    }

    public int getInputType() {
        return this.f3081d.getInputType();
    }

    public int getMaxWidth() {
        return this.f3062F;
    }

    public CharSequence getQuery() {
        return this.f3081d.getText();
    }

    public CharSequence getQueryHint() {
        return this.f3059C != null ? this.f3059C : (!f3056c || this.f3068L == null || this.f3068L.getHintId() == 0) ? this.f3096s : getContext().getText(this.f3068L.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.f3093p;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.f3092o;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f3057A;
    }

    public boolean isIconfiedByDefault() {
        return this.f3102y;
    }

    public boolean isIconified() {
        return this.f3103z;
    }

    public boolean isQueryRefinementEnabled() {
        return this.f3060D;
    }

    public boolean isSubmitButtonEnabled() {
        return this.f3058B;
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        m2195a(true);
        this.f3081d.setImeOptions(this.f3067K);
        this.f3066J = false;
    }

    public void onActionViewExpanded() {
        if (!this.f3066J) {
            this.f3066J = true;
            this.f3067K = this.f3081d.getImeOptions();
            this.f3081d.setImeOptions(this.f3067K | 33554432);
            this.f3081d.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f3072P);
        post(this.f3073Q);
        super.onDetachedFromWindow();
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
            case Integer.MIN_VALUE:
                if (this.f3062F <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f3062F, size);
                    break;
                }
            case 0:
                if (this.f3062F <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f3062F;
                    break;
                }
            case 1073741824:
                if (this.f3062F > 0) {
                    size = Math.min(this.f3062F, size);
                    break;
                }
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m2224i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f3061E || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f3081d.requestFocus(i, rect);
        if (requestFocus) {
            m2195a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f3069M = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m2236o();
        } else {
            m2237p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f3102y != z) {
            this.f3102y = z;
            m2195a(z);
            m2228k();
        }
    }

    public void setImeOptions(int i) {
        this.f3081d.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f3081d.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f3062F = i;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f3098u = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f3099v = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.f3097t = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f3101x = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.f3100w = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.f3081d.setText(charSequence);
        if (charSequence != null) {
            this.f3081d.setSelection(this.f3081d.length());
            this.f3065I = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m2232m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f3059C = charSequence;
        m2228k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f3060D = z;
        if (this.f3057A instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) this.f3057A).setQueryRefinement(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f3068L = searchableInfo;
        if (this.f3068L != null) {
            if (f3056c) {
                m2229l();
            }
            m2228k();
        }
        this.f3063G = f3056c && m2216e();
        if (this.f3063G) {
            this.f3081d.setPrivateImeOptions("nm");
        }
        m2195a(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f3058B = z;
        m2195a(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f3057A = cursorAdapter;
        this.f3081d.setAdapter(this.f3057A);
    }
}
