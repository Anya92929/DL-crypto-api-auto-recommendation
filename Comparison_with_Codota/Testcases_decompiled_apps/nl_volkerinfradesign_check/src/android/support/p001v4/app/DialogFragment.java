package android.support.p001v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: android.support.v4.app.DialogFragment */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;

    /* renamed from: a */
    int f113a = 0;

    /* renamed from: b */
    int f114b = 0;

    /* renamed from: c */
    boolean f115c = true;

    /* renamed from: d */
    boolean f116d = true;

    /* renamed from: e */
    int f117e = -1;

    /* renamed from: f */
    Dialog f118f;

    /* renamed from: g */
    boolean f119g;

    /* renamed from: h */
    boolean f120h;

    /* renamed from: i */
    boolean f121i;

    public void setStyle(int i, @StyleRes int i2) {
        this.f113a = i;
        if (this.f113a == 2 || this.f113a == 3) {
            this.f114b = 16973913;
        }
        if (i2 != 0) {
            this.f114b = i2;
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        this.f120h = false;
        this.f121i = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commit();
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        this.f120h = false;
        this.f121i = true;
        fragmentTransaction.add((Fragment) this, str);
        this.f119g = false;
        this.f117e = fragmentTransaction.commit();
        return this.f117e;
    }

    public void dismiss() {
        mo169a(false);
    }

    public void dismissAllowingStateLoss() {
        mo169a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169a(boolean z) {
        if (!this.f120h) {
            this.f120h = true;
            this.f121i = false;
            if (this.f118f != null) {
                this.f118f.dismiss();
                this.f118f = null;
            }
            this.f119g = true;
            if (this.f117e >= 0) {
                getFragmentManager().popBackStack(this.f117e, 1);
                this.f117e = -1;
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

    public Dialog getDialog() {
        return this.f118f;
    }

    @StyleRes
    public int getTheme() {
        return this.f114b;
    }

    public void setCancelable(boolean z) {
        this.f115c = z;
        if (this.f118f != null) {
            this.f118f.setCancelable(z);
        }
    }

    public boolean isCancelable() {
        return this.f115c;
    }

    public void setShowsDialog(boolean z) {
        this.f116d = z;
    }

    public boolean getShowsDialog() {
        return this.f116d;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.f121i) {
            this.f120h = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.f121i && !this.f120h) {
            this.f120h = true;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f116d = this.f131H == 0;
        if (bundle != null) {
            this.f113a = bundle.getInt("android:style", 0);
            this.f114b = bundle.getInt("android:theme", 0);
            this.f115c = bundle.getBoolean("android:cancelable", true);
            this.f116d = bundle.getBoolean("android:showsDialog", this.f116d);
            this.f117e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (!this.f116d) {
            return super.getLayoutInflater(bundle);
        }
        this.f118f = onCreateDialog(bundle);
        if (this.f118f == null) {
            return (LayoutInflater) this.f127D.mo407c().getSystemService("layout_inflater");
        }
        setupDialog(this.f118f, this.f113a);
        return (LayoutInflater) this.f118f.getContext().getSystemService("layout_inflater");
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

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(getActivity(), getTheme());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f119g) {
            mo169a(true);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.f116d) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f118f.setContentView(view);
            }
            this.f118f.setOwnerActivity(getActivity());
            this.f118f.setCancelable(this.f115c);
            this.f118f.setOnCancelListener(this);
            this.f118f.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.f118f.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f118f != null) {
            this.f119g = false;
            this.f118f.show();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.onSaveInstanceState(bundle);
        if (!(this.f118f == null || (onSaveInstanceState = this.f118f.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        if (this.f113a != 0) {
            bundle.putInt("android:style", this.f113a);
        }
        if (this.f114b != 0) {
            bundle.putInt("android:theme", this.f114b);
        }
        if (!this.f115c) {
            bundle.putBoolean("android:cancelable", this.f115c);
        }
        if (!this.f116d) {
            bundle.putBoolean("android:showsDialog", this.f116d);
        }
        if (this.f117e != -1) {
            bundle.putInt("android:backStackId", this.f117e);
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f118f != null) {
            this.f118f.hide();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f118f != null) {
            this.f119g = true;
            this.f118f.dismiss();
            this.f118f = null;
        }
    }
}
