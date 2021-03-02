package cmn;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

@TargetApi(13)
/* renamed from: cmn.e */
public class C0743e extends C0742d {
    /* renamed from: a */
    public final Point mo3375a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager == null ? null : windowManager.getDefaultDisplay();
        Point point = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getSize(point);
        }
        return point;
    }
}
