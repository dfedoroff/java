package GameBoard;

import Classes.AbstractTypes.BasicCharacter;
import Classes.AbstractTypes.Healers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Logger {
    public static Queue<String> logQueue = new ArrayDeque<>();

    public static void logHit(BasicCharacter attacker, BasicCharacter defender, double damage) {

        logQueue.add(
                String.format(
                        "%s%c номер:%-3d %s удар %s %c номер:%-3d %s с %.1f повреждения",
                        attacker.getSquadColor(),
                        attacker.getCharacterSymbol(), attacker.getId(),
                        Constants.AnsiColors.ANSI_BLUE, defender.getSquadColor(),
                        defender.getCharacterSymbol(), defender.getId(),
                        Constants.AnsiColors.ANSI_BLUE, damage) +
                        Constants.AnsiColors.ANSI_RESET);
    }

    public static void logDead(BasicCharacter character) {

        logQueue.add(
                String.format(
                        "%s%c номер:%d %s убит",
                        character.getSquadColor(),
                        character.getCharacterSymbol(), character.getId(),
                        Constants.AnsiColors.ANSI_RED) +
                        Constants.AnsiColors.ANSI_RESET);
    }

    public static void logHeal(Healers healer, BasicCharacter character) {

        logQueue.add(healer.getSquadColor() +
                String.format(
                        "%c номер:%-3d вылечен %c номер:%-3d",
                        healer.getCharacterSymbol(), healer.getId(), character.getCharacterSymbol(), character.getId()) +
                Constants.AnsiColors.ANSI_RESET);
    }

    public static void logResurrect(Healers healer, BasicCharacter character) {

        logQueue.add(healer.getSquadColor() +
                String.format(
                        "%c номер:%-3d воскрешен %c номер:%-3d",
                        healer.getCharacterSymbol(), healer.getId(), character.getCharacterSymbol(), character.getId()) +
                Constants.AnsiColors.ANSI_RESET);
    }
}
