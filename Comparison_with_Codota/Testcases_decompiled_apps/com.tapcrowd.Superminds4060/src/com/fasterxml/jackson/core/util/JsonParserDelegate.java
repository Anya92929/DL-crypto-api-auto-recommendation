package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonParserDelegate extends JsonParser {
    protected JsonParser delegate;

    public JsonParserDelegate(JsonParser d) {
        this.delegate = d;
    }

    public void setCodec(ObjectCodec c) {
        this.delegate.setCodec(c);
    }

    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    public JsonParser enable(JsonParser.Feature f) {
        this.delegate.enable(f);
        return this;
    }

    public JsonParser disable(JsonParser.Feature f) {
        this.delegate.disable(f);
        return this;
    }

    public boolean isEnabled(JsonParser.Feature f) {
        return this.delegate.isEnabled(f);
    }

    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    public void setSchema(FormatSchema schema) {
        this.delegate.setSchema(schema);
    }

    public boolean canUseSchema(FormatSchema schema) {
        return this.delegate.canUseSchema(schema);
    }

    public boolean requiresCustomCodec() {
        return this.delegate.requiresCustomCodec();
    }

    public Version version() {
        return this.delegate.version();
    }

    public Object getInputSource() {
        return this.delegate.getInputSource();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    public JsonToken getCurrentToken() {
        return this.delegate.getCurrentToken();
    }

    public boolean hasCurrentToken() {
        return this.delegate.hasCurrentToken();
    }

    public String getCurrentName() throws IOException, JsonParseException {
        return this.delegate.getCurrentName();
    }

    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    public JsonStreamContext getParsingContext() {
        return this.delegate.getParsingContext();
    }

    public void clearCurrentToken() {
        this.delegate.clearCurrentToken();
    }

    public JsonToken getLastClearedToken() {
        return this.delegate.getLastClearedToken();
    }

    public void overrideCurrentName(String name) {
        this.delegate.overrideCurrentName(name);
    }

    public String getText() throws IOException, JsonParseException {
        return this.delegate.getText();
    }

    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        return this.delegate.getTextCharacters();
    }

    public int getTextLength() throws IOException, JsonParseException {
        return this.delegate.getTextLength();
    }

    public int getTextOffset() throws IOException, JsonParseException {
        return this.delegate.getTextOffset();
    }

    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        return this.delegate.getBigIntegerValue();
    }

    public boolean getBooleanValue() throws IOException, JsonParseException {
        return this.delegate.getBooleanValue();
    }

    public byte getByteValue() throws IOException, JsonParseException {
        return this.delegate.getByteValue();
    }

    public short getShortValue() throws IOException, JsonParseException {
        return this.delegate.getShortValue();
    }

    public BigDecimal getDecimalValue() throws IOException, JsonParseException {
        return this.delegate.getDecimalValue();
    }

    public double getDoubleValue() throws IOException, JsonParseException {
        return this.delegate.getDoubleValue();
    }

    public float getFloatValue() throws IOException, JsonParseException {
        return this.delegate.getFloatValue();
    }

    public int getIntValue() throws IOException, JsonParseException {
        return this.delegate.getIntValue();
    }

    public long getLongValue() throws IOException, JsonParseException {
        return this.delegate.getLongValue();
    }

    public JsonParser.NumberType getNumberType() throws IOException, JsonParseException {
        return this.delegate.getNumberType();
    }

    public Number getNumberValue() throws IOException, JsonParseException {
        return this.delegate.getNumberValue();
    }

    public int getValueAsInt() throws IOException, JsonParseException {
        return this.delegate.getValueAsInt();
    }

    public int getValueAsInt(int defaultValue) throws IOException, JsonParseException {
        return this.delegate.getValueAsInt(defaultValue);
    }

    public long getValueAsLong() throws IOException, JsonParseException {
        return this.delegate.getValueAsLong();
    }

    public long getValueAsLong(long defaultValue) throws IOException, JsonParseException {
        return this.delegate.getValueAsLong(defaultValue);
    }

    public double getValueAsDouble() throws IOException, JsonParseException {
        return this.delegate.getValueAsDouble();
    }

    public double getValueAsDouble(double defaultValue) throws IOException, JsonParseException {
        return this.delegate.getValueAsDouble(defaultValue);
    }

    public boolean getValueAsBoolean() throws IOException, JsonParseException {
        return this.delegate.getValueAsBoolean();
    }

    public boolean getValueAsBoolean(boolean defaultValue) throws IOException, JsonParseException {
        return this.delegate.getValueAsBoolean(defaultValue);
    }

    public String getValueAsString() throws IOException, JsonParseException {
        return this.delegate.getValueAsString();
    }

    public String getValueAsString(String defaultValue) throws IOException, JsonParseException {
        return this.delegate.getValueAsString(defaultValue);
    }

    public Object getEmbeddedObject() throws IOException, JsonParseException {
        return this.delegate.getEmbeddedObject();
    }

    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException, JsonParseException {
        return this.delegate.getBinaryValue(b64variant);
    }

    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException, JsonParseException {
        return this.delegate.readBinaryValue(b64variant, out);
    }

    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        return this.delegate.nextToken();
    }

    public JsonToken nextValue() throws IOException, JsonParseException {
        return this.delegate.nextValue();
    }

    public JsonParser skipChildren() throws IOException, JsonParseException {
        this.delegate.skipChildren();
        return this;
    }
}
