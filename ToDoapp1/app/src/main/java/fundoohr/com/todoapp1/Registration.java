
package fundoohr.com.todoapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
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
    String   Name;
    String email_id;
    String  password;
    String Mobile;
    String Adress;
    boolean chkName = false;
    boolean chkMail = false;
    boolean chkPassword = false;
    boolean chkMobNo = false;
    boolean chkAddress = false;
     Matcher mMatcher;
    Pattern mPattern;
      String EMAIL_PATTERN = "^(.+)@(.+)$";
    final String PASSWORD_PATTERN = "\\d+";
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
        public void save(View view)
    {
        Name=fullname6.getText().toString();
        String email_id = email3.getText().toString();
        String password = passwordd4.getText().toString();
        String Mobile = Mobile5.getText().toString();
        String Adress = Address8.getText().toString();
        if (Name.isEmpty()) {
            fullname6.setError("First name not entered");
        } else {
            chkName = true;
        }

       if(email_id.isEmpty()) {
           email3.setError("email should not empty");
       }
       else if(!isValidEmail(email_id))
        {
            email3.setError("invalid email");
        }
        else{
           chkMail=true;
       }
        if (Mobile.isEmpty()) {
            Mobile5.setError("Enter your mob number");
        } else if (Mobile.length() != 10) {
            Mobile5.setError("Mobile no should be  10 digit");
        } else {
            chkMobNo = true;
        }
        if (Adress.isEmpty()) {
            Address8.setError("Enter your Address ");
        } else {
            chkAddress = true;
        }
        if (password.isEmpty()) {
            passwordd4.setError("Password should not be blank");
        }
        else if (password.length() != 5) {
            passwordd4.setError("password should be  5 character");
        }
        else
        {
            chkPassword=true;
        }


        if (chkName && chkMail && chkMobNo && chkPassword && chkAddress) {
            SharedPreferences sh = getSharedPreferences("smita", Context.MODE_PRIVATE);
            String N = fullname6.getText().toString();
            String e = email3.getText().toString();
            String p = passwordd4.getText().toString();
            String m = Mobile5.getText().toString();
            String a = Address8.getText().toString();
            SharedPreferences.Editor editor = sh.edit();
            editor.putString("Name", N);
            editor.putString("email_id", e);
            editor.putString("password", p);
            editor.putString("Adress", a);
            editor.putString("Mobile", m);
            editor.commit();

            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }

    }

    private boolean isValidEmail(String email_id) {
        return Patterns.EMAIL_ADDRESS.matcher(email_id).matches();
    }
}
