package Client.Services.Classes;
import Client.Services.BillsType;
public class MyBills 
{
	private String monthOfExpense;
	private enum BillsType{};
	private Object[] coolboi; 
	private int numDays;
	public static int id;
	private int iD;
	public MyBills()
	{
		this.monthOfExpense="January";
		Object[] cool= {};
		this.coolboi=cool;
		this.numDays=0;
		this.iD=id;
	}

	public MyBills(String moe,Object[] cb,int nd)
	{
		this.monthOfExpense=moe;
		this.coolboi=cb;
		this.numDays=nd;
		this.iD=id;
	}
	public String getMonthOfExpense() 
	{
		return this.monthOfExpense;
	}
	public Object[] getinfo() 
	{
		return this.coolboi;
	}
	public int getID() 
	{
		return this.iD;
	}
	public int getnumDays() 
	{
		return this.numDays;
	}
}
