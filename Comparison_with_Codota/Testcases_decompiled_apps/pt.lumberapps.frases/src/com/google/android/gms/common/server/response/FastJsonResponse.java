package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public class Field extends AbstractSafeParcelable {
        public static final zza CREATOR = new zza();

        /* renamed from: a */
        protected final int f4636a;

        /* renamed from: b */
        protected final boolean f4637b;

        /* renamed from: c */
        protected final int f4638c;

        /* renamed from: d */
        protected final boolean f4639d;

        /* renamed from: e */
        protected final String f4640e;

        /* renamed from: f */
        protected final int f4641f;

        /* renamed from: g */
        protected final Class f4642g;

        /* renamed from: h */
        protected final String f4643h;

        /* renamed from: i */
        private final int f4644i;

        /* renamed from: j */
        private FieldMappingDictionary f4645j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public zza f4646k;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.f4644i = i;
            this.f4636a = i2;
            this.f4637b = z;
            this.f4638c = i3;
            this.f4639d = z2;
            this.f4640e = str;
            this.f4641f = i4;
            if (str2 == null) {
                this.f4642g = null;
                this.f4643h = null;
            } else {
                this.f4642g = SafeParcelResponse.class;
                this.f4643h = str2;
            }
            if (converterWrapper == null) {
                this.f4646k = null;
            } else {
                this.f4646k = converterWrapper.zzatr();
            }
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, zza zza) {
            this.f4644i = 1;
            this.f4636a = i;
            this.f4637b = z;
            this.f4638c = i2;
            this.f4639d = z2;
            this.f4640e = str;
            this.f4641f = i3;
            this.f4642g = cls;
            if (cls == null) {
                this.f4643h = null;
            } else {
                this.f4643h = cls.getCanonicalName();
            }
            this.f4646k = zza;
        }

        public static Field zza(String str, int i, zza zza, boolean z) {
            return new Field(zza.zzatt(), z, zza.zzatu(), false, str, i, (Class) null, zza);
        }

        public static Field zza(String str, int i, Class cls) {
            return new Field(11, false, 11, false, str, i, cls, (zza) null);
        }

        public static Field zzb(String str, int i, Class cls) {
            return new Field(11, true, 11, true, str, i, cls, (zza) null);
        }

        public static Field zzj(String str, int i) {
            return new Field(0, false, 0, false, str, i, (Class) null, (zza) null);
        }

        public static Field zzk(String str, int i) {
            return new Field(6, false, 6, false, str, i, (Class) null, (zza) null);
        }

        public static Field zzl(String str, int i) {
            return new Field(7, false, 7, false, str, i, (Class) null, (zza) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo6811a() {
            if (this.f4643h == null) {
                return null;
            }
            return this.f4643h;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public ConverterWrapper mo6812b() {
            if (this.f4646k == null) {
                return null;
            }
            return ConverterWrapper.zza(this.f4646k);
        }

        public Object convertBack(Object obj) {
            return this.f4646k.convertBack(obj);
        }

        public int getVersionCode() {
            return this.f4644i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.f4644i).append(10);
            sb.append("                 typeIn=").append(this.f4636a).append(10);
            sb.append("            typeInArray=").append(this.f4637b).append(10);
            sb.append("                typeOut=").append(this.f4638c).append(10);
            sb.append("           typeOutArray=").append(this.f4639d).append(10);
            sb.append("        outputFieldName=").append(this.f4640e).append(10);
            sb.append("      safeParcelFieldId=").append(this.f4641f).append(10);
            sb.append("       concreteTypeName=").append(mo6811a()).append(10);
            if (zzauc() != null) {
                sb.append("     concreteType.class=").append(zzauc().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.f4646k == null ? "null" : this.f4646k.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zza zza = CREATOR;
            zza.m6176a(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.f4645j = fieldMappingDictionary;
        }

        public int zzatt() {
            return this.f4636a;
        }

        public int zzatu() {
            return this.f4638c;
        }

        public boolean zzaty() {
            return this.f4637b;
        }

        public boolean zzatz() {
            return this.f4639d;
        }

        public String zzaua() {
            return this.f4640e;
        }

        public int zzaub() {
            return this.f4641f;
        }

        public Class zzauc() {
            return this.f4642g;
        }

        public boolean zzaue() {
            return this.f4646k != null;
        }

        public Map zzaug() {
            zzab.zzy(this.f4643h);
            zzab.zzy(this.f4645j);
            return this.f4645j.zzhw(this.f4643h);
        }
    }

    public interface zza {
        Object convertBack(Object obj);

        int zzatt();

        int zzatu();
    }

    /* renamed from: a */
    private void m6152a(StringBuilder sb, Field field, Object obj) {
        if (field.zzatt() == 11) {
            sb.append(((FastJsonResponse) field.zzauc().cast(obj)).toString());
        } else if (field.zzatt() == 7) {
            sb.append("\"");
            sb.append(zzp.zzia((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    /* renamed from: a */
    private void m6153a(StringBuilder sb, Field field, ArrayList arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m6152a(sb, field, obj);
            }
        }
        sb.append("]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo6800a(Field field, Object obj) {
        return field.f4646k != null ? field.convertBack(obj) : obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6801a(Field field) {
        return field.zzatu() == 11 ? field.zzatz() ? mo6804b(field.zzaua()) : mo6802a(field.zzaua()) : zzht(field.zzaua());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6802a(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo6803b(Field field) {
        String zzaua = field.zzaua();
        if (field.zzauc() == null) {
            return zzhs(field.zzaua());
        }
        zzab.zza(zzhs(field.zzaua()) == null, "Concrete field shouldn't be value object: %s", field.zzaua());
        HashMap zzatx = field.zzatz() ? zzatx() : zzatw();
        if (zzatx != null) {
            return zzatx.get(zzaua);
        }
        try {
            char upperCase = Character.toUpperCase(zzaua.charAt(0));
            String valueOf = String.valueOf(zzaua.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(valueOf).length() + 4).append("get").append(upperCase).append(valueOf).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo6804b(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        Map zzatv = zzatv();
        StringBuilder sb = new StringBuilder(100);
        for (String str : zzatv.keySet()) {
            Field field = (Field) zzatv.get(str);
            if (mo6801a(field)) {
                Object a = mo6800a(field, mo6803b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (field.zzatu()) {
                        case 8:
                            sb.append("\"").append(zzc.zzp((byte[]) a)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzc.zzq((byte[]) a)).append("\"");
                            break;
                        case 10:
                            zzq.zza(sb, (HashMap) a);
                            break;
                        default:
                            if (!field.zzaty()) {
                                m6152a(sb, field, a);
                                break;
                            } else {
                                m6153a(sb, field, (ArrayList) a);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public abstract Map zzatv();

    public HashMap zzatw() {
        return null;
    }

    public HashMap zzatx() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzhs(String str);

    /* access modifiers changed from: protected */
    public abstract boolean zzht(String str);
}
