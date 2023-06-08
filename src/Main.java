import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    /*
    План занятия
    1) Компараторы
    2) Итераторы
     */

    /*
    Теория
    Существуют высокоуровневые(абстракции) инструменты для работы со структурами данных:
    Компаратор и итератор. Они представлены интерфейсами Comparable и Iterable.
    Интерфейсы - контракт, который должен реализовать класс наследник.

    Компараторы поставляют контракт, который обязывает класс представить правило для сортировки объектов этого класса

    Итератор - перебиратель, то что помогает перебрать структуру данных:

    Для простоты рассмотрим уже знакомый нам цикл for:

    for(int i = 0; i < 10; i++){
     Действия
    }

    Переменная i - итератор цикла, т.е. она перебирает цикл.

    Итераторы Глава 5. Стр. 230



     */

    /*
    Заметки

    Вспомнить сортировку пузырьком - мы сравнивали два значения, чтобы определить перестановку, метод compareTo делает то же
    самое
     */

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(7);
        System.out.println("Аrray: " + numbers);
        Collections.sort(numbers);
        System.out.println("Аrray: " + numbers);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(12000, 120, "BMW"));                    // new Car()  - анонимный объект, создается, чтобы сразу использоваться. Дальше к нему обратиться нельзя
        cars.add(new Car(10000, 100, "Volkswagen"));
        cars.add(new Car(8000, 200, "Ford"));

        System.out.println("Cars: \n" + cars);
        //До появления компаратора, Collections просто не знает как отсортировать такую структуру, т.к. у нашего типа(класс) несколько параметров
        //Collections.sort(cars);
        Collections.sort(cars);
        System.out.println("Cars: \n" + cars);

        Comparator<Car> comparator = new Comparator<Car>() {    // Анонинмый класс - Реализуем контракт в точке создания объекта
            @Override
            public int compare(Car o1, Car o2) {
                return o1.price - o2.price;
            }
        };

        Collections.sort(cars, comparator);

        System.out.println("Cars: \n" + cars);

        Comparator<Car> comparator1 = new Comparator<Car>() {    // Анонинмый класс
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (o1.speed - o2.speed);
            }
        };

        //Мой нейминг. Расхождение с автором некритично для понимания.  В книге  класс InterIterApp стр.233
        LinkList list = new LinkList();
        ListIterator iterator1 = list.getIterator();
        iterator1.insertAfter(20);
        iterator1.insertAfter(40);
        list.displayList();
        System.out.println("Удаленный элемент: ");
        System.out.println(iterator1.deleteCurrent());
        System.out.println("Список: ");
        list.displayList();
    }
}
