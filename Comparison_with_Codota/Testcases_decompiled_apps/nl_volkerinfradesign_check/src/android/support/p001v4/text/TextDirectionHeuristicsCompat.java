package android.support.p001v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new C0251e(C0247a.f835a, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new C0251e(C0248b.f838a, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new C0251e(C0248b.f838a, true);
    public static final TextDirectionHeuristicCompat LOCALE = C0252f.f841a;
    public static final TextDirectionHeuristicCompat LTR = new C0251e((C0249c) null, false);
    public static final TextDirectionHeuristicCompat RTL = new C0251e((C0249c) null, true);

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$c */
    interface C0249c {
        /* renamed from: a */
        int mo1550a(CharSequence charSequence, int i, int i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static int m956c(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static int m957d(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$d */
    static abstract class C0250d implements TextDirectionHeuristicCompat {

        /* renamed from: a */
        private final C0249c f839a;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo1551a();

        public C0250d(C0249c cVar) {
            this.f839a = cVar;
        }

        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i, i2);
        }

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f839a == null) {
                return mo1551a();
            } else {
                return m961a(charSequence, i, i2);
            }
        }

        /* renamed from: a */
        private boolean m961a(CharSequence charSequence, int i, int i2) {
            switch (this.f839a.mo1550a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo1551a();
            }
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$e */
    static class C0251e extends C0250d {

        /* renamed from: a */
        private final boolean f840a;

        private C0251e(C0249c cVar, boolean z) {
            super(cVar);
            this.f840a = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo1551a() {
            return this.f840a;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$b */
    static class C0248b implements C0249c {

        /* renamed from: a */
        public static final C0248b f838a = new C0248b();

        /* renamed from: a */
        public int mo1550a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.m957d(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private C0248b() {
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$a */
    static class C0247a implements C0249c {

        /* renamed from: a */
        public static final C0247a f835a = new C0247a(true);

        /* renamed from: b */
        public static final C0247a f836b = new C0247a(false);

        /* renamed from: c */
        private final boolean f837c;

        /* renamed from: a */
        public int mo1550a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (TextDirectionHeuristicsCompat.m956c(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.f837c) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (this.f837c) {
                            z = true;
                            break;
                        } else {
                            return 1;
                        }
                }
                i++;
            }
            if (!z) {
                return 2;
            }
            if (!this.f837c) {
                return 0;
            }
            return 1;
        }

        private C0247a(boolean z) {
            this.f837c = z;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$f */
    static class C0252f extends C0250d {

        /* renamed from: a */
        public static final C0252f f841a = new C0252f();

        public C0252f() {
            super((C0249c) null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo1551a() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }
}
