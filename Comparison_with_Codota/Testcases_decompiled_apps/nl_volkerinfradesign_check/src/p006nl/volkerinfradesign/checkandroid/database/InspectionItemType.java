package p006nl.volkerinfradesign.checkandroid.database;

import android.support.p001v4.view.InputDeviceCompat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import p006nl.volkerinfradesign.checkandroid.AppState;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemType */
public enum InspectionItemType {
    BOOLEAN {
        public int getInputType() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public Boolean getValue(String str) {
            if (str == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            return str != null && (str.equals(Boolean.TRUE.toString()) || str.equals(Boolean.FALSE.toString()));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).toString();
            }
            String str = (String) obj;
            if (StringUtils.isNotBlank(str)) {
                return Boolean.valueOf(str).toString();
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            if (StringUtils.isNotBlank(str)) {
                return Boolean.valueOf(str).toString();
            }
            return null;
        }
    },
    DATE {

        /* renamed from: a */
        private final SimpleDateFormat f4790a;

        public int getInputType() {
            return InspectionItemType.f4786a.m5905a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            return InspectionItemType.f4786a.m5908a(obj, this.f4790a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return InspectionItemType.f4786a.mo9189a(str, this.f4790a);
        }

        public Object getValue(String str) {
            return InspectionItemType.f4786a.m5912b(str, this.f4790a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9177b(String str) {
            return InspectionItemType.f4786a.m5910a(str);
        }
    },
    DATETIME {

        /* renamed from: a */
        private final SimpleDateFormat f4791a;

        public int getInputType() {
            return InspectionItemType.f4786a.m5905a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            return InspectionItemType.f4786a.m5908a(obj, this.f4791a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return InspectionItemType.f4786a.mo9189a(str, this.f4791a);
        }

        public Object getValue(String str) {
            return InspectionItemType.f4786a.m5912b(str, this.f4791a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9177b(String str) {
            return InspectionItemType.f4786a.m5910a(str);
        }
    },
    FLOAT {
        public int getInputType() {
            return 12290;
        }

        /* renamed from: c */
        public Float getValue(String str) {
            if (str == null) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            return str != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            if (StringUtils.isNotBlank((String) obj)) {
                try {
                    return Float.valueOf((String) obj).toString();
                } catch (NumberFormatException e) {
                    AppState.getInstance().getModel().getLogger().logError("Error in parsing Float.", e);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            if (StringUtils.isNotBlank(str)) {
                return Float.valueOf(str).toString();
            }
            return null;
        }
    },
    HEADER {
        public int getInputType() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String getValue(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            throw new UnsupportedOperationException();
        }
    },
    INTEGER {
        public int getInputType() {
            return InputDeviceCompat.SOURCE_TOUCHSCREEN;
        }

        /* renamed from: c */
        public Integer getValue(String str) {
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            return str != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            if (StringUtils.isNotBlank((String) obj)) {
                try {
                    return Integer.valueOf((String) obj).toString();
                } catch (NumberFormatException e) {
                    AppState.getInstance().getModel().getLogger().logError("Error in parsing Integer.", e);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            if (StringUtils.isNotBlank(str)) {
                return Integer.valueOf(str).toString();
            }
            return null;
        }
    },
    MULTICHOICE {
        public int getInputType() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String[] getValue(String str) {
            if (str == null) {
                return null;
            }
            if (str.length() <= 2) {
                return new String[0];
            }
            try {
                if (!str.startsWith("[\"") || !str.endsWith("\"]")) {
                    str = str.replace("[", "[\"").replace("]", "\"]").replace(", ", "!@#$%").replace(",", "\",\"").replace("!@#$%", ", ");
                }
                JSONArray jSONArray = new JSONArray(str);
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = jSONArray.getString(i);
                }
                return strArr;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            return StringUtils.isNotBlank(str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            if (((String[]) obj).length <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder("[");
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                sb.append("\"" + strArr[i] + "\"");
                sb.append(',');
            }
            return sb.substring(0, sb.length() - 1) + "]";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return str;
        }
    },
    PROJECTS {
        public int getInputType() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String getValue(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            throw new UnsupportedOperationException();
        }
    },
    SINGLECHOICE {
        public int getInputType() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String getValue(String str) {
            return str;
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            return StringUtils.isNotBlank(str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            String str = (String) obj;
            if (StringUtils.isNotBlank(str)) {
                return str;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return str;
        }
    },
    STRING {
        public int getInputType() {
            return 131073;
        }

        /* renamed from: c */
        public String getValue(String str) {
            return str;
        }

        /* renamed from: b */
        public boolean mo9177b(String str) {
            return StringUtils.isNotBlank(str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            String str = (String) obj;
            if (StringUtils.isNotBlank(str)) {
                return str.replaceAll("'", "'");
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return str;
        }
    },
    TIME {

        /* renamed from: a */
        private final SimpleDateFormat f4788a;

        public int getInputType() {
            return InspectionItemType.f4786a.m5905a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            return InspectionItemType.f4786a.m5908a(obj, this.f4788a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return InspectionItemType.f4786a.mo9189a(str, this.f4788a);
        }

        public Object getValue(String str) {
            return InspectionItemType.f4786a.m5912b(str, this.f4788a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9177b(String str) {
            return InspectionItemType.f4786a.m5910a(str);
        }
    },
    BLANC {
        public int getInputType() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return null;
        }

        public Object getValue(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9177b(String str) {
            return false;
        }
    },
    SIGNATURE {
        public int getInputType() {
            return STRING.getInputType();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9175a(Object obj) {
            return STRING.mo9175a(obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo9176a(String str) {
            return STRING.mo9176a(str);
        }

        public Object getValue(String str) {
            return STRING.mo9176a(str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9177b(String str) {
            return STRING.mo9177b(str);
        }
    };
    
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C1447a f4786a = null;

    /* renamed from: a */
    public abstract String mo9175a(Object obj);

    /* renamed from: a */
    public abstract String mo9176a(String str);

    /* renamed from: b */
    public abstract boolean mo9177b(String str);

    public abstract int getInputType();

    public abstract Object getValue(String str);

    static {
        f4786a = new C1447a();
    }

    public boolean hasChoices() {
        switch (this) {
            case SINGLECHOICE:
            case MULTICHOICE:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemType$a */
    static final class C1447a {
        private C1447a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m5908a(Object obj, SimpleDateFormat simpleDateFormat) {
            Long l;
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                try {
                    l = Long.valueOf(simpleDateFormat.parse((String) obj).getTime());
                } catch (ParseException e) {
                    AppState.getInstance().getModel().getLogger().logError("Not been able to parse the value: " + obj.toString(), e);
                    l = obj;
                }
            } else if (obj instanceof Calendar) {
                return Long.valueOf(((Calendar) obj).getTimeInMillis()).toString();
            } else {
                l = obj;
            }
            return Long.valueOf((String) l).toString();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int m5905a() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public Long m5912b(String str, SimpleDateFormat simpleDateFormat) {
            if (str == null) {
                return null;
            }
            if (StringUtils.isNumeric(str)) {
                return Long.valueOf(str);
            }
            try {
                return Long.valueOf(simpleDateFormat.parse(str).getTime());
            } catch (ParseException e) {
                AppState.getInstance().getModel().getLogger().logError("Not been able to parse the value: " + str, e);
                return null;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m5910a(String str) {
            return str != null;
        }

        /* renamed from: a */
        public String mo9189a(String str, SimpleDateFormat simpleDateFormat) {
            Long b;
            if (!StringUtils.isBlank(str) && (b = m5912b(str, simpleDateFormat)) != null) {
                return simpleDateFormat.format(new Date(b.longValue()));
            }
            return null;
        }
    }
}
