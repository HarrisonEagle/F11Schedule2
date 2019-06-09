package com.example.f11schedule;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class notelist extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    List<noteinf> bflist;
    public static Button title;

    public notelist(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return bflist.size();
    }

    @Override
    public Object getItem(int position) {
        return bflist.get(position);
    }

    public void setBflist(List<noteinf> bflist) {
        this.bflist = bflist;
    }

    @Override
    public long getItemId(int position) {
        return bflist.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.notelist,parent,false);

        title=convertView.findViewById(R.id.texttitle);
        Button del=convertView.findViewById(R.id.delnote);

        if(bflist.get(position).getTitle()!=null){
            title.setText(bflist.get(position).getTitle());
        }

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editnote.setIndex(position);
                Intent intent=new Intent(context,editnote.class);
                context.startActivity(intent);
            }
        });


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    File file=new File(context.getFilesDir()+File.separator+MainActivity.notelst.get(position).getTitle()+".txt");
                    if(file.exists()){
                        file.delete();

                    }


                MainActivity.notelst.remove(position);





                try{
                    File file2=new File(context.getFilesDir()+File.separator+"notelist.csv");
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
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
