package com.google.android.gms.internal;

import java.util.BitSet;

/* renamed from: com.google.android.gms.internal.ce */
final class C1467ce extends zzanh {
    C1467ce() {
    }

    /* renamed from: a */
    public BitSet zzb(zzaom zzaom) {
        boolean z;
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        BitSet bitSet = new BitSet();
        zzaom.beginArray();
        zzaon b = zzaom.mo7902b();
        int i = 0;
        while (b != zzaon.END_ARRAY) {
            switch (C1483cu.f4929a[b.ordinal()]) {
                case 1:
                    if (zzaom.nextInt() == 0) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 2:
                    z = zzaom.nextBoolean();
                    break;
                case 3:
                    String nextString = zzaom.nextString();
                    try {
                        if (Integer.parseInt(nextString) == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        String valueOf = String.valueOf(nextString);
                        throw new zzane(valueOf.length() != 0 ? "Error: Expecting: bitset number value (1, 0), Found: ".concat(valueOf) : new String("Error: Expecting: bitset number value (1, 0), Found: "));
                    }
                default:
                    String valueOf2 = String.valueOf(b);
                    throw new zzane(new StringBuilder(String.valueOf(valueOf2).length() + 27).append("Invalid bitset value type: ").append(valueOf2).toString());
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            b = zzaom.mo7902b();
        }
        zzaom.endArray();
        return bitSet;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, BitSet bitSet) {
        if (bitSet == null) {
            zzaoo.mo7926l();
            return;
        }
        zzaoo.mo7922h();
        for (int i = 0; i < bitSet.length(); i++) {
            zzaoo.zzcr((long) (bitSet.get(i) ? 1 : 0));
        }
        zzaoo.mo7923i();
    }
}
