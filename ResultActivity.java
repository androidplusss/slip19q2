package com.example.slip19q2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class ResultActivity extends AppCompatActivity {
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText = findViewById(R.id.resultText);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String weight = intent.getStringExtra("weight");
        String goal = intent.getStringExtra("goal");
        String height = intent.getStringExtra("height");
        String age = intent.getStringExtra("age");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String gender = intent.getStringExtra("gender");
        String displayMessage = "Membership Details:\n\n"
                + "Full Name: " + name + "\n"
                + "Gender: " + gender + "\n"
                + "Current Weight: " + weight + "\n"
                + "Goal Weight: " + goal + "\n"
                + "Height: " + height + "\n"
                + "Age: " + age + "\n"
                + "Phone: " + phone + "\n"
                + "Address: " + address;
        resultText.setText(displayMessage);
    }
}
