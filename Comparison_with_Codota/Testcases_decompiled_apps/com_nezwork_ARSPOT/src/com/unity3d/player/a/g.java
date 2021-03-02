package com.unity3d.player.a;

import android.text.TextUtils;
import com.qualcomm.ar.pl.SystemTools;
import com.unity3d.player.a.f;
import com.unity3d.player.b.a;
import com.unity3d.player.b.b;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.regex.Pattern;

final class g {
    private final i a;
    private final f b;
    private final int c;
    private final String d;
    private final String e;
    private final b f;

    g(i iVar, b bVar, f fVar, int i, String str, String str2) {
        this.a = iVar;
        this.f = bVar;
        this.b = fVar;
        this.c = i;
        this.d = str;
        this.e = str2;
    }

    private void a(int i, k kVar) {
        this.a.a(i, kVar);
        if (this.a.a()) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    public final f a() {
        return this.b;
    }

    public final void a(PublicKey publicKey, int i, String str, String str2) {
        k kVar = null;
        if (i == 0 || i == 1 || i == 2) {
            try {
                Signature instance = Signature.getInstance("SHA1withRSA");  //CRYPTOGRAPHIC API CALLSITE 19
                instance.initVerify(publicKey);
                instance.update(str.getBytes());     //CRYPTOGRAPHIC API CALLSITE 01
                if (!instance.verify(a.a(str2))) {
                    this.b.b();
                    return;
                }
                try {
                    TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
                    simpleStringSplitter.setString(str);
                    Iterator it = simpleStringSplitter.iterator();
                    if (!it.hasNext()) {
                        throw new IllegalArgumentException("");
                    }
                    String str3 = (String) it.next();
                    String str4 = "";
                    if (it.hasNext()) {
                        str4 = (String) it.next();
                    }
                    String[] split = TextUtils.split(str3, Pattern.quote("|"));
                    if (split.length < 6) {
                        throw new IllegalArgumentException("");
                    }
                    kVar = new k();
                    kVar.g = str4;
                    kVar.a = Integer.parseInt(split[0]);
                    kVar.b = Integer.parseInt(split[1]);
                    kVar.c = split[2];
                    kVar.d = split[3];
                    kVar.e = split[4];
                    kVar.f = Long.parseLong(split[5]);
                    if (kVar.a != i) {
                        this.b.b();
                        return;
                    } else if (kVar.b != this.c) {
                        this.b.b();
                        return;
                    } else if (!kVar.c.equals(this.d)) {
                        this.b.b();
                        return;
                    } else if (!kVar.d.equals(this.e)) {
                        this.b.b();
                        return;
                    } else if (TextUtils.isEmpty(kVar.e)) {
                        this.b.b();
                        return;
                    }
                } catch (IllegalArgumentException e2) {
                    this.b.b();
                    return;
                }
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(e3);
            } catch (InvalidKeyException e4) {
                f.a aVar = f.a.INVALID_PUBLIC_KEY;
                f fVar = this.b;
                return;
            } catch (SignatureException e5) {
                throw new RuntimeException(e5);
            } catch (b e6) {
                this.b.b();
                return;
            }
        }
        switch (i) {
            case SystemTools.AR_ERROR_NONE:
            case 2:
                b bVar = this.f;
                a(1, kVar);
                return;
            case 1:
                a(0, kVar);
                return;
            case SystemTools.AR_ERROR_INVALID_ENUM:
                f.a aVar2 = f.a.NOT_MARKET_MANAGED;
                f fVar2 = this.b;
                return;
            case SystemTools.AR_ERROR_INVALID_HANDLE:
                a(-1, kVar);
                return;
            case SystemTools.AR_ERROR_INVALID_OPERATION:
                a(-1, kVar);
                return;
            case 257:
                a(-1, kVar);
                return;
            case 258:
                f.a aVar3 = f.a.INVALID_PACKAGE_NAME;
                f fVar3 = this.b;
                return;
            case 259:
                f.a aVar4 = f.a.NON_MATCHING_UID;
                f fVar4 = this.b;
                return;
            default:
                this.b.b();
                return;
        }
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }
}
