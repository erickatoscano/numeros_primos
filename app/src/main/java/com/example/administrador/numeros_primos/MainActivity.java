package com.example.administrador.numeros_primos;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private TextView texto,texto2;
    private Button btn_async, btn;
    List<EjemploAsyncTask> taskList;
    int rFinal = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskList = new ArrayList<EjemploAsyncTask>();

        texto = (TextView)findViewById(R.id.texto);
        texto2 = (TextView)findViewById(R.id.texto2);
        btn = (Button)findViewById(R.id.calcular);
        btn_async = (Button)findViewById(R.id.calcularThread);

        btn.setOnClickListener(this);
        btn_async.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.calcular:
                numeroPrimo();

                break;
            case R.id.calcularThread:

                EjemploAsyncTask ejemplo= new EjemploAsyncTask(this);
                taskList.add(ejemplo);
                ejemplo.execute(rFinal);
                Toast.makeText(getApplicationContext(), "New run queued.", Toast.LENGTH_SHORT).show();


                break;
            default:
                break;
        }
    }


private void numeroPrimo(){
        texto2.setText(" ");
    int i,j;
    boolean isPrime;
    int rInicial=2;//Rango inicial, este debe ser mayor de 1.


    for(i = rInicial;i <= rFinal;i++){
        //recorro ciclo tantas veces como necesite(<= es para incluir el valor de rFinal).
        isPrime=true;// i es primo hasta que se demuestre lo contrario, jejejejeje.
        for(j = 2;j < i;j++){
            if(i % j == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            texto2.append(i+"\n");
        }
    }



}
}
