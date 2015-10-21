package designPattern1qn1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger {

	
	private java.util.logging.Logger jLogger= java.util.logging.Logger.getLogger("MyLog");
	private static Logger logger= new Logger();

private FileHandler fh;
private Logger()
{
	try {  
	       
        // This block configure the logger with handler and formatter  
        fh = new FileHandler("D:/MyLogFile.log");  
        jLogger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
        // the following statement is used to log any messages  
        jLogger.info("My first log");  
    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  

	
}

public static Logger getInsrtance()
{
	return logger;

}

public void logError(String message)
{
  jLogger.info(message);	

}


	 
}
