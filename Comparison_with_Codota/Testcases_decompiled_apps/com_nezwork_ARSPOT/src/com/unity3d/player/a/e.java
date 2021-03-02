package com.unity3d.player.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.unity3d.player.a.c;
import com.unity3d.player.a.d;
import com.unity3d.player.a.f;
import com.unity3d.player.b.b;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class e implements ServiceConnection {
    protected static byte[] a = {-99, -111, -109, -46, -97, -110, -100, -114, -111, -105, -100, -46, -118, -101, -110, -100, -105, -110, -103, -46, -108, -105, -99, -101, -110, -115, -105, -110, -103, -46, -73, -76, -105, -99, -101, -110, -115, -101, -82, -101, -115, -117, -108, -116, -76, -105, -115, -116, -101, -110, -101, -114};
    protected static byte[] b;
    private static final SecureRandom c = new SecureRandom();
    private d d;
    /* access modifiers changed from: private */
    public PublicKey e;
    private final Context f;
    private final i g;
    /* access modifiers changed from: private */
    public Handler h;
    private final String i;
    private final String j;
    /* access modifiers changed from: private */
    public final Set k = new HashSet();
    private final Queue l = new LinkedList();

    class a extends c.a {
        /* access modifiers changed from: private */
        public final g b;
        private Runnable c = new Runnable() {
            public final void run() {
                e.this.b(a.this.b);
                e.this.a(a.this.b);
            }
        };

        public a(g gVar) {
            this.b = gVar;
            e.this.h.postDelayed(this.c, 10000);
        }

        public final void a(final int i, final String str, final String str2) {
            e.this.h.post(new Runnable() {
                public final void run() {
                    if (e.this.k.contains(a.this.b)) {
                        e.this.h.removeCallbacks(a.this.c);
                        a.this.b.a(e.this.e, i, str, str2);
                        e.this.a(a.this.b);
                    }
                }
            });
        }
    }

    static {
        byte[] bArr = {54, 51, 22, 28, 26, 17, 12, 22, 17, 24, 44, 26, 13, 9, 22, 28, 26};
        b = new byte[(bArr.length + 30)];
        for (int i2 = 0; i2 < a.length; i2++) {
            a[i2] = (byte) (-a[i2]);
            if (i2 < 30) {
                b[i2] = a[i2];
                if (i2 < bArr.length) {
                    b[i2 + 30] = (byte) (bArr[i2] ^ Byte.MAX_VALUE);
                }
            }
        }
    }

    public e(Context context, i iVar, String str) {
        this.f = context;
        this.g = iVar;
        this.e = a(str);
        this.i = this.f.getPackageName();
        this.j = a(context, this.i);
        HandlerThread handlerThread = new HandlerThread(this.i);
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper());
    }

    private static String a(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            return "";
        }
    }

    private static PublicKey a(String str) {
        try {
            // X509EncodedKeySpec keySpec = ??
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.unity3d.player.b.a.a(str)));  //CRYPTOGRAPHIC API CALLSITE 02; CRYPTOGRAPHIC API CALLSITE 03; CRYPTOGRAPHIC API CALLSITE 04
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (b e3) {
            throw new IllegalArgumentException(e3);
        } catch (InvalidKeySpecException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(g gVar) {
        this.k.remove(gVar);
        if (this.k.isEmpty()) {
            c();
        }
    }

    private void b() {
        while (true) {
            g gVar = (g) this.l.poll();
            if (gVar != null) {
                try {
                    this.d.a((long) gVar.b(), gVar.c(), new a(gVar));
                    this.k.add(gVar);
                } catch (RemoteException e2) {
                    b(gVar);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void b(g gVar) {
        this.g.a(-1, (k) null);
        if (this.g.a()) {
            gVar.a().a();
        } else {
            gVar.a().b();
        }
    }

    private void c() {
        if (this.d != null) {
            try {
                this.f.unbindService(this);
            } catch (IllegalArgumentException e2) {
            }
            this.d = null;
        }
    }

    public final synchronized void a() {
        c();
        this.h.getLooper().quit();
    }

    public final synchronized void a(f fVar) {
        if (this.g.a()) {
            fVar.a();
        } else {
            g gVar = new g(this.g, new b(), fVar, c.nextInt(), this.i, this.j);
            if (this.d == null) {
                try {
                    if (this.f.bindService(new Intent(new String(b)), this, 1)) {
                        this.l.offer(gVar);
                    } else {
                        b(gVar);
                    }
                } catch (SecurityException e2) {
                    f.a aVar = f.a.MISSING_PERMISSION;
                }
            } else {
                this.l.offer(gVar);
                b();
            }
        }
        return;
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.d = d.a.a(iBinder);
        b();
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        this.d = null;
    }
}
