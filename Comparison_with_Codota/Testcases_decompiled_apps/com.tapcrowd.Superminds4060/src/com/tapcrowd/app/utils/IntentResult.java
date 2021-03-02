package com.tapcrowd.app.utils;

public final class IntentResult {
    private final String contents;
    private final String formatName;

    IntentResult(String contents2, String formatName2) {
        this.contents = contents2;
        this.formatName = formatName2;
    }

    public String getContents() {
        return this.contents;
    }

    public String getFormatName() {
        return this.formatName;
    }
}
