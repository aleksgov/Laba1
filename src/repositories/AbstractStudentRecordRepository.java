package repositories;
import Interfaces.SearchableStudentRecordRepository;
import entities.StudentRecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractStudentRecordRepository<T extends StudentRecord> implements SearchableStudentRecordRepository<T> {
    protected List<T> records = new ArrayList<>();
    @Override
    public void add(T record) {
        records.add(record);
    }
    @Override
    public void remove(T record) {
        records.remove(record);
    }
    @Override
    public void update(T record) {
        int index = records.indexOf(record);
        if(index != -1) {
            records.set(index, record);
        }
    }
    @Override
    public T findById(String id) {
        return records.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<T> sortByDate() {
        return records.stream().sorted(Comparator.comparing(StudentRecord::getDate)).collect(Collectors.toList());
    }

    @Override
    public List<T> search(String keyword) {
        return records.stream()
                .filter(r -> r.getStudentName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

}
