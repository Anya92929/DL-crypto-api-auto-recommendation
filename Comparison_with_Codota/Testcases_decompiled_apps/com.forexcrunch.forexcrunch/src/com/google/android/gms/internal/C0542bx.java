package com.google.android.gms.internal;

import android.os.Parcel;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.bx */
public final class C0542bx extends C0409ae implements SafeParcelable, ItemScope {
    public static final C0543by CREATOR = new C0543by();

    /* renamed from: iC */
    private static final HashMap<String, C0409ae.C0410a<?, ?>> f1178iC = new HashMap<>();

    /* renamed from: ab */
    private final int f1179ab;

    /* renamed from: di */
    private String f1180di;

    /* renamed from: fy */
    private double f1181fy;

    /* renamed from: fz */
    private double f1182fz;

    /* renamed from: iD */
    private final Set<Integer> f1183iD;

    /* renamed from: iE */
    private C0542bx f1184iE;

    /* renamed from: iF */
    private List<String> f1185iF;

    /* renamed from: iG */
    private C0542bx f1186iG;

    /* renamed from: iH */
    private String f1187iH;

    /* renamed from: iI */
    private String f1188iI;

    /* renamed from: iJ */
    private String f1189iJ;

    /* renamed from: iK */
    private List<C0542bx> f1190iK;

    /* renamed from: iL */
    private int f1191iL;

    /* renamed from: iM */
    private List<C0542bx> f1192iM;

    /* renamed from: iN */
    private C0542bx f1193iN;

    /* renamed from: iO */
    private List<C0542bx> f1194iO;

    /* renamed from: iP */
    private String f1195iP;

    /* renamed from: iQ */
    private String f1196iQ;

    /* renamed from: iR */
    private C0542bx f1197iR;

    /* renamed from: iS */
    private String f1198iS;

    /* renamed from: iT */
    private String f1199iT;

    /* renamed from: iU */
    private String f1200iU;

    /* renamed from: iV */
    private List<C0542bx> f1201iV;

    /* renamed from: iW */
    private String f1202iW;

    /* renamed from: iX */
    private String f1203iX;

    /* renamed from: iY */
    private String f1204iY;

    /* renamed from: iZ */
    private String f1205iZ;

    /* renamed from: ie */
    private String f1206ie;

    /* renamed from: jA */
    private String f1207jA;

    /* renamed from: ja */
    private String f1208ja;

    /* renamed from: jb */
    private String f1209jb;

    /* renamed from: jc */
    private String f1210jc;

    /* renamed from: jd */
    private String f1211jd;

    /* renamed from: je */
    private C0542bx f1212je;

    /* renamed from: jf */
    private String f1213jf;

    /* renamed from: jg */
    private String f1214jg;

    /* renamed from: jh */
    private String f1215jh;

    /* renamed from: ji */
    private String f1216ji;

    /* renamed from: jj */
    private C0542bx f1217jj;

    /* renamed from: jk */
    private C0542bx f1218jk;

    /* renamed from: jl */
    private C0542bx f1219jl;

    /* renamed from: jm */
    private List<C0542bx> f1220jm;

    /* renamed from: jn */
    private String f1221jn;

    /* renamed from: jo */
    private String f1222jo;

    /* renamed from: jp */
    private String f1223jp;

    /* renamed from: jq */
    private String f1224jq;

    /* renamed from: jr */
    private C0542bx f1225jr;

    /* renamed from: js */
    private String f1226js;

    /* renamed from: jt */
    private String f1227jt;

    /* renamed from: ju */
    private String f1228ju;

    /* renamed from: jv */
    private C0542bx f1229jv;

    /* renamed from: jw */
    private String f1230jw;

    /* renamed from: jx */
    private String f1231jx;

    /* renamed from: jy */
    private String f1232jy;

    /* renamed from: jz */
    private String f1233jz;
    private String mName;

    static {
        f1178iC.put("about", C0409ae.C0410a.m826a("about", 2, C0542bx.class));
        f1178iC.put("additionalName", C0409ae.C0410a.m833g("additionalName", 3));
        f1178iC.put("address", C0409ae.C0410a.m826a("address", 4, C0542bx.class));
        f1178iC.put("addressCountry", C0409ae.C0410a.m832f("addressCountry", 5));
        f1178iC.put("addressLocality", C0409ae.C0410a.m832f("addressLocality", 6));
        f1178iC.put("addressRegion", C0409ae.C0410a.m832f("addressRegion", 7));
        f1178iC.put("associated_media", C0409ae.C0410a.m827b("associated_media", 8, C0542bx.class));
        f1178iC.put("attendeeCount", C0409ae.C0410a.m828c("attendeeCount", 9));
        f1178iC.put("attendees", C0409ae.C0410a.m827b("attendees", 10, C0542bx.class));
        f1178iC.put("audio", C0409ae.C0410a.m826a("audio", 11, C0542bx.class));
        f1178iC.put("author", C0409ae.C0410a.m827b("author", 12, C0542bx.class));
        f1178iC.put("bestRating", C0409ae.C0410a.m832f("bestRating", 13));
        f1178iC.put("birthDate", C0409ae.C0410a.m832f("birthDate", 14));
        f1178iC.put("byArtist", C0409ae.C0410a.m826a("byArtist", 15, C0542bx.class));
        f1178iC.put("caption", C0409ae.C0410a.m832f("caption", 16));
        f1178iC.put("contentSize", C0409ae.C0410a.m832f("contentSize", 17));
        f1178iC.put("contentUrl", C0409ae.C0410a.m832f("contentUrl", 18));
        f1178iC.put("contributor", C0409ae.C0410a.m827b("contributor", 19, C0542bx.class));
        f1178iC.put("dateCreated", C0409ae.C0410a.m832f("dateCreated", 20));
        f1178iC.put("dateModified", C0409ae.C0410a.m832f("dateModified", 21));
        f1178iC.put("datePublished", C0409ae.C0410a.m832f("datePublished", 22));
        f1178iC.put("description", C0409ae.C0410a.m832f("description", 23));
        f1178iC.put("duration", C0409ae.C0410a.m832f("duration", 24));
        f1178iC.put("embedUrl", C0409ae.C0410a.m832f("embedUrl", 25));
        f1178iC.put("endDate", C0409ae.C0410a.m832f("endDate", 26));
        f1178iC.put("familyName", C0409ae.C0410a.m832f("familyName", 27));
        f1178iC.put("gender", C0409ae.C0410a.m832f("gender", 28));
        f1178iC.put("geo", C0409ae.C0410a.m826a("geo", 29, C0542bx.class));
        f1178iC.put("givenName", C0409ae.C0410a.m832f("givenName", 30));
        f1178iC.put("height", C0409ae.C0410a.m832f("height", 31));
        f1178iC.put("id", C0409ae.C0410a.m832f("id", 32));
        f1178iC.put("image", C0409ae.C0410a.m832f("image", 33));
        f1178iC.put("inAlbum", C0409ae.C0410a.m826a("inAlbum", 34, C0542bx.class));
        f1178iC.put("latitude", C0409ae.C0410a.m830d("latitude", 36));
        f1178iC.put("location", C0409ae.C0410a.m826a("location", 37, C0542bx.class));
        f1178iC.put("longitude", C0409ae.C0410a.m830d("longitude", 38));
        f1178iC.put("name", C0409ae.C0410a.m832f("name", 39));
        f1178iC.put("partOfTVSeries", C0409ae.C0410a.m826a("partOfTVSeries", 40, C0542bx.class));
        f1178iC.put("performers", C0409ae.C0410a.m827b("performers", 41, C0542bx.class));
        f1178iC.put("playerType", C0409ae.C0410a.m832f("playerType", 42));
        f1178iC.put("postOfficeBoxNumber", C0409ae.C0410a.m832f("postOfficeBoxNumber", 43));
        f1178iC.put("postalCode", C0409ae.C0410a.m832f("postalCode", 44));
        f1178iC.put("ratingValue", C0409ae.C0410a.m832f("ratingValue", 45));
        f1178iC.put("reviewRating", C0409ae.C0410a.m826a("reviewRating", 46, C0542bx.class));
        f1178iC.put("startDate", C0409ae.C0410a.m832f("startDate", 47));
        f1178iC.put("streetAddress", C0409ae.C0410a.m832f("streetAddress", 48));
        f1178iC.put("text", C0409ae.C0410a.m832f("text", 49));
        f1178iC.put("thumbnail", C0409ae.C0410a.m826a("thumbnail", 50, C0542bx.class));
        f1178iC.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C0409ae.C0410a.m832f(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        f1178iC.put("tickerSymbol", C0409ae.C0410a.m832f("tickerSymbol", 52));
        f1178iC.put(ChartActivity.TYPE, C0409ae.C0410a.m832f(ChartActivity.TYPE, 53));
        f1178iC.put("url", C0409ae.C0410a.m832f("url", 54));
        f1178iC.put("width", C0409ae.C0410a.m832f("width", 55));
        f1178iC.put("worstRating", C0409ae.C0410a.m832f("worstRating", 56));
    }

    public C0542bx() {
        this.f1179ab = 1;
        this.f1183iD = new HashSet();
    }

    C0542bx(Set<Integer> set, int i, C0542bx bxVar, List<String> list, C0542bx bxVar2, String str, String str2, String str3, List<C0542bx> list2, int i2, List<C0542bx> list3, C0542bx bxVar3, List<C0542bx> list4, String str4, String str5, C0542bx bxVar4, String str6, String str7, String str8, List<C0542bx> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C0542bx bxVar5, String str18, String str19, String str20, String str21, C0542bx bxVar6, double d, C0542bx bxVar7, double d2, String str22, C0542bx bxVar8, List<C0542bx> list6, String str23, String str24, String str25, String str26, C0542bx bxVar9, String str27, String str28, String str29, C0542bx bxVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f1183iD = set;
        this.f1179ab = i;
        this.f1184iE = bxVar;
        this.f1185iF = list;
        this.f1186iG = bxVar2;
        this.f1187iH = str;
        this.f1188iI = str2;
        this.f1189iJ = str3;
        this.f1190iK = list2;
        this.f1191iL = i2;
        this.f1192iM = list3;
        this.f1193iN = bxVar3;
        this.f1194iO = list4;
        this.f1195iP = str4;
        this.f1196iQ = str5;
        this.f1197iR = bxVar4;
        this.f1198iS = str6;
        this.f1199iT = str7;
        this.f1200iU = str8;
        this.f1201iV = list5;
        this.f1202iW = str9;
        this.f1203iX = str10;
        this.f1204iY = str11;
        this.f1180di = str12;
        this.f1205iZ = str13;
        this.f1208ja = str14;
        this.f1209jb = str15;
        this.f1210jc = str16;
        this.f1211jd = str17;
        this.f1212je = bxVar5;
        this.f1213jf = str18;
        this.f1214jg = str19;
        this.f1215jh = str20;
        this.f1216ji = str21;
        this.f1217jj = bxVar6;
        this.f1181fy = d;
        this.f1218jk = bxVar7;
        this.f1182fz = d2;
        this.mName = str22;
        this.f1219jl = bxVar8;
        this.f1220jm = list6;
        this.f1221jn = str23;
        this.f1222jo = str24;
        this.f1223jp = str25;
        this.f1224jq = str26;
        this.f1225jr = bxVar9;
        this.f1226js = str27;
        this.f1227jt = str28;
        this.f1228ju = str29;
        this.f1229jv = bxVar10;
        this.f1230jw = str30;
        this.f1231jx = str31;
        this.f1232jy = str32;
        this.f1206ie = str33;
        this.f1233jz = str34;
        this.f1207jA = str35;
    }

    public C0542bx(Set<Integer> set, C0542bx bxVar, List<String> list, C0542bx bxVar2, String str, String str2, String str3, List<C0542bx> list2, int i, List<C0542bx> list3, C0542bx bxVar3, List<C0542bx> list4, String str4, String str5, C0542bx bxVar4, String str6, String str7, String str8, List<C0542bx> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C0542bx bxVar5, String str18, String str19, String str20, String str21, C0542bx bxVar6, double d, C0542bx bxVar7, double d2, String str22, C0542bx bxVar8, List<C0542bx> list6, String str23, String str24, String str25, String str26, C0542bx bxVar9, String str27, String str28, String str29, C0542bx bxVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f1183iD = set;
        this.f1179ab = 1;
        this.f1184iE = bxVar;
        this.f1185iF = list;
        this.f1186iG = bxVar2;
        this.f1187iH = str;
        this.f1188iI = str2;
        this.f1189iJ = str3;
        this.f1190iK = list2;
        this.f1191iL = i;
        this.f1192iM = list3;
        this.f1193iN = bxVar3;
        this.f1194iO = list4;
        this.f1195iP = str4;
        this.f1196iQ = str5;
        this.f1197iR = bxVar4;
        this.f1198iS = str6;
        this.f1199iT = str7;
        this.f1200iU = str8;
        this.f1201iV = list5;
        this.f1202iW = str9;
        this.f1203iX = str10;
        this.f1204iY = str11;
        this.f1180di = str12;
        this.f1205iZ = str13;
        this.f1208ja = str14;
        this.f1209jb = str15;
        this.f1210jc = str16;
        this.f1211jd = str17;
        this.f1212je = bxVar5;
        this.f1213jf = str18;
        this.f1214jg = str19;
        this.f1215jh = str20;
        this.f1216ji = str21;
        this.f1217jj = bxVar6;
        this.f1181fy = d;
        this.f1218jk = bxVar7;
        this.f1182fz = d2;
        this.mName = str22;
        this.f1219jl = bxVar8;
        this.f1220jm = list6;
        this.f1221jn = str23;
        this.f1222jo = str24;
        this.f1223jp = str25;
        this.f1224jq = str26;
        this.f1225jr = bxVar9;
        this.f1226js = str27;
        this.f1227jt = str28;
        this.f1228ju = str29;
        this.f1229jv = bxVar10;
        this.f1230jw = str30;
        this.f1231jx = str31;
        this.f1232jy = str32;
        this.f1206ie = str33;
        this.f1233jz = str34;
        this.f1207jA = str35;
    }

    /* renamed from: T */
    public HashMap<String, C0409ae.C0410a<?, ?>> mo4475T() {
        return f1178iC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4479a(C0409ae.C0410a aVar) {
        return this.f1183iD.contains(Integer.valueOf(aVar.mo4493aa()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4480b(C0409ae.C0410a aVar) {
        switch (aVar.mo4493aa()) {
            case 2:
                return this.f1184iE;
            case 3:
                return this.f1185iF;
            case 4:
                return this.f1186iG;
            case 5:
                return this.f1187iH;
            case 6:
                return this.f1188iI;
            case 7:
                return this.f1189iJ;
            case 8:
                return this.f1190iK;
            case 9:
                return Integer.valueOf(this.f1191iL);
            case 10:
                return this.f1192iM;
            case 11:
                return this.f1193iN;
            case 12:
                return this.f1194iO;
            case 13:
                return this.f1195iP;
            case 14:
                return this.f1196iQ;
            case 15:
                return this.f1197iR;
            case 16:
                return this.f1198iS;
            case 17:
                return this.f1199iT;
            case 18:
                return this.f1200iU;
            case 19:
                return this.f1201iV;
            case 20:
                return this.f1202iW;
            case 21:
                return this.f1203iX;
            case 22:
                return this.f1204iY;
            case 23:
                return this.f1180di;
            case 24:
                return this.f1205iZ;
            case 25:
                return this.f1208ja;
            case 26:
                return this.f1209jb;
            case 27:
                return this.f1210jc;
            case 28:
                return this.f1211jd;
            case 29:
                return this.f1212je;
            case 30:
                return this.f1213jf;
            case 31:
                return this.f1214jg;
            case 32:
                return this.f1215jh;
            case 33:
                return this.f1216ji;
            case 34:
                return this.f1217jj;
            case 36:
                return Double.valueOf(this.f1181fy);
            case 37:
                return this.f1218jk;
            case 38:
                return Double.valueOf(this.f1182fz);
            case 39:
                return this.mName;
            case 40:
                return this.f1219jl;
            case 41:
                return this.f1220jm;
            case 42:
                return this.f1221jn;
            case 43:
                return this.f1222jo;
            case 44:
                return this.f1223jp;
            case 45:
                return this.f1224jq;
            case 46:
                return this.f1225jr;
            case 47:
                return this.f1226js;
            case 48:
                return this.f1227jt;
            case 49:
                return this.f1228ju;
            case 50:
                return this.f1229jv;
            case 51:
                return this.f1230jw;
            case 52:
                return this.f1231jx;
            case 53:
                return this.f1232jy;
            case 54:
                return this.f1206ie;
            case 55:
                return this.f1233jz;
            case 56:
                return this.f1207jA;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4493aa());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bH */
    public Set<Integer> mo4943bH() {
        return this.f1183iD;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bI */
    public C0542bx mo4944bI() {
        return this.f1184iE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bJ */
    public C0542bx mo4945bJ() {
        return this.f1186iG;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bK */
    public List<C0542bx> mo4946bK() {
        return this.f1190iK;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bL */
    public List<C0542bx> mo4947bL() {
        return this.f1192iM;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bM */
    public C0542bx mo4948bM() {
        return this.f1193iN;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bN */
    public List<C0542bx> mo4949bN() {
        return this.f1194iO;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bO */
    public C0542bx mo4950bO() {
        return this.f1197iR;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bP */
    public List<C0542bx> mo4951bP() {
        return this.f1201iV;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bQ */
    public C0542bx mo4952bQ() {
        return this.f1212je;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bR */
    public C0542bx mo4953bR() {
        return this.f1217jj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bS */
    public C0542bx mo4954bS() {
        return this.f1218jk;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bT */
    public C0542bx mo4955bT() {
        return this.f1219jl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bU */
    public List<C0542bx> mo4956bU() {
        return this.f1220jm;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bV */
    public C0542bx mo4957bV() {
        return this.f1225jr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bW */
    public C0542bx mo4958bW() {
        return this.f1229jv;
    }

    /* renamed from: bX */
    public C0542bx freeze() {
        return this;
    }

    public int describeContents() {
        C0543by byVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0542bx)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0542bx bxVar = (C0542bx) obj;
        for (C0409ae.C0410a next : f1178iC.values()) {
            if (mo4479a(next)) {
                if (!bxVar.mo4479a(next)) {
                    return false;
                }
                if (!mo4480b(next).equals(bxVar.mo4480b(next))) {
                    return false;
                }
            } else if (bxVar.mo4479a(next)) {
                return false;
            }
        }
        return true;
    }

    public ItemScope getAbout() {
        return this.f1184iE;
    }

    public List<String> getAdditionalName() {
        return this.f1185iF;
    }

    public ItemScope getAddress() {
        return this.f1186iG;
    }

    public String getAddressCountry() {
        return this.f1187iH;
    }

    public String getAddressLocality() {
        return this.f1188iI;
    }

    public String getAddressRegion() {
        return this.f1189iJ;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.f1190iK;
    }

    public int getAttendeeCount() {
        return this.f1191iL;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.f1192iM;
    }

    public ItemScope getAudio() {
        return this.f1193iN;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.f1194iO;
    }

    public String getBestRating() {
        return this.f1195iP;
    }

    public String getBirthDate() {
        return this.f1196iQ;
    }

    public ItemScope getByArtist() {
        return this.f1197iR;
    }

    public String getCaption() {
        return this.f1198iS;
    }

    public String getContentSize() {
        return this.f1199iT;
    }

    public String getContentUrl() {
        return this.f1200iU;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.f1201iV;
    }

    public String getDateCreated() {
        return this.f1202iW;
    }

    public String getDateModified() {
        return this.f1203iX;
    }

    public String getDatePublished() {
        return this.f1204iY;
    }

    public String getDescription() {
        return this.f1180di;
    }

    public String getDuration() {
        return this.f1205iZ;
    }

    public String getEmbedUrl() {
        return this.f1208ja;
    }

    public String getEndDate() {
        return this.f1209jb;
    }

    public String getFamilyName() {
        return this.f1210jc;
    }

    public String getGender() {
        return this.f1211jd;
    }

    public ItemScope getGeo() {
        return this.f1212je;
    }

    public String getGivenName() {
        return this.f1213jf;
    }

    public String getHeight() {
        return this.f1214jg;
    }

    public String getId() {
        return this.f1215jh;
    }

    public String getImage() {
        return this.f1216ji;
    }

    public ItemScope getInAlbum() {
        return this.f1217jj;
    }

    public double getLatitude() {
        return this.f1181fy;
    }

    public ItemScope getLocation() {
        return this.f1218jk;
    }

    public double getLongitude() {
        return this.f1182fz;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.f1219jl;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.f1220jm;
    }

    public String getPlayerType() {
        return this.f1221jn;
    }

    public String getPostOfficeBoxNumber() {
        return this.f1222jo;
    }

    public String getPostalCode() {
        return this.f1223jp;
    }

    public String getRatingValue() {
        return this.f1224jq;
    }

    public ItemScope getReviewRating() {
        return this.f1225jr;
    }

    public String getStartDate() {
        return this.f1226js;
    }

    public String getStreetAddress() {
        return this.f1227jt;
    }

    public String getText() {
        return this.f1228ju;
    }

    public ItemScope getThumbnail() {
        return this.f1229jv;
    }

    public String getThumbnailUrl() {
        return this.f1230jw;
    }

    public String getTickerSymbol() {
        return this.f1231jx;
    }

    public String getType() {
        return this.f1232jy;
    }

    public String getUrl() {
        return this.f1206ie;
    }

    public String getWidth() {
        return this.f1233jz;
    }

    public String getWorstRating() {
        return this.f1207jA;
    }

    public boolean hasAbout() {
        return this.f1183iD.contains(2);
    }

    public boolean hasAdditionalName() {
        return this.f1183iD.contains(3);
    }

    public boolean hasAddress() {
        return this.f1183iD.contains(4);
    }

    public boolean hasAddressCountry() {
        return this.f1183iD.contains(5);
    }

    public boolean hasAddressLocality() {
        return this.f1183iD.contains(6);
    }

    public boolean hasAddressRegion() {
        return this.f1183iD.contains(7);
    }

    public boolean hasAssociated_media() {
        return this.f1183iD.contains(8);
    }

    public boolean hasAttendeeCount() {
        return this.f1183iD.contains(9);
    }

    public boolean hasAttendees() {
        return this.f1183iD.contains(10);
    }

    public boolean hasAudio() {
        return this.f1183iD.contains(11);
    }

    public boolean hasAuthor() {
        return this.f1183iD.contains(12);
    }

    public boolean hasBestRating() {
        return this.f1183iD.contains(13);
    }

    public boolean hasBirthDate() {
        return this.f1183iD.contains(14);
    }

    public boolean hasByArtist() {
        return this.f1183iD.contains(15);
    }

    public boolean hasCaption() {
        return this.f1183iD.contains(16);
    }

    public boolean hasContentSize() {
        return this.f1183iD.contains(17);
    }

    public boolean hasContentUrl() {
        return this.f1183iD.contains(18);
    }

    public boolean hasContributor() {
        return this.f1183iD.contains(19);
    }

    public boolean hasDateCreated() {
        return this.f1183iD.contains(20);
    }

    public boolean hasDateModified() {
        return this.f1183iD.contains(21);
    }

    public boolean hasDatePublished() {
        return this.f1183iD.contains(22);
    }

    public boolean hasDescription() {
        return this.f1183iD.contains(23);
    }

    public boolean hasDuration() {
        return this.f1183iD.contains(24);
    }

    public boolean hasEmbedUrl() {
        return this.f1183iD.contains(25);
    }

    public boolean hasEndDate() {
        return this.f1183iD.contains(26);
    }

    public boolean hasFamilyName() {
        return this.f1183iD.contains(27);
    }

    public boolean hasGender() {
        return this.f1183iD.contains(28);
    }

    public boolean hasGeo() {
        return this.f1183iD.contains(29);
    }

    public boolean hasGivenName() {
        return this.f1183iD.contains(30);
    }

    public boolean hasHeight() {
        return this.f1183iD.contains(31);
    }

    public boolean hasId() {
        return this.f1183iD.contains(32);
    }

    public boolean hasImage() {
        return this.f1183iD.contains(33);
    }

    public boolean hasInAlbum() {
        return this.f1183iD.contains(34);
    }

    public boolean hasLatitude() {
        return this.f1183iD.contains(36);
    }

    public boolean hasLocation() {
        return this.f1183iD.contains(37);
    }

    public boolean hasLongitude() {
        return this.f1183iD.contains(38);
    }

    public boolean hasName() {
        return this.f1183iD.contains(39);
    }

    public boolean hasPartOfTVSeries() {
        return this.f1183iD.contains(40);
    }

    public boolean hasPerformers() {
        return this.f1183iD.contains(41);
    }

    public boolean hasPlayerType() {
        return this.f1183iD.contains(42);
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.f1183iD.contains(43);
    }

    public boolean hasPostalCode() {
        return this.f1183iD.contains(44);
    }

    public boolean hasRatingValue() {
        return this.f1183iD.contains(45);
    }

    public boolean hasReviewRating() {
        return this.f1183iD.contains(46);
    }

    public boolean hasStartDate() {
        return this.f1183iD.contains(47);
    }

    public boolean hasStreetAddress() {
        return this.f1183iD.contains(48);
    }

    public boolean hasText() {
        return this.f1183iD.contains(49);
    }

    public boolean hasThumbnail() {
        return this.f1183iD.contains(50);
    }

    public boolean hasThumbnailUrl() {
        return this.f1183iD.contains(51);
    }

    public boolean hasTickerSymbol() {
        return this.f1183iD.contains(52);
    }

    public boolean hasType() {
        return this.f1183iD.contains(53);
    }

    public boolean hasUrl() {
        return this.f1183iD.contains(54);
    }

    public boolean hasWidth() {
        return this.f1183iD.contains(55);
    }

    public boolean hasWorstRating() {
        return this.f1183iD.contains(56);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C0409ae.C0410a<?, ?>> it = f1178iC.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0409ae.C0410a next = it.next();
            if (mo4479a(next)) {
                i = mo4480b(next).hashCode() + i2 + next.mo4493aa();
            } else {
                i = i2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5071i() {
        return this.f1179ab;
    }

    public boolean isDataValid() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Object mo4481m(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public boolean mo4482n(String str) {
        return false;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0543by byVar = CREATOR;
        C0543by.m1564a(this, out, flags);
    }
}
