package com.example.languageswitching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    Button btnOkForRu;
    Button btnOkForEn;
    TextView textView;
    String[] mLanguage = {"ru", "en"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        btnOkForRu = findViewById(R.id.btnOkForRu);
        btnOkForEn = findViewById(R.id.btnOkForEn);
        textView = findViewById(R.id.textView);
        initSpinner();


        btnOkForRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Locale locale = new Locale("ru");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                spinner.setSelection(0);
                mLanguage = new String[]{"ru"};
                textView.setText(R.string.textView);
                recreate();

            }
        });
        btnOkForEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale1 = new Locale("en");
                Configuration config1 = new Configuration();
                config1.setLocale(locale1);
                getResources().updateConfiguration(config1, getBaseContext().getResources().getDisplayMetrics());
                spinner.setSelection(1);
                mLanguage = new String[]{"en"};
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
