package com.upiiz.dm_jlgdc_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 1. Declarar variables, para interactuar con las vistas
    // vistas: boton, texto, entrada de texto, layout

    EditText etPies, etMetros;

    Button btnPies, btnMetros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //2. Enlazar variables con vistas, por lo general el error es NullPointer
        etMetros = findViewById(R.id.etMetros);
        etPies = findViewById(R.id.etPies);
        btnMetros = findViewById(R.id.btnMetros);
        btnPies = findViewById(R.id.btnPies);
        // 3. Procesos varios - excuchar los clicks o touchs

        btnMetros.setOnClickListener(this);
        btnPies.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        // view - puede ser el btnMetros o btnPies
        if(view.getId()==R.id.btnPies){
            //En caso de dar click sobre el boton pies
            convertirMetrosPies();
        }else {
            //En caso de dar click sobre el boton metros
            convertirPiesMetros();
        }
    }
    public void convertirMetrosPies(){
        double metros = Double.parseDouble(etMetros.getText().toString());
        double pies = metros*3.28084;
        etPies.setText(String.valueOf(pies));
    }
    public void convertirPiesMetros(){
        double pies = Double.parseDouble((etPies.getText().toString()));
        double metros = pies / 3.28084;
        etMetros.setText(String.valueOf(metros));
    }
}