package webapp.dso.mapper;

import java.math.*;
import java.time.*;
import java.util.*;

import org.noear.weed.BaseMapper;
import org.noear.weed.DataItem;
import org.noear.weed.DataList;
import org.noear.weed.annotation.Db;
import org.noear.weed.xml.Namespace;
import webapp.model.*;

@Db("db2")
@Namespace("webapp.dso.mapper")
public interface SqlMapper{
    int appx_get() throws Exception;

    AppxModel appx_get2(int app_id) throws Exception;

    Map<String,Object> appx_get3(String tb, int app_id) throws Exception;

    List<AppxModel> appx_getlist(int app_id) throws Exception;

    List<Integer> appx_getids() throws Exception;
}
