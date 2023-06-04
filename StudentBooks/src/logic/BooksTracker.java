package logic;

import domain.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class BooksTracker {
    private Map<Student, Integer> map;

    public BooksTracker() {
        this.map = new HashMap<>();
    }

    public void addStudent(String id) {
        map.put(new Student(id), 0);
    }

    public void readBook(String id, int books) {
        Student student = new Student(id);
        if (!map.containsKey(student)) {
            System.out.println("There is no student with the ID " + id);
            return;
        }
        map.put(student, map.get(student) + books);

    }

    public int findBooks(String id) {
        return map.getOrDefault(new Student(id), -1);
    }

    public int totalBooks() {
        return map.values().stream()
                .reduce((a, b) -> a + b)
                .get();
    }

    public double averageBooks() {
        return map.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public String[] fewerThanTenBooks() {
        return map.keySet().stream()
                .filter(student -> map.get(student) < 10)
                .map(student -> student.getId())
                .toArray(String[]::new);

    }

    public String[] goldSilverBronze() {
        return map.keySet().stream()
                .sorted((o1, o2) -> map.get(o2) - map.get(o1))
                .limit(3)
                .map(student -> student.getId())
                .toArray(String[]::new);
    }




}
