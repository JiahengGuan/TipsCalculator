package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean unvalidInput(String checkAmount ,String partySize){
        if(checkAmount.equals("") || partySize.equals("") ) return true;
        //use a try{} catch to check if the input is valid
        try{
            if(Double.parseDouble(checkAmount) <= 0 && Integer.parseInt(partySize) <=0) return true;
        }catch(Exception e){
            return true;
        }
        return false;
    }

    public void calTip(View view){
        EditText CA = findViewById(R.id.checkAmountValue);
        EditText PS = findViewById(R.id.partySizeValue);

        String content_checkAmount = CA.getText().toString();
        double checkAmount = Double.parseDouble(content_checkAmount);
        String content_partySize = PS.getText().toString();
        int partySize = Integer.parseInt(content_partySize);

        if(unvalidInput(content_checkAmount,content_partySize)){
            Context context = getApplicationContext();
            CharSequence text = "Empty or incorrect value(s)!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
            return;
        }

        EditText tip_fifteenPercentTip = findViewById(R.id.fifteenPercentTipValue);
        EditText tip_twentyPercent = findViewById(R.id.twentyPercentTipValue);
        EditText tip_twentyfivePercent = findViewById(R.id.twentyfivePercentTipValue);
        EditText total_fifteenPercent = findViewById(R.id.fifteenPercentTotalValue);
        EditText total_twentyPercent = findViewById(R.id.twentyPercentTotalValue);
        EditText total_twentyfivePercent = findViewById(R.id.twentyfivePercentTotalValue);

        int after_split = (int)Math.round(checkAmount / partySize);
        String fifteenTip = String.valueOf(Math.round(after_split * 0.15));
        String twentyTip = String.valueOf(Math.round(after_split * 0.2));
        String twentyFiveTip = String.valueOf(Math.round(after_split * 0.25));
        String fifteenTotal = String.valueOf(Math.round(after_split * 1.15));
        String twentyTotal = String.valueOf(Math.round(after_split * 1.2));
        String twentyFiveTotal = String.valueOf(Math.round(after_split * 1.25));

        tip_fifteenPercentTip.setText(fifteenTip);
        tip_twentyPercent.setText(twentyTip);
        tip_twentyfivePercent.setText(twentyFiveTip);

        total_fifteenPercent.setText(fifteenTotal);
        total_twentyPercent.setText(twentyTotal);
        total_twentyfivePercent.setText(twentyFiveTotal);

    }
}