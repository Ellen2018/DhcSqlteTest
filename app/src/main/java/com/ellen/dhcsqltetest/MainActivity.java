package com.ellen.dhcsqltetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ellen.dhcsqltetest.bean.Student;
import com.ellen.dhcsqltetest.sql.AppLibrary;
import com.ellen.dhcsqltetest.sql.StudentOperate;
import com.ellen.dhcsqltetest.sql.StudentTable;
import com.ellen.sqlitecreate.createsql.helper.WhereSymbolEnum;
import com.ellen.sqlitecreate.createsql.order.Order;
import com.ellen.sqlitecreate.createsql.where.Between;
import com.ellen.sqlitecreate.createsql.where.Where;
import com.ellen.sqlitecreate.createsql.where.WhereIn;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建数据库，名字为app_library,版本为1
        AppLibrary appLibrary = new AppLibrary(this,"app_library",1);
        StudentTable studentTable = new StudentTable(appLibrary.getWriteDataBase(), Student.class, StudentOperate.class);
        //创建表
        studentTable.onCreateTableIfNotExits();

    }

    
}
