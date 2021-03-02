package com.jackhenry.godough.core.accounts.statements.model;

import android.text.TextUtils;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughType;
import java.io.File;

public class StatementDetail implements GoDoughType {
    private static final String BASE_STATEMENT_DIR = "statements";
    public static final int PAGE_NUM_UNKNOWN = -1;
    public static final File TEMP_STATEMENT_DIRECTORY = new File(GoDoughApp.getApp().getCacheDir(), BASE_STATEMENT_DIR);
    private String base64Pdf;
    private String message;
    private int pageCount = -1;
    private String pdfFileSize;
    private String webOutput;

    public String getMessage() {
        return this.message;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public String getPdfFile() {
        if (TextUtils.isEmpty(this.base64Pdf) || this.base64Pdf.trim().length() == 0) {
            return null;
        }
        return this.base64Pdf;
    }

    public String getPdfFileSize() {
        return this.pdfFileSize;
    }

    public String getWebOutput() {
        return this.webOutput;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPageCount(int i) {
        this.pageCount = i;
    }

    public void setPdfFile(String str) {
        this.base64Pdf = str;
    }

    public void setPdfFileSize(String str) {
        this.pdfFileSize = str;
    }

    public void setWebOutput(String str) {
        this.webOutput = str;
    }
}
