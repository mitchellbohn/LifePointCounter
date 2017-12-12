package mitchell.lifepointcounter;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import mitchell.lifepointcounter.db.Counter;
import mitchell.lifepointcounter.db.CounterHelper;

import java.util.ArrayList;

public class CountersActivity extends AppCompatActivity {

    private CounterHelper mHelper;
    private ListView mCounterListView;
    private ArrayAdapter<String> mAdapter;

    Button dice;
    Button points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counters);

        mHelper = new CounterHelper(this);
        mCounterListView = findViewById(R.id.list_counters);

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

        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_counter:
                final EditText counterEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("New Counter")
                        .setMessage("Add a new counter:")
                        .setView(counterEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String counter = String.valueOf(counterEditText.getText());
                                SQLiteDatabase db = mHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                values.put(Counter.CounterEntry.COL_COUNTER_TITLE, counter);
                                db.insertWithOnConflict(Counter.CounterEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                                db.close();
                                updateUI();
                            }
                        })

                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void updateUI() {
        ArrayList<String> counterList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(Counter.CounterEntry.TABLE,
                new String[] {Counter.CounterEntry._ID, Counter.CounterEntry.COL_COUNTER_TITLE}, null, null, null, null, null);

        while(cursor.moveToNext()) {
            int index = cursor.getColumnIndex(Counter.CounterEntry.COL_COUNTER_TITLE);
            counterList.add(cursor.getString(index));
        }

        if(mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this, R.layout.item_counter, R.id.counter_title, counterList);
            mCounterListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(counterList);
            mAdapter.notifyDataSetChanged();
        }
        cursor.close();
        db.close();
    }

    public void deleteCounter(View view) {
        View parent = (View) view.getParent();
        TextView counterTextView = parent.findViewById(R.id.counter_title);
        String counter = String.valueOf(counterTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(Counter.CounterEntry.TABLE, Counter.CounterEntry.COL_COUNTER_TITLE + " = ?", new String[] {counter});
        db.close();
        updateUI();
    }
}
