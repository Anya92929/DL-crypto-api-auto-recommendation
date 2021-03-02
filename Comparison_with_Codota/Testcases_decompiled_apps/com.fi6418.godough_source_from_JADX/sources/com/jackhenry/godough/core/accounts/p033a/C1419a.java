package com.jackhenry.godough.core.accounts.p033a;

import android.graphics.Canvas;
import android.support.p003v7.widget.GridLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.helper.ItemTouchHelper;

/* renamed from: com.jackhenry.godough.core.accounts.a.a */
public class C1419a extends ItemTouchHelper.Callback {

    /* renamed from: a */
    private final C1420b f5847a;

    public C1419a(C1420b bVar) {
        this.f5847a = bVar;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof C1421c) {
            ((C1421c) viewHolder).mo9564u();
        }
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return recyclerView.getLayoutManager() instanceof GridLayoutManager ? makeMovementFlags(15, 0) : makeMovementFlags(3, 48);
    }

    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(f) / ((float) viewHolder.itemView.getWidth())));
            viewHolder.itemView.setTranslationX(f);
            return;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
            return false;
        }
        this.f5847a.mo9561a(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i != 0 && (viewHolder instanceof C1421c)) {
            ((C1421c) viewHolder).mo9563t();
        }
        super.onSelectedChanged(viewHolder, i);
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.f5847a.mo9562c(viewHolder.getAdapterPosition());
    }
}
