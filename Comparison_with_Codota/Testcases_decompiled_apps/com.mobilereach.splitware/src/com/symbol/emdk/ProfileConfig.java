package com.symbol.emdk;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class ProfileConfig {
    public ActivitySelection activitySelection;
    public DataCapture dataCapture;
    public String modifiedDate;
    public String profileName;

    public class ActivitySelection {
        public ArrayList<ActivityElement> activities;

        public class ActivityElement {
            public String packageName;

            public ActivityElement(ActivitySelection activitySelection, String str, String... strArr) {
                throw new RuntimeException("stub");
            }
        }

        public ActivitySelection(ProfileConfig profileConfig) {
            throw new RuntimeException("stub");
        }
    }

    public class DataCapture {
        public Barcode barcode;
        public DataDelivery dataDelivery;
        public MSR msr;

        public class Barcode {
            public DecoderParams decoderParams;
            public Decoders decoders;
            public ReaderParams readerParams;
            public ScanParams scanParams;
            public DEVICETYPES scannerSelection;
            public ENABLED_STATE scanner_input_enabled;
            public UpcEanParams upcEanParams;

            public class DecoderParams {
                public Codabar codabar;
                public Code11 code11;
                public Code128 code128;
                public Code39 code39;
                public Code93 code93;
                public Composite_AB composite_AB;
                public Discrete_2of5 discrete_2of5;
                public EAN8 ean8;
                public Interleaved_2of5 interleaved_2of5;
                public Matrix_2of5 matrix_2of5;
                public MSI msi;
                public Trioptic39 trioptic39;
                public UK_Postal uk_Postal;
                public UPCA upca;
                public UPCE0 upce0;
                public UPCE1 upce1;
                public USPlanet usPlanet;
                public USPostnet usPostnet;

                public class Codabar {
                    public ENABLED_STATE clsi_editing;
                    public int length1;
                    public int length2;
                    public ENABLED_STATE notis_editing;
                    public ENABLED_STATE redundancy;
                }

                public class Code11 {
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                    public ENABLED_STATE report_check_digit;
                    public VERIFY_CHECK_DIGIT verify_check_digit;
                }

                public class Code128 {
                    public ENABLED_STATE check_isbt_table;
                    public ENABLED_STATE enable_ean128;
                    public ENABLED_STATE enable_isbt128;
                    public ENABLED_STATE enable_plain;
                    public ISBT128_CONTACT_MODE isbt128_concat_mode;
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                    public SECURITY_LEVEL security_level;
                }

                public class Code39 {
                    public ENABLED_STATE convert_to_code32;
                    public ENABLED_STATE full_ascii;
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                    public ENABLED_STATE report_check_digit;
                    public ENABLED_STATE report_code32_prefix;
                    public SECURITY_LEVEL security_level;
                    public ENABLED_STATE verify_check_digit;
                }

                public class Code93 {
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                }

                public class Composite_AB {
                    public UCC_LINK_MODE ucc_link_mode;
                }

                public class Discrete_2of5 {
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                }

                public class EAN8 {
                    public ENABLED_STATE convert_to_ean13;
                }

                public class Interleaved_2of5 {
                    public CHECK_DIGIT_TYPE check_digit;
                    public ENABLED_STATE convert_itf14_to_ean13;
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                    public ENABLED_STATE report_check_digit;
                    public SECURITY_LEVEL security_level;
                }

                public class MSI {
                    public CHECK_DIGIT check_digit;
                    public CHECK_DIGIT_SCHEME check_digit_scheme;
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                    public ENABLED_STATE report_check_digit;
                }

                public class Matrix_2of5 {
                    public int length1;
                    public int length2;
                    public ENABLED_STATE redundancy;
                    public ENABLED_STATE report_check_digit;
                    public ENABLED_STATE verify_check_digit;
                }

                public class Trioptic39 {
                    public ENABLED_STATE redundancy;
                }

                public class UK_Postal {
                    public ENABLED_STATE report_check_digit;
                }

                public class UPCA {
                    public PREAMBLE preamble;
                    public ENABLED_STATE report_check_digit;
                }

                public class UPCE0 {
                    public ENABLED_STATE convert_to_upca;
                    public PREAMBLE preamble;
                    public ENABLED_STATE report_check_digit;
                }

                public class UPCE1 {
                    public ENABLED_STATE convert_to_upca;
                    public PREAMBLE preamble;
                    public ENABLED_STATE report_check_digit;
                }

                public class USPlanet {
                    public ENABLED_STATE report_check_digit;
                }

                public class USPostnet {
                    public ENABLED_STATE report_check_digit;
                }
            }

            public class Decoders {
                public ENABLED_STATE australian_postal;
                public ENABLED_STATE aztec;
                public ENABLED_STATE canadian_postal;
                public ENABLED_STATE chinese_2of5;
                public ENABLED_STATE codabar;
                public ENABLED_STATE code11;
                public ENABLED_STATE code128;
                public ENABLED_STATE code39;
                public ENABLED_STATE code93;
                public ENABLED_STATE composite_ab;
                public ENABLED_STATE composite_c;
                public ENABLED_STATE d2of5;
                public ENABLED_STATE datamatrix;
                public ENABLED_STATE dutch_postal;
                public ENABLED_STATE ean13;
                public ENABLED_STATE ean8;
                public ENABLED_STATE gs1_databar;
                public ENABLED_STATE gs1_databar_exp;
                public ENABLED_STATE gs1_databar_lim;
                public ENABLED_STATE i2of5;
                public ENABLED_STATE japanese_postal;
                public ENABLED_STATE korean_3of5;
                public ENABLED_STATE matrix_2of5;
                public ENABLED_STATE maxicode;
                public ENABLED_STATE micropdf;
                public ENABLED_STATE microqr;
                public ENABLED_STATE msi;
                public ENABLED_STATE pdf417;
                public ENABLED_STATE qrcode;
                public ENABLED_STATE signature;
                public ENABLED_STATE tlc39;
                public ENABLED_STATE trioptic39;
                public ENABLED_STATE uk_postal;
                public ENABLED_STATE upca;
                public ENABLED_STATE upce0;
                public ENABLED_STATE upce1;
                public ENABLED_STATE us4state;
                public ENABLED_STATE us4state_fics;
                public ENABLED_STATE usplanet;
                public ENABLED_STATE uspostnet;
                public ENABLED_STATE webcode;
            }

            public class ReaderParams {
                public int beam_timer;
                public int illumination_brightness;
                public ILLUMINATION_MODE illumination_mode;
                public INVERSE_1D_MODE inverse_1d_mode;
                public LCD_MODE lcd_mode;
                public LINEAR_SECURITY_LEVEL linear_security_level;
                @Deprecated
                public int low_power_timeout;
                public PICK_LIST picklist;
                public POWER_MODE power_mode;
                public VIEWFINDER_MODE viewfinder_mode;
            }

            public class ScanParams {
                public ENABLED_STATE bt_disconnect_on_exit;
                public CODE_ID_TYPE code_id_type;
                public int connection_idle_time;
                @Deprecated
                public int datacapture_led_id;
                public String decode_audio_feedback_uri;
                public ENABLED_STATE decode_haptic_feedback;
                public ENABLED_STATE decoding_led_feedback;
                public ENABLED_STATE display_bt_address_barcode;
                public int establish_connection_time;
                public int good_decode_led_timer;
                public VOLUME_SLIDER_TYPE volume_slider_type;
            }

            public class UpcEanParams {
                public ENABLED_STATE bookland;
                public BOOKLAND_FORMAT bookland_format;
                public ENABLED_STATE coupon;
                public COUPON_REPORT coupon_report;
                public ENABLED_STATE databar_to_upc_ean;
                public ENABLED_STATE ean_zero_extend;
                public ENABLED_STATE linear_decode;
                public ENABLED_STATE random_weight_check_digit;
                public int retry_count;
                public SECURITY_LEVEL security_level;
                public ENABLED_STATE supplemental2;
                public ENABLED_STATE supplemental5;
                public SUPPLEMENTAL_MODE supplemental_mode;
            }
        }

        public class DataDelivery {
            public Intent intent;
            public Keystroke keystroke;

            public class BasicDataFormatting {
                public ENABLED_STATE bdf_enabled;
                public String bdf_prefix;
                public ENABLED_STATE bdf_send_data;
                public ENABLED_STATE bdf_send_enter;
                public ENABLED_STATE bdf_send_hex;
                public ENABLED_STATE bdf_send_tab;
                public String bdf_suffix;
            }

            public class Intent {
                public String action;
                public BasicDataFormatting basicDataFormatting;
                public String category;
                public INTENT_DELIVERY delivery;
                public ENABLED_STATE output_enabled;
            }

            public class Keystroke {
                public BasicDataFormatting basicDataFormatting;
                public ENABLED_STATE ime_output_enabled;
                public ACTION_KEY_CHAR keystroke_action_char;
            }
        }

        public class MSR {
            public ENABLED_STATE msr_input_enabled;

            public MSR(DataCapture dataCapture) {
                throw new RuntimeException("stub");
            }
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ACTION_KEY_CHAR extends Enum<ACTION_KEY_CHAR> {
        public static final ACTION_KEY_CHAR CARRIAGERETURN = null;
        public static final ACTION_KEY_CHAR DEFAULT = null;
        public static final ACTION_KEY_CHAR LINEFEED = null;
        public static final ACTION_KEY_CHAR NONE = null;
        public static final ACTION_KEY_CHAR TAB = null;

        public static ACTION_KEY_CHAR valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ACTION_KEY_CHAR[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class BOOKLAND_FORMAT extends Enum<BOOKLAND_FORMAT> {
        public static final BOOKLAND_FORMAT DEFAULT = null;
        public static final BOOKLAND_FORMAT ISBN_10 = null;
        public static final BOOKLAND_FORMAT ISBN_13 = null;

        public static BOOKLAND_FORMAT valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static BOOKLAND_FORMAT[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CHECK_DIGIT extends Enum<CHECK_DIGIT> {
        public static final CHECK_DIGIT DEFAULT = null;
        public static final CHECK_DIGIT ONE = null;
        public static final CHECK_DIGIT TWO = null;

        public static CHECK_DIGIT valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CHECK_DIGIT[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CHECK_DIGIT_SCHEME extends Enum<CHECK_DIGIT_SCHEME> {
        public static final CHECK_DIGIT_SCHEME DEFAULT = null;
        public static final CHECK_DIGIT_SCHEME MOD_10_10 = null;
        public static final CHECK_DIGIT_SCHEME MOD_11_10 = null;

        public static CHECK_DIGIT_SCHEME valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CHECK_DIGIT_SCHEME[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CHECK_DIGIT_TYPE extends Enum<CHECK_DIGIT_TYPE> {
        public static final CHECK_DIGIT_TYPE DEFAULT = null;

        /* renamed from: NO */
        public static final CHECK_DIGIT_TYPE f23NO = null;
        public static final CHECK_DIGIT_TYPE OPCC = null;
        public static final CHECK_DIGIT_TYPE USS = null;

        public static CHECK_DIGIT_TYPE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CHECK_DIGIT_TYPE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CODE_ID_TYPE extends Enum<CODE_ID_TYPE> {
        public static final CODE_ID_TYPE AIM = null;
        public static final CODE_ID_TYPE DEFAULT = null;
        public static final CODE_ID_TYPE NONE = null;
        public static final CODE_ID_TYPE SYMBOL = null;

        public static CODE_ID_TYPE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CODE_ID_TYPE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class COUPON_REPORT extends Enum<COUPON_REPORT> {
        public static final COUPON_REPORT BOTH = null;
        public static final COUPON_REPORT DEFAULT = null;
        public static final COUPON_REPORT NEW = null;
        public static final COUPON_REPORT OLD = null;

        public static COUPON_REPORT valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static COUPON_REPORT[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DEVICETYPES extends Enum<DEVICETYPES> {
        public static final DEVICETYPES AUTO = null;
        public static final DEVICETYPES INTERNAL_CAMERA1 = null;
        public static final DEVICETYPES INTERNAL_IMAGER1 = null;
        public static final DEVICETYPES INTERNAL_LASER1 = null;

        public static DEVICETYPES valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DEVICETYPES[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ENABLED_STATE extends Enum<ENABLED_STATE> {
        public static final ENABLED_STATE DEFAULT = null;
        public static final ENABLED_STATE FALSE = null;
        public static final ENABLED_STATE TRUE = null;

        public static ENABLED_STATE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ENABLED_STATE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ILLUMINATION_MODE extends Enum<ILLUMINATION_MODE> {
        public static final ILLUMINATION_MODE DEFAULT = null;
        public static final ILLUMINATION_MODE OFF = null;

        /* renamed from: ON */
        public static final ILLUMINATION_MODE f24ON = null;

        public static ILLUMINATION_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ILLUMINATION_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class INTENT_DELIVERY extends Enum<INTENT_DELIVERY> {
        public static final INTENT_DELIVERY BROADCAST_INTENT = null;
        public static final INTENT_DELIVERY DEFAULT = null;
        public static final INTENT_DELIVERY SEND_VIA_STARTACTIVITY = null;
        public static final INTENT_DELIVERY SEND_VIA_STARTSERVICE = null;

        public static INTENT_DELIVERY valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static INTENT_DELIVERY[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class INVERSE_1D_MODE extends Enum<INVERSE_1D_MODE> {
        public static final INVERSE_1D_MODE AUTO = null;
        public static final INVERSE_1D_MODE DEFAULT = null;
        public static final INVERSE_1D_MODE DISABLED = null;
        public static final INVERSE_1D_MODE ENABLED = null;

        public static INVERSE_1D_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static INVERSE_1D_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ISBT128_CONTACT_MODE extends Enum<ISBT128_CONTACT_MODE> {
        public static final ISBT128_CONTACT_MODE ALWAYS = null;
        public static final ISBT128_CONTACT_MODE AUTO = null;
        public static final ISBT128_CONTACT_MODE DEFAULT = null;
        public static final ISBT128_CONTACT_MODE NEVER = null;

        public static ISBT128_CONTACT_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ISBT128_CONTACT_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class LCD_MODE extends Enum<LCD_MODE> {
        public static final LCD_MODE DEFAULT = null;
        public static final LCD_MODE DISABLED = null;
        public static final LCD_MODE ENABLED = null;

        public static LCD_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static LCD_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class LINEAR_SECURITY_LEVEL extends Enum<LINEAR_SECURITY_LEVEL> {
        public static final LINEAR_SECURITY_LEVEL ALL_THRICE = null;
        public static final LINEAR_SECURITY_LEVEL ALL_TWICE = null;
        public static final LINEAR_SECURITY_LEVEL DEFAULT = null;
        public static final LINEAR_SECURITY_LEVEL LONG_AND_SHORT = null;
        public static final LINEAR_SECURITY_LEVEL SHORT_OR_CODABAR = null;

        public static LINEAR_SECURITY_LEVEL valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static LINEAR_SECURITY_LEVEL[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class PICK_LIST extends Enum<PICK_LIST> {
        @Deprecated
        public static final PICK_LIST CENTERED = null;
        public static final PICK_LIST DEFAULT = null;
        public static final PICK_LIST DISABLED = null;
        public static final PICK_LIST ENABLED = null;

        public static PICK_LIST valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static PICK_LIST[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class POWER_MODE extends Enum<POWER_MODE> {
        public static final POWER_MODE ALWAYS_ON = null;
        public static final POWER_MODE DEFAULT = null;
        public static final POWER_MODE HIGH = null;
        public static final POWER_MODE LOW = null;
        public static final POWER_MODE OPTIMIZED = null;

        public static POWER_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static POWER_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class PREAMBLE extends Enum<PREAMBLE> {
        public static final PREAMBLE COUNTRY_AND_SYS_CHAR = null;
        public static final PREAMBLE DEFAULT = null;
        public static final PREAMBLE NONE = null;
        public static final PREAMBLE SYS_CHAR = null;

        public static PREAMBLE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static PREAMBLE[] values() {
            throw new RuntimeException("stub");
        }
    }

    class ParserHelper {
        public String parseObjectToXML(String str, ProfileConfig profileConfig) throws TransformerException, ParserConfigurationException, IOException {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class SECURITY_LEVEL extends Enum<SECURITY_LEVEL> {
        public static final SECURITY_LEVEL DEFAULT = null;
        public static final SECURITY_LEVEL LEVEL_0 = null;
        public static final SECURITY_LEVEL LEVEL_1 = null;
        public static final SECURITY_LEVEL LEVEL_2 = null;
        public static final SECURITY_LEVEL LEVEL_3 = null;

        public static SECURITY_LEVEL valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static SECURITY_LEVEL[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class SUPPLEMENTAL_MODE extends Enum<SUPPLEMENTAL_MODE> {
        public static final SUPPLEMENTAL_MODE ALWAYS = null;
        public static final SUPPLEMENTAL_MODE AUTO = null;
        public static final SUPPLEMENTAL_MODE DEFAULT = null;

        /* renamed from: NO */
        public static final SUPPLEMENTAL_MODE f25NO = null;
        public static final SUPPLEMENTAL_MODE SMART = null;
        public static final SUPPLEMENTAL_MODE S_378_379 = null;
        public static final SUPPLEMENTAL_MODE S_414_419_434_439 = null;
        public static final SUPPLEMENTAL_MODE S_977 = null;
        public static final SUPPLEMENTAL_MODE S_978_979 = null;

        public static SUPPLEMENTAL_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static SUPPLEMENTAL_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class UCC_LINK_MODE extends Enum<UCC_LINK_MODE> {
        public static final UCC_LINK_MODE ALWAYS_LINKED = null;
        public static final UCC_LINK_MODE AUTO_DISCRIMINATE = null;
        public static final UCC_LINK_MODE DEFAULT = null;
        public static final UCC_LINK_MODE LINK_FLAG_IGNORED = null;

        public static UCC_LINK_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static UCC_LINK_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class VERIFY_CHECK_DIGIT extends Enum<VERIFY_CHECK_DIGIT> {
        public static final VERIFY_CHECK_DIGIT DEFAULT = null;

        /* renamed from: NO */
        public static final VERIFY_CHECK_DIGIT f26NO = null;
        public static final VERIFY_CHECK_DIGIT ONE = null;
        public static final VERIFY_CHECK_DIGIT TWO = null;

        public static VERIFY_CHECK_DIGIT valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static VERIFY_CHECK_DIGIT[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class VIEWFINDER_MODE extends Enum<VIEWFINDER_MODE> {
        public static final VIEWFINDER_MODE DEFAULT = null;
        public static final VIEWFINDER_MODE DISABLED = null;
        public static final VIEWFINDER_MODE ENABLED = null;
        public static final VIEWFINDER_MODE STATIC_RECTICLE = null;

        public static VIEWFINDER_MODE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static VIEWFINDER_MODE[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class VOLUME_SLIDER_TYPE extends Enum<VOLUME_SLIDER_TYPE> {
        public static final VOLUME_SLIDER_TYPE ALARM = null;
        public static final VOLUME_SLIDER_TYPE DEFAULT = null;
        public static final VOLUME_SLIDER_TYPE MUSIC_AND_MEDIA = null;
        public static final VOLUME_SLIDER_TYPE RINGER_AND_NOTIFICATIONS = null;

        public static VOLUME_SLIDER_TYPE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static VOLUME_SLIDER_TYPE[] values() {
            throw new RuntimeException("stub");
        }
    }

    public ProfileConfig() {
        throw new RuntimeException("stub");
    }
}
