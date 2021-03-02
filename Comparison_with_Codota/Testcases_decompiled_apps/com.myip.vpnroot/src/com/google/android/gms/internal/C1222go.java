package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@C1130ez
/* renamed from: com.google.android.gms.internal.go */
public class C1222go {

    /* renamed from: wy */
    public static final C1225a<Void> f3769wy = new C1225a() {
        /* renamed from: c */
        public Void mo8520b(InputStream inputStream) {
            return null;
        }

        /* renamed from: dr */
        public Void mo8522cK() {
            return null;
        }
    };

    /* renamed from: com.google.android.gms.internal.go$a */
    public interface C1225a<T> {
        /* renamed from: b */
        T mo8520b(InputStream inputStream);

        /* renamed from: cK */
        T mo8522cK();
    }

    /* renamed from: a */
    public <T> Future<T> mo8607a(final String str, final C1225a<T> aVar) {
        return C1209gi.submit(new Callable<T>() {
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public T call() {
                /*
                    r4 = this;
                    r1 = 0
                    java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x003a, IOException -> 0x0046 }
                    java.lang.String r2 = r2     // Catch:{ MalformedURLException -> 0x003a, IOException -> 0x0046 }
                    r0.<init>(r2)     // Catch:{ MalformedURLException -> 0x003a, IOException -> 0x0046 }
                    java.net.URLConnection r0 = r0.openConnection()     // Catch:{ MalformedURLException -> 0x003a, IOException -> 0x0046 }
                    java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ MalformedURLException -> 0x003a, IOException -> 0x0046 }
                    r0.connect()     // Catch:{ MalformedURLException -> 0x0063, IOException -> 0x005e, all -> 0x0059 }
                    int r1 = r0.getResponseCode()     // Catch:{ MalformedURLException -> 0x0063, IOException -> 0x005e, all -> 0x0059 }
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r1 < r2) goto L_0x002e
                    r2 = 299(0x12b, float:4.19E-43)
                    if (r1 > r2) goto L_0x002e
                    com.google.android.gms.internal.go$a r1 = r3     // Catch:{ MalformedURLException -> 0x0063, IOException -> 0x005e, all -> 0x0059 }
                    java.io.InputStream r2 = r0.getInputStream()     // Catch:{ MalformedURLException -> 0x0063, IOException -> 0x005e, all -> 0x0059 }
                    java.lang.Object r1 = r1.mo8520b(r2)     // Catch:{ MalformedURLException -> 0x0063, IOException -> 0x005e, all -> 0x0059 }
                    if (r0 == 0) goto L_0x002c
                    r0.disconnect()
                L_0x002c:
                    r0 = r1
                L_0x002d:
                    return r0
                L_0x002e:
                    if (r0 == 0) goto L_0x0033
                    r0.disconnect()
                L_0x0033:
                    com.google.android.gms.internal.go$a r0 = r3
                    java.lang.Object r0 = r0.mo8522cK()
                    goto L_0x002d
                L_0x003a:
                    r0 = move-exception
                L_0x003b:
                    java.lang.String r2 = "Error making HTTP request."
                    com.google.android.gms.internal.C1229gs.m4683d(r2, r0)     // Catch:{ all -> 0x0052 }
                    if (r1 == 0) goto L_0x0033
                    r1.disconnect()
                    goto L_0x0033
                L_0x0046:
                    r0 = move-exception
                L_0x0047:
                    java.lang.String r2 = "Error making HTTP request."
                    com.google.android.gms.internal.C1229gs.m4683d(r2, r0)     // Catch:{ all -> 0x0052 }
                    if (r1 == 0) goto L_0x0033
                    r1.disconnect()
                    goto L_0x0033
                L_0x0052:
                    r0 = move-exception
                L_0x0053:
                    if (r1 == 0) goto L_0x0058
                    r1.disconnect()
                L_0x0058:
                    throw r0
                L_0x0059:
                    r1 = move-exception
                    r3 = r1
                    r1 = r0
                    r0 = r3
                    goto L_0x0053
                L_0x005e:
                    r1 = move-exception
                    r3 = r1
                    r1 = r0
                    r0 = r3
                    goto L_0x0047
                L_0x0063:
                    r1 = move-exception
                    r3 = r1
                    r1 = r0
                    r0 = r3
                    goto L_0x003b
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1222go.C12242.call():java.lang.Object");
            }
        });
    }
}
