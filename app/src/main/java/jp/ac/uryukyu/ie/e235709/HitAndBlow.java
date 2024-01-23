package jp.ac.uryukyu.ie.e235709;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * HitAndBlowを制御するクラス
 */
public class HitAndBlow {
    /**
     * 秘密の数字
     */
    private int[] secretNumber;

    /**
     * HitAndBlowのコンストラクタ
     * 3桁の数字を作成
     */
    public HitAndBlow() {
        generateSecretNumber();
    }

    /**
     * 3桁の数字をランダムに作成するメソッド
     */
    public void generateSecretNumber() {
        Random random = new Random();
        secretNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            secretNumber[i] = random.nextInt(10);
        }
    }

    /**
     * hitの数をカウントするメソッド
     * 
     * @param guess 予想した数字
     * @return hitの数
     */
    public int countHits(int[] guess) {
        int hits = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == secretNumber[i]) {
                hits++;
            }
        }
        return hits;
    }

    /**
     * blowの数をカウントするメソッド
     * 
     * @param guess 予想した数字
     * @return blowの数
     */
    public int countBlows(int[] guess) {
        int blows = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && guess[i] == secretNumber[j]) {
                    blows++;
                }
            }
        }
        return blows;
    }

    /**
     * ユーザーに3桁の数字を入力させるメソッド
     * 
     * @return 3桁の数字を3つの要素のリストとして返す
     */
    public int[] takeUserGuess() {
        Scanner scanner = new Scanner(System.in);
        int[] guess = new int[3];

        System.out.print("3桁の数字を入力してください: ");
        String input = scanner.next();

        for (int i = 0; i < 3; i++) {
            guess[i] = Character.getNumericValue(input.charAt(i));
        }

        return guess;
    }

    /**
     * ゲームを開始するメソッド
     * 予想が当たるまでループ処理が行われる
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hit and Blowゲームを始めます！");

        int[] guess;
        int attemptCount = 0;

        do {
            attemptCount++;
            guess = takeUserGuess();

            if (Arrays.equals(guess, secretNumber)) {
                System.out.println("おめでとうございます！正解です！");
                System.out.println("試行回数: " + attemptCount);
                break;
            } else {
                int hits = countHits(guess);
                int blows = countBlows(guess);
                System.out.println("Hits: " + hits + ", Blows: " + blows);
            }

        } while (true);
    }

    /**
     * テストで秘密の数字を使うためのgetter
     * 
     * @return 秘密の数字
     */
    int[] getSecretNumber() {
        return secretNumber;
    }
}
