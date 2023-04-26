
package com.ayseozcan.gui;

import com.ayseozcan.entity.User;
import com.ayseozcan.service.UserService;
import javax.swing.JOptionPane;


public class FrmRegister extends javax.swing.JFrame {

    private UserService userService;
    /**
     * Creates new form FrmRegister
     */
    public FrmRegister() {
        initComponents();
        lblerror.setVisible(false);
        userService = new UserService();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRePassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnUyeOl = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yeni Üyelik");

        jLabel1.setText("Kullanıcı Adı");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setText("Şifre");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        jLabel3.setText("Şifre Doğrulama");

        txtRePassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtRePassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRePasswordKeyReleased(evt);
            }
        });

        jLabel4.setText("E-Posta");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnUyeOl.setText("Üye Ol");
        btnUyeOl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeOl(evt);
            }
        });

        lblerror.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 51, 51));
        lblerror.setText("şifreler uyuşmuyor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                        .addComponent(txtPassword)
                        .addComponent(txtRePassword)
                        .addComponent(txtEmail)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnUyeOl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblerror))
                .addGap(18, 18, 18)
                .addComponent(txtRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnUyeOl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uyeOl(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeOl
        if(txtUsername.getText().isEmpty() || 
                txtEmail.getText().isEmpty() ||
                txtPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Lütfen tüm alanları doldurunuz.");
            return;
        }else if(!txtPassword.getText().toString().equals(txtRePassword.getText().toString())){
            JOptionPane.showMessageDialog(rootPane, "Girdiğiniz şifreler uyuşmamaktadır.");
            return;
        }
        String username = txtUsername.getText();
        String pwd = txtPassword.getText();
        String email = txtEmail.getText();
       
        User user = new User(null, username, pwd, email);
        userService.save(user);
        JOptionPane.showMessageDialog(rootPane, "Yeni üyelik kaydınız başarı ile alınmıştır.");
        txtEmail.setText("");
        txtPassword.setText("");
        txtRePassword.setText("");
        txtUsername.setText("");
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        this.dispose();
            
    }//GEN-LAST:event_uyeOl

    private void kontrolEt(){
        if(
                !txtPassword.getText().toString().equals(txtRePassword.getText().toString())
                && !txtPassword.getText().isEmpty()
                && !txtRePassword.getText().isEmpty()
                )
            lblerror.setVisible(true);
        else
            lblerror.setVisible(false);
    }
    
    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        kontrolEt();
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtRePasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRePasswordKeyReleased
        kontrolEt();
    }//GEN-LAST:event_txtRePasswordKeyReleased

    
    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUyeOl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblerror;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRePassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
