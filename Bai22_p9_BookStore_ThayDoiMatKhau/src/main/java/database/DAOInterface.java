package database;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> selectAll();
	public T selectById(String t);
	public int insert(T t);
	public int insertAll(ArrayList<T> arr);
	public int delete(String t);
	public int deleteAll(ArrayList<T> arr);
	public int update(T t);
}
