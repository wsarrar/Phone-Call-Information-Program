import java.util.*;
import java.text.*;
public class PhoneCall {
	private String destinationPNum;
	private String callerName;
	private double cTime;
	private double cCost;
	private Date cDate;
	
	DateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

	public PhoneCall(String destinationPNum, String callerName, 
	double cTime, double cCost, Date cDate) 
	{
		super();
		this.destinationPNum = destinationPNum;;
		this.callerName = callerName;
		this.cTime = cTime;
		this.cCost = cCost;
		this.cDate = cDate;
	}

	public String getDestPhnNum() 
	{
		return destinationPNum;
	}

	public void setDestPhnNum(String destPhnNum) 
	{
		this.destinationPNum = destPhnNum;
	}
	
	public String getCallerName() 
	{
		return callerName;
	}

	public void setCallerName(String callerName) 
	{
		this.callerName = callerName;
	}


	public double getCallTime() 
	{
		return cTime;
	}

	public void setCallTime(double cTime) 
	{
		this.cTime = cTime;
	}

	public double getCallCost() 
	{
		return cCost;
	}

	public void setCallCost(double cCost) 
	{
		this.cCost = cCost;
	}
	
	public Date getCallDate() 
	{
		return cDate;
	}

	public void setCallDate(Date cDate) 
	{
		this.cDate = cDate;
	}

	@Override
	public String toString() 
	{
		String result = "phone_bills.txt [Destinationt Number" + destinationPNum + 
		", Call Time(m)" + cTime + "," + " Call Date" + DF.format(cDate) + 
		", Caller's Name" + callerName + ", Call Cost($)" + cCost + "]";
		return result;
	}
}
