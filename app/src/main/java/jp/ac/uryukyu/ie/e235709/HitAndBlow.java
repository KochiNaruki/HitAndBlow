package jp.ac.uryukyu.ie.e235709;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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

    // メソッド2: ヒットの数を数える
    public int countHits(int[] guess) {
        int hits = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == secretNumber[i]) {
                hits++;
            }
        }
        return hits;
    }

    // メソッド3: blowの数を数える
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

    // メソッド4:3桁の数字を入力
    public int[] takeUserGuess() {
        Scanner scanner = new Scanner(System.in);// 入力処理を行う
        int[] guess = new int[3];

        System.out.print("3桁の数字を入力してください: ");
        String input = scanner.next();// ユーザーの入力を文字列として取得

        for (int i = 0; i < 3; i++) {
            guess[i] = Character.getNumericValue(input.charAt(i));// i番目の文字を取得し、数字に変換
        }

        return guess;
    }

    // メソッド5:ゲームの制御
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hit and Blowゲームを始めます！");

        int[] guess;
        int attemptCount = 0;

        do {
            // ゲームのループ処理
            attemptCount++;// 試行回数のカウント
            guess = takeUserGuess();

            if (Arrays.equals(guess, secretNumber)) {
                // 正解した場合の処理
                System.out.println("おめでとうございます！正解です！");
                System.out.println("試行回数: " + attemptCount);// 試行回数を表示しループを終了
                break;
            } else {
                // 不正解した場合の処理
                int hits = countHits(guess);// ヒットの数をカウント
                int blows = countBlows(guess);// blowの数をカウント
                System.out.println("Hits: " + hits + ", Blows: " + blows);// hitとblowの数を表示
            }

        } while (true);
    }
}
