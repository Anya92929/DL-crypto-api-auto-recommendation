package com.jackhenry.godough.core.model;

public class Redirect implements GoDoughType {
    private static final long serialVersionUID = 1;
    private RedirectType redirect;

    public enum RedirectType {
        HOME,
        MFA,
        SELFENROLLMENT,
        TERMSANDCONDITIONS,
        P2P,
        OFFLINE,
        EMAILCHANGE,
        CREDENTIALS,
        USERSETTINGS,
        RDATERMSANDCONDITIONS,
        RDACOLLECTTERMSANDCONDITIONS,
        RDAREGISTRATION;

        public static RedirectType getEnum(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException e) {
                return HOME;
            }
        }
    }

    public Redirect() {
    }

    public Redirect(RedirectType redirectType) {
        this.redirect = redirectType;
    }

    public RedirectType getRedirect() {
        return this.redirect;
    }

    public void setRedirect(RedirectType redirectType) {
        this.redirect = redirectType;
    }
}
