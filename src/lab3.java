public class lab3 { //оголошую клас lab3
    public static void main(String[] args) { //цей рядок визначає метод main
        //створення масиву з об'єктами класу "Навчальний заклад"
        NavchalnyiZaklad[] zaklady = new NavchalnyiZaklad[3];

        // Ініціалізація об'єктів класу "Навчальний заклад"
        zaklady[0] = new NavchalnyiZaklad("Школа №4", "Школа", 24, "Київ", 104);
        zaklady[1] = new NavchalnyiZaklad("Університет Франка", "Університет", 175, "Львів", 19300);
        zaklady[2] = new NavchalnyiZaklad("Коледж", "Коледж", 31, "Київ", 375);

        // Виведення даних про навчальні заклади
        for (NavchalnyiZaklad zaklad : zaklady) {
            System.out.println("Назва: " + zaklad.getName()); //виводжу назву навчального закладу
            System.out.println("Тип: " + zaklad.getType()); //виводжу тип навчального закладу
            System.out.println("Вік: " + zaklad.getAge()); //виводжу вік навчального закладу
            System.out.println("Місцезнаходження: " + zaklad.getLocality()); //виводжу місцезнаходження навчального закладу
            System.out.println("Кількість студентів: " + zaklad.getNumberOfStudents()); //виводжу к-ть студентів навчального закладу
            System.out.println();
        }
    }
}
class NavchalnyiZaklad {
    private String name; //приватне поле, що зберігає назву навчального закладу
    private String type; //приватне поле, що зберігає тип навчального закладу
    private int age; //приватне поле, що зберігає вік навчального закладу
    private String locality; //приватне поле, що зберігає місцезнаходження навчального закладу
    private int numberOfStudents; //приватне поле, що зберігає к-ть студентів навчального закладу

    public NavchalnyiZaklad(String name, String type, int age, String locality, int numberOfStudents) {
        this.name = name; //ініціалізація поля name з переданим значенням
        this.type = type; //ініціалізація поля type з переданим значенням
        this.age = age; //ініціалізація поля age з переданим значенням
        this.locality = locality; //ініціалізація поля locality з переданим значенням
        this.numberOfStudents = numberOfStudents; //ініціалізація поля numberOfStudents з переданим значенням
    }
    public String getName() {
        return name;
    } //повертає значення поля name
    public String getType() {
        return type;
    } //повертає значення поля type
    public int getAge() {
        return age;
    } //повертає значення поля age
    public String getLocality() {
        return locality;
    } //повертає значення поля locality
    public int getNumberOfStudents() {
        return numberOfStudents;
    } //повертає значення поля numberOfStudents
}
