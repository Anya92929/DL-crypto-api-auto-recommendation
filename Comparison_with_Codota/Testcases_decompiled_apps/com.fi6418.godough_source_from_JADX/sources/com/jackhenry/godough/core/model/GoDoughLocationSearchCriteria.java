package com.jackhenry.godough.core.model;

public class GoDoughLocationSearchCriteria implements GoDoughType {
    private String address;
    private boolean atm;
    private String city;
    private double latitude;
    private boolean lobby;
    private String locationName;
    private double longitude;
    private String state;
    private String zipCode;

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getState() {
        return this.state;
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

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAtm(boolean z) {
        this.atm = z;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLobby(boolean z) {
        this.lobby = z;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setZipCode(String str) {
        this.zipCode = str;
    }
}
