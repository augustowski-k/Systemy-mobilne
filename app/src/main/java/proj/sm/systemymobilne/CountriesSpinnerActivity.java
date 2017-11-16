package proj.sm.systemymobilne;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CountriesSpinnerActivity extends Activity {
    Spinner countriesS;
    ArrayList<String> countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_spinner);

        countries = new ArrayList<String>();
        countries.add("Polska");
        countries.add("Szkocja");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item, countries);

        countriesS = (Spinner)findViewById(R.id.countriesS);

        countriesS.setAdapter(adapter);
    }
}
