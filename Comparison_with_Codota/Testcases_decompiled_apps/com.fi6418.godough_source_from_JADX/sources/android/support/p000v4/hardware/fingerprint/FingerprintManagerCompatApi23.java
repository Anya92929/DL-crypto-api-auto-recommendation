package android.support.p000v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23 */
public final class FingerprintManagerCompatApi23 {

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback */
    public abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationResultInternal */
    public final class AuthenticationResultInternal {

        /* renamed from: a */
        private CryptoObject f819a;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.f819a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f819a;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject */
    public class CryptoObject {

        /* renamed from: a */
        private final Signature f820a;

        /* renamed from: b */
        private final Cipher f821b;

        /* renamed from: c */
        private final Mac f822c;

        public CryptoObject(Signature signature) {
            this.f820a = signature;
            this.f821b = null;
            this.f822c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.f821b = cipher;
            this.f820a = null;
            this.f822c = null;
        }

        public CryptoObject(Mac mac) {
            this.f822c = mac;
            this.f821b = null;
            this.f820a = null;
        }

        public Cipher getCipher() {
            return this.f821b;
        }

        public Mac getMac() {
            return this.f822c;
        }

        public Signature getSignature() {
            return this.f820a;
        }
    }

    /* renamed from: a */
    private static FingerprintManager.AuthenticationCallback m670a(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() {
            public void onAuthenticationError(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i, charSequence);
            }

            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
            }

            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerCompatApi23.m674b(authenticationResult.getCryptoObject())));
            }
        };
    }

    /* renamed from: a */
    private static FingerprintManager.CryptoObject m671a(CryptoObject cryptoObject) {
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

    /* renamed from: a */
    private static FingerprintManager m672a(Context context) {
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        m672a(context).authenticate(m671a(cryptoObject), (CancellationSignal) obj, i, m670a(authenticationCallback), handler);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static CryptoObject m674b(FingerprintManager.CryptoObject cryptoObject) {
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

    public static boolean hasEnrolledFingerprints(Context context) {
        return m672a(context).hasEnrolledFingerprints();
    }

    public static boolean isHardwareDetected(Context context) {
        return m672a(context).isHardwareDetected();
    }
}
