package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
    // _ because number is a private variable
    private ArrayList<Double> _numbers;

    public Excel(ArrayList<Double> numbers) {
        _numbers = numbers;
    }

    public Excel(String numbers) {
        // numbers = "1 3 4 7"
        // strNumArray = numbers.split(" ") -> ["1", "3", "4", "7"]
        // strNumList = {0: "1", 1: "3", 2: "4", 3: "7"}
        // strNumArrayList = {0: "1", 1: "3", 2: "4", 3: "7"}
        String[] strNumArray = numbers.split(" ");

        List<String> strNumList = Arrays.asList(strNumArray);

        ArrayList<String> strNumArrayList = new ArrayList<String>(strNumList);

        strNumArrayList.forEach((value) -> {
            Double doubleValue = Double.parseDouble(value);
            _numbers.add(doubleValue);
        });
    }

    public double findTotal() {
        double Sum = 0;

        for (double value : _numbers) {
            Sum += value;
        }

        return Sum;
    }

    public double findAvg() {
        double average = 0;
        int i;
        double averageFinal;
        for (i = 0; i < _numbers.size(); i++) {
            average = (average + _numbers.get(i));
        }
        averageFinal = average / _numbers.size();

        return averageFinal;
    }

    public double findMax() {
        // 1 2 3 5 7 8 9 1
        double max = _numbers.get(0);
        for (int i = 1; i < _numbers.size(); i++) {
            if (max < _numbers.get(i)) {
                max = _numbers.get(i);
            }
        }
        return max;
    }

    public double findMin() {
        double min = _numbers.get(0);

        for (int i = 1; i < _numbers.size(); i++) {
            if (min > _numbers.get(i))
                min = _numbers.get(i);
        }

        return min;
    }

    public class SwingEventWindow {

    }
}
