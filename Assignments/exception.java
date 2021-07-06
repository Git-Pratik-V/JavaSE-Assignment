class Calculator
{
	int res;
 int caldouble(int num)throws RuntimeException
	{
		if(num==0) 
		{
			throw new RuntimeException("0 is not allowed please change");
		}
		else if(num<0)
		{
			throw new RuntimeException("negative value not allowed please change");
		}
		res=num*2;
		return res;	
}
}
public class MyArithException {


	public static void main(String[] args){
		// TODO Auto-generated method stub
		Calculator c=new Calculator();
		c.caldouble(4);
	}

}
