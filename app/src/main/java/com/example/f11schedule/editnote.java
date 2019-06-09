package com.example.f11schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class editnote extends AppCompatActivity {

    public  static int index;
    public static EditText title;
    public static EditText note;


    public static void setIndex(int index) {
        editnote.index = index;
    }

    public static int getIndex() {
        return index;
    }





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editnote);

        final noteinf ninf=MainActivity.notelst.get(index);

        Button exit=findViewById(R.id.exitnote);
        title=findViewById(R.id.notetitle);
        note=findViewById(R.id.notecontent);

        if(ninf.getTitle()!=null){
            title.setText(ninf.getTitle());

            note.setText(ninf.getContent());
        }




        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button savebtn=findViewById(R.id.savenote);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save
                ninf.setTitle(title.getText().toString());
                ninf.setContent(note.getText().toString());
                MainActivity.notelst.set(index,ninf);


                NoteFragment.nlst.notifyDataSetChanged();

                try{
                    File file=new File(getFilesDir()+File.separator+ninf.getTitle()+".txt");
                    FileWriter fw=new FileWriter(file,false);
                    PrintWriter pw=new PrintWriter(new BufferedWriter(fw));

                    pw.print(ninf.getContent());


                    pw.flush();
                    pw.close();
                    fw.close();


                }catch(FileNotFoundException e){

                }catch(IOException e){

                }



                try{
                    File file2=new File(getFilesDir()+File.separator+"notelist.csv");
                    FileWriter fw2=new FileWriter(file2,false);
                    PrintWriter pw2=new PrintWriter(new BufferedWriter(fw2));

                    for(int i=0;i<MainActivity.notelst.size();i++){
                        pw2.print(MainActivity.notelst.get(i).getTitle());
                        pw2.println();
                    }


                    pw2.flush();
                    pw2.close();
                    fw2.close();


                }catch(FileNotFoundException e){

                }catch(IOException e){

                }

                finish();
            }
        });


    }
}
