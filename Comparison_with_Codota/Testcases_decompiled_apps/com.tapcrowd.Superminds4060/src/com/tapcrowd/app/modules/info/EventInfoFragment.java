package com.tapcrowd.app.modules.info;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCListObject2;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.Separator;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;

public class EventInfoFragment extends TCFragment {
    int contentid;

    /* renamed from: id */
    String f2050id;
    TCObject oEventVenue;
    TCObject tco;

    /* renamed from: v */
    View f2051v;

    public static EventInfoFragment newInstance(String id) {
        EventInfoFragment detail = new EventInfoFragment();
        detail.f2050id = id;
        return detail;
    }

    public void onResume() {
        super.onResume();
        if (this.tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.tco.get("loggingpath"), "");
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2050id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AdHelper.showAds(this, AdHelper.buildPath("21", "detail", this.f2050id));
        if (this.f2051v == null) {
            this.f2051v = inflater.inflate(C0846R.layout.infoevent, container, false);
            if (savedInstanceState != null && this.f2050id == null) {
                this.f2050id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            }
            this.tco = C1199DB.getObject("events", DBFavorites.KEY_EVENT_ID, this.f2050id);
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.website)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.address)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.action)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.telefoon)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.description)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.ticket)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.lbltravinfo)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.email)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.naamEvent)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.fromtoDate)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.abouttap)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.addtocalendar)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            C1232UI.setTitle("Info");
            if (this.tco.has("datefrom") && this.tco.has("dateto") && !this.tco.get("datefrom").equals("1970-01-01")) {
                ((ImageView) this.f2051v.findViewById(C0846R.C0847id.save)).setImageDrawable(C1232UI.getColorOverlay((int) C0846R.drawable.icon_persprog, C1216LO.getLo(C1216LO.navigationColor)));
                C1232UI.show(C0846R.C0847id.actionaddtocalendar, this.f2051v);
                C1232UI.show(C0846R.C0847id.sepCall, this.f2051v);
                this.f2051v.findViewById(C0846R.C0847id.actionaddtocalendar).setBackgroundDrawable(C1232UI.getBackground());
                this.f2051v.findViewById(C0846R.C0847id.actionaddtocalendar).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        EventInfoFragment.this.save((View) null);
                    }
                });
            }
            ((LinearLayout) this.f2051v.findViewById(C0846R.C0847id.header)).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            C1232UI.setText((int) C0846R.C0847id.naamEvent, this.tco.get(DBFavorites.KEY_NAME), this.f2051v);
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.naamEvent)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
            C1232UI.setText((int) C0846R.C0847id.fromtoDate, Converter.datesToString(this.tco.get("datefrom"), this.tco.get("dateto")), this.f2051v);
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.fromtoDate)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
            if (!this.tco.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)) {
                C1232UI.hide(C0846R.C0847id.sepDescrip, this.f2051v);
                C1232UI.hide(C0846R.C0847id.description, this.f2051v);
            }
            C1232UI.setText((int) C0846R.C0847id.description, this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), this.f2051v);
            List<TCObject> schedule = C1199DB.getListFromDb("schedules", "eventid", this.tco.get(DBFavorites.KEY_EVENT_ID), "sortorder +0 DESC");
            LinearLayout ll = (LinearLayout) this.f2051v.findViewById(C0846R.C0847id.container);
            if (schedule.size() > 0) {
                Separator separator = new Separator((Context) getActivity());
                separator.setText(getResourceString(C0846R.string.sepHours));
                ll.addView(separator);
            }
            for (int i = 0; i < schedule.size(); i++) {
                TCObject tco2 = schedule.get(i);
                String str = tco2.get(Globalization.DATE);
                String date = tco2.get("key");
                String caption = tco2.get("caption");
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.setPadding(20, 20, 20, 20);
                TextView textView = new TextView(App.act);
                textView.setTextColor(C1216LO.getLo(C1216LO.textcolor));
                textView.setText(caption);
                textView.setTextSize(1, 11.0f);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView.setPadding(0, 0, 0, 5);
                linearLayout.addView(textView);
                TextView textView2 = new TextView(App.act);
                textView2.setTextColor(C1216LO.getLo(C1216LO.textcolor));
                textView2.setText(date);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.addView(textView2);
                View v = new View(getActivity());
                v.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) Converter.convertDpToPixel(1.0f, getActivity())));
                v.setBackgroundColor(C1216LO.getLo(C1216LO.cellSeparator));
                C1232UI.setFont((ViewGroup) linearLayout);
                ll.addView(linearLayout);
                ll.addView(v);
            }
            this.oEventVenue = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.tco.get("venueid"));
            if (this.oEventVenue.has("address")) {
                String address = "";
                if (this.oEventVenue.has(DBFavorites.KEY_NAME)) {
                    address = String.valueOf(address) + this.oEventVenue.get(DBFavorites.KEY_NAME) + "\n";
                }
                String address2 = String.valueOf(address) + this.oEventVenue.get("address");
                if (address2.startsWith(", ")) {
                    address2 = address2.replace(", ", "");
                }
                C1232UI.setText(C0846R.C0847id.action, address2, this.f2051v);
                ((TextView) this.f2051v.findViewById(C0846R.C0847id.action)).setCompoundDrawables(C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            C1232UI.setText((int) C0846R.C0847id.telefoon, this.tco.get("phonenr"), this.f2051v);
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.telefoon)).setCompoundDrawables(C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor)), (Drawable) null, (Drawable) null, (Drawable) null);
            C1232UI.setText((int) C0846R.C0847id.email, this.tco.get("email"), this.f2051v);
            ((TextView) this.f2051v.findViewById(C0846R.C0847id.email)).setCompoundDrawables(C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor)), (Drawable) null, (Drawable) null, (Drawable) null);
            if (this.tco.has("eventlogobig")) {
                new FastImageLoader().DisplayImage(this.tco.get("eventlogobig"), (ImageView) this.f2051v.findViewById(C0846R.C0847id.icon));
            } else {
                this.f2051v.findViewById(C0846R.C0847id.icon).setVisibility(8);
            }
            if (this.tco.get("ticketlink") == null) {
                this.f2051v.findViewById(C0846R.C0847id.tick).setVisibility(8);
                this.f2051v.findViewById(C0846R.C0847id.sepTicket).setVisibility(8);
            } else {
                this.f2051v.findViewById(C0846R.C0847id.tick).setBackgroundDrawable(C1232UI.getBackground());
                ((TextView) this.f2051v.findViewById(C0846R.C0847id.ticket)).setText(C0846R.string.buyticket);
                ((TextView) this.f2051v.findViewById(C0846R.C0847id.ticket)).setCompoundDrawables(C1232UI.getColorOverlay((int) C0846R.drawable.icon_ticket_black, C1216LO.getLo(C1216LO.actionImageOverlayColor)), (Drawable) null, (Drawable) null, (Drawable) null);
                ((RelativeLayout) this.f2051v.findViewById(C0846R.C0847id.tick)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Actions.openWebview(EventInfoFragment.this, EventInfoFragment.this.tco.get("ticketlink"));
                    }
                });
            }
            TCObject app = C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT);
            if (!app.has("channel")) {
                C1232UI.hide(C0846R.C0847id.sepAboutTap, this.f2051v);
                C1232UI.hide(C0846R.C0847id.abouttap, this.f2051v);
                C1232UI.hide(C0846R.C0847id.aboutTap, this.f2051v);
            } else if (app.get("channel").equals("9")) {
                ((TextView) this.f2051v.findViewById(C0846R.C0847id.abouttap)).setText("Belgacom Mobile Applications");
                ((Separator) this.f2051v.findViewById(C0846R.C0847id.sepAboutTap)).setText((String.valueOf(getResourceString(C0846R.string.sepaboutTap)) + " belgacom").toUpperCase());
                ((LinearLayout) this.f2051v.findViewById(C0846R.C0847id.aboutTap)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    }
                });
            } else {
                C1232UI.hide(C0846R.C0847id.sepAboutTap, this.f2051v);
                C1232UI.hide(C0846R.C0847id.abouttap, this.f2051v);
                C1232UI.hide(C0846R.C0847id.aboutTap, this.f2051v);
            }
            if (this.oEventVenue.get("address") == null) {
                this.f2051v.findViewById(C0846R.C0847id.navigate).setVisibility(8);
                this.f2051v.findViewById(C0846R.C0847id.address).setVisibility(8);
                this.f2051v.findViewById(C0846R.C0847id.sepNav).setVisibility(8);
            } else {
                this.f2051v.findViewById(C0846R.C0847id.contadress).setVisibility(8);
                RelativeLayout lstNavigeer = (RelativeLayout) this.f2051v.findViewById(C0846R.C0847id.navigate);
                lstNavigeer.setBackgroundDrawable(C1232UI.getBackground());
                lstNavigeer.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Actions.doNavigate(EventInfoFragment.this.oEventVenue.get("address"));
                    }
                });
            }
            if (!this.oEventVenue.has("travelinfo") || this.oEventVenue.get("travelinfo").equals("null")) {
                this.f2051v.findViewById(C0846R.C0847id.travinfo).setVisibility(8);
            } else {
                this.f2051v.findViewById(C0846R.C0847id.travinfo).setVisibility(0);
                this.f2051v.findViewById(C0846R.C0847id.travinfo).setBackgroundDrawable(C1232UI.getBackground());
                ((TextView) this.f2051v.findViewById(C0846R.C0847id.lbltravinfo)).setCompoundDrawables(C1232UI.getColorOverlay((int) C0846R.drawable.icon_info, C1216LO.getLo(C1216LO.actionImageOverlayColor)), (Drawable) null, (Drawable) null, (Drawable) null);
                this.f2051v.findViewById(C0846R.C0847id.travinfo).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String travinfo = EventInfoFragment.this.oEventVenue.get("travelinfo");
                        if (travinfo != null) {
                            travinfo = Html.fromHtml(travinfo).toString();
                        }
                        Fragments.add(EventInfoFragment.this, WebViewFragment.newInstance(travinfo, (String) null, ""), EventInfoFragment.this.getResourceString(C0846R.string.travel));
                    }
                });
            }
            int showSepCont = 0;
            if (this.tco.get("phonenr") == null) {
                this.f2051v.findViewById(C0846R.C0847id.actionphone).setVisibility(8);
            } else {
                this.f2051v.findViewById(C0846R.C0847id.actionphone).setBackgroundDrawable(C1232UI.getBackground());
                showSepCont = 0 + 1;
                ((ViewGroup) this.f2051v.findViewById(C0846R.C0847id.actionphone)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Actions.doCall(EventInfoFragment.this.tco.get("phonenr"));
                    }
                });
            }
            if (this.tco.get("email") == null) {
                this.f2051v.findViewById(C0846R.C0847id.sendmail).setVisibility(8);
            } else {
                showSepCont++;
                this.f2051v.findViewById(C0846R.C0847id.sendmail).setBackgroundDrawable(C1232UI.getBackground());
                ((ViewGroup) this.f2051v.findViewById(C0846R.C0847id.sendmail)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Actions.doMail(EventInfoFragment.this.tco.get("email"));
                    }
                });
            }
            if (this.tco.get("website") == null) {
                this.f2051v.findViewById(C0846R.C0847id.showwebsite).setVisibility(8);
            } else {
                showSepCont++;
                this.f2051v.findViewById(C0846R.C0847id.showwebsite).setBackgroundDrawable(C1232UI.getBackground());
                ((TextView) this.f2051v.findViewById(C0846R.C0847id.website)).setCompoundDrawables(C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor)), (Drawable) null, (Drawable) null, (Drawable) null);
                ((ViewGroup) this.f2051v.findViewById(C0846R.C0847id.showwebsite)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Actions.openWebview(EventInfoFragment.this, EventInfoFragment.this.tco.get("website"));
                    }
                });
            }
            if (this.tco.get(DBFavorites.KEY_EVENT_ID, "").equals(this.f2050id)) {
                LayoutInflater li = getActivity().getLayoutInflater();
                List<TCObject> listFromDb = C1199DB.getListFromDb("sponsorgroups", "eventid", this.f2050id, "order_value");
                List<TCObject> metadatas = C1199DB.getListFromDb("metadata", "table_value == 'event' AND identifier", this.tco.get(DBFavorites.KEY_EVENT_ID));
                LinearLayout metadataTap = (LinearLayout) this.f2051v.findViewById(C0846R.C0847id.metadataTap);
                for (TCObject metadata : metadatas) {
                    metadataTap.addView(new Separator(metadata.get("key")));
                    LinearLayout holder = (LinearLayout) li.inflate(C0846R.layout.cell_infoevent, (ViewGroup) null);
                    TextView tv = (TextView) holder.findViewById(C0846R.C0847id.text);
                    tv.setText(metadata.get("value"));
                    tv.setTextColor(C1216LO.getLo(C1216LO.textcolor));
                    Drawable img = getResources().getDrawable(C0846R.drawable.kids);
                    img.setBounds(0, 0, 40, 53);
                    tv.setCompoundDrawables(img, (Drawable) null, (Drawable) null, (Drawable) null);
                    holder.findViewById(C0846R.C0847id.poiarrow).setVisibility(8);
                    ((LinearLayout) holder.findViewById(C0846R.C0847id.parent)).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    metadataTap.addView(holder);
                }
            }
            if (showSepCont == 0) {
                this.f2051v.findViewById(C0846R.C0847id.sepCont).setVisibility(8);
            }
            if (App.typeid.equals("10")) {
                this.f2051v.findViewById(C0846R.C0847id.header).setVisibility(8);
                this.f2051v.findViewById(C0846R.C0847id.scroller).setVisibility(8);
                C1232UI.show(C0846R.C0847id.fakelistviewitems);
                List<TCObject> metadata2 = C1199DB.getQueryFromDb("SELECT * FROM metadata WHERE appid = '" + App.f2123id + "' AND table_value = 'event'");
                final List<TCListObject2> listData = new ArrayList<>();
                for (TCObject tco3 : metadata2) {
                    TCListObject2 tlo = new TCListObject2();
                    tlo.f2134id = tco3.get(DBFavorites.KEY_EVENT_ID);
                    tlo.setField(C0846R.C0847id.text, tco3.get("key"));
                    tlo.setField(C0846R.C0847id.sub1, (String) null);
                    tlo.setField(C0846R.C0847id.sub2, (String) null);
                    tlo.img = "";
                    tlo.celLayout = C0846R.layout.cell_tcobject;
                    listData.add(tlo);
                }
                ((ListView) this.f2051v.findViewById(C0846R.C0847id.list)).setAdapter(new TCListObject2.TCListObjectAdapter2(listData));
                ((ListView) this.f2051v.findViewById(C0846R.C0847id.list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                        TCObject value = C1199DB.getFirstObject("metadata", DBFavorites.KEY_EVENT_ID, ((TCListObject2) listData.get(position)).f2134id);
                        if (value.get("value").length() <= 7) {
                            return;
                        }
                        if (((String) value.get("value").subSequence(0, 7)).contains("http://")) {
                            Actions.openWebview(EventInfoFragment.this, value.get("value"));
                        } else {
                            Fragments.add(EventInfoFragment.this, WebViewFragment.newInstance(value.get("value", false).replace("\n", "<br />"), (String) null, (String) null), value.get("key"));
                        }
                    }
                });
            }
            C1232UI.AddMetaData(this, (ViewGroup) this.f2051v.findViewById(C0846R.C0847id.container2), "event", this.f2050id, this.f2051v);
            return this.f2051v;
        }
        ((ViewGroup) this.f2051v.getParent()).removeView(this.f2051v);
        return this.f2051v;
    }

    public void save(View v) {
        Actions.addToCalander(this.tco.get("datefrom"), this.tco.get("dateto"), this.tco.get(DBFavorites.KEY_NAME, ""), this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, ""), this.oEventVenue.get("address", ""));
    }
}
