package com.example.gununnotu;

import android.content.Intent; // Bunu ekledik
import android.os.Bundle;
import android.view.View; // Bunu ekledik
import android.widget.Button; // Bunu ekledik
import android.widget.TextView; // Bunu ekledik

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    // 1. ADIM: Tasarımdaki bileşenleri burada tanımlıyoruz
    private TextView textViewNotGoster;
    private Button buttonGeriDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Android Studio'nun orijinal pencere kenar boşluğu (Padding) kodu
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. ADIM: Bileşenleri XML'deki id'lerine göre Java'ya bağlıyoruz
        // Eğer XML tarafında id'leri farklı verdiysen parantez içlerini ona göre düzeltmelisin
        textViewNotGoster = findViewById(R.id.textViewNotGoster);
        buttonGeriDon = findViewById(R.id.buttonGeriDon);

        // 3. ADIM: Intent Yakalama ve Metni TextView'a Set Etme
        // İlk sayfadan (MainActivity) gönderilen Intent nesnesini yakalıyoruz
        Intent gelenIntent = getIntent();

        // Intent'in içindeki "not_anahtari" isimli string veriyi çekiyoruz
        String gelenNot = gelenIntent.getStringExtra("not_anahtari");

        // Eğer gelen veri boş değilse, tasarımdaki TextView'a bu notu yazdırıyoruz
        if (gelenNot != null) {
            textViewNotGoster.setText(gelenNot);
        }

        // 4. ADIM: "Yeni Not Yaz" butonuna basınca ilk ekrana geri dönme mantığı
        buttonGeriDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish() mevcut sayfayı kapatır ve bizi bir önceki sayfaya döndürür
                finish();
            }
        });
    }
}