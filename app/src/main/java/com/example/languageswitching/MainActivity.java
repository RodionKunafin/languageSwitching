package com.example.languageswitching;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    Button btnOk;
    TextView textView;
    String[] mLanguage = {"en", "ru"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        btnOk = findViewById(R.id.btnOk);
        textView = findViewById(R.id.textView);
        initSpinner();


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setSelection(1);
                mLanguage = new String[]{"en"};
                Locale locale = new Locale("en");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                textView.setText(R.string.textView);
                recreate();

                spinner.setSelection(0);
                mLanguage = new String[]{"ru"};
                Locale locale1 = new Locale("ru");
                Configuration config1 = new Configuration();
                config.setLocale(locale1);
                getResources().updateConfiguration(config1, getBaseContext().getResources().getDisplayMetrics());
                textView.setText(R.string.textView);
                recreate();

            }
        });

    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                String[] languages = getResources().getStringArray(R.array.languages);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


}
