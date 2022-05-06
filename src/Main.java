import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Ivan", "Ivanov", "Ivanovich", 50_000, 1);
        employees[1] = new Employee("Ivan", "Ivanov", "Sergeevich", 30_000, 1);
        employees[2] = new Employee("Ivan", "Ivanov", "Aleksadrovich", 40_000, 2);
        employees[3] = new Employee("Ivan", "Ivanov", "Semenovich", 20_000, 2);
        employees[4] = new Employee("Ivan", "Ivanov", "Viktorovich", 45_000, 3);
        employees[5] = new Employee("Ivan", "Ivanov", "Petrovich", 10_000, 3);
        employees[6] = new Employee("Ivan", "Ivanov", "Antonovich", 25_000, 4);
        employees[7] = new Employee("Ivan", "Ivanov", "Kirilovich", 35_000, 4);
        employees[8] = new Employee("Ivan", "Ivanov", "Vladimirovcih", 45_000, 5);
        employees[9] = new Employee("Ivan", "Ivanov", "Ilich", 15_000, 5);
        System.out.println(Arrays.toString(employees));
        findSum(employees);
        findMinimumSalary(employees);
        findMaximumSalary(employees);
        findAverageSalary(employees, findSum(employees));
        printFullName(employees);
        increaseSalaryForAll(employees);
        findMinimumSalaryInDivision(employees, 1);
        findMinimumSalaryInDivision(employees, 2);
        findMinimumSalaryInDivision(employees, 3);
        findMinimumSalaryInDivision(employees, 4);
        findMinimumSalaryInDivision(employees, 5);
        findMaximumSalaryInDivision(employees, 1);
        findMaximumSalaryInDivision(employees, 2);
        findMaximumSalaryInDivision(employees, 3);
        findMaximumSalaryInDivision(employees, 4);
        findMaximumSalaryInDivision(employees, 5);
        findSumInDivision(employees,1);
        findSumInDivision(employees,2);
        findSumInDivision(employees,3);
        findSumInDivision(employees,4);
        findSumInDivision(employees,5);
        findMediumSalaryInDivision(employees,1,findSumInDivision(employees,1));
        findMediumSalaryInDivision(employees,1,findSumInDivision(employees,2));
        findMediumSalaryInDivision(employees,1,findSumInDivision(employees,3));
        findMediumSalaryInDivision(employees,1,findSumInDivision(employees,4));
        findMediumSalaryInDivision(employees,1,findSumInDivision(employees,5));
        increaseSalaryForDivision(employees,1);
        increaseSalaryForDivision(employees,2);
        increaseSalaryForDivision(employees,3);
        increaseSalaryForDivision(employees,4);
        increaseSalaryForDivision(employees,5);
        printNamesInDivision(employees,1);
        printNamesInDivision(employees,2);
        printNamesInDivision(employees,3);
        printNamesInDivision(employees,4);
        printNamesInDivision(employees,5);
        minComparison(employees, 23_436);
        maxComparison(employees,23_436);
    }

    static double findSum(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum = sum + employees[i].getSalary();
        }
        System.out.println("Total sum salary expense: " + sum);
        return sum;
    }

    static void findMinimumSalary(Employee[] employees) {
        double minimumSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < minimumSalary) {
                minimumSalary = employees[i].getSalary();
            }
        }
        System.out.println("Minimum salary among all employee: " + minimumSalary);
    }

    static void findMaximumSalary(Employee[] employees) {
        double maximumSalary = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maximumSalary) {
                maximumSalary = employees[i].getSalary();
            }
        }
        System.out.println("Maximum salary among all employee: " + maximumSalary);
    }

    static void findAverageSalary(Employee[] employees, double findSum) {
        double averageSalary = findSum / employees.length;
        System.out.println("Average salary among all employee: " + averageSalary);
    }

    static void printFullName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.print("Full names of all employee: " + employees[i].getName() + " " + employees[i].getSecondName() + " " + employees[i].getFathersName() + ". ");
        }
    }

    static void increaseSalaryForAll(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * 0.08);
        }
    }

    static void findMinimumSalaryInDivision(Employee[] employees, int division) {
        double minimumSalaryInDivision = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && employees[i].getSalary() < minimumSalaryInDivision) {
                minimumSalaryInDivision = employees[i].getSalary();
            }
        }
        System.out.println("Minimum salary in division № " + division + " is " + minimumSalaryInDivision);
    }

    static void findMaximumSalaryInDivision(Employee[] employees, int division) {
        double maximumSalaryInDivision = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maximumSalaryInDivision && employees[i].getDivision() == division) {
                maximumSalaryInDivision = employees[i].getSalary();
            }
        }
        System.out.println("Maximum salary in division № " + division + " is " + maximumSalaryInDivision);
    }

    static double findSumInDivision(Employee[] employees, int division) {
        double sumInDivision = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                sumInDivision = sumInDivision + employees[i].getSalary();
            }
        }
        System.out.println("Sum of salaries in division № " + division + " are " + sumInDivision);
        return sumInDivision;
    }

    static void findMediumSalaryInDivision(Employee[] employees, int division, double sumInDivision) {
        int numberEmployeeInDivision = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getDivision() == division)
                numberEmployeeInDivision = numberEmployeeInDivision +1;
        }
        double averageSalary = sumInDivision / numberEmployeeInDivision;
        System.out.println("Average salary in division № " + division + " is " + averageSalary);
    }

    static void increaseSalaryForDivision(Employee[] employees, int division) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division)
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * 0.12);
        }
    }

    static void printNamesInDivision(Employee[] employees, int division) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division)
                System.out.println();
                System.out.print("Full information of all employee in division №" + division + " : " + employees[i].getName() + " " + employees[i].getSecondName() + " " + employees[i].getFathersName() + " " + employees[i].getSalary() + " " + employees[i].getId());
        }
    }

    static void minComparison(Employee[] employees, double comparison) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() <= comparison)
                System.out.println("Salaries witch are below " + comparison + " : " + employees[i].getName() + " " + employees[i].getSecondName() + " " + employees[i].getFathersName() + " " + employees[i].getSalary() + " " + employees[i].getId());
        }
    }

    static void maxComparison(Employee[] employees, double comparison) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= comparison)
                System.out.println("Salaries witch are higher " + comparison + " : " + employees[i].getName() + " " + employees[i].getSecondName() + " " + employees[i].getFathersName() + " " + employees[i].getSalary() + " " + employees[i].getId());
        }
    }
}