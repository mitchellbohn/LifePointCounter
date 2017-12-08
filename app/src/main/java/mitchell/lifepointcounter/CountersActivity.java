package mitchell.lifepointcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CountersActivity extends AppCompatActivity {

    Button dice;
    Button points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counters);

        dice = findViewById(R.id.dice);
        points = findViewById(R.id.points);

        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),DiceActivity.class);
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
