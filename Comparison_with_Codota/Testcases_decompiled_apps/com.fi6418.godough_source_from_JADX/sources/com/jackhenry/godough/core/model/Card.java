package com.jackhenry.godough.core.model;

public class Card implements GoDoughType {
    private String cardNumber;
    private String cardNumberSuffix;
    private String maskedCardNumber;
    private String primaryCardholderName;
    private String secondaryCardholderName;
    private String statusColor;
    private String statusDescription;

    public Card() {
    }

    public Card(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.cardNumber = str;
        this.cardNumberSuffix = str2;
        this.primaryCardholderName = str3;
        this.secondaryCardholderName = str4;
        this.statusDescription = str5;
        this.maskedCardNumber = str6;
        setStatusColor(str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Card card = (Card) obj;
        if (this.statusDescription == null) {
            if (card.statusDescription != null) {
                return false;
            }
        } else if (!this.statusDescription.equals(card.statusDescription)) {
            return false;
        }
        if (this.cardNumber == null) {
            if (card.cardNumber != null) {
                return false;
            }
        } else if (!this.cardNumber.equals(card.cardNumber)) {
            return false;
        }
        if (this.cardNumberSuffix == null) {
            if (card.cardNumberSuffix != null) {
                return false;
            }
        } else if (!this.cardNumberSuffix.equals(card.cardNumberSuffix)) {
            return false;
        }
        if (this.primaryCardholderName == null) {
            if (card.primaryCardholderName != null) {
                return false;
            }
        } else if (!this.primaryCardholderName.equals(card.primaryCardholderName)) {
            return false;
        }
        if (this.secondaryCardholderName == null) {
            if (card.secondaryCardholderName != null) {
                return false;
            }
        } else if (!this.secondaryCardholderName.equals(card.secondaryCardholderName)) {
            return false;
        }
        return this.statusColor == null ? card.statusColor == null : this.statusColor.equals(card.statusColor);
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getCardNumberSuffix() {
        return this.cardNumberSuffix;
    }

    public String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public String getPrimaryCardholderName() {
        return this.primaryCardholderName;
    }

    public String getSecondaryCardholderName() {
        return this.secondaryCardholderName;
    }

    public String getStatusColor() {
        return this.statusColor;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.primaryCardholderName == null ? 0 : this.primaryCardholderName.hashCode()) + (((this.cardNumberSuffix == null ? 0 : this.cardNumberSuffix.hashCode()) + (((this.cardNumber == null ? 0 : this.cardNumber.hashCode()) + (((this.statusDescription == null ? 0 : this.statusDescription.hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (this.secondaryCardholderName != null) {
            i = this.secondaryCardholderName.hashCode();
        }
        return hashCode + i;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public void setCardNumberSuffix(String str) {
        this.cardNumberSuffix = str;
    }

    public void setMaskedCardNumber(String str) {
        this.maskedCardNumber = str;
    }

    public void setPrimaryCardholderName(String str) {
        this.primaryCardholderName = str;
    }

    public void setSecondaryCardholderName(String str) {
        this.secondaryCardholderName = str;
    }

    public void setStatusColor(String str) {
        this.statusColor = str;
    }

    public void setStatusDescription(String str) {
        this.statusDescription = str;
    }
}
