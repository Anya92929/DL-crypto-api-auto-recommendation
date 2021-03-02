package org.apache.cordova;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpHandler {
    /* access modifiers changed from: protected */
    public Boolean get(String url, String file) {
        HttpEntity entity = getHttpEntity(url);
        try {
            writeToDisk(entity, file);
            try {
                entity.consumeContent();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private HttpEntity getHttpEntity(String url) {
        try {
            return new DefaultHttpClient().execute(new HttpGet(url)).getEntity();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeToDisk(HttpEntity entity, String file) throws IllegalStateException, IOException {
        InputStream in = entity.getContent();
        byte[] buff = new byte[1024];
        FileOutputStream out = new FileOutputStream("/sdcard/" + file);
        while (true) {
            int numread = in.read(buff);
            if (numread <= 0) {
                out.flush();
                out.close();
                return;
            }
            out.write(buff, 0, numread);
        }
    }
}
