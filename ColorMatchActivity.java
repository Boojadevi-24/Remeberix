package com.example.rememberix;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class ColorMatchActivity extends AppCompatActivity {

    View colorDisplay;
    Button option1, option2, option3;
    TextView scoreText;

    int score = 0;
    String correctColor = "";

    List<String> colors = Arrays.asList("Red", "Green", "Blue", "Yellow", "Cyan");
    Map<String, Integer> colorMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match);

        colorDisplay = findViewById(R.id.colorDisplay);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        scoreText = findViewById(R.id.scoreText);

        // Map color names to actual colors
        colorMap.put("Red", Color.RED);
        colorMap.put("Green", Color.GREEN);
        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Yellow", Color.YELLOW);
        colorMap.put("Cyan", Color.CYAN);

        setNewColor();

        // Add listeners to buttons
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                checkAnswer(b.getText().toString());
            }
        };

        option1.setOnClickListener(listener);
        option2.setOnClickListener(listener);
        option3.setOnClickListener(listener);
    }

    private void setNewColor() {
        Random rand = new Random();
        correctColor = colors.get(rand.nextInt(colors.size()));
        colorDisplay.setBackgroundColor(colorMap.get(correctColor));

        // Pick 2 wrong options
        List<String> tempColors = new ArrayList<>(colors);
        tempColors.remove(correctColor);
        Collections.shuffle(tempColors);
        List<String> options = new ArrayList<>();
        options.add(correctColor);
        options.add(tempColors.get(0));
        options.add(tempColors.get(1));
        Collections.shuffle(options);

        option1.setText(options.get(0));
        option2.setText(options.get(1));
        option3.setText(options.get(2));
    }

    private void checkAnswer(String selected) {
        if (selected.equals(correctColor)) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            score = 0;
        }
        scoreText.setText("Score: " + score);
        setNewColor();
    }
}