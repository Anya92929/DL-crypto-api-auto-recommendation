package com.p028a.p030b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.p009v4.app.FragmentTransaction;
import android.util.Xml;
import com.p028a.p029a.C0766a;
import com.p028a.p031c.C0776a;
import com.p028a.p031c.C0778c;
import com.p028a.p031c.C0780e;
import com.p028a.p031c.C0782g;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.a.b.a */
public abstract class C0768a implements Runnable {

    /* renamed from: J */
    private static C0775h f1900J;

    /* renamed from: L */
    private static final Class[] f1901L = {String.class, Object.class, C0771d.class};

    /* renamed from: P */
    private static ExecutorService f1902P;

    /* renamed from: Q */
    private static SocketFactory f1903Q;

    /* renamed from: R */
    private static DefaultHttpClient f1904R;

    /* renamed from: S */
    private static C0774g f1905S;

    /* renamed from: T */
    private static int f1906T = 200;

    /* renamed from: i */
    private static int f1907i = 30000;

    /* renamed from: j */
    private static String f1908j = null;

    /* renamed from: k */
    private static int f1909k = 4;

    /* renamed from: l */
    private static boolean f1910l = true;

    /* renamed from: m */
    private static boolean f1911m = true;

    /* renamed from: n */
    private static boolean f1912n = false;

    /* renamed from: A */
    private int f1913A = 0;

    /* renamed from: B */
    private boolean f1914B = true;

    /* renamed from: C */
    private long f1915C;

    /* renamed from: D */
    private String f1916D = "UTF-8";

    /* renamed from: E */
    private WeakReference f1917E;

    /* renamed from: F */
    private int f1918F = 4;

    /* renamed from: G */
    private HttpUriRequest f1919G;

    /* renamed from: H */
    private boolean f1920H = true;

    /* renamed from: I */
    private int f1921I = 0;

    /* renamed from: K */
    private HttpHost f1922K;

    /* renamed from: M */
    private boolean f1923M;

    /* renamed from: N */
    private boolean f1924N;

    /* renamed from: O */
    private boolean f1925O;

    /* renamed from: U */
    private boolean f1926U;

    /* renamed from: a */
    protected Map f1927a;

    /* renamed from: b */
    protected Map f1928b;

    /* renamed from: c */
    protected Map f1929c;

    /* renamed from: d */
    protected Object f1930d;

    /* renamed from: e */
    protected C0766a f1931e;

    /* renamed from: f */
    protected C0771d f1932f;

    /* renamed from: g */
    protected boolean f1933g;

    /* renamed from: h */
    protected boolean f1934h;

    /* renamed from: o */
    private Class f1935o;

    /* renamed from: p */
    private Reference f1936p;

    /* renamed from: q */
    private Object f1937q;

    /* renamed from: r */
    private String f1938r;

    /* renamed from: s */
    private WeakReference f1939s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String f1940t;

    /* renamed from: u */
    private String f1941u;

    /* renamed from: v */
    private C0775h f1942v;

    /* renamed from: w */
    private int f1943w = 0;

    /* renamed from: x */
    private File f1944x;

    /* renamed from: y */
    private File f1945y;

    /* renamed from: z */
    private boolean f1946z;

    /* renamed from: a */
    private File m3358a(File file) {
        File file2 = new File(String.valueOf(file.getAbsolutePath()) + ".tmp");
        file2.createNewFile();
        return file2;
    }

    /* renamed from: a */
    private static String m3359a(Uri uri) {
        String str = String.valueOf(uri.getScheme()) + "://" + uri.getAuthority() + uri.getPath();
        String fragment = uri.getFragment();
        return fragment != null ? String.valueOf(str) + "#" + fragment : str;
    }

    /* renamed from: a */
    private String m3361a(HttpEntity httpEntity) {
        Header contentEncoding;
        if (httpEntity == null || (contentEncoding = httpEntity.getContentEncoding()) == null) {
            return null;
        }
        return contentEncoding.getValue();
    }

    /* renamed from: a */
    private String m3362a(byte[] bArr, String str, C0771d dVar) {
        Exception e;
        String str2;
        try {
            if (!"utf-8".equalsIgnoreCase(str)) {
                return new String(bArr, str);
            }
            String f = m3384f(dVar.mo3527d("Content-Type"));
            C0776a.m3534b((Object) "parsing header", (Object) f);
            if (f != null) {
                return new String(bArr, f);
            }
            String str3 = new String(bArr, "utf-8");
            try {
                String e2 = mo3549e(str3);
                C0776a.m3534b((Object) "parsing needed", (Object) e2);
                if (e2 == null || "utf-8".equalsIgnoreCase(e2)) {
                    return str3;
                }
                C0776a.m3534b((Object) "correction needed", (Object) e2);
                str2 = new String(bArr, e2);
                try {
                    dVar.mo3518a(str2.getBytes("utf-8"));
                    return str2;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                Exception exc = e4;
                str2 = str3;
                e = exc;
                C0776a.m3535b((Throwable) e);
                return str2;
            }
        } catch (Exception e5) {
            e = e5;
            str2 = null;
            C0776a.m3535b((Throwable) e);
            return str2;
        }
    }

    /* renamed from: a */
    private HttpResponse m3363a(HttpUriRequest httpUriRequest, DefaultHttpClient defaultHttpClient, HttpContext httpContext) {
        if (!httpUriRequest.getURI().getAuthority().contains("_")) {
            return defaultHttpClient.execute(httpUriRequest, httpContext);
        }
        URL url = httpUriRequest.getURI().toURL();
        return defaultHttpClient.execute(url.getPort() == -1 ? new HttpHost(url.getHost(), 80, url.getProtocol()) : new HttpHost(url.getHost(), url.getPort(), url.getProtocol()), httpUriRequest, httpContext);
    }

    /* renamed from: a */
    private static void m3364a(DataOutputStream dataOutputStream, String str, Object obj) {
        if (obj != null) {
            if (obj instanceof File) {
                File file = (File) obj;
                m3366a(dataOutputStream, str, file.getName(), (InputStream) new FileInputStream(file));
            } else if (obj instanceof byte[]) {
                m3366a(dataOutputStream, str, str, (InputStream) new ByteArrayInputStream((byte[]) obj));
            } else if (obj instanceof InputStream) {
                m3366a(dataOutputStream, str, str, (InputStream) obj);
            } else {
                m3365a(dataOutputStream, str, obj.toString());
            }
        }
    }

    /* renamed from: a */
    private static void m3365a(DataOutputStream dataOutputStream, String str, String str2) {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(str2.getBytes("UTF-8"));
        dataOutputStream.writeBytes("\r\n");
    }

    /* renamed from: a */
    private static void m3366a(DataOutputStream dataOutputStream, String str, String str2, InputStream inputStream) {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\";" + " filename=\"" + str2 + "\"" + "\r\n");
        dataOutputStream.writeBytes("Content-Type: application/octet-stream");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Transfer-Encoding: binary");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        C0776a.m3522a(inputStream, (OutputStream) dataOutputStream);
        dataOutputStream.writeBytes("\r\n");
    }

    /* renamed from: a */
    private void m3367a(InputStream inputStream, OutputStream outputStream, int i) {
        C0780e eVar = null;
        Object obj = this.f1939s != null ? this.f1939s.get() : null;
        if (obj != null) {
            eVar = new C0780e(obj);
        }
        C0776a.m3523a(inputStream, outputStream, i, eVar);
    }

    /* renamed from: a */
    private void m3368a(InputStream inputStream, OutputStream outputStream, int i, File file, File file2) {
        if (file2 == null) {
            m3367a(inputStream, outputStream, i);
            return;
        }
        try {
            m3367a(inputStream, outputStream, i);
            inputStream.close();
            outputStream.close();
            file.renameTo(file2);
        } catch (IOException e) {
            C0776a.m3524a((Object) "copy failed, deleting files");
            file.delete();
            file2.delete();
            C0776a.m3518a((Closeable) inputStream);
            C0776a.m3518a((Closeable) outputStream);
            throw e;
        }
    }

    /* renamed from: a */
    public static void m3369a(Runnable runnable) {
        if (f1902P == null) {
            f1902P = Executors.newFixedThreadPool(f1909k);
        }
        f1902P.execute(runnable);
    }

    /* renamed from: a */
    private void m3370a(String str, C0771d dVar) {
        C0776a.m3534b((Object) "get", (Object) str);
        String h = m3387h(str);
        m3373a((HttpUriRequest) new HttpGet(h), h, dVar);
    }

    /* renamed from: a */
    private void m3371a(String str, Map map, C0771d dVar) {
        C0776a.m3534b((Object) "post", (Object) str);
        m3372a(str, (HttpEntityEnclosingRequestBase) new HttpPost(str), map, dVar);
    }

    /* renamed from: a */
    private void m3372a(String str, HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Map map, C0771d dVar) {
        HttpEntity urlEncodedFormEntity;
        httpEntityEnclosingRequestBase.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        Object obj = map.get("%entity");
        if (obj instanceof HttpEntity) {
            urlEncodedFormEntity = (HttpEntity) obj;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    arrayList.add(new BasicNameValuePair((String) entry.getKey(), value.toString()));
                }
            }
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "UTF-8");
        }
        if (this.f1928b != null && !this.f1928b.containsKey("Content-Type")) {
            this.f1928b.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        }
        httpEntityEnclosingRequestBase.setEntity(urlEncodedFormEntity);
        m3373a((HttpUriRequest) httpEntityEnclosingRequestBase, str, dVar);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x028f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0290, code lost:
        r20 = r3;
        r3 = r2;
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x029a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x029b, code lost:
        r20 = r3;
        r3 = r2;
        r2 = r20;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x028f A[ExcHandler: all (r3v28 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:60:0x013d] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0164  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3373a(org.apache.http.client.methods.HttpUriRequest r22, java.lang.String r23, com.p028a.p030b.C0771d r24) {
        /*
            r21 = this;
            org.apache.http.impl.client.DefaultHttpClient r12 = m3400t()
            com.a.b.g r2 = f1905S
            if (r2 == 0) goto L_0x0011
            com.a.b.g r2 = f1905S
            r0 = r21
            r1 = r22
            r2.mo3552a(r0, r1, r12)
        L_0x0011:
            java.lang.String r2 = f1908j
            if (r2 == 0) goto L_0x00d5
            java.lang.String r2 = "User-Agent"
            java.lang.String r3 = f1908j
            r0 = r22
            r0.addHeader(r2, r3)
        L_0x001e:
            r0 = r21
            java.util.Map r2 = r0.f1928b
            if (r2 == 0) goto L_0x0036
            r0 = r21
            java.util.Map r2 = r0.f1928b
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r4 = r2.iterator()
        L_0x0030:
            boolean r2 = r4.hasNext()
            if (r2 != 0) goto L_0x00e8
        L_0x0036:
            boolean r2 = f1910l
            if (r2 == 0) goto L_0x0055
            r0 = r21
            java.util.Map r2 = r0.f1928b
            if (r2 == 0) goto L_0x004c
            r0 = r21
            java.util.Map r2 = r0.f1928b
            java.lang.String r3 = "Accept-Encoding"
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L_0x0055
        L_0x004c:
            java.lang.String r2 = "Accept-Encoding"
            java.lang.String r3 = "gzip"
            r0 = r22
            r0.addHeader(r2, r3)
        L_0x0055:
            r0 = r21
            com.a.a.a r2 = r0.f1931e
            if (r2 == 0) goto L_0x0066
            r0 = r21
            com.a.a.a r2 = r0.f1931e
            r0 = r21
            r1 = r22
            r2.mo3453a((com.p028a.p030b.C0768a) r0, (org.apache.http.HttpRequest) r1)
        L_0x0066:
            java.lang.String r2 = r21.m3401u()
            if (r2 == 0) goto L_0x0073
            java.lang.String r3 = "Cookie"
            r0 = r22
            r0.addHeader(r3, r2)
        L_0x0073:
            org.apache.http.params.HttpParams r2 = r22.getParams()
            r0 = r21
            org.apache.http.HttpHost r3 = r0.f1922K
            if (r3 == 0) goto L_0x0086
            java.lang.String r3 = "http.route.default-proxy"
            r0 = r21
            org.apache.http.HttpHost r4 = r0.f1922K
            r2.setParameter(r3, r4)
        L_0x0086:
            r0 = r21
            int r3 = r0.f1913A
            if (r3 <= 0) goto L_0x00a6
            java.lang.String r3 = "http.connection.timeout"
            r0 = r21
            int r4 = r0.f1913A
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.setParameter(r3, r4)
            java.lang.String r3 = "http.socket.timeout"
            r0 = r21
            int r4 = r0.f1913A
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.setParameter(r3, r4)
        L_0x00a6:
            r0 = r21
            boolean r3 = r0.f1914B
            if (r3 != 0) goto L_0x00b2
            java.lang.String r3 = "http.protocol.handle-redirects"
            r4 = 0
            r2.setBooleanParameter(r3, r4)
        L_0x00b2:
            org.apache.http.protocol.BasicHttpContext r13 = new org.apache.http.protocol.BasicHttpContext
            r13.<init>()
            org.apache.http.impl.client.BasicCookieStore r3 = new org.apache.http.impl.client.BasicCookieStore
            r3.<init>()
            java.lang.String r4 = "http.cookie-store"
            r13.setAttribute(r4, r3)
            r0 = r22
            r1 = r21
            r1.f1919G = r0
            r0 = r21
            boolean r3 = r0.f1926U
            if (r3 == 0) goto L_0x00ff
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Aborted"
            r2.<init>(r3)
            throw r2
        L_0x00d5:
            java.lang.String r2 = f1908j
            if (r2 != 0) goto L_0x001e
            boolean r2 = f1910l
            if (r2 == 0) goto L_0x001e
            java.lang.String r2 = "User-Agent"
            java.lang.String r3 = "gzip"
            r0 = r22
            r0.addHeader(r2, r3)
            goto L_0x001e
        L_0x00e8:
            java.lang.Object r2 = r4.next()
            java.lang.String r2 = (java.lang.String) r2
            r0 = r21
            java.util.Map r3 = r0.f1928b
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            r0 = r22
            r0.addHeader(r2, r3)
            goto L_0x0030
        L_0x00ff:
            boolean r3 = f1912n
            if (r3 == 0) goto L_0x010b
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Simulated Error"
            r2.<init>(r3)
            throw r2
        L_0x010b:
            r0 = r21
            r1 = r22
            org.apache.http.HttpResponse r2 = r0.m3363a((org.apache.http.client.methods.HttpUriRequest) r1, (org.apache.http.impl.client.DefaultHttpClient) r12, (org.apache.http.protocol.HttpContext) r13)     // Catch:{ HttpHostConnectException -> 0x01a1 }
            r8 = r2
        L_0x0114:
            r10 = 0
            org.apache.http.StatusLine r2 = r8.getStatusLine()
            int r14 = r2.getStatusCode()
            org.apache.http.StatusLine r2 = r8.getStatusLine()
            java.lang.String r15 = r2.getReasonPhrase()
            r9 = 0
            org.apache.http.HttpEntity r5 = r8.getEntity()
            r7 = 0
            r6 = 0
            r2 = 200(0xc8, float:2.8E-43)
            if (r14 < r2) goto L_0x0134
            r2 = 300(0x12c, float:4.2E-43)
            if (r14 < r2) goto L_0x01d8
        L_0x0134:
            r2 = 0
            if (r5 == 0) goto L_0x02aa
            java.io.InputStream r2 = r5.getContent()     // Catch:{ Exception -> 0x01bf, all -> 0x01ce }
            r0 = r21
            java.lang.String r3 = r0.m3361a((org.apache.http.HttpEntity) r5)     // Catch:{ Exception -> 0x029a, all -> 0x028f }
            r0 = r21
            byte[] r4 = r0.m3375a((java.lang.String) r3, (java.io.InputStream) r2)     // Catch:{ Exception -> 0x029a, all -> 0x028f }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x029a, all -> 0x028f }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x029a, all -> 0x028f }
            java.lang.String r4 = "error"
            com.p028a.p031c.C0776a.m3534b((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ Exception -> 0x02a2, all -> 0x028f }
        L_0x0153:
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r2)
            r9 = r3
            r2 = r23
        L_0x0159:
            java.lang.String r3 = "response"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            com.p028a.p031c.C0776a.m3534b((java.lang.Object) r3, (java.lang.Object) r4)
            if (r10 == 0) goto L_0x016e
            int r3 = r10.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0 = r23
            com.p028a.p031c.C0776a.m3534b((java.lang.Object) r3, (java.lang.Object) r0)
        L_0x016e:
            r0 = r24
            com.a.b.d r3 = r0.mo3522b((int) r14)
            com.a.b.d r3 = r3.mo3523b((java.lang.String) r15)
            com.a.b.d r3 = r3.mo3513a((java.lang.String) r9)
            com.a.b.d r2 = r3.mo3525c(r2)
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            com.a.b.d r2 = r2.mo3514a((java.util.Date) r3)
            com.a.b.d r2 = r2.mo3518a((byte[]) r10)
            com.a.b.d r2 = r2.mo3512a((java.io.File) r7)
            com.a.b.d r2 = r2.mo3515a((org.apache.http.impl.client.DefaultHttpClient) r12)
            com.a.b.d r2 = r2.mo3516a((org.apache.http.protocol.HttpContext) r13)
            org.apache.http.Header[] r3 = r8.getAllHeaders()
            r2.mo3519a((org.apache.http.Header[]) r3)
            return
        L_0x01a1:
            r3 = move-exception
            r0 = r21
            org.apache.http.HttpHost r4 = r0.f1922K
            if (r4 == 0) goto L_0x01be
            java.lang.String r3 = "proxy failed, retrying without proxy"
            com.p028a.p031c.C0776a.m3524a((java.lang.Object) r3)
            java.lang.String r3 = "http.route.default-proxy"
            r4 = 0
            r2.setParameter(r3, r4)
            r0 = r21
            r1 = r22
            org.apache.http.HttpResponse r2 = r0.m3363a((org.apache.http.client.methods.HttpUriRequest) r1, (org.apache.http.impl.client.DefaultHttpClient) r12, (org.apache.http.protocol.HttpContext) r13)
            r8 = r2
            goto L_0x0114
        L_0x01be:
            throw r3
        L_0x01bf:
            r3 = move-exception
            r20 = r3
            r3 = r2
            r2 = r20
        L_0x01c5:
            com.p028a.p031c.C0776a.m3527a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0297 }
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r3)
            r2 = r23
            goto L_0x0159
        L_0x01ce:
            r3 = move-exception
            r20 = r3
            r3 = r2
            r2 = r20
        L_0x01d4:
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r3)
            throw r2
        L_0x01d8:
            java.lang.String r2 = "http.target_host"
            java.lang.Object r2 = r13.getAttribute(r2)
            org.apache.http.HttpHost r2 = (org.apache.http.HttpHost) r2
            java.lang.String r3 = "http.request"
            java.lang.Object r3 = r13.getAttribute(r3)
            org.apache.http.client.methods.HttpUriRequest r3 = (org.apache.http.client.methods.HttpUriRequest) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = r2.toURI()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r4.<init>(r2)
            java.net.URI r2 = r3.getURI()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r11 = r2.toString()
            r2 = 32
            r3 = 65536(0x10000, float:9.18355E-41)
            long r16 = r5.getContentLength()
            r0 = r16
            int r4 = (int) r0
            int r3 = java.lang.Math.min(r3, r4)
            int r16 = java.lang.Math.max(r2, r3)
            r4 = 0
            r3 = 0
            java.io.File r7 = r21.m3396p()     // Catch:{ all -> 0x0287 }
            if (r7 != 0) goto L_0x025e
            com.a.c.d r2 = new com.a.c.d     // Catch:{ all -> 0x0287 }
            r0 = r16
            r2.<init>(r0)     // Catch:{ all -> 0x0287 }
            r4 = r2
        L_0x0224:
            java.io.InputStream r3 = r5.getContent()     // Catch:{ all -> 0x0287 }
            java.lang.String r2 = "gzip"
            r0 = r21
            java.lang.String r16 = r0.m3361a((org.apache.http.HttpEntity) r5)     // Catch:{ all -> 0x0287 }
            r0 = r16
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0287 }
            if (r2 == 0) goto L_0x023e
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0287 }
            r2.<init>(r3)     // Catch:{ all -> 0x0287 }
            r3 = r2
        L_0x023e:
            long r16 = r5.getContentLength()     // Catch:{ all -> 0x0287 }
            r0 = r16
            int r5 = (int) r0     // Catch:{ all -> 0x0287 }
            r2 = r21
            r2.m3368a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0287 }
            if (r7 != 0) goto L_0x0274
            r0 = r4
            com.a.c.d r0 = (com.p028a.p031c.C0779d) r0     // Catch:{ all -> 0x0287 }
            r2 = r0
            byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x0287 }
        L_0x0254:
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r3)
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r4)
            r10 = r2
            r2 = r11
            goto L_0x0159
        L_0x025e:
            r0 = r21
            java.io.File r6 = r0.m3358a((java.io.File) r7)     // Catch:{ all -> 0x0287 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0287 }
            java.io.FileOutputStream r16 = new java.io.FileOutputStream     // Catch:{ all -> 0x0287 }
            r0 = r16
            r0.<init>(r6)     // Catch:{ all -> 0x0287 }
            r0 = r16
            r2.<init>(r0)     // Catch:{ all -> 0x0287 }
            r4 = r2
            goto L_0x0224
        L_0x0274:
            boolean r2 = r7.exists()     // Catch:{ all -> 0x0287 }
            if (r2 == 0) goto L_0x0284
            long r16 = r7.length()     // Catch:{ all -> 0x0287 }
            r18 = 0
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x02a8
        L_0x0284:
            r7 = 0
            r2 = r10
            goto L_0x0254
        L_0x0287:
            r2 = move-exception
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r3)
            com.p028a.p031c.C0776a.m3518a((java.io.Closeable) r4)
            throw r2
        L_0x028f:
            r3 = move-exception
            r20 = r3
            r3 = r2
            r2 = r20
            goto L_0x01d4
        L_0x0297:
            r2 = move-exception
            goto L_0x01d4
        L_0x029a:
            r3 = move-exception
            r20 = r3
            r3 = r2
            r2 = r20
            goto L_0x01c5
        L_0x02a2:
            r4 = move-exception
            r9 = r3
            r3 = r2
            r2 = r4
            goto L_0x01c5
        L_0x02a8:
            r2 = r10
            goto L_0x0254
        L_0x02aa:
            r3 = r9
            goto L_0x0153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p028a.p030b.C0768a.m3373a(org.apache.http.client.methods.HttpUriRequest, java.lang.String, com.a.b.d):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m3374a(java.util.Map r3) {
        /*
            java.util.Set r0 = r3.entrySet()
            java.util.Iterator r1 = r0.iterator()
        L_0x0008:
            boolean r0 = r1.hasNext()
            if (r0 != 0) goto L_0x0010
            r0 = 0
        L_0x000f:
            return r0
        L_0x0010:
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getValue()
            java.lang.Object r0 = r0.getKey()
            com.p028a.p031c.C0776a.m3534b((java.lang.Object) r0, (java.lang.Object) r2)
            boolean r0 = r2 instanceof java.io.File
            if (r0 != 0) goto L_0x002d
            boolean r0 = r2 instanceof byte[]
            if (r0 != 0) goto L_0x002d
            boolean r0 = r2 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0008
        L_0x002d:
            r0 = 1
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p028a.p030b.C0768a.m3374a(java.util.Map):boolean");
    }

    /* renamed from: a */
    private byte[] m3375a(String str, InputStream inputStream) {
        if ("gzip".equalsIgnoreCase(str)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return C0776a.m3529a(inputStream);
    }

    /* renamed from: b */
    private static Map m3376b(Uri uri) {
        HashMap hashMap = new HashMap();
        for (String split : uri.getQuery().split("&")) {
            String[] split2 = split.split("=");
            if (split2.length >= 2) {
                hashMap.put(split2[0], split2[1]);
            } else if (split2.length == 1) {
                hashMap.put(split2[0], "");
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private void mo3545b(int i) {
        if (i <= 1) {
            m3398r();
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            try {
                m3398r();
                return;
            } catch (IOException e) {
                if (i2 == i - 1) {
                    throw e;
                }
                i2++;
            }
        }
    }

    /* renamed from: b */
    private void m3378b(String str, C0771d dVar) {
        C0776a.m3534b((Object) "get", (Object) str);
        String h = m3387h(str);
        m3373a((HttpUriRequest) new HttpDelete(h), h, dVar);
    }

    /* renamed from: b */
    private void m3379b(String str, Map map, C0771d dVar) {
        C0776a.m3534b((Object) "put", (Object) str);
        m3372a(str, (HttpEntityEnclosingRequestBase) new HttpPut(str), map, dVar);
    }

    /* renamed from: c */
    private void m3380c(Context context) {
        Object d = mo3505d(this.f1940t);
        if (d != null) {
            this.f1930d = d;
            this.f1932f.mo3511a(4).mo3510a();
            mo3491a();
            return;
        }
        this.f1944x = C0776a.m3511a(context, this.f1943w);
        m3369a((Runnable) this);
    }

    /* renamed from: c */
    private void m3381c(String str, Map map, C0771d dVar) {
        Proxy a;
        byte[] bArr;
        String str2;
        C0776a.m3534b((Object) "multipart", (Object) str);
        URL url = new URL(str);
        if (this.f1922K != null) {
            C0776a.m3534b((Object) "proxy", (Object) this.f1922K);
            a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f1922K.getHostName(), this.f1922K.getPort()));
        } else {
            a = f1905S != null ? f1905S.mo3551a(this) : null;
        }
        HttpURLConnection httpURLConnection = a == null ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(a);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(f1907i * 4);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
        if (this.f1928b != null) {
            for (String str3 : this.f1928b.keySet()) {
                httpURLConnection.setRequestProperty(str3, (String) this.f1928b.get(str3));
            }
        }
        String u = m3401u();
        if (u != null) {
            httpURLConnection.setRequestProperty("Cookie", u);
        }
        if (this.f1931e != null) {
            this.f1931e.mo3452a(this, httpURLConnection);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        for (Map.Entry entry : map.entrySet()) {
            m3364a(dataOutputStream, (String) entry.getKey(), entry.getValue());
        }
        dataOutputStream.writeBytes("--*****--\r\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (responseCode < 200 || responseCode >= 300) {
            str2 = new String(m3375a(contentEncoding, httpURLConnection.getErrorStream()), "UTF-8");
            C0776a.m3534b((Object) "error", (Object) str2);
            bArr = null;
        } else {
            bArr = m3375a(contentEncoding, httpURLConnection.getInputStream());
            str2 = null;
        }
        C0776a.m3534b((Object) "response", (Object) Integer.valueOf(responseCode));
        if (bArr != null) {
            C0776a.m3534b((Object) Integer.valueOf(bArr.length), (Object) str);
        }
        dVar.mo3522b(responseCode).mo3523b(responseMessage).mo3525c(str).mo3514a(new Date()).mo3518a(bArr).mo3513a(str2).mo3515a((DefaultHttpClient) null);
    }

    /* renamed from: e */
    private String mo3549e(String str) {
        Matcher matcher = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return m3384f(matcher.group());
    }

    /* renamed from: f */
    protected static int m3383f() {
        return f1906T;
    }

    /* renamed from: f */
    private String m3384f(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf("charset")) == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(";", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf + 7, indexOf2).replaceAll("[^\\w-]", "");
    }

    /* renamed from: g */
    private Object m3385g() {
        return this;
    }

    /* renamed from: g */
    private String m3386g(String str) {
        if (this.f1941u != null) {
            str = this.f1941u;
        }
        return this.f1931e != null ? this.f1931e.mo3450a(str) : str;
    }

    /* renamed from: h */
    private static String m3387h(String str) {
        return str.replaceAll(" ", "%20").replaceAll("\\|", "%7C");
    }

    /* renamed from: h */
    private void m3388h() {
        this.f1936p = null;
        this.f1937q = null;
        this.f1939s = null;
        this.f1919G = null;
        this.f1942v = null;
        this.f1931e = null;
        this.f1917E = null;
    }

    /* renamed from: i */
    private void m3389i() {
        if (this.f1924N) {
            synchronized (this) {
                try {
                    notifyAll();
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: j */
    private boolean m3390j() {
        if (this.f1917E == null) {
            return true;
        }
        Activity activity = (Activity) this.f1917E.get();
        return activity != null && !activity.isFinishing();
    }

    /* renamed from: k */
    private void m3391k() {
        if (!this.f1946z && this.f1933g) {
            m3393m();
        }
        if (this.f1930d == null) {
            m3394n();
        }
        if (this.f1930d == null) {
            m3395o();
        }
    }

    /* renamed from: l */
    private String m3392l() {
        return this.f1931e != null ? this.f1931e.mo3456b(this.f1940t) : this.f1940t;
    }

    /* renamed from: m */
    private void m3393m() {
        File a = mo3479a(this.f1944x, m3392l());
        if (a != null) {
            this.f1932f.mo3511a(3);
            this.f1930d = mo3488a(this.f1940t, a, this.f1932f);
            if (this.f1930d != null) {
                this.f1932f.mo3514a(new Date(a.lastModified())).mo3510a();
            }
        }
    }

    /* renamed from: n */
    private void m3394n() {
        this.f1930d = mo3502c(this.f1940t);
        if (this.f1930d != null) {
            this.f1932f.mo3511a(2).mo3510a();
        }
    }

    /* renamed from: o */
    private void m3395o() {
        if (this.f1940t == null) {
            this.f1932f.mo3522b(-101).mo3510a();
            return;
        }
        byte[] bArr = null;
        try {
            mo3545b(this.f1921I + 1);
            if (this.f1931e != null && this.f1931e.mo3455a(this, this.f1932f) && !this.f1925O) {
                C0776a.m3534b((Object) "reauth needed", (Object) this.f1932f.mo3532h());
                this.f1925O = true;
                if (this.f1931e.mo3458b(this)) {
                    m3398r();
                } else {
                    this.f1932f.mo3524b(true);
                    return;
                }
            }
            bArr = this.f1932f.mo3533i();
        } catch (IOException e) {
            C0776a.m3524a((Object) "IOException");
            String message = e.getMessage();
            if (message == null || !message.contains("No authentication challenges found")) {
                this.f1932f.mo3522b(-101).mo3523b("network error");
            } else {
                this.f1932f.mo3522b(401).mo3523b(message);
            }
        } catch (Exception e2) {
            C0776a.m3527a((Throwable) e2);
            this.f1932f.mo3522b(-101).mo3523b("network error");
        }
        try {
            this.f1930d = mo3489a(this.f1940t, bArr, this.f1932f);
        } catch (Exception e3) {
            C0776a.m3527a((Throwable) e3);
        }
        if (this.f1930d == null && bArr != null) {
            this.f1932f.mo3522b(-103).mo3523b("transform error");
        }
        f1906T = this.f1932f.mo3531g();
        this.f1932f.mo3510a();
    }

    /* renamed from: p */
    private File m3396p() {
        File file;
        if (!mo3504c()) {
            file = null;
        } else if (this.f1945y != null) {
            file = this.f1945y;
        } else if (this.f1933g) {
            file = mo3497b();
        } else {
            File d = C0776a.m3540d();
            if (d == null) {
                d = this.f1944x;
            }
            file = C0776a.m3512a(d, this.f1940t);
        }
        if (file == null || file.exists()) {
            return file;
        }
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            return file;
        } catch (Exception e) {
            C0776a.m3535b((Throwable) e);
            return null;
        }
    }

    /* renamed from: q */
    private void m3397q() {
        if (this.f1930d != null && this.f1933g) {
            byte[] i = this.f1932f.mo3533i();
            if (i != null) {
                try {
                    if (this.f1932f.mo3535k() == 1) {
                        File b = mo3497b();
                        if (!this.f1932f.mo3530f()) {
                            mo3496a(this.f1940t, this.f1930d, b, i);
                        } else if (b.exists()) {
                            b.delete();
                        }
                    }
                } catch (Exception e) {
                    C0776a.m3527a((Throwable) e);
                }
            }
            this.f1932f.mo3518a((byte[]) null);
        } else if (this.f1932f.mo3531g() == -103) {
            File b2 = mo3497b();
            if (b2.exists()) {
                b2.delete();
                C0776a.m3524a((Object) "invalidated cache due to transform error");
            }
        }
    }

    /* renamed from: r */
    private void m3398r() {
        String str = this.f1940t;
        Map map = this.f1927a;
        if (map == null && str.length() > 2000) {
            Uri parse = Uri.parse(str);
            str = m3359a(parse);
            map = m3376b(parse);
        }
        String g = m3386g(str);
        if (2 == this.f1918F) {
            m3378b(g, this.f1932f);
        } else if (3 == this.f1918F) {
            m3379b(g, map, this.f1932f);
        } else {
            if (1 == this.f1918F && map == null) {
                map = new HashMap();
            }
            if (map == null) {
                m3370a(g, this.f1932f);
            } else if (m3374a(map)) {
                m3381c(g, map, this.f1932f);
            } else {
                m3371a(g, map, this.f1932f);
            }
        }
    }

    /* renamed from: s */
    private void m3399s() {
        if (this.f1940t != null && this.f1934h) {
            mo3494a(this.f1940t, this.f1930d);
        }
        mo3491a();
        m3388h();
    }

    /* renamed from: t */
    private static DefaultHttpClient m3400t() {
        if (f1904R == null || !f1911m) {
            C0776a.m3524a((Object) "creating http client");
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, f1907i);
            HttpConnectionParams.setSoTimeout(basicHttpParams, f1907i);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(25));
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, FragmentTransaction.TRANSIT_EXIT_MASK);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", f1903Q == null ? SSLSocketFactory.getSocketFactory() : f1903Q, 443));
            f1904R = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        }
        return f1904R;
    }

    /* renamed from: u */
    private String m3401u() {
        if (this.f1929c == null || this.f1929c.size() == 0) {
            return null;
        }
        Iterator it = this.f1929c.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str);
            sb.append("=");
            sb.append((String) this.f1929c.get(str));
            if (it.hasNext()) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo3479a(File file, String str) {
        if (this.f1915C < 0) {
            return null;
        }
        File b = C0776a.m3531b(file, str);
        if (b == null || this.f1915C == 0 || System.currentTimeMillis() - b.lastModified() <= this.f1915C) {
            return b;
        }
        return null;
    }

    /* renamed from: a */
    public Object mo3480a(int i) {
        this.f1943w = i;
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3481a(long j) {
        this.f1915C = j;
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3482a(C0766a aVar) {
        this.f1931e = aVar;
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3483a(C0775h hVar) {
        this.f1942v = hVar;
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3484a(Class cls) {
        this.f1935o = cls;
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3485a(Object obj) {
        if (obj != null) {
            this.f1939s = new WeakReference(obj);
        }
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3486a(String str) {
        this.f1940t = str;
        return m3385g();
    }

    /* renamed from: a */
    public Object mo3487a(String str, int i) {
        this.f1922K = new HttpHost(str, i);
        return m3385g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo3488a(String str, File file, C0771d dVar) {
        byte[] a;
        try {
            if (mo3504c()) {
                dVar.mo3512a(file);
                a = null;
            } else {
                a = C0776a.m3529a((InputStream) new FileInputStream(file));
            }
            return mo3489a(str, a, dVar);
        } catch (Exception e) {
            C0776a.m3527a((Throwable) e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo3489a(String str, byte[] bArr, C0771d dVar) {
        JSONArray jSONArray;
        String str2;
        JSONObject jSONObject;
        if (this.f1935o == null) {
            return null;
        }
        File j = dVar.mo3534j();
        if (bArr != null) {
            if (this.f1935o.equals(Bitmap.class)) {
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
            if (this.f1935o.equals(JSONObject.class)) {
                try {
                    str2 = new String(bArr, this.f1916D);
                    try {
                        jSONObject = (JSONObject) new JSONTokener(str2).nextValue();
                    } catch (Exception e) {
                        e = e;
                        C0776a.m3527a((Throwable) e);
                        C0776a.m3524a((Object) str2);
                        jSONObject = null;
                        return jSONObject;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                    C0776a.m3527a((Throwable) e);
                    C0776a.m3524a((Object) str2);
                    jSONObject = null;
                    return jSONObject;
                }
                return jSONObject;
            } else if (this.f1935o.equals(JSONArray.class)) {
                try {
                    jSONArray = (JSONArray) new JSONTokener(new String(bArr, this.f1916D)).nextValue();
                } catch (Exception e3) {
                    C0776a.m3527a((Throwable) e3);
                    jSONArray = null;
                }
                return jSONArray;
            } else if (this.f1935o.equals(String.class)) {
                if (dVar.mo3535k() == 1) {
                    C0776a.m3524a((Object) "network");
                    return m3362a(bArr, this.f1916D, dVar);
                }
                C0776a.m3524a((Object) "file");
                try {
                    return new String(bArr, this.f1916D);
                } catch (Exception e4) {
                    C0776a.m3527a((Throwable) e4);
                    return null;
                }
            } else if (this.f1935o.equals(byte[].class)) {
                return bArr;
            } else {
                if (this.f1942v != null) {
                    return this.f1942v.mo3553a(str, this.f1935o, this.f1916D, bArr, dVar);
                } else if (f1900J == null) {
                    return null;
                } else {
                    return f1900J.mo3553a(str, this.f1935o, this.f1916D, bArr, dVar);
                }
            }
        } else if (j == null) {
            return null;
        } else {
            if (this.f1935o.equals(File.class)) {
                return j;
            }
            if (this.f1935o.equals(C0782g.class)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(j);
                    C0782g gVar = new C0782g(fileInputStream);
                    dVar.mo3520a((Closeable) fileInputStream);
                    return gVar;
                } catch (Exception e5) {
                    C0776a.m3535b((Throwable) e5);
                    return null;
                }
            } else if (this.f1935o.equals(XmlPullParser.class)) {
                XmlPullParser newPullParser = Xml.newPullParser();
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(j);
                    newPullParser.setInput(fileInputStream2, this.f1916D);
                    dVar.mo3520a((Closeable) fileInputStream2);
                    return newPullParser;
                } catch (Exception e6) {
                    C0776a.m3535b((Throwable) e6);
                    return null;
                }
            } else if (!this.f1935o.equals(InputStream.class)) {
                return null;
            } else {
                try {
                    FileInputStream fileInputStream3 = new FileInputStream(j);
                    dVar.mo3520a((Closeable) fileInputStream3);
                    return fileInputStream3;
                } catch (Exception e7) {
                    C0776a.m3535b((Throwable) e7);
                    return null;
                }
            }
        }
    }

    /* renamed from: a */
    public Object mo3490a(boolean z) {
        this.f1933g = z;
        return m3385g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3491a() {
        mo3503c(false);
        this.f1923M = true;
        if (!m3390j()) {
            mo3500b(this.f1940t, this.f1930d, this.f1932f);
        } else if (this.f1938r != null) {
            Object e = mo3507e();
            Class[] clsArr = {String.class, this.f1935o, C0771d.class};
            C0776a.m3513a(e, this.f1938r, true, true, clsArr, f1901L, this.f1940t, this.f1930d, this.f1932f);
        } else {
            try {
                mo3495a(this.f1940t, this.f1930d, this.f1932f);
            } catch (Exception e2) {
                C0776a.m3535b((Throwable) e2);
            }
        }
        m3397q();
        if (!this.f1924N) {
            this.f1932f.mo3526c();
        }
        m3389i();
        C0776a.m3517a();
    }

    /* renamed from: a */
    public void mo3492a(Activity activity) {
        if (activity.isFinishing()) {
            C0776a.m3525a((Object) "Warning", (Object) "Possible memory leak. Calling ajax with a terminated activity.");
        }
        if (this.f1935o == null) {
            C0776a.m3525a((Object) "Warning", (Object) "type() is not called with response type.");
            return;
        }
        this.f1917E = new WeakReference(activity);
        mo3493a((Context) activity);
    }

    /* renamed from: a */
    public void mo3493a(Context context) {
        if (this.f1932f == null) {
            this.f1932f = new C0771d();
            this.f1932f.mo3525c(this.f1940t).mo3517a(this.f1946z);
        } else if (this.f1932f.mo3528d()) {
            this.f1932f.mo3521b();
            this.f1930d = null;
        }
        mo3503c(true);
        if (this.f1931e == null || this.f1931e.mo3454a()) {
            m3380c(context);
            return;
        }
        C0776a.m3534b((Object) "auth needed", (Object) this.f1940t);
        this.f1931e.mo3451a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3494a(String str, Object obj) {
    }

    /* renamed from: a */
    public void mo3495a(String str, Object obj, C0771d dVar) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3496a(String str, Object obj, File file, byte[] bArr) {
        if (file != null && bArr != null) {
            C0776a.m3521a(file, bArr, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public File mo3497b() {
        return C0776a.m3512a(this.f1944x, m3392l());
    }

    /* renamed from: b */
    public Object mo3498b(String str) {
        this.f1941u = str;
        return m3385g();
    }

    /* renamed from: b */
    public Object mo3499b(boolean z) {
        this.f1934h = z;
        return m3385g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3500b(String str, Object obj, C0771d dVar) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo3501b(Context context) {
        return this.f1933g && C0776a.m3531b(C0776a.m3511a(context, this.f1943w), this.f1940t) != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Object mo3502c(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo3503c(boolean z) {
        Object obj = this.f1939s == null ? null : this.f1939s.get();
        if (obj == null) {
            return;
        }
        if (C0776a.m3537b()) {
            C0778c.m3549a(obj, this.f1940t, z);
        } else {
            C0776a.m3526a((Runnable) new C0769b(this, obj, z));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3504c() {
        return File.class.equals(this.f1935o) || XmlPullParser.class.equals(this.f1935o) || InputStream.class.equals(this.f1935o) || C0782g.class.equals(this.f1935o);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Object mo3505d(String str) {
        return null;
    }

    /* renamed from: d */
    public String mo3506d() {
        return this.f1940t;
    }

    /* renamed from: e */
    public Object mo3507e() {
        if (this.f1937q != null) {
            return this.f1937q;
        }
        if (this.f1936p == null) {
            return null;
        }
        return this.f1936p.get();
    }

    public void run() {
        if (!this.f1932f.mo3528d()) {
            try {
                m3391k();
            } catch (Throwable th) {
                C0776a.m3527a(th);
                this.f1932f.mo3522b(-101).mo3510a();
            }
            if (this.f1932f.mo3529e()) {
                return;
            }
            if (this.f1920H) {
                C0776a.m3526a((Runnable) this);
            } else {
                m3399s();
            }
        } else {
            m3399s();
        }
    }
}
