package warriors.engine;

import warriors.contracts.Hero;
import warriors.contracts.WarriorsAPI;
import warriors.contracts.Map;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;

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
        Hero gamon = new Warrior("gamon", 9, 10);
        Hero garrosh = new Warrior("garrosh", 10, 9);
        Hero gandalf = new Wizard("gandalf", 5, 14);
        Hero merlin = new Wizard("merlin", 6, 12);

        heroesList.add(gamon);
        heroesList.add(garrosh);
        heroesList.add(gandalf);
        heroesList.add(merlin);

        this.mapsList = new ArrayList<>();
        warriors.engine.Map niortMap = new warriors.engine.Map("NiortMap", 64);
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
    public GameState nextTurn(String gameID){
        diceResult = diceRoll();
        Hero hero = gameState.getHero();
        warriors.engine.Map map = (warriors.engine.Map)gameState.getMap();
        String message = "";

        gameState.setCurrentSquare(gameState.getCurrentSquare()+ diceResult);
        if(gameState.getCurrentSquare()>= 64){
            message = "Victoire ! Vous avez finit le donjon !";
            gameState.setGameStatus(GameStatus.FINISHED);
        } else {
            message = "Vous avez fait un" + diceResult + "vous avez arrivez sur la case" + gameState.getCurrentSquare() + " .";

        }
        gameState.setLastLog(message);
        return gameState;
    }

    private int diceRoll(){
        Random rand = new Random();
            return rand.nextInt(6)+1;

    }
}