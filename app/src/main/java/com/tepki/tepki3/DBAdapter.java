package com.tepki.tepki3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;


import java.util.ArrayList;

/**
 * Created by x on 08.08.2017.
 */

public class DBAdapter extends BaseAdapter {
    static final String ROWID = "id";
    static final String NAME = "name";
    static final String POSITION = "position";
    static final String TAG = "DBAdapter";
    static final String DBNAME = "veritabani";
    static final String TBNAME = "veritabanim";
    static final int DBVERSION = '1';

    static final String CREATE_veritabanim = "CREATE TABLE veritabanim(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,position TEXT NOT NULL);";

    final Context c;
    SQLiteDatabase db;
    DBHelper helper;

    ArrayList<Favori> favoriler;


    public DBAdapter(Context c, ArrayList<Favori> favoriler) {
        this.c = c;
        helper = new DBHelper(c);
        this.favoriler = favoriler;
        Log.w("deneme", "gelir mi constructor");
    }


    @Override
    public int getCount() {
        return favoriler.size();
    }

    @Override
    public Object getItem(int pos) {
        return favoriler.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return favoriler.indexOf(getItem(pos));
    }

    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model2, null);
        }
        Button button = convertView.findViewById(R.id.button);
        button.setText(favoriler.get(pos).getImg());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((GridView)parent).performItemClick(view,pos,0);
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        return convertView;
    }

    private static class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context) {
            super(context, DBNAME, null, DBVERSION);
            Log.w("deneme", "gelir mi45");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                Log.w("deneme", "gelir mi65");
                db.execSQL(CREATE_veritabanim);
                //db.execSQL("DROP TABLE IF EXISTS veritabanim");
                Log.w("deneme", "bisiler");
            } catch (SQLException e) {
                Log.w("deneme", "gelmedi2");
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading DB");
            db.execSQL("DROP TABLE IF EXISTS veritabanim");
            onCreate(db);
        }

    }

    public DBAdapter openDB() {
        try {
            db = helper.getWritableDatabase();
            Log.w("deneme", "gel");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.w("deneme", "gelme");
        }
        return this;
    }

    public void close() {
        helper.close();
    }

    public long add(String name, String uri) {
        try {
            ContentValues cv = new ContentValues();
            //cv.clear();
            cv.put(NAME, name);
            cv.put(POSITION, uri);
            Log.w("deneme", "ge");
            //cv.clear();
            return db.insert(TBNAME, ROWID, cv);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean deleteTitle(String uri)
    {
        Log.w("deneme1", "13");
        return db.delete(TBNAME,"name=?",new String[]{uri})>0;
    }

    public Cursor getAllValues() {
        String[] columns = {ROWID, NAME, POSITION};
        Log.w("deneme", "g");
        return db.query(TBNAME, columns, null, null, null, null, null);
    }

}
