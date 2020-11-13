
/**
 * The referee class is responsible for starting the tic-tac-toe game and connecting the tow players to each other.
 * @author Ahmed Amer
 * @version 1.0
 * @since February 6, 2020
 *
 */
public class Referee {
	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	/**
	 * Constructs an object of type referee with null values for each of its members.
	 */
	public Referee() {
		this.oPlayer = null;
		this.xPlayer = null;
		this.board = null;
	}
	/**
	 * Connects the game's board to the referee object's board
	 * @param b The game board
	 */
	public void setBoard(Board b) {
		this.board = b;
	}
	/**
	 * Sets a player to the objects oPlayer
	 * @param oPlayer One of the players
	 */
	public void setOPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	/**
	 * Sets a player to the objects xPlayer
	 * @param xPlayer one of the players
	 */
	public void setXPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	/**
	 * Initializes the game by displaying the board and ensures the xPlayer begins first.
	 */
	public void runTheGame() {
		System.out.println("The referee has started the game");
		this.xPlayer.setOpponent(this.oPlayer);
		this.oPlayer.setOpponent(this.xPlayer);
		this.board.display();
		this.xPlayer.play();
	}
}
