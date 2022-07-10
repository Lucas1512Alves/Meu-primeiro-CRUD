
package view;

import dao.Daopassageiro;
import java.util.Date;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import model.Passageiro;
//import util.DateUtil;
import util.EntityManagerUtil;


public class PassageiroForm extends javax.swing.JDialog {
    
    private boolean isNovoPassageiro;
    private Daopassageiro  passageiroDao = new Daopassageiro(EntityManagerUtil.getEntityManagerFactory());
    private Passageiro passageiro;
    
    
    private Passageiro findByIdPassageiro(int passageiroId){
        return this.passageiroDao.findPassageiro(passageiroId);
    }
    
    
    // construtor utilizado para criar novo produto //
    public PassageiroForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.isNovoPassageiro = true;
        
        this.passageiro = new Passageiro();
    }

    
    /* construtor para atualizar produto */
    public PassageiroForm(java.awt.Frame parent, boolean modal, int passageiroId) {
        super(parent, modal);
        initComponents();
        this.isNovoPassageiro = false;
        
        passageiro = this.findByIdPassageiro(passageiroId);
        
        this.jName.setText(this.passageiro.getNome());
        this.jCPF.setText(this.passageiro.getCpf());
        this.jEmail.setText(this.passageiro.getEmail());
         this.tTextoCódigo.setValue(this.passageiro.getCodpassageiro());
        
        //this.tDataNascimento.setValue(
              // DateUtil.dateToJFormattedFieldDate(
                     //  DateUtil.integerToDate(this.passageiro.getDtnascimento())));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jName = new javax.swing.JLabel();
        tTextoName = new javax.swing.JTextField();
        jCPF = new javax.swing.JLabel();
        tTextoCPF = new javax.swing.JTextField();
        jEmail = new javax.swing.JLabel();
        tTextoEmail = new javax.swing.JTextField();
        jEndereco = new javax.swing.JLabel();
        tTextoEndereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tTextoCelular = new javax.swing.JTextField();
        bCancelar = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        jCódigo = new javax.swing.JLabel();
        tTextoCódigo = new javax.swing.JFormattedTextField();

        jName.setText("Nome:");

        jCPF.setText("CPF:");

        jEmail.setText("E-mail:");

        jEndereco.setText("Endereço");

        jLabel1.setText("Celular:");

        bCancelar.setBackground(new java.awt.Color(255, 0, 0));
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bLimpar.setBackground(new java.awt.Color(0, 255, 255));
        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bSalvar.setBackground(new java.awt.Color(102, 255, 102));
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        jCódigo.setText("Código:");

        tTextoCódigo.setEditable(false);
        tTextoCódigo.setColumns(5);
        tTextoCódigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tTextoCódigo.setHorizontalAlignment(javax.swing.JFormattedTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTextoName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTextoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTextoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jCódigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tTextoCódigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTextoEndereco)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTextoEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tTextoName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jName)
                        .addComponent(jCPF)
                        .addComponent(tTextoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tTextoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCódigo)
                    .addComponent(tTextoCódigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEndereco)
                    .addComponent(tTextoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEmail)
                    .addComponent(tTextoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
   
    
    //método para cancelar
    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    
    /* CLEAR */
    /* método utilizado para limpar as os inputs do formulário */
    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        this.tTextoName.setText("");
        //this.tDataNascimento.setValue(0);
        this.tTextoCPF.setText("");
        this.tTextoEmail.setText("");
        this.tTextoEndereco.setText("");
    }//GEN-LAST:event_bLimparActionPerformed

    
    /* CREATE OR UPDATE */
    /* método utilizado para atualizar ou salvar o produto */
    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        this.passageiro.setNome(this.tTextoName.getText());
        this.passageiro.setCpf(this.tTextoCPF.getText());
        this.passageiro.setEmail(this.tTextoEmail.getText());
        //this.passageiro.setDtnascimento(DateUtil.dateToInteger((Date) this.tDataNascimento.getValue()));
        this.passageiro.setEndereco(this.tTextoEndereco.getText());
        this.passageiro.setNumerocell(this.tTextoCelular.getText());
        
        /* chama o serviço de persistência */
        if(this.isNovoPassageiro){
            this.passageiroDao.create(passageiro);
        }else {
            this.passageiroDao.edit(passageiro);
        }
         JOptionPane.showMessageDialog(null, "Passageiro atualizado com sucesso!");
        dispose(); /* fecha o JDialog */
    }//GEN-LAST:event_bSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCancelar;
    public javax.swing.JButton bLimpar;
    public javax.swing.JButton bSalvar;
    private javax.swing.JLabel jCPF;
    private javax.swing.JLabel jCódigo;
    private javax.swing.JLabel jEmail;
    private javax.swing.JLabel jEndereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jName;
    private javax.swing.JTextField tTextoCPF;
    private javax.swing.JTextField tTextoCelular;
    private javax.swing.JFormattedTextField tTextoCódigo;
    private javax.swing.JTextField tTextoEmail;
    private javax.swing.JTextField tTextoEndereco;
    private javax.swing.JTextField tTextoName;
    // End of variables declaration//GEN-END:variables
}
