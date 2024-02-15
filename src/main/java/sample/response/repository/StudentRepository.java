package sample.response.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import sample.response.model.Student;

@Repository
public class StudentRepository {
    private final Set<Student> students = new HashSet<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students.stream()
                .sorted()
                .toList();
    }

    public List<Student> findByGrade(int grade) {
        return students.stream()
                .filter(s -> s.getGrade() == grade)
                .toList();
    }
}
