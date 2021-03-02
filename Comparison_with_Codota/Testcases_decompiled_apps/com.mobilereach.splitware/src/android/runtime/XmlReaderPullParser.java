package android.runtime;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;
import org.xmlpull.v1.XmlPullParser;

public class XmlReaderPullParser implements IGCUserPeer, XmlPullParser {
    public static final String __md_methods = "n_getAttributeCount:()I:GetGetAttributeCountHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getColumnNumber:()I:GetGetColumnNumberHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getDepth:()I:GetGetDepthHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getEventType:()I:GetGetEventTypeHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getInputEncoding:()Ljava/lang/String;:GetGetInputEncodingHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_isEmptyElementTag:()Z:GetIsEmptyElementTagHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_isWhitespace:()Z:GetIsWhitespaceHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getLineNumber:()I:GetGetLineNumberHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getName:()Ljava/lang/String;:GetGetNameHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getNamespace:()Ljava/lang/String;:GetGetNamespaceHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getPositionDescription:()Ljava/lang/String;:GetGetPositionDescriptionHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getPrefix:()Ljava/lang/String;:GetGetPrefixHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getText:()Ljava/lang/String;:GetGetTextHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_defineEntityReplacementText:(Ljava/lang/String;Ljava/lang/String;)V:GetDefineEntityReplacementText_Ljava_lang_String_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getAttributeName:(I)Ljava/lang/String;:GetGetAttributeName_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getAttributeNamespace:(I)Ljava/lang/String;:GetGetAttributeNamespace_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getAttributePrefix:(I)Ljava/lang/String;:GetGetAttributePrefix_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getAttributeType:(I)Ljava/lang/String;:GetGetAttributeType_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getAttributeValue:(I)Ljava/lang/String;:GetGetAttributeValue_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:GetGetAttributeValue_Ljava_lang_String_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getFeature:(Ljava/lang/String;)Z:GetGetFeature_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getNamespace:(Ljava/lang/String;)Ljava/lang/String;:GetGetNamespace_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getNamespaceCount:(I)I:GetGetNamespaceCount_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getNamespacePrefix:(I)Ljava/lang/String;:GetGetNamespacePrefix_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getNamespaceUri:(I)Ljava/lang/String;:GetGetNamespaceUri_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getProperty:(Ljava/lang/String;)Ljava/lang/Object;:GetGetProperty_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_getTextCharacters:([I)[C:GetGetTextCharacters_arrayIHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_isAttributeDefault:(I)Z:GetIsAttributeDefault_IHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_next:()I:GetNextHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_nextTag:()I:GetNextTagHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_nextText:()Ljava/lang/String;:GetNextTextHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_nextToken:()I:GetNextTokenHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_require:(ILjava/lang/String;Ljava/lang/String;)V:GetRequire_ILjava_lang_String_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_setFeature:(Ljava/lang/String;Z)V:GetSetFeature_Ljava_lang_String_ZHandler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_setInput:(Ljava/io/InputStream;Ljava/lang/String;)V:GetSetInput_Ljava_io_InputStream_Ljava_lang_String_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_setInput:(Ljava/io/Reader;)V:GetSetInput_Ljava_io_Reader_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_setProperty:(Ljava/lang/String;Ljava/lang/Object;)V:GetSetProperty_Ljava_lang_String_Ljava_lang_Object_Handler:Org.XmlPull.V1.IXmlPullParserInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_defineEntityReplacementText(String str, String str2);

    private native int n_getAttributeCount();

    private native String n_getAttributeName(int i);

    private native String n_getAttributeNamespace(int i);

    private native String n_getAttributePrefix(int i);

    private native String n_getAttributeType(int i);

    private native String n_getAttributeValue(int i);

    private native String n_getAttributeValue(String str, String str2);

    private native int n_getColumnNumber();

    private native int n_getDepth();

    private native int n_getEventType();

    private native boolean n_getFeature(String str);

    private native String n_getInputEncoding();

    private native int n_getLineNumber();

    private native String n_getName();

    private native String n_getNamespace();

    private native String n_getNamespace(String str);

    private native int n_getNamespaceCount(int i);

    private native String n_getNamespacePrefix(int i);

    private native String n_getNamespaceUri(int i);

    private native String n_getPositionDescription();

    private native String n_getPrefix();

    private native Object n_getProperty(String str);

    private native String n_getText();

    private native char[] n_getTextCharacters(int[] iArr);

    private native boolean n_isAttributeDefault(int i);

    private native boolean n_isEmptyElementTag();

    private native boolean n_isWhitespace();

    private native int n_next();

    private native int n_nextTag();

    private native String n_nextText();

    private native int n_nextToken();

    private native void n_require(int i, String str, String str2);

    private native void n_setFeature(String str, boolean z);

    private native void n_setInput(InputStream inputStream, String str);

    private native void n_setInput(Reader reader);

    private native void n_setProperty(String str, Object obj);

    static {
        Runtime.register("Android.Runtime.XmlReaderPullParser, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", XmlReaderPullParser.class, __md_methods);
    }

    public XmlReaderPullParser() throws Throwable {
        if (getClass() == XmlReaderPullParser.class) {
            TypeManager.Activate("Android.Runtime.XmlReaderPullParser, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public int getAttributeCount() {
        return n_getAttributeCount();
    }

    public int getColumnNumber() {
        return n_getColumnNumber();
    }

    public int getDepth() {
        return n_getDepth();
    }

    public int getEventType() {
        return n_getEventType();
    }

    public String getInputEncoding() {
        return n_getInputEncoding();
    }

    public boolean isEmptyElementTag() {
        return n_isEmptyElementTag();
    }

    public boolean isWhitespace() {
        return n_isWhitespace();
    }

    public int getLineNumber() {
        return n_getLineNumber();
    }

    public String getName() {
        return n_getName();
    }

    public String getNamespace() {
        return n_getNamespace();
    }

    public String getPositionDescription() {
        return n_getPositionDescription();
    }

    public String getPrefix() {
        return n_getPrefix();
    }

    public String getText() {
        return n_getText();
    }

    public void defineEntityReplacementText(String str, String str2) {
        n_defineEntityReplacementText(str, str2);
    }

    public String getAttributeName(int i) {
        return n_getAttributeName(i);
    }

    public String getAttributeNamespace(int i) {
        return n_getAttributeNamespace(i);
    }

    public String getAttributePrefix(int i) {
        return n_getAttributePrefix(i);
    }

    public String getAttributeType(int i) {
        return n_getAttributeType(i);
    }

    public String getAttributeValue(int i) {
        return n_getAttributeValue(i);
    }

    public String getAttributeValue(String str, String str2) {
        return n_getAttributeValue(str, str2);
    }

    public boolean getFeature(String str) {
        return n_getFeature(str);
    }

    public String getNamespace(String str) {
        return n_getNamespace(str);
    }

    public int getNamespaceCount(int i) {
        return n_getNamespaceCount(i);
    }

    public String getNamespacePrefix(int i) {
        return n_getNamespacePrefix(i);
    }

    public String getNamespaceUri(int i) {
        return n_getNamespaceUri(i);
    }

    public Object getProperty(String str) {
        return n_getProperty(str);
    }

    public char[] getTextCharacters(int[] iArr) {
        return n_getTextCharacters(iArr);
    }

    public boolean isAttributeDefault(int i) {
        return n_isAttributeDefault(i);
    }

    public int next() {
        return n_next();
    }

    public int nextTag() {
        return n_nextTag();
    }

    public String nextText() {
        return n_nextText();
    }

    public int nextToken() {
        return n_nextToken();
    }

    public void require(int i, String str, String str2) {
        n_require(i, str, str2);
    }

    public void setFeature(String str, boolean z) {
        n_setFeature(str, z);
    }

    public void setInput(InputStream inputStream, String str) {
        n_setInput(inputStream, str);
    }

    public void setInput(Reader reader) {
        n_setInput(reader);
    }

    public void setProperty(String str, Object obj) {
        n_setProperty(str, obj);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
