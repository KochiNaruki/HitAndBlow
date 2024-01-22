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
    //メソッド2: ヒットの数を数える
    public int countHits(int [] guess){
        int hits = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == secretNumber[i]) {
                hits++;
            }
        }
        return hits;
    }
    //メソッド3: blowの数を数える
    public int countBlows(int [] guess){
        int blows = 0;
        for (int i = 0; i <3; i++){
            for (int j = 0; j < 3; j++) {
                if (i != j && guess[i] == secretNumber[j]) {
                    blows++;
                }
            }
        }
        return blows;
        }
    
}
