package expressions;

import java.util.List;

import model.RGBColor;

public class Vmapping extends Variable {
	private Expression myExpression;

	public Vmapping(String variable, Expression expression) {
		super(variable);
		myExpression = expression;
	}
	
	public Expression getExpression(){
		return myExpression;
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars){
		for(Vmapping v:vars){
			if(v.getName().equals(myVariable)){
				Vmapping layer = vars.remove(0);
				RGBColor result =  v.getExpression().evaluate(xval, yval, tval, vars);
				vars.add(0, layer);
				return result;
			}
		}
		return null;
	}

}
