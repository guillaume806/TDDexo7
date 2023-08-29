package org.example;

public class Frame {
    private int[] rolls = new int[2];
    private boolean isStrike = false;

    public int[] getRolls() {
        return rolls;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public void roll(int pins) {
        if (rolls[0] == 0) {
            rolls[0] = pins;
            if (pins == 10) {
                isStrike = true;
            }
        } else {
            rolls[1] = pins;
        }
    }


}

