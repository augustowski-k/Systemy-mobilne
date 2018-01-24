package proj.sm.receiverapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTV;
    Button btnSend;
    ICountriesRepository countryRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryRepo = new CountriesRepository();

        autoCompleteTV = (AutoCompleteTextView)findViewById(R.id.autoCompleteACTV);
        btnSend = (Button)findViewById(R.id.btnSend);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,countryRepo.getCountryNames());
        autoCompleteTV.setAdapter(adapter);
    }

    public void btnSendClicked(View v){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("CountryName", autoCompleteTV.getText().toString());

        setResult(RESULT_OK, returnIntent);
        finish();
    }

}
