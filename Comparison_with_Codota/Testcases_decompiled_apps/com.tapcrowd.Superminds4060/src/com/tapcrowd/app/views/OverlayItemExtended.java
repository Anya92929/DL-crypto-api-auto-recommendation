package com.tapcrowd.app.views;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.tapcrowd.app.views.ClusteredMapView;

public class OverlayItemExtended extends OverlayItem {
    public boolean isMe = false;
    public int slaves = 0;
    public ClusteredMapView.Tag tag;

    public OverlayItemExtended(GeoPoint point, String title, String snippet, ClusteredMapView.Tag tag2) {
        super(point, title, snippet);
        this.tag = tag2;
    }
}
