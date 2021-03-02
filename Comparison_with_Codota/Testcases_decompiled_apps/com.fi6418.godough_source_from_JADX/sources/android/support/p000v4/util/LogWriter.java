package android.support.p000v4.util;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.util.LogWriter */
public class LogWriter extends Writer {

    /* renamed from: a */
    private final String f1097a;

    /* renamed from: b */
    private StringBuilder f1098b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f1097a = str;
    }

    /* renamed from: a */
    private void m820a() {
        if (this.f1098b.length() > 0) {
            Log.d(this.f1097a, this.f1098b.toString());
            this.f1098b.delete(0, this.f1098b.length());
        }
    }

    public void close() {
        m820a();
    }

    public void flush() {
        m820a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m820a();
            } else {
                this.f1098b.append(c);
            }
        }
    }
}
