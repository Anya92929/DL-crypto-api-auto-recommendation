package com.myip.vpnroot;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Utils {
    public static String notifyWeb(List<NameValuePair> params) {
        String SERVER_PASS = "gaen9sh" + "eizei0" + "isafaeV";
        try {
            params.add(new BasicNameValuePair("username", "gapiv2"));
            params.add(new BasicNameValuePair("password", SERVER_PASS));
            URL url1 = new URL("https://www.myip.io/gapiv2/index.php");
            HttpsURLConnection ucs = null;
            HttpURLConnection uc = null;
            if ("https://www.myip.io/gapiv2/index.php".contains("https:")) {
                if (ucs != null) {
                    ucs.disconnect();
                }
                HttpsURLConnection ucs2 = (HttpsURLConnection) url1.openConnection();
                ucs2.setConnectTimeout(60000);
                ucs2.setRequestMethod("POST");
                ucs2.setDoInput(true);
                ucs2.setDoOutput(true);
                ucs2.setRequestProperty("connection", "close");
                ucs2.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(("gapiv2" + ":" + SERVER_PASS).getBytes(), 0).trim());
                OutputStream os = ucs2.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(getQuery(params));
                writer.close();
                os.close();
                ucs2.connect();
                if (ucs2 != null) {
                    return convertStreamToString(ucs2.getInputStream()).toString();
                }
                InputStream inputStream = uc.getInputStream();
            } else {
                if (uc != null) {
                    uc.disconnect();
                }
                HttpURLConnection uc2 = (HttpURLConnection) url1.openConnection();
                uc2.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(("gapiv2" + ":" + SERVER_PASS).getBytes(), 0).trim());
                uc2.setConnectTimeout(60000);
                uc2.setRequestMethod("POST");
                uc2.setDoInput(true);
                uc2.setDoOutput(true);
                OutputStream os2 = uc2.getOutputStream();
                BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(os2, "UTF-8"));
                writer2.write(getQuery(params));
                writer2.close();
                os2.close();
                uc2.connect();
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (NameValuePair pair : params) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }
        return result.toString();
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    sb.append(line + "\n");
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    is.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    is.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        is.close();
        return sb.toString();
    }
}
