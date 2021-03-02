package com.tapcrowd.app.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.MotionEventCompat;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.ClusteredMapView;
import java.util.ArrayList;
import java.util.List;

public class ClusterOverlay extends ItemizedOverlay<OverlayItemExtended> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$views$ClusteredMapView$Tag;
    Context context;
    private OverlayItemOnTapListener listener;
    private List<OverlayItemExtended> overlays = new ArrayList();

    static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$views$ClusteredMapView$Tag() {
        int[] iArr = $SWITCH_TABLE$com$tapcrowd$app$views$ClusteredMapView$Tag;
        if (iArr == null) {
            iArr = new int[ClusteredMapView.Tag.values().length];
            try {
                iArr[ClusteredMapView.Tag.Basefeed.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ClusteredMapView.Tag.Bulk.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ClusteredMapView.Tag.None.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ClusteredMapView.Tag.Premium.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$tapcrowd$app$views$ClusteredMapView$Tag = iArr;
        }
        return iArr;
    }

    public ClusterOverlay(Drawable defaultMarker, Context context2) {
        super(boundCenterBottom(defaultMarker));
        this.context = context2;
        populate();
    }

    /* access modifiers changed from: protected */
    public OverlayItemExtended createItem(int i) {
        return this.overlays.get(i);
    }

    public int size() {
        return this.overlays.size();
    }

    public void addOverlayItem(OverlayItemExtended overlay) {
        this.overlays.add(overlay);
    }

    public void removeAllOverlays() {
        this.overlays.clear();
        populate();
    }

    public void populateOverlay() {
        populate();
    }

    public void setOnTapListener(OverlayItemOnTapListener listener2) {
        this.listener = listener2;
    }

    public void addOverlayItemClustered(OverlayItemExtended thisOverlay, MapView mapView) {
        for (OverlayItemExtended otherOverlay : this.overlays) {
            GeoPoint point = thisOverlay.getPoint();
            Point master = new Point();
            mapView.getProjection().toPixels(point, master);
            GeoPoint slavePoint = otherOverlay.getPoint();
            Point slave = new Point();
            mapView.getProjection().toPixels(slavePoint, slave);
            if (Math.sqrt((double) (((master.x - slave.x) * (master.x - slave.x)) + ((master.y - slave.y) * (master.y - slave.y)))) < 240.0d) {
                otherOverlay.slaves++;
                return;
            }
        }
        this.overlays.add(thisOverlay);
    }

    /* access modifiers changed from: protected */
    public boolean onTap(int index) {
        OverlayItemExtended item = this.overlays.get(index);
        if (item.slaves == 0 && this.listener != null) {
            this.listener.onTap(item);
        }
        return ClusterOverlay.super.onTap(index);
    }

    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        Bitmap marker;
        String text;
        new FastImageLoader();
        for (int index = 0; index < this.overlays.size(); index++) {
            OverlayItemExtended item = this.overlays.get(index);
            GeoPoint point = item.getPoint();
            Point ptScreenCoord = new Point();
            mapView.getProjection().toPixels(point, ptScreenCoord);
            if (item.slaves > 0) {
                Bitmap marker2 = ((BitmapDrawable) App.act.getResources().getDrawable(C0846R.drawable.cluster)).getBitmap();
                canvas.drawBitmap(marker2, (float) (ptScreenCoord.x - (marker2.getWidth() / 2)), (float) (ptScreenCoord.y - (marker2.getHeight() / 2)), (Paint) null);
            } else {
                switch ($SWITCH_TABLE$com$tapcrowd$app$views$ClusteredMapView$Tag()[item.tag.ordinal()]) {
                    case 1:
                        marker = ((BitmapDrawable) App.act.getResources().getDrawable(C0846R.drawable.marker_bulk)).getBitmap();
                        break;
                    case 2:
                        marker = ((BitmapDrawable) App.act.getResources().getDrawable(C0846R.drawable.marker_basefeed)).getBitmap();
                        break;
                    case 3:
                        marker = ((BitmapDrawable) App.act.getResources().getDrawable(C0846R.drawable.marker_premium)).getBitmap();
                        break;
                    default:
                        marker = ((BitmapDrawable) App.act.getResources().getDrawable(C0846R.drawable.marker_premium)).getBitmap();
                        break;
                }
                canvas.drawBitmap(marker, (float) (ptScreenCoord.x - (marker.getWidth() / 2)), (float) (ptScreenCoord.y - marker.getHeight()), (Paint) null);
            }
            new Paint();
            Paint paint = new Paint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(30.0f);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            paint.setARGB(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
            if (item.slaves > 0) {
                text = new StringBuilder(String.valueOf(item.slaves + 1)).toString();
            } else {
                text = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            canvas.drawText(text, (float) ptScreenCoord.x, (float) (ptScreenCoord.y + 10), paint);
        }
    }
}
