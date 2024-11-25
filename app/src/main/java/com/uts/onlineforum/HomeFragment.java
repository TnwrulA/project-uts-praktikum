package com.uts.onlineforum;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

             RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<String> groupNames = new ArrayList<>();
        groupNames.add("KELOMPOK");
        groupNames.add("ALFITO LEONARD-F55123060");
        groupNames.add("TANWIRUL MUTTAQIN-F55123083");
        groupNames.add("REYHAN DANY-F55123095");
        groupNames.add("Manchester United Tetap Dihati");
        groupNames.add("Pecinta anime");
        groupNames.add("Pecinta Musik");
        groupNames.add("Pro Player");
        groupNames.add("Wisata Lokal");
        groupNames.add("Olahraga");
        groupNames.add("Fotografi");
        groupNames.add("Pemain Sinetron anak jalanan");
        groupNames.add("Teknologi Masa Depan");
        groupNames.add("Bola");
        groupNames.add("Pecinta Wanita");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(groupNames, groupName -> {
            Bundle bundle = new Bundle();
            bundle.putString("groupName", groupName);
        });

        recyclerView.setAdapter(adapter);

        return view;
    }
}
