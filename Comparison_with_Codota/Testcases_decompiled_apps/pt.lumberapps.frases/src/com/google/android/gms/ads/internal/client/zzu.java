package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhs;

public interface zzu extends IInterface {

    public abstract class zza extends Binder implements zzu {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static zzu zzn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzu)) ? new C1252y(iBinder) : (zzu) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.ads.internal.client.VideoOptionsParcel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: com.google.android.gms.ads.internal.client.AdRequestParcel} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v33, types: [com.google.android.gms.ads.internal.client.AdSizeParcel] */
        /* JADX WARNING: type inference failed for: r0v61, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v64 */
        /* JADX WARNING: type inference failed for: r0v65 */
        /* JADX WARNING: type inference failed for: r0v66 */
        /* JADX WARNING: type inference failed for: r0v67 */
        /* JADX WARNING: type inference failed for: r0v68 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) {
            /*
                r4 = this;
                r0 = 0
                r2 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0048;
                    case 5: goto L_0x0069;
                    case 6: goto L_0x0075;
                    case 7: goto L_0x0081;
                    case 8: goto L_0x0096;
                    case 9: goto L_0x00ab;
                    case 10: goto L_0x00b8;
                    case 11: goto L_0x00c5;
                    case 12: goto L_0x00d2;
                    case 13: goto L_0x00ed;
                    case 14: goto L_0x0108;
                    case 15: goto L_0x011d;
                    case 18: goto L_0x0136;
                    case 19: goto L_0x0147;
                    case 20: goto L_0x015c;
                    case 21: goto L_0x0171;
                    case 22: goto L_0x0186;
                    case 23: goto L_0x019a;
                    case 24: goto L_0x01ae;
                    case 25: goto L_0x01c3;
                    case 26: goto L_0x01d4;
                    case 29: goto L_0x01eb;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r5, r6, r7, r8)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r7.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                com.google.android.gms.dynamic.zzd r2 = r4.zzdm()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                goto L_0x000a
            L_0x0027:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.destroy()
                r7.writeNoException()
                goto L_0x000a
            L_0x0033:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                boolean r0 = r4.isReady()
                r7.writeNoException()
                if (r0 == 0) goto L_0x0046
                r0 = r1
            L_0x0042:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0046:
                r0 = r2
                goto L_0x0042
            L_0x0048:
                java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r3)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x005b
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = (com.google.android.gms.ads.internal.client.AdRequestParcel) r0
            L_0x005b:
                boolean r0 = r4.zzb(r0)
                r7.writeNoException()
                if (r0 == 0) goto L_0x0065
                r2 = r1
            L_0x0065:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x0069:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.pause()
                r7.writeNoException()
                goto L_0x000a
            L_0x0075:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.resume()
                r7.writeNoException()
                goto L_0x000a
            L_0x0081:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzq r0 = com.google.android.gms.ads.internal.client.zzq.zza.zzj(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzq) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0096:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzw r0 = com.google.android.gms.ads.internal.client.zzw.zza.zzp(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzw) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x00ab:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.showInterstitial()
                r7.writeNoException()
                goto L_0x000a
            L_0x00b8:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.stopLoading()
                r7.writeNoException()
                goto L_0x000a
            L_0x00c5:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.zzdp()
                r7.writeNoException()
                goto L_0x000a
            L_0x00d2:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r4.zzdn()
                r7.writeNoException()
                if (r0 == 0) goto L_0x00e8
                r7.writeInt(r1)
                r0.writeToParcel(r7, r1)
                goto L_0x000a
            L_0x00e8:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x00ed:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0100
                com.google.android.gms.ads.internal.client.zzi r0 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.client.AdSizeParcel r0 = (com.google.android.gms.ads.internal.client.AdSizeParcel) r0
            L_0x0100:
                r4.zza((com.google.android.gms.ads.internal.client.AdSizeParcel) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0108:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzho r0 = com.google.android.gms.internal.zzho.zza.zzau(r0)
                r4.zza((com.google.android.gms.internal.zzho) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x011d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzhs r0 = com.google.android.gms.internal.zzhs.zza.zzay(r0)
                java.lang.String r2 = r6.readString()
                r4.zza(r0, r2)
                r7.writeNoException()
                goto L_0x000a
            L_0x0136:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                java.lang.String r0 = r4.getMediationAdapterClassName()
                r7.writeNoException()
                r7.writeString(r0)
                goto L_0x000a
            L_0x0147:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzdo r0 = com.google.android.gms.internal.zzdo.zza.zzx(r0)
                r4.zza((com.google.android.gms.internal.zzdo) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x015c:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzp r0 = com.google.android.gms.ads.internal.client.zzp.zza.zzi(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzp) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0171:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzy r0 = com.google.android.gms.ads.internal.client.zzy.zza.zzq(r0)
                r4.zza((com.google.android.gms.ads.internal.client.zzy) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0186:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0192
                r2 = r1
            L_0x0192:
                r4.setManualImpressionsEnabled(r2)
                r7.writeNoException()
                goto L_0x000a
            L_0x019a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                boolean r0 = r4.isLoading()
                r7.writeNoException()
                if (r0 == 0) goto L_0x01a9
                r2 = r1
            L_0x01a9:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x01ae:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.reward.client.zzd r0 = com.google.android.gms.ads.internal.reward.client.zzd.zza.zzbh(r0)
                r4.zza((com.google.android.gms.ads.internal.reward.client.zzd) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x01c3:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.setUserId(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x01d4:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                com.google.android.gms.ads.internal.client.zzab r2 = r4.zzdq()
                r7.writeNoException()
                if (r2 == 0) goto L_0x01e6
                android.os.IBinder r0 = r2.asBinder()
            L_0x01e6:
                r7.writeStrongBinder(r0)
                goto L_0x000a
            L_0x01eb:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x01fe
                com.google.android.gms.ads.internal.client.zzaq r0 = com.google.android.gms.ads.internal.client.VideoOptionsParcel.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.ads.internal.client.VideoOptionsParcel r0 = (com.google.android.gms.ads.internal.client.VideoOptionsParcel) r0
            L_0x01fe:
                r4.zza((com.google.android.gms.ads.internal.client.VideoOptionsParcel) r0)
                r7.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzu.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void destroy();

    String getMediationAdapterClassName();

    boolean isLoading();

    boolean isReady();

    void pause();

    void resume();

    void setManualImpressionsEnabled(boolean z);

    void setUserId(String str);

    void showInterstitial();

    void stopLoading();

    void zza(AdSizeParcel adSizeParcel);

    void zza(VideoOptionsParcel videoOptionsParcel);

    void zza(zzp zzp);

    void zza(zzq zzq);

    void zza(zzw zzw);

    void zza(zzy zzy);

    void zza(zzd zzd);

    void zza(zzdo zzdo);

    void zza(zzho zzho);

    void zza(zzhs zzhs, String str);

    boolean zzb(AdRequestParcel adRequestParcel);

    com.google.android.gms.dynamic.zzd zzdm();

    AdSizeParcel zzdn();

    void zzdp();

    zzab zzdq();
}
