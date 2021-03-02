package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1369ji;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.nt */
public final class C1634nt extends C1372jj implements ItemScope {
    public static final C1635nu CREATOR = new C1635nu();
    private static final HashMap<String, C1369ji.C1370a<?, ?>> alQ = new HashMap<>();

    /* renamed from: BL */
    String f4308BL;

    /* renamed from: BR */
    final int f4309BR;

    /* renamed from: Tg */
    String f4310Tg;
    double adZ;
    double aea;
    final Set<Integer> alR;
    C1634nt alS;
    List<String> alT;
    C1634nt alU;
    String alV;
    String alW;
    String alX;
    List<C1634nt> alY;
    int alZ;
    String amA;
    String amB;
    String amC;
    C1634nt amD;
    String amE;
    String amF;
    String amG;
    C1634nt amH;
    String amI;
    String amJ;
    String amK;
    String amL;
    List<C1634nt> ama;
    C1634nt amb;
    List<C1634nt> amc;
    String amd;
    String ame;
    C1634nt amf;
    String amg;
    String amh;
    List<C1634nt> ami;
    String amj;
    String amk;
    String aml;
    String amm;
    String amn;
    String amo;
    String amp;
    String amq;
    C1634nt amr;
    String ams;
    String amt;
    String amu;
    C1634nt amv;
    C1634nt amw;
    C1634nt amx;
    List<C1634nt> amy;
    String amz;
    String mName;

    /* renamed from: ol */
    String f4311ol;

    /* renamed from: uO */
    String f4312uO;

    /* renamed from: uR */
    String f4313uR;

    static {
        alQ.put("about", C1369ji.C1370a.m5133a("about", 2, C1634nt.class));
        alQ.put("additionalName", C1369ji.C1370a.m5140m("additionalName", 3));
        alQ.put("address", C1369ji.C1370a.m5133a("address", 4, C1634nt.class));
        alQ.put("addressCountry", C1369ji.C1370a.m5139l("addressCountry", 5));
        alQ.put("addressLocality", C1369ji.C1370a.m5139l("addressLocality", 6));
        alQ.put("addressRegion", C1369ji.C1370a.m5139l("addressRegion", 7));
        alQ.put("associated_media", C1369ji.C1370a.m5134b("associated_media", 8, C1634nt.class));
        alQ.put("attendeeCount", C1369ji.C1370a.m5136i("attendeeCount", 9));
        alQ.put("attendees", C1369ji.C1370a.m5134b("attendees", 10, C1634nt.class));
        alQ.put("audio", C1369ji.C1370a.m5133a("audio", 11, C1634nt.class));
        alQ.put("author", C1369ji.C1370a.m5134b("author", 12, C1634nt.class));
        alQ.put("bestRating", C1369ji.C1370a.m5139l("bestRating", 13));
        alQ.put("birthDate", C1369ji.C1370a.m5139l("birthDate", 14));
        alQ.put("byArtist", C1369ji.C1370a.m5133a("byArtist", 15, C1634nt.class));
        alQ.put("caption", C1369ji.C1370a.m5139l("caption", 16));
        alQ.put("contentSize", C1369ji.C1370a.m5139l("contentSize", 17));
        alQ.put("contentUrl", C1369ji.C1370a.m5139l("contentUrl", 18));
        alQ.put("contributor", C1369ji.C1370a.m5134b("contributor", 19, C1634nt.class));
        alQ.put("dateCreated", C1369ji.C1370a.m5139l("dateCreated", 20));
        alQ.put("dateModified", C1369ji.C1370a.m5139l("dateModified", 21));
        alQ.put("datePublished", C1369ji.C1370a.m5139l("datePublished", 22));
        alQ.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1369ji.C1370a.m5139l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        alQ.put("duration", C1369ji.C1370a.m5139l("duration", 24));
        alQ.put("embedUrl", C1369ji.C1370a.m5139l("embedUrl", 25));
        alQ.put("endDate", C1369ji.C1370a.m5139l("endDate", 26));
        alQ.put("familyName", C1369ji.C1370a.m5139l("familyName", 27));
        alQ.put("gender", C1369ji.C1370a.m5139l("gender", 28));
        alQ.put("geo", C1369ji.C1370a.m5133a("geo", 29, C1634nt.class));
        alQ.put("givenName", C1369ji.C1370a.m5139l("givenName", 30));
        alQ.put("height", C1369ji.C1370a.m5139l("height", 31));
        alQ.put("id", C1369ji.C1370a.m5139l("id", 32));
        alQ.put("image", C1369ji.C1370a.m5139l("image", 33));
        alQ.put("inAlbum", C1369ji.C1370a.m5133a("inAlbum", 34, C1634nt.class));
        alQ.put("latitude", C1369ji.C1370a.m5137j("latitude", 36));
        alQ.put("location", C1369ji.C1370a.m5133a("location", 37, C1634nt.class));
        alQ.put("longitude", C1369ji.C1370a.m5137j("longitude", 38));
        alQ.put("name", C1369ji.C1370a.m5139l("name", 39));
        alQ.put("partOfTVSeries", C1369ji.C1370a.m5133a("partOfTVSeries", 40, C1634nt.class));
        alQ.put("performers", C1369ji.C1370a.m5134b("performers", 41, C1634nt.class));
        alQ.put("playerType", C1369ji.C1370a.m5139l("playerType", 42));
        alQ.put("postOfficeBoxNumber", C1369ji.C1370a.m5139l("postOfficeBoxNumber", 43));
        alQ.put("postalCode", C1369ji.C1370a.m5139l("postalCode", 44));
        alQ.put("ratingValue", C1369ji.C1370a.m5139l("ratingValue", 45));
        alQ.put("reviewRating", C1369ji.C1370a.m5133a("reviewRating", 46, C1634nt.class));
        alQ.put("startDate", C1369ji.C1370a.m5139l("startDate", 47));
        alQ.put("streetAddress", C1369ji.C1370a.m5139l("streetAddress", 48));
        alQ.put("text", C1369ji.C1370a.m5139l("text", 49));
        alQ.put("thumbnail", C1369ji.C1370a.m5133a("thumbnail", 50, C1634nt.class));
        alQ.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C1369ji.C1370a.m5139l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        alQ.put("tickerSymbol", C1369ji.C1370a.m5139l("tickerSymbol", 52));
        alQ.put("type", C1369ji.C1370a.m5139l("type", 53));
        alQ.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1369ji.C1370a.m5139l(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        alQ.put("width", C1369ji.C1370a.m5139l("width", 55));
        alQ.put("worstRating", C1369ji.C1370a.m5139l("worstRating", 56));
    }

    public C1634nt() {
        this.f4309BR = 1;
        this.alR = new HashSet();
    }

    C1634nt(Set<Integer> set, int i, C1634nt ntVar, List<String> list, C1634nt ntVar2, String str, String str2, String str3, List<C1634nt> list2, int i2, List<C1634nt> list3, C1634nt ntVar3, List<C1634nt> list4, String str4, String str5, C1634nt ntVar4, String str6, String str7, String str8, List<C1634nt> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C1634nt ntVar5, String str18, String str19, String str20, String str21, C1634nt ntVar6, double d, C1634nt ntVar7, double d2, String str22, C1634nt ntVar8, List<C1634nt> list6, String str23, String str24, String str25, String str26, C1634nt ntVar9, String str27, String str28, String str29, C1634nt ntVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.alR = set;
        this.f4309BR = i;
        this.alS = ntVar;
        this.alT = list;
        this.alU = ntVar2;
        this.alV = str;
        this.alW = str2;
        this.alX = str3;
        this.alY = list2;
        this.alZ = i2;
        this.ama = list3;
        this.amb = ntVar3;
        this.amc = list4;
        this.amd = str4;
        this.ame = str5;
        this.amf = ntVar4;
        this.amg = str6;
        this.amh = str7;
        this.f4311ol = str8;
        this.ami = list5;
        this.amj = str9;
        this.amk = str10;
        this.aml = str11;
        this.f4310Tg = str12;
        this.amm = str13;
        this.amn = str14;
        this.amo = str15;
        this.amp = str16;
        this.amq = str17;
        this.amr = ntVar5;
        this.ams = str18;
        this.amt = str19;
        this.f4308BL = str20;
        this.amu = str21;
        this.amv = ntVar6;
        this.adZ = d;
        this.amw = ntVar7;
        this.aea = d2;
        this.mName = str22;
        this.amx = ntVar8;
        this.amy = list6;
        this.amz = str23;
        this.amA = str24;
        this.amB = str25;
        this.amC = str26;
        this.amD = ntVar9;
        this.amE = str27;
        this.amF = str28;
        this.amG = str29;
        this.amH = ntVar10;
        this.amI = str30;
        this.amJ = str31;
        this.f4312uO = str32;
        this.f4313uR = str33;
        this.amK = str34;
        this.amL = str35;
    }

    public C1634nt(Set<Integer> set, C1634nt ntVar, List<String> list, C1634nt ntVar2, String str, String str2, String str3, List<C1634nt> list2, int i, List<C1634nt> list3, C1634nt ntVar3, List<C1634nt> list4, String str4, String str5, C1634nt ntVar4, String str6, String str7, String str8, List<C1634nt> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C1634nt ntVar5, String str18, String str19, String str20, String str21, C1634nt ntVar6, double d, C1634nt ntVar7, double d2, String str22, C1634nt ntVar8, List<C1634nt> list6, String str23, String str24, String str25, String str26, C1634nt ntVar9, String str27, String str28, String str29, C1634nt ntVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.alR = set;
        this.f4309BR = 1;
        this.alS = ntVar;
        this.alT = list;
        this.alU = ntVar2;
        this.alV = str;
        this.alW = str2;
        this.alX = str3;
        this.alY = list2;
        this.alZ = i;
        this.ama = list3;
        this.amb = ntVar3;
        this.amc = list4;
        this.amd = str4;
        this.ame = str5;
        this.amf = ntVar4;
        this.amg = str6;
        this.amh = str7;
        this.f4311ol = str8;
        this.ami = list5;
        this.amj = str9;
        this.amk = str10;
        this.aml = str11;
        this.f4310Tg = str12;
        this.amm = str13;
        this.amn = str14;
        this.amo = str15;
        this.amp = str16;
        this.amq = str17;
        this.amr = ntVar5;
        this.ams = str18;
        this.amt = str19;
        this.f4308BL = str20;
        this.amu = str21;
        this.amv = ntVar6;
        this.adZ = d;
        this.amw = ntVar7;
        this.aea = d2;
        this.mName = str22;
        this.amx = ntVar8;
        this.amy = list6;
        this.amz = str23;
        this.amA = str24;
        this.amB = str25;
        this.amC = str26;
        this.amD = ntVar9;
        this.amE = str27;
        this.amF = str28;
        this.amG = str29;
        this.amH = ntVar10;
        this.amI = str30;
        this.amJ = str31;
        this.f4312uO = str32;
        this.f4313uR = str33;
        this.amK = str34;
        this.amL = str35;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo9017a(C1369ji.C1370a aVar) {
        return this.alR.contains(Integer.valueOf(aVar.mo9037hm()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo9018b(C1369ji.C1370a aVar) {
        switch (aVar.mo9037hm()) {
            case 2:
                return this.alS;
            case 3:
                return this.alT;
            case 4:
                return this.alU;
            case 5:
                return this.alV;
            case 6:
                return this.alW;
            case 7:
                return this.alX;
            case 8:
                return this.alY;
            case 9:
                return Integer.valueOf(this.alZ);
            case 10:
                return this.ama;
            case 11:
                return this.amb;
            case 12:
                return this.amc;
            case 13:
                return this.amd;
            case 14:
                return this.ame;
            case 15:
                return this.amf;
            case 16:
                return this.amg;
            case 17:
                return this.amh;
            case 18:
                return this.f4311ol;
            case 19:
                return this.ami;
            case FitnessActivities.BOXING:
                return this.amj;
            case 21:
                return this.amk;
            case FitnessActivities.CIRCUIT_TRAINING:
                return this.aml;
            case FitnessActivities.CRICKET:
                return this.f4310Tg;
            case FitnessActivities.DANCING:
                return this.amm;
            case FitnessActivities.ELLIPTICAL:
                return this.amn;
            case FitnessActivities.FENCING:
                return this.amo;
            case FitnessActivities.FOOTBALL_AMERICAN:
                return this.amp;
            case FitnessActivities.FOOTBALL_AUSTRALIAN:
                return this.amq;
            case FitnessActivities.FOOTBALL_SOCCER:
                return this.amr;
            case FitnessActivities.FRISBEE_DISC:
                return this.ams;
            case 31:
                return this.amt;
            case 32:
                return this.f4308BL;
            case FitnessActivities.GYMNASTICS:
                return this.amu;
            case FitnessActivities.HANDBALL:
                return this.amv;
            case FitnessActivities.HOCKEY:
                return Double.valueOf(this.adZ);
            case FitnessActivities.HORSEBACK_RIDING:
                return this.amw;
            case FitnessActivities.HOUSEWORK:
                return Double.valueOf(this.aea);
            case FitnessActivities.JUMP_ROPE:
                return this.mName;
            case FitnessActivities.KAYAKING:
                return this.amx;
            case FitnessActivities.KETTLEBELL_TRAINING:
                return this.amy;
            case FitnessActivities.KICKBOXING:
                return this.amz;
            case FitnessActivities.KITESURFING:
                return this.amA;
            case FitnessActivities.MARTIAL_ARTS:
                return this.amB;
            case FitnessActivities.MEDITATION:
                return this.amC;
            case FitnessActivities.MIXED_MARTIAL_ARTS:
                return this.amD;
            case FitnessActivities.P90X:
                return this.amE;
            case FitnessActivities.PARAGLIDING:
                return this.amF;
            case FitnessActivities.PILATES:
                return this.amG;
            case 50:
                return this.amH;
            case FitnessActivities.RACQUETBALL:
                return this.amI;
            case FitnessActivities.ROCK_CLIMBING:
                return this.amJ;
            case FitnessActivities.ROWING:
                return this.f4312uO;
            case FitnessActivities.ROWING_MACHINE:
                return this.f4313uR;
            case FitnessActivities.RUGBY:
                return this.amK;
            case FitnessActivities.RUNNING_JOGGING:
                return this.amL;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo9037hm());
        }
    }

    public int describeContents() {
        C1635nu nuVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1634nt)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1634nt ntVar = (C1634nt) obj;
        for (C1369ji.C1370a next : alQ.values()) {
            if (mo9017a(next)) {
                if (!ntVar.mo9017a(next)) {
                    return false;
                }
                if (!mo9018b(next).equals(ntVar.mo9018b(next))) {
                    return false;
                }
            } else if (ntVar.mo9017a(next)) {
                return false;
            }
        }
        return true;
    }

    public ItemScope getAbout() {
        return this.alS;
    }

    public List<String> getAdditionalName() {
        return this.alT;
    }

    public ItemScope getAddress() {
        return this.alU;
    }

    public String getAddressCountry() {
        return this.alV;
    }

    public String getAddressLocality() {
        return this.alW;
    }

    public String getAddressRegion() {
        return this.alX;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.alY;
    }

    public int getAttendeeCount() {
        return this.alZ;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.ama;
    }

    public ItemScope getAudio() {
        return this.amb;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.amc;
    }

    public String getBestRating() {
        return this.amd;
    }

    public String getBirthDate() {
        return this.ame;
    }

    public ItemScope getByArtist() {
        return this.amf;
    }

    public String getCaption() {
        return this.amg;
    }

    public String getContentSize() {
        return this.amh;
    }

    public String getContentUrl() {
        return this.f4311ol;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.ami;
    }

    public String getDateCreated() {
        return this.amj;
    }

    public String getDateModified() {
        return this.amk;
    }

    public String getDatePublished() {
        return this.aml;
    }

    public String getDescription() {
        return this.f4310Tg;
    }

    public String getDuration() {
        return this.amm;
    }

    public String getEmbedUrl() {
        return this.amn;
    }

    public String getEndDate() {
        return this.amo;
    }

    public String getFamilyName() {
        return this.amp;
    }

    public String getGender() {
        return this.amq;
    }

    public ItemScope getGeo() {
        return this.amr;
    }

    public String getGivenName() {
        return this.ams;
    }

    public String getHeight() {
        return this.amt;
    }

    public String getId() {
        return this.f4308BL;
    }

    public String getImage() {
        return this.amu;
    }

    public ItemScope getInAlbum() {
        return this.amv;
    }

    public double getLatitude() {
        return this.adZ;
    }

    public ItemScope getLocation() {
        return this.amw;
    }

    public double getLongitude() {
        return this.aea;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.amx;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.amy;
    }

    public String getPlayerType() {
        return this.amz;
    }

    public String getPostOfficeBoxNumber() {
        return this.amA;
    }

    public String getPostalCode() {
        return this.amB;
    }

    public String getRatingValue() {
        return this.amC;
    }

    public ItemScope getReviewRating() {
        return this.amD;
    }

    public String getStartDate() {
        return this.amE;
    }

    public String getStreetAddress() {
        return this.amF;
    }

    public String getText() {
        return this.amG;
    }

    public ItemScope getThumbnail() {
        return this.amH;
    }

    public String getThumbnailUrl() {
        return this.amI;
    }

    public String getTickerSymbol() {
        return this.amJ;
    }

    public String getType() {
        return this.f4312uO;
    }

    public String getUrl() {
        return this.f4313uR;
    }

    public String getWidth() {
        return this.amK;
    }

    public String getWorstRating() {
        return this.amL;
    }

    public boolean hasAbout() {
        return this.alR.contains(2);
    }

    public boolean hasAdditionalName() {
        return this.alR.contains(3);
    }

    public boolean hasAddress() {
        return this.alR.contains(4);
    }

    public boolean hasAddressCountry() {
        return this.alR.contains(5);
    }

    public boolean hasAddressLocality() {
        return this.alR.contains(6);
    }

    public boolean hasAddressRegion() {
        return this.alR.contains(7);
    }

    public boolean hasAssociated_media() {
        return this.alR.contains(8);
    }

    public boolean hasAttendeeCount() {
        return this.alR.contains(9);
    }

    public boolean hasAttendees() {
        return this.alR.contains(10);
    }

    public boolean hasAudio() {
        return this.alR.contains(11);
    }

    public boolean hasAuthor() {
        return this.alR.contains(12);
    }

    public boolean hasBestRating() {
        return this.alR.contains(13);
    }

    public boolean hasBirthDate() {
        return this.alR.contains(14);
    }

    public boolean hasByArtist() {
        return this.alR.contains(15);
    }

    public boolean hasCaption() {
        return this.alR.contains(16);
    }

    public boolean hasContentSize() {
        return this.alR.contains(17);
    }

    public boolean hasContentUrl() {
        return this.alR.contains(18);
    }

    public boolean hasContributor() {
        return this.alR.contains(19);
    }

    public boolean hasDateCreated() {
        return this.alR.contains(20);
    }

    public boolean hasDateModified() {
        return this.alR.contains(21);
    }

    public boolean hasDatePublished() {
        return this.alR.contains(22);
    }

    public boolean hasDescription() {
        return this.alR.contains(23);
    }

    public boolean hasDuration() {
        return this.alR.contains(24);
    }

    public boolean hasEmbedUrl() {
        return this.alR.contains(25);
    }

    public boolean hasEndDate() {
        return this.alR.contains(26);
    }

    public boolean hasFamilyName() {
        return this.alR.contains(27);
    }

    public boolean hasGender() {
        return this.alR.contains(28);
    }

    public boolean hasGeo() {
        return this.alR.contains(29);
    }

    public boolean hasGivenName() {
        return this.alR.contains(30);
    }

    public boolean hasHeight() {
        return this.alR.contains(31);
    }

    public boolean hasId() {
        return this.alR.contains(32);
    }

    public boolean hasImage() {
        return this.alR.contains(33);
    }

    public boolean hasInAlbum() {
        return this.alR.contains(34);
    }

    public boolean hasLatitude() {
        return this.alR.contains(36);
    }

    public boolean hasLocation() {
        return this.alR.contains(37);
    }

    public boolean hasLongitude() {
        return this.alR.contains(38);
    }

    public boolean hasName() {
        return this.alR.contains(39);
    }

    public boolean hasPartOfTVSeries() {
        return this.alR.contains(40);
    }

    public boolean hasPerformers() {
        return this.alR.contains(41);
    }

    public boolean hasPlayerType() {
        return this.alR.contains(42);
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.alR.contains(43);
    }

    public boolean hasPostalCode() {
        return this.alR.contains(44);
    }

    public boolean hasRatingValue() {
        return this.alR.contains(45);
    }

    public boolean hasReviewRating() {
        return this.alR.contains(46);
    }

    public boolean hasStartDate() {
        return this.alR.contains(47);
    }

    public boolean hasStreetAddress() {
        return this.alR.contains(48);
    }

    public boolean hasText() {
        return this.alR.contains(49);
    }

    public boolean hasThumbnail() {
        return this.alR.contains(50);
    }

    public boolean hasThumbnailUrl() {
        return this.alR.contains(51);
    }

    public boolean hasTickerSymbol() {
        return this.alR.contains(52);
    }

    public boolean hasType() {
        return this.alR.contains(53);
    }

    public boolean hasUrl() {
        return this.alR.contains(54);
    }

    public boolean hasWidth() {
        return this.alR.contains(55);
    }

    public boolean hasWorstRating() {
        return this.alR.contains(56);
    }

    public int hashCode() {
        int i = 0;
        Iterator<C1369ji.C1370a<?, ?>> it = alQ.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C1369ji.C1370a next = it.next();
            if (mo9017a(next)) {
                i = mo9018b(next).hashCode() + i2 + next.mo9037hm();
            } else {
                i = i2;
            }
        }
    }

    /* renamed from: hf */
    public HashMap<String, C1369ji.C1370a<?, ?>> mo9023hf() {
        return alQ;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: np */
    public C1634nt freeze() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1635nu nuVar = CREATOR;
        C1635nu.m5748a(this, out, flags);
    }
}
