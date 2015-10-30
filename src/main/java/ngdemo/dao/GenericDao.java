package ngdemo.dao;

public interface GenericDao<T> {
	void persist(T object) throws Exception;

	T get(Integer id);
}
