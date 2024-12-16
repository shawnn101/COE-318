package coe318.lab2;
/**
* ComplexNumber models a complex number expressed
* in rectangular form (real and imaginary parts).
* It is an <em>immutable</em> object.
*
* @author Your Name
*/
public class ComplexNumber {
//Instance variable declarations
    private double re;
    private double im;
    
/**
* Construct a ComplexNumber given its
* real and imaginary parts.
* @param re The real component
* @param im The imaginary component
*/
public ComplexNumber(double re, double im) {
//Initialize the instance variables
    this.re = re;
    this.im = im;
}
/**
* Returns the real component.
* @return the real
*/
public double getReal() {
    return this.re;
}
/**
* Returns the imaginary component.
* @return the imaginary
*/
public double getImaginary() {
    return this.im;
}
/**
* Returns a new ComplexNumber number that is
* the negative of <em>this</em>. Note: the
* original ComplexNumber is <b>NOT</b>
* modified.
* @return -this
*/
public ComplexNumber negate() {
    // complex conjugate of a number a+bi is−a−bi

    return new ComplexNumber(-this.re, -this.im);
}
/**
* Returns a new ComplexNumber that is the
* sum of <em>this</em> and <em>z</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this + z
*/
public ComplexNumber add(ComplexNumber z) {
    return new ComplexNumber(this.re + z.getReal(), this.im + z.getImaginary());
}
/**
* Returns a new ComplexNumber that is the
* difference of <em>this</em> and <em>z</em>.
* * Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this + z
*/
public ComplexNumber subtract(ComplexNumber z) {
    return new ComplexNumber(this.re - z.getReal(), this.im - z.getImaginary());
}
/**
* Returns a new ComplexNumber that is the
* product of <em>this</em> and <em>z</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this * z
*/
public ComplexNumber multiply(ComplexNumber z) {
    double real_num = this.re * z.getReal() - this.im * z.getImaginary();
    double imaginary_num = this.re * z.getImaginary() + this.im * z.getReal();
    return new ComplexNumber(real_num, imaginary_num);
}
/**
* Returns a new ComplexNumber that is
* the reciprocal of <em>this</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @return 1.0 / this
*/
public ComplexNumber reciprocal() {
    double denom = this.re * this.re + this.im * this.im;
    return new ComplexNumber(this.re/denom, -this.im/denom);
}
/**
* Returns a new ComplexNumber that is
* <em>this</em> divided by <em>z</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this / z
*/
public ComplexNumber divide(ComplexNumber z) {
    return this.multiply(z.reciprocal());
}

/**
* Returns a String representation of
* <em>this</em> in the format:
* <pre>
* real +-(optional) i imaginary
* </pre>
* If the imaginary part is zero, only the
* real part is converted to a String.
* A "+" or "-" is placed between the real
* and imaginary parts depending on the
* the sign of the imagrinary part.
* <p>
* Examples:
* <pre>
* ..println(new ComplexNumber(0,0); -> "0.0"
* * ..println(new ComplexNumber(1,1); -> "1.0 + i1.0"
* ..println(new ComplexNumber(1,-1); -> "1.0 - i1.0"
* </pre>
* @return the String representation.
*/


@Override
public String toString() {
    //DO NOT MODIFY THIS CODE!
    String str = "" + this.getReal();
    if (this.getImaginary() == 0.0) {
        return str;
    }
    if (this.getImaginary() > 0) {
        return str + " + i" + this.getImaginary();
    } else {
        return str + " - i" + -this.getImaginary();
    }
  }
}

