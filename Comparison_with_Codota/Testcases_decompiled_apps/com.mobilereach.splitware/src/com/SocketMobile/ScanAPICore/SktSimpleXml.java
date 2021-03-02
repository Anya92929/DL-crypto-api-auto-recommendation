package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktScanTypes;

final class SktSimpleXml {

    interface AttrState {
        public static final int inName = 1;
        public static final int inValue = 4;
        public static final int nameDone = 2;
        public static final int startName = 0;
        public static final int startValue = 3;
    }

    interface BracketState {
        public static final int inAttributeName = 4;
        public static final int inAttributeValue = 5;
        public static final int inStringContentOnly = 6;
        public static final int inTag = 1;
        public static final int inTagAfterName = 3;
        public static final int inTagName = 2;
        public static final int outside = 0;
    }

    static class CSktXmlUtilities {
        CSktXmlUtilities() {
        }

        public static long AllocateAndCopy(String ppszDestination, String pszSource, int nLength) {
            long Result = 0;
            if (ppszDestination == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                String ppszDestination2 = pszSource;
            }
            return Result;
        }
    }

    SktSimpleXml() {
    }

    static class TSktXmlContext {
        int nLineNumber;
        char[] pBuffer;
        char[] pWriteBuffer;
        long ulBufferSize;
        int ulCurrentIndex;
        long ulRowOffset;

        TSktXmlContext() {
        }
    }

    static class CSktXmlBracket {
        private SktList m_Attributes = new SktList();
        private boolean m_bEmptyContent = false;
        private boolean m_bEndTag = false;
        private boolean m_bStringContentOnly = false;
        private long m_ulNameEndIndex = 0;
        private long m_ulNameStartIndex = 0;

        protected CSktXmlBracket() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long Parse(com.SocketMobile.ScanAPICore.SktSimpleXml.TSktXmlContext r19) {
            /*
                r18 = this;
                r2 = 0
                r5 = 1
                r10 = 0
                r6 = 32
                r4 = 0
                if (r19 != 0) goto L_0x000b
                r2 = -18
            L_0x000b:
                boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
                if (r11 == 0) goto L_0x0036
                r0 = r19
                int r8 = r0.ulCurrentIndex
            L_0x0015:
                long r12 = (long) r8
                r0 = r19
                long r14 = r0.ulBufferSize
                int r11 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r11 >= 0) goto L_0x0036
                r0 = r19
                char[] r11 = r0.pBuffer     // Catch:{ Exception -> 0x0090 }
                char r6 = r11[r8]     // Catch:{ Exception -> 0x0090 }
                switch(r6) {
                    case 0: goto L_0x0030;
                    case 10: goto L_0x018a;
                    case 13: goto L_0x0030;
                    case 32: goto L_0x017f;
                    case 47: goto L_0x015b;
                    case 60: goto L_0x00b3;
                    case 61: goto L_0x0030;
                    case 62: goto L_0x0106;
                    default: goto L_0x0027;
                }
            L_0x0027:
                r11 = 1
                if (r4 != r11) goto L_0x019b
                r4 = 2
                long r12 = (long) r8
                r0 = r18
                r0.m_ulNameStartIndex = r12
            L_0x0030:
                if (r5 != 0) goto L_0x01de
                r0 = r19
                r0.ulCurrentIndex = r8
            L_0x0036:
                boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
                if (r11 == 0) goto L_0x008f
                if (r4 == 0) goto L_0x008f
                r2 = -52
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "Unexpected end of file at line:"
                java.lang.StringBuilder r11 = r11.append(r12)
                r0 = r19
                int r12 = r0.nLineNumber
                java.lang.String r12 = java.lang.String.valueOf(r12)
                java.lang.StringBuilder r11 = r11.append(r12)
                java.lang.String r12 = " col:"
                java.lang.StringBuilder r11 = r11.append(r12)
                r0 = r19
                int r12 = r0.ulCurrentIndex
                long r12 = (long) r12
                r0 = r19
                long r14 = r0.ulRowOffset
                long r12 = r12 - r14
                java.lang.String r12 = java.lang.String.valueOf(r12)
                java.lang.StringBuilder r11 = r11.append(r12)
                java.lang.String r12 = " size:"
                java.lang.StringBuilder r11 = r11.append(r12)
                r0 = r19
                long r12 = r0.ulBufferSize
                java.lang.String r12 = java.lang.String.valueOf(r12)
                java.lang.StringBuilder r11 = r11.append(r12)
                java.lang.String r12 = " bytes"
                java.lang.StringBuilder r11 = r11.append(r12)
                java.lang.String r9 = r11.toString()
                r11 = 2
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r11, r9)
            L_0x008f:
                return r2
            L_0x0090:
                r7 = move-exception
                r11 = 2
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "exception:"
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r13 = r7.getMessage()
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r12 = r12.toString()
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r11, r12)
                r2 = -52
                r0 = r19
                r0.ulCurrentIndex = r8
                goto L_0x0036
            L_0x00b3:
                if (r4 != 0) goto L_0x00b8
                r4 = 1
                goto L_0x0030
            L_0x00b8:
                r11 = 6
                if (r4 != r11) goto L_0x00cb
                r11 = 1
                r0 = r18
                r0.m_bStringContentOnly = r11
                long r12 = (long) r8
                r0 = r18
                r0.m_ulNameEndIndex = r12
                int r8 = r8 + -1
                r5 = 0
                r4 = 0
                goto L_0x0030
            L_0x00cb:
                r2 = -52
                r11 = 2
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "Unexpected < at line:"
                java.lang.StringBuilder r12 = r12.append(r13)
                r0 = r19
                int r13 = r0.nLineNumber
                java.lang.String r13 = java.lang.String.valueOf(r13)
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r13 = " col:"
                java.lang.StringBuilder r12 = r12.append(r13)
                long r14 = (long) r8
                r0 = r19
                long r0 = r0.ulRowOffset
                r16 = r0
                long r14 = r14 - r16
                java.lang.String r13 = java.lang.String.valueOf(r14)
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r12 = r12.toString()
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r11, r12)
                r5 = 0
                goto L_0x0030
            L_0x0106:
                r11 = 2
                if (r4 != r11) goto L_0x011c
                r0 = r18
                long r12 = r0.m_ulNameEndIndex
                r14 = 0
                int r11 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r11 != 0) goto L_0x0118
                long r12 = (long) r8
                r0 = r18
                r0.m_ulNameEndIndex = r12
            L_0x0118:
                r4 = 0
                r5 = 0
                goto L_0x0030
            L_0x011c:
                r11 = 1
                if (r4 == r11) goto L_0x0118
                r11 = 3
                if (r4 == r11) goto L_0x0118
                r2 = -52
                r11 = 2
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "Unexpected > at line:"
                java.lang.StringBuilder r12 = r12.append(r13)
                r0 = r19
                int r13 = r0.nLineNumber
                java.lang.String r13 = java.lang.String.valueOf(r13)
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r13 = " col:"
                java.lang.StringBuilder r12 = r12.append(r13)
                long r14 = (long) r8
                r0 = r19
                long r0 = r0.ulRowOffset
                r16 = r0
                long r14 = r14 - r16
                java.lang.String r13 = java.lang.String.valueOf(r14)
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r12 = r12.toString()
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r11, r12)
                goto L_0x0118
            L_0x015b:
                r11 = 1
                if (r4 != r11) goto L_0x0165
                r11 = 1
                r0 = r18
                r0.m_bEndTag = r11
                goto L_0x0030
            L_0x0165:
                r11 = 2
                if (r4 == r11) goto L_0x016b
                r11 = 3
                if (r4 != r11) goto L_0x0030
            L_0x016b:
                r11 = 1
                r0 = r18
                r0.m_bEndTag = r11
                r11 = 1
                r0 = r18
                r0.m_bEmptyContent = r11
                r11 = 2
                if (r4 != r11) goto L_0x0030
                long r12 = (long) r8
                r0 = r18
                r0.m_ulNameEndIndex = r12
                goto L_0x0030
            L_0x017f:
                r11 = 2
                if (r4 != r11) goto L_0x0030
                long r12 = (long) r8
                r0 = r18
                r0.m_ulNameEndIndex = r12
                r4 = 3
                goto L_0x0030
            L_0x018a:
                r0 = r19
                int r11 = r0.nLineNumber
                int r11 = r11 + 1
                r0 = r19
                r0.nLineNumber = r11
                long r12 = (long) r8
                r0 = r19
                r0.ulRowOffset = r12
                goto L_0x0030
            L_0x019b:
                r11 = 3
                if (r4 != r11) goto L_0x01d4
                r0 = r19
                r0.ulCurrentIndex = r8
                com.SocketMobile.ScanAPICore.SktSimpleXml$CSktXmlTagAttribute r10 = new com.SocketMobile.ScanAPICore.SktSimpleXml$CSktXmlTagAttribute
                r10.<init>()
                r0 = r19
                long r12 = r10.Parse(r0)
                java.lang.String r11 = "pAttribute.Parse(pContext)"
                long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r12, r11)
                r0 = r19
                int r8 = r0.ulCurrentIndex
                boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
                if (r11 == 0) goto L_0x01cb
                r0 = r18
                com.SocketMobile.ScanAPICore.SktList r11 = r0.m_Attributes
                long r12 = r11.AddTail(r10)
                java.lang.String r11 = "m_Attributes.AddTail(pAttribute)"
                long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r12, r11)
            L_0x01cb:
                boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
                if (r11 != 0) goto L_0x0030
                r10 = 0
                goto L_0x0030
            L_0x01d4:
                if (r4 != 0) goto L_0x0030
                r4 = 6
                long r12 = (long) r8
                r0 = r18
                r0.m_ulNameStartIndex = r12
                goto L_0x0030
            L_0x01de:
                int r8 = r8 + 1
                goto L_0x0015
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktSimpleXml.CSktXmlBracket.Parse(com.SocketMobile.ScanAPICore.SktSimpleXml$TSktXmlContext):long");
        }

        /* access modifiers changed from: protected */
        public long RetrieveAllAttributes(SktList[] pAttributes) {
            long Result = 0;
            CSktXmlTagAttribute[] pAttribute = new CSktXmlTagAttribute[1];
            while (SktScanErrors.SKTSUCCESS(this.m_Attributes.RemoveHead(pAttribute))) {
                Result = SktDebug.DBGSKT_EVAL(pAttributes[0].AddTail(pAttribute[0]), "pAttributes[0].AddTail(pAttribute[0])");
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    break;
                }
            }
            return Result;
        }

        /* access modifiers changed from: protected */
        public boolean IsContentEmpty() {
            return this.m_bEmptyContent;
        }

        /* access modifiers changed from: protected */
        public boolean IsStringContentOnly() {
            return this.m_bStringContentOnly;
        }

        /* access modifiers changed from: protected */
        public boolean IsEndTag() {
            return this.m_bEndTag;
        }

        /* access modifiers changed from: protected */
        public long GetNameStartIndex() {
            return this.m_ulNameStartIndex;
        }

        /* access modifiers changed from: protected */
        public long GetNameEndIndex() {
            return this.m_ulNameEndIndex;
        }
    }

    static class CSktXmlTag {
        private SktList m_Attributes = new SktList();
        private SktList m_Content = new SktList();
        private String m_pszContent = null;
        private String m_pszTagName = null;

        public long WriteName(String pszName, int nLength) {
            try {
                this.m_pszTagName = pszName.substring(0, nLength);
                return 0;
            } catch (StringIndexOutOfBoundsException e) {
                return -18;
            }
        }

        public long WriteStringContent(String pszContent, int nLength) {
            try {
                this.m_pszContent = pszContent.substring(0, nLength);
                return 0;
            } catch (StringIndexOutOfBoundsException e) {
                return -18;
            }
        }

        public long AddTag(String pszName, int nLength, CSktXmlTag[] ppNewTag) {
            CSktXmlTag pNewTag = new CSktXmlTag();
            long Result = SktDebug.DBGSKT_EVAL(pNewTag.WriteName(pszName, nLength), "pNewTag.WriteName(pszName,nLength)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(InsertTag(pNewTag), "InsertTag(pNewTag)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (ppNewTag != null) {
                    ppNewTag[0] = pNewTag;
                }
            }
            return Result;
        }

        public long RemoveTag(CSktXmlTag ppTagToRemove) {
            long Result = 0;
            CSktXmlTag[] pSearch = new CSktXmlTag[1];
            if (ppTagToRemove == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktList.Position position = this.m_Content.GetHeadPosition();
                while (true) {
                    if (!position.IsValid()) {
                        break;
                    }
                    SktList.Position removePosition = position.Copy();
                    pSearch[0] = (CSktXmlTag) position.GetNext();
                    if (SktScanErrors.SKTSUCCESS(Result) && pSearch[0] == ppTagToRemove) {
                        this.m_Content.RemoveAt(removePosition, pSearch);
                        ppTagToRemove = null;
                        break;
                    }
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result) || ppTagToRemove == null) {
                return Result;
            }
            return -17;
        }

        public long AddAttribute(String pszName, int nNameLength, String pszValue, int nValueLength) {
            long Result = 0;
            CSktXmlTagAttribute[] pAttribute = new CSktXmlTagAttribute[1];
            boolean bFound = false;
            SktList.Position position = this.m_Attributes.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                pAttribute[0] = (CSktXmlTagAttribute) position.GetNext();
                if (nNameLength == pAttribute[0].GetName().length() && pAttribute[0].GetName().equalsIgnoreCase(pszName)) {
                    bFound = true;
                    break;
                }
            }
            if (!bFound) {
                pAttribute[0] = new CSktXmlTagAttribute();
            }
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(pAttribute[0].WriteName(pszName, nNameLength), "pAttribute[0].WriteName(pszName,nNameLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pAttribute[0].ReplaceXMLAndWriteValue(pszValue), "pAttribute[0].ReplaceXMLAndWriteValue(pszValue)");
            }
            if (bFound || !SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            return SktDebug.DBGSKT_EVAL(this.m_Attributes.AddTail(pAttribute[0]), "m_Attributes.AddTail(pAttribute[0])");
        }

        public long AddStringContent(String pszContent, int nLength) {
            try {
                this.m_pszContent = pszContent.substring(0, nLength);
                return 0;
            } catch (StringIndexOutOfBoundsException e) {
                return -18;
            }
        }

        public long Seek(String pszTagPath, int nIndex, boolean bNotFoundError, CSktXmlTag[] ppTagFound) {
            long Result = 0;
            int nSlashIndex = 0;
            boolean bFound = false;
            CSktXmlTag pXmlTag = null;
            if (this.m_pszTagName == null) {
                Result = -19;
            }
            if (SktScanErrors.SKTSUCCESS(Result) && (ppTagFound == null || pszTagPath == null || pszTagPath.length() == 0)) {
                Result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            ppTagFound[0] = null;
            SktList.Position position = this.m_Content.GetHeadPosition();
            int nCurrentIndex = 0;
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                pXmlTag = (CSktXmlTag) position.GetNext();
                if (pXmlTag.StartWithSameName(pszTagPath)) {
                    if (nCurrentIndex == nIndex) {
                        bFound = true;
                        break;
                    }
                    nCurrentIndex++;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            if (bFound) {
                int nPathLength = pszTagPath.length();
                int nTagNameLength = pXmlTag.GetTagName().length();
                if (nPathLength > nTagNameLength && pszTagPath.toCharArray()[nTagNameLength] == '/') {
                    nSlashIndex = nTagNameLength;
                }
                if (nSlashIndex != 0) {
                    return SktDebug.DBGSKT_EVAL(pXmlTag.Seek(pszTagPath.substring(nSlashIndex + 1), nIndex, bNotFoundError, ppTagFound), "pXmlTag.Seek(pszCurrent,nIndex,bNotFoundError,ppTagFound)");
                }
                ppTagFound[0] = pXmlTag;
                return Result;
            } else if (bNotFoundError) {
                return -17;
            } else {
                return Result;
            }
        }

        public boolean IsContentString() {
            return this.m_pszContent != null;
        }

        public String GetContentString() {
            return this.m_pszContent;
        }

        public String GetAttributeValue(String pszAttributeName) {
            SktList.Position position = this.m_Attributes.GetHeadPosition();
            while (position.IsValid()) {
                CSktXmlTagAttribute pAttribute = (CSktXmlTagAttribute) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(0) && pAttribute.GetName() != "" && pAttribute.GetName().length() == pszAttributeName.length() && pAttribute.GetName().equals(pszAttributeName)) {
                    return pAttribute.GetValue();
                }
            }
            return null;
        }

        public String GetTagName() {
            return this.m_pszTagName;
        }

        /* access modifiers changed from: protected */
        public long InsertTag(CSktXmlTag pNewTag) {
            return SktDebug.DBGSKT_EVAL(this.m_Content.AddTail(pNewTag), "m_Content.AddTail(pNewTag)");
        }

        /* access modifiers changed from: protected */
        public boolean StartWithSameName(String pszPathName) {
            int nTagSize;
            if (this.m_pszTagName == null || pszPathName == null || pszPathName.length() < (nTagSize = this.m_pszTagName.length())) {
                return false;
            }
            try {
                if (this.m_pszTagName.equals(pszPathName.substring(0, nTagSize))) {
                    return true;
                }
                return false;
            } catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public long Initialize(char[] pBuffer, CSktXmlBracket pCurrentBracket, SktList.Position position, SktList pBracketsList) {
            long Result = 0;
            boolean bShouldBeEndTag = false;
            if (pCurrentBracket.GetNameEndIndex() < pCurrentBracket.GetNameStartIndex()) {
                Result = -49;
            }
            String str_buffer = String.valueOf(pBuffer, (int) pCurrentBracket.GetNameStartIndex(), pBuffer.length - ((int) pCurrentBracket.GetNameStartIndex()));
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteName(str_buffer, (int) (pCurrentBracket.GetNameEndIndex() - pCurrentBracket.GetNameStartIndex())), "WriteName(str_buffer,(int)(pCurrentBracket.GetNameEndIndex()-pCurrentBracket.GetNameStartIndex()))");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktList[] pAttributes = {GetAttributesList()};
                Result = SktDebug.DBGSKT_EVAL(pCurrentBracket.RetrieveAllAttributes(pAttributes), "pCurrentBracket.RetrieveAllAttributes(pAttributes)");
                this.m_Attributes = pAttributes[0];
            }
            if (pCurrentBracket.IsEndTag()) {
                return Result;
            }
            while (position.IsValid()) {
                CSktXmlBracket pCurrentBracket2 = (CSktXmlBracket) position.GetNext();
                if (pCurrentBracket2.IsStringContentOnly()) {
                    String str_buffer1 = String.valueOf(pBuffer, (int) pCurrentBracket2.GetNameStartIndex(), pBuffer.length - ((int) pCurrentBracket2.GetNameStartIndex()));
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(WriteStringContent(str_buffer1, (int) (pCurrentBracket2.GetNameEndIndex() - pCurrentBracket2.GetNameStartIndex())), "WriteStringContent(str_buffer1,(int)(pCurrentBracket.GetNameEndIndex()-pCurrentBracket.GetNameStartIndex()))");
                    }
                    bShouldBeEndTag = true;
                } else if (pCurrentBracket2.IsEndTag() && !pCurrentBracket2.IsContentEmpty()) {
                    if (this.m_pszTagName != String.valueOf(pBuffer, (int) pCurrentBracket2.GetNameStartIndex(), pBuffer.length - ((int) pCurrentBracket2.GetNameStartIndex()))) {
                        return Result;
                    }
                    SktDebug.DBGSKT_MSG(4, "Unexpected end tag for " + this.m_pszTagName);
                    return -52;
                } else if (!bShouldBeEndTag) {
                    CSktXmlTag pXmlTag = new CSktXmlTag();
                    if (pXmlTag != null) {
                        Result = SktDebug.DBGSKT_EVAL(pXmlTag.Initialize(pBuffer, pCurrentBracket2, position, pBracketsList), "pXmlTag.Initialize(pBuffer,pCurrentBracket,position,pBracketsList)");
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(InsertTag(pXmlTag), "InsertTag(pXmlTag)");
                        }
                    }
                } else {
                    SktDebug.DBGSKT_MSG(4, "Missing end tag for " + this.m_pszTagName);
                    return -52;
                }
            }
            return Result;
        }

        /* access modifiers changed from: protected */
        public long Read(TSktXmlContext pContext) {
            long Result = 0;
            CSktXmlTagAttribute pAttribute = null;
            if (pContext == null || pContext.pWriteBuffer == null || pContext.ulBufferSize == 0) {
                Result = -2;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, "<"), "AddStringToBuffer(pContext,\"<\")");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, GetTagName()), "AddStringToBuffer(pContext,GetTagName())");
            }
            SktList.Position position = this.m_Attributes.GetHeadPosition();
            while (position.IsValid() && SktScanErrors.SKTSUCCESS(Result)) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, " "), "AddStringToBuffer(pContext,\" \")");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pAttribute = (CSktXmlTagAttribute) position.GetNext();
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, pAttribute.GetName()), "AddStringToBuffer(pContext,pAttribute.GetName())");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, "=\""), "AddStringToBuffer(pContext,\"=\"\")");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, pAttribute.GetValue()), "AddStringToBuffer(pContext,pAttribute.GetValue())");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, "\""), "AddStringToBuffer(pContext,\"\"\")");
                }
            }
            if (this.m_Content.GetCount() != 0 || GetContentString() != null) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, ">\n"), "AddStringToBuffer(pContext,\">\n\")");
                }
                if (GetContentString() == null) {
                    SktList.Position position2 = this.m_Content.GetHeadPosition();
                    while (position2.IsValid() && SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(((CSktXmlTag) position2.GetNext()).Read(pContext), "pXmlTag.Read(pContext)");
                    }
                } else if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, GetContentString()), "AddStringToBuffer(pContext,GetContentString())");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, "</"), "AddStringToBuffer(pContext,\"</\")");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, GetTagName()), "AddStringToBuffer(pContext,GetTagName())");
                }
                return SktScanErrors.SKTSUCCESS(Result) ? SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, ">\n"), "AddStringToBuffer(pContext,\">\n\")") : Result;
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                return SktDebug.DBGSKT_EVAL(AddStringToBuffer(pContext, "/>\n"), "AddStringToBuffer(pContext,\"/>\n\")");
            } else {
                return Result;
            }
        }

        /* access modifiers changed from: protected */
        public SktList GetAttributesList() {
            return this.m_Attributes;
        }

        /* access modifiers changed from: protected */
        public long AddStringToBuffer(TSktXmlContext pContext, String pszString) {
            int nSize;
            if (pszString == null || (nSize = pszString.length()) == 0) {
                return 0;
            }
            if (((long) (pContext.ulCurrentIndex + nSize)) >= pContext.ulBufferSize) {
                return -26;
            }
            char[] pszStringtoChars = pszString.toCharArray();
            for (int i = 0; i < pszStringtoChars.length; i++) {
                pContext.pWriteBuffer[pContext.ulCurrentIndex + i] = pszStringtoChars[i];
            }
            pContext.ulCurrentIndex += nSize;
            return 0;
        }

        /* access modifiers changed from: protected */
        public long GetLength() {
            boolean bEmpty = true;
            long ulLength = 0 + 1 + ((long) GetTagName().length());
            SktList.Position position = this.m_Attributes.GetHeadPosition();
            while (position.IsValid()) {
                ulLength = ulLength + 1 + ((CSktXmlTagAttribute) position.GetNext()).GetLength();
            }
            if (GetContentString() != null) {
                bEmpty = false;
                ulLength += (long) GetContentString().length();
            } else {
                SktList.Position position2 = this.m_Content.GetHeadPosition();
                while (position2.IsValid()) {
                    bEmpty = false;
                    ulLength += ((CSktXmlTag) position2.GetNext()).GetLength();
                }
            }
            if (!bEmpty) {
                return ulLength + ((long) GetTagName().length()) + 6;
            }
            return ulLength + 3;
        }

        public int GetChildrenCount() {
            return this.m_Content.GetCount();
        }

        public CSktXmlTag GetChild(int index) {
            CSktXmlTag[] result = new CSktXmlTag[1];
            SktList.Position position = new SktList.Position();
            if (SktScanErrors.SKTSUCCESS(this.m_Content.FindIndex((long) index, position)) && !SktScanErrors.SKTSUCCESS(this.m_Content.GetAt(position, result))) {
                result[0] = null;
            }
            return result[0];
        }

        /* access modifiers changed from: protected */
        public long Clone(CSktXmlTag[] ppCloned) {
            long Result;
            long Result2 = 0;
            CSktXmlTag pClonedTemp = null;
            if (ppCloned == null) {
                Result2 = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                ppCloned[0] = null;
                pClonedTemp = new CSktXmlTag();
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SktDebug.DBGSKT_EVAL(pClonedTemp.WriteName(GetTagName(), GetTagName().length()), "pClonedTemp.WriteName(GetTagName(),GetTagName().length())");
            }
            SktList attributsList = this.m_Attributes;
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                SktList.Position position = attributsList.GetHeadPosition();
                while (position.IsValid()) {
                    CSktXmlTagAttribute pAttribute = (CSktXmlTagAttribute) position.GetNext();
                    Result2 = SktDebug.DBGSKT_EVAL(pClonedTemp.AddAttribute(pAttribute.GetName(), pAttribute.GetName().length(), pAttribute.GetValue(), pAttribute.GetValue().length()), "pClonedTemp.AddAttribute(pAttribute.GetName(),pAttribute.GetName().length(),pAttribute.GetValue(),pAttribute.GetValue().length())");
                    if (!SktScanErrors.SKTSUCCESS(Result2)) {
                        break;
                    }
                }
            }
            if (!IsContentString()) {
                CSktXmlTag[] pNewTag = new CSktXmlTag[1];
                SktList.Position position2 = this.m_Content.GetHeadPosition();
                while (position2.IsValid()) {
                    Result = SktDebug.DBGSKT_EVAL(((CSktXmlTag) position2.GetNext()).Clone(pNewTag), "pCurrentTag.Clone(pNewTag)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(pClonedTemp.InsertTag(pNewTag[0]), "pClonedTemp.InsertTag(pNewTag[0])");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        pNewTag[0] = null;
                    }
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pClonedTemp.AddStringContent(GetContentString(), GetContentString().length()), "pClonedTemp.AddStringContent(GetContentString(), GetContentString().length())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                ppCloned[0] = pClonedTemp;
            }
            return Result;
        }

        public long ReadTagContent(char[] pszBuffer, int ulBufferSize, SktScanTypes.TSktScanInteger pulSizeRead) {
            long Result = 0;
            TSktXmlContext Context = new TSktXmlContext();
            Context.pWriteBuffer = pszBuffer;
            Context.ulBufferSize = (long) ulBufferSize;
            Context.nLineNumber = 1;
            if (pszBuffer == null) {
                Result = -18;
            } else if (pulSizeRead == null) {
                Result = -2;
            } else {
                pulSizeRead.m_value = 0;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = Read(Context);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pulSizeRead.m_value = Context.ulCurrentIndex;
            }
            return Result;
        }
    }

    static class CSktXmlTagAttribute {
        protected final AmpersandXml[] AmpersandTable = {new AmpersandXml("&amp;", '&'), new AmpersandXml("&lt;", '<'), new AmpersandXml("&gt;", '>'), new AmpersandXml("&quot;", '\"')};
        private String m_pszName = "";
        private String m_pszValue = "";

        protected class AmpersandXml {
            protected char _actualChar;
            protected String _xmlString;

            public AmpersandXml(String xml, char character) {
                this._xmlString = xml;
                this._actualChar = character;
            }

            /* access modifiers changed from: package-private */
            public String getXmlString() {
                return this._xmlString;
            }

            /* access modifiers changed from: package-private */
            public char getActualChar() {
                return this._actualChar;
            }
        }

        protected CSktXmlTagAttribute() {
        }

        /* access modifiers changed from: protected */
        public long WriteName(String pszName, int nLength) {
            try {
                this.m_pszName = pszName.substring(0, nLength);
                return 0;
            } catch (StringIndexOutOfBoundsException e) {
                return -18;
            }
        }

        /* access modifiers changed from: protected */
        public long WriteValue(String pszValue, int nLength) {
            try {
                this.m_pszValue = pszValue.substring(0, nLength);
                return 0;
            } catch (StringIndexOutOfBoundsException e) {
                return -18;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long Parse(com.SocketMobile.ScanAPICore.SktSimpleXml.TSktXmlContext r21) {
            /*
                r20 = this;
                r4 = 0
                r7 = 1
                r10 = 0
                r9 = 0
                r12 = 0
                r11 = 0
                r3 = 0
                if (r21 != 0) goto L_0x000c
                r4 = -18
            L_0x000c:
                boolean r13 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r4)
                if (r13 == 0) goto L_0x0034
                r0 = r21
                int r8 = r0.ulCurrentIndex
            L_0x0016:
                long r14 = (long) r8
                r0 = r21
                long r0 = r0.ulBufferSize
                r16 = r0
                int r13 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r13 >= 0) goto L_0x0034
                r0 = r21
                char[] r13 = r0.pBuffer
                char r13 = r13[r8]
                switch(r13) {
                    case 10: goto L_0x0144;
                    case 13: goto L_0x002e;
                    case 32: goto L_0x0035;
                    case 34: goto L_0x0041;
                    case 60: goto L_0x0107;
                    case 61: goto L_0x003b;
                    case 62: goto L_0x00ca;
                    default: goto L_0x002a;
                }
            L_0x002a:
                if (r3 != 0) goto L_0x0155
                r3 = 1
                r10 = r8
            L_0x002e:
                if (r7 != 0) goto L_0x015c
                r0 = r21
                r0.ulCurrentIndex = r8
            L_0x0034:
                return r4
            L_0x0035:
                r13 = 1
                if (r3 != r13) goto L_0x002e
                r9 = r8
                r3 = 2
                goto L_0x002e
            L_0x003b:
                r13 = 1
                if (r3 != r13) goto L_0x002e
                r9 = r8
                r3 = 2
                goto L_0x002e
            L_0x0041:
                r13 = 2
                if (r3 != r13) goto L_0x0048
                r3 = 3
                int r12 = r8 + 1
                goto L_0x002e
            L_0x0048:
                r13 = 4
                if (r3 == r13) goto L_0x004e
                r13 = 3
                if (r3 != r13) goto L_0x008d
            L_0x004e:
                r11 = r8
                java.lang.String r2 = new java.lang.String
                r0 = r21
                char[] r13 = r0.pBuffer
                int r14 = r9 - r10
                r2.<init>(r13, r10, r14)
                boolean r13 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r4)
                if (r13 == 0) goto L_0x006e
                int r13 = r9 - r10
                r0 = r20
                long r14 = r0.WriteName(r2, r13)
                java.lang.String r13 = "WriteName(Name,ulNameEndIndex-ulNameStartIndex)"
                long r4 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r14, r13)
            L_0x006e:
                java.lang.String r6 = new java.lang.String
                r0 = r21
                char[] r13 = r0.pBuffer
                int r14 = r11 - r12
                r6.<init>(r13, r12, r14)
                boolean r13 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r4)
                if (r13 == 0) goto L_0x008b
                r0 = r20
                long r14 = r0.RestoreXMLAndWriteValue(r6)
                java.lang.String r13 = "RestoreXMLAndWriteValue(Value)"
                long r4 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r14, r13)
            L_0x008b:
                r7 = 0
                goto L_0x002e
            L_0x008d:
                r4 = -52
                r13 = 2
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r15 = "Unexpected \" at line:"
                java.lang.StringBuilder r14 = r14.append(r15)
                r0 = r21
                int r15 = r0.nLineNumber
                java.lang.String r15 = java.lang.String.valueOf(r15)
                java.lang.StringBuilder r14 = r14.append(r15)
                java.lang.String r15 = " col:"
                java.lang.StringBuilder r14 = r14.append(r15)
                long r0 = (long) r8
                r16 = r0
                r0 = r21
                long r0 = r0.ulRowOffset
                r18 = r0
                long r16 = r16 - r18
                java.lang.String r15 = java.lang.String.valueOf(r16)
                java.lang.StringBuilder r14 = r14.append(r15)
                java.lang.String r14 = r14.toString()
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r13, r14)
                r7 = 0
                goto L_0x002e
            L_0x00ca:
                r4 = -52
                r13 = 2
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r15 = "Unexpected \" at line:"
                java.lang.StringBuilder r14 = r14.append(r15)
                r0 = r21
                int r15 = r0.nLineNumber
                java.lang.String r15 = java.lang.String.valueOf(r15)
                java.lang.StringBuilder r14 = r14.append(r15)
                java.lang.String r15 = " col:"
                java.lang.StringBuilder r14 = r14.append(r15)
                long r0 = (long) r8
                r16 = r0
                r0 = r21
                long r0 = r0.ulRowOffset
                r18 = r0
                long r16 = r16 - r18
                java.lang.String r15 = java.lang.String.valueOf(r16)
                java.lang.StringBuilder r14 = r14.append(r15)
                java.lang.String r14 = r14.toString()
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r13, r14)
                r7 = 0
                goto L_0x002e
            L_0x0107:
                r4 = -52
                r13 = 2
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r15 = "Unexpected \" at line:"
                java.lang.StringBuilder r14 = r14.append(r15)
                r0 = r21
                int r15 = r0.nLineNumber
                java.lang.String r15 = java.lang.String.valueOf(r15)
                java.lang.StringBuilder r14 = r14.append(r15)
                java.lang.String r15 = " col:"
                java.lang.StringBuilder r14 = r14.append(r15)
                long r0 = (long) r8
                r16 = r0
                r0 = r21
                long r0 = r0.ulRowOffset
                r18 = r0
                long r16 = r16 - r18
                java.lang.String r15 = java.lang.String.valueOf(r16)
                java.lang.StringBuilder r14 = r14.append(r15)
                java.lang.String r14 = r14.toString()
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r13, r14)
                r7 = 0
                goto L_0x002e
            L_0x0144:
                r0 = r21
                int r13 = r0.nLineNumber
                int r13 = r13 + 1
                r0 = r21
                r0.nLineNumber = r13
                long r14 = (long) r8
                r0 = r21
                r0.ulRowOffset = r14
                goto L_0x002e
            L_0x0155:
                r13 = 3
                if (r3 != r13) goto L_0x002e
                r12 = r8
                r3 = 4
                goto L_0x002e
            L_0x015c:
                int r8 = r8 + 1
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktSimpleXml.CSktXmlTagAttribute.Parse(com.SocketMobile.ScanAPICore.SktSimpleXml$TSktXmlContext):long");
        }

        /* access modifiers changed from: protected */
        public String GetName() {
            return this.m_pszName;
        }

        /* access modifiers changed from: protected */
        public String GetValue() {
            return this.m_pszValue;
        }

        /* access modifiers changed from: protected */
        public long GetLength() {
            return 0 + ((long) GetName().length()) + ((long) GetValue().length()) + 3;
        }

        /* access modifiers changed from: protected */
        public long RestoreXMLAndWriteValue(String value) {
            String[] newValue = new String[1];
            this.m_pszValue = "";
            long Result = SktDebug.DBGSKT_EVAL(RestoreXMLChars(newValue, value), "RestoreXMLChars(m_pszValue, value)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this.m_pszValue = newValue[0];
            }
            return Result;
        }

        /* access modifiers changed from: protected */
        public long RestoreXMLChars(String[] newValue, String value) {
            if (newValue == null || value == null) {
                return -18;
            }
            int length = value.length();
            int max = this.AmpersandTable.length;
            newValue[0] = "";
            int i = 0;
            while (i < length) {
                if (value.charAt(i) == '&') {
                    int k = 0;
                    String sub = value.substring(i);
                    String sub2 = sub.substring(0, sub.indexOf(59) + 1);
                    while (true) {
                        if (k >= max) {
                            break;
                        } else if (sub2.compareToIgnoreCase(this.AmpersandTable[k].getXmlString()) == 0) {
                            newValue[0] = newValue[0] + this.AmpersandTable[k].getActualChar();
                            i += this.AmpersandTable[k].getXmlString().length() - 1;
                            break;
                        } else {
                            k++;
                        }
                    }
                    if (k >= max) {
                        return -49;
                    }
                } else {
                    newValue[0] = newValue[0] + value.charAt(i);
                }
                i++;
            }
            return 0;
        }

        /* access modifiers changed from: protected */
        public long ReplaceXMLAndWriteValue(String szValue) {
            this.m_pszValue = "";
            String[] newValue = new String[1];
            long Result = SktDebug.DBGSKT_EVAL(ReplaceXMLChars(newValue, szValue), "ReplaceXMLChars(m_pszValue, szValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this.m_pszValue = newValue[0];
            }
            return Result;
        }

        /* access modifiers changed from: protected */
        public long ReplaceXMLChars(String[] szNewValue, String szValue) {
            if (szNewValue == null || szValue == null) {
                return -18;
            }
            szNewValue[0] = "";
            int length = szValue.length();
            for (int i = 0; i < length; i++) {
                int max = this.AmpersandTable.length;
                int k = 0;
                while (true) {
                    if (k >= max) {
                        break;
                    } else if (szValue.charAt(i) == this.AmpersandTable[k].getActualChar()) {
                        szNewValue[0] = szNewValue[0] + this.AmpersandTable[k].getXmlString();
                        break;
                    } else {
                        k++;
                    }
                }
                if (k >= max) {
                    szNewValue[0] = szNewValue[0] + szValue.charAt(i);
                }
            }
            return 0;
        }
    }

    static class CSktXmlParser {
        private CSktXmlTag m_pRoot = null;

        public long Parse(char[] pszBuffer, long ulSize) {
            long Result = 0;
            SktList BracketsStack = new SktList();
            TSktXmlContext Context = new TSktXmlContext();
            Context.nLineNumber = 1;
            Context.pBuffer = pszBuffer;
            Context.ulBufferSize = ulSize;
            Context.ulCurrentIndex = 0;
            Context.ulRowOffset = 0;
            CSktXmlBracket[] pCurrentBracket = new CSktXmlBracket[1];
            this.m_pRoot = null;
            while (true) {
                if (((long) Context.ulCurrentIndex) >= ulSize) {
                    break;
                }
                pCurrentBracket[0] = new CSktXmlBracket();
                if (pCurrentBracket[0] != null) {
                    Result = SktDebug.DBGSKT_EVAL(pCurrentBracket[0].Parse(Context), "pCurrentBracket[0].Parse(Context)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(BracketsStack.AddTail(pCurrentBracket[0]), "BracketsStack.AddTail(pCurrentBracket[0])");
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        break;
                    }
                    Context.ulCurrentIndex++;
                } else {
                    Result = -2;
                    break;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktList.Position position = BracketsStack.GetHeadPosition();
                if (position.IsValid()) {
                    pCurrentBracket[0] = (CSktXmlBracket) position.GetNext();
                    this.m_pRoot = new CSktXmlTag();
                    if (this.m_pRoot == null) {
                        Result = -2;
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(this.m_pRoot.Initialize(pszBuffer, pCurrentBracket[0], position, BracketsStack), "m_pRoot.Initialize(pszBuffer,pCurrentBracket[0],position,BracketsStack)");
                    }
                }
            }
            while (SktScanErrors.SKTSUCCESS(BracketsStack.RemoveHead(pCurrentBracket))) {
                pCurrentBracket[0] = null;
            }
            return Result;
        }

        /* access modifiers changed from: package-private */
        public long Seek(CSktXmlTag pRootTag, String pszTagPath, int nIndex, boolean bNotFoundError, CSktXmlTag[] ppTagFound) {
            long Result = 0;
            if (this.m_pRoot == null) {
                Result = -6;
            }
            if (SktScanErrors.SKTSUCCESS(Result) && (pszTagPath == null || pszTagPath.length() == 0 || ppTagFound == null)) {
                Result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            ppTagFound[0] = null;
            if (pRootTag == null) {
                CSktXmlTag pRootTag2 = this.m_pRoot;
                if (pRootTag2.StartWithSameName(pszTagPath)) {
                    int nSlashIndex = 0;
                    int nPathLength = pszTagPath.length();
                    int nTagNameLength = pRootTag2.GetTagName().length();
                    if (nPathLength > nTagNameLength && pszTagPath.toCharArray()[nTagNameLength] == '/') {
                        nSlashIndex = nTagNameLength;
                    }
                    if (nSlashIndex != 0) {
                        String pszTagPath2 = pszTagPath.substring(nSlashIndex + 1);
                        return SktScanErrors.SKTSUCCESS(Result) ? SktDebug.DBGSKT_EVAL(pRootTag2.Seek(pszTagPath2, nIndex, bNotFoundError, ppTagFound), "pRootTag.Seek(" + pszTagPath2 + "," + nIndex + "," + bNotFoundError + ",ppTagFound)") : Result;
                    }
                    ppTagFound[0] = pRootTag2;
                    return Result;
                } else if (bNotFoundError) {
                    return -17;
                } else {
                    return Result;
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                return SktDebug.DBGSKT_EVAL(pRootTag.Seek(pszTagPath, nIndex, bNotFoundError, ppTagFound), "pRootTag.Seek(" + pszTagPath + "," + nIndex + "," + bNotFoundError + ",ppTagFound)");
            } else {
                return Result;
            }
        }

        /* access modifiers changed from: package-private */
        public long Read(char[] pszBuffer, long ulBufferSize, long[] pulSizeRead) {
            long Result = 0;
            TSktXmlContext Context = new TSktXmlContext();
            Context.pWriteBuffer = pszBuffer;
            Context.ulBufferSize = ulBufferSize;
            Context.nLineNumber = 1;
            if (this.m_pRoot == null) {
                Result = -6;
            } else if (pulSizeRead == null) {
                Result = -2;
            } else {
                pulSizeRead[0] = 0;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_pRoot.Read(Context);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pulSizeRead[0] = (long) Context.ulCurrentIndex;
            }
            return Result;
        }

        /* access modifiers changed from: package-private */
        public long SetRoot(CSktXmlTag pNewRoot) {
            this.m_pRoot = pNewRoot;
            return 0;
        }

        /* access modifiers changed from: package-private */
        public long GetLength() {
            if (this.m_pRoot != null) {
                return this.m_pRoot.GetLength() + 1;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public long InsertTags(String pszContenerTagPath, int nIndex, CSktXmlTag pTagsToCloneAndInsert) {
            CSktXmlTag[] pContenerTag = new CSktXmlTag[1];
            CSktXmlTag[] pNewTag = new CSktXmlTag[1];
            long Result = SktDebug.DBGSKT_EVAL(Seek((CSktXmlTag) null, pszContenerTagPath, nIndex, false, pContenerTag), "Seek(null,pszContenerTagPath,nIndex,false,pContenerTag)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pTagsToCloneAndInsert.Clone(pNewTag), "pTagsToCloneAndInsert.Clone(pNewTag)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                return SktDebug.DBGSKT_EVAL(pContenerTag[0].InsertTag(pNewTag[0]), "pContenerTag[0].InsertTag(pNewTag[0])");
            }
            return Result;
        }

        static boolean Test() {
            boolean bResult = true;
            CSktXmlTag[] pXmlTag = new CSktXmlTag[1];
            CSktXmlParser Parser = new CSktXmlParser();
            if (1 == 1) {
                bResult = SktDebug.DBGSKT_EXPECTING(Parser.Parse("<start>\n<config name=\"this is a name\">\nthis is a content</config>\n</start>\n".toCharArray(), (long) "<start>\n<config name=\"this is a name\">\nthis is a content</config>\n</start>\n".length()), "Parser.Parse(szXml.toCharArray(),szXml.length())", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Parser.Seek((CSktXmlTag) null, "start/config", 0, true, pXmlTag), "Parser.Seek(null,\"start/config\",0,true,pXmlTag)", 0);
            }
            if (pXmlTag[0].IsContentString()) {
                if (pXmlTag[0].GetContentString() == "this is a content") {
                    SktDebug.DBGSKT_MSG(4, "XML Content string doesn't match");
                    bResult = false;
                }
                if (bResult) {
                    if (pXmlTag[0].GetAttributeValue("name") == null) {
                        SktDebug.DBGSKT_MSG(4, "XML name attribute not found");
                        bResult = false;
                    } else if (pXmlTag[0].GetAttributeValue("name") == "this is a name") {
                        SktDebug.DBGSKT_MSG(4, "XML value attribute doesn't match");
                        bResult = false;
                    }
                }
            }
            CSktXmlTag pNewTag = new CSktXmlTag();
            if (pNewTag == null) {
                SktDebug.DBGSKT_MSG(4, "Not enough memory to complete the test");
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(pNewTag.WriteName("start", "start".length()), "pNewTag.WriteName(\"start\",(\"start\").length())", 0);
            }
            CSktXmlTag pCurrent = pNewTag;
            CSktXmlTag pNewTag2 = new CSktXmlTag();
            if (pNewTag2 == null) {
                SktDebug.DBGSKT_MSG(4, "Not enough memory to complete the test");
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(pNewTag2.WriteName("config", "config".length()), "pNewTag.WriteName(\"config\",(\"config\").length())", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(pNewTag2.AddAttribute("name", "name".length(), "this is a name", "this is a name".length()), "pNewTag.AddAttribute(\"name\",(\"name\").length(),\"this is a name\",(\"this is a name\").length())", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(pNewTag2.AddStringContent("this is a content", "this is a content".length()), "pNewTag.AddStringContent(\"this is a content\",(\"this is a content\").length())", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(pCurrent.InsertTag(pNewTag2), "pCurrent.InsertTag(pNewTag)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Parser.SetRoot(pCurrent), "Parser.SetRoot(pCurrent)", 0);
            }
            long ulBufferSize = Parser.GetLength();
            char[] pszBuffer = new char[((int) ulBufferSize)];
            long[] ulSize = {0};
            if (pszBuffer == null) {
                SktDebug.DBGSKT_MSG(4, "Not enough memory to complete the test");
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Parser.Read(pszBuffer, ulBufferSize, ulSize), "Parser.Read(pszBuffer,ulBufferSize,ulSize)", 0);
            }
            if (bResult && "<start>\n<config name=\"this is a name\">\nthis is a content</config>\n</start>\n".equals(String.valueOf(pszBuffer))) {
                SktDebug.DBGSKT_MSG(4, "XML content doesn't match");
                bResult = false;
            }
            if (bResult) {
                SktDebug.DBGSKT_MSG(1, "SktSimpleXml Test pass");
            }
            return bResult;
        }
    }
}
