import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}
	
	@Override
	protected void play() {
		int count =0;
		while(!this.board.isFull() && !this.board.oWins() && !this.board.xWins()) {
			if(count%2 == 0) {
				this.makeMove();
				this.board.display();
			}
			else {
				this.opponent.makeMove();
				this.opponent.board.display();
			}
			count++;
		}
		if(this.board.xWins()) {
			System.out.println("THE GAME IS OVER: "+this.name+" is the winner!\n"
					+ "Game Ended...");
		}
		else if(this.board.oWins()) {
			System.out.println("THE GAME IS OVER: "+this.opponent.name+" is the winner!\n"
					+ "Game Ended...");
		}
		else {
			System.out.println("THE GAME IS OVER: It was a tie\n"
					+ "Game Ended...");
		}
		
	}
	
	@Override
	protected void makeMove() {
		int row, cols;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(this.name+", what row should your next "+this.mark+" be placed in?");
			row = Integer.parseInt(sc.nextLine());
			System.out.println(this.name+", what column should your next "+this.mark+" be placed in?");
			cols = Integer.parseInt(sc.nextLine());
			if(this.board.checkForMark(row, cols) == false) {
				this.board.addMark(row, cols, this.mark);
				break;
			}
			else {
				System.out.println("\nPlease pick a square that is empty\n");
				this.board.display();
			}
		}
	}
	
}
