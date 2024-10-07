package repositories;

import entities.GradeBook;

import java.util.Comparator;
import java.util.stream.Collectors;
import  java.util.List;

public class GradeBookRepository extends AbstractStudentRecordRepository<GradeBook> {
    @Override
    public List<GradeBook> sortByGrade() {
        return records.stream().sorted(Comparator.comparing(GradeBook::getAverageGrade).reversed()).collect(Collectors.toList());
    }
}