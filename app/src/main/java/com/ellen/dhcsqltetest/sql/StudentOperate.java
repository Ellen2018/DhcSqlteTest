package com.ellen.dhcsqltetest.sql;

import com.ellen.dhcsqlitelibrary.table.operate.AutoDesignOperate;
import com.ellen.dhcsqlitelibrary.table.operate.Delete;
import com.ellen.dhcsqlitelibrary.table.operate.Search;
import com.ellen.dhcsqlitelibrary.table.operate.SearchByMajorKey;
import com.ellen.dhcsqlitelibrary.table.operate.TotalSql;
import com.ellen.dhcsqlitelibrary.table.operate.Update;
import com.ellen.dhcsqlitelibrary.table.operate.Value;
import com.ellen.dhcsqltetest.bean.Student;

import java.util.List;

public interface StudentOperate extends AutoDesignOperate {

    /**
     * 通过sid删除指定数据
     * @param sid
     */
    @Delete("sid = @sid")
    void deleteBySid(@Value("sid") int sid);

    /**
     * 更新名字通过sid(学号)
     *
     * @param sid
     * @param newName
     */
    @Update(valueSql = "name = '@newName'", whereSql = "sid = @sid")
    void updateStudentNameById(@Value("sid") int sid, @Value("newName") String newName);

    /**
     * 查询名字中带有str的数据，结果按照id进行排序
     *
     * @param str
     * @return
     */
    @Search(whereSql = "name like '@str'", orderSql = "id ASC")
    List<Student> searchByLikeName(@Value("str") String str);

}
