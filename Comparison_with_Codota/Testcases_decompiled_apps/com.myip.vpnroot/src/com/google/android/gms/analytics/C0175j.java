package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0174i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.j */
abstract class C0175j<T extends C0174i> {
    Context mContext;

    /* renamed from: xV */
    C0176a<T> f184xV;

    /* renamed from: com.google.android.gms.analytics.j$a */
    public interface C0176a<U extends C0174i> {
        /* renamed from: c */
        void mo3632c(String str, int i);

        /* renamed from: d */
        void mo3633d(String str, boolean z);

        /* renamed from: dX */
        U mo3634dX();

        /* renamed from: f */
        void mo3636f(String str, String str2);

        /* renamed from: g */
        void mo3637g(String str, String str2);
    }

    public C0175j(Context context, C0176a<T> aVar) {
        this.mContext = context;
        this.f184xV = aVar;
    }

    /* renamed from: a */
    private T m190a(XmlResourceParser xmlResourceParser) {
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
                            this.f184xV.mo3636f(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.f184xV.mo3637g(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.f184xV.mo3633d(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                C0207z.m306T("Error parsing bool configuration value: " + trim3);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.f184xV.mo3632c(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                C0207z.m306T("Error parsing int configuration value: " + trim4);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            C0207z.m306T("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            C0207z.m306T("Error parsing tracker configuration file: " + e4);
        }
        return this.f184xV.mo3634dX();
    }

    /* renamed from: w */
    public T mo3706w(int i) {
        try {
            return m190a(this.mContext.getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            C0207z.m309W("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
