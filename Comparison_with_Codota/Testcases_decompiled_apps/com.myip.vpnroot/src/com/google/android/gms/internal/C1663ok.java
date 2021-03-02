package com.google.android.gms.internal;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C0976c;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ok */
public interface C1663ok {

    /* renamed from: com.google.android.gms.internal.ok$a */
    public static final class C1664a extends C1712pg<C1664a> {
        public long asg;
        public C0976c.C0986j ash;

        /* renamed from: gs */
        public C0976c.C0982f f4343gs;

        public C1664a() {
            mo9924pJ();
        }

        /* renamed from: l */
        public static C1664a m5840l(byte[] bArr) throws C1717pl {
            return (C1664a) C1718pm.m6089a(new C1664a(), bArr);
        }

        /* renamed from: a */
        public void mo4922a(C1710pf pfVar) throws IOException {
            pfVar.mo10057b(1, this.asg);
            if (this.f4343gs != null) {
                pfVar.mo10053a(2, (C1718pm) this.f4343gs);
            }
            if (this.ash != null) {
                pfVar.mo10053a(3, (C1718pm) this.ash);
            }
            super.mo4922a(pfVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4924c() {
            int c = super.mo4924c() + C1710pf.m6004d(1, this.asg);
            if (this.f4343gs != null) {
                c += C1710pf.m6002c(2, (C1718pm) this.f4343gs);
            }
            return this.ash != null ? c + C1710pf.m6002c(3, (C1718pm) this.ash) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1664a)) {
                return false;
            }
            C1664a aVar = (C1664a) o;
            if (this.asg != aVar.asg) {
                return false;
            }
            if (this.f4343gs == null) {
                if (aVar.f4343gs != null) {
                    return false;
                }
            } else if (!this.f4343gs.equals(aVar.f4343gs)) {
                return false;
            }
            if (this.ash == null) {
                if (aVar.ash != null) {
                    return false;
                }
            } else if (!this.ash.equals(aVar.ash)) {
                return false;
            }
            return mo10081a(aVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4343gs == null ? 0 : this.f4343gs.hashCode()) + ((((int) (this.asg ^ (this.asg >>> 32))) + 527) * 31)) * 31;
            if (this.ash != null) {
                i = this.ash.hashCode();
            }
            return ((hashCode + i) * 31) + mo10082qx();
        }

        /* renamed from: p */
        public C1664a mo4923b(C1709pe peVar) throws IOException {
            while (true) {
                int qg = peVar.mo10028qg();
                switch (qg) {
                    case 0:
                        break;
                    case 8:
                        this.asg = peVar.mo10030qi();
                        continue;
                    case 18:
                        if (this.f4343gs == null) {
                            this.f4343gs = new C0976c.C0982f();
                        }
                        peVar.mo10018a(this.f4343gs);
                        continue;
                    case FitnessActivities.FENCING:
                        if (this.ash == null) {
                            this.ash = new C0976c.C0986j();
                        }
                        peVar.mo10018a(this.ash);
                        continue;
                    default:
                        if (!mo10080a(peVar, qg)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* renamed from: pJ */
        public C1664a mo9924pJ() {
            this.asg = 0;
            this.f4343gs = null;
            this.ash = null;
            this.awy = null;
            this.awJ = -1;
            return this;
        }
    }
}
