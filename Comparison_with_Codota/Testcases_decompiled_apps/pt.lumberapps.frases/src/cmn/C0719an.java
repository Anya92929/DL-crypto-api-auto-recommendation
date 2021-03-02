package cmn;

import android.support.p009v4.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: cmn.an */
public class C0719an {

    /* renamed from: a */
    private static final String f1775a = C0719an.class.getSimpleName();

    private C0719an() {
    }

    /* renamed from: a */
    public static void m3210a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                new StringBuilder("Exception while closing stream: ").append(e);
            }
        }
    }

    /* renamed from: a */
    private static void m3211a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static byte[] m3212a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                m3211a(inputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                m3210a((Closeable) byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                m3210a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            m3210a((Closeable) byteArrayOutputStream);
            throw th;
        }
    }
}
