package com.jackhenry.godough.core.model;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.jackhenry.android.p022a.C1362i;
import com.jackhenry.android.p022a.C1363j;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.GoDoughApp;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LocationSearchCriteria implements Serializable {
    public static final String KEY_LOCATION = "location";
    public static final String KEY_LOCATION_SEARCH_CRITERIA = "locationSearchCriteria";
    private String city;
    private double lat = -1.0d;
    private double lng = -1.0d;
    private LocationType locationType = LocationType.ALL;
    private String state;
    private String zipcode;

    public enum LocationType {
        BRANCH,
        ATM,
        ALL
    }

    public interface OnLocationSearch {
        void onLocationCancel();

        void onLocationSearch(LocationSearchCriteria locationSearchCriteria);
    }

    public LocationSearchCriteria() {
    }

    public LocationSearchCriteria(String str, String str2, String str3) {
        this.city = str;
        this.state = str2;
        this.zipcode = str3;
    }

    public static List<GoDoughLocation> clearLocationMiles() {
        List<GoDoughLocation> locations = GoDoughApp.getLocations();
        if (locations != null) {
            for (GoDoughLocation milesToLocation : locations) {
                milesToLocation.setMilesToLocation(-1.0d);
            }
            Collections.sort(locations);
        }
        return locations;
    }

    public static List<GoDoughLocation> getLocationsByCityState(Activity activity, String str, String str2) {
        return C1364k.m5589a(str) ? getLocationsByGoogleSearch(activity, str2) : getLocationsByGoogleSearch(activity, str + ", " + str2);
    }

    public static List<GoDoughLocation> getLocationsByGoogleSearch(Activity activity, String str) {
        List<GoDoughLocation> locations = GoDoughApp.getLocations();
        if (locations != null) {
            try {
                List<Address> fromLocationName = new Geocoder(activity).getFromLocationName(str, 10);
                if (!fromLocationName.isEmpty()) {
                    Location location = new Location("");
                    location.setLatitude(fromLocationName.get(0).getLatitude());
                    location.setLongitude(fromLocationName.get(0).getLongitude());
                    Location location2 = new Location("");
                    for (GoDoughLocation next : locations) {
                        location2.setLatitude(next.getLatitude());
                        location2.setLongitude(next.getLongitude());
                        next.setMilesToLocation((double) (location2.distanceTo(location) * 6.2137E-4f));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Collections.sort(locations);
        }
        return locations;
    }

    public static List<GoDoughLocation> getLocationsByZipCode(Activity activity, String str) {
        return getLocationsByGoogleSearch(activity, str);
    }

    public static List<String> getUniqueCitiesForState(List<GoDoughLocation> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (GoDoughLocation next : list) {
            if (next.getState().equals(str) && !arrayList.contains(next.getCity())) {
                arrayList.add(next.getCity());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<C1363j> getUniqueStates(List<GoDoughLocation> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (GoDoughLocation next : list) {
                if (!hashMap.containsKey(next.getState()) && C1362i.m5581a(next.getState()) != null) {
                    hashMap.put(next.getState(), C1362i.m5581a(next.getState()));
                }
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.size());
        arrayList.addAll(hashMap.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    public static boolean passesFilter(GoDoughLocation goDoughLocation, LocationType locationType2) {
        switch (locationType2) {
            case ALL:
                return true;
            case BRANCH:
                return goDoughLocation.isLobby();
            case ATM:
                return goDoughLocation.isAtm();
            default:
                return false;
        }
    }

    public void clearLatLng() {
        this.lat = -1.0d;
        this.lng = -1.0d;
    }

    public String getCity() {
        return this.city;
    }

    public LatLng getLatLng() {
        if (this.lat == -1.0d && this.lng == -1.0d) {
            return null;
        }
        return new LatLng(this.lat, this.lng);
    }

    public LocationType getLocationType() {
        return this.locationType;
    }

    public String getState() {
        return this.state;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setLatLng(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public void setLocationType(LocationType locationType2) {
        this.locationType = locationType2;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setZipcode(String str) {
        this.zipcode = str;
    }
}
