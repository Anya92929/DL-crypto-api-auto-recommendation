package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.dynamic.zzd;
import java.util.List;

public interface zzgk extends IInterface {

    public abstract class zza extends Binder implements zzgk {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static zzgk zzak(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzgk)) ? new C1641iq(iBinder) : (zzgk) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel} */
        /* JADX WARNING: type inference failed for: r6v0 */
        /* JADX WARNING: type inference failed for: r6v1, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r6v3, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r6v6 */
        /* JADX WARNING: type inference failed for: r6v8, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r6v10 */
        /* JADX WARNING: type inference failed for: r6v11 */
        /* JADX WARNING: type inference failed for: r6v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) {
            /*
                r9 = this;
                r0 = 0
                r6 = 0
                r8 = 1
                switch(r10) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x006a;
                    case 4: goto L_0x009b;
                    case 5: goto L_0x00a8;
                    case 6: goto L_0x00b5;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x0134;
                    case 9: goto L_0x0141;
                    case 10: goto L_0x014e;
                    case 11: goto L_0x0185;
                    case 12: goto L_0x01a6;
                    case 13: goto L_0x01b3;
                    case 14: goto L_0x01c7;
                    case 15: goto L_0x0211;
                    case 16: goto L_0x0228;
                    case 17: goto L_0x023f;
                    case 18: goto L_0x025a;
                    case 19: goto L_0x0275;
                    case 20: goto L_0x0290;
                    case 21: goto L_0x02b5;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r8 = super.onTransact(r10, r11, r12, r13)
            L_0x000a:
                return r8
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r12.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0050
                com.google.android.gms.ads.internal.client.zzi r0 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdSizeParcel r0 = (com.google.android.gms.ads.internal.client.AdSizeParcel) r0
                r2 = r0
            L_0x002d:
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0052
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
                r3 = r0
            L_0x003c:
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzgl r5 = com.google.android.gms.internal.zzgl.zza.zzal(r0)
                r0 = r9
                r0.zza((com.google.android.gms.dynamic.zzd) r1, (com.google.android.gms.ads.internal.client.AdSizeParcel) r2, (com.google.android.gms.ads.internal.client.AdRequestParcel) r3, (java.lang.String) r4, (com.google.android.gms.internal.zzgl) r5)
                r12.writeNoException()
                goto L_0x000a
            L_0x0050:
                r2 = r6
                goto L_0x002d
            L_0x0052:
                r3 = r6
                goto L_0x003c
            L_0x0054:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                com.google.android.gms.dynamic.zzd r0 = r9.getView()
                r12.writeNoException()
                if (r0 == 0) goto L_0x0066
                android.os.IBinder r6 = r0.asBinder()
            L_0x0066:
                r12.writeStrongBinder(r6)
                goto L_0x000a
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0099
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
            L_0x0085:
                java.lang.String r2 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.internal.zzgl r3 = com.google.android.gms.internal.zzgl.zza.zzal(r3)
                r9.zza(r1, r0, r2, r3)
                r12.writeNoException()
                goto L_0x000a
            L_0x0099:
                r0 = r6
                goto L_0x0085
            L_0x009b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.showInterstitial()
                r12.writeNoException()
                goto L_0x000a
            L_0x00a8:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.destroy()
                r12.writeNoException()
                goto L_0x000a
            L_0x00b5:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x00f9
                com.google.android.gms.ads.internal.client.zzi r0 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdSizeParcel r0 = (com.google.android.gms.ads.internal.client.AdSizeParcel) r0
                r2 = r0
            L_0x00d1:
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x00fb
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
                r3 = r0
            L_0x00e0:
                java.lang.String r4 = r11.readString()
                java.lang.String r5 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzgl r6 = com.google.android.gms.internal.zzgl.zza.zzal(r0)
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5, r6)
                r12.writeNoException()
                goto L_0x000a
            L_0x00f9:
                r2 = r6
                goto L_0x00d1
            L_0x00fb:
                r3 = r6
                goto L_0x00e0
            L_0x00fd:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0132
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
                r2 = r0
            L_0x0119:
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzgl r5 = com.google.android.gms.internal.zzgl.zza.zzal(r0)
                r0 = r9
                r0.zza((com.google.android.gms.dynamic.zzd) r1, (com.google.android.gms.ads.internal.client.AdRequestParcel) r2, (java.lang.String) r3, (java.lang.String) r4, (com.google.android.gms.internal.zzgl) r5)
                r12.writeNoException()
                goto L_0x000a
            L_0x0132:
                r2 = r6
                goto L_0x0119
            L_0x0134:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.pause()
                r12.writeNoException()
                goto L_0x000a
            L_0x0141:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.resume()
                r12.writeNoException()
                goto L_0x000a
            L_0x014e:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0183
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
                r2 = r0
            L_0x016a:
                java.lang.String r3 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.ads.internal.reward.mediation.client.zza r4 = com.google.android.gms.ads.internal.reward.mediation.client.zza.C2107zza.zzbj(r0)
                java.lang.String r5 = r11.readString()
                r0 = r9
                r0.zza((com.google.android.gms.dynamic.zzd) r1, (com.google.android.gms.ads.internal.client.AdRequestParcel) r2, (java.lang.String) r3, (com.google.android.gms.ads.internal.reward.mediation.client.zza) r4, (java.lang.String) r5)
                r12.writeNoException()
                goto L_0x000a
            L_0x0183:
                r2 = r6
                goto L_0x016a
            L_0x0185:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x01a4
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
            L_0x0198:
                java.lang.String r1 = r11.readString()
                r9.zzc(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x01a4:
                r0 = r6
                goto L_0x0198
            L_0x01a6:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.showVideo()
                r12.writeNoException()
                goto L_0x000a
            L_0x01b3:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                boolean r1 = r9.isInitialized()
                r12.writeNoException()
                if (r1 == 0) goto L_0x01c2
                r0 = r8
            L_0x01c2:
                r12.writeInt(r0)
                goto L_0x000a
            L_0x01c7:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x020f
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
                r2 = r0
            L_0x01e3:
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzgl r5 = com.google.android.gms.internal.zzgl.zza.zzal(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0202
                com.google.android.gms.ads.internal.formats.zzj r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r0 = (com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel) r0
                r6 = r0
            L_0x0202:
                java.util.ArrayList r7 = r11.createStringArrayList()
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5, r6, r7)
                r12.writeNoException()
                goto L_0x000a
            L_0x020f:
                r2 = r6
                goto L_0x01e3
            L_0x0211:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                com.google.android.gms.internal.zzgn r0 = r9.zzmo()
                r12.writeNoException()
                if (r0 == 0) goto L_0x0223
                android.os.IBinder r6 = r0.asBinder()
            L_0x0223:
                r12.writeStrongBinder(r6)
                goto L_0x000a
            L_0x0228:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                com.google.android.gms.internal.zzgo r0 = r9.zzmp()
                r12.writeNoException()
                if (r0 == 0) goto L_0x023a
                android.os.IBinder r6 = r0.asBinder()
            L_0x023a:
                r12.writeStrongBinder(r6)
                goto L_0x000a
            L_0x023f:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.Bundle r1 = r9.zzmq()
                r12.writeNoException()
                if (r1 == 0) goto L_0x0255
                r12.writeInt(r8)
                r1.writeToParcel(r12, r8)
                goto L_0x000a
            L_0x0255:
                r12.writeInt(r0)
                goto L_0x000a
            L_0x025a:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.Bundle r1 = r9.getInterstitialAdapterInfo()
                r12.writeNoException()
                if (r1 == 0) goto L_0x0270
                r12.writeInt(r8)
                r1.writeToParcel(r12, r8)
                goto L_0x000a
            L_0x0270:
                r12.writeInt(r0)
                goto L_0x000a
            L_0x0275:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.Bundle r1 = r9.zzmr()
                r12.writeNoException()
                if (r1 == 0) goto L_0x028b
                r12.writeInt(r8)
                r1.writeToParcel(r12, r8)
                goto L_0x000a
            L_0x028b:
                r12.writeInt(r0)
                goto L_0x000a
            L_0x0290:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x02b3
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
            L_0x02a3:
                java.lang.String r1 = r11.readString()
                java.lang.String r2 = r11.readString()
                r9.zza(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x02b3:
                r0 = r6
                goto L_0x02a3
            L_0x02b5:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r0 = com.google.android.gms.dynamic.zzd.zza.zzfc(r0)
                r9.zzj(r0)
                r12.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgk.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void destroy();

    Bundle getInterstitialAdapterInfo();

    zzd getView();

    boolean isInitialized();

    void pause();

    void resume();

    void showInterstitial();

    void showVideo();

    void zza(AdRequestParcel adRequestParcel, String str, String str2);

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza2, String str2);

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzgl zzgl);

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl);

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl, NativeAdOptionsParcel nativeAdOptionsParcel, List list);

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzgl zzgl);

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzgl zzgl);

    void zzc(AdRequestParcel adRequestParcel, String str);

    void zzj(zzd zzd);

    zzgn zzmo();

    zzgo zzmp();

    Bundle zzmq();

    Bundle zzmr();
}
