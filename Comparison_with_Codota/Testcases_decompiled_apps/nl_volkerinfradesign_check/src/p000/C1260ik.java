package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemView;

/* renamed from: ik */
public final class C1260ik {

    /* renamed from: a */
    final FrameLayout f4417a;

    /* renamed from: b */
    final LinearLayout f4418b;

    /* renamed from: c */
    final ImageView f4419c;

    /* renamed from: d */
    final LinearLayout f4420d;

    /* renamed from: e */
    final Button f4421e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Point f4422f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f4423g;

    /* renamed from: h */
    private final View.OnClickListener f4424h = new View.OnClickListener() {
        public void onClick(View view) {
            C1260ik.this.f4425i.mo10059a(C1260ik.this);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ItemView f4425i;

    /* renamed from: j */
    private final View.OnClickListener f4426j = new View.OnClickListener() {
        public void onClick(View view) {
            if (C1260ik.this.f4425i.f5236A != null && C1260ik.this.f4422f != null && !C1260ik.this.f4423g) {
                new C1263a(C1260ik.this.f4422f).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[]{C1260ik.this.f4425i.f5236A});
            }
        }
    };

    public C1260ik(ItemView itemView) {
        this.f4425i = itemView;
        this.f4417a = (FrameLayout) itemView.findViewById(C1352R.C1354id.descImgContainer);
        this.f4419c = (ImageView) itemView.findViewById(C1352R.C1354id.descImg);
        this.f4420d = (LinearLayout) itemView.findViewById(C1352R.C1354id.descImgProgress);
        this.f4418b = (LinearLayout) itemView.findViewById(C1352R.C1354id.descImgError);
        this.f4421e = (Button) itemView.findViewById(C1352R.C1354id.descImgRetry);
        this.f4421e.setOnClickListener(this.f4426j);
        this.f4419c.setOnClickListener(this.f4424h);
    }

    /* renamed from: a */
    public void mo8594a() {
        if (this.f4425i.f5236A == null) {
            this.f4417a.setVisibility(8);
            return;
        }
        this.f4417a.setVisibility(0);
        if (this.f4422f != null && !this.f4423g) {
            new C1263a(this.f4422f).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[]{this.f4425i.f5236A});
        }
    }

    /* renamed from: a */
    public void mo8595a(int i, int i2, int i3, int i4) {
        this.f4422f = new Point(i, i2);
        if (this.f4425i.f5236A != null && !this.f4423g) {
            new C1263a(this.f4422f).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[]{this.f4425i.f5236A});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5567a(int i) {
        int i2;
        int i3;
        int i4 = 0;
        if (i == -1) {
            this.f4417a.setVisibility(8);
            return;
        }
        this.f4417a.setVisibility(0);
        LinearLayout linearLayout = this.f4420d;
        if (i == 0) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        linearLayout.setVisibility(i2);
        LinearLayout linearLayout2 = this.f4418b;
        if (i == 1) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        linearLayout2.setVisibility(i3);
        ImageView imageView = this.f4419c;
        if (i != 2) {
            i4 = 4;
        }
        imageView.setVisibility(i4);
    }

    /* renamed from: ik$a */
    class C1263a extends AsyncTask<String, Void, C1264b> {
        public C1263a(Point point) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1264b doInBackground(String... strArr) {
            byte[] mediumSize;
            try {
                PicturesTable.PicturesCursor ensure = Schema.getPictures().ensure(strArr[0]);
                if (ensure == null || !ensure.moveToFirst() || (mediumSize = ensure.getMediumSize()) == null) {
                    return new C1264b((Exception) new NullPointerException("Bitmap not available!"));
                }
                return new C1264b(BitmapFactory.decodeByteArray(mediumSize, 0, mediumSize.length));
            } catch (Exception e) {
                Exception exc = e;
                exc.printStackTrace();
                return new C1264b(exc);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C1264b bVar) {
            super.onPostExecute(bVar);
            boolean unused = C1260ik.this.f4423g = false;
            if (C1260ik.this.f4417a.getVisibility() != 0) {
                return;
            }
            if (bVar.mo8604b()) {
                C1260ik.this.f4419c.setImageBitmap(bVar.mo8603a());
                C1260ik.this.m5567a(2);
                return;
            }
            C1260ik.this.m5567a(1);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = C1260ik.this.f4423g = true;
            C1260ik.this.m5567a(0);
        }
    }

    /* renamed from: ik$b */
    final class C1264b {

        /* renamed from: b */
        private final Bitmap f4431b;

        /* renamed from: c */
        private final Exception f4432c;

        public C1264b(Exception exc) {
            this.f4432c = exc;
            this.f4431b = null;
        }

        C1264b(Bitmap bitmap) {
            this.f4431b = bitmap;
            this.f4432c = null;
        }

        /* renamed from: a */
        public Bitmap mo8603a() {
            return this.f4431b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo8604b() {
            return this.f4431b != null;
        }
    }
}
