package transfermatrix3;

import java.util.ArrayList;

public class Optics {
    public double [] Fresnel(double lambda,double thetai,double [] h,Complex [] n,int pol) {
        Complex _0 = new Complex(0.0);
        Complex _1 = new Complex(1.0);
        Complex I = Complex.I();
        Complex _I = new Complex(0.0,-1.0);
        Complex [] theta = new Complex[n.length];
        //Snell's law:
        theta[0]=new Complex(thetai*Math.PI/180.0);
        for (int a=0; a<n.length-1; a++)
        {
            Complex n_n1 = Complex.div(n[a],n[a+1]);
            Complex C = Complex.asin( Complex.mul(n_n1,Complex.sin(theta[a])));
            theta[a+1]= new Complex(C.re,-Math.abs(C.im));
        }
        
        //Fresnel coefficients:
        Complex [] Fr = new Complex[n.length];
        Complex [] Ft = new Complex[n.length];
        if (pol==0) { //formulas for s polarization
            for (int a=0; a<n.length-1; a++) {
                Complex nct = Complex.mul(n[a],Complex.cos(theta[a]));
                Complex n1ct1 = Complex.mul(n[a+1],Complex.cos(theta[a+1]));
                Fr[a] = Complex.div(Complex.sub(nct,n1ct1),Complex.add(nct,n1ct1));
                Ft[a] = Complex.div(Complex.mul(nct,2.0),Complex.add(nct,n1ct1));
            }
        }
        else if(pol==1) { //formulas for p polarization
            for (int a=0; a<n.length-1; a++) {
                Complex nct = Complex.mul(n[a],Complex.cos(theta[a]));
                Complex nct1 = Complex.mul(n[a],Complex.cos(theta[a+1]));
                Complex n1ct = Complex.mul(n[a+1],Complex.cos(theta[a]));
                Fr[a] = Complex.div(Complex.sub(nct1,n1ct),Complex.add(nct1,n1ct));
                Ft[a] = Complex.div(Complex.mul(nct,2.0),Complex.add(nct1,n1ct));
            }
        }

        //phase shift factors:
        Complex [] delta = new Complex[n.length];
        for (int a=0; a<n.length-2; a++) {
            Complex c1 = Complex.mul(n[a+1],Complex.cos(theta[a+1]));
            delta[a]=Complex.mul(c1,2*Math.PI*h[a+1]/lambda);
        }

        //build up transfer matrix:
        CMatrix2 M = CMatrix2.I(); //start with unity matrix
        for (int a=0; a<n.length-2; a++) {
            Complex invFt = Complex.div(_1, Ft[a]);
            CMatrix2 M1 = new CMatrix2(_1,Fr[a],Fr[a],_1);
            Complex eid = Complex.exp(Complex.mul(I,delta[a]));
            Complex e_id = Complex.exp(Complex.mul(_I,delta[a]));
            CMatrix2 M2 = new CMatrix2(e_id,_0,_0,eid);
            M = CMatrix2.mul(M,invFt);
            M = CMatrix2.mul(M,M1);
            M = CMatrix2.mul(M,M2);
        }
        Complex invFtn = Complex.div(_1, Ft[n.length-2]);
        CMatrix2 Mn = new CMatrix2(_1,Fr[n.length-2],Fr[n.length-2],_1);
        M = CMatrix2.mul(M,invFtn);
        M = CMatrix2.mul(M,Mn);
       
        //total Fresnel coefficients:
        Complex Frtot=Complex.div(M.m[1][0],M.m[0][0]);
        Complex Fttot=Complex.div(_1,M.m[0][0]);

        //special case of single interface:
        if (n.length==2) {
            Frtot=Fr[0];
            Fttot=Ft[0];
        }

        //total Fresnel coefficients in intensity:
        double FR=Math.pow(Complex.abs(Frtot), 2);
        double num = Complex.real(Complex.mul(n[n.length-1],Complex.cos(theta[n.length-1])));
        double den = Complex.real(Complex.mul(n[0],Complex.cos(theta[0])));
        double FT=Math.pow(Complex.abs(Fttot),2)*num/den;
        double FA=1-FR-FT;
        return new double []{FR,FT,FA};
    }    
    
    void plotAll(PlotDialog pltDlg, TransferMatrix3 frame, double [] h, int layer) {
        if(layer<frame.n.length-1) {
            for (h[layer]=frame.h0[layer]; h[layer]<=frame.hn[layer]; h[layer]+=frame.dh[layer]) {
                plotAll(pltDlg, frame, h, layer+1);
                if (frame.dh[layer] == 0.0)
                    break;
            }
        }
        else {
            ArrayList<Double> Y = new ArrayList<>();
            ArrayList<Double> X = new ArrayList<>();
            for(double thetai=0.0; thetai<=90.0; thetai+=0.01) { //angle of incidence (degrees)
                double [] F = Fresnel(frame.lambda,thetai,h,frame.n,frame.pol);
                X.add(thetai); 
                Y.add(F[frame.type]); 
            }
            String legend = "";
            for (int i=1; i<frame.hname.length-1; i++) {
                if(i>1)
                    legend+=", ";
                legend += String.format("%s=%5.2f", frame.hname[i], h[i]);
            }
            pltDlg.plot(X,Y,legend);
        }
    }
    
    public void plot(TransferMatrix3 frame) {
        double [] h=new double[]{-1,35,150,28,-1}; //film thicknesses in nm, equal in length to n, start and end with NaN
        String titles[] = {
            "Fresnel coefficient for reflection",
            "Fresnel coefficient for transmission",
            "Fresnel coefficient for absorption"
        };
        String pols[] = {
            " (s polarization)",
            " (p polarization)"
        };
                       
        PlotDialog pltDlg = new PlotDialog(titles[frame.type]+pols[frame.pol], "",frame,true);
        
        plotAll(pltDlg, frame, h, 1);
        pltDlg.setLocationRelativeTo(null);
        pltDlg.setVisible(true);
    }

}
