package main.java.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoGenerator {

    public static void main(String[] args) {
        List<Integer> lotto = execute();
        System.out.println("lotto = " + lotto);
    }

    public static List<Integer> execute() {
        Random random = new Random();
        Set<Integer> result = new HashSet<>();

        while (result.size() < 6) {
            result.add(random.nextInt(45) + 1);
        }

        return result.stream().toList();
    }

}
