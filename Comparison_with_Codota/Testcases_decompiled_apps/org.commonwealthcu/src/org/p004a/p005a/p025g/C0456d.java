package org.p004a.p005a.p025g;

import android.support.p003v7.appcompat.C0137R;
import org.p004a.p005a.C0242ad;

/* renamed from: org.a.a.g.d */
public final class C0456d implements C0242ad {

    /* renamed from: a */
    public static final C0456d f452a = new C0456d();

    /* renamed from: b */
    private static final String[][] f453b = {null, new String[3], new String[8], new String[8], new String[25], new String[8]};

    static {
        m817a(200, "OK");
        m817a(201, "Created");
        m817a(202, "Accepted");
        m817a(204, "No Content");
        m817a(301, "Moved Permanently");
        m817a(302, "Moved Temporarily");
        m817a(304, "Not Modified");
        m817a(400, "Bad Request");
        m817a(401, "Unauthorized");
        m817a(403, "Forbidden");
        m817a(404, "Not Found");
        m817a(500, "Internal Server Error");
        m817a(501, "Not Implemented");
        m817a(502, "Bad Gateway");
        m817a(503, "Service Unavailable");
        m817a(100, "Continue");
        m817a(307, "Temporary Redirect");
        m817a(405, "Method Not Allowed");
        m817a(409, "Conflict");
        m817a(412, "Precondition Failed");
        m817a(413, "Request Too Long");
        m817a(414, "Request-URI Too Long");
        m817a(415, "Unsupported Media Type");
        m817a(300, "Multiple Choices");
        m817a(303, "See Other");
        m817a(305, "Use Proxy");
        m817a(402, "Payment Required");
        m817a(406, "Not Acceptable");
        m817a(407, "Proxy Authentication Required");
        m817a(408, "Request Timeout");
        m817a(C0137R.styleable.Theme_checkedTextViewStyle, "Switching Protocols");
        m817a(203, "Non Authoritative Information");
        m817a(205, "Reset Content");
        m817a(206, "Partial Content");
        m817a(504, "Gateway Timeout");
        m817a(505, "Http Version Not Supported");
        m817a(410, "Gone");
        m817a(411, "Length Required");
        m817a(416, "Requested Range Not Satisfiable");
        m817a(417, "Expectation Failed");
        m817a(C0137R.styleable.Theme_editTextStyle, "Processing");
        m817a(207, "Multi-Status");
        m817a(422, "Unprocessable Entity");
        m817a(419, "Insufficient Space On Resource");
        m817a(420, "Method Failure");
        m817a(423, "Locked");
        m817a(507, "Insufficient Storage");
        m817a(424, "Failed Dependency");
    }

    protected C0456d() {
    }

    /* renamed from: a */
    private static void m817a(int i, String str) {
        int i2 = i / 100;
        f453b[i2][i - (i2 * 100)] = str;
    }
}
