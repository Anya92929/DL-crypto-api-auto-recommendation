package cmn;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: cmn.ao */
public final class C0720ao {

    /* renamed from: a */
    private static String f1776a = "ImageDownloader";

    /* renamed from: b */
    private static C0720ao f1777b;

    /* renamed from: c */
    private final Map f1778c = new HashMap();

    /* renamed from: d */
    private final Map f1779d = new HashMap();

    /* renamed from: e */
    private final Map f1780e = new WeakHashMap();

    /* renamed from: f */
    private final C0759u f1781f = new C0759u();

    /* renamed from: g */
    private final Bitmap f1782g = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);

    /* renamed from: h */
    private C0764z f1783h = new C0706aa();

    /* renamed from: i */
    private int f1784i;

    private C0720ao() {
    }

    /* renamed from: a */
    public static synchronized C0720ao m3213a() {
        C0720ao aoVar;
        synchronized (C0720ao.class) {
            if (f1777b == null) {
                f1777b = new C0720ao();
            }
            aoVar = f1777b;
        }
        return aoVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m3214a(Bitmap bitmap, String str, boolean z) {
        if (bitmap == null) {
            this.f1783h.mo3383a(str, this.f1782g);
            List<ImageView> list = (List) this.f1778c.get(str);
            if (list != null) {
                for (ImageView imageView : list) {
                    if (imageView != null && str.equals(this.f1780e.get(imageView))) {
                        if (z) {
                            imageView.setVisibility(8);
                        }
                        this.f1780e.remove(imageView);
                    }
                }
            }
            List<C0708ac> list2 = (List) this.f1779d.get(str);
            if (list2 != null) {
                for (C0708ac a : list2) {
                    try {
                        a.mo3385a((Object) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f1778c.remove(str);
            this.f1779d.remove(str);
        } else {
            if (this.f1784i == 0) {
                this.f1784i = C0709ad.m3188b(160.0f) * C0709ad.m3188b(160.0f);
            }
            if (bitmap.getWidth() * bitmap.getHeight() <= this.f1784i) {
                this.f1783h.mo3383a(str, bitmap);
            }
            List<ImageView> list3 = (List) this.f1778c.get(str);
            if (list3 != null) {
                for (ImageView imageView2 : list3) {
                    if (imageView2 != null && str.equals(this.f1780e.get(imageView2))) {
                        this.f1780e.remove(imageView2);
                        imageView2.setVisibility(0);
                        imageView2.setImageBitmap(bitmap);
                    }
                }
            }
            List<C0708ac> list4 = (List) this.f1779d.get(str);
            if (list4 != null) {
                for (C0708ac a2 : list4) {
                    try {
                        a2.mo3385a(bitmap);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f1778c.remove(str);
            this.f1779d.remove(str);
        }
    }

    /* renamed from: a */
    private synchronized void m3215a(ImageView imageView, String str, boolean z, C0708ac acVar) {
        if (!C0725at.m3230a()) {
            throw new IllegalStateException("Call imagedownloader on the UI thread only.");
        }
        if (imageView != null) {
            this.f1780e.put(imageView, str);
        }
        if (!TextUtils.isEmpty(str)) {
            Bitmap bitmap = (Bitmap) this.f1783h.mo3382a(str);
            if (bitmap != null) {
                if (bitmap != this.f1782g) {
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        imageView.setImageBitmap(bitmap);
                    }
                    if (acVar != null) {
                        acVar.mo3385a(bitmap);
                    }
                } else {
                    if (z && imageView != null) {
                        imageView.setVisibility(8);
                    }
                    if (acVar != null) {
                        acVar.mo3385a((Object) null);
                    }
                }
                if (imageView != null) {
                    this.f1780e.remove(imageView);
                }
            } else {
                if (acVar != null) {
                    List list = (List) this.f1779d.get(str);
                    if (list == null) {
                        list = new ArrayList();
                        this.f1779d.put(str, list);
                    }
                    list.add(acVar);
                }
                List list2 = (List) this.f1778c.get(str);
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    if (imageView != null) {
                        arrayList.add(imageView);
                    }
                    this.f1778c.put(str, arrayList);
                    this.f1781f.mo3448a(str, new C0721ap(this, str, z));
                } else if (imageView != null) {
                    list2.add(imageView);
                }
            }
        } else if (acVar != null) {
            acVar.mo3385a((Object) null);
        }
    }

    /* renamed from: a */
    public final synchronized void mo3405a(ImageView imageView, String str) {
        m3215a(imageView, str, false, (C0708ac) null);
    }

    /* renamed from: a */
    public final synchronized void mo3406a(ImageView imageView, String str, C0708ac acVar) {
        m3215a(imageView, str, true, acVar);
    }

    /* renamed from: b */
    public final synchronized void mo3407b(ImageView imageView, String str) {
        m3215a(imageView, str, true, (C0708ac) null);
    }
}
