package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzee;

public interface zzs extends IInterface {

    public abstract class zza extends Binder implements zzs {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static zzs zzl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new C1250w(iBinder) : (zzs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v25, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x0052;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0088;
                    case 7: goto L_0x00a4;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                com.google.android.gms.ads.internal.client.zzr r2 = r4.zzes()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzq r0 = com.google.android.gms.ads.internal.client.zzq.zza.zzj(r0)
                r4.zzb((com.google.android.gms.ads.internal.client.zzq) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x003d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzeb r0 = com.google.android.gms.internal.zzeb.zza.zzae(r0)
                r4.zza((com.google.android.gms.internal.zzeb) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0052:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzec r0 = com.google.android.gms.internal.zzec.zza.zzaf(r0)
                r4.zza((com.google.android.gms.internal.zzec) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0067:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzee r2 = com.google.android.gms.internal.zzee.zza.zzah(r2)
                android.os.IBinder r3 = r6.readStrongBinder()
                com.google.android.gms.internal.zzed r3 = com.google.android.gms.internal.zzed.zza.zzag(r3)
                r4.zza(r0, r2, r3)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0088:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x009b
                com.google.android.gms.ads.internal.formats.zzj r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r0 = (com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel) r0
            L_0x009b:
                r4.zza((com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00a4:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzy r0 = com.google.android.gms.ads.internal.client.zzy.zza.zzq(r0)
                r4.zzb((com.google.android.gms.ads.internal.client.zzy) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzs.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(NativeAdOptionsParcel nativeAdOptionsParcel);

    void zza(zzeb zzeb);

    void zza(zzec zzec);

    void zza(String str, zzee zzee, zzed zzed);

    void zzb(zzq zzq);

    void zzb(zzy zzy);

    zzr zzes();
}
