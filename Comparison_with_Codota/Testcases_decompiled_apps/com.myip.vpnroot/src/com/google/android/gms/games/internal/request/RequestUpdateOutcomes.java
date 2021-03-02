package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] abh = {"requestId", "outcome"};

    /* renamed from: HF */
    private final int f2344HF;
    private final HashMap<String, Integer> abi;

    public static final class Builder {

        /* renamed from: HF */
        private int f2345HF = 0;
        private HashMap<String, Integer> abi = new HashMap<>();

        /* renamed from: dR */
        public Builder mo7454dR(int i) {
            this.f2345HF = i;
            return this;
        }

        /* renamed from: lw */
        public RequestUpdateOutcomes mo7455lw() {
            return new RequestUpdateOutcomes(this.f2345HF, this.abi);
        }

        /* renamed from: x */
        public Builder mo7456x(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.abi.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.f2344HF = statusCode;
        this.abi = outcomeMap;
    }

    /* renamed from: V */
    public static RequestUpdateOutcomes m3637V(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.mo7454dR(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int ar = dataHolder.mo4304ar(i);
            builder.mo7456x(dataHolder.mo4306c("requestId", i, ar), dataHolder.mo4305b("outcome", i, ar));
        }
        return builder.mo7455lw();
    }

    public Set<String> getRequestIds() {
        return this.abi.keySet();
    }

    public int getRequestOutcome(String requestId) {
        C0348n.m859b(this.abi.containsKey(requestId), (Object) "Request " + requestId + " was not part of the update operation!");
        return this.abi.get(requestId).intValue();
    }
}
