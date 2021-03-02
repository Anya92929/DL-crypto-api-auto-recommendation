package android.support.p000v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, false);
    public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, true);

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong */
    class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);

        /* renamed from: a */
        private final boolean f1076a;

        private AnyStrong(boolean z) {
            this.f1076a = z;
        }

        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (TextDirectionHeuristicsCompat.m796c(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.f1076a) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (this.f1076a) {
                            z = true;
                            break;
                        } else {
                            return 1;
                        }
                }
                i++;
            }
            if (z) {
                return !this.f1076a ? 0 : 1;
            }
            return 2;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong */
    class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong INSTANCE = new FirstStrong();

        private FirstStrong() {
        }

        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.m797d(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm */
    interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl */
    abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* renamed from: a */
        private final TextDirectionAlgorithm f1077a;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f1077a = textDirectionAlgorithm;
        }

        /* renamed from: a */
        private boolean m798a(CharSequence charSequence, int i, int i2) {
            switch (this.f1077a.checkRtl(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo1907a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo1907a();

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                return this.f1077a == null ? mo1907a() : m798a(charSequence, i, i2);
            }
            throw new IllegalArgumentException();
        }

        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i, i2);
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal */
    class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* renamed from: a */
        private final boolean f1078a;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.f1078a = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo1907a() {
            return this.f1078a;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale */
    class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super((TextDirectionAlgorithm) null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo1907a() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static int m796c(int i) {
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
    public static int m797d(int i) {
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
}
