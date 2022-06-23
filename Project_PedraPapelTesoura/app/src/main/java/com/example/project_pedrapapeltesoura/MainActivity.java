package com.example.project_pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imageResulado = findViewById(R.id.imageResultado);
        TextView textoReseultado = findViewById(R.id.textView2);

        int numero = new Random().nextInt(3); //0, 1, 2
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaAPP = opcoes[numero];

        switch (escolhaAPP) {
            case "Pedra":
                imageResulado.setImageResource(R.drawable.pedra); //configurando uma imgagem a partir de um recurso.
                break;
            case "Papel":
                imageResulado.setImageResource(R.drawable.papel); //configurando uma imgagem a partir de um recurso.
                break;
            case "Tesoura":
                imageResulado.setImageResource(R.drawable.tesoura); //configurando uma imgagem a partir de um recurso.
                break;
        }

        //System.out.println(" o item clicado e:" + opcaoAPP);

        if (
                (escolhaAPP == "Tesoura" && escolhaUsuario == "Papel") || (escolhaAPP == "Papel" && escolhaUsuario == "Pedra") || (escolhaAPP == "Pedra" && escolhaUsuario == "Tesoura")
        ) {//appGanhador
            textoReseultado.setText("Você perdeu :(");

        } else if (
                (escolhaUsuario == "Tesoura" && escolhaAPP == "Papel") || (escolhaUsuario == "Papel" && escolhaAPP == "Pedra") || (escolhaUsuario == "Pedra" && escolhaAPP == "Tesoura")
        ) { //usuarioGanhador
            textoReseultado.setText("Você ganhou :)");

        } else {//emapate
            textoReseultado.setText("Empatamos ;)");
        }


    }
}
