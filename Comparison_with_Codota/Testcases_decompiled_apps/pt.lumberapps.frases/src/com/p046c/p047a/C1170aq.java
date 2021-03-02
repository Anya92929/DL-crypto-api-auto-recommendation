package com.p046c.p047a;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

/* renamed from: com.c.a.aq */
class C1170aq extends Handler {
    private C1170aq() {
    }

    /* synthetic */ C1170aq(C1165al alVar) {
        this();
    }

    public void handleMessage(Message message) {
        boolean z;
        int i;
        ArrayList arrayList = (ArrayList) C1164ak.f3232i.get();
        ArrayList arrayList2 = (ArrayList) C1164ak.f3234k.get();
        switch (message.what) {
            case 0:
                ArrayList arrayList3 = (ArrayList) C1164ak.f3233j.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C1164ak akVar = (C1164ak) arrayList4.get(i2);
                        if (akVar.f3259y == 0) {
                            akVar.m5326r();
                        } else {
                            arrayList2.add(akVar);
                        }
                    }
                }
                break;
            case 1:
                z = true;
                break;
            default:
                return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        ArrayList arrayList5 = (ArrayList) C1164ak.f3236m.get();
        ArrayList arrayList6 = (ArrayList) C1164ak.f3235l.get();
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            C1164ak akVar2 = (C1164ak) arrayList2.get(i3);
            if (akVar2.mo4586b(currentAnimationTimeMillis)) {
                arrayList5.add(akVar2);
            }
        }
        int size3 = arrayList5.size();
        if (size3 > 0) {
            for (int i4 = 0; i4 < size3; i4++) {
                C1164ak akVar3 = (C1164ak) arrayList5.get(i4);
                akVar3.m5326r();
                boolean unused = akVar3.f3256v = true;
                arrayList2.remove(akVar3);
            }
            arrayList5.clear();
        }
        int size4 = arrayList.size();
        int i5 = 0;
        while (i5 < size4) {
            C1164ak akVar4 = (C1164ak) arrayList.get(i5);
            if (akVar4.mo4535e(currentAnimationTimeMillis)) {
                arrayList6.add(akVar4);
            }
            if (arrayList.size() == size4) {
                i = i5 + 1;
            } else {
                size4--;
                arrayList6.remove(akVar4);
                i = i5;
            }
            size4 = size4;
            i5 = i;
        }
        if (arrayList6.size() > 0) {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < arrayList6.size()) {
                    ((C1164ak) arrayList6.get(i7)).mo4587i();
                    i6 = i7 + 1;
                } else {
                    arrayList6.clear();
                }
            }
        }
        if (!z) {
            return;
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            sendEmptyMessageDelayed(1, Math.max(0, C1164ak.f3240z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
        }
    }
}
