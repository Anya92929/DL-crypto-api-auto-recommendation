package com.tapcrowd.app.modules.map;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES10;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorPickerFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.filter.FilterFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.PathDrawer;
import com.tapcrowd.app.views.imageviewtouch.ImageViewTouch;
import com.tapcrowd.app.views.imageviewtouch.ImageViewTouchBase;
import com.tapcrowd.app.views.imageviewtouch.utils.FastBitmapDrawable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.cordova.Globalization;

public class MapV2Fragment extends TCFragment implements ImageViewTouchBase.OnMatrixChangedListener, View.OnClickListener, MenuFragment.MenuItemListener, ImageViewTouchBase.OnZoomChangedListener {
    private Marker aPoint;
    private Marker activemarker;
    private int[] allZoomlevels;
    private Marker bPoint;
    private Bitmap catalogbmp;
    private Dijkstra dijkstra;
    private Vertex endPoint;
    private final int endPointPickerRequest = 523;
    private Bitmap favoritebmp;
    View.OnClickListener filter = new View.OnClickListener() {
        public void onClick(View v) {
            List<TCObject> groups = C1199DB.getQueryFromDb("SELECT name FROM groups WHERE id IN (SELECT groupid FROM groupitems INNER JOIN exhibitors ON groupitems.itemid == exhibitors.id WHERE itemtable == 'exhibitor' AND x1 != '0' AND y1 != '0')");
            ArrayList<String> categories = new ArrayList<>();
            for (TCObject group : groups) {
                categories.add(group.get(DBFavorites.KEY_NAME));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("null", categories);
            Fragments.add(MapV2Fragment.this, FilterFragment.newInstance(intent, (ArrayList<String>) null, MapV2Fragment.this.listener), MapV2Fragment.this.getString(C0846R.string.categorieen));
        }
    };
    /* access modifiers changed from: private */
    public ImageViewTouch floorplan;
    /* access modifiers changed from: private */
    public String groupid;
    /* access modifiers changed from: private */
    public boolean handlingMapClick;
    OnFragmentResultListener listener = new OnFragmentResultListener() {
        public void onFragmentResult(Intent data, int requestCode, int resultCode) {
            ArrayList<String> results = data.getStringArrayListExtra(FilterFragment.RESULTS);
            for (Marker marker : MapV2Fragment.this.visiblemarkers) {
                if (marker.img != null && !marker.removeable) {
                    MapV2Fragment.this.markercontainer.removeView(marker.img);
                    marker.img = null;
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
                for (TCObject group : C1199DB.getQueryFromDb(String.valueOf(query) + ";")) {
                    MapV2Fragment.this.showCategories(group.get(DBFavorites.KEY_EVENT_ID));
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public TCObject map;
    /* access modifiers changed from: private */
    public String mapid;
    private Bitmap markerbmp;
    /* access modifiers changed from: private */
    public ViewGroup markercontainer;
    private List<Marker> markers = new ArrayList();
    private Matrix matrix;
    /* access modifiers changed from: private */
    public MenuFragment menu;
    private boolean noMap;

    /* renamed from: pd */
    private PathDrawer f2072pd;
    private boolean retained;
    private Bitmap routeAbmp;
    private Bitmap routeBbmp;
    /* access modifiers changed from: private */
    public float scale = 1.0f;
    private Vertex startPoint;
    private final int startPointPickerRequest = 124;
    /* access modifiers changed from: private */
    public int touchSlop;
    private View.OnTouchListener touchlistener = new View.OnTouchListener() {

        /* renamed from: x */
        float f2076x;

        /* renamed from: y */
        float f2077y;

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                this.f2076x = event.getX();
                this.f2077y = event.getY();
            }
            if (action != 3 && action != 1) {
                return false;
            }
            float newX = event.getX();
            float newY = event.getY();
            if (((int) Math.sqrt((double) (((newX - this.f2076x) * (newX - this.f2076x)) + ((newY - this.f2077y) * (newY - this.f2077y))))) > MapV2Fragment.this.touchSlop || MapV2Fragment.this.handlingMapClick) {
                return false;
            }
            MapV2Fragment.this.click(newX, newY);
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View f2073v;
    /* access modifiers changed from: private */
    public List<Marker> visiblemarkers = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: x */
    public float f2074x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public float f2075y;
    private int zoomlevel;

    public static MapV2Fragment newInstance() {
        MapV2Fragment detail = new MapV2Fragment();
        if (C1199DB.getSize("mapv2") >= 1) {
            detail.map = C1199DB.getFirstObject("mapv2", "zoomlevel +0 ASC");
            detail.mapid = detail.map.get("mapid");
        }
        return detail;
    }

    public static MapV2Fragment newInstance(String mapid2) {
        MapV2Fragment detail = new MapV2Fragment();
        detail.map = C1199DB.getObject("mapv2", "mapid", mapid2);
        detail.mapid = mapid2;
        return detail;
    }

    public static MapV2Fragment newInstance(String mapid2, float x, float y) {
        MapV2Fragment detail = new MapV2Fragment();
        detail.map = C1199DB.getObject("mapv2", "mapid", mapid2);
        detail.mapid = mapid2;
        detail.f2074x = x;
        detail.f2075y = y;
        return detail;
    }

    public static MapV2Fragment newInstance(String mapid2, String groupid2) {
        MapV2Fragment detail = new MapV2Fragment();
        detail.map = C1199DB.getObject("mapv2", "mapid", mapid2);
        detail.mapid = detail.map.get("mapid");
        detail.groupid = groupid2;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mapid", this.mapid);
        outState.putFloat("x", this.f2074x);
        outState.putFloat("y", this.f2075y);
        outState.putString("groupid", this.groupid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AdHelper.showAds(this, AdHelper.buildPath("72", "map", (String) null));
        C1232UI.show(C0846R.C0847id.titloader);
        if (this.f2073v == null) {
            this.f2073v = inflater.inflate(C0846R.layout.floorplanv2, container, false);
            if (savedInstanceState != null && this.map == null) {
                this.mapid = savedInstanceState.getString("mapid");
                this.f2074x = savedInstanceState.getFloat("x");
                this.f2075y = savedInstanceState.getFloat("y");
                this.groupid = savedInstanceState.getString("groupid");
                if (this.mapid != null) {
                    this.map = C1199DB.getFirstObject("mapv2", "mapid", this.mapid);
                }
            }
            this.markercontainer = (ViewGroup) this.f2073v.findViewById(C0846R.C0847id.markerscontainer);
            this.floorplan = (ImageViewTouch) this.f2073v.findViewById(C0846R.C0847id.floorplan);
            this.f2072pd = (PathDrawer) this.f2073v.findViewById(C0846R.C0847id.routingoverlay);
            if (C1216LO.getLoDrawable(C1216LO.navigationMarker) != null) {
                this.markerbmp = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navigationMarker)).getBitmap();
            } else {
                this.markerbmp = ((BitmapDrawable) getResources().getDrawable(C0846R.drawable.pin_blanco)).getBitmap();
            }
            this.markerbmp = resizeBitmap(this.markerbmp);
            this.catalogbmp = ((BitmapDrawable) getResources().getDrawable(C0846R.drawable.catalogmarker)).getBitmap();
            this.catalogbmp = resizeBitmap(this.catalogbmp);
            this.routeAbmp = ((BitmapDrawable) getResources().getDrawable(C0846R.drawable.pin_a)).getBitmap();
            this.routeAbmp = resizeBitmap(this.routeAbmp);
            this.routeBbmp = ((BitmapDrawable) getResources().getDrawable(C0846R.drawable.pin_b)).getBitmap();
            this.routeBbmp = resizeBitmap(this.routeBbmp);
            this.favoritebmp = ((BitmapDrawable) getResources().getDrawable(C0846R.drawable.floorplan_favorite)).getBitmap();
            this.favoritebmp = resizeBitmap(this.favoritebmp);
            this.touchSlop = ViewConfiguration.get(getActivity()).getScaledTouchSlop();
            if (C1199DB.getSize("indoor_routing_points") == 0 || C1199DB.getSize("indoor_routing_paths") == 0) {
                this.f2073v.findViewById(C0846R.C0847id.openNavigate).setVisibility(8);
            }
            this.f2073v.findViewById(C0846R.C0847id.openNavigate).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapV2Fragment.this.toggleNavigationBar();
                }
            });
            this.f2073v.findViewById(C0846R.C0847id.tvEnd).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapV2Fragment.this.pickMarker(523);
                }
            });
            this.f2073v.findViewById(C0846R.C0847id.tvStart).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapV2Fragment.this.pickMarker(124);
                }
            });
            this.f2073v.findViewById(C0846R.C0847id.ivRemoveEnd).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapV2Fragment.this.emptyEnd();
                }
            });
            this.f2073v.findViewById(C0846R.C0847id.ivRemoveStart).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapV2Fragment.this.emptyStart();
                }
            });
            this.f2073v.findViewById(C0846R.C0847id.btnNavigate).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapV2Fragment.this.berekenroute();
                }
            });
            this.f2073v.findViewById(C0846R.C0847id.markername).setOnClickListener(this);
            this.f2073v.findViewById(C0846R.C0847id.openSearch).setOnClickListener(this.filter);
            if (C1199DB.getSize("mapv2") == 0) {
                C1232UI.show(C0846R.C0847id.nomap, this.f2073v);
                this.noMap = true;
                return this.f2073v;
            } else if (this.map == null) {
                C1232UI.show(C0846R.C0847id.nomap, this.f2073v);
                this.noMap = true;
                return this.f2073v;
            } else {
                this.mapid = this.map.get("mapid", "0");
                this.zoomlevel = Integer.parseInt(this.map.get("zoomlevel"));
                this.allZoomlevels = populateZoomlevels();
                this.floorplan.setDoubleTapEnabled(false);
                this.floorplan.setOnMatrixChangedListener(this);
                this.floorplan.setOnZoomChangedListener(this);
                Bitmap bmp = getMap(this.map);
                this.f2072pd.setinitScale(this.scale);
                if (bmp == null) {
                    C1232UI.show(C0846R.C0847id.nomap, this.f2073v);
                    this.noMap = true;
                    return this.f2073v;
                }
                this.floorplan.setImageDrawable(new FastBitmapDrawable(bmp));
                this.matrix = this.floorplan.getImageViewMatrix();
                this.floorplan.setBackgroundColor(bmp.getPixel(0, 0));
                this.f2073v.findViewById(C0846R.C0847id.relBottomBar).setBackgroundColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
                ((TextView) this.f2073v.findViewById(C0846R.C0847id.openSearch)).setTextColor(C1216LO.getLo(C1216LO.actionbarContentColor));
                ((TextView) this.f2073v.findViewById(C0846R.C0847id.openNavigate)).setTextColor(C1216LO.getLo(C1216LO.actionbarContentColor));
                if (C1199DB.getQueryFromDb("SELECT name FROM groups WHERE id IN (SELECT groupid FROM groupitems INNER JOIN exhibitors ON groupitems.itemid == exhibitors.id WHERE itemtable == 'exhibitor' AND x1 != '0' AND y1 != '0')").size() == 0) {
                    this.f2073v.findViewById(C0846R.C0847id.openSearch).setVisibility(8);
                }
                return this.f2073v;
            }
        } else {
            ((ViewGroup) this.f2073v.getParent()).removeView(this.f2073v);
            this.retained = true;
            return this.f2073v;
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.noMap) {
            if (!this.retained || getFavorites().isEmpty()) {
                this.floorplan.setOnTouchListener(this.touchlistener);
                new backgroundworker(this, (backgroundworker) null).execute(new Void[0]);
                if (this.map.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) && !App.tablet) {
                    String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
                    if (color.length() == 8) {
                        color = color.substring(2);
                    }
                    getSherlockActivity().getSupportActionBar().setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + this.map.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) + "</font>"));
                    return;
                }
                return;
            }
            ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.show_favorites48_white, C1216LO.getLo(C1216LO.navigationColor)), 1));
            this.menu = MenuFragment.newInstance(menuitems, this);
            Fragments.addMenu(this, this.menu);
        }
    }

    private class backgroundworker extends AsyncTask<Void, Void, Void> {
        private boolean hasExhiWithRoute;
        private boolean hasFavorites;

        private backgroundworker() {
            this.hasExhiWithRoute = false;
            this.hasFavorites = false;
        }

        /* synthetic */ backgroundworker(MapV2Fragment mapV2Fragment, backgroundworker backgroundworker) {
            this();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... arg0) {
            boolean z = true;
            MapV2Fragment.this.startupDijkstra();
            MapV2Fragment.this.fillMarkerList();
            Iterator<TCObject> it = C1199DB.getQueryFromDb("SELECT id, booth, name, image_large, x1, y1 FROM exhibitors ORDER BY name COLLATE LOCALIZED").iterator();
            while (true) {
                if (it.hasNext()) {
                    if (hasARoute(it.next())) {
                        this.hasExhiWithRoute = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (MapV2Fragment.this.getFavorites().isEmpty()) {
                z = false;
            }
            this.hasFavorites = z;
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            C1232UI.show(C0846R.C0847id.relBottomBar, MapV2Fragment.this.f2073v);
            ((ImageView) MapV2Fragment.this.f2073v.findViewById(C0846R.C0847id.btnNavigate)).setBackgroundColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
            if (this.hasFavorites) {
                ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
                menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.show_favorites48_white, C1216LO.getLo(C1216LO.navigationColor)), 1));
                MapV2Fragment.this.menu = MenuFragment.newInstance(menuitems, MapV2Fragment.this);
                Fragments.addMenu(MapV2Fragment.this, MapV2Fragment.this.menu);
            }
            MapV2Fragment.this.floorplan.post(new Runnable() {
                public void run() {
                    if (!(MapV2Fragment.this.f2074x == BitmapDescriptorFactory.HUE_RED || MapV2Fragment.this.f2075y == BitmapDescriptorFactory.HUE_RED)) {
                        float scale = MapV2Fragment.this.getValue(0);
                        float transX = MapV2Fragment.this.getValue(2);
                        float transY = MapV2Fragment.this.getValue(5);
                        MapV2Fragment.this.click(((Float.valueOf(MapV2Fragment.this.f2074x).floatValue() / MapV2Fragment.this.scale) * scale) + transX, ((Float.valueOf(MapV2Fragment.this.f2075y).floatValue() / MapV2Fragment.this.scale) * scale) + transY);
                    }
                    if (MapV2Fragment.this.groupid != null) {
                        MapV2Fragment.this.showCategories();
                    }
                }
            });
        }

        public boolean hasARoute(TCObject tco) {
            new ArrayList();
            int rectWidth = (int) (((double) Integer.parseInt(MapV2Fragment.this.map.get("width"))) * 0.05d);
            int rectHeight = (int) (((double) Integer.parseInt(MapV2Fragment.this.map.get("height"))) * 0.05d);
            Point point = new Point((int) Float.parseFloat(tco.get("x1")), (int) Float.parseFloat(tco.get("y1")));
            if (C1199DB.getListFromDb("indoor_routing_points", "'1'", "1' AND x+0 BETWEEN " + (point.x - rectWidth) + " AND " + (point.x + rectWidth) + " AND y+0 BETWEEN " + (point.y - rectHeight) + " AND " + (point.y + rectHeight) + " AND mapid =='" + MapV2Fragment.this.mapid).isEmpty()) {
                return false;
            }
            return true;
        }
    }

    private int[] populateZoomlevels() {
        List<Object> maps = TCDBHelper.getTCListFromDb("SELECT id, zoomlevel FROM mapv2 ORDER BY zoomlevel+0 ASC;", new TCDBHelper.TCListHelperObject("zoomlevel", (String) null, (String) null), false);
        int[] zooms = new int[maps.size()];
        for (int i = 0; i < maps.size(); i++) {
            zooms[i] = Integer.parseInt(((TCListObject) maps.get(i)).getText());
        }
        return zooms;
    }

    private Bitmap getMap(TCObject map2) {
        int windowwidth;
        Drawable draw = this.floorplan.getDrawable();
        if (draw != null && (draw instanceof FastBitmapDrawable)) {
            ((FastBitmapDrawable) draw).getBitmap().recycle();
            System.gc();
        }
        int[] maxsizeA = new int[1];
        GLES10.glGetIntegerv(3379, maxsizeA, 0);
        int maxsize = maxsizeA[0] / 2;
        int inSampleSize = 1;
        float imgwidth = (float) Math.round(Float.parseFloat(map2.get("width")));
        float imgheight = (float) Math.round(Float.parseFloat(map2.get("height")));
        if (maxsize == 0) {
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
        } else if (imgwidth > ((float) maxsize) || imgheight > ((float) maxsize)) {
            inSampleSize = imgwidth > imgheight ? (int) Math.ceil((double) (imgwidth / ((float) maxsize))) : (int) Math.ceil((double) (imgheight / ((float) maxsize)));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        System.gc();
        FastImageLoader fil = new FastImageLoader();
        String url = map2.get("imageurl");
        if (url.startsWith("http://upload.tapcrowd.com/")) {
            url = "http://stream.tapcrowd1.netdna-cdn.com/original/" + url.substring("http://upload.tapcrowd.com/".length());
        }
        Bitmap mapbmp = BitmapFactory.decodeFile(fil.getPath(url), options);
        this.scale = imgheight / ((float) mapbmp.getHeight());
        if (this.scale == BitmapDescriptorFactory.HUE_RED) {
            this.scale = 1.0f;
        }
        return mapbmp;
    }

    /* access modifiers changed from: private */
    public void showCategories() {
        showCategories(this.groupid);
    }

    /* access modifiers changed from: private */
    public void showCategories(String groupid2) {
        List<TCObject> items = new ArrayList<>();
        if (groupid2 != null) {
            items = C1199DB.getQueryFromDb("SELECT * FROM groupitems INNER JOIN exhibitors ON exhibitors.id == groupitems.itemid WHERE exhibitors.mapid == '" + this.mapid + "' AND groupid == '" + groupid2 + "'");
        }
        for (TCObject item : items) {
            Marker marker = new Marker("", ((float) Math.round(Float.parseFloat(item.get("x1", "0")))) / this.scale, ((float) Math.round(Float.parseFloat(item.get("y1", "0")))) / this.scale, "", "");
            marker.removeable = false;
            drawMarker(marker, this.catalogbmp);
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

    /* access modifiers changed from: private */
    public void fillMarkerList() {
        List<TCObject> list;
        List<TCObject> list2;
        if (C1199DB.getSize("mapv2") == 1) {
            list = C1199DB.getListFromDb(DBFavorites.TABLE_EXHIBITORS);
        } else {
            list = C1199DB.getListFromDb(DBFavorites.TABLE_EXHIBITORS, "mapid", this.mapid);
        }
        for (TCObject tco : list) {
            float x = ((float) Math.round(Float.parseFloat(tco.get("x1", "0")))) / this.scale;
            float y = ((float) Math.round(Float.parseFloat(tco.get("y1", "0")))) / this.scale;
            if (!(x == BitmapDescriptorFactory.HUE_RED || y == BitmapDescriptorFactory.HUE_RED)) {
                this.markers.add(new Marker(tco.get(DBFavorites.KEY_EVENT_ID), x, y, LinkedObjects.TABLE_EXHI, tco.get(DBFavorites.KEY_NAME)));
            }
        }
        if (C1199DB.getSize("mapv2") == 1) {
            list2 = C1199DB.getListFromDb("sessions");
        } else {
            list2 = C1199DB.getListFromDb("sessions", "mapid", this.mapid);
        }
        for (TCObject tco2 : list2) {
            float x2 = ((float) Math.round(Float.parseFloat(tco2.get("xpos")))) / this.scale;
            float y2 = ((float) Math.round(Float.parseFloat(tco2.get("ypos")))) / this.scale;
            if (!(x2 == BitmapDescriptorFactory.HUE_RED || y2 == BitmapDescriptorFactory.HUE_RED)) {
                this.markers.add(new Marker(tco2.get(DBFavorites.KEY_EVENT_ID), x2, y2, "session", tco2.get(DBFavorites.KEY_NAME)));
            }
        }
    }

    /* access modifiers changed from: private */
    public void click(float x, float y) {
        this.handlingMapClick = true;
        hideRoutePicker();
        if (this.markers.size() != 0) {
            float scale2 = getValue(0);
            Marker closest = null;
            Point clicked = new Point((int) ((x - getValue(2)) / scale2), (int) ((y - getValue(5)) / scale2));
            float distance = Float.MAX_VALUE;
            for (Marker marker : this.markers) {
                Point cur = new Point((int) marker.f2080x, (int) marker.f2081y);
                if (closest == null) {
                    closest = marker;
                    distance = distance(clicked, cur);
                } else {
                    Float dis = Float.valueOf(distance(clicked, cur));
                    if (dis.floatValue() < distance) {
                        closest = marker;
                        distance = dis.floatValue();
                    }
                }
            }
            if (closest.type.equals("map")) {
                mapClick(closest);
            } else if (closest.type.equals("session")) {
                sessionClick(closest);
            } else if (closest.type.equals(LinkedObjects.TABLE_EXHI)) {
                exhibitorClick(closest);
            }
        }
    }

    public void mapClick(final Marker marker) {
        float scale2 = getValue(0);
        this.floorplan.zoomTo(this.floorplan.getMaxZoom(), (marker.f2080x * scale2) + getValue(2), (marker.f2081y * scale2) + getValue(5), 1000.0f);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Fragments.add(MapV2Fragment.this, MapV2Fragment.newInstance(marker.f2079id), marker.name);
                MapV2Fragment.this.handlingMapClick = false;
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

    public void centerMarker(Marker marker) {
        float scale2 = getValue(0);
        float transX = getValue(2);
        float transY = getValue(5);
        int windowheight = this.floorplan.getMeasuredHeight();
        this.floorplan.scrollBy(((-(marker.f2080x * scale2)) + ((float) (this.floorplan.getMeasuredWidth() / 2))) - transX, ((-(marker.f2081y * scale2)) + ((float) (windowheight / 2))) - transY, 1000.0d);
        this.floorplan.invalidate();
        this.f2072pd.setPath((List<Vertex>) null);
    }

    public void clearMarkers() {
        for (Marker marker : this.visiblemarkers) {
            if (marker.img != null && marker.removeable) {
                this.markercontainer.removeView(marker.img);
                marker.img = null;
            }
        }
    }

    public void showLabel(String text) {
        TextView name = (TextView) this.f2073v.findViewById(C0846R.C0847id.markername);
        name.setText(String.valueOf(text) + " >");
        if (name.getVisibility() == 8) {
            TranslateAnimation slide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -120.0f, BitmapDescriptorFactory.HUE_RED);
            slide.setDuration(500);
            name.setVisibility(0);
            name.setAnimation(slide);
        }
    }

    public void hideLabel() {
        TextView name = (TextView) this.f2073v.findViewById(C0846R.C0847id.markername);
        if (name.getVisibility() == 0) {
            TranslateAnimation slide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -200.0f);
            slide.setDuration(750);
            name.setVisibility(8);
            name.setAnimation(slide);
        }
    }

    public void updateMarkers() {
        float scale2 = getValue(0);
        float transX = getValue(2);
        float transY = getValue(5);
        for (Marker marker : this.visiblemarkers) {
            if (marker.img != null) {
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) marker.img.getLayoutParams();
                lp.setMargins((int) (((marker.f2080x * scale2) + transX) - ((float) (marker.img.getWidth() / 2))), (int) (((marker.f2081y * scale2) + transY) - ((float) marker.img.getHeight())), 0, 0);
                marker.img.setLayoutParams(lp);
            }
        }
    }

    public float distance(Point a, Point b) {
        int x = a.x - b.x;
        int y = a.y - b.y;
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* access modifiers changed from: protected */
    public float getValue(int whichValue) {
        float[] mMatrixValues = new float[9];
        this.matrix.getValues(mMatrixValues);
        return mMatrixValues[whichValue];
    }

    public void onMatrixChanged(Matrix matrix2) {
        boolean changed = this.matrix == matrix2;
        this.matrix = matrix2;
        if (changed) {
            updateMarkers();
            updatePath();
        }
    }

    public void onClick(View v) {
        if (this.activemarker != null && this.activemarker.type.equals(LinkedObjects.TABLE_EXHI)) {
            Fragments.add(this, ExhibitorDetailFragment.newInstance(this.activemarker.f2079id), getResourceString(C0846R.string.detail));
        }
    }

    public void click(MenuItem item) {
        if (item.getItemId() == 1) {
            showFavorites();
        }
    }

    public void emptyStart() {
        ((TextView) this.f2073v.findViewById(C0846R.C0847id.tvStart)).setText("");
        this.aPoint = null;
        clearMarkers();
        this.f2072pd.setPath((List<Vertex>) null);
        this.startPoint = null;
    }

    /* access modifiers changed from: private */
    public void emptyEnd() {
        ((TextView) this.f2073v.findViewById(C0846R.C0847id.tvEnd)).setText("");
        this.bPoint = null;
        clearMarkers();
        this.f2072pd.setPath((List<Vertex>) null);
        this.endPoint = null;
    }

    /* access modifiers changed from: private */
    public void pickMarker(int requestcode) {
        Fragments.add(this, ExhibitorPickerFragment.newInstance(new OnFragmentResultListener() {
            public void onFragmentResult(Intent data, int requestCode, int resultCode) {
                MapV2Fragment.this.onActivityResult(requestCode, resultCode, data);
            }
        }, requestcode, this.map.get("width"), this.map.get("height"), this.mapid), C1199DB.getFirstObject("launchers", "moduletypeid", "2").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
    }

    private void showFavorites() {
        List<TCObject> list = getFavorites();
        clearMarkers();
        hideRoutePicker();
        hideLabel();
        this.f2072pd.setPath((List<Vertex>) null);
        for (TCObject tco : list) {
            drawMarker(new Marker("", ((float) Math.round(Float.parseFloat(tco.get("x", "0")))) / this.scale, ((float) Math.round(Float.parseFloat(tco.get("y", "0")))) / this.scale, "", ""), this.favoritebmp);
        }
    }

    /* access modifiers changed from: private */
    public List<TCObject> getFavorites() {
        return C1199DB.getQueryFromDb(String.format("SELECT e.x1 AS x, e.y1 AS y FROM exhibitors e INNER JOIN persprog p ON p.exhibitorid == e.id WHERE mapid == '%1$s' AND CAST(x AS INTEGER) != 0 AND CAST(y AS INTEGER) != 0 UNION SELECT s.xpos AS x, s.ypos AS y FROM sessions s INNER JOIN persprog p ON p.sessionid == s.id WHERE mapid == '%1$s' AND CAST(x AS INTEGER) != 0 AND CAST(y AS INTEGER) != 0", new Object[]{this.mapid}));
    }

    private void updateMap(Matrix matrix2) {
        int newzoomlevel = getZoomlevel();
        if (this.zoomlevel != newzoomlevel && newzoomlevel != 0) {
            this.zoomlevel = newzoomlevel;
            this.map = C1199DB.getObject("mapv2", "zoomlevel", String.valueOf(this.zoomlevel));
            this.mapid = this.map.get("mapid");
            Bitmap bmp = getMap(this.map);
            this.floorplan.setImageDrawable(new FastBitmapDrawable(bmp), false, new Matrix(matrix2), -1.0f);
        }
    }

    private int getZoomlevel() {
        if (!isAdded() || getResources() == null || getResources().getConfiguration() == null) {
            return 0;
        }
        float scale2 = getValue(0);
        if (getResources().getConfiguration().orientation != 2) {
            scale2 -= this.floorplan.getMinZoom();
        }
        int zoom = this.allZoomlevels[this.allZoomlevels.length - 1];
        float maxZoom = this.floorplan.getMaxZoom() - this.floorplan.getMinZoom();
        for (int i : this.allZoomlevels) {
            if (((float) zoom) * scale2 > ((float) i)) {
                int zoom2 = i;
                return i;
            }
        }
        return zoom;
    }

    private void updatePath() {
        this.f2072pd.UpdatePosition(this.matrix);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            this.f2072pd.setPath((List<Vertex>) null);
            hideLabel();
            clearMarkers();
            TCObject tco = C1199DB.getObject(DBFavorites.TABLE_EXHIBITORS, DBFavorites.KEY_EVENT_ID, data.getExtras().getString(DBFavorites.KEY_EVENT_ID));
            if (requestCode == 124) {
                if (this.bPoint == null || !this.bPoint.f2079id.equals(tco.get(DBFavorites.KEY_EVENT_ID))) {
                    this.aPoint = new Marker(tco.get(DBFavorites.KEY_EVENT_ID), Float.parseFloat(tco.get("x1")) / this.scale, Float.parseFloat(tco.get("y1")) / this.scale, LinkedObjects.TABLE_EXHI, tco.get(DBFavorites.KEY_NAME));
                    this.startPoint = getClosestVertex(tco);
                    if (this.startPoint != null) {
                        ((TextView) this.f2073v.findViewById(C0846R.C0847id.tvStart)).setText(tco.get(DBFavorites.KEY_NAME));
                    }
                } else {
                    return;
                }
            } else if (requestCode == 523) {
                if (this.aPoint == null || !this.aPoint.f2079id.equals(tco.get(DBFavorites.KEY_EVENT_ID))) {
                    this.bPoint = new Marker(tco.get(DBFavorites.KEY_EVENT_ID), Float.parseFloat(tco.get("x1")) / this.scale, Float.parseFloat(tco.get("y1")) / this.scale, LinkedObjects.TABLE_EXHI, tco.get(DBFavorites.KEY_NAME));
                    this.endPoint = getClosestVertex(tco);
                    if (this.endPoint != null) {
                        ((TextView) this.f2073v.findViewById(C0846R.C0847id.tvEnd)).setText(tco.get(DBFavorites.KEY_NAME));
                    }
                } else {
                    return;
                }
            }
            if (this.aPoint != null) {
                drawMarker(this.aPoint, this.routeAbmp);
            }
            if (this.bPoint != null) {
                drawMarker(this.bPoint, this.routeBbmp);
            }
        }
    }

    /* access modifiers changed from: private */
    public void toggleNavigationBar() {
        if (this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).getVisibility() == 0) {
            hideRoutePicker();
        } else {
            showRoutePicker();
        }
    }

    private void showRoutePicker() {
        if (this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).getVisibility() == 8) {
            Animation routeAnimation = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) ((int) Converter.convertDpToPixel(100.0f, getActivity())), BitmapDescriptorFactory.HUE_RED);
            routeAnimation.setDuration(200);
            this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).setVisibility(0);
            this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).startAnimation(routeAnimation);
        }
    }

    private void hideRoutePicker() {
        if (this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).getVisibility() == 0) {
            Animation routeAnimation = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) ((int) Converter.convertDpToPixel(100.0f, getActivity())));
            routeAnimation.setDuration(200);
            this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).startAnimation(routeAnimation);
            this.f2073v.findViewById(C0846R.C0847id.routepickercontainer).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void startupDijkstra() {
        new ArrayList();
        List<Vertex> vertexes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        List<TCObject> nodes = C1199DB.getListFromDb("indoor_routing_points", "mapid", this.mapid);
        Map<String, TCObject> nodesById = new HashMap<>();
        for (TCObject tco : nodes) {
            String id = tco.get(DBFavorites.KEY_EVENT_ID);
            vertexes.add(new Vertex(id, Integer.parseInt(tco.get("x")), Integer.parseInt(tco.get("y"))));
            nodesById.put(id, tco);
        }
        nodes.clear();
        List<TCObject> paths = C1199DB.getListFromDb("indoor_routing_paths", "mapid", this.mapid);
        for (TCObject tco2 : paths) {
            try {
                String routeStart = tco2.get("map_routingpointid_start");
                String routeEnd = tco2.get("map_routingpointid_end");
                String id2 = tco2.get(DBFavorites.KEY_EVENT_ID);
                int startx = Integer.parseInt(nodesById.get(routeStart).get("x"));
                int endx = Integer.parseInt(nodesById.get(routeEnd).get("x"));
                int starty = Integer.parseInt(nodesById.get(routeStart).get("y"));
                int endy = Integer.parseInt(nodesById.get(routeEnd).get("y"));
                int x = startx - endx;
                int y = starty - endy;
                edges.add(new Edge(id2, new Vertex(routeStart, startx, starty), new Vertex(routeEnd, endx, endy), (float) Math.sqrt((double) ((x * x) + (y * y)))));
            } catch (Exception e) {
            }
        }
        nodesById.clear();
        paths.clear();
        this.dijkstra = new Dijkstra(new Graph(vertexes, edges));
    }

    /* access modifiers changed from: private */
    public void berekenroute() {
        if (this.startPoint != null && this.endPoint != null) {
            centerMarker(this.aPoint);
            this.dijkstra.execute(this.startPoint);
            LinkedList<Vertex> path = this.dijkstra.getPath(this.endPoint);
            if (path != null) {
                hideLabel();
                path.add(0, new Vertex(this.aPoint.f2079id, (int) (this.aPoint.f2080x * this.scale), (int) (this.aPoint.f2081y * this.scale)));
                path.add(path.size(), new Vertex(this.bPoint.f2079id, (int) (this.bPoint.f2080x * this.scale), (int) (this.bPoint.f2081y * this.scale)));
                drawPath(path);
                clearMarkers();
                drawMarker(this.aPoint, this.routeAbmp);
                drawMarker(this.bPoint, this.routeBbmp);
            }
        }
    }

    private void drawPath(List<Vertex> path) {
        updatePath();
        this.f2072pd.setPath(path);
    }

    private void drawMarker(Marker marker) {
        drawMarker(marker, this.markerbmp);
    }

    private void drawMarker(Marker marker, Bitmap icon) {
        marker.img = new ImageView(getActivity());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-2, -2);
        marker.img.setImageBitmap(icon);
        marker.img.setScaleType(ImageView.ScaleType.MATRIX);
        float scale2 = getValue(0);
        float transX = getValue(2);
        float transY = getValue(5);
        lp.setMargins((int) (((marker.f2080x * scale2) + transX) - ((float) (icon.getWidth() / 2))), (int) (((marker.f2081y * scale2) + transY) - ((float) icon.getHeight())), 0, 0);
        marker.img.setLayoutParams(lp);
        this.visiblemarkers.add(marker);
        this.markercontainer.addView(marker.img);
    }

    public Vertex getClosestVertex(TCObject tco) {
        new ArrayList();
        int rectWidth = (int) (((double) Integer.parseInt(this.map.get("width"))) * 0.05d);
        int rectHeight = (int) (((double) Integer.parseInt(this.map.get("height"))) * 0.05d);
        Point point = new Point((int) Float.parseFloat(tco.get("x1")), (int) Float.parseFloat(tco.get("y1")));
        List<TCObject> oNodes = C1199DB.getListFromDb("indoor_routing_points", "'1'", "1' AND x+0 BETWEEN " + (point.x - rectWidth) + " AND " + (point.x + rectWidth) + " AND y+0 BETWEEN " + (point.y - rectHeight) + " AND " + (point.y + rectHeight) + " AND mapid =='" + this.mapid);
        Vertex closest = null;
        if (oNodes.isEmpty()) {
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setMessage(getString(C0846R.string.norouting));
            ad.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            ad.show();
            return null;
        }
        float distance = Float.MAX_VALUE;
        for (TCObject next : oNodes) {
            if (next instanceof TCObject) {
                TCObject node = next;
                Point cur = new Point(Integer.parseInt(node.get("x")), Integer.parseInt(node.get("y")));
                if (closest == null) {
                    closest = new Vertex(node.get(DBFavorites.KEY_EVENT_ID), Integer.parseInt(node.get("x")), Integer.parseInt(node.get("y")));
                    distance = distance(point, cur);
                } else {
                    Float dis = Float.valueOf(distance(point, cur));
                    if (dis.floatValue() < distance) {
                        closest = new Vertex(node.get(DBFavorites.KEY_EVENT_ID), Integer.parseInt(node.get("x")), Integer.parseInt(node.get("y")));
                        distance = dis.floatValue();
                    }
                }
            }
        }
        return closest;
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
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(1);
            View v = getLayoutInflater().inflate(C0846R.layout.sessionlist, (ViewGroup) null);
            List<TCObject> sessions = C1199DB.getQueryFromDb("SELECT sessions.*, sessions.starttime || ' - ' || sessions.endtime AS time, GROUP_CONCAT(tagsv2.tag, ' ') AS tag, GROUP_CONCAT(sp.name , ', ') AS speakernames FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == sessions.id AND tagsv2.itemtype == 'session' LEFT OUTER JOIN speakers sp ON sp.id == speaker_session.speakerid WHERE location IN (SELECT location FROM sessions WHERE id =='" + this.marker.f2079id + "') AND sessions.parentid == '0' " + "GROUP BY sessions.id " + "ORDER BY sessions.date, sessions.starttime, sessions.endtime");
            if (sessions.size() == 0) {
                dismiss();
                return;
            }
            List<Object> listitems = new ArrayList<>();
            for (TCObject ses : sessions) {
                try {
                    String s = DateFormat.getLongDateFormat(MapV2Fragment.this.getActivity()).format(new SimpleDateFormat("dd/MM/yyyy").parse(ses.get(Globalization.DATE)));
                    if (!listitems.contains(s)) {
                        listitems.add(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                listitems.add(new TCListObject(ses.get(DBFavorites.KEY_EVENT_ID), ses.get(DBFavorites.KEY_NAME), ses.get(Globalization.TIME), ses.get("speakernames"), (String) null).setSearch(ses.get("tag", "")));
            }
            TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) listitems, 0, false);
            adapter.setLayout(C0846R.layout.cell_session_new);
            ((ListView) v.findViewById(C0846R.C0847id.list)).setAdapter(adapter);
            ((ListView) v.findViewById(C0846R.C0847id.list)).setOnItemClickListener(this);
            v.findViewById(C0846R.C0847id.close).setOnClickListener(this.close);
            ((TextView) v.findViewById(C0846R.C0847id.location)).setText(sessions.get(0).get("location"));
            C1232UI.getColorOverlay((int) C0846R.drawable.popupclose, C1216LO.getLo(C1216LO.seperatorBackgroundColor));
            addContentView(v, new RelativeLayout.LayoutParams(-1, -1));
        }

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Object o = arg0.getItemAtPosition(arg2);
            if (o.getClass() == TCListObject.class) {
                Fragments.add(MapV2Fragment.this, SessionDetailFragment.newInstance(((TCListObject) o).getId()), MapV2Fragment.this.getResourceString(C0846R.string.detail));
                dismiss();
            }
        }
    }

    private class Marker {

        /* renamed from: id */
        public String f2079id;
        public ImageView img;
        public String name;
        public boolean removeable = true;
        public String type;

        /* renamed from: x */
        public float f2080x;

        /* renamed from: y */
        public float f2081y;

        public Marker(String id, float x, float y, String type2, String name2) {
            this.f2079id = id;
            this.f2080x = x;
            this.f2081y = y;
            this.type = type2;
            this.name = name2;
        }
    }

    private static class Dijkstra {
        private Map<Vertex, Float> distance;
        private final List<Edge> edges;
        private Map<Vertex, Vertex> predecessors;
        private Set<Vertex> settledNodes;
        private Set<Vertex> unSettledNodes;

        public Dijkstra(Graph graph) {
            this.edges = new ArrayList(graph.getEdges());
        }

        public void execute(Vertex source) {
            this.settledNodes = new HashSet();
            this.unSettledNodes = new HashSet();
            this.distance = new HashMap();
            this.predecessors = new HashMap();
            this.distance.put(source, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
            this.unSettledNodes.add(source);
            while (this.unSettledNodes.size() > 0) {
                this.unSettledNodes.removeAll(this.settledNodes);
                Vertex node = getMinimum(this.unSettledNodes);
                this.settledNodes.add(node);
                this.unSettledNodes.remove(node);
                findMinimalDistances(node);
            }
        }

        private void findMinimalDistances(Vertex node) {
            for (Vertex target : getNeighbors(node)) {
                if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                    this.distance.put(target, Float.valueOf(getShortestDistance(node) + getDistance(node, target)));
                    this.predecessors.put(target, node);
                    this.unSettledNodes.add(target);
                }
            }
        }

        private float getDistance(Vertex node, Vertex target) {
            for (Edge edge : this.edges) {
                if ((edge.getSource().equals(node) && edge.getDestination().equals(target)) || (edge.getSource().equals(target) && edge.getDestination().equals(node))) {
                    return edge.getWeight();
                }
            }
            throw new RuntimeException("Should not happen");
        }

        private List<Vertex> getNeighbors(Vertex node) {
            List<Vertex> neighbors = new ArrayList<>();
            for (Edge edge : this.edges) {
                if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                    neighbors.add(edge.getDestination());
                } else if (edge.getDestination().equals(node) && !isSettled(edge.getSource())) {
                    neighbors.add(edge.getSource());
                }
            }
            return neighbors;
        }

        private Vertex getMinimum(Set<Vertex> vertexes) {
            Vertex minimum = null;
            for (Vertex vertex : vertexes) {
                if (minimum == null) {
                    minimum = vertex;
                } else if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
            return minimum;
        }

        private boolean isSettled(Vertex vertex) {
            return this.settledNodes.contains(vertex);
        }

        private float getShortestDistance(Vertex destination) {
            Float d = this.distance.get(destination);
            if (d == null) {
                return Float.MAX_VALUE;
            }
            return d.floatValue();
        }

        public LinkedList<Vertex> getPath(Vertex target) {
            LinkedList<Vertex> path = new LinkedList<>();
            Vertex step = target;
            if (this.predecessors.get(step) == null) {
                return null;
            }
            path.add(step);
            while (this.predecessors.get(step) != null) {
                step = this.predecessors.get(step);
                path.add(step);
            }
            Collections.reverse(path);
            return path;
        }
    }

    private class Graph {
        private final List<Edge> edges;
        private final List<Vertex> vertexes;

        public Graph(List<Vertex> vertexes2, List<Edge> edges2) {
            this.vertexes = vertexes2;
            this.edges = edges2;
        }

        public List<Vertex> getVertexes() {
            return this.vertexes;
        }

        public List<Edge> getEdges() {
            return this.edges;
        }
    }

    public class Vertex {

        /* renamed from: id */
        private final String f2082id;

        /* renamed from: x */
        private final int f2083x;

        /* renamed from: y */
        private final int f2084y;

        public Vertex(String id, int x, int y) {
            this.f2082id = id;
            this.f2083x = x;
            this.f2084y = y;
        }

        public String getId() {
            return this.f2082id;
        }

        public int getX() {
            return this.f2083x;
        }

        public int getY() {
            return this.f2084y;
        }

        public int hashCode() {
            return (this.f2082id == null ? 0 : this.f2082id.hashCode()) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Vertex other = (Vertex) obj;
            if (this.f2082id == null) {
                if (other.f2082id != null) {
                    return false;
                }
                return true;
            } else if (!this.f2082id.equals(other.f2082id)) {
                return false;
            } else {
                return true;
            }
        }

        public String toString() {
            return String.valueOf(this.f2082id) + " x:" + this.f2083x + " y:" + this.f2084y;
        }
    }

    private class Edge {
        private final Vertex destination;

        /* renamed from: id */
        private final String f2078id;
        private final Vertex source;
        private final float weight;

        public Edge(String id, Vertex source2, Vertex destination2, float weight2) {
            this.f2078id = id;
            this.source = source2;
            this.destination = destination2;
            this.weight = weight2;
        }

        public String getId() {
            return this.f2078id;
        }

        public Vertex getDestination() {
            return this.destination;
        }

        public Vertex getSource() {
            return this.source;
        }

        public float getWeight() {
            return this.weight;
        }

        public String toString() {
            return this.source + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.destination;
        }
    }

    public void onZoomChanged(float scale2) {
        float minZoom = this.floorplan.getMinZoom();
        float percentage = (scale2 - minZoom) / (this.floorplan.getMaxZoom() - minZoom);
        float bottomThreshold = BitmapDescriptorFactory.HUE_RED;
        int newzoomlevel = -1;
        int i = 0;
        int len = this.allZoomlevels.length;
        while (true) {
            if (i < len) {
                float topThreshold = ((float) this.allZoomlevels[i]) / ((float) this.allZoomlevels[this.allZoomlevels.length - 1]);
                if (percentage > bottomThreshold && percentage < topThreshold) {
                    newzoomlevel = this.allZoomlevels[i];
                    break;
                } else {
                    bottomThreshold = topThreshold;
                    i++;
                }
            } else {
                break;
            }
        }
        if (this.zoomlevel != newzoomlevel && newzoomlevel != -1) {
            this.zoomlevel = newzoomlevel;
            this.map = C1199DB.getObject("mapv2", "zoomlevel", String.valueOf(this.zoomlevel));
            this.mapid = this.map.get("mapid");
            Bitmap bmp = getMap(this.map);
            this.floorplan.setImageDrawable(new FastBitmapDrawable(bmp), false, new Matrix(this.matrix), -1.0f);
        }
    }
}
