package p006nl.volkerinfradesign.checkandroid.p007ui.splashScreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.p001v4.app.FragmentActivity;
import android.widget.ImageView;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.MainActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.splashScreen.SplashActivity */
public class SplashActivity extends FragmentActivity {

    /* renamed from: k */
    private final int f5482k = 1200;

    public App getApp() {
        return (App) getApplication();
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(getApp().getModel().getCustomTheme().getSplashStyle());
        setContentView(C1352R.layout.splashscreen);
        Account account = getApp().getModel().getAccount();
        final ImageView imageView = (ImageView) findViewById(C1352R.C1354id.splashFlag);
        if (account != null) {
            account.getCompanyLogo(new Account.LogoCallback() {
                public void onStart() {
                }

                public void onSuccess(Bitmap bitmap) {
                    if (imageView.isShown()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }

                public void onFinish() {
                }
            });
        }
        if (getApp().getState().getName().equals("WAVE")) {
            ((ImageView) findViewById(C1352R.C1354id.ic_app)).setImageDrawable(getResources().getDrawable(C1352R.C1353drawable.wave));
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                App.getAesEncrypter();
            }
        }, 10);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        }, 1200);
    }
}
