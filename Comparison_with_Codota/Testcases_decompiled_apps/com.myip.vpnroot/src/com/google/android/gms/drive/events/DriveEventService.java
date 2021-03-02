package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.internal.C0386ad;
import com.google.android.gms.drive.internal.C0478v;
import com.google.android.gms.drive.internal.OnEventResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    /* access modifiers changed from: private */

    /* renamed from: NN */
    public CountDownLatch f869NN;

    /* renamed from: NO */
    C0368a f870NO;

    /* renamed from: NP */
    int f871NP;
    private final String mName;

    /* renamed from: com.google.android.gms.drive.events.DriveEventService$a */
    final class C0368a extends Handler {
        C0368a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public Message m991b(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        /* access modifiers changed from: private */
        /* renamed from: hW */
        public Message m992hW() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            C0478v.m1342n("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    DriveEventService.this.m985a((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    C0478v.m1343p("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.drive.events.DriveEventService$b */
    final class C0369b extends C0386ad.C0387a {
        C0369b() {
        }

        /* renamed from: c */
        public void mo4744c(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (DriveEventService.this) {
                C0478v.m1342n("DriveEventService", "onEvent: " + onEventResponse);
                C0348n.m861i(DriveEventService.this.f870NO);
                DriveEventService.this.m988hV();
                DriveEventService.this.f870NO.sendMessage(DriveEventService.this.f870NO.m991b(onEventResponse));
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.f871NP = -1;
        this.mName = name;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m985a(OnEventResponse onEventResponse) {
        DriveEvent ih = onEventResponse.mo4814ih();
        C0478v.m1342n("DriveEventService", "handleEventMessage: " + ih);
        try {
            switch (ih.getType()) {
                case 1:
                    onChange((ChangeEvent) ih);
                    return;
                case 2:
                    onCompletion((CompletionEvent) ih);
                    return;
                default:
                    C0478v.m1343p(this.mName, "Unhandled event: " + ih);
                    return;
            }
        } catch (Exception e) {
            C0478v.m1340a(this.mName, e, "Error handling event: " + ih);
        }
        C0478v.m1340a(this.mName, e, "Error handling event: " + ih);
    }

    /* renamed from: bc */
    private boolean m987bc(int i) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (String equals : packagesForUid) {
            if (GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: hV */
    public void m988hV() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.f871NP) {
            if (!GooglePlayServicesUtil.m470b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) || !m987bc(callingUid)) {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
            this.f871NP = callingUid;
        }
    }

    /* access modifiers changed from: protected */
    public int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder iBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.f870NO == null) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f869NN = new CountDownLatch(1);
                new Thread() {
                    public void run() {
                        try {
                            Looper.prepare();
                            DriveEventService.this.f870NO = new C0368a();
                            countDownLatch.countDown();
                            C0478v.m1342n("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            C0478v.m1342n("DriveEventService", "Finished loop");
                        } finally {
                            DriveEventService.this.f869NN.countDown();
                        }
                    }
                }.start();
                try {
                    countDownLatch.await(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            iBinder = new C0369b().asBinder();
        } else {
            iBinder = null;
        }
        return iBinder;
    }

    public void onChange(ChangeEvent event) {
        C0478v.m1343p(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        C0478v.m1343p(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        C0478v.m1342n("DriveEventService", "onDestroy");
        if (this.f870NO != null) {
            this.f870NO.sendMessage(this.f870NO.m992hW());
            this.f870NO = null;
            try {
                this.f869NN.await(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
            }
            this.f869NN = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
