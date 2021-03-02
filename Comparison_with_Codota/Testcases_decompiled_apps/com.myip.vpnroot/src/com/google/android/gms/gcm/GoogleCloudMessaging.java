package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    static GoogleCloudMessaging adk;
    private PendingIntent adl;
    final BlockingQueue<Intent> adm = new LinkedBlockingQueue();
    private Handler adn = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            GoogleCloudMessaging.this.adm.add((Intent) msg.obj);
        }
    };
    private Messenger ado = new Messenger(this.adn);

    /* renamed from: lB */
    private Context f2397lB;

    /* renamed from: a */
    private void m3771a(String str, String str2, long j, int i, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        } else if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        } else {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            intent.putExtras(bundle);
            mo7828j(intent);
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            intent.putExtra("google.to", str);
            intent.putExtra("google.message_id", str2);
            intent.putExtra("google.ttl", Long.toString(j));
            intent.putExtra("google.delay", Integer.toString(i));
            this.f2397lB.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        }
    }

    /* renamed from: d */
    private void m3772d(String... strArr) {
        String e = mo7826e(strArr);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        intent.putExtra("google.messenger", this.ado);
        mo7828j(intent);
        intent.putExtra("sender", e);
        this.f2397lB.startService(intent);
    }

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (adk == null) {
                adk = new GoogleCloudMessaging();
                adk.f2397lB = context;
            }
            googleCloudMessaging = adk;
        }
        return googleCloudMessaging;
    }

    /* renamed from: lL */
    private void m3773lL() {
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        this.adm.clear();
        intent.putExtra("google.messenger", this.ado);
        mo7828j(intent);
        this.f2397lB.startService(intent);
    }

    public void close() {
        mo7829lM();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo7826e(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public synchronized void mo7828j(Intent intent) {
        if (this.adl == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.adl = PendingIntent.getBroadcast(this.f2397lB, 0, intent2, 0);
        }
        intent.putExtra("app", this.adl);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lM */
    public synchronized void mo7829lM() {
        if (this.adl != null) {
            this.adl.cancel();
            this.adl = null;
        }
    }

    public String register(String... senderIds) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        this.adm.clear();
        m3772d(senderIds);
        try {
            Intent poll = this.adm.poll(5000, TimeUnit.MILLISECONDS);
            if (poll == null) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
            String stringExtra = poll.getStringExtra("registration_id");
            if (stringExtra != null) {
                return stringExtra;
            }
            poll.getStringExtra("error");
            String stringExtra2 = poll.getStringExtra("error");
            if (stringExtra2 != null) {
                throw new IOException(stringExtra2);
            }
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void send(String to, String msgId, long timeToLive, Bundle data) throws IOException {
        m3771a(to, msgId, timeToLive, -1, data);
    }

    public void send(String to, String msgId, Bundle data) throws IOException {
        send(to, msgId, -1, data);
    }

    public void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        m3773lL();
        try {
            Intent poll = this.adm.poll(5000, TimeUnit.MILLISECONDS);
            if (poll == null) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            } else if (poll.getStringExtra("unregistered") == null) {
                String stringExtra = poll.getStringExtra("error");
                if (stringExtra != null) {
                    throw new IOException(stringExtra);
                }
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }
}
