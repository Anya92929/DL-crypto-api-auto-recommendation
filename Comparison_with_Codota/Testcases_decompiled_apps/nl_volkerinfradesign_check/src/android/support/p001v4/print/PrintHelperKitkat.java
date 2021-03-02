package android.support.p001v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: android.support.v4.print.PrintHelperKitkat */
class PrintHelperKitkat {

    /* renamed from: a */
    final Context f789a;

    /* renamed from: b */
    BitmapFactory.Options f790b = null;

    /* renamed from: c */
    int f791c = 2;

    /* renamed from: d */
    int f792d = 2;

    /* renamed from: e */
    int f793e = 1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Object f794f = new Object();

    /* renamed from: android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    PrintHelperKitkat(Context context) {
        this.f789a = context;
    }

    /* renamed from: a */
    public void mo1495a(int i) {
        this.f791c = i;
    }

    /* renamed from: a */
    public int mo1494a() {
        return this.f791c;
    }

    /* renamed from: b */
    public void mo1499b(int i) {
        this.f792d = i;
    }

    /* renamed from: c */
    public void mo1501c(int i) {
        this.f793e = i;
    }

    /* renamed from: b */
    public int mo1498b() {
        return this.f793e;
    }

    /* renamed from: c */
    public int mo1500c() {
        return this.f792d;
    }

    /* renamed from: a */
    public void mo1496a(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        if (bitmap != null) {
            final int i = this.f791c;
            PrintManager printManager = (PrintManager) this.f789a.getSystemService("print");
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            final String str2 = str;
            final Bitmap bitmap2 = bitmap;
            final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
            printManager.print(str, new PrintDocumentAdapter() {

                /* renamed from: f */
                private PrintAttributes f800f;

                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    boolean z = true;
                    this.f800f = printAttributes2;
                    PrintDocumentInfo build = new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build();
                    if (printAttributes2.equals(printAttributes)) {
                        z = false;
                    }
                    layoutResultCallback.onLayoutFinished(build, z);
                }

                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.f789a, this.f800f);
                    Bitmap a = PrintHelperKitkat.this.m909a(bitmap2, this.f800f.getColorMode());
                    try {
                        PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                        startPage.getCanvas().drawBitmap(a, PrintHelperKitkat.this.m914a(a.getWidth(), a.getHeight(), new RectF(startPage.getInfo().getContentRect()), i), (Paint) null);
                        printedPdfDocument.finishPage(startPage);
                        printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                        writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } catch (IOException e) {
                        Log.e("PrintHelperKitkat", "Error writing printed content", e);
                        writeResultCallback.onWriteFailed((CharSequence) null);
                    } catch (Throwable th) {
                        if (printedPdfDocument != null) {
                            printedPdfDocument.close();
                        }
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (a != bitmap2) {
                            a.recycle();
                        }
                        throw th;
                    }
                    if (printedPdfDocument != null) {
                        printedPdfDocument.close();
                    }
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (a != bitmap2) {
                        a.recycle();
                    }
                }

                public void onFinish() {
                    if (onPrintFinishCallback2 != null) {
                        onPrintFinishCallback2.onFinish();
                    }
                }
            }, new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.f792d).build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Matrix m914a(int i, int i2, RectF rectF, int i3) {
        float min;
        Matrix matrix = new Matrix();
        float width = rectF.width() / ((float) i);
        if (i3 == 2) {
            min = Math.max(width, rectF.height() / ((float) i2));
        } else {
            min = Math.min(width, rectF.height() / ((float) i2));
        }
        matrix.postScale(min, min);
        matrix.postTranslate((rectF.width() - (((float) i) * min)) / 2.0f, (rectF.height() - (min * ((float) i2))) / 2.0f);
        return matrix;
    }

    /* renamed from: a */
    public void mo1497a(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        final int i = this.f791c;
        final String str2 = str;
        final Uri uri2 = uri;
        final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
        C02372 r0 = new PrintDocumentAdapter() {

            /* renamed from: a */
            AsyncTask<Uri, Boolean, Bitmap> f801a;

            /* renamed from: b */
            Bitmap f802b = null;

            /* renamed from: h */
            private PrintAttributes f808h;

            public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                boolean z = true;
                this.f808h = printAttributes2;
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                } else if (this.f802b != null) {
                    PrintDocumentInfo build = new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build();
                    if (printAttributes2.equals(printAttributes)) {
                        z = false;
                    }
                    layoutResultCallback.onLayoutFinished(build, z);
                } else {
                    final CancellationSignal cancellationSignal2 = cancellationSignal;
                    final PrintAttributes printAttributes3 = printAttributes2;
                    final PrintAttributes printAttributes4 = printAttributes;
                    final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                    this.f801a = new AsyncTask<Uri, Boolean, Bitmap>() {
                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            cancellationSignal2.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                                public void onCancel() {
                                    C02372.this.m925a();
                                    C02381.this.cancel(false);
                                }
                            });
                        }

                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public Bitmap doInBackground(Uri... uriArr) {
                            try {
                                return PrintHelperKitkat.this.m910a(uri2, 3500);
                            } catch (FileNotFoundException e) {
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onPostExecute(Bitmap bitmap) {
                            boolean z = true;
                            super.onPostExecute(bitmap);
                            C02372.this.f802b = bitmap;
                            if (bitmap != null) {
                                PrintDocumentInfo build = new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build();
                                if (printAttributes3.equals(printAttributes4)) {
                                    z = false;
                                }
                                layoutResultCallback2.onLayoutFinished(build, z);
                            } else {
                                layoutResultCallback2.onLayoutFailed((CharSequence) null);
                            }
                            C02372.this.f801a = null;
                        }

                        /* access modifiers changed from: protected */
                        /* renamed from: b */
                        public void onCancelled(Bitmap bitmap) {
                            layoutResultCallback2.onLayoutCancelled();
                            C02372.this.f801a = null;
                        }
                    }.execute(new Uri[0]);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m925a() {
                synchronized (PrintHelperKitkat.this.f794f) {
                    if (PrintHelperKitkat.this.f790b != null) {
                        PrintHelperKitkat.this.f790b.requestCancelDecode();
                        PrintHelperKitkat.this.f790b = null;
                    }
                }
            }

            public void onFinish() {
                super.onFinish();
                m925a();
                if (this.f801a != null) {
                    this.f801a.cancel(true);
                }
                if (onPrintFinishCallback2 != null) {
                    onPrintFinishCallback2.onFinish();
                }
                if (this.f802b != null) {
                    this.f802b.recycle();
                    this.f802b = null;
                }
            }

            public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.f789a, this.f808h);
                Bitmap a = PrintHelperKitkat.this.m909a(this.f802b, this.f808h.getColorMode());
                try {
                    PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                    startPage.getCanvas().drawBitmap(a, PrintHelperKitkat.this.m914a(this.f802b.getWidth(), this.f802b.getHeight(), new RectF(startPage.getInfo().getContentRect()), i), (Paint) null);
                    printedPdfDocument.finishPage(startPage);
                    printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } catch (IOException e) {
                    Log.e("PrintHelperKitkat", "Error writing printed content", e);
                    writeResultCallback.onWriteFailed((CharSequence) null);
                } catch (Throwable th) {
                    if (printedPdfDocument != null) {
                        printedPdfDocument.close();
                    }
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (a != this.f802b) {
                        a.recycle();
                    }
                    throw th;
                }
                if (printedPdfDocument != null) {
                    printedPdfDocument.close();
                }
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e3) {
                    }
                }
                if (a != this.f802b) {
                    a.recycle();
                }
            }
        };
        PrintManager printManager = (PrintManager) this.f789a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f792d);
        if (this.f793e == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.f793e == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, r0, builder.build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m910a(Uri uri, int i) throws FileNotFoundException {
        BitmapFactory.Options options;
        int i2 = 1;
        Bitmap bitmap = null;
        if (i <= 0 || uri == null || this.f789a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        m911a(uri, options2);
        int i3 = options2.outWidth;
        int i4 = options2.outHeight;
        if (i3 > 0 && i4 > 0) {
            int max = Math.max(i3, i4);
            while (max > i) {
                max >>>= 1;
                i2 <<= 1;
            }
            if (i2 > 0 && Math.min(i3, i4) / i2 > 0) {
                synchronized (this.f794f) {
                    this.f790b = new BitmapFactory.Options();
                    this.f790b.inMutable = true;
                    this.f790b.inSampleSize = i2;
                    options = this.f790b;
                }
                try {
                    bitmap = m911a(uri, options);
                    synchronized (this.f794f) {
                        this.f790b = null;
                    }
                } catch (Throwable th) {
                    synchronized (this.f794f) {
                        this.f790b = null;
                        throw th;
                    }
                }
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private Bitmap m911a(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        InputStream inputStream = null;
        if (uri == null || this.f789a == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        try {
            inputStream = this.f789a.getContentResolver().openInputStream(uri);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
            if (inputStream != null) {
                try {
                } catch (IOException e) {
                    Log.w("PrintHelperKitkat", "close fail ", e);
                }
            }
            return decodeStream;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.w("PrintHelperKitkat", "close fail ", e2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m909a(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(BitmapDescriptorFactory.HUE_RED);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }
}
