package com.google.android.gms.location.places.p003ui;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;

/* renamed from: com.google.android.gms.location.places.ui.PlaceSelectionListener */
public interface PlaceSelectionListener {
    void onError(Status status);

    void onPlaceSelected(Place place);
}
