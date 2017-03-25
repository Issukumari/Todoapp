
package fundoohr.com.todoapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fundoohr.com.todoapp1.base.BaseActivity;
import fundoohr.com.todoapp1.utils.Utility;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    AppCompatEditText fullname6;
    AppCompatEditText email3;
    AppCompatEditText passwordd4;
    AppCompatEditText Mobile5;
    AppCompatEditText Address8;
    Button save;
    String   Name;
    String email_id;
    String  password;
    String Mobile;
    String Adress;
    boolean checkName = false;
    boolean checkMail = false;
    boolean checkPassword = false;
    boolean checkMobNo = false;
    boolean checkAddress = false;
     Matcher mMatcher;
    Pattern mPattern;
      String EMAIL_PATTERN = "^(.+)@(.+)$";
    final String PASSWORD_PATTERN = "\\d+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initView();
    }

    @Override
    public void initView() {
        fullname6 = (AppCompatEditText) findViewById(R.id.edit6);
        email3 = (AppCompatEditText) findViewById(R.id.edit3);
        passwordd4 = (AppCompatEditText) findViewById(R.id.edit4);
        Mobile5 = (AppCompatEditText) findViewById(R.id.edit5);
        Address8 = (AppCompatEditText) findViewById(R.id.edit8);
        save = (Button) findViewById(R.id.save);

        setClicklistener();
    }

    @Override
    public void setClicklistener() {
        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save :
                showProgressDialog("Loading");
                validate();
                break;

        }
    }

    void validate(){
        Name = fullname6.getText().toString();
        String email_id = email3.getText().toString();
        String password = passwordd4.getText().toString();
        String Mobile = Mobile5.getText().toString();
        String Adress = Address8.getText().toString();


        if(TextUtils.isEmpty(Name) && TextUtils.isEmpty(email_id) && TextUtils.isEmpty(password)&& TextUtils.isEmpty(Mobile)&& TextUtils.isEmpty(Adress)){
            Toast.makeText(RegisterActivity.this, "field should not be empty", Toast.LENGTH_SHORT).show();
        }
        else if(Utility.isValidEmail(email_id)){

        }
        else if (Mobile.length() != 10) {
            Mobile5.setError("Mobile no should be  10 digit");
        }
        else if (password.length() != 5) {
            passwordd4.setError("password should be  5 character");
        }

        else{
            showProgressDialog("Loading");
        }



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


            hideProgressDialog();

            Toast.makeText(getApplicationContext(), "RegisterActivity Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login_Activity.class);
            startActivity(intent);
            finish();
        
    }
}

