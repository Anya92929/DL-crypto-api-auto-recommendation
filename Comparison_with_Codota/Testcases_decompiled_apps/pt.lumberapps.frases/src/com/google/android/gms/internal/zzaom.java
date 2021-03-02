package com.google.android.gms.internal;

import android.support.p021v7.p023b.C0515k;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzaom implements Closeable {

    /* renamed from: a */
    private static final char[] f5851a = ")]}'\n".toCharArray();

    /* renamed from: b */
    private final Reader f5852b;

    /* renamed from: c */
    private boolean f5853c = false;

    /* renamed from: d */
    private final char[] f5854d = new char[1024];

    /* renamed from: e */
    private int f5855e = 0;

    /* renamed from: f */
    private int f5856f = 0;

    /* renamed from: g */
    private int f5857g = 0;

    /* renamed from: h */
    private int f5858h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f5859i = 0;

    /* renamed from: j */
    private long f5860j;

    /* renamed from: k */
    private int f5861k;

    /* renamed from: l */
    private String f5862l;

    /* renamed from: m */
    private int[] f5863m = new int[32];

    /* renamed from: n */
    private int f5864n = 0;

    /* renamed from: o */
    private String[] f5865o;

    /* renamed from: p */
    private int[] f5866p;

    static {
        zzanr.beV = new C1499dj();
    }

    public zzaom(Reader reader) {
        int[] iArr = this.f5863m;
        int i = this.f5864n;
        this.f5864n = i + 1;
        iArr[i] = 6;
        this.f5865o = new String[32];
        this.f5866p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f5852b = reader;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m6724a() {
        int i = this.f5863m[this.f5864n - 1];
        if (i == 1) {
            this.f5863m[this.f5864n - 1] = 2;
        } else if (i == 2) {
            switch (m6727a(true)) {
                case C0515k.AppCompatTheme_dialogPreferredPadding:
                    break;
                case C0515k.AppCompatTheme_toolbarStyle:
                    m6744i();
                    break;
                case C0515k.AppCompatTheme_alertDialogStyle:
                    this.f5859i = 4;
                    return 4;
                default:
                    throw m6732b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f5863m[this.f5864n - 1] = 4;
            if (i == 5) {
                switch (m6727a(true)) {
                    case C0515k.AppCompatTheme_dialogPreferredPadding:
                        break;
                    case C0515k.AppCompatTheme_toolbarStyle:
                        m6744i();
                        break;
                    case 125:
                        this.f5859i = 2;
                        return 2;
                    default:
                        throw m6732b("Unterminated object");
                }
            }
            int a = m6727a(true);
            switch (a) {
                case C0515k.AppCompatTheme_actionModePasteDrawable:
                    this.f5859i = 13;
                    return 13;
                case C0515k.AppCompatTheme_actionModePopupWindowStyle:
                    m6744i();
                    this.f5859i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f5859i = 2;
                        return 2;
                    }
                    throw m6732b("Expected name");
                default:
                    m6744i();
                    this.f5855e--;
                    if (m6729a((char) a)) {
                        this.f5859i = 14;
                        return 14;
                    }
                    throw m6732b("Expected name");
            }
        } else if (i == 4) {
            this.f5863m[this.f5864n - 1] = 5;
            switch (m6727a(true)) {
                case C0515k.AppCompatTheme_activityChooserViewStyle:
                    break;
                case C0515k.AppCompatTheme_popupMenuStyle:
                    m6744i();
                    if ((this.f5855e < this.f5856f || m6734b(1)) && this.f5854d[this.f5855e] == '>') {
                        this.f5855e++;
                        break;
                    }
                default:
                    throw m6732b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f5853c) {
                m6747l();
            }
            this.f5863m[this.f5864n - 1] = 7;
        } else if (i == 7) {
            if (m6727a(false) == -1) {
                this.f5859i = 17;
                return 17;
            }
            m6744i();
            this.f5855e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m6727a(true)) {
            case C0515k.AppCompatTheme_actionModePasteDrawable:
                if (this.f5864n == 1) {
                    m6744i();
                }
                this.f5859i = 9;
                return 9;
            case C0515k.AppCompatTheme_actionModePopupWindowStyle:
                m6744i();
                this.f5859i = 8;
                return 8;
            case C0515k.AppCompatTheme_dialogPreferredPadding:
            case C0515k.AppCompatTheme_toolbarStyle:
                break;
            case C0515k.AppCompatTheme_controlBackground:
                this.f5859i = 3;
                return 3;
            case C0515k.AppCompatTheme_alertDialogStyle:
                if (i == 1) {
                    this.f5859i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f5859i = 1;
                return 1;
            default:
                this.f5855e--;
                if (this.f5864n == 1) {
                    m6744i();
                }
                int c = m6735c();
                if (c != 0) {
                    return c;
                }
                int d = m6738d();
                if (d != 0) {
                    return d;
                }
                if (!m6729a(this.f5854d[this.f5855e])) {
                    throw m6732b("Expected value");
                }
                m6744i();
                this.f5859i = 10;
                return 10;
        }
        if (i == 1 || i == 2) {
            m6744i();
            this.f5855e--;
            this.f5859i = 7;
            return 7;
        }
        throw m6732b("Unexpected value");
    }

    /* renamed from: a */
    private int m6727a(boolean z) {
        char[] cArr = this.f5854d;
        int i = this.f5855e;
        int i2 = this.f5856f;
        while (true) {
            if (i == i2) {
                this.f5855e = i;
                if (m6734b(1)) {
                    i = this.f5855e;
                    i2 = this.f5856f;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(m6742g()).append(" column ").append(m6743h()).toString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.f5857g++;
                this.f5858h = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.f5855e = i3;
                if (i3 == i2) {
                    this.f5855e--;
                    boolean b = m6734b(2);
                    this.f5855e++;
                    if (!b) {
                        return c;
                    }
                }
                m6744i();
                switch (cArr[this.f5855e]) {
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        this.f5855e++;
                        if (m6730a("*/")) {
                            i = this.f5855e + 2;
                            i2 = this.f5856f;
                            break;
                        } else {
                            throw m6732b("Unterminated comment");
                        }
                    case C0515k.AppCompatTheme_dropdownListPreferredItemHeight:
                        this.f5855e++;
                        m6745j();
                        i = this.f5855e;
                        i2 = this.f5856f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f5855e = i3;
                m6744i();
                m6745j();
                i = this.f5855e;
                i2 = this.f5856f;
            } else {
                this.f5855e = i3;
                return c;
            }
        }
    }

    /* renamed from: a */
    private void m6728a(int i) {
        if (this.f5864n == this.f5863m.length) {
            int[] iArr = new int[(this.f5864n * 2)];
            int[] iArr2 = new int[(this.f5864n * 2)];
            String[] strArr = new String[(this.f5864n * 2)];
            System.arraycopy(this.f5863m, 0, iArr, 0, this.f5864n);
            System.arraycopy(this.f5866p, 0, iArr2, 0, this.f5864n);
            System.arraycopy(this.f5865o, 0, strArr, 0, this.f5864n);
            this.f5863m = iArr;
            this.f5866p = iArr2;
            this.f5865o = strArr;
        }
        int[] iArr3 = this.f5863m;
        int i2 = this.f5864n;
        this.f5864n = i2 + 1;
        iArr3[i2] = i;
    }

    /* renamed from: a */
    private boolean m6729a(char c) {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case C0515k.AppCompatTheme_dialogPreferredPadding:
            case C0515k.AppCompatTheme_activityChooserViewStyle:
            case C0515k.AppCompatTheme_controlBackground:
            case C0515k.AppCompatTheme_alertDialogStyle:
            case '{':
            case '}':
                break;
            case C0515k.AppCompatTheme_actionModeSelectAllDrawable:
            case C0515k.AppCompatTheme_dropdownListPreferredItemHeight:
            case C0515k.AppCompatTheme_toolbarStyle:
            case C0515k.AppCompatTheme_popupMenuStyle:
            case C0515k.AppCompatTheme_colorBackgroundFloating:
                m6744i();
                break;
            default:
                return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m6730a(String str) {
        while (true) {
            if (this.f5855e + str.length() > this.f5856f && !m6734b(str.length())) {
                return false;
            }
            if (this.f5854d[this.f5855e] == 10) {
                this.f5857g++;
                this.f5858h = this.f5855e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f5854d[this.f5855e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f5855e++;
        }
    }

    /* renamed from: b */
    private IOException m6732b(String str) {
        int g = m6742g();
        int h = m6743h();
        String path = getPath();
        throw new zzaop(new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length()).append(str).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    /* renamed from: b */
    private String m6733b(char c) {
        char[] cArr = this.f5854d;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f5855e;
            int i2 = this.f5856f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f5855e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.f5855e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(m6746k());
                    i = this.f5855e;
                    i2 = this.f5856f;
                    i4 = i;
                } else if (c2 == 10) {
                    this.f5857g++;
                    this.f5858h = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.f5855e = i3;
        } while (m6734b(1));
        throw m6732b("Unterminated string");
    }

    /* renamed from: b */
    private boolean m6734b(int i) {
        char[] cArr = this.f5854d;
        this.f5858h -= this.f5855e;
        if (this.f5856f != this.f5855e) {
            this.f5856f -= this.f5855e;
            System.arraycopy(cArr, this.f5855e, cArr, 0, this.f5856f);
        } else {
            this.f5856f = 0;
        }
        this.f5855e = 0;
        do {
            int read = this.f5852b.read(cArr, this.f5856f, cArr.length - this.f5856f);
            if (read == -1) {
                return false;
            }
            this.f5856f = read + this.f5856f;
            if (this.f5857g == 0 && this.f5858h == 0 && this.f5856f > 0 && cArr[0] == 65279) {
                this.f5855e++;
                this.f5858h++;
                i++;
            }
        } while (this.f5856f < i);
        return true;
    }

    /* renamed from: c */
    private int m6735c() {
        String str;
        String str2;
        int i;
        char c = this.f5854d[this.f5855e];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f5855e + i2 >= this.f5856f && !m6734b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f5854d[this.f5855e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f5855e + length < this.f5856f || m6734b(length + 1)) && m6729a(this.f5854d[this.f5855e + length])) {
            return 0;
        }
        this.f5855e += length;
        this.f5859i = i;
        return i;
    }

    /* renamed from: c */
    private void m6737c(char c) {
        char[] cArr = this.f5854d;
        do {
            int i = this.f5855e;
            int i2 = this.f5856f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f5855e = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.f5855e = i4;
                    m6746k();
                    i4 = this.f5855e;
                    i2 = this.f5856f;
                } else if (c2 == 10) {
                    this.f5857g++;
                    this.f5858h = i4;
                }
                i3 = i4;
            }
            this.f5855e = i3;
        } while (m6734b(1));
        throw m6732b("Unterminated string");
    }

    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m6738d() {
        /*
            r15 = this;
            char[] r11 = r15.f5854d
            int r2 = r15.f5855e
            int r1 = r15.f5856f
            r6 = 0
            r5 = 0
            r4 = 1
            r3 = 0
            r0 = 0
            r10 = r0
            r0 = r1
            r1 = r2
        L_0x000f:
            int r2 = r1 + r10
            if (r2 != r0) goto L_0x003f
            int r0 = r11.length
            if (r10 != r0) goto L_0x0018
            r0 = 0
        L_0x0017:
            return r0
        L_0x0018:
            int r0 = r10 + 1
            boolean r0 = r15.m6734b((int) r0)
            if (r0 != 0) goto L_0x003b
        L_0x0020:
            r0 = 2
            if (r3 != r0) goto L_0x00df
            if (r4 == 0) goto L_0x00df
            r0 = -9223372036854775808
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            if (r5 == 0) goto L_0x00df
        L_0x002d:
            if (r5 == 0) goto L_0x00dc
        L_0x002f:
            r15.f5860j = r6
            int r0 = r15.f5855e
            int r0 = r0 + r10
            r15.f5855e = r0
            r0 = 15
            r15.f5859i = r0
            goto L_0x0017
        L_0x003b:
            int r1 = r15.f5855e
            int r0 = r15.f5856f
        L_0x003f:
            int r2 = r1 + r10
            char r2 = r11[r2]
            switch(r2) {
                case 43: goto L_0x006d;
                case 45: goto L_0x0056;
                case 46: goto L_0x0082;
                case 69: goto L_0x0076;
                case 101: goto L_0x0076;
                default: goto L_0x0046;
            }
        L_0x0046:
            r8 = 48
            if (r2 < r8) goto L_0x004e
            r8 = 57
            if (r2 <= r8) goto L_0x008b
        L_0x004e:
            boolean r0 = r15.m6729a((char) r2)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            goto L_0x0017
        L_0x0056:
            if (r3 != 0) goto L_0x0064
            r3 = 1
            r2 = 1
            r14 = r4
            r4 = r3
            r3 = r14
        L_0x005d:
            int r5 = r10 + 1
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x000f
        L_0x0064:
            r2 = 5
            if (r3 != r2) goto L_0x006b
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x006b:
            r0 = 0
            goto L_0x0017
        L_0x006d:
            r2 = 5
            if (r3 != r2) goto L_0x0074
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0074:
            r0 = 0
            goto L_0x0017
        L_0x0076:
            r2 = 2
            if (r3 == r2) goto L_0x007c
            r2 = 4
            if (r3 != r2) goto L_0x0080
        L_0x007c:
            r2 = 5
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0080:
            r0 = 0
            goto L_0x0017
        L_0x0082:
            r2 = 2
            if (r3 != r2) goto L_0x0089
            r2 = 3
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0089:
            r0 = 0
            goto L_0x0017
        L_0x008b:
            r8 = 1
            if (r3 == r8) goto L_0x0090
            if (r3 != 0) goto L_0x0098
        L_0x0090:
            int r2 = r2 + -48
            int r2 = -r2
            long r6 = (long) r2
            r2 = 2
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0098:
            r8 = 2
            if (r3 != r8) goto L_0x00cb
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00a4
            r0 = 0
            goto L_0x0017
        L_0x00a4:
            r8 = 10
            long r8 = r8 * r6
            int r2 = r2 + -48
            long r12 = (long) r2
            long r8 = r8 - r12
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x00c1
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00c9
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c9
        L_0x00c1:
            r2 = 1
        L_0x00c2:
            r2 = r2 & r4
            r4 = r5
            r6 = r8
            r14 = r3
            r3 = r2
            r2 = r14
            goto L_0x005d
        L_0x00c9:
            r2 = 0
            goto L_0x00c2
        L_0x00cb:
            r2 = 3
            if (r3 != r2) goto L_0x00d2
            r2 = 4
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00d2:
            r2 = 5
            if (r3 == r2) goto L_0x00d8
            r2 = 6
            if (r3 != r2) goto L_0x00f3
        L_0x00d8:
            r2 = 7
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00dc:
            long r6 = -r6
            goto L_0x002f
        L_0x00df:
            r0 = 2
            if (r3 == r0) goto L_0x00e8
            r0 = 4
            if (r3 == r0) goto L_0x00e8
            r0 = 7
            if (r3 != r0) goto L_0x00f0
        L_0x00e8:
            r15.f5861k = r10
            r0 = 16
            r15.f5859i = r0
            goto L_0x0017
        L_0x00f0:
            r0 = 0
            goto L_0x0017
        L_0x00f3:
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaom.m6738d():int");
    }

    /* renamed from: e */
    private String mo7906e() {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.f5855e + i < this.f5856f) {
                switch (this.f5854d[this.f5855e + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case C0515k.AppCompatTheme_dialogPreferredPadding:
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                    case C0515k.AppCompatTheme_controlBackground:
                    case C0515k.AppCompatTheme_alertDialogStyle:
                    case '{':
                    case '}':
                        break;
                    case C0515k.AppCompatTheme_actionModeSelectAllDrawable:
                    case C0515k.AppCompatTheme_dropdownListPreferredItemHeight:
                    case C0515k.AppCompatTheme_toolbarStyle:
                    case C0515k.AppCompatTheme_popupMenuStyle:
                    case C0515k.AppCompatTheme_colorBackgroundFloating:
                        m6744i();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f5854d.length) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f5854d, this.f5855e, i);
                this.f5855e = i + this.f5855e;
                if (!m6734b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (m6734b(i + 1)) {
            }
        }
        if (sb2 == null) {
            sb = new String(this.f5854d, this.f5855e, i);
        } else {
            sb2.append(this.f5854d, this.f5855e, i);
            sb = sb2.toString();
        }
        this.f5855e = i + this.f5855e;
        return sb;
    }

    /* renamed from: f */
    private void m6741f() {
        do {
            int i = 0;
            while (this.f5855e + i < this.f5856f) {
                switch (this.f5854d[this.f5855e + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case C0515k.AppCompatTheme_dialogPreferredPadding:
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                    case C0515k.AppCompatTheme_controlBackground:
                    case C0515k.AppCompatTheme_alertDialogStyle:
                    case '{':
                    case '}':
                        break;
                    case C0515k.AppCompatTheme_actionModeSelectAllDrawable:
                    case C0515k.AppCompatTheme_dropdownListPreferredItemHeight:
                    case C0515k.AppCompatTheme_toolbarStyle:
                    case C0515k.AppCompatTheme_popupMenuStyle:
                    case C0515k.AppCompatTheme_colorBackgroundFloating:
                        m6744i();
                        break;
                    default:
                        i++;
                }
                this.f5855e = i + this.f5855e;
                return;
            }
            this.f5855e = i + this.f5855e;
        } while (m6734b(1));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m6742g() {
        return this.f5857g + 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public int m6743h() {
        return (this.f5855e - this.f5858h) + 1;
    }

    /* renamed from: i */
    private void m6744i() {
        if (!this.f5853c) {
            throw m6732b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: j */
    private void m6745j() {
        char c;
        do {
            if (this.f5855e < this.f5856f || m6734b(1)) {
                char[] cArr = this.f5854d;
                int i = this.f5855e;
                this.f5855e = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.f5857g++;
                    this.f5858h = this.f5855e;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    /* renamed from: k */
    private char m6746k() {
        int i;
        if (this.f5855e != this.f5856f || m6734b(1)) {
            char[] cArr = this.f5854d;
            int i2 = this.f5855e;
            this.f5855e = i2 + 1;
            char c = cArr[i2];
            switch (c) {
                case 10:
                    this.f5857g++;
                    this.f5858h = this.f5855e;
                    return c;
                case C0515k.AppCompatTheme_buttonBarPositiveButtonStyle:
                    return 8;
                case C0515k.AppCompatTheme_buttonStyle:
                    return 12;
                case C0515k.AppCompatTheme_ratingBarStyleSmall:
                    return 10;
                case C0515k.AppCompatTheme_listMenuViewStyle:
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.f5855e + 4 <= this.f5856f || m6734b(4)) {
                        int i3 = this.f5855e;
                        int i4 = i3 + 4;
                        int i5 = i3;
                        char c2 = 0;
                        for (int i6 = i5; i6 < i4; i6++) {
                            char c3 = this.f5854d[i6];
                            char c4 = (char) (c2 << 4);
                            if (c3 >= '0' && c3 <= '9') {
                                i = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i = (c3 - 'a') + 10;
                            } else if (c3 < 'A' || c3 > 'F') {
                                String valueOf = String.valueOf(new String(this.f5854d, this.f5855e, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? "\\u".concat(valueOf) : new String("\\u"));
                            } else {
                                i = (c3 - 'A') + 10;
                            }
                            c2 = (char) (c4 + i);
                        }
                        this.f5855e += 4;
                        return c2;
                    }
                    throw m6732b("Unterminated escape sequence");
                default:
                    return c;
            }
        } else {
            throw m6732b("Unterminated escape sequence");
        }
    }

    /* renamed from: l */
    private void m6747l() {
        m6727a(true);
        this.f5855e--;
        if (this.f5855e + f5851a.length <= this.f5856f || m6734b(f5851a.length)) {
            int i = 0;
            while (i < f5851a.length) {
                if (this.f5854d[this.f5855e + i] == f5851a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f5855e += f5851a.length;
        }
    }

    /* renamed from: b */
    public zzaon mo7902b() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        switch (i) {
            case 1:
                return zzaon.BEGIN_OBJECT;
            case 2:
                return zzaon.END_OBJECT;
            case 3:
                return zzaon.BEGIN_ARRAY;
            case 4:
                return zzaon.END_ARRAY;
            case 5:
            case 6:
                return zzaon.BOOLEAN;
            case 7:
                return zzaon.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzaon.STRING;
            case 12:
            case 13:
            case 14:
                return zzaon.NAME;
            case 15:
            case 16:
                return zzaon.NUMBER;
            case 17:
                return zzaon.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void beginArray() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 3) {
            m6728a(1);
            this.f5866p[this.f5864n - 1] = 0;
            this.f5859i = 0;
            return;
        }
        String valueOf = String.valueOf(mo7902b());
        int g = m6742g();
        int h = m6743h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 74 + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public void beginObject() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 1) {
            m6728a(3);
            this.f5859i = 0;
            return;
        }
        String valueOf = String.valueOf(mo7902b());
        int g = m6742g();
        int h = m6743h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 75 + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public void close() {
        this.f5859i = 0;
        this.f5863m[0] = 8;
        this.f5864n = 1;
        this.f5852b.close();
    }

    public void endArray() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 4) {
            this.f5864n--;
            int[] iArr = this.f5866p;
            int i2 = this.f5864n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f5859i = 0;
            return;
        }
        String valueOf = String.valueOf(mo7902b());
        int g = m6742g();
        int h = m6743h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public void endObject() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 2) {
            this.f5864n--;
            this.f5865o[this.f5864n] = null;
            int[] iArr = this.f5866p;
            int i2 = this.f5864n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f5859i = 0;
            return;
        }
        String valueOf = String.valueOf(mo7902b());
        int g = m6742g();
        int h = m6743h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 73 + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f5864n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f5863m[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.f5866p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.f5865o[i2] == null) {
                        break;
                    } else {
                        append.append(this.f5865o[i2]);
                        break;
                    }
            }
        }
        return append.toString();
    }

    public boolean hasNext() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.f5853c;
    }

    public boolean nextBoolean() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 5) {
            this.f5859i = 0;
            int[] iArr = this.f5866p;
            int i2 = this.f5864n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f5859i = 0;
            int[] iArr2 = this.f5866p;
            int i3 = this.f5864n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(mo7902b());
            int g = m6742g();
            int h = m6743h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 15) {
            this.f5859i = 0;
            int[] iArr = this.f5866p;
            int i2 = this.f5864n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f5860j;
        }
        if (i == 16) {
            this.f5862l = new String(this.f5854d, this.f5855e, this.f5861k);
            this.f5855e += this.f5861k;
        } else if (i == 8 || i == 9) {
            this.f5862l = m6733b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f5862l = mo7906e();
        } else if (i != 11) {
            String valueOf = String.valueOf(mo7902b());
            int g = m6742g();
            int h = m6743h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f5859i = 11;
        double parseDouble = Double.parseDouble(this.f5862l);
        if (this.f5853c || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f5862l = null;
            this.f5859i = 0;
            int[] iArr2 = this.f5866p;
            int i3 = this.f5864n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        int g2 = m6742g();
        int h2 = m6743h();
        String path2 = getPath();
        throw new zzaop(new StringBuilder(String.valueOf(path2).length() + C0515k.AppCompatTheme_buttonStyle).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(g2).append(" column ").append(h2).append(" path ").append(path2).toString());
    }

    public int nextInt() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 15) {
            int i2 = (int) this.f5860j;
            if (this.f5860j != ((long) i2)) {
                long j = this.f5860j;
                int g = m6742g();
                int h = m6743h();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
            }
            this.f5859i = 0;
            int[] iArr = this.f5866p;
            int i3 = this.f5864n - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.f5862l = new String(this.f5854d, this.f5855e, this.f5861k);
            this.f5855e += this.f5861k;
        } else if (i == 8 || i == 9) {
            this.f5862l = m6733b(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.f5862l);
                this.f5859i = 0;
                int[] iArr2 = this.f5866p;
                int i4 = this.f5864n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(mo7902b());
            int g2 = m6742g();
            int h2 = m6743h();
            String path2 = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(g2).append(" column ").append(h2).append(" path ").append(path2).toString());
        }
        this.f5859i = 11;
        double parseDouble = Double.parseDouble(this.f5862l);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            String str = this.f5862l;
            int g3 = m6742g();
            int h3 = m6743h();
            String path3 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length()).append("Expected an int but was ").append(str).append(" at line ").append(g3).append(" column ").append(h3).append(" path ").append(path3).toString());
        }
        this.f5862l = null;
        this.f5859i = 0;
        int[] iArr3 = this.f5866p;
        int i6 = this.f5864n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 15) {
            this.f5859i = 0;
            int[] iArr = this.f5866p;
            int i2 = this.f5864n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5860j;
        }
        if (i == 16) {
            this.f5862l = new String(this.f5854d, this.f5855e, this.f5861k);
            this.f5855e += this.f5861k;
        } else if (i == 8 || i == 9) {
            this.f5862l = m6733b(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.f5862l);
                this.f5859i = 0;
                int[] iArr2 = this.f5866p;
                int i3 = this.f5864n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(mo7902b());
            int g = m6742g();
            int h = m6743h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f5859i = 11;
        double parseDouble = Double.parseDouble(this.f5862l);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            String str = this.f5862l;
            int g2 = m6742g();
            int h2 = m6743h();
            String path2 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length()).append("Expected a long but was ").append(str).append(" at line ").append(g2).append(" column ").append(h2).append(" path ").append(path2).toString());
        }
        this.f5862l = null;
        this.f5859i = 0;
        int[] iArr3 = this.f5866p;
        int i4 = this.f5864n - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String nextName() {
        String b;
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 14) {
            b = mo7906e();
        } else if (i == 12) {
            b = m6733b('\'');
        } else if (i == 13) {
            b = m6733b('\"');
        } else {
            String valueOf = String.valueOf(mo7902b());
            int g = m6742g();
            int h = m6743h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f5859i = 0;
        this.f5865o[this.f5864n - 1] = b;
        return b;
    }

    public void nextNull() {
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 7) {
            this.f5859i = 0;
            int[] iArr = this.f5866p;
            int i2 = this.f5864n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(mo7902b());
        int g = m6742g();
        int h = m6743h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public String nextString() {
        String str;
        int i = this.f5859i;
        if (i == 0) {
            i = m6724a();
        }
        if (i == 10) {
            str = mo7906e();
        } else if (i == 8) {
            str = m6733b('\'');
        } else if (i == 9) {
            str = m6733b('\"');
        } else if (i == 11) {
            str = this.f5862l;
            this.f5862l = null;
        } else if (i == 15) {
            str = Long.toString(this.f5860j);
        } else if (i == 16) {
            str = new String(this.f5854d, this.f5855e, this.f5861k);
            this.f5855e += this.f5861k;
        } else {
            String valueOf = String.valueOf(mo7902b());
            int g = m6742g();
            int h = m6743h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f5859i = 0;
        int[] iArr = this.f5866p;
        int i2 = this.f5864n - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.f5853c = z;
    }

    public void skipValue() {
        int i = 0;
        do {
            int i2 = this.f5859i;
            if (i2 == 0) {
                i2 = m6724a();
            }
            if (i2 == 3) {
                m6728a(1);
                i++;
            } else if (i2 == 1) {
                m6728a(3);
                i++;
            } else if (i2 == 4) {
                this.f5864n--;
                i--;
            } else if (i2 == 2) {
                this.f5864n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m6741f();
            } else if (i2 == 8 || i2 == 12) {
                m6737c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m6737c('\"');
            } else if (i2 == 16) {
                this.f5855e += this.f5861k;
            }
            this.f5859i = 0;
        } while (i != 0);
        int[] iArr = this.f5866p;
        int i3 = this.f5864n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f5865o[this.f5864n - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int g = m6742g();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(g).append(" column ").append(m6743h()).toString();
    }
}
