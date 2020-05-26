package com.ellen.dhcsqltetest.bean;

import com.ellen.dhcsqlitelibrary.table.annotation.DataStructure;
import com.ellen.dhcsqlitelibrary.table.annotation.MajorKey;
import com.ellen.dhcsqlitelibrary.table.annotation.Operate;
import com.ellen.dhcsqlitelibrary.table.annotation.OperateEnum;
import com.ellen.dhcsqlitelibrary.table.annotation.SqlType;
import com.ellen.sqlitecreate.createsql.helper.SQLFieldTypeEnum;

import java.util.Map;

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
    private int age;

    /**
     * 科目以及成绩
     */
    @DataStructure //声明它是属于数据结构的属性
    private Map<Subject,Integer> subjectMap;

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

    public void setAge(int age) {
        this.age = age;
    }

    public Map<Subject, Integer> getSubjectMap() {
        return subjectMap;
    }

    public void setSubjectMap(Map<Subject, Integer> subjectMap) {
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
}
