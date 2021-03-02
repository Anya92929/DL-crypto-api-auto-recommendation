package com.radiusnetworks.ibeacon;

public class BleNotAvailableException extends RuntimeException {
    private static final long serialVersionUID = 2242747823097637729L;

    public BleNotAvailableException(String message) {
        super(message);
    }
}
