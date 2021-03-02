package p006nl.volkerinfradesign.checkandroid.p007ui.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p004v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.help.HelpActivity */
public class HelpActivity extends AppCompatActivity {
    public App getApp() {
        return (App) getApplication();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(getApp().getModel().getCustomTheme().getMainStyle());
        setContentView(C1352R.layout.help);
        Account account = getApp().getModel().getAccount();
        Button button = (Button) findViewById(C1352R.C1354id.help_helpdesk);
        Button button2 = (Button) findViewById(C1352R.C1354id.help_manual);
        Button button3 = (Button) findViewById(C1352R.C1354id.help_community);
        ActionBarCompat actionBarCompat = new ActionBarCompat(this);
        button2.setMovementMethod(LinkMovementMethod.getInstance());
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.dropbox.com/s/c08fhb1t4jozehq/Gebruikers%20handleiding.pdf?dl=0"));
                HelpActivity.this.startActivity(intent);
            }
        });
        button3.setMovementMethod(LinkMovementMethod.getInstance());
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://plus.google.com/communities/108706304042429421464"));
                HelpActivity.this.startActivity(intent);
            }
        });
        if (account != null) {
            final String str = "tel:" + account.getHelpNumber();
            button.setMovementMethod(LinkMovementMethod.getInstance());
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(str));
                    HelpActivity.this.startActivity(intent);
                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(HelpActivity.this, "Geen helpdesk aanwezig.", 1).show();
                }
            });
        }
        actionBarCompat.setDisplayHomeAsUpEnabled(true);
    }
}
