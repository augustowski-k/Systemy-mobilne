package proj.sm.systemymobilne.activities;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Repositories.ICountriesRepository;
import proj.sm.systemymobilne.Repositories.SimpleCountryRepository;

public class countriesActivity extends ListActivity {
    TextView countriesTV;
    ArrayList<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        ICountriesRepository countryRepo = new SimpleCountryRepository();
        countries = (ArrayList<String>)countryRepo.getCountryNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item, countries);
        setListAdapter(adapter);
        countriesTV = (TextView)findViewById(R.id.countriesTV);


        getListView().setOnItemClickListener(listViewItemClicked);
    }

    private AdapterView.OnItemClickListener listViewItemClicked = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            countriesTV.setText(countries.get(position));
        }
    };
}
