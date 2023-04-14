package com.kennel;

import com.kennel.controller.KennelAccounting;
import com.kennel.storage.KennelStorage;
import com.kennel.view.ConsoleView;
import com.kennel.view.View;

public class Main {

    public static void main(String[] args) {
        KennelAccounting kennelAccounting = new KennelAccounting(new KennelStorage());
        View view = new ConsoleView(kennelAccounting);

        while (true) {
            view.showKennelRegistry();
            View.MainMenuCommand code = view.showMainMenuWithResult();
            switch (code) {
                case ADD_ANIMAL -> {
                    boolean result = view.showAddAnimalDialog();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                }
                case SHOW_SKILLS -> {
                    view.showDetailInfoAnimalDialog();
                }
                case REMOVE_ANIMAL -> {
                    int removeId = view.showRemoveAnimalDialog();
                    String resMessage = removeId > -1  ? "Выписано животное" + removeId : "Не удалось  выписать животное";
                    System.out.println(resMessage);
                }
                case EXIT -> {
                    System.out.println("Жаль, что вы уходите");
                    return;
                }
            }
        }
    }
}
