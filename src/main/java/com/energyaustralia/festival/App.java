package com.energyaustralia.festival;

public class App {

	public static class TextInput {

		protected String val;

		public TextInput() {
			this.val = "";
		}
		
		public void add(char c) {
			this.val = this.val + c;
		}

		public String getValue() {
			return val;
		}
	}

	public static class NumericInput extends TextInput {

		public void add(char c) {
			if (c >= 48 && c <= 57)
				this.val = this.val + c;
		}
	}

	public static void main(String[] args) {
		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('0');
		System.out.println(input.getValue());
	}
}
