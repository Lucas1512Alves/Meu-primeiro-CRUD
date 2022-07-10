package view;

import dao.Daopassageiro;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Passageiro;
import util.EntityManagerUtil;

public class ListaPassageiro extends javax.swing.JFrame {

    Daopassageiro passageirodao  = new Daopassageiro(EntityManagerUtil.getEntityManagerFactory());
   
     /* utilizado como modelo da JTable */
    String col[] = {"CodPassageiro", "Nome", "CPF", "NumeroCell"};
    DefaultTableModel tableModel = new DefaultTableModel(col,0){
    
            /* necessário para não serem permitidas alterações no conteúdo das células das tabelas */
            @Override
            public boolean isCellEditable(int row, int column) {
                //todas as células falsas
                return false;
            }
        };
        
        public ListaPassageiro() {
        initComponents(); 
        this.jTable1.setModel(tableModel);
        this.findAllPassageiro();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bRemoverPassageiro = new javax.swing.JButton();
        bNovoPassageiro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CodPassageiro", "Nome", "CPF", "NumeroCell"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        bRemoverPassageiro.setText("Remover Passageiro");
        bRemoverPassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverPassageiroActionPerformed(evt);
            }
        });

        bNovoPassageiro.setText("Novo Passageiro");
        bNovoPassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoPassageiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bNovoPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(bRemoverPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bNovoPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRemoverPassageiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoPassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoPassageiroActionPerformed
        PassageiroForm passageiroForm = new PassageiroForm(this, true);
        passageiroForm.setVisible(true);

        this.findAllPassageiro();
    }//GEN-LAST:event_bNovoPassageiroActionPerformed
 
    /* REMOVE */
    private void bRemoverPassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverPassageiroActionPerformed
         
        /* JOptionPane é utilizado para confirmar a operação */
        int opcao = JOptionPane.showConfirmDialog(null, "Certeza que deseja excluir o(s) passageiro(os) selecionado(os)?");
        
        if (opcao == JOptionPane.YES_OPTION) {
        
            /* Recupera os índices de todas as linhas selecionadas */
            int indices[] = this.jTable1.getSelectedRows();
            
            /* Itera sobre a lista de índices */
            /* Como existe uma operação de remove, a iteração deve acontecer do fim para o início */
           for (int i = indices.length - 1; i>= 0; i--) {
               int idPassageiroAserRemovido = (int) this.tableModel.getValueAt(indices[i],0);
               this.passageirodao.destroy(idPassageiroAserRemovido);
           }
           this.findAllPassageiro();
    }
    }//GEN-LAST:event_bRemoverPassageiroActionPerformed

     
    
         /* UPDATE */
    /* método utilizado para atualizar objeto da lista */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) { 
        if (evt.getClickCount() == 2) {    //Para detectar eventos de clique duplo
            int row = ((JTable)evt.getSource()).getSelectedRow(); // recupera a linha selecionada
            
            int produtoId = (int) this.tableModel.getValueAt(row, 0);
            
            PassageiroForm passageiroForm = new PassageiroForm(this, true, produtoId);
            passageiroForm.setVisible(true);
            
            this.findAllPassageiro();
        }
    }
    
    /* LIST */
    /* método utilizado para recuperar todos os produtos do banco de adicionar na tabela do Form */
    private void findAllPassageiro(){
        //Limpa a tabela
        for(int i = this.tableModel.getRowCount() - 1; i >= 0; i--){
            this.tableModel.removeRow(i);
        }
        
        //Adiciona os itens novamente (lista Atualizada)
        for(Passageiro passageiroRecuperado: this.passageirodao.findAllPassageiro()){
            Object[] passageiroAserAdicionado = {
                passageiroRecuperado.getCodpassageiro(), 
                passageiroRecuperado.getNome(), 
                passageiroRecuperado.getCpf(), 
                passageiroRecuperado.getNumerocell()
            };
            
            this.tableModel.addRow(passageiroAserAdicionado);
        }
    }
    
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bNovoPassageiro;
    public javax.swing.JButton bRemoverPassageiro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
