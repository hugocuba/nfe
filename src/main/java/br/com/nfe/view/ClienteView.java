/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.view;

import br.com.nfe.controller.ClienteController;
import br.com.nfe.dao.PaisDAO;
import br.com.nfe.model.Cliente;
import br.com.nfe.model.Endereco;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Fisica;
import br.com.nfe.model.Juridica;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Pais;
import br.com.nfe.model.Sessao;
import br.com.nfe.model.Telefone;
import static br.com.nfe.utils.DocumentsValidation.validaCNPJ;
import static br.com.nfe.utils.DocumentsValidation.validaCpf;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author a1502778
 */
public class ClienteView extends javax.swing.JFrame {

    Sessao sessao = Sessao.getInstance();
    Cliente cliente;

    /**
     * Creates new form Cliente
     */
    public ClienteView() {
        initComponents();
        liberarCampos(false);
        btNovo.setEnabled(true);
        btSalvar.setEnabled(false);
        preencheView();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

        limparCampos();
        liberarCampos(false);

        btModificar.setEnabled(true);

        textNome.setText(cliente.getPessoa().getNome());
        textEmail.setText(cliente.getPessoa().getEmail());
        textIE.setText(cliente.getPessoa().getInscricaoEstadual());
        textSuframa.setText(cliente.getPessoa().getSuframa());
        checkBoxICMS.setEnabled(cliente.getPessoa().isIsencaoIcms());

        List<Telefone> t = cliente.getPessoa().getTelefones();
        List<Endereco> e = cliente.getPessoa().getEnderecos();

        tftFone.setText(t.get(0).getDdd() + t.get(0).getNumero());

        textLogradouro.setText(e.get(0).getEndereco());
        textNum.setText(String.valueOf(e.get(0).getNumero()));
        textBairro.setText(e.get(0).getBairro());
        textComplemento.setText(e.get(0).getComplemento());
        textCep.setText(e.get(0).getCep());
        abreListaPais.setSelectedItem(e.get(0).getMunicipio().getEstado().getPais());
        abreListaEstado.setSelectedItem(e.get(0).getMunicipio().getEstado());
        abreListaMunicipio.setSelectedItem(e.get(0).getMunicipio());

        if (cliente.getPessoa() instanceof Fisica) {
            jRadioButtonPF.setEnabled(true);
            ftfCpfCnpj.setText(((Fisica) cliente.getPessoa()).getCpf());
        } else {
            if (cliente.getPessoa() instanceof Juridica) {
                jRadioButtonPJ.setEnabled(true);
                ftfCpfCnpj.setText(((Juridica) cliente.getPessoa()).getCnpj());
            }
        }

    }

    private void preencheView() {
        abreListaPais.removeAllItems();
        PaisDAO pDAO = new PaisDAO();
        List<Pais> listPais = pDAO.findAll();
        for (Pais pais : listPais) {
            abreListaPais.addItem(pais);
        }
        abreListaPais.setSelectedIndex(-1);
        
    }

    public void preencheEstados(Pais pais) {
        abreListaEstado.removeAllItems();
        for (Estado estado : pais.getEstados()) {
            abreListaEstado.addItem(estado);
        }
        abreListaEstado.setSelectedIndex(-1);
        
    }

    public void preencheCidades(Estado estado) {
        abreListaMunicipio.removeAllItems();
        for (Municipio municipio : estado.getMunicipios()) {
            abreListaMunicipio.addItem(municipio);
        }
        abreListaMunicipio.setSelectedIndex(-1);
        
    }

    public void limparCampos() {
        checkBoxICMS.setSelected(false);
        textNome.setText(null);
        ftfCpfCnpj.setText(null);
        jRadioButtonPF.setSelected(true);
        textIE.setText(null);
        textSuframa.setText(null);
        textEmail.setText(null);
        tftFone.setText(null);
        textLogradouro.setText(null);
        textNum.setText(null);
        textBairro.setText(null);
        textComplemento.setText(null);
        textCep.setText(null);
        preencheView();
    }

    private void liberarCampos(Boolean opcao) {
        checkBoxICMS.setEnabled(opcao);
        textNome.setEnabled(opcao);
        ftfCpfCnpj.setEnabled(opcao);
        jRadioButtonPF.setEnabled(opcao);
        jRadioButtonPJ.setEnabled(opcao);
        textIE.setEnabled(opcao);
        textSuframa.setEnabled(opcao);
        textEmail.setEnabled(opcao);
        tftFone.setEnabled(opcao);
        textLogradouro.setEnabled(opcao);
        textNum.setEnabled(opcao);
        textBairro.setEnabled(opcao);
        textComplemento.setEnabled(opcao);
        textCep.setEnabled(opcao);
        abreListaPais.setEnabled(opcao);
        abreListaEstado.setEnabled(opcao);
        abreListaMunicipio.setEnabled(opcao);
    }

    /*  public ClienteView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        buttonGroupTipoCliente = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        checkBoxICMS = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        lbIE = new javax.swing.JLabel();
        textIE = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        textSuframa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ftfCpfCnpj = new javax.swing.JFormattedTextField();
        tftFone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonPF = new javax.swing.JRadioButton();
        jRadioButtonPJ = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        lbLogradouro = new javax.swing.JLabel();
        textLogradouro = new javax.swing.JTextField();
        lbComplemento = new javax.swing.JLabel();
        textComplemento = new javax.swing.JTextField();
        lbNum = new javax.swing.JLabel();
        textBairro = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        abreListaPais = new javax.swing.JComboBox();
        lbEstado = new javax.swing.JLabel();
        abreListaEstado = new javax.swing.JComboBox();
        lbMunicipio = new javax.swing.JLabel();
        abreListaMunicipio = new javax.swing.JComboBox();
        lbCep = new javax.swing.JLabel();
        textCep = new javax.swing.JFormattedTextField();
        textNum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Cliente");

        checkBoxICMS.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkBoxICMS.setText("Marque ser for isento de ICMS.");
        checkBoxICMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxICMSMouseClicked(evt);
            }
        });
        checkBoxICMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxICMSActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel1.setName(""); // NOI18N

        lbNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbNome.setText("*Nome / Razão Social:");

        lbIE.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbIE.setText("Inscrição Estadual:");

        lbEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbEmail.setText("E-mail:");

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("*CPF / CNPJ:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Nº Inscrição SUFRAMA:");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("*Telefone:");

        try {
            ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfCpfCnpjActionPerformed(evt);
            }
        });

        try {
            tftFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)*********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tftFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftFoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome)
                    .addComponent(lbIE)
                    .addComponent(lbEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textIE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftfCpfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(textSuframa)
                    .addComponent(tftFone))
                .addGap(313, 313, 313))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ftfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSuframa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tftFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIE)
                            .addComponent(textIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmail)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        buttonGroupTipoCliente.add(jRadioButtonPF);
        jRadioButtonPF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButtonPF.setSelected(true);
        jRadioButtonPF.setText("Pessoa Física");
        jRadioButtonPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPFMouseClicked(evt);
            }
        });

        buttonGroupTipoCliente.add(jRadioButtonPJ);
        jRadioButtonPJ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButtonPJ.setText("Pessoa Jurídica");
        jRadioButtonPJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPJMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jRadioButtonPF)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonPJ)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPF)
                    .addComponent(jRadioButtonPJ)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        lbLogradouro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbLogradouro.setText("*Logradouro:");

        lbComplemento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbComplemento.setText("Complemento: ");

        lbNum.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbNum.setText("*Nº:");

        lbBairro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbBairro.setText("*Bairro:");

        lbPais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbPais.setText("*País:");

        abreListaPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                abreListaPaisItemStateChanged(evt);
            }
        });

        lbEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbEstado.setText("*Estado:");

        abreListaEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                abreListaEstadoItemStateChanged(evt);
            }
        });

        lbMunicipio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbMunicipio.setText("*Município:");

        lbCep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbCep.setText("*CEP: ");

        try {
            textCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        textNum.setPreferredSize(new java.awt.Dimension(15, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComplemento)
                    .addComponent(lbLogradouro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCep, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNum, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbPais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abreListaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(lbEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abreListaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lbMunicipio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abreListaMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLogradouro)
                            .addComponent(textLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbComplemento)
                            .addComponent(textComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBairro)
                            .addComponent(textBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNum)
                            .addComponent(textNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCep)
                            .addComponent(textCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(lbMunicipio)
                    .addComponent(lbPais)
                    .addComponent(abreListaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abreListaMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abreListaPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("* Campo de preenchimento obrigatório");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setPreferredSize(new java.awt.Dimension(71, 33));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setEnabled(false);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btModificar.setText("Editar");
        btModificar.setEnabled(false);
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setPreferredSize(new java.awt.Dimension(99, 33));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxICMS)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(checkBoxICMS)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void jRadioButtonPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonPFMouseClicked
        if (jRadioButtonPF.isSelected()) {

            try {
                ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            jRadioButtonPJ.setSelected(false);

        } else if (jRadioButtonPJ.isSelected()) {

            jRadioButtonPF.setSelected(false);

            try {
                ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jRadioButtonPFMouseClicked

    private void jRadioButtonPJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonPJMouseClicked
        if (jRadioButtonPJ.isSelected()) {
            jRadioButtonPF.setSelected(false);
            try {
                ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
            } catch (java.text.ParseException ex) {
            }
        } else if (jRadioButtonPJ.isSelected()) {
            jRadioButtonPJ.setSelected(false);
            try {
                ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            } catch (java.text.ParseException ex) {
            }
        }
    }//GEN-LAST:event_jRadioButtonPJMouseClicked

    private void checkBoxICMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxICMSMouseClicked
        if (checkBoxICMS.isSelected()) {
            textIE.setEnabled(false);
        } else {
            textIE.setEnabled(true);
        }
    }//GEN-LAST:event_checkBoxICMSMouseClicked

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed

        //Janela nova = new Janela(); // para abrir a nova janela (Janela Ã© o nome da classe) 
        //nova.setVisible(true); 
        dispose(); // para fechar a janela atual 

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void checkBoxICMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxICMSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxICMSActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if(validaCampos(ftfCpfCnpj.getText().replaceAll("\\D", ""))){
            if (cliente == null) {
                if (salvar()) {
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                    liberarCampos(false);
                    btNovo.setEnabled(true);
                    btSalvar.setEnabled(false);
                }
            }else{
                if(atualizar(cliente)){
                    JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    liberarCampos(false);
                    btNovo.setEnabled(true);
                    btSalvar.setEnabled(false);
                }
            }
        }else{
            if (jRadioButtonPF.isSelected())
                JOptionPane.showMessageDialog(this, "O CPF digitado não é um CPF válido.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "O CNPJ digitado não é um CNPJ válido.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tftFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftFoneActionPerformed
        
    }//GEN-LAST:event_tftFoneActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        PesquisaClienteView pesquisaCliente = new PesquisaClienteView(this, true, this);
        pesquisaCliente.setVisible(true);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        liberarCampos(true);
        btSalvar.setEnabled(true);
        btModificar.setEnabled(false);
    }//GEN-LAST:event_btModificarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparCampos();
        liberarCampos(true);
        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void ftfCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfCpfCnpjActionPerformed
        
    }//GEN-LAST:event_ftfCpfCnpjActionPerformed

    private void abreListaPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_abreListaPaisItemStateChanged
        if (abreListaPais.getSelectedItem() != null) {
            abreListaEstado.setEnabled(true);
            preencheEstados((Pais) abreListaPais.getSelectedItem());
        }else{
            abreListaEstado.setEnabled(false);
        }
    }//GEN-LAST:event_abreListaPaisItemStateChanged

    private void abreListaEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_abreListaEstadoItemStateChanged
        if (abreListaEstado.getSelectedItem() != null) {
            abreListaMunicipio.setEnabled(true);
            preencheCidades((Estado) abreListaEstado.getSelectedItem());
        }else{
            abreListaMunicipio.setEnabled(false);
        }
    }//GEN-LAST:event_abreListaEstadoItemStateChanged

    private void fechar() {
        this.dispose();
    }

    private Boolean verificaCampos() {
        Boolean valido = true;

        if ("".equals(textNome.getText())) {
            valido = false;
            textNome.setBackground(new Color(238, 221, 130));
            textNome.requestFocus();
        } else {
            textNome.setBackground(Color.WHITE);
            if ("".equals(ftfCpfCnpj.getText().replaceAll("\\D", ""))){
                valido = false;
                ftfCpfCnpj.setBackground(new Color(238, 221, 130));
                ftfCpfCnpj.requestFocus();
            }else{
                ftfCpfCnpj.setBackground(Color.WHITE);
                if ("".equals(tftFone.getText().replaceAll("\\D", ""))) {
                    valido = false;
                    tftFone.setBackground(new Color(238, 221, 130));
                    tftFone.requestFocus();
                }else{
                    tftFone.setBackground(Color.WHITE);
                    if ("".equals(textLogradouro.getText())) {
                        valido = false;
                        textLogradouro.setBackground(new Color(238, 221, 130));
                        textLogradouro.requestFocus();
                    }else{
                        textLogradouro.setBackground(Color.WHITE);
                        if ("".equals(textNum.getText().replaceAll("\\D", ""))) {
                            valido = false;
                            textNum.setBackground(new Color(238, 221, 130));
                            textNum.requestFocus();
                        }else{
                            textNum.setBackground(Color.WHITE);
                            if ("".equals(textBairro.getText())) {
                                valido = false;
                                textBairro.setBackground(new Color(238, 221, 130));
                                textBairro.requestFocus();
                            }else{
                                textBairro.setBackground(Color.WHITE);
                                if ("".equals(textCep.getText().replaceAll("\\D", ""))) {
                                    valido = false;
                                    textCep.setBackground(new Color(238, 221, 130));
                                    textCep.requestFocus();
                                } else {
                                    textCep.setBackground(Color.WHITE);
                                    if (abreListaPais.getSelectedItem() == null) {               
                                            valido = false;
                                            abreListaPais.setBackground(new Color(238, 221, 130));
                                            abreListaPais.requestFocus();
                                    }else{
                                        abreListaPais.setBackground(Color.WHITE);
                                        if (abreListaEstado.getSelectedItem() == null) {               
                                            valido = false;
                                            abreListaEstado.setBackground(new Color(238, 221, 130));
                                            abreListaEstado.requestFocus();
                                        }else{
                                            abreListaEstado.setBackground(Color.WHITE);
                                            if (abreListaMunicipio.getSelectedItem() == null) {               
                                                valido = false;
                                                abreListaMunicipio.setBackground(new Color(238, 221, 130));
                                                abreListaMunicipio.requestFocus();
                                            }else{
                                                abreListaMunicipio.setBackground(Color.WHITE);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return valido;
    }
    
    private boolean validaCampos (String documento){
        if (jRadioButtonPF.isSelected())
            return validaCpf(documento);
        else
            return validaCNPJ(documento);
    }

    private boolean salvar() {

        boolean salvo = false;

        if (verificaCampos()) {

            ClienteController cController = new ClienteController();

            if (cController.salvar(preencherCliente())) {
                salvo = true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.WARNING_MESSAGE);
        }

        return salvo;
    }
    
    private Map<String, JComponent> preencherCliente(){
            Map<String, JComponent> dados = new HashMap<>();

            dados.put("tipo", jRadioButtonPF);
            dados.put("icms", checkBoxICMS);
            dados.put("nome", textNome);
            dados.put("ie", textIE);
            dados.put("suframa", textSuframa);
            dados.put("email", textEmail);
            dados.put("telefone", tftFone);
            dados.put("logradouro", textLogradouro);
            dados.put("num", textNum);
            dados.put("bairro", textBairro);
            dados.put("complemento", textComplemento);
            dados.put("cep", textCep);
            dados.put("pais", abreListaPais);
            dados.put("estado", abreListaEstado);
            dados.put("municipio", abreListaMunicipio);
            dados.put("documento", ftfCpfCnpj);
            
            return dados;
    }

    private boolean atualizar(Cliente c) {       
        boolean atualizado = false;
        
        ClienteController cController = new ClienteController();
        
        if(cController.atualizar(preencherCliente(), cliente))
            atualizado = true;
        
        return atualizado;
    }

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
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox abreListaEstado;
    private javax.swing.JComboBox abreListaMunicipio;
    private javax.swing.JComboBox abreListaPais;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroupTipoCliente;
    private javax.swing.JCheckBox checkBoxICMS;
    private javax.swing.JFormattedTextField ftfCpfCnpj;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonPF;
    private javax.swing.JRadioButton jRadioButtonPJ;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbIE;
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbMunicipio;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbPais;
    private javax.swing.JTextField textBairro;
    private javax.swing.JFormattedTextField textCep;
    private javax.swing.JTextField textComplemento;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textIE;
    private javax.swing.JTextField textLogradouro;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textNum;
    private javax.swing.JTextField textSuframa;
    private javax.swing.JFormattedTextField tftFone;
    // End of variables declaration//GEN-END:variables
}
