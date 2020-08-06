package client;

import client.model.ComplexModel;

public interface ComplexModelService {
    //持久化
    void save(ComplexModel model);

    //读取
    ComplexModel read(Integer modelId);
}
