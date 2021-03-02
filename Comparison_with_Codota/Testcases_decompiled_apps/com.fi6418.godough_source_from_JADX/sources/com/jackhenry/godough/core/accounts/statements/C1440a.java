package com.jackhenry.godough.core.accounts.statements;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@TargetApi(19)
/* renamed from: com.jackhenry.godough.core.accounts.statements.a */
public class C1440a extends PrintDocumentAdapter {

    /* renamed from: a */
    private final String f5891a;

    /* renamed from: b */
    private int f5892b = 0;

    public C1440a(int i, String str) {
        this.f5892b = i;
        this.f5891a = str;
    }

    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        if (cancellationSignal.isCanceled()) {
            layoutResultCallback.onLayoutCancelled();
        } else if (this.f5892b != 0) {
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder("print_output.pdf").setContentType(0).setPageCount(this.f5892b).build(), true);
        } else {
            layoutResultCallback.onLayoutFailed("Page count calculation failed.");
        }
    }

    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(StatementDetail.TEMP_STATEMENT_DIRECTORY, this.f5891a));
            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
