package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0135R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0581a;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0598f;
import com.google.android.gms.dynamic.C0601h;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C1670oq;
import com.google.android.gms.internal.C1673or;
import com.google.android.gms.internal.C1698oy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: Ll */
    public final Fragment f4631Ll = this;
    /* access modifiers changed from: private */
    public C2178b atF;
    /* access modifiers changed from: private */
    public final C0601h atG = C0601h.m1747a(this);
    private final C2179c atH = new C2179c();
    /* access modifiers changed from: private */
    public C2177a atI = new C2177a(this);
    /* access modifiers changed from: private */
    public WalletFragmentOptions atJ;
    /* access modifiers changed from: private */
    public WalletFragmentInitParams atK;
    /* access modifiers changed from: private */
    public MaskedWalletRequest atL;
    /* access modifiers changed from: private */
    public MaskedWallet atM;
    /* access modifiers changed from: private */
    public Boolean atN;
    /* access modifiers changed from: private */
    public boolean mCreated = false;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment$a */
    static class C2177a extends C1673or.C1674a {
        private OnStateChangedListener atO;
        private final SupportWalletFragment atP;

        C2177a(SupportWalletFragment supportWalletFragment) {
            this.atP = supportWalletFragment;
        }

        /* renamed from: a */
        public void mo9955a(int i, int i2, Bundle bundle) {
            if (this.atO != null) {
                this.atO.onStateChanged(this.atP, i, i2, bundle);
            }
        }

        /* renamed from: a */
        public void mo11984a(OnStateChangedListener onStateChangedListener) {
            this.atO = onStateChangedListener;
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment$b */
    private static class C2178b implements LifecycleDelegate {
        private final C1670oq atQ;

        private C2178b(C1670oq oqVar) {
            this.atQ = oqVar;
        }

        /* access modifiers changed from: private */
        public int getState() {
            try {
                return this.atQ.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams startParams) {
            try {
                this.atQ.initialize(startParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.atQ.onActivityResult(requestCode, resultCode, data);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void setEnabled(boolean enabled) {
            try {
                this.atQ.setEnabled(enabled);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.atQ.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.atQ.updateMaskedWalletRequest(request);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.atQ.onCreate(savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0597e.m1742f(this.atQ.onCreateView(C0597e.m1743k(inflater), C0597e.m1743k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.atQ.mo9939a(C0597e.m1743k(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.atQ.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.atQ.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.atQ.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.atQ.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.atQ.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment$c */
    private class C2179c extends C0581a<C2178b> implements View.OnClickListener {
        private C2179c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5497a(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(SupportWalletFragment.this.f4631Ll.getActivity());
            button.setText(C0135R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (!(SupportWalletFragment.this.atJ == null || (fragmentStyle = SupportWalletFragment.this.atJ.getFragmentStyle()) == null)) {
                DisplayMetrics displayMetrics = SupportWalletFragment.this.f4631Ll.getResources().getDisplayMetrics();
                i = fragmentStyle.mo12030a("buyButtonWidth", displayMetrics, -1);
                i2 = fragmentStyle.mo12030a("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C2178b> fVar) {
            FragmentActivity activity = SupportWalletFragment.this.f4631Ll.getActivity();
            if (SupportWalletFragment.this.atF == null && SupportWalletFragment.this.mCreated && activity != null) {
                try {
                    C2178b unused = SupportWalletFragment.this.atF = new C2178b(C1698oy.m5924a(activity, SupportWalletFragment.this.atG, SupportWalletFragment.this.atJ, SupportWalletFragment.this.atI));
                    WalletFragmentOptions unused2 = SupportWalletFragment.this.atJ = null;
                    fVar.mo5511a(SupportWalletFragment.this.atF);
                    if (SupportWalletFragment.this.atK != null) {
                        SupportWalletFragment.this.atF.initialize(SupportWalletFragment.this.atK);
                        WalletFragmentInitParams unused3 = SupportWalletFragment.this.atK = null;
                    }
                    if (SupportWalletFragment.this.atL != null) {
                        SupportWalletFragment.this.atF.updateMaskedWalletRequest(SupportWalletFragment.this.atL);
                        MaskedWalletRequest unused4 = SupportWalletFragment.this.atL = null;
                    }
                    if (SupportWalletFragment.this.atM != null) {
                        SupportWalletFragment.this.atF.updateMaskedWallet(SupportWalletFragment.this.atM);
                        MaskedWallet unused5 = SupportWalletFragment.this.atM = null;
                    }
                    if (SupportWalletFragment.this.atN != null) {
                        SupportWalletFragment.this.atF.setEnabled(SupportWalletFragment.this.atN.booleanValue());
                        Boolean unused6 = SupportWalletFragment.this.atN = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            FragmentActivity activity = SupportWalletFragment.this.f4631Ll.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.f4631Ll.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        if (this.atF != null) {
            return this.atF.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.atF != null) {
            this.atF.initialize(initParams);
            this.atK = null;
        } else if (this.atK == null) {
            this.atK = initParams;
            if (this.atL != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.atM != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.atF != null) {
            this.atF.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.atK != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.atK = walletFragmentInitParams;
            }
            if (this.atL == null) {
                this.atL = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.atM == null) {
                this.atM = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.atJ = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.atN = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (!(this.f4631Ll.getArguments() == null || (walletFragmentOptions = (WalletFragmentOptions) this.f4631Ll.getArguments().getParcelable("extraWalletFragmentOptions")) == null)) {
            walletFragmentOptions.mo12016Z(this.f4631Ll.getActivity());
            this.atJ = walletFragmentOptions;
        }
        this.mCreated = true;
        this.atH.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.atH.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.atJ == null) {
            this.atJ = WalletFragmentOptions.m7374a((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.atJ);
        this.atH.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.atH.onPause();
    }

    public void onResume() {
        super.onResume();
        this.atH.onResume();
        FragmentManager supportFragmentManager = this.f4631Ll.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f4631Ll.getActivity()), this.f4631Ll.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.atH.onSaveInstanceState(outState);
        if (this.atK != null) {
            outState.putParcelable("walletFragmentInitParams", this.atK);
            this.atK = null;
        }
        if (this.atL != null) {
            outState.putParcelable("maskedWalletRequest", this.atL);
            this.atL = null;
        }
        if (this.atM != null) {
            outState.putParcelable("maskedWallet", this.atM);
            this.atM = null;
        }
        if (this.atJ != null) {
            outState.putParcelable("walletFragmentOptions", this.atJ);
            this.atJ = null;
        }
        if (this.atN != null) {
            outState.putBoolean("enabled", this.atN.booleanValue());
            this.atN = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.atH.onStart();
    }

    public void onStop() {
        super.onStop();
        this.atH.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.atF != null) {
            this.atF.setEnabled(enabled);
            this.atN = null;
            return;
        }
        this.atN = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.atI.mo11984a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.atF != null) {
            this.atF.updateMaskedWallet(maskedWallet);
            this.atM = null;
            return;
        }
        this.atM = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.atF != null) {
            this.atF.updateMaskedWalletRequest(request);
            this.atL = null;
            return;
        }
        this.atL = request;
    }
}
