package com.parse.codec.language;

import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.google.ads.AdSize;
import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;
import com.parse.codec.binary.BaseNCodec;
import java.util.Locale;

public class DoubleMetaphone implements StringEncoder {
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {Constants.SPAIN, "EP", "EB", "EL", "EY", "IB", "IL", Constants.INDIA, "IE", "EI", "ER"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", "S", "N", "M", "B", "Z"};
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;

    public String doubleMetaphone(String value) {
        return doubleMetaphone(value, false);
    }

    public String doubleMetaphone(String value, boolean alternate) {
        String value2 = cleanInput(value);
        if (value2 == null) {
            return null;
        }
        boolean slavoGermanic = isSlavoGermanic(value2);
        int index = isSilentStart(value2) ? 1 : 0;
        DoubleMetaphoneResult result = new DoubleMetaphoneResult(getMaxCodeLen());
        while (!result.isComplete() && index <= value2.length() - 1) {
            switch (value2.charAt(index)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'Y':
                    index = handleAEIOUY(result, index);
                    break;
                case 'B':
                    result.append('P');
                    if (charAt(value2, index + 1) != 'B') {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case 'C':
                    index = handleC(value2, result, index);
                    break;
                case 'D':
                    index = handleD(value2, result, index);
                    break;
                case 'F':
                    result.append('F');
                    if (charAt(value2, index + 1) != 'F') {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case 'G':
                    index = handleG(value2, result, index, slavoGermanic);
                    break;
                case 'H':
                    index = handleH(value2, result, index);
                    break;
                case 'J':
                    index = handleJ(value2, result, index, slavoGermanic);
                    break;
                case 'K':
                    result.append('K');
                    if (charAt(value2, index + 1) != 'K') {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case BaseNCodec.MIME_CHUNK_SIZE:
                    index = handleL(value2, result, index);
                    break;
                case 'M':
                    result.append('M');
                    if (!conditionM0(value2, index)) {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case 'N':
                    result.append('N');
                    if (charAt(value2, index + 1) != 'N') {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case 'P':
                    index = handleP(value2, result, index);
                    break;
                case 'Q':
                    result.append('K');
                    if (charAt(value2, index + 1) != 'Q') {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case 'R':
                    index = handleR(value2, result, index, slavoGermanic);
                    break;
                case 'S':
                    index = handleS(value2, result, index, slavoGermanic);
                    break;
                case 'T':
                    index = handleT(value2, result, index);
                    break;
                case 'V':
                    result.append('F');
                    if (charAt(value2, index + 1) != 'V') {
                        index++;
                        break;
                    } else {
                        index += 2;
                        break;
                    }
                case 'W':
                    index = handleW(value2, result, index);
                    break;
                case 'X':
                    index = handleX(value2, result, index);
                    break;
                case AdSize.LARGE_AD_HEIGHT:
                    index = handleZ(value2, result, index, slavoGermanic);
                    break;
                case 199:
                    result.append('S');
                    index++;
                    break;
                case 209:
                    result.append('N');
                    index++;
                    break;
                default:
                    index++;
                    break;
            }
        }
        if (alternate) {
            return result.getAlternate();
        }
        return result.getPrimary();
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public String encode(String value) {
        return doubleMetaphone(value);
    }

    public boolean isDoubleMetaphoneEqual(String value1, String value2) {
        return isDoubleMetaphoneEqual(value1, value2, false);
    }

    public boolean isDoubleMetaphoneEqual(String value1, String value2, boolean alternate) {
        return doubleMetaphone(value1, alternate).equals(doubleMetaphone(value2, alternate));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int maxCodeLen2) {
        this.maxCodeLen = maxCodeLen2;
    }

    private int handleAEIOUY(DoubleMetaphoneResult result, int index) {
        if (index == 0) {
            result.append('A');
        }
        return index + 1;
    }

    private int handleC(String value, DoubleMetaphoneResult result, int index) {
        int index2;
        if (conditionC0(value, index)) {
            result.append('K');
            index2 = index + 2;
        } else if (index == 0 && contains(value, index, 6, "CAESAR")) {
            result.append('S');
            index2 = index + 2;
        } else if (contains(value, index, 2, Constants.SWITZERLAND)) {
            index2 = handleCH(value, result, index);
        } else if (contains(value, index, 2, Constants.CZECH_REPUBLIC) && !contains(value, index - 2, 4, "WICZ")) {
            result.append('S', 'X');
            index2 = index + 2;
        } else if (contains(value, index + 1, 3, "CIA")) {
            result.append('X');
            index2 = index + 3;
        } else if (contains(value, index, 2, "CC") && (index != 1 || charAt(value, 0) != 'M')) {
            return handleCC(value, result, index);
        } else {
            if (contains(value, index, 2, "CK", "CG", "CQ")) {
                result.append('K');
                index2 = index + 2;
            } else if (contains(value, index, 2, "CI", "CE", "CY")) {
                if (contains(value, index, 3, "CIO", "CIE", "CIA")) {
                    result.append('S', 'X');
                } else {
                    result.append('S');
                }
                index2 = index + 2;
            } else {
                result.append('K');
                if (contains(value, index + 1, 2, " C", " Q", " G")) {
                    index2 = index + 3;
                } else {
                    if (!contains(value, index + 1, 1, "C", "K", "Q") || contains(value, index + 1, 2, "CE", "CI")) {
                        index2 = index + 1;
                    } else {
                        index2 = index + 2;
                    }
                }
            }
        }
        return index2;
    }

    private int handleCC(String value, DoubleMetaphoneResult result, int index) {
        if (!contains(value, index + 2, 1, "I", "E", "H") || contains(value, index + 2, 2, Constants.HUNGARY)) {
            result.append('K');
            return index + 2;
        }
        if (!(index == 1 && charAt(value, index - 1) == 'A') && !contains(value, index - 1, 5, "UCCEE", "UCCES")) {
            result.append('X');
        } else {
            result.append("KS");
        }
        return index + 3;
    }

    private int handleCH(String value, DoubleMetaphoneResult result, int index) {
        if (index > 0 && contains(value, index, 4, "CHAE")) {
            result.append('K', 'X');
            return index + 2;
        } else if (conditionCH0(value, index)) {
            result.append('K');
            return index + 2;
        } else if (conditionCH1(value, index)) {
            result.append('K');
            return index + 2;
        } else {
            if (index <= 0) {
                result.append('X');
            } else if (contains(value, 0, 2, "MC")) {
                result.append('K');
            } else {
                result.append('X', 'K');
            }
            return index + 2;
        }
    }

    private int handleD(String value, DoubleMetaphoneResult result, int index) {
        if (contains(value, index, 2, "DG")) {
            if (contains(value, index + 2, 1, "I", "E", "Y")) {
                result.append('J');
                return index + 3;
            }
            result.append("TK");
            return index + 2;
        } else if (contains(value, index, 2, "DT", "DD")) {
            result.append('T');
            return index + 2;
        } else {
            result.append('T');
            return index + 1;
        }
    }

    private int handleG(String value, DoubleMetaphoneResult result, int index, boolean slavoGermanic) {
        if (charAt(value, index + 1) == 'H') {
            return handleGH(value, result, index);
        }
        if (charAt(value, index + 1) == 'N') {
            if (index == 1 && isVowel(charAt(value, 0)) && !slavoGermanic) {
                result.append("KN", "N");
            } else if (contains(value, index + 2, 2, "EY") || charAt(value, index + 1) == 'Y' || slavoGermanic) {
                result.append("KN");
            } else {
                result.append("N", "KN");
            }
            return index + 2;
        } else if (contains(value, index + 1, 2, "LI") && !slavoGermanic) {
            result.append("KL", "L");
            return index + 2;
        } else if (index == 0 && (charAt(value, index + 1) == 'Y' || contains(value, index + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            result.append('K', 'J');
            return index + 2;
        } else if ((contains(value, index + 1, 2, "ER") || charAt(value, index + 1) == 'Y') && !contains(value, 0, 6, "DANGER", "RANGER", "MANGER") && !contains(value, index - 1, 1, "E", "I") && !contains(value, index - 1, 3, "RGY", "OGY")) {
            result.append('K', 'J');
            return index + 2;
        } else {
            if (contains(value, index + 1, 1, "E", "I", "Y") || contains(value, index - 1, 4, "AGGI", "OGGI")) {
                if (contains(value, 0, 4, "VAN ", "VON ") || contains(value, 0, 3, "SCH") || contains(value, index + 1, 2, "ET")) {
                    result.append('K');
                } else if (contains(value, index + 1, 3, "IER")) {
                    result.append('J');
                } else {
                    result.append('J', 'K');
                }
                return index + 2;
            } else if (charAt(value, index + 1) == 'G') {
                int index2 = index + 2;
                result.append('K');
                return index2;
            } else {
                int index3 = index + 1;
                result.append('K');
                return index3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (contains(r11, r13 - 2, 1, "B", "H", "D") == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (contains(r11, r13 - 3, 1, "B", "H", "D") == false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleGH(java.lang.String r11, com.parse.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13) {
        /*
            r10 = this;
            r9 = 73
            r6 = 2
            r8 = 75
            r2 = 1
            if (r13 <= 0) goto L_0x001a
            int r0 = r13 + -1
            char r0 = r10.charAt(r11, r0)
            boolean r0 = r10.isVowel(r0)
            if (r0 != 0) goto L_0x001a
            r12.append((char) r8)
            int r13 = r13 + 2
        L_0x0019:
            return r13
        L_0x001a:
            if (r13 != 0) goto L_0x0030
            int r0 = r13 + 2
            char r0 = r10.charAt(r11, r0)
            if (r0 != r9) goto L_0x002c
            r0 = 74
            r12.append((char) r0)
        L_0x0029:
            int r13 = r13 + 2
            goto L_0x0019
        L_0x002c:
            r12.append((char) r8)
            goto L_0x0029
        L_0x0030:
            if (r13 <= r2) goto L_0x0041
            int r1 = r13 + -2
            java.lang.String r3 = "B"
            java.lang.String r4 = "H"
            java.lang.String r5 = "D"
            r0 = r11
            boolean r0 = contains(r0, r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0061
        L_0x0041:
            if (r13 <= r6) goto L_0x0052
            int r1 = r13 + -3
            java.lang.String r3 = "B"
            java.lang.String r4 = "H"
            java.lang.String r5 = "D"
            r0 = r11
            boolean r0 = contains(r0, r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0061
        L_0x0052:
            r0 = 3
            if (r13 <= r0) goto L_0x0064
            int r0 = r13 + -4
            java.lang.String r1 = "B"
            java.lang.String r3 = "H"
            boolean r0 = contains(r11, r0, r2, r1, r3)
            if (r0 == 0) goto L_0x0064
        L_0x0061:
            int r13 = r13 + 2
            goto L_0x0019
        L_0x0064:
            if (r13 <= r6) goto L_0x008b
            int r0 = r13 + -1
            char r0 = r10.charAt(r11, r0)
            r1 = 85
            if (r0 != r1) goto L_0x008b
            int r1 = r13 + -3
            java.lang.String r3 = "C"
            java.lang.String r4 = "G"
            java.lang.String r5 = "L"
            java.lang.String r6 = "R"
            java.lang.String r7 = "T"
            r0 = r11
            boolean r0 = contains(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x008b
            r0 = 70
            r12.append((char) r0)
        L_0x0088:
            int r13 = r13 + 2
            goto L_0x0019
        L_0x008b:
            if (r13 <= 0) goto L_0x0088
            int r0 = r13 + -1
            char r0 = r10.charAt(r11, r0)
            if (r0 == r9) goto L_0x0088
            r12.append((char) r8)
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.codec.language.DoubleMetaphone.handleGH(java.lang.String, com.parse.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleH(String value, DoubleMetaphoneResult result, int index) {
        if ((index != 0 && !isVowel(charAt(value, index - 1))) || !isVowel(charAt(value, index + 1))) {
            return index + 1;
        }
        result.append('H');
        return index + 2;
    }

    private int handleJ(String value, DoubleMetaphoneResult result, int index, boolean slavoGermanic) {
        if (contains(value, index, 4, "JOSE") || contains(value, 0, 4, "SAN ")) {
            if ((index == 0 && charAt(value, index + 4) == ' ') || value.length() == 4 || contains(value, 0, 4, "SAN ")) {
                result.append('H');
            } else {
                result.append('J', 'H');
            }
            return index + 1;
        }
        if (index == 0 && !contains(value, index, 4, "JOSE")) {
            result.append('J', 'A');
        } else if (isVowel(charAt(value, index - 1)) && !slavoGermanic && (charAt(value, index + 1) == 'A' || charAt(value, index + 1) == 'O')) {
            result.append('J', 'H');
        } else if (index == value.length() - 1) {
            result.append('J', ' ');
        } else if (!contains(value, index + 1, 1, L_T_K_S_N_M_B_Z)) {
            if (!contains(value, index - 1, 1, "S", "K", "L")) {
                result.append('J');
            }
        }
        if (charAt(value, index + 1) == 'J') {
            return index + 2;
        }
        return index + 1;
    }

    private int handleL(String value, DoubleMetaphoneResult result, int index) {
        if (charAt(value, index + 1) == 'L') {
            if (conditionL0(value, index)) {
                result.appendPrimary('L');
            } else {
                result.append('L');
            }
            return index + 2;
        }
        int index2 = index + 1;
        result.append('L');
        return index2;
    }

    private int handleP(String value, DoubleMetaphoneResult result, int index) {
        if (charAt(value, index + 1) == 'H') {
            result.append('F');
            return index + 2;
        }
        result.append('P');
        return contains(value, index + 1, 1, "P", "B") ? index + 2 : index + 1;
    }

    private int handleR(String value, DoubleMetaphoneResult result, int index, boolean slavoGermanic) {
        if (index != value.length() - 1 || slavoGermanic || !contains(value, index - 2, 2, "IE") || contains(value, index - 4, 2, "ME", "MA")) {
            result.append('R');
        } else {
            result.appendAlternate('R');
        }
        return charAt(value, index + 1) == 'R' ? index + 2 : index + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (contains(r11, r13 + 1, 1, "M", "N", "L", "W") == false) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleS(java.lang.String r11, com.parse.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13, boolean r14) {
        /*
            r10 = this;
            r4 = 3
            r9 = 2
            r8 = 88
            r2 = 1
            r7 = 83
            int r0 = r13 + -1
            java.lang.String r1 = "ISL"
            java.lang.String r3 = "YSL"
            boolean r0 = contains(r11, r0, r4, r1, r3)
            if (r0 == 0) goto L_0x0016
            int r13 = r13 + 1
        L_0x0015:
            return r13
        L_0x0016:
            if (r13 != 0) goto L_0x0027
            r0 = 5
            java.lang.String r1 = "SUGAR"
            boolean r0 = contains((java.lang.String) r11, (int) r13, (int) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x0027
            r12.append((char) r8, (char) r7)
            int r13 = r13 + 1
            goto L_0x0015
        L_0x0027:
            java.lang.String r0 = "SH"
            boolean r0 = contains((java.lang.String) r11, (int) r13, (int) r9, (java.lang.String) r0)
            if (r0 == 0) goto L_0x004b
            int r1 = r13 + 1
            r2 = 4
            java.lang.String r3 = "HEIM"
            java.lang.String r4 = "HOEK"
            java.lang.String r5 = "HOLM"
            java.lang.String r6 = "HOLZ"
            r0 = r11
            boolean r0 = contains(r0, r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0047
            r12.append((char) r7)
        L_0x0044:
            int r13 = r13 + 2
            goto L_0x0015
        L_0x0047:
            r12.append((char) r8)
            goto L_0x0044
        L_0x004b:
            java.lang.String r0 = "SIO"
            java.lang.String r1 = "SIA"
            boolean r0 = contains(r11, r13, r4, r0, r1)
            if (r0 != 0) goto L_0x005e
            r0 = 4
            java.lang.String r1 = "SIAN"
            boolean r0 = contains((java.lang.String) r11, (int) r13, (int) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x006a
        L_0x005e:
            if (r14 == 0) goto L_0x0066
            r12.append((char) r7)
        L_0x0063:
            int r13 = r13 + 3
            goto L_0x0015
        L_0x0066:
            r12.append((char) r7, (char) r8)
            goto L_0x0063
        L_0x006a:
            if (r13 != 0) goto L_0x007d
            int r1 = r13 + 1
            java.lang.String r3 = "M"
            java.lang.String r4 = "N"
            java.lang.String r5 = "L"
            java.lang.String r6 = "W"
            r0 = r11
            boolean r0 = contains(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0087
        L_0x007d:
            int r0 = r13 + 1
            java.lang.String r1 = "Z"
            boolean r0 = contains((java.lang.String) r11, (int) r0, (int) r2, (java.lang.String) r1)
            if (r0 == 0) goto L_0x009b
        L_0x0087:
            r12.append((char) r7, (char) r8)
            int r0 = r13 + 1
            java.lang.String r1 = "Z"
            boolean r0 = contains((java.lang.String) r11, (int) r0, (int) r2, (java.lang.String) r1)
            if (r0 == 0) goto L_0x0098
            int r13 = r13 + 2
        L_0x0096:
            goto L_0x0015
        L_0x0098:
            int r13 = r13 + 1
            goto L_0x0096
        L_0x009b:
            java.lang.String r0 = "SC"
            boolean r0 = contains((java.lang.String) r11, (int) r13, (int) r9, (java.lang.String) r0)
            if (r0 == 0) goto L_0x00a9
            int r13 = r10.handleSC(r11, r12, r13)
            goto L_0x0015
        L_0x00a9:
            int r0 = r11.length()
            int r0 = r0 + -1
            if (r13 != r0) goto L_0x00d0
            int r0 = r13 + -2
            java.lang.String r1 = "AI"
            java.lang.String r3 = "OI"
            boolean r0 = contains(r11, r0, r9, r1, r3)
            if (r0 == 0) goto L_0x00d0
            r12.appendAlternate((char) r7)
        L_0x00c0:
            int r0 = r13 + 1
            java.lang.String r1 = "S"
            java.lang.String r3 = "Z"
            boolean r0 = contains(r11, r0, r2, r1, r3)
            if (r0 == 0) goto L_0x00d4
            int r13 = r13 + 2
        L_0x00ce:
            goto L_0x0015
        L_0x00d0:
            r12.append((char) r7)
            goto L_0x00c0
        L_0x00d4:
            int r13 = r13 + 1
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.codec.language.DoubleMetaphone.handleS(java.lang.String, com.parse.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleSC(String value, DoubleMetaphoneResult result, int index) {
        if (charAt(value, index + 2) == 'H') {
            if (contains(value, index + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(value, index + 3, 2, "ER", "EN")) {
                    result.append("X", Constants.SLOVAKIA);
                } else {
                    result.append(Constants.SLOVAKIA);
                }
            } else if (index != 0 || isVowel(charAt(value, 3)) || charAt(value, 3) == 'W') {
                result.append('X');
            } else {
                result.append('X', 'S');
            }
        } else {
            if (contains(value, index + 2, 1, "I", "E", "Y")) {
                result.append('S');
            } else {
                result.append(Constants.SLOVAKIA);
            }
        }
        return index + 3;
    }

    private int handleT(String value, DoubleMetaphoneResult result, int index) {
        if (contains(value, index, 4, "TION")) {
            result.append('X');
            return index + 3;
        } else if (contains(value, index, 3, "TIA", "TCH")) {
            result.append('X');
            return index + 3;
        } else if (contains(value, index, 2, "TH") || contains(value, index, 3, "TTH")) {
            if (contains(value, index + 2, 2, "OM", "AM") || contains(value, 0, 4, "VAN ", "VON ") || contains(value, 0, 3, "SCH")) {
                result.append('T');
            } else {
                result.append('0', 'T');
            }
            return index + 2;
        } else {
            result.append('T');
            return contains(value, index + 1, 1, "T", "D") ? index + 2 : index + 1;
        }
    }

    private int handleW(String value, DoubleMetaphoneResult result, int index) {
        if (contains(value, index, 2, "WR")) {
            result.append('R');
            return index + 2;
        } else if (index != 0 || (!isVowel(charAt(value, index + 1)) && !contains(value, index, 2, "WH"))) {
            if (index != value.length() - 1 || !isVowel(charAt(value, index - 1))) {
                if (!contains(value, index - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !contains(value, 0, 3, "SCH")) {
                    if (!contains(value, index, 4, "WICZ", "WITZ")) {
                        return index + 1;
                    }
                    result.append("TS", "FX");
                    return index + 4;
                }
            }
            result.appendAlternate('F');
            return index + 1;
        } else {
            if (isVowel(charAt(value, index + 1))) {
                result.append('A', 'F');
            } else {
                result.append('A');
            }
            return index + 1;
        }
    }

    private int handleX(String value, DoubleMetaphoneResult result, int index) {
        if (index == 0) {
            result.append('S');
            return index + 1;
        }
        if (index != value.length() - 1 || (!contains(value, index - 3, 3, "IAU", "EAU") && !contains(value, index - 2, 2, Constants.AUSTRALIA, "OU"))) {
            result.append("KS");
        }
        return contains(value, index + 1, 1, "C", "X") ? index + 2 : index + 1;
    }

    private int handleZ(String value, DoubleMetaphoneResult result, int index, boolean slavoGermanic) {
        if (charAt(value, index + 1) == 'H') {
            result.append('J');
            return index + 2;
        }
        if (contains(value, index + 1, 2, "ZO", "ZI", Constants.SOUTH_AFRICA) || (slavoGermanic && index > 0 && charAt(value, index - 1) != 'T')) {
            result.append("S", "TS");
        } else {
            result.append('S');
        }
        return charAt(value, index + 1) == 'Z' ? index + 2 : index + 1;
    }

    private boolean conditionC0(String value, int index) {
        if (contains(value, index, 4, "CHIA")) {
            return true;
        }
        if (index <= 1) {
            return false;
        }
        if (isVowel(charAt(value, index - 2))) {
            return false;
        }
        if (!contains(value, index - 1, 3, "ACH")) {
            return false;
        }
        char c = charAt(value, index + 2);
        if ((c == 'I' || c == 'E') && !contains(value, index - 2, 6, "BACHER", "MACHER")) {
            return false;
        }
        return true;
    }

    private boolean conditionCH0(String value, int index) {
        if (index != 0) {
            return false;
        }
        if (!contains(value, index + 1, 5, "HARAC", "HARIS")) {
            if (!contains(value, index + 1, 3, "HOR", "HYM", "HIA", "HEM")) {
                return false;
            }
        }
        if (contains(value, 0, 5, "CHORE")) {
            return false;
        }
        return true;
    }

    private boolean conditionCH1(String value, int index) {
        if (!contains(value, 0, 4, "VAN ", "VON ") && !contains(value, 0, 3, "SCH")) {
            if (!contains(value, index - 2, 6, "ORCHES", "ARCHIT", "ORCHID") && !contains(value, index + 2, 1, "T", "S")) {
                if ((!contains(value, index - 1, 1, "A", "O", "U", "E") && index != 0) || (!contains(value, index + 2, 1, L_R_N_M_B_H_F_V_W_SPACE) && index + 1 != value.length() - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean conditionL0(String value, int index) {
        if (index == value.length() - 3) {
            if (contains(value, index - 1, 4, "ILLO", "ILLA", "ALLE")) {
                return true;
            }
        }
        if ((contains(value, value.length() - 2, 2, "AS", "OS") || contains(value, value.length() - 1, 1, "A", "O")) && contains(value, index - 1, 4, "ALLE")) {
            return true;
        }
        return false;
    }

    private boolean conditionM0(String value, int index) {
        if (charAt(value, index + 1) == 'M') {
            return true;
        }
        if (!contains(value, index - 1, 3, "UMB") || (index + 1 != value.length() - 1 && !contains(value, index + 2, 2, "ER"))) {
            return false;
        }
        return true;
    }

    private boolean isSlavoGermanic(String value) {
        return value.indexOf(87) > -1 || value.indexOf(75) > -1 || value.indexOf(Constants.CZECH_REPUBLIC) > -1 || value.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char ch) {
        return VOWELS.indexOf(ch) != -1;
    }

    private boolean isSilentStart(String value) {
        for (String startsWith : SILENT_START) {
            if (value.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private String cleanInput(String input) {
        if (input == null) {
            return null;
        }
        String input2 = input.trim();
        if (input2.length() != 0) {
            return input2.toUpperCase(Locale.ENGLISH);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public char charAt(String value, int index) {
        if (index < 0 || index >= value.length()) {
            return 0;
        }
        return value.charAt(index);
    }

    private static boolean contains(String value, int start, int length, String criteria) {
        return contains(value, start, length, new String[]{criteria});
    }

    private static boolean contains(String value, int start, int length, String criteria1, String criteria2) {
        return contains(value, start, length, new String[]{criteria1, criteria2});
    }

    private static boolean contains(String value, int start, int length, String criteria1, String criteria2, String criteria3) {
        return contains(value, start, length, new String[]{criteria1, criteria2, criteria3});
    }

    private static boolean contains(String value, int start, int length, String criteria1, String criteria2, String criteria3, String criteria4) {
        return contains(value, start, length, new String[]{criteria1, criteria2, criteria3, criteria4});
    }

    private static boolean contains(String value, int start, int length, String criteria1, String criteria2, String criteria3, String criteria4, String criteria5) {
        return contains(value, start, length, new String[]{criteria1, criteria2, criteria3, criteria4, criteria5});
    }

    private static boolean contains(String value, int start, int length, String criteria1, String criteria2, String criteria3, String criteria4, String criteria5, String criteria6) {
        return contains(value, start, length, new String[]{criteria1, criteria2, criteria3, criteria4, criteria5, criteria6});
    }

    protected static boolean contains(String value, int start, int length, String[] criteria) {
        if (start < 0 || start + length > value.length()) {
            return false;
        }
        String target = value.substring(start, start + length);
        for (String equals : criteria) {
            if (target.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public class DoubleMetaphoneResult {
        private StringBuffer alternate;
        private int maxLength;
        private StringBuffer primary;

        public DoubleMetaphoneResult(int maxLength2) {
            this.primary = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = maxLength2;
        }

        public void append(char value) {
            appendPrimary(value);
            appendAlternate(value);
        }

        public void append(char primary2, char alternate2) {
            appendPrimary(primary2);
            appendAlternate(alternate2);
        }

        public void appendPrimary(char value) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(value);
            }
        }

        public void appendAlternate(char value) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(value);
            }
        }

        public void append(String value) {
            appendPrimary(value);
            appendAlternate(value);
        }

        public void append(String primary2, String alternate2) {
            appendPrimary(primary2);
            appendAlternate(alternate2);
        }

        public void appendPrimary(String value) {
            int addChars = this.maxLength - this.primary.length();
            if (value.length() <= addChars) {
                this.primary.append(value);
            } else {
                this.primary.append(value.substring(0, addChars));
            }
        }

        public void appendAlternate(String value) {
            int addChars = this.maxLength - this.alternate.length();
            if (value.length() <= addChars) {
                this.alternate.append(value);
            } else {
                this.alternate.append(value.substring(0, addChars));
            }
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }
}
