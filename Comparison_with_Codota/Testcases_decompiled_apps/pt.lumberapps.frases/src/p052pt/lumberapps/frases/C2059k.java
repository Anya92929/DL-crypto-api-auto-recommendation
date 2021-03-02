package p052pt.lumberapps.frases;

import android.graphics.Bitmap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: pt.lumberapps.frases.k */
class C2059k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2057i f7753a;

    C2059k(C2057i iVar) {
        this.f7753a = iVar;
    }

    public void run() {
        File file = new File(this.f7753a.f7747a);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.f7753a.f7748b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            this.f7753a.f7747a = file.getAbsolutePath();
            this.f7753a.mo10212a(this.f7753a.f7747a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.f7753a.mo10217h();
    }
}
