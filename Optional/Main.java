package Optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(new SoundCard(new USB("2.0")));

        assert computer !=null : "computer is null!";

        String version = Optional.ofNullable(computer.getSoundCard())
                .map(soundCard -> soundCard.getUsb())
                .map(usb -> usb.getVersion())
                .filter(ver -> ver.equals("2.0")) // якщо версія дорівнює 2.0, то поверне юзб, якщо ні, то поверне null
                .orElse("N/A");  // Якщо USB не знайдений, повертаємо "N/A"

        System.out.println(version);


//        Optional<Computer> computerOptional = Optional.of(computer);
//
//        computerOptional.ifPresent(computer1 -> System.out.println("Комп'ютер існує"));
//
//        if (computerOptional.isPresent()) {
//            System.out.println("Комп'ютер існує");
//        }
//
//        Optional<Computer> computerOptionalEmpty = Optional.empty();
//        Computer computer2 = computerOptionalEmpty.orElse(new Computer(new SoundCard(new USB("3.0"))));
//
//        // Оновлюємо Optional для другого комп'ютера
//        computerOptionalEmpty = Optional.of(computer2);
//
//        // Виводимо версію USB другого комп'ютера
//        computerOptionalEmpty.ifPresent(comp ->
//                comp.getSoundCard()
//                        .map(SoundCard::getUsb)
//                        .map(USB::getVersion)
//                        .ifPresent(version -> System.out.println("Версія USB: " + version))
//        );
// Якщо USB не знайдений, повертаємо "N/A"


//        Optional<String> optionalString = Optional.empty();
//        System.out.println(optionalString.orElse("ПУСТО"));
//        System.out.println(optionalString.orElseGet(Main::getAnotherString));
//        System.out.println(optionalString.orElseThrow(() -> new IllegalStateException("Немає значення")));

    }

    private static String getAnotherString() {
        return "За замовчуванням";
    }
}
