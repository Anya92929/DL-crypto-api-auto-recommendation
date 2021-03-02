package android.support.p001v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.p001v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.TaskStackBuilder */
public class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: a */
    private static final C0102a f417a;

    /* renamed from: b */
    private final ArrayList<Intent> f418b = new ArrayList<>();

    /* renamed from: c */
    private final Context f419c;

    /* renamed from: android.support.v4.app.TaskStackBuilder$SupportParentable */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$a */
    interface C0102a {
        /* renamed from: a */
        PendingIntent mo764a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$b */
    static class C0103b implements C0102a {
        C0103b() {
        }

        /* renamed from: a */
        public PendingIntent mo764a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, i, intent, i2);
        }
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$c */
    static class C0104c implements C0102a {
        C0104c() {
        }

        /* renamed from: a */
        public PendingIntent mo764a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return C0009ai.m18a(context, i, intentArr, i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f417a = new C0104c();
        } else {
            f417a = new C0103b();
        }
    }

    private TaskStackBuilder(Context context) {
        this.f419c = context;
    }

    public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    public static TaskStackBuilder from(Context context) {
        return create(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        this.f418b.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f419c.getPackageManager());
        }
        if (component != null) {
            addParentStack(component);
        }
        addNextIntent(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        Intent intent;
        Intent intent2 = null;
        if (activity instanceof SupportParentable) {
            intent2 = ((SupportParentable) activity).getSupportParentActivityIntent();
        }
        if (intent2 == null) {
            intent = NavUtils.getParentActivityIntent(activity);
        } else {
            intent = intent2;
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f419c.getPackageManager());
            }
            addParentStack(component);
            addNextIntent(intent);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(Class<?> cls) {
        return addParentStack(new ComponentName(this.f419c, cls));
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        int size = this.f418b.size();
        try {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.f419c, componentName);
            while (parentActivityIntent != null) {
                this.f418b.add(size, parentActivityIntent);
                parentActivityIntent = NavUtils.getParentActivityIntent(this.f419c, parentActivityIntent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public int getIntentCount() {
        return this.f418b.size();
    }

    public Intent getIntent(int i) {
        return editIntentAt(i);
    }

    public Intent editIntentAt(int i) {
        return this.f418b.get(i);
    }

    public Iterator<Intent> iterator() {
        return this.f418b.iterator();
    }

    public void startActivities() {
        startActivities((Bundle) null);
    }

    public void startActivities(Bundle bundle) {
        if (this.f418b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f418b.toArray(new Intent[this.f418b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!ContextCompat.startActivities(this.f419c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f419c.startActivity(intent);
        }
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, (Bundle) null);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        if (this.f418b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.f418b.toArray(new Intent[this.f418b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return f417a.mo764a(this.f419c, intentArr, i, i2, bundle);
    }

    public Intent[] getIntents() {
        Intent[] intentArr = new Intent[this.f418b.size()];
        if (intentArr.length == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.f418b.get(0)).addFlags(268484608);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= intentArr.length) {
                return intentArr;
            }
            intentArr[i2] = new Intent(this.f418b.get(i2));
            i = i2 + 1;
        }
    }
}
