package app.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton suma,resta,multiplicacion,division,potencia,porcentaje;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText valor1 = (EditText)findViewById(R.id.txtValor1);
        final EditText valor2 = (EditText)findViewById(R.id.txtValor2);
        final Button btnOperacion = (Button)findViewById(R.id.btnCalcular);
        resultado = (TextView)findViewById(R.id.txtResul);
        suma = (RadioButton)findViewById(R.id.rbSuma);
        resta = (RadioButton)findViewById(R.id.rbResta);
        multiplicacion = (RadioButton)findViewById(R.id.rbMult);
        division = (RadioButton)findViewById(R.id.rbDiv);
        potencia = (RadioButton)findViewById(R.id.rbPotencia);
        porcentaje = (RadioButton)findViewById(R.id.rbPorciento);

        btnOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valor1.getText().toString().isEmpty()||valor2.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Campo o campos vacíos", Toast.LENGTH_LONG).show();
                    resultado.setText(String.valueOf(0));
                }
                else{
                    double val1 = Double.parseDouble(valor1.getText().toString());
                    double val2 = Double.parseDouble(valor2.getText().toString());

                    double resul;
                    if(suma.isChecked()==true){
                        resul = val1+val2;
                        resultado.setText(String.valueOf(resul));
                    }
                    else if(resta.isChecked()==true){
                        resul = val1-val2;
                        resultado.setText(String.valueOf(resul));
                    }
                    else if(multiplicacion.isChecked()==true){
                        resul = val1*val2;
                        resultado.setText(String.valueOf(resul));
                    }
                    else if(division.isChecked()==true){
                        resul = val1/val2;
                        resultado.setText(String.valueOf(resul));
                    }
                    else if(potencia.isChecked()==true){
                        resul = Math.pow(val1,val2);
                        resultado.setText(String.valueOf(resul));
                    }
                    else if(porcentaje.isChecked()==true){
                        resul = (val1*val2)/100;
                        resultado.setText(String.valueOf(resul));
                    }else{
                        Toast.makeText(getApplicationContext(), "Opcion no marcada", Toast.LENGTH_LONG).show();
                        resultado.setText(String.valueOf(0));
                    }
                }

            }
        });
    }
}
