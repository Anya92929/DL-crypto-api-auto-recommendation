package com.google.android.gms.internal;

import android.webkit.ConsoleMessage;

/* renamed from: com.google.android.gms.internal.no */
/* synthetic */ class C1774no {

    /* renamed from: a */
    static final /* synthetic */ int[] f5398a = new int[ConsoleMessage.MessageLevel.values().length];

    static {
        try {
            f5398a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5398a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5398a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5398a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5398a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
