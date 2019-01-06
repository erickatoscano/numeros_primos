package com.example.administrador.numeros_primos;

import android.app.Activity;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EjemploAsyncTask extends AsyncTask<Integer, String, List<Integer>> {

    Activity activity;
    public EjemploAsyncTask(Activity mainActivity) {
        activity = mainActivity;
    }

    @Override
    protected List<Integer> doInBackground(Integer... params) {

        int i,j;
        boolean isPrime;
        int rInicial=2;//Rango inicial, este debe ser mayor de 1.
        int rFinal = params[0];//Rango final.
        List<Integer> primeList = new ArrayList<Integer>();

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
                primeList.add(i);
                publishProgress("Numeros primos: " + i);

                //   texto.setText((CharSequence) primeList);
                //
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                }
            }
        }

        return primeList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }


    @Override
    protected void onProgressUpdate(String... values) {
        TextView messageView = (TextView) activity.findViewById(R.id.texto);
        messageView.setText(values[0]);
        super.onProgressUpdate(values);


    }



    @Override
    protected void onPostExecute(List<Integer> result) {

        TextView messageView = (TextView) activity.findViewById(R.id.texto);
        messageView.setText("Numeros primo (AsyncTask): " + result.get(result.size()-1));
        super.onPostExecute(result);
        //super.onPostExecute(result);

        //Toast.makeText(getBaseContext(), "Tarea Larga Finalizada en AsyncTask", Toast.LENGTH_SHORT).show();



    }


}
