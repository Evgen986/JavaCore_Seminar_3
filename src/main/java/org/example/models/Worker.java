package org.example.models;

import org.example.utils.exceptions.CreateWorkerException;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Класс работников на полной занятости.
 */
public class Worker extends WorkerBase {

    /**
     * Месячная заработная ставка работника.
     */
    private final BigDecimal salaryRateOfMonth;


    /**
     * Закрытый конструктор класса.
     *
     * @param name              ФИО работника.
     * @param dateOfBirth       дата рождения работника.
     * @param salaryRateOfMonth заработная ставка работника.
     */
    private Worker(String name, LocalDate dateOfBirth, BigDecimal salaryRateOfMonth) {
        super(name, dateOfBirth);
        this.salaryRateOfMonth = salaryRateOfMonth;
    }

    /**
     * Метод создания нового работника с фиксированным графиком работы,
     * содержит логику проверки корректности вводимых данных.
     *
     * @param name        ФИО не менее трех символов.
     * @param dateOfBirth дата рождения с ограничением не старше 70 и не младше 18 лет.
     * @param salaryRate  заработная ставка, не может быть равной 0 или отрицательной.
     * @return объект работника.
     * @throws CreateWorkerException собственное исключение при подаче некорректных данных.
     */
    public static Worker createWorker(String name, LocalDate dateOfBirth, BigDecimal salaryRate)
            throws CreateWorkerException {
        if (name.length() < 3) throw new CreateWorkerException("Недопустимое ФИО сотрудника!");
        if (dateOfBirth.isBefore(maxYearOfBirth) || dateOfBirth.isAfter(minYearOfBirth))
            throw new CreateWorkerException("Недопустимый возраст сотрудника");
        if (salaryRate.compareTo(new BigDecimal(0)) <= 0)
            throw new CreateWorkerException("Недопустимая зарплатная ставка!");
        return new Worker(name, dateOfBirth, salaryRate);
    }

    /**
     * Переопределенный метод базового класса, расчета з/п работника.
     *
     * @return заработную плату работника.
     */
    @Override
    public BigDecimal calculationPayment() {
        return salaryRateOfMonth;
    }

    @Override
    public String toString() {
        return String.format("Кадровый работник: %s, %s года рождения, получает: %s руб.",
                name, dateOfBirth, this.calculationPayment());
    }
}
