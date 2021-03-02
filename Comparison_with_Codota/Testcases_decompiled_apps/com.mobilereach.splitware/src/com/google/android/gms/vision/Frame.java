package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    /* access modifiers changed from: private */
    public Bitmap mBitmap;
    private Metadata zzbni;
    /* access modifiers changed from: private */
    public ByteBuffer zzbnj;

    public static class Builder {
        private Frame zzbnk = new Frame();

        public Frame build() {
            if (this.zzbnk.zzbnj != null || this.zzbnk.mBitmap != null) {
                return this.zzbnk;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap image) {
            int width = image.getWidth();
            int height = image.getHeight();
            Bitmap unused = this.zzbnk.mBitmap = image;
            Metadata metadata = this.zzbnk.getMetadata();
            int unused2 = metadata.zzoG = width;
            int unused3 = metadata.zzoH = height;
            return this;
        }

        public Builder setId(int id) {
            int unused = this.zzbnk.getMetadata().mId = id;
            return this;
        }

        public Builder setImageData(ByteBuffer data, int width, int height, int format) {
            if (data == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (data.capacity() < width * height) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else {
                switch (format) {
                    case 16:
                    case 17:
                    case 842094169:
                        ByteBuffer unused = this.zzbnk.zzbnj = data;
                        Metadata metadata = this.zzbnk.getMetadata();
                        int unused2 = metadata.zzoG = width;
                        int unused3 = metadata.zzoH = height;
                        return this;
                    default:
                        throw new IllegalArgumentException("Unsupported image format: " + format);
                }
            }
        }

        public Builder setRotation(int rotation) {
            int unused = this.zzbnk.getMetadata().zzDE = rotation;
            return this;
        }

        public Builder setTimestampMillis(long timestampMillis) {
            long unused = this.zzbnk.getMetadata().zzaJi = timestampMillis;
            return this;
        }
    }

    public static class Metadata {
        /* access modifiers changed from: private */
        public int mId;
        /* access modifiers changed from: private */
        public int zzDE;
        /* access modifiers changed from: private */
        public long zzaJi;
        /* access modifiers changed from: private */
        public int zzoG;
        /* access modifiers changed from: private */
        public int zzoH;

        public Metadata() {
        }

        public Metadata(Metadata metadata) {
            this.zzoG = metadata.getWidth();
            this.zzoH = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzaJi = metadata.getTimestampMillis();
            this.zzDE = metadata.getRotation();
        }

        public int getHeight() {
            return this.zzoH;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzDE;
        }

        public long getTimestampMillis() {
            return this.zzaJi;
        }

        public int getWidth() {
            return this.zzoG;
        }

        public void zzIf() {
            if (this.zzDE % 2 != 0) {
                int i = this.zzoG;
                this.zzoG = this.zzoH;
                this.zzoH = i;
            }
            this.zzDE = 0;
        }
    }

    private Frame() {
        this.zzbni = new Metadata();
        this.zzbnj = null;
        this.mBitmap = null;
    }

    private ByteBuffer zzIe() {
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int[] iArr = new int[(width * height)];
        this.mBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[(width * height)];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) ((int) ((((float) Color.red(iArr[i])) * 0.299f) + (((float) Color.green(iArr[i])) * 0.587f) + (((float) Color.blue(iArr[i])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        return this.mBitmap != null ? zzIe() : this.zzbnj;
    }

    public Metadata getMetadata() {
        return this.zzbni;
    }
}
