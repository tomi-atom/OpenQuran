package atomstudio.openquran.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sadaqaworks.quranprojects.R;

public class SettingsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    if (savedInstanceState == null) {
      FragmentManager fragmentManager = getFragmentManager();
      fragmentManager
          .beginTransaction()
          .replace(R.id.main_container, new SettingsPreferenceFragment())
          .commit();
    }
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    startActivity(intent);
    return super.onKeyUp(keyCode, event);
  }

  @Override
  public void onBackPressed() {
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    startActivity(intent);
    super.onBackPressed();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  public static class SettingsPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      addPreferencesFromResource(R.xml.settings);
    }
  }
}
