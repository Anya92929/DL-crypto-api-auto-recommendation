package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.google.firebase.iid.i */
public class C1987i {

    /* renamed from: a */
    static String f7533a = null;

    /* renamed from: b */
    static int f7534b = 0;

    /* renamed from: c */
    static int f7535c = 0;

    /* renamed from: d */
    static int f7536d = 0;

    /* renamed from: e */
    Context f7537e;

    /* renamed from: f */
    Map f7538f = new HashMap();

    /* renamed from: g */
    Messenger f7539g;

    /* renamed from: h */
    Messenger f7540h;

    /* renamed from: i */
    MessengerCompat f7541i;

    /* renamed from: j */
    PendingIntent f7542j;

    /* renamed from: k */
    long f7543k;

    /* renamed from: l */
    long f7544l;

    /* renamed from: m */
    int f7545m;

    /* renamed from: n */
    int f7546n;

    /* renamed from: o */
    long f7547o;

    public C1987i(Context context) {
        this.f7537e = context;
    }

    /* renamed from: a */
    public static String m8156a(Context context) {
        if (f7533a != null) {
            return f7533a;
        }
        f7534b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo next : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", next.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(next.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", new StringBuilder(17).append("Found ").append(applicationInfo.uid).toString());
                    f7535c = applicationInfo.uid;
                    f7533a = next.serviceInfo.packageName;
                    return f7533a;
                } catch (PackageManager.NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(next.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f7533a = applicationInfo2.packageName;
            f7535c = applicationInfo2.uid;
            return f7533a;
        } catch (PackageManager.NameNotFoundException e2) {
            try {
                ApplicationInfo applicationInfo3 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f7533a = applicationInfo3.packageName;
                f7535c = applicationInfo3.uid;
                return f7533a;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    /* renamed from: a */
    static String m8157a(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return FirebaseInstanceId.m8101a(instance.sign()); // CRYPTOGRAPHIC API CALLSITE 14
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    /* renamed from: a */
    private void m8158a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f7538f.keySet()) {
                Object obj2 = this.f7538f.get(str);
                this.f7538f.put(str, obj);
                m8159a(obj2, obj);
            }
        }
    }

    /* renamed from: a */
    private void m8159a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    /* renamed from: a */
    private void m8160a(String str) {
        if ("com.google.android.gsf".equals(f7533a)) {
            this.f7545m++;
            if (this.f7545m >= 3) {
                if (this.f7545m == 3) {
                    this.f7546n = new Random().nextInt(1000) + 1000;
                }
                this.f7546n *= 2;
                this.f7547o = SystemClock.elapsedRealtime() + ((long) this.f7546n);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f7546n).toString());
            }
        }
    }

    /* renamed from: a */
    private void m8161a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f7538f.get(str);
            this.f7538f.put(str, obj);
            m8159a(obj2, obj);
        }
    }

    /* renamed from: b */
    private static int m8162b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m8156a(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    /* renamed from: b */
    private Intent m8163b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = m8164b();
        synchronized (getClass()) {
            this.f7538f.put(b, conditionVariable);
        }
        mo9892a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f7538f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    /* renamed from: b */
    public static synchronized String m8164b() {
        String num;
        synchronized (C1987i.class) {
            int i = f7536d;
            f7536d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Intent mo9888a(Bundle bundle, KeyPair keyPair) {
        Intent b = m8163b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m8163b(bundle, keyPair);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9889a() {
        if (this.f7539g == null) {
            m8156a(this.f7537e);
            this.f7539g = new Messenger(new C1988j(this, Looper.getMainLooper()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9890a(Intent intent) {
        if (this.f7542j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f7542j = PendingIntent.getBroadcast(this.f7537e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f7542j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9891a(Intent intent, String str) {
        this.f7543k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f7533a);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.f7537e.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.f7539g);
        if (!(this.f7540h == null && this.f7541i == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f7540h != null) {
                    this.f7540h.send(obtain);
                    return;
                } else {
                    this.f7541i.send(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f7537e.startService(intent);
    }

    /* renamed from: a */
    public void mo9892a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7547o == 0 || elapsedRealtime > this.f7547o) {
            mo9889a();
            if (f7533a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f7543k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f7533a);
            bundle.putString("gmsv", Integer.toString(m8162b(this.f7537e)));
            bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.m8103b(this.f7537e)));
            bundle.putString("app_ver_name", FirebaseInstanceId.m8104c(this.f7537e));
            bundle.putString("cliv", "fiid-9452000");
            bundle.putString("appid", FirebaseInstanceId.m8100a(keyPair));
            String a = FirebaseInstanceId.m8099a(this.f7537e);
            if (a != null) {
                bundle.putString("gmp_app_id", a);
            }
            String a2 = FirebaseInstanceId.m8101a(keyPair.getPublic().getEncoded());
            bundle.putString("pub2", a2);
            bundle.putString("sig", m8157a(keyPair, this.f7537e.getPackageName(), a2));
            intent.putExtras(bundle);
            mo9890a(intent);
            mo9891a(intent, str);
            return;
        }
        long j = this.f7547o - elapsedRealtime;
        Log.w("InstanceID/Rpc", new StringBuilder(78).append("Backoff mode, next request attempt: ").append(j).append(" interval: ").append(this.f7546n).toString());
        throw new IOException("RETRY_LATER");
    }

    /* renamed from: a */
    public void mo9893a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f7541i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f7540h = (Messenger) parcelableExtra;
                    }
                }
                mo9896d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo9894b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9895c(Intent intent) {
        String str;
        String str2;
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf2 = String.valueOf(stringExtra);
            Log.d("InstanceID/Rpc", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String valueOf3 = String.valueOf(stringExtra);
                Log.w("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
            }
            if (split.length > 2) {
                str = split[2];
                str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
            } else {
                str2 = "UNKNOWN";
                str = null;
            }
            intent.putExtra("error", str2);
        } else {
            str = null;
            str2 = stringExtra;
        }
        if (str == null) {
            m8158a((Object) str2);
        } else {
            m8161a(str, (Object) str2);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f7544l = SystemClock.elapsedRealtime();
            this.f7546n = ((int) longExtra) * 1000;
            this.f7547o = SystemClock.elapsedRealtime() + ((long) this.f7546n);
            Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(this.f7546n).toString());
        } else if ("SERVICE_NOT_AVAILABLE".equals(str2) || "AUTHENTICATION_FAILED".equals(str2)) {
            m8160a(str2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9896d(Intent intent) {
        String str;
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
            }
        } else if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                mo9895c(intent);
                return;
            }
            this.f7543k = SystemClock.elapsedRealtime();
            this.f7547o = 0;
            this.f7545m = 0;
            this.f7546n = 0;
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(stringExtra).length() + 16 + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
            }
            if (stringExtra.startsWith("|")) {
                String[] split = stringExtra.split("\\|");
                if (!"ID".equals(split[1])) {
                    String valueOf2 = String.valueOf(stringExtra);
                    Log.w("InstanceID/Rpc", valueOf2.length() != 0 ? "Unexpected structured response ".concat(valueOf2) : new String("Unexpected structured response "));
                }
                String str2 = split[2];
                if (split.length > 4) {
                    if ("SYNC".equals(split[3])) {
                        FirebaseInstanceId.m8105d(this.f7537e);
                    } else if ("RST".equals(split[3])) {
                        FirebaseInstanceId.m8102a(this.f7537e, C1985g.m8145a(this.f7537e, (Bundle) null).mo9882c());
                        intent.removeExtra("registration_id");
                        m8161a(str2, (Object) intent);
                        return;
                    }
                }
                String str3 = split[split.length - 1];
                if (str3.startsWith(":")) {
                    str3 = str3.substring(1);
                }
                intent.putExtra("registration_id", str3);
                str = str2;
            } else {
                str = null;
            }
            if (str == null) {
                m8158a((Object) intent);
            } else {
                m8161a(str, (Object) intent);
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf3 = String.valueOf(intent.getAction());
            Log.d("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected response ".concat(valueOf3) : new String("Unexpected response "));
        }
    }
}
