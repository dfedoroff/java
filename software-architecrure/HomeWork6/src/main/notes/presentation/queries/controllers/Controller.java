package main.notes.presentation.queries.controllers;

import main.notes.presentation.queries.views.Presenter;

/**
 * Абстрактный класс контроллера, предоставляющий метод для работы с представлениями.
 */
public abstract class Controller {

    /**
     * Метод для отображения представления с использованием указанного презентера.
     *
     * @param presenter презентер для отображения представления
     * @param <T> тип презентера, который расширяет интерфейс Presenter
     */
    public <T extends Presenter> void view(T presenter) {
        // Метод для реализации в подклассах
    }
}
