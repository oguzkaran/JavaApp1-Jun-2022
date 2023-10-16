package org.csystem.app.game.combat;

import org.csystem.app.game.combat.color.Color;
import org.csystem.app.game.combat.enemy.Enemy;
import org.csystem.util.string.StringUtil;
import org.csystem.util.thread.ThreadUtil;

import java.util.ArrayList;
import java.util.Random;

public class StoreEnemiesToArrayDemoApp {
    private static void run()
    {
        Random r = new Random();
        Color [] colors = Color.values();
        ArrayList enemies = new ArrayList<>();

        for (;;) {
            Enemy enemy = new Enemy();

            enemy.setName(StringUtil.getRandomTextEN(r, r.nextInt(5, 11)))
                    .setColor(colors[r.nextInt(colors.length)]);

            enemies.add(enemy);

            ThreadUtil.sleep(1000);

            System.out.println("---------------------------------------------");
            System.out.printf("Size:%d%n", enemies.size());
            for (Object obj : enemies) {
                enemy = (Enemy)obj;
                System.out.println(enemy.toString());
            }
            System.out.println("---------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
