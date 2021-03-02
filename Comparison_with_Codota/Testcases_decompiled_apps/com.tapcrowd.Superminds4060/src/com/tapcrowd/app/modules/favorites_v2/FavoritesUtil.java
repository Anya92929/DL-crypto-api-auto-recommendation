package com.tapcrowd.app.modules.favorites_v2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.views.Cell;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.Locale;

public class FavoritesUtil {
    private static String moduleName;
    private Cell cell;
    /* access modifiers changed from: private */
    public Context context;
    private String eventid;
    /* access modifiers changed from: private */
    public Fragment fragment;

    /* renamed from: id */
    private String f2034id;
    private String name;
    private View.OnClickListener ocl;
    private View parent;
    private String startdate;
    private Type type;

    public enum Type {
        Sessions,
        Exhibitors
    }

    public FavoritesUtil(Fragment fragment2, Context context2, View parent2, Type type2, String id, String eventid2, String name2) {
        this.ocl = new View.OnClickListener() {
            public void onClick(View v) {
                final SharedPreferences pref = FavoritesUtil.this.context.getSharedPreferences("TapCrowd", 0);
                if (pref.getString("email", (String) null) == null) {
                    EmailDialog dialog = new EmailDialog(FavoritesUtil.this.context, "");
                    dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            SharedPreferences.Editor edit = pref.edit();
                            edit.putString("email", "");
                            edit.commit();
                            FavoritesUtil.this.handleAdd();
                        }
                    });
                    dialog.show();
                    return;
                }
                FavoritesUtil.this.handleAdd();
            }
        };
        this.fragment = fragment2;
        this.context = context2;
        this.parent = parent2;
        this.type = type2;
        this.f2034id = id;
        this.eventid = eventid2;
        this.name = name2;
    }

    public FavoritesUtil(Fragment fragment2, Context context2, View parent2, Type type2, String id, String eventid2, String name2, String startDate) {
        this(fragment2, context2, parent2, type2, id, eventid2, name2);
        this.startdate = startDate;
    }

    public void addCell() {
        if (hasModule()) {
            this.cell = C1232UI.addCell(this.parent, getText(), this.ocl, C1232UI.getColorOverlay((int) C0846R.drawable.icon_persprog, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
    }

    public void updateCell() {
        if (this.cell != null) {
            this.cell.setText(getText());
        }
    }

    private void addToFavorites() {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this.fragment.getActivity());
        alertbox.setMessage(this.fragment.getString(C0846R.string.addedtoconferencebag).replace("**replace**", getModuleName()));
        alertbox.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        alertbox.setNegativeButton(this.fragment.getString(C0846R.string.showprog).replace("**replace**", getModuleName()), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Fragments.add(FavoritesUtil.this.fragment, FavoritesFragment.newInstance(), FavoritesUtil.this.getModuleName());
            }
        });
        alertbox.show();
        updateCell();
    }

    private String getText() {
        if (isFavorite()) {
            return this.context.getString(C0846R.string.removepersprog).replace("**replace**", getModuleName());
        }
        return this.context.getString(C0846R.string.addtopersprog).replace("**replace**", getModuleName());
    }

    private boolean hasModule() {
        return C1199DB.getSize("launchers", new StringBuilder("eventid == '").append(this.eventid).append("' AND moduletypeid").toString(), "74") > 0;
    }

    private boolean isFavorite() {
        DBFavorites db = new DBFavorites(App.act);
        if (this.type == Type.Exhibitors) {
            if (db.getByEventId(this.f2034id, DBFavorites.TABLE_EXHIBITORS) != null) {
                return true;
            }
            return false;
        } else if (this.type != Type.Sessions) {
            return false;
        } else {
            if (db.getByEventId(this.f2034id, "sessions") == null) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public String getModuleName() {
        if (moduleName == null) {
            moduleName = C1199DB.getFirstObject("launchers", "moduletypeid", "74").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        return moduleName;
    }

    /* access modifiers changed from: private */
    public void handleAdd() {
        DBFavorites db = new DBFavorites(this.context);
        if (this.type == Type.Exhibitors) {
            if (isFavorite()) {
                db.deleteExhibitorByEventId(this.f2034id);
                updateCell();
                return;
            }
            db.createExhibition(this.f2034id, this.name, this.type.toString());
            addToFavorites();
        } else if (this.type != Type.Sessions) {
        } else {
            if (isFavorite()) {
                db.deleteSessionByEventId(this.f2034id);
                updateCell();
                return;
            }
            db.createSession(this.f2034id, this.name, this.type.toString(), this.startdate);
            addToFavorites();
        }
    }

    private class EmailDialog extends Dialog implements View.OnClickListener {
        Context context;
        EditText email;
        String emailStr;
        TextView title;

        public EmailDialog(Context context2, String email2) {
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
            this.email = (EditText) v.findViewById(C0846R.C0847id.email);
            this.email.setInputType(33);
            if (this.emailStr != null) {
                this.email.setText(this.emailStr);
            }
            v.setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
            this.title.setText(C1199DB.getFirstObject("launchers", "moduletypeid", "74").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).toUpperCase(Locale.ENGLISH));
            this.title.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
            this.title.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            Button ok = (Button) v.findViewById(C0846R.C0847id.f1990ok);
            ok.setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolor));
            ok.setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
            ok.setOnClickListener(this);
            Button cancel = (Button) v.findViewById(C0846R.C0847id.cancel);
            cancel.setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolor));
            cancel.setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
            cancel.setOnClickListener(this);
            setContentView(v, new ViewGroup.LayoutParams((((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth() / 5) * (App.tablet ? 3 : 4), -1));
        }

        public void onClick(View v) {
            SharedPreferences pref = getContext().getSharedPreferences("TapCrowd", 0);
            if (v.getId() == C0846R.C0847id.f1990ok) {
                if (this.email.getText().toString().contains("@")) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("email", this.email.getText().toString());
                    TCAnalytics.log(this.context, "email", this.email.getText().toString());
                    editor.commit();
                    dismiss();
                    FavoritesUtil.this.handleAdd();
                    return;
                }
                Toast.makeText(App.act, App.act.getString(C0846R.string.invalidemail), 1).show();
            } else if (v.getId() == C0846R.C0847id.cancel) {
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("email", "");
                edit.commit();
                dismiss();
                FavoritesUtil.this.handleAdd();
            }
        }
    }
}
