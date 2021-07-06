package mypack;

public class CareerExpert 
{
	public String getAdvice(String qualification)
	{	
		if(qualification.equalsIgnoreCase("be"))
		{
			return "Get admitted in eDAC course";
		}
	return "No advice available for this qualification";
	}
}