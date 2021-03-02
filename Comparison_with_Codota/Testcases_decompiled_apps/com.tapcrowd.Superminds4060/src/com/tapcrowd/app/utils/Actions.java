package com.tapcrowd.app.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.p000v4.app.Fragment;
import android.text.Spanned;
import android.widget.Toast;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.modules.webview.FormFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Actions {
    public static void doCall(String tel) {
        if (!App.act.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            Toast.makeText(App.act, App.act.getString(C0846R.string.notelephone), 1).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(App.act);
        builder.setMessage(String.valueOf(App.act.getString(C0846R.string.docall)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + tel + "?");
        final String ftel = tel.replace("(0)", "");
        builder.setCancelable(false);
        builder.setPositiveButton(App.act.getString(17039379), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                App.act.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ftel)));
            }
        });
        builder.setNegativeButton(App.act.getString(17039369), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    public static void doMail(String email) {
        Intent sendIntent = new Intent("android.intent.action.SEND");
        sendIntent.putExtra("android.intent.extra.EMAIL", new String[]{email});
        sendIntent.setType("message/rfc822");
        App.act.startActivity(Intent.createChooser(sendIntent, "Mail:"));
    }

    public static void doMail(String email, Spanned content) {
        Intent sendIntent = new Intent("android.intent.action.SEND");
        sendIntent.putExtra("android.intent.extra.EMAIL", new String[]{email});
        sendIntent.putExtra("android.intent.extra.TEXT", content);
        sendIntent.setType("message/rfc822");
        App.act.startActivity(Intent.createChooser(sendIntent, "Mail:"));
    }

    public static void doMail(NotesFragment notesFragment, String email, ArrayList<String> content, ArrayList<Uri> uris) {
        Intent sendIntent = new Intent("android.intent.action.SEND_MULTIPLE");
        sendIntent.putExtra("android.intent.extra.EMAIL", new String[]{email});
        sendIntent.putExtra("android.intent.extra.TEXT", content);
        sendIntent.putExtra("android.intent.extra.STREAM", uris);
        sendIntent.setType("message/rfc822");
        notesFragment.startActivityForResult(Intent.createChooser(sendIntent, "Mail:"), 777);
    }

    public static void doNavigate(String adres) {
        try {
            App.act.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + adres)));
        } catch (Exception e) {
        }
    }

    public static void openBrowser(String url) {
        Intent i = new Intent("android.intent.action.VIEW");
        if (url.indexOf("http://") == -1) {
            url = String.valueOf(url) + "http://";
        }
        i.setData(Uri.parse(url));
        App.act.startActivity(i);
    }

    public static void openWebview(Fragment fr, String url) {
        Fragments.add(fr, WebViewFragment.newInstance(url, ""), (String) null);
    }

    public static void openForm(Fragment fr, String url) {
        Fragments.add(fr, FormFragment.newInstance(url, ""), (String) null);
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        intent.addFlags(8);
        return packageManager.queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void addToContacts(String name, String phonenr, String email, String address) {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        if (name != null) {
            intent.putExtra(DBFavorites.KEY_NAME, name);
        }
        if (phonenr != null) {
            intent.putExtra("phone", phonenr);
        }
        if (email != null) {
            intent.putExtra("email", email);
        }
        if (address != null) {
            intent.putExtra("postal", address);
        }
        App.act.startActivityForResult(intent, 14521);
    }

    public static void addToCalander(String start, String end, String title, String description, String location) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        new Date();
        new Date();
        try {
            Date startDate = format.parse(start);
            Date endDate = format.parse(end);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, title);
            intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
            intent.putExtra("eventLocation", location);
            intent.putExtra("beginTime", startDate.getTime());
            intent.putExtra("endTime", endDate.getTime());
            intent.putExtra("allDay", true);
            App.act.startActivity(intent);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
