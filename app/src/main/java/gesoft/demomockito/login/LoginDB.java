package gesoft.demomockito.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by yhr on 2016/7/22.
 *
 */

public class LoginDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Login.db";

    public static final int DATABASE_VERSION = 1;

    class LoginTable implements BaseColumns {
        public static final String TABLE_NAME = "login";
        public static final String COLUMN_NAME_NAME = "login_name";
        public static final String COLUMN_NAME_PWD = "login_pwd";
        public static final String COLUMN_NAME_COUNTER = "login_counter";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + LoginTable.TABLE_NAME + " (" +
                    LoginTable._ID + " TEXT PRIMARY KEY," +
                    LoginTable.COLUMN_NAME_NAME + " TEXT, " +
                    LoginTable.COLUMN_NAME_PWD + " TEXT, " +
                    LoginTable.COLUMN_NAME_COUNTER + " INTEGER " +
                    " )";

    public LoginDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
