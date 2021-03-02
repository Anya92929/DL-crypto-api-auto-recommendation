package p005pl.mg6.android.maps.extensions;

import com.google.android.gms.maps.model.MarkerOptions;

/* renamed from: pl.mg6.android.maps.extensions.ClusteringSettings */
public class ClusteringSettings {
    private boolean addMarkersDynamically = false;
    private double clusterSize = 180.0d;
    private boolean enabled = true;
    private IconDataProvider iconDataProvider = null;

    /* renamed from: pl.mg6.android.maps.extensions.ClusteringSettings$IconDataProvider */
    public interface IconDataProvider {
        MarkerOptions getIconData(int i);
    }

    public ClusteringSettings addMarkersDynamically(boolean addMarkersDynamically2) {
        this.addMarkersDynamically = addMarkersDynamically2;
        return this;
    }

    public ClusteringSettings clusterSize(double clusterSize2) {
        this.clusterSize = clusterSize2;
        return this;
    }

    public ClusteringSettings enabled(boolean enabled2) {
        this.enabled = enabled2;
        return this;
    }

    public double getClusterSize() {
        return this.clusterSize;
    }

    public IconDataProvider getIconDataProvider() {
        return this.iconDataProvider;
    }

    public ClusteringSettings iconDataProvider(IconDataProvider iconDataProvider2) {
        this.iconDataProvider = iconDataProvider2;
        return this;
    }

    public boolean isAddMarkersDynamically() {
        return this.addMarkersDynamically;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClusteringSettings)) {
            return false;
        }
        ClusteringSettings other = (ClusteringSettings) o;
        if (this.enabled != other.enabled) {
            return false;
        }
        if (this.addMarkersDynamically != other.addMarkersDynamically) {
            return false;
        }
        if (!this.enabled && !other.enabled) {
            return true;
        }
        if (this.clusterSize != other.clusterSize) {
            return false;
        }
        return this.iconDataProvider.equals(other.iconDataProvider);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
