package p006nl.volkerinfradesign.checkandroid.environments;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.AccountState */
public enum AccountState {
    NO_EMAIL {
        public boolean isPersistable() {
            return true;
        }

        public boolean isCodeRequested() {
            return false;
        }

        public boolean isLoading() {
            return false;
        }

        public boolean isVerified() {
            return false;
        }

        public boolean isFinished() {
            return false;
        }
    },
    EMAIL_APPLIED {
        public boolean isPersistable() {
            return true;
        }

        public boolean isCodeRequested() {
            return false;
        }

        public boolean isLoading() {
            return false;
        }

        public boolean isVerified() {
            return false;
        }

        public boolean isFinished() {
            return false;
        }
    },
    REQUESTING_CODE {
        public boolean isPersistable() {
            return false;
        }

        public boolean isCodeRequested() {
            return false;
        }

        public boolean isLoading() {
            return true;
        }

        public boolean isVerified() {
            return false;
        }

        public boolean isFinished() {
            return false;
        }
    },
    CODE_REQUESTED {
        public boolean isPersistable() {
            return true;
        }

        public boolean isCodeRequested() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public boolean isVerified() {
            return false;
        }

        public boolean isFinished() {
            return false;
        }
    },
    VERIFIED {
        public boolean isPersistable() {
            return true;
        }

        public boolean isCodeRequested() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public boolean isVerified() {
            return true;
        }

        public boolean isFinished() {
            return false;
        }
    },
    VERIFICATION_FAILED {
        public boolean isPersistable() {
            return true;
        }

        public boolean isCodeRequested() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public boolean isVerified() {
            return false;
        }

        public boolean isFinished() {
            return false;
        }
    },
    VERIFYING {
        public boolean isPersistable() {
            return false;
        }

        public boolean isCodeRequested() {
            return true;
        }

        public boolean isLoading() {
            return true;
        }

        public boolean isVerified() {
            return false;
        }

        public boolean isFinished() {
            return false;
        }
    },
    FINISHED {
        public boolean isPersistable() {
            return true;
        }

        public boolean isCodeRequested() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public boolean isVerified() {
            return true;
        }

        public boolean isFinished() {
            return true;
        }
    };

    public abstract boolean isCodeRequested();

    public abstract boolean isFinished();

    public abstract boolean isLoading();

    public abstract boolean isPersistable();

    public abstract boolean isVerified();
}
