package Collections;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hospital {

    public static void main(String[] args) {
        float[] array = generatePatientsTemperatures(5);
        System.out.println(getReport(array));
    }

    public static float[] generatePatientsTemperatures(int count) {
        Random random = new Random();
        float[] temperatures = new float[count];

        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = 32.0f + random.nextFloat() * (42.0f - 32.0f);
        }
        return temperatures;
    }

    public static String getReport(float[] temperatureData) {
        String temperatureList = IntStream.range(0, temperatureData.length)
                .mapToObj(i -> String.format("%.1f", temperatureData[i]))
                .collect(Collectors.joining(", "));

        double averageTemperature = IntStream.range(0, temperatureData.length)
                .mapToDouble(i -> temperatureData[i])
                .average()
                .orElse(0);

        int healthyCount = (int) IntStream.range(0, temperatureData.length)
                .mapToDouble(i -> temperatureData[i])
                .filter(i -> i > 36.2 && i < 36.9)
                .count();

        return String.format("Температура пацієнтів: %s \n" + "Середня температура: %.1f \n" + "Кількість здорових пацієнтів: %d", temperatureList, averageTemperature, healthyCount);
    }
}
