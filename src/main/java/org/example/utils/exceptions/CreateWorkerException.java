package org.example.utils.exceptions;

/**
 * Класс собственного исключения, генерируется при подаче некорректных данных во время создания объектов.
 */
public class CreateWorkerException extends RuntimeException {
    /**
     * Конструктор класса исключения, вызывает родительский конструктор класса RuntimeException
     * и передает в него сообщение для пользователя.
     * @param message сообщение для пользователя.
     */
    public CreateWorkerException(String message) {
        super(message);
    }
}
