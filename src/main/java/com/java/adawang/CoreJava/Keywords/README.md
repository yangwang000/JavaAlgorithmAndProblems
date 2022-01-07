## Final Class
When a class is declared with final keyword, it is called a final class. A final class cannot be extended(inherited).  <br>
There are two uses of a final class: <br>
<li>One is definitely to prevent inheritance, as final classes cannot be extended. For example, all Wrapper Classes like Integer, Float, etc. are final classes. We can not extend them.</li>
<li>The other use of final with classes is to create an immutable class like the predefined String class. One can not make a class immutable without making it final.</li>

## Final Methods
A final method cannot be overridden. 

## Final Variables
When a variable is declared with final keyword, its value can’t be modified, essentially, a constant.If the final variable is a reference, this means that the variable cannot be re-bound to reference another object, but the internal state of the object pointed by that reference variable can be changed i.e. you can add or remove elements from the final array or final collection. It is good practice to represent final variables in all uppercase, using underscore to separate words.
<pre><code>
// Java Program to demonstrate Different
// Ways of Initializing a final Variable

// Main class
class GFG {

	// a final variable
	// direct initialize
	final int THRESHOLD = 5;
	
	// a blank final variable
	final int CAPACITY;
	
	// another blank final variable
	final int MINIMUM;
	
	// a final static variable PI
	// direct initialize
	static final double PI = 3.141592653589793;
	
	// a blank final static variable
	static final double EULERCONSTANT;
	
	// instance initializer block for
	// initializing CAPACITY
	{
		CAPACITY = 25;
	}
	
	// static initializer block for
	// initializing EULERCONSTANT
	static{
		EULERCONSTANT = 2.3;
	}
	
	// constructor for initializing MINIMUM
	// Note that if there are more than one
	// constructor, you must initialize MINIMUM
	// in them also
	public GFG()
	{
		MINIMUM = -1;
	}	
}
</code></pre>

