package com.ellen.dhcsqltetest.sql;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyTable;
import com.ellen.dhcsqltetest.bean.Student;


public class StudentTable extends ZxyTable<Student,StudentOperate> {

    public StudentTable(SQLiteDatabase db, String tableName) {
        super(db, tableName);
    }

    public StudentTable(SQLiteDatabase db) {
        super(db);
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
}
