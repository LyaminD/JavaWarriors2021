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
        Hero gamon = new Warrior("gamon", 9, 6);
        Hero garrosh = new Warrior("garrosh", 10, 5);
        Hero gandalf = new Wizard("gandalf", 5, 12);
        Hero merlin = new Wizard("merlin", 6, 11);

        heroesList.add(gamon);
        heroesList.add(garrosh);
        heroesList.add(gandalf);
        heroesList.add(merlin);

        this.mapsList = new ArrayList<>();
        warriors.engine.Map niortMap = new warriors.engine.Map("NiortMap", 64);
        mapsList.add(niortMap);

        Event vide = new Event();
        Square emptySquare = new Square(vide);
        Weapon arc = new Weapon("arc", 1);
        Square caseArc = new Square(arc);
        Weapon massue = new Weapon("massue", 3);
        Square caseMassue = new Square(massue);
        Weapon epee = new Weapon("epee", 5);
        Square caseEpee = new Square(epee);
        Spell eclair = new Spell("eclair", 2);
        Square caseEclair = new Square(eclair);
        Spell bouleDeFeu = new Spell("boule de feu", 7);
        Square caseBouleDeFeu = new Square(bouleDeFeu);
        Potion potionMineure = new Potion("potion mineure", 1);
        Square casePotionMineure = new Square(potionMineure);
        Potion potionStandard = new Potion("potion standard", 2);
        Square casePotionStandard = new Square(potionStandard);
        Potion grandePotion = new Potion("grande potion", 5);
        Square caseGrandePotion = new Square(grandePotion);

        niortMap.addToMap(emptySquare, 0);
        niortMap.addToMap(caseEclair, 1);
        niortMap.addToMap(caseArc, 2);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 3);
        niortMap.addToMap(caseEclair, 4);
        niortMap.addToMap(caseMassue, 5);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 6);
        niortMap.addToMap(casePotionMineure, 7);
        niortMap.addToMap(caseEclair, 8);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 9);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 10);
        niortMap.addToMap(caseArc, 11);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 12);
        niortMap.addToMap(casePotionMineure, 13);
        niortMap.addToMap(caseArc, 14);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 15);
        niortMap.addToMap(emptySquare, 16);
        niortMap.addToMap(caseEclair, 17);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 18);
        niortMap.addToMap(caseArc, 19);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 20);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 21);
        niortMap.addToMap(caseMassue, 22);
        niortMap.addToMap(caseEclair, 23);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 24);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 25);
        niortMap.addToMap(caseArc, 26);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 27);
        niortMap.addToMap(casePotionMineure, 28);
        niortMap.addToMap(casePotionMineure, 29);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 3)), 30);
        niortMap.addToMap(casePotionStandard, 31);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 32);
        niortMap.addToMap(casePotionMineure, 33);
        niortMap.addToMap(emptySquare, 34);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 35);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 36);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 37);
        niortMap.addToMap(caseMassue, 38);
        niortMap.addToMap(casePotionStandard, 39);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 40);
        niortMap.addToMap(caseGrandePotion, 41);
        niortMap.addToMap(caseEpee, 42);
        niortMap.addToMap(casePotionStandard, 43);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 44);
        niortMap.addToMap(new Square(new Enemy("dragon", 8, 15)), 45);
        niortMap.addToMap(emptySquare, 46);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 47);
        niortMap.addToMap(caseBouleDeFeu, 48);
        niortMap.addToMap(caseBouleDeFeu, 49);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 50);
        niortMap.addToMap(caseGrandePotion, 51);
        niortMap.addToMap(new Square(new Enemy("dragon", 8, 15)), 52);
        niortMap.addToMap(caseEpee, 53);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 54);
        niortMap.addToMap(new Square(new Enemy("sorcier", 6, 5)), 55);
        niortMap.addToMap(new Square(new Enemy("dragon", 8, 15)), 56);
        niortMap.addToMap(emptySquare, 57);
        niortMap.addToMap(casePotionStandard, 58);
        niortMap.addToMap(caseBouleDeFeu, 59);
        niortMap.addToMap(caseGrandePotion, 60);
        niortMap.addToMap(casePotionStandard, 61);
        niortMap.addToMap(new Square(new Enemy("dragon", 8, 15)), 62);
        niortMap.addToMap(emptySquare, 63);
        niortMap.addToMap(new Square(new Enemy("dragon", 8, 15)), 64);
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
        diceResult = diceRoll();
        Hero hero = gameState.getHero();
        warriors.engine.Map map = (warriors.engine.Map) gameState.getMap();
        String message = "";

        gameState.setCurrentSquare(gameState.getCurrentSquare() + diceResult);
        if (gameState.getCurrentSquare() >= 64) {
            message = "Victoire ! Vous avez finit le donjon !";
            gameState.setGameStatus(GameStatus.FINISHED);
        } else {
            message = "Vous avez fait un " + diceResult + " vous avez arrivez sur la case " + gameState.getCurrentSquare() + " .";
            message += "\n Point de vie : " + ((LocalHero) hero).getLife() + " | Niveau d'attaque " + ((LocalHero) hero).getAttackLevel() + " | Case :" + gameState.getCurrentSquare();

            String type = map.getSquareContent(gameState.getCurrentSquare()).getEvent().getType();
            message += "\n c'est une case de type " + type;
            switch (type) {

                case ("Enemy"):
                    Event enemyEvent = map.getSquareContent(gameState.getCurrentSquare()).getEvent();
                    Enemy enemy = (Enemy) enemyEvent;
                    message += "\n" + enemy.toString();
                    message += "\n Un combat a mort vient de s'engager ! Il en restera qu'un !";
                    message += "\n Vous attaquez en premier !";

                    while (((LocalHero) hero).getLife() > 0 && enemy.getLifeLevel() > 0) {

                        message += "\n Vous attaquez la cible !";

                        enemy.setLifeLevel(enemy.getLifeLevel() - ((LocalHero) hero).getAttackLevel());
                        message += "\n Il reste" + enemy.getLifeLevel() + " points de vie a la cible !";

                        if (enemy.getLifeLevel() > 0) {

                            message += "\n L'enemi contre-attaque !";
                            ((LocalHero) hero).setLifeLevel(((LocalHero) hero).getLife() - enemy.getAttackLevel());
                            message += "\n Il vous reste" + ((LocalHero) hero).getLife() + " points de vie !";

                            if (((LocalHero) hero).getLife() <= 0) {
                                message += "\n Vous etes mort ! GAME OVER";
                                gameState.setGameStatus(GameStatus.GAME_OVER);
                            }

                        } else {
                            message += "\n Ennemi vaincu ! Bravo !";
                        }
                    }
                    break;

                case ("Weapon"):

                    Event weaponEvent = map.getSquareContent(gameState.getCurrentSquare()).getEvent();
                    Weapon weapon = (Weapon) weaponEvent;
                    message += "\n" + weapon.toString();

                    if (hero instanceof Warrior) {

                        if (((LocalHero) hero).getWeapon() != null) {

                            if (((LocalHero) hero).getWeapon().getAttackLevel() >= weapon.getAttackLevel()) {
                                message += "\n L'arme trouvee est moins efficace que la votre, vous la laissez donc au sol !";
                            } else {
                                ((LocalHero) hero).setWeapon(weapon);
                                message += "\n Arme equipe !";
                                message += "\n Votre puissance d'attaque est de " + ((LocalHero) hero).getAttackLevel();
                            }

                        } else {
                            ((LocalHero) hero).setWeapon(weapon);
                            ((LocalHero) hero).setAttackLevel(((LocalHero) hero).getAttackLevel() + weapon.getAttackLevel());
                            message += "\n Arme equipe !";
                            message += "\n Votre nouveau niveau d'attaque est de " + ((LocalHero) hero).getAttackLevel();
                        }

                    } else {
                        message += "\n Vous ne pouvez pas utiliser d'armes !";
                    }
                    break;

                case ("Spell"):

                    Event spellEvent = map.getSquareContent(gameState.getCurrentSquare()).getEvent();
                    Spell spell = (Spell) spellEvent;
                    message += "\n" + spell.toString();

                    if (hero instanceof Wizard) {

                        if (((LocalHero) hero).getSpell() != null) {

                            if (((LocalHero) hero).getSpell().getAttackLevel() >= spell.getAttackLevel()) {
                                message += "\n Le pouvoir trouve est moins éfficace que le votre, vous le laissez donc au sol !";
                            } else {
                                ((LocalHero) hero).setSpell(spell);
                                ((LocalHero) hero).setAttackLevel(((LocalHero) hero).getAttackLevel() + spell.getAttackLevel());
                                message += "\n Pouvoir equipe !";
                                message += "\n Votre nouveau niveau d'attaque est de " + ((LocalHero) hero).getAttackLevel();
                            }

                        } else {
                            ((LocalHero) hero).setSpell(spell);
                            message += "\n Pouvoir equipe !";
                            message += "\n Votre nouveau niveau d'attaque est de " + ((LocalHero) hero).getAttackLevel();
                        }

                    } else {
                        message += "\n Vous ne pouvez pas utiliser de pouvoirs !";
                    }
                    break;

                case ("Potion"):
                    Event potionEvent = map.getSquareContent(gameState.getCurrentSquare()).getEvent();
                    Potion potion = (Potion) potionEvent;
                    message += "\n" + potion.toString();

                    if (((LocalHero) hero).getMaxLife() != ((LocalHero) hero).getLife()) {
                        ((LocalHero) hero).setLifeLevel(((LocalHero) hero).getLife() + potion.getLifeLevel());
                        message += "\n Vous venez de regagnez " + potion.getLifeLevel() + " points de vie !";
                    } else {
                        message += "\n Votre vie est au maximum, vous laissez la potion au sol.";
                    }
                    break;

                default:
                    break;
            }
        }
        gameState.setLastLog(message);
        return gameState;
    }

    private int diceRoll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}