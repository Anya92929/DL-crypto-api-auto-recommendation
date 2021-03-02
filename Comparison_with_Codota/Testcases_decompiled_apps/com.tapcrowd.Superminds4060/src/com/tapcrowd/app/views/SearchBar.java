package com.tapcrowd.app.views;

import android.content.Context;
import android.support.p000v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.TCCheckboxAdapter;
import com.tapcrowd.app.utils.TCListObject;

public class SearchBar extends LinearLayout {
    View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus && SearchBar.this.requestfocus) {
                SearchBar.this.search.post(new Runnable() {
                    public void run() {
                        SearchBar.this.search.requestFocus();
                        SearchBar.this.requestfocus = false;
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */
    public ListFragment fragment;
    /* access modifiers changed from: private */
    public TextChangedListener listener;
    /* access modifiers changed from: private */
    public boolean requestfocus;
    /* access modifiers changed from: private */
    public EditText search;
    TextWatcher textWatcher = new TextWatcher() {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (SearchBar.this.listener != null) {
                SearchBar.this.requestfocus = true;
                SearchBar.this.listener.textChanged(s, count);
                return;
            }
            ListAdapter adapter = SearchBar.this.fragment.getListAdapter();
            if (adapter instanceof TCListObject.TCListObjectAdapter) {
                SearchBar.this.requestfocus = true;
                ((TCListObject.TCListObjectAdapter) adapter).getFilter().filter(s);
            }
            if (adapter instanceof TCCheckboxAdapter) {
                SearchBar.this.requestfocus = true;
                ((TCCheckboxAdapter) adapter).getFilter().filter(s);
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    };

    public interface TextChangedListener {
        void textChanged(CharSequence charSequence, int i);
    }

    public SearchBar(Context context, ListFragment fragment2) {
        super(context);
        this.fragment = fragment2;
        construct();
    }

    public SearchBar(Context context, TextChangedListener listener2) {
        super(context);
        this.listener = listener2;
        construct();
    }

    public SearchBar(Context context, ListFragment fragment2, TextChangedListener listener2) {
        super(context);
        this.fragment = fragment2;
        this.listener = listener2;
        construct();
    }

    public SearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        construct();
    }

    public void construct() {
        LayoutInflater.from(getContext()).inflate(C0846R.layout.search_bar, this);
        this.search = (EditText) findViewById(C0846R.C0847id.search_box);
        this.search.addTextChangedListener(this.textWatcher);
    }

    public EditText getSearch() {
        return this.search;
    }

    public void forceChange() {
        this.textWatcher.onTextChanged(this.search.getText(), 0, 0, this.search.getText().length());
    }
}
