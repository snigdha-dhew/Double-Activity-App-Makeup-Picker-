package com.example.doubleactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Activity2 extends AppCompatActivity {
    public static final String Product = "product_brands";
    private MakeupExpert expert = new MakeupExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String p_type = intent.getStringExtra(Product);
        TextView product_type= (TextView)findViewById(R.id.productName);
        TextView brands= (TextView)findViewById(R.id.T1_brands);
        product_type.setText(p_type);


        List<String> brandsList = expert.getbrands(p_type);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);
        //done
    }
}