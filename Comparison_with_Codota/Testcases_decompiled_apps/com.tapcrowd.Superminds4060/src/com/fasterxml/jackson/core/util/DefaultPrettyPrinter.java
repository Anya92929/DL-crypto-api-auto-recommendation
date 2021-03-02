package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p003io.SerializedString;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class DefaultPrettyPrinter implements PrettyPrinter, Instantiatable<DefaultPrettyPrinter>, Serializable {
    public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    private static final long serialVersionUID = -5512586643324525213L;
    protected Indenter _arrayIndenter;
    protected transient int _nesting;
    protected Indenter _objectIndenter;
    protected final SerializableString _rootSeparator;
    protected boolean _spacesInObjectEntries;

    public interface Indenter {
        boolean isInline();

        void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException;
    }

    public DefaultPrettyPrinter() {
        this((SerializableString) DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultPrettyPrinter(String rootSeparator) {
        this((SerializableString) rootSeparator == null ? null : new SerializedString(rootSeparator));
    }

    public DefaultPrettyPrinter(SerializableString rootSeparator) {
        this._arrayIndenter = FixedSpaceIndenter.instance;
        this._objectIndenter = Lf2SpacesIndenter.instance;
        this._spacesInObjectEntries = true;
        this._nesting = 0;
        this._rootSeparator = rootSeparator;
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter base) {
        this(base, base._rootSeparator);
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter base, SerializableString rootSeparator) {
        this._arrayIndenter = FixedSpaceIndenter.instance;
        this._objectIndenter = Lf2SpacesIndenter.instance;
        this._spacesInObjectEntries = true;
        this._nesting = 0;
        this._arrayIndenter = base._arrayIndenter;
        this._objectIndenter = base._objectIndenter;
        this._spacesInObjectEntries = base._spacesInObjectEntries;
        this._nesting = base._nesting;
        this._rootSeparator = rootSeparator;
    }

    /* Debug info: failed to restart local var, previous not found, register: 1 */
    public DefaultPrettyPrinter withRootSeparator(SerializableString rootSeparator) {
        if (this._rootSeparator != rootSeparator) {
            return (rootSeparator == null || !rootSeparator.equals(this._rootSeparator)) ? new DefaultPrettyPrinter(this, rootSeparator) : this;
        }
        return this;
    }

    public void indentArraysWith(Indenter i) {
        if (i == null) {
            i = NopIndenter.instance;
        }
        this._arrayIndenter = i;
    }

    public void indentObjectsWith(Indenter i) {
        if (i == null) {
            i = NopIndenter.instance;
        }
        this._objectIndenter = i;
    }

    public void spacesInObjectEntries(boolean b) {
        this._spacesInObjectEntries = b;
    }

    public DefaultPrettyPrinter createInstance() {
        return new DefaultPrettyPrinter(this);
    }

    public void writeRootValueSeparator(JsonGenerator jg) throws IOException, JsonGenerationException {
        if (this._rootSeparator != null) {
            jg.writeRaw(this._rootSeparator);
        }
    }

    public void writeStartObject(JsonGenerator jg) throws IOException, JsonGenerationException {
        jg.writeRaw('{');
        if (!this._objectIndenter.isInline()) {
            this._nesting++;
        }
    }

    public void beforeObjectEntries(JsonGenerator jg) throws IOException, JsonGenerationException {
        this._objectIndenter.writeIndentation(jg, this._nesting);
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jg) throws IOException, JsonGenerationException {
        if (this._spacesInObjectEntries) {
            jg.writeRaw(" : ");
        } else {
            jg.writeRaw(':');
        }
    }

    public void writeObjectEntrySeparator(JsonGenerator jg) throws IOException, JsonGenerationException {
        jg.writeRaw(',');
        this._objectIndenter.writeIndentation(jg, this._nesting);
    }

    public void writeEndObject(JsonGenerator jg, int nrOfEntries) throws IOException, JsonGenerationException {
        if (!this._objectIndenter.isInline()) {
            this._nesting--;
        }
        if (nrOfEntries > 0) {
            this._objectIndenter.writeIndentation(jg, this._nesting);
        } else {
            jg.writeRaw(' ');
        }
        jg.writeRaw('}');
    }

    public void writeStartArray(JsonGenerator jg) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting++;
        }
        jg.writeRaw('[');
    }

    public void beforeArrayValues(JsonGenerator jg) throws IOException, JsonGenerationException {
        this._arrayIndenter.writeIndentation(jg, this._nesting);
    }

    public void writeArrayValueSeparator(JsonGenerator jg) throws IOException, JsonGenerationException {
        jg.writeRaw(',');
        this._arrayIndenter.writeIndentation(jg, this._nesting);
    }

    public void writeEndArray(JsonGenerator jg, int nrOfValues) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting--;
        }
        if (nrOfValues > 0) {
            this._arrayIndenter.writeIndentation(jg, this._nesting);
        } else {
            jg.writeRaw(' ');
        }
        jg.writeRaw(']');
    }

    public static class NopIndenter implements Indenter, Serializable {
        public static NopIndenter instance = new NopIndenter();
        private static final long serialVersionUID = 1;

        public void writeIndentation(JsonGenerator jg, int level) {
        }

        public boolean isInline() {
            return true;
        }
    }

    public static class FixedSpaceIndenter implements Indenter, Serializable {
        public static FixedSpaceIndenter instance = new FixedSpaceIndenter();
        private static final long serialVersionUID = 1;

        public void writeIndentation(JsonGenerator jg, int level) throws IOException, JsonGenerationException {
            jg.writeRaw(' ');
        }

        public boolean isInline() {
            return true;
        }
    }

    public static class Lf2SpacesIndenter implements Indenter, Serializable {
        static final char[] SPACES = new char[64];
        static final int SPACE_COUNT = 64;
        static final String SYSTEM_LINE_SEPARATOR;
        public static Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
        private static final long serialVersionUID = 1;

        static {
            String lf = null;
            try {
                lf = System.getProperty("line.separator");
            } catch (Throwable th) {
            }
            if (lf == null) {
                lf = "\n";
            }
            SYSTEM_LINE_SEPARATOR = lf;
            Arrays.fill(SPACES, ' ');
        }

        public boolean isInline() {
            return false;
        }

        public void writeIndentation(JsonGenerator jg, int level) throws IOException, JsonGenerationException {
            jg.writeRaw(SYSTEM_LINE_SEPARATOR);
            if (level > 0) {
                int level2 = level + level;
                while (level2 > 64) {
                    jg.writeRaw(SPACES, 0, 64);
                    level2 -= SPACES.length;
                }
                jg.writeRaw(SPACES, 0, level2);
            }
        }
    }
}
