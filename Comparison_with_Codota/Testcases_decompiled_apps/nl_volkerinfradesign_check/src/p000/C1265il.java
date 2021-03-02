package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.AsyncTask;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemView;

/* renamed from: il */
public final class C1265il {

    /* renamed from: a */
    public final ImageButton f4433a;

    /* renamed from: b */
    public final ImageButton f4434b;

    /* renamed from: c */
    public final LinearLayout f4435c;

    /* renamed from: d */
    public final HorizontalScrollView f4436d;

    /* renamed from: e */
    private Point f4437e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f4438f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final View.OnClickListener f4439g = new View.OnClickListener() {
        public void onClick(View view) {
            C1265il.this.f4443k.mo10062a((PictureKey) view.getTag(), C1265il.this.f4435c.indexOfChild(view) - 1);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final View.OnLongClickListener f4440h = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            C1265il.this.f4443k.mo10061a((PictureKey) view.getTag());
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final LinearLayout.LayoutParams f4441i = new LinearLayout.LayoutParams(-2, -1);

    /* renamed from: j */
    private final View.OnClickListener f4442j = new View.OnClickListener() {
        public void onClick(View view) {
            if (view == C1265il.this.f4433a) {
                C1265il.this.f4443k.mo10065c();
            } else {
                C1265il.this.f4443k.mo10067e();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final ItemView f4443k;

    public C1265il(ItemView itemView) {
        this.f4443k = itemView;
        this.f4436d = (HorizontalScrollView) itemView.findViewById(C1352R.C1354id.pictures);
        this.f4435c = (LinearLayout) itemView.findViewById(C1352R.C1354id.picturesContainer);
        this.f4433a = (ImageButton) this.f4435c.findViewById(C1352R.C1354id.addPictureButton);
        this.f4433a.setOnClickListener(this.f4442j);
        this.f4434b = (ImageButton) this.f4435c.findViewById(C1352R.C1354id.pickPicture);
        this.f4434b.setOnClickListener(this.f4442j);
    }

    /* renamed from: a */
    public void mo8606a(int i, int i2, int i3, int i4) {
        this.f4437e = new Point(i, i2);
        if (this.f4443k.f5276z != null && !this.f4438f) {
            new C1269a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f4443k.f5276z);
        }
    }

    /* renamed from: a */
    public void mo8605a() {
        if (!this.f4443k.f5260j) {
            this.f4436d.setVisibility(8);
            return;
        }
        this.f4436d.setVisibility(0);
        if (this.f4437e != null && !this.f4438f && this.f4443k.f5276z != null) {
            new C1269a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f4443k.f5276z);
        }
    }

    /* renamed from: il$a */
    class C1269a extends AsyncTask<PictureKey, ImageView, Void> {
        private C1269a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(PictureKey... pictureKeyArr) {
            boolean delete;
            for (PictureKey pictureKey : pictureKeyArr) {
                PicturesTable.PicturesCursor picturesCursor = pictureKey.get();
                try {
                    picturesCursor.getCount();
                    picturesCursor.moveToFirst();
                    delete = false;
                } catch (Exception e) {
                    delete = pictureKey.delete();
                } catch (Throwable th) {
                    picturesCursor.close();
                    throw th;
                }
                if (!delete) {
                    if (picturesCursor.moveToFirst()) {
                        m5585a(picturesCursor, pictureKey);
                    }
                }
                picturesCursor.close();
            }
            return null;
        }

        /* renamed from: a */
        private void m5585a(PicturesTable.PicturesCursor picturesCursor, PictureKey pictureKey) {
            byte[] thumb = picturesCursor.getThumb();
            if (thumb != null && thumb.length > 0) {
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(thumb, 0, thumb.length);
                    if (decodeByteArray != null) {
                        ImageView imageView = new ImageView(C1265il.this.f4443k.getContext());
                        imageView.setBackgroundResource(17301683);
                        imageView.setAdjustViewBounds(true);
                        imageView.setLayoutParams(C1265il.this.f4441i);
                        imageView.setImageBitmap(decodeByteArray);
                        imageView.setTag(pictureKey);
                        publishProgress(new ImageView[]{imageView});
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppState.getInstance().log().mo8930e("Error in ImagesHolder", e);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            boolean unused = C1265il.this.f4438f = false;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = C1265il.this.f4438f = true;
            while (C1265il.this.f4435c.getChildCount() > 1) {
                ((ImageView) C1265il.this.f4435c.getChildAt(1)).setOnClickListener((View.OnClickListener) null);
                C1265il.this.f4435c.removeViewAt(1);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(ImageView... imageViewArr) {
            super.onProgressUpdate(imageViewArr);
            for (ImageView imageView : imageViewArr) {
                imageView.setOnClickListener(C1265il.this.f4439g);
                imageView.setOnLongClickListener(C1265il.this.f4440h);
                C1265il.this.f4435c.addView(imageView, C1265il.this.f4435c.getChildCount());
            }
        }
    }
}
