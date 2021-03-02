package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFile;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.common.data.a */
public class C0294a implements SafeParcelable {
    public static final Parcelable.Creator<C0294a> CREATOR = new C0295b();

    /* renamed from: BR */
    final int f685BR;

    /* renamed from: FD */
    final int f686FD;

    /* renamed from: JK */
    ParcelFileDescriptor f687JK;

    /* renamed from: JL */
    private Bitmap f688JL;

    /* renamed from: JM */
    private boolean f689JM;

    /* renamed from: JN */
    private File f690JN;

    C0294a(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.f685BR = i;
        this.f687JK = parcelFileDescriptor;
        this.f686FD = i2;
        this.f688JL = null;
        this.f689JM = false;
    }

    public C0294a(Bitmap bitmap) {
        this.f685BR = 1;
        this.f687JK = null;
        this.f686FD = 0;
        this.f688JL = bitmap;
        this.f689JM = true;
    }

    /* renamed from: a */
    private void m613a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    /* renamed from: gy */
    private FileOutputStream m614gy() {
        if (this.f690JN == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.f690JN);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.f687JK = ParcelFileDescriptor.open(createTempFile, DriveFile.MODE_READ_ONLY);
                createTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (IOException e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    /* renamed from: a */
    public void mo4325a(File file) {
        if (file == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.f690JN = file;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: gx */
    public Bitmap mo4327gx() {
        if (!this.f689JM) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f687JK));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                m613a((Closeable) dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.f688JL = createBitmap;
                this.f689JM = true;
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                m613a((Closeable) dataInputStream);
                throw th;
            }
        }
        return this.f688JL;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (this.f687JK == null) {
            Bitmap bitmap = this.f688JL;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(m614gy());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                m613a((Closeable) dataOutputStream);
            } catch (IOException e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                m613a((Closeable) dataOutputStream);
                throw th;
            }
        }
        C0295b.m617a(this, dest, flags);
    }
}
