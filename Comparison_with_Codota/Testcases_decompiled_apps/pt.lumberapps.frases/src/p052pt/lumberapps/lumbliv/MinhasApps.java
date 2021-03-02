package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.p028a.C0765a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: pt.lumberapps.lumbliv.MinhasApps */
public class MinhasApps extends Activity implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    C2080a f7830b;

    /* renamed from: c */
    C0765a f7831c;

    /* renamed from: d */
    ArrayList f7832d;

    /* renamed from: e */
    ListView f7833e;

    /* renamed from: f */
    JSONObject f7834f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8389a(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject("{\"Apps_LumberApps\":[{\"titulo\":\"Significado dos Sonhos\",\"desc\":\"Saiba o que quer dizer aquilo com que sonhou.\",\"icon\":\"https:\\/\\/lh3.ggpht.com\\/_HHglqnkUfxDfJfXj_5j2Bsdprok3n0GE1dZxP4oDaJGQtJ3ZrX7BEIRBz3S9GxuyVYt=w300-rw\",\"url\":\"pt.lumberapps.sonhos\",\"url_site\":\"\"},{\"titulo\":\"Cita\\u0026ccedil;\\u0026otilde;es Esp\\u0026iacute;ritas\",\"desc\":\"Aplica\\u0026ccedil;\\u0026atilde;o com v\\u0026aacute;rias frases ligadas ao tema dos espiritismo.\\nContem mais de 400 Cita\\u0026ccedil;\\u0026otilde;es com diversos autores, tais como:\\nAllan Kardec, Chico Xavier, Emanuel, Andr\\u0026eacute; Lu\\u0026iacute;s, entre outros.\",\"icon\":\"https:\\/\\/lh4.ggpht.com\\/_vmWBaJiwSow7txxKvfqonBGt7-rkC09KorftwEyhDLdY_qsc6MEjIY9tLg_yM0UK_4=w300-rw\",\"url\":\"pt.lumberapps.espiritas\",\"url_site\":\"\"},{\"titulo\":\"1000 Mensagens\",\"desc\":\"Mensagens para Whatsapp, sms, Facebook Menssenger ets.\\nNesta App vai encontrar muitas mensagens e SMs para enviar aos seu amigos, namorada\\/o. \\nMuitas categorias como:\\n* Rom\\u0026acirc;nticas,\\n* Bom Dia,\\n* Boa Noite,\\n* Mensagens Engra\\u0026ccedil;adas,\\n* Motiva\\u0026ccedil;\\u0026atilde;o,\\n* Parabens,\\n* Saudade, \\n* Religiosas\",\"icon\":\"https:\\/\\/lh5.ggpht.com\\/RZ7QLH8kazKa34vJWDSi5VWyLz_zaRz4xM_rnPYaGfWcIwidt7GLc4nimGOGJ22C4Q=w300-rw\",\"url\":\"pt.lumberapps.mensagens\",\"url_site\":\"\"},{\"titulo\":\"ABC em PT\",\"desc\":\"Aplica\\u0026ccedil;\\u0026atilde;o para crian\\u0026ccedil;as aprenderem as letras, n\\u0026uacute;meros e os nomes dos Animais.\\nTem todas as letras do abeced\\u0026aacute;rio portugu\\u0026ecirc;s, n\\u0026uacute;meros at\\u0026eacute; dez, animais, tudo com voz em portugu\\u0026ecirc;s.\\nJogo \\u0026quot;onde est\\u0026aacute;?\\u0026quot; onde \\u0026eacute; pedido \\u0026agrave; crian\\u0026ccedil;a que toque na letra ou numero pedida pela voz.\\nLetras: todas as letras do abeced\\u0026aacute;rio com voz em portugu\\u0026ecirc;s\\nN\\u0026uacute;meros: N\\u0026uacute;meros de 1 a 10 com voz em Portugu\\u0026ecirc;s.\\nAnimais: Animais com o nome e som caracter\\u0026iacute;stico do animal.\",\"icon\":\"https:\\/\\/lh3.ggpht.com\\/2r0wPwtKk62oOuzem9-q4H52Zn_eS689tbICnLZJ96csFXAAM6TxW0EtBhZJTCBTtA0=w300-rw\",\"url\":\"appinventor.ai_uilsone.ABCemPT_copy_checkpoint1\",\"url_site\":\"\"},{\"titulo\":\"Significado dos Nomes\",\"desc\":\"App com o s\\u0026iacute;gnificado de centenas de nomes pr\\u0026oacute;prios e apelidos.\",\"icon\":\"https:\\/\\/lh6.ggpht.com\\/ML5fByH4NZha9QJMPH9AUv6zHfwLG91ivpa_1vW_AFq1oQ2MpqZG9d7v9aPUAzXeZDQ=w300-rw\",\"url\":\"pt.lumberapps.significadodosnomes\",\"url_site\":\"\"},{\"titulo\":\"Sabia que..?\",\"desc\":\"Curiosidades em Portugu\\u0026ecirc;s. Esta aplica\\u0026ccedil;\\u0026atilde;o tem muitos outros factos sobre a natureza, hist\\u0026oacute;ria, ci\\u0026ecirc;ncia que voc\\u0026ecirc; n\\u0026atilde;o sabia!\\nExperimente o widget no seu ecr\\u0026atilde; principal para ter acesso sempre \\u0026agrave;s melhores curiosidades.\",\"icon\":\"https:\\/\\/lh3.ggpht.com\\/N9Ah7suYDJDRYTXXfXkmRvh71h8dBPBb5MLXT63I0trqQYgb3iCF1RE580_kznAjbw=w300-rw\",\"url\":\"pt.lumberapps.sabiaque\",\"url_site\":\"\"},{\"titulo\":\"Anedotas e Piadas\",\"desc\":\"Anedotas piadas e adivinhas nesta app vai encontrar tudo isso.Tem tamb\\u0026eacute;m um widget para ter piadas sempre \\u0026agrave; m\\u0026atilde;o.\",\"icon\":\"https:\\/\\/lh6.ggpht.com\\/6qDnwpUk91sbLkbBSlLEXVsey5O61TzadeZ9QZNh3NIX3mxhqN6Uj53wq9n4pBczPdM=w300-rw\",\"url\":\"pt.lumberapps.anedotas\",\"url_site\":\"\"},{\"titulo\":\"Barracuda.pt\",\"desc\":\"Videos para rir e muito humor em portugu\\u0026ecirc;s e pode ir diretamente para o site onde s\\u0026atilde;o publicados diariamente v\\u0026iacute;deos c\\u0026oacute;micos que v\\u0026atilde;o fazer rir muito.\\nPode partilhar os videos no facebook, twitter etc.\\nVideos de fails, humor, animais, barracadas, loucos na estrada e muito mais.\",\"icon\":\"https:\\/\\/lh6.ggpht.com\\/oaufrJGWz2dl5Wxzku9mVqR0kC_vqK2BnG09JB49WCvY_ewge751adSzzmkLLlBqgQ=w300-rw\",\"url\":\"pt.lumberapps.barracuda\",\"url_site\":\"barracuda.pt\"},{\"titulo\":\"1000 Frases\",\"desc\":\"Aplica\\u0026ccedil;\\u0026atilde;o com mais de mil frases lindas entre prov\\u0026eacute;rbios, frases de amor, pensamentos e frases de amizade. Pode partilhar as frases diretamente no facebook, email, twitter, mensagens, whatsapp etc...\",\"icon\":\"https:\\/\\/lh6.ggpht.com\\/Mzx4edLH6hA0sDQArW7x_ldFjjmgVBlpuXmwmSYSHQyR8L02kds_4cVjsvq_EnTyEBE=w300-rw\",\"url\":\"pt.lumberapps.frases\",\"url_site\":\"www.mil-frases.com\"},{\"titulo\":\"Frases em Imagens\",\"desc\":\"Aplica\\u0026ccedil;\\u0026atilde;o com centenas de imagens com frases.Pode partilhar as frases em imagem no facebook, google+, twitter, tumblr ou noutras redes, enviar por mensagem para os seu amigos ou mail.\",\"icon\":\"https:\\/\\/lh4.ggpht.com\\/cXKunF08hKZ-2Y-bT4IafmcDvf3RDfHZGu8VThkN6blOGcrTzmFjw5ZNhW4_dWiUyGM=w300-rw\",\"url\":\"pt.lumberapps.imagensfrases\",\"url_site\":\"www.mil-frases.com\"},{\"titulo\":\"Palbloco\",\"desc\":\"Nesta app os mais pequenos ter\\u0026atilde;o uma forma muito divertida de brincar com as letras. com desenhos de animais e objectos do dia a dia como ilustra\\u0026ccedil;\\u0026otilde;es. O objectivo e simples:\\n\\tensinar as crian\\u0026ccedil;as a juntarem as letras do abecedario para formar palavra.\",\"icon\":\"https:\\/\\/lh3.ggpht.com\\/0hDDNyh1_dpmUb0TmUR0rbSl4vrnGrda2b-tE7w_BYwUw5Rg7fPSRvHCDLAkXb6428m9=w300-rw\",\"url\":\"pt.lumberapps.palbloco\",\"url_site\":\"\"},{\"titulo\":\"PetCom\",\"desc\":\"Pet com \\u0026eacute; uma app simples para comunicar com o seu anumal de estima\\u0026ccedil;\\u0026atilde;o\\n\\tInclu\\u0026iacute; o modo de partida para voc\\u0026ecirc; filmar o seu animal a reagiar aos sons\",\"icon\":\"https:\\/\\/lh3.ggpht.com\\/OI9GW8e0vifjStwE2M6h8zk2LqSGO_-e2ZtpGBvrC0lCbyeLKzEx-safe-SXFkSNVk4=w300-rw\",\"url\":\"pt.lumberapps.petcom\",\"url_site\":\"\"},{\"titulo\":\"IVA Portugal\",\"desc\":\"Calculadora para o IVA em Portugal.\\nPode-se Tamb\\u0026eacute;m adicionar o Calculo de Lucro.\\nApp simples direccionada para quem tem lojas e precisa de fazer este tipo de contas.\",\"icon\":\"https:\\/\\/lh6.ggpht.com\\/RMPx2xWeko_JpzyGuatWRI1RxZ8FwgtajAULnK3zlGnRodIKoEBpF1Y3-W9vjHH-ng=w300-rw\",\"url\":\"pt.lumberapps.ivapt\",\"url_site\":\"\"},{\"titulo\":\"ABC em Ingl\\u0026ecirc;s\",\"desc\":\"Vers\\u0026atilde;o em ingl\\u0026ecirc;s do ABC em PT.\\nA game for your children learn the alphabet, the numbers and animals.\\nWith a game for kids to find the asked item.\",\"icon\":\"https:\\/\\/lh3.ggpht.com\\/O-843fN9JeIxOBayoI9ZN3Qef_-RzH3WAFG5Kyb0cNbOoX3CDiZyyvCisB7JHrNn9OWs=w300-rw\",\"url\":\"pt.wo.kidsalphaandanimals\",\"url_site\":\"\"}]}");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("Apps_LumberApps");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        this.f7832d.add(new C2092m(jSONObject2.getString("titulo"), jSONObject2.getString("desc"), jSONObject2.getString("url"), jSONObject2.getString("icon")));
                    } catch (JSONException e2) {
                        mo10121b(e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            mo10121b(e3.getMessage());
            mo10260a(false);
        }
        if (this.f7832d.size() > 0) {
            mo10260a(true);
            mo10121b("ok");
            return;
        }
        mo10260a(false);
    }

    /* renamed from: a */
    public void mo10259a() {
        this.f7834f = mo10262d("http://www.lumberapps.pt/MApps/index.php?json_=pt");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10119a(View view) {
    }

    /* renamed from: a */
    public void mo10260a(boolean z) {
        if (z) {
            this.f7830b = new C2080a(this, 17367043, this.f7832d, this.f7831c);
            this.f7833e = (ListView) findViewById(C2099t.listView1);
            this.f7833e.setOnItemClickListener(this);
            this.f7833e.setAdapter(this.f7830b);
            return;
        }
        mo10121b("Erro");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10261b(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        ((RelativeLayout) findViewById(C2099t.rela_minhas_apps)).addView(view, layoutParams);
    }

    /* renamed from: b */
    public void mo10121b(String str) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10122c(String str) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public JSONObject mo10262d(String str) {
        String str2 = str;
        this.f7831c.mo3469a(str2, JSONObject.class, 345600000, new C2096q(this));
        return this.f7834f;
    }

    public void onClick(View view) {
        mo10119a(view);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2100u.minhas_apps);
        this.f7831c = new C0765a((Activity) this);
        this.f7832d = new ArrayList();
        mo10259a();
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo10122c(((C2092m) this.f7832d.get(i)).f7866c);
    }
}
