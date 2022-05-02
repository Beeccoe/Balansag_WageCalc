package com.example.balansag_wagecalc.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.balansag_wagecalc.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText empName, empHours;
    RadioGroup empType;
    RadioButton btnSelected;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //EditText
        empName = findViewById(R.id.nameDisplay);

        empHours = findViewById(R.id.empHours);
        //RadioGroup
        empType = findViewById(R.id.empType);
        //Button
        calculate = findViewById(R.id.btnCalculate);

        //button On click listener
        calculate.setOnClickListener(this);

        empName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.empName) .equals(empName.getText().toString())){
                    empName.setText("");
                }
            }
        });

        empHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.empHours) .equals(empHours.getText().toString())){
                    empHours.setText("");
                }
            }
        });
    }

    public void onClick(View v) {

        if (getString(R.string.empHours) .equals(empHours.getText().toString())){
        }
        else {
            switch (v.getId()) {
                case R.id.btnCalculate:
                    int selectedEmployeeType = empType.getCheckedRadioButtonId();

                    btnSelected = findViewById(selectedEmployeeType);

                    String type = btnSelected.getText().toString();
                    String name = empName.getText().toString();
                    String totalHours = (empHours.getText().toString());

                    Intent intent = new Intent(this, Display.class);

                    intent.putExtra("type", type);
                    intent.putExtra("empName", name);
                    intent.putExtra("hours", totalHours);
                    startActivity(intent);

                    break;
            }
        }
    }
}