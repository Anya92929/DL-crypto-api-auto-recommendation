package com.google.android.gms.p018c;

import java.io.IOException;

/* renamed from: com.google.android.gms.c.bm */
public class C0651bm extends IOException {
    C0651bm(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
    }
}
