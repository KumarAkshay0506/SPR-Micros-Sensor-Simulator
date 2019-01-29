package transfermatrix3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PlotDialog extends javax.swing.JDialog {
    Plot plot;
    
    /**
     * Creates new form PlotDialog
     */
    public PlotDialog(String title, String subtitle, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        plot=new Plot();
        plot.setBackground(Color.WHITE);
        plot.setOpaque(true);
        plot.setSize(400,400);
        plot.setWindowSize(0,0,jpPlot.getWidth(),jpPlot.getHeight());
        plot.setWorldSize(0,0,90,1);
        plot.setXTicks(9);
        plot.setYTicks(10);
        plot.setXLabel("Incident angle (degrees)");
        plot.setYLabel("Fresnel coefficient");
        plot.setTitle(title);
        plot.setSubtitle(subtitle);
        jpPlot.add(plot,BorderLayout.CENTER);        
    }

    public void plot(ArrayList X,ArrayList Y,String name) {
        if (name.isEmpty())
            plot.showLegend(false);
        plot.addPlot(X,Y,name);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpPlot = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Plot");
        setModal(true);
        setResizable(false);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("OK");
        jButton1.setPreferredSize(new java.awt.Dimension(60, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new java.awt.GridBagConstraints());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpPlot.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpPlot.setMinimumSize(new java.awt.Dimension(400, 400));
        jpPlot.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jpPlotLayout = new javax.swing.GroupLayout(jpPlot);
        jpPlot.setLayout(jpPlotLayout);
        jpPlotLayout.setHorizontalGroup(
            jpPlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPlotLayout.setVerticalGroup(
            jpPlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlot, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Save as image");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save as text");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser saveDlg=new JFileChooser();
        String stype="png";
        saveDlg.setMultiSelectionEnabled(false);
        saveDlg.setCurrentDirectory(new File("."));
        saveDlg.addChoosableFileFilter(new myFileFilter(stype,"Png Image (*.png)"));
        saveDlg.setAcceptAllFileFilterUsed(false);
        int opc=saveDlg.showSaveDialog(this);
        if(opc==JFileChooser.APPROVE_OPTION) {
            String filename=saveDlg.getSelectedFile().getName();
            if(filename!=null) {
                filename=saveDlg.getSelectedFile().getAbsolutePath();
                if(!filename.endsWith(".png")) 
                    filename=filename.concat(".png");                     
                plot.save(filename);
            }
        }        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser saveDlg=new JFileChooser();
        String stype="txt";
        saveDlg.setMultiSelectionEnabled(false);
        saveDlg.setCurrentDirectory(new File("."));
        saveDlg.addChoosableFileFilter(new myFileFilter(stype,"Text (*.txt)"));
        saveDlg.setAcceptAllFileFilterUsed(false);
        int opc=saveDlg.showSaveDialog(this);
        if(opc==JFileChooser.APPROVE_OPTION) {
            String filename=saveDlg.getSelectedFile().getName();
            if(filename!=null) {
                filename=saveDlg.getSelectedFile().getAbsolutePath();
                if(!filename.endsWith(".txt")) 
                    filename=filename.concat(".txt");                     
                plot.saveText(filename);
            }
        }        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpPlot;
    // End of variables declaration//GEN-END:variables
}
