package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.analytics.tracking.android.AnalyticsThread;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread extends Thread implements AnalyticsThread {
    static final String API_VERSION = "1";
    private static final String CLIENT_VERSION = "ma1b5";
    private static final int MAX_SAMPLE_RATE = 100;
    private static final int SAMPLE_RATE_MODULO = 10000;
    private static final int SAMPLE_RATE_MULTIPLIER = 100;
    private static GAThread sInstance;
    /* access modifiers changed from: private */
    public volatile boolean mAppOptOut;
    /* access modifiers changed from: private */
    public volatile String mClientId;
    private volatile boolean mClosed = false;
    /* access modifiers changed from: private */
    public volatile List<Command> mCommands;
    /* access modifiers changed from: private */
    public final Context mContext;
    private volatile boolean mDisabled = false;
    /* access modifiers changed from: private */
    public volatile String mInstallCampaign;
    /* access modifiers changed from: private */
    public volatile MetaModel mMetaModel;
    /* access modifiers changed from: private */
    public volatile ServiceProxy mServiceProxy;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    static GAThread getInstance(Context ctx) {
        if (sInstance == null) {
            sInstance = new GAThread(ctx);
        }
        return sInstance;
    }

    private GAThread(Context ctx) {
        super("GAThread");
        if (ctx != null) {
            this.mContext = ctx.getApplicationContext();
        } else {
            this.mContext = ctx;
        }
        start();
    }

    @VisibleForTesting
    GAThread(Context ctx, ServiceProxy proxy) {
        super("GAThread");
        if (ctx != null) {
            this.mContext = ctx.getApplicationContext();
        } else {
            this.mContext = ctx;
        }
        this.mServiceProxy = proxy;
        start();
    }

    private void init() {
        this.mServiceProxy.createService();
        this.mCommands = new ArrayList();
        this.mCommands.add(new Command(Command.APPEND_VERSION, "_v", CLIENT_VERSION));
        this.mCommands.add(new Command(Command.APPEND_QUEUE_TIME, ModelFields.QUEUE_TIME, (String) null));
        this.mCommands.add(new Command(Command.APPEND_CACHE_BUSTER, ModelFields.CACHE_BUSTER, (String) null));
        this.mMetaModel = new MetaModel();
        MetaModelInitializer.set(this.mMetaModel);
    }

    public void sendHit(Map<String, String> hit) {
        final Map<String, String> hitCopy = new HashMap<>(hit);
        final long hitTime = System.currentTimeMillis();
        hitCopy.put("hitTime", Long.toString(hitTime));
        queueToThread(new Runnable() {
            public void run() {
                hitCopy.put(ModelFields.CLIENT_ID, GAThread.this.mClientId);
                if (!GAThread.this.mAppOptOut && !GAThread.this.isSampledOut(hitCopy)) {
                    if (!TextUtils.isEmpty(GAThread.this.mInstallCampaign)) {
                        hitCopy.put(ModelFields.CAMPAIGN, GAThread.this.mInstallCampaign);
                        String unused = GAThread.this.mInstallCampaign = null;
                    }
                    GAThread.this.fillAppParameters(hitCopy);
                    GAThread.this.fillCampaignParameters(hitCopy);
                    GAThread.this.fillExceptionParameters(hitCopy);
                    GAThread.this.mServiceProxy.putHit(HitBuilder.generateHitParams(GAThread.this.mMetaModel, hitCopy), hitTime, GAThread.this.getHostUrl(hitCopy), GAThread.this.mCommands);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String getHostUrl(Map<String, String> hit) {
        String hitUrl = hit.get("internalHitUrl");
        if (hitUrl == null) {
            return (!hit.containsKey(ModelFields.USE_SECURE) || Utils.safeParseBoolean(hit.get(ModelFields.USE_SECURE))) ? "https://ssl.google-analytics.com/collect" : "http://www.google-analytics.com/collect";
        }
        return hitUrl;
    }

    /* access modifiers changed from: private */
    public void fillExceptionParameters(Map<String, String> hit) {
        String rawExceptionString = hit.get(ModelFields.RAW_EXCEPTION);
        if (rawExceptionString != null) {
            hit.remove(ModelFields.RAW_EXCEPTION);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Utils.hexDecode(rawExceptionString)));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject instanceof Throwable) {
                    Throwable exception = (Throwable) readObject;
                    hit.put(ModelFields.EX_DESCRIPTION, new StandardExceptionParser(this.mContext, new ArrayList<>()).getDescription(hit.get(ModelFields.EXCEPTION_THREAD_NAME), exception));
                }
            } catch (IOException e) {
                Log.m529w("IOException reading exception");
            } catch (ClassNotFoundException e2) {
                Log.m529w("ClassNotFoundException reading exception");
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isSampledOut(Map<String, String> hit) {
        String clientId;
        if (hit.get(ModelFields.SAMPLE_RATE) != null) {
            double sampleRate = Utils.safeParseDouble(hit.get(ModelFields.SAMPLE_RATE));
            if (sampleRate <= 0.0d) {
                return true;
            }
            if (sampleRate < 100.0d && (clientId = hit.get(ModelFields.CLIENT_ID)) != null && ((double) (Math.abs(clientId.hashCode()) % SAMPLE_RATE_MODULO)) >= 100.0d * sampleRate) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void fillAppParameters(Map<String, String> hit) {
        PackageManager pm = this.mContext.getPackageManager();
        String appId = this.mContext.getPackageName();
        String appInstallerId = pm.getInstallerPackageName(appId);
        String appName = appId;
        String appVersion = null;
        try {
            PackageInfo packageInfo = pm.getPackageInfo(this.mContext.getPackageName(), 0);
            if (packageInfo != null) {
                appName = pm.getApplicationLabel(packageInfo.applicationInfo).toString();
                appVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.m526e("Error retrieving package info: appName set to " + appName);
        }
        putIfAbsent(hit, ModelFields.APP_NAME, appName);
        putIfAbsent(hit, ModelFields.APP_VERSION, appVersion);
        putIfAbsent(hit, ModelFields.APP_ID, appId);
        putIfAbsent(hit, ModelFields.APP_INSTALLER_ID, appInstallerId);
        hit.put(ModelFields.API_VERSION, API_VERSION);
    }

    private void putIfAbsent(Map<String, String> hit, String key, String value) {
        if (!hit.containsKey(key)) {
            hit.put(key, value);
        }
    }

    /* access modifiers changed from: private */
    public void fillCampaignParameters(Map<String, String> hit) {
        String campaign = Utils.filterCampaign(hit.get(ModelFields.CAMPAIGN));
        if (!TextUtils.isEmpty(campaign)) {
            Map<String, String> paramsMap = Utils.parseURLParameters(campaign);
            hit.put(ModelFields.CAMPAIGN_CONTENT, paramsMap.get("utm_content"));
            hit.put(ModelFields.CAMPAIGN_MEDIUM, paramsMap.get("utm_medium"));
            hit.put(ModelFields.CAMPAIGN_NAME, paramsMap.get("utm_campaign"));
            hit.put(ModelFields.CAMPAIGN_SOURCE, paramsMap.get("utm_source"));
            hit.put(ModelFields.CAMPAIGN_KEYWORD, paramsMap.get("utm_term"));
            hit.put(ModelFields.CAMPAIGN_ID, paramsMap.get("utm_id"));
            hit.put(ModelFields.GCLID, paramsMap.get(ModelFields.GCLID));
            hit.put(ModelFields.DCLID, paramsMap.get(ModelFields.DCLID));
            hit.put(ModelFields.GMOB_T, paramsMap.get(ModelFields.GMOB_T));
        }
    }

    public void dispatch() {
        queueToThread(new Runnable() {
            public void run() {
                GAThread.this.mServiceProxy.dispatch();
            }
        });
    }

    public void setAppOptOut(final boolean appOptOut) {
        queueToThread(new Runnable() {
            public void run() {
                if (GAThread.this.mAppOptOut != appOptOut) {
                    if (appOptOut) {
                        try {
                            GAThread.this.mContext.getFileStreamPath("gaOptOut").createNewFile();
                        } catch (IOException e) {
                            Log.m529w("Error creating optOut file.");
                        }
                        GAThread.this.mServiceProxy.clearHits();
                    } else {
                        GAThread.this.mContext.deleteFile("gaOptOut");
                    }
                    boolean unused = GAThread.this.mAppOptOut = appOptOut;
                }
            }
        });
    }

    public void requestAppOptOut(final GoogleAnalytics.AppOptOutCallback callback) {
        queueToThread(new Runnable() {
            public void run() {
                callback.reportAppOptOut(GAThread.this.mAppOptOut);
            }
        });
    }

    public void requestClientId(final AnalyticsThread.ClientIdCallback callback) {
        queueToThread(new Runnable() {
            public void run() {
                callback.reportClientId(GAThread.this.mClientId);
            }
        });
    }

    private void queueToThread(Runnable r) {
        this.queue.add(r);
    }

    private boolean loadAppOptOut() {
        return this.mContext.getFileStreamPath("gaOptOut").exists();
    }

    private boolean storeClientId(String clientId) {
        try {
            FileOutputStream fos = this.mContext.openFileOutput("gaClientId", 0);
            fos.write(clientId.getBytes());
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            Log.m526e("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            Log.m526e("Error writing to clientId file.");
            return false;
        }
    }

    private String generateClientId() {
        String result = UUID.randomUUID().toString().toLowerCase();
        if (!storeClientId(result)) {
            return "0";
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String initializeClientId() {
        String rslt = null;
        try {
            FileInputStream input = this.mContext.openFileInput("gaClientId");
            byte[] bytes = new byte[128];
            int readLen = input.read(bytes, 0, 128);
            if (input.available() > 0) {
                Log.m526e("clientId file seems corrupted, deleting it.");
                input.close();
                this.mContext.deleteFile("gaInstallData");
            }
            if (readLen <= 0) {
                Log.m526e("clientId file seems empty, deleting it.");
                input.close();
                this.mContext.deleteFile("gaInstallData");
            } else {
                String rslt2 = new String(bytes, 0, readLen);
                try {
                    input.close();
                    rslt = rslt2;
                } catch (FileNotFoundException e) {
                    rslt = rslt2;
                } catch (IOException e2) {
                    rslt = rslt2;
                    Log.m526e("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaInstallData");
                } catch (NumberFormatException e3) {
                    rslt = rslt2;
                    Log.m526e("cliendId file doesn't have long value, deleting it.");
                    this.mContext.deleteFile("gaInstallData");
                }
            }
        } catch (FileNotFoundException e4) {
        } catch (IOException e5) {
            Log.m526e("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaInstallData");
        } catch (NumberFormatException e6) {
            Log.m526e("cliendId file doesn't have long value, deleting it.");
            this.mContext.deleteFile("gaInstallData");
        }
        if (rslt == null) {
            return generateClientId();
        }
        return rslt;
    }

    @VisibleForTesting
    static String getAndClearCampaign(Context context) {
        try {
            FileInputStream input = context.openFileInput("gaInstallData");
            byte[] inputBytes = new byte[8192];
            int readLen = input.read(inputBytes, 0, 8192);
            if (input.available() > 0) {
                Log.m526e("Too much campaign data, ignoring it.");
                input.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            input.close();
            context.deleteFile("gaInstallData");
            if (readLen <= 0) {
                Log.m529w("Campaign file is empty.");
                return null;
            }
            String campaignString = new String(inputBytes, 0, readLen);
            Log.m527i("Campaign found: " + campaignString);
            return campaignString;
        } catch (FileNotFoundException e) {
            Log.m527i("No campaign data found.");
            return null;
        } catch (IOException e2) {
            Log.m526e("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String printStackTrace(Throwable t) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        t.printStackTrace(stream);
        stream.flush();
        return new String(baos.toByteArray());
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.m529w("sleep interrupted in GAThread initialize");
        }
        if (this.mServiceProxy == null) {
            this.mServiceProxy = new GAServiceProxy(this.mContext, this);
        }
        init();
        try {
            this.mAppOptOut = loadAppOptOut();
            this.mClientId = initializeClientId();
            this.mInstallCampaign = getAndClearCampaign(this.mContext);
        } catch (Throwable t) {
            Log.m526e("Error initializing the GAThread: " + printStackTrace(t));
            Log.m526e("Google Analytics will not start up.");
            this.mDisabled = true;
        }
        while (!this.mClosed) {
            try {
                Runnable r = this.queue.take();
                if (!this.mDisabled) {
                    r.run();
                }
            } catch (InterruptedException e2) {
                Log.m527i(e2.toString());
            } catch (Throwable t2) {
                Log.m526e("Error on GAThread: " + printStackTrace(t2));
                Log.m526e("Google Analytics is shutting down.");
                this.mDisabled = true;
            }
        }
    }

    public LinkedBlockingQueue<Runnable> getQueue() {
        return this.queue;
    }

    public Thread getThread() {
        return this;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void close() {
        this.mClosed = true;
        interrupt();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isDisabled() {
        return this.mDisabled;
    }
}
