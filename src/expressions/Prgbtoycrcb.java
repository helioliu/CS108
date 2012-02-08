package expressions;
import java.util.*;

import model.RGBColor;
import model.util.ColorModel;

public class Prgbtoycrcb extends ParenExp{
	
	public Prgbtoycrcb(List<Expression> subexpressions){
		super(subexpressions);
	}
	
	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		List<RGBColor> results = evaluateSubs(xval, yval, tval, vars);
		return ColorModel.rgb2ycrcb(results.get(0));

	}
	
	public static class Factory extends PExpParamFactories.Factory1P
    {

        protected String commandName() {
            return "rgbToYCrCb";
        }
        
        protected ParenExp constructParenExpression(List<Expression> subExpressions) {
            return new Prgbtoycrcb(subExpressions);
        }
        
    }

}
