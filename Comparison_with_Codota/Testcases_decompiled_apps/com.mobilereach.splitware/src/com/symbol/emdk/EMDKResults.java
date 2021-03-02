package com.symbol.emdk;

import org.w3c.dom.Document;

public class EMDKResults {
    public EXTENDED_STATUS_CODE extendedStatusCode;
    public STATUS_CODE statusCode;

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class EXTENDED_STATUS_CODE extends Enum<EXTENDED_STATUS_CODE> {
        public static final EXTENDED_STATUS_CODE ACTIVITY_SELECTION_MERGING_NOT_SUPPORTED = null;
        public static final EXTENDED_STATUS_CODE APP_NOT_ALLOWED_TO_SUBMIT_XML = null;
        public static final EXTENDED_STATUS_CODE DEPENDACY_COMPONENT_FAILURE = null;
        public static final EXTENDED_STATUS_CODE FEATURE_NAME_NOT_FOUND_IN_CONFIG = null;
        public static final EXTENDED_STATUS_CODE FEATURE_NAME_NOT_FOUND_IN_EXTRADATA = null;
        public static final EXTENDED_STATUS_CODE FEATURE_NOT_UNIQUE_IN_CONFIG = null;
        public static final EXTENDED_STATUS_CODE FEATURE_NOT_UNIQUE_IN_EXTRADATA = null;
        public static final EXTENDED_STATUS_CODE FEATURE_TYPE_NOT_FOUND_IN_CONFIG = null;
        public static final EXTENDED_STATUS_CODE FEATURE_TYPE_NOT_FOUND_IN_EXTRADATA = null;
        public static final EXTENDED_STATUS_CODE GENERAL_EXCEPTION_OCCURED = null;
        public static final EXTENDED_STATUS_CODE INVALID_PROFILE_CONFIGURATION = null;
        public static final EXTENDED_STATUS_CODE INVALID_VALUE = null;
        public static final EXTENDED_STATUS_CODE NAMEVALUE_MISMATCH_IN_EXTRADATA = null;
        public static final EXTENDED_STATUS_CODE NAMEVALUE_MISSMATCH_IN_CONFIG = null;
        public static final EXTENDED_STATUS_CODE NONE = null;
        public static final EXTENDED_STATUS_CODE PROFILE_NAME_FORMAT_ERROR = null;
        public static final EXTENDED_STATUS_CODE PROFILE_NOT_FOUND_IN_CONFIG = null;
        public static final EXTENDED_STATUS_CODE PROFILE_NOT_FOUND_IN_EXTRADATA = null;

        public static EXTENDED_STATUS_CODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static EXTENDED_STATUS_CODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class STATUS_CODE extends Enum<STATUS_CODE> {
        public static final STATUS_CODE CHECK_XML = null;
        public static final STATUS_CODE EMDK_NOT_OPENED = null;
        public static final STATUS_CODE EMPTY_PROFILENAME = null;
        public static final STATUS_CODE FAILURE = null;
        public static final STATUS_CODE NO_DATA_LISTENER = null;
        public static final STATUS_CODE NULL_POINTER = null;
        public static final STATUS_CODE PREVIOUS_REQUEST_IN_PROGRESS = null;
        public static final STATUS_CODE PROCESSING = null;
        public static final STATUS_CODE SUCCESS = null;
        public static final STATUS_CODE UNKNOWN = null;

        public static STATUS_CODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static STATUS_CODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    public String getExtendedStatusMessage() {
        throw new RuntimeException("stub");
    }

    public Document getStatusDocument() {
        throw new RuntimeException("stub");
    }

    public String getStatusString() {
        throw new RuntimeException("stub");
    }

    public int getSuccessFeaturesCount() {
        throw new RuntimeException("stub");
    }

    public int getTotalFeaturesCount() {
        throw new RuntimeException("stub");
    }
}
