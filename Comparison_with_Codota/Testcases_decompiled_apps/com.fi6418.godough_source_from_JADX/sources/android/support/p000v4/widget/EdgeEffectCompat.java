package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

/* renamed from: android.support.v4.widget.EdgeEffectCompat */
public class EdgeEffectCompat {

    /* renamed from: b */
    private static final EdgeEffectImpl f1492b;

    /* renamed from: a */
    private Object f1493a;

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$BaseEdgeEffectImpl */
    class BaseEdgeEffectImpl implements EdgeEffectImpl {
        BaseEdgeEffectImpl() {
        }

        public boolean draw(Object obj, Canvas canvas) {
            return false;
        }

        public void finish(Object obj) {
        }

        public boolean isFinished(Object obj) {
            return true;
        }

        public Object newEdgeEffect(Context context) {
            return null;
        }

        public boolean onAbsorb(Object obj, int i) {
            return false;
        }

        public boolean onPull(Object obj, float f) {
            return false;
        }

        public boolean onPull(Object obj, float f, float f2) {
            return false;
        }

        public boolean onRelease(Object obj) {
            return false;
        }

        public void setSize(Object obj, int i, int i2) {
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectIcsImpl */
    class EdgeEffectIcsImpl implements EdgeEffectImpl {
        EdgeEffectIcsImpl() {
        }

        public boolean draw(Object obj, Canvas canvas) {
            return EdgeEffectCompatIcs.draw(obj, canvas);
        }

        public void finish(Object obj) {
            EdgeEffectCompatIcs.finish(obj);
        }

        public boolean isFinished(Object obj) {
            return EdgeEffectCompatIcs.isFinished(obj);
        }

        public Object newEdgeEffect(Context context) {
            return EdgeEffectCompatIcs.newEdgeEffect(context);
        }

        public boolean onAbsorb(Object obj, int i) {
            return EdgeEffectCompatIcs.onAbsorb(obj, i);
        }

        public boolean onPull(Object obj, float f) {
            return EdgeEffectCompatIcs.onPull(obj, f);
        }

        public boolean onPull(Object obj, float f, float f2) {
            return EdgeEffectCompatIcs.onPull(obj, f);
        }

        public boolean onRelease(Object obj) {
            return EdgeEffectCompatIcs.onRelease(obj);
        }

        public void setSize(Object obj, int i, int i2) {
            EdgeEffectCompatIcs.setSize(obj, i, i2);
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl */
    interface EdgeEffectImpl {
        boolean draw(Object obj, Canvas canvas);

        void finish(Object obj);

        boolean isFinished(Object obj);

        Object newEdgeEffect(Context context);

        boolean onAbsorb(Object obj, int i);

        boolean onPull(Object obj, float f);

        boolean onPull(Object obj, float f, float f2);

        boolean onRelease(Object obj);

        void setSize(Object obj, int i, int i2);
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectLollipopImpl */
    class EdgeEffectLollipopImpl extends EdgeEffectIcsImpl {
        EdgeEffectLollipopImpl() {
        }

        public boolean onPull(Object obj, float f, float f2) {
            return EdgeEffectCompatLollipop.onPull(obj, f, f2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1492b = new EdgeEffectLollipopImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1492b = new EdgeEffectIcsImpl();
        } else {
            f1492b = new BaseEdgeEffectImpl();
        }
    }

    public EdgeEffectCompat(Context context) {
        this.f1493a = f1492b.newEdgeEffect(context);
    }

    public boolean draw(Canvas canvas) {
        return f1492b.draw(this.f1493a, canvas);
    }

    public void finish() {
        f1492b.finish(this.f1493a);
    }

    public boolean isFinished() {
        return f1492b.isFinished(this.f1493a);
    }

    public boolean onAbsorb(int i) {
        return f1492b.onAbsorb(this.f1493a, i);
    }

    public boolean onPull(float f) {
        return f1492b.onPull(this.f1493a, f);
    }

    public boolean onPull(float f, float f2) {
        return f1492b.onPull(this.f1493a, f, f2);
    }

    public boolean onRelease() {
        return f1492b.onRelease(this.f1493a);
    }

    public void setSize(int i, int i2) {
        f1492b.setSize(this.f1493a, i, i2);
    }
}
