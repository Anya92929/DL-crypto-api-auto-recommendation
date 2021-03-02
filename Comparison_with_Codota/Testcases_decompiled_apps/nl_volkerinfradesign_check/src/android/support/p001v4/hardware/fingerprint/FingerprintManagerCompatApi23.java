package android.support.p001v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23 */
public final class FingerprintManagerCompatApi23 {
    /* renamed from: a */
    private static FingerprintManager m552a(Context context) {
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        return m552a(context).hasEnrolledFingerprints();
    }

    public static boolean isHardwareDetected(Context context) {
        return m552a(context).isHardwareDetected();
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        m552a(context).authenticate(m551a(cryptoObject), (CancellationSignal) obj, i, m550a(authenticationCallback), handler);
    }

    /* renamed from: a */
    private static FingerprintManager.CryptoObject m551a(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static CryptoObject m554b(FingerprintManager.CryptoObject cryptoObject) {
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
    private static FingerprintManager.AuthenticationCallback m550a(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() {
            public void onAuthenticationError(int i, CharSequence charSequence) {
                authenticationCallback.onAuthenticationError(i, charSequence);
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                authenticationCallback.onAuthenticationHelp(i, charSequence);
            }

            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerCompatApi23.m554b(authenticationResult.getCryptoObject())));
            }

            public void onAuthenticationFailed() {
                authenticationCallback.onAuthenticationFailed();
            }
        };
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject */
    public static class CryptoObject {

        /* renamed from: a */
        private final Signature f516a;

        /* renamed from: b */
        private final Cipher f517b;

        /* renamed from: c */
        private final Mac f518c;

        public CryptoObject(Signature signature) {
            this.f516a = signature;
            this.f517b = null;
            this.f518c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.f517b = cipher;
            this.f516a = null;
            this.f518c = null;
        }

        public CryptoObject(Mac mac) {
            this.f518c = mac;
            this.f517b = null;
            this.f516a = null;
        }

        public Signature getSignature() {
            return this.f516a;
        }

        public Cipher getCipher() {
            return this.f517b;
        }

        public Mac getMac() {
            return this.f518c;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationResultInternal */
    public static final class AuthenticationResultInternal {

        /* renamed from: a */
        private CryptoObject f515a;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.f515a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f515a;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }

        public void onAuthenticationFailed() {
        }
    }
}
