package com.tapcrowd.app.utils;

import android.support.p000v4.app.Fragment;
import com.google.android.gms.location.LocationStatusCodes;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.AdFragment;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.cordova.Globalization;
import org.apache.cordova.NetworkManager;

public class AdHelper {
    private static final String PATH_SEP = ",";
    private static final String TAB_PATH = "tabpath";
    private static boolean allPages;
    private static HashMap<String, Carousel> pathList;

    public static void showAds(Fragment fr, String path) {
        AdFragment adfragment = ((TCLauncher) fr.getActivity()).getAdFragment();
        TCObject adlauncher = C1199DB.getFirstObject("launchers", "moduletypeid", "29");
        if (path == null || (adlauncher.get("displaytype", "").equals(NetworkManager.TYPE_NONE) && !path.equals(""))) {
            adfragment.setCarousel(new Carousel());
            return;
        }
        if (App.tablet) {
            path = TAB_PATH;
        }
        adfragment.setCarousel(getCarousel(path));
    }

    private static Carousel getCarousel(String path) {
        HashMap<String, Carousel> pathList2 = getPathList();
        if (path == null) {
            return new Carousel();
        }
        if (path.equals("")) {
            Carousel car = new Carousel();
            if (pathList2.containsKey("")) {
                car.addAllAds(pathList2.get(""));
            }
            if (!pathList2.containsKey("/")) {
                return car;
            }
            car.addAllAds(pathList2.get("/"));
            return car;
        }
        while (!pathList2.containsKey(path)) {
            path = removeSegment(path);
            if (path == null) {
                return new Carousel();
            }
        }
        return pathList2.get(path);
    }

    private static HashMap<String, Carousel> getPathList() {
        if (pathList == null) {
            initPathList();
        }
        return pathList;
    }

    private static void initPathList() {
        allPages = C1199DB.getFirstObject("launchers", "moduletypeid", "29").get("displaytype", "").equals("AllPages");
        pathList = new HashMap<>();
        for (TCObject item : C1199DB.getQueryFromDb("SELECT paths, time, image, order_value, website FROM ad ORDER BY paths")) {
            String[] paths = item.get("paths", "").split(PATH_SEP);
            C1192Ad ad = new C1192Ad(item.get("image"), item.get("website"), Integer.valueOf(item.get(Globalization.TIME)).intValue(), item.get("order_value", "0"));
            if (ad.getImage() != null) {
                for (String path : paths) {
                    if (App.tablet) {
                        path = TAB_PATH;
                    }
                    Carousel carousel = new Carousel();
                    if (pathList.containsKey(path)) {
                        carousel = pathList.get(path);
                    }
                    carousel.addAd(ad);
                    pathList.put(path, carousel);
                }
            }
        }
    }

    private static String removeSegment(String path) {
        String newPath;
        if (allPages) {
            if (path.equals("")) {
                return null;
            }
            if (path.equals("/")) {
                return "";
            }
        } else if (path.equals("/")) {
            return null;
        }
        int lastIndex = path.lastIndexOf("/");
        if (lastIndex <= 0) {
            newPath = "/";
        } else {
            newPath = path.substring(0, lastIndex);
        }
        return newPath;
    }

    public static String buildPath(String moduletypeid, String type, String detailid) {
        String path = String.valueOf("/") + C1199DB.getFirstObject("launchers", "moduletypeid", moduletypeid).get(DBFavorites.KEY_EVENT_ID);
        if (type != null) {
            path = String.valueOf(path) + "/" + type;
        }
        if (detailid != null) {
            return String.valueOf(path) + "/" + detailid;
        }
        return path;
    }

    public static class Carousel {
        Comparator<C1192Ad> adSorter = new Comparator<C1192Ad>() {
            public int compare(C1192Ad lhs, C1192Ad rhs) {
                return lhs.getOrder().compareTo(rhs.getOrder());
            }
        };
        private ArrayList<C1192Ad> ads = new ArrayList<>();

        public void addAd(C1192Ad ad) {
            if (!this.ads.contains(ad)) {
                this.ads.add(ad);
            }
        }

        public void addAllAds(Carousel carousel) {
            this.ads.addAll(carousel.getAds());
        }

        public ArrayList<C1192Ad> getAds() {
            sort();
            return this.ads;
        }

        private void sort() {
            HashSet<String> orders = new HashSet<>();
            Collections.sort(this.ads, this.adSorter);
            ArrayList<C1192Ad> temp = new ArrayList<>();
            int len = this.ads.size();
            for (int i = 0; i < len; i++) {
                String order = this.ads.get(i).getOrder();
                if (!orders.contains(order)) {
                    ArrayList<C1192Ad> list = getAllForOrder(order);
                    Collections.shuffle(list);
                    temp.addAll(list);
                    orders.add(order);
                }
            }
            this.ads = temp;
        }

        private ArrayList<C1192Ad> getAllForOrder(String order) {
            ArrayList<C1192Ad> list = new ArrayList<>();
            Iterator<C1192Ad> it = this.ads.iterator();
            while (it.hasNext()) {
                C1192Ad ad = it.next();
                if (ad.getOrder().equals(order)) {
                    list.add(ad);
                }
            }
            return list;
        }
    }

    /* renamed from: com.tapcrowd.app.utils.AdHelper$Ad */
    public static class C1192Ad {
        private String image;
        private String order;
        private int time;
        private String website;

        public C1192Ad(String image2, String website2, int time2, String order2) {
            this.image = image2;
            this.website = website2;
            this.time = time2 * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
            this.order = order2;
        }

        public String getImage() {
            return this.image;
        }

        public String getWebsite() {
            return this.website;
        }

        public int getTime() {
            return this.time;
        }

        public String getOrder() {
            return this.order;
        }

        public String toString() {
            return this.image;
        }
    }
}
