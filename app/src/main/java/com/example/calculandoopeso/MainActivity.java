package com.example.calculandoopeso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularPeso(View view) {

        EditText edtxtPeso = (EditText) findViewById(R.id.edtxtPeso);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);

        txtResult.setText("Resultado");

        Float peso;
        Float novoPeso;

        AlertDialog.Builder a = new AlertDialog.Builder(this);

        if(!(edtxtPeso.getText().toString().equals(""))){

            peso = Float.parseFloat(edtxtPeso.getText()+"");

            if(peso>(peso+(peso*15)/100)){

                novoPeso = peso+((peso*15)/100);
                txtResult.setText("Engordou 15%, novo peso: "+novoPeso);

            }else if(peso<(peso-(peso*20)/100)){
                novoPeso = peso-((peso*20)/100);
                txtResult.setText("Emagreceu 20%, novo peso: "+novoPeso);
            }

        }else {
            a.setTitle("Erro");
            a.setMessage("Caixa vazia, insira o peso!!!");
            a.create().show();
        }
    }
}