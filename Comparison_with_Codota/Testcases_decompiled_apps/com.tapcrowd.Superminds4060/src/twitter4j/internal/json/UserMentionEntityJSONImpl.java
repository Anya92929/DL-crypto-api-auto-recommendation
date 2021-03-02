package twitter4j.internal.json;

import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import twitter4j.TwitterException;
import twitter4j.UserMentionEntity;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class UserMentionEntityJSONImpl extends EntityIndex implements UserMentionEntity {
    private static final long serialVersionUID = 6580431141350059702L;

    /* renamed from: id */
    private long f2169id;
    private String name;
    private String screenName;

    UserMentionEntityJSONImpl(JSONObject json) throws TwitterException {
        init(json);
    }

    UserMentionEntityJSONImpl(int start, int end, String name2, String screenName2, long id) {
        setStart(start);
        setEnd(end);
        this.name = name2;
        this.screenName = screenName2;
        this.f2169id = id;
    }

    UserMentionEntityJSONImpl() {
    }

    private void init(JSONObject json) throws TwitterException {
        try {
            JSONArray indicesArray = json.getJSONArray("indices");
            setStart(indicesArray.getInt(0));
            setEnd(indicesArray.getInt(1));
            if (!json.isNull(DBFavorites.KEY_NAME)) {
                this.name = json.getString(DBFavorites.KEY_NAME);
            }
            if (!json.isNull("screen_name")) {
                this.screenName = json.getString("screen_name");
            }
            this.f2169id = z_T4JInternalParseUtil.getLong(DBFavorites.KEY_EVENT_ID, json);
        } catch (JSONException jsone) {
            throw new TwitterException((Exception) jsone);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public long getId() {
        return this.f2169id;
    }

    public int getStart() {
        return super.getStart();
    }

    public int getEnd() {
        return super.getEnd();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserMentionEntityJSONImpl that = (UserMentionEntityJSONImpl) o;
        if (this.f2169id != that.f2169id) {
            return false;
        }
        if (this.name == null ? that.name != null : !this.name.equals(that.name)) {
            return false;
        }
        if (this.screenName != null) {
            if (this.screenName.equals(that.screenName)) {
                return true;
            }
        } else if (that.screenName == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i = 0;
        if (this.name != null) {
            result = this.name.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.screenName != null) {
            i = this.screenName.hashCode();
        }
        return ((i2 + i) * 31) + ((int) (this.f2169id ^ (this.f2169id >>> 32)));
    }

    public String toString() {
        return "UserMentionEntityJSONImpl{name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", id=" + this.f2169id + '}';
    }
}
