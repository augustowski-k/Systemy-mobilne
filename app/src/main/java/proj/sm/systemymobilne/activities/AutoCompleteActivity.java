package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Repositories.ICountriesRepository;
import proj.sm.systemymobilne.Repositories.SimpleCountryRepository;

public class AutoCompleteActivity extends Activity {
    TextView mainTV;
    AutoCompleteTextView autoCompleteTV;
    ICountriesRepository countryRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        countryRepo = new SimpleCountryRepository();

        mainTV = (TextView)findViewById(R.id.autoCopmleteTV);
        autoCompleteTV = (AutoCompleteTextView)findViewById(R.id.autoCompleteACTV);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,countryRepo.getCountryNames());
        autoCompleteTV.setAdapter(adapter);

        autoCompleteTV.addTextChangedListener(autoCompleteTextChangedListener);
    }

    private TextWatcher autoCompleteTextChangedListener = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mainTV.setText(s);
        }

        @Override
        public void afterTextChanged(Editable s) {}
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    };
}
