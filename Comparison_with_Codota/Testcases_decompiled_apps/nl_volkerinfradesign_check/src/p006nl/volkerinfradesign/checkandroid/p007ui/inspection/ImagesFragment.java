package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.view.PagerAdapter;
import android.support.p001v4.view.ViewPager;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p010uk.p011co.senab.photoview.PhotoView;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ImagesFragment */
public final class ImagesFragment extends Fragment {

    /* renamed from: a */
    private Integer f5072a;

    /* renamed from: b */
    private InspectionItemKey f5073b;

    /* renamed from: c */
    private C1568c f5074c;

    /* renamed from: a */
    static ImagesFragment m6088a(InspectionItemConstants.ItemCursor itemCursor) {
        ImagesFragment imagesFragment = new ImagesFragment();
        Bundle bundle = new Bundle();
        if (itemCursor.hasDescriptiveImageUrl()) {
            bundle.putInt("images:initial_index", ExploreByTouchHelper.INVALID_ID);
            bundle.putParcelable("images:inspection_item_key", itemCursor.getKey());
            imagesFragment.setArguments(bundle);
            return imagesFragment;
        }
        throw new IllegalArgumentException("This item has no descriptive image!");
    }

    /* renamed from: a */
    static ImagesFragment m6089a(InspectionItemConstants.ItemCursor itemCursor, int i) {
        ImagesFragment imagesFragment = new ImagesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("images:initial_index", i);
        bundle.putParcelable("images:inspection_item_key", itemCursor.getKey());
        imagesFragment.setArguments(bundle);
        return imagesFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5074c = new C1568c();
        this.f5074c.setId(666);
        viewGroup.setBackgroundColor(getResources().getColor(C1352R.color.vw_bg_gray));
        return this.f5074c;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5074c.setAdapter(new C1567b());
        if (bundle == null && m6092n()) {
            this.f5074c.setCurrentItem(m6090l());
        }
    }

    /* renamed from: l */
    private int m6090l() {
        if (this.f5072a == null) {
            int i = getArguments().getInt("images:initial_index");
            switch (i) {
                case ExploreByTouchHelper.INVALID_ID:
                    throw new IllegalStateException("This is a viewer of a descriptiveImage!");
                case -1:
                    throw new IllegalStateException("There is nop initial index!");
                default:
                    this.f5072a = Integer.valueOf(i);
                    getArguments().putInt("images:initial_index", -1);
                    break;
            }
        }
        return this.f5072a.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public InspectionItemKey m6091m() {
        if (this.f5073b == null) {
            this.f5073b = (InspectionItemKey) getArguments().getParcelable("images:inspection_item_key");
        }
        return this.f5073b;
    }

    /* renamed from: n */
    private boolean m6092n() {
        switch (getArguments().getInt("images:initial_index", -1)) {
            case ExploreByTouchHelper.INVALID_ID:
            case -1:
                return false;
            default:
                return true;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ImagesFragment$b */
    class C1567b extends PagerAdapter {

        /* renamed from: b */
        private final PictureKey[] f5078b;

        C1567b() {
            PictureKey[] pictureKeyArr;
            switch (ImagesFragment.this.getArguments().getInt("images:initial_index")) {
                case ExploreByTouchHelper.INVALID_ID:
                    pictureKeyArr = new PictureKey[]{ImagesFragment.this.m6091m().getDescriptivePicture()};
                    break;
                default:
                    pictureKeyArr = ImagesFragment.this.m6091m().getPictures();
                    break;
            }
            this.f5078b = pictureKeyArr == null ? new PictureKey[0] : pictureKeyArr;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f5078b.length;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PhotoView photoView = new PhotoView(ImagesFragment.this.getActivity());
            viewGroup.addView(photoView);
            new C1566a(photoView).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new PictureKey[]{this.f5078b[i]});
            return photoView;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ImagesFragment$c */
    class C1568c extends ViewPager {

        /* renamed from: b */
        private final boolean f5080b;

        public C1568c() {
            super(ImagesFragment.this.getActivity());
            this.f5080b = Build.VERSION.SDK_INT >= 14;
        }

        @SuppressLint({"NewApi"})
        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (!this.f5080b || m6095g()) {
                return false;
            }
            return super.onHoverEvent(motionEvent);
        }

        @SuppressLint({"NewApi"})
        public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
            if (!this.f5080b || m6095g()) {
                return false;
            }
            return super.onInterceptHoverEvent(motionEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (m6095g()) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (m6095g()) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }

        /* renamed from: g */
        private boolean m6095g() {
            PagerAdapter adapter = getAdapter();
            if (adapter == null || adapter.getCount() != 1) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.ImagesFragment$a */
    class C1566a extends AsyncTask<PictureKey, Void, Bitmap> {

        /* renamed from: b */
        private final WeakReference<PhotoView> f5076b;

        public C1566a(PhotoView photoView) {
            this.f5076b = new WeakReference<>(photoView);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r0 = r2.getThumb();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            if (r0 != null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return android.graphics.BitmapFactory.decodeByteArray(r0, 0, r0.length);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:6:0x0011] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x004d A[ExcHandler:  FINALLY, Splitter:B:6:0x0011] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(p006nl.volkerinfradesign.checkandroid.database.PictureKey... r5) {
            /*
                r4 = this;
                r0 = 0
                r1 = r5[r0]
                if (r1 == 0) goto L_0x0041
                nl.volkerinfradesign.checkandroid.database.PicturesTable$PicturesCursor r2 = r1.get()
                r2.getCount()     // Catch:{ Exception -> 0x0027 }
                r2.moveToFirst()     // Catch:{ Exception -> 0x0027 }
            L_0x000f:
                if (r0 != 0) goto L_0x003e
                boolean r0 = r2.moveToFirst()     // Catch:{ Error -> 0x0043, Exception -> 0x0048, all -> 0x004d }
                if (r0 == 0) goto L_0x003e
                byte[] r0 = r2.getMediumSize()     // Catch:{ Error -> 0x002d, Exception -> 0x0048, all -> 0x004d }
                if (r0 == 0) goto L_0x003e
                r1 = 0
                int r3 = r0.length     // Catch:{ Error -> 0x002d, Exception -> 0x0048, all -> 0x004d }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r1, r3)     // Catch:{ Error -> 0x002d, Exception -> 0x0048, all -> 0x004d }
                r2.close()
            L_0x0026:
                return r0
            L_0x0027:
                r0 = move-exception
                boolean r0 = r1.delete()
                goto L_0x000f
            L_0x002d:
                r0 = move-exception
                byte[] r0 = r2.getThumb()     // Catch:{ Error -> 0x0043, Exception -> 0x0048, all -> 0x004d }
                if (r0 == 0) goto L_0x003e
                r1 = 0
                int r3 = r0.length     // Catch:{ Error -> 0x0043, Exception -> 0x0048, all -> 0x004d }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r1, r3)     // Catch:{ Error -> 0x0043, Exception -> 0x0048, all -> 0x004d }
                r2.close()
                goto L_0x0026
            L_0x003e:
                r2.close()
            L_0x0041:
                r0 = 0
                goto L_0x0026
            L_0x0043:
                r0 = move-exception
                r2.close()
                goto L_0x0041
            L_0x0048:
                r0 = move-exception
                r2.close()
                goto L_0x0041
            L_0x004d:
                r0 = move-exception
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.p007ui.inspection.ImagesFragment.C1566a.doInBackground(nl.volkerinfradesign.checkandroid.database.PictureKey[]):android.graphics.Bitmap");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            PhotoView photoView;
            super.onPostExecute(bitmap);
            WeakReference<PhotoView> weakReference = this.f5076b;
            if (weakReference != null && bitmap != null && (photoView = (PhotoView) weakReference.get()) != null) {
                photoView.setImageBitmap(bitmap);
            }
        }
    }
}
