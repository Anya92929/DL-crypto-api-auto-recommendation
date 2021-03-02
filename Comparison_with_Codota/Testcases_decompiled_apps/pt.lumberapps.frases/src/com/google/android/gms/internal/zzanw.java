package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class zzanw {
    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C1444bi(appendable);
    }

    public static void zzb(zzamv zzamv, zzaoo zzaoo) {
        zzaok.bgM.zza(zzaoo, zzamv);
    }

    public static zzamv zzh(zzaom zzaom) {
        boolean z = true;
        try {
            zzaom.mo7902b();
            z = false;
            return (zzamv) zzaok.bgM.zzb(zzaom);
        } catch (EOFException e) {
            if (z) {
                return zzamx.bei;
            }
            throw new zzane((Throwable) e);
        } catch (zzaop e2) {
            throw new zzane((Throwable) e2);
        } catch (IOException e3) {
            throw new zzamw((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new zzane((Throwable) e4);
        }
    }
}
