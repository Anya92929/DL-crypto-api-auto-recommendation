package android.support.p000v4.print;

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
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: a */
    final Context f1021a;

    /* renamed from: b */
    BitmapFactory.Options f1022b = null;

    /* renamed from: c */
    int f1023c = 2;

    /* renamed from: d */
    int f1024d = 2;

    /* renamed from: e */
    int f1025e = 1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Object f1026f = new Object();

    /* renamed from: android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    PrintHelperKitkat(Context context) {
        this.f1021a = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m751a(Bitmap bitmap, int i) {
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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m752a(Uri uri, int i) {
        BitmapFactory.Options options;
        int i2 = 1;
        Bitmap bitmap = null;
        if (i <= 0 || uri == null || this.f1021a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        m753a(uri, options2);
        int i3 = options2.outWidth;
        int i4 = options2.outHeight;
        if (i3 > 0 && i4 > 0) {
            int max = Math.max(i3, i4);
            while (max > i) {
                max >>>= 1;
                i2 <<= 1;
            }
            if (i2 > 0 && Math.min(i3, i4) / i2 > 0) {
                synchronized (this.f1026f) {
                    this.f1022b = new BitmapFactory.Options();
                    this.f1022b.inMutable = true;
                    this.f1022b.inSampleSize = i2;
                    options = this.f1022b;
                }
                try {
                    bitmap = m753a(uri, options);
                    synchronized (this.f1026f) {
                        this.f1022b = null;
                    }
                } catch (Throwable th) {
                    synchronized (this.f1026f) {
                        this.f1022b = null;
                        throw th;
                    }
                }
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private Bitmap m753a(Uri uri, BitmapFactory.Options options) {
        InputStream inputStream = null;
        if (uri == null || this.f1021a == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        try {
            inputStream = this.f1021a.getContentResolver().openInputStream(uri);
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
    public Matrix m756a(int i, int i2, RectF rectF, int i3) {
        Matrix matrix = new Matrix();
        float width = rectF.width() / ((float) i);
        float max = i3 == 2 ? Math.max(width, rectF.height() / ((float) i2)) : Math.min(width, rectF.height() / ((float) i2));
        matrix.postScale(max, max);
        matrix.postTranslate((rectF.width() - (((float) i) * max)) / 2.0f, (rectF.height() - (max * ((float) i2))) / 2.0f);
        return matrix;
    }

    public int getColorMode() {
        return this.f1024d;
    }

    public int getOrientation() {
        return this.f1025e;
    }

    public int getScaleMode() {
        return this.f1023c;
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        if (bitmap != null) {
            final int i = this.f1023c;
            PrintManager printManager = (PrintManager) this.f1021a.getSystemService("print");
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            final String str2 = str;
            final Bitmap bitmap2 = bitmap;
            final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
            printManager.print(str, new PrintDocumentAdapter() {

                /* renamed from: f */
                private PrintAttributes f1032f;

                public void onFinish() {
                    if (onPrintFinishCallback2 != null) {
                        onPrintFinishCallback2.onFinish();
                    }
                }

                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    boolean z = true;
                    this.f1032f = printAttributes2;
                    PrintDocumentInfo build = new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build();
                    if (printAttributes2.equals(printAttributes)) {
                        z = false;
                    }
                    layoutResultCallback.onLayoutFinished(build, z);
                }

                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.f1021a, this.f1032f);
                    Bitmap a = PrintHelperKitkat.this.m751a(bitmap2, this.f1032f.getColorMode());
                    try {
                        PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                        startPage.getCanvas().drawBitmap(a, PrintHelperKitkat.this.m756a(a.getWidth(), a.getHeight(), new RectF(startPage.getInfo().getContentRect()), i), (Paint) null);
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
            }, new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.f1024d).build());
        }
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        final int i = this.f1023c;
        final String str2 = str;
        final Uri uri2 = uri;
        final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
        C01552 r0 = new PrintDocumentAdapter() {

            /* renamed from: a */
            AsyncTask<Uri, Boolean, Bitmap> f1033a;

            /* renamed from: b */
            Bitmap f1034b = null;

            /* renamed from: h */
            private PrintAttributes f1040h;

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m759a() {
                synchronized (PrintHelperKitkat.this.f1026f) {
                    if (PrintHelperKitkat.this.f1022b != null) {
                        PrintHelperKitkat.this.f1022b.requestCancelDecode();
                        PrintHelperKitkat.this.f1022b = null;
                    }
                }
            }

            public void onFinish() {
                super.onFinish();
                m759a();
                if (this.f1033a != null) {
                    this.f1033a.cancel(true);
                }
                if (onPrintFinishCallback2 != null) {
                    onPrintFinishCallback2.onFinish();
                }
                if (this.f1034b != null) {
                    this.f1034b.recycle();
                    this.f1034b = null;
                }
            }

            public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                boolean z = true;
                this.f1040h = printAttributes2;
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                } else if (this.f1034b != null) {
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
                    this.f1033a = new AsyncTask<Uri, Boolean, Bitmap>() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public Bitmap doInBackground(Uri... uriArr) {
                            try {
                                return PrintHelperKitkat.this.m752a(uri2, 3500);
                            } catch (FileNotFoundException e) {
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onPostExecute(Bitmap bitmap) {
                            boolean z = true;
                            super.onPostExecute(bitmap);
                            C01552.this.f1034b = bitmap;
                            if (bitmap != null) {
                                PrintDocumentInfo build = new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build();
                                if (printAttributes3.equals(printAttributes4)) {
                                    z = false;
                                }
                                layoutResultCallback2.onLayoutFinished(build, z);
                            } else {
                                layoutResultCallback2.onLayoutFailed((CharSequence) null);
                            }
                            C01552.this.f1033a = null;
                        }

                        /* access modifiers changed from: protected */
                        /* renamed from: b */
                        public void onCancelled(Bitmap bitmap) {
                            layoutResultCallback2.onLayoutCancelled();
                            C01552.this.f1033a = null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            cancellationSignal2.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                                public void onCancel() {
                                    C01552.this.m759a();
                                    C01561.this.cancel(false);
                                }
                            });
                        }
                    }.execute(new Uri[0]);
                }
            }

            public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.f1021a, this.f1040h);
                Bitmap a = PrintHelperKitkat.this.m751a(this.f1034b, this.f1040h.getColorMode());
                try {
                    PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                    startPage.getCanvas().drawBitmap(a, PrintHelperKitkat.this.m756a(this.f1034b.getWidth(), this.f1034b.getHeight(), new RectF(startPage.getInfo().getContentRect()), i), (Paint) null);
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
                    if (a != this.f1034b) {
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
                if (a != this.f1034b) {
                    a.recycle();
                }
            }
        };
        PrintManager printManager = (PrintManager) this.f1021a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f1024d);
        if (this.f1025e == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.f1025e == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, r0, builder.build());
    }

    public void setColorMode(int i) {
        this.f1024d = i;
    }

    public void setOrientation(int i) {
        this.f1025e = i;
    }

    public void setScaleMode(int i) {
        this.f1023c = i;
    }
}
