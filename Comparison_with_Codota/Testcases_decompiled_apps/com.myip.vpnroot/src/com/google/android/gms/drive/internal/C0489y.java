package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.events.C0372c;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.C0386ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.y */
public class C0489y extends C0386ad.C0387a {

    /* renamed from: NS */
    private final int f1086NS;

    /* renamed from: OW */
    private final C0372c f1087OW;

    /* renamed from: OX */
    private final C0491a f1088OX;

    /* renamed from: OY */
    private final List<Integer> f1089OY = new ArrayList();

    /* renamed from: com.google.android.gms.drive.internal.y$a */
    private static class C0491a extends Handler {
        private final Context mContext;

        private C0491a(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        /* renamed from: a */
        public void mo5100a(C0372c cVar, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(cVar, driveEvent)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    C0372c cVar = (C0372c) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            if (cVar instanceof DriveEvent.Listener) {
                                ((DriveEvent.Listener) cVar).onEvent((ChangeEvent) driveEvent);
                                return;
                            } else {
                                ((ChangeListener) cVar).onChange((ChangeEvent) driveEvent);
                                return;
                            }
                        case 2:
                            ((CompletionListener) cVar).onCompletion((CompletionEvent) driveEvent);
                            return;
                        default:
                            C0478v.m1343p("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    C0478v.m1341e(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    public C0489y(Looper looper, Context context, int i, C0372c cVar) {
        this.f1086NS = i;
        this.f1087OW = cVar;
        this.f1088OX = new C0491a(looper, context);
    }

    /* renamed from: bq */
    public void mo5098bq(int i) {
        this.f1089OY.add(Integer.valueOf(i));
    }

    /* renamed from: br */
    public boolean mo5099br(int i) {
        return this.f1089OY.contains(Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo4744c(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent ih = onEventResponse.mo4814ih();
        C0348n.m850I(this.f1086NS == ih.getType());
        C0348n.m850I(this.f1089OY.contains(Integer.valueOf(ih.getType())));
        this.f1088OX.mo5100a(this.f1087OW, ih);
    }
}
