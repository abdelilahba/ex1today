package com.example.ex5json201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.sp1);
        t=findViewById(R.id.txt1);
        ArrayList<Etudiant> ets=changeobject();
        ArrayList<String> s =new ArrayList<>();
        for(Etudiant e : ets){
            s.add(e.getIdent()+"-"+e.getNom());

        }
        ArrayAdapter dr=new ArrayAdapter(this,R.layout.activity_main,s);
        sp.setAdapter(dr);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                Etudiant e =ets.get(pos);
                t.setText(e.getNaissance());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }
    public String loadJSONFromRaw(int resId) {
        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public ArrayList<Etudiant> changeobject(){
        ArrayList<Etudiant> et =new ArrayList<>();
        try {
            JSONArray js =new JSONArray(loadJSONFromRaw(R.raw.etudiants));
            for (int i=0;i<js.length();i++){
                Etudiant e =new Etudiant();
                JSONObject o =js.getJSONObject(i);
                e.setIdent(o.getString("ident"));
                e.setNom(o.getString("nom"));
                e.setVille(o.getString("ville"));
                e.setNaissance(o.getString("naissance"));
                JSONObject ob=new JSONObject("resultat");
                e.setNoteFr(ob.getInt("fr"));
                e.setNoteHist(ob.getInt("hist"));
                e.setNoteMath(ob.getInt("math"));
                e.setNoteFr(ob.getInt("phys"));
                et.add(e);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return et;
    }
}
