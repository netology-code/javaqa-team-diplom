package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    private GameStore store = new GameStore();


    private Game mortalKombat = store.publishGame("Mortal Kombat X", "Fights");
    private Game injustice = store.publishGame("Injustice", "Fights");
    private Game rockNRollRacing = store.publishGame("Rock N Roll Racing", "Race");
    private Game needForSpeed = store.publishGame("Need For Speed", "Race");
    private Game worldOfWarcraft = store.publishGame("World Of Warcraft", "MMORPG");
    private Game lineAge = store.publishGame("Line Age II", "MMORPG");
    private Game worldOfTanks = store.publishGame("Танки Г", "Аркады");
    private Game netologyBattle = store.publishGame("Нетология Баттл Онлайн", "Аркады");


    @Test

    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Leeeeexxxxaaaaa");
        player.installGame(mortalKombat);
        player.play(mortalKombat, 3);

        int expected = 3;
        int actual = player.sumGenre(mortalKombat.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {

        Player player = new Player("Leeeeexxxxaaaaa");
        player.installGame(mortalKombat);
        player.installGame(injustice);
        player.play(mortalKombat, 3);
        player.play(injustice, 3);

        int expected = 6;
        int actual = player.sumGenre(mortalKombat.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfThreeGames() {


        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Leeeeexxxxaaaaa");
        player.installGame(mortalKombat);
        player.play(mortalKombat, 3);

        int expected = 3;
        int actual = player.sumGenre(mortalKombat.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {

        Player player = new Player("Leeeeexxxxaaaaa");
        player.installGame(mortalKombat);
        player.installGame(injustice);
        player.play(mortalKombat, 3);
        player.play(injustice, 3);

        int expected = 6;
        int actual = player.sumGenre(mortalKombat.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfThreeGames() {

        Player player = new Player("Petya");
        player.installGame(mortalKombat);
        player.play(mortalKombat, 3);
        player.installGame(injustice);
        player.play(injustice, 5);
        player.installGame(rockNRollRacing);
        player.play(rockNRollRacing, 5);

        int expected = 8;
        int actual = player.sumGenre(mortalKombat.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldExpIfGameNotInstall() {

        Player player = new Player("Vanek");

        assertThrows(RuntimeException.class, () -> {
            player.play(injustice, 5);
        });
    }

    @Test
    public void mostPlayerByGenreGamePlayed() {
        Player player = new Player("Ura");
        player.installGame(mortalKombat);
        player.installGame(injustice);
        player.installGame(rockNRollRacing);

        player.play(mortalKombat, 6);
        player.play(worldOfTanks, 5);
        player.play(rockNRollRacing, 3);


        Game expected = mortalKombat;
        Game actual = player.mostPlayerByGenre("Fights");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldSumGenreIfGameReplay() {

        Player player = new Player("Petya");
        player.installGame(mortalKombat);
        player.installGame(worldOfWarcraft);
        player.installGame(needForSpeed);

        player.play(mortalKombat, 3);
        player.play(mortalKombat, 3);


        int expected = 6;
        int actual = player.sumGenre("Fights");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGames() {

        Player player = new Player("Petya");
        player.installGame(mortalKombat);

        player.play(mortalKombat, 3);
        player.installGame(injustice);
        player.play(injustice, 5);
        player.installGame(rockNRollRacing);
        player.play(rockNRollRacing, 5);

        int expected = 8;
        int actual = player.sumGenre(mortalKombat.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldExpIfGameNotInstall() {

        Player player = new Player("Vanek");

        assertThrows(RuntimeException.class, () -> {
            player.play(injustice, 5);
        });
    }

    @Test
    public void mostPlayerByGenreGamePlayed() {
        Player player = new Player("Ura");
        player.installGame(mortalKombat);
        player.installGame(injustice);
        player.installGame(rockNRollRacing);

        player.play(mortalKombat, 6);
        player.play(injustice, 5);
        player.play(rockNRollRacing, 3);


        Game expected = mortalKombat;
        Game actual = player.mostPlayerByGenre("Fights");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldSumGenreIfGameReplay() {

        Player player = new Player("Petya");
        player.installGame(mortalKombat);
        player.installGame(worldOfWarcraft);
        player.installGame(needForSpeed);

        player.play(mortalKombat, 3);
        player.play(mortalKombat, 3);


        int expected = 6;
        int actual = player.sumGenre("Fights");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGames() {

        Player player = new Player("Petya");
        player.installGame(mortalKombat);
        player.installGame(injustice);
        player.installGame(needForSpeed);

        player.play(mortalKombat, 1);
        player.play(injustice, 2);
        player.play(needForSpeed, 4);

        int expected = 3;
        int actual = player.sumGenre("Fights");

        assertEquals(expected, actual);
    }


}


