package android.support.p003v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.p000v4.view.KeyEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.widget.CursorAdapter;
import android.support.p000v4.widget.ExploreByTouchHelper;
import android.support.p003v7.appcompat.C0091R;
import android.support.p003v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.drive.DriveFile;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.SearchView */
public class SearchView extends LinearLayout implements CollapsibleActionView {
    private static final boolean DBG = false;
    static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    /* access modifiers changed from: private */
    public ImageView mCloseButton;
    private int mCollapsedImeOptions;
    private View mDropDownAnchor;
    private boolean mExpandedInActionView;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    /* access modifiers changed from: private */
    public View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    /* access modifiers changed from: private */
    public SearchAutoComplete mQueryTextView;
    private Runnable mReleaseCursorRunnable;
    /* access modifiers changed from: private */
    public View mSearchButton;
    private View mSearchEditFrame;
    private ImageView mSearchHintIcon;
    private View mSearchPlate;
    /* access modifiers changed from: private */
    public SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private View mSubmitArea;
    /* access modifiers changed from: private */
    public View mSubmitButton;
    private boolean mSubmitButtonEnabled;
    /* access modifiers changed from: private */
    public CursorAdapter mSuggestionsAdapter;
    View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    /* access modifiers changed from: private */
    public View mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

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

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mShowImeRunnable = new Runnable() {
            public void run() {
                InputMethodManager imm = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (imm != null) {
                    SearchView.HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(imm, SearchView.this, 0);
                }
            }
        };
        this.mUpdateDrawableStateRunnable = new Runnable() {
            public void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.mReleaseCursorRunnable = new Runnable() {
            public void run() {
                if (SearchView.this.mSuggestionsAdapter != null && (SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter)) {
                    SearchView.this.mSuggestionsAdapter.changeCursor((Cursor) null);
                }
            }
        };
        this.mOutsideDrawablesCache = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (v == SearchView.this.mSearchButton) {
                    SearchView.this.onSearchClicked();
                } else if (v == SearchView.this.mCloseButton) {
                    SearchView.this.onCloseClicked();
                } else if (v == SearchView.this.mSubmitButton) {
                    SearchView.this.onSubmitQuery();
                } else if (v == SearchView.this.mVoiceButton) {
                    SearchView.this.onVoiceClicked();
                } else if (v == SearchView.this.mQueryTextView) {
                    SearchView.this.forceSuggestionQuery();
                }
            }
        };
        this.mTextKeyListener = new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (SearchView.this.mSearchable == null) {
                    return false;
                }
                if (SearchView.this.mQueryTextView.isPopupShowing() && SearchView.this.mQueryTextView.getListSelection() != -1) {
                    return SearchView.this.onSuggestionsKey(v, keyCode, event);
                }
                if (SearchView.this.mQueryTextView.isEmpty() || !KeyEventCompat.hasNoModifiers(event) || event.getAction() != 1 || keyCode != 66) {
                    return false;
                }
                v.cancelLongPress();
                SearchView.this.launchQuerySearch(0, (String) null, SearchView.this.mQueryTextView.getText().toString());
                return true;
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                boolean unused = SearchView.this.onItemClicked(position, 0, (String) null);
            }
        };
        this.mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                boolean unused = SearchView.this.onItemSelected(position);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mTextWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int before, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int after) {
                SearchView.this.onTextChanged(s);
            }

            public void afterTextChanged(Editable s) {
            }
        };
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0091R.layout.abc_search_view, this, true);
        this.mSearchButton = findViewById(C0091R.C0093id.search_button);
        this.mQueryTextView = (SearchAutoComplete) findViewById(C0091R.C0093id.search_src_text);
        this.mQueryTextView.setSearchView(this);
        this.mSearchEditFrame = findViewById(C0091R.C0093id.search_edit_frame);
        this.mSearchPlate = findViewById(C0091R.C0093id.search_plate);
        this.mSubmitArea = findViewById(C0091R.C0093id.submit_area);
        this.mSubmitButton = findViewById(C0091R.C0093id.search_go_btn);
        this.mCloseButton = (ImageView) findViewById(C0091R.C0093id.search_close_btn);
        this.mVoiceButton = findViewById(C0091R.C0093id.search_voice_btn);
        this.mSearchHintIcon = (ImageView) findViewById(C0091R.C0093id.search_mag_icon);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mSubmitButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.addTextChangedListener(this.mTextWatcher);
        this.mQueryTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mQueryTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mQueryTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mQueryTextView.setOnKeyListener(this.mTextKeyListener);
        this.mQueryTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (SearchView.this.mOnQueryTextFocusChangeListener != null) {
                    SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
                }
            }
        });
        TypedArray a = context.obtainStyledAttributes(attrs, C0091R.styleable.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(3, true));
        int maxWidth = a.getDimensionPixelSize(0, -1);
        if (maxWidth != -1) {
            setMaxWidth(maxWidth);
        }
        CharSequence queryHint = a.getText(4);
        if (!TextUtils.isEmpty(queryHint)) {
            setQueryHint(queryHint);
        }
        int imeOptions = a.getInt(2, -1);
        if (imeOptions != -1) {
            setImeOptions(imeOptions);
        }
        int inputType = a.getInt(1, -1);
        if (inputType != -1) {
            setInputType(inputType);
        }
        a.recycle();
        TypedArray a2 = context.obtainStyledAttributes(attrs, C0091R.styleable.View, 0, 0);
        boolean focusable = a2.getBoolean(0, true);
        a2.recycle();
        setFocusable(focusable);
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent.addFlags(DriveFile.MODE_READ_ONLY);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent.addFlags(DriveFile.MODE_READ_ONLY);
        this.mDropDownAnchor = findViewById(this.mQueryTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                addOnLayoutChangeListenerToDropDownAnchorSDK11();
            } else {
                addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        this.mDropDownAnchor.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                SearchView.this.adjustDropDownSizeAndPosition();
            }
        });
    }

    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                SearchView.this.adjustDropDownSizeAndPosition();
            }
        });
    }

    public void setSearchableInfo(SearchableInfo searchable) {
        this.mSearchable = searchable;
        if (this.mSearchable != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        if (this.mVoiceButtonEnabled) {
            this.mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    public void setAppSearchData(Bundle appSearchData) {
        this.mAppSearchData = appSearchData;
    }

    public void setImeOptions(int imeOptions) {
        this.mQueryTextView.setImeOptions(imeOptions);
    }

    public int getImeOptions() {
        return this.mQueryTextView.getImeOptions();
    }

    public void setInputType(int inputType) {
        this.mQueryTextView.setInputType(inputType);
    }

    public int getInputType() {
        return this.mQueryTextView.getInputType();
    }

    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (this.mClearingFocus) {
            return false;
        }
        if (!isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        boolean result = this.mQueryTextView.requestFocus(direction, previouslyFocusedRect);
        if (!result) {
            return result;
        }
        updateViewsVisibility(false);
        return result;
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        this.mQueryTextView.clearFocus();
        this.mClearingFocus = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener listener) {
        this.mOnQueryChangeListener = listener;
    }

    public void setOnCloseListener(OnCloseListener listener) {
        this.mOnCloseListener = listener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener listener) {
        this.mOnQueryTextFocusChangeListener = listener;
    }

    public void setOnSuggestionListener(OnSuggestionListener listener) {
        this.mOnSuggestionListener = listener;
    }

    public void setOnSearchClickListener(View.OnClickListener listener) {
        this.mOnSearchClickListener = listener;
    }

    public CharSequence getQuery() {
        return this.mQueryTextView.getText();
    }

    public void setQuery(CharSequence query, boolean submit) {
        this.mQueryTextView.setText(query);
        if (query != null) {
            this.mQueryTextView.setSelection(this.mQueryTextView.length());
            this.mUserQuery = query;
        }
        if (submit && !TextUtils.isEmpty(query)) {
            onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence hint) {
        this.mQueryHint = hint;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        int hintId;
        if (this.mQueryHint != null) {
            return this.mQueryHint;
        }
        if (this.mSearchable == null || (hintId = this.mSearchable.getHintId()) == 0) {
            return null;
        }
        return getContext().getString(hintId);
    }

    public void setIconifiedByDefault(boolean iconified) {
        if (this.mIconifiedByDefault != iconified) {
            this.mIconifiedByDefault = iconified;
            updateViewsVisibility(iconified);
            updateQueryHint();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public void setIconified(boolean iconify) {
        if (iconify) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public void setSubmitButtonEnabled(boolean enabled) {
        this.mSubmitButtonEnabled = enabled;
        updateViewsVisibility(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void setQueryRefinementEnabled(boolean enable) {
        this.mQueryRefinement = enable;
        if (this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) this.mSuggestionsAdapter).setQueryRefinement(enable ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public void setSuggestionsAdapter(CursorAdapter adapter) {
        this.mSuggestionsAdapter = adapter;
        this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int maxpixels) {
        this.mMaxWidth = maxpixels;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isIconified()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        switch (widthMode) {
            case ExploreByTouchHelper.INVALID_ID:
                if (this.mMaxWidth <= 0) {
                    width = Math.min(getPreferredWidth(), width);
                    break;
                } else {
                    width = Math.min(this.mMaxWidth, width);
                    break;
                }
            case 0:
                if (this.mMaxWidth <= 0) {
                    width = getPreferredWidth();
                    break;
                } else {
                    width = this.mMaxWidth;
                    break;
                }
            case 1073741824:
                if (this.mMaxWidth > 0) {
                    width = Math.min(this.mMaxWidth, width);
                    break;
                }
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), heightMeasureSpec);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0091R.dimen.abc_search_view_preferred_width);
    }

    private void updateViewsVisibility(boolean collapsed) {
        int visCollapsed;
        boolean hasText;
        int i;
        boolean z = true;
        int i2 = 8;
        this.mIconified = collapsed;
        if (collapsed) {
            visCollapsed = 0;
        } else {
            visCollapsed = 8;
        }
        if (!TextUtils.isEmpty(this.mQueryTextView.getText())) {
            hasText = true;
        } else {
            hasText = false;
        }
        this.mSearchButton.setVisibility(visCollapsed);
        updateSubmitButton(hasText);
        View view = this.mSearchEditFrame;
        if (collapsed) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        ImageView imageView = this.mSearchHintIcon;
        if (!this.mIconifiedByDefault) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        updateCloseButton();
        if (hasText) {
            z = false;
        }
        updateVoiceButton(z);
        updateSubmitArea();
    }

    private boolean hasVoiceSearch() {
        if (this.mSearchable == null || !this.mSearchable.getVoiceSearchEnabled()) {
            return false;
        }
        Intent testIntent = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
            testIntent = this.mVoiceWebSearchIntent;
        } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
            testIntent = this.mVoiceAppSearchIntent;
        }
        if (testIntent == null || getContext().getPackageManager().resolveActivity(testIntent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified();
    }

    private void updateSubmitButton(boolean hasText) {
        int visibility = 8;
        if (this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (hasText || !this.mVoiceButtonEnabled)) {
            visibility = 0;
        }
        this.mSubmitButton.setVisibility(visibility);
    }

    private void updateSubmitArea() {
        int visibility = 8;
        if (isSubmitAreaEnabled() && (this.mSubmitButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) {
            visibility = 0;
        }
        this.mSubmitArea.setVisibility(visibility);
    }

    private void updateCloseButton() {
        boolean hasText;
        boolean showClose = true;
        int i = 0;
        if (!TextUtils.isEmpty(this.mQueryTextView.getText())) {
            hasText = true;
        } else {
            hasText = false;
        }
        if (!hasText && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
            showClose = false;
        }
        ImageView imageView = this.mCloseButton;
        if (!showClose) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    /* access modifiers changed from: private */
    public void updateFocusedState() {
        boolean focused = this.mQueryTextView.hasFocus();
        this.mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        this.mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void setImeVisibility(boolean visible) {
        if (visible) {
            post(this.mShowImeRunnable);
            return;
        }
        removeCallbacks(this.mShowImeRunnable);
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void onQueryRefine(CharSequence queryText) {
        setQuery(queryText);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mSearchable == null) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /* access modifiers changed from: private */
    public boolean onSuggestionsKey(View v, int keyCode, KeyEvent event) {
        int selPoint;
        if (this.mSearchable == null || this.mSuggestionsAdapter == null || event.getAction() != 0 || !KeyEventCompat.hasNoModifiers(event)) {
            return false;
        }
        if (keyCode == 66 || keyCode == 84 || keyCode == 61) {
            return onItemClicked(this.mQueryTextView.getListSelection(), 0, (String) null);
        }
        if (keyCode == 21 || keyCode == 22) {
            if (keyCode == 21) {
                selPoint = 0;
            } else {
                selPoint = this.mQueryTextView.length();
            }
            this.mQueryTextView.setSelection(selPoint);
            this.mQueryTextView.setListSelection(0);
            this.mQueryTextView.clearListSelection();
            HIDDEN_METHOD_INVOKER.ensureImeVisible(this.mQueryTextView, true);
            return true;
        }
        if (!(keyCode == 19 && this.mQueryTextView.getListSelection() == 0)) {
        }
        return false;
    }

    private int getSearchIconId() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(C0091R.attr.searchViewSearchIcon, outValue, true);
        return outValue.resourceId;
    }

    private CharSequence getDecoratedHint(CharSequence hintText) {
        if (!this.mIconifiedByDefault) {
            return hintText;
        }
        SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.append(hintText);
        Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (((double) this.mQueryTextView.getTextSize()) * 1.25d);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, 33);
        return ssb;
    }

    private void updateQueryHint() {
        if (this.mQueryHint != null) {
            this.mQueryTextView.setHint(getDecoratedHint(this.mQueryHint));
        } else if (this.mSearchable != null) {
            CharSequence hint = null;
            int hintId = this.mSearchable.getHintId();
            if (hintId != 0) {
                hint = getContext().getString(hintId);
            }
            if (hint != null) {
                this.mQueryTextView.setHint(getDecoratedHint(hint));
            }
        } else {
            this.mQueryTextView.setHint(getDecoratedHint(""));
        }
    }

    private void updateSearchAutoComplete() {
        int i = 1;
        this.mQueryTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mQueryTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
            }
        }
        this.mQueryTextView.setInputType(inputType);
        if (this.mSuggestionsAdapter != null) {
            this.mSuggestionsAdapter.changeCursor((Cursor) null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                i = 2;
            }
            suggestionsAdapter.setQueryRefinement(i);
        }
    }

    private void updateVoiceButton(boolean empty) {
        int visibility = 8;
        if (this.mVoiceButtonEnabled && !isIconified() && empty) {
            visibility = 0;
            this.mSubmitButton.setVisibility(8);
        }
        this.mVoiceButton.setVisibility(visibility);
    }

    /* access modifiers changed from: private */
    public void onTextChanged(CharSequence newText) {
        boolean hasText;
        boolean z = true;
        CharSequence text = this.mQueryTextView.getText();
        this.mUserQuery = text;
        if (!TextUtils.isEmpty(text)) {
            hasText = true;
        } else {
            hasText = false;
        }
        updateSubmitButton(hasText);
        if (hasText) {
            z = false;
        }
        updateVoiceButton(z);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null && !TextUtils.equals(newText, this.mOldQueryText)) {
            this.mOnQueryChangeListener.onQueryTextChange(newText.toString());
        }
        this.mOldQueryText = newText.toString();
    }

    /* access modifiers changed from: private */
    public void onSubmitQuery() {
        CharSequence query = this.mQueryTextView.getText();
        if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            if (this.mOnQueryChangeListener == null || !this.mOnQueryChangeListener.onQueryTextSubmit(query.toString())) {
                if (this.mSearchable != null) {
                    launchQuerySearch(0, (String) null, query.toString());
                    setImeVisibility(false);
                }
                dismissSuggestions();
            }
        }
    }

    private void dismissSuggestions() {
        this.mQueryTextView.dismissDropDown();
    }

    /* access modifiers changed from: private */
    public void onCloseClicked() {
        if (!TextUtils.isEmpty(this.mQueryTextView.getText())) {
            this.mQueryTextView.setText("");
            this.mQueryTextView.requestFocus();
            setImeVisibility(true);
        } else if (!this.mIconifiedByDefault) {
        } else {
            if (this.mOnCloseListener == null || !this.mOnCloseListener.onClose()) {
                clearFocus();
                updateViewsVisibility(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSearchClicked() {
        updateViewsVisibility(false);
        this.mQueryTextView.requestFocus();
        setImeVisibility(true);
        if (this.mOnSearchClickListener != null) {
            this.mOnSearchClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: private */
    public void onVoiceClicked() {
        if (this.mSearchable != null) {
            SearchableInfo searchable = this.mSearchable;
            try {
                if (searchable.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchable));
                } else if (searchable.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchable));
                }
            } catch (ActivityNotFoundException e) {
                Log.w(LOG_TAG, "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mQueryTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        postUpdateFocusedState();
    }

    public void onActionViewCollapsed() {
        clearFocus();
        updateViewsVisibility(true);
        this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            this.mCollapsedImeOptions = this.mQueryTextView.getImeOptions();
            this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions | 33554432);
            this.mQueryTextView.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: private */
    public void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() > 1) {
            Resources res = getContext().getResources();
            int anchorPadding = this.mSearchPlate.getPaddingLeft();
            Rect dropDownPadding = new Rect();
            int iconOffset = this.mIconifiedByDefault ? res.getDimensionPixelSize(C0091R.dimen.abc_dropdownitem_icon_width) + res.getDimensionPixelSize(C0091R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.mQueryTextView.getDropDownBackground().getPadding(dropDownPadding);
            this.mQueryTextView.setDropDownHorizontalOffset(anchorPadding - (dropDownPadding.left + iconOffset));
            this.mQueryTextView.setDropDownWidth((((this.mDropDownAnchor.getWidth() + dropDownPadding.left) + dropDownPadding.right) + iconOffset) - anchorPadding);
        }
    }

    /* access modifiers changed from: private */
    public boolean onItemClicked(int position, int actionKey, String actionMsg) {
        if (this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionClick(position)) {
            return false;
        }
        launchSuggestion(position, 0, (String) null);
        setImeVisibility(false);
        dismissSuggestions();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean onItemSelected(int position) {
        if (this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionSelect(position)) {
            return false;
        }
        rewriteQueryFromSuggestion(position);
        return true;
    }

    private void rewriteQueryFromSuggestion(int position) {
        CharSequence oldQuery = this.mQueryTextView.getText();
        Cursor c = this.mSuggestionsAdapter.getCursor();
        if (c != null) {
            if (c.moveToPosition(position)) {
                CharSequence newQuery = this.mSuggestionsAdapter.convertToString(c);
                if (newQuery != null) {
                    setQuery(newQuery);
                } else {
                    setQuery(oldQuery);
                }
            } else {
                setQuery(oldQuery);
            }
        }
    }

    private boolean launchSuggestion(int position, int actionKey, String actionMsg) {
        Cursor c = this.mSuggestionsAdapter.getCursor();
        if (c == null || !c.moveToPosition(position)) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(c, actionKey, actionMsg));
        return true;
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException ex) {
                Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
            }
        }
    }

    private void setQuery(CharSequence query) {
        this.mQueryTextView.setText(query);
        this.mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    /* access modifiers changed from: private */
    public void launchQuerySearch(int actionKey, String actionMsg, String query) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", (Uri) null, (String) null, query, actionKey, actionMsg));
    }

    private Intent createIntent(String action, Uri data, String extraData, String query, int actionKey, String actionMsg) {
        Intent intent = new Intent(action);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (query != null) {
            intent.putExtra("query", query);
        }
        if (extraData != null) {
            intent.putExtra("intent_extra_data_key", extraData);
        }
        if (this.mAppSearchData != null) {
            intent.putExtra("app_data", this.mAppSearchData);
        }
        if (actionKey != 0) {
            intent.putExtra("action_key", actionKey);
            intent.putExtra("action_msg", actionMsg);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createVoiceWebSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return voiceIntent;
    }

    private Intent createVoiceAppSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        ComponentName searchActivity = searchable.getSearchActivity();
        Intent queryIntent = new Intent("android.intent.action.SEARCH");
        queryIntent.setComponent(searchActivity);
        PendingIntent pending = PendingIntent.getActivity(getContext(), 0, queryIntent, 1073741824);
        Bundle queryExtras = new Bundle();
        if (this.mAppSearchData != null) {
            queryExtras.putParcelable("app_data", this.mAppSearchData);
        }
        Intent voiceIntent = new Intent(baseIntent);
        String languageModel = "free_form";
        String prompt = null;
        String language = null;
        int maxResults = 1;
        Resources resources = getResources();
        if (searchable.getVoiceLanguageModeId() != 0) {
            languageModel = resources.getString(searchable.getVoiceLanguageModeId());
        }
        if (searchable.getVoicePromptTextId() != 0) {
            prompt = resources.getString(searchable.getVoicePromptTextId());
        }
        if (searchable.getVoiceLanguageId() != 0) {
            language = resources.getString(searchable.getVoiceLanguageId());
        }
        if (searchable.getVoiceMaxResults() != 0) {
            maxResults = searchable.getVoiceMaxResults();
        }
        voiceIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", languageModel);
        voiceIntent.putExtra("android.speech.extra.PROMPT", prompt);
        voiceIntent.putExtra("android.speech.extra.LANGUAGE", language);
        voiceIntent.putExtra("android.speech.extra.MAX_RESULTS", maxResults);
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pending);
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", queryExtras);
        return voiceIntent;
    }

    private Intent createIntentFromSuggestion(Cursor c, int actionKey, String actionMsg) {
        int rowNum;
        String id;
        try {
            String action = SuggestionsAdapter.getColumnString(c, "suggest_intent_action");
            if (action == null) {
                action = this.mSearchable.getSuggestIntentAction();
            }
            if (action == null) {
                action = "android.intent.action.SEARCH";
            }
            String data = SuggestionsAdapter.getColumnString(c, "suggest_intent_data");
            if (data == null) {
                data = this.mSearchable.getSuggestIntentData();
            }
            if (!(data == null || (id = SuggestionsAdapter.getColumnString(c, "suggest_intent_data_id")) == null)) {
                data = data + "/" + Uri.encode(id);
            }
            return createIntent(action, data == null ? null : Uri.parse(data), SuggestionsAdapter.getColumnString(c, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(c, "suggest_intent_query"), actionKey, actionMsg);
        } catch (RuntimeException e) {
            try {
                rowNum = c.getPosition();
            } catch (RuntimeException e2) {
                rowNum = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + rowNum + " returned exception.", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void forceSuggestionQuery() {
        HIDDEN_METHOD_INVOKER.doBeforeTextChanged(this.mQueryTextView);
        HIDDEN_METHOD_INVOKER.doAfterTextChanged(this.mQueryTextView);
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete */
    public static class SearchAutoComplete extends AutoCompleteTextView {
        private SearchView mSearchView;
        private int mThreshold = getThreshold();

        public SearchAutoComplete(Context context) {
            super(context);
        }

        public SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            this.mThreshold = threshold;
        }

        /* access modifiers changed from: private */
        public boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence text) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);
            if (hasWindowFocus && this.mSearchView.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.isLandscapeMode(getContext())) {
                    SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            this.mSearchView.onTextFocusChanged();
        }

        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyCode == 4) {
                if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state == null) {
                        return true;
                    }
                    state.startTracking(event, this);
                    return true;
                } else if (event.getAction() == 1) {
                    KeyEvent.DispatcherState state2 = getKeyDispatcherState();
                    if (state2 != null) {
                        state2.handleUpEvent(event);
                    }
                    if (event.isTracking() && !event.isCanceled()) {
                        this.mSearchView.clearFocus();
                        this.mSearchView.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(keyCode, event);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$AutoCompleteTextViewReflector */
    private static class AutoCompleteTextViewReflector {
        private Method doAfterTextChanged;
        private Method doBeforeTextChanged;
        private Method ensureImeVisible;
        private Method showSoftInputUnchecked;

        AutoCompleteTextViewReflector() {
            try {
                this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.doBeforeTextChanged.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.doAfterTextChanged.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                this.ensureImeVisible = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.ensureImeVisible.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            Class<InputMethodManager> cls2 = InputMethodManager.class;
            try {
                this.showSoftInputUnchecked = cls2.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.showSoftInputUnchecked.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        /* access modifiers changed from: package-private */
        public void doBeforeTextChanged(AutoCompleteTextView view) {
            if (this.doBeforeTextChanged != null) {
                try {
                    this.doBeforeTextChanged.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void doAfterTextChanged(AutoCompleteTextView view) {
            if (this.doAfterTextChanged != null) {
                try {
                    this.doAfterTextChanged.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void ensureImeVisible(AutoCompleteTextView view, boolean visible) {
            if (this.ensureImeVisible != null) {
                try {
                    this.ensureImeVisible.invoke(view, new Object[]{Boolean.valueOf(visible)});
                } catch (Exception e) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void showSoftInputUnchecked(InputMethodManager imm, View view, int flags) {
            if (this.showSoftInputUnchecked != null) {
                try {
                    this.showSoftInputUnchecked.invoke(imm, new Object[]{Integer.valueOf(flags), null});
                    return;
                } catch (Exception e) {
                }
            }
            imm.showSoftInput(view, flags);
        }
    }
}