package airline.infra;

import java.util.List;

public interface MemoryRepository<T> {

    void create(T t);

    boolean update(long id, T t);

    boolean delete(long id);

    T findById(long id);

    List<T> findAll();

}
