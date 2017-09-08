package carddeck.service.classes;
public class Card {
   private CardSign sign;
   private CardValue value;
   
public Card(CardSign sign, CardValue value){   // constructor
      this.sign = sign;
      this.value = value;
   }
   
   public CardSign getSign() { return this.sign; }
   
   public CardValue getValue() { return this.value; }
   
   public String toString() { return "This card is " + this.sign + " of " + this.value; }
   
   public int compareCards(Card aCard)
    {
		if (this.sign.ordinal()>aCard.sign.ordinal())
		{
			return 1;
		}
		else if (this.sign.ordinal()<aCard.sign.ordinal())
		{
			return -1;
		}
		else
		{
			if (this.value.ordinal()>aCard.value.ordinal())
			{
				return 1;
			}
			else if(this.value.ordinal()>aCard.value.ordinal())
			{
				return -1;
			}
			else 
			{
				return 0;
			}
		}
		
	}
}