package com.tapcrowd.app.utils;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.NotificationToSessionDetail;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.views.Cell;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonalProgramUtil {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$utils$PersonalProgramUtil$Type;
    private static String moduleName;
    private String analytics;
    private Cell cell;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String eventid;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2129id;
    private String itemModuleName;
    private String moduleTypeId;
    private View.OnClickListener ocl = new View.OnClickListener() {
        public void onClick(View v) {
            if (PersonalProgramUtil.this.isFavorite()) {
                C1199DB.remove("persprog", String.valueOf(PersonalProgramUtil.this.type.toString()) + DBFavorites.KEY_EVENT_ID, PersonalProgramUtil.this.f2129id);
                if (PersonalProgramUtil.this.type == Type.session) {
                    PersonalProgramUtil.this.cancelNotification();
                }
                PersonalProgramSync.remove(PersonalProgramUtil.this.context, PersonalProgramUtil.this.eventid, PersonalProgramUtil.this.type.toString(), PersonalProgramUtil.this.f2129id);
            } else {
                ContentValues cv = new ContentValues();
                cv.put(String.valueOf(PersonalProgramUtil.this.type.toString()) + DBFavorites.KEY_EVENT_ID, PersonalProgramUtil.this.f2129id);
                cv.put("eventid", PersonalProgramUtil.this.eventid);
                C1199DB.write("persprog", cv);
                AlertDialog.Builder alertbox = new AlertDialog.Builder(PersonalProgramUtil.this.context);
                alertbox.setMessage(PersonalProgramUtil.this.context.getString(PersonalProgramUtil.this.getAlertMessage()).replace("**replace**", PersonalProgramUtil.this.getModuleName()));
                alertbox.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
                alertbox.show();
                if (PersonalProgramUtil.this.type == Type.session) {
                    PersonalProgramUtil.this.createNotifaction();
                }
                PersonalProgramSync.add(PersonalProgramUtil.this.context, PersonalProgramUtil.this.eventid, PersonalProgramUtil.this.type.toString(), PersonalProgramUtil.this.f2129id);
            }
            PersonalProgramUtil.this.updateCell();
        }
    };
    private View parent;
    /* access modifiers changed from: private */
    public Type type;

    public enum Type {
        session,
        exhibitors,
        catalog
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$utils$PersonalProgramUtil$Type() {
        int[] iArr = $SWITCH_TABLE$com$tapcrowd$app$utils$PersonalProgramUtil$Type;
        if (iArr == null) {
            iArr = new int[Type.values().length];
            try {
                iArr[Type.catalog.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Type.exhibitors.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Type.session.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$tapcrowd$app$utils$PersonalProgramUtil$Type = iArr;
        }
        return iArr;
    }

    public PersonalProgramUtil(Context context2, View parent2, Type type2, String id, String eventid2, String analytics2) {
        this.context = context2;
        this.parent = parent2;
        this.type = type2;
        this.f2129id = id;
        this.eventid = eventid2;
        this.analytics = analytics2;
    }

    public void addCell() {
        if (hasModule()) {
            this.cell = C1232UI.addCell(this.parent, getText(), this.ocl, C1232UI.getColorOverlay((int) C0846R.drawable.icon_persprog, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
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
            return this.context.getString(C0846R.string.removepersprog).replace("**replace**", getModuleName());
        }
        return this.context.getString(C0846R.string.addtopersprog).replace("**replace**", getModuleName());
    }

    private boolean hasModule() {
        return C1199DB.getSize("launchers", new StringBuilder("eventid == '").append(this.eventid).append("' AND moduletypeid").toString(), "43") > 0;
    }

    /* access modifiers changed from: private */
    public boolean isFavorite() {
        return C1199DB.getSize("persprog", new StringBuilder(String.valueOf(this.type.toString())).append(DBFavorites.KEY_EVENT_ID).toString(), this.f2129id) > 0;
    }

    private String getModuleTypeId() {
        if (this.moduleTypeId != null) {
            return this.moduleTypeId;
        }
        switch ($SWITCH_TABLE$com$tapcrowd$app$utils$PersonalProgramUtil$Type()[this.type.ordinal()]) {
            case 1:
                this.moduleTypeId = "10";
                break;
            case 2:
                this.moduleTypeId = "2";
                break;
            case 3:
                this.moduleTypeId = "15";
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

    /* access modifiers changed from: private */
    public String getModuleName() {
        if (moduleName == null) {
            moduleName = C1199DB.getFirstObject("launchers", "moduletypeid", "43").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        return moduleName;
    }

    /* access modifiers changed from: private */
    public int getAlertMessage() {
        if (this.type == Type.session) {
            return C0846R.string.addedtopersprogsess;
        }
        return C0846R.string.addedtopersprog;
    }

    /* access modifiers changed from: private */
    public void cancelNotification() {
        Intent intent = new Intent(this.context, NotificationToSessionDetail.class);
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.context.getString(C0846R.string.detail));
        intent.putExtra(DBFavorites.KEY_EVENT_ID, this.f2129id);
        TCObject tco = C1199DB.getFirstObject("sessions", DBFavorites.KEY_EVENT_ID, this.f2129id);
        String datum = tco.get(DBFavorites.KEY_SESSION_STARTDATE);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Date parsed = new Date();
        try {
            parsed = format.parse(datum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsed);
        calendar.add(12, -15);
        Notifications.cancelNotification(intent, this.f2129id, tco.get(DBFavorites.KEY_NAME), "Starts in 15 minutes.", C0846R.drawable.icon, calendar.getTimeInMillis());
    }

    /* access modifiers changed from: private */
    public void createNotifaction() {
        Intent intent = new Intent(this.context, NotificationToSessionDetail.class);
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.context.getString(C0846R.string.detail));
        intent.putExtra(DBFavorites.KEY_EVENT_ID, this.f2129id);
        TCObject tco = C1199DB.getFirstObject("sessions", DBFavorites.KEY_EVENT_ID, this.f2129id);
        String datum = tco.get(DBFavorites.KEY_SESSION_STARTDATE);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Date parsed = new Date();
        try {
            parsed = format.parse(datum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsed);
        calendar.add(12, -15);
        if (calendar.getTimeInMillis() > System.currentTimeMillis()) {
            Notifications.createNotification(this.context, intent, this.f2129id, tco.get(DBFavorites.KEY_NAME), "Starts in 15 minutes.", C0846R.drawable.icon, calendar.getTimeInMillis());
        }
    }
}
