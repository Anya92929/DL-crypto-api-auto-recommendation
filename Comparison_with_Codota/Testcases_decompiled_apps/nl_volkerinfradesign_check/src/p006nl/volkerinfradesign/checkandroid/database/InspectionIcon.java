package p006nl.volkerinfradesign.checkandroid.database;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionIcon */
public enum InspectionIcon {
    BICYCLE {
        public char getCharacter() {
            return 'b';
        }
    },
    SHIELD {
        public char getCharacter() {
            return 'd';
        }
    },
    SQUARE {
        public char getCharacter() {
            return 'g';
        }
    },
    COMPASS {
        public char getCharacter() {
            return 'k';
        }
    },
    CIRCLE {
        public char getCharacter() {
            return 'n';
        }
    },
    CROSS {
        public char getCharacter() {
            return 'r';
        }
    },
    QUESTION_MARK {
        public char getCharacter() {
            return 's';
        }
    },
    BUS {
        public char getCharacter() {
            return 'v';
        }
    },
    HOLE {
        public char getCharacter() {
            return 'w';
        }
    },
    EXIT {
        public char getCharacter() {
            return 'x';
        }
    },
    HOME {
        public char getCharacter() {
            return 'H';
        }
    },
    EYE {
        public char getCharacter() {
            return 'M';
        }
    },
    EAR {
        public char getCharacter() {
            return 'N';
        }
    },
    MEGAPHONE {
        public char getCharacter() {
            return 'V';
        }
    },
    WEB {
        public char getCharacter() {
            return '\"';
        }
    },
    SUN_GLASSES {
        public char getCharacter() {
            return '$';
        }
    },
    CUP {
        public char getCharacter() {
            return '%';
        }
    },
    MEDAL {
        public char getCharacter() {
            return '&';
        }
    },
    TEXT_BALLOON {
        public char getCharacter() {
            return ')';
        }
    };

    public abstract char getCharacter();

    public static char getCharacter(int i) {
        InspectionIcon[] values = values();
        return values[Math.abs(i) % values.length].getCharacter();
    }
}
