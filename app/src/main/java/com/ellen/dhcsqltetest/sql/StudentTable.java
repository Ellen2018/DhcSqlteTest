package com.ellen.dhcsqltetest.sql;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;
import com.ellen.dhcsqlitelibrary.table.impl.ZxyTable;
import com.ellen.dhcsqltetest.bean.Student;


public class StudentTable extends ZxyTable<Student,StudentOperate> {


    public StudentTable(SQLiteDatabase db, String tableName, Class<Student> dataClass, Class<StudentOperate> autoClass) {
        super(db, tableName, dataClass, autoClass);
    }

    public StudentTable(SQLiteDatabase db, Class<Student> dataClass, Class<StudentOperate> autoClass) {
        super(db, dataClass, autoClass);
    }

    public StudentTable(ZxyLibrary zxyLibrary, String tableName, Class<Student> dataClass, Class<StudentOperate> autoClass) {
        super(zxyLibrary, tableName, dataClass, autoClass);
    }

    public StudentTable(ZxyLibrary zxyLibrary, Class<Student> dataClass, Class<StudentOperate> autoClass) {
        super(zxyLibrary, dataClass, autoClass);
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
