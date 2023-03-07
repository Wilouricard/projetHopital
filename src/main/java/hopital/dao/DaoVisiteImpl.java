package hopital.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Compte;
import hopital.model.Patient;
import hopital.model.Visite;

public class DaoVisiteImpl implements DaoVisite{
	
	private Visite getVisite(ResultSet rs) throws SQLException {
		return new Visite(rs.getString("numero_visite"),rs.getClass().getName().valueOf("id_patient"),rs.getClass().getName().valueOf("id_medecin"),rs.getString("cout_visite"),rs.getString("salle"),rs.getDate("date_visite"));
	}

	public void insert(Visite obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("insert into compte (numero_visite,id_patient,id_medecin,cout_visite,salle,date_visite) values (?,?,?,?,?,?)");
			ps.setInt(1, obj.getNumero_visite());
			ps.setInt(2, obj.getId_patient().getId_patient());
			ps.setInt(3, obj.getId_compte().getId());
			ps.setInt(4, obj.getCout_visite());
			ps.setInt(5, obj.getSalle());
			ps.setDate(6, Date.valueOf(obj.getDate()));
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public void update(Visite obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("update visite set id_patient=?,id_medecin=?,cout_visite=?,salle=?,date_visite=? where numero_visite=?");
			ps.setInt(1, obj.getId_patient().getId_patient());
			ps.setInt(2, obj.getId_compte().getId());
			ps.setInt(3, obj.getCout_visite());
			ps.setInt(4, obj.getSalle());
			ps.setDate(5, Date.valueOf(obj.getDate()));
			ps.setInt(6, obj.getNumero_visite());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public void delete(Visite obj) {
		deleteByKey(obj.getNumero_visite());
		
	}

	public void deleteByKey(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("delete from visite where numero_visite=?");
			ps.setInt(1, id);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public Visite findByKey(Integer id) {
		PreparedStatement ps = null;
		Visite visite = null;
		try {
			ps=Context.getContext().getConnection().prepareStatement("select * from visite where numero_visite=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				visite = getVisite(rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		return visite;
	}

	public List<Visite> findAll() {
		Statement st = null;
		List<Visite> visites = new ArrayList<Visite>();
		Visite visite = null;
		try {
			st= Context.getContext().getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from visite");
			if (rs.next()) {
				visite = getVisite(rs);
				visites.add(visite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		return visites;
		
	}

}
