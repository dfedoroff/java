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
                        "%s%c id:%-3d %s удар %s %c id:%-3d %s с %.1f повреждения",
                        attacker.getSquadColor(),
                        attacker.getCharacterSymbol(), attacker.getId(),
                        AnsiColors.ANSI_BLUE, defender.getSquadColor(),
                        defender.getCharacterSymbol(), defender.getId(),
                        AnsiColors.ANSI_BLUE, damage) +
                        AnsiColors.ANSI_RESET);
    }

    public static void logDead(BasicCharacter character) {

        logQueue.add(
                String.format(
                        "%s%c id:%d %s убит",
                        character.getSquadColor(),
                        character.getCharacterSymbol(), character.getId(),
                        AnsiColors.ANSI_RED) +
                        AnsiColors.ANSI_RESET);
    }

    public static void logHeal(Healers healer, BasicCharacter toHeal) {

        logQueue.add(healer.getSquadColor() +
                String.format(
                        "%c id:%-3d вылечен %c id:%-3d",
                        healer.getCharacterSymbol(), healer.getId(), toHeal.getCharacterSymbol(), toHeal.getId()) +
                AnsiColors.ANSI_RESET);
    }

    public static void logResurrect(Healers healer, BasicCharacter characterDamaged) {

        logQueue.add(healer.getSquadColor() +
                String.format(
                        "%c id:%-3d воскрешенный %c id:%-3d",
                        healer.getCharacterSymbol(), healer.getId(), characterDamaged.getCharacterSymbol(), characterDamaged.getId()) +
                AnsiColors.ANSI_RESET);
    }
}
