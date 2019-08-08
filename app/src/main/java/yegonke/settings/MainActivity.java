package yegonke.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResume() {
        super.onResume();
        showSettings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }

    private void showSettings() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder sb = new StringBuilder();
        sb.append("\n User Name: " + sp.getString("userName", ""));
        sb.append("\n Auto Update: " + sp.getBoolean("autoUpdate", false));
        sb.append("\n Sync Frequency: " + sp.getString("syncFrequency", ""));

        TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);
        settingsTextView.setText(sb.toString());
    }
}