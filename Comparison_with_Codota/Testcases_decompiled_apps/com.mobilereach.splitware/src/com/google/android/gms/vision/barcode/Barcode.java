package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.support.p000v4.widget.ExploreByTouchHelper;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Barcode implements SafeParcelable {
    public static final int ALL_FORMATS = 0;
    public static final int AZTEC = 4096;
    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final zzb CREATOR = new zzb();
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    public CalendarEvent calendarEvent;
    public ContactInfo contactInfo;
    public Point[] cornerPoints;
    public String displayValue;
    public DriverLicense driverLicense;
    public Email email;
    public int format;
    public GeoPoint geoPoint;
    public Phone phone;
    public String rawValue;
    public Sms sms;
    public UrlBookmark url;
    public int valueFormat;
    final int versionCode;
    public WiFi wifi;

    public static class Address implements SafeParcelable {
        public static final zza CREATOR = new zza();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String[] addressLines;
        public int type;
        final int versionCode;

        public Address() {
            this.versionCode = 1;
        }

        public Address(int versionCode2, int type2, String[] addressLines2) {
            this.versionCode = versionCode2;
            this.type = type2;
            this.addressLines = addressLines2;
        }

        public int describeContents() {
            zza zza = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zza zza = CREATOR;
            zza.zza(this, parcel, flags);
        }
    }

    public static class CalendarDateTime implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        public int day;
        public int hours;
        public boolean isUtc;
        public int minutes;
        public int month;
        public String rawValue;
        public int seconds;
        final int versionCode;
        public int year;

        public CalendarDateTime() {
            this.versionCode = 1;
        }

        public CalendarDateTime(int versionCode2, int year2, int month2, int day2, int hours2, int minutes2, int seconds2, boolean isUtc2, String rawValue2) {
            this.versionCode = versionCode2;
            this.year = year2;
            this.month = month2;
            this.day = day2;
            this.hours = hours2;
            this.minutes = minutes2;
            this.seconds = seconds2;
            this.isUtc = isUtc2;
            this.rawValue = rawValue2;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzc zzc = CREATOR;
            zzc.zza(this, parcel, flags);
        }
    }

    public static class CalendarEvent implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        public String description;
        public CalendarDateTime end;
        public String location;
        public String organizer;
        public CalendarDateTime start;
        public String status;
        public String summary;
        final int versionCode;

        public CalendarEvent() {
            this.versionCode = 1;
        }

        public CalendarEvent(int versionCode2, String summary2, String description2, String location2, String organizer2, String status2, CalendarDateTime start2, CalendarDateTime end2) {
            this.versionCode = versionCode2;
            this.summary = summary2;
            this.description = description2;
            this.location = location2;
            this.organizer = organizer2;
            this.status = status2;
            this.start = start2;
            this.end = end2;
        }

        public int describeContents() {
            zzd zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzd zzd = CREATOR;
            zzd.zza(this, parcel, flags);
        }
    }

    public static class ContactInfo implements SafeParcelable {
        public static final zze CREATOR = new zze();
        public Address[] addresses;
        public Email[] emails;
        public PersonName name;
        public String organization;
        public Phone[] phones;
        public String title;
        public String[] urls;
        final int versionCode;

        public ContactInfo() {
            this.versionCode = 1;
        }

        public ContactInfo(int versionCode2, PersonName name2, String organization2, String title2, Phone[] phones2, Email[] emails2, String[] urls2, Address[] addresses2) {
            this.versionCode = versionCode2;
            this.name = name2;
            this.organization = organization2;
            this.title = title2;
            this.phones = phones2;
            this.emails = emails2;
            this.urls = urls2;
            this.addresses = addresses2;
        }

        public int describeContents() {
            zze zze = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zze zze = CREATOR;
            zze.zza(this, parcel, flags);
        }
    }

    public static class DriverLicense implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        public String addressCity;
        public String addressState;
        public String addressStreet;
        public String addressZip;
        public String birthDate;
        public String documentType;
        public String expiryDate;
        public String firstName;
        public String gender;
        public String issueDate;
        public String issuingCountry;
        public String lastName;
        public String licenseNumber;
        public String middleName;
        final int versionCode;

        public DriverLicense() {
            this.versionCode = 1;
        }

        public DriverLicense(int versionCode2, String documentType2, String firstName2, String middleName2, String lastName2, String gender2, String addressStreet2, String addressCity2, String addressState2, String addressZip2, String licenseNumber2, String issueDate2, String expiryDate2, String birthDate2, String issuingCountry2) {
            this.versionCode = versionCode2;
            this.documentType = documentType2;
            this.firstName = firstName2;
            this.middleName = middleName2;
            this.lastName = lastName2;
            this.gender = gender2;
            this.addressStreet = addressStreet2;
            this.addressCity = addressCity2;
            this.addressState = addressState2;
            this.addressZip = addressZip2;
            this.licenseNumber = licenseNumber2;
            this.issueDate = issueDate2;
            this.expiryDate = expiryDate2;
            this.birthDate = birthDate2;
            this.issuingCountry = issuingCountry2;
        }

        public int describeContents() {
            zzf zzf = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzf zzf = CREATOR;
            zzf.zza(this, parcel, flags);
        }
    }

    public static class Email implements SafeParcelable {
        public static final zzg CREATOR = new zzg();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String address;
        public String body;
        public String subject;
        public int type;
        final int versionCode;

        public Email() {
            this.versionCode = 1;
        }

        public Email(int versionCode2, int type2, String address2, String subject2, String body2) {
            this.versionCode = versionCode2;
            this.type = type2;
            this.address = address2;
            this.subject = subject2;
            this.body = body2;
        }

        public int describeContents() {
            zzg zzg = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzg zzg = CREATOR;
            zzg.zza(this, parcel, flags);
        }
    }

    public static class GeoPoint implements SafeParcelable {
        public static final zzh CREATOR = new zzh();
        public double lat;
        public double lng;
        final int versionCode;

        public GeoPoint() {
            this.versionCode = 1;
        }

        public GeoPoint(int versionCode2, double lat2, double lng2) {
            this.versionCode = versionCode2;
            this.lat = lat2;
            this.lng = lng2;
        }

        public int describeContents() {
            zzh zzh = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzh zzh = CREATOR;
            zzh.zza(this, parcel, flags);
        }
    }

    public static class PersonName implements SafeParcelable {
        public static final zzi CREATOR = new zzi();
        public String first;
        public String formattedName;
        public String last;
        public String middle;
        public String prefix;
        public String pronunciation;
        public String suffix;
        final int versionCode;

        public PersonName() {
            this.versionCode = 1;
        }

        public PersonName(int versionCode2, String formattedName2, String pronunciation2, String prefix2, String first2, String middle2, String last2, String suffix2) {
            this.versionCode = versionCode2;
            this.formattedName = formattedName2;
            this.pronunciation = pronunciation2;
            this.prefix = prefix2;
            this.first = first2;
            this.middle = middle2;
            this.last = last2;
            this.suffix = suffix2;
        }

        public int describeContents() {
            zzi zzi = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzi zzi = CREATOR;
            zzi.zza(this, parcel, flags);
        }
    }

    public static class Phone implements SafeParcelable {
        public static final zzj CREATOR = new zzj();
        public static final int FAX = 3;
        public static final int HOME = 2;
        public static final int MOBILE = 4;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String number;
        public int type;
        final int versionCode;

        public Phone() {
            this.versionCode = 1;
        }

        public Phone(int versionCode2, int type2, String number2) {
            this.versionCode = versionCode2;
            this.type = type2;
            this.number = number2;
        }

        public int describeContents() {
            zzj zzj = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzj zzj = CREATOR;
            zzj.zza(this, parcel, flags);
        }
    }

    public static class Sms implements SafeParcelable {
        public static final zzk CREATOR = new zzk();
        public String message;
        public String phoneNumber;
        final int versionCode;

        public Sms() {
            this.versionCode = 1;
        }

        public Sms(int versionCode2, String message2, String phoneNumber2) {
            this.versionCode = versionCode2;
            this.message = message2;
            this.phoneNumber = phoneNumber2;
        }

        public int describeContents() {
            zzk zzk = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzk zzk = CREATOR;
            zzk.zza(this, parcel, flags);
        }
    }

    public static class UrlBookmark implements SafeParcelable {
        public static final zzl CREATOR = new zzl();
        public String title;
        public String url;
        final int versionCode;

        public UrlBookmark() {
            this.versionCode = 1;
        }

        public UrlBookmark(int versionCode2, String title2, String url2) {
            this.versionCode = versionCode2;
            this.title = title2;
            this.url = url2;
        }

        public int describeContents() {
            zzl zzl = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzl zzl = CREATOR;
            zzl.zza(this, parcel, flags);
        }
    }

    public static class WiFi implements SafeParcelable {
        public static final zzm CREATOR = new zzm();
        public static final int OPEN = 1;
        public static final int WEP = 3;
        public static final int WPA = 2;
        public int encryptionType;
        public String password;
        public String ssid;
        final int versionCode;

        public WiFi() {
            this.versionCode = 1;
        }

        public WiFi(int versionCode2, String ssid2, String password2, int encryptionType2) {
            this.versionCode = versionCode2;
            this.ssid = ssid2;
            this.password = password2;
            this.encryptionType = encryptionType2;
        }

        public int describeContents() {
            zzm zzm = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzm zzm = CREATOR;
            zzm.zza(this, parcel, flags);
        }
    }

    public Barcode() {
        this.versionCode = 1;
    }

    public Barcode(int versionCode2, int format2, String rawValue2, String displayValue2, int valueFormat2, Point[] cornerPoints2, Email email2, Phone phone2, Sms sms2, WiFi wifi2, UrlBookmark url2, GeoPoint geoPoint2, CalendarEvent calendarEvent2, ContactInfo contactInfo2, DriverLicense driverLicense2) {
        this.versionCode = versionCode2;
        this.format = format2;
        this.rawValue = rawValue2;
        this.displayValue = displayValue2;
        this.valueFormat = valueFormat2;
        this.cornerPoints = cornerPoints2;
        this.email = email2;
        this.phone = phone2;
        this.sms = sms2;
        this.wifi = wifi2;
        this.url = url2;
        this.geoPoint = geoPoint2;
        this.calendarEvent = calendarEvent2;
        this.contactInfo = contactInfo2;
        this.driverLicense = driverLicense2;
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public Rect getBoundingBox() {
        int i = Integer.MAX_VALUE;
        int i2 = ExploreByTouchHelper.INVALID_ID;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Point point : this.cornerPoints) {
            i4 = Math.min(i4, point.x);
            i3 = Math.max(i3, point.x);
            i = Math.min(i, point.y);
            i2 = Math.max(i2, point.y);
        }
        return new Rect(i4, i, i3, i2);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, flags);
    }
}
