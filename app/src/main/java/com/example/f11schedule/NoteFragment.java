package com.example.f11schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class NoteFragment extends Fragment {

    public static notelist nlst;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.notefragment,container,false);

        Button add=v.findViewById(R.id.testbtn);

        final ListView listview=v.findViewById(R.id.notes);
        nlst=new notelist(getActivity());
        nlst.setBflist(MainActivity.notelst);
        listview.setAdapter(nlst);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteinf newnote=new noteinf();
                MainActivity.notelst.add(newnote);
                nlst.notifyDataSetChanged();
                Log.d("tag0",String.valueOf(MainActivity.notelst.size()));
            }
        });


        return v;

    }
}
