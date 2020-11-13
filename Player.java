/**
 * The Player class holds the information of a player in the game.
 * The class also connects the player to the board and to his/her opponent.
 * @author Ahmed Amer
 * @version 1.1
 * @since February 20, 2020
 *
 */
public abstract class Player  {
	protected String name;
	protected Board board;
	protected Player opponent;
	protected char mark;
	/**
	 * Constructs a new object of type Player with the given name and assigned mark.
	 * @param name The name of the player.
	 * @param mark The mark that the player uses.
	 */
	public Player(String name,char mark) {
		this.name = name;
		this.mark = mark;
		this.board = null;
		this.opponent = null;
	}
	/**
	 * The play method runs the game until a player wins or until the board is full.
	 * It also ensures that the turn is passed from player to player in between turns
	 */
	protected abstract void play();
	/**
	 * Method used by the play method to get the mark input location for the specified player.
	 */
	protected abstract void makeMove(); 
	/**
	 * Sets the opponent of the Player object.
	 * @param p The opponent player
	 */
	protected void setOpponent(Player p) {
		this.opponent = p;
	}
	/**
	 * Connects the board to the Player object.
	 * @param b The board where the game is played.
	 */
	protected void setBoard(Board b) {
		this.board = b;
	}
}
