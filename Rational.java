public class Rational 
{
    // Instance Variables
    private int _n;
    private int _d;

    // Constructors
    public Rational()
    {
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
        return ( "Fraction: " + _n + " / " + _d + "\n");
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
            System.out.println("Divide by Zero error.");
    }

    public void add(Rational fraction){
        int multiple = _d * fraction.getD();
            int m1 = multiple / _d ;
            int m2 = multiple / fraction.getD();
        if (_d==fraction.getD()) {
            _n+=fraction.getN();
            _d=fraction.getD();}
        else 
            _d = multiple;
            _n = (_n * m1) + (fraction.getN() * m2);
    }
    public void subtract(Rational fraction){
        int multiple = _d * fraction.getD();
            int m1 = multiple / _d ;
            int m2 = multiple / fraction.getD();
        if (_d==fraction.getD()) {
            _n+=fraction.getN();
            _d=fraction.getD();}
        else 
            _d = multiple;
            _n = (_n * m1) - (fraction.getN() * m2);
    }
public static int gcdER (Rational r){
        int a = r.getN();
        int b = r.getD();
        int maxNum = Math.max(a,b);
        int minNum = Math.min(a,b);
        if (minNum == 0) return maxNum; // tests the zero case
        if (maxNum % minNum == 0) return minNum; //tests the zero case
        while (minNum != 0) {
        maxNum = maxNum - minNum;
        if (maxNum < minNum) {
        int temp = minNum;
        minNum = maxNum;
        maxNum = temp;
        }
    }
    return maxNum;
    }

    public static String reduce (Rational f){
        String returns = "";
        int h = gcdER(f);
        int newn = (f.getN() / h);
        int newd = (f.getD() / h);
        returns+= newn + "/" + newd;
        return returns;
    }
    public static void main(String[] args){
      Rational r = new Rational(2,3); //Stores the rational number 2/3
      Rational s = new Rational(1,2); //Stores the rational number 1/2
      r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
      System.out.println(r);

      Rational g = new Rational(2,3); //Stores the rational number 2/3
      Rational h = new Rational(1,2); //Stores the rational number 1/2
      g.divide(h);
      System.out.println(g);

      Rational z = new Rational(2,3);
      Rational k = new Rational(1,4);
      z.add(k);
      System.out.println(z);

      Rational d = new Rational(2,36);
      Rational e = new Rational(1,6);
      d.subtract(e);
      System.out.println(d);

      Rational x = new Rational(100,75);
      System.out.println(gcdER(x));
      System.out.println(reduce(x));
    }
}