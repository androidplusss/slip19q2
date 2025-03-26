package com.example.slip19q2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText fullName, currentWeight, goalWeight, height, age, phone, address;
    private RadioGroup genderGroup;
    private CheckBox termsCheckBox;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullName = findViewById(R.id.fullName);
        currentWeight = findViewById(R.id.currentWeight);
        goalWeight = findViewById(R.id.goalWeight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        genderGroup = findViewById(R.id.genderGroup);
        termsCheckBox = findViewById(R.id.termsCheckBox);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToNextActivity();
            }
        });
    }
    private void sendDataToNextActivity() {
        String name = fullName.getText().toString().trim();
        String weight = currentWeight.getText().toString().trim();
        String goal = goalWeight.getText().toString().trim();
        String heightValue = height.getText().toString().trim();
        String ageValue = age.getText().toString().trim();
        String phoneValue = phone.getText().toString().trim();
        String addressValue = address.getText().toString().trim();
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender != null ? selectedGender.getText().toString() : "Not Selected";
        if (name.isEmpty() || phoneValue.isEmpty() || !termsCheckBox.isChecked()) {
            Toast.makeText(this, "Please fill in all fields and accept terms", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("goal", goal);
        intent.putExtra("height", heightValue);
        intent.putExtra("age", ageValue);
        intent.putExtra("phone", phoneValue);
        intent.putExtra("address", addressValue);
        intent.putExtra("gender", gender);
        startActivity(intent);
    }
}
