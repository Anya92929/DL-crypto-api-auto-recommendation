package com.google.p019b.p020a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.b.a.e */
public class C1340e implements Externalizable {

    /* renamed from: a */
    private boolean f5475a;

    /* renamed from: b */
    private String f5476b = "";

    /* renamed from: c */
    private boolean f5477c;

    /* renamed from: d */
    private String f5478d = "";

    /* renamed from: e */
    private List<String> f5479e = new ArrayList();

    /* renamed from: f */
    private boolean f5480f;

    /* renamed from: g */
    private String f5481g = "";

    /* renamed from: h */
    private boolean f5482h;

    /* renamed from: i */
    private boolean f5483i = false;

    /* renamed from: j */
    private boolean f5484j;

    /* renamed from: k */
    private String f5485k = "";

    /* renamed from: a */
    public C1340e mo9198a(String str) {
        this.f5475a = true;
        this.f5476b = str;
        return this;
    }

    /* renamed from: a */
    public C1340e mo9199a(boolean z) {
        this.f5482h = true;
        this.f5483i = z;
        return this;
    }

    /* renamed from: a */
    public String mo9200a() {
        return this.f5476b;
    }

    /* renamed from: a */
    public String mo9201a(int i) {
        return this.f5479e.get(i);
    }

    /* renamed from: b */
    public C1340e mo9202b(String str) {
        this.f5477c = true;
        this.f5478d = str;
        return this;
    }

    /* renamed from: b */
    public String mo9203b() {
        return this.f5478d;
    }

    /* renamed from: c */
    public int mo9204c() {
        return this.f5479e.size();
    }

    /* renamed from: c */
    public C1340e mo9205c(String str) {
        this.f5480f = true;
        this.f5481g = str;
        return this;
    }

    /* renamed from: d */
    public C1340e mo9206d(String str) {
        this.f5484j = true;
        this.f5485k = str;
        return this;
    }

    /* renamed from: d */
    public String mo9207d() {
        return this.f5481g;
    }

    /* renamed from: e */
    public boolean mo9208e() {
        return this.f5483i;
    }

    public void readExternal(ObjectInput objectInput) {
        mo9198a(objectInput.readUTF());
        mo9202b(objectInput.readUTF());
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f5479e.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            mo9205c(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            mo9206d(objectInput.readUTF());
        }
        mo9199a(objectInput.readBoolean());
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f5476b);
        objectOutput.writeUTF(this.f5478d);
        int c = mo9204c();
        objectOutput.writeInt(c);
        for (int i = 0; i < c; i++) {
            objectOutput.writeUTF(this.f5479e.get(i));
        }
        objectOutput.writeBoolean(this.f5480f);
        if (this.f5480f) {
            objectOutput.writeUTF(this.f5481g);
        }
        objectOutput.writeBoolean(this.f5484j);
        if (this.f5484j) {
            objectOutput.writeUTF(this.f5485k);
        }
        objectOutput.writeBoolean(this.f5483i);
    }
}
