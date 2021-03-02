package com.tapcrowd.app.views;

import android.content.Context;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClusteredMapView extends MapView {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public List<TCPoint> geoPoints = new ArrayList();
    /* access modifiers changed from: private */
    public ClusterLoadListener listener;
    /* access modifiers changed from: private */
    public List<Overlay> mapOverlays = getOverlays();
    private int oldZoomLevel = -1;
    /* access modifiers changed from: private */
    public OverlayItemOnTapListener tapListener;
    private MarkerCalcTask task;

    enum Tag {
        Bulk,
        Basefeed,
        Premium,
        None
    }

    public ClusteredMapView(Context context2, AttributeSet attrs) {
        super(context2, attrs);
        this.context = context2;
    }

    public ClusteredMapView(Context context2, AttributeSet attrs, int defStyle) {
        super(context2, attrs, defStyle);
        this.context = context2;
    }

    public ClusteredMapView(Context context2, String apiKey) {
        super(context2, apiKey);
        this.context = context2;
    }

    public void setClusterLoadListener(ClusterLoadListener listener2) {
        this.listener = listener2;
    }

    public void setOnTapListener(OverlayItemOnTapListener listener2) {
        this.tapListener = listener2;
    }

    public void clear() {
        this.geoPoints = new ArrayList();
        getOverlays().clear();
        this.mapOverlays.clear();
    }

    public void putPoints(List<TCObject> ltco) {
        Tag tag;
        this.geoPoints = new ArrayList();
        for (TCObject tco : ltco) {
            if (tco.has("lat") && tco.has("lon")) {
                double lat = Double.parseDouble(tco.get("lat"));
                double lng = Double.parseDouble(tco.get("lon"));
                if (tco.get("tags", "").toLowerCase().contains("bulk")) {
                    tag = Tag.Bulk;
                } else if (tco.get("tags", "").toLowerCase().contains("basefeed")) {
                    tag = Tag.Basefeed;
                } else if (tco.get("tags", "").toLowerCase().contains("premium")) {
                    tag = Tag.Premium;
                } else {
                    tag = Tag.None;
                }
                this.geoPoints.add(new TCPoint(new GeoPoint((int) (1000000.0d * lat), (int) (1000000.0d * lng)), tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), tag));
            }
        }
        this.task = new MarkerCalcTask(this, (MarkerCalcTask) null);
        this.task.execute(new Integer[]{Integer.valueOf(getZoomLevel())});
    }

    public List<GeoPoint> getPoints() {
        List<GeoPoint> points = new ArrayList<>();
        for (TCPoint item : this.geoPoints) {
            points.add(item.point);
        }
        return points;
    }

    public void dispatchDraw(Canvas canvas) {
        if (getZoomLevel() != this.oldZoomLevel) {
            this.oldZoomLevel = getZoomLevel();
            if (this.task != null && this.task.getStatus() == AsyncTask.Status.RUNNING) {
                this.task.cancel(true);
            }
            this.task = new MarkerCalcTask(this, (MarkerCalcTask) null);
            this.task.execute(new Integer[]{Integer.valueOf(getZoomLevel())});
        }
        ClusteredMapView.super.dispatchDraw(canvas);
    }

    private class MarkerCalcTask extends AsyncTask<Integer, Void, Void> {
        private ClusterOverlay itemizedOverlay;
        int zoomleveloftask;

        private MarkerCalcTask() {
        }

        /* synthetic */ MarkerCalcTask(ClusteredMapView clusteredMapView, MarkerCalcTask markerCalcTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (ClusteredMapView.this.listener != null) {
                ClusteredMapView.this.listener.onLoadStart(this.zoomleveloftask);
            }
            ClusteredMapView.this.getOverlays().clear();
            ClusteredMapView.this.mapOverlays.clear();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Integer... arg0) {
            this.zoomleveloftask = arg0[0].intValue();
            this.itemizedOverlay = new ClusterOverlay(ClusteredMapView.this.getResources().getDrawable(C0846R.drawable.mapmarker), ClusteredMapView.this.context);
            Log.e("Zoomlevel", new StringBuilder(String.valueOf(ClusteredMapView.this.getZoomLevel())).toString());
            if (ClusteredMapView.this.getZoomLevel() <= 12) {
                Iterator it = ClusteredMapView.this.geoPoints.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TCPoint item = (TCPoint) it.next();
                    if (isCancelled()) {
                        break;
                    }
                    this.itemizedOverlay.addOverlayItemClustered(new OverlayItemExtended(item.point, item.f2141id, item.name, item.tag), ClusteredMapView.this);
                }
            } else {
                Iterator it2 = ClusteredMapView.this.geoPoints.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        TCPoint item2 = (TCPoint) it2.next();
                        if (isCancelled()) {
                            break;
                        }
                        this.itemizedOverlay.addOverlayItem(new OverlayItemExtended(item2.point, item2.f2141id, item2.name, item2.tag));
                    } else {
                        break;
                    }
                }
                return null;
            }
            this.itemizedOverlay.populateOverlay();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (ClusteredMapView.this.listener != null) {
                ClusteredMapView.this.listener.onLoadFinished(this.zoomleveloftask);
            }
            if (ClusteredMapView.this.tapListener != null) {
                this.itemizedOverlay.setOnTapListener(ClusteredMapView.this.tapListener);
            }
            ClusteredMapView.this.getOverlays().clear();
            ClusteredMapView.this.mapOverlays.clear();
            ClusteredMapView.this.mapOverlays.add(this.itemizedOverlay);
            super.onPostExecute(result);
        }
    }

    private class TCPoint {

        /* renamed from: id */
        public String f2141id;
        public String name;
        public GeoPoint point;
        public Tag tag;

        public TCPoint(GeoPoint point2, String id, String name2, Tag tag2) {
            this.point = point2;
            this.f2141id = id;
            this.name = name2;
            this.tag = tag2;
        }
    }
}
