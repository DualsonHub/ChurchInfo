package com.livingfaith.lfc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MeetAPastor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
String hanson, nsikak, kelly, nameMem,emailmem, phoneMem, message;
    EditText phone, email,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_apastor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setLogo(R.drawable.meet_pastor);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv = (TextView) findViewById(R.id.duration);

        Spinner spinner = (Spinner) findViewById(R.id.email_spinner);
        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.emails, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        name = (EditText) findViewById(R.id.name);

        Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aEmailList[] = { nsikak, hanson,kelly };
                 nameMem = name.getText().toString();
                 emailmem = email.getText().toString();
                 phoneMem = phone.getText().toString();
                if(nameMem.isEmpty() || emailmem.isEmpty() || phoneMem.isEmpty() ){
                    Toast.makeText(MeetAPastor.this, "please fill in your Information", Toast.LENGTH_SHORT).show();
                }else{
                     message = name.getText().toString();
                    message += "\n" + phone.getText().toString();
                    message += "\n" + email.getText().toString();

                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);


                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);  //supposed to pass info of the emails to the email app
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Meeting Request");  //not taking stuff from an edittext, only things in quotes.
                    emailIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, phone.getText().toString());
                    emailIntent.putExtra(Intent.EXTRA_TEXT, message);


                    emailIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, phone.getText().toString());
                    emailIntent.setType("message/rfc822");
                    startActivity(Intent.createChooser(emailIntent, "Send Email Using..."));
                sendSMSMessage();
                }

            }
        });
    }


    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = "07016898349";
       // String message = txtMessage.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if(pos == 0){
            Toast.makeText(MeetAPastor.this, "Choose a pastor to meet", Toast.LENGTH_SHORT).show();
        }
        else if(pos == 1){
            nsikak = "nsikakthompson73@gmail.com";
        }
        else if(pos == 2){
            hanson = "hansonofon@gmail.com";
        }
        else if(pos == 3){
            kelly = "cosmic.data.evolution@gmail.com";
        }
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



}
