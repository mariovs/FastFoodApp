package com.mario22gmail.vasile.projecthamburger;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Statistics_Activity extends AppCompatActivity {

    Calendar calendarOneDay = Calendar.getInstance();
    Calendar calendarFrom = Calendar.getInstance();
    Calendar calendarTo = Calendar.getInstance();
    TextView totalCartofiTextView;

    DatePickerDialog.OnDateSetListener singleDate = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendarOneDay.set(Calendar.YEAR, year);
            calendarOneDay.set(Calendar.MONTH, monthOfYear);
            calendarOneDay.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            EditText dateFromEditText = (EditText) findViewById(R.id.datepickerStatisticsSingleDate);
            updateLabel(dateFromEditText, calendarFrom);
            UpdatePieChart(calendarOneDay.getTime());
            String hamburgerSpecial = SqlConstants.ReadHamburgerSpecial(getApplicationContext());
            int cartofiPrajiti = UpdateTotalAmountsLabelFromDb(calendarOneDay.getTime());
            TextView cartofiTextView = (TextView) findViewById(R.id.textViewTotalCartofi);
            cartofiTextView.setText(cartofiPrajiti);

        }

    };

    DatePickerDialog.OnDateSetListener dateFrom = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendarFrom.set(Calendar.YEAR, year);
            calendarFrom.set(Calendar.MONTH, monthOfYear);
            calendarFrom.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            EditText dateFromEditText = (EditText) findViewById(R.id.datepickerStatisticsFrom);
            updateLabel(dateFromEditText, calendarFrom);

        }
    };

    DatePickerDialog.OnDateSetListener dateTo = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendarTo.set(Calendar.YEAR, year);
            calendarTo.set(Calendar.MONTH, monthOfYear);
            calendarTo.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            EditText dateToEditText = (EditText) findViewById(R.id.datepickerStatisticsTo);
            updateLabel(dateToEditText, calendarTo);
            UpdatePieChart(calendarFrom.getTime(),calendarTo.getTime());
            UpdateTotalAmountsLabelFromDb(calendarFrom.getTime(),calendarTo.getTime());

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        final EditText singleDatePickerEditText = (EditText) findViewById(R.id.datepickerStatisticsSingleDate);
        singleDatePickerEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Statistics_Activity.this, singleDate, calendarOneDay
                        .get(Calendar.YEAR), calendarOneDay.get(Calendar.MONTH),
                        calendarOneDay.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        final EditText datePickerFromEditText = (EditText) findViewById(R.id.datepickerStatisticsFrom);
        datePickerFromEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Statistics_Activity.this, dateFrom, calendarFrom
                        .get(Calendar.YEAR), calendarFrom.get(Calendar.MONTH),
                        calendarFrom.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final EditText datePickerToEditText = (EditText) findViewById(R.id.datepickerStatisticsTo);
        datePickerToEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Statistics_Activity.this, dateTo, calendarTo
                        .get(Calendar.YEAR), calendarTo.get(Calendar.MONTH),
                        calendarTo.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        AppCompatCheckBox checkBox = (AppCompatCheckBox) findViewById(R.id.periodCheckBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DisplayRightDatePickers(isChecked);
                datePickerFromEditText.setText("");
                datePickerToEditText.setText("");
                singleDatePickerEditText.setText("");
            }
        });
        DisplayRightDatePickers(checkBox.isChecked());
        totalCartofiTextView = (TextView) findViewById(R.id.textViewTotalCartofi);
    }



    private int UpdateTotalAmountsLabelFromDb(Date dateFrom)
    {
        int cartofiCount =SqlConstants.GetCartofiPrajiti(getApplicationContext(),dateFrom);
        return  cartofiCount;
    }

    private void UpdateTotalAmountsLabelFromDb(Date dateFrom, Date dateTo)
    {
        int totalCartofiAmount = SqlConstants.GetCartofiPrajiti(getApplicationContext(),dateFrom,dateTo);

        totalCartofiTextView.setText(totalCartofiAmount);
    }

    private void updateLabel(EditText editTextToUpdate, Calendar calendar) {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextToUpdate.setText(sdf.format(calendar.getTime()));
        Toast.makeText(this.getApplicationContext(),myFormat,Toast.LENGTH_LONG);
    }

    public void DisplayRightDatePickers(boolean isPeriod)
    {
        RelativeLayout singleDateLayout = (RelativeLayout) findViewById(R.id.layoutSingleDate);
        LinearLayout periodLayout = (LinearLayout) findViewById(R.id.layoutPeriod);
        if(isPeriod)
        {
            singleDateLayout.setVisibility(View.GONE);
            periodLayout.setVisibility(View.VISIBLE);
        }
        else
        {
            singleDateLayout.setVisibility(View.VISIBLE);
            periodLayout.setVisibility(View.GONE);
        }
    }

    private void UpdatePieChart(Date dateFrom){

        int hamburgerSpecial = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerSpecialTable,dateFrom);
        int hamburgerDublu = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerDubluTable,dateFrom);
        int hamburgerSunca = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerSuncaTable,dateFrom);
        int hamburgerMediu = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerMediuTable,dateFrom);
        int hamburgerCheese = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerCheeseTable,dateFrom);
        int hamburgerCartofi = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerCartofiTable,dateFrom);
        int hamburgerSimplu = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerSimpluTable,dateFrom);
        int hamburgerVegetarian = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerVegetarianTable,dateFrom);
        int hamburgerSandwich = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.SandwichTable,dateFrom);


        PieChartView pieChart = (PieChartView) findViewById(R.id.pieChart);
        SliceValue sliceSpecial = new SliceValue(hamburgerSpecial, getResources().getColor(R.color.colorRed));
        SliceValue sliceDublu = new SliceValue(hamburgerDublu, getResources().getColor(R.color.colorTeal));
        SliceValue sliceSunca = new SliceValue(hamburgerSunca,getResources().getColor(R.color.colorBlueLight));
        SliceValue sliceMediu = new SliceValue(hamburgerMediu,getResources().getColor(R.color.colorBlueGrey));
        SliceValue sliceCheese = new SliceValue(hamburgerCheese,getResources().getColor(R.color.colorOrangeLight));
        SliceValue sliceCartofi = new SliceValue(hamburgerCartofi,getResources().getColor(R.color.colorYellow));
        SliceValue sliceSimplu = new SliceValue(hamburgerSimplu,getResources().getColor(R.color.colorBlueDark));
        SliceValue sliceVegetarian = new SliceValue(hamburgerVegetarian,getResources().getColor(R.color.colorGreen));
        SliceValue sliceSandwitch = new SliceValue(hamburgerSandwich,getResources().getColor(R.color.colorMov));

        List<SliceValue> sliceValueList =  new ArrayList<>();
        sliceValueList.add(sliceSpecial);
        sliceValueList.add(sliceDublu);
        sliceValueList.add(sliceSunca);
        sliceValueList.add(sliceMediu);
        sliceValueList.add(sliceCheese);
        sliceValueList.add(sliceCartofi);
        sliceValueList.add(sliceSimplu);
        sliceValueList.add(sliceVegetarian);
        sliceValueList.add(sliceSandwitch);
        PieChartData data = new PieChartData(sliceValueList);
        data.setHasLabels(true);
        data.setValueLabelTextSize(12);
        pieChart.setPieChartData(data);
        pieChart.startDataAnimation();
    }


    private void UpdatePieChart(Date dateFrom, Date dateTo){

        int hamburgerSpecial = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerSpecialTable,dateFrom,dateTo);
        int hamburgerDublu = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerDubluTable,dateFrom,dateTo);
        int hamburgerSunca = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerSuncaTable,dateFrom,dateTo);
        int hamburgerMediu = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerMediuTable,dateFrom,dateTo);
        int hamburgerCheese = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerCheeseTable,dateFrom,dateTo);
        int hamburgerCartofi = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerCartofiTable,dateFrom,dateTo);
        int hamburgerSimplu = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerSimpluTable,dateFrom,dateTo);
        int hamburgerVegetarian = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.HamburgerVegetarianTable,dateFrom,dateTo);
        int hamburgerSandwich = SqlConstants.GetNumberOfHamburgerSold(this.getApplicationContext(),SqlConstants.SandwichTable,dateFrom,dateTo);

        PieChartView pieChart = (PieChartView) findViewById(R.id.pieChart);
        SliceValue sliceSpecial = new SliceValue(hamburgerSpecial, getResources().getColor(R.color.colorRed));
        SliceValue sliceDublu = new SliceValue(hamburgerDublu, getResources().getColor(R.color.colorTeal));
        SliceValue sliceSunca = new SliceValue(hamburgerSunca,getResources().getColor(R.color.colorBlueLight));
        SliceValue sliceMediu = new SliceValue(hamburgerMediu,getResources().getColor(R.color.colorBlueGrey));
        SliceValue sliceCheese = new SliceValue(hamburgerCheese,getResources().getColor(R.color.colorOrangeLight));
        SliceValue sliceCartofi = new SliceValue(hamburgerCartofi,getResources().getColor(R.color.colorYellow));
        SliceValue sliceSimplu = new SliceValue(hamburgerSimplu,getResources().getColor(R.color.colorBlueDark));
        SliceValue sliceVegetarian = new SliceValue(hamburgerVegetarian,getResources().getColor(R.color.colorGreen));
        SliceValue sliceSandwitch = new SliceValue(hamburgerSandwich,getResources().getColor(R.color.colorMov));

        List<SliceValue> sliceValueList =  new ArrayList<>();
        sliceValueList.add(sliceSpecial);
        sliceValueList.add(sliceDublu);
        sliceValueList.add(sliceSunca);
        sliceValueList.add(sliceMediu);
        sliceValueList.add(sliceCheese);
        sliceValueList.add(sliceCartofi);
        sliceValueList.add(sliceSimplu);
        sliceValueList.add(sliceVegetarian);
        sliceValueList.add(sliceSandwitch);
        PieChartData data = new PieChartData(sliceValueList);
        data.setHasLabels(true);
        data.setValueLabelTextSize(12);
        pieChart.setPieChartData(data);
        pieChart.startDataAnimation();
    }

    public void FabMainPageNavigationClick(View view)
    {
        Intent mainPage = new Intent(this,MainActivity.class);
        startActivity(mainPage);
    }
}


