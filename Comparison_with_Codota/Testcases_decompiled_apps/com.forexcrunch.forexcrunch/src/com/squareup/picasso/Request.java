package com.squareup.picasso;

import android.net.Uri;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Request {
    public final boolean centerCrop;
    public final boolean centerInside;
    public final boolean hasRotationPivot;
    public final int resourceId;
    public final float rotationDegrees;
    public final float rotationPivotX;
    public final float rotationPivotY;
    public final int targetHeight;
    public final int targetWidth;
    public final List<Transformation> transformations;
    public final Uri uri;

    private Request(Uri uri2, int resourceId2, List<Transformation> transformations2, int targetWidth2, int targetHeight2, boolean centerCrop2, boolean centerInside2, float rotationDegrees2, float rotationPivotX2, float rotationPivotY2, boolean hasRotationPivot2) {
        this.uri = uri2;
        this.resourceId = resourceId2;
        if (transformations2 == null) {
            this.transformations = null;
        } else {
            this.transformations = Collections.unmodifiableList(transformations2);
        }
        this.targetWidth = targetWidth2;
        this.targetHeight = targetHeight2;
        this.centerCrop = centerCrop2;
        this.centerInside = centerInside2;
        this.rotationDegrees = rotationDegrees2;
        this.rotationPivotX = rotationPivotX2;
        this.rotationPivotY = rotationPivotY2;
        this.hasRotationPivot = hasRotationPivot2;
    }

    /* access modifiers changed from: package-private */
    public String getName() {
        if (this.uri != null) {
            return this.uri.getPath();
        }
        return Integer.toHexString(this.resourceId);
    }

    public boolean hasSize() {
        return this.targetWidth != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean needsTransformation() {
        return needsMatrixTransform() || hasCustomTransformations();
    }

    /* access modifiers changed from: package-private */
    public boolean needsMatrixTransform() {
        return (this.targetWidth == 0 && this.rotationDegrees == BitmapDescriptorFactory.HUE_RED) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean hasCustomTransformations() {
        return this.transformations != null;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public static final class Builder {
        private boolean centerCrop;
        private boolean centerInside;
        private boolean hasRotationPivot;
        private int resourceId;
        private float rotationDegrees;
        private float rotationPivotX;
        private float rotationPivotY;
        private int targetHeight;
        private int targetWidth;
        private List<Transformation> transformations;
        private Uri uri;

        public Builder(Uri uri2) {
            setUri(uri2);
        }

        public Builder(int resourceId2) {
            setResourceId(resourceId2);
        }

        Builder(Uri uri2, int resourceId2) {
            this.uri = uri2;
            this.resourceId = resourceId2;
        }

        private Builder(Request request) {
            this.uri = request.uri;
            this.resourceId = request.resourceId;
            this.targetWidth = request.targetWidth;
            this.targetHeight = request.targetHeight;
            this.centerCrop = request.centerCrop;
            this.centerInside = request.centerInside;
            this.rotationDegrees = request.rotationDegrees;
            this.rotationPivotX = request.rotationPivotX;
            this.rotationPivotY = request.rotationPivotY;
            this.hasRotationPivot = request.hasRotationPivot;
            if (request.transformations != null) {
                this.transformations = new ArrayList(request.transformations);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasImage() {
            return (this.uri == null && this.resourceId == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean hasSize() {
            return this.targetWidth != 0;
        }

        public Builder setUri(Uri uri2) {
            if (uri2 == null) {
                throw new IllegalArgumentException("Image URI may not be null.");
            }
            this.uri = uri2;
            this.resourceId = 0;
            return this;
        }

        public Builder setResourceId(int resourceId2) {
            if (resourceId2 == 0) {
                throw new IllegalArgumentException("Image resource ID may not be 0.");
            }
            this.resourceId = resourceId2;
            this.uri = null;
            return this;
        }

        public Builder resize(int targetWidth2, int targetHeight2) {
            if (targetWidth2 <= 0) {
                throw new IllegalArgumentException("Width must be positive number.");
            } else if (targetHeight2 <= 0) {
                throw new IllegalArgumentException("Height must be positive number.");
            } else {
                this.targetWidth = targetWidth2;
                this.targetHeight = targetHeight2;
                return this;
            }
        }

        public Builder clearResize() {
            this.targetWidth = 0;
            this.targetHeight = 0;
            this.centerCrop = false;
            this.centerInside = false;
            return this;
        }

        public Builder centerCrop() {
            if (this.centerInside) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.centerCrop = true;
            return this;
        }

        public Builder clearCenterCrop() {
            this.centerCrop = false;
            return this;
        }

        public Builder centerInside() {
            if (this.centerCrop) {
                throw new IllegalStateException("Center inside can not be used after calling centerCrop");
            }
            this.centerInside = true;
            return this;
        }

        public Builder clearCenterInside() {
            this.centerInside = false;
            return this;
        }

        public Builder rotate(float degrees) {
            this.rotationDegrees = degrees;
            return this;
        }

        public Builder rotate(float degrees, float pivotX, float pivotY) {
            this.rotationDegrees = degrees;
            this.rotationPivotX = pivotX;
            this.rotationPivotY = pivotY;
            this.hasRotationPivot = true;
            return this;
        }

        public Builder clearRotation() {
            this.rotationDegrees = BitmapDescriptorFactory.HUE_RED;
            this.rotationPivotX = BitmapDescriptorFactory.HUE_RED;
            this.rotationPivotY = BitmapDescriptorFactory.HUE_RED;
            this.hasRotationPivot = false;
            return this;
        }

        public Builder transform(Transformation transformation) {
            if (transformation == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (this.transformations == null) {
                this.transformations = new ArrayList(2);
            }
            this.transformations.add(transformation);
            return this;
        }

        public Request build() {
            if (this.centerInside && this.centerCrop) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.centerCrop && this.targetWidth == 0) {
                throw new IllegalStateException("Center crop requires calling resize.");
            } else if (!this.centerInside || this.targetWidth != 0) {
                return new Request(this.uri, this.resourceId, this.transformations, this.targetWidth, this.targetHeight, this.centerCrop, this.centerInside, this.rotationDegrees, this.rotationPivotX, this.rotationPivotY, this.hasRotationPivot);
            } else {
                throw new IllegalStateException("Center inside requires calling resize.");
            }
        }
    }
}
