package com.mohammed.guidofmaysan.SQLitePackage;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.mohammed.guidofmaysan.RecyclerView.InfoModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    private String dbPath;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private static String dbName="maysan.db3";

    public SQLiteHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
        this.context = context;
        dbPath = context.getApplicationInfo().dataDir + "/databases/";
        copyAndCheckExisting();
    }

    private void copyAndCheckExisting() {
        getReadableDatabase();
        File file=new File(dbPath);
        try {
            copyDbFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
            close();
    }

    private void copyDbFile() throws IOException {
        InputStream inputStream = context.getAssets().open(dbName);
        OutputStream outputStream = new FileOutputStream(dbPath + dbName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public List<InfoModel> getAll(String tableName, int i) {
        sqLiteDatabase = getReadableDatabase();
        List<InfoModel> temp = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(tableName, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            InfoModel infoModel =
                    new InfoModel(cursor.getInt(0), cursor.getString(i),
                            cursor.getBlob(2), cursor.getDouble(3),
                            cursor.getDouble(4));
            temp.add(infoModel);
        }
        cursor.close();
        sqLiteDatabase.close();
        return temp;
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.disableWriteAheadLogging();
    }


}
