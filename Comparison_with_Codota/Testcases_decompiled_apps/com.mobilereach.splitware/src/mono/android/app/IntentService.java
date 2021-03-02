package mono.android.app;

import java.util.ArrayList;

public abstract class IntentService extends android.app.IntentService {
    ArrayList refList;

    public IntentService() {
        this((String) null);
    }

    public IntentService(String str) {
        super(str);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
