package com.bella.fm.framwork.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bella.fm.App;
import com.bella.fm.framwork.Constants;
import com.bella.fm.framwork.base.BaseModel;


/**
 *  * author：yangzhidan on 2016/10/12 15:05
 *  * function: 数据库帮助类
 *  
 */
public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper dbHelper;

    public static DBHelper getInstence() {
        if (dbHelper == null)
            dbHelper = new DBHelper(App.getApplication().getApplicationContext());
        return dbHelper;
    }

    private DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表(第一次安装app的时候onCreate才执行)

        // getReadableDatabase();//主要用于查询
        // write;//增，删，改

        try {
            for (int i = 0; i < Constants.TABLES.length; i++) {
                Class<BaseModel> baseModelClass = (Class<BaseModel>) Class.forName(Constants.TABLES[i]);//根据类名反射拿到Class
                BaseModel baseModel = baseModelClass.newInstance();//根据Class拿到对象
                db.execSQL(baseModel.getCreateTableSql());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 数据库升级
     *
     * @param sqLiteDatabase
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {



    }



}
