import java.util.List;
import java.util.ArrayList;

public class KnapsackProblemGreedyAlgorithm {


    public static class Solution {

        private List<Subject> subjects = new ArrayList<>();
        private int totalPrice = 0;

        public void addSubject(Subject subject) {
            subjects.add(subject);
            totalPrice += subject.getPrice();
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public List<Subject> getSubjects() {
            return subjects;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Knapsack contains: ");
            for (Subject subject : subjects) {
                stringBuilder.append(subject.getName()).append(" ");
            }
            return stringBuilder.toString();
        }

    }

    public static class Subject {

        private final String name;
        private final int weight;
        private final int price;

        public Subject(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public static Solution solve(List<Subject> subjects, int weight) {
        Solution solution = new Solution();

        int freeSpace = weight;
        Subject localMaximum = findLocalMaximum(subjects, solution, freeSpace);
        while (localMaximum != null) {
            solution.addSubject(localMaximum);
            freeSpace = freeSpace - localMaximum.getWeight();
            localMaximum = findLocalMaximum(subjects, solution, freeSpace);
        }
        return solution;
    }

    private static Subject findLocalMaximum(List<Subject> subjects, Solution currentSolution, int weight) {
        Subject localMaximum = null;
        int localMaximumValue = 0;
        for(Subject subject : subjects) {
            //if we haven't had the subject in an our intermediate solution
            if (!currentSolution.getSubjects().contains(subject) && subject.getWeight() <= weight) {
                if (subject.getPrice() > localMaximumValue) {
                    localMaximum = subject;
                    localMaximumValue = subject.getPrice();
                }
            }
        }
        return localMaximum;
    }

    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject("Recorder", 4, 3000));
        subjects.add(new Subject("Notebook", 3, 2000));
        subjects.add(new Subject("Guitar", 1, 1500));
        subjects.add(new Subject("IPhone", 1, 2000));

        Solution maxPriceKnapsack = solve(subjects, 4);
        System.out.println(maxPriceKnapsack);
    }
}