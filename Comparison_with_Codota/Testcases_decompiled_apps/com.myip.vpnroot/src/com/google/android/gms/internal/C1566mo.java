package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.games.multiplayer.Multiplayer;

/* renamed from: com.google.android.gms.internal.mo */
public final class C1566mo implements SafeParcelable {
    public static final C1567mp CREATOR = new C1567mp();
    public static final C1566mo afA = m5623bW("beauty_salon");
    public static final C1566mo afB = m5623bW("bicycle_store");
    public static final C1566mo afC = m5623bW("book_store");
    public static final C1566mo afD = m5623bW("bowling_alley");
    public static final C1566mo afE = m5623bW("bus_station");
    public static final C1566mo afF = m5623bW("cafe");
    public static final C1566mo afG = m5623bW("campground");
    public static final C1566mo afH = m5623bW("car_dealer");
    public static final C1566mo afI = m5623bW("car_rental");
    public static final C1566mo afJ = m5623bW("car_repair");
    public static final C1566mo afK = m5623bW("car_wash");
    public static final C1566mo afL = m5623bW("casino");
    public static final C1566mo afM = m5623bW("cemetery");
    public static final C1566mo afN = m5623bW("church");
    public static final C1566mo afO = m5623bW("city_hall");
    public static final C1566mo afP = m5623bW("clothing_store");
    public static final C1566mo afQ = m5623bW("convenience_store");
    public static final C1566mo afR = m5623bW("courthouse");
    public static final C1566mo afS = m5623bW("dentist");
    public static final C1566mo afT = m5623bW("department_store");
    public static final C1566mo afU = m5623bW("doctor");
    public static final C1566mo afV = m5623bW("electrician");
    public static final C1566mo afW = m5623bW("electronics_store");
    public static final C1566mo afX = m5623bW("embassy");
    public static final C1566mo afY = m5623bW("establishment");
    public static final C1566mo afZ = m5623bW("finance");
    public static final C1566mo afr = m5623bW("accounting");
    public static final C1566mo afs = m5623bW("airport");
    public static final C1566mo aft = m5623bW("amusement_park");
    public static final C1566mo afu = m5623bW("aquarium");
    public static final C1566mo afv = m5623bW("art_gallery");
    public static final C1566mo afw = m5623bW("atm");
    public static final C1566mo afx = m5623bW("bakery");
    public static final C1566mo afy = m5623bW("bank");
    public static final C1566mo afz = m5623bW("bar");
    public static final C1566mo agA = m5623bW("mosque");
    public static final C1566mo agB = m5623bW("movie_rental");
    public static final C1566mo agC = m5623bW("movie_theater");
    public static final C1566mo agD = m5623bW("moving_company");
    public static final C1566mo agE = m5623bW("museum");
    public static final C1566mo agF = m5623bW("night_club");
    public static final C1566mo agG = m5623bW("painter");
    public static final C1566mo agH = m5623bW("park");
    public static final C1566mo agI = m5623bW("parking");
    public static final C1566mo agJ = m5623bW("pet_store");
    public static final C1566mo agK = m5623bW("pharmacy");
    public static final C1566mo agL = m5623bW("physiotherapist");
    public static final C1566mo agM = m5623bW("place_of_worship");
    public static final C1566mo agN = m5623bW("plumber");
    public static final C1566mo agO = m5623bW("police");
    public static final C1566mo agP = m5623bW("post_office");
    public static final C1566mo agQ = m5623bW("real_estate_agency");
    public static final C1566mo agR = m5623bW("restaurant");
    public static final C1566mo agS = m5623bW("roofing_contractor");
    public static final C1566mo agT = m5623bW("rv_park");
    public static final C1566mo agU = m5623bW("school");
    public static final C1566mo agV = m5623bW("shoe_store");
    public static final C1566mo agW = m5623bW("shopping_mall");
    public static final C1566mo agX = m5623bW("spa");
    public static final C1566mo agY = m5623bW("stadium");
    public static final C1566mo agZ = m5623bW("storage");
    public static final C1566mo aga = m5623bW("fire_station");
    public static final C1566mo agb = m5623bW("florist");
    public static final C1566mo agc = m5623bW("food");
    public static final C1566mo agd = m5623bW("funeral_home");
    public static final C1566mo age = m5623bW("furniture_store");
    public static final C1566mo agf = m5623bW("gas_station");
    public static final C1566mo agg = m5623bW("general_contractor");
    public static final C1566mo agh = m5623bW("grocery_or_supermarket");
    public static final C1566mo agi = m5623bW("gym");
    public static final C1566mo agj = m5623bW("hair_care");
    public static final C1566mo agk = m5623bW("hardware_store");
    public static final C1566mo agl = m5623bW("health");
    public static final C1566mo agm = m5623bW("hindu_temple");
    public static final C1566mo agn = m5623bW("home_goods_store");
    public static final C1566mo ago = m5623bW("hospital");
    public static final C1566mo agp = m5623bW("insurance_agency");
    public static final C1566mo agq = m5623bW("jewelry_store");
    public static final C1566mo agr = m5623bW("laundry");
    public static final C1566mo ags = m5623bW("lawyer");
    public static final C1566mo agt = m5623bW("library");
    public static final C1566mo agu = m5623bW("liquor_store");
    public static final C1566mo agv = m5623bW("local_government_office");
    public static final C1566mo agw = m5623bW("locksmith");
    public static final C1566mo agx = m5623bW("lodging");
    public static final C1566mo agy = m5623bW("meal_delivery");
    public static final C1566mo agz = m5623bW("meal_takeaway");
    public static final C1566mo ahA = m5623bW("premise");
    public static final C1566mo ahB = m5623bW(Multiplayer.EXTRA_ROOM);
    public static final C1566mo ahC = m5623bW("route");
    public static final C1566mo ahD = m5623bW("street_address");
    public static final C1566mo ahE = m5623bW("sublocality");
    public static final C1566mo ahF = m5623bW("sublocality_level_1");
    public static final C1566mo ahG = m5623bW("sublocality_level_2");
    public static final C1566mo ahH = m5623bW("sublocality_level_3");
    public static final C1566mo ahI = m5623bW("sublocality_level_4");
    public static final C1566mo ahJ = m5623bW("sublocality_level_5");
    public static final C1566mo ahK = m5623bW("subpremise");
    public static final C1566mo ahL = m5623bW("transit_station");
    public static final C1566mo ahM = m5623bW(FitnessActivities.OTHER_STRING);
    public static final C1566mo aha = m5623bW("store");
    public static final C1566mo ahb = m5623bW("subway_station");
    public static final C1566mo ahc = m5623bW("synagogue");
    public static final C1566mo ahd = m5623bW("taxi_stand");
    public static final C1566mo ahe = m5623bW("train_station");
    public static final C1566mo ahf = m5623bW("travel_agency");
    public static final C1566mo ahg = m5623bW("university");
    public static final C1566mo ahh = m5623bW("veterinary_care");
    public static final C1566mo ahi = m5623bW("zoo");
    public static final C1566mo ahj = m5623bW("administrative_area_level_1");
    public static final C1566mo ahk = m5623bW("administrative_area_level_2");
    public static final C1566mo ahl = m5623bW("administrative_area_level_3");
    public static final C1566mo ahm = m5623bW("colloquial_area");
    public static final C1566mo ahn = m5623bW("country");
    public static final C1566mo aho = m5623bW("floor");
    public static final C1566mo ahp = m5623bW("geocode");
    public static final C1566mo ahq = m5623bW("intersection");
    public static final C1566mo ahr = m5623bW("locality");
    public static final C1566mo ahs = m5623bW("natural_feature");
    public static final C1566mo aht = m5623bW("neighborhood");
    public static final C1566mo ahu = m5623bW("political");
    public static final C1566mo ahv = m5623bW("point_of_interest");
    public static final C1566mo ahw = m5623bW("post_box");
    public static final C1566mo ahx = m5623bW("postal_code");
    public static final C1566mo ahy = m5623bW("postal_code_prefix");
    public static final C1566mo ahz = m5623bW("postal_town");

    /* renamed from: BR */
    final int f4287BR;

    /* renamed from: uO */
    final String f4288uO;

    C1566mo(int i, String str) {
        C0348n.m856aZ(str);
        this.f4287BR = i;
        this.f4288uO = str;
    }

    /* renamed from: bW */
    public static C1566mo m5623bW(String str) {
        return new C1566mo(0, str);
    }

    public int describeContents() {
        C1567mp mpVar = CREATOR;
        return 0;
    }

    public boolean equals(Object o) {
        return (o instanceof C1566mo) && this.f4288uO.equals(((C1566mo) o).f4288uO);
    }

    public int hashCode() {
        return this.f4288uO.hashCode();
    }

    public String toString() {
        return this.f4288uO;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1567mp mpVar = CREATOR;
        C1567mp.m5624a(this, parcel, flags);
    }
}
