package cmn;

/* renamed from: cmn.bh */
public enum C0740bh {
    SIZE("=s%d"),
    WIDTH("=w%d"),
    HEIGHT("=h%d"),
    CROP_SQUARE("=s%d-c");
    

    /* renamed from: e */
    private String f1826e;

    private C0740bh(String str) {
        this.f1826e = str;
    }

    /* renamed from: a */
    public final String mo3420a(int i) {
        return String.format(this.f1826e, new Object[]{Integer.valueOf(i)});
    }
}
