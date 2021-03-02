package com.symbol.emdk.barcode;

public class ScannerConfig {
    public DecoderParams decoderParams;
    public ReaderParams readerParams;
    public ScanParams scanParams;
    public SkipOnUnSupported skipOnUnsupported;

    class InterfaceParams {
        public int connectionEstablishTime;
        public boolean displayBluetoothAddressBarcode;
    }

    public class ScanParams {
        public AudioStreamType audioStreamType;
        public CodeIdType codeIdType;
        public String decodeAudioFeedbackUri;
        public boolean decodeHapticFeedback;
        public boolean decodeLEDFeedback;
        public int decodeLEDTime;
    }

    public class ReaderParams {
        public ReaderSpecific readerSpecific;

        public class ReaderSpecific {
            public CameraSpecific cameraSpecific;
            public ImagerSpecific imagerSpecific;
            public LaserSpecific laserSpecific;

            public class CameraSpecific {
                public int beamTimer;
                public ContinuousRead continuousRead;
                public IlluminationMode illuminationMode;
                public Inverse1DMode inverse1DMode;
                public LinearSecurityLevel linearSecurityLevel;
                public ViewFinderMode viewfinderMode;
            }

            public class ImagerSpecific {
                public int beamTimer;
                public int connectionIdleTime;
                public ContinuousRead continuousRead;
                public boolean disconnectOnExit;
                public int illuminationBrightness;
                public Inverse1DMode inverse1DMode;
                public LcdMode lcdMode;
                public LinearSecurityLevel linearSecurityLevel;
                public PickList pickList;
            }

            public class LaserSpecific {
                public int beamTimer;
                public ContinuousRead continuousRead;
                public Inverse1DMode inverse1DMode;
                public LinearSecurityLevel linearSecurityLevel;
                public PowerMode powerMode;
            }

            public class ContinuousRead {
                public int differentSymbolTimeout;
                public boolean isContinuousScan;
                public int sameSymbolTimeout;

                public ContinuousRead(ReaderSpecific readerSpecific) {
                    throw new RuntimeException("stub");
                }
            }

            public ReaderSpecific(ReaderParams readerParams) {
                throw new RuntimeException("stub");
            }
        }
    }

    public class DecoderParams {
        public AustralianPostal australianPostal;
        public Aztec aztec;
        public CanadianPostal canadianPostal;
        public Chinese2of5 chinese2of5;
        public CodaBar codaBar;
        public Code11 code11;
        public Code128 code128;
        public Code39 code39;
        public Code93 code93;
        public CompositeAB compositeAB;
        public CompositeC compositeC;
        public D2of5 d2of5;
        public DataMatrix dataMatrix;
        public DutchPostal dutchPostal;
        public Ean13 ean13;
        public Ean8 ean8;
        public Gs1Databar gs1Databar;
        public Gs1DatabarExp gs1DatabarExp;
        public Gs1DatabarLim gs1DatabarLim;
        public HanXin hanXin;
        public I2of5 i2of5;
        public JapanesePostal japanesePostal;
        public Korean3of5 korean3of5;
        public MailMark mailMark;
        public Matrix2of5 matrix2of5;
        public MaxiCode maxiCode;
        public MicroPdf microPDF;
        public MicroQr microQR;
        public Msi msi;
        public Pdf417 pdf417;
        public QrCode qrCode;
        public Signature signature;
        public Tlc39 tlc39;
        public TriOptic39 triOptic39;
        public UkPostal ukPostal;
        public UpcEanParams upcEanParams;
        public Upca upca;
        public Upce0 upce0;
        public Upce1 upce1;
        public Us4State us4State;
        public Us4StateFics us4StateFics;
        public UsPlanet usPlanet;
        public UsPostNet usPostNet;
        public WebCode webCode;

        public class AustralianPostal extends BaseDecoder {
        }

        public class Aztec extends BaseDecoder {
        }

        public class CanadianPostal extends BaseDecoder {
        }

        public class Chinese2of5 extends BaseDecoder {
        }

        public class CodaBar extends BaseDecoder {
            public boolean clsiEditing;
            public int length1;
            public int length2;
            public boolean notisEditing;
            public boolean redundancy;
        }

        public class Code11 extends BaseDecoder {
            public int length1;
            public int length2;
            public boolean redundancy;
            public boolean reportCheckDigit;
            public VerifyCheckDigit verifyCheckDigit;
        }

        public class Code128 extends BaseDecoder {
            public boolean checkIsbtTable;
            public boolean enableEan128;
            public boolean enableIsbt128;
            public boolean enablePlain;
            public Isbt128ContactMode isbt128ConcatMode;
            public int length1;
            public int length2;
            public boolean redundancy;
            public SecurityLevel securityLevel;
        }

        public class Code39 extends BaseDecoder {
            public boolean convertToCode32;
            public boolean fullAscii;
            public int length1;
            public int length2;
            public boolean redundancy;
            public boolean reportCheckDigit;
            public boolean reportCode32Prefix;
            public SecurityLevel securityLevel;
            public boolean verifyCheckDigit;
        }

        public class Code93 extends BaseDecoder {
            public int length1;
            public int length2;
            public boolean redundancy;
        }

        public class CompositeAB extends BaseDecoder {
            public UccLinkMode uccLinkMode;
        }

        public class CompositeC extends BaseDecoder {
        }

        public class D2of5 extends BaseDecoder {
            public int length1;
            public int length2;
            public boolean redundancy;
        }

        public class DataMatrix extends BaseDecoder {
        }

        public class DutchPostal extends BaseDecoder {
        }

        public class Ean13 extends BaseDecoder {
        }

        public class Ean8 extends BaseDecoder {
            public boolean convertToEan13;
        }

        public class Gs1Databar extends BaseDecoder {
        }

        public class Gs1DatabarExp extends BaseDecoder {
        }

        public class Gs1DatabarLim extends BaseDecoder {
        }

        public class HanXin extends BaseDecoder {
            public HanXinInverse hanXinInverse;
        }

        public class I2of5 extends BaseDecoder {
            public boolean convertToEan13;
            public int length1;
            public int length2;
            public boolean redundancy;
            public boolean reportCheckDigit;
            public SecurityLevel securityLevel;
            public CheckDigitType verifyCheckDigit;
        }

        public class JapanesePostal extends BaseDecoder {
        }

        public class Korean3of5 extends BaseDecoder {
        }

        public class MailMark extends BaseDecoder {
        }

        public class Matrix2of5 extends BaseDecoder {
            public int length1;
            public int length2;
            public boolean redundancy;
            public boolean reportCheckDigit;
            public boolean verifyCheckDigit;
        }

        public class MaxiCode extends BaseDecoder {
        }

        public class MicroPdf extends BaseDecoder {
        }

        public class MicroQr extends BaseDecoder {
        }

        public class Msi extends BaseDecoder {
            public CheckDigitScheme checkDigitScheme;
            public CheckDigit checkDigits;
            public int length1;
            public int length2;
            public boolean redundancy;
            public boolean reportCheckDigit;
        }

        public class Pdf417 extends BaseDecoder {
        }

        public class QrCode extends BaseDecoder {
        }

        public class Signature extends BaseDecoder {
        }

        public class Tlc39 extends BaseDecoder {
        }

        public class TriOptic39 extends BaseDecoder {
            public boolean redundancy;
        }

        public class UkPostal extends BaseDecoder {
            public boolean reportCheckDigit;
        }

        public class UpcEanParams {
            public boolean booklandCode;
            public BooklandFormat booklandFormat;
            public boolean convertDataBarToUpcEan;
            public boolean couponCode;
            public CouponReport couponReport;
            public boolean eanZeroExtend;
            @Deprecated
            public boolean linearDecode;
            public boolean randomWeightCheckDigit;
            public SecurityLevel securityLevel;
            public boolean supplemental2;
            public boolean supplemental5;
            public SupplementalMode supplementalMode;
            public int supplementalRetries;
        }

        public class Upca extends BaseDecoder {
            public Preamble preamble;
            public boolean reportCheckDigit;
        }

        public class Upce0 extends BaseDecoder {
            public boolean convertToUpca;
            public Preamble preamble;
            public boolean reportCheckDigit;
        }

        public class Upce1 extends BaseDecoder {
            public boolean convertToUpca;
            public Preamble preamble;
            public boolean reportCheckDigit;
        }

        public class Us4State extends BaseDecoder {
        }

        public class Us4StateFics extends BaseDecoder {
        }

        public class UsPlanet extends BaseDecoder {
            public boolean reportCheckDigit;
        }

        public class UsPostNet extends BaseDecoder {
            public boolean reportCheckDigit;
        }

        public class WebCode extends BaseDecoder {
            public boolean subType;
        }

        public abstract class BaseDecoder {
            public boolean enabled;

            public BaseDecoder(DecoderParams decoderParams) {
                throw new RuntimeException("stub");
            }
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class AudioStreamType extends Enum<AudioStreamType> {
        public static final AudioStreamType ALARAMS = null;
        public static final AudioStreamType MEDIA = null;
        public static final AudioStreamType RINGER = null;

        public static AudioStreamType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static AudioStreamType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class BooklandFormat extends Enum<BooklandFormat> {
        public static final BooklandFormat ISBN_10 = null;
        public static final BooklandFormat ISBN_13 = null;

        public static BooklandFormat valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static BooklandFormat[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CheckDigit extends Enum<CheckDigit> {
        public static final CheckDigit ONE = null;
        public static final CheckDigit TWO = null;

        public static CheckDigit valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CheckDigit[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CheckDigitScheme extends Enum<CheckDigitScheme> {
        public static final CheckDigitScheme MOD_10_10 = null;
        public static final CheckDigitScheme MOD_11_10 = null;

        public static CheckDigitScheme valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CheckDigitScheme[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CheckDigitType extends Enum<CheckDigitType> {

        /* renamed from: NO */
        public static final CheckDigitType f28NO = null;
        public static final CheckDigitType OPCC = null;
        public static final CheckDigitType USS = null;

        public static CheckDigitType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CheckDigitType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CodeIdType extends Enum<CodeIdType> {
        public static final CodeIdType AIM = null;
        public static final CodeIdType NONE = null;
        public static final CodeIdType SYMBOL = null;

        public static CodeIdType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CodeIdType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CouponReport extends Enum<CouponReport> {
        public static final CouponReport BOTH = null;
        public static final CouponReport NEW = null;
        public static final CouponReport OLD = null;

        public static CouponReport valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CouponReport[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class HanXinInverse extends Enum<HanXinInverse> {
        public static final HanXinInverse AUTO = null;
        public static final HanXinInverse DISABLED = null;
        public static final HanXinInverse ENABLED = null;

        public static HanXinInverse valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static HanXinInverse[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class IlluminationMode extends Enum<IlluminationMode> {
        public static final IlluminationMode OFF = null;

        /* renamed from: ON */
        public static final IlluminationMode f29ON = null;

        public static IlluminationMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static IlluminationMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class Inverse1DMode extends Enum<Inverse1DMode> {
        public static final Inverse1DMode AUTO = null;
        public static final Inverse1DMode DISABLED = null;
        public static final Inverse1DMode ENABLED = null;

        public static Inverse1DMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static Inverse1DMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class Isbt128ContactMode extends Enum<Isbt128ContactMode> {
        public static final Isbt128ContactMode ALWAYS = null;
        public static final Isbt128ContactMode AUTO = null;
        public static final Isbt128ContactMode NEVER = null;

        public static Isbt128ContactMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static Isbt128ContactMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class LcdMode extends Enum<LcdMode> {
        public static final LcdMode DISABLED = null;
        public static final LcdMode ENABLED = null;

        public static LcdMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static LcdMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class LinearSecurityLevel extends Enum<LinearSecurityLevel> {
        public static final LinearSecurityLevel ALL_THRICE = null;
        public static final LinearSecurityLevel ALL_TWICE = null;
        public static final LinearSecurityLevel LONG_AND_SHORT = null;
        public static final LinearSecurityLevel SHORT_OR_CODABAR = null;

        public static LinearSecurityLevel valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static LinearSecurityLevel[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class PickList extends Enum<PickList> {
        public static final PickList DISABLED = null;
        public static final PickList ENABLED = null;

        public static PickList valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static PickList[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class PowerMode extends Enum<PowerMode> {
        public static final PowerMode ALWAYS_ON = null;
        public static final PowerMode HIGH = null;
        public static final PowerMode LOW = null;
        public static final PowerMode OPTIMIZED = null;

        public static PowerMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static PowerMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class Preamble extends Enum<Preamble> {
        public static final Preamble COUNTRY_AND_SYS_CHAR = null;
        public static final Preamble NONE = null;
        public static final Preamble SYS_CHAR = null;

        public static Preamble valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static Preamble[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class SecurityLevel extends Enum<SecurityLevel> {
        public static final SecurityLevel LEVEL_0 = null;
        public static final SecurityLevel LEVEL_1 = null;
        public static final SecurityLevel LEVEL_2 = null;
        public static final SecurityLevel LEVEL_3 = null;

        public static SecurityLevel valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static SecurityLevel[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class SkipOnUnSupported extends Enum<SkipOnUnSupported> {
        public static final SkipOnUnSupported ALL = null;
        public static final SkipOnUnSupported NONE = null;
        public static final SkipOnUnSupported UNSUPPORTED_PARAM = null;
        public static final SkipOnUnSupported UNSUPPORTED_VALUE = null;

        public static SkipOnUnSupported valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static SkipOnUnSupported[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class SupplementalMode extends Enum<SupplementalMode> {
        public static final SupplementalMode ALWAYS = null;
        public static final SupplementalMode AUTO = null;

        /* renamed from: NO */
        public static final SupplementalMode f30NO = null;
        public static final SupplementalMode SMART = null;
        public static final SupplementalMode S_378_379 = null;
        public static final SupplementalMode S_414_419_434_439 = null;
        public static final SupplementalMode S_977 = null;
        public static final SupplementalMode S_978_979 = null;

        public static SupplementalMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static SupplementalMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class UccLinkMode extends Enum<UccLinkMode> {
        public static final UccLinkMode ALWAYS_LINKED = null;
        public static final UccLinkMode AUTO_DISCRIMINATE = null;
        public static final UccLinkMode LINK_FLAG_IGNORED = null;

        public static UccLinkMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static UccLinkMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class VerifyCheckDigit extends Enum<VerifyCheckDigit> {

        /* renamed from: NO */
        public static final VerifyCheckDigit f31NO = null;
        public static final VerifyCheckDigit ONE = null;
        public static final VerifyCheckDigit TWO = null;

        public static VerifyCheckDigit valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static VerifyCheckDigit[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ViewFinderMode extends Enum<ViewFinderMode> {
        public static final ViewFinderMode ENABLED = null;
        public static final ViewFinderMode STATIC_RECTICLE = null;

        public static ViewFinderMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ViewFinderMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    public boolean isParamSupported(String str) {
        throw new RuntimeException("stub");
    }

    public void resetToDefault(Scanner scanner) throws ScannerException {
        throw new RuntimeException("stub");
    }
}
