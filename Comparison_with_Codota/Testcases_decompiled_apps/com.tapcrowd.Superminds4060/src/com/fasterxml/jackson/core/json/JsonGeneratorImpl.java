package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.CharacterEscapes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class JsonGeneratorImpl extends GeneratorBase {
    protected static final int[] sOutputEscapes = CharTypes.get7BitOutputEscapes();
    protected CharacterEscapes _characterEscapes;
    protected final IOContext _ioContext;
    protected int _maximumNonEscapedChar;
    protected int[] _outputEscapes = sOutputEscapes;
    protected SerializableString _rootValueSeparator = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;

    public JsonGeneratorImpl(IOContext ctxt, int features, ObjectCodec codec) {
        super(features, codec);
        this._ioContext = ctxt;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    public JsonGenerator setHighestNonEscapedChar(int charCode) {
        if (charCode < 0) {
            charCode = 0;
        }
        this._maximumNonEscapedChar = charCode;
        return this;
    }

    public int getHighestEscapedChar() {
        return this._maximumNonEscapedChar;
    }

    public JsonGenerator setCharacterEscapes(CharacterEscapes esc) {
        this._characterEscapes = esc;
        if (esc == null) {
            this._outputEscapes = sOutputEscapes;
        } else {
            this._outputEscapes = esc.getEscapeCodesForAscii();
        }
        return this;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public JsonGenerator setRootValueSeparator(SerializableString sep) {
        this._rootValueSeparator = sep;
        return this;
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public final void writeStringField(String fieldName, String value) throws IOException, JsonGenerationException {
        writeFieldName(fieldName);
        writeString(value);
    }
}
