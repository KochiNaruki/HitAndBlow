import jp.ac.uryukyu.ie.e235709.HitAndBlow;

/**
 * MainクラスはHitAndBlowゲームを開始する
 */
public class Main {
    /**
     * mainメソッド
     * ゲームを開始する
     * @param args 使用しない
     */
    public static void main(String[] args) {
        /**
         * HitAndBlowのコンストラクタ
         * 3桁の数字を作成
         */
        HitAndBlow game = new HitAndBlow();
        game.playGame();
    }
}
