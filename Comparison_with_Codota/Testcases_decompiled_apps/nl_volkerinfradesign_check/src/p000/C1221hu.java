package p000;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/* renamed from: hu */
public class C1221hu {

    /* renamed from: a */
    private final MarkerOptions f4318a = new MarkerOptions();

    /* renamed from: b */
    private final PolylineOptions f4319b = new PolylineOptions();

    /* renamed from: c */
    private final PolygonOptions f4320c = new PolygonOptions();

    /* renamed from: d */
    private final HashMap<String, String> f4321d = new HashMap<>();

    /* renamed from: e */
    private final HashSet<String> f4322e = new HashSet<>();

    /* renamed from: f */
    private boolean f4323f = true;

    /* renamed from: g */
    private boolean f4324g = true;

    /* renamed from: h */
    private String f4325h;

    /* renamed from: i */
    private double f4326i = 1.0d;

    /* renamed from: j */
    private String f4327j = null;

    /* renamed from: k */
    private boolean f4328k = false;

    /* renamed from: l */
    private boolean f4329l = false;

    /* renamed from: m */
    private boolean f4330m = false;

    /* renamed from: n */
    private float f4331n = BitmapDescriptorFactory.HUE_RED;

    C1221hu() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8337a(String str) {
        this.f4321d.put("text", str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8332a() {
        return this.f4327j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8339b(String str) {
        this.f4327j = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo8343c(String str) {
        return this.f4322e.contains(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo8341b() {
        return this.f4323f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8338a(boolean z) {
        this.f4323f = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public double mo8342c() {
        return this.f4326i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8333a(double d) {
        this.f4326i = d;
        this.f4322e.add("iconScale");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo8345d() {
        return this.f4324g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo8347e() {
        return this.f4321d.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8340b(boolean z) {
        this.f4324g = z;
        this.f4322e.add("outline");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo8348f() {
        return this.f4325h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8344d(String str) {
        this.f4325h = str;
        if (!this.f4325h.startsWith("http://")) {
            this.f4318a.icon(BitmapDescriptorFactory.fromPath(str));
        }
        this.f4322e.add("iconUrl");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo8346e(String str) {
        PolygonOptions polygonOptions = this.f4320c;
        String valueOf = String.valueOf(m5430k(str));
        polygonOptions.fillColor(Color.parseColor(valueOf.length() != 0 ? "#".concat(valueOf) : new String("#")));
        this.f4322e.add("fillColor");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo8349f(String str) {
        String valueOf = String.valueOf(m5430k(str));
        this.f4331n = m5429b(Color.parseColor(valueOf.length() != 0 ? "#".concat(valueOf) : new String("#")));
        this.f4318a.icon(BitmapDescriptorFactory.defaultMarker(this.f4331n));
        this.f4322e.add("markerColor");
    }

    /* renamed from: b */
    private static float m5429b(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[0];
    }

    /* renamed from: k */
    private static String m5430k(String str) {
        if (str.length() > 6) {
            String valueOf = String.valueOf(str.substring(0, 2));
            String valueOf2 = String.valueOf(str.substring(6, 8));
            String valueOf3 = String.valueOf(str.substring(4, 6));
            String valueOf4 = String.valueOf(str.substring(2, 4));
            return new StringBuilder(String.valueOf(valueOf).length() + 0 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length()).append(valueOf).append(valueOf2).append(valueOf3).append(valueOf4).toString();
        }
        String valueOf5 = String.valueOf(str.substring(4, 6));
        String valueOf6 = String.valueOf(str.substring(2, 4));
        String valueOf7 = String.valueOf(str.substring(0, 2));
        return new StringBuilder(String.valueOf(valueOf5).length() + 0 + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length()).append(valueOf5).append(valueOf6).append(valueOf7).toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8334a(float f) {
        this.f4318a.rotation(f);
        this.f4322e.add("heading");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8335a(float f, float f2, String str, String str2) {
        if (!str.equals("fraction")) {
            f = 0.5f;
        }
        if (!str2.equals("fraction")) {
            f2 = 1.0f;
        }
        this.f4318a.anchor(f, f2);
        this.f4322e.add("hotSpot");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo8350g(String str) {
        this.f4328k = str.equals("random");
        this.f4322e.add("iconColorMode");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo8351g() {
        return this.f4328k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo8352h(String str) {
        this.f4329l = str.equals("random");
        this.f4322e.add("lineColorMode");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo8353h() {
        return this.f4329l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo8354i(String str) {
        this.f4330m = str.equals("random");
        this.f4322e.add("polyColorMode");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo8355i() {
        return this.f4330m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo8357j(String str) {
        PolylineOptions polylineOptions = this.f4319b;
        String valueOf = String.valueOf(m5430k(str));
        polylineOptions.color(Color.parseColor(valueOf.length() != 0 ? "#".concat(valueOf) : new String("#")));
        PolygonOptions polygonOptions = this.f4320c;
        String valueOf2 = String.valueOf(str);
        polygonOptions.strokeColor(Color.parseColor(valueOf2.length() != 0 ? "#".concat(valueOf2) : new String("#")));
        this.f4322e.add("outlineColor");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8336a(Float f) {
        this.f4319b.width(f.floatValue());
        this.f4320c.strokeWidth(f.floatValue());
        this.f4322e.add("width");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public HashMap<String, String> mo8356j() {
        return this.f4321d;
    }

    /* renamed from: a */
    private static MarkerOptions m5426a(MarkerOptions markerOptions, boolean z, float f) {
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.rotation(markerOptions.getRotation());
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        if (z) {
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(m5429b(m5425a((int) f))));
        }
        markerOptions2.icon(markerOptions.getIcon());
        return markerOptions2;
    }

    /* renamed from: a */
    private static PolylineOptions m5428a(PolylineOptions polylineOptions) {
        PolylineOptions polylineOptions2 = new PolylineOptions();
        polylineOptions2.color(polylineOptions.getColor());
        polylineOptions2.width(polylineOptions.getWidth());
        return polylineOptions2;
    }

    /* renamed from: a */
    private static PolygonOptions m5427a(PolygonOptions polygonOptions, boolean z, boolean z2) {
        PolygonOptions polygonOptions2 = new PolygonOptions();
        if (z) {
            polygonOptions2.fillColor(polygonOptions.getFillColor());
        }
        if (z2) {
            polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
            polygonOptions2.strokeWidth(polygonOptions.getStrokeWidth());
        }
        return polygonOptions2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public MarkerOptions mo8358k() {
        return m5426a(this.f4318a, mo8351g(), this.f4331n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public PolylineOptions mo8359l() {
        return m5428a(this.f4319b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public PolygonOptions mo8360m() {
        return m5427a(this.f4320c, this.f4323f, this.f4324g);
    }

    /* renamed from: a */
    static int m5425a(int i) {
        Random random = new Random();
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Style").append("{");
        append.append("\n balloon options=").append(this.f4321d);
        append.append(",\n fill=").append(this.f4323f);
        append.append(",\n outline=").append(this.f4324g);
        append.append(",\n icon url=").append(this.f4325h);
        append.append(",\n scale=").append(this.f4326i);
        append.append(",\n style id=").append(this.f4327j);
        append.append("\n}\n");
        return append.toString();
    }
}
