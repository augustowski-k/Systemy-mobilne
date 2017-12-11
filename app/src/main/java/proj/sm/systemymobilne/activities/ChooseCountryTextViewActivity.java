package proj.sm.systemymobilne.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import proj.sm.systemymobilne.R;

public class ChooseCountryTextViewActivity extends AppCompatActivity {
    TextView txvCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country_text_view);

        txvCountry = (TextView) findViewById(R.id.txvCountry);
        txvCountry.setText(getIntent().getStringExtra("CountryName"));
    }
}
