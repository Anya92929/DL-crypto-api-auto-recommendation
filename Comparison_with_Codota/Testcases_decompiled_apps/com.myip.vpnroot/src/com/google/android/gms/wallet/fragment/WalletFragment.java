package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
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
import com.google.android.gms.dynamic.C0590b;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0598f;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C1670oq;
import com.google.android.gms.internal.C1673or;
import com.google.android.gms.internal.C1698oy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: Sb */
    public final Fragment f4632Sb = this;
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
    public C2182b atS;
    /* access modifiers changed from: private */
    public final C0590b atT = C0590b.m1721a(this);
    private final C2183c atU = new C2183c();
    /* access modifiers changed from: private */
    public C2181a atV = new C2181a(this);
    /* access modifiers changed from: private */
    public boolean mCreated = false;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment$a */
    static class C2181a extends C1673or.C1674a {
        private OnStateChangedListener atW;
        private final WalletFragment atX;

        C2181a(WalletFragment walletFragment) {
            this.atX = walletFragment;
        }

        /* renamed from: a */
        public void mo9955a(int i, int i2, Bundle bundle) {
            if (this.atW != null) {
                this.atW.onStateChanged(this.atX, i, i2, bundle);
            }
        }

        /* renamed from: a */
        public void mo12003a(OnStateChangedListener onStateChangedListener) {
            this.atW = onStateChangedListener;
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment$b */
    private static class C2182b implements LifecycleDelegate {
        private final C1670oq atQ;

        private C2182b(C1670oq oqVar) {
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

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment$c */
    private class C2183c extends C0581a<C2182b> implements View.OnClickListener {
        private C2183c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5497a(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(WalletFragment.this.f4632Sb.getActivity());
            button.setText(C0135R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (!(WalletFragment.this.atJ == null || (fragmentStyle = WalletFragment.this.atJ.getFragmentStyle()) == null)) {
                DisplayMetrics displayMetrics = WalletFragment.this.f4632Sb.getResources().getDisplayMetrics();
                i = fragmentStyle.mo12030a("buyButtonWidth", displayMetrics, -1);
                i2 = fragmentStyle.mo12030a("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C2182b> fVar) {
            Activity activity = WalletFragment.this.f4632Sb.getActivity();
            if (WalletFragment.this.atS == null && WalletFragment.this.mCreated && activity != null) {
                try {
                    C2182b unused = WalletFragment.this.atS = new C2182b(C1698oy.m5924a(activity, WalletFragment.this.atT, WalletFragment.this.atJ, WalletFragment.this.atV));
                    WalletFragmentOptions unused2 = WalletFragment.this.atJ = null;
                    fVar.mo5511a(WalletFragment.this.atS);
                    if (WalletFragment.this.atK != null) {
                        WalletFragment.this.atS.initialize(WalletFragment.this.atK);
                        WalletFragmentInitParams unused3 = WalletFragment.this.atK = null;
                    }
                    if (WalletFragment.this.atL != null) {
                        WalletFragment.this.atS.updateMaskedWalletRequest(WalletFragment.this.atL);
                        MaskedWalletRequest unused4 = WalletFragment.this.atL = null;
                    }
                    if (WalletFragment.this.atM != null) {
                        WalletFragment.this.atS.updateMaskedWallet(WalletFragment.this.atM);
                        MaskedWallet unused5 = WalletFragment.this.atM = null;
                    }
                    if (WalletFragment.this.atN != null) {
                        WalletFragment.this.atS.setEnabled(WalletFragment.this.atN.booleanValue());
                        Boolean unused6 = WalletFragment.this.atN = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Activity activity = WalletFragment.this.f4632Sb.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.f4632Sb.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        if (this.atS != null) {
            return this.atS.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.atS != null) {
            this.atS.initialize(initParams);
            this.atK = null;
        } else if (this.atK == null) {
            this.atK = initParams;
            if (this.atL != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.atM != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.atS != null) {
            this.atS.onActivityResult(requestCode, resultCode, data);
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
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (!(this.f4632Sb.getArguments() == null || (walletFragmentOptions = (WalletFragmentOptions) this.f4632Sb.getArguments().getParcelable("extraWalletFragmentOptions")) == null)) {
            walletFragmentOptions.mo12016Z(this.f4632Sb.getActivity());
            this.atJ = walletFragmentOptions;
        }
        this.mCreated = true;
        this.atU.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.atU.onCreateView(inflater, container, savedInstanceState);
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
        this.atU.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.atU.onPause();
    }

    public void onResume() {
        super.onResume();
        this.atU.onResume();
        FragmentManager fragmentManager = this.f4632Sb.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f4632Sb.getActivity()), this.f4632Sb.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.atU.onSaveInstanceState(outState);
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
        this.atU.onStart();
    }

    public void onStop() {
        super.onStop();
        this.atU.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.atS != null) {
            this.atS.setEnabled(enabled);
            this.atN = null;
            return;
        }
        this.atN = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.atV.mo12003a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.atS != null) {
            this.atS.updateMaskedWallet(maskedWallet);
            this.atM = null;
            return;
        }
        this.atM = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.atS != null) {
            this.atS.updateMaskedWalletRequest(request);
            this.atL = null;
            return;
        }
        this.atL = request;
    }
}
