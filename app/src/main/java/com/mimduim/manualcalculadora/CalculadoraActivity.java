package com.mimduim.manualcalculadora;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText visor;
    private Button botao;
    private TableRow linha;
    private TableLayout leiaute;
    private double num1, num2, resp;
    private String STRING = "";
    private String aux, textvisor, numero, operador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        visor = new EditText(this);
        visor.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        visor.setText("");
        visor.setTextSize(70);
        visor.setBackgroundColor(Color.parseColor("#000000"));
        visor.setTextColor(Color.parseColor("#19B5FE"));
        visor.setCursorVisible(false);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                visor.setText(tecladoCalculadora(btn.getText().toString()));
            }
        };


        TABLECREATE(listener);



       /* View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button botao = (Button) view;
                Toast.makeText(CalculadoraActivity.this, "Click: " + botao.getText(), Toast.LENGTH_SHORT).show();
            }
        };*/


    }

    public void TABLECREATE(View.OnClickListener listener) {
        leiaute = new TableLayout(this);
        leiaute.setBackgroundColor(Color.parseColor("#000000"));

        leiaute.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        leiaute.addView(visor);
        leiaute.setStretchAllColumns(true);

        int cont = 7;
        for (int i = 0; i < 5; i++) {
            linha = new TableRow(this);
            linha.setPadding(5,5,5,5);
            for (int j = 0; j < 4; j++) {
                botao = new Button(this);
                botao.setTextSize(30);
                botao.setPadding(5,5,5,5);
                // botao.setBackgroundResource(R.drawable.abc_action_bar_item_background_material);
                botao.setTextColor(Color.parseColor("#19B5FE"));
                botao.setBackgroundColor(Color.parseColor("#000000"));


                if (i == 0 && j == 0)
                    botao.setText("C");
                else if (i == 0 && j == 1)
                    botao.setText("SQRT");
                else if (i == 0 && j == 2)
                    botao.setText("=");
                else if (i == 0 && j == 3)
                    botao.setText("<X");
                else if (i == 1 && j == 3)
                    botao.setText("+");
                else if (i == 2 && j == 3)
                    botao.setText("-");
                else if (i == 3 && j == 3)
                    botao.setText("/");
                else if (i == 4 && j == 3)
                    botao.setText("*");
                else if (i == 4 && j == 0)
                    botao.setText(".");
                else if (i == 4 && j == 1) {
                    botao.setText("0");
                } else if (i == 4 && j == 2)
                    botao.setText("%");
                else {
                    botao.setText("" + cont++);
                }
                botao.setOnClickListener(listener);
                linha.addView(botao);
            }
            if (i > 0)
                cont -= 6;
            leiaute.addView(linha);
        }
        setContentView(leiaute);
    }

    public String ADICAO() {
        num1 = Float.parseFloat(STRING);
        num2 = Float.parseFloat(textvisor);
        resp = num1 + num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String SUBTRACAO() {
        num1 = Float.parseFloat(STRING);
        num2 = Float.parseFloat(textvisor);
        resp = num1 - num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String DIVISAO() {
        num1 = Float.parseFloat(STRING);
        num2 = Float.parseFloat(textvisor);
        resp = num1 / num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String MULTIPLICACAO() {
        num1 = Float.parseFloat(STRING);
        num2 = Float.parseFloat(textvisor);
        resp = num1 * num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String PORCENTAGEM() {
        num1 = Float.parseFloat(STRING);
        num2 = Float.parseFloat(textvisor);
        resp = num1 * (num2 / 100);
        aux = String.valueOf(resp);
        return aux;
    }

    public String SQRT() {
        num1 = Float.parseFloat(STRING);
        num2 = Float.parseFloat(textvisor);
        resp = Math.pow(num1, num2);
        aux = String.valueOf(resp);
        return aux;
    }

    public String tecladoCalculadora(String string) {
        aux = null;
        textvisor = visor.getText().toString();
        numero = string;

        if (numero == "C") {
            aux = "";
            STRING = aux;
            return aux;
        } else if (numero == "<X") {
            aux = textvisor;
            if (!aux.isEmpty()) aux = aux.substring(0, aux.length() - 1);
            return aux;
        } else if (numero == "+") {
            operador = numero;
            aux = textvisor;
            STRING = aux;
            aux = "";
            return aux;
        } else if (numero == "-") {
            operador = numero;
            aux = textvisor;
            STRING = aux;
            aux = "";
            return aux;
        } else if (numero == "/") {
            operador = numero;
            aux = textvisor;
            STRING = aux;
            aux = "";
            return aux;
        } else if (numero == "*") {
            operador = numero;
            aux = textvisor;
            STRING = aux;
            aux = "";
            return aux;
        } else if (numero == "SQRT") {
            operador = numero;
            aux = textvisor;
            STRING = aux;
            aux = "";
            return aux;
        } else if (numero == "%") {
            return PORCENTAGEM();
        } else if (numero == "=") {
            if (operador == "+")
                return ADICAO();
            if (operador == "-")
                return SUBTRACAO();
            if (operador == "/")
                return DIVISAO();
            if (operador == "*")
                return MULTIPLICACAO();
            if (operador == "SQRT")
                return SQRT();
        }
        aux = textvisor + numero;
        return aux;
    }
}