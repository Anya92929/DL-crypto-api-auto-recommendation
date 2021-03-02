package com.jackhenry.godough.core.accounts.statements;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetailHeader;
import com.jackhenry.godough.p027b.C1389d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.jackhenry.godough.core.accounts.statements.w */
public class C1462w {

    /* renamed from: a */
    private StatementDetail f5918a;

    /* renamed from: b */
    private Context f5919b;

    /* renamed from: c */
    private StatementDetailHeader f5920c;

    public C1462w(StatementDetail statementDetail, Context context, StatementDetailHeader statementDetailHeader) {
        this.f5919b = context;
        this.f5920c = statementDetailHeader;
        this.f5918a = statementDetail;
    }

    @TargetApi(21)
    /* renamed from: a */
    private Bitmap m5892a(int i, PdfRenderer pdfRenderer) {
        if (this.f5918a.getPdfFile() == null || i > pdfRenderer.getPageCount()) {
            return null;
        }
        PdfRenderer.Page openPage = pdfRenderer.openPage(i);
        Bitmap createBitmap = Bitmap.createBitmap(openPage.getWidth(), openPage.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawColor(-1);
        openPage.render(createBitmap, (Rect) null, (Matrix) null, 1);
        openPage.close();
        return createBitmap;
    }

    /* renamed from: a */
    private String m5893a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append(" window.onscroll = function(){updatePage()};");
        sb.append(" var content=[[]];");
        sb.append(" function buildContentArray()");
        sb.append(" {");
        sb.append("     var myelement;");
        sb.append("     var pageOffset;");
        sb.append("     for (x=0;x < " + i + ";x++)");
        sb.append("     {");
        sb.append("         myelement = document.getElementById('page' + x);");
        sb.append("         if ( myelement !=null)");
        sb.append("         {");
        sb.append("             var divContents =[];");
        sb.append("             divContents[0] = myelement.offsetTop;");
        sb.append("             divContents[1]= myelement.offsetTop+myelement.offsetHeight;");
        sb.append("             content[x]= divContents;");
        sb.append("             console.log('Set Total Height ' + content[x][1] + 'offset ' + content[x][0] );");
        sb.append("         }");
        sb.append("     }");
        sb.append(" }");
        sb.append(" function updatePage()");
        sb.append(" {");
        sb.append("     var topOffset = window.innerHeight/2;");
        sb.append("     if (content[0][0] ==null)");
        sb.append("     {");
        sb.append("         buildContentArray();");
        sb.append("     }");
        sb.append("     var scroll=window.scrollY;");
        sb.append("     var offset=scroll + topOffset;");
        sb.append("     for (x=0; x< content.length;x++)");
        sb.append("     {");
        sb.append("         if ((content[x][0]> scroll && content[x][0] < offset))");
        sb.append("         {");
        sb.append("             Statements.showPageCounter(x);");
        sb.append("             break;");
        sb.append("         }");
        sb.append("         else if ((content[x][1]> scroll+(topOffset/2) && content[x][0] < offset)) ");
        sb.append("         {");
        sb.append("             Statements.showPageCounter(x);");
        sb.append("             break;");
        sb.append("         }");
        sb.append("     }");
        sb.append("     console.log('Scroll Y ' + window.scrollY);");
        sb.append(" }");
        sb.append("</script>");
        return sb.toString();
    }

    /* renamed from: a */
    private String m5894a(String str) {
        String str2 = "<meta name=\"viewport\" content=\"width=device-width\" />";
        if (Build.VERSION.SDK_INT < 19) {
            str2 = "<meta name=\"viewport\" content=\"width=480\" />";
        }
        return String.format("<html><head><META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">\n<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\"> %1$s" + m5893a(this.f5918a.getPageCount()) + " <style>#dataWrapper {" + " background-color: #DCDCDC; height: auto; width: auto; margin: 0px; padding-top:10px; padding-bottom:10px; padding-right:0px; padding-left:0px;" + "} " + " img {display: block;" + "    margin-left: auto;" + "    margin-right: auto;  padding: 0px;}" + " pre {background-color: white; margin: 0px; padding:20px;}" + "</style>" + "</head><body bgcolor=\"#DCDCDC\" style=\"margin: 0px; padding-top:10px; padding-bottom:10px; padding-right:20px; padding-left:20px; display: inline-block;\">%2$s</body></html>", new Object[]{str2, str});
    }

    @TargetApi(21)
    /* renamed from: b */
    private PdfRenderer m5895b() {
        File file = new File(StatementDetail.TEMP_STATEMENT_DIRECTORY, this.f5920c.getFileName());
        if (!file.exists() || this.f5918a.getPdfFile() == null) {
            return null;
        }
        try {
            return new PdfRenderer(ParcelFileDescriptor.open(file, 268435456));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new C1389d(this.f5919b.getString(C1506am.statements_file_error), 1000);
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new C1389d(this.f5919b.getString(C1506am.statements_file_error), 1000);
        }
    }

    @TargetApi(21)
    /* renamed from: c */
    private String m5896c() {
        String format = String.format("<div id=\"dataWrapper\" >%1$s</div>", new Object[]{"<img id=\"page%1$d\" src=\"%2$s\" />"});
        PdfRenderer b = m5895b();
        this.f5918a.setPageCount(b.getPageCount());
        StringBuilder sb = new StringBuilder();
        File file = StatementDetail.TEMP_STATEMENT_DIRECTORY;
        for (int i = 0; i < this.f5918a.getPageCount(); i++) {
            Bitmap a = m5892a(i, b);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            File file2 = new File(StatementDetail.TEMP_STATEMENT_DIRECTORY, "StatementDetail" + i + ".bmp");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                a.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.writeTo(fileOutputStream);
                sb.append(String.format(format, new Object[]{Integer.valueOf(i), file2.getName()}));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return m5894a(sb.toString());
    }

    /* renamed from: a */
    public String mo9657a() {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return m5896c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
