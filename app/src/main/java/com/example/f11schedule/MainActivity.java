package com.example.f11schedule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static List<SchInf> lst=new ArrayList();
    final static List<noteinf> notelst=new ArrayList<>();



    public void initnote(){

        try{
            File file=new File(getFilesDir()+File.separator+"notelist.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));


            int i=0;

            String line;
            while((line = br.readLine()) != null){

                noteinf tmp=new noteinf();
                String content="";
                StringBuilder text = new StringBuilder();
                File txt=new File(getFilesDir()+File.separator+line+".txt");
                try {
                    BufferedReader br2 = new BufferedReader(new FileReader(txt));
                    String line2;

                    while ((line2 = br2.readLine()) != null) {
                        text.append(line2);
                        text.append('\n');
                    }
                    br2.close();
                }
                catch (IOException e) {
                    //You'll need to add proper error handling here
                }
                content=text.toString();

                tmp.setTitle(line);
                tmp.setContent(content);
                notelst.add(tmp);












            }

            Log.d("tag",String.valueOf(notelst.size()));




        } catch (IOException e) {

        }

    }

    public void init() {

        for (int i = 0; i < 43; i++) {
            SchInf sch = new SchInf();
            sch.setType(-1);
            lst.add(sch);

        }

        try{
            File f = new File(getFilesDir()+File.separator+"subjdata.csv");
            BufferedReader br = new BufferedReader(new FileReader(f));


            int i=0;

            String line;
            while((line = br.readLine()) != null){
                i++;
                String arr[]=line.split(",");
                SchInf tmp = new SchInf();
                    tmp.setClassname(arr[0]);
                    tmp.setTeachername(arr[1]);
                    tmp.setRoomname(arr[2]);
                    tmp.setType(Integer.valueOf(arr[3]));
                
                

                lst.set(i,tmp);











            }


        } catch (IOException e) {

        }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final ScheduleFragment sc=new ScheduleFragment();
        final NoteFragment nf=new NoteFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.maincontent,sc).add(R.id.maincontent,nf).hide(nf).show(sc).commit();

        final ImageButton showsch=findViewById(R.id.showsch);
        final ImageButton shownote=findViewById(R.id.shownote);

        showsch.setImageResource(R.mipmap.timetable);

        showsch.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                showsch.setImageResource(R.mipmap.timetable);
                shownote.setImageResource(R.mipmap.notes);

                getSupportFragmentManager().beginTransaction().hide(nf).show(sc).commit();

            }

        });

        shownote.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                showsch.setImageResource(R.mipmap.timetablewhite);
                shownote.setImageResource(R.mipmap.note);

                getSupportFragmentManager().beginTransaction().hide(sc).show(nf).commit();

            }

        });

        init();
        initnote();









    }
}
