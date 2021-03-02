package p005pl.mg6.android.maps.extensions.impl;

import android.os.Handler;
import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* renamed from: pl.mg6.android.maps.extensions.impl.ClusterRefresher */
class ClusterRefresher {
    private boolean refreshPending;
    private Set<ClusterMarker> refreshQueue = new HashSet();
    private Handler refresher = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            ClusterRefresher.this.refreshAll();
            return true;
        }
    });

    ClusterRefresher() {
    }

    /* access modifiers changed from: package-private */
    public void refresh(ClusterMarker cluster) {
        this.refreshQueue.add(cluster);
        if (!this.refreshPending) {
            this.refresher.sendEmptyMessage(0);
            this.refreshPending = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void cleanup() {
        this.refreshQueue.clear();
        this.refreshPending = false;
        this.refresher.removeMessages(0);
    }

    /* access modifiers changed from: package-private */
    public void refreshAll() {
        for (ClusterMarker cluster : this.refreshQueue) {
            cluster.refresh();
        }
        cleanup();
    }
}
