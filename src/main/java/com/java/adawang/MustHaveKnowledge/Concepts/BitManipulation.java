package com.java.adawang.MustHaveKnowledge.Concepts;

public class BitManipulation {
	// 0s 1s means sequence of 0 or 1
	// x ^ 0s = x; x ^ 1s = ~x; x ^ x = 0;
	// x & 0s = 0; x & 1s = x; x & x = x;
	// x | 0s = x; x | 1s = 1s; x | x = x;
	// 0110+0110 is equivalent to 0110*2 shift left by 1
	// 0110*0100 shift 0110 left by 2
	// a^(~a) = 1s

	boolean checkExactlyOneBitSet(int bitVector){
		return ((bitVector - 1) & bitVector) == 0;
	}

	// logical right shift operator >>>
	// shift the bits and put a 0 in the most significant bit
	// 10110101 = -75
	// 01011010 = 90
	// arithmetic right shift operator >>
	// shift values to the right but fill in the new bits
	// with the value of the sign bit
	// 10110101 = -75
	// 11011010 = -38

	// four bit signed integer
	// |7|0 111|-1|1 111|
	// |6|0 110|-2|1 110|
//	|5|0 101|-3|1 101|
//	|4|0 100|-4|1 100|
//	|3|0 011|-5|1 011|
//	|2|0 010|-6|1 010|
//	|1|0 001|-7|1 001|
//	|0|0 000|||
}
