/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package presentacion;

import Logica.ServicioConsulta;
import dto.PersonaDTO;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author jerso
 */
   
public class VentanaPrincipal extends JFrame {

    private JTextField txtCedula;

    private JComboBox<String> cmbProtocolo;

    private JTextField txtNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JTextField txtCodigoElectoral;
    private JTextField txtProvincia;
    private JTextField txtCanton;
    private JTextField txtDistrito;

    private JButton btnConsultar;
    private JButton btnLimpiar;
    private JButton btnSalir;

    private final ServicioConsulta servicioConsulta;

    public VentanaPrincipal() {

        servicioConsulta = new ServicioConsulta();

        setTitle("Consulta Padron Electoral");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        crearComponentes();
    }

    private void crearComponentes() {

        JPanel panel =
                new JPanel(
                        new GridLayout(0, 2, 10, 10)
                );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20
                )
        );

        txtCedula = new JTextField();

        cmbProtocolo =
                new JComboBox<>(
                        new String[]{"TCP", "HTTP"}
                );

        txtNombre = crearCampo();
        txtPrimerApellido = crearCampo();
        txtSegundoApellido = crearCampo();
        txtCodigoElectoral = crearCampo();
        txtProvincia = crearCampo();
        txtCanton = crearCampo();
        txtDistrito = crearCampo();

        btnConsultar = new JButton("Consultar");
        btnLimpiar = new JButton("Limpiar");
        btnSalir = new JButton("Salir");

        panel.add(new JLabel("Cedula:"));
        panel.add(txtCedula);

        panel.add(new JLabel("Protocolo:"));
        panel.add(cmbProtocolo);

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Primer apellido:"));
        panel.add(txtPrimerApellido);

        panel.add(new JLabel("Segundo apellido:"));
        panel.add(txtSegundoApellido);

        panel.add(new JLabel("Codigo electoral:"));
        panel.add(txtCodigoElectoral);

        panel.add(new JLabel("Provincia:"));
        panel.add(txtProvincia);

        panel.add(new JLabel("Canton:"));
        panel.add(txtCanton);

        panel.add(new JLabel("Distrito:"));
        panel.add(txtDistrito);

        panel.add(btnConsultar);
        panel.add(btnLimpiar);

        panel.add(btnSalir);

        add(panel);

        btnConsultar.addActionListener(
                e -> consultar()
        );

        btnLimpiar.addActionListener(
                e -> limpiar()
        );

        btnSalir.addActionListener(
                e -> System.exit(0)
        );
    }

    private JTextField crearCampo() {

        JTextField campo = new JTextField();
        campo.setEditable(false);

        return campo;
    }

    private void consultar() {

        try {

            String cedula =
                    txtCedula.getText();

            String protocolo =
                    cmbProtocolo
                            .getSelectedItem()
                            .toString();

            PersonaDTO persona =
                    servicioConsulta.consultar(
                            cedula,
                            protocolo
                    );

            mostrarPersona(persona);

        } catch (Exception e) {

            limpiarResultados();

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void mostrarPersona(PersonaDTO persona) {

        txtCedula.setText(persona.getCedula());
        txtNombre.setText(persona.getNombre());

        txtPrimerApellido.setText(
                persona.getPrimerApellido()
        );

        txtSegundoApellido.setText(
                persona.getSegundoApellido()
        );

        txtCodigoElectoral.setText(
                persona.getCodigoElectoral()
        );

        txtProvincia.setText(
                persona.getProvincia()
        );

        txtCanton.setText(
                persona.getCanton()
        );

        txtDistrito.setText(
                persona.getDistrito()
        );
    }

    private void limpiar() {

        txtCedula.setText("");

        limpiarResultados();

        txtCedula.requestFocus();
    }

    private void limpiarResultados() {

        txtNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtCodigoElectoral.setText("");
        txtProvincia.setText("");
        txtCanton.setText("");
        txtDistrito.setText("");
    }
}
