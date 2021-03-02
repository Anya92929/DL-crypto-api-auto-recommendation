package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class zzana {
    public zzamv zza(Reader reader) {
        try {
            zzaom zzaom = new zzaom(reader);
            zzamv zzh = zzh(zzaom);
            if (zzh.zzczj() || zzaom.mo7902b() == zzaon.END_DOCUMENT) {
                return zzh;
            }
            throw new zzane("Did not consume the entire document.");
        } catch (zzaop e) {
            throw new zzane((Throwable) e);
        } catch (IOException e2) {
            throw new zzamw((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new zzane((Throwable) e3);
        }
    }

    public zzamv zzh(zzaom zzaom) {
        boolean isLenient = zzaom.isLenient();
        zzaom.setLenient(true);
        try {
            zzamv zzh = zzanw.zzh(zzaom);
            zzaom.setLenient(isLenient);
            return zzh;
        } catch (StackOverflowError e) {
            String valueOf = String.valueOf(zzaom);
            throw new zzamz(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e);
        } catch (OutOfMemoryError e2) {
            String valueOf2 = String.valueOf(zzaom);
            throw new zzamz(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("Failed parsing JSON source: ").append(valueOf2).append(" to Json").toString(), e2);
        } catch (Throwable th) {
            zzaom.setLenient(isLenient);
            throw th;
        }
    }

    public zzamv zztp(String str) {
        return zza(new StringReader(str));
    }
}
