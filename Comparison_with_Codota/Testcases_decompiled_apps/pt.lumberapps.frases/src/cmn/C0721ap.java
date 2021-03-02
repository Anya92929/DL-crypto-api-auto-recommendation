package cmn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayInputStream;

/* renamed from: cmn.ap */
final class C0721ap implements C0708ac {

    /* renamed from: a */
    final /* synthetic */ String f1785a;

    /* renamed from: b */
    final /* synthetic */ boolean f1786b;

    /* renamed from: c */
    final /* synthetic */ C0720ao f1787c;

    C0721ap(C0720ao aoVar, String str, boolean z) {
        this.f1787c = aoVar;
        this.f1785a = str;
        this.f1786b = z;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3385a(Object obj) {
        C0762x xVar = (C0762x) obj;
        Bitmap bitmap = null;
        if (xVar == null || xVar.mo3449a() == null) {
            new StringBuilder("Couldn't fetch ").append(this.f1785a).append(", null result");
        } else {
            try {
                bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(xVar.mo3449a()));
            } catch (OutOfMemoryError e) {
                System.gc();
            } catch (Exception e2) {
                new StringBuilder("Exception fetching ").append(this.f1785a).append(": ").append(e2);
            }
        }
        this.f1787c.m3214a(bitmap, this.f1785a, this.f1786b);
    }
}
