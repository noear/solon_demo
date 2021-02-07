package webapp.dso.mapper;

import java.math.*;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

import org.noear.weed.BaseMapper;
import org.noear.weed.DataItem;
import org.noear.weed.DataList;
import org.noear.weed.annotation.Db;
import org.noear.weed.xml.Namespace;
import webapp.model.*;

@Db("db1")
@Namespace("webapp.dso.mapper.SqlMapper")
public interface SqlMapper{
    //随便取条数据的ID
    int appx_get() throws SQLException;

    //随便取条数据的ID
    int appx_get0() throws SQLException;

    //根据id取条数据
    AppxModel appx_get2(int app_id) throws SQLException;

    List<AppxModel> appx_getlist(int app_id) throws SQLException;

    List<Integer> appx_getids() throws SQLException;

    Set<Integer> appx_getids2() throws SQLException;

    void appx_add() throws SQLException;
}
