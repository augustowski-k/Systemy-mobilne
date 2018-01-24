package proj.sm.systemymobilne.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import proj.sm.systemymobilne.R;

public class ChooseCountryTextViewActivity extends AppCompatActivity {
    TextView txvCountry;
    String countryPhone;
    Button btnCallEmbassy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country_text_view);
        Intent intent = getIntent();
        String countryName = intent.getStringExtra("CountryName");
        countryPhone = intent.getStringExtra("CountryPhone");
        String embassyData = countryName + ": " + countryPhone;
        txvCountry = (TextView) findViewById(R.id.txvCountry);
        txvCountry.setText(embassyData);
        btnCallEmbassy = (Button)findViewById(R.id.btnCallEmbassy);
        btnCallEmbassy.setOnClickListener(callEmbassyListener);
    }


    private View.OnClickListener callEmbassyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent callEmbassyIntent = new Intent();
            callEmbassyIntent.setAction(Intent.ACTION_CALL);
            callEmbassyIntent.setData(Uri.parse("tel:" + countryPhone));
            startActivity(callEmbassyIntent);
        }
    };
}
