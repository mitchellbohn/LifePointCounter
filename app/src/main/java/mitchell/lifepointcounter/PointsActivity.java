package mitchell.lifepointcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PointsActivity extends AppCompatActivity {
    Button p1add1000;
    Button p1add100;
    Button p1add10;
    Button p1add1;
    Button p1sub1000;
    Button p1sub100;
    Button p1sub10;
    Button p1sub1;
    TextView p1points;
    Button p2add1000;
    Button p2add100;
    Button p2add10;
    Button p2add1;
    Button p2sub1000;
    Button p2sub100;
    Button p2sub10;
    Button p2sub1;
    TextView p2points;
    Button reset;
    Button dice;
    Button counters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        p1add1000 = findViewById(R.id.p1add1000);
        p1add100 = findViewById(R.id.p1add100);
        p1add10 = findViewById(R.id.p1add10);
        p1add1 = findViewById(R.id.p1add1);
        p1sub1000 = findViewById(R.id.p1sub1000);
        p1sub100 = findViewById(R.id.p1sub100);
        p1sub10 = findViewById(R.id.p1sub10);
        p1sub1 = findViewById(R.id.p1sub1);
        p1points = findViewById(R.id.p1points);
        p2add1000 = findViewById(R.id.p2add1000);
        p2add100 = findViewById(R.id.p2add100);
        p2add10 = findViewById(R.id.p2add10);
        p2add1 = findViewById(R.id.p2add1);
        p2sub1000 = findViewById(R.id.p2sub1000);
        p2sub100 = findViewById(R.id.p2sub100);
        p2sub10 = findViewById(R.id.p2sub10);
        p2sub1 = findViewById(R.id.p2sub1);
        p2points = findViewById(R.id.p2points);
        reset = findViewById(R.id.reset);
        dice = findViewById(R.id.dice);
        counters = findViewById(R.id.counters);

        p1add1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue = countValue + 1000;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1add100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue = countValue + 100;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1add10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue = countValue + 10;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue++;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1sub1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue = countValue - 1000;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1sub100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue = countValue - 100;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1sub10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue = countValue - 10;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p1sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p1points.getText().toString());
                countValue--;
                p1points.setText(String.valueOf(countValue));
            }
        });

        p2add1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue = countValue + 1000;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2add100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue = countValue + 100;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2add10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue = countValue + 10;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue++;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2sub1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue = countValue - 1000;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2sub100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue = countValue - 100;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2sub10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue = countValue - 10;
                p2points.setText(String.valueOf(countValue));
            }
        });

        p2sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countValue = Integer.parseInt(p2points.getText().toString());
                countValue--;
                p2points.setText(String.valueOf(countValue));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1points.setText(String.valueOf("8000"));
                p2points.setText(String.valueOf("8000"));
            }
        });

        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),DiceActivity.class);
                startActivity(intent);
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

    }
}
