package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.C0199t;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HitBuilders {

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_EVENT);
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set("&ea", action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set("&ec", category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set("&el", label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set("&ev", Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set("&exd", description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set("&exf", C0162aj.m141C(fatal));
            return this;
        }
    }

    protected static class HitBuilder<T extends HitBuilder> {

        /* renamed from: AI */
        private Map<String, String> f103AI = new HashMap();

        /* renamed from: AJ */
        ProductAction f104AJ;

        /* renamed from: AK */
        Map<String, List<Product>> f105AK = new HashMap();

        /* renamed from: AL */
        List<Promotion> f106AL = new ArrayList();

        /* renamed from: AM */
        List<Product> f107AM = new ArrayList();

        protected HitBuilder() {
        }

        public T addImpression(Product product, String impressionList) {
            if (product == null) {
                C0207z.m309W("product should be non-null");
            } else {
                if (impressionList == null) {
                    impressionList = "";
                }
                if (!this.f105AK.containsKey(impressionList)) {
                    this.f105AK.put(impressionList, new ArrayList());
                }
                this.f105AK.get(impressionList).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                C0207z.m309W("product should be non-null");
            } else {
                this.f107AM.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                C0207z.m309W("promotion should be non-null");
            } else {
                this.f106AL.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap(this.f103AI);
            if (this.f104AJ != null) {
                hashMap.putAll(this.f104AJ.build());
            }
            int i = 1;
            for (Promotion aq : this.f106AL) {
                hashMap.putAll(aq.mo3688aq(C0180n.m201A(i)));
                i++;
            }
            int i2 = 1;
            for (Product aq2 : this.f107AM) {
                hashMap.putAll(aq2.mo3663aq(C0180n.m209z(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry next : this.f105AK.entrySet()) {
                String C = C0180n.m203C(i3);
                int i4 = 1;
                for (Product aq3 : (List) next.getValue()) {
                    hashMap.putAll(aq3.mo3663aq(C + C0180n.m202B(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    hashMap.put(C + "nm", next.getKey());
                }
                i3++;
            }
            return hashMap;
        }

        /* access modifiers changed from: protected */
        public String get(String paramName) {
            return this.f103AI.get(paramName);
        }

        public final T set(String paramName, String paramValue) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.MAP_BUILDER_SET);
            if (paramName != null) {
                this.f103AI.put(paramName, paramValue);
            } else {
                C0207z.m309W(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> params) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.MAP_BUILDER_SET_ALL);
            if (params != null) {
                this.f103AI.putAll(new HashMap(params));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String utmParams) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            String ao = C0162aj.m147ao(utmParams);
            if (!TextUtils.isEmpty(ao)) {
                Map<String, String> an = C0162aj.m146an(ao);
                set("&cc", an.get("utm_content"));
                set("&cm", an.get("utm_medium"));
                set("&cn", an.get("utm_campaign"));
                set("&cs", an.get("utm_source"));
                set("&ck", an.get("utm_term"));
                set("&ci", an.get("utm_id"));
                set("&gclid", an.get("gclid"));
                set("&dclid", an.get("dclid"));
                set("&gmob_t", an.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int index, String dimension) {
            set(C0180n.m207x(index), dimension);
            return this;
        }

        public T setCustomMetric(int index, float metric) {
            set(C0180n.m208y(index), Float.toString(metric));
            return this;
        }

        /* access modifiers changed from: protected */
        public T setHitType(String hitType) {
            set("&t", hitType);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean nonInteraction) {
            set("&ni", C0162aj.m141C(nonInteraction));
            return this;
        }

        public T setProductAction(ProductAction action) {
            this.f104AJ = action;
            return this;
        }

        public T setPromotionAction(String action) {
            this.f103AI.put("&promoa", action);
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set("&iv", category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set("&in", name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set("&ip", Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set("&iq", Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set("&ic", sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_SOCIAL);
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set("&sa", action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set("&sn", network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set("&st", target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set("&utc", category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set("&utl", label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set("&utt", Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set("&utv", variable);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            C0199t.m276eq().mo3731a(C0199t.C0200a.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set("&ta", affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set("&tr", Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set("&ts", Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set("&tt", Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }
}
