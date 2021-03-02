package com.tapcrowd.app.modules.map;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.FloatMath;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.filter.FilterFragment;
import com.tapcrowd.app.modules.sessions.FestivalSessionDetailFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.imageviewtouch.ImageViewTouch;
import com.tapcrowd.app.views.imageviewtouch.ImageViewTouchBase;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends TCFragment implements ImageViewTouchBase.OnMatrixChangedListener, View.OnClickListener {
    Marker activemarker;
    Bitmap catalogbmp;
    List<String> checkedgroupid;
    View.OnClickListener filter = new View.OnClickListener() {
        public void onClick(View v) {
            List<TCObject> groups = C1199DB.getQueryFromDb("SELECT name FROM groups WHERE id IN (SELECT groupid FROM groupitems INNER JOIN exhibitors ON groupitems.itemid == exhibitors.id WHERE itemtable == 'exhibitor' AND x1 != '0' AND y1 != '0')");
            ArrayList<String> categories = new ArrayList<>();
            for (TCObject group : groups) {
                categories.add(group.get(DBFavorites.KEY_NAME));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("null", categories);
            Fragments.add(MapFragment.this, FilterFragment.newInstance(intent, (ArrayList<String>) null, MapFragment.this.listener), MapFragment.this.getString(C0846R.string.categorieen));
        }
    };
    ImageViewTouch floorplan;
    List<String> groupid;
    boolean handlingMapClick;

    /* renamed from: id */
    String f2063id;
    OnFragmentResultListener listener = new OnFragmentResultListener() {
        public void onFragmentResult(Intent data, int requestCode, int resultCode) {
            ArrayList<String> results = data.getStringArrayListExtra(FilterFragment.RESULTS);
            for (Marker marker : MapFragment.this.visiblemarkers) {
                if (marker.view != null && marker.type == Marker.Type.SubCategorie) {
                    MapFragment.this.markercontainer.removeView(marker.view);
                    marker.view = null;
                }
            }
            if (results != null && results.size() != 0) {
                String query = "SELECT id FROM groups WHERE";
                int len = results.size();
                for (int i = 0; i < len; i++) {
                    String name = results.get(i);
                    if (i > 0) {
                        query = String.valueOf(query) + " OR";
                    }
                    query = String.valueOf(query) + " name == '" + name + "'";
                }
                List<TCObject> ids = C1199DB.getQueryFromDb(query);
                MapFragment.this.checkedgroupid = new ArrayList();
                for (TCObject id : ids) {
                    MapFragment.this.checkedgroupid.add(id.get(DBFavorites.KEY_EVENT_ID));
                }
                for (TCObject subplan : C1199DB.getQueryFromDb("SELECT count(exhibitors.id) AS count, mapid FROM exhibitors INNER JOIN groupitems ON groupitems.itemid == exhibitors.id WHERE itemtable == 'exhibitor' AND groupitems.groupid IN (" + query + ") AND exhibitors.x1 != '0' AND exhibitors.y1 != '0' AND exhibitors.mapid != '0' " + "GROUP BY mapid")) {
                    TCObject map = C1199DB.getFirstObject("map", DBFavorites.KEY_EVENT_ID, subplan.get("mapid"));
                    Marker marker2 = new Marker("", ((float) Math.round(Float.parseFloat(map.get("x", "0")))) / MapFragment.this.scale, ((float) Math.round(Float.parseFloat(map.get("y", "0")))) / MapFragment.this.scale, Marker.Type.SubCategorie, "");
                    marker2.removeable = false;
                    View view = LayoutInflater.from(MapFragment.this.getActivity()).inflate(C0846R.layout.marker_subcategorie, (ViewGroup) null);
                    ((TextView) view.findViewById(C0846R.C0847id.count)).setText(subplan.get("count"));
                    MapFragment.this.drawMarker(marker2, false, view);
                }
                for (TCObject group : C1199DB.getQueryFromDb(query)) {
                    MapFragment.this.showCategories(group.get(DBFavorites.KEY_EVENT_ID));
                }
            }
        }
    };
    TCObject map;
    String mapid;
    Bitmap markerbmp;
    ViewGroup markercontainer;
    List<Marker> markers = new ArrayList();
    Matrix matrix;
    boolean retained;
    float scale = 1.0f;
    int touchSlop;
    View.OnTouchListener touchlistener = new View.OnTouchListener() {

        /* renamed from: x */
        float f2067x;

        /* renamed from: y */
        float f2068y;

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                this.f2067x = event.getX();
                this.f2068y = event.getY();
            }
            if (action != 3 && action != 1) {
                return false;
            }
            float newX = event.getX();
            float newY = event.getY();
            if (((int) FloatMath.sqrt(((newX - this.f2067x) * (newX - this.f2067x)) + ((newY - this.f2068y) * (newY - this.f2068y)))) > MapFragment.this.touchSlop || MapFragment.this.handlingMapClick) {
                return false;
            }
            MapFragment.this.click(newX, newY);
            return false;
        }
    };

    /* renamed from: v */
    View f2064v;
    List<Marker> visiblemarkers = new ArrayList();

    /* renamed from: x */
    float f2065x;

    /* renamed from: y */
    float f2066y;

    public static MapFragment newInstance() {
        MapFragment detail = new MapFragment();
        if (C1199DB.getSize("map") == 1) {
            detail.map = C1199DB.getFirstObject("map");
        } else {
            detail.map = C1199DB.getObject("map", "parentId", "0");
        }
        detail.mapid = detail.map.get(DBFavorites.KEY_EVENT_ID);
        return detail;
    }

    public static MapFragment newInstance(String mapid2) {
        MapFragment detail = new MapFragment();
        detail.map = C1199DB.getObject("map", DBFavorites.KEY_EVENT_ID, mapid2);
        detail.mapid = mapid2;
        return detail;
    }

    public static MapFragment newInstance(int x, int y, String title) {
        MapFragment detail = new MapFragment();
        detail.map = C1199DB.getObject("map", "parentId", "0");
        detail.mapid = detail.map.get(DBFavorites.KEY_EVENT_ID);
        detail.f2065x = (float) x;
        detail.f2066y = (float) y;
        return detail;
    }

    public static MapFragment newInstance(String mapid2, float x, float y) {
        MapFragment detail = new MapFragment();
        detail.map = C1199DB.getObject("map", DBFavorites.KEY_EVENT_ID, mapid2);
        detail.mapid = mapid2;
        detail.f2065x = x;
        detail.f2066y = y;
        return detail;
    }

    public static MapFragment newInstance(String id, List<String> groupid2) {
        MapFragment detail = new MapFragment();
        detail.f2063id = id;
        if (id.equals("0")) {
            detail.map = C1199DB.getObject("map", "parentId", id);
        } else {
            detail.map = C1199DB.getObject("map", DBFavorites.KEY_EVENT_ID, id);
        }
        detail.mapid = detail.map.get(DBFavorites.KEY_EVENT_ID);
        detail.groupid = groupid2;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mapid", this.mapid);
        outState.putFloat("x", this.f2065x);
        outState.putFloat("y", this.f2066y);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2063id);
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AdHelper.showAds(this, AdHelper.buildPath("5", "map", (String) null));
        if (this.f2064v == null) {
            this.f2064v = inflater.inflate(C0846R.layout.floorplan, container, false);
            if (savedInstanceState != null && this.map == null) {
                this.mapid = savedInstanceState.getString("mapid");
                this.f2065x = savedInstanceState.getFloat("x");
                this.f2066y = savedInstanceState.getFloat("y");
                this.f2063id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
                if (this.mapid != null) {
                    this.map = C1199DB.getFirstObject("map", DBFavorites.KEY_EVENT_ID, this.mapid);
                }
                if (this.f2063id != null) {
                    if (this.f2063id.equals("0")) {
                        this.map = C1199DB.getObject("map", "parentId", this.f2063id);
                    } else {
                        this.map = C1199DB.getObject("map", DBFavorites.KEY_EVENT_ID, this.f2063id);
                    }
                }
            }
            this.markercontainer = (ViewGroup) this.f2064v.findViewById(C0846R.C0847id.markerscontainer);
            this.floorplan = (ImageViewTouch) this.f2064v.findViewById(C0846R.C0847id.floorplan);
            if (C1216LO.getLoDrawable(C1216LO.navigationMarker) != null) {
                this.markerbmp = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navigationMarker)).getBitmap();
            } else {
                this.markerbmp = ((BitmapDrawable) getResources().getDrawable(C0846R.drawable.floorplanmarker)).getBitmap();
            }
            this.markerbmp = resizeBitmap(this.markerbmp);
            this.catalogbmp = this.markerbmp;
            this.touchSlop = ViewConfiguration.get(getActivity()).getScaledTouchSlop();
            this.f2064v.findViewById(C0846R.C0847id.markername).setOnClickListener(this);
            if (C1199DB.getSize("map") == 0) {
                C1232UI.show(C0846R.C0847id.nomap, this.f2064v);
                return this.f2064v;
            } else if (this.map == null) {
                C1232UI.show(C0846R.C0847id.nomap, this.f2064v);
                return this.f2064v;
            } else {
                this.mapid = this.map.get(DBFavorites.KEY_EVENT_ID, "0");
                this.floorplan.setDoubleTapEnabled(false);
                this.floorplan.setOnMatrixChangedListener(this);
                Bitmap bmp = getMap(this.map);
                if (bmp == null) {
                    C1232UI.show(C0846R.C0847id.nomap, this.f2064v);
                    return this.f2064v;
                }
                fillMarkerList();
                this.floorplan.setImageBitmap(bmp);
                this.floorplan.setBackgroundColor(bmp.getPixel(0, 0));
                this.f2064v.findViewById(C0846R.C0847id.filterContainer).setBackgroundColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
                ((TextView) this.f2064v.findViewById(C0846R.C0847id.filter)).setTextColor(C1216LO.getLo(C1216LO.actionbarContentColor));
                this.f2064v.findViewById(C0846R.C0847id.filter).setOnClickListener(this.filter);
                if (C1199DB.getQueryFromDb("SELECT name FROM groups WHERE id IN (SELECT groupid FROM groupitems INNER JOIN exhibitors ON groupitems.itemid == exhibitors.id WHERE itemtable == 'exhibitor' AND x1 != '0' AND y1 != '0')").size() == 0 || !this.map.get("parentId").equals("0")) {
                    this.f2064v.findViewById(C0846R.C0847id.filterContainer).setVisibility(8);
                }
                return this.f2064v;
            }
        } else {
            ((ViewGroup) this.f2064v.getParent()).removeView(this.f2064v);
            this.retained = true;
            return this.f2064v;
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("5", "map", (String) null));
        if (!this.retained) {
            this.floorplan.setOnTouchListener(this.touchlistener);
            this.floorplan.post(new Runnable() {
                public void run() {
                    if (!(MapFragment.this.f2065x == BitmapDescriptorFactory.HUE_RED || MapFragment.this.f2066y == BitmapDescriptorFactory.HUE_RED)) {
                        float scale = MapFragment.this.getValue(0);
                        float transX = MapFragment.this.getValue(2);
                        float transY = MapFragment.this.getValue(5);
                        MapFragment.this.click(((Float.valueOf(MapFragment.this.f2065x).floatValue() / MapFragment.this.scale) * scale) + transX, ((Float.valueOf(MapFragment.this.f2066y).floatValue() / MapFragment.this.scale) * scale) + transY);
                    }
                    if (MapFragment.this.groupid != null) {
                        MapFragment.this.showCategories();
                    }
                }
            });
            if (this.map.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) && !App.tablet) {
                String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
                if (color.length() == 8) {
                    color = color.substring(2);
                }
                getSherlockActivity().getSupportActionBar().setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + this.map.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) + "</font>"));
            }
        }
    }

    private Bitmap getMap(TCObject map2) {
        int windowwidth;
        int inSampleSize = 1;
        float imgwidth = (float) Math.round(Float.parseFloat(map2.get("width")));
        float imgheight = (float) Math.round(Float.parseFloat(map2.get("height")));
        int windowheight = (int) (((float) getActivity().getWindowManager().getDefaultDisplay().getHeight()) - Converter.convertDpToPixel(45.0f, getActivity()));
        if (C1199DB.getSize("ad") > 0) {
            windowheight -= 100;
        }
        int windowwidth2 = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        if (getResources().getConfiguration().orientation == 2) {
            windowwidth = windowwidth2 - 300;
        } else {
            windowwidth = windowwidth2 - 120;
        }
        if (windowheight < windowwidth) {
            if (imgheight > ((float) windowheight)) {
                inSampleSize = Math.round(imgheight / ((float) windowheight));
            }
        } else if (imgwidth > ((float) windowwidth)) {
            inSampleSize = Math.round(imgwidth / ((float) windowwidth));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        Bitmap mapbmp = BitmapFactory.decodeFile(new FastImageLoader().getPath(map2.get("imageurl")), options);
        this.scale = imgheight / ((float) mapbmp.getHeight());
        if (this.scale == BitmapDescriptorFactory.HUE_RED) {
            this.scale = 1.0f;
        }
        return mapbmp;
    }

    /* access modifiers changed from: private */
    public void showCategories() {
        if (this.groupid != null) {
            for (String group : this.groupid) {
                showCategories(group);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showCategories(String groupid2) {
        List<TCObject> items = new ArrayList<>();
        if (groupid2 != null) {
            items = C1199DB.getQueryFromDb("SELECT * FROM groupitems INNER JOIN exhibitors ON exhibitors.id == groupitems.itemid WHERE exhibitors.mapid == '" + this.mapid + "' AND groupid == '" + groupid2 + "'");
        }
        for (TCObject item : items) {
            Marker marker = new Marker("", ((float) Math.round(Float.parseFloat(item.get("x1", "0")))) / this.scale, ((float) Math.round(Float.parseFloat(item.get("y1", "0")))) / this.scale, Marker.Type.Categorie, "");
            marker.removeable = false;
            drawMarker(marker, true);
        }
    }

    private Bitmap resizeBitmap(Bitmap bmp) {
        double scaleFactor;
        int imageWidth = bmp.getWidth();
        int imageHeight = bmp.getHeight();
        if (((double) imageWidth) / ((double) imageHeight) < 0.6666666666666666d) {
            scaleFactor = 90.0d / ((double) imageHeight);
        } else {
            scaleFactor = 60.0d / ((double) imageWidth);
        }
        return Bitmap.createScaledBitmap(bmp, (int) (((float) scaleFactor) * ((float) imageWidth)), (int) (((float) scaleFactor) * ((float) imageHeight)), true);
    }

    private void fillMarkerList() {
        List<TCObject> list;
        List<TCObject> list2;
        List<TCObject> list3;
        if (C1199DB.getSize("map") == 1) {
            list = C1199DB.getListFromDb(DBFavorites.TABLE_EXHIBITORS);
        } else {
            list = C1199DB.getListFromDb(DBFavorites.TABLE_EXHIBITORS, "mapid", this.mapid);
        }
        for (TCObject tco : list) {
            float x = ((float) Math.round(Float.parseFloat(tco.get("x1", "0")))) / this.scale;
            float y = ((float) Math.round(Float.parseFloat(tco.get("y1", "0")))) / this.scale;
            if (!(x == BitmapDescriptorFactory.HUE_RED || y == BitmapDescriptorFactory.HUE_RED)) {
                this.markers.add(new Marker(tco.get(DBFavorites.KEY_EVENT_ID), x, y, Marker.Type.Exhibitor, tco.get(DBFavorites.KEY_NAME)));
            }
        }
        if (C1199DB.getSize("map") == 1) {
            list2 = C1199DB.getListFromDb("map");
        } else {
            list2 = C1199DB.getListFromDb("map", "parentId", this.mapid);
        }
        for (TCObject tco2 : list2) {
            float x2 = ((float) Math.round(Float.parseFloat(tco2.get("x", "0")))) / this.scale;
            float y2 = ((float) Math.round(Float.parseFloat(tco2.get("y", "0")))) / this.scale;
            if (!(x2 == BitmapDescriptorFactory.HUE_RED || y2 == BitmapDescriptorFactory.HUE_RED)) {
                this.markers.add(new Marker(tco2.get(DBFavorites.KEY_EVENT_ID), x2, y2, Marker.Type.Map, tco2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)));
            }
        }
        if (C1199DB.getSize("map") == 1) {
            list3 = C1199DB.getListFromDb("sessions");
        } else {
            list3 = C1199DB.getListFromDb("sessions", "mapid", this.mapid);
        }
        for (TCObject tco3 : list3) {
            float x3 = ((float) Math.round(Float.parseFloat(tco3.get("xpos")))) / this.scale;
            float y3 = ((float) Math.round(Float.parseFloat(tco3.get("ypos")))) / this.scale;
            if (!(x3 == BitmapDescriptorFactory.HUE_RED || y3 == BitmapDescriptorFactory.HUE_RED)) {
                this.markers.add(new Marker(tco3.get(DBFavorites.KEY_EVENT_ID), x3, y3, Marker.Type.Session, tco3.get(DBFavorites.KEY_NAME)));
            }
        }
    }

    public void click(float x, float y) {
        this.handlingMapClick = true;
        if (this.markers.size() != 0) {
            float scale2 = getValue(0);
            Marker closest = null;
            Point clicked = new Point((int) ((x - getValue(2)) / scale2), (int) ((y - getValue(5)) / scale2));
            float distance = Float.MAX_VALUE;
            for (Marker marker : this.markers) {
                Point cur = new Point((int) marker.f2070x, (int) marker.f2071y);
                if (closest == null) {
                    closest = marker;
                    distance = distance(clicked, cur).floatValue();
                } else {
                    Float dis = distance(clicked, cur);
                    if (dis.floatValue() < distance) {
                        closest = marker;
                        distance = dis.floatValue();
                    }
                }
            }
            if (closest.type == Marker.Type.Map) {
                mapClick(closest);
            } else if (closest.type == Marker.Type.Session) {
                sessionClick(closest);
            } else if (closest.type == Marker.Type.Exhibitor) {
                exhibitorClick(closest);
            }
        }
    }

    public void mapClick(final Marker marker) {
        float scale2 = getValue(0);
        this.floorplan.zoomTo(this.floorplan.getMaxZoom(), (marker.f2070x * scale2) + getValue(2), (marker.f2071y * scale2) + getValue(5), 1000.0f);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Fragments.add(MapFragment.this, MapFragment.newInstance(marker.f2069id, MapFragment.this.checkedgroupid), marker.name);
                MapFragment.this.handlingMapClick = false;
            }
        }, 1000);
    }

    public void exhibitorClick(Marker marker) {
        this.handlingMapClick = false;
        clearMarkers();
        drawMarker(marker);
        centerMarker(marker);
        showLabel(marker.name);
        this.activemarker = marker;
    }

    public void sessionClick(Marker marker) {
        this.handlingMapClick = false;
        clearMarkers();
        drawMarker(marker);
        centerMarker(marker);
        new SessionDialog(getActivity(), marker).show();
        hideLabel();
    }

    public void drawMarker(Marker marker) {
        drawMarker(marker, false);
    }

    public void centerMarker(Marker marker) {
        float scale2 = getValue(0);
        float transX = getValue(2);
        float transY = getValue(5);
        int windowheight = this.floorplan.getMeasuredHeight();
        this.floorplan.scrollBy(((-(marker.f2070x * scale2)) + ((float) (this.floorplan.getMeasuredWidth() / 2))) - transX, ((-(marker.f2071y * scale2)) + ((float) (windowheight / 2))) - transY, 1000.0d);
        this.floorplan.invalidate();
    }

    public void drawMarker(Marker marker, boolean catalog) {
        drawMarker(marker, catalog, (View) null);
    }

    public void drawMarker(Marker marker, boolean catalog, View view) {
        Bitmap active;
        float scale2 = getValue(0);
        float transX = getValue(2);
        float transY = getValue(5);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-2, -2);
        if (view == null) {
            marker.view = new ImageView(getActivity());
            if (!catalog) {
                active = this.markerbmp;
            } else {
                active = this.catalogbmp;
            }
            ((ImageView) marker.view).setImageBitmap(active);
            ((ImageView) marker.view).setScaleType(ImageView.ScaleType.MATRIX);
            lp.setMargins((int) (((marker.f2070x * scale2) + transX) - ((float) (active.getWidth() / 2))), (int) (((marker.f2071y * scale2) + transY) - ((float) active.getHeight())), 0, 0);
        } else {
            int dp = (int) Converter.convertDpToPixel(20.0f, getActivity());
            marker.view = view;
            lp.setMargins((int) (((marker.f2070x * scale2) + transX) - ((float) (dp / 2))), (int) (((marker.f2071y * scale2) + transY) - ((float) (dp / 2))), 0, 0);
        }
        marker.view.setLayoutParams(lp);
        this.visiblemarkers.add(marker);
        this.markercontainer.addView(marker.view);
    }

    public void clearMarkers() {
        for (Marker marker : this.visiblemarkers) {
            if (marker.view != null && marker.removeable) {
                this.markercontainer.removeView(marker.view);
                marker.view = null;
            }
        }
    }

    public void showLabel(String text) {
        TextView name = (TextView) this.f2064v.findViewById(C0846R.C0847id.markername);
        name.setText(String.valueOf(text) + " >");
        if (name.getVisibility() == 8) {
            TranslateAnimation slide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -120.0f, BitmapDescriptorFactory.HUE_RED);
            slide.setDuration(500);
            name.setVisibility(0);
            name.setAnimation(slide);
        }
    }

    public void hideLabel() {
        TextView name = (TextView) this.f2064v.findViewById(C0846R.C0847id.markername);
        if (name.getVisibility() == 0) {
            TranslateAnimation slide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -200.0f);
            slide.setDuration(750);
            name.setVisibility(0);
            name.setAnimation(slide);
        }
    }

    private static class Marker {

        /* renamed from: id */
        public String f2069id;
        public String name;
        public boolean removeable = true;
        public Type type;
        public View view;

        /* renamed from: x */
        public float f2070x;

        /* renamed from: y */
        public float f2071y;

        public enum Type {
            SubCategorie,
            Categorie,
            Exhibitor,
            Map,
            Session
        }

        public Marker(String id, float x, float y, Type type2, String name2) {
            this.f2069id = id;
            this.f2070x = x;
            this.f2071y = y;
            this.type = type2;
            this.name = name2;
        }
    }

    public void updateMarkers() {
        float f;
        int height;
        float scale2 = getValue(0);
        float transX = getValue(2);
        float transY = getValue(5);
        for (Marker marker : this.visiblemarkers) {
            if (marker.view != null) {
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) marker.view.getLayoutParams();
                float x = ((marker.f2070x * scale2) + transX) - ((float) (marker.view.getWidth() / 2));
                if (marker.type == Marker.Type.SubCategorie) {
                    f = (marker.f2071y * scale2) + transY;
                    height = marker.view.getHeight() / 2;
                } else {
                    f = (marker.f2071y * scale2) + transY;
                    height = marker.view.getHeight();
                }
                lp.setMargins((int) x, (int) (f - ((float) height)), 0, 0);
                marker.view.setLayoutParams(lp);
            }
        }
    }

    public Float distance(Point a, Point b) {
        int x = a.x - b.x;
        int y = a.y - b.y;
        return Float.valueOf(FloatMath.sqrt((float) ((x * x) + (y * y))));
    }

    /* access modifiers changed from: protected */
    public float getValue(int whichValue) {
        float[] mMatrixValues = new float[9];
        if (this.matrix == null) {
            this.matrix = this.floorplan.getImageMatrix();
        }
        this.matrix.getValues(mMatrixValues);
        return mMatrixValues[whichValue];
    }

    public void onMatrixChanged(Matrix matrix2) {
        boolean changed = this.matrix == matrix2;
        this.matrix = matrix2;
        if (changed) {
            updateMarkers();
        }
    }

    public void onClick(View v) {
        if (this.activemarker != null && this.activemarker.type == Marker.Type.Exhibitor) {
            Fragments.add(this, ExhibitorDetailFragment.newInstance(this.activemarker.f2069id), getResourceString(C0846R.string.detail));
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                MapFragment.this.updateMarkers();
            }
        }, 250);
        super.onConfigurationChanged(newConfig);
    }

    private class SessionDialog extends Dialog implements AdapterView.OnItemClickListener {
        View.OnClickListener close = new View.OnClickListener() {
            public void onClick(View v) {
                SessionDialog.this.dismiss();
            }
        };
        Marker marker;

        public SessionDialog(Context context, Marker marker2) {
            super(context);
            this.marker = marker2;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0178  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x018a  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x018c A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCreate(android.os.Bundle r24) {
            /*
                r23 = this;
                super.onCreate(r24)
                r2 = 1
                r0 = r23
                r0.requestWindowFeature(r2)
                android.view.LayoutInflater r2 = r23.getLayoutInflater()
                r3 = 2130903212(0x7f0300ac, float:1.7413236E38)
                r4 = 0
                android.view.View r21 = r2.inflate(r3, r4)
                java.lang.String r2 = "backgroundColor"
                int r2 = com.tapcrowd.app.utils.C1216LO.getLo(r2)
                r0 = r21
                r0.setBackgroundColor(r2)
                java.lang.String r14 = ""
                java.lang.String r2 = com.tapcrowd.app.utils.App.typeid
                java.lang.String r3 = "10"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L_0x00e2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "SELECT sessions.*, sessiongroups.name AS sgname FROM sessions JOIN sessiongroups ON sessions.sessiongroupid = sessiongroups.id WHERE sessions.location = (SELECT location FROM sessions WHERE id = '"
                r2.<init>(r3)
                r0 = r23
                com.tapcrowd.app.modules.map.MapFragment$Marker r3 = r0.marker
                java.lang.String r3 = r3.f2069id
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r3 = "') "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r3 = "ORDER BY sessiongroups.order_value DESC, sessions.date, sessions.starttime;"
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r14 = r2.toString()
            L_0x004d:
                java.util.List r18 = com.tapcrowd.app.utils.C1199DB.getQueryFromDb(r14)
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                java.util.Iterator r22 = r18.iterator()
            L_0x005a:
                boolean r2 = r22.hasNext()
                if (r2 != 0) goto L_0x0105
                r2 = 2131362017(0x7f0a00e1, float:1.8343803E38)
                r0 = r21
                android.view.View r13 = r0.findViewById(r2)
                android.widget.ListView r13 = (android.widget.ListView) r13
                com.tapcrowd.app.utils.TCListObject$TCListObjectAdapter r8 = new com.tapcrowd.app.utils.TCListObject$TCListObjectAdapter
                r2 = 0
                r3 = 0
                r8.<init>((java.util.List) r11, (int) r2, (boolean) r3)
                r2 = 2130903101(0x7f03003d, float:1.741301E38)
                r8.setLayout(r2)
                r13.setAdapter(r8)
                r0 = r23
                r13.setOnItemClickListener(r0)
                r2 = 2131362212(0x7f0a01a4, float:1.8344198E38)
                r0 = r21
                android.view.View r2 = r0.findViewById(r2)
                r0 = r23
                android.view.View$OnClickListener r3 = r0.close
                r2.setOnClickListener(r3)
                r2 = 0
                r0 = r18
                java.lang.Object r2 = r0.get(r2)
                com.tapcrowd.app.utils.TCObject r2 = (com.tapcrowd.app.utils.TCObject) r2
                java.lang.String r3 = "location"
                r0 = r23
                com.tapcrowd.app.modules.map.MapFragment$Marker r4 = r0.marker
                java.lang.String r4 = r4.name
                java.lang.String r12 = r2.get((java.lang.String) r3, (java.lang.String) r4)
                r2 = 2131361859(0x7f0a0043, float:1.8343482E38)
                r0 = r21
                android.view.View r2 = r0.findViewById(r2)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r2.setText(r12)
                r2 = 2131361859(0x7f0a0043, float:1.8343482E38)
                r0 = r21
                android.view.View r2 = r0.findViewById(r2)
                android.widget.TextView r2 = (android.widget.TextView) r2
                java.lang.String r3 = "textcolor"
                int r3 = com.tapcrowd.app.utils.C1216LO.getLo(r3)
                r2.setTextColor(r3)
                r2 = 2130837851(0x7f02015b, float:1.7280668E38)
                java.lang.String r3 = "seperatorBackgroundColor"
                int r3 = com.tapcrowd.app.utils.C1216LO.getLo(r3)
                com.tapcrowd.app.utils.C1232UI.getColorOverlay((int) r2, (int) r3)
                android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
                r3 = -1
                r4 = -1
                r2.<init>(r3, r4)
                r0 = r23
                r1 = r21
                r0.addContentView(r1, r2)
                return
            L_0x00e2:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "SELECT sessions.*, sessiongroups.name AS sgname FROM sessions JOIN sessiongroups ON sessions.sessiongroupid = sessiongroups.id WHERE sessions.location = (SELECT location FROM sessions WHERE id = '"
                r2.<init>(r3)
                r0 = r23
                com.tapcrowd.app.modules.map.MapFragment$Marker r3 = r0.marker
                java.lang.String r3 = r3.f2069id
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r3 = "') "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r3 = "ORDER BY sessions.date, sessions.starttime;"
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r14 = r2.toString()
                goto L_0x004d
            L_0x0105:
                java.lang.Object r17 = r22.next()
                com.tapcrowd.app.utils.TCObject r17 = (com.tapcrowd.app.utils.TCObject) r17
                java.text.SimpleDateFormat r16 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ea }
                java.lang.String r2 = "dd/MM/yyyy"
                r0 = r16
                r0.<init>(r2)     // Catch:{ Exception -> 0x01ea }
                java.lang.String r2 = "date"
                r0 = r17
                java.lang.String r2 = r0.get(r2)     // Catch:{ Exception -> 0x01ea }
                r0 = r16
                java.util.Date r9 = r0.parse(r2)     // Catch:{ Exception -> 0x01ea }
                android.app.Activity r2 = com.tapcrowd.app.utils.App.act     // Catch:{ Exception -> 0x01ea }
                java.text.DateFormat r2 = android.text.format.DateFormat.getLongDateFormat(r2)     // Catch:{ Exception -> 0x01ea }
                java.lang.String r15 = r2.format(r9)     // Catch:{ Exception -> 0x01ea }
                java.lang.String r2 = com.tapcrowd.app.utils.App.typeid     // Catch:{ Exception -> 0x01ea }
                java.lang.String r3 = "10"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01ea }
                if (r2 == 0) goto L_0x01d5
                java.lang.String r2 = "sgname"
                r0 = r17
                java.lang.String r2 = r0.get(r2)     // Catch:{ Exception -> 0x01ea }
                boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x01ea }
                if (r2 != 0) goto L_0x01d5
                java.lang.String r2 = "sgname"
                r0 = r17
                java.lang.String r2 = r0.get(r2)     // Catch:{ Exception -> 0x01ea }
                r11.add(r2)     // Catch:{ Exception -> 0x01ea }
            L_0x014f:
                java.lang.String r6 = ""
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "SELECT name FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid WHERE speaker_session.sessionid == '"
                r2.<init>(r3)
                java.lang.String r3 = "id"
                r0 = r17
                java.lang.String r3 = r0.get(r3)
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r3 = "';"
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.util.List r20 = com.tapcrowd.app.utils.C1199DB.getQueryFromDb(r2)
                int r2 = r20.size()
                if (r2 <= 0) goto L_0x0182
                java.util.Iterator r2 = r20.iterator()
            L_0x017c:
                boolean r3 = r2.hasNext()
                if (r3 != 0) goto L_0x01f0
            L_0x0182:
                java.lang.String r2 = ""
                boolean r2 = r6.equals(r2)
                if (r2 == 0) goto L_0x018c
                java.lang.String r6 = "   "
            L_0x018c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "starttime"
                r0 = r17
                java.lang.String r3 = r0.get(r3)
                java.lang.String r3 = java.lang.String.valueOf(r3)
                r2.<init>(r3)
                java.lang.String r3 = " - "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r3 = "endtime"
                r0 = r17
                java.lang.String r3 = r0.get(r3)
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r5 = r2.toString()
                com.tapcrowd.app.utils.TCListObject r2 = new com.tapcrowd.app.utils.TCListObject
                java.lang.String r3 = "id"
                r0 = r17
                java.lang.String r3 = r0.get(r3)
                java.lang.String r4 = "name"
                r0 = r17
                java.lang.String r4 = r0.get(r4)
                java.lang.String r7 = "imageurl"
                r0 = r17
                java.lang.String r7 = r0.get(r7)
                r2.<init>(r3, r4, r5, r6, r7)
                r11.add(r2)
                goto L_0x005a
            L_0x01d5:
                java.lang.String r2 = com.tapcrowd.app.utils.App.typeid     // Catch:{ Exception -> 0x01ea }
                java.lang.String r3 = "10"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01ea }
                if (r2 != 0) goto L_0x014f
                boolean r2 = r11.contains(r15)     // Catch:{ Exception -> 0x01ea }
                if (r2 != 0) goto L_0x014f
                r11.add(r15)     // Catch:{ Exception -> 0x01ea }
                goto L_0x014f
            L_0x01ea:
                r10 = move-exception
                r10.printStackTrace()
                goto L_0x014f
            L_0x01f0:
                java.lang.Object r19 = r2.next()
                com.tapcrowd.app.utils.TCObject r19 = (com.tapcrowd.app.utils.TCObject) r19
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = java.lang.String.valueOf(r6)
                r3.<init>(r4)
                java.lang.String r4 = "name"
                r0 = r19
                java.lang.String r4 = r0.get(r4)
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r6 = r3.toString()
                int r3 = r20.size()
                int r3 = r3 + -1
                r0 = r20
                java.lang.Object r3 = r0.get(r3)
                r0 = r19
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x017c
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = java.lang.String.valueOf(r6)
                r3.<init>(r4)
                java.lang.String r4 = ", "
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r6 = r3.toString()
                goto L_0x017c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.map.MapFragment.SessionDialog.onCreate(android.os.Bundle):void");
        }

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Object o = arg0.getItemAtPosition(arg2);
            if (o.getClass() == TCListObject.class) {
                TCListObject tco = (TCListObject) o;
                if (App.typeid.equals("10")) {
                    Fragments.add(MapFragment.this, FestivalSessionDetailFragment.newInstance(tco.getId()), MapFragment.this.getResourceString(C0846R.string.detail));
                } else {
                    Fragments.add(MapFragment.this, SessionDetailFragment.newInstance(tco.getId()), MapFragment.this.getResourceString(C0846R.string.detail));
                }
                dismiss();
            }
        }
    }
}
