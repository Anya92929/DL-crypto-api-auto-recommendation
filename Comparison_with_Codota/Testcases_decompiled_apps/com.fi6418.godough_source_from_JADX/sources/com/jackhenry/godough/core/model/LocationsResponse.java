package com.jackhenry.godough.core.model;

import java.util.List;

public class LocationsResponse implements GoDoughType {
    private List<GoDoughLocation> locations;

    public List<GoDoughLocation> getLocations() {
        return this.locations;
    }

    public void setLocations(List<GoDoughLocation> list) {
        this.locations = list;
    }
}
