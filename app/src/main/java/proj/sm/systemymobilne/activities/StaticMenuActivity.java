package proj.sm.systemymobilne.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

public class StaticMenuActivity extends AppCompatActivity {
    EditText edtFirstString, edtSecondString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        edtFirstString = (EditText)findViewById(R.id.edtFirstString);
        edtSecondString = (EditText)findViewById(R.id.edtSecondString);

        registerForContextMenu(edtFirstString);
        registerForContextMenu(edtSecondString);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.edtFirstString){
            inflateFirstStringMenu(menu);
        }else if(v.getId() == R.id.edtSecondString){
            inflateSecondStringMenu(menu);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getGroupId() == R.id.secondStringEditMenuInputType){
            Tools.showToast("Context menu for second string edit. " + item.getTitle(), this);
        }
        if(item.getGroupId() == R.id.firstStringEditMenuColor){
            Tools.showToast("Context menu for first string edit. " + item.getTitle(), this);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Tools.showToast("Options menu, item: '" + item.getTitle() + "' selected", this);
        return true;
    }

    private void inflateFirstStringMenu(ContextMenu menu) {
        getMenuInflater().inflate(R.menu.edt_first_string_ctx_menu, menu);
    }

    private void inflateSecondStringMenu(ContextMenu menu) {
        getMenuInflater().inflate(R.menu.edt_second_string_ctx_menu, menu);
    }
}
