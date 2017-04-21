import model.Salary;
import service.FunctionalSalaryService;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class FunctionalSalaryMain {
    public static void main(String[] args) {

        List<Salary> list = FunctionalSalaryService.generateSalaryList("src\\Salaries.csv");

        //1. 1900년대 연봉
        //OptionalDouble optAverage =
                list.stream()
                .filter(x -> x.getYearId().getYear() < 2000)
                .mapToInt(Salary::getSalary)
                .average();

        //2. NYY연봉
        //OptionalDouble optAverage =
                list.stream()
                .filter(x -> x.getTeamId().equals("NYY"))
                .mapToInt(x -> x.getSalary())
                .average();

        //3. 최상위 10명 평균연봉
        OptionalDouble optAverage =
                list.stream()
                .sorted((x, y) -> y.getSalary() - x.getSalary())
                .mapToInt(x -> x.getSalary())
                .limit(10)
                .average();

        if (optAverage.isPresent()) {
            System.out.printf("TOP10 평균 연봉은 %.2f달러 입니다.\n", optAverage.getAsDouble());
        } else {
            System.out.println("no data");
        }
    }
}
