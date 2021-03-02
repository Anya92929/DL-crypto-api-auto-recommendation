package android.support.p003v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.p003v7.app.AlertController;
import android.support.p003v7.appcompat.C0137R;
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
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    /* access modifiers changed from: private */
    public AlertController mAlert;

    /* renamed from: android.support.v7.app.AlertDialog$Builder */
    public class Builder {

        /* renamed from: P */
        private final AlertController.AlertParams f9P;
        private int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(Context context, int i) {
            this.f9P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f9P.mContext, this.mTheme, false);
            this.f9P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f9P.mCancelable);
            if (this.f9P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f9P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f9P.mOnDismissListener);
            if (this.f9P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f9P.mOnKeyListener);
            }
            return alertDialog;
        }

        public Context getContext() {
            return this.f9P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mAdapter = listAdapter;
            this.f9P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f9P.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.f9P.mCursor = cursor;
            this.f9P.mLabelColumn = str;
            this.f9P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f9P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.f9P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f9P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f9P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f9P.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.f9P.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mItems = this.f9P.mContext.getResources().getTextArray(i);
            this.f9P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mItems = charSequenceArr;
            this.f9P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(int i) {
            this.f9P.mMessage = this.f9P.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f9P.mMessage = charSequence;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f9P.mItems = this.f9P.mContext.getResources().getTextArray(i);
            this.f9P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f9P.mCheckedItems = zArr;
            this.f9P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f9P.mCursor = cursor;
            this.f9P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f9P.mIsCheckedColumn = str;
            this.f9P.mLabelColumn = str2;
            this.f9P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f9P.mItems = charSequenceArr;
            this.f9P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f9P.mCheckedItems = zArr;
            this.f9P.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mNegativeButtonText = this.f9P.mContext.getText(i);
            this.f9P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mNegativeButtonText = charSequence;
            this.f9P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mNeutralButtonText = this.f9P.mContext.getText(i);
            this.f9P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mNeutralButtonText = charSequence;
            this.f9P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f9P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f9P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f9P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f9P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mPositiveButtonText = this.f9P.mContext.getText(i);
            this.f9P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mPositiveButtonText = charSequence;
            this.f9P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f9P.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mItems = this.f9P.mContext.getResources().getTextArray(i);
            this.f9P.mOnClickListener = onClickListener;
            this.f9P.mCheckedItem = i2;
            this.f9P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mCursor = cursor;
            this.f9P.mOnClickListener = onClickListener;
            this.f9P.mCheckedItem = i;
            this.f9P.mLabelColumn = str;
            this.f9P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mAdapter = listAdapter;
            this.f9P.mOnClickListener = onClickListener;
            this.f9P.mCheckedItem = i;
            this.f9P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f9P.mItems = charSequenceArr;
            this.f9P.mOnClickListener = onClickListener;
            this.f9P.mCheckedItem = i;
            this.f9P.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(int i) {
            this.f9P.mTitle = this.f9P.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f9P.mTitle = charSequence;
            return this;
        }

        public Builder setView(int i) {
            this.f9P.mView = null;
            this.f9P.mViewLayoutResId = i;
            this.f9P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f9P.mView = view;
            this.f9P.mViewLayoutResId = 0;
            this.f9P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f9P.mView = view;
            this.f9P.mViewLayoutResId = 0;
            this.f9P.mViewSpacingSpecified = true;
            this.f9P.mViewSpacingLeft = i;
            this.f9P.mViewSpacingTop = i2;
            this.f9P.mViewSpacingRight = i3;
            this.f9P.mViewSpacingBottom = i4;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    protected AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
    }

    protected AlertDialog(Context context, int i) {
        this(context, i, true);
    }

    AlertDialog(Context context, int i, boolean z) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, resolveDialogTheme(context, 0));
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new AlertController(context, this, getWindow());
    }

    static int resolveDialogTheme(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0137R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, (Message) null);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, (DialogInterface.OnClickListener) null, message);
    }

    /* access modifiers changed from: package-private */
    public void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }
}
