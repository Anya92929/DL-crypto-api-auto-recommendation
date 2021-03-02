package android.support.p000v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: android.support.v4.util.AtomicFile */
public class AtomicFile {

    /* renamed from: a */
    private final File f1084a;

    /* renamed from: b */
    private final File f1085b;

    public AtomicFile(File file) {
        this.f1084a = file;
        this.f1085b = new File(file.getPath() + ".bak");
    }

    /* renamed from: a */
    static boolean m815a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public void delete() {
        this.f1084a.delete();
        this.f1085b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m815a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f1084a.delete();
                this.f1085b.renameTo(this.f1084a);
            } catch (IOException e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m815a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f1085b.delete();
            } catch (IOException e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public File getBaseFile() {
        return this.f1084a;
    }

    public FileInputStream openRead() {
        if (this.f1085b.exists()) {
            this.f1084a.delete();
            this.f1085b.renameTo(this.f1084a);
        }
        return new FileInputStream(this.f1084a);
    }

    public byte[] readFully() {
        byte[] bArr;
        int i = 0;
        FileInputStream openRead = openRead();
        try {
            byte[] bArr2 = new byte[openRead.available()];
            while (true) {
                int read = openRead.read(bArr2, i, bArr2.length - i);
                if (read <= 0) {
                    return bArr2;
                }
                int i2 = read + i;
                int available = openRead.available();
                if (available > bArr2.length - i2) {
                    bArr = new byte[(available + i2)];
                    System.arraycopy(bArr2, 0, bArr, 0, i2);
                } else {
                    bArr = bArr2;
                }
                bArr2 = bArr;
                i = i2;
            }
        } finally {
            openRead.close();
        }
    }

    public FileOutputStream startWrite() {
        if (this.f1084a.exists()) {
            if (this.f1085b.exists()) {
                this.f1084a.delete();
            } else if (!this.f1084a.renameTo(this.f1085b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f1084a + " to backup file " + this.f1085b);
            }
        }
        try {
            return new FileOutputStream(this.f1084a);
        } catch (FileNotFoundException e) {
            if (!this.f1084a.getParentFile().mkdir()) {
                throw new IOException("Couldn't create directory " + this.f1084a);
            }
            try {
                return new FileOutputStream(this.f1084a);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.f1084a);
            }
        }
    }
}
