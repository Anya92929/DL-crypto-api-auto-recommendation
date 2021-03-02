package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import com.myip.vpnroot.Prop;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.dj */
class C2115dj extends C2112dg {

    /* renamed from: ID */
    private static final String f4584ID = C0880a.UNIVERSAL_ANALYTICS.toString();
    private static final String arS = C0929b.ACCOUNT.toString();
    private static final String arT = C0929b.ANALYTICS_PASS_THROUGH.toString();
    private static final String arU = C0929b.ENABLE_ECOMMERCE.toString();
    private static final String arV = C0929b.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String arW = C0929b.ECOMMERCE_MACRO_DATA.toString();
    private static final String arX = C0929b.ANALYTICS_FIELDS.toString();
    private static final String arY = C0929b.TRACK_TRANSACTION.toString();
    private static final String arZ = C0929b.TRANSACTION_DATALAYER_MAP.toString();
    private static final String asa = C0929b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> asb = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
    private static Map<String, String> asc;
    private static Map<String, String> asd;
    private final DataLayer anS;
    private final Set<String> ase;
    private final C2110df asf;

    public C2115dj(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new C2110df(context));
    }

    C2115dj(Context context, DataLayer dataLayer, C2110df dfVar) {
        super(f4584ID, new String[0]);
        this.anS = dataLayer;
        this.asf = dfVar;
        this.ase = new HashSet();
        this.ase.add("");
        this.ase.add("0");
        this.ase.add("false");
    }

    /* renamed from: M */
    private Promotion m7128M(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = map.get("id");
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        String str2 = map.get("name");
        if (str2 != null) {
            promotion.setName(String.valueOf(str2));
        }
        String str3 = map.get("creative");
        if (str3 != null) {
            promotion.setCreative(String.valueOf(str3));
        }
        String str4 = map.get("position");
        if (str4 != null) {
            promotion.setPosition(String.valueOf(str4));
        }
        return promotion;
    }

    /* renamed from: N */
    private Product m7129N(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(m7142z(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.setPrice(m7141y(obj8).doubleValue());
        }
        Object obj9 = map.get("quantity");
        if (obj9 != null) {
            product.setQuantity(m7142z(obj9).intValue());
        }
        return product;
    }

    /* renamed from: O */
    private Map<String, String> m7130O(Map<String, C1026d.C1027a> map) {
        C1026d.C1027a aVar = map.get(arZ);
        if (aVar != null) {
            return m7136c(aVar);
        }
        if (asc == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            asc = hashMap;
        }
        return asc;
    }

    /* renamed from: P */
    private Map<String, String> m7131P(Map<String, C1026d.C1027a> map) {
        C1026d.C1027a aVar = map.get(asa);
        if (aVar != null) {
            return m7136c(aVar);
        }
        if (asd == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put(Prop.EXTRA_SKU, "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            asd = hashMap;
        }
        return asd;
    }

    /* renamed from: a */
    private void m7132a(Tracker tracker, Map<String, C1026d.C1027a> map) {
        String cZ = m7137cZ("transactionId");
        if (cZ == null) {
            C2028bh.m6816T("Cannot find transactionId in data layer.");
            return;
        }
        LinkedList<Map> linkedList = new LinkedList<>();
        try {
            Map<String, String> p = m7140p(map.get(arX));
            p.put("&t", "transaction");
            for (Map.Entry next : m7130O(map).entrySet()) {
                m7134b(p, (String) next.getValue(), m7137cZ((String) next.getKey()));
            }
            linkedList.add(p);
            List<Map<String, String>> da = m7138da("transactionProducts");
            if (da != null) {
                for (Map next2 : da) {
                    if (next2.get("name") == null) {
                        C2028bh.m6816T("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map<String, String> p2 = m7140p(map.get(arX));
                    p2.put("&t", "item");
                    p2.put("&ti", cZ);
                    for (Map.Entry next3 : m7131P(map).entrySet()) {
                        m7134b(p2, (String) next3.getValue(), (String) next2.get(next3.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map send : linkedList) {
                tracker.send(send);
            }
        } catch (IllegalArgumentException e) {
            C2028bh.m6820b("Unable to send transaction", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7133b(com.google.android.gms.analytics.Tracker r8, java.util.Map<java.lang.String, com.google.android.gms.internal.C1026d.C1027a> r9) {
        /*
            r7 = this;
            r1 = 0
            com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder r3 = new com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder
            r3.<init>()
            java.lang.String r0 = arX
            java.lang.Object r0 = r9.get(r0)
            com.google.android.gms.internal.d$a r0 = (com.google.android.gms.internal.C1026d.C1027a) r0
            java.util.Map r4 = r7.m7140p(r0)
            r3.setAll(r4)
            java.lang.String r0 = arV
            boolean r0 = r7.m7139f(r9, r0)
            if (r0 == 0) goto L_0x008f
            com.google.android.gms.tagmanager.DataLayer r0 = r7.anS
            java.lang.String r2 = "ecommerce"
            java.lang.Object r0 = r0.get(r2)
            boolean r2 = r0 instanceof java.util.Map
            if (r2 == 0) goto L_0x01c8
            java.util.Map r0 = (java.util.Map) r0
        L_0x002b:
            r2 = r0
        L_0x002c:
            if (r2 == 0) goto L_0x0197
            java.lang.String r0 = "&cu"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = "currencyCode"
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x0040:
            if (r0 == 0) goto L_0x0047
            java.lang.String r4 = "&cu"
            r3.set(r4, r0)
        L_0x0047:
            java.lang.String r0 = "impressions"
            java.lang.Object r0 = r2.get(r0)
            boolean r4 = r0 instanceof java.util.List
            if (r4 == 0) goto L_0x00a3
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r4 = r0.iterator()
        L_0x0057:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r0 = r4.next()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.analytics.ecommerce.Product r5 = r7.m7129N(r0)     // Catch:{ RuntimeException -> 0x0073 }
            java.lang.String r6 = "list"
            java.lang.Object r0 = r0.get(r6)     // Catch:{ RuntimeException -> 0x0073 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ RuntimeException -> 0x0073 }
            r3.addImpression(r5, r0)     // Catch:{ RuntimeException -> 0x0073 }
            goto L_0x0057
        L_0x0073:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to extract a product from DataLayer. "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.tagmanager.C2028bh.m6816T(r0)
            goto L_0x0057
        L_0x008f:
            java.lang.String r0 = arW
            java.lang.Object r0 = r9.get(r0)
            com.google.android.gms.internal.d$a r0 = (com.google.android.gms.internal.C1026d.C1027a) r0
            java.lang.Object r0 = com.google.android.gms.tagmanager.C2114di.m7111o(r0)
            boolean r2 = r0 instanceof java.util.Map
            if (r2 == 0) goto L_0x01c5
            java.util.Map r0 = (java.util.Map) r0
            r2 = r0
            goto L_0x002c
        L_0x00a3:
            java.lang.String r0 = "promoClick"
            boolean r0 = r2.containsKey(r0)
            if (r0 == 0) goto L_0x00f2
            java.lang.String r0 = "promoClick"
            java.lang.Object r0 = r2.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "promotions"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
        L_0x00bb:
            r1 = 1
            if (r0 == 0) goto L_0x017e
            java.util.Iterator r4 = r0.iterator()
        L_0x00c2:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x010b
            java.lang.Object r0 = r4.next()
            java.util.Map r0 = (java.util.Map) r0
            com.google.android.gms.analytics.ecommerce.Promotion r0 = r7.m7128M(r0)     // Catch:{ RuntimeException -> 0x00d6 }
            r3.addPromotion(r0)     // Catch:{ RuntimeException -> 0x00d6 }
            goto L_0x00c2
        L_0x00d6:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to extract a promotion from DataLayer. "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.tagmanager.C2028bh.m6816T(r0)
            goto L_0x00c2
        L_0x00f2:
            java.lang.String r0 = "promoView"
            boolean r0 = r2.containsKey(r0)
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = "promoView"
            java.lang.Object r0 = r2.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "promotions"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            goto L_0x00bb
        L_0x010b:
            java.lang.String r0 = "promoClick"
            boolean r0 = r2.containsKey(r0)
            if (r0 == 0) goto L_0x0177
            java.lang.String r0 = "&promoa"
            java.lang.String r1 = "click"
            r3.set(r0, r1)
            r0 = 0
        L_0x011b:
            if (r0 == 0) goto L_0x0197
            java.util.List<java.lang.String> r0 = asb
            java.util.Iterator r1 = r0.iterator()
        L_0x0123:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0197
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r4 = r2.containsKey(r0)
            if (r4 == 0) goto L_0x0123
            java.lang.Object r1 = r2.get(r0)
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "products"
            java.lang.Object r2 = r1.get(r2)
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r4 = r2.iterator()
        L_0x0147:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x0180
            java.lang.Object r2 = r4.next()
            java.util.Map r2 = (java.util.Map) r2
            com.google.android.gms.analytics.ecommerce.Product r2 = r7.m7129N(r2)     // Catch:{ RuntimeException -> 0x015b }
            r3.addProduct(r2)     // Catch:{ RuntimeException -> 0x015b }
            goto L_0x0147
        L_0x015b:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to extract a product from DataLayer. "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r5.append(r2)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.tagmanager.C2028bh.m6816T(r2)
            goto L_0x0147
        L_0x0177:
            java.lang.String r0 = "&promoa"
            java.lang.String r4 = "view"
            r3.set(r0, r4)
        L_0x017e:
            r0 = r1
            goto L_0x011b
        L_0x0180:
            java.lang.String r2 = "actionField"
            boolean r2 = r1.containsKey(r2)     // Catch:{ RuntimeException -> 0x01a6 }
            if (r2 == 0) goto L_0x019f
            java.lang.String r2 = "actionField"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ RuntimeException -> 0x01a6 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ RuntimeException -> 0x01a6 }
            com.google.android.gms.analytics.ecommerce.ProductAction r0 = r7.m7135c(r0, r1)     // Catch:{ RuntimeException -> 0x01a6 }
        L_0x0194:
            r3.setProductAction(r0)     // Catch:{ RuntimeException -> 0x01a6 }
        L_0x0197:
            java.util.Map r0 = r3.build()
            r8.send(r0)
            return
        L_0x019f:
            com.google.android.gms.analytics.ecommerce.ProductAction r1 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x01a6 }
            r1.<init>(r0)     // Catch:{ RuntimeException -> 0x01a6 }
            r0 = r1
            goto L_0x0194
        L_0x01a6:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to extract a product action from DataLayer. "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.tagmanager.C2028bh.m6816T(r0)
            goto L_0x0197
        L_0x01c2:
            r0 = r1
            goto L_0x00bb
        L_0x01c5:
            r2 = r1
            goto L_0x002c
        L_0x01c8:
            r0 = r1
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2115dj.m7133b(com.google.android.gms.analytics.Tracker, java.util.Map):void");
    }

    /* renamed from: b */
    private void m7134b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    /* renamed from: c */
    private ProductAction m7135c(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get("id");
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        Object obj2 = map.get("affiliation");
        if (obj2 != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj2));
        }
        Object obj3 = map.get("coupon");
        if (obj3 != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj3));
        }
        Object obj4 = map.get("list");
        if (obj4 != null) {
            productAction.setProductActionList(String.valueOf(obj4));
        }
        Object obj5 = map.get("option");
        if (obj5 != null) {
            productAction.setCheckoutOptions(String.valueOf(obj5));
        }
        Object obj6 = map.get("revenue");
        if (obj6 != null) {
            productAction.setTransactionRevenue(m7141y(obj6).doubleValue());
        }
        Object obj7 = map.get("tax");
        if (obj7 != null) {
            productAction.setTransactionTax(m7141y(obj7).doubleValue());
        }
        Object obj8 = map.get("shipping");
        if (obj8 != null) {
            productAction.setTransactionShipping(m7141y(obj8).doubleValue());
        }
        Object obj9 = map.get("step");
        if (obj9 != null) {
            productAction.setCheckoutStep(m7142z(obj9).intValue());
        }
        return productAction;
    }

    /* renamed from: c */
    private Map<String, String> m7136c(C1026d.C1027a aVar) {
        Object o = C2114di.m7111o(aVar);
        if (!(o instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) o).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    /* renamed from: cZ */
    private String m7137cZ(String str) {
        Object obj = this.anS.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* renamed from: da */
    private List<Map<String, String>> m7138da(String str) {
        Object obj = this.anS.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Object obj2 : (List) obj) {
            if (!(obj2 instanceof Map)) {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }
        return (List) obj;
    }

    /* renamed from: f */
    private boolean m7139f(Map<String, C1026d.C1027a> map, String str) {
        C1026d.C1027a aVar = map.get(str);
        if (aVar == null) {
            return false;
        }
        return C2114di.m7110n(aVar).booleanValue();
    }

    /* renamed from: p */
    private Map<String, String> m7140p(C1026d.C1027a aVar) {
        if (aVar == null) {
            return new HashMap();
        }
        Map<String, String> c = m7136c(aVar);
        if (c == null) {
            return new HashMap();
        }
        String str = c.get("&aip");
        if (str != null && this.ase.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    /* renamed from: y */
    private Double m7141y(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Double: " + e.getMessage());
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            throw new RuntimeException("Cannot convert the object to Double: " + obj.toString());
        }
    }

    /* renamed from: z */
    private Integer m7142z(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Integer: " + e.getMessage());
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            throw new RuntimeException("Cannot convert the object to Integer: " + obj.toString());
        }
    }

    /* renamed from: E */
    public void mo11732E(Map<String, C1026d.C1027a> map) {
        Tracker cR = this.asf.mo11731cR("_GTM_DEFAULT_TRACKER_");
        if (m7139f(map, arU)) {
            m7133b(cR, map);
        } else if (m7139f(map, arT)) {
            cR.send(m7140p(map.get(arX)));
        } else if (m7139f(map, arY)) {
            m7132a(cR, map);
        } else {
            C2028bh.m6819W("Ignoring unknown tag.");
        }
    }
}
