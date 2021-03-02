package p052pt.lumberapps.frases.outros;

/* renamed from: pt.lumberapps.frases.outros.e */
public class C2068e {
    /* renamed from: a */
    public static String m8360a(String str) {
        char[] cArr = {163, '@', 167, '&', '$', '%', '_', '#', 186, 170};
        char[] cArr2 = {'a', 'e', 'i', 'o', 'u', 'b', 'd', 't', 'g', 'f'};
        for (int i = 0; i < cArr2.length; i++) {
            str = str.replace(cArr[i], cArr2[i]);
        }
        return str;
    }
}
