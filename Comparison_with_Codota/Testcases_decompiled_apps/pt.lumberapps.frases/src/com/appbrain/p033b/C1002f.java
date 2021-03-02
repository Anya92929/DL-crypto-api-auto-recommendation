package com.appbrain.p033b;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.appbrain.b.f */
public abstract class C1002f implements Iterable {

    /* renamed from: a */
    public static final C1002f f2629a = new C1018v(new byte[0]);

    /* renamed from: b */
    static final /* synthetic */ boolean f2630b = (!C1002f.class.desiredAssertionStatus());

    C1002f() {
    }

    /* renamed from: a */
    public static C1002f m4158a(Iterable iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add((C1002f) it.next());
            }
            collection = arrayList;
        } else {
            collection = (Collection) iterable;
        }
        return collection.isEmpty() ? f2629a : m4160a(collection.iterator(), collection.size());
    }

    /* renamed from: a */
    public static C1002f m4159a(String str) {
        try {
            return new C1018v(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    /* renamed from: a */
    private static C1002f m4160a(Iterator it, int i) {
        if (!f2630b && i <= 0) {
            throw new AssertionError();
        } else if (i == 1) {
            return (C1002f) it.next();
        } else {
            int i2 = i >>> 1;
            return m4160a(it, i2).mo3967a(m4160a(it, i - i2));
        }
    }

    /* renamed from: a */
    public static C1002f m4161a(byte[] bArr) {
        return m4162a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C1002f m4162a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C1018v(bArr2);
    }

    /* renamed from: a */
    static C1004h m4163a(int i) {
        return new C1004h(i, (byte) 0);
    }

    /* renamed from: g */
    public static C1005i m4164g() {
        return new C1005i();
    }

    /* renamed from: a */
    public abstract int mo3919a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo3920a(int i, int i2, int i3);

    /* renamed from: a */
    public final C1002f mo3967a(C1002f fVar) {
        int a = mo3919a();
        int a2 = fVar.mo3919a();
        if (((long) a) + ((long) a2) < 2147483647L) {
            return C0988ac.m4111a(this, fVar);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + a + "+" + a2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo3921a(OutputStream outputStream, int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3922a(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo3923b(int i, int i2, int i3);

    /* renamed from: b */
    public abstract String mo3924b(String str);

    /* renamed from: b */
    public final void mo3968b(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Target offset < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + i3);
        } else if (i + i3 > mo3919a()) {
            throw new IndexOutOfBoundsException("Source end offset < 0: " + (i + i3));
        } else if (i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException("Target end offset < 0: " + (i2 + i3));
        } else if (i3 > 0) {
            mo3922a(bArr, i, i2, i3);
        }
    }

    /* renamed from: c */
    public abstract C1003g iterator();

    /* renamed from: d */
    public final byte[] mo3969d() {
        int a = mo3919a();
        if (a == 0) {
            return C1013q.f2662a;
        }
        byte[] bArr = new byte[a];
        mo3922a(bArr, 0, 0, a);
        return bArr;
    }

    /* renamed from: e */
    public final String mo3970e() {
        try {
            return mo3924b("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    /* renamed from: f */
    public abstract boolean mo3927f();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract int mo3928h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public abstract boolean mo3930i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract int mo3932j();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo3919a())});
    }
}
