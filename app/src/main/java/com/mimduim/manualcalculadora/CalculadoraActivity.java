package com.mimduim.manualcalculadora;

        import android.app.ActionBar;
        import android.app.Notification;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AbsoluteLayout;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TableLayout;
        import android.widget.TableRow;
        import android.widget.TextView;
        import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button botao = (Button) view;
                Toast.makeText(CalculadoraActivity.this, "Click: " + botao.getText(), Toast.LENGTH_SHORT).show();
            }
        };

        TableLayout leiaute = new TableLayout(this);


        leiaute.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));


        TableRow header = new TableRow(this);
        EditText valor = new EditText(this);
        valor.setEms(14);

        header.addView(valor);

        leiaute.addView(header);

        leiaute.setStretchAllColumns(true);

        int cont = 7;
        for (int i = 0; i < 3; i++) {
            TableRow linha = new TableRow(this);
            for (int j = 0; j < 3; j++) {
                Button botao = new Button(this);
                botao.setText("" + cont++);
                botao.setOnClickListener(listener);
                linha.addView(botao);
            }
            cont-=6;
            leiaute.addView(linha);
        }


        setContentView(leiaute);
    }
}
