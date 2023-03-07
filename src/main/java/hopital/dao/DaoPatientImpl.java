package hopital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import hopital.model.Patient;

public class DaoPatientImpl implements DaoPatient {
	
	private Patient getPatient(ResultSet rs) throws SQLException {
		return new Patient(rs.getString("nom"),rs.getString("prenom"));
	}

	public void insert(Patient obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("insert into patient (nom, prenom) values (?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public void update(Patient obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("update patient set nom=?,prenom=? where id_patient=?");
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.setInt(3, obj.getId_patient());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public void delete(Patient obj) {
		deleteByKey(obj.getId_patient());
	}

	public void deleteByKey(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("delete from patient where id=?");
			ps.setInt(1, id);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
	}

	public Patient findByKey(Integer id) {
		PreparedStatement ps = null;
		Patient patient = null;
		try {
			ps=Context.getContext().getConnection().prepareStatement("select * from patient where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				patient = getPatient(rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		return patient;
	}

	public List<Patient> findAll() {
		Statement st = null;
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient = null;
		try {
			st= Context.getContext().getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from patient");
			if (rs.next()) {
				patient = getPatient(rs);
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		return patients;
	}


}
