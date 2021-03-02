package p006nl.volkerinfradesign.checkandroid.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.AppState;

/* renamed from: nl.volkerinfradesign.checkandroid.data.SystemUtils */
public final class SystemUtils {
    public static File[] filterEquals(File file, final String str) {
        return file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.equals(str);
            }
        });
    }

    public static <T extends Serializable> T load(Class<T> cls, File file) {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                T t = (Serializable) cls.cast(objectInputStream.readObject());
                IOUtils.closeQuietly((InputStream) objectInputStream);
                return t;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    AppState.getInstance().log().mo8930e("Error in SystemUtils", e);
                    IOUtils.closeQuietly((InputStream) objectInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((InputStream) objectInputStream);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            objectInputStream = null;
            e.printStackTrace();
            AppState.getInstance().log().mo8930e("Error in SystemUtils", e);
            IOUtils.closeQuietly((InputStream) objectInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
            IOUtils.closeQuietly((InputStream) objectInputStream);
            throw th;
        }
    }

    public static void save(Serializable serializable, File file) {
        ObjectOutputStream objectOutputStream;
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                AppState.getInstance().log().mo8930e("SystemUtils", e);
            }
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            try {
                objectOutputStream.writeObject(serializable);
                IOUtils.closeQuietly((OutputStream) objectOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    AppState.getInstance().log().mo8930e("SystemUtils", e);
                    IOUtils.closeQuietly((OutputStream) objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((OutputStream) objectOutputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            objectOutputStream = null;
            e.printStackTrace();
            AppState.getInstance().log().mo8930e("SystemUtils", e);
            IOUtils.closeQuietly((OutputStream) objectOutputStream);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
            IOUtils.closeQuietly((OutputStream) objectOutputStream);
            throw th;
        }
    }
}
