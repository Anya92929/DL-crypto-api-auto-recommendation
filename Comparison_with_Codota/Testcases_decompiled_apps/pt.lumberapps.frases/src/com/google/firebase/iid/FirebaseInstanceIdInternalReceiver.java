package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.p009v4.p010a.C0060z;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;

public final class FirebaseInstanceIdInternalReceiver extends C0060z {

    /* renamed from: a */
    private static final Queue f7506a = new LinkedList();

    /* renamed from: b */
    private static final Queue f7507b = new LinkedList();

    /* renamed from: a */
    static int m8115a(Context context, String str, Intent intent) {
        char c = 65535;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    c = 0;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                f7506a.offer(intent);
                break;
            case 1:
                f7507b.offer(intent);
                break;
            default:
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Unknown service action: ".concat(valueOf) : new String("Unknown service action: "));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return m8119c(context, intent2);
    }

    /* renamed from: a */
    public static Intent m8116a() {
        return (Intent) f7506a.poll();
    }

    /* renamed from: b */
    public static Intent m8117b(Context context, Intent intent) {
        return m8118b(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }

    /* renamed from: b */
    private static Intent m8118b(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    /* renamed from: c */
    private static int m8119c(Context context, Intent intent) {
        ComponentName startService;
        m8120d(context, intent);
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                startService = m188a(context, intent);
            } else {
                startService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startService != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        }
    }

    /* renamed from: d */
    private static void m8120d(Context context, Intent intent) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            return;
        }
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
            String valueOf = String.valueOf(serviceInfo.packageName);
            String valueOf2 = String.valueOf(serviceInfo.name);
            Log.e("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 94 + String.valueOf(valueOf2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(valueOf).append("/").append(valueOf2).toString());
            return;
        }
        String str = serviceInfo.name;
        if (str.startsWith(".")) {
            String valueOf3 = String.valueOf(context.getPackageName());
            String valueOf4 = String.valueOf(str);
            str = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf5 = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf5) : new String("Restricting intent to a specific service: "));
        }
        intent.setClassName(context.getPackageName(), str);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = (Intent) intent.getParcelableExtra("wrapped_intent");
            if (intent2 == null) {
                Log.w("FirebaseInstanceId", "Missing wrapped intent");
            } else {
                m8115a(context, intent.getAction(), intent2);
            }
        }
    }
}
