package transfermatrix3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TransferMatrix3 extends javax.swing.JFrame {
    int type;
    double lambda;      // vacuum wavelength (nm)
    int pol;            //polarization, 1 for p and 0 for s
    Complex [] n; //refractive index data

    double [] h0; // thickness
    double [] dh; // thickness
    double [] hn; // thickness
    String [] hname;
    
    static String [] FILE_DESCRIPTION={"Text (*.txt)"};
    
    /**
     * Creates new form TransferMatrix3
     */
    public TransferMatrix3() {
        initComponents();
        setDefaultValues();
    }

    private void setDefaultValues() {
        jtWavelength.setText("");
        jtNr1.setText("");
        jtNr2.setText("");
        jtNi2.setText("");
        jtNr3.setText("");
        jtNr4.setText("");
        jtNi4.setText("");
        jtNr5.setText("");
        jtThickStart1.setText("");
        jtThickEnd1.setText("");
        jtThickStep1.setText("");
        jtThickStart2.setText("");
        jtThickEnd2.setText("");
        jtThickStep2.setText("");
        jtThickStart3.setText("");
        jtThickEnd3.setText("");
        jtThickStep3.setText("");
    }            

    public String setFullPathName(String filename) throws IOException {
        File currdir=new File(".");
        File file=new File(filename);
        String fname;
        if(filename.equals(file.getName()))
            fname=currdir.getCanonicalPath()+"/"+file.getName();
        else
            fname=filename;
        return fname;
    }

    public boolean saveData(String name) {
        BufferedWriter  fidw;
        try {
            String fname=setFullPathName(name);
            fidw=new BufferedWriter(new FileWriter(fname));
            fidw.write("#PLOT DATA\n");
            fidw.write(String.format("Plot type = %d\n",jcbPlotType.getSelectedIndex()));
            fidw.write("Wavelength (nm) = ");
            fidw.write(jtWavelength.getText());
            fidw.newLine();
            fidw.write(String.format("Polarization = %d\n",jcbPolarization.getSelectedIndex()));
            fidw.write("Refractive index of prism = ");
            fidw.write(jtNr1.getText());
            fidw.newLine();
            fidw.write("Refractive index of metal 1 (real part) = ");
            fidw.write(jtNr2.getText());
            fidw.newLine();
            fidw.write("Refractive index of metal 1 (imaginary part) = ");
            fidw.write(jtNi2.getText());
            fidw.newLine();
            fidw.write("Refractive index of waveguide = ");
            fidw.write(jtNr3.getText());
            fidw.newLine();
            fidw.write("Refractive index of metal 2 (real part) = ");
            fidw.write(jtNr4.getText());
            fidw.newLine();
            fidw.write("Refractive index of metal 2 (imaginary part) = ");
            fidw.write(jtNi4.getText());
            fidw.newLine();
            fidw.write("Refractive index of dielectric = ");
            fidw.write(jtNr5.getText());
            fidw.newLine();
            fidw.write("Metal 1 thickness start (nm) = ");
            fidw.write(jtThickStart1.getText());
            fidw.newLine();
            fidw.write("Metal 1 thickness end (nm) = ");
            fidw.write(jtThickEnd1.getText());
            fidw.newLine();
            fidw.write("Metal 1 thickness step (nm) = ");
            fidw.write(jtThickStep1.getText());
            fidw.newLine();
            fidw.write("Metal waveguide thickness start (nm) = ");
            fidw.write(jtThickStart2.getText());
            fidw.newLine();
            fidw.write("Metal waveguide thickness end (nm) = ");
            fidw.write(jtThickEnd2.getText());
            fidw.newLine();
            fidw.write("Metal waveguide thickness step (nm) = ");
            fidw.write(jtThickStep2.getText());
            fidw.newLine();
            fidw.write("Metal 2 thickness start (nm) = ");
            fidw.write(jtThickStart3.getText());
            fidw.newLine();
            fidw.write("Metal 2 thickness end (nm) = ");
            fidw.write(jtThickEnd3.getText());
            fidw.newLine();
            fidw.write("Metal 2 thickness step (nm) = ");
            fidw.write(jtThickStep3.getText());
            fidw.newLine();
            fidw.close();
            return true;
        }
        catch (IOException ie){
            return false;
        }        
    }   
    
    String getNextValue(BufferedReader fid) throws IOException {
        String [] parts = fid.readLine().split("=");
        return parts[1].trim();
    }    
    
    public boolean loadData(String name) {
        try {
            String fname = setFullPathName(name);
            FileReader fr=new FileReader(fname);
            
            BufferedReader fid=new BufferedReader(fr);
            String line;
            line = fid.readLine();
            if(!line.equals("#PLOT DATA")) {
                fid.close();
                return false;
            }
            jcbPlotType.setSelectedIndex(Integer.parseInt(getNextValue(fid)));
            jtWavelength.setText(getNextValue(fid));
            jcbPolarization.setSelectedIndex(Integer.parseInt(getNextValue(fid)));
            jtNr1.setText(getNextValue(fid));
            jtNr2.setText(getNextValue(fid));
            jtNi2.setText(getNextValue(fid));
            jtNr3.setText(getNextValue(fid));
            jtNr4.setText(getNextValue(fid));
            jtNi4.setText(getNextValue(fid));
            jtNr5.setText(getNextValue(fid));
            jtThickStart1.setText(getNextValue(fid));
            jtThickEnd1.setText(getNextValue(fid));
            jtThickStep1.setText(getNextValue(fid));
            jtThickStart2.setText(getNextValue(fid));
            jtThickEnd2.setText(getNextValue(fid));
            jtThickStep2.setText(getNextValue(fid));
            jtThickStart3.setText(getNextValue(fid));
            jtThickEnd3.setText(getNextValue(fid));
            jtThickStep3.setText(getNextValue(fid));
            fid.close();
            return true;
        }
        catch (IOException ie){            
            return false;
        }    
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtWavelength = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtNr1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtNr2 = new javax.swing.JTextField();
        jtNi2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtNr4 = new javax.swing.JTextField();
        jtNi4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtNr3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtNr5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtThickStart1 = new javax.swing.JTextField();
        jtThickEnd1 = new javax.swing.JTextField();
        jtThickStep1 = new javax.swing.JTextField();
        jtThickStart2 = new javax.swing.JTextField();
        jtThickEnd2 = new javax.swing.JTextField();
        jtThickStep2 = new javax.swing.JTextField();
        jtThickStart3 = new javax.swing.JTextField();
        jtThickEnd3 = new javax.swing.JTextField();
        jtThickStep3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcbPlotType = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jcbPolarization = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transfer Matrix 3");
        setMinimumSize(new java.awt.Dimension(600, 610));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setMinimumSize(new java.awt.Dimension(500, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Wavelength  (nm)");
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel1.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        jtWavelength.setText("jTextField1");
        jtWavelength.setMinimumSize(new java.awt.Dimension(80, 27));
        jtWavelength.setName(""); // NOI18N
        jtWavelength.setPreferredSize(new java.awt.Dimension(80, 27));
        jtWavelength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtWavelengthActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel4.add(jtWavelength, gridBagConstraints);
        jtWavelength.getAccessibleContext().setAccessibleName("");

        jPanel7.setPreferredSize(new java.awt.Dimension(65, 27));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7, new java.awt.GridBagConstraints());

        jPanel8.setPreferredSize(new java.awt.Dimension(80, 27));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 160));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 160));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Refractive Index of prism (nm)");
        jLabel2.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel2.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jtNr1.setText("jTextField1");
        jtNr1.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNr1.setName(""); // NOI18N
        jtNr1.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNr1, gridBagConstraints);
        jtNr1.getAccessibleContext().setAccessibleName("");

        jLabel3.setText("Dielectric Constant of Metal 1");
        jLabel3.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel3.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jtNr2.setText("jTextField1");
        jtNr2.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNr2.setName(""); // NOI18N
        jtNr2.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNr2, gridBagConstraints);
        jtNr2.getAccessibleContext().setAccessibleName("");

        jtNi2.setText("jTextField1");
        jtNi2.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNi2.setName(""); // NOI18N
        jtNi2.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNi2, gridBagConstraints);
        jtNi2.getAccessibleContext().setAccessibleName("");
        jtNi2.getAccessibleContext().setAccessibleDescription("");

        jLabel4.setText("Dielectric Constant of Metal 2");
        jLabel4.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel4.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jtNr4.setText("jTextField1");
        jtNr4.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNr4.setName(""); // NOI18N
        jtNr4.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNr4, gridBagConstraints);
        jtNr4.getAccessibleContext().setAccessibleName("");

        jtNi4.setText("jTextField1");
        jtNi4.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNi4.setName(""); // NOI18N
        jtNi4.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNi4, gridBagConstraints);
        jtNi4.getAccessibleContext().setAccessibleName("");

        jLabel5.setText("Dielectric Constant  of waveguide (nm)");
        jLabel5.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel5.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel5.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        jtNr3.setText("jTextField1");
        jtNr3.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNr3.setName(""); // NOI18N
        jtNr3.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNr3, gridBagConstraints);
        jtNr3.getAccessibleContext().setAccessibleName("");

        jLabel6.setText("Dielectric Constant of post metal 2 medium (nm)");
        jLabel6.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel6.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel6.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        jtNr5.setText("jTextField1");
        jtNr5.setMinimumSize(new java.awt.Dimension(80, 27));
        jtNr5.setName(""); // NOI18N
        jtNr5.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jtNr5, gridBagConstraints);
        jtNr5.getAccessibleContext().setAccessibleName("");

        jLabel11.setText("i");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 12);
        jPanel1.add(jLabel11, gridBagConstraints);

        jLabel13.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        jPanel1.add(jLabel13, gridBagConstraints);

        jLabel14.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        jPanel1.add(jLabel14, gridBagConstraints);

        jLabel12.setText("i");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 12);
        jPanel1.add(jLabel12, gridBagConstraints);

        getContentPane().add(jPanel1);

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel13.setPreferredSize(new java.awt.Dimension(500, 111));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel16.setText("Start");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel13.add(jLabel16, gridBagConstraints);

        jLabel17.setText("End");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel13.add(jLabel17, gridBagConstraints);

        jLabel18.setText("Step");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel13.add(jLabel18, gridBagConstraints);

        jtThickStart1.setText("jTextField1");
        jtThickStart1.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickStart1.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickStart1.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel13.add(jtThickStart1, gridBagConstraints);

        jtThickEnd1.setText("jTextField2");
        jtThickEnd1.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickEnd1.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickEnd1.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel13.add(jtThickEnd1, gridBagConstraints);

        jtThickStep1.setText("jTextField3");
        jtThickStep1.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickStep1.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickStep1.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel13.add(jtThickStep1, gridBagConstraints);

        jtThickStart2.setText("jTextField1");
        jtThickStart2.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickStart2.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickStart2.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel13.add(jtThickStart2, gridBagConstraints);

        jtThickEnd2.setText("jTextField2");
        jtThickEnd2.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickEnd2.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickEnd2.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        jPanel13.add(jtThickEnd2, gridBagConstraints);

        jtThickStep2.setText("jTextField3");
        jtThickStep2.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickStep2.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickStep2.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        jPanel13.add(jtThickStep2, gridBagConstraints);

        jtThickStart3.setText("jTextField1");
        jtThickStart3.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickStart3.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickStart3.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel13.add(jtThickStart3, gridBagConstraints);

        jtThickEnd3.setText("jTextField2");
        jtThickEnd3.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickEnd3.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickEnd3.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel13.add(jtThickEnd3, gridBagConstraints);

        jtThickStep3.setText("jTextField3");
        jtThickStep3.setMaximumSize(new java.awt.Dimension(80, 27));
        jtThickStep3.setMinimumSize(new java.awt.Dimension(80, 27));
        jtThickStep3.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel13.add(jtThickStep3, gridBagConstraints);

        jLabel19.setText("Metal 1 thickness");
        jLabel19.setMaximumSize(new java.awt.Dimension(250, 17));
        jLabel19.setMinimumSize(new java.awt.Dimension(250, 17));
        jLabel19.setPreferredSize(new java.awt.Dimension(300, 17));
        jLabel19.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel13.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Metal waveguide thickness");
        jLabel20.setMaximumSize(new java.awt.Dimension(250, 17));
        jLabel20.setMinimumSize(new java.awt.Dimension(250, 17));
        jLabel20.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel13.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Metal 2 thickness");
        jLabel21.setMaximumSize(new java.awt.Dimension(250, 17));
        jLabel21.setMinimumSize(new java.awt.Dimension(250, 17));
        jLabel21.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanel13.add(jLabel21, gridBagConstraints);

        getContentPane().add(jPanel13);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setMinimumSize(new java.awt.Dimension(500, 70));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 70));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Plot type:");
        jLabel7.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel7.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel7.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        jPanel3.add(jLabel7, gridBagConstraints);

        jcbPlotType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reflection", "Transmission", "Absorbtion" }));
        jcbPlotType.setMinimumSize(new java.awt.Dimension(150, 27));
        jcbPlotType.setName(""); // NOI18N
        jcbPlotType.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(jcbPlotType, gridBagConstraints);
        jcbPlotType.getAccessibleContext().setAccessibleName("");

        jLabel15.setText("Polarization:");
        jLabel15.setMaximumSize(new java.awt.Dimension(300, 17));
        jLabel15.setMinimumSize(new java.awt.Dimension(300, 17));
        jLabel15.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        jPanel3.add(jLabel15, gridBagConstraints);

        jcbPolarization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "s", "p" }));
        jcbPolarization.setMinimumSize(new java.awt.Dimension(50, 27));
        jcbPolarization.setName(""); // NOI18N
        jcbPolarization.setPreferredSize(new java.awt.Dimension(80, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(jcbPolarization, gridBagConstraints);
        jcbPolarization.getAccessibleContext().setAccessibleName("");

        jPanel11.setPreferredSize(new java.awt.Dimension(70, 27));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel11, new java.awt.GridBagConstraints());

        jPanel12.setPreferredSize(new java.awt.Dimension(10, 27));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel12, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel3);

        jPanel6.setMinimumSize(new java.awt.Dimension(500, 30));
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Plot");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new java.awt.GridBagConstraints());
        jButton1.getAccessibleContext().setAccessibleName("jbPlot");

        getContentPane().add(jPanel6);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Load values");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save values");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String filename=null;
        JFileChooser loadDlg=new JFileChooser();
        String stype="txt";
        loadDlg.setMultiSelectionEnabled(false);
        loadDlg.setCurrentDirectory(new File("."));
        loadDlg.addChoosableFileFilter(new myFileFilter(stype,"Text (*.txt)"));
        int opc=loadDlg.showOpenDialog(this);
        if(opc==JFileChooser.APPROVE_OPTION) {
            filename=loadDlg.getSelectedFile().getName();
            if(filename!=null) {
                filename=loadDlg.getSelectedFile().getAbsolutePath();                     
            }
        }
        if(filename!=null) {
            if(!loadData(filename))
                JOptionPane.showMessageDialog(this,
                        "File \""+loadDlg.getSelectedFile().getName()+"\" is not a valid plot data file!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public boolean validateInputs() {
        type = jcbPlotType.getSelectedIndex();
        try {
            lambda = Double.parseDouble(jtWavelength.getText());      // vacuum wavelength (nm)
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid wavelength!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        pol = jcbPolarization.getSelectedIndex();            //polarization, 1 for p and 0 for s
        double nr1, nr2, ni2, nr3, nr4, ni4, nr5;
        try {
            nr1 = Double.parseDouble(jtNr1.getText());
            if (nr1 == 0.0) {
                JOptionPane.showMessageDialog(this,
                        "Invalid refractive index of prism!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;                
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid refractive index of prism!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            nr2 = Double.parseDouble(jtNr2.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid real refractive index of metal 1!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            ni2 = Double.parseDouble(jtNi2.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid imaginary refractive index of metal 1!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            nr3 = Double.parseDouble(jtNr3.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid refractive index of waveguide!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            nr4 = Double.parseDouble(jtNr4.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid real refractive index of metal 2!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            ni4 = Double.parseDouble(jtNi4.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid imaginary refractive index of metal 2!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            nr5 = Double.parseDouble(jtNr5.getText());
            if (nr5 == 0.0) {
                JOptionPane.showMessageDialog(this,
                        "Invalid refractive index of dielectric!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;                
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid refractive index of dielectric!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int count = 2;
        count += (nr2 != 0.0)? 1 : 0;
        count += (nr3 != 0.0)? 1 : 0;
        count += (nr4 != 0.0)? 1 : 0;

        n = new Complex[count]; //refractive index data
        int i = 0;
        n[i++] = new Complex(nr1);
        if (nr2 != 0.0)
            n[i++] = Complex.sqrt(new Complex(nr2,ni2));
        if (nr3 != 0.0)
            n[i++] = new Complex(nr3);
        if (nr4 != 0.0)
            n[i++] = Complex.sqrt(new Complex(nr4,ni4));
        n[i++] = new Complex(nr5);
        
        
        double [] thickStart = new double[3];
        double [] thickEnd = new double[3];
        double [] thickStep = new double[3];
        
        try {
            thickStart[0] = Double.parseDouble(jtThickStart1.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal 1 thickness start value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickEnd[0] = Double.parseDouble(jtThickEnd1.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal 1 thickness end value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickStep[0] = Double.parseDouble(jtThickStep1.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal 1 thickness step value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickStart[1] = Double.parseDouble(jtThickStart2.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal waveguide thickness start value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickEnd[1] = Double.parseDouble(jtThickEnd2.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal waveguide thickness end value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickStep[1] = Double.parseDouble(jtThickStep2.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal waveguide thickness step value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickStart[2] = Double.parseDouble(jtThickStart3.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal 2 thickness start value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickEnd[2] = Double.parseDouble(jtThickEnd3.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal 2 thickness end value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            thickStep[2] = Double.parseDouble(jtThickStep3.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid metal 2 thickness step value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        h0 = new double[count]; //thickess
        dh = new double[count]; //thickess
        hn = new double[count]; //thickess
        hname = new String[count];
        i = 0;
        h0[i++] = -1;
        if (nr2 != 0.0) {
            h0[i] = thickStart[0];
            dh[i] = thickStep[0];
            hn[i] = thickEnd[0];
            hname[i++] = "M1";
        }
        if (nr3 != 0.0) {
            h0[i] = thickStart[1];
            dh[i] = thickStep[1];
            hn[i] = thickEnd[1];
            hname[i++] = "WG";
        }
        if (nr4 != 0.0) {
            h0[i] = thickStart[2];
            dh[i] = thickStep[2];
            hn[i] = thickEnd[2];
            hname[i++] = "M2";
        }
        h0[i++] = -1;

        return true;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(validateInputs()) {
            Optics op = new Optics();
            op.plot(this);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtWavelengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtWavelengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtWavelengthActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(validateInputs()) {
            JFileChooser saveDlg=new JFileChooser();
            String stype="txt";
            saveDlg.setMultiSelectionEnabled(false);
            saveDlg.setCurrentDirectory(new File("."));
            saveDlg.addChoosableFileFilter(new myFileFilter(stype,"Text (*.txt)"));
            int opc=saveDlg.showSaveDialog(this);
            if(opc==JFileChooser.APPROVE_OPTION) {
                String filename=saveDlg.getSelectedFile().getName();
                if(filename!=null) {
                    filename=saveDlg.getSelectedFile().getAbsolutePath();
                    if(!filename.endsWith(".txt")) 
                        filename=filename.concat(".txt");                     
                    saveData(filename);
                }
            }        
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransferMatrix3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferMatrix3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferMatrix3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferMatrix3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransferMatrix3 gui = new TransferMatrix3();
                gui.pack();
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JComboBox<String> jcbPlotType;
    private javax.swing.JComboBox<String> jcbPolarization;
    private javax.swing.JTextField jtNi2;
    private javax.swing.JTextField jtNi4;
    private javax.swing.JTextField jtNr1;
    private javax.swing.JTextField jtNr2;
    private javax.swing.JTextField jtNr3;
    private javax.swing.JTextField jtNr4;
    private javax.swing.JTextField jtNr5;
    private javax.swing.JTextField jtThickEnd1;
    private javax.swing.JTextField jtThickEnd2;
    private javax.swing.JTextField jtThickEnd3;
    private javax.swing.JTextField jtThickStart1;
    private javax.swing.JTextField jtThickStart2;
    private javax.swing.JTextField jtThickStart3;
    private javax.swing.JTextField jtThickStep1;
    private javax.swing.JTextField jtThickStep2;
    private javax.swing.JTextField jtThickStep3;
    private javax.swing.JTextField jtWavelength;
    // End of variables declaration//GEN-END:variables
}
