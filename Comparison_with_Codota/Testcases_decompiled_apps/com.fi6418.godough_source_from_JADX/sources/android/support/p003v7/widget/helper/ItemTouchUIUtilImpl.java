package android.support.p003v7.widget.helper;

import android.graphics.Canvas;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.recyclerview.C0273R;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl */
class ItemTouchUIUtilImpl {

    /* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl$Gingerbread */
    class Gingerbread implements ItemTouchUIUtil {
        Gingerbread() {
        }

        /* renamed from: a */
        private void m2457a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public void clearView(View view) {
            view.setVisibility(0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                m2457a(canvas, recyclerView, view, f, f2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i == 2) {
                m2457a(canvas, recyclerView, view, f, f2);
            }
        }

        public void onSelected(View view) {
            view.setVisibility(4);
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl$Honeycomb */
    class Honeycomb implements ItemTouchUIUtil {
        Honeycomb() {
        }

        public void clearView(View view) {
            ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
            ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            ViewCompat.setTranslationX(view, f);
            ViewCompat.setTranslationY(view, f2);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }

        public void onSelected(View view) {
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl$Lollipop */
    class Lollipop extends Honeycomb {
        Lollipop() {
        }

        /* renamed from: a */
        private float m2458a(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float elevation = ViewCompat.getElevation(childAt);
                    if (elevation > f) {
                        f = elevation;
                    }
                }
            }
            return f;
        }

        public void clearView(View view) {
            Object tag = view.getTag(C0273R.C0274id.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.setElevation(view, ((Float) tag).floatValue());
            }
            view.setTag(C0273R.C0274id.item_touch_helper_previous_elevation, (Object) null);
            super.clearView(view);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(C0273R.C0274id.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                ViewCompat.setElevation(view, 1.0f + m2458a(recyclerView, view));
                view.setTag(C0273R.C0274id.item_touch_helper_previous_elevation, valueOf);
            }
            super.onDraw(canvas, recyclerView, view, f, f2, i, z);
        }
    }

    ItemTouchUIUtilImpl() {
    }
}
