package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.json.CoreVersion;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.p003io.CharacterEscapes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.p003io.InputDecorator;
import com.fasterxml.jackson.core.p003io.OutputDecorator;
import com.fasterxml.jackson.core.p003io.SerializedString;
import com.fasterxml.jackson.core.p003io.UTF8Writer;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.net.URL;

public class JsonFactory implements Versioned, Serializable {
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    private static final SerializableString DEFAULT_ROOT_VALUE_SEPARATOR = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    public static final String FORMAT_NAME_JSON = "JSON";
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef = new ThreadLocal<>();
    private static final long serialVersionUID = 8726401676402117450L;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected ObjectCodec _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected final transient BytesToNameCanonicalizer _rootByteSymbols;
    protected final transient CharsToNameCanonicalizer _rootCharSymbols;
    protected SerializableString _rootValueSeparator;

    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);
        
        private final boolean _defaultState;

        public static int collectDefaults() {
            int flags = 0;
            for (Feature f : values()) {
                if (f.enabledByDefault()) {
                    flags |= f.getMask();
                }
            }
            return flags;
        }

        private Feature(boolean defaultState) {
            this._defaultState = defaultState;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int flags) {
            return (getMask() & flags) != 0;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this((ObjectCodec) null);
    }

    public JsonFactory(ObjectCodec oc) {
        this._rootCharSymbols = CharsToNameCanonicalizer.createRoot();
        this._rootByteSymbols = BytesToNameCanonicalizer.createRoot();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._objectCodec = oc;
    }

    public JsonFactory copy() {
        _checkInvalidCopy(JsonFactory.class);
        return new JsonFactory((ObjectCodec) null);
    }

    /* access modifiers changed from: protected */
    public void _checkInvalidCopy(Class<?> exp) {
        if (getClass() != exp) {
            throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
        }
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new JsonFactory(this._objectCodec);
    }

    public boolean canUseSchema(FormatSchema schema) {
        String ourFormat = getFormatName();
        return ourFormat != null && ourFormat.equals(schema.getSchemaType());
    }

    public String getFormatName() {
        if (getClass() == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    public MatchStrength hasFormat(InputAccessor acc) throws IOException {
        if (getClass() == JsonFactory.class) {
            return hasJSONFormat(acc);
        }
        return null;
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    /* access modifiers changed from: protected */
    public MatchStrength hasJSONFormat(InputAccessor acc) throws IOException {
        return ByteSourceJsonBootstrapper.hasJSONFormat(acc);
    }

    public Version version() {
        return CoreVersion.instance.version();
    }

    public final JsonFactory configure(Feature f, boolean state) {
        return state ? enable(f) : disable(f);
    }

    public JsonFactory enable(Feature f) {
        this._factoryFeatures |= f.getMask();
        return this;
    }

    public JsonFactory disable(Feature f) {
        this._factoryFeatures &= f.getMask() ^ -1;
        return this;
    }

    public final boolean isEnabled(Feature f) {
        return (this._factoryFeatures & f.getMask()) != 0;
    }

    public final JsonFactory configure(JsonParser.Feature f, boolean state) {
        return state ? enable(f) : disable(f);
    }

    public JsonFactory enable(JsonParser.Feature f) {
        this._parserFeatures |= f.getMask();
        return this;
    }

    public JsonFactory disable(JsonParser.Feature f) {
        this._parserFeatures &= f.getMask() ^ -1;
        return this;
    }

    public final boolean isEnabled(JsonParser.Feature f) {
        return (this._parserFeatures & f.getMask()) != 0;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public JsonFactory setInputDecorator(InputDecorator d) {
        this._inputDecorator = d;
        return this;
    }

    public final JsonFactory configure(JsonGenerator.Feature f, boolean state) {
        return state ? enable(f) : disable(f);
    }

    public JsonFactory enable(JsonGenerator.Feature f) {
        this._generatorFeatures |= f.getMask();
        return this;
    }

    public JsonFactory disable(JsonGenerator.Feature f) {
        this._generatorFeatures &= f.getMask() ^ -1;
        return this;
    }

    public final boolean isEnabled(JsonGenerator.Feature f) {
        return (this._generatorFeatures & f.getMask()) != 0;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes esc) {
        this._characterEscapes = esc;
        return this;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    public JsonFactory setOutputDecorator(OutputDecorator d) {
        this._outputDecorator = d;
        return this;
    }

    public JsonFactory setRootValueSeparator(String sep) {
        this._rootValueSeparator = sep == null ? null : new SerializedString(sep);
        return this;
    }

    public String getRootValueSeparator() {
        if (this._rootValueSeparator == null) {
            return null;
        }
        return this._rootValueSeparator.getValue();
    }

    public JsonFactory setCodec(ObjectCodec oc) {
        this._objectCodec = oc;
        return this;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public JsonParser createParser(File f) throws IOException, JsonParseException {
        return createJsonParser(f);
    }

    public JsonParser createParser(URL url) throws IOException, JsonParseException {
        return createJsonParser(url);
    }

    public JsonParser createParser(InputStream in) throws IOException, JsonParseException {
        return createJsonParser(in);
    }

    public JsonParser createParser(Reader r) throws IOException, JsonParseException {
        return createJsonParser(r);
    }

    public JsonParser createParser(byte[] data) throws IOException, JsonParseException {
        return createJsonParser(data);
    }

    public JsonParser createParser(byte[] data, int offset, int len) throws IOException, JsonParseException {
        return createJsonParser(data, offset, len);
    }

    public JsonParser createParser(String content) throws IOException, JsonParseException {
        return createJsonParser(content);
    }

    public JsonParser createJsonParser(File f) throws IOException, JsonParseException {
        IOContext ctxt = _createContext(f, true);
        InputStream in = new FileInputStream(f);
        if (this._inputDecorator != null) {
            in = this._inputDecorator.decorate(ctxt, in);
        }
        return _createParser(in, ctxt);
    }

    public JsonParser createJsonParser(URL url) throws IOException, JsonParseException {
        IOContext ctxt = _createContext(url, true);
        InputStream in = _optimizedStreamFromURL(url);
        if (this._inputDecorator != null) {
            in = this._inputDecorator.decorate(ctxt, in);
        }
        return _createParser(in, ctxt);
    }

    public JsonParser createJsonParser(InputStream in) throws IOException, JsonParseException {
        IOContext ctxt = _createContext(in, false);
        if (this._inputDecorator != null) {
            in = this._inputDecorator.decorate(ctxt, in);
        }
        return _createParser(in, ctxt);
    }

    public JsonParser createJsonParser(Reader r) throws IOException, JsonParseException {
        IOContext ctxt = _createContext(r, false);
        if (this._inputDecorator != null) {
            r = this._inputDecorator.decorate(ctxt, r);
        }
        return _createParser(r, ctxt);
    }

    public JsonParser createJsonParser(byte[] data) throws IOException, JsonParseException {
        InputStream in;
        IOContext ctxt = _createContext(data, true);
        if (this._inputDecorator == null || (in = this._inputDecorator.decorate(ctxt, data, 0, data.length)) == null) {
            return _createParser(data, 0, data.length, ctxt);
        }
        return _createParser(in, ctxt);
    }

    public JsonParser createJsonParser(byte[] data, int offset, int len) throws IOException, JsonParseException {
        InputStream in;
        IOContext ctxt = _createContext(data, true);
        if (this._inputDecorator == null || (in = this._inputDecorator.decorate(ctxt, data, offset, len)) == null) {
            return _createParser(data, offset, len, ctxt);
        }
        return _createParser(in, ctxt);
    }

    public JsonParser createJsonParser(String content) throws IOException, JsonParseException {
        Reader r = new StringReader(content);
        IOContext ctxt = _createContext(r, true);
        if (this._inputDecorator != null) {
            r = this._inputDecorator.decorate(ctxt, r);
        }
        return _createParser(r, ctxt);
    }

    public JsonGenerator createGenerator(OutputStream out, JsonEncoding enc) throws IOException {
        return createJsonGenerator(out, enc);
    }

    public JsonGenerator createGenerator(Writer out) throws IOException {
        return createJsonGenerator(out);
    }

    public JsonGenerator createGenerator(OutputStream out) throws IOException {
        return createJsonGenerator(out);
    }

    public JsonGenerator createGenerator(File f, JsonEncoding enc) throws IOException {
        return createJsonGenerator(f, enc);
    }

    public JsonGenerator createJsonGenerator(OutputStream out, JsonEncoding enc) throws IOException {
        IOContext ctxt = _createContext(out, false);
        ctxt.setEncoding(enc);
        if (enc == JsonEncoding.UTF8) {
            if (this._outputDecorator != null) {
                out = this._outputDecorator.decorate(ctxt, out);
            }
            return _createUTF8JsonGenerator(out, ctxt);
        }
        Writer w = _createWriter(out, enc, ctxt);
        if (this._outputDecorator != null) {
            w = this._outputDecorator.decorate(ctxt, w);
        }
        return _createGenerator(w, ctxt);
    }

    public JsonGenerator createJsonGenerator(Writer out) throws IOException {
        IOContext ctxt = _createContext(out, false);
        if (this._outputDecorator != null) {
            out = this._outputDecorator.decorate(ctxt, out);
        }
        return _createGenerator(out, ctxt);
    }

    public JsonGenerator createJsonGenerator(OutputStream out) throws IOException {
        return createJsonGenerator(out, JsonEncoding.UTF8);
    }

    public JsonGenerator createJsonGenerator(File f, JsonEncoding enc) throws IOException {
        OutputStream out = new FileOutputStream(f);
        IOContext ctxt = _createContext(out, true);
        ctxt.setEncoding(enc);
        if (enc == JsonEncoding.UTF8) {
            if (this._outputDecorator != null) {
                out = this._outputDecorator.decorate(ctxt, out);
            }
            return _createUTF8JsonGenerator(out, ctxt);
        }
        Writer w = _createWriter(out, enc, ctxt);
        if (this._outputDecorator != null) {
            w = this._outputDecorator.decorate(ctxt, w);
        }
        return _createGenerator(w, ctxt);
    }

    /* access modifiers changed from: protected */
    public JsonParser _createParser(InputStream in, IOContext ctxt) throws IOException, JsonParseException {
        return _createJsonParser(in, ctxt);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JsonParser _createJsonParser(InputStream in, IOContext ctxt) throws IOException, JsonParseException {
        return new ByteSourceJsonBootstrapper(ctxt, in).constructParser(this._parserFeatures, this._objectCodec, this._rootByteSymbols, this._rootCharSymbols, isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES));
    }

    /* access modifiers changed from: protected */
    public JsonParser _createParser(Reader r, IOContext ctxt) throws IOException, JsonParseException {
        return _createJsonParser(r, ctxt);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JsonParser _createJsonParser(Reader r, IOContext ctxt) throws IOException, JsonParseException {
        return new ReaderBasedJsonParser(ctxt, this._parserFeatures, r, this._objectCodec, this._rootCharSymbols.makeChild(isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES)));
    }

    /* access modifiers changed from: protected */
    public JsonParser _createParser(byte[] data, int offset, int len, IOContext ctxt) throws IOException, JsonParseException {
        return _createJsonParser(data, offset, len, ctxt);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JsonParser _createJsonParser(byte[] data, int offset, int len, IOContext ctxt) throws IOException, JsonParseException {
        return new ByteSourceJsonBootstrapper(ctxt, data, offset, len).constructParser(this._parserFeatures, this._objectCodec, this._rootByteSymbols, this._rootCharSymbols, isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES));
    }

    /* access modifiers changed from: protected */
    public JsonGenerator _createGenerator(Writer out, IOContext ctxt) throws IOException {
        return _createJsonGenerator(out, ctxt);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JsonGenerator _createJsonGenerator(Writer out, IOContext ctxt) throws IOException {
        WriterBasedJsonGenerator gen = new WriterBasedJsonGenerator(ctxt, this._generatorFeatures, this._objectCodec, out);
        if (this._characterEscapes != null) {
            gen.setCharacterEscapes(this._characterEscapes);
        }
        SerializableString rootSep = this._rootValueSeparator;
        if (rootSep != DEFAULT_ROOT_VALUE_SEPARATOR) {
            gen.setRootValueSeparator(rootSep);
        }
        return gen;
    }

    /* access modifiers changed from: protected */
    public JsonGenerator _createUTF8Generator(OutputStream out, IOContext ctxt) throws IOException {
        return _createUTF8JsonGenerator(out, ctxt);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JsonGenerator _createUTF8JsonGenerator(OutputStream out, IOContext ctxt) throws IOException {
        UTF8JsonGenerator gen = new UTF8JsonGenerator(ctxt, this._generatorFeatures, this._objectCodec, out);
        if (this._characterEscapes != null) {
            gen.setCharacterEscapes(this._characterEscapes);
        }
        SerializableString rootSep = this._rootValueSeparator;
        if (rootSep != DEFAULT_ROOT_VALUE_SEPARATOR) {
            gen.setRootValueSeparator(rootSep);
        }
        return gen;
    }

    /* access modifiers changed from: protected */
    public Writer _createWriter(OutputStream out, JsonEncoding enc, IOContext ctxt) throws IOException {
        if (enc == JsonEncoding.UTF8) {
            return new UTF8Writer(ctxt, out);
        }
        return new OutputStreamWriter(out, enc.getJavaName());
    }

    /* access modifiers changed from: protected */
    public IOContext _createContext(Object srcRef, boolean resourceManaged) {
        return new IOContext(_getBufferRecycler(), srcRef, resourceManaged);
    }

    public BufferRecycler _getBufferRecycler() {
        SoftReference<BufferRecycler> ref = _recyclerRef.get();
        BufferRecycler br = ref == null ? null : ref.get();
        if (br != null) {
            return br;
        }
        BufferRecycler br2 = new BufferRecycler();
        _recyclerRef.set(new SoftReference(br2));
        return br2;
    }

    /* access modifiers changed from: protected */
    public InputStream _optimizedStreamFromURL(URL url) throws IOException {
        String host;
        if (!"file".equals(url.getProtocol()) || ((host = url.getHost()) != null && host.length() != 0)) {
            return url.openStream();
        }
        return new FileInputStream(url.getPath());
    }
}
