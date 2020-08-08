package webapp.dso.db1;


import org.apache.ibatis.annotations.Mapper;
import webapp.model.AppxModel;

@Mapper
public interface AppxMapper {
    AppxModel appx_get();
    AppxModel appx_get2(int app_id);
}

