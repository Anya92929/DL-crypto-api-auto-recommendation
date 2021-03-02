package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gcm.CommonUtilities;
import com.forexcrunch.forexcrunch.gcm.ServerUtilities;
import com.forexcrunch.forexcrunch.gcm.WakeLocker;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.parse.ParseAnalytics;

public class SplashScreen extends Activity {
    private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String newMessage = intent.getExtras().getString(CommonUtilities.EXTRA_MESSAGE);
            WakeLocker.acquire(SplashScreen.this.getApplicationContext());
            Toast.makeText(SplashScreen.this.getApplicationContext(), "New Message: " + newMessage, 1).show();
            WakeLocker.release();
        }
    };
    AsyncTask<Void, Void, Void> mRegisterTask;
    ProgressBar progress;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.splash_screen);
        this.progress = (ProgressBar) findViewById(C0089R.idSplashScreen.progress);
        initImageLoader(this);
        new FetchNewsTask().execute(new String[0]);
        boolean register = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("notif", true);
        ParseAnalytics.trackAppOpened(getIntent());
        if (register) {
            ServerUtilities.gcmRegister(this);
        }
    }

    public static void initImageLoader(Context context) {
        int memoryCacheSize;
        if (Build.VERSION.SDK_INT >= 5) {
            memoryCacheSize = (((ActivityManager) context.getSystemService("activity")).getMemoryClass() / 8) * 1024 * 1024;
        } else {
            memoryCacheSize = 2097152;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).threadPriority(3).memoryCacheSize(memoryCacheSize).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging().build());
    }

    class FetchNewsTask extends AsyncTask<String, Void, Void> {

        /* renamed from: e */
        Exception f63e;

        FetchNewsTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SplashScreen.this.progress.setVisibility(0);
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                NewsController.getInstance(SplashScreen.this).setNewsNews(WSController.getNewsFromJson(SplashScreen.this, 53));
                NewsController.getInstance(SplashScreen.this).setOpinionsNews(WSController.getNewsFromJson(SplashScreen.this, 38));
                NewsController.getInstance(SplashScreen.this).setLatestNews(WSController.getLatestNewsFromJson(SplashScreen.this));
                NewsController.getInstance(SplashScreen.this).setFirstEURUSD(WSController.getNewsFromJson(SplashScreen.this, News.EUR_USD_DAILY, 1));
                NewsController.getInstance(SplashScreen.this).setEurusdNews(WSController.getNewsFromJson(SplashScreen.this, News.EUR_USD_FORECAST, 1));
                NewsController.getInstance(SplashScreen.this).setGbpNews(WSController.getNewsFromJson(SplashScreen.this, 512, 1));
                NewsController.getInstance(SplashScreen.this).setAudNews(WSController.getNewsFromJson(SplashScreen.this, News.AUD_USD_DAILY, 1));
                NewsController.getInstance(SplashScreen.this).setMajorsNews(WSController.getNewsFromJson(SplashScreen.this, 1132, 1));
                NewsController.getInstance(SplashScreen.this).setJpyNews(WSController.getNewsFromJson(SplashScreen.this, News.USD_JPY_FORECAST, 1));
                NewsController.getInstance(SplashScreen.this).setChfNews(WSController.getNewsFromJson(SplashScreen.this, News.USD_CHF_FORECAST, 1));
                NewsController.getInstance(SplashScreen.this).setCadNews(WSController.getNewsFromJson(SplashScreen.this, News.CANADIAN_DOLAR, 1));
                NewsController.getInstance(SplashScreen.this).setNzdNews(WSController.getNewsFromJson(SplashScreen.this, News.NZR_USD_FORECAST, 1));
                return null;
            } catch (Exception e) {
                this.f63e = e;
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            SplashScreen.this.progress.setVisibility(8);
            SplashScreen.this.showErrorDialog(SplashScreen.this.getString(C0089R.string.server_error));
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            SplashScreen.this.progress.setVisibility(8);
            if (!isCancelled()) {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, TabsActivity.class));
                SplashScreen.this.finish();
            } else {
                SplashScreen.this.showErrorDialog(SplashScreen.this.getString(C0089R.string.server_error));
            }
            super.onPostExecute(result);
        }
    }

    public void showErrorDialog(String error) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0089R.layout.error_dialog);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.rounded_shape);
        ((TextView) dialog.findViewById(C0089R.idErrorDialog.text)).setText(getString(C0089R.string.error_splash));
        Button btnSavedArticles = (Button) dialog.findViewById(C0089R.idErrorDialog.savedArticles);
        btnSavedArticles.setVisibility(0);
        ((Button) dialog.findViewById(C0089R.idErrorDialog.btnOk)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                SplashScreen.this.finish();
            }
        });
        btnSavedArticles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, SavedArticlesActivity.class));
                SplashScreen.this.finish();
            }
        });
        dialog.show();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
