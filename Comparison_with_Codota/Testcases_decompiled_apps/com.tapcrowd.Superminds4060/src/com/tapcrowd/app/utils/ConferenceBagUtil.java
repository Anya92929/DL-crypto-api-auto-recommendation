package com.tapcrowd.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.conferencebag.FavoritesFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.images.Utils;
import com.tapcrowd.app.views.Cell;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class ConferenceBagUtil {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$utils$ConferenceBagUtil$Type;
    private static int REQUEST_CODE = 55;
    private static String moduleName;
    private String analytics;
    private Cell cell;
    /* access modifiers changed from: private */
    public String eventid;
    /* access modifiers changed from: private */
    public Fragment fragment;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2125id;
    private String itemModuleName;
    private String moduleTypeId;
    private View.OnClickListener ocl = new View.OnClickListener() {
        public void onClick(View v) {
            if (ConferenceBagUtil.this.isFavorite()) {
                ContentValues cv = new ContentValues();
                cv.put("deleted", "1");
                cv.put("synced", "0");
                C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + ConferenceBagUtil.this.f2125id + "' AND table_value == '" + ConferenceBagUtil.this.getTableName() + "'");
            } else {
                try {
                    String email = ConferenceBagUtil.this.fragment.getActivity().getSharedPreferences("TapCrowd", 0).getString("email", (String) null);
                    if (email == null) {
                        new ConfDialog(ConferenceBagUtil.this.fragment.getActivity(), email).show();
                    } else {
                        ConferenceBagUtil.this.addToConferenceBag();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ConferenceBagUtil.this.updateCell();
            Internet.synchConferencebag(new Handler());
        }
    };
    private View parent;
    private Type type;
    /* access modifiers changed from: private */
    public String venueid;

    public enum Type {
        session,
        exhibitor,
        attendee,
        catalog,
        projects,
        careers
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$utils$ConferenceBagUtil$Type() {
        int[] iArr = $SWITCH_TABLE$com$tapcrowd$app$utils$ConferenceBagUtil$Type;
        if (iArr == null) {
            iArr = new int[Type.values().length];
            try {
                iArr[Type.attendee.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Type.careers.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Type.catalog.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Type.exhibitor.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Type.projects.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Type.session.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$com$tapcrowd$app$utils$ConferenceBagUtil$Type = iArr;
        }
        return iArr;
    }

    public ConferenceBagUtil(Fragment fragment2, View parent2, Type type2, String id, String eventid2, String venueid2, String analytics2) {
        this.fragment = fragment2;
        this.parent = parent2;
        this.type = type2;
        this.f2125id = id;
        this.eventid = eventid2 == null ? "" : eventid2;
        this.venueid = venueid2 == null ? "" : venueid2;
        this.venueid = this.venueid.equals("0") ? "" : this.venueid;
        this.analytics = analytics2;
    }

    public void addCell() {
        if (hasModule()) {
            this.cell = C1232UI.addCell(this.parent, getText(), this.ocl, C1232UI.getColorOverlay((int) C0846R.drawable.icon_confbag, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            this.cell.setBackgroundDrawable(C1232UI.getBackground());
        }
    }

    public void updateCell() {
        if (this.cell != null) {
            this.cell.setText(getText());
        }
    }

    private String getText() {
        if (isFavorite()) {
            return this.fragment.getString(C0846R.string.removepersprog).replace("**replace**", getModuleName());
        }
        return this.fragment.getString(C0846R.string.addtopersprog).replace("**replace**", getModuleName());
    }

    /* access modifiers changed from: private */
    public String getModuleName() {
        if (moduleName == null) {
            moduleName = C1199DB.getFirstObject("launchers", "eventid == '" + this.eventid + "' AND moduletypeid", "42").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        return moduleName;
    }

    public boolean hasModule() {
        return C1199DB.getSize("launchers", new StringBuilder("eventid == '").append(this.eventid).append("' AND moduletypeid").toString(), "42") > 0 || C1199DB.getSize("launchers", new StringBuilder("venueid == '").append(this.venueid).append("' AND moduletypeid").toString(), "42") > 0;
    }

    /* access modifiers changed from: private */
    public boolean isFavorite() {
        return C1199DB.getQueryFromDb(new StringBuilder("SELECT * FROM personal WHERE type == 'confbag' AND tableid == '").append(this.f2125id).append("' AND table_value == '").append(getTableName()).append("' AND deleted == '0'").toString()).size() > 0;
    }

    private String getModuleTypeId() {
        if (this.moduleTypeId != null) {
            return this.moduleTypeId;
        }
        switch ($SWITCH_TABLE$com$tapcrowd$app$utils$ConferenceBagUtil$Type()[this.type.ordinal()]) {
            case 1:
                this.moduleTypeId = "10";
                break;
            case 2:
                this.moduleTypeId = "2";
                break;
            case 3:
                this.moduleTypeId = "14";
                break;
            case 4:
                this.moduleTypeId = "15";
                break;
            case 5:
                this.moduleTypeId = "25";
                break;
            case 6:
                this.moduleTypeId = "14";
                break;
        }
        return this.moduleTypeId;
    }

    private String getItemModuleName() {
        if (this.itemModuleName == null) {
            this.itemModuleName = C1199DB.getFirstObject("launchers", "moduletypeid", getModuleTypeId()).get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        return this.itemModuleName;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == -1) {
            addToConferenceBag();
        }
    }

    /* access modifiers changed from: private */
    public void addToConferenceBag() {
        C1199DB.getQueryFromDb("INSERT INTO personal(id, appid, eventid, venueid, email, table_value, tableid, extra, type, deleted, synced) VALUES('" + Utils.generateId() + "', '" + App.f2123id + "', '" + this.eventid + "', '" + this.venueid + "', '" + this.fragment.getActivity().getSharedPreferences("TapCrowd", 0).getString("email", "") + "', '" + getTableName() + "', '" + this.f2125id + "', '', 'confbag', '0', '0')");
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this.fragment.getActivity());
        alertbox.setMessage(this.fragment.getString(C0846R.string.addedtoconferencebag).replace("**replace**", getModuleName()));
        alertbox.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        alertbox.setNegativeButton(this.fragment.getString(C0846R.string.showprog).replace("**replace**", getModuleName()), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Fragments.add(ConferenceBagUtil.this.fragment, FavoritesFragment.newInstance(ConferenceBagUtil.this.eventid.equals("") ? "venueid" : "eventid", ConferenceBagUtil.this.eventid.equals("") ? ConferenceBagUtil.this.venueid : ConferenceBagUtil.this.eventid), ConferenceBagUtil.this.getModuleName());
            }
        });
        alertbox.show();
        updateCell();
    }

    public String getTableName() {
        switch ($SWITCH_TABLE$com$tapcrowd$app$utils$ConferenceBagUtil$Type()[this.type.ordinal()]) {
            case 1:
                return "sessions";
            case 2:
                return DBFavorites.TABLE_EXHIBITORS;
            case 3:
                return LinkedObjects.TABLE_ATT;
            case 4:
                return LinkedObjects.TABLE_CAT;
            case 5:
                return "projects";
            case 6:
                return "careers";
            default:
                return this.type.toString();
        }
    }

    private class ConfDialog extends Dialog implements View.OnClickListener {
        Context context;
        EditText email;
        String emailStr;

        /* renamed from: ok */
        Button f2126ok;
        TextView title;

        public ConfDialog(Context context2, String email2) {
            super(context2, C0846R.style.transparentDialogTheme);
            requestWindowFeature(1);
            this.context = context2;
            this.emailStr = email2;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View v = getLayoutInflater().inflate(C0846R.layout.confbag_dialog, (ViewGroup) null);
            this.title = (TextView) v.findViewById(C0846R.C0847id.title);
            this.f2126ok = (Button) v.findViewById(C0846R.C0847id.f1990ok);
            this.email = (EditText) v.findViewById(C0846R.C0847id.email);
            v.findViewById(C0846R.C0847id.cancel).setVisibility(8);
            if (this.emailStr != null) {
                this.email.setText(this.emailStr);
            }
            v.setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
            this.title.setText(C1199DB.getFirstObject("launchers", "moduletypeid", "42").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).toUpperCase());
            this.title.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
            this.title.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            this.f2126ok.setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolor));
            this.f2126ok.setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
            this.f2126ok.setOnClickListener(this);
            setContentView(v, new ViewGroup.LayoutParams((((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth() / 5) * (App.tablet ? 3 : 4), -1));
        }

        public void onClick(View v) {
            if (this.email.getText().toString().contains("@")) {
                SharedPreferences.Editor editor = this.context.getSharedPreferences("TapCrowd", 0).edit();
                editor.putString("email", this.email.getText().toString());
                editor.commit();
                TCAnalytics.log(this.context, "/email/" + this.email, "");
                C1199DB.getQueryFromDb("UPDATE personal SET synced = 0");
                Internet.synchConferencebag((Handler) null);
                ConferenceBagUtil.this.addToConferenceBag();
                dismiss();
                return;
            }
            Toast.makeText(this.context, this.context.getString(C0846R.string.invalidemail), 1).show();
        }
    }
}
