package warriors.engine;

import warriors.contracts.*;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warriors implements WarriorsAPI {
    private List<Hero> heroesList;
    private List<Map> mapsList;
    warriors.engine.GameState gameState;
    int diceResult;

    public Warriors() {
        this.heroesList = new ArrayList<>();
        Hero hero1 = new Warrior("Johan", 8, 7);
        Hero hero2 = new Warrior("Alexis", 9, 6);
        Hero hero3 = new Wizard("Merlin", 5, 10);
        Hero hero4 = new Wizard("Steven", 6, 15);
        heroesList.add(hero1);
        heroesList.add(hero2);
        heroesList.add(hero3);
        heroesList.add(hero4);

        this.mapsList = new ArrayList<>();
        warriors.engine.Map niortMap = new warriors.engine.Map("NiortMap", 64);

        Enemy goblin = new Enemy(6,1);
        Square goblinSquare = new Square(goblin);
        Enemy sorcerer = new Enemy(9,2);
        Square sorcererSquare = new Square(sorcerer);
        Enemy dragon = new Enemy(9,2);
        Square dragonSquare = new Square(dragon);

        niortMap.addToMap(goblinSquare,3);
        niortMap.addToMap(goblinSquare,6);
        niortMap.addToMap(goblinSquare,9);
        niortMap.addToMap(goblinSquare,12);
        niortMap.addToMap(goblinSquare,15);
        niortMap.addToMap(goblinSquare,18);
        niortMap.addToMap(goblinSquare,21);
        niortMap.addToMap(goblinSquare,24);
        niortMap.addToMap(goblinSquare,27);
        niortMap.addToMap(goblinSquare,30);
        niortMap.addToMap(sorcererSquare,10);
        niortMap.addToMap(sorcererSquare,20);
        niortMap.addToMap(sorcererSquare,25);
        niortMap.addToMap(sorcererSquare,32);
        niortMap.addToMap(sorcererSquare,35);
        niortMap.addToMap(sorcererSquare,36);
        niortMap.addToMap(sorcererSquare,37);
        niortMap.addToMap(sorcererSquare,40);
        niortMap.addToMap(sorcererSquare,44);
        niortMap.addToMap(sorcererSquare,47);
        niortMap.addToMap(dragonSquare,45);
        niortMap.addToMap(dragonSquare,52);
        niortMap.addToMap(dragonSquare,56);
        niortMap.addToMap(dragonSquare,62);

        mapsList.add(niortMap);
    }


    @Override
    public List<Hero> getHeroes() {
        return heroesList;
    }

    @Override
    public List<Map> getMaps() {
        return mapsList;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        gameState = new warriors.engine.GameState(playerName, hero, map);
        return gameState;
    }

    @Override
    public GameState nextTurn(String gameID) {

        //générer un résultat de dé entre 1 et 6       pas de system out, stocker dans lastlog
        diceResult = diceRoll();

        //déplacer le perso et afficher la case actuelle
        gameState.setCurrentSquare(gameState.getCurrentSquare() + diceResult);

        if (gameState.getCurrentSquare() >= 64) {
            gameState.setCurrentSquare(64);
            gameState.setLastLog("Vous avez fait un " + diceResult + " et vous etes sur la case " + gameState.getCurrentSquare() + ", vous etes arrives");
            gameState.setGameStatus(GameStatus.FINISHED);
        } else {
            gameState.setLastLog("Vous avez fait un " + diceResult + " et vous etes sur la case " + gameState.getCurrentSquare());
        }
        return gameState;
    }

    private int diceRoll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}