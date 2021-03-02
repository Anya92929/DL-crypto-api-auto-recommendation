package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.LinkedObjects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.internal.fq */
public final class C0558fq extends C0422dw implements SafeParcelable, ItemScope {
    public static final C0559fr CREATOR = new C0559fr();

    /* renamed from: rH */
    private static final HashMap<String, C0422dw.C0423a<?, ?>> f1370rH = new HashMap<>();

    /* renamed from: hN */
    private String f1371hN;

    /* renamed from: iM */
    private final int f1372iM;
    private String mName;

    /* renamed from: mo */
    private String f1373mo;

    /* renamed from: oE */
    private double f1374oE;

    /* renamed from: oF */
    private double f1375oF;

    /* renamed from: rI */
    private final Set<Integer> f1376rI;

    /* renamed from: rJ */
    private C0558fq f1377rJ;

    /* renamed from: rK */
    private List<String> f1378rK;

    /* renamed from: rL */
    private C0558fq f1379rL;

    /* renamed from: rM */
    private String f1380rM;

    /* renamed from: rN */
    private String f1381rN;

    /* renamed from: rO */
    private String f1382rO;

    /* renamed from: rP */
    private List<C0558fq> f1383rP;

    /* renamed from: rQ */
    private int f1384rQ;

    /* renamed from: rR */
    private List<C0558fq> f1385rR;

    /* renamed from: rS */
    private C0558fq f1386rS;

    /* renamed from: rT */
    private List<C0558fq> f1387rT;

    /* renamed from: rU */
    private String f1388rU;

    /* renamed from: rV */
    private String f1389rV;

    /* renamed from: rW */
    private C0558fq f1390rW;

    /* renamed from: rX */
    private String f1391rX;

    /* renamed from: rY */
    private String f1392rY;

    /* renamed from: rZ */
    private String f1393rZ;

    /* renamed from: sA */
    private C0558fq f1394sA;

    /* renamed from: sB */
    private String f1395sB;

    /* renamed from: sC */
    private String f1396sC;

    /* renamed from: sD */
    private String f1397sD;

    /* renamed from: sE */
    private String f1398sE;

    /* renamed from: sF */
    private String f1399sF;

    /* renamed from: sa */
    private List<C0558fq> f1400sa;

    /* renamed from: sb */
    private String f1401sb;

    /* renamed from: sc */
    private String f1402sc;

    /* renamed from: sd */
    private String f1403sd;

    /* renamed from: se */
    private String f1404se;

    /* renamed from: sf */
    private String f1405sf;

    /* renamed from: sg */
    private String f1406sg;

    /* renamed from: sh */
    private String f1407sh;

    /* renamed from: si */
    private String f1408si;

    /* renamed from: sj */
    private C0558fq f1409sj;

    /* renamed from: sk */
    private String f1410sk;

    /* renamed from: sl */
    private String f1411sl;

    /* renamed from: sm */
    private String f1412sm;

    /* renamed from: sn */
    private String f1413sn;

    /* renamed from: so */
    private C0558fq f1414so;

    /* renamed from: sp */
    private C0558fq f1415sp;

    /* renamed from: sq */
    private C0558fq f1416sq;

    /* renamed from: sr */
    private List<C0558fq> f1417sr;

    /* renamed from: ss */
    private String f1418ss;

    /* renamed from: st */
    private String f1419st;

    /* renamed from: su */
    private String f1420su;

    /* renamed from: sv */
    private String f1421sv;

    /* renamed from: sw */
    private C0558fq f1422sw;

    /* renamed from: sx */
    private String f1423sx;

    /* renamed from: sy */
    private String f1424sy;

    /* renamed from: sz */
    private String f1425sz;

    static {
        f1370rH.put("about", C0422dw.C0423a.m992a("about", 2, C0558fq.class));
        f1370rH.put("additionalName", C0422dw.C0423a.m999h("additionalName", 3));
        f1370rH.put("address", C0422dw.C0423a.m992a("address", 4, C0558fq.class));
        f1370rH.put("addressCountry", C0422dw.C0423a.m998g("addressCountry", 5));
        f1370rH.put("addressLocality", C0422dw.C0423a.m998g("addressLocality", 6));
        f1370rH.put("addressRegion", C0422dw.C0423a.m998g("addressRegion", 7));
        f1370rH.put("associated_media", C0422dw.C0423a.m993b("associated_media", 8, C0558fq.class));
        f1370rH.put("attendeeCount", C0422dw.C0423a.m995d("attendeeCount", 9));
        f1370rH.put(LinkedObjects.TABLE_ATT, C0422dw.C0423a.m993b(LinkedObjects.TABLE_ATT, 10, C0558fq.class));
        f1370rH.put("audio", C0422dw.C0423a.m992a("audio", 11, C0558fq.class));
        f1370rH.put("author", C0422dw.C0423a.m993b("author", 12, C0558fq.class));
        f1370rH.put("bestRating", C0422dw.C0423a.m998g("bestRating", 13));
        f1370rH.put("birthDate", C0422dw.C0423a.m998g("birthDate", 14));
        f1370rH.put("byArtist", C0422dw.C0423a.m992a("byArtist", 15, C0558fq.class));
        f1370rH.put("caption", C0422dw.C0423a.m998g("caption", 16));
        f1370rH.put("contentSize", C0422dw.C0423a.m998g("contentSize", 17));
        f1370rH.put("contentUrl", C0422dw.C0423a.m998g("contentUrl", 18));
        f1370rH.put("contributor", C0422dw.C0423a.m993b("contributor", 19, C0558fq.class));
        f1370rH.put("dateCreated", C0422dw.C0423a.m998g("dateCreated", 20));
        f1370rH.put("dateModified", C0422dw.C0423a.m998g("dateModified", 21));
        f1370rH.put("datePublished", C0422dw.C0423a.m998g("datePublished", 22));
        f1370rH.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0422dw.C0423a.m998g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        f1370rH.put("duration", C0422dw.C0423a.m998g("duration", 24));
        f1370rH.put("embedUrl", C0422dw.C0423a.m998g("embedUrl", 25));
        f1370rH.put("endDate", C0422dw.C0423a.m998g("endDate", 26));
        f1370rH.put("familyName", C0422dw.C0423a.m998g("familyName", 27));
        f1370rH.put("gender", C0422dw.C0423a.m998g("gender", 28));
        f1370rH.put("geo", C0422dw.C0423a.m992a("geo", 29, C0558fq.class));
        f1370rH.put("givenName", C0422dw.C0423a.m998g("givenName", 30));
        f1370rH.put("height", C0422dw.C0423a.m998g("height", 31));
        f1370rH.put(DBFavorites.KEY_EVENT_ID, C0422dw.C0423a.m998g(DBFavorites.KEY_EVENT_ID, 32));
        f1370rH.put("image", C0422dw.C0423a.m998g("image", 33));
        f1370rH.put("inAlbum", C0422dw.C0423a.m992a("inAlbum", 34, C0558fq.class));
        f1370rH.put("latitude", C0422dw.C0423a.m996e("latitude", 36));
        f1370rH.put("location", C0422dw.C0423a.m992a("location", 37, C0558fq.class));
        f1370rH.put("longitude", C0422dw.C0423a.m996e("longitude", 38));
        f1370rH.put(DBFavorites.KEY_NAME, C0422dw.C0423a.m998g(DBFavorites.KEY_NAME, 39));
        f1370rH.put("partOfTVSeries", C0422dw.C0423a.m992a("partOfTVSeries", 40, C0558fq.class));
        f1370rH.put("performers", C0422dw.C0423a.m993b("performers", 41, C0558fq.class));
        f1370rH.put("playerType", C0422dw.C0423a.m998g("playerType", 42));
        f1370rH.put("postOfficeBoxNumber", C0422dw.C0423a.m998g("postOfficeBoxNumber", 43));
        f1370rH.put("postalCode", C0422dw.C0423a.m998g("postalCode", 44));
        f1370rH.put("ratingValue", C0422dw.C0423a.m998g("ratingValue", 45));
        f1370rH.put("reviewRating", C0422dw.C0423a.m992a("reviewRating", 46, C0558fq.class));
        f1370rH.put("startDate", C0422dw.C0423a.m998g("startDate", 47));
        f1370rH.put("streetAddress", C0422dw.C0423a.m998g("streetAddress", 48));
        f1370rH.put("text", C0422dw.C0423a.m998g("text", 49));
        f1370rH.put("thumbnail", C0422dw.C0423a.m992a("thumbnail", 50, C0558fq.class));
        f1370rH.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C0422dw.C0423a.m998g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        f1370rH.put("tickerSymbol", C0422dw.C0423a.m998g("tickerSymbol", 52));
        f1370rH.put(Globalization.TYPE, C0422dw.C0423a.m998g(Globalization.TYPE, 53));
        f1370rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0422dw.C0423a.m998g(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        f1370rH.put("width", C0422dw.C0423a.m998g("width", 55));
        f1370rH.put("worstRating", C0422dw.C0423a.m998g("worstRating", 56));
    }

    public C0558fq() {
        this.f1372iM = 1;
        this.f1376rI = new HashSet();
    }

    C0558fq(Set<Integer> set, int i, C0558fq fqVar, List<String> list, C0558fq fqVar2, String str, String str2, String str3, List<C0558fq> list2, int i2, List<C0558fq> list3, C0558fq fqVar3, List<C0558fq> list4, String str4, String str5, C0558fq fqVar4, String str6, String str7, String str8, List<C0558fq> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C0558fq fqVar5, String str18, String str19, String str20, String str21, C0558fq fqVar6, double d, C0558fq fqVar7, double d2, String str22, C0558fq fqVar8, List<C0558fq> list6, String str23, String str24, String str25, String str26, C0558fq fqVar9, String str27, String str28, String str29, C0558fq fqVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f1376rI = set;
        this.f1372iM = i;
        this.f1377rJ = fqVar;
        this.f1378rK = list;
        this.f1379rL = fqVar2;
        this.f1380rM = str;
        this.f1381rN = str2;
        this.f1382rO = str3;
        this.f1383rP = list2;
        this.f1384rQ = i2;
        this.f1385rR = list3;
        this.f1386rS = fqVar3;
        this.f1387rT = list4;
        this.f1388rU = str4;
        this.f1389rV = str5;
        this.f1390rW = fqVar4;
        this.f1391rX = str6;
        this.f1392rY = str7;
        this.f1393rZ = str8;
        this.f1400sa = list5;
        this.f1401sb = str9;
        this.f1402sc = str10;
        this.f1403sd = str11;
        this.f1373mo = str12;
        this.f1404se = str13;
        this.f1405sf = str14;
        this.f1406sg = str15;
        this.f1407sh = str16;
        this.f1408si = str17;
        this.f1409sj = fqVar5;
        this.f1410sk = str18;
        this.f1411sl = str19;
        this.f1412sm = str20;
        this.f1413sn = str21;
        this.f1414so = fqVar6;
        this.f1374oE = d;
        this.f1415sp = fqVar7;
        this.f1375oF = d2;
        this.mName = str22;
        this.f1416sq = fqVar8;
        this.f1417sr = list6;
        this.f1418ss = str23;
        this.f1419st = str24;
        this.f1420su = str25;
        this.f1421sv = str26;
        this.f1422sw = fqVar9;
        this.f1423sx = str27;
        this.f1424sy = str28;
        this.f1425sz = str29;
        this.f1394sA = fqVar10;
        this.f1395sB = str30;
        this.f1396sC = str31;
        this.f1397sD = str32;
        this.f1371hN = str33;
        this.f1398sE = str34;
        this.f1399sF = str35;
    }

    public C0558fq(Set<Integer> set, C0558fq fqVar, List<String> list, C0558fq fqVar2, String str, String str2, String str3, List<C0558fq> list2, int i, List<C0558fq> list3, C0558fq fqVar3, List<C0558fq> list4, String str4, String str5, C0558fq fqVar4, String str6, String str7, String str8, List<C0558fq> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C0558fq fqVar5, String str18, String str19, String str20, String str21, C0558fq fqVar6, double d, C0558fq fqVar7, double d2, String str22, C0558fq fqVar8, List<C0558fq> list6, String str23, String str24, String str25, String str26, C0558fq fqVar9, String str27, String str28, String str29, C0558fq fqVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f1376rI = set;
        this.f1372iM = 1;
        this.f1377rJ = fqVar;
        this.f1378rK = list;
        this.f1379rL = fqVar2;
        this.f1380rM = str;
        this.f1381rN = str2;
        this.f1382rO = str3;
        this.f1383rP = list2;
        this.f1384rQ = i;
        this.f1385rR = list3;
        this.f1386rS = fqVar3;
        this.f1387rT = list4;
        this.f1388rU = str4;
        this.f1389rV = str5;
        this.f1390rW = fqVar4;
        this.f1391rX = str6;
        this.f1392rY = str7;
        this.f1393rZ = str8;
        this.f1400sa = list5;
        this.f1401sb = str9;
        this.f1402sc = str10;
        this.f1403sd = str11;
        this.f1373mo = str12;
        this.f1404se = str13;
        this.f1405sf = str14;
        this.f1406sg = str15;
        this.f1407sh = str16;
        this.f1408si = str17;
        this.f1409sj = fqVar5;
        this.f1410sk = str18;
        this.f1411sl = str19;
        this.f1412sm = str20;
        this.f1413sn = str21;
        this.f1414so = fqVar6;
        this.f1374oE = d;
        this.f1415sp = fqVar7;
        this.f1375oF = d2;
        this.mName = str22;
        this.f1416sq = fqVar8;
        this.f1417sr = list6;
        this.f1418ss = str23;
        this.f1419st = str24;
        this.f1420su = str25;
        this.f1421sv = str26;
        this.f1422sw = fqVar9;
        this.f1423sx = str27;
        this.f1424sy = str28;
        this.f1425sz = str29;
        this.f1394sA = fqVar10;
        this.f1395sB = str30;
        this.f1396sC = str31;
        this.f1397sD = str32;
        this.f1371hN = str33;
        this.f1398sE = str34;
        this.f1399sF = str35;
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public Object mo4427D(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public boolean mo4428E(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4432a(C0422dw.C0423a aVar) {
        return this.f1376rI.contains(Integer.valueOf(aVar.mo4447bw()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo4433b(C0422dw.C0423a aVar) {
        switch (aVar.mo4447bw()) {
            case 2:
                return this.f1377rJ;
            case 3:
                return this.f1378rK;
            case 4:
                return this.f1379rL;
            case 5:
                return this.f1380rM;
            case 6:
                return this.f1381rN;
            case 7:
                return this.f1382rO;
            case 8:
                return this.f1383rP;
            case 9:
                return Integer.valueOf(this.f1384rQ);
            case 10:
                return this.f1385rR;
            case 11:
                return this.f1386rS;
            case 12:
                return this.f1387rT;
            case 13:
                return this.f1388rU;
            case 14:
                return this.f1389rV;
            case 15:
                return this.f1390rW;
            case 16:
                return this.f1391rX;
            case 17:
                return this.f1392rY;
            case 18:
                return this.f1393rZ;
            case 19:
                return this.f1400sa;
            case 20:
                return this.f1401sb;
            case 21:
                return this.f1402sc;
            case 22:
                return this.f1403sd;
            case 23:
                return this.f1373mo;
            case 24:
                return this.f1404se;
            case 25:
                return this.f1405sf;
            case 26:
                return this.f1406sg;
            case 27:
                return this.f1407sh;
            case 28:
                return this.f1408si;
            case 29:
                return this.f1409sj;
            case 30:
                return this.f1410sk;
            case 31:
                return this.f1411sl;
            case 32:
                return this.f1412sm;
            case 33:
                return this.f1413sn;
            case 34:
                return this.f1414so;
            case 36:
                return Double.valueOf(this.f1374oE);
            case 37:
                return this.f1415sp;
            case 38:
                return Double.valueOf(this.f1375oF);
            case 39:
                return this.mName;
            case 40:
                return this.f1416sq;
            case 41:
                return this.f1417sr;
            case 42:
                return this.f1418ss;
            case 43:
                return this.f1419st;
            case 44:
                return this.f1420su;
            case 45:
                return this.f1421sv;
            case 46:
                return this.f1422sw;
            case 47:
                return this.f1423sx;
            case 48:
                return this.f1424sy;
            case 49:
                return this.f1425sz;
            case 50:
                return this.f1394sA;
            case 51:
                return this.f1395sB;
            case 52:
                return this.f1396sC;
            case 53:
                return this.f1397sD;
            case 54:
                return this.f1371hN;
            case 55:
                return this.f1398sE;
            case 56:
                return this.f1399sF;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo4447bw());
        }
    }

    /* renamed from: bp */
    public HashMap<String, C0422dw.C0423a<?, ?>> mo4434bp() {
        return f1370rH;
    }

    public int describeContents() {
        C0559fr frVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: di */
    public Set<Integer> mo4875di() {
        return this.f1376rI;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dj */
    public C0558fq mo4876dj() {
        return this.f1377rJ;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dk */
    public C0558fq mo4877dk() {
        return this.f1379rL;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dl */
    public List<C0558fq> mo4878dl() {
        return this.f1383rP;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dm */
    public List<C0558fq> mo4879dm() {
        return this.f1385rR;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dn */
    public C0558fq mo4880dn() {
        return this.f1386rS;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: do */
    public List<C0558fq> mo4881do() {
        return this.f1387rT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dp */
    public C0558fq mo4882dp() {
        return this.f1390rW;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dq */
    public List<C0558fq> mo4883dq() {
        return this.f1400sa;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dr */
    public C0558fq mo4884dr() {
        return this.f1409sj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ds */
    public C0558fq mo4885ds() {
        return this.f1414so;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dt */
    public C0558fq mo4886dt() {
        return this.f1415sp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: du */
    public C0558fq mo4887du() {
        return this.f1416sq;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dv */
    public List<C0558fq> mo4888dv() {
        return this.f1417sr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dw */
    public C0558fq mo4889dw() {
        return this.f1422sw;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dx */
    public C0558fq mo4890dx() {
        return this.f1394sA;
    }

    /* renamed from: dy */
    public C0558fq freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0558fq)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0558fq fqVar = (C0558fq) obj;
        for (C0422dw.C0423a next : f1370rH.values()) {
            if (mo4432a(next)) {
                if (!fqVar.mo4432a(next)) {
                    return false;
                }
                if (!mo4433b(next).equals(fqVar.mo4433b(next))) {
                    return false;
                }
            } else if (fqVar.mo4432a(next)) {
                return false;
            }
        }
        return true;
    }

    public ItemScope getAbout() {
        return this.f1377rJ;
    }

    public List<String> getAdditionalName() {
        return this.f1378rK;
    }

    public ItemScope getAddress() {
        return this.f1379rL;
    }

    public String getAddressCountry() {
        return this.f1380rM;
    }

    public String getAddressLocality() {
        return this.f1381rN;
    }

    public String getAddressRegion() {
        return this.f1382rO;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.f1383rP;
    }

    public int getAttendeeCount() {
        return this.f1384rQ;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.f1385rR;
    }

    public ItemScope getAudio() {
        return this.f1386rS;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.f1387rT;
    }

    public String getBestRating() {
        return this.f1388rU;
    }

    public String getBirthDate() {
        return this.f1389rV;
    }

    public ItemScope getByArtist() {
        return this.f1390rW;
    }

    public String getCaption() {
        return this.f1391rX;
    }

    public String getContentSize() {
        return this.f1392rY;
    }

    public String getContentUrl() {
        return this.f1393rZ;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.f1400sa;
    }

    public String getDateCreated() {
        return this.f1401sb;
    }

    public String getDateModified() {
        return this.f1402sc;
    }

    public String getDatePublished() {
        return this.f1403sd;
    }

    public String getDescription() {
        return this.f1373mo;
    }

    public String getDuration() {
        return this.f1404se;
    }

    public String getEmbedUrl() {
        return this.f1405sf;
    }

    public String getEndDate() {
        return this.f1406sg;
    }

    public String getFamilyName() {
        return this.f1407sh;
    }

    public String getGender() {
        return this.f1408si;
    }

    public ItemScope getGeo() {
        return this.f1409sj;
    }

    public String getGivenName() {
        return this.f1410sk;
    }

    public String getHeight() {
        return this.f1411sl;
    }

    public String getId() {
        return this.f1412sm;
    }

    public String getImage() {
        return this.f1413sn;
    }

    public ItemScope getInAlbum() {
        return this.f1414so;
    }

    public double getLatitude() {
        return this.f1374oE;
    }

    public ItemScope getLocation() {
        return this.f1415sp;
    }

    public double getLongitude() {
        return this.f1375oF;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.f1416sq;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.f1417sr;
    }

    public String getPlayerType() {
        return this.f1418ss;
    }

    public String getPostOfficeBoxNumber() {
        return this.f1419st;
    }

    public String getPostalCode() {
        return this.f1420su;
    }

    public String getRatingValue() {
        return this.f1421sv;
    }

    public ItemScope getReviewRating() {
        return this.f1422sw;
    }

    public String getStartDate() {
        return this.f1423sx;
    }

    public String getStreetAddress() {
        return this.f1424sy;
    }

    public String getText() {
        return this.f1425sz;
    }

    public ItemScope getThumbnail() {
        return this.f1394sA;
    }

    public String getThumbnailUrl() {
        return this.f1395sB;
    }

    public String getTickerSymbol() {
        return this.f1396sC;
    }

    public String getType() {
        return this.f1397sD;
    }

    public String getUrl() {
        return this.f1371hN;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1372iM;
    }

    public String getWidth() {
        return this.f1398sE;
    }

    public String getWorstRating() {
        return this.f1399sF;
    }

    public boolean hasAbout() {
        return this.f1376rI.contains(2);
    }

    public boolean hasAdditionalName() {
        return this.f1376rI.contains(3);
    }

    public boolean hasAddress() {
        return this.f1376rI.contains(4);
    }

    public boolean hasAddressCountry() {
        return this.f1376rI.contains(5);
    }

    public boolean hasAddressLocality() {
        return this.f1376rI.contains(6);
    }

    public boolean hasAddressRegion() {
        return this.f1376rI.contains(7);
    }

    public boolean hasAssociated_media() {
        return this.f1376rI.contains(8);
    }

    public boolean hasAttendeeCount() {
        return this.f1376rI.contains(9);
    }

    public boolean hasAttendees() {
        return this.f1376rI.contains(10);
    }

    public boolean hasAudio() {
        return this.f1376rI.contains(11);
    }

    public boolean hasAuthor() {
        return this.f1376rI.contains(12);
    }

    public boolean hasBestRating() {
        return this.f1376rI.contains(13);
    }

    public boolean hasBirthDate() {
        return this.f1376rI.contains(14);
    }

    public boolean hasByArtist() {
        return this.f1376rI.contains(15);
    }

    public boolean hasCaption() {
        return this.f1376rI.contains(16);
    }

    public boolean hasContentSize() {
        return this.f1376rI.contains(17);
    }

    public boolean hasContentUrl() {
        return this.f1376rI.contains(18);
    }

    public boolean hasContributor() {
        return this.f1376rI.contains(19);
    }

    public boolean hasDateCreated() {
        return this.f1376rI.contains(20);
    }

    public boolean hasDateModified() {
        return this.f1376rI.contains(21);
    }

    public boolean hasDatePublished() {
        return this.f1376rI.contains(22);
    }

    public boolean hasDescription() {
        return this.f1376rI.contains(23);
    }

    public boolean hasDuration() {
        return this.f1376rI.contains(24);
    }

    public boolean hasEmbedUrl() {
        return this.f1376rI.contains(25);
    }

    public boolean hasEndDate() {
        return this.f1376rI.contains(26);
    }

    public boolean hasFamilyName() {
        return this.f1376rI.contains(27);
    }

    public boolean hasGender() {
        return this.f1376rI.contains(28);
    }

    public boolean hasGeo() {
        return this.f1376rI.contains(29);
    }

    public boolean hasGivenName() {
        return this.f1376rI.contains(30);
    }

    public boolean hasHeight() {
        return this.f1376rI.contains(31);
    }

    public boolean hasId() {
        return this.f1376rI.contains(32);
    }

    public boolean hasImage() {
        return this.f1376rI.contains(33);
    }

    public boolean hasInAlbum() {
        return this.f1376rI.contains(34);
    }

    public boolean hasLatitude() {
        return this.f1376rI.contains(36);
    }

    public boolean hasLocation() {
        return this.f1376rI.contains(37);
    }

    public boolean hasLongitude() {
        return this.f1376rI.contains(38);
    }

    public boolean hasName() {
        return this.f1376rI.contains(39);
    }

    public boolean hasPartOfTVSeries() {
        return this.f1376rI.contains(40);
    }

    public boolean hasPerformers() {
        return this.f1376rI.contains(41);
    }

    public boolean hasPlayerType() {
        return this.f1376rI.contains(42);
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.f1376rI.contains(43);
    }

    public boolean hasPostalCode() {
        return this.f1376rI.contains(44);
    }

    public boolean hasRatingValue() {
        return this.f1376rI.contains(45);
    }

    public boolean hasReviewRating() {
        return this.f1376rI.contains(46);
    }

    public boolean hasStartDate() {
        return this.f1376rI.contains(47);
    }

    public boolean hasStreetAddress() {
        return this.f1376rI.contains(48);
    }

    public boolean hasText() {
        return this.f1376rI.contains(49);
    }

    public boolean hasThumbnail() {
        return this.f1376rI.contains(50);
    }

    public boolean hasThumbnailUrl() {
        return this.f1376rI.contains(51);
    }

    public boolean hasTickerSymbol() {
        return this.f1376rI.contains(52);
    }

    public boolean hasType() {
        return this.f1376rI.contains(53);
    }

    public boolean hasUrl() {
        return this.f1376rI.contains(54);
    }

    public boolean hasWidth() {
        return this.f1376rI.contains(55);
    }

    public boolean hasWorstRating() {
        return this.f1376rI.contains(56);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C0422dw.C0423a<?, ?>> it = f1370rH.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0422dw.C0423a next = it.next();
            if (mo4432a(next)) {
                i = mo4433b(next).hashCode() + i2 + next.mo4447bw();
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0559fr frVar = CREATOR;
        C0559fr.m1698a(this, out, flags);
    }
}
