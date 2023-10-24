package org.example.utils.comparators;

import org.example.models.WorkerBase;

import java.util.Comparator;

/**
 * Компаратор осуществляющий сравнение объектов по поведению, путем вызова метода calculationPayment().
 */
public class WorkerSalaryComparator implements Comparator<WorkerBase> {
    @Override
    public int compare(WorkerBase o1, WorkerBase o2) {
        if (o1.calculationPayment().compareTo(o2.calculationPayment()) == 0) {
            return 0;
        } else if (o1.calculationPayment().compareTo(o2.calculationPayment()) < 1) {
            return -1;
        } else return 1;
    }
}
