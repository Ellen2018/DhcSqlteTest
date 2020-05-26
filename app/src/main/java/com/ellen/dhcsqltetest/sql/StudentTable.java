package com.ellen.dhcsqltetest.sql;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.json.JsonLibraryType;
import com.ellen.dhcsqlitelibrary.table.operate.AutoDesignOperate;
import com.ellen.dhcsqlitelibrary.table.reflection.ZxyLibrary;
import com.ellen.dhcsqlitelibrary.table.reflection.ZxyTable;
import com.ellen.dhcsqltetest.bean.Student;
import com.ellen.dhcsqltetest.bean.Subject;
import com.ellen.sqlitecreate.createsql.helper.SQLFieldType;
import com.ellen.sqlitecreate.createsql.helper.SQLFieldTypeEnum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTable extends ZxyTable<Student,StudentOperate> {

    public StudentTable(SQLiteDatabase db, Class<? extends Student> dataClass, Class<? extends AutoDesignOperate> autoClass) {
        super(db, dataClass, autoClass);
    }

    public StudentTable(SQLiteDatabase db, Class<? extends Student> dataClass, String autoTableName, Class<? extends AutoDesignOperate> autoClass) {
        super(db, dataClass, autoTableName, autoClass);
    }

    @Override
    protected SQLFieldType getSqlFieldType(String classFieldName, Class typeClass) {
        if(classFieldName.equals("isMan")){
            return new SQLFieldType(SQLFieldTypeEnum.TEXT,1);
        }else {
            return super.getSqlFieldType(classFieldName, typeClass);
        }
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

    /**
     * 恢复数据结构数据
     * @param classFieldName
     * @param json
     * @return
     */
    @Override
    protected Object resumeDataStructure(String classFieldName, String json) {
        if(classFieldName.equals("subjectMap")){
            Type type = new TypeToken<HashMap<Subject,Integer>>() {}.getType();
            Map<Subject,Integer> subjectMap = new Gson().fromJson(json, type);
            return subjectMap;
        }
        return super.resumeDataStructure(classFieldName, json);
    }
}
