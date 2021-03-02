package com.qualcomm.ar.pl;

import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ARHttpParams {
    int delayedStart_ms;
    int requestTimeout_ms;

    public static HttpParams createHttpParams(ARHttpParams arParams) {
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, arParams.requestTimeout_ms);
        HttpConnectionParams.setSoTimeout(httpParams, arParams.requestTimeout_ms);
        return httpParams;
    }
}
