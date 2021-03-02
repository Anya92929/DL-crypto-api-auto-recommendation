package p006nl.volkerinfradesign.checkandroid.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: nl.volkerinfradesign.checkandroid.util.UtilFiles */
public class UtilFiles {
    public static final float MAX_FILE_SIZEINBYTES = 5000000.0f;
    public static final float MAX_FULL_DIMENSION = 4069.0f;
    public static final float MAX_MEDIUM_DIMENSION = 2048.0f;
    public static final float MAX_THUMB_DIMENSION = 256.0f;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[SYNTHETIC, Splitter:B:11:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[SYNTHETIC, Splitter:B:16:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveBitmapToFile(android.graphics.Bitmap r4, java.io.File r5) {
        /*
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0016, all -> 0x0020 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0016, all -> 0x0020 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            r2 = 100
            r4.compress(r1, r2, r0)     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            r0.flush()     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0015:
            return
        L_0x0016:
            r0 = move-exception
            r0 = r1
        L_0x0018:
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x001e }
            goto L_0x0015
        L_0x001e:
            r0 = move-exception
            goto L_0x0015
        L_0x0020:
            r0 = move-exception
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0026:
            throw r0
        L_0x0027:
            r0 = move-exception
            goto L_0x0015
        L_0x0029:
            r1 = move-exception
            goto L_0x0026
        L_0x002b:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0021
        L_0x0030:
            r1 = move-exception
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.util.UtilFiles.saveBitmapToFile(android.graphics.Bitmap, java.io.File):void");
    }

    public static int getSampleSize(File file, float f, float f2) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int i = 0;
        BitmapFactory.decodeFile(file.getPath(), options);
        if (f > BitmapDescriptorFactory.HUE_RED) {
            if (((float) options.outWidth) / ((float) options.outHeight) >= 1.0f) {
                i = Math.round(((float) options.outWidth) / f);
            } else {
                i = Math.round(((float) options.outHeight) / f);
            }
        }
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            i = Math.max(i, (int) Math.floor((double) (((float) file.length()) / f2)));
        }
        return (int) Math.pow(2.0d, (double) (((int) (Math.log((double) (i - 1)) / Math.log(2.0d))) + 1));
    }

    public static void downSizeImage(File file, File file2, float f, float f2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = getSampleSize(file, f, f2);
        int i = 0;
        while (i < 5) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new File(file2.getPath().replace(file2.getName(), "")).mkdirs();
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                BitmapFactory.decodeFile(file.getPath(), options).compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                byteArrayOutputStream.writeTo(fileOutputStream);
                byteArrayOutputStream.flush();
                return;
            } catch (OutOfMemoryError e) {
                options.inSampleSize *= 2;
                i++;
            } finally {
                byteArrayOutputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static byte[] getDownSizedImage(byte[] bArr, float f, float f2) throws IOException {
        byte[] byteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        float f3 = ((float) options.outWidth) / ((float) options.outHeight);
        if (f > BitmapDescriptorFactory.HUE_RED) {
            if (f3 >= 1.0f) {
                options2.inSampleSize = Math.round(((float) options.outWidth) / f);
            } else {
                options2.inSampleSize = Math.round(((float) options.outHeight) / f);
            }
        }
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            options2.inSampleSize = Math.max(options2.inSampleSize, (int) Math.floor((double) (((float) bArr.length) / f2)));
        }
        options2.inSampleSize = Math.max(options2.inSampleSize, (int) Math.floor((double) (((float) bArr.length) / 5000000.0f)));
        while (true) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2).compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                break;
            } catch (OutOfMemoryError e) {
                options2.inSampleSize *= 2;
            } finally {
                byteArrayOutputStream.close();
            }
        }
        return byteArray;
    }
}
