package com.forexcrunch.forexcrunch.model;

public class HistTableModel {
    private float Actual;
    private String DisplayActual;
    private String DisplayConsensus;
    private String DisplayPrevious;
    private String ForType;
    private String PotActual;
    private String PotConsensus;
    private String PotPrevious;
    private boolean Preliminar;
    private float Previous;
    private String Unit;
    private DateTime dateTime;
    private DateTime forDateTime;

    public DateTime getForDateTime() {
        return this.forDateTime;
    }

    public void setForDateTime(DateTime forDateTime2) {
        this.forDateTime = forDateTime2;
    }

    public String getForType() {
        return this.ForType;
    }

    public void setForType(String forType) {
        this.ForType = forType;
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

    public float getActual() {
        return this.Actual;
    }

    public void setActual(float actual) {
        this.Actual = actual;
    }

    public float getPrevious() {
        return this.Previous;
    }

    public void setPrevious(float previous) {
        this.Previous = previous;
    }

    public String getUnit() {
        return this.Unit;
    }

    public void setUnit(String unit) {
        this.Unit = unit;
    }

    public boolean isPreliminar() {
        return this.Preliminar;
    }

    public void setPreliminar(boolean preliminar) {
        this.Preliminar = preliminar;
    }

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(DateTime dateTime2) {
        this.dateTime = dateTime2;
    }
}
