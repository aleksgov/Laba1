package repositories;

import entities.CourseWork;
import entities.StudentRecord;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseWorkRepository extends AbstractStudentRecordRepository<CourseWork> {
    @Override
    public List<CourseWork> sortByGrade() {
        return records.stream().sorted(Comparator.comparing(StudentRecord::getGrade).reversed()).collect(Collectors.toList());
    }
}
