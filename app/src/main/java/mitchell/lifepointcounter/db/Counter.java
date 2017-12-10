package mitchell.lifepointcounter.db;

import android.provider.BaseColumns;

public class Counter {

    public static final String DB_NAME = "mitchell.lifepointcounter.db";
    public static final int DB_VERSION = 1;

    public class CounterEntry implements BaseColumns{
        public static final String TABLE = "counters";
        public static final String COL_COUNTER_TITLE = "title";
    }
}
