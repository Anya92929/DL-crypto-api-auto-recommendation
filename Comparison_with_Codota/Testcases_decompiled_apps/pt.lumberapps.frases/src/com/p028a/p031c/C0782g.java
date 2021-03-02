package com.p028a.p031c;

import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.a.c.g */
public class C0782g {

    /* renamed from: a */
    private Element f2043a;

    public C0782g(InputStream inputStream) {
        try {
            this.f2043a = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (ParserConfigurationException e) {
        } catch (IOException e2) {
            throw new SAXException(e2);
        }
    }

    /* renamed from: a */
    private String m3564a(Element element, int i) {
        String str;
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("utf-8", (Boolean) null);
            if (i > 0) {
                char[] cArr = new char[i];
                Arrays.fill(cArr, ' ');
                str = new String(cArr);
            } else {
                str = null;
            }
            m3566a(this.f2043a, newSerializer, 0, str);
            newSerializer.endDocument();
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m3565a(Node node) {
        String str = null;
        switch (node.getNodeType()) {
            case 3:
                str = node.getNodeValue();
                if (str != null) {
                    str = str.trim();
                    break;
                }
                break;
            case 4:
                str = node.getNodeValue();
                break;
        }
        return str == null ? "" : str;
    }

    /* renamed from: a */
    private void m3566a(Element element, XmlSerializer xmlSerializer, int i, String str) {
        int i2 = 0;
        String tagName = element.getTagName();
        m3567a(xmlSerializer, i, str);
        xmlSerializer.startTag("", tagName);
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                Attr attr = (Attr) attributes.item(i3);
                xmlSerializer.attribute("", attr.getName(), attr.getValue());
            }
        }
        if (element.hasChildNodes()) {
            NodeList childNodes = element.getChildNodes();
            int i4 = 0;
            while (i2 < childNodes.getLength()) {
                Node item = childNodes.item(i2);
                switch (item.getNodeType()) {
                    case 1:
                        m3566a((Element) item, xmlSerializer, i + 1, str);
                        i4++;
                        break;
                    case 3:
                        xmlSerializer.text(m3565a(item));
                        break;
                    case 4:
                        xmlSerializer.cdsect(m3565a(item));
                        break;
                }
                i2++;
                i4 = i4;
            }
            if (i4 > 0) {
                m3567a(xmlSerializer, i, str);
            }
        }
        xmlSerializer.endTag("", tagName);
    }

    /* renamed from: a */
    private void m3567a(XmlSerializer xmlSerializer, int i, String str) {
        if (str != null) {
            xmlSerializer.text("\n");
            for (int i2 = 0; i2 < i; i2++) {
                xmlSerializer.text(str);
            }
        }
    }

    /* renamed from: a */
    public String mo3581a(int i) {
        return m3564a(this.f2043a, i);
    }

    public String toString() {
        return mo3581a(0);
    }
}
