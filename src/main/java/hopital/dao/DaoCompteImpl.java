package hopital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Compte;
import hopital.model.Patient;

public class DaoCompteImpl implements DaoCompte{
	
	private Compte getCompte(ResultSet rs) throws SQLException {
		return new Compte(rs.getString("login"),rs.getString("password"),rs.getString("typeCompte"));
	}

	public void insert(Compte obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("insert into compte (login, password,typeCompte) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getTypeCompte());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public void update(Compte obj) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("update compte set login=?,password=?,typeCompte=? where id_patient=?");
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getTypeCompte());
			ps.setInt(4, obj.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public void delete(Compte obj) {
		deleteByKey(obj.getId());
		
	}

	public void deleteByKey(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = Context.getContext().getConnection().prepareStatement("delete from compte where id=?");
			ps.setInt(1, id);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		
	}

	public Compte findByKey(Integer id) {
		PreparedStatement ps = null;
		Compte compte = null;
		try {
			ps=Context.getContext().getConnection().prepareStatement("select * from compte where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				compte = getCompte(rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		return compte;
	}

	public List<Compte> findAll() {
		Statement st = null;
		List<Compte> comptes = new ArrayList<Compte>();
		Compte compte = null;
		try {
			st= Context.getContext().getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from compte");
			if (rs.next()) {
				compte = getCompte(rs);
				comptes.add(compte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Context.destroy();
		}
		return comptes;
	}

}
