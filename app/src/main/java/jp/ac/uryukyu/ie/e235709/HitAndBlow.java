package jp.ac.uryukyu.ie.e235709;

import java.util.Random;

public class HitAndBlow {
    private int[] secretNumber;

    public HitAndBlow() {
        generateSecretNumber();
    }

    // メソッド1: 3桁の秘密の数字を作成する
    public void generateSecretNumber() {
        Random random = new Random();
        secretNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            secretNumber[i] = random.nextInt(10);
        }
    }
}
