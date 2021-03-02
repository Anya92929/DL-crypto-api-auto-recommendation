package com.symbol.emdk.payment;

public class PromptPinMessage {
    public String messageTitle;
    public Screen1 screen1;

    public class Screen1 {
        public String message1;
        public String message2;
    }

    public PromptPinMessage() {
        throw new RuntimeException("stub");
    }
}
