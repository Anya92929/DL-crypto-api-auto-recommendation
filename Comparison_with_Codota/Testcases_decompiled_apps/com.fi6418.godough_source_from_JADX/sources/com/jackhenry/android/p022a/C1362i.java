package com.jackhenry.android.p022a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.android.a.i */
public class C1362i {

    /* renamed from: a */
    private static List<C1363j> f5568a = new ArrayList();

    static {
        f5568a.add(new C1363j("AL", "Alabama"));
        f5568a.add(new C1363j("AK", "Alaska"));
        f5568a.add(new C1363j("AZ", "Arizona"));
        f5568a.add(new C1363j("AR", "Arkansas"));
        f5568a.add(new C1363j("CA", "California"));
        f5568a.add(new C1363j("CO", "Colorado"));
        f5568a.add(new C1363j("CT", "Connecticut"));
        f5568a.add(new C1363j("DE", "Delaware"));
        f5568a.add(new C1363j("DC", "District of Columbia"));
        f5568a.add(new C1363j("FL", "Florida"));
        f5568a.add(new C1363j("GA", "Georgia"));
        f5568a.add(new C1363j("HI", "Hawaii"));
        f5568a.add(new C1363j("ID", "Idaho"));
        f5568a.add(new C1363j("IL", "Illinois"));
        f5568a.add(new C1363j("IN", "Indiana"));
        f5568a.add(new C1363j("IA", "Iowa"));
        f5568a.add(new C1363j("KS", "Kansas"));
        f5568a.add(new C1363j("KY", "Kentucky"));
        f5568a.add(new C1363j("LA", "Louisiana"));
        f5568a.add(new C1363j("ME", "Maine"));
        f5568a.add(new C1363j("MD", "Maryland"));
        f5568a.add(new C1363j("MA", "Massachusetts"));
        f5568a.add(new C1363j("MI", "Michigan"));
        f5568a.add(new C1363j("MN", "Minnesota"));
        f5568a.add(new C1363j("MS", "Mississippi"));
        f5568a.add(new C1363j("MO", "Missouri"));
        f5568a.add(new C1363j("MT", "Montana"));
        f5568a.add(new C1363j("NE", "Nebraska"));
        f5568a.add(new C1363j("NV", "Nevada"));
        f5568a.add(new C1363j("NH", "New Hampshire"));
        f5568a.add(new C1363j("NJ", "New Jersey"));
        f5568a.add(new C1363j("NM", "New Mexico"));
        f5568a.add(new C1363j("NY", "New York"));
        f5568a.add(new C1363j("NC", "North Carolina"));
        f5568a.add(new C1363j("ND", "North Dakota"));
        f5568a.add(new C1363j("OH", "Ohio"));
        f5568a.add(new C1363j("OK", "Oklahoma"));
        f5568a.add(new C1363j("OR", "Oregon"));
        f5568a.add(new C1363j("PA", "Pennsylvania"));
        f5568a.add(new C1363j("RI", "Rhode Island"));
        f5568a.add(new C1363j("SC", "South Carolina"));
        f5568a.add(new C1363j("SD", "South Dakota"));
        f5568a.add(new C1363j("TN", "Tennessee"));
        f5568a.add(new C1363j("TX", "Texas"));
        f5568a.add(new C1363j("UT", "Utah"));
        f5568a.add(new C1363j("VT", "Vermont"));
        f5568a.add(new C1363j("VA", "Virginia"));
        f5568a.add(new C1363j("WA", "Washington"));
        f5568a.add(new C1363j("WV", "West Virginia"));
        f5568a.add(new C1363j("WI", "Wisconsin"));
        f5568a.add(new C1363j("WY", "Wyoming State"));
    }

    /* renamed from: a */
    public static C1363j m5581a(String str) {
        for (C1363j next : f5568a) {
            if (next.mo9285b().equals(str)) {
                return next;
            }
        }
        return null;
    }
}
