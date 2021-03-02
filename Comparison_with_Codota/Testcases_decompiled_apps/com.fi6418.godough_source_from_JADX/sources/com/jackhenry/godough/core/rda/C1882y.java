package com.jackhenry.godough.core.rda;

import com.jackhenry.godough.core.model.Deposit;

/* renamed from: com.jackhenry.godough.core.rda.y */
/* synthetic */ class C1882y {

    /* renamed from: a */
    static final /* synthetic */ int[] f6775a = new int[Deposit.Side.values().length];

    static {
        try {
            f6775a[Deposit.Side.FRONT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6775a[Deposit.Side.BACK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
