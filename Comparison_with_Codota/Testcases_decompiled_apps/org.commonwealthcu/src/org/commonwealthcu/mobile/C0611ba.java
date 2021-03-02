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

/* renamed from: org.commonwealthcu.mobile.ba */
final class C0611ba extends AsyncTask {

    /* renamed from: a */
    private File f792a;

    /* renamed from: b */
    private String f793b;

    /* renamed from: c */
    private URL f794c;

    /* renamed from: d */
    private boolean f795d;

    /* renamed from: e */
    private /* synthetic */ C0608ay f796e;

    private C0611ba(C0608ay ayVar) {
        this.f796e = ayVar;
        this.f795d = false;
    }

    /* synthetic */ C0611ba(C0608ay ayVar, byte b) {
        this(ayVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Long doInBackground(URL... urlArr) {
        try {
            this.f794c = urlArr[0];
            this.f792a = Environment.getExternalStorageDirectory();
            this.f793b = "temp_deposit.pdf";
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.f794c.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();
            System.out.println("Opening output file");
            File file = new File(this.f792a, this.f793b);
            System.out.println("File name is " + this.f793b);
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
                    this.f795d = true;
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
        if (this.f795d) {
            System.out.println("File downloaded");
            System.out.println("File is " + this.f793b + " and located in " + this.f792a.getPath());
            File file = new File(this.f792a, this.f793b);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(67108864);
            try {
                this.f796e.startActivity(Intent.createChooser(intent, "Open PDF"));
            } catch (ActivityNotFoundException e) {
                new AlertDialog.Builder(this.f796e.f787g).setTitle("PDF Viewer Not Found").setMessage("In order to view past deposits, you need a PDF Reader. One was not found on the device.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            }
        } else {
            System.out.println("Disengaging, error occurred.");
        }
    }
}
