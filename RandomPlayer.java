
public class RandomPlayer extends Player {
	protected RandomGenerator random;
	
	public RandomPlayer(String name, char mark, RandomGenerator r) {
		super(name, mark);
		this.random = r;
		
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
		int i, j;
		while(true) {
			i = random.discrete(0, 2);
			j = random.discrete(0, 2);
			if(this.board.checkForMark(i, j) == false) {
				this.board.addMark(i, j, mark);
				break;
			}
			
		}
		
	
	}

}
