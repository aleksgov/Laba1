package Interfaces;

import java.util.List;

public interface SortableStudentRecordRepository<T> extends StudentRecordRepository<T> {
    List<T> sortByGrade();
}