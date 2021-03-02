package com.tapcrowd.app.modules.exhibitors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.favorites_v2.FavoritesUtil;
import com.tapcrowd.app.modules.groups.GroupListFragment;
import com.tapcrowd.app.modules.map.MapFragment;
import com.tapcrowd.app.modules.map.MapV2Fragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notes.AddNoteFragment;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.ConferenceBagUtil;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.PdfUtil;
import com.tapcrowd.app.utils.PersonalProgramUtil;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class ExhibitorDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NOTES = 5345;
    private final int SHARE = 55;
    ProgressDialog dialog;
    GetLatLon getLatLon;
    double lat;
    boolean locationerror;
    double lon;
    String placelauncherid;
    boolean showplaces;
    TCObject tco;

    /* renamed from: v */
    View f2030v;

    public static ExhibitorDetailFragment newInstance(String id) {
        ExhibitorDetailFragment detail = new ExhibitorDetailFragment();
        detail.tco = C1199DB.getObject(DBFavorites.TABLE_EXHIBITORS, DBFavorites.KEY_EVENT_ID, id);
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.tco.get(DBFavorites.KEY_EVENT_ID));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2030v = inflater.inflate(C0846R.layout.exhibitordetail, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("2", "detail", this.tco.get(DBFavorites.KEY_EVENT_ID)));
        if (savedInstanceState != null && this.tco == null) {
            this.tco = C1199DB.getObject(DBFavorites.TABLE_EXHIBITORS, DBFavorites.KEY_EVENT_ID, savedInstanceState.getString(DBFavorites.KEY_EVENT_ID));
        }
        this.dialog = new ProgressDialog(getActivity());
        this.dialog.setMessage(getResourceString(C0846R.string.loading));
        setupMenu();
        C1232UI.hide(C0846R.C0847id.date, this.f2030v);
        C1232UI.hide(C0846R.C0847id.time, this.f2030v);
        C1232UI.hide(C0846R.C0847id.sepInfo, this.f2030v);
        C1232UI.setColor(C0846R.C0847id.location, 1, this.f2030v);
        C1232UI.setText((int) C0846R.C0847id.name, this.tco.get(DBFavorites.KEY_NAME), this.f2030v);
        if (this.tco.has("booth")) {
            C1232UI.setText((int) C0846R.C0847id.location, String.valueOf(getResourceString(C0846R.string.location)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.tco.get("booth", "null"), this.f2030v);
        } else {
            C1232UI.setText((int) C0846R.C0847id.location, "", this.f2030v);
        }
        String text = Converter.unicodeToString(this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
        if (text.length() > 2) {
            C1232UI.setText((int) C0846R.C0847id.info, text, this.f2030v);
        } else {
            this.f2030v.findViewById(C0846R.C0847id.sepInfo).setVisibility(8);
            this.f2030v.findViewById(C0846R.C0847id.info).setVisibility(8);
        }
        List<TCObject> artists = C1199DB.getListFromDb("groupitems", "itemid", this.tco.get(DBFavorites.KEY_EVENT_ID));
        this.f2030v.findViewById(C0846R.C0847id.LinearLayout2).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2030v.findViewById(C0846R.C0847id.name)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2030v.findViewById(C0846R.C0847id.location)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2030v.findViewById(C0846R.C0847id.country)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        List<String> images = new ArrayList<>();
        if (this.tco.has("image_large")) {
            images.add(this.tco.get("image_large"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'exhibitor' AND parentId == '" + this.tco.get(DBFavorites.KEY_EVENT_ID) + "'")) {
            images.add(meta.get("value"));
        }
        ViewPager vp = (ViewPager) this.f2030v.findViewById(C0846R.C0847id.viewerpager);
        vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) this.f2030v.findViewById(C0846R.C0847id.pager), ImageView.ScaleType.FIT_CENTER));
        if (images.size() == 0) {
            vp.setVisibility(8);
        }
        if (this.tco.has("x1") && !this.tco.get("x1").equalsIgnoreCase("0")) {
            TCObject mapLauncher = C1199DB.getFirstObject("launchers", "moduletypeid", "72");
            if (!mapLauncher.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                mapLauncher = C1199DB.getFirstObject("launchers", "moduletypeid", "5");
            }
            C1232UI.addCell(this.f2030v, String.valueOf(getResourceString(C0846R.string.showfloorplan)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + mapLauncher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    if (C1199DB.getSize("launchers", "moduletypeid", "72") > 0) {
                        Fragments.add(ExhibitorDetailFragment.this, MapV2Fragment.newInstance(ExhibitorDetailFragment.this.tco.get("mapid"), (float) ((int) Double.parseDouble(ExhibitorDetailFragment.this.tco.get("x1"))), (float) ((int) Double.parseDouble(ExhibitorDetailFragment.this.tco.get("y1")))), ExhibitorDetailFragment.this.tco.get(DBFavorites.KEY_NAME));
                    } else {
                        Fragments.add(ExhibitorDetailFragment.this, MapFragment.newInstance(ExhibitorDetailFragment.this.tco.get("mapid"), (float) ((int) Double.parseDouble(ExhibitorDetailFragment.this.tco.get("x1"))), (float) ((int) Double.parseDouble(ExhibitorDetailFragment.this.tco.get("y1")))), ExhibitorDetailFragment.this.tco.get(DBFavorites.KEY_NAME));
                    }
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_map_white, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.tco.has("web")) {
            C1232UI.addCell(this.f2030v, getResourceString(C0846R.string.showwebsite), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(ExhibitorDetailFragment.this, ExhibitorDetailFragment.this.tco.get("web"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.tco.has("tel")) {
            C1232UI.addCell(this.f2030v, this.tco.get("tel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doCall(ExhibitorDetailFragment.this.tco.get("tel"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.tco.has("email")) {
            C1232UI.addCell(this.f2030v, Html.fromHtml(this.tco.get("email", "")).toString(), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doMail(ExhibitorDetailFragment.this.tco.get("email"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.tco.has("address")) {
            this.getLatLon = new GetLatLon(this, (GetLatLon) null);
            this.getLatLon.execute(new Void[0]);
            C1232UI.addCell(this.f2030v, Html.fromHtml(this.tco.get("address", "")).toString(), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    if (C1199DB.getSize("launchers", "moduletypeid", "54") > 0) {
                        ExhibitorDetailFragment.this.registerForContextMenu(v);
                        ExhibitorDetailFragment.this.getActivity().openContextMenu(v);
                        ExhibitorDetailFragment.this.unregisterForContextMenu(v);
                        return;
                    }
                    Actions.doNavigate(ExhibitorDetailFragment.this.tco.get("address"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (artists.size() > 0) {
            C1232UI.addCell(this.f2030v, getResourceString(C0846R.string.exhiartists), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(ExhibitorDetailFragment.this, GroupListFragment.newInstance("groupitemsid", ExhibitorDetailFragment.this.tco.get(DBFavorites.KEY_EVENT_ID, "")), ExhibitorDetailFragment.this.getResourceString(C0846R.string.categorieen));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_categories, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        new ConferenceBagUtil(this, this.f2030v, ConferenceBagUtil.Type.exhibitor, this.tco.get(DBFavorites.KEY_EVENT_ID), this.tco.get("eventid"), (String) null, this.analytics).addCell();
        new PersonalProgramUtil(getActivity(), this.f2030v, PersonalProgramUtil.Type.exhibitors, this.tco.get(DBFavorites.KEY_EVENT_ID), this.tco.get("eventid"), this.analytics).addCell();
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            C1232UI.addCell(this.f2030v, C1199DB.getFirstObject("launchers", "moduletypeid", "35").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(ExhibitorDetailFragment.this, NotesFragment.newInstance(DBFavorites.TABLE_EXHIBITORS, ExhibitorDetailFragment.this.tco.get(DBFavorites.KEY_EVENT_ID)), ExhibitorDetailFragment.this.tco.get(DBFavorites.KEY_NAME, ""));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        new FavoritesUtil(this, getActivity(), this.f2030v, FavoritesUtil.Type.Exhibitors, this.tco.get(DBFavorites.KEY_EVENT_ID), this.tco.get("eventid"), this.tco.get(DBFavorites.KEY_NAME)).addCell();
        for (final TCObject conf : C1199DB.getListFromDb("confbag", "itemtable == 'exhibitor' AND tableid", this.tco.get(DBFavorites.KEY_EVENT_ID))) {
            String title = conf.get("documentlink");
            String title2 = title.substring(title.lastIndexOf(47) + 1);
            C1232UI.addCell(this.f2030v, title2.substring(0, title2.lastIndexOf(".")).replace("_", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replace("-", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    new PdfUtil(ExhibitorDetailFragment.this.getActivity(), (PdfUtil.PdfLoadFinishedListener) null).showPdf(conf.get("documentlink"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_attachment, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, LinkedObjects.TABLE_EXHI, this.tco.get(DBFavorites.KEY_EVENT_ID), this.f2030v);
        LinkedObjects.add(this, this.f2030v, LinkedObjects.TABLE_EXHI, this.tco.get(DBFavorites.KEY_EVENT_ID));
        return this.f2030v;
    }

    public void onResume() {
        if (this.tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.tco.get("loggingpath"), "");
        }
        super.onResume();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (TCObject place : C1199DB.getListFromDb("launchers", "moduletypeid", "54")) {
            menu.add(0, Integer.valueOf(place.get(DBFavorites.KEY_EVENT_ID)).intValue(), 0, String.valueOf(getResourceString(C0846R.string.showin)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + place.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        }
        menu.add(0, 0, 0, "Maps");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Actions.doNavigate(this.tco.get("address"));
                break;
            default:
                this.showplaces = true;
                this.placelauncherid = String.valueOf(item.getItemId());
                if (this.getLatLon != null && this.getLatLon.getStatus() == AsyncTask.Status.RUNNING) {
                    this.dialog.show();
                    break;
                } else {
                    showPlaces();
                    break;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class GetLatLon extends AsyncTask<Void, Void, Void> {
        private GetLatLon() {
        }

        /* synthetic */ GetLatLon(ExhibitorDetailFragment exhibitorDetailFragment, GetLatLon getLatLon) {
            this();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                List<Address> address = new Geocoder(ExhibitorDetailFragment.this.getActivity()).getFromLocationName(ExhibitorDetailFragment.this.tco.get("address"), 5);
                if (address != null) {
                    Address location = address.get(0);
                    ExhibitorDetailFragment.this.lat = location.getLatitude();
                    ExhibitorDetailFragment.this.lon = location.getLongitude();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ExhibitorDetailFragment.this.locationerror = true;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (ExhibitorDetailFragment.this.dialog.isShowing()) {
                ExhibitorDetailFragment.this.dialog.dismiss();
            }
            ExhibitorDetailFragment.this.showPlaces();
            super.onPostExecute(result);
        }
    }

    public void showPlaces() {
        if (this.locationerror && this.showplaces) {
            Toast.makeText(getActivity(), "Service to retrieve location is not available, please try again later...", 0).show();
        } else if (this.showplaces) {
            this.showplaces = false;
        }
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5345));
        }
        if (C1199DB.getSize("socialshare", "launcherid", C1199DB.getFirstObject("launchers", "moduletypeid", "2").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 55));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
            case 55:
                share();
                return;
            case 5345:
                Fragments.add(this, AddNoteFragment.newInstance(DBFavorites.TABLE_EXHIBITORS, this.tco.get(DBFavorites.KEY_EVENT_ID)), "");
                return;
            default:
                return;
        }
    }

    public void share() {
        Intent textIntent = new Intent("android.intent.action.SEND");
        Intent mailIntent = new Intent("android.intent.action.SEND");
        Intent imageIntent = new Intent("android.intent.action.SEND");
        textIntent.setType("text/plain");
        mailIntent.setType("message/rfc822");
        imageIntent.setType("image/*");
        textIntent.putExtra("android.intent.extra.SUBJECT", this.tco.get(DBFavorites.KEY_NAME));
        textIntent.putExtra("android.intent.extra.TEXT", this.tco.get(DBFavorites.KEY_NAME));
        mailIntent.putExtra("android.intent.extra.SUBJECT", this.tco.get(DBFavorites.KEY_NAME));
        mailIntent.putExtra("android.intent.extra.TEXT", this.tco.get(DBFavorites.KEY_NAME));
        imageIntent.putExtra("android.intent.extra.SUBJECT", this.tco.get(DBFavorites.KEY_NAME));
        imageIntent.putExtra("android.intent.extra.TEXT", this.tco.get(DBFavorites.KEY_NAME));
        Intent chooser = Intent.createChooser(imageIntent, "Share");
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{mailIntent, textIntent});
        startActivity(chooser);
    }
}
