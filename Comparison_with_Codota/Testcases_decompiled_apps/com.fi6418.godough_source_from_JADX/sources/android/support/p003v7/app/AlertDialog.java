package android.support.p003v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.p003v7.app.AlertController;
import android.support.p003v7.appcompat.C0235R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.app.AlertDialog */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AlertController f1796a = new AlertController(getContext(), this, getWindow());

    /* renamed from: android.support.v7.app.AlertDialog$Builder */
    public class Builder {

        /* renamed from: a */
        private final AlertController.AlertParams f1797a;

        /* renamed from: b */
        private int f1798b;

        public Builder(Context context) {
            this(context, AlertDialog.m1249a(context, 0));
        }

        public Builder(Context context, int i) {
            this.f1797a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.m1249a(context, i)));
            this.f1798b = i;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f1797a.mContext, this.f1798b, false);
            this.f1797a.apply(alertDialog.f1796a);
            alertDialog.setCancelable(this.f1797a.mCancelable);
            if (this.f1797a.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1797a.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f1797a.mOnDismissListener);
            if (this.f1797a.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f1797a.mOnKeyListener);
            }
            return alertDialog;
        }

        public Context getContext() {
            return this.f1797a.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mAdapter = listAdapter;
            this.f1797a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f1797a.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.f1797a.mCursor = cursor;
            this.f1797a.mLabelColumn = str;
            this.f1797a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f1797a.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.f1797a.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f1797a.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f1797a.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f1797a.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.f1797a.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mItems = this.f1797a.mContext.getResources().getTextArray(i);
            this.f1797a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mItems = charSequenceArr;
            this.f1797a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(int i) {
            this.f1797a.mMessage = this.f1797a.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f1797a.mMessage = charSequence;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1797a.mItems = this.f1797a.mContext.getResources().getTextArray(i);
            this.f1797a.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1797a.mCheckedItems = zArr;
            this.f1797a.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1797a.mCursor = cursor;
            this.f1797a.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1797a.mIsCheckedColumn = str;
            this.f1797a.mLabelColumn = str2;
            this.f1797a.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1797a.mItems = charSequenceArr;
            this.f1797a.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1797a.mCheckedItems = zArr;
            this.f1797a.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mNegativeButtonText = this.f1797a.mContext.getText(i);
            this.f1797a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mNegativeButtonText = charSequence;
            this.f1797a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mNeutralButtonText = this.f1797a.mContext.getText(i);
            this.f1797a.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mNeutralButtonText = charSequence;
            this.f1797a.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f1797a.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f1797a.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f1797a.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f1797a.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mPositiveButtonText = this.f1797a.mContext.getText(i);
            this.f1797a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mPositiveButtonText = charSequence;
            this.f1797a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f1797a.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mItems = this.f1797a.mContext.getResources().getTextArray(i);
            this.f1797a.mOnClickListener = onClickListener;
            this.f1797a.mCheckedItem = i2;
            this.f1797a.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mCursor = cursor;
            this.f1797a.mOnClickListener = onClickListener;
            this.f1797a.mCheckedItem = i;
            this.f1797a.mLabelColumn = str;
            this.f1797a.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mAdapter = listAdapter;
            this.f1797a.mOnClickListener = onClickListener;
            this.f1797a.mCheckedItem = i;
            this.f1797a.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f1797a.mItems = charSequenceArr;
            this.f1797a.mOnClickListener = onClickListener;
            this.f1797a.mCheckedItem = i;
            this.f1797a.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(int i) {
            this.f1797a.mTitle = this.f1797a.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f1797a.mTitle = charSequence;
            return this;
        }

        public Builder setView(int i) {
            this.f1797a.mView = null;
            this.f1797a.mViewLayoutResId = i;
            this.f1797a.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f1797a.mView = view;
            this.f1797a.mViewLayoutResId = 0;
            this.f1797a.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f1797a.mView = view;
            this.f1797a.mViewLayoutResId = 0;
            this.f1797a.mViewSpacingSpecified = true;
            this.f1797a.mViewSpacingLeft = i;
            this.f1797a.mViewSpacingTop = i2;
            this.f1797a.mViewSpacingRight = i3;
            this.f1797a.mViewSpacingBottom = i4;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    AlertDialog(Context context, int i, boolean z) {
        super(context, m1249a(context, i));
    }

    /* renamed from: a */
    static int m1249a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0235R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.f1796a.getButton(i);
    }

    public ListView getListView() {
        return this.f1796a.getListView();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1796a.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1796a.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1796a.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1796a.setButton(i, charSequence, onClickListener, (Message) null);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.f1796a.setButton(i, charSequence, (DialogInterface.OnClickListener) null, message);
    }

    public void setCustomTitle(View view) {
        this.f1796a.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.f1796a.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f1796a.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.f1796a.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.f1796a.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1796a.setTitle(charSequence);
    }

    public void setView(View view) {
        this.f1796a.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.f1796a.setView(view, i, i2, i3, i4);
    }
}
