package org.capstone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.capstone.model.BankRegister;
import org.capstone.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RequestDaoImpl implements RequestDao 
{
	private JdbcTemplate jdbcTemplate;

	public RequestDaoImpl(DriverManagerDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Request> read() {
		List<Request> rlist = jdbcTemplate.query("SELECT * FROM request", new RowMapper<Request>() {
			
			@Override
			public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
				Request r=new Request();
				r.setCid(rs.getString("cid"));
				r.setAcname(rs.getString("acname"));
				r.setAcnum(rs.getString("acnum"));
				r.setType(rs.getString("type"));
				r.setAddress(rs.getString("address"));
				r.setMobile(rs.getString("mobile"));
				return r;
			}
			
		});

		return rlist;
	}

	@Override
	public int updaterblock1(String cid, String x) {
		String sql = "UPDATE request set rblock=? WHERE cid=?";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { x,cid});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updaterblock2(String cid, String x) {
		String sql = "UPDATE request set rblock=? WHERE cid=?";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { x,cid});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Request> display(String cid) {
List<Request> rlist = jdbcTemplate.query("SELECT * FROM request where cid=?", new Object[] {cid},new RowMapper<Request>() {
			
			@Override
			public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
				Request r=new Request();
				r.setRblock(rs.getString("rblock"));
				return r;
			}
			
		});

		return rlist;
	}

	@Override
	public int delete(String cid) {
		String sql = "DELETE FROM request WHERE cid=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] {cid });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	}


