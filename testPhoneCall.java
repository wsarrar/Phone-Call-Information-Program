// Academic Project (2019)

import java.util.*;
import java.text.*;
import java.io.*;

public class testPhoneCall
{
	public static void main(String[] args) throws IOException, ParseException {
		File f = new File(args[0]);

		FileReader fReader = new FileReader(f);
		BufferedReader bReader = new BufferedReader(fReader);
		String line;
		PhoneCall pCall;
		
		List<PhoneCall> list1 = new ArrayList<PhoneCall>();
		List<PhoneCall> anotherList = new ArrayList<PhoneCall>();

		while ((line = bReader.readLine()) != null) 
		{
			String myArray[] = line.split(",");
			String destinationNumber = myArray[0];
			double duration = Double.valueOf(myArray[1]);
			String callDate = myArray[2];
			DateFormat dataF = new SimpleDateFormat("dd-MM-yyyy");
			Date startDate = dataF.parse(callDate);
			String callerName = myArray[3];
			double cost = Double.valueOf(myArray[4]);
			
			pCall = new PhoneCall(destinationNumber, callerName, duration, cost, startDate);
			list1.add(pCall);
		}
		
		fReader.close();
		
		anotherList = list1;
		boolean condition = true;
		Scanner scan = new Scanner(System.in);
		String x = "";

		do{
			printMenu();
			x = scan.nextLine();
			
			switch (x) {
			
			case "A":
				System.out.println("Search a call using a destination number");
				System.out.println("Enter the Destination Number: ");
				String pNum = scan.nextLine();
				String foundPNum = "";

				for(PhoneCall p: list1)
				{
					String phoneNumber = p.getDestPhnNum();
					
					if(phoneNumber.equalsIgnoreCase(pNum))
						foundPNum  = p.toString();
				}
				
				if(!foundPNum .isEmpty())
					System.out.println(foundPNum );
					
				else
					System.out.println("Phone number not found");
				break;
			
			case "B":

				System.out.println("This caller has the longest call information");
				Collections.sort(anotherList, new Comparator<PhoneCall>() 
				{
					@Override
					public int compare(PhoneCall call1, PhoneCall call2) 
					{
						return Double.compare(call1.getCallTime(), call2.getCallTime());
					}
				});

				pCall = anotherList.get(anotherList.size() - 1);
				System.out.println(pCall.toString());
				break;

			case "C":
				System.out.println("This caller has the shortest call information");

				Collections.sort(anotherList, new Comparator<PhoneCall>()
				{
					@Override
					public int compare(PhoneCall call1, PhoneCall call2) 
					{
						return Double.compare(call1.getCallTime(), call2.getCallTime());
					}
				});

				pCall = anotherList.get(0);
				System.out.println(pCall.toString());
				break;

			case "D":
				System.out.println("Display the calls based on the call duration");

				Collections.sort(anotherList, new Comparator<PhoneCall>() 
				{
					@Override
					public int compare(PhoneCall call1, PhoneCall call2) 	
					{
						return Double.compare(call1.getCallTime(), call2.getCallTime());
					}
				});
				
				for(PhoneCall p: anotherList)
				{
					System.out.println(p.toString());
				}

				break;

			case "E":
				System.out.println("Add your information to a file");

				String text = "";
				BufferedWriter output = null;

				try 
				{
					File newFile = new File("phone_bills.txt");
					output = new BufferedWriter(new FileWriter(f));
					double totalBill = 0.0;

					StringBuffer sBuffer = new StringBuffer();

					for(PhoneCall p1:list1)
					{
						text = p1.toString()+" \n";
						sBuffer.append(text);
						totalBill += p1.getCallCost();
					}
					output.write(sBuffer.toString());
					output.write("Total Bill::"+totalBill);

				} 
				catch ( IOException excep ) 
				{
					excep.printStackTrace();
				} 
				finally 
				{
					if (output != null) 
						output.close();
				}

				break;

			case "F":
				condition = false;
				break;

			default:
				System.out.println("Invalid Choice....");
			}

		}while(condition);
	}
	
	public static void printMenu()
	{
		System.out.println("Menu");
		System.out.println("A) Search a call based on the destination number");
		System.out.println("B) Display the longest call information");
		System.out.println("C) Display the shortest call information ");
		System.out.println("D) Sort the phone calls array list based on the call duration and display calls in the sorted order");
		System.out.println("E) Prepare a phone bill and store the phone bill");
		System.out.println("F) Exit the program");
	}
}


