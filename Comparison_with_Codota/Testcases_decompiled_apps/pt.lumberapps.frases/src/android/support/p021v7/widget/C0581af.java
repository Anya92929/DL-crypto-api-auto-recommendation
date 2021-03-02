package android.support.p021v7.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.widget.af */
final class C0581af extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ C0704z f1362a;

    private C0581af(C0704z zVar) {
        this.f1362a = zVar;
    }

    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        List list = objArr[0];
        String str = objArr[1];
        try {
            FileOutputStream openFileOutput = this.f1362a.f1733g.openFileOutput(str, 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, (String) null);
                newSerializer.startDocument("UTF-8", true);
                newSerializer.startTag((String) null, "historical-records");
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    C0579ad adVar = (C0579ad) list.remove(0);
                    newSerializer.startTag((String) null, "historical-record");
                    newSerializer.attribute((String) null, "activity", adVar.f1359a.flattenToString());
                    newSerializer.attribute((String) null, "time", String.valueOf(adVar.f1360b));
                    newSerializer.attribute((String) null, "weight", String.valueOf(adVar.f1361c));
                    newSerializer.endTag((String) null, "historical-record");
                }
                newSerializer.endTag((String) null, "historical-records");
                newSerializer.endDocument();
                boolean unused = this.f1362a.f1738l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IllegalArgumentException e2) {
                Log.e(C0704z.f1727a, "Error writing historical recrod file: " + this.f1362a.f1734h, e2);
                boolean unused2 = this.f1362a.f1738l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IllegalStateException e4) {
                Log.e(C0704z.f1727a, "Error writing historical recrod file: " + this.f1362a.f1734h, e4);
                boolean unused3 = this.f1362a.f1738l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (IOException e6) {
                Log.e(C0704z.f1727a, "Error writing historical recrod file: " + this.f1362a.f1734h, e6);
                boolean unused4 = this.f1362a.f1738l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (Throwable th) {
                boolean unused5 = this.f1362a.f1738l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            Log.e(C0704z.f1727a, "Error writing historical recrod file: " + str, e9);
        }
        return null;
    }
}
