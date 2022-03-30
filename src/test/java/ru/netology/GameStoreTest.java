package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayerTime(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 3);
        assertEquals(store.getSumPlayedTime(), 3);
    }
 /*Тест на самого играющего*/
    @Test
    public void shouldMostPlayerTime(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 2);
        assertEquals(store.getMostPlayer(),"Vasiliy");

    }
    /*Тест на самого играющего при одинкаовых значениях*/
    @Test
    public void shouldMostPlayerTimeSameValues(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 5);
        assertEquals(store.getMostPlayer(),"Vasiliy");

    }
/*Тест на суммирование метода addPlayTime*/
    @Test
    public void shouldSummPlayerTime(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Genadiy", 4);
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 2);
        assertEquals(store.getMostPlayer(),"Genadiy");

    }

    /*Ищет самого играющего игрока при отсутствии их*/
    @Test
    public void shouldGetMostPlayerWithNull(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertEquals(store.getMostPlayer(), null);
    }


    // другие ваши тесты
}
