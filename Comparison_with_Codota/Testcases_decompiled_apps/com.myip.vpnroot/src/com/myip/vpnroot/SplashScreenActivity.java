package com.myip.vpnroot;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreenActivity extends Activity {
    private static int SPLASH_TIME_OUT = GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE;
    /* access modifiers changed from: private */
    public Handler mHandler;
    IInAppBillingService mService;
    ServiceConnection mServiceConn = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName name) {
            SplashScreenActivity.this.mService = null;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            SplashScreenActivity.this.mService = IInAppBillingService.Stub.asInterface(service);
            new AsyncTask<String, Void, String>() {
                String out;

                /* access modifiers changed from: protected */
                public String doInBackground(String... params2) {
                    return "";
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(String out_web) {
                    ArrayList<String> skuList = new ArrayList<>();
                    skuList.add("com.myip.vpnroot.shared.m");
                    skuList.add("com.myip.vpnroot.shared.y");
                    skuList.add("com.myip.vpnroot.1.eu.m");
                    skuList.add("com.myip.vpnroot.1.eu.y");
                    skuList.add("com.myip.vpnroot.1.m");
                    skuList.add("com.myip.vpnroot.1.y");
                    Bundle querySkus = new Bundle();
                    querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
                    try {
                        Bundle skuDetails = SplashScreenActivity.this.mService.getSkuDetails(3, SplashScreenActivity.this.getPackageName(), "inapp", querySkus);
                        if (skuDetails.getInt("RESPONSE_CODE") == 0) {
                            Iterator<String> it = skuDetails.getStringArrayList("DETAILS_LIST").iterator();
                            while (it.hasNext()) {
                                JSONObject object = new JSONObject(it.next());
                                String string = object.getString("productId");
                                object.getString("price");
                            }
                        }
                    } catch (RemoteException exception) {
                        exception.printStackTrace();
                    } catch (JSONException exception2) {
                        exception2.printStackTrace();
                    }
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
        }
    };
    Runnable startMain = new Runnable() {
        public void run() {
            SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this, NewMainActivity.class));
            SplashScreenActivity.this.finish();
            SplashScreenActivity.this.mHandler.removeCallbacks(this);
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(C2344R.layout.activity_splash_screen);
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        bindService(serviceIntent, this.mServiceConn, 1);
        this.mHandler = new Handler();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        new Intent("android.intent.action.MAIN", (Uri) null).addCategory("android.intent.category.LAUNCHER");
        this.mHandler.postDelayed(this.startMain, (long) SPLASH_TIME_OUT);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mService != null) {
            unbindService(this.mServiceConn);
        }
    }
}
