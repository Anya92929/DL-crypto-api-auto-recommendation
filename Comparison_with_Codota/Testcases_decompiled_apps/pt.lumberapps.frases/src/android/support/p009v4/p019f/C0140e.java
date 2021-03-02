package android.support.p009v4.p019f;

import android.support.p009v4.app.NotificationCompat;
import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.f.e */
public class C0140e extends Writer {

    /* renamed from: a */
    private final String f191a;

    /* renamed from: b */
    private StringBuilder f192b = new StringBuilder(NotificationCompat.FLAG_HIGH_PRIORITY);

    public C0140e(String str) {
        this.f191a = str;
    }

    /* renamed from: a */
    private void m342a() {
        if (this.f192b.length() > 0) {
            Log.d(this.f191a, this.f192b.toString());
            this.f192b.delete(0, this.f192b.length());
        }
    }

    public void close() {
        m342a();
    }

    public void flush() {
        m342a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m342a();
            } else {
                this.f192b.append(c);
            }
        }
    }
}
