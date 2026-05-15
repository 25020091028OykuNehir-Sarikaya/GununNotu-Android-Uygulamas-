package com.example.gununnotu;

import android.content.Intent; // Bunu ekledik
import android.os.Bundle;
import android.view.View; // Bunu ekledik
import android.widget.Button; // Bunu ekledik
import android.widget.EditText; // Bunu ekledik

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. ADIM: Tasarımdaki bileşenleri burada tanımlıyoruz
    private EditText editTextNot;
    private Button buttonKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Android Studio'nun otomatik pencere kenar boşluğu (Padding) kodu
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. ADIM: Bileşenleri XML'deki id'lerine göre Java'ya bağlıyoruz
        // Eğer XML tarafında id'leri farklı verdiysen parantez içlerini ona göre düzeltmelisin
        editTextNot = findViewById(R.id.editTextNot);
        buttonKaydet = findViewById(R.id.buttonKaydet);

        // 3. ADIM: Butona tıklama olayını ve Intent mantığını yazıyoruz
        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText içindeki notu string metne çevirip alıyoruz
                String girilenNot = editTextNot.getText().toString();

                // MainActivity'den DetailActivity'ye gitmek için Intent (köprü) kuruyoruz
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                // Veriyi "not_anahtari" ismiyle paketleyip Intent içine koyuyoruz
                intent.putExtra("not_anahtari", girilenNot);

                // İkinci ekranı başlatıyoruz
                startActivity(intent);
            }
        });
    }
}