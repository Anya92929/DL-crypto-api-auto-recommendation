package p000;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: as */
public class C0600as {
    /* renamed from: a */
    public static Intent m3400a(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }

    /* renamed from: b */
    public static Intent m3401b(ComponentName componentName) {
        return Intent.makeRestartActivityTask(componentName);
    }
}
