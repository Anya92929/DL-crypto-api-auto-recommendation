package com.tapcrowd.app.utils;

import android.support.p000v4.app.Fragment;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.attendees.AttendeeListFragment;
import com.tapcrowd.app.modules.business.BusinessThumbsFragment;
import com.tapcrowd.app.modules.business.CatalogCompareFragmentV2;
import com.tapcrowd.app.modules.business.ContactFragment;
import com.tapcrowd.app.modules.business.LocationFragment;
import com.tapcrowd.app.modules.conferencebag.FavoritesFragment;
import com.tapcrowd.app.modules.conferencebag.PersonalProgramFragment;
import com.tapcrowd.app.modules.coupons.CouponsFragment;
import com.tapcrowd.app.modules.events.EventListFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.findmy.FindMyFragment;
import com.tapcrowd.app.modules.findmy.FindMyFriendsFragment;
import com.tapcrowd.app.modules.flashlight.FlashLightFragment;
import com.tapcrowd.app.modules.gamification.GamificationFragment;
import com.tapcrowd.app.modules.groups.GroupImageList;
import com.tapcrowd.app.modules.groups.GroupListBusFragment;
import com.tapcrowd.app.modules.groups.GroupListFragment;
import com.tapcrowd.app.modules.groups.GroupListRestoFragment;
import com.tapcrowd.app.modules.info.BusInfoFragment;
import com.tapcrowd.app.modules.info.CityInfoFragment;
import com.tapcrowd.app.modules.info.EventInfoFragment;
import com.tapcrowd.app.modules.info.ShopRestoInfoFragment;
import com.tapcrowd.app.modules.map.MapFragment;
import com.tapcrowd.app.modules.map.MapV2Fragment;
import com.tapcrowd.app.modules.news.NewsTabsFragment;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.modules.notifications.NotificationsFragment;
import com.tapcrowd.app.modules.photosharer.PhotoSharerFragment;
import com.tapcrowd.app.modules.places.PlaceListFragment;
import com.tapcrowd.app.modules.places.VenueListFragment;
import com.tapcrowd.app.modules.search.SearchListAllFragment;
import com.tapcrowd.app.modules.sessions.FestivalFavoritesFragment;
import com.tapcrowd.app.modules.sessions.FestivalSessionsFragment;
import com.tapcrowd.app.modules.sessions.SessionViewTypeFragment;
import com.tapcrowd.app.modules.speakers.SpeakerListFragment;
import com.tapcrowd.app.modules.sponsors.SponsorListFragment;
import com.tapcrowd.app.modules.swipe2mobile.Swipe2MobileFragment;
import com.tapcrowd.app.modules.webview.FormFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import org.apache.cordova.NetworkManager;

public class LauncherUtil {
    public static Fragment getFragment(TCObject tco) {
        return getFragment(tco.get(DBFavorites.KEY_EVENT_ID, ""));
    }

    public static Fragment getFragment(TCListObject tlo) {
        return getFragment(tlo.getId());
    }

    public static Fragment getFragment(String id) {
        String type;
        String typeid;
        String url;
        TCObject launcher = C1199DB.getFirstObject("launchers", DBFavorites.KEY_EVENT_ID, id);
        String str = App.f2123id;
        if (launcher.has("eventid")) {
            type = "eventid";
            typeid = launcher.get("eventid");
        } else if (launcher.has("venueid")) {
            type = "venueid";
            typeid = launcher.get("venueid");
        } else {
            type = "appid";
            typeid = App.f2123id;
        }
        String dt = launcher.get("displaytype", "");
        String m = launcher.get("moduletypeid", "");
        Fragment fragment = null;
        if (dt.equals(NetworkManager.TYPE_NONE)) {
            return null;
        }
        if (m.equals("0")) {
            fragment = WebViewFragment.newInstance(launcher.get(PlusShare.KEY_CALL_TO_ACTION_URL), true, launcher.get(DBFavorites.KEY_EVENT_ID));
        } else if (m.equals("1")) {
            fragment = NewsTabsFragment.newInstance(type, typeid);
        } else if (m.equals("2")) {
            if (dt.equals("categories")) {
                fragment = GroupListFragment.newInstance("parentid", C1199DB.getObject("groups", "eventid == " + type + " AND name", "exhibitorcategories").get(DBFavorites.KEY_EVENT_ID), true);
            } else {
                fragment = ExhibitorListFragment.newInstance(launcher.get("eventid", ""));
            }
        } else if (m.equals("5")) {
            fragment = MapFragment.newInstance();
        } else if (m.equals("10")) {
            if (dt.equals("lineup")) {
                fragment = FestivalSessionsFragment.newInstance();
            } else {
                fragment = SessionViewTypeFragment.newInstance(launcher.get("eventid"), launcher.get("displaytype"), (String) null);
            }
        } else if (m.equals("11")) {
            fragment = FestivalFavoritesFragment.newInstance();
        } else if (m.equals("14")) {
            fragment = AttendeeListFragment.newInstance(launcher.get("eventid"));
        } else if (m.equals("15")) {
            if (dt.equals("imagelist")) {
                fragment = GroupImageList.newInstance(launcher.get("groupid"));
            } else {
                fragment = GroupListFragment.newInstance("parentid", C1199DB.getObject("groups", DBFavorites.KEY_NAME, "catalogcategories").get(DBFavorites.KEY_EVENT_ID));
            }
        } else if (m.equals("19")) {
            fragment = SponsorListFragment.newInstance();
        } else if (m.equals("21")) {
            if (App.typeid.equals("4") && launcher.has("venueid")) {
                fragment = BusInfoFragment.newInstance(launcher.get("venueid"));
            } else if (App.typeid.equals("5")) {
                if (launcher.has("eventid")) {
                    fragment = EventInfoFragment.newInstance(launcher.get("eventid"));
                } else {
                    fragment = CityInfoFragment.newInstance();
                }
            } else if (App.typeid.equals("8") || App.typeid.equals("7")) {
                fragment = ShopRestoInfoFragment.newInstance(launcher.get("venueid"));
            } else {
                fragment = EventInfoFragment.newInstance(launcher.get("eventid"));
            }
        } else if (m.equals("22")) {
            fragment = LocationFragment.newInstance(launcher.get("venueid"));
        } else if (m.equals("23")) {
            fragment = ContactFragment.newInstance(launcher.get("venueid"));
        } else if (m.equals("24")) {
            if (dt.equals("thumbs")) {
                fragment = BusinessThumbsFragment.newInstance(launcher.get(DBFavorites.KEY_MODULE));
            } else if (dt.equals("slider")) {
                fragment = GroupListRestoFragment.newInstance("slider", launcher.get(DBFavorites.KEY_MODULE));
            } else {
                fragment = GroupListBusFragment.newInstance(launcher.get(DBFavorites.KEY_MODULE), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
            }
        } else if (m.equals("25")) {
            if (dt.equals("thumbs")) {
                fragment = BusinessThumbsFragment.newInstance(launcher.get(DBFavorites.KEY_MODULE));
            } else {
                fragment = GroupListBusFragment.newInstance(launcher.get(DBFavorites.KEY_MODULE), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
            }
        } else if (m.equals("26")) {
            fragment = EventListFragment.newInstance();
        } else if (m.equals("27")) {
            fragment = GroupListBusFragment.newInstance(launcher.get(DBFavorites.KEY_MODULE), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        } else if (m.equals("30")) {
            fragment = EventListFragment.newInstance();
        } else if (m.equals("31")) {
            if (launcher.has("tag")) {
                fragment = VenueListFragment.newInstance(launcher.get("tag"));
            } else {
                fragment = VenueListFragment.newInstance();
            }
        } else if (m.equals("35")) {
            fragment = NotesFragment.newInstance();
        } else if (m.equals("36")) {
            fragment = FindMyFriendsFragment.newInstance();
        } else if (m.equals("37")) {
            fragment = FindMyFragment.newInstance(m);
        } else if (m.equals("38")) {
            fragment = FlashLightFragment.newInstance();
        } else if (m.equals("39")) {
            fragment = PhotoSharerFragment.newInstance(type.replace(DBFavorites.KEY_EVENT_ID, ""), typeid);
        } else if (m.equals("40")) {
            fragment = SpeakerListFragment.newInstance();
        } else if (m.equals("42")) {
            fragment = FavoritesFragment.newInstance(type, typeid);
        } else if (m.equals("43")) {
            fragment = PersonalProgramFragment.newInstance(launcher.get("eventid"));
        } else if (m.equals("44")) {
            String url2 = launcher.get(PlusShare.KEY_CALL_TO_ACTION_URL, false);
            if (url2.contains("?")) {
                url = String.valueOf(url2) + "&cordova=2__2__0";
            } else {
                url = String.valueOf(url2) + "?cordova=2__2__0";
            }
            fragment = FormFragment.newInstance(url, launcher.get(DBFavorites.KEY_EVENT_ID));
        } else if (m.equals("47")) {
            fragment = CouponsFragment.newInstance();
        } else if ((!m.equals("50") || C1199DB.getSize("launchers", "moduletypeid", "48") != 0) && !m.equals("51") && !m.equals("52")) {
            if (m.equals("54")) {
                fragment = PlaceListFragment.newInstance(typeid);
            } else if (m.equals("60")) {
                fragment = FormFragment.newInstance(String.valueOf(launcher.get("mobileurl")) + "&datasource=session&datasourceparent=event&datasourceparentid=" + launcher.get("eventid"), launcher.get(DBFavorites.KEY_EVENT_ID));
            } else if (m.equals("61")) {
                fragment = FormFragment.newInstance(String.valueOf(launcher.get("mobileurl")) + "&datasource=speaker&datasourceparent=event&datasourceparentid=" + launcher.get("eventid"), launcher.get(DBFavorites.KEY_EVENT_ID));
            } else if (m.equals("61")) {
                fragment = FormFragment.newInstance(launcher.get("mobileurl"), launcher.get(DBFavorites.KEY_EVENT_ID));
            } else if (m.equals("62")) {
                fragment = WebViewFragment.newInstance(String.valueOf(launcher.get("mobileurl")) + "&udid=" + User.getDeviceId(), true, launcher.get(DBFavorites.KEY_EVENT_ID));
            } else if (m.equals("65")) {
                fragment = NotificationsFragment.newInstance();
            } else if (m.equals("66")) {
                fragment = GamificationFragment.newInstance();
            } else if (m.equals("67")) {
                fragment = SearchListAllFragment.newInstance(new String[]{LinkedObjects.TABLE_ATT, DBFavorites.TABLE_EXHIBITORS, "sessions", "speakers", LinkedObjects.TABLE_CAT, "sponsors", "groups"});
            } else if (m.equals("71")) {
                fragment = FindMyFragment.newInstance(m);
            } else if (m.equals("72")) {
                fragment = MapV2Fragment.newInstance();
            } else if (m.equals("73")) {
                fragment = CatalogCompareFragmentV2.newInstance();
            } else if (m.equals("75")) {
                fragment = Swipe2MobileFragment.newInstance();
            } else if (m.equals("74")) {
                fragment = com.tapcrowd.app.modules.favorites_v2.FavoritesFragment.newInstance(type, typeid);
            } else if (launcher.has("mobileurl")) {
                fragment = WebViewFragment.newInstance(launcher.get("mobileurl"), true, launcher.get(DBFavorites.KEY_EVENT_ID));
            }
        } else if (launcher.has("groupid")) {
            fragment = GroupListRestoFragment.newInstance(launcher.get("groupid"));
        } else {
            fragment = GroupListRestoFragment.newInstance();
        }
        if ((fragment instanceof TCFragment) && launcher.has("loggingpath")) {
            ((TCFragment) fragment).setPath(launcher.get("loggingpath", ""));
        }
        if ((fragment instanceof TCListFragment) && launcher.has("loggingpath")) {
            ((TCListFragment) fragment).setPath(launcher.get("loggingpath", ""));
        }
        return fragment;
    }

    public static boolean hasFragment(TCObject tco) {
        String m = tco.get("moduletypeid");
        if (tco.get("displaytype", "").equals(NetworkManager.TYPE_NONE)) {
            return false;
        }
        if (m.equals("0")) {
            return true;
        }
        if (m.equals("1")) {
            return true;
        }
        if (m.equals("2")) {
            return true;
        }
        if (m.equals("5")) {
            return true;
        }
        if (m.equals("10")) {
            return true;
        }
        if (m.equals("11")) {
            return true;
        }
        if (m.equals("14")) {
            return true;
        }
        if (m.equals("15")) {
            return true;
        }
        if (m.equals("19")) {
            return true;
        }
        if (m.equals("21")) {
            return true;
        }
        if (m.equals("22")) {
            return true;
        }
        if (m.equals("23")) {
            return true;
        }
        if (m.equals("24")) {
            return true;
        }
        if (m.equals("25")) {
            return true;
        }
        if (m.equals("26")) {
            return true;
        }
        if (m.equals("27")) {
            return true;
        }
        if (m.equals("30")) {
            return true;
        }
        if (m.equals("31")) {
            return true;
        }
        if (m.equals("35")) {
            return true;
        }
        if (m.equals("36")) {
            return true;
        }
        if (m.equals("37")) {
            return true;
        }
        if (m.equals("38")) {
            return true;
        }
        if (m.equals("39")) {
            return true;
        }
        if (m.equals("42")) {
            return true;
        }
        if (m.equals("43")) {
            return true;
        }
        if (m.equals("44")) {
            return true;
        }
        if (m.equals("47")) {
            return true;
        }
        if (m.equals("50")) {
            return true;
        }
        if (m.equals("51")) {
            return true;
        }
        if (m.equals("52")) {
            return true;
        }
        if (m.equals("54")) {
            return true;
        }
        if (m.equals("60")) {
            return true;
        }
        if (m.equals("61")) {
            return true;
        }
        if (m.equals("62")) {
            return true;
        }
        if (m.equals("63")) {
            return true;
        }
        if (m.equals("65")) {
            return true;
        }
        if (m.equals("66")) {
            return true;
        }
        if (m.equals("67")) {
            return true;
        }
        if (m.equals("71")) {
            return true;
        }
        if (m.equals("72")) {
            return true;
        }
        if (m.equals("73")) {
            return true;
        }
        if (m.equals("75")) {
            return true;
        }
        if (m.equals("74")) {
            return true;
        }
        return false;
    }
}
