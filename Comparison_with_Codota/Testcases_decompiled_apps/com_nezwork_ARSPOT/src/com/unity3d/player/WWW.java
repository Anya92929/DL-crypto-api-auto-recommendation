package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

class WWW extends Thread {
    private int a = 0;
    private int b;
    private String c;
    private byte[] d;
    private Map e;

    WWW(int i, String str, byte[] bArr, Map map) {
        this.b = i;
        this.c = str;
        this.d = bArr;
        this.e = map;
        start();
    }

    private static native void doneCallback(int i);

    private static native void errorCallback(int i, String str);

    private static native boolean headerCallback(int i, String str);

    private static native void progressCallback(int i, float f, float f2, double d2, int i2);

    private static native boolean readCallback(int i, byte[] bArr, int i2);

    /* access modifiers changed from: protected */
    public boolean headerCallback(String str, String str2) {
        return headerCallback(this.b, str + ": " + str2 + "\n\r");
    }

    /* access modifiers changed from: protected */
    public boolean headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            for (String append : (List) entry.getValue()) {
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append(append);
                sb.append("\n\r");
            }
        }
        return headerCallback(this.b, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void progressCallback(int i, int i2, int i3, int i4, long j, long j2) {
        float f;
        float f2;
        double d2;
        if (i4 > 0) {
            f = ((float) i3) / ((float) i4);
            double max = ((double) Math.max(i4 - i3, 0)) / ((1000.0d * ((double) i3)) / Math.max((double) (j - j2), 0.1d));
            if (Double.isInfinite(max) || Double.isNaN(max)) {
                max = 0.0d;
            }
            f2 = 1.0f;
            d2 = max;
        } else if (i2 > 0) {
            f = 0.0f;
            f2 = (float) (i / i2);
            d2 = 0.0d;
        } else {
            return;
        }
        progressCallback(this.b, f2, f, d2, i4);
    }

    /* access modifiers changed from: protected */
    public boolean readCallback(byte[] bArr, int i) {
        return readCallback(this.b, bArr, i);
    }

    public void run() {
        List list;
        int i = this.a + 1;
        this.a = i;
        if (i > 5) {
            errorCallback(this.b, "Too many redirects");
            return;
        }
        try {
            URL url = new URL(this.c);
            URLConnection openConnection = url.openConnection();
            if (this.e != null) {
                for (Map.Entry entry : this.e.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (this.d != null) {
                openConnection.setDoOutput(true);
                try {
                    OutputStream outputStream = openConnection.getOutputStream();
                    int i2 = 0;
                    while (i2 < this.d.length) {
                        int min = Math.min(1428, this.d.length - i2);
                        outputStream.write(this.d, i2, min);
                        i2 += min;
                        progressCallback(i2, this.d.length, 0, 0, 0, 0);
                    }
                } catch (Exception e2) {
                    errorCallback(this.b, e2.toString());
                    return;
                }
            }
            if (openConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    Map headerFields = httpURLConnection.getHeaderFields();
                    if (headerFields != null && ((responseCode == 301 || responseCode == 302) && (list = (List) headerFields.get("Location")) != null && !list.isEmpty())) {
                        httpURLConnection.disconnect();
                        this.c = (String) list.get(0);
                        run();
                        return;
                    }
                } catch (IOException e3) {
                    errorCallback(this.b, e3.toString());
                    return;
                }
            }
            Map<String, List<String>> headerFields2 = openConnection.getHeaderFields();
            boolean headerCallback = headerCallback(headerFields2);
            if ((headerFields2 == null || !headerFields2.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                headerCallback = headerCallback || headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
            }
            if ((headerFields2 == null || !headerFields2.containsKey("content-type")) && openConnection.getContentType() != null) {
                headerCallback = headerCallback || headerCallback("content-type", openConnection.getContentType());
            }
            if (headerCallback) {
                errorCallback(this.b, this.c + " aborted");
                return;
            }
            int contentLength = openConnection.getContentLength() > 0 ? openConnection.getContentLength() : 0;
            int min2 = (url.getProtocol().equalsIgnoreCase("file") || url.getProtocol().equalsIgnoreCase("jar")) ? contentLength == 0 ? 32768 : Math.min(contentLength, 32768) : 1428;
            int i3 = 0;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = new byte[min2];
                InputStream inputStream = openConnection.getInputStream();
                for (int i4 = 0; i4 != -1; i4 = inputStream.read(bArr)) {
                    if (readCallback(bArr, i4)) {
                        errorCallback(this.b, this.c + " aborted");
                        return;
                    }
                    i3 += i4;
                    progressCallback(0, 0, i3, contentLength, System.currentTimeMillis(), currentTimeMillis);
                }
                progressCallback(0, 0, i3, i3, 0, 0);
                doneCallback(this.b);
            } catch (Exception e4) {
                errorCallback(this.b, e4.toString());
            }
        } catch (MalformedURLException e5) {
            errorCallback(this.b, e5.toString());
        } catch (IOException e6) {
            errorCallback(this.b, e6.toString());
        }
    }
}
