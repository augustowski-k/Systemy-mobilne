package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Repositories.ICountriesRepository;
import proj.sm.systemymobilne.Repositories.SimpleCountryRepository;

public class ChooseCountryListActivity extends ListActivity {
    ArrayList<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        Intent i = getIntent();

        ICountriesRepository countryRepo = new SimpleCountryRepository();
        countries = (ArrayList<String>)countryRepo.getCountryNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item, countries);
        setListAdapter(adapter);


        getListView().setOnItemClickListener(listViewItemClicked);
    }

    private AdapterView.OnItemClickListener listViewItemClicked = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("CountryName", countries.get(position));
            returnIntent.putExtra("CountryPhone", getRandomNumber());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    };

    private String getRandomNumber(){
        Random rd = new Random();
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < 9; i++){
            sb.append(rd.nextInt(9));
        }

        return sb.toString();
    }
}
