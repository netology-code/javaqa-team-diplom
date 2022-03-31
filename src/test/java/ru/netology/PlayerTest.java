package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {


    @Test // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Петя", если добавлена ТОЛЬКО ОДНА ИГРА
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Петя", если добавлено НЕСКОЛЬКО ИГР
    public void shouldSumGenreIfSomeGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Покорение Марса", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);

        player.installGame(game2);
        player.play(game2, 5);

        int expected = 8;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test // Считает количество часов, которое играли в игру, если она УСТАНОВЛЕНА
    public void shouldCountHoursWhenGameInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int actual = player.play(game, 3);
        assertEquals(3, actual);
    }

    @Test // Выкидывает исключение при попытке сосчитать количество часов, которое играли в игру, если она НЕ УСТАНОВЛЕНА
    public void shouldThrowExceptionWhenGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> player.play(game, 3));
    }

    @Test // Выдает игру заданного жанра "Аркады", в которую играли бОльшее количество часов
    public void shouldReturnMostPlayedByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Покорение Марса", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);

        player.installGame(game2);
        player.play(game2, 5);

        assertEquals("Покорение Марса", player.mostPlayerByGenre("Аркады"));    }
}