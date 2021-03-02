package com.google.android.gms.internal;

import com.google.android.gms.internal.C0955bq;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.fz */
public final class C1196fz {
    public final int errorCode;
    public final int orientation;

    /* renamed from: qA */
    public final String f3665qA;

    /* renamed from: qB */
    public final C1006co f3666qB;

    /* renamed from: qf */
    public final List<String> f3667qf;

    /* renamed from: qg */
    public final List<String> f3668qg;

    /* renamed from: qj */
    public final long f3669qj;

    /* renamed from: qy */
    public final C1003cl f3670qy;

    /* renamed from: qz */
    public final C1016cu f3671qz;

    /* renamed from: rN */
    public final C1232gv f3672rN;

    /* renamed from: tA */
    public final String f3673tA;

    /* renamed from: tH */
    public final long f3674tH;

    /* renamed from: tI */
    public final boolean f3675tI;

    /* renamed from: tJ */
    public final long f3676tJ;

    /* renamed from: tK */
    public final List<String> f3677tK;

    /* renamed from: tN */
    public final String f3678tN;

    /* renamed from: tx */
    public final C0924av f3679tx;

    /* renamed from: vp */
    public final JSONObject f3680vp;

    /* renamed from: vq */
    public final C1004cm f3681vq;

    /* renamed from: vr */
    public final C0927ay f3682vr;

    /* renamed from: vs */
    public final long f3683vs;

    /* renamed from: vt */
    public final long f3684vt;

    /* renamed from: vu */
    public final C0955bq.C0956a f3685vu;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.fz$a */
    public static final class C1197a {
        public final int errorCode;

        /* renamed from: lH */
        public final C0927ay f3686lH;

        /* renamed from: vp */
        public final JSONObject f3687vp;

        /* renamed from: vq */
        public final C1004cm f3688vq;

        /* renamed from: vs */
        public final long f3689vs;

        /* renamed from: vt */
        public final long f3690vt;

        /* renamed from: vv */
        public final C1168fi f3691vv;

        /* renamed from: vw */
        public final C1171fk f3692vw;

        public C1197a(C1168fi fiVar, C1171fk fkVar, C1004cm cmVar, C0927ay ayVar, int i, long j, long j2, JSONObject jSONObject) {
            this.f3691vv = fiVar;
            this.f3692vw = fkVar;
            this.f3688vq = cmVar;
            this.f3686lH = ayVar;
            this.errorCode = i;
            this.f3689vs = j;
            this.f3690vt = j2;
            this.f3687vp = jSONObject;
        }
    }

    public C1196fz(C0924av avVar, C1232gv gvVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, C1003cl clVar, C1016cu cuVar, String str2, C1004cm cmVar, C1006co coVar, long j2, C0927ay ayVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, C0955bq.C0956a aVar) {
        this.f3679tx = avVar;
        this.f3672rN = gvVar;
        this.f3667qf = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.f3668qg = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f3677tK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.f3669qj = j;
        this.f3673tA = str;
        this.f3675tI = z;
        this.f3670qy = clVar;
        this.f3671qz = cuVar;
        this.f3665qA = str2;
        this.f3681vq = cmVar;
        this.f3666qB = coVar;
        this.f3676tJ = j2;
        this.f3682vr = ayVar;
        this.f3674tH = j3;
        this.f3683vs = j4;
        this.f3684vt = j5;
        this.f3678tN = str3;
        this.f3680vp = jSONObject;
        this.f3685vu = aVar;
    }

    public C1196fz(C1197a aVar, C1232gv gvVar, C1003cl clVar, C1016cu cuVar, String str, C1006co coVar, C0955bq.C0956a aVar2) {
        this(aVar.f3691vv.f3539tx, gvVar, aVar.f3692vw.f3555qf, aVar.errorCode, aVar.f3692vw.f3556qg, aVar.f3692vw.f3564tK, aVar.f3692vw.orientation, aVar.f3692vw.f3557qj, aVar.f3691vv.f3532tA, aVar.f3692vw.f3562tI, clVar, cuVar, str, aVar.f3688vq, coVar, aVar.f3692vw.f3563tJ, aVar.f3686lH, aVar.f3692vw.f3561tH, aVar.f3689vs, aVar.f3690vt, aVar.f3692vw.f3567tN, aVar.f3687vp, aVar2);
    }
}
