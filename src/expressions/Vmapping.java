package expressions;

public class Vmapping{
	private String myVariable;
	private Expression myExpression;

	public Vmapping(String variable, Expression expression) {
		myVariable = variable;
		myExpression = expression;
	}
	
	public String getName(){
		return myVariable;
	}
	
	public Expression getExpression(){
		return myExpression;
	}

}
