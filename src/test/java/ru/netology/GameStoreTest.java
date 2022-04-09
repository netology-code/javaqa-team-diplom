package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();
    Game game1 = store.publishGame("Танки", "онлайн");
    Game game2 = store.publishGame("Майн Крафт", "Бой");
    Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game4 = store.publishGame("Симс", "Симулятор");
    Game game5 = store.publishGame("Змейка", "Примитив");


    @Test
    public void addGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Танки", "онлайн");
        Game game2 = store.publishGame("Майн Крафт", "Бой");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game4 = store.publishGame("Симс", "Симулятор");
        Game game5 = store.publishGame("Змейка", "Примитив");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
        assertTrue(store.containsGame(game5));
        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldAddGameTrue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }



    @Test
    public void ShouldGetMostPlayer() {

        GameStore store = new GameStore();

        Game game = store.publishGame("Майн Крафт", "выживание");

        store.addPlayTime("1", 10);
        store.addPlayTime("1", 30);
        store.addPlayTime("2", 30);

        String expected = "1";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void getSumPlayedTimeTest() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Танки", "онлайн");

        store.addPlayTime("1", 11);
        store.addPlayTime("2", 22);
        store.addPlayTime("3", 33);

        int expected = 66;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }
}