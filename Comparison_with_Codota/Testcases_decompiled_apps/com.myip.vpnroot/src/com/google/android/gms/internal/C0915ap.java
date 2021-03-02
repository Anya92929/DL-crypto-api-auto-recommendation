package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.C0920as;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/* renamed from: com.google.android.gms.internal.ap */
public class C0915ap {

    /* renamed from: nJ */
    private final int f2599nJ;

    /* renamed from: nK */
    private final int f2600nK;

    /* renamed from: nL */
    private final C0914ao f2601nL = new C0919ar();

    /* renamed from: nM */
    private Base64OutputStream f2602nM;

    /* renamed from: nN */
    private ByteArrayOutputStream f2603nN;

    public C0915ap(int i) {
        this.f2600nK = i;
        this.f2599nJ = 6;
    }

    /* renamed from: m */
    private String m3888m(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.f2603nN = new ByteArrayOutputStream();
        this.f2602nM = new Base64OutputStream(this.f2603nN, 10);
        Arrays.sort(split, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int i = 0;
        while (i < split.length && i < this.f2600nK) {
            if (split[i].trim().length() != 0) {
                try {
                    this.f2602nM.write(this.f2601nL.mo8001l(split[i]));
                } catch (IOException e) {
                    C1229gs.m4681b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        try {
            this.f2602nM.flush();
            this.f2602nM.close();
            return this.f2603nN.toString();
        } catch (IOException e2) {
            C1229gs.m4681b("HashManager: Unable to convert to base 64", e2);
            return "";
        }
    }

    /* renamed from: a */
    public String mo8002a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase());
            stringBuffer.append(10);
        }
        switch (0) {
            case 0:
                return mo8003n(stringBuffer.toString());
            case 1:
                return m3888m(stringBuffer.toString());
            default:
                return "";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public String mo8003n(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.f2603nN = new ByteArrayOutputStream();
        this.f2602nM = new Base64OutputStream(this.f2603nN, 10);
        PriorityQueue priorityQueue = new PriorityQueue(this.f2600nK, new Comparator<C0920as.C0921a>() {
            /* renamed from: a */
            public int compare(C0920as.C0921a aVar, C0920as.C0921a aVar2) {
                return (int) (aVar.value - aVar2.value);
            }
        });
        for (String p : split) {
            String[] p2 = C0918aq.m3895p(p);
            if (p2.length >= this.f2599nJ) {
                C0920as.m3902a(p2, this.f2600nK, this.f2599nJ, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                this.f2602nM.write(this.f2601nL.mo8001l(((C0920as.C0921a) it.next()).f2607nQ));
            } catch (IOException e) {
                C1229gs.m4681b("Error while writing hash to byteStream", e);
            }
        }
        try {
            this.f2602nM.flush();
            this.f2602nM.close();
            return this.f2603nN.toString();
        } catch (IOException e2) {
            C1229gs.m4681b("HashManager: unable to convert to base 64", e2);
            return "";
        }
    }
}
