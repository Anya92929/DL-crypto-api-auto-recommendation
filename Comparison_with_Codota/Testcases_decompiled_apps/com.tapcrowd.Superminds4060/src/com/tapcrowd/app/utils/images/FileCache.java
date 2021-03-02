package com.tapcrowd.app.utils.images;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCache {
    private File cacheDir;

    public FileCache(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.cacheDir = new File(Environment.getExternalStorageDirectory(), "Tapcrowd");
        } else {
            this.cacheDir = context.getCacheDir();
        }
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
        }
    }

    public File getFile(String url) {
        return new File(this.cacheDir, String.valueOf(url.hashCode()));
    }

    public void clear() {
        File[] files = this.cacheDir.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }
    }

    public File copy(String url, String target) {
        FileOutputStream fileOutputStream;
        File toCopy = getFile(url);
        File copy = new File(this.cacheDir, target);
        try {
            FileInputStream fileInputStream = new FileInputStream(toCopy);
            try {
                fileOutputStream = new FileOutputStream(copy);
            } catch (Exception e) {
                e = e;
                FileInputStream fileInputStream2 = fileInputStream;
                e.printStackTrace();
                return null;
            }
            try {
                byte[] buffer = new byte[1024];
                while (true) {
                    int length = fileInputStream.read(buffer);
                    if (length <= 0) {
                        fileInputStream.close();
                        fileOutputStream.close();
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        FileInputStream fileInputStream3 = fileInputStream;
                        return copy;
                    }
                    fileOutputStream.write(buffer, 0, length);
                }
            } catch (Exception e2) {
                e = e2;
                FileOutputStream fileOutputStream3 = fileOutputStream;
                FileInputStream fileInputStream4 = fileInputStream;
                e.printStackTrace();
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }
}
