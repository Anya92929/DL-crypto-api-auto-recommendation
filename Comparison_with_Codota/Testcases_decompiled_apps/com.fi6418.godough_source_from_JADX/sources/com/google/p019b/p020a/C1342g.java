package com.google.p019b.p020a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.b.a.g */
public class C1342g implements Externalizable {

    /* renamed from: a */
    private List<C1341f> f5538a = new ArrayList();

    /* renamed from: a */
    public List<C1341f> mo9247a() {
        return this.f5538a;
    }

    /* renamed from: b */
    public int mo9248b() {
        return this.f5538a.size();
    }

    public void readExternal(ObjectInput objectInput) {
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            C1341f fVar = new C1341f();
            fVar.readExternal(objectInput);
            this.f5538a.add(fVar);
        }
    }

    public void writeExternal(ObjectOutput objectOutput) {
        int b = mo9248b();
        objectOutput.writeInt(b);
        for (int i = 0; i < b; i++) {
            this.f5538a.get(i).writeExternal(objectOutput);
        }
    }
}
