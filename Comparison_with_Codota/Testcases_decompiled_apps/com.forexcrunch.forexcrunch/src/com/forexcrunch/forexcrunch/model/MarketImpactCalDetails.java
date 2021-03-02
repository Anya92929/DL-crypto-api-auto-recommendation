package com.forexcrunch.forexcrunch.model;

public class MarketImpactCalDetails {
    public static final String AUD_CAPTION = "AUD";
    public static final String AUD_INSTRUMENT = "AUD_CAD,AUD_JPY,AUD_NZD,AUD_USD,CHF_AUD,EUR_AUD,GBP_AUD";
    public static final String CAD_CAPTION = "CAD";
    public static final String CAD_INSTRUMENT = "AUD_CAD,CAD_JPY,EUR_CAD,GBP_CAD,USD_CAD";
    public static final String CHF_CAPTION = "CHF";
    public static final String CHF_INSTRUMENT = "CHF_AUD,CHF_JPY,EUR_CHF,GBP_CHF,USD_CHF";
    public static final String EUR_CAPTION = "EUR";
    public static final String EUR_INSTRUMENT = "EUR_AUD,EUR_CAD,EUR_CHF,EUR_GBP,EUR_JPY,EUR_USD";
    public static final String GBP_CAPTION = "GBP";
    public static final String GBP_INSTRUMENT = "EUR_GBP,GBP_AUD,GBP_CAD,GBP_CHF,GBP_JPY,GBP_USD";
    public static final String JPY_CAPTION = "JPY";
    public static final String JPY_INSTRUMENT = "AUD_JPY,CAD_JPY,CHF_JPY,EUR_JPY,GBP_JPY,NZD_JPY,USD_JPY";
    public static final String NZD_CAPTION = "NZD";
    public static final String NZD_INSTRUMENT = "AUD_NZD,NZD_JPY,NZD_USD";
    public static final String USD_CAPTION = "USD";
    public static final String USD_INSTRUMENT = "AUD_USD,EUR_USD,GBP_USD,NZD_USD,USD_CAD,USD_CHF,USD_JPY";
    private String IdEventDate;
    private String URLChart;
    private String URLRadar;
    private DateTime dateTime;

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(DateTime dateTime2) {
        this.dateTime = dateTime2;
    }

    public String getIdEventDate() {
        return this.IdEventDate;
    }

    public void setIdEventDate(String idEventDate) {
        this.IdEventDate = idEventDate;
    }

    public String getURLChart() {
        return this.URLChart;
    }

    public void setURLChart(String uRLChart) {
        this.URLChart = uRLChart;
    }

    public String getURLRadar() {
        return this.URLRadar;
    }

    public void setURLRadar(String uRLRadar) {
        this.URLRadar = uRLRadar;
    }
}
