package ngdemo.dao;

import java.util.List;

public interface GenericDao<T> {
	T save(T object) throws Exception;

	T get(Integer id);

    void delete(int id);

    List<T> getAll();
}
