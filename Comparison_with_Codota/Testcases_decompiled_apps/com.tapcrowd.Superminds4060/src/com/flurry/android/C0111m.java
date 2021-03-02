package com.flurry.android;

/* renamed from: com.flurry.android.m */
final class C0111m implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f208a;

    /* renamed from: b */
    private /* synthetic */ C0098al f209b;

    C0111m(C0098al alVar, String str) {
        this.f209b = alVar;
        this.f208a = str;
    }

    public final void run() {
        if (this.f208a != null) {
            C0120v.m132a(this.f209b.f122d, this.f209b.f120b, this.f208a);
            this.f209b.f121c.mo3325a(new C0104f((byte) 8, this.f209b.f122d.mo3362j()));
            return;
        }
        String str = "Unable to launch in app market: " + this.f209b.f119a;
        C0095ai.m106d(C0120v.f233a, str);
        this.f209b.f122d.m138e(str);
    }
}
