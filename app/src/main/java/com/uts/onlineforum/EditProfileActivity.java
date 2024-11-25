package com.uts.onlineforum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private EditText etEditUsername, etEditGender, etEditBirthplace, etEditStatus, etEditHobby;
    private Button btnSaveEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        etEditUsername = findViewById(R.id.et_edit_username);
        etEditGender = findViewById(R.id.et_edit_gender);
        etEditBirthplace = findViewById(R.id.et_edit_birthplace);
        etEditStatus = findViewById(R.id.et_edit_status);
        etEditHobby = findViewById(R.id.et_edit_hobby);
        btnSaveEdit = findViewById(R.id.btn_save_edit);

        Intent intent = getIntent();
        if (intent != null) {
            etEditUsername.setText(intent.getStringExtra("username"));
            etEditGender.setText(intent.getStringExtra("gender"));
            etEditBirthplace.setText(intent.getStringExtra("birthplace"));
            etEditStatus.setText(intent.getStringExtra("status"));
            etEditHobby.setText(intent.getStringExtra("hobby"));
        } else {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
        }


        btnSaveEdit.setOnClickListener(v -> {
            String username = etEditUsername.getText().toString();
            String gender = etEditGender.getText().toString();
            String birthplace = etEditBirthplace.getText().toString();
            String status = etEditStatus.getText().toString();
            String hobby = etEditHobby.getText().toString();

            if (username.isEmpty() || gender.isEmpty() || birthplace.isEmpty() || status.isEmpty() || hobby.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show();
            } else {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("username", username);
                resultIntent.putExtra("gender", gender);
                resultIntent.putExtra("birthplace", birthplace);
                resultIntent.putExtra("status", status);
                resultIntent.putExtra("hobby", hobby);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
