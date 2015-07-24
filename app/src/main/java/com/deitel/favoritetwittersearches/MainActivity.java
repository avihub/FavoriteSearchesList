package com.deitel.favoritetwittersearches;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;


public class MainActivity extends Activity {

    private SharedPreferences savedSearches;
    private TableLayout queryTableLayout;
    private EditText queryEditText;
    private EditText tagEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savedSearches = getSharedPreferences("searches", MODE_PRIVATE);
        queryTableLayout = (TableLayout) findViewById(R.id.queryTableLayout);
        queryEditText = (EditText) findViewById(R.id.queryEditText);
        tagEditText = (EditText) findViewById(R.id.tagEditText);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(saveButtonListener);
        Button clearTagsButton = (Button) findViewById(R.id.clearTagsButton);

        refreshButtons(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
