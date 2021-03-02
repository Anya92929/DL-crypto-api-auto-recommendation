package android.support.p009v4.p010a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/* renamed from: android.support.v4.a.z */
public abstract class C0060z extends BroadcastReceiver {

    /* renamed from: a */
    private static final SparseArray f157a = new SparseArray();

    /* renamed from: b */
    private static int f158b = 1;

    /* renamed from: a */
    public static ComponentName m188a(Context context, Intent intent) {
        synchronized (f157a) {
            int i = f158b;
            f158b++;
            if (f158b <= 0) {
                f158b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f157a.put(i, newWakeLock);
            return startService;
        }
    }

    /* renamed from: a */
    public static boolean m189a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f157a) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) f157a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f157a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
