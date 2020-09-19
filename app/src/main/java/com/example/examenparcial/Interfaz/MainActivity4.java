package com.example.examenparcial.Interfaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.examenparcial.R;
import com.example.examenparcial.RecyclerViewAdaptador.RecyclerViewAdaptadorArticulo;
import com.example.examenparcial.Secciones.Articulo;
import com.example.examenparcial.WebServices.Asynchtask;
import com.example.examenparcial.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity4 extends AppCompatActivity implements Asynchtask {
    private RecyclerView recyclerView;
    private RecyclerViewAdaptadorArticulo recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle b = this.getIntent().getExtras();
        recyclerView =(RecyclerView)findViewById(R.id.rvusuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        handleSSLHandshake();
        gsonrevistas();
    }
    ArrayList<Articulo> Articulolist;
    private void gsonrevistas() {
        String url ="https://revistas.uteq.edu.ec/ws/issues.php?j_id=2";
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url, datos, MainActivity4.this, MainActivity4.this);
        ws.execute("GET");
    }
    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }
    public void processFinish(String result) throws JSONException {
        try {
            JSONArray jsonlista= new JSONArray(result);
            Articulolist = Articulo.JsonObjectsBuild(jsonlista);
            recyclerViewAdapter= new RecyclerViewAdaptadorArticulo(getApplicationContext(), Articulolist);
            recyclerView.setAdapter(recyclerViewAdapter);

        }catch (JSONException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}