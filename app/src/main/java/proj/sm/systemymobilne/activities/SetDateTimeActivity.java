package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import proj.sm.systemymobilne.R;

public class SetDateTimeActivity extends Activity {
    TextView txvDateTime;
    DatePickerDialog dlgDatePicker;
    TimePickerDialog dlgTimePicker;
    Button btnSetDate, btnSetTime;
    Calendar cal;
    Integer chosenYear, chosenMonth, chosenDay, chosenHour, chosenMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date_time);

        txvDateTime = (TextView)findViewById(R.id.txvDateTime);
        btnSetDate = (Button)findViewById(R.id.btnSetDate);
        btnSetTime = (Button)findViewById(R.id.btnSetTime);

        btnSetDate.setOnClickListener(setDateOnClickListener);
        btnSetTime.setOnClickListener(setTimeOnClickListener);

        cal = Calendar.getInstance();
    }

    private View.OnClickListener setDateOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ensureDatePicker();
            dlgDatePicker.show();
        }
    };

    private void ensureDatePicker() {
        if(dlgDatePicker == null){
            dlgDatePicker = new DatePickerDialog(this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        }
    }

    private View.OnClickListener setTimeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ensureTimePicker();
            dlgTimePicker.show();
        }
    };

    private void ensureTimePicker() {
        if(dlgTimePicker == null){
            dlgTimePicker = new TimePickerDialog(this,timeSetListener, cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE), true);
        }
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            chosenYear = year;
            chosenMonth = month;
            chosenDay = dayOfMonth;
            setTimeIndicator();
        }
    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            chosenHour = hourOfDay;
            chosenMinute = minute;
            setTimeIndicator();
        }
    };

    private void setTimeIndicator() {
        String timeStr = "";
        if(chosenYear != null){
            timeStr += chosenDay + "." + chosenMonth + "." + chosenYear;
        }
        if(chosenHour != null){
            timeStr += " " + chosenHour + ":" + chosenMinute;
        }

        txvDateTime.setText(timeStr);
    }
}
