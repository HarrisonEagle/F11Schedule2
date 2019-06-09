package com.example.f11schedule;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class editsch extends AppCompatActivity {

    public  static int index;

    public static void setIndex(int index) {
        editsch.index = index;
    }

    public static int getIndex() {
        return index;
    }

    public void savefile(){


            //File file = new File(getFilesDir()+File.separator+"subjdata");
        try{
        File file=new File(getFilesDir()+File.separator+"subjdata.csv");
        FileWriter fw=new FileWriter(file,false);
        PrintWriter pw=new PrintWriter(new BufferedWriter(fw));
        for(int i=1;i<=42;i++){
            pw.print(MainActivity.lst.get(i).getClassname());


            pw.print(",");

            pw.print(MainActivity.lst.get(i).getTeachername());
            pw.print(",");
            pw.print(MainActivity.lst.get(i).getRoomname());
            pw.print(",");
            pw.print(MainActivity.lst.get(i).getType());
            pw.println();

        }
        pw.flush();
        pw.close();
        fw.close();
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        String[] type={"必修","選択必修","選択","切る授業（良い子は選ばないでね）"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editsch);
        final SchInf newinf=(SchInf) MainActivity.lst.get(index);

        Button exit=findViewById(R.id.back);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final EditText subjectname=findViewById(R.id.subjectname);

        final EditText roomname=findViewById(R.id.roomname);

        final EditText teachername=findViewById(R.id.teachername);


        if(newinf.getType()!=-1){

            subjectname.setText(newinf.getClassname());

            roomname.setText(newinf.getRoomname());
            teachername.setText(newinf.getTeachername());

        }
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,type);
       final Spinner color=findViewById(R.id.type);
       color.setAdapter(adapter);
       color.setSelection(newinf.type);

        Button save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                newinf.setClassname(subjectname.getText().toString());
                newinf.setTeachername(teachername.getText().toString());
                newinf.setRoomname(roomname.getText().toString());
                newinf.setType(color.getSelectedItemPosition());
                String str="";
                if(subjectname.getText().toString().length()>3){
                    for(int i=0; i<subjectname.getText().toString().length();i++){

                            str+=subjectname.getText().toString().substring(i,i+1);
                            if(i%3==0){
                                str+="\n";
                            }


                    }
                }else{

                    str=subjectname.getText().toString();


                }
                switch (index){
                    case 1:ScheduleFragment.btn1.setText(str);
                    if(color.getSelectedItemPosition()==0){
                        ScheduleFragment.btn1.setBackgroundColor(Color.BLUE);

                    }else if(color.getSelectedItemPosition()==1){
                        ScheduleFragment.btn1.setBackgroundColor(Color.GREEN);

                    }else if(color.getSelectedItemPosition()==2){
                        ScheduleFragment.btn1.setBackgroundColor(Color.CYAN);

                    }else if(color.getSelectedItemPosition()==3){
                        ScheduleFragment.btn1.setBackgroundColor(Color.RED);

                    }
                    break;
                    case 2:ScheduleFragment.btn2.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn2.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn2.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn2.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn2.setBackgroundColor(Color.RED);

                        }break;
                    case 3:ScheduleFragment.btn3.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn3.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn3.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn3.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn3.setBackgroundColor(Color.RED);

                        }break;
                    case 4:ScheduleFragment.btn4.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn4.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn4.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn4.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn4.setBackgroundColor(Color.RED);

                        }break;
                    case 5:ScheduleFragment.btn5.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn5.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn5.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn5.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn5.setBackgroundColor(Color.RED);

                        }break;
                    case 6:ScheduleFragment.btn6.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn6.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn6.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn6.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn6.setBackgroundColor(Color.RED);

                        }break;
                    case 7:ScheduleFragment.btn7.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn7.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn7.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn7.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn7.setBackgroundColor(Color.RED);

                        }break;
                    case 8:ScheduleFragment.btn8.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn8.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn8.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn8.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn8.setBackgroundColor(Color.RED);

                        }break;
                    case 9:ScheduleFragment.btn9.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn9.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn9.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn9.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn9.setBackgroundColor(Color.RED);

                        }break;
                    case 10:ScheduleFragment.btn10.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn10.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn10.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn10.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn10.setBackgroundColor(Color.RED);

                        }break;
                    case 11:ScheduleFragment.btn11.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn11.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn11.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn11.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn1.setBackgroundColor(Color.RED);

                        }break;
                    case 12:ScheduleFragment.btn12.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn12.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn12.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn12.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn12.setBackgroundColor(Color.RED);

                        }break;
                    case 13:ScheduleFragment.btn13.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn13.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn13.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn13.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn13.setBackgroundColor(Color.RED);

                        }break;
                    case 14:ScheduleFragment.btn14.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn14.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn14.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn14.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn14.setBackgroundColor(Color.RED);

                        }break;
                    case 15:ScheduleFragment.btn15.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn15.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn15.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn15.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn15.setBackgroundColor(Color.RED);

                        }break;
                    case 16:ScheduleFragment.btn16.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn16.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn16.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn16.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn16.setBackgroundColor(Color.RED);

                        }break;
                    case 17:ScheduleFragment.btn17.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn17.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn17.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn17.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn17.setBackgroundColor(Color.RED);

                        }break;
                    case 18:ScheduleFragment.btn18.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn18.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn18.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn18.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn18.setBackgroundColor(Color.RED);

                        }break;
                    case 19:ScheduleFragment.btn19.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn19.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn19.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn19.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn19.setBackgroundColor(Color.RED);

                        }break;
                    case 20:ScheduleFragment.btn20.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn20.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn20.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn20.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn20.setBackgroundColor(Color.RED);

                        }break;
                    case 21:ScheduleFragment.btn21.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn21.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn21.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn21.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn21.setBackgroundColor(Color.RED);

                        }break;
                    case 22:ScheduleFragment.btn22.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn22.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn22.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn22.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn22.setBackgroundColor(Color.RED);

                        }break;
                    case 23:ScheduleFragment.btn23.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn23.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn23.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn23.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn23.setBackgroundColor(Color.RED);

                        }break;
                    case 24:ScheduleFragment.btn24.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn24.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn24.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn24.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn24.setBackgroundColor(Color.RED);

                        }break;
                    case 25:ScheduleFragment.btn25.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn25.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn25.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn25.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn25.setBackgroundColor(Color.RED);

                        }break;
                    case 26:ScheduleFragment.btn26.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn26.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn26.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn26.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn26.setBackgroundColor(Color.RED);

                        }break;
                    case 27:ScheduleFragment.btn27.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn27.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn27.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn27.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn27.setBackgroundColor(Color.RED);

                        }break;
                    case 28:ScheduleFragment.btn28.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn28.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn28.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn28.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn28.setBackgroundColor(Color.RED);

                        }break;
                    case 29:ScheduleFragment.btn29.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn29.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn29.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn29.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn29.setBackgroundColor(Color.RED);

                        }break;
                    case 30:ScheduleFragment.btn30.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn30.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn30.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn30.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn30.setBackgroundColor(Color.RED);

                        }break;
                    case 31:ScheduleFragment.btn31.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn31.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn31.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn31.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn31.setBackgroundColor(Color.RED);

                        }break;
                    case 32:ScheduleFragment.btn32.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn32.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn32.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn32.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn32.setBackgroundColor(Color.RED);

                        }break;
                    case 33:ScheduleFragment.btn33.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn33.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn33.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn33.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn33.setBackgroundColor(Color.RED);

                        }break;
                    case 34:ScheduleFragment.btn34.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn34.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn34.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn34.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn34.setBackgroundColor(Color.RED);

                        }break;
                    case 35:ScheduleFragment.btn35.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn35.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn35.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn35.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn35.setBackgroundColor(Color.RED);

                        }break;
                    case 36:ScheduleFragment.btn36.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn36.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn36.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn36.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn36.setBackgroundColor(Color.RED);

                        }break;
                    case 37:ScheduleFragment.btn37.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn37.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn37.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn37.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn37.setBackgroundColor(Color.RED);

                        }break;
                    case 38:ScheduleFragment.btn38.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn38.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn38.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn38.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn38.setBackgroundColor(Color.RED);

                        }break;
                    case 39:ScheduleFragment.btn39.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn39.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn39.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn39.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn39.setBackgroundColor(Color.RED);

                        }break;
                    case 40:ScheduleFragment.btn40.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn40.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn40.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn40.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn40.setBackgroundColor(Color.RED);

                        }break;
                    case 41:ScheduleFragment.btn41.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn41.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn41.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn41.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn41.setBackgroundColor(Color.RED);

                        }break;
                    case 42:ScheduleFragment.btn42.setText(str);
                        if(color.getSelectedItemPosition()==0){
                            ScheduleFragment.btn42.setBackgroundColor(Color.BLUE);

                        }else if(color.getSelectedItemPosition()==1){
                            ScheduleFragment.btn42.setBackgroundColor(Color.GREEN);

                        }else if(color.getSelectedItemPosition()==2){
                            ScheduleFragment.btn42.setBackgroundColor(Color.CYAN);

                        }else if(color.getSelectedItemPosition()==3){
                            ScheduleFragment.btn42.setBackgroundColor(Color.RED);

                        }break;
                }

                newinf.setType(color.getSelectedItemPosition());

                MainActivity.lst.set(index,newinf);
                Toast.makeText(editsch.this,"保存しました！",Toast.LENGTH_LONG).show();
                savefile();

                finish();
            }
        });

        final Button clear=findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newinf.setType(-1);
                newinf.setRoomname("");
                newinf.setTeachername("");
                newinf.setClassname("");
                MainActivity.lst.set(index,newinf);
                subjectname.setText("");
                teachername.setText("");
                roomname.setText("");
                switch (index){
                    case 1:ScheduleFragment.btn1.setText("");ScheduleFragment.btn1.setBackgroundColor(Color.BLACK);break;
                    case 2:ScheduleFragment.btn2.setText("");ScheduleFragment.btn2.setBackgroundColor(Color.BLACK);break;
                    case 3:ScheduleFragment.btn3.setText("");ScheduleFragment.btn3.setBackgroundColor(Color.BLACK);break;
                    case 4:ScheduleFragment.btn4.setText("");ScheduleFragment.btn4.setBackgroundColor(Color.BLACK);break;
                    case 5:ScheduleFragment.btn5.setText("");ScheduleFragment.btn5.setBackgroundColor(Color.BLACK);break;
                    case 6:ScheduleFragment.btn6.setText("");ScheduleFragment.btn6.setBackgroundColor(Color.BLACK);break;
                    case 7:ScheduleFragment.btn7.setText("");ScheduleFragment.btn7.setBackgroundColor(Color.BLACK);break;
                    case 8:ScheduleFragment.btn8.setText("");ScheduleFragment.btn8.setBackgroundColor(Color.BLACK);break;
                    case 9:ScheduleFragment.btn9.setText("");ScheduleFragment.btn9.setBackgroundColor(Color.BLACK);break;
                    case 10:ScheduleFragment.btn10.setText("");ScheduleFragment.btn10.setBackgroundColor(Color.BLACK);break;
                    case 11:ScheduleFragment.btn11.setText("");ScheduleFragment.btn11.setBackgroundColor(Color.BLACK);break;
                    case 12:ScheduleFragment.btn12.setText("");ScheduleFragment.btn12.setBackgroundColor(Color.BLACK);break;
                    case 13:ScheduleFragment.btn13.setText("");ScheduleFragment.btn13.setBackgroundColor(Color.BLACK);break;
                    case 14:ScheduleFragment.btn14.setText("");ScheduleFragment.btn14.setBackgroundColor(Color.BLACK);break;
                    case 15:ScheduleFragment.btn15.setText("");ScheduleFragment.btn15.setBackgroundColor(Color.BLACK);break;
                    case 16:ScheduleFragment.btn16.setText("");ScheduleFragment.btn16.setBackgroundColor(Color.BLACK);break;
                    case 17:ScheduleFragment.btn17.setText("");ScheduleFragment.btn17.setBackgroundColor(Color.BLACK);break;
                    case 18:ScheduleFragment.btn18.setText("");ScheduleFragment.btn18.setBackgroundColor(Color.BLACK);break;
                    case 19:ScheduleFragment.btn19.setText("");ScheduleFragment.btn19.setBackgroundColor(Color.BLACK);break;
                    case 20:ScheduleFragment.btn20.setText("");ScheduleFragment.btn20.setBackgroundColor(Color.BLACK);break;
                    case 21:ScheduleFragment.btn21.setText("");ScheduleFragment.btn21.setBackgroundColor(Color.BLACK);break;
                    case 22:ScheduleFragment.btn22.setText("");ScheduleFragment.btn22.setBackgroundColor(Color.BLACK);break;
                    case 23:ScheduleFragment.btn23.setText("");ScheduleFragment.btn23.setBackgroundColor(Color.BLACK);break;
                    case 24:ScheduleFragment.btn24.setText("");ScheduleFragment.btn24.setBackgroundColor(Color.BLACK);break;
                    case 25:ScheduleFragment.btn25.setText("");ScheduleFragment.btn25.setBackgroundColor(Color.BLACK);break;
                    case 26:ScheduleFragment.btn26.setText("");ScheduleFragment.btn26.setBackgroundColor(Color.BLACK);break;
                    case 27:ScheduleFragment.btn27.setText("");ScheduleFragment.btn27.setBackgroundColor(Color.BLACK);break;
                    case 28:ScheduleFragment.btn28.setText("");ScheduleFragment.btn28.setBackgroundColor(Color.BLACK);break;
                    case 29:ScheduleFragment.btn29.setText("");ScheduleFragment.btn29.setBackgroundColor(Color.BLACK);break;
                    case 30:ScheduleFragment.btn30.setText("");ScheduleFragment.btn30.setBackgroundColor(Color.BLACK);break;
                    case 31:ScheduleFragment.btn31.setText("");ScheduleFragment.btn31.setBackgroundColor(Color.BLACK);break;
                    case 32:ScheduleFragment.btn32.setText("");ScheduleFragment.btn32.setBackgroundColor(Color.BLACK);break;
                    case 33:ScheduleFragment.btn33.setText("");ScheduleFragment.btn33.setBackgroundColor(Color.BLACK);break;
                    case 34:ScheduleFragment.btn34.setText("");ScheduleFragment.btn34.setBackgroundColor(Color.BLACK);break;
                    case 35:ScheduleFragment.btn35.setText("");ScheduleFragment.btn35.setBackgroundColor(Color.BLACK);break;
                    case 36:ScheduleFragment.btn36.setText("");ScheduleFragment.btn36.setBackgroundColor(Color.BLACK);break;
                    case 37:ScheduleFragment.btn37.setText("");ScheduleFragment.btn37.setBackgroundColor(Color.BLACK);break;
                    case 38:ScheduleFragment.btn38.setText("");ScheduleFragment.btn38.setBackgroundColor(Color.BLACK);break;
                    case 39:ScheduleFragment.btn39.setText("");ScheduleFragment.btn39.setBackgroundColor(Color.BLACK);break;
                    case 40:ScheduleFragment.btn40.setText("");ScheduleFragment.btn40.setBackgroundColor(Color.BLACK);break;
                    case 41:ScheduleFragment.btn41.setText("");ScheduleFragment.btn41.setBackgroundColor(Color.BLACK);break;
                    case 42:ScheduleFragment.btn42.setText("");ScheduleFragment.btn42.setBackgroundColor(Color.BLACK);break;




                }
                savefile();
                finish();
            }
        });
    }
}
