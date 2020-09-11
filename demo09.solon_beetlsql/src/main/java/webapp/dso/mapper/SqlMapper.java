package webapp.dso.mapper;

import java.util.*;

import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Update;
import webapp.model.*;

@SqlResource("SqlMapper")
public interface SqlMapper {
    //随便取条数据的ID
    int appx_get() throws Exception;

    //根据id取条数据
    AppxModel appx_get2(int app_id) throws Exception;

    List<AppxModel> appx_getlist(int app_id) throws Exception;

    List<Integer> appx_getids() throws Exception;

    @Update
    void appx_add();
}
