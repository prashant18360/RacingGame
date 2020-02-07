package ap_assign5;

import java.util.*;
import java.io.*;
import java.lang.*;

class DangerTile {
	private Randomgenerate robj = new Randomgenerate();
	private final int move_T = this.getRobj().randomnumber();
	private int tilecounter;
	
	public int getTilecounter() {
		return tilecounter;
	}
	public void setTilecounter(int tilecounter) {
		this.tilecounter = tilecounter;
	}
	public Randomgenerate getRobj() {
		return robj;
	}
	public int getMove_T() {
		return move_T;
	}
	

	public DangerTile() {
		this.setTilecounter(0);
	}
	
	public int movestep(int pos) {
		int tpos = pos - this.getMove_T();
		if(tpos <= 0)
			tpos = 1;
		return tpos;
	}
}

class Snake extends DangerTile {
	
	private final int move_s = super.getMove_T();
	
	public Snake() {
		
	}
	
	public int getmove_s() {
		return move_s;
	}
}

class Vulture extends DangerTile {
	
	private final int move_v = super.getMove_T();
	
	public int getmove_v() {
		return move_v;
	}
}

class Cricket extends DangerTile {
	
	private final int move_c = super.getMove_T();
	
	public int getmove_c() {
		return move_c;
	}
	
}

class Trampoline {
	
	private Randomgenerate robjt = new Randomgenerate();
	private final int move_t =this.getRobjt().randomnumber();
	private int tilecounter;
	
	public int getTilecounter() {
		return tilecounter;
	}
	public void setTilecounter(int tilecounter) {
		this.tilecounter = tilecounter;
	}
	public Randomgenerate getRobjt() {
		return robjt;
	}
	public int getmove_t() {
		return move_t;
	}
	
	public Trampoline() {
		this.setTilecounter(0);
	}
	
	public int moveahead(int pos,int n) {
		int temp=pos;
		if(pos + this.getmove_t() <= n) {
			temp =  pos + this.getmove_t();
		}
		return temp;
	}
}

class Randomgenerate {
	public Randomgenerate() {}
	public int randomnumber() {
		Random rd = new Random();
		return rd.nextInt(10) + 1;
	}
}



class Dice {
	public Dice() {}
	public int diceroll() {
		Random ran = new Random();
		return ran.nextInt(6) + 1;
	}
}


class GamewinnerException extends Exception {
	public GamewinnerException(String message) {
		super(message);
	}
}

class SnakebiteException extends Exception {
	public SnakebiteException(String message) {
		super(message);
	}
}

class CricketbiteException extends Exception {
	public CricketbiteException(String message) {
		super(message);
	}
}

class VulturebiteException extends Exception {
	public VulturebiteException(String message) {
		super(message);
	}
}

class TrampolineException extends Exception {
	public TrampolineException(String message) {
		super(message);
	}
}


public class TileGame {
	
	class User {
		private final String name;
		public String getName() {
			return name;
		}
		public User(String str) {
			name = str;
		}
		
	}

	
	private DangerTile sn = new Snake();
	private DangerTile vl = new Vulture();
	private DangerTile ck = new Cricket();
	private Trampoline tp = new Trampoline();
	
	private Hashtable<Integer, Integer> tilemap = new Hashtable<Integer, Integer>();
	private int position;
	
	private int count_snak;
	private int count_vul;
	private int count_crick;
	private int count_tramp;
	
	private Randomgenerate rob = new Randomgenerate();
	private Dice d = new Dice();
	private int rollcount;
	
	/*private int snake_bite;
	private int vulture_bite;
	private int cricket_bite;
	private int tramp_move;*/

	
	public DangerTile getSn() {
		return sn;
	}
	public void setSn(DangerTile sn) {
		this.sn = sn;
	}
	public DangerTile getVl() {
		return vl;
	}
	public void setVl(DangerTile vl) {
		this.vl = vl;
	}
	public DangerTile getCk() {
		return ck;
	}
	public void setCk(DangerTile ck) {
		this.ck = ck;
	}
	public Trampoline getTp() {
		return tp;
	}
	public void setTp(Trampoline tp) {
		this.tp = tp;
	}

	
	public Hashtable<Integer, Integer> getTilemap() {
		return tilemap;
	}
	public void setTilemap(Hashtable<Integer, Integer> tilemap) {
		this.tilemap = tilemap;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getCount_snak() {
		return count_snak;
	}
	public void setCount_snak(int count_snak) {
		this.count_snak = count_snak;
	}
	public int getCount_vul() {
		return count_vul;
	}
	public void setCount_vul(int count_vul) {
		this.count_vul = count_vul;
	}
	public int getCount_crick() {
		return count_crick;
	}
	public void setCount_crick(int count_crick) {
		this.count_crick = count_crick;
	}
	public int getCount_tramp() {
		return count_tramp;
	}
	public void setCount_tramp(int count_tramp) {
		this.count_tramp = count_tramp;
	}
	
	public Randomgenerate getRob() {
		return rob;
	}
	public Dice getD() {
		return d;
	}
	
	public int getRollcount() {
		return rollcount;
	}
	public void setRollcount(int rollcount) {
		this.rollcount = rollcount;
	}
	
	public TileGame() {
		this.setPosition(1);
		this.setRollcount(1);
	}
	
	public void Gamewinnermessage() throws GamewinnerException {
		
		throw new GamewinnerException(" win the race in " + this.getRollcount() + " rolls  \n Total snake bite = " + this.getSn().getTilecounter()  + "\n Total Vulture bite = " + this.getVl().getTilecounter() + "\n Total Cricket bite = " + this.getCk().getTilecounter() + "\n Total Trampoline = " + this.getTp().getTilecounter());
	}
	
	public void checkmessagesnk()  throws SnakebiteException {
		throw new SnakebiteException("Hiss...! I am a Snake, ");
	}
	
	public void checkmessagevul() throws VulturebiteException {
		throw new VulturebiteException("Yapping...! I am Vulture, ");
	}
	
	public void checkmessagecric() throws CricketbiteException {
		throw new CricketbiteException("Chirp...! I am a Cricket, ");
	}
	
	public void checkmessagetramp() throws TrampolineException {
		throw new TrampolineException("Ping Pong ! I am Trampoline, ");
	}
	
	
	public void Shaking(User u, int n) {
			System.out.println("Trying to shake the Tile-" + this.getPosition());
			Hashtable<Integer, Integer> trackmap = this.getTilemap();
			if(trackmap.get(this.getPosition()) == 1) {
				DangerTile s = this.getSn();
				s.setTilecounter(s.getTilecounter() + 1);
				this.setSn(s);
				try {
					this.checkmessagesnk();
				}
				catch(SnakebiteException e) {
					System.out.print(e.getMessage());
				}
				System.out.println("you go back " + sn.getMove_T() + " tiles!");
				this.setPosition(sn.movestep(this.getPosition()));
				System.out.println(u.getName() + " moved to Tile " + this.getPosition());
			}
			else if(trackmap.get(this.getPosition()) == 2) {
				DangerTile vul = this.getVl();
				vul.setTilecounter(vul.getTilecounter() + 1);
				this.setVl(vul);
				try {
					this.checkmessagevul();
				}
				catch(VulturebiteException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("you go back " + vl.getMove_T() + " tiles!");
				this.setPosition(vl.movestep(this.getPosition()));
				System.out.println(u.getName() + " moved to Tile " + this.getPosition());
			}
			else if(trackmap.get(this.getPosition()) == 3) {
				DangerTile cric = this.getCk();
				cric.setTilecounter(cric.getTilecounter() + 1);
				this.setCk(cric);
				try {
					this.checkmessagecric();
				}
				catch(CricketbiteException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("you go back " + ck.getMove_T() + " tiles!");
				this.setPosition(ck.movestep(this.getPosition()));
				System.out.println(u.getName() + " moved to Tile " + this.getPosition());
			}
			else if(trackmap.get(this.getPosition()) == 4) {
				Trampoline tram = this.getTp();
				tram.setTilecounter(tram.getTilecounter() + 1);
				this.setTp(tram);
				try {
					this.checkmessagetramp();
				}
				catch(TrampolineException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("you advance " + tp.getmove_t() + " tiles!");
				this.setPosition(tp.moveahead(this.getPosition(), n));
				System.out.println(u.getName() + " moved to Tile " + this.getPosition());
				if(this.getPosition() == n) {
					System.out.println("=====Winner=====Winner=======");
					System.out.print(u.getName());
					try {
						Gamewinnermessage();
					}
					catch(GamewinnerException e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
			else {
				System.out.println("I am a White tile !");
				System.out.println(u.getName() + " moved to Tile- " + this.getPosition());
			}
	}
	
	public void updatesettings(int n) {
		Hashtable<Integer, Integer> tmap = this.getTilemap();
		int c=0;
		for(int i=1;i<=n-(n%6);i=i+6) {
			c=0;
			for(int j=0;j<6;j++) {
				if(5 <= tmap.get(i+j)) {
					c++;
				}
			}
			if(c == 0) {
				if(tmap.get(i+3) == 1) {
					tmap.put(i+3 , 8);
					this.setCount_snak(this.getCount_snak() - 1);
				}
				else if(tmap.get(i+3) == 2) {
					tmap.put(i+3 , 8);
					this.setCount_vul(this.getCount_vul() - 1);
				}
				else if(tmap.get(i+3) == 3) {
					tmap.put(i+3 , 8);
					this.setCount_crick(this.getCount_crick() - 1);
				}
				else if(tmap.get(i+3) == 4) {
					tmap.put(i+3 , 8);
					this.setCount_tramp(this.getCount_tramp() - 1);
				}
			}
			
		}
		this.setTilemap(tmap);
	}
	
	
	public void Runsetting(int n) {
			System.out.println("Setting up the race track");
			Hashtable<Integer, Integer> tmap = this.getTilemap();
			tmap.put(1, 8);
			tmap.put(n, 8);
			for(int i=2;i<n;i++) {
				int temp = this.getRob().randomnumber();
				if(temp == 1) {
					tmap.put(i, 1);
					this.setCount_snak(this.getCount_snak() + 1);
				}
				else if(temp == 2) {
					tmap.put(i, 2);
					this.setCount_crick(this.getCount_crick() + 1);
				}
				else if(temp == 3) {
					tmap.put(i, 3);
					this.setCount_vul(this.getCount_vul() + 1);
				}
				else if(temp == 4) {
					tmap.put(i, 4);
					this.setCount_tramp(this.getCount_tramp() + 1);
				}
				else {
					tmap.put(i, temp);
				}
			}
			this.setTilemap(tmap);
			this.updatesettings(n);
			
			System.out.println("Danger : There are " + this.getCount_snak() + " , " + this.getCount_crick() + " , " + this.getCount_vul() + " number of snakes , cricket , vulture respectively on your track");
			
			System.out.println("Danger : Each Snake, Cricket and Vulture can throw you back by " + sn.getMove_T() + " , " + vl.getMove_T() + " , " + ck.getMove_T());
			
			System.out.println("Good News : There are " + this.getCount_tramp() + " number of Trampolines on your track!");
			
			System.out.println("Good News : Each Trampoline can help you by " + tp.getmove_t() + " number of Tiles");
			
		
	}
	
	public void GamePlay(int n, String name) {
			User u = new User(name);
			System.out.println("Game started ===================>");
			int temp;
			while(this.getPosition() < n) {
				temp = this.getD().diceroll();
				System.out.print("[Roll-" + this.getRollcount() + "]: " + name + " rolled " + temp + " at Tile- " + this.getPosition() + ", ");
				if(this.getPosition() == 1) {
					if(temp == 6) {
						System.out.println("You are out of the cage ! You get a free roll");
						this.setRollcount(this.getRollcount() + 1);
						int temp2 = this.getD().diceroll();
						System.out.print("[Roll-" + this.getRollcount() + "]: " + name + " rolled " + temp2 + " at Tile- " + this.getPosition() + ", ");
						this.setPosition(1 + temp2);
						System.out.println("landed on Tile " + this.getPosition());
						
						this.Shaking(u,n);
						
					}
					else {
						System.out.println("OOPs you need 6 to start");
					}
				}
				else if(this.getPosition() != 1) {
					if(this.getPosition() + temp > n) {
						System.out.println(" landed on Tile " + this.getPosition());
					}
					else if(this.getPosition() + temp == n) {
						this.setPosition(this.getPosition() + temp);
						System.out.println(" landed on Tile " + this.getPosition());
						System.out.println("=====Winner=====Winner=======");
						System.out.print(name);
						try {
							Gamewinnermessage();
						}
						catch(GamewinnerException e) {
							System.out.println(e.getMessage());
						}
						
					}
					else {
						this.setPosition(this.getPosition() + temp);
						System.out.println(" landed on Tile " + this.getPosition());
						this.Shaking(u,n);
					}
				}
				this.setRollcount(this.getRollcount() + 1);
			}
			
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TileGame T = new TileGame();
		
		
		boolean done = false;
		int total=0;
		while(!done) {
			System.out.println("Enter total number of tiles on the race track(length)");
			try {
				Scanner scan = new Scanner(System.in);
				total = scan.nextInt();
				
				T.Runsetting(total);
				
				boolean done2 = false;
				while(!done2) {
					System.out.println("Enter the Player Name ");
					try {
						Scanner scan1 = new Scanner(System.in);
						String name = scan1.next();
						
						
						System.out.println("Starting the game with " + name + " at Tile-" + T.getPosition());
						System.out.println("Control transferred to Computer for rolling the Dice for " + name);
						//System.out.println("Hit enter to star the game");
						T.GamePlay(total, name);
						done2 = true;
						
					}
					catch(InputMismatchException inp1) {
						System.out.println("Wrong input ");
						System.out.println("this input should be string type ");
					}
					
				}
				done = true;
				
			}
			
			catch(InputMismatchException inp) {
				System.out.println("Wrong input ");
				System.out.println("This input should be Integer type ");
			}
		}
		
		
		
		
		
		

	}

}
