package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.internal.C1326ik;
import com.google.android.gms.internal.C1390jz;
import com.google.android.gms.internal.C1394kc;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;

    /* renamed from: Fl */
    private JSONObject f529Fl;

    /* renamed from: Gd */
    private float f530Gd;

    /* renamed from: Ge */
    private int f531Ge;

    /* renamed from: Gf */
    private int f532Gf;

    /* renamed from: Gg */
    private int f533Gg;

    /* renamed from: Gh */
    private int f534Gh;

    /* renamed from: Gi */
    private int f535Gi;

    /* renamed from: Gj */
    private int f536Gj;

    /* renamed from: Gk */
    private String f537Gk;

    /* renamed from: Gl */
    private int f538Gl;

    /* renamed from: Gm */
    private int f539Gm;

    /* renamed from: xm */
    private int f540xm;

    public TextTrackStyle() {
        clear();
    }

    /* renamed from: aC */
    private int m444aC(String str) {
        if (str == null || str.length() != 9 || str.charAt(0) != '#') {
            return 0;
        }
        try {
            return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void clear() {
        this.f530Gd = 1.0f;
        this.f531Ge = 0;
        this.f540xm = 0;
        this.f532Gf = -1;
        this.f533Gg = 0;
        this.f534Gh = -1;
        this.f535Gi = 0;
        this.f536Gj = 0;
        this.f537Gk = null;
        this.f538Gl = -1;
        this.f539Gm = -1;
        this.f529Fl = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!C1394kc.m5244hH()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    /* renamed from: t */
    private String m445t(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    /* renamed from: bL */
    public JSONObject mo4110bL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.f530Gd);
            if (this.f531Ge != 0) {
                jSONObject.put("foregroundColor", m445t(this.f531Ge));
            }
            if (this.f540xm != 0) {
                jSONObject.put("backgroundColor", m445t(this.f540xm));
            }
            switch (this.f532Gf) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.f533Gg != 0) {
                jSONObject.put("edgeColor", m445t(this.f533Gg));
            }
            switch (this.f534Gh) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.f535Gi != 0) {
                jSONObject.put("windowColor", m445t(this.f535Gi));
            }
            if (this.f534Gh == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.f536Gj);
            }
            if (this.f537Gk != null) {
                jSONObject.put("fontFamily", this.f537Gk);
            }
            switch (this.f538Gl) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.f539Gm) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.f529Fl != null) {
                jSONObject.put("customData", this.f529Fl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo4111c(JSONObject jSONObject) throws JSONException {
        clear();
        this.f530Gd = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.f531Ge = m444aC(jSONObject.optString("foregroundColor"));
        this.f540xm = m444aC(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.f532Gf = 0;
            } else if ("OUTLINE".equals(string)) {
                this.f532Gf = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.f532Gf = 2;
            } else if ("RAISED".equals(string)) {
                this.f532Gf = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.f532Gf = 4;
            }
        }
        this.f533Gg = m444aC(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.f534Gh = 0;
            } else if ("NORMAL".equals(string2)) {
                this.f534Gh = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.f534Gh = 2;
            }
        }
        this.f535Gi = m444aC(jSONObject.optString("windowColor"));
        if (this.f534Gh == 2) {
            this.f536Gj = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.f537Gk = jSONObject.optString("fontFamily", (String) null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.f538Gl = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.f538Gl = 1;
            } else if ("SERIF".equals(string3)) {
                this.f538Gl = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.f538Gl = 3;
            } else if ("CASUAL".equals(string3)) {
                this.f538Gl = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.f538Gl = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.f538Gl = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.f539Gm = 0;
            } else if ("BOLD".equals(string4)) {
                this.f539Gm = 1;
            } else if ("ITALIC".equals(string4)) {
                this.f539Gm = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.f539Gm = 3;
            }
        }
        this.f529Fl = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.f529Fl == null) != (textTrackStyle.f529Fl == null)) {
            return false;
        }
        if (this.f529Fl != null && textTrackStyle.f529Fl != null && !C1390jz.m5226d(this.f529Fl, textTrackStyle.f529Fl)) {
            return false;
        }
        if (!(this.f530Gd == textTrackStyle.f530Gd && this.f531Ge == textTrackStyle.f531Ge && this.f540xm == textTrackStyle.f540xm && this.f532Gf == textTrackStyle.f532Gf && this.f533Gg == textTrackStyle.f533Gg && this.f534Gh == textTrackStyle.f534Gh && this.f536Gj == textTrackStyle.f536Gj && C1326ik.m4984a(this.f537Gk, textTrackStyle.f537Gk) && this.f538Gl == textTrackStyle.f538Gl && this.f539Gm == textTrackStyle.f539Gm)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.f540xm;
    }

    public JSONObject getCustomData() {
        return this.f529Fl;
    }

    public int getEdgeColor() {
        return this.f533Gg;
    }

    public int getEdgeType() {
        return this.f532Gf;
    }

    public String getFontFamily() {
        return this.f537Gk;
    }

    public int getFontGenericFamily() {
        return this.f538Gl;
    }

    public float getFontScale() {
        return this.f530Gd;
    }

    public int getFontStyle() {
        return this.f539Gm;
    }

    public int getForegroundColor() {
        return this.f531Ge;
    }

    public int getWindowColor() {
        return this.f535Gi;
    }

    public int getWindowCornerRadius() {
        return this.f536Gj;
    }

    public int getWindowType() {
        return this.f534Gh;
    }

    public int hashCode() {
        return C0345m.hashCode(Float.valueOf(this.f530Gd), Integer.valueOf(this.f531Ge), Integer.valueOf(this.f540xm), Integer.valueOf(this.f532Gf), Integer.valueOf(this.f533Gg), Integer.valueOf(this.f534Gh), Integer.valueOf(this.f535Gi), Integer.valueOf(this.f536Gj), this.f537Gk, Integer.valueOf(this.f538Gl), Integer.valueOf(this.f539Gm), this.f529Fl);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.f540xm = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.f529Fl = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.f533Gg = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.f532Gf = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.f537Gk = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.f538Gl = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.f530Gd = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.f539Gm = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.f531Ge = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.f535Gi = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.f536Gj = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.f534Gh = windowType;
    }
}
