package com.ayseozcan.gui;

import com.ayseozcan.entity.Musteri;
import com.ayseozcan.service.MusteriService;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainPage extends javax.swing.JFrame {

    private MusteriService musteriService;

    public MainPage() {
        initComponents();
        musteriService = new MusteriService();
        listele(null);
    }

    private void tabloTemizle() {

        DefaultTableModel dtm = (DefaultTableModel) tabloMusteri.getModel();
        dtm.getDataVector().removeAllElements();
        tabloMusteri.repaint();
    }

    private void tabloSatirEkle() {

        DefaultTableModel dtm = (DefaultTableModel) tabloMusteri.getModel();
        dtm.setRowCount(dtm.getRowCount() + 1);
        tabloMusteri.repaint();
    }

    public void listele(List<Musteri> mlist) {
        musteriService = new MusteriService();
        
        /**
         * servis katmani araciligiyla tum musteri listesini cekiyoruz
         */
        if (mlist == null)
        {
            mlist = musteriService.findAll();
        }
        /**
         * Müşteri listeniz içinde müşterileri tek tek çekiyor ve bilgilerini
         * tablo içine ekliyoruz.
         */
        tabloTemizle();
        for (int i = 0; i < mlist.size(); i++)
        {
            tabloSatirEkle();
            tabloMusteri.setValueAt(mlist.get(i).getId(), i, 0);
            tabloMusteri.setValueAt(mlist.get(i).getAd(), i, 1);
            tabloMusteri.setValueAt(mlist.get(i).getTelefon(), i, 2);
            tabloMusteri.setValueAt(mlist.get(i).getCinsiyet(), i, 3);
            tabloMusteri.setValueAt(mlist.get(i).getAdres(), i, 4);
        }

    }

    private void atomicListele() {
        List<Musteri> mlist = musteriService.findAll();
        AtomicInteger i = new AtomicInteger(0);
        //for(int i=0;i<mlist.size();i++){}
        //for(Musteri mst : mlist){}
        /**
         * bu asenkron çalışır bu nedenle burada primitive data type
         * kullanamazsınız.
         *
         */
        mlist.forEach(mst ->
        {
            tabloMusteri.setValueAt(mst.getId(), i.get(), 0);
            tabloMusteri.setValueAt(mst.getAd(), i.get(), 1);
            tabloMusteri.setValueAt(mst.getTelefon(), i.get(), 2);
            tabloMusteri.setValueAt(mst.getCinsiyet(), i.get(), 3);
            tabloMusteri.setValueAt(mst.getAdres(), i.get(), 4);
            i.incrementAndGet();
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IslemlerPopup = new javax.swing.JPopupMenu();
        btnDüzenle = new javax.swing.JMenuItem();
        btnSil = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Seç = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbCinsiyet = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdres = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btnYeniKayit = new javax.swing.JButton();
        btnKaydet = new javax.swing.JButton();
        btnIptal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabloMusteri = new javax.swing.JTable();
        txtAramaAd = new javax.swing.JTextField();
        txtAramaTelefon = new javax.swing.JTextField();
        txtAramaAdres = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        btnDüzenle.setText("Düzenle");
        btnDüzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDüzenleActionPerformed(evt);
            }
        });
        IslemlerPopup.add(btnDüzenle);

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        IslemlerPopup.add(btnSil);
        IslemlerPopup.add(jSeparator1);

        Seç.setText("Seç");
        IslemlerPopup.add(Seç);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Müşteri İşlemleri Formu");

        jLabel1.setText("Id");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.setEnabled(false);

        jLabel2.setText("Ad");

        txtAd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAd.setEnabled(false);

        jLabel3.setText("Cinsiyet");

        cmbCinsiyet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCinsiyet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erkek", "Kadın", "Belirtmek İstemiyor" }));
        cmbCinsiyet.setEnabled(false);

        jLabel4.setText("Adres");

        txtAdres.setColumns(20);
        txtAdres.setRows(5);
        txtAdres.setEnabled(false);
        jScrollPane1.setViewportView(txtAdres);

        jLabel5.setText("Telefon");

        try {
            txtTelefon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0(###)-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefon.setEnabled(false);
        txtTelefon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnYeniKayit.setText("Yeni Kayıt");
        btnYeniKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniKayitActionPerformed(evt);
            }
        });

        btnKaydet.setText("Kaydet");
        btnKaydet.setEnabled(false);
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        btnIptal.setText("İptal");
        btnIptal.setEnabled(false);
        btnIptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIptalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefon)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(123, 123, 123)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCinsiyet, 0, 192, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnYeniKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIptal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKaydet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnYeniKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnIptal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        tabloMusteri.setBackground(new java.awt.Color(192, 219, 234));
        tabloMusteri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Müşteri Ad Soyad", "Telefon", "Cinsiyet", "Adres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabloMusteri.setComponentPopupMenu(IslemlerPopup);
        tabloMusteri.setGridColor(new java.awt.Color(204, 204, 204));
        tabloMusteri.setShowGrid(true);
        jScrollPane2.setViewportView(tabloMusteri);
        if (tabloMusteri.getColumnModel().getColumnCount() > 0) {
            tabloMusteri.getColumnModel().getColumn(0).setResizable(false);
            tabloMusteri.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabloMusteri.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabloMusteri.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabloMusteri.getColumnModel().getColumn(3).setPreferredWidth(40);
            tabloMusteri.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        txtAramaAd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAramaAd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAramaAdKeyReleased(evt);
            }
        });

        txtAramaTelefon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAramaTelefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAramaTelefonKeyReleased(evt);
            }
        });

        txtAramaAdres.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAramaAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAramaAdresKeyReleased(evt);
            }
        });

        jMenu1.setText("Müşteri İşlemleri");

        jMenuItem1.setText("Müşteri Ekle");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenu6.setText("Müşteri Raporları");

        jMenuItem2.setText("Müşteri Listei");
        jMenu6.add(jMenuItem2);

        jMenuItem3.setText("Silinmiş Müşteri Listesi");
        jMenu6.add(jMenuItem3);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Yönetim Paneli");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("|");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Diğer");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("İletişim");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(txtAramaAd, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAramaTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(txtAramaAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAramaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAramaTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAramaAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed

        String id = txtId.getText();
        String ad = txtAd.getText();
        String adres = txtAdres.getText();
        String cinsiyet = cmbCinsiyet.getSelectedItem().toString();
        String telefon = txtTelefon.getText();
        if (ad.isEmpty() || adres.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Gerekli alanları doldurunuz.");
            return;
        }

        if (txtId.getText().isEmpty())
        {
            Musteri musteri = new Musteri(ad, adres, telefon, "", cinsiyet, 1);
            musteriService.save(musteri);
            JOptionPane.showMessageDialog(rootPane, "Müşteri kayıt işlemi tamamlandı.");
         
        }else{

            Musteri musteri = new Musteri(Long.valueOf(id), ad, adres, telefon, "", cinsiyet, 1);
            musteriService.update(musteri);
            JOptionPane.showMessageDialog(rootPane, "Müşteri güncelleme işlemi tamamlandı.");
        }

        listele(null);
        acKapat(false);

    }//GEN-LAST:event_btnKaydetActionPerformed

    private void btnYeniKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniKayitActionPerformed
        txtAd.setText("");
        txtAdres.setText("");
        txtTelefon.setText("");
        txtId.setText("");
        acKapat(true);
    }//GEN-LAST:event_btnYeniKayitActionPerformed

    private void btnIptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIptalActionPerformed
        acKapat(false);
    }//GEN-LAST:event_btnIptalActionPerformed

    private void txtAramaAdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaAdKeyReleased
        String arananDeger = txtAramaAd.getText();
        String telefon = txtAramaTelefon.getText();
        Musteri mst = new Musteri();
        mst.setAd(arananDeger);
        if (!telefon.isEmpty())
        {
            mst.setTelefon(telefon);
        }
        mst.setState(1);
        List<Musteri> mlist = musteriService.findByEtntity(mst);
        listele(mlist);
    }//GEN-LAST:event_txtAramaAdKeyReleased

    private void txtAramaTelefonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaTelefonKeyReleased
        String arananDeger = txtAramaTelefon.getText();
        String ad = txtAramaAd.getText();
        Musteri mst = new Musteri();
        mst.setTelefon(arananDeger);
        //eger iki alani da aramaya dahil edersek:
        if (!ad.isEmpty())
        {
            mst.setAd(ad);
        }
        mst.setState(1);
        List<Musteri> mlist = musteriService.findByEtntity(mst);
        listele(mlist);
    }//GEN-LAST:event_txtAramaTelefonKeyReleased

    private void txtAramaAdresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaAdresKeyReleased
        String arananDeger = txtAramaAdres.getText();
        Musteri mst = new Musteri();
        mst.setAdres(arananDeger);
        mst.setState(1);
        List<Musteri> mlist = musteriService.findByEtntity(mst);
        listele(mlist);
    }//GEN-LAST:event_txtAramaAdresKeyReleased

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        int selectRow = tabloMusteri.getSelectedRow();
        if (selectRow == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "once bir satir seciniz");
        } else
        {
            int secim = JOptionPane.showConfirmDialog(rootPane, "silmek istediginize emin misiniz?", "!!Kayit Silme!!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (secim == JOptionPane.YES_OPTION)
            {
                Long id = (Long) tabloMusteri.getValueAt(selectRow, 0);
                musteriService.delete(id);
                listele(null);
            } else
            {
                JOptionPane.showMessageDialog(rootPane, "silme islemi iptal edildi");
            }

        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnDüzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDüzenleActionPerformed
        int selectRow = tabloMusteri.getSelectedRow();
        txtId.setText(tabloMusteri.getValueAt(selectRow, 0).toString());
        txtAd.setText(tabloMusteri.getValueAt(selectRow, 1).toString());
        txtAdres.setText(tabloMusteri.getValueAt(selectRow, 4).toString());
        txtTelefon.setText(tabloMusteri.getValueAt(selectRow, 2).toString());
        cmbCinsiyet.setSelectedItem(tabloMusteri.getValueAt(selectRow, 3) == null ? "Erkek": tabloMusteri.getValueAt(selectRow, 3).toString());
        acKapat(true);
    }//GEN-LAST:event_btnDüzenleActionPerformed


    public void acKapat(boolean isTrue) {
        btnYeniKayit.setEnabled(!isTrue);
        btnKaydet.setEnabled(isTrue);
        btnIptal.setEnabled(isTrue);
        txtAd.setEnabled(isTrue);
        txtAdres.setEnabled(isTrue);
        txtTelefon.setEnabled(isTrue);
        cmbCinsiyet.setEnabled(isTrue);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu IslemlerPopup;
    private javax.swing.JMenuItem Seç;
    private javax.swing.JMenuItem btnDüzenle;
    private javax.swing.JButton btnIptal;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JMenuItem btnSil;
    private javax.swing.JButton btnYeniKayit;
    private javax.swing.JComboBox<String> cmbCinsiyet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabloMusteri;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextArea txtAdres;
    private javax.swing.JTextField txtAramaAd;
    private javax.swing.JTextField txtAramaAdres;
    private javax.swing.JTextField txtAramaTelefon;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
