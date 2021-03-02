package okhttp3;

public enum TlsVersion {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: a */
    final String f5952a;

    private TlsVersion(String str) {
        this.f5952a = str;
    }

    public static TlsVersion forJavaName(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    c = 1;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    c = 0;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    c = 3;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return TLS_1_2;
            case 1:
                return TLS_1_1;
            case 2:
                return TLS_1_0;
            case 3:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    public String javaName() {
        return this.f5952a;
    }
}
