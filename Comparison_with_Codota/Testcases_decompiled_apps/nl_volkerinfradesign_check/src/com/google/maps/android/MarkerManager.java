package com.google.maps.android;

import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MarkerManager implements GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final GoogleMap f3850a;

    /* renamed from: b */
    private final Map<String, Collection> f3851b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<Marker, Collection> f3852c = new HashMap();

    public MarkerManager(GoogleMap googleMap) {
        this.f3850a = googleMap;
    }

    public Collection newCollection() {
        return new Collection();
    }

    public Collection newCollection(String str) {
        if (this.f3851b.get(str) != null) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "collection id is not unique: ".concat(valueOf) : new String("collection id is not unique: "));
        }
        Collection collection = new Collection();
        this.f3851b.put(str, collection);
        return collection;
    }

    public Collection getCollection(String str) {
        return this.f3851b.get(str);
    }

    public View getInfoWindow(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection == null || collection.f3858f == null) {
            return null;
        }
        return collection.f3858f.getInfoWindow(marker);
    }

    public View getInfoContents(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection == null || collection.f3858f == null) {
            return null;
        }
        return collection.f3858f.getInfoContents(marker);
    }

    public void onInfoWindowClick(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection != null && collection.f3855c != null) {
            collection.f3855c.onInfoWindowClick(marker);
        }
    }

    public boolean onMarkerClick(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection == null || collection.f3856d == null) {
            return false;
        }
        return collection.f3856d.onMarkerClick(marker);
    }

    public void onMarkerDragStart(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection != null && collection.f3857e != null) {
            collection.f3857e.onMarkerDragStart(marker);
        }
    }

    public void onMarkerDrag(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection != null && collection.f3857e != null) {
            collection.f3857e.onMarkerDrag(marker);
        }
    }

    public void onMarkerDragEnd(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        if (collection != null && collection.f3857e != null) {
            collection.f3857e.onMarkerDragEnd(marker);
        }
    }

    public boolean remove(Marker marker) {
        Collection collection = this.f3852c.get(marker);
        return collection != null && collection.remove(marker);
    }

    public class Collection {

        /* renamed from: b */
        private final Set<Marker> f3854b = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public GoogleMap.OnInfoWindowClickListener f3855c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public GoogleMap.OnMarkerClickListener f3856d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public GoogleMap.OnMarkerDragListener f3857e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public GoogleMap.InfoWindowAdapter f3858f;

        public Collection() {
        }

        public Marker addMarker(MarkerOptions markerOptions) {
            Marker addMarker = MarkerManager.this.f3850a.addMarker(markerOptions);
            this.f3854b.add(addMarker);
            MarkerManager.this.f3852c.put(addMarker, this);
            return addMarker;
        }

        public boolean remove(Marker marker) {
            if (!this.f3854b.remove(marker)) {
                return false;
            }
            MarkerManager.this.f3852c.remove(marker);
            marker.remove();
            return true;
        }

        public void clear() {
            for (Marker next : this.f3854b) {
                next.remove();
                MarkerManager.this.f3852c.remove(next);
            }
            this.f3854b.clear();
        }

        public java.util.Collection<Marker> getMarkers() {
            return Collections.unmodifiableCollection(this.f3854b);
        }

        public void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
            this.f3855c = onInfoWindowClickListener;
        }

        public void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener onMarkerClickListener) {
            this.f3856d = onMarkerClickListener;
        }

        public void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener onMarkerDragListener) {
            this.f3857e = onMarkerDragListener;
        }

        public void setOnInfoWindowAdapter(GoogleMap.InfoWindowAdapter infoWindowAdapter) {
            this.f3858f = infoWindowAdapter;
        }
    }
}
