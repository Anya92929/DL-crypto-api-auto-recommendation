package com.tapcrowd.app.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;
import com.tapcrowd.Superminds4060.C0846R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class PdfUtil {
    /* access modifiers changed from: private */
    public File cacheDir;
    /* access modifiers changed from: private */
    public Context context;
    PdfLoadFinishedListener listener;

    public interface PdfLoadFinishedListener {
        void onFinished();
    }

    public PdfUtil(Context context2, PdfLoadFinishedListener pdfLoadFinishedListener) {
        this.context = context2;
        this.listener = pdfLoadFinishedListener;
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.cacheDir = new File(Environment.getExternalStorageDirectory(), "Tapcrowd");
        } else {
            this.cacheDir = context2.getCacheDir();
        }
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
        }
    }

    public void showPdf(String pdf) {
        String filename = pdf.substring(pdf.lastIndexOf(47) + 1);
        if (new File(this.cacheDir, filename).exists()) {
            startPdfIntent(filename);
            return;
        }
        new DownloadPdfTask(this, (DownloadPdfTask) null).execute(new String[]{pdf});
    }

    /* access modifiers changed from: private */
    public void startPdfIntent(String pdf) {
        if (pdf == null) {
            Toast.makeText(this.context, "Failed to download pdf.", 0).show();
            return;
        }
        File file = new File(this.cacheDir, pdf);
        if (file.exists()) {
            Intent i = new Intent("android.intent.action.VIEW");
            i.setType("application/pdf");
            i.setData(Uri.fromFile(file));
            if (Actions.isIntentAvailable(this.context, i)) {
                this.context.startActivity(i);
                if (this.listener != null) {
                    this.listener.onFinished();
                    return;
                }
                return;
            }
            startDownloadIntent();
        }
    }

    private class DownloadPdfTask extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;

        private DownloadPdfTask() {
        }

        /* synthetic */ DownloadPdfTask(PdfUtil pdfUtil, DownloadPdfTask downloadPdfTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = new ProgressDialog(PdfUtil.this.context);
            this.dialog.setMessage(PdfUtil.this.context.getString(C0846R.string.loading));
            this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    DownloadPdfTask.this.cancel(true);
                }
            });
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            String url = params[0];
            String filename = url.substring(url.lastIndexOf(47) + 1);
            if (!url.startsWith("http")) {
                url = String.valueOf(PdfUtil.this.context.getString(C0846R.string.baseimgurl)) + url;
            }
            try {
                InputStream streamInput = new URL(url).openConnection().getInputStream();
                BufferedInputStream bufferedStreamInput = new BufferedInputStream(streamInput);
                FileOutputStream outputStream = new FileOutputStream(new File(PdfUtil.this.cacheDir, filename));
                byte[] dataBuffer = new byte[4096];
                while (true) {
                    int nRead = bufferedStreamInput.read(dataBuffer);
                    if (nRead <= 0) {
                        streamInput.close();
                        outputStream.close();
                        return filename;
                    }
                    outputStream.write(dataBuffer, 0, nRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
                File file = new File(PdfUtil.this.cacheDir, filename);
                if (file.exists()) {
                    file.delete();
                }
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            PdfUtil.this.startPdfIntent(result);
            super.onPostExecute(result);
        }
    }

    private void startDownloadIntent() {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(App.act);
        alertbox.setMessage(C0846R.string.no_support);
        alertbox.setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                try {
                    PdfUtil.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.adobe.reader")));
                } catch (ActivityNotFoundException e) {
                    PdfUtil.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.adobe.reader")));
                }
                if (PdfUtil.this.listener != null) {
                    PdfUtil.this.listener.onFinished();
                }
            }
        });
        alertbox.setNegativeButton(C0846R.string.f2002no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (PdfUtil.this.listener != null) {
                    PdfUtil.this.listener.onFinished();
                }
            }
        });
        alertbox.show();
    }
}
