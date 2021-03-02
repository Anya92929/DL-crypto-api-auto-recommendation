package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.C1150p;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import java.util.List;

/* renamed from: com.google.android.gms.location.internal.i */
public interface C1129i extends IInterface {
    /* renamed from: a */
    Location mo7850a();

    /* renamed from: a */
    Status mo7851a(GestureRequest gestureRequest, PendingIntent pendingIntent);

    /* renamed from: a */
    ActivityRecognitionResult mo7852a(String str);

    /* renamed from: a */
    void mo7853a(long j, boolean z, PendingIntent pendingIntent);

    /* renamed from: a */
    void mo7854a(PendingIntent pendingIntent);

    /* renamed from: a */
    void mo7855a(PendingIntent pendingIntent, C1126f fVar, String str);

    /* renamed from: a */
    void mo7856a(Location location);

    /* renamed from: a */
    void mo7857a(Location location, int i);

    /* renamed from: a */
    void mo7858a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, C1126f fVar);

    /* renamed from: a */
    void mo7859a(LocationRequest locationRequest, PendingIntent pendingIntent);

    /* renamed from: a */
    void mo7860a(LocationRequest locationRequest, C1150p pVar);

    /* renamed from: a */
    void mo7861a(LocationRequest locationRequest, C1150p pVar, String str);

    /* renamed from: a */
    void mo7862a(LocationSettingsRequest locationSettingsRequest, C1132l lVar, String str);

    /* renamed from: a */
    void mo7863a(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent);

    /* renamed from: a */
    void mo7864a(LocationRequestInternal locationRequestInternal, C1150p pVar);

    /* renamed from: a */
    void mo7865a(LocationRequestUpdateData locationRequestUpdateData);

    /* renamed from: a */
    void mo7866a(C1126f fVar, String str);

    /* renamed from: a */
    void mo7867a(C1150p pVar);

    /* renamed from: a */
    void mo7868a(List<ParcelableGeofence> list, PendingIntent pendingIntent, C1126f fVar, String str);

    /* renamed from: a */
    void mo7869a(boolean z);

    /* renamed from: a */
    void mo7870a(String[] strArr, C1126f fVar, String str);

    /* renamed from: b */
    Location mo7871b(String str);

    /* renamed from: b */
    IBinder mo7872b();

    /* renamed from: b */
    Status mo7873b(PendingIntent pendingIntent);

    /* renamed from: c */
    Status mo7874c(PendingIntent pendingIntent);

    /* renamed from: c */
    LocationAvailability mo7875c(String str);

    /* renamed from: d */
    Status mo7876d(PendingIntent pendingIntent);

    /* renamed from: e */
    void mo7877e(PendingIntent pendingIntent);
}
