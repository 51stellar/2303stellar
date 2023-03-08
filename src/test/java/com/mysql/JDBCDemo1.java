package com.mysql;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class JDBCDemo1 {
    public static void main(String[] args) throws IOException, SQLException {
        String sql="select regname,leaveamount,id from pv.member where mobilephone=?";
        Object[] value={"15290750137"};
        JDBCUtil jdbcUtil=new JDBCUtil();
        Map<String,Object> map=jdbcUtil.query(sql,"15290750137");
        Set<String> sets=map.keySet();
        for(String set:sets){
            System.out.println("key="+set);
            System.out.println("value="+map.get(set));
        }
    }
}
