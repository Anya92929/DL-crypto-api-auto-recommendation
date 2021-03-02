package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzw;

public interface zze extends IInterface {

    public abstract class zza extends Binder implements zze {
        public static zze zzkv(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C1949b(iBinder) : (zze) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.signin.internal.SignInRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.signin.internal.RecordConsentRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: com.google.android.gms.common.internal.ResolveAccountRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: com.google.android.gms.signin.internal.CheckServerAuthResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.google.android.gms.common.internal.AuthAccountRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v39 */
        /* JADX WARNING: type inference failed for: r0v40 */
        /* JADX WARNING: type inference failed for: r0v41 */
        /* JADX WARNING: type inference failed for: r0v42 */
        /* JADX WARNING: type inference failed for: r0v43 */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) {
            /*
                r5 = this;
                r2 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x004d;
                    case 5: goto L_0x0062;
                    case 7: goto L_0x0084;
                    case 8: goto L_0x0095;
                    case 9: goto L_0x00bc;
                    case 10: goto L_0x00dc;
                    case 11: goto L_0x00ff;
                    case 12: goto L_0x0114;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r8.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator r0 = com.google.android.gms.common.internal.AuthAccountRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.common.internal.AuthAccountRequest r0 = (com.google.android.gms.common.internal.AuthAccountRequest) r0
            L_0x0024:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r2 = com.google.android.gms.signin.internal.zzd.zza.zzku(r2)
                r5.zza((com.google.android.gms.common.internal.AuthAccountRequest) r0, (com.google.android.gms.signin.internal.zzd) r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x0033:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0046
                android.os.Parcelable$Creator r0 = com.google.android.gms.signin.internal.CheckServerAuthResult.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.signin.internal.CheckServerAuthResult r0 = (com.google.android.gms.signin.internal.CheckServerAuthResult) r0
            L_0x0046:
                r5.zza(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x004d:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0060
                r0 = r1
            L_0x0059:
                r5.zzcf(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x0060:
                r0 = r2
                goto L_0x0059
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator r0 = com.google.android.gms.common.internal.ResolveAccountRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.common.internal.ResolveAccountRequest r0 = (com.google.android.gms.common.internal.ResolveAccountRequest) r0
            L_0x0075:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzw r2 = com.google.android.gms.common.internal.zzw.zza.zzdv(r2)
                r5.zza((com.google.android.gms.common.internal.ResolveAccountRequest) r0, (com.google.android.gms.common.internal.zzw) r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x0084:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                r5.zzza(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x0095:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x00ac
                android.os.Parcelable$Creator r0 = android.accounts.Account.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.accounts.Account r0 = (android.accounts.Account) r0
            L_0x00ac:
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r3 = com.google.android.gms.signin.internal.zzd.zza.zzku(r3)
                r5.zza((int) r2, (android.accounts.Account) r0, (com.google.android.gms.signin.internal.zzd) r3)
                r8.writeNoException()
                goto L_0x000a
            L_0x00bc:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzq r0 = com.google.android.gms.common.internal.zzq.zza.zzdp(r0)
                int r3 = r7.readInt()
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x00d4
                r2 = r1
            L_0x00d4:
                r5.zza((com.google.android.gms.common.internal.zzq) r0, (int) r3, (boolean) r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x00dc:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00ef
                android.os.Parcelable$Creator r0 = com.google.android.gms.signin.internal.RecordConsentRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.signin.internal.RecordConsentRequest r0 = (com.google.android.gms.signin.internal.RecordConsentRequest) r0
            L_0x00ef:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r2 = com.google.android.gms.signin.internal.zzd.zza.zzku(r2)
                r5.zza((com.google.android.gms.signin.internal.RecordConsentRequest) r0, (com.google.android.gms.signin.internal.zzd) r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x00ff:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r0 = com.google.android.gms.signin.internal.zzd.zza.zzku(r0)
                r5.zzb(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x0114:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0127
                android.os.Parcelable$Creator r0 = com.google.android.gms.signin.internal.SignInRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.signin.internal.SignInRequest r0 = (com.google.android.gms.signin.internal.SignInRequest) r0
            L_0x0127:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r2 = com.google.android.gms.signin.internal.zzd.zza.zzku(r2)
                r5.zza((com.google.android.gms.signin.internal.SignInRequest) r0, (com.google.android.gms.signin.internal.zzd) r2)
                r8.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.zze.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, Account account, zzd zzd);

    void zza(AuthAccountRequest authAccountRequest, zzd zzd);

    void zza(ResolveAccountRequest resolveAccountRequest, zzw zzw);

    void zza(zzq zzq, int i, boolean z);

    void zza(CheckServerAuthResult checkServerAuthResult);

    void zza(RecordConsentRequest recordConsentRequest, zzd zzd);

    void zza(SignInRequest signInRequest, zzd zzd);

    void zzb(zzd zzd);

    void zzcf(boolean z);

    void zzza(int i);
}
