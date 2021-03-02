package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C2159y implements C2005aq {
    private static C2159y aoQ;

    /* renamed from: xz */
    private static final Object f4608xz = new Object();
    private String aoR;
    private String aoS;
    private C2006ar aoT;
    private C2058cg aoh;

    private C2159y(Context context) {
        this(C2007as.m6770Y(context), new C2095cw());
    }

    C2159y(C2006ar arVar, C2058cg cgVar) {
        this.aoT = arVar;
        this.aoh = cgVar;
    }

    /* renamed from: W */
    public static C2005aq m7281W(Context context) {
        C2159y yVar;
        synchronized (f4608xz) {
            if (aoQ == null) {
                aoQ = new C2159y(context);
            }
            yVar = aoQ;
        }
        return yVar;
    }

    /* renamed from: cw */
    public boolean mo11556cw(String str) {
        if (!this.aoh.mo11572eK()) {
            C2028bh.m6819W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        if (!(this.aoR == null || this.aoS == null)) {
            try {
                str = this.aoR + "?" + this.aoS + "=" + URLEncoder.encode(str, "UTF-8");
                C2028bh.m6818V("Sending wrapped url hit: " + str);
            } catch (UnsupportedEncodingException e) {
                C2028bh.m6821d("Error wrapping URL for testing.", e);
                return false;
            }
        }
        this.aoT.mo11558cz(str);
        return true;
    }
}
