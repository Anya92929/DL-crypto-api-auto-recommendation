package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.C1009bf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.google.android.gms.analytics.internal.l */
class C0564l extends C0514aa {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final byte[] f3875c = "\n".getBytes();

    /* renamed from: a */
    private final String f3876a = m3282a("GoogleAnalytics", C0515ab.f3700a, Build.VERSION.RELEASE, C0570r.m3327a(Locale.getDefault()), Build.MODEL, Build.ID);

    /* renamed from: b */
    private final C0569q f3877b;

    C0564l(C0516ac acVar) {
        super(acVar);
        this.f3877b = new C0569q(acVar.mo6602d());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC, Splitter:B:26:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082 A[SYNTHETIC, Splitter:B:35:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m3281a(java.net.URL r6, byte[] r7) {
        /*
            r5 = this;
            r1 = 0
            com.google.android.gms.common.internal.C1009bf.m4528a(r6)
            com.google.android.gms.common.internal.C1009bf.m4528a(r7)
            java.lang.String r0 = "POST bytes, url"
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.mo6871b(r0, r2, r6)
            boolean r0 = r5.mo6865B()
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = "Post payload\n"
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            r5.mo6866a(r0, r2)
        L_0x0021:
            java.net.HttpURLConnection r2 = r5.mo6815a((java.net.URL) r6)     // Catch:{ IOException -> 0x0064, all -> 0x007e }
            r0 = 1
            r2.setDoOutput(r0)     // Catch:{ IOException -> 0x0094 }
            int r0 = r7.length     // Catch:{ IOException -> 0x0094 }
            r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0094 }
            r2.connect()     // Catch:{ IOException -> 0x0094 }
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ IOException -> 0x0094 }
            r1.write(r7)     // Catch:{ IOException -> 0x0094 }
            r5.m3285a((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x0094 }
            int r0 = r2.getResponseCode()     // Catch:{ IOException -> 0x0094 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x0049
            com.google.android.gms.analytics.internal.t r3 = r5.mo6891t()     // Catch:{ IOException -> 0x0094 }
            r3.mo6857h()     // Catch:{ IOException -> 0x0094 }
        L_0x0049:
            java.lang.String r3 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0094 }
            r5.mo6870b(r3, r4)     // Catch:{ IOException -> 0x0094 }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x005d }
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.disconnect()
        L_0x005c:
            return r0
        L_0x005d:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.mo6880e(r3, r1)
            goto L_0x0057
        L_0x0064:
            r0 = move-exception
            r2 = r1
        L_0x0066:
            java.lang.String r3 = "Network POST connection error"
            r5.mo6877d(r3, r0)     // Catch:{ all -> 0x0092 }
            r0 = 0
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ IOException -> 0x0077 }
        L_0x0071:
            if (r2 == 0) goto L_0x005c
            r2.disconnect()
            goto L_0x005c
        L_0x0077:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.mo6880e(r3, r1)
            goto L_0x0071
        L_0x007e:
            r0 = move-exception
            r2 = r1
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()     // Catch:{ IOException -> 0x008b }
        L_0x0085:
            if (r2 == 0) goto L_0x008a
            r2.disconnect()
        L_0x008a:
            throw r0
        L_0x008b:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.mo6880e(r3, r1)
            goto L_0x0085
        L_0x0092:
            r0 = move-exception
            goto L_0x0080
        L_0x0094:
            r0 = move-exception
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0564l.m3281a(java.net.URL, byte[]):int");
    }

    /* renamed from: a */
    private static String m3282a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    /* renamed from: a */
    private URL m3283a(C0556d dVar, String str) {
        try {
            return new URL(dVar.mo6792f() ? mo6888q().mo6745o() + mo6888q().mo6747q() + "?" + str : mo6888q().mo6746p() + mo6888q().mo6747q() + "?" + str);
        } catch (MalformedURLException e) {
            mo6880e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m3284a(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* renamed from: a */
    private void m3285a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                } catch (IOException e) {
                    mo6880e("Error closing http connection input stream", e);
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    mo6880e("Error closing http connection input stream", e2);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m3286a(C0556d dVar) {
        C1009bf.m4528a(dVar);
        String a = mo6814a(dVar, !dVar.mo6792f());
        if (a == null) {
            mo6887p().mo6804a(dVar, "Error formatting hit for upload");
            return true;
        } else if (a.length() <= mo6888q().mo6734d()) {
            URL a2 = m3283a(dVar, a);
            if (a2 != null) {
                return m3288b(a2) == 200;
            }
            mo6881f("Failed to build collect GET endpoint url");
            return false;
        } else {
            String a3 = mo6814a(dVar, false);
            if (a3 == null) {
                mo6887p().mo6804a(dVar, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = a3.getBytes();
            if (bytes.length > mo6888q().mo6736f()) {
                mo6887p().mo6804a(dVar, "Hit payload exceeds size limit");
                return true;
            }
            URL b = m3290b(dVar);
            if (b != null) {
                return m3281a(b, bytes) == 200;
            }
            mo6881f("Failed to build collect POST endpoint url");
            return false;
        }
    }

    /* renamed from: a */
    private static byte[] m3287a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private int m3288b(URL url) {
        int i;
        C1009bf.m4528a(url);
        mo6870b("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection a = mo6815a(url);
            a.connect();
            m3285a(a);
            i = a.getResponseCode();
            if (i == 200) {
                mo6891t().mo6857h();
            }
            mo6870b("GET status", Integer.valueOf(i));
            if (a != null) {
                a.disconnect();
            }
        } catch (IOException e) {
            mo6877d("Network GET connection error", e);
            i = 0;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af A[SYNTHETIC, Splitter:B:35:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3 A[SYNTHETIC, Splitter:B:44:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m3289b(java.net.URL r9, byte[] r10) {
        /*
            r8 = this;
            r1 = 0
            com.google.android.gms.common.internal.C1009bf.m4528a(r9)
            com.google.android.gms.common.internal.C1009bf.m4528a(r10)
            byte[] r0 = m3287a((byte[]) r10)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r2 = "POST compressed size, ratio %, url"
            int r3 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r4 = 100
            int r6 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r6 = (long) r6     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r4 = r4 * r6
            int r6 = r10.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r6 = (long) r6     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r8.mo6868a(r2, r3, r4, r9)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            int r2 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            int r3 = r10.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            if (r2 <= r3) goto L_0x0034
            java.lang.String r2 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r3 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            int r4 = r10.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r8.mo6875c(r2, r3, r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
        L_0x0034:
            boolean r2 = r8.mo6865B()     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            if (r2 == 0) goto L_0x0057
            java.lang.String r2 = "Post payload"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r3.<init>()     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r4 = "\n"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r4.<init>(r10)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r8.mo6866a(r2, r3)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
        L_0x0057:
            java.net.HttpURLConnection r3 = r8.mo6815a((java.net.URL) r9)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r2 = 1
            r3.setDoOutput(r2)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r3.addRequestProperty(r2, r4)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            int r2 = r0.length     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r3.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r3.connect()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            java.io.OutputStream r2 = r3.getOutputStream()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r2.write(r0)     // Catch:{ IOException -> 0x00de, all -> 0x00d5 }
            r2.close()     // Catch:{ IOException -> 0x00de, all -> 0x00d5 }
            r2 = 0
            r8.m3285a((java.net.HttpURLConnection) r3)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 != r4) goto L_0x008a
            com.google.android.gms.analytics.internal.t r4 = r8.mo6891t()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r4.mo6857h()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
        L_0x008a:
            java.lang.String r4 = "POST status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r8.mo6870b(r4, r5)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            if (r1 == 0) goto L_0x0098
            r2.close()     // Catch:{ IOException -> 0x009e }
        L_0x0098:
            if (r3 == 0) goto L_0x009d
            r3.disconnect()
        L_0x009d:
            return r0
        L_0x009e:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.mo6880e(r2, r1)
            goto L_0x0098
        L_0x00a5:
            r0 = move-exception
            r2 = r1
        L_0x00a7:
            java.lang.String r3 = "Network compressed POST connection error"
            r8.mo6877d(r3, r0)     // Catch:{ all -> 0x00d8 }
            r0 = 0
            if (r1 == 0) goto L_0x00b2
            r1.close()     // Catch:{ IOException -> 0x00b8 }
        L_0x00b2:
            if (r2 == 0) goto L_0x009d
            r2.disconnect()
            goto L_0x009d
        L_0x00b8:
            r1 = move-exception
            java.lang.String r3 = "Error closing http compressed post connection output stream"
            r8.mo6880e(r3, r1)
            goto L_0x00b2
        L_0x00bf:
            r0 = move-exception
            r3 = r1
        L_0x00c1:
            if (r1 == 0) goto L_0x00c6
            r1.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00c6:
            if (r3 == 0) goto L_0x00cb
            r3.disconnect()
        L_0x00cb:
            throw r0
        L_0x00cc:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.mo6880e(r2, r1)
            goto L_0x00c6
        L_0x00d3:
            r0 = move-exception
            goto L_0x00c1
        L_0x00d5:
            r0 = move-exception
            r1 = r2
            goto L_0x00c1
        L_0x00d8:
            r0 = move-exception
            r3 = r2
            goto L_0x00c1
        L_0x00db:
            r0 = move-exception
            r2 = r3
            goto L_0x00a7
        L_0x00de:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0564l.m3289b(java.net.URL, byte[]):int");
    }

    /* renamed from: b */
    private URL m3290b(C0556d dVar) {
        try {
            return new URL(dVar.mo6792f() ? mo6888q().mo6745o() + mo6888q().mo6747q() : mo6888q().mo6746p() + mo6888q().mo6747q());
        } catch (MalformedURLException e) {
            mo6880e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* renamed from: c */
    private String m3291c(C0556d dVar) {
        return String.valueOf(dVar.mo6789c());
    }

    /* renamed from: d */
    private URL m3293d() {
        try {
            return new URL(mo6888q().mo6745o() + mo6888q().mo6748r());
        } catch (MalformedURLException e) {
            mo6880e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6814a(C0556d dVar, boolean z) {
        C1009bf.m4528a(dVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : dVar.mo6788b().entrySet()) {
                String str = (String) next.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    m3284a(sb, str, (String) next.getValue());
                }
            }
            m3284a(sb, "ht", String.valueOf(dVar.mo6790d()));
            m3284a(sb, "qt", String.valueOf(mo6885n().mo6990a() - dVar.mo6790d()));
            if (mo6888q().mo6731a()) {
                m3284a(sb, "_gmsv", C0515ab.f3700a);
            }
            if (z) {
                long g = dVar.mo6793g();
                m3284a(sb, "z", g != 0 ? String.valueOf(g) : m3291c(dVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            mo6880e("Failed to encode name or value", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo6815a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(mo6888q().mo6727D());
        httpURLConnection.setReadTimeout(mo6888q().mo6728E());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.f3876a);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* renamed from: a */
    public List<Long> mo6816a(List<C0556d> list) {
        boolean z;
        boolean z2 = true;
        mo6884m();
        mo6596D();
        C1009bf.m4528a(list);
        if (mo6888q().mo6751u().isEmpty() || !this.f3877b.mo6834a(mo6888q().mo6744n() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = mo6888q().mo6749s() != C0534au.NONE;
            if (mo6888q().mo6750t() != C0538ay.GZIP) {
                z2 = false;
            }
        }
        return z ? mo6817a(list, z2) : mo6818b(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<Long> mo6817a(List<C0556d> list, boolean z) {
        C1009bf.m4536b(!list.isEmpty());
        mo6867a("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        C0565m mVar = new C0565m(this);
        ArrayList arrayList = new ArrayList();
        for (C0556d next : list) {
            if (!mVar.mo6821a(next)) {
                break;
            }
            arrayList.add(Long.valueOf(next.mo6789c()));
        }
        if (mVar.mo6820a() == 0) {
            return arrayList;
        }
        URL d = m3293d();
        if (d == null) {
            mo6881f("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int b = z ? m3289b(d, mVar.mo6822b()) : m3281a(d, mVar.mo6822b());
        if (200 == b) {
            mo6866a("Batched upload completed. Hits batched", Integer.valueOf(mVar.mo6820a()));
            return arrayList;
        }
        mo6866a("Network error uploading hits. status code", Integer.valueOf(b));
        if (mo6888q().mo6751u().contains(Integer.valueOf(b))) {
            mo6879e("Server instructed the client to stop batching");
            this.f3877b.mo6833a();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        mo6866a("Network initialized. User agent", this.f3876a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<Long> mo6818b(List<C0556d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C0556d next : list) {
            if (m3286a(next)) {
                arrayList.add(Long.valueOf(next.mo6789c()));
                if (arrayList.size() >= mo6888q().mo6742l()) {
                    break;
                }
            } else {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean mo6819b() {
        NetworkInfo networkInfo;
        mo6884m();
        mo6596D();
        try {
            networkInfo = ((ConnectivityManager) mo6886o().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        mo6869b("No network connectivity");
        return false;
    }
}
