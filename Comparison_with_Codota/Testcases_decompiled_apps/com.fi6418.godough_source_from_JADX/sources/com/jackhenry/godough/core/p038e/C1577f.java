package com.jackhenry.godough.core.p038e;

import com.jackhenry.godough.core.C1493ah;

/* renamed from: com.jackhenry.godough.core.e.f */
public enum C1577f {
    INFO(C1493ah.dialog_header_info, C1493ah.message_icon_general),
    ERROR(C1493ah.dialog_header_error, C1493ah.message_icon_error),
    SUCCESS(C1493ah.dialog_header_success, C1493ah.message_icon_confirm),
    NO_HEADER(-1, -1);
    

    /* renamed from: e */
    private int f6154e;

    /* renamed from: f */
    private int f6155f;

    private C1577f(int i, int i2) {
        this.f6154e = i;
        this.f6155f = i2;
    }
}
