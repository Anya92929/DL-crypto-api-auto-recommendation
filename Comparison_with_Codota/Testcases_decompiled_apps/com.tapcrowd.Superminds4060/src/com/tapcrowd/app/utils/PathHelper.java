package com.tapcrowd.app.utils;

import android.content.Context;
import android.support.p000v4.app.Fragment;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.business.ContactFragment;
import com.tapcrowd.app.modules.business.LocationFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.info.BusInfoFragment;
import com.tapcrowd.app.modules.info.CityInfoFragment;
import com.tapcrowd.app.modules.info.EventInfoFragment;
import com.tapcrowd.app.modules.info.ShopRestoInfoFragment;
import com.tapcrowd.app.modules.info.VenueInfoFragment;
import com.tapcrowd.app.modules.news.NewsDetailFragment;
import com.tapcrowd.app.modules.places.PlaceDetailFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.modules.speakers.SpeakerDetailFragment;
import com.tapcrowd.app.modules.sponsors.SponsorDetailFragment;

public class PathHelper {
    public static Fragment getFragment(Context context, String path) {
        if (path.startsWith("/") && path.length() > 1) {
            path = path.substring(1);
        }
        C1199DB.openDataBase(context);
        String[] segments = getSegments(path);
        if (segments.length < 2 && segments.length > 0) {
            return setLauncherTitle(LauncherUtil.getFragment(segments[0]), segments[0]);
        }
        if (segments.length >= 2) {
            return getDetail(context, segments[0], segments[1]);
        }
        return null;
    }

    private static String[] getSegments(String path) {
        return path.split("/");
    }

    private static Fragment setLauncherTitle(Fragment fr, String launcherid) {
        TCObject launcher = C1199DB.getFirstObject("launchers", DBFavorites.KEY_EVENT_ID, launcherid);
        if (fr instanceof TCFragment) {
            ((TCFragment) fr).setTitle(launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        }
        if (fr instanceof TCListFragment) {
            ((TCListFragment) fr).setTitle(launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        }
        return fr;
    }

    private static Fragment getDetail(Context context, String launcherid, String detailid) {
        TCFragment tCFragment = null;
        TCObject launcher = C1199DB.getFirstObject("launchers", DBFavorites.KEY_EVENT_ID, launcherid);
        String m = launcher.get("moduletypeid");
        if (m.equals("1")) {
            tCFragment = NewsDetailFragment.newInstance(detailid);
        } else if (m.equals("2")) {
            tCFragment = ExhibitorDetailFragment.newInstance(detailid);
        } else if (m.equals("10")) {
            tCFragment = SessionDetailFragment.newInstance(detailid);
        } else if (m.equals("14")) {
            tCFragment = AttendeeDetailFragment.newInstance(detailid);
        } else if (m.equals("15")) {
            tCFragment = CatalogDetailFragment.newInstance(detailid, "");
        } else if (m.equals("19")) {
            tCFragment = SponsorDetailFragment.newInstance(detailid);
        } else if (m.equals("21")) {
            if (App.typeid.equals("4") && launcher.has("venueid")) {
                tCFragment = BusInfoFragment.newInstance(launcher.get("venueid"));
            } else if (App.typeid.equals("5")) {
                if (launcher.has("eventid")) {
                    tCFragment = EventInfoFragment.newInstance(launcher.get("eventid"));
                } else {
                    tCFragment = CityInfoFragment.newInstance();
                }
            } else if (App.typeid.equals("8") || App.typeid.equals("7")) {
                tCFragment = ShopRestoInfoFragment.newInstance(launcher.get("venueid"));
            } else {
                tCFragment = EventInfoFragment.newInstance(launcher.get("eventid"));
            }
        } else if (m.equals("22")) {
            tCFragment = LocationFragment.newInstance(launcher.get("venueid"));
        } else if (m.equals("23")) {
            tCFragment = ContactFragment.newInstance(launcher.get("venueid"));
        } else if (m.equals("24")) {
            tCFragment = CatalogDetailFragment.newInstance(detailid, "");
        } else if (m.equals("25")) {
            tCFragment = CatalogDetailFragment.newInstance(detailid, "");
        } else if (m.equals("26")) {
            tCFragment = EventInfoFragment.newInstance(detailid);
        } else if (m.equals("27")) {
            tCFragment = CatalogDetailFragment.newInstance(detailid, "");
        } else if (m.equals("30")) {
            tCFragment = EventInfoFragment.newInstance(detailid);
        } else if (m.equals("31")) {
            tCFragment = VenueInfoFragment.newInstance(detailid);
        } else if (m.equals("40")) {
            tCFragment = SpeakerDetailFragment.newInstance(detailid);
        } else if ((m.equals("50") && C1199DB.getSize("launchers", "moduletypeid", "48") == 0) || m.equals("51") || m.equals("52")) {
            tCFragment = CatalogDetailFragment.newInstance(detailid, "");
        } else if (m.equals("54")) {
            tCFragment = PlaceDetailFragment.newInstance(detailid);
        }
        if (tCFragment instanceof TCFragment) {
            tCFragment.setTitle(context.getString(C0846R.string.detail));
        }
        if (tCFragment instanceof TCListFragment) {
            ((TCListFragment) tCFragment).setTitle(context.getString(C0846R.string.detail));
        }
        return tCFragment;
    }
}
