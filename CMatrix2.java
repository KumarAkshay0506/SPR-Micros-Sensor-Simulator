package transfermatrix3;


public class CMatrix2 {
    public Complex m[][];
    
    public CMatrix2() {
        m = new Complex[2][2];
        m[0][0] = new Complex(0.0);
        m[0][1] = new Complex(0.0);
        m[1][0] = new Complex(0.0);
        m[1][1] = new Complex(0.0);
    }

    public CMatrix2(Complex a,Complex b,Complex c,Complex d) {
        m = new Complex[2][2];
        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d;
    }
    
    public static CMatrix2 I() {
        return new CMatrix2(new Complex(1.0),new Complex(0.0),new Complex(0.0),new Complex(1.0));
    }
                
    public CMatrix2 mul(CMatrix2 mat) {
        CMatrix2 r = new CMatrix2();
        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++)
                    r.m[i][j]=Complex.add(r.m[i][j],Complex.mul(m[i][k],mat.m[k][j]));
            }
        return r;
    }

    public CMatrix2 mul(double x) {
        CMatrix2 r = new CMatrix2();
        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++)
                    r.m[i][j]=Complex.add(r.m[i][j],Complex.mul(m[i][k],x));
            }
        return r;
    }

    public static CMatrix2 mul(CMatrix2 a,CMatrix2 b) {
        CMatrix2 r = new CMatrix2();
        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++)
                    r.m[i][j]=Complex.add(r.m[i][j],Complex.mul(a.m[i][k],b.m[k][j]));
            }
        return r;
    }

    public static CMatrix2 mul(CMatrix2 a,Complex b) {
        CMatrix2 r = new CMatrix2();
        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                r.m[i][j]=Complex.mul(a.m[i][j],b);
        return r;
    }
    
}
