package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Record {

    private List<Integer> points;

    public Record() {
        this.points = new ArrayList<>();
    }

    public void add(int point) {
        if (point <= 100 && point >= 0) {
            points.add(point);
        }
    }

    public List<Integer> getPoints() {
        return this.points;
    }

    public double average() {
        return points.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(-1);
    }

    public double passingAverage() {
        return passingPoints().stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(-1);
    }

    public double passPercentage() {
        return 100.0 * passingPoints().size() / points.size();
    }

    private List<Integer> passingPoints() {
        return points.stream()
                .filter(p -> p >= 50)
                .collect(Collectors.toList());
    }

    public int howManyStars(int grade) {
        if (grade == 5) {
            return points.stream()
                    .filter(p -> p > 90)
                    .collect(Collectors.toList())
                    .size();
        } else if (grade == 4) {
            return points.stream()
                    .filter(p -> p >= 80 && p < 90)
                    .collect(Collectors.toList())
                    .size();
        } else if (grade == 3) {
            return points.stream()
                    .filter(p -> p < 80 && p >= 70)
                    .collect(Collectors.toList())
                    .size();
        } else if (grade == 2) {
            return points.stream()
                    .filter(p -> p < 70 && p >= 60)
                    .collect(Collectors.toList())
                    .size();
        } else if (grade == 1) {
            return points.stream()
                    .filter(p -> p < 60 && p >= 50)
                    .collect(Collectors.toList())
                    .size();
        } else if (grade == 0) {
            return points.stream()
                    .filter(p -> p < 50)
                    .collect(Collectors.toList())
                    .size();
        }
        return -1;
    }
}
