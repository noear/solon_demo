package webapp.dso.mapper;


import org.apache.ibatis.annotations.Mapper;
import webapp.model.AppxModel;

import java.util.List;

@Mapper
public interface Appx2Mapper {
    AppxModel appx_get();
    List<AppxModel> appx_get_page();
    AppxModel appx_get2(int app_id);
}

