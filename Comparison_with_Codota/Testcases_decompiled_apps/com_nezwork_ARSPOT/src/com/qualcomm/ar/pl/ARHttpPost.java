package com.qualcomm.ar.pl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;

public class ARHttpPost {
    private static final String MODULENAME = "ARHttpPost";
    public byte[] content = null;
    public String contentEncoding = null;
    public String contentPath = null;
    public String contentType = null;
    public String[] headers;
    boolean isQuery;
    public long nativeRequestPtr;
    public String url;

    public static HttpPost createHttpPost(ARHttpPost arPost) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(arPost.url);
        for (int i = 0; i < arPost.headers.length / 2; i++) {
            httpPost.addHeader(arPost.headers[i * 2], arPost.headers[(i * 2) + 1]);
        }
        if (arPost.isQuery) {
            httpPost.setEntity(new StringEntity("", "UTF-8"));
        } else if (arPost.contentPath != null) {
            httpPost.setEntity(new FileEntity(new File(arPost.contentPath), arPost.contentType));
        } else if (arPost.content != null) {
            httpPost.setEntity(new ByteArrayEntity(arPost.content));
        }
        return httpPost;
    }
}
