package id.amartek.app.service.generic;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    public List<T> Get();

    public Optional<T> Get(Integer id);

    public Boolean Save(T model);

    public Boolean Delete(Integer id);

}
