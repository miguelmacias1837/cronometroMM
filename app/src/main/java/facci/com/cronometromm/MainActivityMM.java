package facci.com.cronometromm;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivityMM extends ActionBarActivity {
    Button Contar,Pausa;
    Chronometer crono;
    long Time=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_mm);
        crono = (Chronometer) findViewById(R.id.cronometro);
        Contar = (Button) findViewById(R.id.contar);
        Pausa= (Button) findViewById(R.id.pausa);

        Contar.setEnabled(true);
        Pausa.setEnabled(false);

        Contar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contar.setEnabled(false);
                Pausa.setEnabled(true);
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();
            }
        });
        Pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contar.setEnabled(true);
                Pausa.setEnabled(false);;
                crono.stop();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_mm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
