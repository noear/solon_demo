package webapp.dso.db2;


import org.apache.ibatis.annotations.Mapper;
import webapp.model.AppxModel;

@Mapper
public interface Appx2Mapper {
    AppxModel appx_get();
    AppxModel appx_get2(int app_id);
}

