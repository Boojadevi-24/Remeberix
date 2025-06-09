package com.example.rememberix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    CardView chatbotCard;
    CardView colormatchCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //service 1- chatbot
        chatbotCard = findViewById(R.id.chatbotCard);

        chatbotCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ChatBotActivity.class);
                startActivity(intent);
            }
        });
        // service 2 - gamification
        colormatchCard = findViewById(R.id.colormatchCard);

        colormatchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ColorMatchActivity.class);
                startActivity(intent);
            }
        });

        // Repeat similar blocks for other cards (Images, Health Monitoring, etc.)
    }
}
