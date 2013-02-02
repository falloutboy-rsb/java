package org.itaio.utilities;

import org.itaio.iTAIO;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.Time;

import java.awt.*;
import java.util.ArrayList;

public class Paint {

    public static void repaint(final Graphics gg) {
        final Graphics2D g = (Graphics2D) gg;
        drawStrings(g);
    }

    private static void drawStrings(Graphics2D g) {
        int y = 65;
        final int x = 5;
        final ArrayList<String> strings = new ArrayList<String>();

        final SkillData temp = iTAIO.sd;
        strings.add("iTAIO v" + getVersion() + " - by _phl0w");
        strings.add("Levels gained: " + temp.level(iTAIO.task.getSkill()));
        strings.add("Experience gained: " + temp.experience(iTAIO.task.getSkill()));
        strings.add("Experience/hour: " + temp.experience(SkillData.Rate.HOUR, iTAIO.task.getSkill()));
        strings.add("TTL: " + Time.format(temp.timeToLevel(SkillData.Rate.HOUR, iTAIO.task.getSkill())));
        strings.add("Runtime: " + Time.format((System.currentTimeMillis() - iTAIO.startTime)));

        for (final String s : strings) {
            y += g.getFontMetrics().getHeight();
            g.setColor(Color.black);
            g.drawString(s, x + 1, y + 1);
            g.setColor(Color.WHITE);
            g.drawString(s, x, y);
        }
    }

    private static double getVersion() {
        return iTAIO.class.getAnnotation(Manifest.class).version();
    }
}