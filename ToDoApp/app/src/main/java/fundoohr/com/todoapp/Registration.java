
package fundoohr.com.todoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    EditText fullname6;
    EditText email3;
    EditText passwordd4;
    EditText Mobile5;
    EditText Address8;
    Button save;
    final String Name = "name";
    final String email_id = "id";
    final String password = "pass";
    final String Mobile = "mobile no";
    final String Adress = "Address";

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Matcher mMatcher;
    private Pattern mPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullname6 = (EditText) findViewById(R.id.edit6);
        email3 = (EditText) findViewById(R.id.edit3);
        passwordd4 = (EditText) findViewById(R.id.edit4);
        Mobile5 = (EditText) findViewById(R.id.edit5);
        Address8 = (EditText) findViewById(R.id.edit8);
        save = (Button) findViewById(R.id.save);



    }
    public void save(View view) {
        SharedPreferences sh = getSharedPreferences("smita", Context.MODE_PRIVATE);
        String N = fullname6.getText().toString();
        String e = email3.getText().toString();
        String p = passwordd4.getText().toString();
        String m = Mobile5.getText().toString();
        String a = Address8.getText().toString();
        SharedPreferences.Editor editor = sh.edit();
        editor.putString(Name, N);
        editor.putString(email_id, e);
        editor.putString(password, p);
        editor.putString(Adress, a);
        editor.putString(Mobile, m);
        editor.commit();
        mPattern=Pattern.compile(EMAIL_PATTERN);
        mMatcher = mPattern.matcher(email3.getText().toString());
        if (mMatcher.matches()) {
            email3.setError("Valid ");
        }else {
            email3.setError("Error");
        }

/*
        if (fullname6.getText().toString().length() >= 10) {
            fullname6.setError("Full name not entered");
            fullname6.requestFocus();
        }
        if (email3.getText().toString().length() == 0) {
            email3.setError("Email should not be empty");
            email3.requestFocus();
        }

        if (passwordd4.getText().toString().length() == 0) {
            passwordd4.setError("Password should mot be empty");
            passwordd4.requestFocus();
        } else {
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
        }
        if (Mobile5.getText().toString().length() != 10) {
            Mobile5.setError("Mobile no should not be empty");
            Mobile5.requestFocus();


        } else {
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
        }
        if (Address8.getText().toString().length() == 0) {
            Address8.setError(" Address should not be empty");
            Address8.requestFocus();
        }
        Intent intent=new Intent(Registration.this,MainActivity.class);
        finish();
*/
    }
    }
