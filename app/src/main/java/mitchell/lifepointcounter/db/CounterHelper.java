package mitchell.lifepointcounter.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CounterHelper extends SQLiteOpenHelper{

    public CounterHelper(Context context) {
        super(context, Counter.DB_NAME, null, Counter.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Counter.CounterEntry.TABLE + " ( " +
                                               Counter.CounterEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                               Counter.CounterEntry.COL_COUNTER_TITLE + " TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Counter.CounterEntry.TABLE);
        onCreate(db);
    }
}
