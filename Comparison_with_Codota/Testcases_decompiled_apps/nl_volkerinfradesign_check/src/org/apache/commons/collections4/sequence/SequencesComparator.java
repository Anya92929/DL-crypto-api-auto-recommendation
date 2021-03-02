package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

public class SequencesComparator<T> {

    /* renamed from: a */
    private final List<T> f6747a;

    /* renamed from: b */
    private final List<T> f6748b;

    /* renamed from: c */
    private final Equator<? super T> f6749c;

    /* renamed from: d */
    private final int[] f6750d;

    /* renamed from: e */
    private final int[] f6751e;

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.f6747a = list;
        this.f6748b = list2;
        this.f6749c = equator;
        int size = list.size() + list2.size() + 2;
        this.f6750d = new int[size];
        this.f6751e = new int[size];
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        m7171a(0, this.f6747a.size(), 0, this.f6748b.size(), editScript);
        return editScript;
    }

    /* renamed from: a */
    private C1921a m7170a(int i, int i2, int i3, int i4) {
        int i5 = i;
        while (i5 - i2 < i4 && i5 < i3 && this.f6749c.equate(this.f6747a.get(i5), this.f6748b.get(i5 - i2))) {
            i5++;
        }
        return new C1921a(i, i5, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0138, code lost:
        r4 = r4 + 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.collections4.sequence.SequencesComparator.C1921a m7172b(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            int r0 = r12 - r11
            int r1 = r14 - r13
            if (r0 == 0) goto L_0x0008
            if (r1 != 0) goto L_0x000a
        L_0x0008:
            r0 = 0
        L_0x0009:
            return r0
        L_0x000a:
            int r5 = r0 - r1
            int r0 = r0 + r1
            int r1 = r0 % 2
            if (r1 != 0) goto L_0x0071
        L_0x0011:
            int r6 = r0 / 2
            int[] r0 = r10.f6750d
            int r1 = r6 + 1
            r0[r1] = r11
            int[] r0 = r10.f6751e
            int r1 = r6 + 1
            int r2 = r12 + 1
            r0[r1] = r2
            r0 = 0
            r4 = r0
        L_0x0023:
            if (r4 > r6) goto L_0x013d
            int r0 = -r4
            r2 = r0
        L_0x0027:
            if (r2 > r4) goto L_0x00ad
            int r3 = r2 + r6
            int r0 = -r4
            if (r2 == r0) goto L_0x003e
            if (r2 == r4) goto L_0x0074
            int[] r0 = r10.f6750d
            int r1 = r3 + -1
            r0 = r0[r1]
            int[] r1 = r10.f6750d
            int r7 = r3 + 1
            r1 = r1[r7]
            if (r0 >= r1) goto L_0x0074
        L_0x003e:
            int[] r0 = r10.f6750d
            int[] r1 = r10.f6750d
            int r7 = r3 + 1
            r1 = r1[r7]
            r0[r3] = r1
        L_0x0048:
            int[] r0 = r10.f6750d
            r1 = r0[r3]
            int r0 = r1 - r11
            int r0 = r0 + r13
            int r0 = r0 - r2
        L_0x0050:
            if (r1 >= r12) goto L_0x0081
            if (r0 >= r14) goto L_0x0081
            org.apache.commons.collections4.Equator<? super T> r7 = r10.f6749c
            java.util.List<T> r8 = r10.f6747a
            java.lang.Object r8 = r8.get(r1)
            java.util.List<T> r9 = r10.f6748b
            java.lang.Object r9 = r9.get(r0)
            boolean r7 = r7.equate(r8, r9)
            if (r7 == 0) goto L_0x0081
            int[] r7 = r10.f6750d
            int r1 = r1 + 1
            r7[r3] = r1
            int r0 = r0 + 1
            goto L_0x0050
        L_0x0071:
            int r0 = r0 + 1
            goto L_0x0011
        L_0x0074:
            int[] r0 = r10.f6750d
            int[] r1 = r10.f6750d
            int r7 = r3 + -1
            r1 = r1[r7]
            int r1 = r1 + 1
            r0[r3] = r1
            goto L_0x0048
        L_0x0081:
            int r0 = r5 % 2
            if (r0 == 0) goto L_0x00a8
            int r0 = r5 - r4
            if (r0 > r2) goto L_0x00a8
            int r0 = r5 + r4
            if (r2 > r0) goto L_0x00a8
            int[] r0 = r10.f6751e
            int r1 = r3 - r5
            r0 = r0[r1]
            int[] r1 = r10.f6750d
            r1 = r1[r3]
            if (r0 > r1) goto L_0x00a8
            int[] r0 = r10.f6751e
            int r1 = r3 - r5
            r0 = r0[r1]
            int r1 = r2 + r11
            int r1 = r1 - r13
            org.apache.commons.collections4.sequence.SequencesComparator$a r0 = r10.m7170a(r0, r1, r12, r14)
            goto L_0x0009
        L_0x00a8:
            int r0 = r2 + 2
            r2 = r0
            goto L_0x0027
        L_0x00ad:
            int r0 = r5 - r4
            r3 = r0
        L_0x00b0:
            int r0 = r5 + r4
            if (r3 > r0) goto L_0x0138
            int r0 = r3 + r6
            int r7 = r0 - r5
            int r0 = r5 - r4
            if (r3 == r0) goto L_0x00ce
            int r0 = r5 + r4
            if (r3 == r0) goto L_0x0106
            int[] r0 = r10.f6751e
            int r1 = r7 + 1
            r0 = r0[r1]
            int[] r1 = r10.f6751e
            int r2 = r7 + -1
            r1 = r1[r2]
            if (r0 > r1) goto L_0x0106
        L_0x00ce:
            int[] r0 = r10.f6751e
            int[] r1 = r10.f6751e
            int r2 = r7 + 1
            r1 = r1[r2]
            int r1 = r1 + -1
            r0[r7] = r1
        L_0x00da:
            int[] r0 = r10.f6751e
            r0 = r0[r7]
            int r1 = r0 + -1
            int r0 = r1 - r11
            int r0 = r0 + r13
            int r0 = r0 - r3
        L_0x00e4:
            if (r1 < r11) goto L_0x0111
            if (r0 < r13) goto L_0x0111
            org.apache.commons.collections4.Equator<? super T> r2 = r10.f6749c
            java.util.List<T> r8 = r10.f6747a
            java.lang.Object r8 = r8.get(r1)
            java.util.List<T> r9 = r10.f6748b
            java.lang.Object r9 = r9.get(r0)
            boolean r2 = r2.equate(r8, r9)
            if (r2 == 0) goto L_0x0111
            int[] r8 = r10.f6751e
            int r2 = r1 + -1
            r8[r7] = r1
            int r0 = r0 + -1
            r1 = r2
            goto L_0x00e4
        L_0x0106:
            int[] r0 = r10.f6751e
            int[] r1 = r10.f6751e
            int r2 = r7 + -1
            r1 = r1[r2]
            r0[r7] = r1
            goto L_0x00da
        L_0x0111:
            int r0 = r5 % 2
            if (r0 != 0) goto L_0x0133
            int r0 = -r4
            if (r0 > r3) goto L_0x0133
            if (r3 > r4) goto L_0x0133
            int[] r0 = r10.f6751e
            r0 = r0[r7]
            int[] r1 = r10.f6750d
            int r2 = r7 + r5
            r1 = r1[r2]
            if (r0 > r1) goto L_0x0133
            int[] r0 = r10.f6751e
            r0 = r0[r7]
            int r1 = r3 + r11
            int r1 = r1 - r13
            org.apache.commons.collections4.sequence.SequencesComparator$a r0 = r10.m7170a(r0, r1, r12, r14)
            goto L_0x0009
        L_0x0133:
            int r0 = r3 + 2
            r3 = r0
            goto L_0x00b0
        L_0x0138:
            int r0 = r4 + 1
            r4 = r0
            goto L_0x0023
        L_0x013d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal Error"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.sequence.SequencesComparator.m7172b(int, int, int, int):org.apache.commons.collections4.sequence.SequencesComparator$a");
    }

    /* renamed from: a */
    private void m7171a(int i, int i2, int i3, int i4, EditScript<T> editScript) {
        C1921a b = m7172b(i, i2, i3, i4);
        if (b == null || ((b.mo12265a() == i2 && b.mo12267c() == i2 - i4) || (b.mo12266b() == i && b.mo12267c() == i - i3))) {
            int i5 = i3;
            int i6 = i;
            while (true) {
                if (i6 >= i2 && i5 >= i4) {
                    return;
                }
                if (i6 < i2 && i5 < i4 && this.f6749c.equate(this.f6747a.get(i6), this.f6748b.get(i5))) {
                    editScript.append((KeepCommand<T>) new KeepCommand(this.f6747a.get(i6)));
                    i6++;
                    i5++;
                } else if (i2 - i > i4 - i3) {
                    editScript.append((DeleteCommand<T>) new DeleteCommand(this.f6747a.get(i6)));
                    i6++;
                } else {
                    editScript.append((InsertCommand<T>) new InsertCommand(this.f6748b.get(i5)));
                    i5++;
                }
            }
        } else {
            m7171a(i, b.mo12265a(), i3, b.mo12265a() - b.mo12267c(), editScript);
            for (int a = b.mo12265a(); a < b.mo12266b(); a++) {
                editScript.append((KeepCommand<T>) new KeepCommand(this.f6747a.get(a)));
            }
            m7171a(b.mo12266b(), i2, b.mo12266b() - b.mo12267c(), i4, editScript);
        }
    }

    /* renamed from: org.apache.commons.collections4.sequence.SequencesComparator$a */
    static class C1921a {

        /* renamed from: a */
        private final int f6752a;

        /* renamed from: b */
        private final int f6753b;

        /* renamed from: c */
        private final int f6754c;

        public C1921a(int i, int i2, int i3) {
            this.f6752a = i;
            this.f6753b = i2;
            this.f6754c = i3;
        }

        /* renamed from: a */
        public int mo12265a() {
            return this.f6752a;
        }

        /* renamed from: b */
        public int mo12266b() {
            return this.f6753b;
        }

        /* renamed from: c */
        public int mo12267c() {
            return this.f6754c;
        }
    }
}
