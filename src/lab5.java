import java.util.ArrayList; //імпортуємо необхідні класи
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lab5 {
    public static void main(String[] args) {
        Coffee[] coffees = {
                new BeanCoffee("Арабіка", 500, 480, 4), //створюю об'єкт BeanCoffee з іменем "Арабіка", об'ємом 500, ціною 480 та якістю 4, аналогічно створюю решу об'єктів
                new GroundCoffee("Робуста", 700, 350, 5),
                new InstantCoffee("Ліберіка", 250, 1190, 4),
                new BeanCoffee("Мокко", 300, 660, 4),
                new GroundCoffee("Еспресо", 400, 450, 5)
        };

        CoffeeVan coffeeVan = new CoffeeVan(coffees); //створюю об'єкт CoffeeVan з масивом кави coffees
        System.out.println("Загальний об'єм: " + coffeeVan.getTotalVolume()); //виводжу загальний об'єм вантажівки кави
        System.out.println("Загальна ціна: " + coffeeVan.getTotalPrice()); //виводжу загальну ціну вантажівки кави

        coffeeVan.sortCoffeesByPriceWeightRatio(); //сортую каву за співвідношенням ціни до ваги

        System.out.println("Відсортована кава:"); //виводжу відсортовану каву
        for (Coffee coffee : coffeeVan.getCoffees()) {
            System.out.println(coffee.getName() + " - " + coffee.getPriceWeightRatio()); //виводжу назву кави та її співвідношення ціни до ваги
        }

        int targetQuality = 4; //встановлюю цільову якість кави
        List<Coffee> coffeesInRange = coffeeVan.findCoffeesByQuality(targetQuality); //знаходжу каву з вказаною якістю
        if (!coffeesInRange.isEmpty()) {
            System.out.print("Кава в межах вказаної якості (" + targetQuality + "): ");
            for (int i = 0; i < coffeesInRange.size(); i++) {
                System.out.print(coffeesInRange.get(i).getName()); //виводжу назви кави, що знаходяться в межах вказаної якості
                if (i < coffeesInRange.size() - 1) {
                    System.out.print(", "); //друкування "," якщо об'єкт не один
                }
            }
            System.out.println();
        } else {
            System.out.println("Немає кави такої якості (" + targetQuality + ")"); //виводжу повідомлення, якщо кави з вказаною якістю немає
        }
    }
}

class CoffeeVan {
    private Coffee[] coffees; //масив кави
    private double totalVolume; //загальний об'єм
    private double totalPrice; //загальна ціна

    public CoffeeVan(Coffee[] coffees) {
        this.coffees = coffees;
        totalVolume = calculateTotalVolume(); //обчислення загального об'єму
        totalPrice = calculateTotalPrice(); //обчислення загальної ціни
    }

    public Coffee[] getCoffees() {
        return coffees; //повернення масиву кава
    }

    public double getTotalVolume() {
        return totalVolume; //повернення загального об'єму
    }

    public double getTotalPrice() {
        return totalPrice; //повернення загальної ціни
    }

    public void sortCoffeesByPriceWeightRatio() {
        Arrays.sort(coffees, Comparator.comparingDouble(Coffee::getPriceWeightRatio)); //сортую каву за співвідношенням ціни до ваги
        //використовую компаратор, який порівнює каву за їхнім співвідношенням ціни до ваги.
    }

    public List<Coffee> findCoffeesByQuality(int targetQuality) {
        List<Coffee> coffeesInRange = new ArrayList<>();
        for (Coffee coffee : coffees) {
            if (coffee.getQuality() == targetQuality) {
                coffeesInRange.add(coffee); //додавання кави з вказаною якістю до списку
            }
        }
        return coffeesInRange; //повернення списку кави з вказаною якістю
    }

    private double calculateTotalVolume() {
        double volume = 0;
        for (Coffee coffee : coffees) {
            volume += coffee.getVolume(); //обчислення загального об'єму
        }
        return volume; //повернення загального об'єму
    }

    private double calculateTotalPrice() {
        double price = 0;
        for (Coffee coffee : coffees) {
            price += coffee.getPrice(); //обчислення загальної ціни
        }
        return price; //повернення загальної ціни
    }
}

class Coffee {
    private String name; //назва кави
    private double volume; //об'єм
    private double price; //ціна
    private int quality; //якість

    public Coffee(String name, double volume, double price, int quality) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.quality = quality;
    }

    public String getName() {
        return name; //повернення назви кави
    }

    public double getVolume() {
        return volume; //повернення об'єму кави
    }

    public double getPrice() {
        return price; //повернення ціни кави
    }

    public int getQuality() {
        return quality; //повернення якості кави
    }

    public double getPriceWeightRatio() {
        return price / volume; //обчислення співвідношення ціни до ваги
    }
}

class BeanCoffee extends Coffee { //Класи BeanCoffee, GroundCoffee і InstantCoffee є похідними (підкласами) від базового класу Coffee і успадковують його властивості та методи.
    public BeanCoffee(String name, double volume, double price, int quality) {
        super(name, volume, price, quality);
    }
}

class GroundCoffee extends Coffee {
    public GroundCoffee(String name, double volume, double price, int quality) {
        super(name, volume, price, quality);
    }
}

class InstantCoffee extends Coffee {
    public InstantCoffee(String name, double volume, double price, int quality) {
        super(name, volume, price, quality);
    }
}

