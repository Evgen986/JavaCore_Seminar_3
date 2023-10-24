package org.example.utils.comparators;

import org.example.models.WorkerBase;

import java.util.Comparator;

/**
 * Компаратор осуществляющий сравнение объектов по дате рождения.
 */
public class WorkerDateOfBirthComparator implements Comparator<WorkerBase> {
    @Override
    public int compare(WorkerBase o1, WorkerBase o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
