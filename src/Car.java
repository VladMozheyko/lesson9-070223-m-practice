public class Car implements Comparable{
    int price;
    double speed;
    String brand;

    public Car(int price, double speed, String brand) {
        this.price = price;
        this.speed = speed;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public double getSpeed() {
        return speed;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", speed=" + speed +
                ", brand='" + brand + '\'' +
                '}' + "\n";
    }

    @Override
    public int compareTo(Object o) {               // Получаем на выход Object, потому что не знаем, какие типы будут сравниваться
        Car car = (Car) o;                         // Приводим(преобразуем) параметр o к типу Car, чтобы сравнить объекты
        return this.brand.compareTo(car.brand);    // TODO 1) Продумать варианты с дробной частью для сравнения по double, которая меньше единицы по модулю => (-1; 1); 2) Реализовать многоуровневую сортировку
    }
}
