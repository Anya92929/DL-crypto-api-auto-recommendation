package com.jackhenry.godough.core.model;

public class GoDoughLocation implements GoDoughType, Comparable<GoDoughLocation> {
    private String address1;
    private String address2;
    private boolean atm;
    private String city;
    private String email;
    private int fiNumber;
    private double latitude;
    private boolean lobby;
    private int locationId;
    private String locationName;
    private double longitude;
    private double milesToLocation = -1.0d;
    private String phoneNumber;
    private int sortOrder;
    private String state;
    private String zipCode;

    public GoDoughLocation() {
    }

    public GoDoughLocation(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, double d, double d2) {
        this.locationId = i;
        this.fiNumber = i2;
        this.sortOrder = i3;
        this.locationName = str;
        this.address1 = str2;
        this.address2 = str3;
        this.city = str4;
        this.state = str5.toUpperCase();
        this.zipCode = str6;
        this.phoneNumber = str7;
        this.email = str8;
        this.lobby = z;
        this.atm = z2;
        this.latitude = d;
        this.longitude = d2;
    }

    public int compareTo(GoDoughLocation goDoughLocation) {
        if (this.milesToLocation == -1.0d) {
            return this.sortOrder - goDoughLocation.sortOrder;
        }
        if (this.milesToLocation < goDoughLocation.milesToLocation) {
            return -1;
        }
        return this.milesToLocation > goDoughLocation.milesToLocation ? 1 : 0;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2 == null ? "" : this.address2;
    }

    public String getCity() {
        return this.city;
    }

    public String getEmail() {
        return this.email;
    }

    public int getFiNumber() {
        return this.fiNumber;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getMilesToLocation() {
        return this.milesToLocation;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public String getState() {
        return this.state.toUpperCase();
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public boolean isAtm() {
        return this.atm;
    }

    public boolean isLobby() {
        return this.lobby;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public void setAddress2(String str) {
        this.address2 = str;
    }

    public void setAtm(boolean z) {
        this.atm = z;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFiNumber(int i) {
        this.fiNumber = i;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLobby(boolean z) {
        this.lobby = z;
    }

    public void setLocationId(int i) {
        this.locationId = i;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setMilesToLocation(double d) {
        this.milesToLocation = d;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setSortOrder(int i) {
        this.sortOrder = i;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setZipCode(String str) {
        this.zipCode = str;
    }
}
