package mypack;

public class LoginBean {
	  public boolean check(String un,String pass)
	  {
		  if(un.equalsIgnoreCase("Ankush") && pass.equalsIgnoreCase("pass"))
		  {
			  return true;
		  }
		  return false;
	  }
	}
