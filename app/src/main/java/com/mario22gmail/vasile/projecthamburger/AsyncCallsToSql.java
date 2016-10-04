//package com.mario22gmail.vasile.projecthamburger;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.widget.TextView;
//
//import java.util.Date;
//
///**
// * Created by Mario Vasile on 9/30/2016.
// */
//
//public class AsyncCallsToSql extends AsyncTask<ObjectForSqlCommand, String, String> {
//
//
//    int valueCartofi ;
//
//
//    @Override
//    protected Date doInBackground(ObjectForSqlCommand... params) {
//
//        int totalCartofiAmount = SqlConstants.GetCartofiPrajiti(getApplicationContext(),dateFrom);
//        totalCartofiTextView.setText(totalCartofiAmount);
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(String viewId) {
//        super.onPostExecute(viewId);
//
//        totalCartofiTextView = (TextView) findViewById(R.id.textViewTotalCartofi);
//
//
//    }
//}
