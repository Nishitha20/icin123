package org.capstone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.capstone.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TransactionDaoImpl implements TransactionDao {

	private JdbcTemplate jdbcTemplate;

	public TransactionDaoImpl(DriverManagerDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Transaction> view(String cid) {
List<Transaction> t1 = jdbcTemplate.query("SELECT * FROM transaction where cid=?",new Object[] {cid}, new RowMapper<Transaction>() {
			
			@Override
			public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
				Transaction t= new Transaction();
				t.setCid(rs.getString("cid"));
				t.setTid(rs.getString("tid"));
				t.setDate(rs.getString("date"));
				t.setTime(rs.getString("time"));
				t.setTo(rs.getString("toac"));
				t.setFrom(rs.getString("fromac"));
				t.setType(rs.getString("type"));
				t.setPbal(Integer.parseInt(rs.getString("pbal")));
				t.setAmt(Integer.parseInt(rs.getString("amt")));
				t.setTypetid(rs.getString("typetid"));
				t.setCbal(Integer.parseInt(rs.getString("cbal")));
				return t;
			}
			
		});

		return t1;
	}
	@Override
	public int transfer(String accn2, int amt) {
		String sql = "UPDATE register set balance=? WHERE acnum=?";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { amt,accn2 });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
