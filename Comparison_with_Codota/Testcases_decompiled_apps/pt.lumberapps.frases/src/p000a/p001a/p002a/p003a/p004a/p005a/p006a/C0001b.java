package p000a.p001a.p002a.p003a.p004a.p005a.p006a;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: a.a.a.a.a.a.a.b */
final class C0001b extends Handler {

    /* renamed from: a */
    private static C0001b f7a;

    /* renamed from: b */
    private Queue f8b = new LinkedBlockingQueue();

    private C0001b() {
    }

    /* renamed from: a */
    static synchronized C0001b m11a() {
        C0001b bVar;
        synchronized (C0001b.class) {
            if (f7a == null) {
                f7a = new C0001b();
            }
            bVar = f7a;
        }
        return bVar;
    }

    /* renamed from: a */
    private void m12a(C0000a aVar, int i) {
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = aVar;
        sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private void m13a(C0000a aVar, int i, long j) {
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = aVar;
        sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: b */
    private long m14b(C0000a aVar) {
        return 0 + ((long) aVar.mo4e().f12d) + aVar.mo7h().getDuration() + aVar.mo8i().getDuration();
    }

    /* renamed from: c */
    private void m15c() {
        if (!this.f8b.isEmpty()) {
            C0000a aVar = (C0000a) this.f8b.peek();
            if (aVar.mo5f() == null) {
                this.f8b.poll();
            }
            if (!aVar.mo2c()) {
                m12a(aVar, -1040157475);
            } else {
                m13a(aVar, 794631, m14b(aVar));
            }
        }
    }

    /* renamed from: c */
    private void m16c(C0000a aVar) {
        if (!aVar.mo2c()) {
            View g = aVar.mo6g();
            if (g.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                aVar.mo5f().addContentView(g, layoutParams);
            }
            g.startAnimation(aVar.mo7h());
            m13a(aVar, -1040155167, ((long) aVar.mo4e().f12d) + aVar.mo7h().getDuration());
        }
    }

    /* renamed from: d */
    private void m17d() {
        removeMessages(-1040157475);
        removeMessages(794631);
        removeMessages(-1040155167);
    }

    /* renamed from: d */
    private void m18d(C0000a aVar) {
        View g = aVar.mo6g();
        ViewGroup viewGroup = (ViewGroup) g.getParent();
        if (viewGroup != null) {
            g.startAnimation(aVar.mo8i());
            C0000a aVar2 = (C0000a) this.f8b.poll();
            viewGroup.removeView(g);
            if (aVar2 != null) {
                aVar2.mo3d();
            }
            m13a(aVar, 794631, aVar.mo8i().getDuration());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9a(C0000a aVar) {
        this.f8b.add(aVar);
        m15c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10b() {
        m17d();
        if (this.f8b != null) {
            for (C0000a aVar : this.f8b) {
                if (aVar.mo2c()) {
                    ((ViewGroup) aVar.mo6g().getParent()).removeView(aVar.mo6g());
                }
            }
            this.f8b.clear();
        }
    }

    public void handleMessage(Message message) {
        C0000a aVar = (C0000a) message.obj;
        switch (message.what) {
            case -1040157475:
                m16c(aVar);
                return;
            case -1040155167:
                m18d(aVar);
                return;
            case 794631:
                m15c();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
