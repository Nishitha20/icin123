package org.capstone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.capstone.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AdminDaoImpl implements AdminDao {

	private JdbcTemplate jdbcTemplate;

	public AdminDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int validateadmin(String user,String pass) {
		 String sql = "select * from admin where adminid='" + user+ "' and password='" + pass
		    + "'";
		 List<Admin> admin = jdbcTemplate.query(sql, new UserMapper());

		    return admin.size() > 0 ? 1 : 0;
		    }
	class UserMapper implements RowMapper<Admin> {

		  public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
			  Admin admin=new Admin();
		    admin.setAid(rs.getString("adminid"));
		    admin.setPass(rs.getString("password"));

		    return admin;
		  }
	}
	
}
