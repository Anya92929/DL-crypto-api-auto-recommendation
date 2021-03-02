package com.forexcrunch.forexcrunch.model;

public class CountryItem {
    private String countryCode;
    private int flagResourceIdOff;
    private int flagResourceIdOn;
    private boolean isSelected;
    private String name;

    public CountryItem(int flagResourceIdOff2, int flagResourceIdOn2, String name2, String countryCode2, boolean isSelected2) {
        this.flagResourceIdOff = flagResourceIdOff2;
        this.flagResourceIdOn = flagResourceIdOn2;
        this.name = name2;
        this.countryCode = countryCode2;
        this.isSelected = isSelected2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean isSelected2) {
        this.isSelected = isSelected2;
    }

    public int getFlagResourceIdOff() {
        return this.flagResourceIdOff;
    }

    public void setFlagResourceIdOff(int flagResourceId) {
        this.flagResourceIdOff = flagResourceId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode2) {
        this.countryCode = countryCode2;
    }

    public int getFlagResourceIdOn() {
        return this.flagResourceIdOn;
    }

    public void setFlagResourceIdOn(int flagResourceIdOn2) {
        this.flagResourceIdOn = flagResourceIdOn2;
    }
}
