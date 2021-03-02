package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzin
public class zzk extends zzdt.zza implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    boolean f3700a = false;

    /* renamed from: b */
    int f3701b;

    /* renamed from: c */
    int f3702c;

    /* renamed from: d */
    private final Object f3703d = new Object();

    /* renamed from: e */
    private final FrameLayout f3704e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameLayout f3705f;

    /* renamed from: g */
    private Map f3706g = new HashMap();

    /* renamed from: h */
    private C1257a f3707h;

    /* renamed from: i */
    private zzh f3708i;

    public zzk(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f3704e = frameLayout;
        this.f3705f = frameLayout2;
        zzu.zzgk().zza((View) this.f3704e, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzu.zzgk().zza((View) this.f3704e, (ViewTreeObserver.OnScrollChangedListener) this);
        this.f3704e.setOnTouchListener(this);
        this.f3704e.setOnClickListener(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5374a() {
        return this.f3704e.getMeasuredWidth();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5375a(int i) {
        return zzm.zziw().zzb(this.f3708i.getContext(), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Point mo5376a(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.f3704e.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1257a mo5377a(zzi zzi) {
        return zzi.zza(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5378a(View view) {
        if (this.f3708i != null) {
            zzh zzla = this.f3708i instanceof zzg ? ((zzg) this.f3708i).zzla() : this.f3708i;
            if (zzla != null) {
                zzla.zzh(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5379b() {
        return this.f3704e.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Point mo5380b(View view) {
        if (this.f3707h == null || !this.f3707h.mo5309a().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.f3704e.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    public void destroy() {
        synchronized (this.f3703d) {
            if (this.f3705f != null) {
                this.f3705f.removeAllViews();
            }
            this.f3705f = null;
            this.f3706g = null;
            this.f3707h = null;
            this.f3708i = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r10) {
        /*
            r9 = this;
            java.lang.Object r6 = r9.f3703d
            monitor-enter(r6)
            com.google.android.gms.ads.internal.formats.zzh r0 = r9.f3708i     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
        L_0x0008:
            return
        L_0x0009:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r3.<init>()     // Catch:{ all -> 0x0090 }
            java.util.Map r0 = r9.f3706g     // Catch:{ all -> 0x0090 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0090 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0090 }
        L_0x0018:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0099
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0090 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r0.getValue()     // Catch:{ all -> 0x0090 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0090 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0018
            android.graphics.Point r4 = r9.mo5380b(r1)     // Catch:{ all -> 0x0090 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r7 = "width"
            int r8 = r1.getWidth()     // Catch:{ JSONException -> 0x0075 }
            int r8 = r9.mo5375a((int) r8)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r7, r8)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r7 = "height"
            int r1 = r1.getHeight()     // Catch:{ JSONException -> 0x0075 }
            int r1 = r9.mo5375a((int) r1)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r7, r1)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r1 = "x"
            int r7 = r4.x     // Catch:{ JSONException -> 0x0075 }
            int r7 = r9.mo5375a((int) r7)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r1, r7)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r1 = "y"
            int r4 = r4.y     // Catch:{ JSONException -> 0x0075 }
            int r4 = r9.mo5375a((int) r4)     // Catch:{ JSONException -> 0x0075 }
            r5.put(r1, r4)     // Catch:{ JSONException -> 0x0075 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0075 }
            r3.put(r1, r5)     // Catch:{ JSONException -> 0x0075 }
            goto L_0x0018
        L_0x0075:
            r1 = move-exception
            java.lang.String r1 = "Unable to get view rectangle for view "
            java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0090 }
            int r4 = r0.length()     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x0093
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0090 }
        L_0x008c:
            com.google.android.gms.internal.zzkd.zzcx(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x0018
        L_0x0090:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
            throw r0
        L_0x0093:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0090 }
            r0.<init>(r1)     // Catch:{ all -> 0x0090 }
            goto L_0x008c
        L_0x0099:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r4.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = "x"
            int r1 = r9.f3701b     // Catch:{ JSONException -> 0x0103 }
            int r1 = r9.mo5375a((int) r1)     // Catch:{ JSONException -> 0x0103 }
            r4.put(r0, r1)     // Catch:{ JSONException -> 0x0103 }
            java.lang.String r0 = "y"
            int r1 = r9.f3702c     // Catch:{ JSONException -> 0x0103 }
            int r1 = r9.mo5375a((int) r1)     // Catch:{ JSONException -> 0x0103 }
            r4.put(r0, r1)     // Catch:{ JSONException -> 0x0103 }
        L_0x00b4:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = "width"
            int r1 = r9.mo5374a()     // Catch:{ JSONException -> 0x010a }
            int r1 = r9.mo5375a((int) r1)     // Catch:{ JSONException -> 0x010a }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r0 = "height"
            int r1 = r9.mo5379b()     // Catch:{ JSONException -> 0x010a }
            int r1 = r9.mo5375a((int) r1)     // Catch:{ JSONException -> 0x010a }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x010a }
        L_0x00d3:
            com.google.android.gms.ads.internal.formats.a r0 = r9.f3707h     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0119
            com.google.android.gms.ads.internal.formats.a r0 = r9.f3707h     // Catch:{ all -> 0x0090 }
            android.view.ViewGroup r0 = r0.mo5309a()     // Catch:{ all -> 0x0090 }
            boolean r0 = r0.equals(r10)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0119
            com.google.android.gms.ads.internal.formats.zzh r0 = r9.f3708i     // Catch:{ all -> 0x0090 }
            boolean r0 = r0 instanceof com.google.android.gms.ads.internal.formats.zzg     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0111
            com.google.android.gms.ads.internal.formats.zzh r0 = r9.f3708i     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzg r0 = (com.google.android.gms.ads.internal.formats.zzg) r0     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzh r0 = r0.zzla()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0111
            com.google.android.gms.ads.internal.formats.zzh r0 = r9.f3708i     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzg r0 = (com.google.android.gms.ads.internal.formats.zzg) r0     // Catch:{ all -> 0x0090 }
            com.google.android.gms.ads.internal.formats.zzh r0 = r0.zzla()     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = "1007"
            r0.zza(r1, r3, r4, r5)     // Catch:{ all -> 0x0090 }
        L_0x0100:
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
            goto L_0x0008
        L_0x0103:
            r0 = move-exception
            java.lang.String r0 = "Unable to get click location"
            com.google.android.gms.internal.zzkd.zzcx(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00b4
        L_0x010a:
            r0 = move-exception
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.zzkd.zzcx(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00d3
        L_0x0111:
            com.google.android.gms.ads.internal.formats.zzh r0 = r9.f3708i     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = "1007"
            r0.zza(r1, r3, r4, r5)     // Catch:{ all -> 0x0090 }
            goto L_0x0100
        L_0x0119:
            com.google.android.gms.ads.internal.formats.zzh r0 = r9.f3708i     // Catch:{ all -> 0x0090 }
            java.util.Map r2 = r9.f3706g     // Catch:{ all -> 0x0090 }
            r1 = r10
            r0.zza(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0090 }
            goto L_0x0100
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.zzk.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.f3703d) {
            if (this.f3700a) {
                int a = mo5374a();
                int b = mo5379b();
                if (!(a == 0 || b == 0 || this.f3705f == null)) {
                    this.f3705f.setLayoutParams(new FrameLayout.LayoutParams(a, b));
                    this.f3700a = false;
                }
            }
            if (this.f3708i != null) {
                this.f3708i.zzg(this.f3704e);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.f3703d) {
            if (this.f3708i != null) {
                this.f3708i.zzg(this.f3704e);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f3703d) {
            if (this.f3708i != null) {
                Point a = mo5376a(motionEvent);
                this.f3701b = a.x;
                this.f3702c = a.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) a.x, (float) a.y);
                this.f3708i.zzb(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    public zzd zzap(String str) {
        zzd zzac;
        synchronized (this.f3703d) {
            WeakReference weakReference = (WeakReference) this.f3706g.get(str);
            zzac = zze.zzac(weakReference == null ? null : (View) weakReference.get());
        }
        return zzac;
    }

    public void zzc(String str, zzd zzd) {
        View view = (View) zze.zzad(zzd);
        synchronized (this.f3703d) {
            if (view == null) {
                this.f3706g.remove(str);
            } else {
                this.f3706g.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    public void zze(zzd zzd) {
        synchronized (this.f3703d) {
            mo5378a((View) null);
            Object zzad = zze.zzad(zzd);
            if (!(zzad instanceof zzi)) {
                zzkd.zzcx("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (this.f3705f != null) {
                this.f3705f.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                this.f3704e.requestLayout();
            }
            this.f3700a = true;
            zzi zzi = (zzi) zzad;
            if (this.f3708i != null && ((Boolean) zzdc.zzbch.get()).booleanValue()) {
                this.f3708i.zzb(this.f3704e, this.f3706g);
            }
            if (!(this.f3708i instanceof zzg) || !((zzg) this.f3708i).zzkz()) {
                this.f3708i = zzi;
                if (zzi instanceof zzg) {
                    ((zzg) zzi).zzc((zzh) null);
                }
            } else {
                ((zzg) this.f3708i).zzc(zzi);
            }
            if (((Boolean) zzdc.zzbch.get()).booleanValue()) {
                this.f3705f.setClickable(false);
            }
            this.f3705f.removeAllViews();
            this.f3707h = mo5377a(zzi);
            if (this.f3707h != null) {
                this.f3706g.put("1007", new WeakReference(this.f3707h.mo5309a()));
                this.f3705f.addView(this.f3707h);
            }
            zzkh.zzclc.post(new C1267k(this, zzi));
            zzi.zza((View) this.f3704e, this.f3706g, (View.OnTouchListener) this, (View.OnClickListener) this);
            mo5378a((View) this.f3704e);
        }
    }
}
