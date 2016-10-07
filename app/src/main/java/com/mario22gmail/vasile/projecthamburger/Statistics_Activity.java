package com.mario22gmail.vasile.projecthamburger;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
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

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;
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
            UpdateTotalAmountsLabelFromDb(calendarOneDay.getTime());

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


        UpdateLineChartView();

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppCompatCheckBox checkBox = (AppCompatCheckBox) findViewById(R.id.periodCheckBox);
        if(!checkBox.isChecked())
        {
            Date dateNow = Calendar.getInstance().getTime();
            calendarOneDay.setTime(dateNow);

//            calendarOneDay.set(Calendar.YEAR, year);
//            calendarOneDay.set(Calendar.MONTH, monthOfYear);
//            calendarOneDay.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            EditText dateFromEditText = (EditText) findViewById(R.id.datepickerStatisticsSingleDate);
            updateLabel(dateFromEditText, calendarFrom);
            UpdatePieChart(calendarOneDay.getTime());
            UpdateTotalAmountsLabelFromDb(calendarOneDay.getTime());
        }
    }

    public final static String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec",};

    public final static String[] days = new String[]{"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun",};

    private LineChartView chartTop;
    private ColumnChartView chartBottom;

    private LineChartData lineData;
    private ColumnChartData columnData;

    private void UpdateLineChartView()
    {

        // *** TOP LINE CHART ***
        chartTop = (LineChartView) findViewById(R.id.chart_top);

        // Generate and set data for line chart
        generateInitialLineData();

        // *** BOTTOM COLUMN CHART ***

        chartBottom = (ColumnChartView) findViewById(R.id.chart_bottom);

        generateColumnData();

    }


    private void generateColumnData() {

        int numSubcolumns = 1;
        int numColumns = months.length;

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));
            }

            axisValues.add(new AxisValue(i).setLabel(months[i]));

            columns.add(new Column(values).setHasLabelsOnlyForSelected(true));
        }

        columnData = new ColumnChartData(columns);

        columnData.setAxisXBottom(new Axis(axisValues).setHasLines(true));
        columnData.setAxisYLeft(new Axis().setHasLines(true).setMaxLabelChars(2));

        chartBottom.setColumnChartData(columnData);

        // Set value touch listener that will trigger changes for chartTop.
        chartBottom.setOnValueTouchListener(new ValueTouchListener());

        // Set selection mode to keep selected month column highlighted.
        chartBottom.setValueSelectionEnabled(true);

        chartBottom.setZoomType(ZoomType.HORIZONTAL);

        // chartBottom.setOnClickListener(new View.OnClickListener() {
        //
        // @Override
        // public void onClick(View v) {
        // SelectedValue sv = chartBottom.getSelectedValue();
        // if (!sv.isSet()) {
        // generateInitialLineData();
        // }
        //
        // }
        // });

    }

    private void generateInitialLineData() {
        int numValues = 7;

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        List<PointValue> values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            values.add(new PointValue(i, 0));
            axisValues.add(new AxisValue(i).setLabel(days[i]));
        }

        Line line = new Line(values);
        line.setColor(ChartUtils.COLOR_GREEN).setCubic(true);

        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        lineData = new LineChartData(lines);
        lineData.setAxisXBottom(new Axis(axisValues).setHasLines(true));
        lineData.setAxisYLeft(new Axis().setHasLines(true).setMaxLabelChars(3));

        chartTop.setLineChartData(lineData);

        // For build-up animation you have to disable viewport recalculation.
        chartTop.setViewportCalculationEnabled(false);

        // And set initial max viewport and current viewport- remember to set viewports after data.
        Viewport v = new Viewport(0, 110, 6, 0);
        chartTop.setMaximumViewport(v);
        chartTop.setCurrentViewport(v);

        chartTop.setZoomType(ZoomType.HORIZONTAL);
    }

    private void generateLineData(int color, float range) {
        // Cancel last animation if not finished.
        chartTop.cancelDataAnimation();

        // Modify data targets
        Line line = lineData.getLines().get(0);// For this example there is always only one line.
        line.setColor(color);
        for (PointValue value : line.getValues()) {
            // Change target only for Y value.
            value.setTarget(value.getX(), (float) Math.random() * range);
        }

        // Start new data animation with 300ms duration;
        chartTop.startDataAnimation(300);
    }

    private class ValueTouchListener implements ColumnChartOnValueSelectListener {

        @Override
        public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value) {
            generateLineData(value.getColor(), 100);
        }

        @Override
        public void onValueDeselected() {

            generateLineData(ChartUtils.COLOR_GREEN, 0);

        }
    }







    private void UpdateTotalAmountsLabelFromDb(Date dateFrom)
    {
        Context context = getApplicationContext();

        int cartofiAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,SqlConstants.CartofiPrajitiTables(),SqlConstants.ColoanaCartofi);
        TextView cartofiTextView = (TextView) findViewById(R.id.textViewAmountCartofiPrajiti);
        cartofiTextView.setText(cartofiAmount + "");

        int pretAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,SqlConstants.PretTables(),SqlConstants.ColoanaPret);
        TextView pretTextView = (TextView)findViewById(R.id.textViewAmountBani);
        pretTextView.setText(String.valueOf(pretAmount));

        int paineAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,SqlConstants.ChiflaTables(),SqlConstants.ColoanaPaine);
        TextView paineTextView = (TextView) findViewById(R.id.textViewAmountChifle);
        paineTextView.setText(paineAmount + "");

        int carneAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,SqlConstants.CarneTables(),SqlConstants.ColoanaCarne);
        TextView carneTextView = (TextView) findViewById(R.id.textViewAmountCarne);
        carneTextView.setText(carneAmount + "");

        int maionezaAmount = SqlConstants.GetValuesCountFromTables(context, dateFrom,SqlConstants.MaionezaTables(),SqlConstants.ColoanaMaioneza);
        TextView maionezaTextView = (TextView) findViewById(R.id.textViewAmountMaioneza);
        maionezaTextView.setText(maionezaAmount + "");

        int cascavalAmount = SqlConstants.GetValuesCountFromTables(context, dateFrom,SqlConstants.CascavalTables(),SqlConstants.ColoanaCascaval);
        TextView cascavalTextView = (TextView) findViewById(R.id.textViewAmountCascaval);
        cascavalTextView.setText(cascavalAmount + "");

        int ketchupAmount = SqlConstants.GetValuesCountFromTables(context, dateFrom, SqlConstants.KetchupTables(), SqlConstants.ColoanaKetchup);
        TextView ketchupTextView = (TextView) findViewById(R.id.textViewAmountKetchup);
        ketchupTextView.setText(ketchupAmount + "");

        int suncaAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom, SqlConstants.SuncaTables(),SqlConstants.ColoanaSunca);
        TextView suncaTextView = (TextView) findViewById(R.id.textViewAmountSunca);
        suncaTextView.setText(suncaAmount + "");
    }

    private void UpdateTotalAmountsLabelFromDb(Date dateFrom, Date dateTo)
    {
        Context context = getApplicationContext();

        int cartofiAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,dateTo,SqlConstants.CartofiPrajitiTables(),SqlConstants.ColoanaCartofi);
        TextView cartofiTextView = (TextView) findViewById(R.id.textViewAmountCartofiPrajiti);
        cartofiTextView.setText(cartofiAmount + "");

        int pretAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,dateTo,SqlConstants.PretTables(),SqlConstants.ColoanaPret);
        TextView pretTextView = (TextView)findViewById(R.id.textViewAmountBani);
        pretTextView.setText(String.valueOf(pretAmount));

        int paineAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom, dateTo, SqlConstants.ChiflaTables(),SqlConstants.ColoanaPaine);
        TextView paineTextView = (TextView) findViewById(R.id.textViewAmountChifle);
        paineTextView.setText(paineAmount + "");

        int carneAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom,dateTo, SqlConstants.CarneTables(),SqlConstants.ColoanaCarne);
        TextView carneTextView = (TextView) findViewById(R.id.textViewAmountCarne);
        carneTextView.setText(carneAmount + "");

        int maionezaAmount = SqlConstants.GetValuesCountFromTables(context, dateFrom, dateTo, SqlConstants.MaionezaTables(),SqlConstants.ColoanaMaioneza);
        TextView maionezaTextView = (TextView) findViewById(R.id.textViewAmountMaioneza);
        maionezaTextView.setText(maionezaAmount + "");

        int cascavalAmount = SqlConstants.GetValuesCountFromTables(context, dateFrom, dateTo, SqlConstants.CascavalTables(),SqlConstants.ColoanaCascaval);
        TextView cascavalTextView = (TextView) findViewById(R.id.textViewAmountCascaval);
        cascavalTextView.setText(cascavalAmount + "");

        int ketchupAmount = SqlConstants.GetValuesCountFromTables(context, dateFrom,dateTo, SqlConstants.KetchupTables(), SqlConstants.ColoanaKetchup);
        TextView ketchupTextView = (TextView) findViewById(R.id.textViewAmountKetchup);
        ketchupTextView.setText(ketchupAmount + "");

        int suncaAmount = SqlConstants.GetValuesCountFromTables(context,dateFrom, dateTo, SqlConstants.SuncaTables(),SqlConstants.ColoanaSunca);
        TextView suncaTextView = (TextView) findViewById(R.id.textViewAmountSunca);
        suncaTextView.setText(suncaAmount + "");
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


