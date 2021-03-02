package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: org.commonwealthcu.mobile.bf */
final class C0616bf extends AsyncTask {

    /* renamed from: a */
    private File f813a;

    /* renamed from: b */
    private String f814b;

    /* renamed from: c */
    private URL f815c;

    /* renamed from: d */
    private boolean f816d;

    /* renamed from: e */
    private /* synthetic */ C0612bb f817e;

    private C0616bf(C0612bb bbVar) {
        this.f817e = bbVar;
        this.f816d = false;
    }

    /* synthetic */ C0616bf(C0612bb bbVar, byte b) {
        this(bbVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Long doInBackground(URL... urlArr) {
        try {
            this.f815c = urlArr[0];
            this.f813a = Environment.getExternalStorageDirectory();
            this.f814b = "temp_deposit.pdf";
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.f815c.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();
            System.out.println("Opening output file");
            File file = new File(this.f813a, this.f814b);
            System.out.println("File name is " + this.f814b);
            System.out.println("Creating Filestream");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            System.out.println("FileStream Open");
            InputStream inputStream = httpURLConnection.getInputStream();
            System.out.println("InputStream open");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    this.f816d = true;
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        if (this.f816d) {
            System.out.println("File downloaded");
            System.out.println("File is " + this.f814b + " and located in " + this.f813a.getPath());
            File file = new File(this.f813a, this.f814b);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(67108864);
            Intent.createChooser(intent, "Open PDF");
            try {
                this.f817e.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                new AlertDialog.Builder(this.f817e.f803g).setTitle("PDF Viewer Not Found").setMessage("In order to view past deposits, you need a PDF Reader. One was not found on the device.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            }
        } else {
            System.out.println("Disengaging, error occurred.");
        }
    }
}
