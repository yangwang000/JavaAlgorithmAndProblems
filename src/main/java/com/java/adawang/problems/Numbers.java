package com.java.adawang.problems;

public class Numbers {
	/*
	*  #7 Reverse Integer
	*  Given a signed 32-bit integer x, return x with its digits reversed.
	*  If reversing x causes the value to go outside the
	*  signed 32-bit integer range [-231, 231 - 1], then
	*  return 0.
	*
	*  hint: We can build up the reverse integer one
	*  digit at a time. While doing so, we can check
	*  beforehand whether or not appending another digit
	*  would cause overflow.
	 * */
	static class ReverseInteger{
		public int reverse(int x) {
			int result = 0;
			while(x != 0){
				int quotient = x/10;
				int remainder = x%10;
				if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && remainder > 7)) return 0;
				if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && remainder < -8)) return 0;
				result = result*10 + remainder;
				x = quotient;
			}
			return result;
		}
	}
}
