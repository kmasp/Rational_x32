//Team x32 -- Kyle & Zuhra
//APCS1 pd5
//HW32 -- Do you even add bro?
//2015-11-18

public class Rational 
{

    //--------------------PHASE I--------------
    
    // Instance Variables
    private int _n;
    private int _d;

    // Constructors
    public Rational()
    {
        //setting values for the instance variables
	_n = 0;
	_d = 1;
    }
    //overloaded Constructor
    public Rational(int n, int d)
    {
	this();
        //denominator cannot be 0
        if (d != 0)
	{
	    _n = n;
	    _d = d;
	}
        else
	{
	    //if the denominator is 0, then return an error message
            System.out.println("Invalid. Fraction set to 0 / 1");
	}
    }

    // Accessor Methods
    public int getN()
    {
        return _n;
    }

    public int getD()
    {
        return _d;
    }

    // Override toString() Method
    public String toString()
    {
        return (/* "Fraction: " +*/ _n + "/" + _d);// + "\n");
    }

    // Float Value Method
    public double floatValue()
    {
        return ( 1.0*_n / _d ); 
    }

    // Multiply Method
    public void multiply(Rational fraction)
    {
        _n *= fraction.getN();
        _d *= fraction.getD();
    }

    // Divide Method
    public void divide(Rational fraction)
    {
        if ( fraction.getN() != 0 )
	{
	    _n *= fraction.getD();
	    _d *= fraction.getN();
	}
        else
	{
            System.out.println("Divide by Zero error.");
	}
    }

    //----------------------PHASE II--------------

    //Tried making a helper function due to the redundant code in add & subtract, but oh well.
    
    //Adding method
    public void add(Rational fraction)
    {
        //common multiple
        int multiple = _d * fraction.getD();
        int m1 = multiple / _d ;
        int m2 = multiple / fraction.getD();
	
        if (_d==fraction.getD())
	{
            _n+=fraction.getN();
            _d=fraction.getD();
	}
        else
	{
            _d = multiple;
	    _n = (_n * m1) + (fraction.getN() * m2);
	}
    }

    //Subtract method
    public void subtract(Rational fraction)
    {
        int multiple = _d * fraction.getD();
	int m1 = multiple / _d ;
	int m2 = multiple / fraction.getD();
	
        if (_d==fraction.getD())
	{
            _n+=fraction.getN();
            _d=fraction.getD();
	}
        else
	{
            _d = multiple;
	    _n = (_n * m1) - (fraction.getN() * m2);
	}
    }
     
    //Using Euclid's Algorithm to find the gcd
    public static int gcdER (Rational r)
    {
        int a = r.getN();
        int b = r.getD();
	
        //iterative version
        int maxNum = Math.max(a,b); //First number has to be bigger
        int minNum = Math.min(a,b);
        if (minNum == 0) return maxNum; // tests the zero case
        if (maxNum % minNum == 0) return minNum; //tests the zero case
        while (minNum != 0)
	{
	    maxNum = maxNum - minNum;
	    if (maxNum < minNum)
	    {
		int temp = minNum;
		minNum = maxNum;
		maxNum = temp;
	    }
	}
	return maxNum;
    }

    //Reducing fractions method
    public void reduce()
    {
        //using gcdER to find the greatest common divisor of the Rational
        Rational e = new Rational (_n, _d);
        int h = gcdER(e);
        _n = (_n / h); //new numerator
        _d = (_d / h); //new denominator
    }

    //GCD with integer numerator and denominator inputs
    public static int gcd (int n, int d)
    {
        //iterative version
        int maxNum = Math.max(n,d); //First number has to be bigger
        int minNum = Math.min(n,d);
	
        if (minNum == 0)
	{
	    return maxNum; // tests the zero case
	}
	if (maxNum % minNum == 0)
	{
	    return minNum; //tests the zero case
	}
        while (minNum != 0)
	{
	    maxNum = maxNum - minNum;
	    if (maxNum < minNum)
	    {
		int temp = minNum;
		minNum = maxNum;
		maxNum = temp;
	    }
	}
	return maxNum;
	/*Another way to do the while loop without the if
	  while (minNum > 0) 
	  {
	  int temp=maxNum % minNum;
	  maxNum=minNum;
	  minNum=temp;
	  }
	*/		
    }

    public int compareTo(Rational a)
    {
        int n = a.getN();
        int d = a.getD();
	int i;
	
        if (a.floatValue() == this.floatValue())
	{
            i = 0;
        }
        else if (this.floatValue() > a.floatValue())
	{
            i = 1;
        }
	// else if (this.floatValue()
        else 
	{
	    i = -1;
	}
	return i;
    }


    public static void main(String[] args){
    
	//testing multiply
	System.out.println("Testing multiply:");
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
	System.out.println("2/3 multiplied by 1/2 is... " + r);

	//testing divide
	System.out.println("\nTesting divide:");
	Rational z = new Rational(0,3);
	Rational k = new Rational(1,2);
	z.divide(k); //should give 0 / 3
	System.out.println("0/3 divided by 1/2 is... " + z);

	Rational a = new Rational(1, 2);
	Rational b = new Rational(1, 2);
	b.divide(a); //should give 2 / 2
	System.out.println("1/2 divided by 1/2 is... " + b);

	//testing compareTo
	System.out.println("\nTesting compareTo:");
	System.out.println("0/3 comparedTo 1/2 is... " + z.compareTo(k)); //should return -1
	
	Rational q = new Rational(3,6);
	Rational t = new Rational(4,8);
	System.out.println("3/6 comparedTo 4/8 is... " + q.compareTo(t)); //should return 0

	//testing add
	System.out.println("\nTesting add:");
	Rational c = new Rational(0,3);
	Rational d = new Rational(1,2);
	c.add(d); //should give 3 / 6
	System.out.println("0/3 added to 1/2 is... " + c);

	//testing subtract
	System.out.println("\nTesting subtract:");
	Rational e = new Rational(5,3);
	Rational f = new Rational(1,2);
	e.add(f); //should give 7 / 6
	System.out.println("1/2 subtracted from 5/3 is... " + e);

	//testing gcdER
	System.out.println("\nTesting gcdER:");
	Rational g = new Rational(4,50);
	Rational h = new Rational(6,42);
	System.out.println("The GCD of 4 and 50 is... " + gcdER(g)); //should print 2
	System.out.println("The GCD of 6 and 42 is... " + gcdER(h)); //should print 6
	
	//testing gcd
	System.out.println("\nTesting gcd:");
	System.out.println("The GCD of 4 and 50 is... " + gcd(4, 50)); //should print 2
	System.out.println("The GCD of 6 and 42 is... " + gcd(6, 42)); //should print 6

	//testing reduce
	System.out.println("\nTesting reduce:");
	Rational i = new Rational(4,50);
	Rational j = new Rational(6,42);
	i.reduce();
	j.reduce();
	System.out.println("4/50 reduced is..." + i); //should print 2/25
	System.out.println("6/42 reduced is..." + j); //should print 1 / 7


    }
}
