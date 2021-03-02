package com.jackhenry.godough.core.accounts.statements;

import android.content.Context;
import android.util.Base64;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetailHeader;
import com.jackhenry.godough.core.login.C1656ba;
import com.jackhenry.godough.p027b.C1389d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/* renamed from: com.jackhenry.godough.core.accounts.statements.d */
public class C1443d {

    /* renamed from: a */
    StatementDetail f5893a;

    /* renamed from: b */
    StatementDetailHeader f5894b;

    /* renamed from: c */
    private final Context f5895c;

    public C1443d(StatementDetail statementDetail, Context context, StatementDetailHeader statementDetailHeader) {
        this.f5893a = statementDetail;
        this.f5895c = context;
        this.f5894b = statementDetailHeader;
    }

    /* renamed from: a */
    public static String m5877a(long j) {
        if (j <= 0) {
            return "0";
        }
        String[] strArr = {"B", "kB", "MB", "GB", "TB"};
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)) + " " + strArr[log10];
    }

    /* renamed from: a */
    public static void m5878a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m5878a(file2);
                } else {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public static boolean m5879a() {
        File file = StatementDetail.TEMP_STATEMENT_DIRECTORY;
        if (!file.exists()) {
            return true;
        }
        m5878a(file);
        return true;
    }

    /* renamed from: b */
    public boolean mo9600b() {
        m5879a();
        if (StatementDetail.TEMP_STATEMENT_DIRECTORY.exists() || StatementDetail.TEMP_STATEMENT_DIRECTORY.mkdir()) {
            if (this.f5893a.getPdfFile() != null) {
                File file = new File(StatementDetail.TEMP_STATEMENT_DIRECTORY, this.f5894b.getFileName());
                byte[] decode = Base64.decode(this.f5893a.getPdfFile(), 0);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(decode);
                    fileOutputStream.close();
                    this.f5893a.setPdfFileSize(m5877a(file.length()));
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new C1389d(this.f5895c.getString(C1506am.statements_file_error), 1000);
                }
            }
            C1656ba.m6417a(new C1444e(this));
            return true;
        }
        throw new C1389d(this.f5895c.getString(C1506am.statements_file_error), 1000);
    }
}
