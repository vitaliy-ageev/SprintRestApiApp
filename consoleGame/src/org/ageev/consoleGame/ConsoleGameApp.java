package org.ageev.consoleGame;

import java.util.Scanner;

public class ConsoleGameApp {
    // Создаем сканнер для получения данных от пользователя
    private static Scanner sc = new Scanner(System.in);
    // Создаем персонажей
    private static GameCharacter hero = new GameCharacter("Sir John", 10, 2);
    private static GameCharacter monster = new GameCharacter("Goblin", 6, 2);
    
    static class GameCharacter {
        String name;
        int hp;
        int maxHP;
        int attackPower;
        boolean block;
        
        public GameCharacter(String name, int maxHP, int attackPower) {
            this.name = name;
            this.maxHP = maxHP;
            this.hp = maxHP;
            this.attackPower = attackPower;
            this.block = false;
        }
        
        public void attack(GameCharacter target) {
            int damage = this.attackPower;
            if (target.block) {
                if (Math.random() < 0.8) {
                    System.out.println(target.name +  " blocked the attack.");
                    System.out.println(target.name + " has " + target.hp + "/" + target.maxHP + " HP left.");
                    return;
                } else {
                    damage *= 2;
                }
            }
            
            target.hp -= damage;
            System.out.println(this.name + " dealt " + damage + " damage to the character " + target.name + ".");
            System.out.println(target.name + " has " + target.hp + "/" + target.maxHP + " HP left.");
        }
        
        public void block() {
            hp++;
            if (hp > maxHP) {
                hp = maxHP;
            }
            
            block = true;
            System.out.println(this.name + " tries to block the next attack. Gains +1 HP.");
        }
        
        public void reset() {
            block = false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(hero.name + " begins his journey.");
        System.out.println(hero.name + " gets ambushed. " + monster.name + " attacks him from the forest.");
        
        System.out.println("The battle has begun.");
        battlePhase();
        System.out.println("\nGame over.");
    }
    
    public static void battlePhase() {
        while (true) {
            System.out.println("\nHero turn: " + hero.name + ".");
            System.out.println(hero.name + ", what are your actions?");
            hero.reset();
        
            // Получаем данные от пользователя
            String input = sc.next();
        
            if (input.equals("/hit")) {
                hero.attack(monster);
            
                if (monster.hp <= 0) {
                    System.out.println(hero.name + " defeated " + monster.name + ".");
                    break;
                }
            } else if (input.equals("/block")) {
                hero.block();
            } else {
                System.out.println("No such command exists.");
                continue;
            }
        
            System.out.println("\nHero turn: " + monster.name + ".");
            monster.reset();
            if (Math.random() > 0.5) {
                monster.attack(hero);
            
                if (hero.hp <= 0) {
                    System.out.println(monster.name + " defeated " + hero.name + ".");
                    break;
                }
            } else {
                monster.block();
            }
        }
    }
}
