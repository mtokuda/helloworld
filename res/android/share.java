import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends activity {

    String value;
    EditText editText;
    TextView textView;
    SharedPreferences preferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) actionBar.hide();


        // Check if there is a previous value on preferences. If so display it or set text to "Empty".
        textView = (TextView) findViewById(R.id.textView4);

        if (getPreference() != null) {
            textView.setText(getPreference());
        } else {
            textView.setText("Empty");
        }

        // Create reference to button on layout file.
        button = (Button) findViewById(R.id.button);
        // Set listener.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the value on editText.
                editText = (EditText) findViewById(R.id.editText);
                value = editText.getText().toString();
                // Set the value in Shared Preferences.
                setPreference(value);
                // Let the user know the new value by displaying it in the layout and setting a Toast warning.
                textView.setText(getPreference());
                Toast.makeText(MainActivity.this, "Shared Preference Saved!", Toast.LENGTH_LONG).show();
                // Clear EditText after click to keep things tighty.
                editText.setText("");
            }
        });
    }

    public void setPreference(String value) {

        preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("value", value);
        editor.apply();
    }

    public String getPreference() {

        preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        value = preferences.getString("value", null);

        return value;
    }
}
