package com.google.ads.searchads;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.AdRequest;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import java.util.Locale;
import java.util.Map;

public class SearchAdRequest extends AdRequest {

    /* renamed from: a */
    private String f675a;

    /* renamed from: b */
    private int f676b;

    /* renamed from: c */
    private int f677c;

    /* renamed from: d */
    private int f678d;

    /* renamed from: e */
    private int f679e;

    /* renamed from: f */
    private int f680f;

    /* renamed from: g */
    private int f681g;

    /* renamed from: h */
    private String f682h;

    /* renamed from: i */
    private int f683i;

    /* renamed from: j */
    private int f684j;

    /* renamed from: k */
    private BorderType f685k;

    /* renamed from: l */
    private int f686l;

    /* renamed from: m */
    private String f687m;

    public enum BorderType {
        NONE("none"),
        DASHED("dashed"),
        DOTTED("dotted"),
        SOLID("solid");
        

        /* renamed from: a */
        private String f689a;

        private BorderType(String param) {
            this.f689a = param;
        }

        public String toString() {
            return this.f689a;
        }
    }

    public void setQuery(String query) {
        this.f675a = query;
    }

    public void setBackgroundColor(int backgroundColor) {
        if (Color.alpha(backgroundColor) == 255) {
            this.f676b = backgroundColor;
            this.f677c = 0;
            this.f678d = 0;
        }
    }

    public void setBackgroundGradient(int from, int to) {
        if (Color.alpha(from) == 255 && Color.alpha(to) == 255) {
            this.f676b = Color.argb(0, 0, 0, 0);
            this.f677c = from;
            this.f678d = to;
        }
    }

    public void setHeaderTextColor(int headerTextColor) {
        this.f679e = headerTextColor;
    }

    public void setDescriptionTextColor(int descriptionTextColor) {
        this.f680f = descriptionTextColor;
    }

    public void setAnchorTextColor(int anchorTextColor) {
        this.f681g = anchorTextColor;
    }

    public void setFontFace(String fontFace) {
        this.f682h = fontFace;
    }

    public void setHeaderTextSize(int headerTextSize) {
        this.f683i = headerTextSize;
    }

    public void setBorderColor(int borderColor) {
        this.f684j = borderColor;
    }

    public void setBorderType(BorderType borderType) {
        this.f685k = borderType;
    }

    public void setBorderThickness(int borderThickness) {
        this.f686l = borderThickness;
    }

    public void setCustomChannels(String channelIds) {
        this.f687m = channelIds;
    }

    public Map<String, Object> getRequestMap(Context context) {
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        if (adMobAdapterExtras == null) {
            adMobAdapterExtras = new AdMobAdapterExtras();
            setNetworkExtras(adMobAdapterExtras);
        }
        if (this.f675a != null) {
            adMobAdapterExtras.getExtras().put("q", this.f675a);
        }
        if (Color.alpha(this.f676b) != 0) {
            adMobAdapterExtras.getExtras().put("bgcolor", m433a(this.f676b));
        }
        if (Color.alpha(this.f677c) == 255 && Color.alpha(this.f678d) == 255) {
            adMobAdapterExtras.getExtras().put("gradientfrom", m433a(this.f677c));
            adMobAdapterExtras.getExtras().put("gradientto", m433a(this.f678d));
        }
        if (Color.alpha(this.f679e) != 0) {
            adMobAdapterExtras.getExtras().put("hcolor", m433a(this.f679e));
        }
        if (Color.alpha(this.f680f) != 0) {
            adMobAdapterExtras.getExtras().put("dcolor", m433a(this.f680f));
        }
        if (Color.alpha(this.f681g) != 0) {
            adMobAdapterExtras.getExtras().put("acolor", m433a(this.f681g));
        }
        if (this.f682h != null) {
            adMobAdapterExtras.getExtras().put("font", this.f682h);
        }
        adMobAdapterExtras.getExtras().put("headersize", Integer.toString(this.f683i));
        if (Color.alpha(this.f684j) != 0) {
            adMobAdapterExtras.getExtras().put("bcolor", m433a(this.f684j));
        }
        if (this.f685k != null) {
            adMobAdapterExtras.getExtras().put("btype", this.f685k.toString());
        }
        adMobAdapterExtras.getExtras().put("bthick", Integer.toString(this.f686l));
        if (this.f687m != null) {
            adMobAdapterExtras.getExtras().put("channel", this.f687m);
        }
        return super.getRequestMap(context);
    }

    /* renamed from: a */
    private String m433a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
