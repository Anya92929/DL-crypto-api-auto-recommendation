package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.util.BitSet;

/* renamed from: com.google.a.b.a.al */
final class C0379al extends C0363al<BitSet> {
    C0379al() {
    }

    /* renamed from: a */
    public BitSet mo6310b(C0470a aVar) {
        boolean z;
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        BitSet bitSet = new BitSet();
        aVar.mo6375a();
        C0472c f = aVar.mo6381f();
        int i = 0;
        while (f != C0472c.END_ARRAY) {
            switch (f) {
                case NUMBER:
                    if (aVar.mo6388m() == 0) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case BOOLEAN:
                    z = aVar.mo6384i();
                    break;
                case STRING:
                    String h = aVar.mo6383h();
                    try {
                        if (Integer.parseInt(h) == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        throw new C0356ae("Error: Expecting: bitset number value (1, 0), Found: " + h);
                    }
                default:
                    throw new C0356ae("Invalid bitset value type: " + f);
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            f = aVar.mo6381f();
        }
        aVar.mo6376b();
        return bitSet;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, BitSet bitSet) {
        if (bitSet == null) {
            dVar.mo6405f();
            return;
        }
        dVar.mo6399b();
        for (int i = 0; i < bitSet.length(); i++) {
            dVar.mo6394a((long) (bitSet.get(i) ? 1 : 0));
        }
        dVar.mo6401c();
    }
}
