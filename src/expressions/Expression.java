package expressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.RGBColor;

public abstract class Expression {
	
	public abstract RGBColor evaluate (double xval, double yval, double tval, List<Vmapping> vars);
	
	public static abstract class Factory
    {
        public abstract boolean isKindOfExpression(Parser parser);
        public abstract Expression parseExpression(Parser parser);
        
        protected boolean regexMatches(Pattern regex, Parser parser) {
            Matcher expMatcher = regex.matcher(parser.stringAtCurrentPosition());
            return expMatcher.lookingAt();
        }
    }

}
