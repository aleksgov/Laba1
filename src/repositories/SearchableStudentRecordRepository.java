package repositories;

import java.util.List;

public interface SearchableStudentRecordRepository<T> extends SortableStudentRecordRepository<T> {
    List<T> searchByTitle(String title);
}
