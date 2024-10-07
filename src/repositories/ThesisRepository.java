package repositories;

import entities.StudentRecord;
import entities.Thesis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThesisRepository extends AbstractStudentRecordRepository<Thesis> {
    @Override
    public List<Thesis> sortByGrade() {
        return records.stream().sorted(Comparator.comparing(StudentRecord::getGrade).reversed()).collect(Collectors.toList());
    }
}