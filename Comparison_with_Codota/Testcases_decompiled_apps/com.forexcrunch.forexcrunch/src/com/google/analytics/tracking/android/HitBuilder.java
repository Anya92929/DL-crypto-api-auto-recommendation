package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.MetaModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

class HitBuilder {
    HitBuilder() {
    }

    static Map<String, String> generateHitParams(MetaModel metaModel, Map<String, String> hit) {
        String urlParam;
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, String> entry : hit.entrySet()) {
            MetaModel.MetaInfo metaInfo = metaModel.getMetaInfo(entry.getKey());
            if (!(metaInfo == null || (urlParam = metaInfo.getUrlParam(entry.getKey())) == null)) {
                String value = entry.getValue();
                if (metaInfo.getFormatter() != null) {
                    value = metaInfo.getFormatter().format(value);
                }
                if (value != null && !value.equals(metaInfo.getDefaultValue())) {
                    params.put(urlParam, value);
                }
            }
        }
        return params;
    }

    static String postProcessHit(Hit hit, long currentTimeMillis) {
        StringBuilder builder = new StringBuilder();
        builder.append(hit.getHitParams());
        if (hit.getHitTime() > 0) {
            long queueTime = currentTimeMillis - hit.getHitTime();
            if (queueTime >= 0) {
                builder.append("&").append(ModelFields.QUEUE_TIME).append("=").append(queueTime);
            }
        }
        builder.append("&").append(ModelFields.CACHE_BUSTER).append("=").append(hit.getHitId());
        return builder.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }
}
