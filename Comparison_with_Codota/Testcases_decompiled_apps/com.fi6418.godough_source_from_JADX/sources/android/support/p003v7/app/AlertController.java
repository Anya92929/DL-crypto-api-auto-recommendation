package android.support.p003v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.app.AlertController */
class AlertController {

    /* renamed from: A */
    private TextView f1742A;

    /* renamed from: B */
    private TextView f1743B;

    /* renamed from: C */
    private View f1744C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ListAdapter f1745D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f1746E = -1;

    /* renamed from: F */
    private int f1747F;

    /* renamed from: G */
    private int f1748G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f1749H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f1750I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public int f1751J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f1752K;

    /* renamed from: L */
    private int f1753L = 0;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public Handler f1754M;

    /* renamed from: N */
    private final View.OnClickListener f1755N = new View.OnClickListener() {
        public void onClick(View view) {
            Message obtain = (view != AlertController.this.f1769n || AlertController.this.f1771p == null) ? (view != AlertController.this.f1772q || AlertController.this.f1774s == null) ? (view != AlertController.this.f1775t || AlertController.this.f1777v == null) ? null : Message.obtain(AlertController.this.f1777v) : Message.obtain(AlertController.this.f1774s) : Message.obtain(AlertController.this.f1771p);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.f1754M.obtainMessage(1, AlertController.this.f1757b).sendToTarget();
        }
    };

    /* renamed from: a */
    private final Context f1756a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppCompatDialog f1757b;

    /* renamed from: c */
    private final Window f1758c;

    /* renamed from: d */
    private CharSequence f1759d;

    /* renamed from: e */
    private CharSequence f1760e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ListView f1761f;

    /* renamed from: g */
    private View f1762g;

    /* renamed from: h */
    private int f1763h;

    /* renamed from: i */
    private int f1764i;

    /* renamed from: j */
    private int f1765j;

    /* renamed from: k */
    private int f1766k;

    /* renamed from: l */
    private int f1767l;

    /* renamed from: m */
    private boolean f1768m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Button f1769n;

    /* renamed from: o */
    private CharSequence f1770o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Message f1771p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Button f1772q;

    /* renamed from: r */
    private CharSequence f1773r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Message f1774s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Button f1775t;

    /* renamed from: u */
    private CharSequence f1776u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Message f1777v;

    /* renamed from: w */
    private ScrollView f1778w;

    /* renamed from: x */
    private int f1779x = 0;

    /* renamed from: y */
    private Drawable f1780y;

    /* renamed from: z */
    private ImageView f1781z;

    /* renamed from: android.support.v7.app.AlertController$AlertParams */
    public class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId = 0;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified = false;
        public int mViewSpacingTop;

        /* renamed from: android.support.v7.app.AlertController$AlertParams$OnPrepareListViewListener */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        private void m1248a(final AlertController alertController) {
            ListAdapter checkedItemAdapter;
            final ListView listView = (ListView) this.mInflater.inflate(alertController.f1749H, (ViewGroup) null);
            if (!this.mIsMultiChoice) {
                int k = this.mIsSingleChoice ? alertController.f1751J : alertController.f1752K;
                checkedItemAdapter = this.mCursor == null ? this.mAdapter != null ? this.mAdapter : new CheckedItemAdapter(this.mContext, k, 16908308, this.mItems) : new SimpleCursorAdapter(this.mContext, k, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
            } else if (this.mCursor == null) {
                checkedItemAdapter = new ArrayAdapter<CharSequence>(this.mContext, alertController.f1750I, 16908308, this.mItems) {
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (AlertParams.this.mCheckedItems != null && AlertParams.this.mCheckedItems[i]) {
                            listView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final AlertController alertController2 = alertController;
                checkedItemAdapter = new CursorAdapter(this.mContext, this.mCursor, false) {

                    /* renamed from: d */
                    private final int f1788d;

                    /* renamed from: e */
                    private final int f1789e;

                    {
                        Cursor cursor = getCursor();
                        this.f1788d = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                        this.f1789e = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                    }

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1788d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1789e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.mInflater.inflate(alertController2.f1750I, viewGroup, false);
                    }
                };
            }
            if (this.mOnPrepareListViewListener != null) {
                this.mOnPrepareListViewListener.onPrepareListView(listView);
            }
            ListAdapter unused = alertController.f1745D = checkedItemAdapter;
            int unused2 = alertController.f1746E = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AlertParams.this.mOnClickListener.onClick(alertController.f1757b, i);
                        if (!AlertParams.this.mIsSingleChoice) {
                            alertController.f1757b.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[i] = listView.isItemChecked(i);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f1757b, i, listView.isItemChecked(i));
                    }
                });
            }
            if (this.mOnItemSelectedListener != null) {
                listView.setOnItemSelectedListener(this.mOnItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                listView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                listView.setChoiceMode(2);
            }
            ListView unused3 = alertController.f1761f = listView;
        }

        public void apply(AlertController alertController) {
            if (this.mCustomTitleView != null) {
                alertController.setCustomTitle(this.mCustomTitleView);
            } else {
                if (this.mTitle != null) {
                    alertController.setTitle(this.mTitle);
                }
                if (this.mIcon != null) {
                    alertController.setIcon(this.mIcon);
                }
                if (this.mIconId != 0) {
                    alertController.setIcon(this.mIconId);
                }
                if (this.mIconAttrId != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(this.mIconAttrId));
                }
            }
            if (this.mMessage != null) {
                alertController.setMessage(this.mMessage);
            }
            if (this.mPositiveButtonText != null) {
                alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, (Message) null);
            }
            if (this.mNegativeButtonText != null) {
                alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, (Message) null);
            }
            if (this.mNeutralButtonText != null) {
                alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, (Message) null);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                m1248a(alertController);
            }
            if (this.mView != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                }
                alertController.setView(this.mView);
            } else if (this.mViewLayoutResId != 0) {
                alertController.setView(this.mViewLayoutResId);
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$ButtonHandler */
    final class ButtonHandler extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f1795a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f1795a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1795a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$CheckedItemAdapter */
    class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f1756a = context;
        this.f1757b = appCompatDialog;
        this.f1758c = window;
        this.f1754M = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, C0235R.styleable.AlertDialog, C0235R.attr.alertDialogStyle, 0);
        this.f1747F = obtainStyledAttributes.getResourceId(C0235R.styleable.AlertDialog_android_layout, 0);
        this.f1748G = obtainStyledAttributes.getResourceId(C0235R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f1749H = obtainStyledAttributes.getResourceId(C0235R.styleable.AlertDialog_listLayout, 0);
        this.f1750I = obtainStyledAttributes.getResourceId(C0235R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f1751J = obtainStyledAttributes.getResourceId(C0235R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f1752K = obtainStyledAttributes.getResourceId(C0235R.styleable.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private int m1225a() {
        return this.f1748G == 0 ? this.f1747F : this.f1753L == 1 ? this.f1748G : this.f1747F;
    }

    /* renamed from: a */
    private void m1230a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private static boolean m1231a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0235R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    /* renamed from: a */
    static boolean m1232a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m1232a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m1233a(ViewGroup viewGroup) {
        if (this.f1744C != null) {
            viewGroup.addView(this.f1744C, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1758c.findViewById(C0235R.C0237id.title_template).setVisibility(8);
            return true;
        }
        this.f1781z = (ImageView) this.f1758c.findViewById(16908294);
        if (!TextUtils.isEmpty(this.f1759d)) {
            this.f1742A = (TextView) this.f1758c.findViewById(C0235R.C0237id.alertTitle);
            this.f1742A.setText(this.f1759d);
            if (this.f1779x != 0) {
                this.f1781z.setImageResource(this.f1779x);
                return true;
            } else if (this.f1780y != null) {
                this.f1781z.setImageDrawable(this.f1780y);
                return true;
            } else {
                this.f1742A.setPadding(this.f1781z.getPaddingLeft(), this.f1781z.getPaddingTop(), this.f1781z.getPaddingRight(), this.f1781z.getPaddingBottom());
                this.f1781z.setVisibility(8);
                return true;
            }
        } else {
            this.f1758c.findViewById(C0235R.C0237id.title_template).setVisibility(8);
            this.f1781z.setVisibility(8);
            viewGroup.setVisibility(8);
            return false;
        }
    }

    /* renamed from: b */
    private void m1235b() {
        boolean z = false;
        m1236b((ViewGroup) this.f1758c.findViewById(C0235R.C0237id.contentPanel));
        boolean c = m1238c();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f1756a, (AttributeSet) null, C0235R.styleable.AlertDialog, C0235R.attr.alertDialogStyle, 0);
        m1233a((ViewGroup) this.f1758c.findViewById(C0235R.C0237id.topPanel));
        View findViewById = this.f1758c.findViewById(C0235R.C0237id.buttonPanel);
        if (!c) {
            findViewById.setVisibility(8);
            View findViewById2 = this.f1758c.findViewById(C0235R.C0237id.textSpacerNoButtons);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        FrameLayout frameLayout = (FrameLayout) this.f1758c.findViewById(C0235R.C0237id.customPanel);
        View inflate = this.f1762g != null ? this.f1762g : this.f1763h != 0 ? LayoutInflater.from(this.f1756a).inflate(this.f1763h, frameLayout, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!z || !m1232a(inflate)) {
            this.f1758c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout2 = (FrameLayout) this.f1758c.findViewById(C0235R.C0237id.custom);
            frameLayout2.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f1768m) {
                frameLayout2.setPadding(this.f1764i, this.f1765j, this.f1766k, this.f1767l);
            }
            if (this.f1761f != null) {
                ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = BitmapDescriptorFactory.HUE_RED;
            }
        } else {
            frameLayout.setVisibility(8);
        }
        ListView listView = this.f1761f;
        if (!(listView == null || this.f1745D == null)) {
            listView.setAdapter(this.f1745D);
            int i = this.f1746E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private void m1236b(ViewGroup viewGroup) {
        this.f1778w = (ScrollView) this.f1758c.findViewById(C0235R.C0237id.scrollView);
        this.f1778w.setFocusable(false);
        this.f1743B = (TextView) this.f1758c.findViewById(16908299);
        if (this.f1743B != null) {
            if (this.f1760e != null) {
                this.f1743B.setText(this.f1760e);
                return;
            }
            this.f1743B.setVisibility(8);
            this.f1778w.removeView(this.f1743B);
            if (this.f1761f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1778w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1778w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1761f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: c */
    private boolean m1238c() {
        boolean z;
        this.f1769n = (Button) this.f1758c.findViewById(16908313);
        this.f1769n.setOnClickListener(this.f1755N);
        if (TextUtils.isEmpty(this.f1770o)) {
            this.f1769n.setVisibility(8);
            z = false;
        } else {
            this.f1769n.setText(this.f1770o);
            this.f1769n.setVisibility(0);
            z = true;
        }
        this.f1772q = (Button) this.f1758c.findViewById(16908314);
        this.f1772q.setOnClickListener(this.f1755N);
        if (TextUtils.isEmpty(this.f1773r)) {
            this.f1772q.setVisibility(8);
        } else {
            this.f1772q.setText(this.f1773r);
            this.f1772q.setVisibility(0);
            z |= true;
        }
        this.f1775t = (Button) this.f1758c.findViewById(16908315);
        this.f1775t.setOnClickListener(this.f1755N);
        if (TextUtils.isEmpty(this.f1776u)) {
            this.f1775t.setVisibility(8);
        } else {
            this.f1775t.setText(this.f1776u);
            this.f1775t.setVisibility(0);
            z |= true;
        }
        if (m1231a(this.f1756a)) {
            if (z) {
                m1230a(this.f1769n);
            } else if (z) {
                m1230a(this.f1772q);
            } else if (z) {
                m1230a(this.f1775t);
            }
        }
        return z;
    }

    public Button getButton(int i) {
        switch (i) {
            case -3:
                return this.f1775t;
            case -2:
                return this.f1772q;
            case -1:
                return this.f1769n;
            default:
                return null;
        }
    }

    public int getIconAttributeResId(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1756a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.f1761f;
    }

    public void installContent() {
        this.f1757b.supportRequestWindowFeature(1);
        this.f1757b.setContentView(m1225a());
        m1235b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1778w != null && this.f1778w.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1778w != null && this.f1778w.executeKeyEvent(keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1754M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1776u = charSequence;
                this.f1777v = message;
                return;
            case -2:
                this.f1773r = charSequence;
                this.f1774s = message;
                return;
            case -1:
                this.f1770o = charSequence;
                this.f1771p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setButtonPanelLayoutHint(int i) {
        this.f1753L = i;
    }

    public void setCustomTitle(View view) {
        this.f1744C = view;
    }

    public void setIcon(int i) {
        this.f1780y = null;
        this.f1779x = i;
        if (this.f1781z == null) {
            return;
        }
        if (i != 0) {
            this.f1781z.setImageResource(this.f1779x);
        } else {
            this.f1781z.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1780y = drawable;
        this.f1779x = 0;
        if (this.f1781z == null) {
            return;
        }
        if (drawable != null) {
            this.f1781z.setImageDrawable(drawable);
        } else {
            this.f1781z.setVisibility(8);
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.f1760e = charSequence;
        if (this.f1743B != null) {
            this.f1743B.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f1759d = charSequence;
        if (this.f1742A != null) {
            this.f1742A.setText(charSequence);
        }
    }

    public void setView(int i) {
        this.f1762g = null;
        this.f1763h = i;
        this.f1768m = false;
    }

    public void setView(View view) {
        this.f1762g = view;
        this.f1763h = 0;
        this.f1768m = false;
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.f1762g = view;
        this.f1763h = 0;
        this.f1768m = true;
        this.f1764i = i;
        this.f1765j = i2;
        this.f1766k = i3;
        this.f1767l = i4;
    }
}
