package android.support.p001v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.hardware.fingerprint.FingerprintManagerCompatApi23;
import android.support.p001v4.p003os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat */
public class FingerprintManagerCompat {

    /* renamed from: a */
    static final C0147b f507a;

    /* renamed from: b */
    private Context f508b;

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$b */
    interface C0147b {
        /* renamed from: a */
        void mo925a(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        /* renamed from: a */
        boolean mo926a(Context context);

        /* renamed from: b */
        boolean mo927b(Context context);
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private FingerprintManagerCompat(Context context) {
        this.f508b = context;
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f507a = new C0145a();
        } else {
            f507a = new C0148c();
        }
    }

    public boolean hasEnrolledFingerprints() {
        return f507a.mo926a(this.f508b);
    }

    public boolean isHardwareDetected() {
        return f507a.mo927b(this.f508b);
    }

    public void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        f507a.mo925a(this.f508b, cryptoObject, i, cancellationSignal, authenticationCallback, handler);
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject */
    public static class CryptoObject {

        /* renamed from: a */
        private final Signature f510a;

        /* renamed from: b */
        private final Cipher f511b;

        /* renamed from: c */
        private final Mac f512c;

        public CryptoObject(Signature signature) {
            this.f510a = signature;
            this.f511b = null;
            this.f512c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.f511b = cipher;
            this.f510a = null;
            this.f512c = null;
        }

        public CryptoObject(Mac mac) {
            this.f512c = mac;
            this.f511b = null;
            this.f510a = null;
        }

        public Signature getSignature() {
            return this.f510a;
        }

        public Cipher getCipher() {
            return this.f511b;
        }

        public Mac getMac() {
            return this.f512c;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult */
    public static final class AuthenticationResult {

        /* renamed from: a */
        private CryptoObject f509a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f509a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f509a;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationFailed() {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$c */
    static class C0148c implements C0147b {
        /* renamed from: a */
        public boolean mo926a(Context context) {
            return false;
        }

        /* renamed from: b */
        public boolean mo927b(Context context) {
            return false;
        }

        /* renamed from: a */
        public void mo925a(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$a */
    static class C0145a implements C0147b {
        /* renamed from: a */
        public boolean mo926a(Context context) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        /* renamed from: b */
        public boolean mo927b(Context context) {
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }

        /* renamed from: a */
        public void mo925a(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            FingerprintManagerCompatApi23.authenticate(context, m539a(cryptoObject), i, cancellationSignal != null ? cancellationSignal.getCancellationSignalObject() : null, m538a(authenticationCallback), handler);
        }

        /* renamed from: a */
        private static FingerprintManagerCompatApi23.CryptoObject m539a(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static CryptoObject m540b(FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        /* renamed from: a */
        private static FingerprintManagerCompatApi23.AuthenticationCallback m538a(final AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerCompatApi23.AuthenticationCallback() {
                public void onAuthenticationError(int i, CharSequence charSequence) {
                    authenticationCallback.onAuthenticationError(i, charSequence);
                }

                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                    authenticationCallback.onAuthenticationHelp(i, charSequence);
                }

                public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal authenticationResultInternal) {
                    authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(C0145a.m540b(authenticationResultInternal.getCryptoObject())));
                }

                public void onAuthenticationFailed() {
                    authenticationCallback.onAuthenticationFailed();
                }
            };
        }
    }
}
