package android.support.p001v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: android.support.v4.util.AtomicFile */
public class AtomicFile {

    /* renamed from: a */
    private final File f847a;

    /* renamed from: b */
    private final File f848b;

    public AtomicFile(File file) {
        this.f847a = file;
        this.f848b = new File(file.getPath() + ".bak");
    }

    public File getBaseFile() {
        return this.f847a;
    }

    public void delete() {
        this.f847a.delete();
        this.f848b.delete();
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.f847a.exists()) {
            if (this.f848b.exists()) {
                this.f847a.delete();
            } else if (!this.f847a.renameTo(this.f848b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f847a + " to backup file " + this.f848b);
            }
        }
        try {
            return new FileOutputStream(this.f847a);
        } catch (FileNotFoundException e) {
            if (!this.f847a.getParentFile().mkdir()) {
                throw new IOException("Couldn't create directory " + this.f847a);
            }
            try {
                return new FileOutputStream(this.f847a);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.f847a);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m982a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f848b.delete();
            } catch (IOException e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            m982a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f847a.delete();
                this.f848b.renameTo(this.f847a);
            } catch (IOException e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f848b.exists()) {
            this.f847a.delete();
            this.f848b.renameTo(this.f847a);
        }
        return new FileInputStream(this.f847a);
    }

    public byte[] readFully() throws IOException {
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

    /* renamed from: a */
    static boolean m982a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}
