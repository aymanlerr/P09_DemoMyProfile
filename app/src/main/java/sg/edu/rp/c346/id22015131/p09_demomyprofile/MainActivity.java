package sg.edu.rp.c346.id22015131.p09_demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs = getPreferences((MODE_PRIVATE));
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "");
        float gpa = prefs.getFloat("gpa", 0.0f);
        etName.setText(name);
        String strGPA = Float.toString(gpa);
        etGPA.setText(strGPA);
    }


}