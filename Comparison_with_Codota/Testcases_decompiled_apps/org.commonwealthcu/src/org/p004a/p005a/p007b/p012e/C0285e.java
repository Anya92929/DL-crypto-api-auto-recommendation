package org.p004a.p005a.p007b.p012e;

import android.support.p000v4.media.TransportMediator;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p033i.C0526e;
import org.p004a.p005a.p033i.C0532k;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.b.e.e */
public final class C0285e {

    /* renamed from: a */
    private static final char[] f121a = {'&', ';'};

    /* renamed from: b */
    private static final BitSet f122b = new BitSet(256);

    /* renamed from: c */
    private static final BitSet f123c = new BitSet(256);

    /* renamed from: d */
    private static final BitSet f124d = new BitSet(256);

    /* renamed from: e */
    private static final BitSet f125e = new BitSet(256);

    /* renamed from: f */
    private static final BitSet f126f = new BitSet(256);

    /* renamed from: g */
    private static final BitSet f127g = new BitSet(256);

    /* renamed from: h */
    private static final BitSet f128h = new BitSet(256);

    static {
        new StringBuilder("[").append(new String(f121a)).append("]");
        for (int i = 97; i <= 122; i++) {
            f122b.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f122b.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            f122b.set(i3);
        }
        f122b.set(95);
        f122b.set(45);
        f122b.set(46);
        f122b.set(42);
        f128h.or(f122b);
        f122b.set(33);
        f122b.set(TransportMediator.KEYCODE_MEDIA_PLAY);
        f122b.set(39);
        f122b.set(40);
        f122b.set(41);
        f123c.set(44);
        f123c.set(59);
        f123c.set(58);
        f123c.set(36);
        f123c.set(38);
        f123c.set(43);
        f123c.set(61);
        f124d.or(f122b);
        f124d.or(f123c);
        f125e.or(f122b);
        f125e.set(47);
        f125e.set(59);
        f125e.set(58);
        f125e.set(64);
        f125e.set(38);
        f125e.set(61);
        f125e.set(43);
        f125e.set(36);
        f125e.set(44);
        f127g.set(59);
        f127g.set(47);
        f127g.set(63);
        f127g.set(58);
        f127g.set(64);
        f127g.set(38);
        f127g.set(61);
        f127g.set(43);
        f127g.set(36);
        f127g.set(44);
        f127g.set(91);
        f127g.set(93);
        f126f.or(f127g);
        f126f.or(f122b);
    }

    /* renamed from: a */
    public static String m187a(Iterable iterable, Charset charset) {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C0576y yVar = (C0576y) it.next();
            String f = m196f(yVar.mo5357a(), charset);
            String f2 = m196f(yVar.mo5358b(), charset);
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(f);
            if (f2 != null) {
                sb.append("=");
                sb.append(f2);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m188a(String str, String str2) {
        if (str == null) {
            return null;
        }
        return m189a(str, str2 != null ? Charset.forName(str2) : C0297c.f129a, f128h, true);
    }

    /* renamed from: a */
    private static String m189a(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get() & 255;
            if (bitSet.get(b)) {
                sb.append((char) b);
            } else if (!z || b != 32) {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((b >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & 15, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            } else {
                sb.append('+');
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m190a(List list, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0576y yVar = (C0576y) it.next();
            String a = m188a(yVar.mo5357a(), str);
            String a2 = m188a(yVar.mo5358b(), str);
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(a);
            if (a2 != null) {
                sb.append("=");
                sb.append(a2);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static List m191a(String str, Charset charset) {
        char[] cArr = f121a;
        if (str == null) {
            return Collections.emptyList();
        }
        C0526e eVar = C0526e.f571a;
        C0563b bVar = new C0563b(str.length());
        bVar.mo5428a(str);
        C0541t tVar = new C0541t(0, bVar.mo5435c());
        ArrayList arrayList = new ArrayList();
        while (!tVar.mo5386c()) {
            C0576y a = eVar.mo5341a(bVar, tVar, cArr);
            if (a.mo5357a().length() > 0) {
                arrayList.add(new C0532k(m195e(a.mo5357a(), charset), m195e(a.mo5358b(), charset)));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    static String m192b(String str, Charset charset) {
        return m189a(str, charset, f124d, false);
    }

    /* renamed from: c */
    static String m193c(String str, Charset charset) {
        return m189a(str, charset, f126f, false);
    }

    /* renamed from: d */
    static String m194d(String str, Charset charset) {
        return m189a(str, charset, f125e, false);
    }

    /* renamed from: e */
    private static String m195e(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = C0297c.f129a;
        }
        if (str == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length());
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.hasRemaining()) {
            char c = wrap.get();
            if (c == '%' && wrap.remaining() >= 2) {
                char c2 = wrap.get();
                char c3 = wrap.get();
                int digit = Character.digit(c2, 16);
                int digit2 = Character.digit(c3, 16);
                if (digit == -1 || digit2 == -1) {
                    allocate.put((byte) 37);
                    allocate.put((byte) c2);
                    allocate.put((byte) c3);
                } else {
                    allocate.put((byte) ((digit << 4) + digit2));
                }
            } else if (c == '+') {
                allocate.put((byte) 32);
            } else {
                allocate.put((byte) c);
            }
        }
        allocate.flip();
        return charset.decode(allocate).toString();
    }

    /* renamed from: f */
    private static String m196f(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = C0297c.f129a;
        }
        return m189a(str, charset, f128h, true);
    }
}
