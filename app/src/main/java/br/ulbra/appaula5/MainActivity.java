package br.ulbra.appaula5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgOpcoes;
    Button btnCalcular;
    EditText edtSalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSalario = (EditText) findViewById(R.id.edtSalario);
        rgOpcoes = (RadioGroup) findViewById(R.id.rgOpcoes);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salario = Double.parseDouble(edtSalario.getText().toString());
                int op = rgOpcoes.getCheckedRadioButtonId();
                double novoSalario = 0;
                if(op == R.id.rb40){
                    novoSalario = salario + (salario* 0.40);
                }else if(op == R.id.rb45){
                    novoSalario = salario + (salario * 0.45);
                }else{
                    novoSalario = salario + (salario* 0.50);
                }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo salário");
                dialogo.setMessage("Seu novo salário é: R$" + String.valueOf(novoSalario));
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
            }
        });
    }
}