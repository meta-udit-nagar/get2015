package designpattern1qn2;

public class EngineerFactory {

   public IEngineer createEnginner(String choice)
   {
	   IEngineer engineer= null;
	   
	   if(choice.equals("developer"))
		   engineer= new Developer();
	   else if(choice.endsWith("tester"))
		   engineer= new Tester();
	   
	   return engineer;
	   
   }


}
