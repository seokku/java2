package ch08Interface;

public class CalcuMultiInterfaceClass implements FourOpInterface, SumAvgInterface{

	@Override
	public int sum(int[] scores) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int s : scores)
			sum += s;
		return sum;
	}

	@Override
	public int avg(int sum, int cnt) {
		// TODO Auto-generated method stub
		return sum / cnt;
	}

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x - y;
	}
	
	@Override
	public int mul(int x, int y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	@Override
	public int div(int x, int y) {
		// TODO Auto-generated method stub
		return x % y;
	}

}
