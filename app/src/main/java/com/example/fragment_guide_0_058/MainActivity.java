package com.example.fragment_guide_0_058;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment_guide_0_058.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        button1 =mainBinding.button1;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crea una instancia del fragmento MessageFragment
                QuestionFragment fragment = new QuestionFragment();
                // Obtiene el administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();
                // Inicia una transacción de fragmento
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                // Reemplaza el contenido del contenedor con el fragmento MessageFragment
                transaction.replace(mainBinding.container.getId(), fragment);
                // Opcional: añade la transacción a la pila de retroceso
                transaction.addToBackStack(null);
                // Realiza la transacción
                transaction.commit();

            }
        });
    }
}