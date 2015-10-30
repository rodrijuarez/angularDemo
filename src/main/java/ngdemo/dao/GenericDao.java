package ngdemo.dao;

public interface GenericDao<T> {
	T save(T object) throws Exception;

	T get(Integer id);
}
