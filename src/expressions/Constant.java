package expressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.RGBColor;
import expressions.Expression;

public class Constant extends Expression {
	private RGBColor myValue;

	public Constant(RGBColor value) {
		myValue = value;
	}

	public RGBColor evaluate(double xval, double yval, double tval, List<Vmapping> vars) {
		return myValue;
	}

	public static class Factory extends Expression.Factory {
		protected static final Pattern DOUBLE_REGEX = Pattern
				.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");

		public boolean isKindOfExpression(Parser parser) {
			return regexMatches(DOUBLE_REGEX, parser);
		}

		public Expression parseExpression(Parser parser) {
			String input = parser.stringAtCurrentPosition();
			Matcher doubleMatcher = DOUBLE_REGEX.matcher(input);
			doubleMatcher.find(0);
			String numberMatch = input.substring(doubleMatcher.start(),
					doubleMatcher.end());
			parser.advanceCurrentPosition(numberMatch.length());
			// this represents the color gray of the given intensity
			double value = Double.parseDouble(numberMatch);
			RGBColor gray = new RGBColor(value);
			return new Constant(gray);
		}

	}
}
