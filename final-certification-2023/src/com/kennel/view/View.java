package com.kennel.view;

import com.kennel.model.AbstractAnimal;

public interface View {

    enum MainMenuCommand {
        ADD_ANIMAL ("Добавить животное"),
        SHOW_SKILLS("Показать команды"),
        REMOVE_ANIMAL ("Удалить животное"),
        EXIT ("Выйти");

        private String tag;

        MainMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    enum AddSkillMenuCommand {
        ADD_SKILL ("Обучить команде"),
        EXIT ("Выйти");

        private String tag;

        AddSkillMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    void showKennelRegistry();

    MainMenuCommand showMainMenuWithResult();

    boolean showAddAnimalDialog();

    int showRemoveAnimalDialog();

    void showDetailInfoAnimalDialog();

    void showAnimalInfo(AbstractAnimal animal);

    AddSkillMenuCommand showAddSkillMenu(AbstractAnimal animal);

    boolean showAddSkillDialog(AbstractAnimal animal);
}
