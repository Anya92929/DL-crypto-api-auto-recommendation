package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;
import twitter4j.internal.http.HttpParameter;

public final class GeoQuery implements Serializable {
    private static final long serialVersionUID = 927081526936169802L;
    private String accuracy = null;
    private String granularity = null;

    /* renamed from: ip */
    private String f2154ip = null;
    private GeoLocation location;
    private int maxResults = -1;
    private String query = null;

    public GeoQuery(GeoLocation location2) {
        this.location = location2;
    }

    public GeoQuery(String ip) {
        this.f2154ip = ip;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query2) {
        this.query = query2;
    }

    public String getIp() {
        return this.f2154ip;
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(String accuracy2) {
        this.accuracy = accuracy2;
    }

    public GeoQuery accuracy(String accuracy2) {
        setAccuracy(accuracy2);
        return this;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public void setGranularity(String granularity2) {
        this.granularity = granularity2;
    }

    public GeoQuery granularity(String granularity2) {
        setGranularity(granularity2);
        return this;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(int maxResults2) {
        this.maxResults = maxResults2;
    }

    public GeoQuery maxResults(int maxResults2) {
        setMaxResults(maxResults2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public HttpParameter[] asHttpParameterArray() {
        ArrayList<HttpParameter> params = new ArrayList<>();
        if (this.location != null) {
            appendParameter("lat", this.location.getLatitude(), (List<HttpParameter>) params);
            appendParameter(Globalization.LONG, this.location.getLongitude(), (List<HttpParameter>) params);
        }
        if (this.f2154ip != null) {
            appendParameter("ip", this.f2154ip, (List<HttpParameter>) params);
        }
        appendParameter("accuracy", this.accuracy, (List<HttpParameter>) params);
        appendParameter("query", this.query, (List<HttpParameter>) params);
        appendParameter("granularity", this.granularity, (List<HttpParameter>) params);
        appendParameter("max_results", this.maxResults, (List<HttpParameter>) params);
        return (HttpParameter[]) params.toArray(new HttpParameter[params.size()]);
    }

    private void appendParameter(String name, String value, List<HttpParameter> params) {
        if (value != null) {
            params.add(new HttpParameter(name, value));
        }
    }

    private void appendParameter(String name, int value, List<HttpParameter> params) {
        if (value > 0) {
            params.add(new HttpParameter(name, String.valueOf(value)));
        }
    }

    private void appendParameter(String name, double value, List<HttpParameter> params) {
        params.add(new HttpParameter(name, String.valueOf(value)));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GeoQuery geoQuery = (GeoQuery) o;
        if (this.maxResults != geoQuery.maxResults) {
            return false;
        }
        if (this.accuracy == null ? geoQuery.accuracy != null : !this.accuracy.equals(geoQuery.accuracy)) {
            return false;
        }
        if (this.granularity == null ? geoQuery.granularity != null : !this.granularity.equals(geoQuery.granularity)) {
            return false;
        }
        if (this.f2154ip == null ? geoQuery.f2154ip != null : !this.f2154ip.equals(geoQuery.f2154ip)) {
            return false;
        }
        if (this.location != null) {
            if (this.location.equals(geoQuery.location)) {
                return true;
            }
        } else if (geoQuery.location == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i;
        int i2;
        int i3 = 0;
        if (this.location != null) {
            result = this.location.hashCode();
        } else {
            result = 0;
        }
        int i4 = result * 31;
        if (this.f2154ip != null) {
            i = this.f2154ip.hashCode();
        } else {
            i = 0;
        }
        int i5 = (i4 + i) * 31;
        if (this.accuracy != null) {
            i2 = this.accuracy.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        if (this.granularity != null) {
            i3 = this.granularity.hashCode();
        }
        return ((i6 + i3) * 31) + this.maxResults;
    }

    public String toString() {
        return "GeoQuery{location=" + this.location + ", query='" + this.query + '\'' + ", ip='" + this.f2154ip + '\'' + ", accuracy='" + this.accuracy + '\'' + ", granularity='" + this.granularity + '\'' + ", maxResults=" + this.maxResults + '}';
    }
}
