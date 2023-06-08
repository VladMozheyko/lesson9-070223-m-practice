public class LinkList {              // Класс для работы со списком
    private Link first;

    public LinkList() {
        first = null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link f){
        first = f;                    // Могли бы передавать first в метод и использовать конструкцию this.first = first;
    }

    public boolean isEmpty(){         // TODO записать проверку на пустоту списка в понятной Вам форме
        return first == null;        // == - логическое сравнение, поэтому вернется true или false
    }

    public ListIterator getIterator(){
        return new ListIterator(this);     // this(этот) - передает текущий объект
    }

    public void displayList(){
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


}
