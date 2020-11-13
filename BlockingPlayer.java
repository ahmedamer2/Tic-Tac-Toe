
public class BlockingPlayer extends RandomPlayer {
	
	
	public BlockingPlayer(String name, char mark, RandomGenerator r) {
		super(name, mark, r);
		
	}
	
	@Override
	protected void makeMove() {
		boolean checkForBlock = false;
		for(int i = 0; i<3 ; i++) {
			for(int j = 0 ; j<3 ; j++) {
				if(this.board.checkForMark(i, j) == false)
					checkForBlock = testForBlocking(i, j);
				if(checkForBlock == true) {
					this.board.addMark(i, j, mark);
					return;
				}
					
			}
		}
		int row, col;
		while(true) {
			row = random.discrete(0, 2);
			col = random.discrete(0, 2);
			if(this.board.checkForMark(row, col) == false) {
				this.board.addMark(row, col, mark);
				break;
			}
			
		}
		
	}
	protected boolean testForBlocking(int row, int col) {
		this.board.addMark(row, col, opponent.mark);
		if(this.board.checkWinner(opponent.mark) == 1) {
			this.board.removeMark(row, col);
			return true;
		}
			
		else {
			this.board.removeMark(row, col);
			return false;
		}
	}

}
