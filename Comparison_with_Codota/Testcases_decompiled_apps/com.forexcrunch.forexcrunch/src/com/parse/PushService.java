package com.parse;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.parse.p005os.ParseAsyncTask;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class PushService extends Service {
    private static final String TAG = "com.parse.PushService";
    static PushConnection connection;
    static int consecutiveFailures;
    /* access modifiers changed from: private */
    public static int defaultPushPort = 8253;
    /* access modifiers changed from: private */
    public static int delaySeconds;
    /* access modifiers changed from: private */
    public static String pushServer = "push.parse.com";
    static Semaphore sleepSemaphore;
    private Timer keepAliveTimer = null;
    /* access modifiers changed from: private */
    public ServiceState state = ServiceState.STOPPED;
    private ParseAsyncTask<Void, Void, String> task;

    enum ServiceState {
        STOPPED,
        ABORTING,
        DESTRUCTING,
        RUNNING
    }

    /* access modifiers changed from: private */
    public static synchronized void startService(Context context) {
        synchronized (PushService.class) {
            Parse.logD(TAG, "ensuring push service is started");
            if (context.startService(new Intent(context, PushService.class)) == null) {
                Parse.logE(TAG, "Could not start the push service. Make sure that the XML tag <service android:name=\"com.parse.PushService\" /> is in your AndroidManifest.xml as a child of the <application> element.");
            }
        }
    }

    public static void startServiceIfRequired(final Context context) {
        new BackgroundTask<Void>((ParseCallback) null) {
            public Void run() throws ParseException {
                if (!ParsePushRouter.hasRoutes(context)) {
                    Parse.logW(PushService.TAG, "No known push routes; will not start push service");
                    return null;
                }
                PushService.startService(context);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static void subscribe(Context context, String channel, Class<? extends Activity> cls) {
        String packageName = context.getPackageName();
        try {
            subscribe(context, channel, cls, context.getPackageManager().getApplicationInfo(packageName, 0).icon);
        } catch (PackageManager.NameNotFoundException e) {
            Parse.logE(TAG, "missing package " + packageName, e);
        }
    }

    public static synchronized void subscribe(Context context, String channel, Class<? extends Activity> cls, int icon) {
        synchronized (PushService.class) {
            startService(context);
            ParsePushRouter.addChannelRoute(context, channel, cls, icon);
        }
    }

    public static synchronized void unsubscribe(Context context, String channel) {
        synchronized (PushService.class) {
            ParsePushRouter.removeChannelRoute(context, channel);
        }
    }

    public static void setDefaultPushCallback(Context context, Class<? extends Activity> cls) {
        String packageName = context.getPackageName();
        try {
            setDefaultPushCallback(context, cls, context.getPackageManager().getApplicationInfo(packageName, 0).icon);
        } catch (PackageManager.NameNotFoundException e) {
            Parse.logE(TAG, "missing package " + packageName, e);
        }
    }

    public static void setDefaultPushCallback(Context context, Class<? extends Activity> cls, int icon) {
        ParsePushRouter.setDefaultRoute(context, cls, icon);
        if (cls != null) {
            startService(context);
        } else if (!ParsePushRouter.hasRoutes(context)) {
            Parse.logD(TAG, "Shutting down push service. No remaining channels");
            context.stopService(new Intent(context, PushService.class));
        }
    }

    public static synchronized Set<String> getSubscriptions(Context context) {
        Set<String> subscriptions;
        synchronized (PushService.class) {
            subscriptions = ParsePushRouter.getSubscriptions(context);
        }
        return subscriptions;
    }

    static void sleep(int millis) throws InterruptedException {
        Semaphore semaphore = sleepSemaphore;
        if (semaphore == null) {
            Thread.sleep((long) millis);
            return;
        }
        while (millis > 100) {
            semaphore.acquire(100);
            millis -= 100;
        }
        semaphore.acquire(millis);
    }

    static void useServer(String newServer) {
        pushServer = newServer;
    }

    static void usePort(int newPort) {
        defaultPushPort = newPort;
    }

    static void resetDelay() {
        delaySeconds = 0;
        consecutiveFailures = 0;
    }

    /* access modifiers changed from: private */
    public void increaseDelay() {
        consecutiveFailures++;
        delaySeconds = (int) (((double) delaySeconds) * (1.5d + (Math.random() / 2.0d)));
        delaySeconds = Math.max(15, delaySeconds);
        delaySeconds = Math.min(delaySeconds, 300);
    }

    public void onCreate() {
        super.onCreate();
        if (Parse.applicationContext == null) {
            Parse.logE(TAG, "The Parse push service cannot start because Parse.initialize has not yet been called. If you call Parse.initialize from an Activity's onCreate, that call should instead be in the Application.onCreate. Be sure your Application class is registered in your AndroidManifest.xml with the android:name property of your <application> tag.");
            this.state = ServiceState.ABORTING;
            stopSelf();
            return;
        }
        this.state = ServiceState.RUNNING;
        Parse.logD(TAG, "creating push service");
        Timer newTimer = new Timer("com.parse.PushService.keepAliveTimer", true);
        newTimer.schedule(new TimerTask() {
            public void run() {
                PushService.this.sendKeepAlive();
            }
        }, 1200000, 1200000);
        this.keepAliveTimer = newTimer;
        resetDelay();
        connection = new PushConnection(this);
        readInBackground(true);
    }

    static boolean sendMessage(String message) {
        return connection.trySend(message);
    }

    /* access modifiers changed from: private */
    public static boolean sendSubscriptionInformation(Context context) {
        return sendMessage(ParsePushRouter.getPushRequestJSON(context).toString());
    }

    /* access modifiers changed from: private */
    public void sendKeepAlive() {
        if (!sendMessage("{}")) {
            connection.close();
        }
    }

    /* access modifiers changed from: private */
    public void readInBackground(final boolean forceReconnect) {
        if (this.state != ServiceState.DESTRUCTING) {
            this.task = new ParseAsyncTask<Void, Void, String>() {
                /* access modifiers changed from: protected */
                public String doInBackground(Void... v) {
                    if (forceReconnect) {
                        if (PushService.delaySeconds > 0) {
                            try {
                                Parse.logI(PushService.TAG, "sleeping for " + PushService.delaySeconds + " seconds");
                                PushService.sleep(PushService.delaySeconds * 1000);
                            } catch (InterruptedException e) {
                                Parse.logV(PushService.TAG, "Push backoff sleep interrupted", e);
                                return null;
                            }
                        }
                        PushService.this.increaseDelay();
                    }
                    if (PushService.this.state == ServiceState.DESTRUCTING) {
                        return null;
                    }
                    PushService.connection.connect(PushService.pushServer, PushService.defaultPushPort, forceReconnect);
                    if (PushService.this.state == ServiceState.DESTRUCTING) {
                        return null;
                    }
                    if (forceReconnect && !PushService.sendSubscriptionInformation(this)) {
                        return null;
                    }
                    if (PushService.this.state == ServiceState.DESTRUCTING) {
                        return null;
                    }
                    try {
                        Parse.logD(PushService.TAG, "waiting for a push");
                        if (Thread.currentThread().isInterrupted()) {
                            return null;
                        }
                        String readLine = PushService.connection.readLine();
                        PushService.resetDelay();
                        return readLine;
                    } catch (IOException e2) {
                        Parse.logV(PushService.TAG, "Network disconnect; will reconnect to the push service shortly.", e2);
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(String line) {
                    Parse.logV(PushService.TAG, "Post execute: " + line);
                    if (PushService.this.state == ServiceState.DESTRUCTING) {
                        PushService.this.state = ServiceState.STOPPED;
                    } else if (line == null) {
                        PushService.this.readInBackground(true);
                    } else {
                        try {
                            ParsePushRouter.routePush(this, new JSONObject(new JSONTokener(line)));
                            PushService.this.readInBackground(false);
                        } catch (JSONException e) {
                            Parse.logE(PushService.TAG, "bad json: " + line, e);
                            PushService.this.readInBackground(false);
                        }
                    }
                }
            };
            this.task.execute(new Void[0]);
        }
    }

    public IBinder onBind(Intent intent) {
        throw new IllegalArgumentException("You cannot bind directly to the PushService. Use PushService.subscribe instead.");
    }

    public void onDestroy() {
        super.onDestroy();
        Parse.logD(TAG, "destroying push service");
        if (this.state == ServiceState.ABORTING) {
            this.state = ServiceState.STOPPED;
            return;
        }
        this.task.cancel(true);
        this.keepAliveTimer.cancel();
        this.state = ServiceState.DESTRUCTING;
        connection.close();
    }
}
