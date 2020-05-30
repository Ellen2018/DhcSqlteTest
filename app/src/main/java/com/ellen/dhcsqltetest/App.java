package com.ellen.dhcsqltetest;

import android.app.Application;
import android.util.Log;

import com.ellen.dhcsqlitelibrary.table.impl.TotalListener;
import com.ellen.dhcsqlitelibrary.table.impl.ZxyTable;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ZxyTable.setTotalListener(new TotalListener() {
            @Override
            public void exeSql(String tableName, String sql) {
                Log.e("SQL全局监听",tableName+":"+sql);
            }
        });
    }
}
