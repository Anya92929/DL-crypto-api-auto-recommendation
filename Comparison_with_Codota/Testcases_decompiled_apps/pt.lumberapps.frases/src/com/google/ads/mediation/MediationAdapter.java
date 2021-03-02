package com.google.ads.mediation;

@Deprecated
public interface MediationAdapter {
    void destroy();

    Class getAdditionalParametersType();

    Class getServerParametersType();
}
