package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C0542bx;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {

        /* renamed from: di */
        private String f1685di;

        /* renamed from: fy */
        private double f1686fy;

        /* renamed from: fz */
        private double f1687fz;

        /* renamed from: iD */
        private final Set<Integer> f1688iD = new HashSet();

        /* renamed from: iE */
        private C0542bx f1689iE;

        /* renamed from: iF */
        private List<String> f1690iF;

        /* renamed from: iG */
        private C0542bx f1691iG;

        /* renamed from: iH */
        private String f1692iH;

        /* renamed from: iI */
        private String f1693iI;

        /* renamed from: iJ */
        private String f1694iJ;

        /* renamed from: iK */
        private List<C0542bx> f1695iK;

        /* renamed from: iL */
        private int f1696iL;

        /* renamed from: iM */
        private List<C0542bx> f1697iM;

        /* renamed from: iN */
        private C0542bx f1698iN;

        /* renamed from: iO */
        private List<C0542bx> f1699iO;

        /* renamed from: iP */
        private String f1700iP;

        /* renamed from: iQ */
        private String f1701iQ;

        /* renamed from: iR */
        private C0542bx f1702iR;

        /* renamed from: iS */
        private String f1703iS;

        /* renamed from: iT */
        private String f1704iT;

        /* renamed from: iU */
        private String f1705iU;

        /* renamed from: iV */
        private List<C0542bx> f1706iV;

        /* renamed from: iW */
        private String f1707iW;

        /* renamed from: iX */
        private String f1708iX;

        /* renamed from: iY */
        private String f1709iY;

        /* renamed from: iZ */
        private String f1710iZ;

        /* renamed from: ie */
        private String f1711ie;

        /* renamed from: jA */
        private String f1712jA;

        /* renamed from: ja */
        private String f1713ja;

        /* renamed from: jb */
        private String f1714jb;

        /* renamed from: jc */
        private String f1715jc;

        /* renamed from: jd */
        private String f1716jd;

        /* renamed from: je */
        private C0542bx f1717je;

        /* renamed from: jf */
        private String f1718jf;

        /* renamed from: jg */
        private String f1719jg;

        /* renamed from: jh */
        private String f1720jh;

        /* renamed from: ji */
        private String f1721ji;

        /* renamed from: jj */
        private C0542bx f1722jj;

        /* renamed from: jk */
        private C0542bx f1723jk;

        /* renamed from: jl */
        private C0542bx f1724jl;

        /* renamed from: jm */
        private List<C0542bx> f1725jm;

        /* renamed from: jn */
        private String f1726jn;

        /* renamed from: jo */
        private String f1727jo;

        /* renamed from: jp */
        private String f1728jp;

        /* renamed from: jq */
        private String f1729jq;

        /* renamed from: jr */
        private C0542bx f1730jr;

        /* renamed from: js */
        private String f1731js;

        /* renamed from: jt */
        private String f1732jt;

        /* renamed from: ju */
        private String f1733ju;

        /* renamed from: jv */
        private C0542bx f1734jv;

        /* renamed from: jw */
        private String f1735jw;

        /* renamed from: jx */
        private String f1736jx;

        /* renamed from: jy */
        private String f1737jy;

        /* renamed from: jz */
        private String f1738jz;
        private String mName;

        public ItemScope build() {
            return new C0542bx(this.f1688iD, this.f1689iE, this.f1690iF, this.f1691iG, this.f1692iH, this.f1693iI, this.f1694iJ, this.f1695iK, this.f1696iL, this.f1697iM, this.f1698iN, this.f1699iO, this.f1700iP, this.f1701iQ, this.f1702iR, this.f1703iS, this.f1704iT, this.f1705iU, this.f1706iV, this.f1707iW, this.f1708iX, this.f1709iY, this.f1685di, this.f1710iZ, this.f1713ja, this.f1714jb, this.f1715jc, this.f1716jd, this.f1717je, this.f1718jf, this.f1719jg, this.f1720jh, this.f1721ji, this.f1722jj, this.f1686fy, this.f1723jk, this.f1687fz, this.mName, this.f1724jl, this.f1725jm, this.f1726jn, this.f1727jo, this.f1728jp, this.f1729jq, this.f1730jr, this.f1731js, this.f1732jt, this.f1733ju, this.f1734jv, this.f1735jw, this.f1736jx, this.f1737jy, this.f1711ie, this.f1738jz, this.f1712jA);
        }

        public Builder setAbout(ItemScope about) {
            this.f1689iE = (C0542bx) about;
            this.f1688iD.add(2);
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.f1690iF = additionalName;
            this.f1688iD.add(3);
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.f1691iG = (C0542bx) address;
            this.f1688iD.add(4);
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.f1692iH = addressCountry;
            this.f1688iD.add(5);
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.f1693iI = addressLocality;
            this.f1688iD.add(6);
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.f1694iJ = addressRegion;
            this.f1688iD.add(7);
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.f1695iK = associated_media;
            this.f1688iD.add(8);
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.f1696iL = attendeeCount;
            this.f1688iD.add(9);
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.f1697iM = attendees;
            this.f1688iD.add(10);
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.f1698iN = (C0542bx) audio;
            this.f1688iD.add(11);
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.f1699iO = author;
            this.f1688iD.add(12);
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.f1700iP = bestRating;
            this.f1688iD.add(13);
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.f1701iQ = birthDate;
            this.f1688iD.add(14);
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.f1702iR = (C0542bx) byArtist;
            this.f1688iD.add(15);
            return this;
        }

        public Builder setCaption(String caption) {
            this.f1703iS = caption;
            this.f1688iD.add(16);
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.f1704iT = contentSize;
            this.f1688iD.add(17);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.f1705iU = contentUrl;
            this.f1688iD.add(18);
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.f1706iV = contributor;
            this.f1688iD.add(19);
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.f1707iW = dateCreated;
            this.f1688iD.add(20);
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.f1708iX = dateModified;
            this.f1688iD.add(21);
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.f1709iY = datePublished;
            this.f1688iD.add(22);
            return this;
        }

        public Builder setDescription(String description) {
            this.f1685di = description;
            this.f1688iD.add(23);
            return this;
        }

        public Builder setDuration(String duration) {
            this.f1710iZ = duration;
            this.f1688iD.add(24);
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.f1713ja = embedUrl;
            this.f1688iD.add(25);
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.f1714jb = endDate;
            this.f1688iD.add(26);
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.f1715jc = familyName;
            this.f1688iD.add(27);
            return this;
        }

        public Builder setGender(String gender) {
            this.f1716jd = gender;
            this.f1688iD.add(28);
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.f1717je = (C0542bx) geo;
            this.f1688iD.add(29);
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.f1718jf = givenName;
            this.f1688iD.add(30);
            return this;
        }

        public Builder setHeight(String height) {
            this.f1719jg = height;
            this.f1688iD.add(31);
            return this;
        }

        public Builder setId(String id) {
            this.f1720jh = id;
            this.f1688iD.add(32);
            return this;
        }

        public Builder setImage(String image) {
            this.f1721ji = image;
            this.f1688iD.add(33);
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.f1722jj = (C0542bx) inAlbum;
            this.f1688iD.add(34);
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.f1686fy = latitude;
            this.f1688iD.add(36);
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.f1723jk = (C0542bx) location;
            this.f1688iD.add(37);
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.f1687fz = longitude;
            this.f1688iD.add(38);
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.f1688iD.add(39);
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.f1724jl = (C0542bx) partOfTVSeries;
            this.f1688iD.add(40);
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.f1725jm = performers;
            this.f1688iD.add(41);
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.f1726jn = playerType;
            this.f1688iD.add(42);
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.f1727jo = postOfficeBoxNumber;
            this.f1688iD.add(43);
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.f1728jp = postalCode;
            this.f1688iD.add(44);
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.f1729jq = ratingValue;
            this.f1688iD.add(45);
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.f1730jr = (C0542bx) reviewRating;
            this.f1688iD.add(46);
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.f1731js = startDate;
            this.f1688iD.add(47);
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.f1732jt = streetAddress;
            this.f1688iD.add(48);
            return this;
        }

        public Builder setText(String text) {
            this.f1733ju = text;
            this.f1688iD.add(49);
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.f1734jv = (C0542bx) thumbnail;
            this.f1688iD.add(50);
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.f1735jw = thumbnailUrl;
            this.f1688iD.add(51);
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.f1736jx = tickerSymbol;
            this.f1688iD.add(52);
            return this;
        }

        public Builder setType(String type) {
            this.f1737jy = type;
            this.f1688iD.add(53);
            return this;
        }

        public Builder setUrl(String url) {
            this.f1711ie = url;
            this.f1688iD.add(54);
            return this;
        }

        public Builder setWidth(String width) {
            this.f1738jz = width;
            this.f1688iD.add(55);
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.f1712jA = worstRating;
            this.f1688iD.add(56);
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
