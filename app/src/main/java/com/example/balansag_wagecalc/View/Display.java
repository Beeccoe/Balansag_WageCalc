package com.example.balansag_wagecalc.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.balansag_wagecalc.R;

public class Display extends AppCompatActivity {
    TextView txtName,txtType,txtHours,txtWage,txtOTWage,txtOT,txtReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.display_screen);

        txtName = findViewById(R.id.txtEmployeeName);
        txtType = findViewById(R.id.txtEmployeeType);
        txtHours = findViewById(R.id.txtHours);
        txtWage = findViewById(R.id.txtTotalWage);
        txtOTWage = findViewById(R.id.txtTotalOTWage);
        txtOT = findViewById(R.id.txtOverTime);
        txtReg = findViewById(R.id.txtTotalRegularWage);

        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));

        txtName.setText("" +EmployeeName);
        txtType.setText("Employee Type: " + String.valueOf(EmployeeType));
        txtHours.setText("Hours Worked: "+ String.valueOf(EmployeeHours));

        calcWage(EmployeeType,EmployeeHours,txtWage,txtReg,txtOT,txtOTWage);

    }
    //Method to calculate wage
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtReg, TextView txtOT, TextView txtOTWage){
        Double totalWage = 0.0;
        Double otWage = 0.0;
        Double overTime = employeeHours - 8.0;

        if(employeeHours > 8.0){
            if(employeeType.equals("Full-time")){
                otWage = overTime * 115;
                totalWage = otWage + 800;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtReg.setText("Total Regular Wage: ₱800");
                txtOT.setText("Overtime: "+String.valueOf(overTime));
                txtOTWage.setText("Total OT Wage: ₱"+String.valueOf(otWage));

            }

            else if(employeeType.equals("Part-time")){
                otWage = overTime * 90;
                totalWage = otWage + 600;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtReg.setText("Total Regular Wage: ₱600");
                txtOT.setText("Overtime: "+String.valueOf(overTime));
                txtOTWage.setText("Total OT Wage: ₱"+String.valueOf(otWage));
            }

            else{
                otWage = overTime * 100;
                totalWage = otWage + 720;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtReg.setText("Total Regular Wage: ₱720");
                txtOT.setText("Overtime: "+String.valueOf(overTime));
                txtOTWage.setText("Total OT Wage: ₱"+String.valueOf(otWage));
            }
            //overtime hours code
        }
        else{
            if(employeeType.equals("Full-time")){
                totalWage = employeeHours * 100;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtReg.setText("Total Regular Wage: Not Available");
                txtOT.setText("Overtime: Not Available");
                txtOTWage.setText("Total OT Wage: Not Available");
            }
            else if(employeeType.equals("Part-time")){
                totalWage = employeeHours * 75;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtReg.setText("Total Regular Wage: Not Available");
                txtOT.setText("Overtime: Not Available");
                txtOTWage.setText("Total OT Wage: Not Available");
            }
            else{
                totalWage = employeeHours * 90;
                txtTotalWage.setText("Total Wage: ₱" +String.valueOf(totalWage));
                txtReg.setText("Total Regular Wage: Not Available");
                txtOT.setText("Overtime: Not Available");
                txtOTWage.setText("Total OT Wage: Not Available");
            }
        }
    }





}