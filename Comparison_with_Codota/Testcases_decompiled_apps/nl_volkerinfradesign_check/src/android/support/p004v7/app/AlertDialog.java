package android.support.p004v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.p004v7.app.AlertController;
import android.support.p004v7.appcompat.C0505R;
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
    public AlertController f1490a;

    protected AlertDialog(Context context) {
        this(context, m2900a(context, 0), true);
    }

    protected AlertDialog(Context context, int i) {
        this(context, i, true);
    }

    AlertDialog(Context context, int i, boolean z) {
        super(context, m2900a(context, i));
        this.f1490a = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, m2900a(context, 0));
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.f1490a = new AlertController(context, this, getWindow());
    }

    /* renamed from: a */
    static int m2900a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0505R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.f1490a.mo3216d(i);
    }

    public ListView getListView() {
        return this.f1490a.mo3209b();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1490a.mo3207a(charSequence);
    }

    public void setCustomTitle(View view) {
        this.f1490a.mo3211b(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.f1490a.mo3212b(charSequence);
    }

    public void setView(View view) {
        this.f1490a.mo3215c(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.f1490a.mo3206a(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.f1490a.mo3204a(i, charSequence, (DialogInterface.OnClickListener) null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1490a.mo3204a(i, charSequence, onClickListener, (Message) null);
    }

    public void setIcon(int i) {
        this.f1490a.mo3210b(i);
    }

    public void setIcon(Drawable drawable) {
        this.f1490a.mo3205a(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.f1490a.mo3210b(typedValue.resourceId);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1490a.mo3202a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1490a.mo3208a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1490a.mo3213b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: android.support.v7.app.AlertDialog$Builder */
    public static class Builder {

        /* renamed from: a */
        private final AlertController.AlertParams f1491a;

        /* renamed from: b */
        private int f1492b;

        public Builder(Context context) {
            this(context, AlertDialog.m2900a(context, 0));
        }

        public Builder(Context context, int i) {
            this.f1491a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.m2900a(context, i)));
            this.f1492b = i;
        }

        public Context getContext() {
            return this.f1491a.mContext;
        }

        public Builder setTitle(int i) {
            this.f1491a.mTitle = this.f1491a.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f1491a.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f1491a.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            this.f1491a.mMessage = this.f1491a.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f1491a.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.f1491a.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f1491a.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f1491a.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f1491a.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mPositiveButtonText = this.f1491a.mContext.getText(i);
            this.f1491a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mPositiveButtonText = charSequence;
            this.f1491a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mNegativeButtonText = this.f1491a.mContext.getText(i);
            this.f1491a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mNegativeButtonText = charSequence;
            this.f1491a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mNeutralButtonText = this.f1491a.mContext.getText(i);
            this.f1491a.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mNeutralButtonText = charSequence;
            this.f1491a.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f1491a.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f1491a.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f1491a.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f1491a.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mItems = this.f1491a.mContext.getResources().getTextArray(i);
            this.f1491a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mItems = charSequenceArr;
            this.f1491a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mAdapter = listAdapter;
            this.f1491a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.f1491a.mCursor = cursor;
            this.f1491a.mLabelColumn = str;
            this.f1491a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1491a.mItems = this.f1491a.mContext.getResources().getTextArray(i);
            this.f1491a.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1491a.mCheckedItems = zArr;
            this.f1491a.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1491a.mItems = charSequenceArr;
            this.f1491a.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1491a.mCheckedItems = zArr;
            this.f1491a.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1491a.mCursor = cursor;
            this.f1491a.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1491a.mIsCheckedColumn = str;
            this.f1491a.mLabelColumn = str2;
            this.f1491a.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mItems = this.f1491a.mContext.getResources().getTextArray(i);
            this.f1491a.mOnClickListener = onClickListener;
            this.f1491a.mCheckedItem = i2;
            this.f1491a.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mCursor = cursor;
            this.f1491a.mOnClickListener = onClickListener;
            this.f1491a.mCheckedItem = i;
            this.f1491a.mLabelColumn = str;
            this.f1491a.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mItems = charSequenceArr;
            this.f1491a.mOnClickListener = onClickListener;
            this.f1491a.mCheckedItem = i;
            this.f1491a.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f1491a.mAdapter = listAdapter;
            this.f1491a.mOnClickListener = onClickListener;
            this.f1491a.mCheckedItem = i;
            this.f1491a.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f1491a.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.f1491a.mView = null;
            this.f1491a.mViewLayoutResId = i;
            this.f1491a.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f1491a.mView = view;
            this.f1491a.mViewLayoutResId = 0;
            this.f1491a.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f1491a.mView = view;
            this.f1491a.mViewLayoutResId = 0;
            this.f1491a.mViewSpacingSpecified = true;
            this.f1491a.mViewSpacingLeft = i;
            this.f1491a.mViewSpacingTop = i2;
            this.f1491a.mViewSpacingRight = i3;
            this.f1491a.mViewSpacingBottom = i4;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.f1491a.mForceInverseBackground = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f1491a.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f1491a.mContext, this.f1492b, false);
            this.f1491a.apply(alertDialog.f1490a);
            alertDialog.setCancelable(this.f1491a.mCancelable);
            if (this.f1491a.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1491a.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f1491a.mOnDismissListener);
            if (this.f1491a.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f1491a.mOnKeyListener);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }
}
