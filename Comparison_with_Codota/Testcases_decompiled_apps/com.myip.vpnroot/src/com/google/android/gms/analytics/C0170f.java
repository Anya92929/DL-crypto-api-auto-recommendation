package com.google.android.gms.analytics;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.f */
interface C0170f {
    /* renamed from: dI */
    void mo3694dI();

    /* renamed from: dO */
    void mo3695dO();

    /* renamed from: dP */
    LinkedBlockingQueue<Runnable> mo3696dP();

    void dispatch();

    Thread getThread();

    /* renamed from: u */
    void mo3699u(Map<String, String> map);
}
