package server;

import client.ComplexModelService;
import client.model.ComplexModel;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;

import java.util.HashMap;
import java.util.Map;

@Mapping("/test/")
@Component(tag = "hessian")
public class ComplexModelServiceImpl implements ComplexModelService {
    private Map<Integer,ComplexModel> models = new HashMap<Integer, ComplexModel>();


    @Override
    public void save(ComplexModel model) {
        if (model.getId() == null){
            throw new IllegalArgumentException("id could not be null");
        }

        models.put(model.getId(), model);
    }

    @Override
    public ComplexModel read(Integer modelId) {
        return models.get(modelId);
    }
}
