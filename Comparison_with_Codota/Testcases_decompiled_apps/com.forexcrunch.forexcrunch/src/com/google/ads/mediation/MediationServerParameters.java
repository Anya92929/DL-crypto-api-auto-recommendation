package com.google.ads.mediation;

import com.google.ads.util.C0284b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class MediationServerParameters {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    public static class MappingException extends Exception {
        public MappingException(String message) {
            super(message);
        }
    }

    public void load(Map<String, String> parameters) throws MappingException {
        String str;
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            C0284b.m490e("No server options fields detected.  To suppress this message either add a field with the @Parameter annotation, or override the load() method");
        }
        for (Map.Entry next : parameters.entrySet()) {
            Field field2 = (Field) hashMap.remove(next.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, next.getValue());
                } catch (IllegalAccessException e) {
                    C0284b.m484b("Server Option '" + ((String) next.getKey()) + "' could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    C0284b.m484b("Server Option '" + ((String) next.getKey()) + "' could not be set: Bad Type");
                }
            } else {
                C0284b.m490e("Unexpected Server Option: " + ((String) next.getKey()) + " = '" + ((String) next.getValue()) + "'");
            }
        }
        String str2 = null;
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                C0284b.m484b("Required Server Option missing: " + ((Parameter) field3.getAnnotation(Parameter.class)).name());
                str = (str2 == null ? "" : str2 + ", ") + ((Parameter) field3.getAnnotation(Parameter.class)).name();
            } else {
                str = str2;
            }
            str2 = str;
        }
        if (str2 != null) {
            throw new MappingException("Required Server Option(s) missing: " + str2);
        }
        mo3654a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3654a() {
    }
}
