package android.support.p001v4.util;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.util.LogWriter */
public class LogWriter extends Writer {

    /* renamed from: a */
    private final String f857a;

    /* renamed from: b */
    private StringBuilder f858b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f857a = str;
    }

    public void close() {
        m985a();
    }

    public void flush() {
        m985a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m985a();
            } else {
                this.f858b.append(c);
            }
        }
    }

    /* renamed from: a */
    private void m985a() {
        if (this.f858b.length() > 0) {
            Log.d(this.f857a, this.f858b.toString());
            this.f858b.delete(0, this.f858b.length());
        }
    }
}
