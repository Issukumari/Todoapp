package fundoohr.com.todoapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
Button AppCompatButtonlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        AppCompatButtonlogout = (Button) findViewById(R.id.logout);
        AppCompatButtonlogout.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(WelcomeActivity.this, Login_Activity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "logout successfully", Toast.LENGTH_SHORT).show();
        finish();

    }
}

