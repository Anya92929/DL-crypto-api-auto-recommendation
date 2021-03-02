package p052pt.lumberapps.lumbliv;

import com.p028a.C0765a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: pt.lumberapps.lumbliv.n */
public class C2093n {

    /* renamed from: a */
    public String f7869a;

    /* renamed from: b */
    ArrayList f7870b = new ArrayList();

    /* renamed from: c */
    C0765a f7871c;

    /* renamed from: d */
    JSONObject f7872d;

    /* renamed from: e */
    public final String f7873e = "{\"PT\":[{\"titulo\":\"Significado Sonhos\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/sonhos.png\",\"pkg\":\"pt.lumberapps.sonhos\"},{\"titulo\":\"Frases Religiosas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/religiosas.png\",\"pkg\":\"pt.lumberapps.religiosas\"},{\"titulo\":\"Significado Nomes\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/nomes.png\",\"pkg\":\"pt.lumberapps.nomes\"},{\"titulo\":\"PalBloco\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/palbloco.png\",\"pkg\":\"pt.lumberapps.palbloco\"},{\"titulo\":\"ABC em PT\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/abc.png\",\"pkg\":\"appinventor.ai_uilsone.ABCemPT_copy_checkpoint1\"},{\"titulo\":\"Sabia que..?\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/sabiaque.png\",\"pkg\":\"pt.lumberapps.sabiaque\"},{\"titulo\":\"Barracuda (Videos)\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/barracuda.png\",\"pkg\":\"pt.lumberapps.barracuda\"},{\"titulo\":\"1000 Mensagens\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/mensagens.png\",\"pkg\":\"pt.lumberapps.mensagens\"},{\"titulo\":\"Anedotas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/anedotas.png\",\"pkg\":\"pt.lumberapps.anedotas\"},{\"titulo\":\"Mil Frases\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"},{\"titulo\":\"Citações Espiritas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/espiritas.png\",\"pkg\":\"pt.lumberapps.espiritas\"},{\"titulo\":\"Frases em Imagens\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/imagensfrases.png\",\"pkg\":\"pt.lumberapps.imagensfrases\"}],\"ES\":[{\"titulo\":\"Significado Nombres\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/nomes.png\",\"pkg\":\"pt.lumberapps.significadodosnomes\"},{\"titulo\":\"Frases Religiosas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/religiosas.png\",\"pkg\":\"pt.lumberapps.religiosas\"},{\"titulo\":\"Mil Frases\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"},{\"titulo\":\"Frases en Imágenes\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/imagensfrases.png\",\"pkg\":\"pt.lumberapps.imagensfrases\"}],\"EN\":[{\"titulo\":\"Kids Letters, Numbers\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/abc_en.png\",\"pkg\":\"pt.wo.kidsalphaandanimals\"},{\"titulo\":\"1000 Quotes\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"},{\"titulo\":\"Quotes on Images\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/imagensfrases.png\",\"pkg\":\"pt.lumberapps.imagensfrases\"}],\"FR\":[{\"titulo\":\"1000 Phrases\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"}]} ";

    public C2093n(C0765a aVar) {
        this.f7871c = aVar;
    }

    /* renamed from: a */
    private String m8422a() {
        return this.f7869a.contains("portu") ? "PT" : this.f7869a.contains("espan") ? "ES" : this.f7869a.contains("ingl") ? "EN" : this.f7869a.contains("franc") ? "FR" : "PT";
    }

    /* renamed from: a */
    public ArrayList mo10299a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() < 1) {
            try {
                jSONObject = new JSONObject("{\"PT\":[{\"titulo\":\"Significado Sonhos\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/sonhos.png\",\"pkg\":\"pt.lumberapps.sonhos\"},{\"titulo\":\"Frases Religiosas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/religiosas.png\",\"pkg\":\"pt.lumberapps.religiosas\"},{\"titulo\":\"Significado Nomes\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/nomes.png\",\"pkg\":\"pt.lumberapps.nomes\"},{\"titulo\":\"PalBloco\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/palbloco.png\",\"pkg\":\"pt.lumberapps.palbloco\"},{\"titulo\":\"ABC em PT\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/abc.png\",\"pkg\":\"appinventor.ai_uilsone.ABCemPT_copy_checkpoint1\"},{\"titulo\":\"Sabia que..?\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/sabiaque.png\",\"pkg\":\"pt.lumberapps.sabiaque\"},{\"titulo\":\"Barracuda (Videos)\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/barracuda.png\",\"pkg\":\"pt.lumberapps.barracuda\"},{\"titulo\":\"1000 Mensagens\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/mensagens.png\",\"pkg\":\"pt.lumberapps.mensagens\"},{\"titulo\":\"Anedotas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/anedotas.png\",\"pkg\":\"pt.lumberapps.anedotas\"},{\"titulo\":\"Mil Frases\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"},{\"titulo\":\"Citações Espiritas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/espiritas.png\",\"pkg\":\"pt.lumberapps.espiritas\"},{\"titulo\":\"Frases em Imagens\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/imagensfrases.png\",\"pkg\":\"pt.lumberapps.imagensfrases\"}],\"ES\":[{\"titulo\":\"Significado Nombres\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/nomes.png\",\"pkg\":\"pt.lumberapps.significadodosnomes\"},{\"titulo\":\"Frases Religiosas\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/religiosas.png\",\"pkg\":\"pt.lumberapps.religiosas\"},{\"titulo\":\"Mil Frases\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"},{\"titulo\":\"Frases en Imágenes\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/imagensfrases.png\",\"pkg\":\"pt.lumberapps.imagensfrases\"}],\"EN\":[{\"titulo\":\"Kids Letters, Numbers\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/abc_en.png\",\"pkg\":\"pt.wo.kidsalphaandanimals\"},{\"titulo\":\"1000 Quotes\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"},{\"titulo\":\"Quotes on Images\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/imagensfrases.png\",\"pkg\":\"pt.lumberapps.imagensfrases\"}],\"FR\":[{\"titulo\":\"1000 Phrases\",\"img\":\"https://dl.dropboxusercontent.com/u/30859657/MAPPS/milfrases.png\",\"pkg\":\"pt.lumberapps.frases\"}]} ");
            } catch (JSONException e) {
                C2101v.f7877a.mo10294a("Erro json null");
                e.printStackTrace();
            }
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(m8422a());
            if (jSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    try {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        String string = jSONObject2.getString("titulo");
                        String string2 = jSONObject2.getString("img");
                        String string3 = jSONObject2.getString("pkg");
                        if (!this.f7871c.mo3477c().getPackageName().equals(string3)) {
                            this.f7870b.add(new C2092m(string, "", string3, string2));
                        }
                    } catch (JSONException e2) {
                        C2101v.f7877a.mo10294a("Erro loop json");
                        e2.printStackTrace();
                    }
                    i = i2 + 1;
                }
            }
            if (this.f7870b.size() > 0) {
                return this.f7870b;
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            C2101v.f7877a.mo10294a("Erro json");
            return null;
        }
    }

    /* renamed from: a */
    public JSONObject mo10300a(String str) {
        String str2 = str;
        this.f7871c.mo3469a(str2, JSONObject.class, 345600000, new C2094o(this));
        return this.f7872d;
    }
}
