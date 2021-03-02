package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.C1553mb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
    private final int aee;
    private final List<Geofence> aef;
    private final Location aeg;

    /* renamed from: tc */
    private final int f4417tc;

    private GeofencingEvent(int errorCode, int transitionType, List<Geofence> triggeringGeofences, Location triggeringLocaton) {
        this.f4417tc = errorCode;
        this.aee = transitionType;
        this.aef = triggeringGeofences;
        this.aeg = triggeringLocaton;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), getGeofenceTransition(intent), getTriggeringGeofences(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int getGeofenceTransition(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return intExtra;
        }
        return -1;
    }

    private static List<Geofence> getTriggeringGeofences(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(C1553mb.m5588h((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.f4417tc;
    }

    public int getGeofenceTransition() {
        return this.aee;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.aef;
    }

    public Location getTriggeringLocation() {
        return this.aeg;
    }

    public boolean hasError() {
        return this.f4417tc != -1;
    }
}
