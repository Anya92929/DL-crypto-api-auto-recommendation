package com.google.android.gms.common;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.common.j */
class C1051j {

    /* renamed from: a */
    static final C1078k[] f4793a = {C0873et.f4608a[0], C0876ew.f4609a[0], C0852dz.f4593a[0], C1065jn.f4801a[0], C0767av.f4561a[0], C1053jb.f4797a[0], C0856ec.f4602a[0], C0786bn.f4569a[0], C1062jk.f4800a[0], C1056je.f4798a[0], C0849dw.f4592a[0], C0821cv.f4582a[0], C0865el.f4605a[0], C1106x.f4871a[0], C0818cs.f4581a[0], C0867en.f4606a[0], C0943hi.f4638a[0], C0783bk.f4568a[0], C0922go.f4629a[0], C0925gr.f4630a[0], C0913gf.f4626a[0], C0764as.f4560a[0], C0798bz.f4573a[0], C0792bt.f4571a[0], C0795bw.f4572a[0], C0919gl.f4628a[0], C0960hz.f4644a[0], C0698am.f4408a[0], C0701ap.f4409a[0], C0837dk.f4588a[0], C0808ci.f4577a[0], C0970ii.f4647a[0], C0970ii.f4647a[1], C0686aa.f4404a[0], C1103u.f4870a[0], C0964ic.f4645a[0], C0952hr.f4641a[0], C0940hf.f4637a[0], C0805cf.f4576a[0], C0897fq.f4620a[0], C0897fq.f4620a[1], C0789bq.f4570a[0], C0802cc.f4575a[0], C0695aj.f4407a[0], C1073jv.f4804a[0], C0780bh.f4567a[0], C1084l.f4809a[0], C0815cp.f4580a[0], C0931gx.f4632a[0], C0937hc.f4636a[0], C0834dh.f4587a[0], C0870eq.f4607a[0], C0946hl.f4639a[0], C0888fh.f4615a[0], C0862ei.f4604a[0], C0831de.f4586a[0], C1071jt.f4803a[0], C0774bb.f4565a[0], C0885fe.f4614a[0], C0975in.f4648a[0], C1080kb.f4807a[0], C0777be.f4566a[0], C0843dq.f4590a[0], C0892fl.f4618a[0], C1041iq.f4789a[0], C0692ag.f4406a[0], C0812cm.f4579a[0], C0916gi.f4627a[0], C1087o.f4810a[0], C0957hw.f4643a[0], C0911gd.f4625a[0], C0967if.f4646a[0], C0828db.f4585a[0], C0901fu.f4621a[0], C1049iy.f4792a[0], C1059jh.f4799a[0], C1046iv.f4791a[0], C1076jy.f4805a[0], C0840dn.f4589a[0], C1068jq.f4802a[0], C0882fb.f4613a[0], C0846dt.f4591a[0], C0824cy.f4583a[0], C0879ez.f4610a[0], C0908ga.f4624a[0], C0689ad.f4405a[0], C0928gu.f4631a[0], C0949ho.f4640a[0], C1090r.f4811a[0], C0894fn.f4619a[0], C0770ay.f4562a[0], C0859ef.f4603a[0], C0904fx.f4622a[0], C0933gz.f4633a[0], C0955hu.f4642a[0]};

    /* renamed from: b */
    static final C1078k[] f4794b = m4703a(C0873et.f4608a, C0876ew.f4609a, C1044it.f4790a, C0852dz.f4593a, C1065jn.f4801a, C0767av.f4561a, C1053jb.f4797a, C0856ec.f4602a, C0786bn.f4569a, C1062jk.f4800a, C1056je.f4798a, C0849dw.f4592a, C0821cv.f4582a, C0865el.f4605a, C1106x.f4871a, C0818cs.f4581a, C0867en.f4606a, C0943hi.f4638a, C0783bk.f4568a, C0922go.f4629a, C0925gr.f4630a, C0913gf.f4626a, C0764as.f4560a, C0798bz.f4573a, C0792bt.f4571a, C0795bw.f4572a, C0919gl.f4628a, C0960hz.f4644a, C0698am.f4408a, C0701ap.f4409a, C0837dk.f4588a, C0808ci.f4577a, C0970ii.f4647a, C0686aa.f4404a, C1103u.f4870a, C0964ic.f4645a, C0952hr.f4641a, C0940hf.f4637a, C0805cf.f4576a, C0897fq.f4620a, C0789bq.f4570a, C0802cc.f4575a, C0695aj.f4407a, C1073jv.f4804a, C0780bh.f4567a, C1084l.f4809a, C0815cp.f4580a, C0931gx.f4632a, C0937hc.f4636a, C0834dh.f4587a, C0870eq.f4607a, C0946hl.f4639a, C0888fh.f4615a, C0862ei.f4604a, C0831de.f4586a, C1071jt.f4803a, C0774bb.f4565a, C0885fe.f4614a, C0975in.f4648a, C1080kb.f4807a, C0777be.f4566a, C0843dq.f4590a, C0892fl.f4618a, C1041iq.f4789a, C0692ag.f4406a, C0812cm.f4579a, C0916gi.f4627a, C1087o.f4810a, C0957hw.f4643a, C0911gd.f4625a, C0967if.f4646a, C0828db.f4585a, C0901fu.f4621a, C1049iy.f4792a, C1059jh.f4799a, C1046iv.f4791a, C1076jy.f4805a, C0840dn.f4589a, C1068jq.f4802a, C0882fb.f4613a, C0846dt.f4591a, C0824cy.f4583a, C0879ez.f4610a, C0908ga.f4624a, C0689ad.f4405a, C0928gu.f4631a, C0949ho.f4640a, C1090r.f4811a, C0894fn.f4619a, C0770ay.f4562a, C0859ef.f4603a, C0904fx.f4622a, C0933gz.f4633a, C0955hu.f4642a);

    /* renamed from: c */
    private static Set<C1078k> f4795c;

    /* renamed from: d */
    private static Set<C1078k> f4796d;

    /* renamed from: a */
    static Set<C1078k> m4701a() {
        if (f4795c == null) {
            f4795c = m4702a(f4794b);
        }
        return f4795c;
    }

    /* renamed from: a */
    private static Set<C1078k> m4702a(C1078k[] kVarArr) {
        HashSet hashSet = new HashSet(kVarArr.length);
        for (C1078k add : kVarArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    /* renamed from: a */
    static C1078k[] m4703a(C1078k[]... kVarArr) {
        int i = 0;
        for (C1078k[] length : kVarArr) {
            i += length.length;
        }
        C1078k[] kVarArr2 = new C1078k[i];
        int length2 = kVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            C1078k[] kVarArr3 = kVarArr[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < kVarArr3.length) {
                kVarArr2[i4] = kVarArr3[i5];
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        return kVarArr2;
    }

    /* renamed from: b */
    static Set<C1078k> m4704b() {
        if (f4796d == null) {
            f4796d = m4702a(f4793a);
        }
        return f4796d;
    }
}
