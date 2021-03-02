package android.support.p000v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.TaskStackBuilder */
public class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: a */
    private static final TaskStackBuilderImpl f711a;

    /* renamed from: b */
    private final ArrayList<Intent> f712b = new ArrayList<>();

    /* renamed from: c */
    private final Context f713c;

    /* renamed from: android.support.v4.app.TaskStackBuilder$SupportParentable */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl */
    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplBase */
    class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
        }

        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, i, intent, i2);
        }
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplHoneycomb */
    class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
        }

        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, i, intentArr, i2);
        }
    }

    /* renamed from: android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplJellybean */
    class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        TaskStackBuilderImplJellybean() {
        }

        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return TaskStackBuilderJellybean.getActivitiesPendingIntent(context, i, intentArr, i2, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f711a = new TaskStackBuilderImplHoneycomb();
        } else {
            f711a = new TaskStackBuilderImplBase();
        }
    }

    private TaskStackBuilder(Context context) {
        this.f713c = context;
    }

    public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    public static TaskStackBuilder from(Context context) {
        return create(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        this.f712b.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f713c.getPackageManager());
        }
        if (component != null) {
            addParentStack(component);
        }
        addNextIntent(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        Intent intent = null;
        if (activity instanceof SupportParentable) {
            intent = ((SupportParentable) activity).getSupportParentActivityIntent();
        }
        Intent parentActivityIntent = intent == null ? NavUtils.getParentActivityIntent(activity) : intent;
        if (parentActivityIntent != null) {
            ComponentName component = parentActivityIntent.getComponent();
            if (component == null) {
                component = parentActivityIntent.resolveActivity(this.f713c.getPackageManager());
            }
            addParentStack(component);
            addNextIntent(parentActivityIntent);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        int size = this.f712b.size();
        try {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.f713c, componentName);
            while (parentActivityIntent != null) {
                this.f712b.add(size, parentActivityIntent);
                parentActivityIntent = NavUtils.getParentActivityIntent(this.f713c, parentActivityIntent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public TaskStackBuilder addParentStack(Class<?> cls) {
        return addParentStack(new ComponentName(this.f713c, cls));
    }

    public Intent editIntentAt(int i) {
        return this.f712b.get(i);
    }

    public Intent getIntent(int i) {
        return editIntentAt(i);
    }

    public int getIntentCount() {
        return this.f712b.size();
    }

    public Intent[] getIntents() {
        Intent[] intentArr = new Intent[this.f712b.size()];
        if (intentArr.length == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.f712b.get(0)).addFlags(268484608);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= intentArr.length) {
                return intentArr;
            }
            intentArr[i2] = new Intent(this.f712b.get(i2));
            i = i2 + 1;
        }
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, (Bundle) null);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        if (this.f712b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.f712b.toArray(new Intent[this.f712b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return f711a.getPendingIntent(this.f713c, intentArr, i, i2, bundle);
    }

    public Iterator<Intent> iterator() {
        return this.f712b.iterator();
    }

    public void startActivities() {
        startActivities((Bundle) null);
    }

    public void startActivities(Bundle bundle) {
        if (this.f712b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f712b.toArray(new Intent[this.f712b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!ContextCompat.startActivities(this.f713c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f713c.startActivity(intent);
        }
    }
}
