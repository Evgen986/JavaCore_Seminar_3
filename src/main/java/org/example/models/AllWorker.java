package org.example.models;

import java.util.Iterator;
import java.util.List;

/**
 * Класс обертка для хранения коллекции всех работников.
 */
public class AllWorker implements Iterable<WorkerBase> {
    /**
     * Лист работников.
     */
    private List<WorkerBase> workersList;
    /**
     * Счетчик для использования итератора.
     */
    private int counter;

    /**
     * Конструктор класса.
     *
     * @param list коллекция работников.
     */
    public AllWorker(List<WorkerBase> list) {
        this.workersList = list;
        counter = 0;
    }

    /**
     * Переопределенный метод итератора.
     *
     * @return
     */
    @Override
    public Iterator<WorkerBase> iterator() {
        return new Iterator<WorkerBase>() {
            // В анонимном классе определяем логику итерации

            /**
             * Проверка, что есть по чему итерироваться.
             * @return true - если не вышли за пределы коллекции, иначе - false.
             */
            @Override
            public boolean hasNext() {
                return counter < workersList.size();
            }

            /**
             * Возвращаем элемент из коллекции, при корректной проверке возможности итерации
             * и увеличиваем счетчик на 1.
             * @return объект коллекции.
             */
            @Override
            public WorkerBase next() {
                if (!hasNext()) {
                    return null;
                } else {
                    return workersList.get(counter++);
                }
            }
        };
    }
}
