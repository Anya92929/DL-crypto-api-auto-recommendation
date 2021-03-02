package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktSimpleXml;

class SktConfigXml {
    private final String kValueName = "Value";
    private SktSimpleXml.CSktXmlParser m_Parser = new SktSimpleXml.CSktXmlParser();
    private boolean m_bNotFoundError = true;

    public long Load(String strContent, long size) {
        long Result = 0;
        if (strContent == null || strContent.length() == 0 || size == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(this.m_Parser.Parse(strContent.toCharArray(), size), "m_Parser.Parse(strContent.toCharArray(),size)");
        }
        return Result;
    }

    public long Load(String pszPathName, String pszFileName, String pszDefaultConfigXmlContent) {
        long Result;
        long Result2 = 0;
        String pszPathFileName = null;
        SktPlatform.SktFile File = new SktPlatform.SktFile();
        long[] ulSizeRead = {0};
        byte[] pszBuffer = null;
        boolean bCreated = false;
        if (pszPathName == null || pszFileName == null || pszPathName.length() == 0 || pszFileName.length() == 0) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result2) && !SktPlatform.SktDirectory.DoesExist(pszPathName)) {
            Result2 = SktDebug.DBGSKT_EVAL(SktPlatform.SktDirectory.Create(pszPathName), "SktDirectory.Create(pszPathName)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            String pszPathFileName2 = pszPathName;
            if (!pszPathFileName2.endsWith("/")) {
                pszPathFileName2 = pszPathFileName2 + "/";
            }
            pszPathFileName = pszPathFileName2 + pszFileName;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            boolean bCreateFile = false;
            Result = SktDebug.DBGSKT_EVAL(File.Open(pszPathFileName, 1), "File.Open(pszPathFileName,Connector.READ)");
            if (pszDefaultConfigXmlContent != null) {
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    bCreateFile = true;
                } else if (File.GetLength() == 0) {
                    bCreateFile = true;
                    File.Close();
                }
            }
            if (bCreateFile) {
                Result = SktDebug.DBGSKT_EVAL(this.m_Parser.Parse(pszDefaultConfigXmlContent.toCharArray(), (long) pszDefaultConfigXmlContent.length()), "m_Parser.Parse(pszDefaultConfigXmlContent.toCharArray(),(long)pszDefaultConfigXmlContent.length())");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(Save(pszPathName, pszFileName), "Save(pszPathName,pszFileName)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(File.Open(pszPathFileName, 1), "File.Open(pszPathFileName,SktFile.READ)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    bCreated = true;
                }
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long ulBufferSize = File.GetLength();
            pszBuffer = new byte[((int) ulBufferSize)];
            if (pszBuffer != null) {
                Result = SktDebug.DBGSKT_EVAL(File.Read(pszBuffer, ulBufferSize, ulSizeRead), "File.Read(pszBuffer,ulBufferSize,ulSizeRead)");
            } else {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Parser.Parse(new String(pszBuffer).toCharArray(), ulSizeRead[0]), "m_Parser.Parse(strResult.toCharArray(),ulSizeRead[0])");
        }
        if (SktScanErrors.SKTSUCCESS(Result) && bCreated) {
            Result = 5;
        }
        File.Close();
        return Result;
    }

    public long Save(String pszPathName, String pszFileName) {
        long Result = 0;
        String pszPathFileName = "";
        SktPlatform.SktFile File = new SktPlatform.SktFile();
        String[] szContent = new String[1];
        long[] ulSizeRead = new long[1];
        long ulBufferSize = 0;
        char[] pszBuffer = null;
        if (pszPathName == null || pszFileName == null || pszPathName.length() == 0 || pszFileName.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(save(szContent), "save(szContent)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (!SktPlatform.SktDirectory.DoesExist(pszPathName)) {
                Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktDirectory.Create(pszPathName), "SktDirectory.Create(pszPathName)");
            }
            String pszPathFileName2 = pszPathName;
            if (!pszPathFileName2.endsWith("/")) {
                pszPathFileName2 = pszPathFileName2 + "/";
            }
            pszPathFileName = pszPathFileName2 + pszFileName;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszBuffer = szContent[0].toCharArray();
            ulBufferSize = (long) pszBuffer.length;
            Result = SktDebug.DBGSKT_EVAL(this.m_Parser.Read(pszBuffer, ulBufferSize, ulSizeRead), "m_Parser.Read(pszBuffer,ulBufferSize,ulSizeRead)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(File.Open(pszPathFileName, 3), "File.Open(pszPathFileName,Connector.READ_WRITE)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(File.Write(new String(pszBuffer).getBytes(), ulBufferSize, ulSizeRead[0]), "File.Write(strBuffer.getBytes(),ulBufferSize,ulSizeRead[0])");
        }
        File.Close();
        szContent[0] = null;
        return Result;
    }

    public long Seek(SktSimpleXml.CSktXmlTag Root, String pszTagPath, boolean bNotFoundError, SktSimpleXml.CSktXmlTag[] Tag) {
        return SktDebug.DBGSKT_EVAL(this.m_Parser.Seek(Root, pszTagPath, 0, bNotFoundError, Tag), "m_Parser.Seek(Root,pszTagPath,0,bNotFoundError,Tag)");
    }

    public long Enumerate(SktSimpleXml.CSktXmlTag Root, int nIndex, String pszName, SktSimpleXml.CSktXmlTag[] Tag) {
        return SktDebug.DBGSKT_EVAL(this.m_Parser.Seek(Root, pszName, nIndex, true, Tag), "m_Parser.Seek(Root,pszName,nIndex,true,Tag)");
    }

    public long Search(SktSimpleXml.CSktXmlTag Root, String pszValueName, String pszValue, SktScanTypes.TSktScanBoolean bFound, SktSimpleXml.CSktXmlTag[] TagFound) {
        long Result = 0;
        String[] pszValueRead = null;
        int nIndex = 0;
        if (Root == null || pszValueName == null || pszValue == null || bFound == null || TagFound == null || pszValueName.length() == 0 || pszValue.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            bFound.setValue(false);
            pszValueRead = new String[1];
            if (pszValueRead == null) {
                Result = -2;
            }
        }
        while (true) {
            if (SktScanErrors.SKTSUCCESS(this.m_Parser.Seek(Root, pszValueName, nIndex, true, TagFound))) {
                if (SktScanErrors.SKTSUCCESS(ReadValue(TagFound[0], pszValueRead, 2048)) && pszValueRead[0].equals(pszValue)) {
                    bFound.setValue(true);
                    break;
                }
                nIndex++;
            } else {
                break;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result) && !bFound.getValue()) {
        }
        return Result;
    }

    public long Search(SktSimpleXml.CSktXmlTag Root, String pszValueName, long ulValue, SktScanTypes.TSktScanBoolean bFound, SktSimpleXml.CSktXmlTag[] TagFound) {
        return SktDebug.DBGSKT_EVAL(Search(Root, pszValueName, String.valueOf(ulValue), bFound, TagFound), "Search(Root,pszValueName,szValue,bFound,TagFound)");
    }

    public long ReadValue(SktSimpleXml.CSktXmlTag pTag, String[] pszValue, int nLength) {
        long Result = 0;
        if (pTag == null || pszValue == null || nLength == 0) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (pTag.GetAttributeValue("Value") == null) {
            return -17;
        }
        pszValue[0] = pTag.GetAttributeValue("Value");
        return Result;
    }

    public long ReadValue(SktSimpleXml.CSktXmlTag pTag, long[] pulValue) {
        long Result = 0;
        String[] szValue = new String[1];
        if (pulValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadValue(pTag, szValue, 64), "ReadValue(pTag,szValue,nLength)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pulValue[0] = (long) szValue[0].length();
        }
        return Result;
    }

    public long ReadSubValue(SktSimpleXml.CSktXmlTag pParentTag, String pszValueName, String[] pszValue, int nLength) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pValueTag = new SktSimpleXml.CSktXmlTag[1];
        if (pParentTag == null || pszValue == null || nLength == 0) {
            Result = -18;
        } else {
            pszValue[0] = "";
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(pParentTag.Seek(pszValueName, 0, this.m_bNotFoundError, pValueTag), "pParentTag.Seek(pszValueName,0,m_bNotFoundError,pValueTag)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || pValueTag[0] == null) {
            return Result;
        }
        if (pValueTag[0].GetAttributeValue("Value") == null) {
            return -17;
        }
        pszValue[0] = pValueTag[0].GetAttributeValue("Value");
        return Result;
    }

    public long ReadSubValue(SktSimpleXml.CSktXmlTag pParentTag, String pszValueName, long[] pulValue) {
        long Result = 0;
        String[] szValue = new String[1];
        if (pulValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadSubValue(pParentTag, pszValueName, szValue, 64), "ReadSubValue(pParentTag,pszValueName,szValue,64)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pulValue[0] = (long) szValue.length;
        }
        return Result;
    }

    public long WriteValue(SktSimpleXml.CSktXmlTag Tag, String pszValue) {
        long Result = 0;
        if (Tag == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(Tag.AddAttribute("Value", "Value".length(), pszValue, pszValue.length()), "Tag.AddAttribute(kValueName,kValueName.length(),pszValue,pszValue.length())");
        }
        return Result;
    }

    public long WriteValue(SktSimpleXml.CSktXmlTag Tag, long ulValue) {
        String szValue = String.valueOf(ulValue);
        if (SktScanErrors.SKTSUCCESS(0)) {
            return SktDebug.DBGSKT_EVAL(WriteValue(Tag, szValue), "WriteValue(Tag,szValue)");
        }
        return 0;
    }

    public long WriteSubValue(SktSimpleXml.CSktXmlTag ParentTag, String pszValueName, String pszValue, int nLength) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] Tag = new SktSimpleXml.CSktXmlTag[1];
        if (ParentTag == null || pszValueName == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ParentTag.Seek(pszValueName, 0, true, Tag), "ParentTag.Seek(" + pszValueName + ",0,true,Tag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(Tag[0].AddAttribute("Value", "Value".length(), pszValue, nLength), "Tag[0].AddAttribute(kValueName, kValueName.length(), pszValue, nLength)");
        }
        return Result;
    }

    public long WriteSubValue(SktSimpleXml.CSktXmlTag ParentTag, String pszValueName, long ulValue) {
        String szValue = String.valueOf(ulValue);
        return SktDebug.DBGSKT_EVAL(WriteSubValue(ParentTag, pszValueName, szValue, szValue.length()), "WriteSubValue(ParentTag,pszValueName,szValue)");
    }

    public long AddValue(SktSimpleXml.CSktXmlTag ParentTag, String pszValueName, String pszValue) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] NewTag = new SktSimpleXml.CSktXmlTag[1];
        if (ParentTag == null || pszValueName == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ParentTag.AddTag(pszValueName, pszValueName.length(), NewTag), "ParentTag.AddTag(pszValueName,pszValueName.length(),NewTag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(NewTag[0].AddAttribute("Value", "Value".length(), pszValue, pszValue.length()), "NewTag[0].AddAttribute(kValueName,kValueName.length(),pszValue,pszValue.length())");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ParentTag.RemoveTag(NewTag[0]);
            }
        }
        return Result;
    }

    public long RemoveValue(SktSimpleXml.CSktXmlTag ParentTag, String pszValueName) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] TagFound = new SktSimpleXml.CSktXmlTag[1];
        if (ParentTag == null || pszValueName == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ParentTag.Seek(pszValueName, 0, true, TagFound), "ParentTag.Seek(pszValueName,0,true,TagFound)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(ParentTag.RemoveTag(TagFound[0]), "ParentTag.RemoveTag(TagFound[0])");
        }
        return Result;
    }

    public long AddSection(SktSimpleXml.CSktXmlTag Root, String pszSectionName, String pszSectionValue, SktSimpleXml.CSktXmlTag[] pSectionTag) {
        long Result = 0;
        if (Root == null || pszSectionName == null || pSectionTag == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Root.AddTag(pszSectionName, pszSectionName.length(), pSectionTag), "Root.AddTag(pszSectionName,pszSectionName.length(),pSectionTag)");
        }
        if (pszSectionValue == null || !SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        return SktDebug.DBGSKT_EVAL(pSectionTag[0].AddAttribute("Value", "Value".length(), pszSectionValue, pszSectionValue.length()), "(pSectionTag[0]).AddAttribute(kValueName,kValueName.length(),pszSectionValue,pszSectionValue.length())");
    }

    public long RemoveSection(SktSimpleXml.CSktXmlTag Root, String pszSectionName, String pszSectionValue) {
        long Result = 0;
        SktScanTypes.TSktScanBoolean bFound = new SktScanTypes.TSktScanBoolean(false);
        SktSimpleXml.CSktXmlTag[] SectionTag = new SktSimpleXml.CSktXmlTag[1];
        if (Root == null || pszSectionName == null) {
            Result = -18;
        }
        if (pszSectionValue != null) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(Search(Root, pszSectionName, pszSectionValue, bFound, SectionTag), "Search(Root,pszSectionName,pszSectionValue,bFound,SectionTag)");
            }
            if (!bFound.getValue()) {
                Result = -17;
            }
        } else if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Root.Seek(pszSectionName, 0, true, SectionTag), "Root.Seek(pszSectionName,0,true,SectionTag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(Root.RemoveTag(SectionTag[0]), "Root.RemoveTag(SectionTag[0])");
        }
        return Result;
    }

    public long InsertXmlTags(String pszRootTagPath, int nIndex, SktSimpleXml.CSktXmlTag pTagsToInsert) {
        return SktDebug.DBGSKT_EVAL(this.m_Parser.InsertTags(pszRootTagPath, nIndex, pTagsToInsert), "m_Parser.InsertTags(pszRootTagPath,nIndex,pTagsToInsert)");
    }

    public void setNotFoundError(boolean bNotFoundError) {
        this.m_bNotFoundError = bNotFoundError;
    }

    /* access modifiers changed from: protected */
    public long save(String[] strContent) {
        long result = 0;
        long[] ulSizeRead = new long[1];
        char[] pszBuffer = null;
        long ulBufferSize = this.m_Parser.GetLength();
        if (ulBufferSize == 0) {
            result = -6;
        }
        if (SktScanErrors.SKTSUCCESS(result) && (pszBuffer = new char[((int) ulBufferSize)]) == null) {
            result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(this.m_Parser.Read(pszBuffer, ulBufferSize, ulSizeRead), "m_Parser.Read(pszBuffer,ulBufferSize,ulSizeRead)");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            strContent[0] = String.valueOf(pszBuffer);
        }
        return result;
    }

    static boolean Test() {
        boolean bResult = true;
        SktConfigXml Config = new SktConfigXml();
        SktSimpleXml.CSktXmlTag[] Root = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] Section = new SktSimpleXml.CSktXmlTag[1];
        String[] pszPathFileName = new String[1];
        if (pszPathFileName == null) {
            bResult = false;
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(SktPlatform.SktSystem.ReadTempPath(pszPathFileName, 2048), "SktPlatform.SktSystem.ReadTempPath(pszPathFileName,nLength)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.Load(pszPathFileName[0], "TestConfig.xml", "<XmlTest> </XmlTest>"), "Config.Load(pszPathFileName[0],\"TestConfig.xml\",\"<XmlTest> </XmlTest>\")", 5);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.Seek((SktSimpleXml.CSktXmlTag) null, "XmlTest/Section", false, Section), "Config.Seek(null,\"XmlTest/Section\",false,Section)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.Seek((SktSimpleXml.CSktXmlTag) null, "XmlTest/Section", true, Section), "Config.Seek(null,\"XmlTest/Section\",true,Section)", -17);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.Seek((SktSimpleXml.CSktXmlTag) null, "XmlTest", true, Root), "Config.Seek(null,\"XmlTest\",true,Root)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.AddSection(Root[0], "Section", "1", Section), "Config.AddSection(Root[0],\"Section\",\"1\",Section)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.AddSection(Root[0], "Section", "2", Section), "Config.AddSection(Root[0],\"Section\",\"2\",Section)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Config.Seek((SktSimpleXml.CSktXmlTag) null, "XmlTest/Section", true, Section), "Config.Seek(null,\"XmlTest/Section\",true,Section)", 0);
        }
        SktScanTypes.TSktScanBoolean CResult = new SktScanTypes.TSktScanBoolean(false);
        if (bResult) {
            boolean bResult2 = SktDebug.DBGSKT_EXPECTING(Config.Search(Root[0], "Section", "1", CResult, Section), "Config.Search(Root[0],\"Section\",\"1\",CResult,Section)", 0);
        }
        boolean bResult3 = CResult.getValue();
        if (bResult3) {
            bResult3 = SktDebug.DBGSKT_EXPECTING(Config.AddValue(Section[0], "FirstValue", "1"), "Config.AddValue(Section[0],\"FirstValue\",\"1\")", 0);
        }
        if (bResult3) {
            bResult3 = SktDebug.DBGSKT_EXPECTING(Config.AddValue(Section[0], "SecondValue", "2"), "Config.AddValue(Section[0],\"SecondValue\",\"2\")", 0);
        }
        if (bResult3) {
            bResult3 = SktDebug.DBGSKT_EXPECTING(Config.WriteSubValue(Section[0], "FirstValue", "3", 1), "Config.WriteSubValue(Section[0],\"FirstValue\",\"3\", 1)", 0);
        }
        if (bResult3) {
            bResult3 = SktDebug.DBGSKT_EXPECTING(Config.Save(pszPathFileName[0], "TestConfig.xml"), "Config.Save(pszPathFileName[0],\"TestConfig.xml\")", 0);
        }
        if (bResult3) {
            bResult3 = SktDebug.DBGSKT_EXPECTING(Config.RemoveValue(Section[0], "SecondValue"), "Config.RemoveValue(Section[0],\"SecondValue\")", 0);
        }
        if (bResult3) {
            boolean bResult4 = SktDebug.DBGSKT_EXPECTING(Config.Search(Root[0], "Section", "2", CResult, Section), "Config.Search(Root[0],\"Section\",\"2\",CResult,Section)", 0);
        }
        boolean bResult5 = CResult.getValue();
        if (bResult5) {
            bResult5 = SktDebug.DBGSKT_EXPECTING(Config.AddValue(Section[0], "FirstValue", "1"), "Config.AddValue(Section[0],\"FirstValue\",\"1\")", 0);
        }
        if (bResult5) {
            bResult5 = SktDebug.DBGSKT_EXPECTING(Config.RemoveSection(Root[0], "Section", "2"), "Config.RemoveSection(Root[0],\"Section\",\"2\")", 0);
        }
        SktPlatform.SktFile.Delete(pszPathFileName[0], "TestConfig.xml");
        if (bResult5) {
            SktDebug.DBGSKT_MSG(1, "SktConfigXml test pass");
        }
        return bResult5;
    }
}
