package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter implements SafeParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zza();

    /* renamed from: a */
    final int f2828a;

    /* renamed from: b */
    ParcelFileDescriptor f2829b;

    /* renamed from: c */
    final int f2830c;

    /* renamed from: d */
    private Bitmap f2831d;

    /* renamed from: e */
    private boolean f2832e;

    /* renamed from: f */
    private File f2833f;

    BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.f2828a = i;
        this.f2829b = parcelFileDescriptor;
        this.f2830c = i2;
        this.f2831d = null;
        this.f2832e = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        this.f2828a = 1;
        this.f2829b = null;
        this.f2830c = 0;
        this.f2831d = bitmap;
        this.f2832e = true;
    }

    /* renamed from: a */
    private FileOutputStream m3847a() {
        if (this.f2833f == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.f2833f);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.f2829b = ParcelFileDescriptor.open(createTempFile, 268435456);
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
    private void m3848a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void release() {
        if (!this.f2832e) {
            try {
                this.f2829b.close();
            } catch (IOException e) {
                Log.w("BitmapTeleporter", "Could not close PFD", e);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f2829b == null) {
            Bitmap bitmap = this.f2831d;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(m3847a());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                m3848a(dataOutputStream);
            } catch (IOException e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                m3848a(dataOutputStream);
                throw th;
            }
        }
        zza.m3856a(this, parcel, i | 1);
        this.f2829b = null;
    }

    public void zzc(File file) {
        if (file == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.f2833f = file;
    }

    public Bitmap zzqa() {
        if (!this.f2832e) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f2829b));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                m3848a(dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.f2831d = createBitmap;
                this.f2832e = true;
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                m3848a(dataInputStream);
                throw th;
            }
        }
        return this.f2831d;
    }
}
