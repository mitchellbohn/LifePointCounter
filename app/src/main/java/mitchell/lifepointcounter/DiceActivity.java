package mitchell.lifepointcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiceActivity extends AppCompatActivity {

    Button counters;
    Button points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        counters = findViewById(R.id.counters);
        points = findViewById(R.id.points);

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
