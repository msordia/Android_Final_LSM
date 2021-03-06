/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    SenasDAO senas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        senas = new SenasDAO(this);
        senas.open();

        SenasTest.ListaSenas = senas.getSenas2();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        int displaymode = getResources().getConfiguration().orientation;
        if(displaymode == 1){// portrait
            SenasTest S = new SenasTest();
            fragmentTransaction.replace(android.R.id.content,S);
        }else {// landscape
            //Main2 f2 = new Main2();
            //fragmentTransaction.replace(android.R.id.content,f2);
        }
        fragmentTransaction.commit();
    }
}
