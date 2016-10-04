package com.mario22gmail.vasile.projecthamburger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mario Vasile on 8/28/2016.
 */
public class FeedHelperSql extends SQLiteOpenHelper {

    public static final int dbVersion = 12;
    public static final String DataBaseName = "FastFood";

    private FeedHelperSql(Context context)
    {
        super(context,DataBaseName, null, dbVersion);
    }

    private static FeedHelperSql instance;

    public static synchronized FeedHelperSql getHelper(Context context)
    {
        if(instance == null)
        {
            instance = new FeedHelperSql(context);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerSpecial);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerDublu);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerSunca);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerMediu);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerCheese);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerCartofi);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerSimplu);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateHamburgerVegetarian);
        sqLiteDatabase.execSQL(SqlConstants.SqlCommandCreateSandwitch);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ SqlConstants.HamburgerSpecialTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerDubluTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerSuncaTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerMediuTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerCheeseTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerCartofiTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerSimpluTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.HamburgerVegetarianTable);
        db.execSQL("DROP TABLE IF EXISTS " + SqlConstants.SandwichTable);

        onCreate(db);
    }
}
