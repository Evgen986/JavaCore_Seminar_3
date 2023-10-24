package org.example;

import org.example.models.AllWorker;
import org.example.models.Freelancer;
import org.example.models.Worker;
import org.example.models.WorkerBase;
import org.example.utils.comparators.WorkerDateOfBirthComparator;
import org.example.utils.comparators.WorkerNameComparator;
import org.example.utils.comparators.WorkerSalaryComparator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * Точка входа в программу.
 */
public class Main {
    public static void main(String[] args) {
        // Задание 1: Помещаем работников в коллекцию с параметризацией родительского класса WorkerBase
        List<WorkerBase> workersList = new ArrayList<>(Arrays.asList(
                Worker.createWorker(
                        "Василий",
                        LocalDate.of(1980, Month.JUNE, 21),
                        new BigDecimal(50000)),
                Freelancer.createFreelancer(
                        "Петр",
                        LocalDate.of(1985, Month.APRIL, 18),
                        new BigDecimal(500)),
                Worker.createWorker(
                        "Иван",
                        LocalDate.of(1986, Month.MARCH, 3),
                        new BigDecimal(75325)),
                Freelancer.createFreelancer(
                        "Сергей",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        new BigDecimal(350)),
                Worker.createWorker(
                        "Александр",
                        LocalDate.of(1963, Month.AUGUST, 3),
                        new BigDecimal(30000)),
                Freelancer.createFreelancer(
                        "Ильдар",
                        LocalDate.of(1965, Month.MAY, 20),
                        new BigDecimal(620)),
                Worker.createWorker(
                        "Александр",
                        LocalDate.of(1960, Month.SEPTEMBER, 25),
                        new BigDecimal(30000)),
                Freelancer.createFreelancer(
                        "Ильдар",
                        LocalDate.of(1960, Month.JANUARY, 8),
                        new BigDecimal(620))
        ));

        System.out.println("============== Коллекция работников ===================");
        for (WorkerBase worker : workersList){
            System.out.println(worker);
        }
        System.out.println();

        // Задание 2: Сортируем полученную коллекцию по полям родительского класса
        System.out.println("=============== Сортировка по имени, затем по дате рождения ==================");
        workersList.sort(new WorkerNameComparator().thenComparing(new WorkerDateOfBirthComparator()));
        for (WorkerBase worker : workersList){
            System.out.println(worker);
        }
        System.out.println();

        // Задание 3: Сортируем полученную коллекцию по поведению дочерних классов.
        System.out.println("=================== Сортировка по зарплате ============================");
        workersList.sort(new WorkerSalaryComparator());
        for (WorkerBase worker : workersList){
            System.out.println(worker);
        }
        System.out.println();

        // Задание 4: Помещаем созданную коллекцию в собственный тип объекта AllWorker и перебираем ее.
        System.out.println("====================== Коллекция обернутая типом AllWorker =========================");
        AllWorker allWorker = new AllWorker(workersList);
        for (WorkerBase worker : allWorker){
            System.out.println(worker);
        }
    }
}