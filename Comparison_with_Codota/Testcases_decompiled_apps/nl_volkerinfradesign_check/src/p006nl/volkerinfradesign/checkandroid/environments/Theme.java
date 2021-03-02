package p006nl.volkerinfradesign.checkandroid.environments;

import p006nl.volkerinfradesign.checkandroid.C1352R;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.Theme */
public enum Theme {
    KWS_ORANGE {
        public int getMainStyle() {
            return C1352R.style.AppTheme_KWS_Orange;
        }

        public int getSplashStyle() {
            return C1352R.style.splashScreenTheme_KWS_Orange;
        }
    },
    VW_RED {
        public int getMainStyle() {
            return C1352R.style.AppTheme_VW_Red;
        }

        public int getSplashStyle() {
            return C1352R.style.splashScreenTheme_VW_Red;
        }
    },
    VWT_BLUE {
        public int getMainStyle() {
            return C1352R.style.AppTheme_Telecom_Blue;
        }

        public int getSplashStyle() {
            return C1352R.style.splashScreenTheme_Telecom_Blue;
        }
    },
    VW_BLUE {
        public int getMainStyle() {
            return C1352R.style.AppTheme_VW_Blue;
        }

        public int getSplashStyle() {
            return C1352R.style.splashScreenTheme_VW_Blue;
        }
    },
    DEFAULT {
        public int getMainStyle() {
            return C1352R.style.AppTheme_VW_Blue;
        }

        public int getSplashStyle() {
            return C1352R.style.splashScreenTheme_VW_Blue;
        }
    };

    public abstract int getMainStyle();

    public abstract int getSplashStyle();
}
