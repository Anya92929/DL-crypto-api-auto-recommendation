package p000;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: hj */
public final class C1205hj implements JsonDeserializer<Date>, JsonSerializer<Date> {

    /* renamed from: a */
    private final DateFormat f4266a;

    /* renamed from: b */
    private final DateFormat f4267b;

    /* renamed from: c */
    private final DateFormat f4268c;

    C1205hj() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public C1205hj(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    public C1205hj(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    C1205hj(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f4266a = dateFormat;
        this.f4267b = dateFormat2;
        this.f4268c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f4268c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: a */
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonPrimitive jsonPrimitive;
        synchronized (this.f4267b) {
            jsonPrimitive = new JsonPrimitive(this.f4266a.format(date));
        }
        return jsonPrimitive;
    }

    /* renamed from: a */
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!(jsonElement instanceof JsonPrimitive)) {
            throw new JsonParseException("The date should be a string value");
        }
        Date a = m5280a(jsonElement);
        if (type == Date.class) {
            return a;
        }
        if (type == Timestamp.class) {
            return new Timestamp(a.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(a.getTime());
        }
        throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
    }

    /* renamed from: a */
    private Date m5280a(JsonElement jsonElement) {
        Date parse;
        synchronized (this.f4267b) {
            try {
                parse = this.f4267b.parse(jsonElement.getAsString());
            } catch (ParseException e) {
                throw new JsonSyntaxException(jsonElement.getAsString(), e);
            } catch (ParseException e2) {
                try {
                    parse = this.f4266a.parse(jsonElement.getAsString());
                } catch (ParseException e3) {
                    parse = this.f4268c.parse(jsonElement.getAsString());
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C1205hj.class.getSimpleName());
        sb.append('(').append(this.f4267b.getClass().getSimpleName()).append(')');
        return sb.toString();
    }
}
