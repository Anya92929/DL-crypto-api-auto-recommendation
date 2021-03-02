package com.forexcrunch.forexcrunch.model;

public class DateTime {
    private String Date;
    private String DateStr;
    private int Day;
    private int Hour;
    private long Miliseconds;
    private int Minute;
    private int Month;
    private int Second;
    private int Year;

    public String getDate() {
        return this.Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getDateStr() {
        return this.DateStr;
    }

    public void setDateStr(String dateStr) {
        this.DateStr = dateStr;
    }

    public int getYear() {
        return this.Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public int getMonth() {
        return this.Month;
    }

    public void setMonth(int month) {
        this.Month = month;
    }

    public int getDay() {
        return this.Day;
    }

    public void setDay(int day) {
        this.Day = day;
    }

    public int getHour() {
        return this.Hour;
    }

    public void setHour(int hour) {
        this.Hour = hour;
    }

    public int getMinute() {
        return this.Minute;
    }

    public void setMinute(int minute) {
        this.Minute = minute;
    }

    public int getSecond() {
        return this.Second;
    }

    public void setSecond(int second) {
        this.Second = second;
    }

    public long getMiliseconds() {
        return this.Miliseconds;
    }

    public void setMiliseconds(long miliseconds) {
        this.Miliseconds = miliseconds;
    }

    public String getFormattedString() {
        String month;
        String day;
        if (this.Month <= 9) {
            month = "0" + this.Month;
        } else {
            month = new StringBuilder().append(this.Month).toString();
        }
        if (this.Day <= 9) {
            day = "0" + this.Day;
        } else {
            day = new StringBuilder().append(this.Day).toString();
        }
        return String.valueOf(this.Year) + "-" + month + "-" + day;
    }
}
