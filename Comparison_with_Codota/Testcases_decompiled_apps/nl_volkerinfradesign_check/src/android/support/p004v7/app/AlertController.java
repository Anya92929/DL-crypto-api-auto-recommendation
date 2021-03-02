package android.support.p004v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.NestedScrollView;
import android.support.p004v7.appcompat.C0505R;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
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
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import org.apache.commons.collections4.trie.KeyAnalyzer;

/* renamed from: android.support.v7.app.AlertController */
class AlertController {

    /* renamed from: A */
    private TextView f1424A;

    /* renamed from: B */
    private TextView f1425B;

    /* renamed from: C */
    private View f1426C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ListAdapter f1427D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f1428E = -1;

    /* renamed from: F */
    private int f1429F;

    /* renamed from: G */
    private int f1430G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f1431H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f1432I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public int f1433J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f1434K;

    /* renamed from: L */
    private int f1435L = 0;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public Handler f1436M;

    /* renamed from: N */
    private final View.OnClickListener f1437N = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            if (view == AlertController.this.f1451n && AlertController.this.f1453p != null) {
                message = Message.obtain(AlertController.this.f1453p);
            } else if (view == AlertController.this.f1454q && AlertController.this.f1456s != null) {
                message = Message.obtain(AlertController.this.f1456s);
            } else if (view != AlertController.this.f1457t || AlertController.this.f1459v == null) {
                message = null;
            } else {
                message = Message.obtain(AlertController.this.f1459v);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.f1436M.obtainMessage(1, AlertController.this.f1439b).sendToTarget();
        }
    };

    /* renamed from: a */
    private final Context f1438a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppCompatDialog f1439b;

    /* renamed from: c */
    private final Window f1440c;

    /* renamed from: d */
    private CharSequence f1441d;

    /* renamed from: e */
    private CharSequence f1442e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ListView f1443f;

    /* renamed from: g */
    private View f1444g;

    /* renamed from: h */
    private int f1445h;

    /* renamed from: i */
    private int f1446i;

    /* renamed from: j */
    private int f1447j;

    /* renamed from: k */
    private int f1448k;

    /* renamed from: l */
    private int f1449l;

    /* renamed from: m */
    private boolean f1450m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Button f1451n;

    /* renamed from: o */
    private CharSequence f1452o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Message f1453p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Button f1454q;

    /* renamed from: r */
    private CharSequence f1455r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Message f1456s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Button f1457t;

    /* renamed from: u */
    private CharSequence f1458u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Message f1459v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public NestedScrollView f1460w;

    /* renamed from: x */
    private int f1461x = 0;

    /* renamed from: y */
    private Drawable f1462y;

    /* renamed from: z */
    private ImageView f1463z;

    /* renamed from: android.support.v7.app.AlertController$a */
    static final class C0483a extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f1489a;

        public C0483a(DialogInterface dialogInterface) {
            this.f1489a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case KeyAnalyzer.OUT_OF_BOUNDS_BIT_KEY /*-3*/:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1489a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f1438a = context;
        this.f1439b = appCompatDialog;
        this.f1440c = window;
        this.f1436M = new C0483a(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, C0505R.styleable.AlertDialog, C0505R.attr.alertDialogStyle, 0);
        this.f1429F = obtainStyledAttributes.getResourceId(C0505R.styleable.AlertDialog_android_layout, 0);
        this.f1430G = obtainStyledAttributes.getResourceId(C0505R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f1431H = obtainStyledAttributes.getResourceId(C0505R.styleable.AlertDialog_listLayout, 0);
        this.f1432I = obtainStyledAttributes.getResourceId(C0505R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f1433J = obtainStyledAttributes.getResourceId(C0505R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f1434K = obtainStyledAttributes.getResourceId(C0505R.styleable.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    static boolean m2864a(View view) {
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
            if (m2864a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo3202a() {
        this.f1439b.supportRequestWindowFeature(1);
        this.f1439b.setContentView(m2868c());
        m2872d();
    }

    /* renamed from: c */
    private int m2868c() {
        if (this.f1430G == 0) {
            return this.f1429F;
        }
        if (this.f1435L == 1) {
            return this.f1430G;
        }
        return this.f1429F;
    }

    /* renamed from: a */
    public void mo3207a(CharSequence charSequence) {
        this.f1441d = charSequence;
        if (this.f1424A != null) {
            this.f1424A.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void mo3211b(View view) {
        this.f1426C = view;
    }

    /* renamed from: b */
    public void mo3212b(CharSequence charSequence) {
        this.f1442e = charSequence;
        if (this.f1425B != null) {
            this.f1425B.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void mo3203a(int i) {
        this.f1444g = null;
        this.f1445h = i;
        this.f1450m = false;
    }

    /* renamed from: c */
    public void mo3215c(View view) {
        this.f1444g = view;
        this.f1445h = 0;
        this.f1450m = false;
    }

    /* renamed from: a */
    public void mo3206a(View view, int i, int i2, int i3, int i4) {
        this.f1444g = view;
        this.f1445h = 0;
        this.f1450m = true;
        this.f1446i = i;
        this.f1447j = i2;
        this.f1448k = i3;
        this.f1449l = i4;
    }

    /* renamed from: a */
    public void mo3204a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1436M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case KeyAnalyzer.OUT_OF_BOUNDS_BIT_KEY /*-3*/:
                this.f1458u = charSequence;
                this.f1459v = message;
                return;
            case -2:
                this.f1455r = charSequence;
                this.f1456s = message;
                return;
            case -1:
                this.f1452o = charSequence;
                this.f1453p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void mo3210b(int i) {
        this.f1462y = null;
        this.f1461x = i;
        if (this.f1463z == null) {
            return;
        }
        if (i != 0) {
            this.f1463z.setImageResource(this.f1461x);
        } else {
            this.f1463z.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo3205a(Drawable drawable) {
        this.f1462y = drawable;
        this.f1461x = 0;
        if (this.f1463z == null) {
            return;
        }
        if (drawable != null) {
            this.f1463z.setImageDrawable(drawable);
        } else {
            this.f1463z.setVisibility(8);
        }
    }

    /* renamed from: c */
    public int mo3214c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1438a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: b */
    public ListView mo3209b() {
        return this.f1443f;
    }

    /* renamed from: d */
    public Button mo3216d(int i) {
        switch (i) {
            case KeyAnalyzer.OUT_OF_BOUNDS_BIT_KEY /*-3*/:
                return this.f1457t;
            case -2:
                return this.f1454q;
            case -1:
                return this.f1451n;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public boolean mo3208a(int i, KeyEvent keyEvent) {
        return this.f1460w != null && this.f1460w.executeKeyEvent(keyEvent);
    }

    /* renamed from: b */
    public boolean mo3213b(int i, KeyEvent keyEvent) {
        return this.f1460w != null && this.f1460w.executeKeyEvent(keyEvent);
    }

    @Nullable
    /* renamed from: a */
    private ViewGroup m2857a(@Nullable View view, @Nullable View view2) {
        View view3;
        View view4;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view4 = ((ViewStub) view2).inflate();
            } else {
                view4 = view2;
            }
            return (ViewGroup) view4;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view3 = ((ViewStub) view).inflate();
        } else {
            view3 = view;
        }
        return (ViewGroup) view3;
    }

    /* renamed from: d */
    private void m2872d() {
        boolean z;
        boolean z2;
        int i;
        View findViewById;
        View findViewById2 = this.f1440c.findViewById(C0505R.C0507id.parentPanel);
        View findViewById3 = findViewById2.findViewById(C0505R.C0507id.topPanel);
        View findViewById4 = findViewById2.findViewById(C0505R.C0507id.contentPanel);
        View findViewById5 = findViewById2.findViewById(C0505R.C0507id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(C0505R.C0507id.customPanel);
        m2862a(viewGroup);
        View findViewById6 = viewGroup.findViewById(C0505R.C0507id.topPanel);
        View findViewById7 = viewGroup.findViewById(C0505R.C0507id.contentPanel);
        View findViewById8 = viewGroup.findViewById(C0505R.C0507id.buttonPanel);
        ViewGroup a = m2857a(findViewById6, findViewById3);
        ViewGroup a2 = m2857a(findViewById7, findViewById4);
        ViewGroup a3 = m2857a(findViewById8, findViewById5);
        m2870c(a2);
        m2873d(a3);
        m2867b(a);
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        if (a == null || a.getVisibility() == 8) {
            z = false;
        } else {
            z = true;
        }
        if (a3 == null || a3.getVisibility() == 8) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z2 || a2 == null || (findViewById = a2.findViewById(C0505R.C0507id.textSpacerNoButtons)) == null)) {
            findViewById.setVisibility(0);
        }
        if (z && this.f1460w != null) {
            this.f1460w.setClipToPadding(true);
        }
        if (!z3) {
            ViewGroup viewGroup2 = this.f1443f != null ? this.f1443f : this.f1460w;
            if (viewGroup2 != null) {
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                m2863a(a2, (View) viewGroup2, (z2 ? 2 : 0) | i, 3);
            }
        }
        ListView listView = this.f1443f;
        if (listView != null && this.f1427D != null) {
            listView.setAdapter(this.f1427D);
            int i2 = this.f1428E;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    /* renamed from: a */
    private void m2863a(ViewGroup viewGroup, View view, int i, int i2) {
        final View view2 = null;
        final View findViewById = this.f1440c.findViewById(C0505R.C0507id.scrollIndicatorUp);
        View findViewById2 = this.f1440c.findViewById(C0505R.C0507id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1442e != null) {
                this.f1460w.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m2866b(nestedScrollView, findViewById, view2);
                    }
                });
                this.f1460w.post(new Runnable() {
                    public void run() {
                        AlertController.m2866b(AlertController.this.f1460w, findViewById, view2);
                    }
                });
            } else if (this.f1443f != null) {
                this.f1443f.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m2866b(absListView, findViewById, view2);
                    }
                });
                this.f1443f.post(new Runnable() {
                    public void run() {
                        AlertController.m2866b(AlertController.this.f1443f, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m2862a(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.f1444g != null) {
            view = this.f1444g;
        } else if (this.f1445h != 0) {
            view = LayoutInflater.from(this.f1438a).inflate(this.f1445h, viewGroup, false);
        } else {
            view = null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !m2864a(view)) {
            this.f1440c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1440c.findViewById(C0505R.C0507id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f1450m) {
                frameLayout.setPadding(this.f1446i, this.f1447j, this.f1448k, this.f1449l);
            }
            if (this.f1443f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = BitmapDescriptorFactory.HUE_RED;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: b */
    private void m2867b(ViewGroup viewGroup) {
        if (this.f1426C != null) {
            viewGroup.addView(this.f1426C, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1440c.findViewById(C0505R.C0507id.title_template).setVisibility(8);
            return;
        }
        this.f1463z = (ImageView) this.f1440c.findViewById(16908294);
        if (!TextUtils.isEmpty(this.f1441d)) {
            this.f1424A = (TextView) this.f1440c.findViewById(C0505R.C0507id.alertTitle);
            this.f1424A.setText(this.f1441d);
            if (this.f1461x != 0) {
                this.f1463z.setImageResource(this.f1461x);
            } else if (this.f1462y != null) {
                this.f1463z.setImageDrawable(this.f1462y);
            } else {
                this.f1424A.setPadding(this.f1463z.getPaddingLeft(), this.f1463z.getPaddingTop(), this.f1463z.getPaddingRight(), this.f1463z.getPaddingBottom());
                this.f1463z.setVisibility(8);
            }
        } else {
            this.f1440c.findViewById(C0505R.C0507id.title_template).setVisibility(8);
            this.f1463z.setVisibility(8);
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m2870c(ViewGroup viewGroup) {
        this.f1460w = (NestedScrollView) this.f1440c.findViewById(C0505R.C0507id.scrollView);
        this.f1460w.setFocusable(false);
        this.f1460w.setNestedScrollingEnabled(false);
        this.f1425B = (TextView) viewGroup.findViewById(16908299);
        if (this.f1425B != null) {
            if (this.f1442e != null) {
                this.f1425B.setText(this.f1442e);
                return;
            }
            this.f1425B.setVisibility(8);
            this.f1460w.removeView(this.f1425B);
            if (this.f1443f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1460w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1460w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1443f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2866b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ViewCompat.canScrollVertically(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ViewCompat.canScrollVertically(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: d */
    private void m2873d(ViewGroup viewGroup) {
        boolean z;
        boolean z2 = true;
        this.f1451n = (Button) viewGroup.findViewById(16908313);
        this.f1451n.setOnClickListener(this.f1437N);
        if (TextUtils.isEmpty(this.f1452o)) {
            this.f1451n.setVisibility(8);
            z = false;
        } else {
            this.f1451n.setText(this.f1452o);
            this.f1451n.setVisibility(0);
            z = true;
        }
        this.f1454q = (Button) viewGroup.findViewById(16908314);
        this.f1454q.setOnClickListener(this.f1437N);
        if (TextUtils.isEmpty(this.f1455r)) {
            this.f1454q.setVisibility(8);
        } else {
            this.f1454q.setText(this.f1455r);
            this.f1454q.setVisibility(0);
            z |= true;
        }
        this.f1457t = (Button) viewGroup.findViewById(16908315);
        this.f1457t.setOnClickListener(this.f1437N);
        if (TextUtils.isEmpty(this.f1458u)) {
            this.f1457t.setVisibility(8);
        } else {
            this.f1457t.setText(this.f1458u);
            this.f1457t.setVisibility(0);
            z |= true;
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$AlertParams */
    public static class AlertParams {
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

        public void apply(AlertController alertController) {
            if (this.mCustomTitleView != null) {
                alertController.mo3211b(this.mCustomTitleView);
            } else {
                if (this.mTitle != null) {
                    alertController.mo3207a(this.mTitle);
                }
                if (this.mIcon != null) {
                    alertController.mo3205a(this.mIcon);
                }
                if (this.mIconId != 0) {
                    alertController.mo3210b(this.mIconId);
                }
                if (this.mIconAttrId != 0) {
                    alertController.mo3210b(alertController.mo3214c(this.mIconAttrId));
                }
            }
            if (this.mMessage != null) {
                alertController.mo3212b(this.mMessage);
            }
            if (this.mPositiveButtonText != null) {
                alertController.mo3204a(-1, this.mPositiveButtonText, this.mPositiveButtonListener, (Message) null);
            }
            if (this.mNegativeButtonText != null) {
                alertController.mo3204a(-2, this.mNegativeButtonText, this.mNegativeButtonListener, (Message) null);
            }
            if (this.mNeutralButtonText != null) {
                alertController.mo3204a(-3, this.mNeutralButtonText, this.mNeutralButtonListener, (Message) null);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                m2899a(alertController);
            }
            if (this.mView != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.mo3206a(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                }
                alertController.mo3215c(this.mView);
            } else if (this.mViewLayoutResId != 0) {
                alertController.mo3203a(this.mViewLayoutResId);
            }
        }

        /* renamed from: a */
        private void m2899a(final AlertController alertController) {
            int n;
            ListAdapter bVar;
            final ListView listView = (ListView) this.mInflater.inflate(alertController.f1431H, (ViewGroup) null);
            if (!this.mIsMultiChoice) {
                if (this.mIsSingleChoice) {
                    n = alertController.f1433J;
                } else {
                    n = alertController.f1434K;
                }
                if (this.mCursor != null) {
                    bVar = new SimpleCursorAdapter(this.mContext, n, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
                } else if (this.mAdapter != null) {
                    bVar = this.mAdapter;
                } else {
                    bVar = new C0484b(this.mContext, n, 16908308, this.mItems);
                }
            } else if (this.mCursor == null) {
                bVar = new ArrayAdapter<CharSequence>(this.mContext, alertController.f1432I, 16908308, this.mItems) {
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
                bVar = new CursorAdapter(this.mContext, this.mCursor, false) {

                    /* renamed from: d */
                    private final int f1482d;

                    /* renamed from: e */
                    private final int f1483e;

                    {
                        Cursor cursor = getCursor();
                        this.f1482d = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                        this.f1483e = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                    }

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1482d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1483e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.mInflater.inflate(alertController2.f1432I, viewGroup, false);
                    }
                };
            }
            if (this.mOnPrepareListViewListener != null) {
                this.mOnPrepareListViewListener.onPrepareListView(listView);
            }
            ListAdapter unused = alertController.f1427D = bVar;
            int unused2 = alertController.f1428E = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AlertParams.this.mOnClickListener.onClick(alertController.f1439b, i);
                        if (!AlertParams.this.mIsSingleChoice) {
                            alertController.f1439b.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[i] = listView.isItemChecked(i);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f1439b, i, listView.isItemChecked(i));
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
            ListView unused3 = alertController.f1443f = listView;
        }
    }

    /* renamed from: android.support.v7.app.AlertController$b */
    static class C0484b extends ArrayAdapter<CharSequence> {
        public C0484b(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }
}
