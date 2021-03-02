package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.MetaModel;
import java.text.DecimalFormat;

class MetaModelInitializer {
    private static final MetaModel.Formatter BOOLEAN_FORMATTER = new MetaModel.Formatter() {
        public String format(String rawValue) {
            return Utils.safeParseBoolean(rawValue) ? "1" : "0";
        }
    };
    private static final MetaModel.Formatter UP_TO_TWO_DIGIT_FLOAT_FORMATTER = new MetaModel.Formatter() {
        private final DecimalFormat mFloatFormat = new DecimalFormat("0.##");

        public String format(String rawValue) {
            return this.mFloatFormat.format(Utils.safeParseDouble(rawValue));
        }
    };

    private MetaModelInitializer() {
    }

    public static void set(MetaModel m) {
        m.addField(ModelFields.API_VERSION, "v", (String) null, (MetaModel.Formatter) null);
        m.addField("libraryVersion", "_v", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ANONYMIZE_IP, "aip", "0", BOOLEAN_FORMATTER);
        m.addField(ModelFields.TRACKING_ID, "tid", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.HIT_TYPE, "t", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.SESSION_CONTROL, "sc", (String) null, (MetaModel.Formatter) null);
        m.addField("adSenseAdMobHitId", "a", (String) null, (MetaModel.Formatter) null);
        m.addField("usage", "_u", (String) null, (MetaModel.Formatter) null);
        m.addField("title", "dt", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.REFERRER, "dr", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.LANGUAGE, "ul", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ENCODING, "de", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.PAGE, "dp", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.SCREEN_COLORS, "sd", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.SCREEN_RESOLUTION, "sr", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.VIEWPORT_SIZE, "vp", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.JAVA_ENABLED, "je", "1", BOOLEAN_FORMATTER);
        m.addField(ModelFields.FLASH_VERSION, "fl", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CLIENT_ID, "cid", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CAMPAIGN_NAME, "cn", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CAMPAIGN_SOURCE, "cs", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CAMPAIGN_MEDIUM, "cm", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CAMPAIGN_KEYWORD, "ck", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CAMPAIGN_CONTENT, "cc", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CAMPAIGN_ID, "ci", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.GCLID, ModelFields.GCLID, (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.DCLID, ModelFields.DCLID, (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.GMOB_T, ModelFields.GMOB_T, (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.EVENT_CATEGORY, "ec", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.EVENT_ACTION, "ea", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.EVENT_LABEL, "el", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.EVENT_VALUE, "ev", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.NON_INTERACTION, "ni", "0", BOOLEAN_FORMATTER);
        m.addField(ModelFields.SOCIAL_NETWORK, "sn", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.SOCIAL_ACTION, "sa", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.SOCIAL_TARGET, "st", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.APP_NAME, "an", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.APP_VERSION, "av", (String) null, (MetaModel.Formatter) null);
        m.addField("description", "cd", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.APP_ID, "aid", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.APP_INSTALLER_ID, "aiid", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TRANSACTION_ID, "ti", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TRANSACTION_AFFILIATION, "ta", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TRANSACTION_SHIPPING, "ts", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TRANSACTION_TOTAL, "tr", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TRANSACTION_TAX, "tt", (String) null, (MetaModel.Formatter) null);
        m.addField("currencyCode", "cu", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ITEM_PRICE, "ip", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ITEM_CODE, "ic", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ITEM_NAME, "in", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ITEM_CATEGORY, "iv", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.ITEM_QUANTITY, "iq", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.EX_DESCRIPTION, "exd", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.EX_FATAL, "exf", "1", BOOLEAN_FORMATTER);
        m.addField(ModelFields.TIMING_VAR, "utv", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TIMING_VALUE, "utt", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TIMING_CATEGORY, "utc", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.TIMING_LABEL, "utl", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.SAMPLE_RATE, "sf", "100", UP_TO_TWO_DIGIT_FLOAT_FORMATTER);
        m.addField("hitTime", "ht", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CUSTOM_DIMENSION, "cd", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CUSTOM_METRIC, "cm", (String) null, (MetaModel.Formatter) null);
        m.addField(ModelFields.CONTENT_GROUPING, "cg", (String) null, (MetaModel.Formatter) null);
    }
}
