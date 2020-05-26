package com.ellen.dhcsqltetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ellen.dhcsqltetest.bean.Father;
import com.ellen.dhcsqltetest.bean.Student;
import com.ellen.dhcsqltetest.sql.AppLibrary;
import com.ellen.dhcsqltetest.sql.StudentOperate;
import com.ellen.dhcsqltetest.sql.StudentTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //清空数据
        studentTable.clear();


        //增加数据

        //增加单条数据
        Student student = new Student();
        student.setName("周杰伦");
        student.setAge(18);
        student.setSubjectMap(getMapSubject());
        student.setFather(new Father("周父","8888888888888"));

        studentTable.saveData(student);

        printAllData("保存单条数据后的所有数据：",studentTable);

        //增加多条数据
        List<Student> studentList = new ArrayList<>();
        for(int i=0;i<10;i++){
            student = new Student();
            student.setName("Name_"+i);
            student.setAge(i);
            student.setSubjectMap(getMapSubject());
            student.setFather(new Father("Father_Name_"+i,"phone_number_"+i));
            studentList.add(student);
        }
        studentTable.saveData(studentList);

        printAllData("保存多条数据后的所有数据：",studentTable);

        //删除数据
        //删除sid为0的数据(通过元操作接口)
        studentTable.getAutoDesignOperate().deleteBySid(0);

        //也可以自己构建sql进行删除
        //studentTable.delete("deleteSql");

        printAllData("删除sid = 0后所以数据：",studentTable);

        //修改数据(通过元操作接口)
        studentTable.getAutoDesignOperate().updateStudentNameById(3,"王力宏33333333");

        printAllData("修改sid = 3的name = 王力宏 所有数据：",studentTable);

        //也可以自己构建sql进行更新
        //studentTable.update(student,"whereSql");

        //查询数据(通过元操作接口)
        List<Student> students = studentTable.getAutoDesignOperate().searchByLikeName("0");

        printListStudent("查询 name 里带 0 的所有数据：",students);

    }

    /**
     * 随机产生成就到科目里并返回一个Map
     * @return
     */
    private Map<String,Integer> getMapSubject(){

        Map<String,Integer> map = new HashMap<>();
        map.put("语文", (int) (Math.random()*101));
        map.put("数学", (int) (Math.random()*101));
        map.put("体育", (int) (Math.random()*101));
        return map;
    }

    private void printAllData(String tag,StudentTable studentTable){
        //获取数据库中所有数据
        List<Student> studentList = studentTable.getAllData(null);
        if(studentList == null || studentList.size() == 0){
            Log.e(tag, "表中无数据");
        }else {
            printListStudent(tag, studentList);
        }
    }

    private void printListStudent(String tag,List<Student> students){
        for(Student student:students){
           Log.e(tag,student.toString());
        }
    }

}
