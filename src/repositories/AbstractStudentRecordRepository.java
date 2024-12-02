package repositories;

import entities.StudentRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractStudentRecordRepository<T extends StudentRecord> implements SearchableStudentRecordRepository<T> {
    protected final List<T> records = new ArrayList<>();

    @Override
    public void add(T record) {
        records.add(record);
    }

    @Override
    public void update(T record) {
        delete(record);
        add(record);
    }

    @Override
    public void delete(T record) {
        records.removeIf(r -> r.getId() == record.getId());
    }

    @Override
    public T findById(int id) {
        return records.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(records);
    }

    @Override
    public List<T> sortByDate() {
        return records.stream()
                .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<T> sortByGrade() {
        return records.stream()
                .sorted((r1, r2) -> Integer.compare(r2.getGrade(), r1.getGrade()))  // сортировка по убыванию оценок
                .collect(Collectors.toList());
    }

    @Override
    public List<T> searchByTitle(String keyword) {
        return records.stream()
                .filter(record -> record.getStudentName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
