package com.example.f11schedule;

import java.io.Serializable;

public class SchInf implements Serializable {
    String classname;
    String teachername;
    String roomname;
    int type;  //1.必修（青）　2.選択必修（緑）　3.選択（黄色）　4.切る授業（赤）

    SchInf(){


    }

    SchInf(String classname,String teachername,int type){
        this.classname=classname;
        this.teachername=teachername;
        this.type=type;


    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getType() {
        return type;
    }

    public String getClassname() {
        return classname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public void setType(int type) {
        this.type = type;
    }


}


