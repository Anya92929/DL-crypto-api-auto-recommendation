package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.content.Context;
import java.util.EnumMap;
import p006nl.volkerinfradesign.check.BuildConfig;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentParams;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentFactory */
public final class EnvironmentFactory {

    /* renamed from: a */
    static final EnumMap<EnvironmentParams.C1510a, CheckEnvironment> f4904a = new EnumMap<>(EnvironmentParams.C1510a.class);

    public Model getCheckInstance(Context context) {
        EnvironmentParams environmentParams = new EnvironmentParams(context, EnvironmentParams.C1510a.CHECK, "keuringen", BuildConfig.APPLICATION_ID);
        if (!ViTa.isInitialized()) {
            ViTa.init(context);
        }
        return m6002a(environmentParams);
    }

    public Model getStenaLineInstance(Context context) {
        EnvironmentParams environmentParams = new EnvironmentParams(context, EnvironmentParams.C1510a.STENA_LINE, "Stenaline", "nl.volkerinfradesign.stenaline");
        if (!ViTa.isInitialized()) {
            ViTa.init(context);
        }
        return m6002a(environmentParams);
    }

    public Model getIsalaDeltaInstance(Context context) {
        EnvironmentParams environmentParams = new EnvironmentParams(context, EnvironmentParams.C1510a.ISALADELTA, "IsalaDeltaEnvironment", "nl.volkerinfradesign.isaladelta");
        if (!ViTa.isInitialized()) {
            ViTa.init(context);
        }
        return m6002a(environmentParams);
    }

    public Model getWaveInstance(Context context) {
        EnvironmentParams environmentParams = new EnvironmentParams(context, EnvironmentParams.C1510a.WAVE, "veiligheid", "nl.volkerinfradesign.wave");
        if (!ViTa.isInitialized()) {
            ViTa.init(context);
        }
        return m6002a(environmentParams);
    }

    /* renamed from: a */
    private Model m6002a(EnvironmentParams environmentParams) {
        EnvironmentParams.C1510a aVar = environmentParams.nameSpace;
        if (!f4904a.containsKey(aVar)) {
            switch (aVar) {
                case CHECK:
                    f4904a.put(aVar, new CheckEnvironment(environmentParams));
                    break;
                case WAVE:
                    f4904a.put(aVar, new WaveEnvironment(environmentParams));
                    break;
                case ISALADELTA:
                    f4904a.put(aVar, new IsalaDeltaEnvironment(environmentParams));
                    break;
                case STENA_LINE:
                    f4904a.put(aVar, new StenaLineEnvironment(environmentParams));
                    break;
                default:
                    throw new IllegalArgumentException("The nameSpace " + aVar.name() + " is not yet supported!");
            }
        }
        return f4904a.get(aVar);
    }
}
