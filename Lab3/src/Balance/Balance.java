package Balance;

import java.util.Stack;

public class Balance {
	private Stack<Character> mStack;

	public Balance() {
		super();
		this.mStack = new Stack<Character>();
	}

	public  boolean BalancedBrackets(String expression) {
		if (expression == null || expression.isEmpty() || expression.length() % 2 != 0) {
			return false;
		}
		this.mStack.clear();
		for (int i = 0; i < expression.length(); i++) {
			char character = expression.charAt(i);
			if (!"[{()}]".contains(String.valueOf(character))) {
				return false;
			}
			if (character == '(' || character == '[' || character == '{') {
				mStack.push(character);
				continue;
			}
			if (mStack.isEmpty()) {
				return false;
			}
			char checkCharacter;
			switch (character) {
			case ')':
				checkCharacter = mStack.pop();
				if (checkCharacter != '(')
					return false;
				break;

			case '}':
				checkCharacter = mStack.pop();
				if (checkCharacter != '{')
					return false;
				break;

			case ']':
				checkCharacter = mStack.pop();
				if (checkCharacter != '[')
					return false;
				break;
			}
		}
		return (mStack.isEmpty());
	}
}
