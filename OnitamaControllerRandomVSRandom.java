package main;

/**
 * A class responsible for facilitating a game of Onitama for two
 * Random Players.
 *
 */

public class OnitamaControllerRandomVSRandom {

    private PlayerRandom player1;
    private PlayerRandom player2;
    protected Onitama onitama;

    /**
     * Constructs an OnitamaControllerRandomVSRandom
     * with two Random players and the game Onitama.
     *
     */

    public OnitamaControllerRandomVSRandom() {

        this.player1 = new PlayerRandom(OnitamaBoard.G1);
        this.player2 = new PlayerRandom(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
        this.player1.setGame(this.onitama);
        this.player2.setGame(this.onitama);

    }

    public void play() {
        while (onitama.getWinner() == OnitamaBoard.EMPTY) {
            this.report();

            Turn turn = null;
            Player whosTurn = onitama.getWhoseTurn();
            turn = whosTurn.getTurn();

            this.reportTurn(whosTurn.getPlayer(), turn);
            onitama.move(turn.getRowO(), turn.getColO(), turn.getRowD(),
                    turn.getColD(), turn.getStyle());
        }
        this.reportFinal();
    }

    /**
     * Reports a turn for a given player given their char.
     *
     * @param whosTurn the character associated with a player.
     * @param turn A Turn that a player is ready to make
     *
     */

    private void reportTurn(char whosTurn, Turn turn) {
        System.out.println(whosTurn + " makes move " + turn + "\n");
    }

    /**
     * Reports the current state of Onitama and whose turn it is.
     */

    private void report() {

        String s = onitama.getBoardString() + onitama.getStylesString(OnitamaBoard.G1) +
                onitama.getStylesString(OnitamaBoard.G2) +
                onitama.getStylesString(OnitamaBoard.EMPTY)
                + "  " + onitama.getWhoseTurn().getPlayer() + " moves next";
        System.out.println(s);
    }

    /**
     * Reports the winner of Onitama once the game has finished.
     *
     */

    private void reportFinal() {

        String s = onitama.getBoardString() + "  "
                + onitama.getWinner() + " won\n";
        System.out.println(s);
    }



    /**
     * plays a game of Onitama with two Random Players.
     *
     *
     */

    public static void main(String[] args) {

        OnitamaControllerRandomVSRandom ocr = new OnitamaControllerRandomVSRandom();
        ocr.play();
    }


}
