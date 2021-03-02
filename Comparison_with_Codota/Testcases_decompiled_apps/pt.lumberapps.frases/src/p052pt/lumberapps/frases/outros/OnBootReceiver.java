package p052pt.lumberapps.frases.outros;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p052pt.lumberapps.frases.C2030aj;
import p052pt.lumberapps.frases.C2056h;

/* renamed from: pt.lumberapps.frases.outros.OnBootReceiver */
public class OnBootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (new C2056h(context).mo10205a()) {
            new C2030aj(context).mo10169c();
        }
    }
}
