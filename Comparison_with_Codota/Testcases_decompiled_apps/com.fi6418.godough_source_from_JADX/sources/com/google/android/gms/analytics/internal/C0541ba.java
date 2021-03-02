package com.google.android.gms.analytics.internal;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0539az;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.internal.ba */
abstract class C0541ba<T extends C0539az> extends C0578z {

    /* renamed from: a */
    C0542bb<T> f3784a;

    public C0541ba(C0516ac acVar, C0542bb<T> bbVar) {
        super(acVar);
        this.f3784a = bbVar;
    }

    /* renamed from: a */
    private T m3140a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase();
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.f3784a.mo6721a(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.f3784a.mo6723b(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.f3784a.mo6722a(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                mo6875c("Error parsing bool configuration value", trim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.f3784a.mo6720a(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                mo6875c("Error parsing int configuration value", trim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            mo6880e("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            mo6880e("Error parsing tracker configuration file", e4);
        }
        return this.f3784a.mo6719a();
    }

    /* renamed from: a */
    public T mo6718a(int i) {
        try {
            return m3140a(mo6882k().mo6601c().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            mo6877d("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
