package com.jackhenry.godough.core.cards;

import com.jackhenry.godough.core.model.CardActions;

/* renamed from: com.jackhenry.godough.core.cards.f */
/* synthetic */ class C1555f {

    /* renamed from: a */
    static final /* synthetic */ int[] f6107a = new int[CardActions.Action.values().length];

    static {
        try {
            f6107a[CardActions.Action.ACTIVATE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6107a[CardActions.Action.REORDER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6107a[CardActions.Action.REPORT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6107a[CardActions.Action.SUSPEND.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}