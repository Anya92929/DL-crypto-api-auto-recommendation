package com.tapcrowd.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.TypedValue;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.io.File;
import org.apache.cordova.Globalization;

/* renamed from: com.tapcrowd.app.utils.LO */
public class C1216LO {
    public static final String actionImageOverlayColor = "actionImageOverlayColor";
    public static final String actionbarBackgroundColor = "actionbarBackgroundColor";
    public static final String actionbarContentColor = "actionbarContentColor";
    public static final String artistImagePlaceholder = "artistImagePlaceholder";
    private static Drawable artistImagePlaceholderDrawable = null;
    public static final String backgroundColor = "backgroundColor";
    public static final String bordercolorButtons = "bordercolorButtons";
    public static final String buttonBackgroundColor = "buttonBackgroundColor";
    public static final String cellSeparator = "cellSeparator";
    public static final String currentLineupTime = "currentLineupTime";
    public static final String icon = "icon";
    private static Drawable iconDrawable = null;
    public static final String launcherBackground = "launcherBackground";
    public static final String launcherBackgroundColor = "launcherBackgroundColor";
    private static Drawable launcherBackgroundDrawable = null;
    public static final String launcherColor = "launcherColor";
    public static final String launcherTextColor = "launcherTextColor";
    public static final String lineupBackground = "lineupBackground";
    private static Drawable lineupBackgroundDrawable = null;
    public static final String lineupCellBackground = "lineupCellBackground";
    public static final String lineupDateBar = "lineupDateHeader";
    private static Drawable lineupDateBarDrawable = null;
    public static final String lineupDateHeader = "lineupDateHeader";
    private static Drawable lineupDateHeaderDrawable = null;
    public static final String lineupHeader = "lineupHeader";
    public static final String lineupHeaderBackgroundColor = "lineupHeaderBackgroundColor";
    private static Drawable lineupHeaderDrawable = null;
    public static final String lineupPattern = "lineupPattern";
    private static Drawable lineupPatternDrawable = null;
    public static final String lineupSeparator = "lineupSeparator";
    private static Drawable lineupSeparatorDrawable = null;
    public static final String navbar = "navbar";
    private static Bitmap navbarBackground = null;
    public static final String navbarColor = "navbarColor";
    private static Drawable navbarDrawable = null;
    public static final String navbarTablets = "navbarTablets";
    private static Drawable navbarTabletsDrawable = null;
    public static final String navbarTitleImage = "navbarTitleImage";
    private static Drawable navbarTitleImageDrawable = null;
    public static final String navigationColor = "navigationColor";
    public static final String navigationMarker = "navigationMarker";
    private static Drawable navigationMarkerDrawable = null;
    public static final String placeholder = "placeholder";
    private static Drawable placeholderDrawable = null;
    public static final String placeholderOverlayColor = "placeholderOverlayColor";
    public static final String premiumCellBgColor = "premiumCellBgColor";
    public static final String premiumCellTextColor = "premiumCellTextColor";
    public static final String separatorTextColor = "separatorTextColor";
    public static final String seperatorBackgroundColor = "seperatorBackgroundColor";
    public static final String sessionDateCellColor = "sessionDateCellColor";
    public static final String sessionDateCellTextColor = "sessionDateCellTextColor";
    public static final String sessionHeaderColor = "sessionHeaderColor";
    public static final String sessionHeaderTextColor = "sessionHeaderTextColor";
    public static final String stageHeaderTextColor = "stageHeaderTextColor";
    public static final String stageTableViewBackground = "stageTableViewBackground";
    private static Drawable stageTableViewBackgroundDrawable = null;
    public static final String tabletBackgroundColor = "tabletBackgroundColor";
    public static final String tabletHeaderImage = "tabletHeaderImage";
    public static final String tableviewHighlight = "tableviewHighlight";
    public static final String textcolor = "textcolor";
    public static final String textcolorButtons = "textcolorButtons";
    public static final String timelineBorderColor = "timelineBorderColor";
    public static final String timelineColor = "timelineColor";
    public static final String timelineTextColor = "timelineTextColor";
    public static final String titleBackgroundColor = "titleBackgroundColor";
    public static final String titleFontColor = "titleFontColor";
    public static final String topTabBackgroundcolor = "topTabBackgroundcolor";
    public static final String topTabBackgroundcolorHigh = "topTabBackgroundcolorHigh";
    public static final String topTabTextColor = "topTabTextColor";
    public static final String topTabTextColorHigh = "topTabTextColorHigh";
    public static final String watermarkFestivalsStr = "watermarkFestivals";
    private static Drawable watermarkFestivalsStrDrawable = null;

    public static void downloadImages() {
        FastImageLoader fil = new FastImageLoader();
        for (TCObject tco : C1199DB.getListFromDb("appearance", "appid", App.f2123id, "controlid +0 ASC")) {
            if (tco.get("controlname").equals(navigationMarker)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(navbar)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(navbarTitleImage)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(launcherBackground)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(placeholder)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(stageTableViewBackground)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(artistImagePlaceholder)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(lineupHeader)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals("lineupDateHeader")) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(lineupBackground)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(lineupPattern)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(lineupSeparator)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals("lineupDateHeader")) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(watermarkFestivalsStr)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(icon)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(navbarTablets)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            } else if (tco.get("controlname").equals(tabletBackgroundColor)) {
                fil.downloadIfNotExists(tco.get("value", ""));
            }
        }
        for (TCObject to : C1199DB.getListFromDb("map")) {
            fil.downloadIfNotExists(to.get("imageurl"));
        }
        for (TCObject to2 : C1199DB.getListFromDb("mapv2")) {
            if (to2.has("imageurl")) {
                String url = to2.get("imageurl");
                if (url.startsWith("http://upload.tapcrowd.com/")) {
                    url = "http://stream.tapcrowd1.netdna-cdn.com/original/" + url.substring("http://upload.tapcrowd.com/".length());
                }
                fil.downloadIfNotExists(url);
            }
        }
        for (TCObject marker : C1199DB.getListFromDb("metavalues", Globalization.TYPE, "markericon")) {
            fil.getBitmap(marker.get("value"));
        }
        for (TCObject to3 : C1199DB.getListFromDb("launchers")) {
            String url2 = to3.get(icon);
            if (url2 != null && !url2.equals("")) {
                if (!url2.startsWith("http://") && !url2.startsWith("https://")) {
                    url2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url2;
                }
                fil.getBitmap(url2);
            }
        }
        for (TCObject to4 : C1199DB.getListFromDb("ad")) {
            if (to4.has("image")) {
                String url3 = to4.get("image");
                if (!url3.startsWith("http://") && !url3.startsWith("https://")) {
                    url3 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url3;
                }
                fil.getBitmap(url3);
            }
        }
    }

    public static void removeImages() {
        File cacheDir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            cacheDir = new File(Environment.getExternalStorageDirectory(), "Tapcrowd");
        } else {
            cacheDir = App.act.getCacheDir();
        }
        if (!cacheDir.exists()) {
            return;
        }
        if (cacheDir.isDirectory()) {
            for (String file : cacheDir.list()) {
                delete(new File(cacheDir, file));
            }
        } else if (cacheDir.isFile()) {
            cacheDir.delete();
        }
    }

    private static void delete(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (String file2 : file.list()) {
                delete(new File(file, file2));
            }
        }
    }

    public static int getLo(String controlname) {
        TCObject appearance = C1199DB.getFirstObject("appearance", "controlname", controlname);
        int value = Color.parseColor("#e3e3e3");
        if (controlname.equals(titleFontColor) || controlname.equals(navigationColor)) {
            value = -16777216;
        }
        if (appearance.has("value")) {
            return Color.parseColor("#" + appearance.get("value"));
        }
        return value;
    }

    public static Drawable getLoDrawable(String controlname) {
        Drawable drawable = null;
        if (controlname.equals(navigationMarker)) {
            drawable = navigationMarkerDrawable;
        } else if (controlname.equals(placeholder)) {
            drawable = placeholderDrawable;
        }
        if (drawable != null) {
            return drawable;
        }
        FastImageLoader fil = new FastImageLoader();
        TCObject appearance = C1199DB.getFirstObject("appearance", "controlname", controlname);
        if (appearance.has("value")) {
            drawable = fil.getDrawable(appearance.get("value"));
        }
        if (controlname.equals(navigationMarker)) {
            navigationMarkerDrawable = drawable;
        } else if (controlname.equals(placeholder)) {
            placeholderDrawable = drawable;
        }
        return drawable;
    }

    public static String getLoUrl(String controlname) {
        TCObject appearance = C1199DB.getFirstObject("appearance", "controlname", controlname);
        if (appearance.has("value")) {
            return appearance.get("value");
        }
        return null;
    }

    public static Bitmap getNavbarBackground(Context context) {
        if (navbarBackground == null) {
            int height = 0;
            int width = context.getResources().getDisplayMetrics().widthPixels;
            TypedValue tv = new TypedValue();
            if (context.getTheme().resolveAttribute(16843499, tv, true)) {
                height = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
            }
            if (height == 0) {
                height = (int) Converter.convertDpToPixel(48.0f, context);
            }
            int color = getLo(navbarColor);
            navbarBackground = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            int iLen = navbarBackground.getHeight();
            for (int i = 0; i < iLen; i++) {
                int jLen = navbarBackground.getWidth();
                for (int j = 0; j < jLen; j++) {
                    navbarBackground.setPixel(j, i, color);
                }
            }
        }
        return navbarBackground;
    }
}
