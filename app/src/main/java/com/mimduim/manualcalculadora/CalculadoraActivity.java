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
    private String string = "";
    private String aux, textvisor, textnextvisor, operador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        visor = new EditText(this);
        visor.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        visor.setGravity(View.TEXT_ALIGNMENT_CENTER);
        visor.setTextSize(70);
        visor.setSingleLine(true);
        visor.setBackgroundColor(Color.parseColor("#000000"));
        visor.setTextColor(Color.parseColor("#2ecc71"));
        visor.setCursorVisible(false);
        visor.setText("");

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                visor.setText(tecladoCalculadora(btn.getText().toString()));
            }
        };


        tableCreate(listener);
    }

    public void tableCreate(View.OnClickListener listener) {
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
            linha.setPadding(5, 5, 5, 5);
            for (int j = 0; j < 4; j++) {
                botao = new Button(this);
                botao.setTextSize(30);
                botao.setPadding(5, 5, 5, 5);
                botao.setTextColor(Color.parseColor("#19B5FE"));
                botao.setBackgroundColor(Color.parseColor("#000000"));


                if (i == 0 && j == 0)
                    botao.setText("C");
                else if (i == 0 && j == 1)
                    botao.setText("√");
                else if (i == 0 && j == 2)
                    botao.setText("=");
                else if (i == 0 && j == 3)
                    botao.setText("◄");
                else if (i == 1 && j == 3)
                    botao.setText("+");
                else if (i == 2 && j == 3)
                    botao.setText("-");
                else if (i == 3 && j == 3)
                    botao.setText("÷");
                else if (i == 4 && j == 3)
                    botao.setText("×");
                else if (i == 4 && j == 0)
                    botao.setText(".");
                else if (i == 4 && j == 1) {
                    botao.setText("0");
                } else if (i == 4 && j == 2)
                    botao.setText("٪");
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

    public String adicao() {
        num1 = Float.parseFloat(string);
        num2 = Float.parseFloat(textvisor);
        resp = num1 + num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String subtracao() {
        num1 = Float.parseFloat(string);
        num2 = Float.parseFloat(textvisor);
        resp = num1 - num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String divisao() {
        num1 = Float.parseFloat(string);
        num2 = Float.parseFloat(textvisor);
        resp = num1 / num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String multiplicacao() {
        num1 = Float.parseFloat(string);
        num2 = Float.parseFloat(textvisor);
        resp = num1 * num2;
        aux = String.valueOf(resp);
        return aux;
    }

    public String porcentagem() {
        num1 = Float.parseFloat(string);
        num2 = Float.parseFloat(textvisor);
        resp = num1 * (num2 / 100);
        aux = String.valueOf(resp);
        return aux;
    }

    public String sqrt() {
        num1 = Float.parseFloat(string);
        resp = Math.sqrt(num1);
        aux = String.valueOf(resp);
        return aux;
    }

    public String tecladoCalculadora(String str) {
        aux = null;
        textvisor = visor.getText().toString();
        textnextvisor = str;

        if (textnextvisor == "C") {
            aux = "";
            string = aux;
            return aux;
        } else if (textnextvisor == "◄") {
            aux = textvisor;
            if (!aux.isEmpty()) aux = aux.substring(0, aux.length() - 1);
            return aux;
        } else if (textnextvisor == "+") {
            operador = textnextvisor;
            aux = textvisor;
            string = aux;
            aux = "";
            return aux;
        } else if (textnextvisor == "-") {
            operador = textnextvisor;
            aux = textvisor;
            string = aux;
            aux = "";
            return aux;
        } else if (textnextvisor == "÷") {
            operador = textnextvisor;
            aux = textvisor;
            string = aux;
            aux = "";
            return aux;
        } else if (textnextvisor == "×") {
            operador = textnextvisor;
            aux = textvisor;
            string = aux;
            aux = "";
            return aux;
        } else if (textnextvisor == "√") {
            operador = textnextvisor;
            aux = textvisor;
            string = aux;
            aux = "";
            return aux;
        } else if (textnextvisor == "٪") {
            return porcentagem();
        } else if (textnextvisor == "=" && textvisor != "") {
            if (operador == "+")
                return adicao();
            else if (operador == "-")
                return subtracao();
            else if (operador == "÷")
                return divisao();
            else if (operador == "×")
                return multiplicacao();
            else if (operador == "√")
                return sqrt();
        } else if (textnextvisor == "=" || textnextvisor == "+" || textnextvisor == "-" || textnextvisor == "×" || textnextvisor == "÷"
                || textnextvisor == "√" || textnextvisor == "٪" && textvisor == "") {
            return "";
        }
        aux = textvisor + textnextvisor;
        return aux;
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}