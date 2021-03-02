package com.forexcrunch.forexcrunch.model;

public class NewsCalDetails {

    /* renamed from: Id */
    private String f72Id;
    private String Provider;
    private String Title;
    private DateTime dateTime;
    private NewsCalendarContent newscalendarContent;

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(DateTime dateTime2) {
        this.dateTime = dateTime2;
    }

    public String getId() {
        return this.f72Id;
    }

    public void setId(String id) {
        this.f72Id = id;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getProvider() {
        return this.Provider;
    }

    public void setProvider(String provider) {
        this.Provider = provider;
    }

    public NewsCalendarContent getNewscalendarContent() {
        return this.newscalendarContent;
    }

    public void setNewscalendarContent(NewsCalendarContent newscalendarContent2) {
        this.newscalendarContent = newscalendarContent2;
    }
}
