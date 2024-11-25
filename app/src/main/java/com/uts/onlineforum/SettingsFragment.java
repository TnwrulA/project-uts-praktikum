package com.uts.onlineforum;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.uts.onlineforum.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.settingProfile.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), EditProfileActivity.class));
        });

        // Notifications button
        binding.settingNotifications.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Pengaturan Notifikasi", Toast.LENGTH_SHORT).show();
        });

        binding.settingDarkMode.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Mode Gelap Diaktifkan", Toast.LENGTH_SHORT).show();
        });
        binding.settingHelp.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Bantuan", Toast.LENGTH_SHORT).show();
        });
        binding.settingLogout.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LoginActivity.class));
            requireActivity().finish();
        });

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
