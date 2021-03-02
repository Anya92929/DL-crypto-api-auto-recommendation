package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;

public abstract class SktOperation {
    private static final int kFlagCommand = 1;
    private static final int kFlagNotCommand = 2;
    protected SktDataEditingProfile _dataEditing;
    protected SktList _operationsList = new SktList();

    public abstract boolean checkIfParametersAreCorrect();

    public abstract int getResultType();

    public abstract long run(SktOperationResult[] sktOperationResultArr);

    public SktOperation(SktDataEditingProfile dataEditingProfile) {
        this._dataEditing = dataEditingProfile;
    }

    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r0v12, types: [com.SocketMobile.ScanAPICore.SktOperationString] */
    /* JADX WARNING: type inference failed for: r0v13, types: [com.SocketMobile.ScanAPICore.SktOperationString] */
    /* JADX WARNING: type inference failed for: r0v14, types: [com.SocketMobile.ScanAPICore.SktOperationInteger] */
    /* JADX WARNING: type inference failed for: r0v15, types: [com.SocketMobile.ScanAPICore.SktOperationInteger] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long Parse(com.SocketMobile.ScanAPICore.SktDataEditingProfile r28, com.SocketMobile.ScanAPICore.SktOperationDictionary r29, char r30, char r31, com.SocketMobile.ScanAPICore.SktParsingString r32, com.SocketMobile.ScanAPICore.SktList r33) {
        /*
            r20 = 0
            com.SocketMobile.ScanAPICore.SktList r22 = new com.SocketMobile.ScanAPICore.SktList
            r22.<init>()
            r4 = 1
            com.SocketMobile.ScanAPICore.SktOperation[] r9 = new com.SocketMobile.ScanAPICore.SktOperation[r4]
            r4 = 1
            com.SocketMobile.ScanAPICore.SktParsingString[] r10 = new com.SocketMobile.ScanAPICore.SktParsingString[r4]
            r6 = 0
            if (r28 == 0) goto L_0x0016
            if (r29 == 0) goto L_0x0016
            if (r32 == 0) goto L_0x0016
            if (r33 != 0) goto L_0x0018
        L_0x0016:
            r20 = -18
        L_0x0018:
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x003e
            r4 = 0
            java.lang.String r5 = "About to split the string:%s"
            r0 = r32
            r0.DbgFormatDump(r4, r5)
            boolean r4 = r32.isEmpty()
            if (r4 != 0) goto L_0x012d
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r22
            long r4 = Split(r0, r1, r2, r3)
            java.lang.String r7 = "CSktOperation.Split(cOpen,cClose,pParsingString,listOfParsingStrings)"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
        L_0x003e:
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x01ac
            com.SocketMobile.ScanAPICore.SktList$Position r26 = r22.GetHeadPosition()
        L_0x0048:
            boolean r4 = r26.IsValid()
            if (r4 == 0) goto L_0x01ac
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x01ac
            java.lang.Object r6 = r26.GetNext()
            com.SocketMobile.ScanAPICore.SktParsingString r6 = (com.SocketMobile.ScanAPICore.SktParsingString) r6
            r4 = 0
            java.lang.String r5 = "Parsing String:%s"
            r6.DbgFormatDump(r4, r5)
            boolean r4 = isCommand(r6)
            r5 = 1
            if (r4 != r5) goto L_0x016d
            r4 = 0
            java.lang.String r5 = "The string %s is a command so look it up"
            r6.DbgFormatDump(r4, r5)
            r4 = r29
            r5 = r28
            r7 = r30
            r8 = r31
            long r4 = LookupCommand(r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r7 = "SktOperation.LookupCommand(dictionary,dataEditing,string,cOpen,cClose,newOperation,operationParsingString)"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x0094
            r4 = 0
            r4 = r9[r4]
            r0 = r33
            long r4 = r0.AddTail(r4)
            java.lang.String r7 = "operationsList.AddTail(newOperation[0])"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
        L_0x0094:
            com.SocketMobile.ScanAPICore.SktList r27 = new com.SocketMobile.ScanAPICore.SktList
            r27.<init>()
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x0048
            r4 = 0
            r4 = r10[r4]
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0048
            r4 = 0
            r4 = r10[r4]
            r5 = 0
            java.lang.String r7 = "This command has some operations:%s"
            r4.DbgFormatDump(r5, r7)
            r4 = 0
            r4 = r10[r4]
            r0 = r30
            r1 = r31
            r2 = r27
            long r4 = splitInParametersIfNecessary(r4, r0, r1, r2)
            java.lang.String r7 = "SktOperation.splitInParametersIfNecessary(operationParsingString[0],cOpen,cClose,sktParametersList"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
            r4 = 17
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "It has "
            java.lang.StringBuilder r5 = r5.append(r7)
            int r7 = r27.GetCount()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = " parameters"
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r4, r5)
            com.SocketMobile.ScanAPICore.SktList$Position r17 = r27.GetHeadPosition()
            r15 = 0
        L_0x00eb:
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x0154
            boolean r4 = r17.IsValid()
            if (r4 == 0) goto L_0x0154
            com.SocketMobile.ScanAPICore.SktList$Position r18 = r17.Copy()
            java.lang.Object r15 = r17.GetNext()
            com.SocketMobile.ScanAPICore.SktParsingString r15 = (com.SocketMobile.ScanAPICore.SktParsingString) r15
            r4 = 0
            r4 = r9[r4]
            com.SocketMobile.ScanAPICore.SktList r16 = r4.getOperationsList()
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r31
            long r4 = Parse(r11, r12, r13, r14, r15, r16)
            java.lang.String r7 = "SktOperation.Parse(dataEditing,dictionary,cOpen,cClose,parameterParsingString,newOperation[0].getOperationsList())"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
            r4 = 1
            com.SocketMobile.ScanAPICore.SktParsingString[] r0 = new com.SocketMobile.ScanAPICore.SktParsingString[r4]
            r25 = r0
            r0 = r27
            r1 = r18
            r2 = r25
            r0.RemoveAt(r1, r2)
            r4 = 0
            r5 = 0
            r25[r4] = r5
            goto L_0x00eb
        L_0x012d:
            com.SocketMobile.ScanAPICore.SktOperationString r19 = new com.SocketMobile.ScanAPICore.SktOperationString
            r0 = r19
            r1 = r28
            r2 = r32
            r0.<init>(r1, r2)
            if (r19 != 0) goto L_0x013e
            r20 = -2
            goto L_0x003e
        L_0x013e:
            r0 = r33
            r1 = r19
            long r4 = r0.AddTail(r1)
            java.lang.String r7 = "operationsList.AddTail(emptyString)"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 != 0) goto L_0x003e
            goto L_0x003e
        L_0x0154:
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x0048
            r4 = 0
            r4 = r9[r4]
            boolean r4 = r4.checkIfParametersAreCorrect()
            if (r4 != 0) goto L_0x0048
            r4 = 1
            java.lang.String r5 = "Parameters incorrect for:%s"
            r6.DbgFormatDump(r4, r5)
            r20 = -18
            goto L_0x0048
        L_0x016d:
            r4 = 0
            java.lang.String r5 = "The string %s is not a command so try to create a String or Integer operation"
            r6.DbgFormatDump(r4, r5)
            r24 = 0
            boolean r4 = r6.isNumber()
            if (r4 == 0) goto L_0x019e
            com.SocketMobile.ScanAPICore.SktOperationInteger r24 = new com.SocketMobile.ScanAPICore.SktOperationInteger
            r0 = r24
            r1 = r28
            r0.<init>(r1, r6)
            if (r24 != 0) goto L_0x0188
            r20 = -2
        L_0x0188:
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r20)
            if (r4 == 0) goto L_0x0048
            r0 = r33
            r1 = r24
            long r4 = r0.AddTail(r1)
            java.lang.String r7 = "operationsList.AddTail(newStringOperation)"
            long r20 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r7)
            goto L_0x0048
        L_0x019e:
            com.SocketMobile.ScanAPICore.SktOperationString r24 = new com.SocketMobile.ScanAPICore.SktOperationString
            r0 = r24
            r1 = r28
            r0.<init>(r1, r6)
            if (r24 != 0) goto L_0x0188
            r20 = -2
            goto L_0x0188
        L_0x01ac:
            r4 = 1
            com.SocketMobile.ScanAPICore.SktParsingString[] r0 = new com.SocketMobile.ScanAPICore.SktParsingString[r4]
            r23 = r0
        L_0x01b1:
            int r4 = r22.GetCount()
            if (r4 <= 0) goto L_0x01c6
            long r4 = r22.RemoveHead(r23)
            boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r4)
            if (r4 == 0) goto L_0x01b1
            r4 = 0
            r5 = 0
            r23[r4] = r5
            goto L_0x01b1
        L_0x01c6:
            r23 = 0
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktOperation.Parse(com.SocketMobile.ScanAPICore.SktDataEditingProfile, com.SocketMobile.ScanAPICore.SktOperationDictionary, char, char, com.SocketMobile.ScanAPICore.SktParsingString, com.SocketMobile.ScanAPICore.SktList):long");
    }

    public static long Split(char cStart, char cEnd, SktParsingString parsingString, SktList parsingStringsList) {
        long Result = 0;
        SktParsingString startEnd = new SktParsingString(String.valueOf(new char[]{cStart, cEnd}));
        if (parsingString == null || parsingString.getLength() == 0 || parsingStringsList == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktParsingString inputString = new SktParsingString(parsingString);
            inputString.setFlag(parsingString.getFlag());
            while (SktScanErrors.SKTSUCCESS(Result) && inputString.getLength() > 0) {
                SktParsingString newString = new SktParsingString(inputString.ExtractBefore(cStart));
                if (newString == null) {
                    Result = -2;
                }
                if (SktScanErrors.SKTSUCCESS(Result) && !newString.isEmpty()) {
                    newString.setFlag(2);
                    newString.DbgFormatDump(false, "Adding(1) in the parsing list: %s");
                    Result = SktDebug.DBGSKT_EVAL(parsingStringsList.AddTail(newString), "parsingStringsList.AddTail(newString)");
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        newString = null;
                    }
                }
                if (!inputString.isEmpty()) {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        newString = new SktParsingString(inputString.Extract(cStart, cEnd));
                        if (newString == null) {
                            Result = -2;
                        } else if (!inputString.isEmpty()) {
                            newString.DbgFormatDump(false, "This new parsing string starts with a command: %s");
                            newString.setFlag(1);
                        } else if (!(newString.find(cStart) == -1 && newString.find(cEnd) == -1)) {
                            Result = -52;
                        }
                    }
                    newString.DbgFormatDump(false, "Adding(2) in the parsing list: %s");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(parsingStringsList.AddTail(newString), "parsingStringsList.AddTail(newString)");
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                    }
                }
                inputString.Remove(startEnd);
            }
        }
        return Result;
    }

    public static boolean isCommand(SktParsingString parsingString) {
        if (parsingString == null || parsingString.getFlag() != 1) {
            return false;
        }
        return true;
    }

    public static long LookupCommand(SktOperationDictionary dictionary, SktDataEditingProfile dataEditingProfile, SktParsingString currentString, char cOpen, char cClose, SktOperation[] newOperation, SktParsingString[] newOperationParsingString) {
        long result = 0;
        if (dictionary == null || dataEditingProfile == null || currentString == null || newOperation == null || newOperationParsingString == null) {
            result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            newOperation[0] = null;
            newOperationParsingString[0] = null;
            SktParsingString Command = currentString.ExtractBefore('(');
            newOperationParsingString[0] = new SktParsingString(currentString.Extract('(', ')'));
            if (newOperationParsingString[0] == null) {
                result = -2;
            }
            if (SktScanErrors.SKTSUCCESS(result)) {
                newOperationParsingString[0].DbgFormatDump(false, "Inside Parenthesis:%s");
                SktOperationFactory factory = dictionary.getValue(Command.getString(), Command.getLength());
                if (factory == null) {
                    Command.DbgFormatDump(true, "Error unable to find the command:%s");
                    result = -83;
                } else {
                    Command.DbgFormatDump(false, "*** command:%s");
                    result = SktDebug.DBGSKT_EVAL(factory.createOperation(dataEditingProfile, newOperation), "factory.createOperation(dataEditingProfile,newOperation)");
                }
            }
            if (SktScanErrors.SKTSUCCESS(result)) {
                result = SktDebug.DBGSKT_EVAL(checkParametersCount(newOperation[0], newOperationParsingString[0], cOpen, cClose), "result=CheckParametersCount(*ppNewOperation,*ppNewOperationParsingString,cOpen,cClose)");
            }
            if (!SktScanErrors.SKTSUCCESS(result)) {
                newOperation[0] = null;
                newOperationParsingString[0] = null;
            }
        }
        return result;
    }

    public long getParameterCount() {
        return 0;
    }

    public static long checkParametersCount(SktOperation operation, SktParsingString operationParameter, char cOpen, char cClose) {
        long result = 0;
        if (operation == null || operationParameter == null) {
            result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(result)) {
            return result;
        }
        int nOpen = 0;
        int nCount = 0;
        char[] szString = operationParameter.getString();
        for (int nIndex = 0; nIndex < operationParameter.getLength(); nIndex++) {
            if (szString[nIndex] == ',' && nOpen == 0) {
                nCount++;
            } else if (szString[nIndex] == cOpen) {
                if (nCount == 0) {
                    nCount++;
                }
                nOpen++;
            } else if (szString[nIndex] == cClose) {
                if (nCount == 0) {
                    nCount++;
                }
                nOpen--;
                if (nOpen < 0) {
                    nOpen = 0;
                }
            } else if (szString[nIndex] != ' ' && nOpen == 0 && nCount == 0) {
                nCount++;
            }
        }
        if (operation.getParameterCount() != ((long) nCount)) {
            return -84;
        }
        return result;
    }

    public boolean canResultBeAString() {
        if (getResultType() == 1 || getResultType() == 3) {
            return true;
        }
        return false;
    }

    public boolean canResultBeAnInteger() {
        if (getResultType() == 2 || getResultType() == 3) {
            return true;
        }
        return false;
    }

    public SktList getOperationsList() {
        return this._operationsList;
    }

    protected static long splitInParametersIfNecessary(SktParsingString stringInsideParenthesis, char cOpen, char cClose, SktList sktParametersList) {
        long result;
        long result2 = 0;
        SktParsingString Coma = new SktParsingString(",");
        SktParsingString InsideParenthesis = new SktParsingString();
        if (stringInsideParenthesis == null || sktParametersList == null) {
            result2 = -18;
        } else {
            InsideParenthesis = new SktParsingString(stringInsideParenthesis);
        }
        char[] pszInside = InsideParenthesis.getString();
        int length = InsideParenthesis.getLength();
        int index = 0;
        int nOpenCount = 0;
        while (SktScanErrors.SKTSUCCESS(result) && index < length) {
            if (pszInside[index] == ',') {
                if (nOpenCount == 0) {
                    SktParsingString newString = new SktParsingString(InsideParenthesis.ExtractBeforeIndex(index));
                    if (newString == null) {
                        result = -2;
                    } else {
                        result = SktDebug.DBGSKT_EVAL(InsideParenthesis.Remove(Coma), "InsideParenthesis.Remove(Coma)");
                        if (SktScanErrors.SKTSUCCESS(result)) {
                            result = SktDebug.DBGSKT_EVAL(sktParametersList.AddTail(newString), "parsingStringsList[0].AddTail(newString)");
                        }
                        if (!SktScanErrors.SKTSUCCESS(result)) {
                        }
                        length = InsideParenthesis.getLength();
                        pszInside = InsideParenthesis.getString();
                        index = 0;
                        if (InsideParenthesis.isEmpty()) {
                            SktParsingString newString2 = new SktParsingString();
                            if (newString2 == null) {
                                result = -2;
                            } else {
                                if (SktScanErrors.SKTSUCCESS(result)) {
                                    result = SktDebug.DBGSKT_EVAL(sktParametersList.AddTail(newString2), "parsingStringsList[0].AddTail(newString)");
                                }
                                if (!SktScanErrors.SKTSUCCESS(result)) {
                                }
                            }
                        }
                    }
                }
            } else if (pszInside[index] == cOpen) {
                nOpenCount++;
            } else if (pszInside[index] == cClose && nOpenCount - 1 < 0) {
                nOpenCount = 0;
            }
            index++;
        }
        if (InsideParenthesis.isEmpty()) {
            return result;
        }
        SktParsingString newString3 = new SktParsingString(InsideParenthesis);
        if (newString3 == null) {
            return -2;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(sktParametersList.AddTail(newString3), "parsingStringsList[0].AddTail(newString)");
        }
        return !SktScanErrors.SKTSUCCESS(result) ? result : result;
    }
}
