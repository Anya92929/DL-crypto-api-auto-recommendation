package com.jackhenry.godough.core.model;

public class RDAMessage implements GoDoughType {
    public static final int ACTION_CONTINUE = 0;
    public static final int ACTION_EXIT = 1;
    private int buttonAction;
    private String message;
    private String title;

    public RDAMessage(int i, String str) {
        this.buttonAction = i;
        this.message = str;
        this.title = null;
    }

    public RDAMessage(int i, String str, String str2) {
        this.buttonAction = i;
        this.message = str;
        this.title = str2;
    }

    public int getButtonAction() {
        return this.buttonAction;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtonAction(int i) {
        this.buttonAction = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
