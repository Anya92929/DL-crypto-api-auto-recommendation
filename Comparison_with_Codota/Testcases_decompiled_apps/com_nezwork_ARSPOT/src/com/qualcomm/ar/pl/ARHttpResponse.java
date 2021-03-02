package com.qualcomm.ar.pl;

import java.io.DataInputStream;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class ARHttpResponse {
    private static final String MODULENAME = "ARHttpResponse";
    public byte[] contentBytes;
    public String contentEncoding;
    public String contentType;
    public int statusCode;

    public static ARHttpResponse createARResponse(HttpResponse httpResponse) throws IOException {
        ARHttpResponse arResponse = new ARHttpResponse();
        arResponse.statusCode = httpResponse.getStatusLine().getStatusCode();
        Header header = httpResponse.getFirstHeader("Content-Type");
        if (header != null) {
            arResponse.contentType = header.getValue();
        }
        Header header2 = httpResponse.getFirstHeader("Content-Encoding");
        if (header2 != null) {
            arResponse.contentEncoding = header2.getValue();
        }
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && entity.getContentLength() > 0) {
            arResponse.contentBytes = new byte[((int) entity.getContentLength())];
            new DataInputStream(entity.getContent()).readFully(arResponse.contentBytes);
        }
        return arResponse;
    }
}
