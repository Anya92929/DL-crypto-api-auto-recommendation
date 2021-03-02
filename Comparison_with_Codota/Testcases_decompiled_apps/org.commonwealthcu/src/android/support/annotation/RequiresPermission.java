package android.support.annotation;

public @interface RequiresPermission {

    public @interface Read {
        RequiresPermission value();
    }

    public @interface Write {
        RequiresPermission value();
    }

    String[] allOf();

    String[] anyOf();

    boolean conditional();

    String value();
}
