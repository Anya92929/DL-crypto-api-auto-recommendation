package android.support.p000v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23;
import android.support.p000v4.p002os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat */
public class FingerprintManagerCompat {

    /* renamed from: a */
    static final FingerprintManagerCompatImpl f811a;

    /* renamed from: b */
    private Context f812b;

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$Api23FingerprintManagerCompatImpl */
    class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        /* renamed from: a */
        private static FingerprintManagerCompatApi23.AuthenticationCallback m667a(final AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerCompatApi23.AuthenticationCallback() {
                public void onAuthenticationError(int i, CharSequence charSequence) {
                    AuthenticationCallback.this.onAuthenticationError(i, charSequence);
                }

                public void onAuthenticationFailed() {
                    AuthenticationCallback.this.onAuthenticationFailed();
                }

                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
                }

                public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal authenticationResultInternal) {
                    AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(Api23FingerprintManagerCompatImpl.m669b(authenticationResultInternal.getCryptoObject())));
                }
            };
        }

        /* renamed from: a */
        private static FingerprintManagerCompatApi23.CryptoObject m668a(CryptoObject cryptoObject) {
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
        public static CryptoObject m669b(FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
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

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            FingerprintManagerCompatApi23.authenticate(context, m668a(cryptoObject), i, cancellationSignal != null ? cancellationSignal.getCancellationSignalObject() : null, m667a(authenticationCallback), handler);
        }

        public boolean hasEnrolledFingerprints(Context context) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        public boolean isHardwareDetected(Context context) {
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback */
    public abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult */
    public final class AuthenticationResult {

        /* renamed from: a */
        private CryptoObject f814a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f814a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f814a;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject */
    public class CryptoObject {

        /* renamed from: a */
        private final Signature f815a;

        /* renamed from: b */
        private final Cipher f816b;

        /* renamed from: c */
        private final Mac f817c;

        public CryptoObject(Signature signature) {
            this.f815a = signature;
            this.f816b = null;
            this.f817c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.f816b = cipher;
            this.f815a = null;
            this.f817c = null;
        }

        public CryptoObject(Mac mac) {
            this.f817c = mac;
            this.f816b = null;
            this.f815a = null;
        }

        public Cipher getCipher() {
            return this.f816b;
        }

        public Mac getMac() {
            return this.f817c;
        }

        public Signature getSignature() {
            return this.f815a;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$FingerprintManagerCompatImpl */
    interface FingerprintManagerCompatImpl {
        void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl */
    class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }

        public boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        public boolean isHardwareDetected(Context context) {
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f811a = new Api23FingerprintManagerCompatImpl();
        } else {
            f811a = new LegacyFingerprintManagerCompatImpl();
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f812b = context;
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    public void authenticate(CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        f811a.authenticate(this.f812b, cryptoObject, i, cancellationSignal, authenticationCallback, handler);
    }

    public boolean hasEnrolledFingerprints() {
        return f811a.hasEnrolledFingerprints(this.f812b);
    }

    public boolean isHardwareDetected() {
        return f811a.isHardwareDetected(this.f812b);
    }
}
