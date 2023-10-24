package org.example.models;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Абстрактный класс работника.
 */
public abstract class WorkerBase {
    /**
     * Предельно допустимый возраст работника.
     */
    private static final int MAX_AGE_WORKER = 70;
    /**
     * Минимально допустимый возраст работника.
     */
    private static final int MIN_AGE_WORKER = 18;
    /**
     * Предельно допустимый дата рождения работника.
     */
    protected static LocalDate maxYearOfBirth = LocalDate.now().minusYears(MAX_AGE_WORKER);
    /**
     * Минимально допустимый дата рождения работника.
     */
    protected static LocalDate minYearOfBirth = LocalDate.now().minusYears(MIN_AGE_WORKER);
    /**
     * Идентификатор работника.
     */
    protected long id;
    /**
     * Фамилия, имя, отчество работника.
     */
    protected String name;
    /**
     * Дата рождения работника.
     */
    protected LocalDate dateOfBirth;

    /**
     * Конструктор абстрактного класса.
     *
     * @param name        ФИО работника.
     * @param dateOfBirth дата рождения работника.
     */
    protected WorkerBase(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Получение ФИО работника.
     *
     * @return ФИО работника в строковом представлении.
     */
    public String getName() {
        return name;
    }

    /**
     * Получение даты рождения работника.
     *
     * @return дата рождения работника.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Абстрактный метод расчета з/п работника.
     *
     * @return сумму заработной платы.
     */
    public abstract BigDecimal calculationPayment();

}
