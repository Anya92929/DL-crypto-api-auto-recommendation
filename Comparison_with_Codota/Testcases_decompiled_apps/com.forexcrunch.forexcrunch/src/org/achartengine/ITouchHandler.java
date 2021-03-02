package org.achartengine;

import android.view.MotionEvent;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.ZoomListener;

public interface ITouchHandler {
    void addPanListener(PanListener panListener);

    void addZoomListener(ZoomListener zoomListener);

    boolean handleTouch(MotionEvent motionEvent);

    void removePanListener(PanListener panListener);

    void removeZoomListener(ZoomListener zoomListener);
}
