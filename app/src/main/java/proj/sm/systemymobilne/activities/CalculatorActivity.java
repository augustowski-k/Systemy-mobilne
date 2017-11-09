package proj.sm.systemymobilne.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import proj.sm.systemymobilne.R;

public class CalculatorActivity extends AppCompatActivity {
    Button oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,sevenBtn,eightBtn,nineBtn,minusBtn,plusBtn,equalsBtn;
    TextView calcDisplayTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calcDisplayTV = (TextView)findViewById(R.id.calcDisplayTV);

        oneBtn = (Button)findViewById(R.id.oneBtn);
        oneBtn.setOnClickListener(btnClickedListener);
        twoBtn = (Button)findViewById(R.id.twoBtn);
        twoBtn.setOnClickListener(btnClickedListener);
        threeBtn = (Button)findViewById(R.id.threeBtn);
        threeBtn.setOnClickListener(btnClickedListener);
        fourBtn = (Button)findViewById(R.id.fourBtn);
        fourBtn.setOnClickListener(btnClickedListener);
        fiveBtn = (Button)findViewById(R.id.fiveBtn);
        fiveBtn.setOnClickListener(btnClickedListener);
        sixBtn = (Button)findViewById(R.id.sixBtn);
        sixBtn.setOnClickListener(btnClickedListener);
        sevenBtn = (Button)findViewById(R.id.sevenBtn);
        sevenBtn.setOnClickListener(btnClickedListener);
        eightBtn = (Button)findViewById(R.id.eightBtn);
        eightBtn.setOnClickListener(btnClickedListener);
        nineBtn = (Button)findViewById(R.id.nineBtn);
        nineBtn.setOnClickListener(btnClickedListener);
        minusBtn = (Button)findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(btnClickedListener);
        plusBtn = (Button)findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(btnClickedListener);
        equalsBtn = (Button)findViewById(R.id.equalsBtn);
        equalsBtn.setOnClickListener(btnClickedListener);
    }

    Button.OnClickListener btnClickedListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            calcDisplayTV.append(((Button)v).getText());
        }
    };
}

