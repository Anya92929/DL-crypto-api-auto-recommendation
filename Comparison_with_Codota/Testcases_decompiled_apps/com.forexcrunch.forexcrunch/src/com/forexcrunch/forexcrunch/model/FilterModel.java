package com.forexcrunch.forexcrunch.model;

public class FilterModel {
    private String categories;
    private String countries;
    private String endDate;
    private String endDateOriginal;
    private String startDate;
    private String startDateOriginal;
    private int volatility;

    public FilterModel(String categories2, String countries2, String startDate2, String endDate2, int volatility2) {
        this.categories = categories2;
        this.countries = countries2;
        this.startDate = startDate2;
        this.endDate = endDate2;
        this.volatility = volatility2;
    }

    public String getStartDateOriginal() {
        return this.startDateOriginal;
    }

    public void setStartDateOriginal(String startDateOriginal2) {
        this.startDateOriginal = startDateOriginal2;
    }

    public String getEndDateOriginal() {
        return this.endDateOriginal;
    }

    public void setEndDateOriginal(String endDateOriginal2) {
        this.endDateOriginal = endDateOriginal2;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(String categories2) {
        this.categories = categories2;
    }

    public String getCountries() {
        return this.countries;
    }

    public void setCountries(String countries2) {
        this.countries = countries2;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate2) {
        this.startDate = startDate2;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate2) {
        this.endDate = endDate2;
    }

    public int getVolatility() {
        return this.volatility;
    }

    public void setVolatility(int volatility2) {
        this.volatility = volatility2;
    }

    public static String formatStringForRequest(String date) {
        if (date == null || date.equals("")) {
            return "";
        }
        String[] splitted = date.split("-");
        return String.valueOf(splitted[2]) + splitted[0] + splitted[1];
    }
}
