package com.google.android.gms.common.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.common.internal.g */
public abstract class C1016g {

    /* renamed from: a */
    public static final C1016g f4728a = m4558a((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").mo7626a(m4557a(8192, 8202));

    /* renamed from: b */
    public static final C1016g f4729b = m4558a((CharSequence) "\t\n\u000b\f\r     　").mo7626a(m4557a(8192, 8198)).mo7626a(m4557a(8200, 8202));

    /* renamed from: c */
    public static final C1016g f4730c = m4557a(0, 127);

    /* renamed from: d */
    public static final C1016g f4731d;

    /* renamed from: e */
    public static final C1016g f4732e = m4557a(9, 13).mo7626a(m4557a(28, ' ')).mo7626a(m4556a(5760)).mo7626a(m4556a(6158)).mo7626a(m4557a(8192, 8198)).mo7626a(m4557a(8200, 8203)).mo7626a(m4557a(8232, 8233)).mo7626a(m4556a(8287)).mo7626a(m4556a(12288));

    /* renamed from: f */
    public static final C1016g f4733f = new C1017h();

    /* renamed from: g */
    public static final C1016g f4734g = new C1023n();

    /* renamed from: h */
    public static final C1016g f4735h = new C1024o();

    /* renamed from: i */
    public static final C1016g f4736i = new C1025p();

    /* renamed from: j */
    public static final C1016g f4737j = new C1026q();

    /* renamed from: k */
    public static final C1016g f4738k = m4557a(0, 31).mo7626a(m4557a(127, 159));

    /* renamed from: l */
    public static final C1016g f4739l = m4557a(0, ' ').mo7626a(m4557a(127, 160)).mo7626a(m4556a(173)).mo7626a(m4557a(1536, 1539)).mo7626a(m4558a((CharSequence) "۝܏ ឴឵᠎")).mo7626a(m4557a(8192, 8207)).mo7626a(m4557a(8232, 8239)).mo7626a(m4557a(8287, 8292)).mo7626a(m4557a(8298, 8303)).mo7626a(m4556a(12288)).mo7626a(m4557a(55296, 63743)).mo7626a(m4558a((CharSequence) "﻿￹￺￻"));

    /* renamed from: m */
    public static final C1016g f4740m = m4557a(0, 1273).mo7626a(m4556a(1470)).mo7626a(m4557a(1488, 1514)).mo7626a(m4556a(1523)).mo7626a(m4556a(1524)).mo7626a(m4557a(1536, 1791)).mo7626a(m4557a(1872, 1919)).mo7626a(m4557a(3584, 3711)).mo7626a(m4557a(7680, 8367)).mo7626a(m4557a(8448, 8506)).mo7626a(m4557a(64336, 65023)).mo7626a(m4557a(65136, 65279)).mo7626a(m4557a(65377, 65500));

    /* renamed from: n */
    public static final C1016g f4741n = new C1027r();

    /* renamed from: o */
    public static final C1016g f4742o = new C1018i();

    static {
        C1016g a = m4557a('0', '9');
        C1016g gVar = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            gVar = gVar.mo7626a(m4557a(c, (char) (c + 9)));
        }
        f4731d = gVar;
    }

    /* renamed from: a */
    public static C1016g m4556a(char c) {
        return new C1019j(c);
    }

    /* renamed from: a */
    public static C1016g m4557a(char c, char c2) {
        C1009bf.m4536b(c2 >= c);
        return new C1022m(c, c2);
    }

    /* renamed from: a */
    public static C1016g m4558a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f4742o;
            case 1:
                return m4556a(charSequence.charAt(0));
            case 2:
                return new C1020k(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new C1021l(charArray);
        }
    }

    /* renamed from: a */
    public C1016g mo7626a(C1016g gVar) {
        return new C1028s(Arrays.asList(new C1016g[]{this, (C1016g) C1009bf.m4528a(gVar)}));
    }

    /* renamed from: b */
    public abstract boolean mo7627b(char c);

    /* renamed from: b */
    public boolean mo7628b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!mo7627b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
