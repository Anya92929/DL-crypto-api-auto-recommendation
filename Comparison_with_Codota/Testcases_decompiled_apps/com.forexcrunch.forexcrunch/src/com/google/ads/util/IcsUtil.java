package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.google.ads.AdSize;
import com.google.ads.C0272n;
import com.google.ads.internal.AdWebView;
import com.google.ads.util.C0293g;

@TargetApi(14)
public class IcsUtil {

    /* renamed from: com.google.ads.util.IcsUtil$a */
    public static class C0281a extends C0293g.C0295a {
        public C0281a(C0272n nVar) {
            super(nVar);
        }

        public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }
    }

    public static class IcsAdWebView extends AdWebView {
        public IcsAdWebView(C0272n slotState, AdSize adSize) {
            super(slotState, adSize);
        }

        public boolean canScrollHorizontally(int direction) {
            if (this.f466a.f658e.mo3725a() != null) {
                return !this.f466a.f658e.mo3725a().mo3428b();
            }
            return super.canScrollHorizontally(direction);
        }

        public boolean canScrollVertically(int direction) {
            if (this.f466a.f658e.mo3725a() != null) {
                return !this.f466a.f658e.mo3725a().mo3428b();
            }
            return super.canScrollVertically(direction);
        }
    }
}
