package repositories;

import java.util.List;

public interface SortableStudentRecordRepository<T> extends StudentRecordRepository<T> {
    List<T> sortByDate();
    List<T> sortByGrade();
}
