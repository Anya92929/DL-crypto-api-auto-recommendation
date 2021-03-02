package p006nl.volkerinfradesign.checkandroid.p007ui.drawing;

import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.p001v4.app.ActivityCompat;
import android.support.p001v4.content.ContextCompat;
import android.support.p004v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Closeable;
import java.io.File;
import org.apache.commons.p009io.FileUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;
import p006nl.volkerinfradesign.checkandroid.util.UtilFiles;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.drawing.DrawActivity */
public class DrawActivity extends AppCompatActivity {

    /* renamed from: k */
    DrawingView f5009k;

    /* renamed from: l */
    private int f5010l;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1352R.C1355menu.draw_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId == C1352R.C1354id.delete) {
            m6061d();
            return true;
        } else if (itemId == C1352R.C1354id.camera) {
            m6059b();
            return true;
        } else if (itemId != C1352R.C1354id.undo) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            this.f5009k.undo();
            return true;
        }
    }

    /* renamed from: b */
    private void m6059b() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            this.f5010l = m6060c();
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", Uri.fromFile(getTempFile()));
            startActivityForResult(intent, 1234);
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 12);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length != 0 && iArr[0] == 0) {
            switch (i) {
                case 12:
                    m6059b();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: c */
    private int m6060c() {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "datetaken"}, (String) null, (String[]) null, "datetaken DESC");
            try {
                if (query.moveToFirst()) {
                    int i = query.getInt(query.getColumnIndex("_id"));
                    IOUtils.closeQuietly((Closeable) query);
                    return i;
                }
                IOUtils.closeQuietly((Closeable) query);
                return -1;
            } catch (Exception e) {
                cursor = query;
                IOUtils.closeQuietly((Closeable) cursor);
                return -1;
            } catch (Throwable th) {
                th = th;
                cursor2 = query;
                IOUtils.closeQuietly((Closeable) cursor2);
                throw th;
            }
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((Closeable) cursor2);
            throw th;
        }
    }

    /* renamed from: d */
    private void m6061d() {
        new AlertDialog.Builder(this).setIcon(17301543).setTitle("Verwijderen").setMessage("Tekening echt verwijderen?").setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DrawActivity.this.finish();
            }
        }).setNegativeButton("Nee", (DialogInterface.OnClickListener) null).show();
    }

    /* renamed from: e */
    private App m6062e() {
        return (App) getApplication();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(m6062e().getModel().getCustomTheme().getMainStyle());
        new ActionBarCompat(this).setDisplayHomeAsUpEnabled(true);
        setContentView(C1352R.layout.draw_layout);
        this.f5009k = (DrawingView) findViewById(C1352R.C1354id.drawingView);
    }

    public void colorClick(View view) {
        this.f5009k.setPaintColor(((ColorDrawable) view.getBackground()).getColor());
    }

    public void sizeClick(View view) {
        this.f5009k.setPaintSize(Integer.valueOf(view.getTag().toString()).intValue());
    }

    public void onBackPressed() {
        if (this.f5009k.f5012a.size() > 0) {
            this.f5009k.buildDrawingCache();
            UtilFiles.saveBitmapToFile(this.f5009k.getDrawingCache(), m6062e().getTempFile());
            setResult(-1);
        }
        super.onBackPressed();
    }

    public File getTempFile() {
        return new File(getExternalCacheDir(), "temp_picture_file_drawing.jpg");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1234:
                File tempFile = getTempFile();
                try {
                    byte[] downSizedImage = UtilFiles.getDownSizedImage(FileUtils.readFileToByteArray(tempFile), (float) Math.max(this.f5009k.getWidth(), this.f5009k.getHeight()), BitmapDescriptorFactory.HUE_RED);
                    this.f5009k.setmBackground(BitmapFactory.decodeByteArray(downSizedImage, 0, downSizedImage.length));
                } catch (Exception e) {
                }
                tempFile.delete();
                int c = m6060c();
                if (this.f5010l != -1 && c != -1 && c > this.f5010l) {
                    getContentResolver().delete(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) c), (String) null, (String[]) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
