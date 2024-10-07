package repositories;
import entities.CourseWork;
import entities.GradeBook;
import entities.StudentRecord;
import entities.Thesis;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeneralStudentRecordRepository<T extends StudentRecord> extends AbstractStudentRecordRepository<T> {

    @Override
    public List<T> sortByGrade() {
        if (CourseWork.class.isAssignableFrom(typeClass)) {
            return records.stream().sorted(Comparator.comparing(StudentRecord::getGrade).reversed()).collect(Collectors.toList());
        } else if (Thesis.class.isAssignableFrom(typeClass)) {
            return records.stream().sorted(Comparator.comparing(StudentRecord::getGrade).reversed()).collect(Collectors.toList());
        } else {
            return records;
        }
    }

    private Class<T> typeClass;

    public GeneralStudentRecordRepository(Class<T> typeClass) {
        this.typeClass = typeClass;
    }
}
