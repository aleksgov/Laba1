package Interfaces;

import java.util.List;

public interface SearchableStudentRecordRepository<T> extends SortableStudentRecordRepository<T> {
    List<T> search(String keyword);
}