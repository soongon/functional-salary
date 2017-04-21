import model.Salary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class StreamDemo {

    public static void main(String[] args) {

        try {
            Map<String, Salary> map =
                Files.lines(Paths.get("src\\Salaries.csv"))
                    .skip(1)
                    .map(x -> {
                        String[] spl = x.split(",");
                        return new Salary(
                                LocalDate.of(Integer.parseInt(spl[0]),1,1),
                                spl[1], spl[2], spl[3], Integer.parseInt(spl[4]));
                    })
                    //.collect(Collectors.toList());
                    .collect(Collectors.toMap(
                            x -> String.valueOf(new Random().nextInt()), x -> x));
            System.out.println(map);

            map.forEach((k, v) -> System.out.println(k + " : " + v));

//            Stream.of(1,2,3,4,5,6,7,8)
//                    .forEach(System.out::println);

//            long sum =
//                    LongStream.range(1, 10000000)
//                    .sum();
//            System.out.println(sum);
//
//            IntStream.generate(() -> 1)
//                    .limit(1)
//                    .forEach(System.out::println);
//
//            Random r = new Random();
//
//            r.ints(1,7)
//                    .limit(10000000)
//                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
