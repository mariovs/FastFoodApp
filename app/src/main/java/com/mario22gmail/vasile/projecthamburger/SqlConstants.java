package com.mario22gmail.vasile.projecthamburger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mario Vasile on 8/28/2016.
 */
public class SqlConstants {

    //CONSTANTE NUME TABELE
    public static String Hamburger1TableName = "HamburgerTable";
    public static final String HamburgerSpecialTable = "HamburgerSpecial";
    public static final String HamburgerDubluTable = "HamburgerDublu";
    public static final String HamburgerSuncaTable = "HamburgerSunca";
    public static final String HamburgerMediuTable = "HamburgerMediu";
    public static final String HamburgerCheeseTable = "Cheeseburger";
    public static final String HamburgerCartofiTable = "HamburgerCartofi";
    public static final String HamburgerSimpluTable = "HamburgerSimplu";
    public static final String HamburgerVegetarianTable = "HamburgerVegetarian";
    public static final String SandwichTable = "Sandwitch";


    //CONSTANTE NUME COLOANE
    public static String ColoanaCarne = "Carne";
    public static String ColoanaPaine = "Chifle";
    public static String ColoanaCascaval = "Cascaval";
    public static String ColoanaMaioneza = "Maioneza";
    public static String ColoanaMustar = "Mustar";
    public static String ColoanaCartofi = "Cartofi";
    public static String ColoanaKetchup = "Ketchup";
    public static String ColoanaSunca = "Sunca";
    public static String ColoanaSalata = "Salata";
    public static String ColoanaHochland = "Hochland";
    public static String ColoanaCastravetiMurati ="CastravetiMurati";
    public static String ColoanaId = "Id";
    public static String ColoanaDataVanzare = "DataVanzare";
    public static String ColoanaPret = "Pret";

    ///CONSTANTE VALORI COLOANE
    public static int ValoareCarne = 1; //buc
    public static int ValoareCarneSpecial = 2;
    public static int ValoarePaine = 1;//buc
    public static int ValoareCascaval = 1;//buc
    public static int ValoareMaioneza = 20;
    public static int ValoareMustar = 20; //ml
    public static int ValoareCartofi = 30; //g
    public static int ValoareKetchup = 20; //ml
    public static int ValoareSunca = 1; //buc
    public static int ValoareCastraveti = 30; //g
    public static int ValoareSalata = 30; //g
    public static int ValoareHochland = 1; //buc

    //preturi
    public static double PretHamburgerSpecial = 9;
    public static double PretHamburgerDublu = 8;
    public static double PretHamburgerSunca = 7.5;
    public static double PretHamburgerMediu = 6.5;
    public static double PretHamburgerCheese = 6.5;
    public static double PretHamburgerCartofi = 5;
    public static double PretHamburgerSimplu = 4;
    public static double PretHamburgerVegetarian = 4;
    public static double PretSandwitch = 6;


    public static String AddCurrentTimeToTable = " DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'LOCALTIME'))";
    public static String Comma_SEP = ",";
    public static String Id = "id";


    /// create table command
    public final static String SqlCommandCreateHamburgerSpecial = "CREATE TABLE " + HamburgerSpecialTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaSunca
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaCascaval
            + Comma_SEP + ColoanaPret + ")";

    public final static String SqlCommandCreateHamburgerDublu = "CREATE TABLE " + HamburgerDubluTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaCascaval
            + Comma_SEP + ColoanaPret + ")";

    public final static String SqlCommandCreateHamburgerSunca = "CREATE TABLE " + HamburgerSuncaTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaSunca
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaCascaval
            + Comma_SEP + ColoanaPret + ")";

    public static final String SqlCommandCreateHamburgerMediu = "CREATE TABLE " + HamburgerMediuTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaCascaval
            + Comma_SEP + ColoanaPret + ")";

    public static  final String SqlCommandCreateHamburgerCheese = "CREATE TABLE " + HamburgerCheeseTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaCastravetiMurati
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaHochland
            + Comma_SEP + ColoanaPret + ")";

    public static final String SqlCommandCreateHamburgerCartofi = "CREATE TABLE " + HamburgerCartofiTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaPret + ")";

    public static final String SqlCommandCreateHamburgerSimplu = "CREATE TABLE " + HamburgerSimpluTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCarne
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaPret + ")";

    public static final String SqlCommandCreateHamburgerVegetarian = "CREATE TABLE " + HamburgerVegetarianTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaCascaval
            + Comma_SEP + ColoanaPret + ")";

    public static final String SqlCommandCreateSandwitch= "CREATE TABLE " + SandwichTable
            + " (" + ColoanaId + " INTEGER PRIMARY KEY"
            + Comma_SEP + ColoanaDataVanzare + AddCurrentTimeToTable
            + Comma_SEP + ColoanaPaine
            + Comma_SEP + ColoanaMaioneza
            + Comma_SEP + ColoanaSalata
            + Comma_SEP + ColoanaSunca
            + Comma_SEP + ColoanaCartofi
            + Comma_SEP + ColoanaKetchup
            + Comma_SEP + ColoanaCascaval
            + Comma_SEP + ColoanaPret + ")";



    ///
    /// Metode generale

    public static void AddHamburger(Context context, String hamburgerTable, int count) {
        try {
            ContentValues hamburgerValues = GetHamburgerValues(hamburgerTable);
            FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
            SQLiteDatabase db = sqlHelper.getWritableDatabase();
            for (int i = 0; i < count; i++) {
                db.insert(hamburgerTable, null, hamburgerValues);
            }
            db.close();
            sqlHelper.close();
        }catch (Exception ex)
        {
            Toast.makeText(context, "Eroare la adaugare", Toast.LENGTH_SHORT).show();
            Log.i("Hamburger error", ex.getMessage());
        }
    }


    public static void DeleteLastHamburger(Context context, String tableName) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        String maxIdQuery = "SELECT MAX(" + ColoanaId + ") FROM " + tableName;
        Cursor cursor = db.rawQuery(maxIdQuery, null);
        cursor.moveToFirst();
        int maxId = cursor.getInt(0);

        cursor.close();
        db.delete(tableName, ColoanaId + "=?", new String[]{maxId + ""});
        db.close();
    }


    public static int GetNumberOfHamburgerSold(Context context, String tableName, Date date) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormated = formatDate.format(date);

        String countQuery = "select count(*) from " + tableName + " " + "WHERE " + ColoanaDataVanzare + " LIKE '" + dateFormated + "%'";
        Cursor cursorCount = db.rawQuery(countQuery, null);
        cursorCount.moveToFirst();
        int countHamburger = cursorCount.getInt(0);

        cursorCount.close();
        db.close();

        return countHamburger;
    }

    public static int GetNumberOfHamburgerSoldToday(Context context, String tableName) {
        Calendar calendar = Calendar.getInstance();
        int hamburgerSold = GetNumberOfHamburgerSold(context, tableName, calendar.getTime());
        return hamburgerSold;
    }


    public static int GetNumberOfHamburgerSold(Context context,String tableName, Date dateFrom, Date dateTo)
    {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateFromFormated = formatDate.format(dateFrom);
        String dateToFormated = formatDate.format(dateTo);

        String countQuery = "select count(*) from " + tableName +
                " " + "WHERE " + ColoanaDataVanzare +" >= '" + dateFromFormated + " 00:00:00'" +
                " and " + ColoanaDataVanzare + " <= '" +dateToFormated +" 23:59:59'";
        Cursor cursorCount = db.rawQuery(countQuery, null);
        cursorCount.moveToFirst();
        int countHamburger = cursorCount.getInt(0);

        cursorCount.close();
        db.close();

        return countHamburger;

        ///select * from tbl_name where Attribute_name between 'yyyy-mm-dd' and 'yyyy-mm-dd';
        //return 0;
    }

    private static int GetHamburgerSpecificValue(Context context, String tableName, String propertyName, Date dateFrom, Date dateTo)
    {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        int valueFromDb;
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            String dateFromFormated = formatDate.format(dateFrom);
            String dateToFormated = formatDate.format(dateTo);

            String countQuery = "select SUM(" + propertyName + ") from " + tableName +
                    " " + "WHERE " + ColoanaDataVanzare + " >= '" + dateFromFormated + " 00:00:00'" +
                    " and " + ColoanaDataVanzare + " <= '" + dateToFormated + " 23:59:59'";

            Cursor cursorCount = db.rawQuery(countQuery, null);
            cursorCount.moveToFirst();
            valueFromDb = cursorCount.getInt(0);

            cursorCount.close();
        }
        catch (Exception ex)
        {
            throw ex;
        }
        db.close();

        return valueFromDb;

    }



    private static int GetHamburgerSpecificValue(SQLiteDatabase db, String tableName, String propertyName, Date dateTo)
    {

        int valueFromDb = 0;
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            String dateToFormated = formatDate.format(dateTo);

            String countQuery = "select SUM(" + propertyName + ") from " + tableName +
                    " " + "WHERE " + ColoanaDataVanzare + " LIKE '" + dateToFormated + "%'";

            Cursor cursorCount = db.rawQuery(countQuery, null);
            cursorCount.moveToFirst();
            valueFromDb = cursorCount.getInt(0);

            cursorCount.close();

        }
        catch (Exception ex)
        {
            throw ex;
        }


        return valueFromDb;
    }



    public static int GetCartofiPrajiti(Context context, Date dateFrom, Date dateTo)
    {
        int cartofiPrajitiSpecial = GetHamburgerSpecificValue(context,SqlConstants.HamburgerSpecialTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);
        int cartofiPrajitiDublu = GetHamburgerSpecificValue(context,SqlConstants.HamburgerDubluTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);
        int cartofiPrajitiSunca = GetHamburgerSpecificValue(context,SqlConstants.HamburgerSuncaTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);
        int cartofiPrajitiMediu = GetHamburgerSpecificValue(context,SqlConstants.HamburgerMediuTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);
        int cartofiPrajitiCartofi = GetHamburgerSpecificValue(context,SqlConstants.HamburgerCartofiTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);
        int cartofiPrajitiVegetarian = GetHamburgerSpecificValue(context,SqlConstants.HamburgerVegetarianTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);
        int cartofiPrajitiSandwich = GetHamburgerSpecificValue(context,SqlConstants.SandwichTable,SqlConstants.ColoanaCartofi,dateFrom,dateTo);

        int totalAmountCartofi = cartofiPrajitiSpecial + cartofiPrajitiDublu + cartofiPrajitiSunca
                + cartofiPrajitiMediu + cartofiPrajitiCartofi + cartofiPrajitiVegetarian + cartofiPrajitiSandwich;
        return totalAmountCartofi;
    }

    public static int GetCartofiPrajiti(Context context, Date dateFrom)
    {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        int cartofiPrajitiSpecial = GetHamburgerSpecificValue(db,SqlConstants.HamburgerSpecialTable,SqlConstants.ColoanaCartofi,dateFrom);
        int cartofiPrajitiDublu = GetHamburgerSpecificValue(db,SqlConstants.HamburgerDubluTable,SqlConstants.ColoanaCartofi,dateFrom);
        int cartofiPrajitiSunca = GetHamburgerSpecificValue(db,SqlConstants.HamburgerSuncaTable,SqlConstants.ColoanaCartofi,dateFrom);
        int cartofiPrajitiMediu = GetHamburgerSpecificValue(db,SqlConstants.HamburgerMediuTable,SqlConstants.ColoanaCartofi,dateFrom);
        int cartofiPrajitiCartofi = GetHamburgerSpecificValue(db,SqlConstants.HamburgerCartofiTable,SqlConstants.ColoanaCartofi,dateFrom);
        int cartofiPrajitiVegetarian = GetHamburgerSpecificValue(db,SqlConstants.HamburgerVegetarianTable,SqlConstants.ColoanaCartofi,dateFrom);
        int cartofiPrajitiSandwich = GetHamburgerSpecificValue(db,SqlConstants.SandwichTable,SqlConstants.ColoanaCartofi,dateFrom);
        db.close();
        int totalAmountCartofi = cartofiPrajitiSpecial + cartofiPrajitiDublu + cartofiPrajitiSunca
                + cartofiPrajitiMediu + cartofiPrajitiCartofi + cartofiPrajitiVegetarian + cartofiPrajitiSandwich;
        return totalAmountCartofi;
    }

    public static ContentValues GetHamburgerValues(String hamburger1TableName) throws Exception {
        switch (hamburger1TableName) {
            case SqlConstants.HamburgerSpecialTable:

                android.content.ContentValues valuesSpecial = new android.content.ContentValues();
                valuesSpecial.put(ColoanaPaine, ValoarePaine);
                valuesSpecial.put(ColoanaMaioneza, ValoareMaioneza);
                valuesSpecial.put(ColoanaSalata, ValoareSalata);
                valuesSpecial.put(ColoanaCarne, ValoareCarneSpecial);
                valuesSpecial.put(ColoanaSunca, ValoareSunca);
                valuesSpecial.put(ColoanaCartofi, ValoareCartofi);
                valuesSpecial.put(ColoanaKetchup, ValoareKetchup);
                valuesSpecial.put(ColoanaCascaval, ValoareCascaval);
                valuesSpecial.put(ColoanaPret, PretHamburgerSpecial);
                return valuesSpecial;

            case SqlConstants.HamburgerDubluTable:
                android.content.ContentValues valuesDublu = new android.content.ContentValues();
                valuesDublu.put(ColoanaPaine, ValoarePaine);
                valuesDublu.put(ColoanaMaioneza, ValoareMaioneza);
                valuesDublu.put(ColoanaSalata, ValoareSalata);
                valuesDublu.put(ColoanaCarne, ValoareCarneSpecial);
                valuesDublu.put(ColoanaCartofi, ValoareCartofi);
                valuesDublu.put(ColoanaKetchup, ValoareKetchup);
                valuesDublu.put(ColoanaCascaval, ValoareCascaval);
                valuesDublu.put(ColoanaPret, PretHamburgerDublu);
                return valuesDublu;

            case SqlConstants.HamburgerSuncaTable:
                android.content.ContentValues valuesSunca = new android.content.ContentValues();
                valuesSunca.put(ColoanaPaine, ValoarePaine);
                valuesSunca.put(ColoanaMaioneza, ValoareMaioneza);
                valuesSunca.put(ColoanaSalata, ValoareSalata);
                valuesSunca.put(ColoanaCarne, ValoareCarne);
                valuesSunca.put(ColoanaSunca, ValoareSunca);
                valuesSunca.put(ColoanaCartofi, ValoareCartofi);
                valuesSunca.put(ColoanaKetchup, ValoareKetchup);
                valuesSunca.put(ColoanaCascaval, ValoareCascaval);
                valuesSunca.put(ColoanaPret, PretHamburgerSunca);
                return valuesSunca;

            case SqlConstants.HamburgerMediuTable:
                android.content.ContentValues valuesMediu = new android.content.ContentValues();
                valuesMediu.put(ColoanaPaine, ValoarePaine);
                valuesMediu.put(ColoanaMaioneza, ValoareMaioneza);
                valuesMediu.put(ColoanaSalata, ValoareSalata);
                valuesMediu.put(ColoanaCarne, ValoareCarne);
                valuesMediu.put(ColoanaCartofi, ValoareCartofi);
                valuesMediu.put(ColoanaKetchup, ValoareKetchup);
                valuesMediu.put(ColoanaCascaval, ValoareCascaval);
                valuesMediu.put(ColoanaPret, PretHamburgerMediu);
                return valuesMediu;

            case SqlConstants.HamburgerCheeseTable:
                android.content.ContentValues valuesCheese = new android.content.ContentValues();
                valuesCheese.put(ColoanaPaine, ValoarePaine);
                valuesCheese.put(ColoanaMaioneza, ValoareMaioneza);
                valuesCheese.put(ColoanaCastravetiMurati, ValoareCastraveti);
                valuesCheese.put(ColoanaCarne, ValoareCarne);
                valuesCheese.put(ColoanaKetchup, ValoareKetchup);
                valuesCheese.put(ColoanaHochland, ValoareHochland);
                valuesCheese.put(ColoanaPret, PretHamburgerCheese);
                return valuesCheese;

            case SqlConstants.HamburgerCartofiTable:
                android.content.ContentValues valuesCartofi = new android.content.ContentValues();
                valuesCartofi.put(ColoanaPaine, ValoarePaine);
                valuesCartofi.put(ColoanaMaioneza, ValoareMaioneza);
                valuesCartofi.put(ColoanaCarne, ValoareCarne);
                valuesCartofi.put(ColoanaCartofi, ValoareCartofi);
                valuesCartofi.put(ColoanaSalata, ValoareSalata);
                valuesCartofi.put(ColoanaKetchup, ValoareKetchup);
                valuesCartofi.put(ColoanaPret, PretHamburgerCartofi);
                return valuesCartofi;

            case SqlConstants.HamburgerSimpluTable:
                android.content.ContentValues valuesSimplu = new android.content.ContentValues();
                valuesSimplu.put(ColoanaMaioneza, ValoareMaioneza);
                valuesSimplu.put(ColoanaPaine, ValoarePaine);
                valuesSimplu.put(ColoanaCarne, ValoareCarne);
                valuesSimplu.put(ColoanaSalata, ValoareSalata);
                valuesSimplu.put(ColoanaKetchup, ValoareKetchup);
                valuesSimplu.put(ColoanaPret, PretHamburgerSimplu);
                return valuesSimplu;

            case SqlConstants.HamburgerVegetarianTable:
                android.content.ContentValues valuesVegetarian = new android.content.ContentValues();
                valuesVegetarian.put(ColoanaMaioneza, ValoareMaioneza);
                valuesVegetarian.put(ColoanaPaine, ValoarePaine);
                valuesVegetarian.put(ColoanaSalata, ValoareSalata);
                valuesVegetarian.put(ColoanaKetchup, ValoareKetchup);
                valuesVegetarian.put(ColoanaCascaval, ValoareCascaval);
                valuesVegetarian.put(ColoanaCartofi, ValoareCartofi);
                valuesVegetarian.put(ColoanaPret, PretHamburgerVegetarian);
                return valuesVegetarian;

            case SqlConstants.SandwichTable:
                android.content.ContentValues valuesSandwich = new android.content.ContentValues();
                valuesSandwich.put(ColoanaMaioneza, ValoareMaioneza);
                valuesSandwich.put(ColoanaPaine, ValoarePaine);
                valuesSandwich.put(ColoanaSalata, ValoareSalata);
                valuesSandwich.put(ColoanaSunca, ValoareSunca);
                valuesSandwich.put(ColoanaKetchup, ValoareKetchup);
                valuesSandwich.put(ColoanaCascaval, ValoareCascaval);
                valuesSandwich.put(ColoanaCartofi, ValoareCartofi);
                valuesSandwich.put(ColoanaPret, PretSandwitch);
                return valuesSandwich;

        }
        throw new Exception("Nu am gasit tabela si nu pot returna valori");
    }










    ///read hamburgers
    public static String ReadHamburgerSpecial(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();

        Cursor c = db.query(SqlConstants.HamburgerSpecialTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSunca)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCascaval)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerDublu(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerDubluTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCascaval)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerSunca(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerSuncaTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSunca)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCascaval)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerMediu(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerMediuTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCascaval)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerCheese(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerCheeseTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCastravetiMurati)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaHochland)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerCartofi(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerCartofiTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerSimplu(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerSimpluTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCarne)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadHamburgerVegetarian(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.HamburgerVegetarianTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCascaval)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }

    public static String ReadSandwitch(Context context) {
        FeedHelperSql sqlHelper = FeedHelperSql.getHelper(context);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.query(SqlConstants.SandwichTable, null, null, null, null, null, null);
        c.moveToFirst();
        String valori = "";
        do {
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaId)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaDataVanzare)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPaine)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaMaioneza)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSalata)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaKetchup)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCascaval)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaCartofi)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaSunca)) + "  ";
            valori += c.getString(c.getColumnIndexOrThrow(SqlConstants.ColoanaPret)) + "  ";
            valori += "\n \n ";
        } while (c.moveToNext());
        c.close();
        db.close();
        return valori;
    }






}
