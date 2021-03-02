package com.forexcrunch.forexcrunch.model;

public class CalendarItem {
    public static final String CURRENT = "current";
    public static final String CUSTOM = "range";
    public static final int FILTERED_LIST = 6;
    public static final String MONHT = "month";
    public static final String NEXT_WEEK = "next_week_range";
    public static final String TODAY = "day";
    public static final String TOMORROW = "tomorrow_range";
    public static final String WEEK = "week";
    private String Actual;
    private String Consensus;
    private String DisplayActual;
    private String DisplayConsensus;
    private String DisplayPrevious;
    private String DisplayRevised;
    private String HTMLDescription;
    private String IdEcoCalendarDate;
    private String InternationalCode;
    private String Name;
    private String PotActual;
    private String PotConsensus;
    private String PotPrevious;
    private String Previous;
    private int Volatility;
    private DateTime dateTime;

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(DateTime dateTime2) {
        this.dateTime = dateTime2;
    }

    public String getIdEcoCalendarDate() {
        return this.IdEcoCalendarDate;
    }

    public void setIdEcoCalendarDate(String idEcoCalendarDate) {
        this.IdEcoCalendarDate = idEcoCalendarDate;
    }

    public String getInternationalCode() {
        return this.InternationalCode;
    }

    public void setInternationalCode(String internationalCode) {
        this.InternationalCode = internationalCode;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getVolatility() {
        return this.Volatility;
    }

    public void setVolatility(int volatility) {
        this.Volatility = volatility;
    }

    public String getDisplayActual() {
        return this.DisplayActual;
    }

    public void setDisplayActual(String displayActual) {
        this.DisplayActual = displayActual;
    }

    public String getDisplayPrevious() {
        return this.DisplayPrevious;
    }

    public void setDisplayPrevious(String displayPrevious) {
        this.DisplayPrevious = displayPrevious;
    }

    public String getDisplayConsensus() {
        return this.DisplayConsensus;
    }

    public void setDisplayConsensus(String displayConsensus) {
        this.DisplayConsensus = displayConsensus;
    }

    public String getDisplayRevised() {
        return this.DisplayRevised;
    }

    public void setDisplayRevised(String displayRevised) {
        this.DisplayRevised = displayRevised;
    }

    public String getActual() {
        return this.Actual;
    }

    public void setActual(String actual) {
        this.Actual = actual;
    }

    public String getConsensus() {
        return this.Consensus;
    }

    public void setConsensus(String consensus) {
        this.Consensus = consensus;
    }

    public String getPrevious() {
        return this.Previous;
    }

    public void setPrevious(String previous) {
        this.Previous = previous;
    }

    public String getPotActual() {
        return this.PotActual;
    }

    public void setPotActual(String potActual) {
        this.PotActual = potActual;
    }

    public String getPotConsensus() {
        return this.PotConsensus;
    }

    public void setPotConsensus(String potConsensus) {
        this.PotConsensus = potConsensus;
    }

    public String getPotPrevious() {
        return this.PotPrevious;
    }

    public void setPotPrevious(String potPrevious) {
        this.PotPrevious = potPrevious;
    }

    public String getHTMLDescription() {
        return this.HTMLDescription;
    }

    public void setHTMLDescription(String hTMLDescription) {
        this.HTMLDescription = hTMLDescription;
    }
}
