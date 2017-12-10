package mitchell.lifepointcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    Button random;
    Button counters;
    Button points;
    TextView roll;
    Button reset_dice;
    NumberPicker sides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        random = findViewById(R.id.random);
        roll = findViewById(R.id.roll);
        counters = findViewById(R.id.counters);
        points = findViewById(R.id.points);
        reset_dice = findViewById(R.id.reset_dice);
        sides = findViewById(R.id.num_sides);
        sides.setMinValue(2);
        sides.setMaxValue(20);

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rollValue = new Random();
                int number = rollValue.nextInt(sides.getValue()) + 1;
                roll.setText(String.valueOf(number));
            }
        });

        reset_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll.setText("X");
            }
        });

        counters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),CountersActivity.class);
                startActivity(intent);
            }
        });

        points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),PointsActivity.class);
                startActivity(intent);
            }
        });
    }
}
