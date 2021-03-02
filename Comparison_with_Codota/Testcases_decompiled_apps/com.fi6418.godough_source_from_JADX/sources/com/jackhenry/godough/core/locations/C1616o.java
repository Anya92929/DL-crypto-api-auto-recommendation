package com.jackhenry.godough.core.locations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;

/* renamed from: com.jackhenry.godough.core.locations.o */
class C1616o implements GoogleMap.InfoWindowAdapter {

    /* renamed from: a */
    View f6253a;

    /* renamed from: b */
    final /* synthetic */ LocationMapFragment f6254b;

    C1616o(LocationMapFragment locationMapFragment, LayoutInflater layoutInflater) {
        this.f6254b = locationMapFragment;
        this.f6253a = layoutInflater.inflate(C1496ak.map_marker_popup, (ViewGroup) null, false);
    }

    public View getInfoContents(Marker marker) {
        return null;
    }

    public View getInfoWindow(Marker marker) {
        View findViewById = this.f6253a.findViewById(C1494ai.icon);
        TextView textView = (TextView) this.f6253a.findViewById(C1494ai.snippet);
        View findViewById2 = this.f6253a.findViewById(C1494ai.arrow_button);
        ((TextView) this.f6253a.findViewById(C1494ai.title)).setText(marker.getTitle());
        if (this.f6254b.f6205d == null || !marker.getTitle().equals(this.f6254b.f6205d.getTitle())) {
            findViewById2.setVisibility(0);
            findViewById.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(marker.getSnippet());
        } else {
            findViewById2.setVisibility(8);
            textView.setVisibility(8);
            findViewById.setVisibility(8);
        }
        return this.f6253a;
    }
}
