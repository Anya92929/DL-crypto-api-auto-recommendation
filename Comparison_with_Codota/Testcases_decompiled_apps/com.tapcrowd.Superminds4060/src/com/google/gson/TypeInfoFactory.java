package com.google.gson;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeInfoFactory {
    private TypeInfoFactory() {
    }

    public static TypeInfoArray getTypeInfoForArray(Type type) {
        Preconditions.checkArgument(TypeUtils.isArray(type));
        return new TypeInfoArray(type);
    }

    public static TypeInfo getTypeInfoForField(Field f, Type typeDefiningF) {
        return new TypeInfo(getActualType(f.getGenericType(), typeDefiningF, TypeUtils.toRawClass(typeDefiningF)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type getActualType(java.lang.reflect.Type r17, java.lang.reflect.Type r18, java.lang.Class<?> r19) {
        /*
            r0 = r17
            boolean r14 = r0 instanceof java.lang.Class
            if (r14 == 0) goto L_0x0007
        L_0x0006:
            return r17
        L_0x0007:
            r0 = r17
            boolean r14 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r14 == 0) goto L_0x002d
            r5 = r17
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type r11 = r5.getOwnerType()
            java.lang.reflect.Type[] r14 = r5.getActualTypeArguments()
            r0 = r18
            r1 = r19
            java.lang.reflect.Type[] r4 = extractRealTypes(r14, r0, r1)
            java.lang.reflect.Type r12 = r5.getRawType()
            com.google.gson.ParameterizedTypeImpl r17 = new com.google.gson.ParameterizedTypeImpl
            r0 = r17
            r0.<init>(r12, r4, r11)
            goto L_0x0006
        L_0x002d:
            r0 = r17
            boolean r14 = r0 instanceof java.lang.reflect.GenericArrayType
            if (r14 == 0) goto L_0x0061
            r5 = r17
            java.lang.reflect.GenericArrayType r5 = (java.lang.reflect.GenericArrayType) r5
            java.lang.reflect.Type r7 = r5.getGenericComponentType()
            r0 = r18
            r1 = r19
            java.lang.reflect.Type r2 = getActualType(r7, r0, r1)
            boolean r14 = r7.equals(r2)
            if (r14 == 0) goto L_0x004c
            r17 = r5
            goto L_0x0006
        L_0x004c:
            boolean r14 = r2 instanceof java.lang.Class
            if (r14 == 0) goto L_0x005b
            java.lang.Class r14 = com.google.gson.TypeUtils.toRawClass(r2)
            java.lang.Class r14 = com.google.gson.TypeUtils.wrapWithArray(r14)
        L_0x0058:
            r17 = r14
            goto L_0x0006
        L_0x005b:
            com.google.gson.GenericArrayTypeImpl r14 = new com.google.gson.GenericArrayTypeImpl
            r14.<init>(r2)
            goto L_0x0058
        L_0x0061:
            r0 = r17
            boolean r14 = r0 instanceof java.lang.reflect.TypeVariable
            if (r14 == 0) goto L_0x00c8
            r0 = r18
            boolean r14 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r14 == 0) goto L_0x0084
            r8 = r17
            java.lang.reflect.TypeVariable r8 = (java.lang.reflect.TypeVariable) r8
            java.lang.reflect.TypeVariable[] r6 = r19.getTypeParameters()
            r10 = r18
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            int r9 = getIndex(r6, r8)
            java.lang.reflect.Type[] r3 = r10.getActualTypeArguments()
            r17 = r3[r9]
            goto L_0x0006
        L_0x0084:
            r0 = r17
            boolean r14 = r0 instanceof java.lang.reflect.TypeVariable
            if (r14 == 0) goto L_0x00a1
            r13 = 0
        L_0x008b:
            r14 = r17
            java.lang.reflect.TypeVariable r14 = (java.lang.reflect.TypeVariable) r14
            r0 = r18
            java.lang.reflect.Type r13 = extractTypeForHierarchy(r0, r14)
            if (r13 == 0) goto L_0x009b
            boolean r14 = r13 instanceof java.lang.reflect.TypeVariable
            if (r14 != 0) goto L_0x008b
        L_0x009b:
            if (r13 == 0) goto L_0x00a1
            r17 = r13
            goto L_0x0006
        L_0x00a1:
            java.lang.UnsupportedOperationException r14 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r16 = "Expecting parameterized type, got "
            java.lang.StringBuilder r15 = r15.append(r16)
            r0 = r18
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.String r16 = ".\n Are you missing the use of TypeToken idiom?\n See "
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = "http://sites.google.com/site/gson/gson-user-guide#TOC-Serializing-and-Deserializing-Gener"
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x00c8:
            r0 = r17
            boolean r14 = r0 instanceof java.lang.reflect.WildcardType
            if (r14 == 0) goto L_0x00e3
            r5 = r17
            java.lang.reflect.WildcardType r5 = (java.lang.reflect.WildcardType) r5
            java.lang.reflect.Type[] r14 = r5.getUpperBounds()
            r15 = 0
            r14 = r14[r15]
            r0 = r18
            r1 = r19
            java.lang.reflect.Type r17 = getActualType(r14, r0, r1)
            goto L_0x0006
        L_0x00e3:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r16 = "Type '"
            java.lang.StringBuilder r15 = r15.append(r16)
            r0 = r17
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.String r16 = "' is not a Class, "
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r16 = "ParameterizedType, GenericArrayType or TypeVariable. Can't extract type."
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.TypeInfoFactory.getActualType(java.lang.reflect.Type, java.lang.reflect.Type, java.lang.Class):java.lang.reflect.Type");
    }

    private static Type extractTypeForHierarchy(Type parentType, TypeVariable<?> typeToEvaluate) {
        Class<?> rawParentType;
        Type[] actualTypeArguments;
        if (parentType instanceof Class) {
            rawParentType = (Class) parentType;
        } else if (!(parentType instanceof ParameterizedType)) {
            return null;
        } else {
            rawParentType = (Class) ((ParameterizedType) parentType).getRawType();
        }
        Type superClass = rawParentType.getGenericSuperclass();
        if ((superClass instanceof ParameterizedType) && ((ParameterizedType) superClass).getRawType() == typeToEvaluate.getGenericDeclaration()) {
            int indexOfActualTypeArgument = getIndex(((Class) ((ParameterizedType) superClass).getRawType()).getTypeParameters(), typeToEvaluate);
            if (parentType instanceof Class) {
                actualTypeArguments = ((ParameterizedType) superClass).getActualTypeArguments();
            } else if (!(parentType instanceof ParameterizedType)) {
                return null;
            } else {
                actualTypeArguments = ((ParameterizedType) parentType).getActualTypeArguments();
            }
            return actualTypeArguments[indexOfActualTypeArgument];
        } else if (superClass != null) {
            return extractTypeForHierarchy(superClass, typeToEvaluate);
        } else {
            return null;
        }
    }

    private static Type[] extractRealTypes(Type[] actualTypeArguments, Type parentType, Class<?> rawParentClass) {
        Preconditions.checkNotNull(actualTypeArguments);
        Type[] retTypes = new Type[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            retTypes[i] = getActualType(actualTypeArguments[i], parentType, rawParentClass);
        }
        return retTypes;
    }

    private static int getIndex(TypeVariable<?>[] types, TypeVariable<?> type) {
        for (int i = 0; i < types.length; i++) {
            if (type.equals(types[i])) {
                return i;
            }
        }
        throw new IllegalStateException("How can the type variable not be present in the class declaration!");
    }
}
