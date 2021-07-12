package webapp.dso.mapper;

import org.apache.ibatis.annotations.Mapper;
import webapp.model.AppxModel;

import java.util.List;

@Mapper
public interface AppxMapper {
    List<AppxModel> appx_get_page();
}

