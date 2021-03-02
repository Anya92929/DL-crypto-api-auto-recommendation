package android.support.p000v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: android.support.v4.app.DialogFragment */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;

    /* renamed from: a */
    int f348a = 0;

    /* renamed from: b */
    int f349b = 0;

    /* renamed from: c */
    boolean f350c = true;

    /* renamed from: d */
    boolean f351d = true;

    /* renamed from: e */
    int f352e = -1;

    /* renamed from: f */
    Dialog f353f;

    /* renamed from: g */
    boolean f354g;

    /* renamed from: h */
    boolean f355h;

    /* renamed from: i */
    boolean f356i;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo466a(boolean z) {
        if (!this.f355h) {
            this.f355h = true;
            this.f356i = false;
            if (this.f353f != null) {
                this.f353f.dismiss();
                this.f353f = null;
            }
            this.f354g = true;
            if (this.f352e >= 0) {
                getFragmentManager().popBackStack(this.f352e, 1);
                this.f352e = -1;
                return;
            }
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            if (z) {
                beginTransaction.commitAllowingStateLoss();
            } else {
                beginTransaction.commit();
            }
        }
    }

    public void dismiss() {
        mo466a(false);
    }

    public void dismissAllowingStateLoss() {
        mo466a(true);
    }

    public Dialog getDialog() {
        return this.f353f;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (!this.f351d) {
            return super.getLayoutInflater(bundle);
        }
        this.f353f = onCreateDialog(bundle);
        if (this.f353f == null) {
            return (LayoutInflater) this.f362D.mo696b().getSystemService("layout_inflater");
        }
        setupDialog(this.f353f, this.f348a);
        return (LayoutInflater) this.f353f.getContext().getSystemService("layout_inflater");
    }

    public boolean getShowsDialog() {
        return this.f351d;
    }

    public int getTheme() {
        return this.f349b;
    }

    public boolean isCancelable() {
        return this.f350c;
    }

    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.f351d) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f353f.setContentView(view);
            }
            this.f353f.setOwnerActivity(getActivity());
            this.f353f.setCancelable(this.f350c);
            this.f353f.setOnCancelListener(this);
            this.f353f.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.f353f.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.f356i) {
            this.f355h = false;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f351d = this.f366H == 0;
        if (bundle != null) {
            this.f348a = bundle.getInt("android:style", 0);
            this.f349b = bundle.getInt("android:theme", 0);
            this.f350c = bundle.getBoolean("android:cancelable", true);
            this.f351d = bundle.getBoolean("android:showsDialog", this.f351d);
            this.f352e = bundle.getInt("android:backStackId", -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(getActivity(), getTheme());
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f353f != null) {
            this.f354g = true;
            this.f353f.dismiss();
            this.f353f = null;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.f356i && !this.f355h) {
            this.f355h = true;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f354g) {
            mo466a(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.onSaveInstanceState(bundle);
        if (!(this.f353f == null || (onSaveInstanceState = this.f353f.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        if (this.f348a != 0) {
            bundle.putInt("android:style", this.f348a);
        }
        if (this.f349b != 0) {
            bundle.putInt("android:theme", this.f349b);
        }
        if (!this.f350c) {
            bundle.putBoolean("android:cancelable", this.f350c);
        }
        if (!this.f351d) {
            bundle.putBoolean("android:showsDialog", this.f351d);
        }
        if (this.f352e != -1) {
            bundle.putInt("android:backStackId", this.f352e);
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f353f != null) {
            this.f354g = false;
            this.f353f.show();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f353f != null) {
            this.f353f.hide();
        }
    }

    public void setCancelable(boolean z) {
        this.f350c = z;
        if (this.f353f != null) {
            this.f353f.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.f351d = z;
    }

    public void setStyle(int i, int i2) {
        this.f348a = i;
        if (this.f348a == 2 || this.f348a == 3) {
            this.f349b = 16973913;
        }
        if (i2 != 0) {
            this.f349b = i2;
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        this.f355h = false;
        this.f356i = true;
        fragmentTransaction.add((Fragment) this, str);
        this.f354g = false;
        this.f352e = fragmentTransaction.commit();
        return this.f352e;
    }

    public void show(FragmentManager fragmentManager, String str) {
        this.f355h = false;
        this.f356i = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commit();
    }
}
