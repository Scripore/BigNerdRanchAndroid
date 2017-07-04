package com.example.mac.greater_or_less;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int left_number;
    private int right_number;

    private Button leftButton;
    private Button rightButton;

    private TextView points;
    private int points_counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = (TextView) findViewById(R.id.points_label);

        generateNumbers();

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(leftButton);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAnswer(rightButton);
            }
        });

    }

    public void generateNumbers() {
        Random rand = new Random();
        left_number = rand.nextInt(10);
        right_number = rand.nextInt(10);

        leftButton = (Button) findViewById(R.id.left_button);
        rightButton = (Button) findViewById(R.id.right_button);

        leftButton.setText(Integer.toString(left_number));
        rightButton.setText(Integer.toString(right_number));


    }

    private void checkAnswer(Button button) {
        int result_string_id;
        if (button == leftButton) {
            result_string_id = (left_number >= right_number) ? R.string.correct : R.string.incorrect;
        } else {
            result_string_id = (left_number <= right_number) ? R.string.correct : R.string.incorrect;
        }

        if (result_string_id == R.string.correct) {
            points_counter += 1;
        } else {
            points_counter -= 1;
        }

        points.setText(Integer.toString(points_counter));

        Toast.makeText(MainActivity.this, result_string_id, Toast.LENGTH_SHORT).show();
        generateNumbers();
    }


}
