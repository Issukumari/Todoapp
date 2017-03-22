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

public class MainActivity extends AppCompatActivity {
    EditText id;
    EditText pass;
    Button login;
    Button Register;
    private Pattern mPattern;
    private Matcher mMatcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.edittext1);
        pass = (EditText) findViewById(R.id.edittext2);
        login = (Button) findViewById(R.id.btn1);
        Register = (Button) findViewById(R.id.btn2);
    }

    public void login(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("smita", Context.MODE_PRIVATE);
        String stename = sharedPreferences.getString("id", "value");
        String strpass = sharedPreferences.getString("pass", "value");
           /* if(id.getText().toString().equalsIgnoreCase(stename)&& pass.getText().toString().equalsIgnoreCase(strpass))
            {
        Toast.makeText(MainActivity.this, "login successfully", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(this,Main2Activity.class);
                startActivity(intent);
    }
            else{
                Toast.makeText(MainActivity.this,"invalid id or password",Toast.LENGTH_LONG).show();
            }
        }
       public  void  Register(View view)
   {
    Intent intent=new Intent(MainActivity.this,Registration.class);
    startActivity(intent);*/
        mPattern = Pattern.compile(EMAIL_PATTERN);
        mMatcher = mPattern.matcher(id.getText().toString());
        if (mMatcher.matches()) {
            id.setError("email-id is correct ");

        } else {
            id.setError("invalid email-id");
        }
    }

    public void Register(View view) {
        Intent intent = new Intent(MainActivity.this, Registration.class);
        startActivity(intent);
    }
}