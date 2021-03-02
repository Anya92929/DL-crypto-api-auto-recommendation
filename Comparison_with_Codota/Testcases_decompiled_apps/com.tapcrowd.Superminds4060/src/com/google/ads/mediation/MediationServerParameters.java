package com.google.ads.mediation;

import com.google.android.gms.internal.C0344cn;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String message) {
            super(message);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3413a() {
    }

    public void load(Map<String, String> parameters) throws MappingException {
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            C0344cn.m737q("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry next : parameters.entrySet()) {
            Field field2 = (Field) hashMap.remove(next.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, next.getValue());
                } catch (IllegalAccessException e) {
                    C0344cn.m737q("Server option \"" + ((String) next.getKey()) + "\" could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    C0344cn.m737q("Server option \"" + ((String) next.getKey()) + "\" could not be set: Bad Type");
                }
            } else {
                C0344cn.m733m("Unexpected server option: " + ((String) next.getKey()) + " = \"" + ((String) next.getValue()) + "\"");
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                C0344cn.m737q("Required server option missing: " + ((Parameter) field3.getAnnotation(Parameter.class)).name());
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(((Parameter) field3.getAnnotation(Parameter.class)).name());
            }
        }
        if (sb.length() > 0) {
            throw new MappingException("Required server option(s) missing: " + sb.toString());
        }
        mo3413a();
    }
}
