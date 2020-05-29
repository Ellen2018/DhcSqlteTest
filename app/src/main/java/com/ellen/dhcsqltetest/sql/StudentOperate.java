package com.ellen.dhcsqltetest.sql;

import com.ellen.dhcsqlitelibrary.table.annotation.auto.Delete;
import com.ellen.dhcsqlitelibrary.table.annotation.auto.Search;
import com.ellen.dhcsqlitelibrary.table.annotation.auto.TotalSql;
import com.ellen.dhcsqlitelibrary.table.annotation.auto.Update;
import com.ellen.dhcsqlitelibrary.table.annotation.auto.Value;
import com.ellen.dhcsqlitelibrary.table.proxy.AutoDesignOperate;
import com.ellen.dhcsqltetest.bean.Student;

import java.util.List;

/**
 * 元操作接口，注重于Sql语句的构成，而无需写方法的具体实现
 */
public interface StudentOperate extends AutoDesignOperate {

    /**
     * 通过sid删除指定数据
     * @param sid
     */
    @Delete("id = @sid")
    void deleteBySid(@Value("sid") int sid);

    /**
     * 更新名字通过sid(学号)
     *
     * @param sid
     * @param newName
     */
    @Update(valueSql = "name = '@newName'", whereSql = "id = @sid")
    void updateStudentNameById(@Value("sid") int sid, @Value("newName") String newName);

    /**
     * 查询名字中带有str的数据，结果按照id进行排序
     *
     * @param str
     * @return
     */
    @Search(whereSql = "name like '%@str%'", orderSql = "id ASC")
    List<Student> searchByLikeName(@Value("str") String str);

}
