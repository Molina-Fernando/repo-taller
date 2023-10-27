package dbController;

import clases.Medico;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ventanas.Login;


/**
 * El controlador ´CtrlMedicoTriage´ se encarga de ser el intermediario entre la
 * clase Médico y la ventana MedicoTriage, completando los datos del triage del
 * paciente en la base de datos.
 *
 */
public class CtrlMedicoTriage {

    CtrlConsulta ctrlConsulta = new CtrlConsulta();
    private final Medico med = new Medico();

    /**
     * LLama al método de la clase Medico llamado ´realizarTriage´ pasandole
     * como parámetro todos los puntos de los signos vitales.
     *
     * @param i1 puntos correspondientes a la respiraión del paciente.
     * @param i2 puntos correspondientes al pulso del paciente.
     * @param i3 puntos correspondientes al estado mental del paciente.
     * @param i4 puntos correspondientes a la conciencia del paciente.
     * @param i5 puntos correspondientes al dolor en el pecho del paciente.
     * @param i6 puntos correspondientes a las lesiones graves del paciente.
     * @param i7 puntos correspondientes a la edad del paciente.
     * @param i8 puntos correspondientes a la fiebre del paciente.
     * @param i9 puntos correspondientes a los vomitos del paciente.
     * @param i10 puntos correspondientes al dolor abdominal del paciente.
     * @param i11 puntos correspondientes a los signos de shock del paciente.
     * @param i12 puntos correspondientes a los dolores leves del paciente.
     * @param i13 puntos correspondientes al sangrado del paciente.
     * @return devuelve el color parcial correspondiente del triage.
     */
    public String triagiarPaciente(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        String colorParcial = med.realizarTriage(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
        return colorParcial;
    }

    /**
     * Llama al método de la clase Medico llamado ´cambiarTriage´, pasandole por
     * paámetro el color definitivo y el motivo del cambio.
     *
     * @param colorDefinitivo
     * @param motivoCambio
     */
    public void cambiarTriage(String colorDefinitivo, String motivoCambio) {
        med.cambiarTriage(colorDefinitivo, motivoCambio);
    }

    /**
     * Este método obtiene el color definitivo y el motivo de cambio si están
     * disponibles o usa el color parcial en su lugar, registra información del
     * paciente en la tabla 'Triage' con su nombre, apellido, colores de triage
     * y motivo de cambio, y actualiza la lista de espera para reflejar el color
     * definitivo y otros detalles.
     *
     */
    public void finalizarTriage() {

        String colorDefinitivo = null;
        String motivoCambio = null;

        String dniMedico = Login.user;

        String dniPac = obtenerUltimoDniPac();
        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT * FROM Medico WHERE DNI = ?";
            String query1 = "SELECT * FROM Paciente WHERE DNI = ?";
            String query2 = "SELECT * FROM Consulta WHERE DNIPaciente = ? AND Matricula IS NULL";
            //String query3 = "SELECT * FROM ListaEsperaSala WHERE DNI = ?";

            PreparedStatement psq2 = conex.prepareStatement(query2);
            PreparedStatement psq1 = conex.prepareStatement(query1);
            PreparedStatement psq = conex.prepareStatement(query);

            psq2.setString(1, dniPac);
            psq1.setString(1, dniPac);
            psq.setString(1, dniMedico);

            ResultSet rs2 = psq2.executeQuery();
            ResultSet rs1 = psq1.executeQuery();
            ResultSet rs = psq.executeQuery();

            if (rs.next() && rs1.next() && rs2.next()) {

                String insert = "INSERT INTO Triage  (NombrePac, ApellidoPac, ApellidoMed, ColorParcial, ColorDefinitivo, MotivoCambio, NroMatricula, DNI) VALUES (?,?,?,?,?,?,?,?);";
                PreparedStatement psi = conex.prepareStatement(insert);

                String update = "UPDATE ListaEsperaSala SET ColorDefinitivo = ?, Fecha =?, Hora =?, Motivo = ? WHERE DNI = ?;";

                PreparedStatement psu = conex.prepareStatement(update);

                if (med.getColorDefinitivo() != null) {
                    colorDefinitivo = med.getColorDefinitivo();
                    motivoCambio = med.getMotivoCambio();

                } else {
                    colorDefinitivo = med.getColorParcial();
                    motivoCambio = "No hubo cambio";
                }
                psi.setString(1, rs1.getString("Nombre"));
                psi.setString(2, rs1.getString("Apellido"));
                psi.setString(3, rs.getString("Apellido"));
                psi.setString(4, med.getColorParcial());
                psi.setString(5, colorDefinitivo);
                psi.setString(6, motivoCambio);
                psi.setInt(7, rs.getInt("Matricula"));
                psi.setInt(8, Integer.parseInt(dniPac));
                
                psu.setString(1, colorDefinitivo);
                psu.setString(2, rs2.getString("Fecha"));
                psu.setString(3, rs2.getString("Hora"));
                psu.setString(4, rs2.getString("Motivo"));

                psu.setInt(5, Integer.parseInt(dniPac));

                psu.executeUpdate();


                psi.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println("EXCEP SQL " + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
            }
        }
        ctrlConsulta.segundaCarga(med.getColorParcial(), colorDefinitivo, dniPac);
    }

    /**
     * Obtiene el dni del último paciente que fue ingresado en la tabla
     * ´ListaEsperaSala´, para ser llamado en el método ´finalizarTriage´.
     *
     * @return dniPac
     */
    public String obtenerUltimoDniPac() {
        String dniPac = null;
        Connection conexion = null;
        try {
            conexion = Conexion.conectar();
            String query = "SELECT DNI FROM ListaEsperaSala ORDER BY ROWID DESC LIMIT 1;";
            PreparedStatement psq = conexion.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            if (rs.next()) {
                dniPac = rs.getString("DNI");
            }
        } catch (SQLException e) {
            System.out.println("EXCEP SQL " + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
            }
        }
        return dniPac;
    }

}
