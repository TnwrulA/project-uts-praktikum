package com.uts.onlineforum;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private EditText etUsername;
    private TextView tvGender, tvBirthplace, tvStatus, tvHobby;
    private Button btnEditProfile;

    private final ActivityResultLauncher<Intent> editProfileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == AppCompatActivity.RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String newUsername = data.getStringExtra("username");
                    String newGender = data.getStringExtra("gender");
                    String newBirthplace = data.getStringExtra("birthplace");
                    String newStatus = data.getStringExtra("status");
                    String newHobby = data.getStringExtra("hobby");

                    etUsername.setText(newUsername);
                    tvGender.setText(newGender);
                    tvBirthplace.setText(newBirthplace);
                    tvStatus.setText(newStatus);
                    tvHobby.setText(newHobby);
                }
            }
    );

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        etUsername = view.findViewById(R.id.et_username);
        tvGender = view.findViewById(R.id.tv_gender);
        tvBirthplace = view.findViewById(R.id.tv_birthplace);
        tvStatus = view.findViewById(R.id.tv_status);
        tvHobby = view.findViewById(R.id.tv_hobby);
        btnEditProfile = view.findViewById(R.id.btn_edit_profile);
        etUsername.setText("-");
        tvGender.setText("-");
        tvBirthplace.setText("-");
        tvStatus.setText("-");
        tvHobby.setText("-");

        btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), EditProfileActivity.class);
            intent.putExtra("username", etUsername.getText().toString());
            intent.putExtra("gender", tvGender.getText().toString());
            intent.putExtra("birthplace", tvBirthplace.getText().toString());
            intent.putExtra("status", tvStatus.getText().toString());
            intent.putExtra("hobby", tvHobby.getText().toString());
            editProfileLauncher.launch(intent);
        });

        return view;
    }
}

