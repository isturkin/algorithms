import java.util.List;
import java.util.ArrayList;

public class KnapsackProblem {

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

    }

    public static Solution solve(List<Subject> subjects, int weight) {
        Solution[][] solutions = new Solution[subjects.size() + 1][weight + 1];
        for (int i = 0; i <= weight; i++) {
            solutions[0][i] = new Solution();
        }
        for (int i = 0; i <= subjects.size(); i++) {
            solutions[i][0] = new Solution();
        }

        for (int k = 1; k <= subjects.size(); k++) {
            Subject currentSubject = subjects.get(k - 1);
            for (int s = 1; s <= weight; s++) {
                //try to put a subject into a knapsack
                if (currentSubject.getWeight() <= s) {
                    solutions[k][s] = max(solutions[k - 1][s], currentSubject, solutions[k - 1][s - currentSubject.getWeight()]);
                } else {
                    solutions[k][s] = solutions[k - 1][s];
                }
            }
        }
        return solutions[subjects.size()][weight];
    }

    private static Solution max(Solution previous, Subject currentSubject, Solution rest) {
        if (previous.getTotalPrice() > (currentSubject.getPrice() + rest.getTotalPrice())) {
            return previous;
        } else {
            Solution newSolution = new Solution();
            for (Subject subject : rest.subjects) {
                newSolution.addSubject(subject);
            }
            newSolution.addSubject(currentSubject);
            return newSolution;
        }
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
