package p006nl.volkerinfradesign.checkandroid.tables;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.p009io.IOUtils;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.Joiner */
public class Joiner {

    /* renamed from: a */
    private String f4947a = new String();

    /* renamed from: b */
    private final Set<Table> f4948b = new HashSet();

    /* renamed from: c */
    private Column f4949c;

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.Joiner$JoinType */
    public enum JoinType {
        JOIN {
            public String toString() {
                return " JOIN ";
            }
        },
        FULL_JOIN {
            public String toString() {
                return " FULL JOIN ";
            }
        },
        CROSS_JOIN {
            public String toString() {
                return " CROSS JOIN ";
            }
        },
        LEFT_OUTER_JOIN {
            public String toString() {
                return " LEFT OUTER JOIN ";
            }
        };

        public abstract String toString();
    }

    public static Joiner join(Column column, String str, Column column2) {
        return new Joiner(column, JoinType.JOIN, str, column2);
    }

    public static Joiner lefOuterJoin(Column column, String str, Column column2) {
        return new Joiner(column, JoinType.LEFT_OUTER_JOIN, str, column2);
    }

    private Joiner(Column column, JoinType joinType, String str, Column column2) {
        this.f4947a += column.getTable().getName() + IOUtils.LINE_SEPARATOR_UNIX;
        this.f4948b.add(column.getTable());
        this.f4949c = column;
        m6034a(column2, joinType, str);
    }

    public Joiner leftOuterJoin(Column column, String str) {
        m6034a(column, JoinType.LEFT_OUTER_JOIN, str);
        return this;
    }

    public Joiner join(Column column, String str) {
        m6034a(column, JoinType.JOIN, str);
        return this;
    }

    /* renamed from: a */
    private Joiner m6034a(Column column, JoinType joinType, String str) {
        this.f4947a += joinType.toString() + column.getTable().getName() + "\nON";
        this.f4947a += this.f4949c.getTable().getName() + "build/intermediates/exploded-aar/com.android.support/mediarouter-v7/22.2.0/res" + this.f4949c.getName();
        this.f4947a += str;
        this.f4947a += column.getTable().getName() + "build/intermediates/exploded-aar/com.android.support/mediarouter-v7/22.2.0/res" + column.getName();
        this.f4948b.add(column.getTable());
        this.f4949c = column;
        return this;
    }
}
