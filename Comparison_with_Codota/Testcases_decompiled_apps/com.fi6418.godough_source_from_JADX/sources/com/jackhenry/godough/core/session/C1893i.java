package com.jackhenry.godough.core.session;

/* renamed from: com.jackhenry.godough.core.session.i */
class C1893i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SessionTimeoutWarningActivity f6790a;

    C1893i(SessionTimeoutWarningActivity sessionTimeoutWarningActivity) {
        this.f6790a = sessionTimeoutWarningActivity;
    }

    public void run() {
        int percentage = SessionTimeoutWarningActivity.getPercentage(this.f6790a.f6777b);
        this.f6790a.f6779d.setIndeterminate(false);
        this.f6790a.f6779d.setProgress(percentage);
        if (percentage >= 100) {
            this.f6790a.f6776a.post(this.f6790a.f6782g);
        } else {
            this.f6790a.f6776a.postDelayed(this.f6790a.f6783h, 500);
        }
    }
}
