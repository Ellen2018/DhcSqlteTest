package com.ellen.dhcsqltetest.bean;
import com.ellen.dhcsqlitelibrary.table.annotation.field.Operate;
import com.ellen.dhcsqlitelibrary.table.annotation.field.OperateEnum;
import com.ellen.dhcsqlitelibrary.table.annotation.field.SqlType;
import com.ellen.dhcsqlitelibrary.table.annotation.field.bound.EndAutoString;
import com.ellen.dhcsqlitelibrary.table.annotation.field.bound.MajorKey;
import com.ellen.sqlitecreate.createsql.helper.SQLFieldTypeEnum;

import java.util.Map;
import java.util.Set;

public class Student {

    /**
     * 学号
     */
    @MajorKey(isAutoIncrement = true)
    private int sid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    @EndAutoString("CHECK(age != 5)")
    private int age;

    /**
     * 科目以及成绩
     */
    //声明它是属于数据结构的属性
    private Map<String,Integer> subjectMap;

    /**
     * 总分
     */
    private int allGrade;

    /**
     * 是否为男生
     */
    private boolean isMan;

    @SqlType(sqlFiledType = SQLFieldTypeEnum.TEXT)//映射为TEXT类型，不限制长度
    @Operate(operate = OperateEnum.JSON)//映射成Json
    private Father father;


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Integer> getSubjectMap() {
        return subjectMap;
    }

    public void setSubjectMap(Map<String, Integer> subjectMap) {
        this.allGrade = 0;
        Set<String> subjectSet = subjectMap.keySet();
        for(String subject:subjectSet){
            this.setAllGrade(this.getAllGrade() + subjectMap.get(subject));
        }
        this.subjectMap = subjectMap;
    }

    public int getAllGrade() {
        return allGrade;
    }

    public void setAllGrade(int allGrade) {
        this.allGrade = allGrade;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", subjectMap=" + subjectMap +
                ", allGrade=" + allGrade +
                ", isMan=" + isMan +
                ", father=" + father +
                '}';
    }
}
