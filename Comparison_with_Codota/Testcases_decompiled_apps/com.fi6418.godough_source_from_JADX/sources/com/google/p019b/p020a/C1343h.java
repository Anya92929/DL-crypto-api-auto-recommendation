package com.google.p019b.p020a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* renamed from: com.google.b.a.h */
public class C1343h implements Externalizable {

    /* renamed from: a */
    private boolean f5539a;

    /* renamed from: b */
    private String f5540b = "";

    /* renamed from: c */
    private boolean f5541c;

    /* renamed from: d */
    private String f5542d = "";

    /* renamed from: e */
    private boolean f5543e;

    /* renamed from: f */
    private String f5544f = "";

    /* renamed from: a */
    public C1343h mo9251a(String str) {
        this.f5539a = true;
        this.f5540b = str;
        return this;
    }

    /* renamed from: b */
    public C1343h mo9252b(String str) {
        this.f5541c = true;
        this.f5542d = str;
        return this;
    }

    /* renamed from: c */
    public C1343h mo9253c(String str) {
        this.f5543e = true;
        this.f5544f = str;
        return this;
    }

    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            mo9251a(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            mo9252b(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            mo9253c(objectInput.readUTF());
        }
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.f5539a);
        if (this.f5539a) {
            objectOutput.writeUTF(this.f5540b);
        }
        objectOutput.writeBoolean(this.f5541c);
        if (this.f5541c) {
            objectOutput.writeUTF(this.f5542d);
        }
        objectOutput.writeBoolean(this.f5543e);
        if (this.f5543e) {
            objectOutput.writeUTF(this.f5544f);
        }
    }
}
