package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Repositories.ICountriesRepository;
import proj.sm.systemymobilne.Repositories.SimpleCountryRepository;

public class CountriesSpinnerActivity extends Activity {
    Spinner countriesS;
    TextView countryTV;
    ArrayList<String> countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_spinner);

        ICountriesRepository countryRepo = new SimpleCountryRepository();
        countries = (ArrayList<String>)countryRepo.getCountryNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item, countries);

        countryTV = (TextView)findViewById(R.id.countriesSpinnerTV);
        countriesS = (Spinner)findViewById(R.id.countriesS);

        countriesS.setAdapter(adapter);

        countriesS.setOnItemSelectedListener(countriesSpinnerItemSelectedListener);
    }

    private AdapterView.OnItemSelectedListener countriesSpinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            countryTV.setText(countries.get(position));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            countryTV.setText("");
        }
    };
}
