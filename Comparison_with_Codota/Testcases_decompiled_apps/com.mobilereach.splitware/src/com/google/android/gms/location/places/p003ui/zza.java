package com.google.android.gms.location.places.p003ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl;

/* renamed from: com.google.android.gms.location.places.ui.zza */
abstract class zza {
    public static final int RESULT_ERROR = 2;

    /* renamed from: com.google.android.gms.location.places.ui.zza$zza  reason: collision with other inner class name */
    protected static abstract class C0460zza {
        protected final Intent mIntent;

        public C0460zza(String str) {
            this.mIntent = new Intent(str);
            this.mIntent.setPackage("com.google.android.gms");
        }

        /* access modifiers changed from: protected */
        public Intent build(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            Resources.Theme theme = activity.getTheme();
            TypedValue typedValue = new TypedValue();
            TypedValue typedValue2 = new TypedValue();
            if (theme.resolveAttribute(16843827, typedValue, true) && !this.mIntent.hasExtra("primary_color")) {
                this.mIntent.putExtra("primary_color", typedValue.data);
            }
            if (theme.resolveAttribute(16843828, typedValue2, true) && !this.mIntent.hasExtra("primary_color_dark")) {
                this.mIntent.putExtra("primary_color_dark", typedValue2.data);
            }
            GoogleApiAvailability.getInstance().zzak(activity);
            return this.mIntent;
        }
    }

    zza() {
    }

    public static Place getPlace(Context context, Intent intent) {
        zzx.zzb(intent, (Object) "intent must not be null");
        zzx.zzb(context, (Object) "context must not be null");
        return (Place) zzc.zza(intent, "selected_place", PlaceImpl.CREATOR);
    }

    public static Status getStatus(Context context, Intent intent) {
        zzx.zzb(intent, (Object) "intent must not be null");
        zzx.zzb(context, (Object) "context must not be null");
        return (Status) zzc.zza(intent, "status", Status.CREATOR);
    }
}
