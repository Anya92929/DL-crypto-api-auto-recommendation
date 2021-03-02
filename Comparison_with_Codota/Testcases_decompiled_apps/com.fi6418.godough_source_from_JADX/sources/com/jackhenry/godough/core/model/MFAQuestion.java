package com.jackhenry.godough.core.model;

public class MFAQuestion implements GoDoughType {
    private String answer;

    /* renamed from: id */
    private long f6506id;
    private String question;

    public String getAnswer() {
        return this.answer;
    }

    public long getId() {
        return this.f6506id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setId(long j) {
        this.f6506id = j;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public String toString() {
        return getQuestion();
    }
}
