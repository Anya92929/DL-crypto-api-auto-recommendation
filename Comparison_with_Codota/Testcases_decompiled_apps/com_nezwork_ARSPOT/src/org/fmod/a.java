package org.fmod;

import android.media.AudioRecord;
import java.nio.ByteBuffer;

final class a implements Runnable {
    private final FMODAudioDevice a;
    private final ByteBuffer b;
    private final int c;
    private final int d;
    private final int e = 2;
    private volatile Thread f;
    private volatile boolean g;
    private AudioRecord h;
    private boolean i;

    a(FMODAudioDevice fMODAudioDevice, int i2, int i3) {
        this.a = fMODAudioDevice;
        this.c = i2;
        this.d = i3;
        this.b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i2, i3, 2));
    }

    private void d() {
        if (this.h != null) {
            if (this.h.getState() == 1) {
                this.h.stop();
            }
            this.h.release();
            this.h = null;
        }
        this.b.position(0);
        this.i = false;
    }

    public final int a() {
        return this.b.capacity();
    }

    public final void b() {
        if (this.f != null) {
            c();
        }
        this.g = true;
        this.f = new Thread(this);
        this.f.start();
    }

    public final void c() {
        while (this.f != null) {
            this.g = false;
            try {
                this.f.join();
                this.f = null;
            } catch (InterruptedException e2) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            r7 = 3
            r1 = 1
            r8 = 0
            r6 = r7
        L_0x0004:
            boolean r0 = r9.g
            if (r0 == 0) goto L_0x00a4
            org.fmod.FMODAudioDevice r0 = r9.a
            boolean r0 = r0.isInitialized()
            if (r0 != 0) goto L_0x001a
            r2 = 10
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x0004
        L_0x0016:
            r0 = move-exception
            r9.g = r8
            goto L_0x0004
        L_0x001a:
            boolean r0 = r9.i
            if (r0 != 0) goto L_0x00a2
            if (r6 <= 0) goto L_0x00a2
            r9.d()
            android.media.AudioRecord r0 = new android.media.AudioRecord
            int r2 = r9.c
            int r3 = r9.d
            r4 = 2
            java.nio.ByteBuffer r5 = r9.b
            int r5 = r5.capacity()
            r0.<init>(r1, r2, r3, r4, r5)
            r9.h = r0
            android.media.AudioRecord r0 = r9.h
            int r0 = r0.getState()
            if (r0 != r1) goto L_0x0077
            r0 = r1
        L_0x003e:
            r9.i = r0
            boolean r0 = r9.i
            if (r0 == 0) goto L_0x0079
            java.nio.ByteBuffer r0 = r9.b
            r0.position(r8)
            android.media.AudioRecord r0 = r9.h
            r0.startRecording()
            r0 = r7
        L_0x004f:
            boolean r2 = r9.i
            if (r2 == 0) goto L_0x00a8
            android.media.AudioRecord r2 = r9.h
            int r2 = r2.getRecordingState()
            if (r2 != r7) goto L_0x00a8
            android.media.AudioRecord r2 = r9.h
            java.nio.ByteBuffer r3 = r9.b
            java.nio.ByteBuffer r4 = r9.b
            int r4 = r4.capacity()
            int r2 = r2.read(r3, r4)
            org.fmod.FMODAudioDevice r3 = r9.a
            java.nio.ByteBuffer r4 = r9.b
            r3.fmodProcessMicData(r4, r2)
            java.nio.ByteBuffer r2 = r9.b
            r2.position(r8)
            r6 = r0
            goto L_0x0004
        L_0x0077:
            r0 = r8
            goto L_0x003e
        L_0x0079:
            java.lang.String r0 = "FMOD"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AudioRecord failed to initialize (status "
            java.lang.StringBuilder r2 = r2.append(r3)
            android.media.AudioRecord r3 = r9.h
            int r3 = r3.getState()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r0, r2)
            int r6 = r6 + -1
            r9.d()
        L_0x00a2:
            r0 = r6
            goto L_0x004f
        L_0x00a4:
            r9.d()
            return
        L_0x00a8:
            r6 = r0
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fmod.a.run():void");
    }
}
