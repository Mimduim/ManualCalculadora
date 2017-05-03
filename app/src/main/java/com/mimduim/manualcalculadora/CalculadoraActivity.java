package com.mimduim.manualcalculadora;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         visor = new EditText(this);
         visor.setText("");

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                tecladoCalculadora(btn.getText().toString());
                visor.setCursorVisible(false);
            }};
       /* View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button botao = (Button) view;
                Toast.makeText(CalculadoraActivity.this, "Click: " + botao.getText(), Toast.LENGTH_SHORT).show();
            }
        };*/

        leiaute = new TableLayout(this);

        leiaute.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        leiaute.addView(visor);
        leiaute.setStretchAllColumns(true);

        int cont = 7;
        for (int i = 0; i < 5; i++) {
             linha = new TableRow(this);
            for (int j = 0; j < 4; j++) {
                 botao = new Button(this);
                if (i == 0 && j == 0)
                    botao.setText("C");
                else if (i == 0 && j == 1)
                    botao.setText("Sqrt");
                else if (i == 0 && j == 2)
                    botao.setText("=");
                else if (i == 0 && j == 3)
                    botao.setText("<x");
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
                else if (i == 4 && j == 1)
                    botao.setText("0");
                else if (i == 4 && j == 2)
                    botao.setText("%");
                else
                    botao.setText("" + cont++);
                botao.setOnClickListener(listener);
                linha.addView(botao);
            }
            if (i > 0)
            cont-=6;
            leiaute.addView(linha);
        }
        setContentView(leiaute);
    }

    public void tecladoCalculadora(String lerNumero){
        String aux = null;
        if (visor.getText().toString().trim().equals("")) {
            String textvisor = visor.getText().toString();
            String numero = String.valueOf(lerNumero);
            aux = textvisor + numero;
            visor.setText(aux);
        } else {
            String textvisor = visor.getText().toString();
            String numero = String.valueOf(lerNumero);
            aux = textvisor + numero;
            visor.setText(aux);
        }
    }
}