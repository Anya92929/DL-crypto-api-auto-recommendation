package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C0558fq;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {

        /* renamed from: hN */
        private String f1809hN;
        private String mName;

        /* renamed from: mo */
        private String f1810mo;

        /* renamed from: oE */
        private double f1811oE;

        /* renamed from: oF */
        private double f1812oF;

        /* renamed from: rI */
        private final Set<Integer> f1813rI = new HashSet();

        /* renamed from: rJ */
        private C0558fq f1814rJ;

        /* renamed from: rK */
        private List<String> f1815rK;

        /* renamed from: rL */
        private C0558fq f1816rL;

        /* renamed from: rM */
        private String f1817rM;

        /* renamed from: rN */
        private String f1818rN;

        /* renamed from: rO */
        private String f1819rO;

        /* renamed from: rP */
        private List<C0558fq> f1820rP;

        /* renamed from: rQ */
        private int f1821rQ;

        /* renamed from: rR */
        private List<C0558fq> f1822rR;

        /* renamed from: rS */
        private C0558fq f1823rS;

        /* renamed from: rT */
        private List<C0558fq> f1824rT;

        /* renamed from: rU */
        private String f1825rU;

        /* renamed from: rV */
        private String f1826rV;

        /* renamed from: rW */
        private C0558fq f1827rW;

        /* renamed from: rX */
        private String f1828rX;

        /* renamed from: rY */
        private String f1829rY;

        /* renamed from: rZ */
        private String f1830rZ;

        /* renamed from: sA */
        private C0558fq f1831sA;

        /* renamed from: sB */
        private String f1832sB;

        /* renamed from: sC */
        private String f1833sC;

        /* renamed from: sD */
        private String f1834sD;

        /* renamed from: sE */
        private String f1835sE;

        /* renamed from: sF */
        private String f1836sF;

        /* renamed from: sa */
        private List<C0558fq> f1837sa;

        /* renamed from: sb */
        private String f1838sb;

        /* renamed from: sc */
        private String f1839sc;

        /* renamed from: sd */
        private String f1840sd;

        /* renamed from: se */
        private String f1841se;

        /* renamed from: sf */
        private String f1842sf;

        /* renamed from: sg */
        private String f1843sg;

        /* renamed from: sh */
        private String f1844sh;

        /* renamed from: si */
        private String f1845si;

        /* renamed from: sj */
        private C0558fq f1846sj;

        /* renamed from: sk */
        private String f1847sk;

        /* renamed from: sl */
        private String f1848sl;

        /* renamed from: sm */
        private String f1849sm;

        /* renamed from: sn */
        private String f1850sn;

        /* renamed from: so */
        private C0558fq f1851so;

        /* renamed from: sp */
        private C0558fq f1852sp;

        /* renamed from: sq */
        private C0558fq f1853sq;

        /* renamed from: sr */
        private List<C0558fq> f1854sr;

        /* renamed from: ss */
        private String f1855ss;

        /* renamed from: st */
        private String f1856st;

        /* renamed from: su */
        private String f1857su;

        /* renamed from: sv */
        private String f1858sv;

        /* renamed from: sw */
        private C0558fq f1859sw;

        /* renamed from: sx */
        private String f1860sx;

        /* renamed from: sy */
        private String f1861sy;

        /* renamed from: sz */
        private String f1862sz;

        public ItemScope build() {
            return new C0558fq(this.f1813rI, this.f1814rJ, this.f1815rK, this.f1816rL, this.f1817rM, this.f1818rN, this.f1819rO, this.f1820rP, this.f1821rQ, this.f1822rR, this.f1823rS, this.f1824rT, this.f1825rU, this.f1826rV, this.f1827rW, this.f1828rX, this.f1829rY, this.f1830rZ, this.f1837sa, this.f1838sb, this.f1839sc, this.f1840sd, this.f1810mo, this.f1841se, this.f1842sf, this.f1843sg, this.f1844sh, this.f1845si, this.f1846sj, this.f1847sk, this.f1848sl, this.f1849sm, this.f1850sn, this.f1851so, this.f1811oE, this.f1852sp, this.f1812oF, this.mName, this.f1853sq, this.f1854sr, this.f1855ss, this.f1856st, this.f1857su, this.f1858sv, this.f1859sw, this.f1860sx, this.f1861sy, this.f1862sz, this.f1831sA, this.f1832sB, this.f1833sC, this.f1834sD, this.f1809hN, this.f1835sE, this.f1836sF);
        }

        public Builder setAbout(ItemScope about) {
            this.f1814rJ = (C0558fq) about;
            this.f1813rI.add(2);
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.f1815rK = additionalName;
            this.f1813rI.add(3);
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.f1816rL = (C0558fq) address;
            this.f1813rI.add(4);
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.f1817rM = addressCountry;
            this.f1813rI.add(5);
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.f1818rN = addressLocality;
            this.f1813rI.add(6);
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.f1819rO = addressRegion;
            this.f1813rI.add(7);
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.f1820rP = associated_media;
            this.f1813rI.add(8);
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.f1821rQ = attendeeCount;
            this.f1813rI.add(9);
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.f1822rR = attendees;
            this.f1813rI.add(10);
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.f1823rS = (C0558fq) audio;
            this.f1813rI.add(11);
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.f1824rT = author;
            this.f1813rI.add(12);
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.f1825rU = bestRating;
            this.f1813rI.add(13);
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.f1826rV = birthDate;
            this.f1813rI.add(14);
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.f1827rW = (C0558fq) byArtist;
            this.f1813rI.add(15);
            return this;
        }

        public Builder setCaption(String caption) {
            this.f1828rX = caption;
            this.f1813rI.add(16);
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.f1829rY = contentSize;
            this.f1813rI.add(17);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.f1830rZ = contentUrl;
            this.f1813rI.add(18);
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.f1837sa = contributor;
            this.f1813rI.add(19);
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.f1838sb = dateCreated;
            this.f1813rI.add(20);
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.f1839sc = dateModified;
            this.f1813rI.add(21);
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.f1840sd = datePublished;
            this.f1813rI.add(22);
            return this;
        }

        public Builder setDescription(String description) {
            this.f1810mo = description;
            this.f1813rI.add(23);
            return this;
        }

        public Builder setDuration(String duration) {
            this.f1841se = duration;
            this.f1813rI.add(24);
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.f1842sf = embedUrl;
            this.f1813rI.add(25);
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.f1843sg = endDate;
            this.f1813rI.add(26);
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.f1844sh = familyName;
            this.f1813rI.add(27);
            return this;
        }

        public Builder setGender(String gender) {
            this.f1845si = gender;
            this.f1813rI.add(28);
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.f1846sj = (C0558fq) geo;
            this.f1813rI.add(29);
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.f1847sk = givenName;
            this.f1813rI.add(30);
            return this;
        }

        public Builder setHeight(String height) {
            this.f1848sl = height;
            this.f1813rI.add(31);
            return this;
        }

        public Builder setId(String id) {
            this.f1849sm = id;
            this.f1813rI.add(32);
            return this;
        }

        public Builder setImage(String image) {
            this.f1850sn = image;
            this.f1813rI.add(33);
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.f1851so = (C0558fq) inAlbum;
            this.f1813rI.add(34);
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.f1811oE = latitude;
            this.f1813rI.add(36);
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.f1852sp = (C0558fq) location;
            this.f1813rI.add(37);
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.f1812oF = longitude;
            this.f1813rI.add(38);
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.f1813rI.add(39);
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.f1853sq = (C0558fq) partOfTVSeries;
            this.f1813rI.add(40);
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.f1854sr = performers;
            this.f1813rI.add(41);
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.f1855ss = playerType;
            this.f1813rI.add(42);
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.f1856st = postOfficeBoxNumber;
            this.f1813rI.add(43);
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.f1857su = postalCode;
            this.f1813rI.add(44);
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.f1858sv = ratingValue;
            this.f1813rI.add(45);
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.f1859sw = (C0558fq) reviewRating;
            this.f1813rI.add(46);
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.f1860sx = startDate;
            this.f1813rI.add(47);
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.f1861sy = streetAddress;
            this.f1813rI.add(48);
            return this;
        }

        public Builder setText(String text) {
            this.f1862sz = text;
            this.f1813rI.add(49);
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.f1831sA = (C0558fq) thumbnail;
            this.f1813rI.add(50);
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.f1832sB = thumbnailUrl;
            this.f1813rI.add(51);
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.f1833sC = tickerSymbol;
            this.f1813rI.add(52);
            return this;
        }

        public Builder setType(String type) {
            this.f1834sD = type;
            this.f1813rI.add(53);
            return this;
        }

        public Builder setUrl(String url) {
            this.f1809hN = url;
            this.f1813rI.add(54);
            return this;
        }

        public Builder setWidth(String width) {
            this.f1835sE = width;
            this.f1813rI.add(55);
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.f1836sF = worstRating;
            this.f1813rI.add(56);
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
