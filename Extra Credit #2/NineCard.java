import carddeck.service.classes.Card;
import carddeck.service.classes.CardValue;
import carddeck.service.classes.CardSign;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
class Ninecards{
    Card [] yourHand = new Card[9]; //player's hand, provided in the text file hand.txt
	Card [] houseHand = new Card[9]; //house's hand, randomly generated

    private void generateHouseHand(){//method to randomly generate the cards for the house
		int rndVal;
		CardSign sign = null;
		CardValue value = null;
		/*Task 5: Add code to generate the cards for the house*/
		for (int i = 0; i<9; i++)
		{
			rndVal =(int)(Math.random()*(4));
			sign= CardSign.values()[rndVal];
			rndVal =(int)(Math.random()*(9));
			value = CardValue.values()[rndVal];
			houseHand[i] = new Card(sign,value);
		}
	}
	private int getScore()
	{
		int score = 0;
		for (int i=0; i<9; i++)
		{
			if(yourHand[i].compareCards(houseHand[i])==1)
			{
				score +=1;
			}
			else if(yourHand[i].compareCards(houseHand[i])==-1)
			{
				score -=1;
			}
		}
		return score;
	}	
	public static void main(String []args){
	//arg[0]: file containing your hand
		Ninecards game=new Ninecards();
		//read the the files from text files
		Card [] cHand = new Card[9];
		int count=0;
		Card aCard;
		Scanner scan;
		String str;
		try {
			File myFile=new File(args[0]);
            scan=new Scanner(myFile);//each line has the format title:genre:author-name-1,author-name-2..authorname-m
			while(scan.hasNextLine()){
				str=scan.nextLine();				
				String []tok=str.split(":");
				/*Task 4: insert the information about the user's cards read from the text file, into the class array */
				CardSign sign = null;
				CardValue value = null;
				sign = CardSign.valueOf(tok[0]);
				value = CardValue.valueOf(tok[1]);
				aCard = new Card(sign,value);
				yourHand[count]=aCard;	
				count++;
			}
		//lets play Nine Cards!!
		//User interactive part
		String option1;
		scan = new Scanner(System.in);
		int score;
		while(true){
			System.out.println("Select an option:");
			System.out.println("Type \"P\" to play a round of Nine Cards");			
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {								 
				case "P":   /*generate the cards for the house*/
							game.generateHouseHand();
							/*Compare the house cards with the cards of the user*/
				            score=game.getScore();				            
							if(score < 0)
								System.out.println("House Wins :-(");
							else if (score == 0)
								System.out.println("Its a draw");
							else if (score > 0)
								System.out.println("Congrats You win !!");
							else
								System.out.println("Somethings wrong!");
							break;
				
				case "Q":   System.out.println("Quitting program");
							System.exit(0);
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}
			
		}					
		}catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}catch(IllegalArgumentException ia){ 
            System.out.println(ia.getMessage());
		} catch(NullPointerException np){
			System.out.println(np.getMessage());
		}
	}	

}