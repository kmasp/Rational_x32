//Team x32 -- Kyle & Zuhra
//APCS1 pd5
//HW32 -- Do you even add bro?
//2015-11-18

public class Rational {

    // Instance Variables
    // Do you want to name them numerator and denominator instead?
    private int _n; 
    private int _d;

    // Constructors
    // Can the this constructor call the second? maybe with this(0,1); ?
    public Rational() {
        _n = 0;
        _d = 1;
    }

    public Rational(int n, int d)
    {
        this();
        if (d != 0)
        {
            _n = n;
            _d = d;
        }
        else
            System.out.println("Invalid. Fraction set to 0 / 1");
    }

    // Accessor Methods
    public int getN() {
        return _n;
    }

    public int getD() {
        return _d;
    }

    // Override toString() Method
    public String toString() {
        return ( /*"Fraction: " +*/ _n + "/" + _d /*+ "\n"*/);
    }

    // Float Value Method
    public double floatValue() {
        return ( 1.0*_n / _d ); 
    }

    // Multiply Method
    public void multiply(Rational fraction) {
        _n *= fraction.getN();
        _d *= fraction.getD();
    }

    // Divide Method
    public void divide(Rational fraction) {
        if ( fraction.getN() != 0 ) {
            _n *= fraction.getD();
            _d *= fraction.getN();
        }
        else {
            System.out.println("Divide by Zero error.");
	}
    }

    // Add Method
    public void add(Rational fraction) {
        if (_d==fraction.getD()) {
            _n+=fraction.getN();
            _d=fraction.getD();
	}
        else {
            int multiple = _d * fraction.getD();
            int m1 = multiple / _d ;
            int m2 = multiple / fraction.getD();
            _d = multiple;
            _n = (_n * m1) + (fraction.getN() * m2);
	b}
    }

    /*
    // Subtract Method
    public void subtract(Rational fraction) {
	
	
    }

    // Greatest Common Demoninator Method
    public void gcd(Rational fraction) {
	if (_n % _d==0) {

	}
    }
    
    // Reduce Method
    public void reduce(Rational fraction) {

    }
    */   
 
    public static void main(String[] args) {
	
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2

	System.out.print(r + " * " + s + " = ");
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r);

	System.out.print(r + " / " + s + " = ");
	r.divide(s);
	System.out.println(r);
	
	Rational z = new Rational(0,3);
	Rational k = new Rational(1,2);

	System.out.print(z + " + " + k + " = ");
	z.add(k);
	System.out.println(z);

	System.out.print(z + " / " + k + " = ");
	z.divide(k);
	System.out.println(z);

    }
} //End class Rational
