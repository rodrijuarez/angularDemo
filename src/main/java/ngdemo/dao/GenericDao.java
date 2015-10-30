package ngdemo.dao;

public interface GenericDao<T> {
	void persist(T object) throws Exception;

	T get(Class<T> type, Integer id);
}
