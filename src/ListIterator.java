public class ListIterator {           // Класс для управления списком
    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list) {
        ourList = list;
        reset();
    }

    public void reset(){
        current = ourList.getFirst(); // Указываем текущий элемент итератора на первый элемент списка
        previous = null;
    }

    public boolean atEnd(){          // TODO записать проверку на последний элемент списка в понятной Вам форме
        return current.next == null; // Проверяем есть ли следующий элемент
    }

    public Link getCurrent(){
        return current;
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    /**
     *Метод для вставки после текущего элемента - в котором находится итератор
     * @param dd вставляемое значение(нейминг автора книги)
     */
    public void insertAfter(long dd){
        Link newLink = new Link(dd);              // Создаем новый элемент списка
        if(ourList.isEmpty()){                    // Проверить пуст ли список
            ourList.setFirst(newLink);            // Если да, то добавляем в первый элемент
            current = newLink;
        }
        else {                                    // В противном случае
            newLink.next = current.next;          // Ссылке на следующий элемент от вставляемого элемента присвоена ссылка на следующий элемент текущего элемента
            current.next = newLink;               // Ссылка на следующий элемент текущего элемента ссылается на новый элемент
            nextLink();                           // Переходим к следующему элементу
        }
    }

    //TODO Доделать оставшиеся методы из листинга: insertBefore, deleteCurrent. стр.232- 233

    public long deleteCurrent(){
        long value = current.dData;                    // Запоминаем удаляемое значение
        if(previous == null){                          // Проверяем есть ли предыдущий элемент, т.е. удаляем ли мы первый элемент
            ourList.setFirst(current.next);            // Первый элемент теперь равен своему следующему элементу
            reset();                                   // сбрасывает список
        }
        else {
            previous.next = current.next;              // В противном случае предудщий элемент равен следующему элементу - исключаем текущий
            if(atEnd()){                               // Проверяем удалили ли мы последний элемент, если да, то сббрасываем список
                reset();
            }
            else {                                    // В противном случае переходим к следующему элементу
                current = current.next;
            }
        }
        return value;                                  // Возвращаем удаленное значение
    }


}
