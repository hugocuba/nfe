/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.controller;

import br.com.nfe.dao.EmitenteDAO;
import br.com.nfe.model.Emitente;
import br.com.nfe.model.Endereco;
import br.com.nfe.model.Juridica;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Pessoa;
import br.com.nfe.model.Telefone;
import br.com.nfe.utils.Telephone;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author hugo
 */
public class EmitenteController {

    public Boolean salvar(Map<String, JComponent> dados) throws IOException {
        boolean salvo = false;

        Pessoa p = new Juridica();

        p.setNome(((JTextComponent) dados.get("nome")).getText());
        ((Juridica) p).setNomeFantasia(((JTextComponent) dados.get("nomeFantasia")).getText());
        ((Juridica) p).setCnpj(((JTextComponent) dados.get("cnpj")).getText());
        p.setInscricaoEstadual(((JTextComponent) dados.get("ie")).getText());

        Endereco endereco = new Endereco();
        endereco.setBairro(((JTextComponent) dados.get("bairro")).getText());
        endereco.setCep(((JTextComponent) dados.get("cep")).getText());
        endereco.setComplemento(((JTextComponent) dados.get("complemento")).getText());
        endereco.setNumero(Integer.parseInt(((JTextComponent) dados.get("numero")).getText()));
        endereco.setMunicipio((Municipio) ((JComboBox) dados.get("cidade")).getSelectedItem());
        endereco.setEndereco(((JTextComponent) dados.get("endereco")).getText());
        endereco.setPessoa(p);

        ArrayList<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        //p.setEnderecos(enderecos);

        List<String> tel = new ArrayList<>();
        tel = Telephone.separarDDD(((JTextField) dados.get("tel")).getText());
        Telefone telefone = new Telefone();
        //telefone.setDdd(tel.get(0));
        //telefone.setNumero(tel.get(1));
        telefone.setPessoa(p);

        Emitente e = new Emitente();
        e.setPessoa(p);
        e.setCnaeFiscal(((JTextComponent) dados.get("cnaeFiscal")).getText());
        e.setInscricaoEstadualSubstTributario(((JTextComponent) dados.get("iest")).getText());
        e.setInscricaoMunicipal(((JTextComponent) dados.get("ie")).getText());

        Icon icon = (((JLabel) dados.get("imagem")).getIcon());
        BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        
         byte[] bytes = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
            try {
                ImageIO.write(img, "png", ios);
                // Set a flag to indicate that the write was successful
            } finally {
                ios.close();
            }
            bytes = baos.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        e.setLogotipo(bytes);

        EmitenteDAO eDAO = new EmitenteDAO();

        if (eDAO.persist(e)) {
            salvo = true;
        };

        return salvo;
    }
}
