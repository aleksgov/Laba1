package repositories;

import java.util.List;

public interface StudentRecordRepository<T> {
    void add(T record);
    void update(T record);
    void delete(T record);
    T findById(int id);
    List<T> findAll();
}
