package com.ellen.dhcsqltetest.sql;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyTable;
import com.ellen.dhcsqlitelibrary.table.proxy.AutoDesignOperate;
import com.ellen.dhcsqltetest.bean.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class StudentTable extends ZxyTable<Student,StudentOperate> {

    public StudentTable(SQLiteDatabase db, Class<Student> dataClass, Class<StudentOperate> autoClass, String tableName) {
        super(db, dataClass, autoClass, tableName);
    }

    public StudentTable(SQLiteDatabase db, Class<Student> dataClass, Class<StudentOperate> autoClass) {
        super(db, dataClass, autoClass);
    }

    @Override
    protected Object setBooleanValue(String classFieldName, boolean value) {
        if(classFieldName.equals("isMan")){
            if(value){
                return "男";
            }else {
                return "女";
            }
        }else {
            return super.setBooleanValue(classFieldName, value);
        }
    }

    @Override
    protected Object resumeDataStructure(String classFieldName, Class fieldClass, String json) {
        if(classFieldName.equals("subjectMap")){
            Type type = new TypeToken<HashMap<String,Integer>>() {}.getType();
            HashMap<String,Integer> subjectMap = new Gson().fromJson(json, type);
            return subjectMap;
        }
        return super.resumeDataStructure(classFieldName, fieldClass, json);
    }

}
