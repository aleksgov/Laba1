package Interfaces;

import java.util.List;

public interface StudentRecordRepository<T> {
    void add(T record);
    void remove(T record);
    void update(T record);
    T findById(String id);
}



