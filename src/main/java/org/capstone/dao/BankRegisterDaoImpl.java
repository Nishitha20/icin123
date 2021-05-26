package org.capstone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.capstone.model.Admin;
import org.capstone.model.BankRegister;
import org.capstone.model.Request;
import org.capstone.model.Transaction;
import org.capstone.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BankRegisterDaoImpl implements BankRegisterDao 
{
	private JdbcTemplate jdbcTemplate;
	public BankRegisterDaoImpl(DriverManagerDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int register(BankRegister b) {
		String sql = "INSERT INTO register(cid,fname,lname,uname,dob,gender,email,mobile,address,type,password,acnum,balance,block,wblock,dblock,tblock) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] {b.getCid(),b.getFname(),b.getLname(),b.getUname(),b.getDob(),b.getGender(),b.getEmail(),b.getMobile(),b.getAddress(),b.getType(),b.getPsswd(),b.getAcnum(),b.getBalance(),b.getBlock(),b.getWblock(),b.getDblock(),b.getTblock()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int validate1(String cid, String pass,String x) {
		 String sql = "select * from register where cid='" + cid +"' and block='" + x+"'";
				 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper());

				    return b.size() > 0 ? 1 : 0;
	}
	class UserMapper implements RowMapper<BankRegister> {

		  public BankRegister mapRow(ResultSet rs, int arg1) throws SQLException {
		    
		    BankRegister b=new BankRegister();
		    b.setCid(rs.getString("cid"));
		    b.setPsswd(rs.getString("password"));
		    return b;
		  }
	}
	@Override
	public List<BankRegister> display(String cid) 
	{
		List<BankRegister> bList = jdbcTemplate.query("SELECT * FROM register WHERE cid=?",
				new Object[] { cid }, new RowMapper<BankRegister>() 
				{

					@Override
					public BankRegister mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						 BankRegister b=new BankRegister();
						    b.setCid(rs.getString("cid"));
						    b.setBalance(rs.getInt("balance"));
						    b.setType(rs.getString("type"));
						return b;
					}
				});
		return bList;
	}

	
	@Override
	public int withdraw(String accn, int amt,String psswd) {
		String sql = "UPDATE register set balance=? WHERE acnum=? and password=?";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { amt,accn,psswd });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<BankRegister> get(String accn) {
		List<BankRegister> bList = jdbcTemplate.query("SELECT * FROM register WHERE acnum=?",
				new Object[] { accn }, new RowMapper<BankRegister>() 
				{

					@Override
					public BankRegister mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						 BankRegister b=new BankRegister();
						    b.setAcnum(rs.getString("acnum"));
						    b.setBalance(rs.getInt("balance"));
						    b.setType(rs.getString("type"));
						    b.setCid(rs.getString("cid"));
						return b;
					}
				});
		return bList;
	}

	@Override
	public int deposit(String accn, int amt,String psswd) {
		String sql = "UPDATE register set balance=? WHERE acnum=? and password=?";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { amt,accn,psswd });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int transaction(Transaction t) {
		String sql = "INSERT INTO transaction(cid,tid,date,time,toac,fromac,pbal,amt,typetid,cbal) values(?,?,?,?,?,?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] {t.getCid(),t.getTid(),t.getDate(),t.getTime(),t.getTo(),t.getFrom(),t.getPbal(),t.getAmt(),t.getTypetid(),t.getCbal()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int transfer(String accn2, int amt1) {
		String sql = "UPDATE register set balance=? WHERE acnum=?";
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { amt1,accn2 });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<BankRegister> get1(String cid) {
		List<BankRegister> bList = jdbcTemplate.query("SELECT * FROM register WHERE cid=?",
				new Object[] { cid }, new RowMapper<BankRegister>() 
				{

					@Override
					public BankRegister mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						 BankRegister b=new BankRegister();
						 	b.setAddress(rs.getString("address"));
						 	b.setFname(rs.getString("fname"));
						 	b.setMobile(rs.getString("mobile"));
						    b.setAcnum(rs.getString("acnum"));
						    b.setBalance(rs.getInt("balance"));
						    b.setType(rs.getString("type"));
						return b;
					}
				});
		return bList;
	}

	@Override
	public int request(Request r) {
		String sql = "INSERT INTO request(cid,acname,acnum,type,address,mobile,rblock) values(?,?,?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] {r.getCid(),r.getAcname(),r.getAcnum(),r.getType(),r.getAddress(),r.getMobile(),r.getRblock()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int validate(String cid, String pass) {
		String sql = "select * from register where cid='" + cid + "' and password='" + 
			 	pass+"'";
			 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper1());

			    return b.size() > 0 ? 1 : 0;
}
class UserMapper1 implements RowMapper<BankRegister> {

	  public BankRegister mapRow(ResultSet rs, int arg1) throws SQLException {
	    
	    BankRegister b=new BankRegister();
	    b.setCid(rs.getString("cid"));
	    b.setPsswd(rs.getString("password"));
	    return b;
	  }
	}
@Override
public int validateadmin(String aid, String pass) {
	String sql = "select * from admin where adminid='" + aid + "' and password='" + 
		 	pass+"'";
		 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper1());

		    return b.size() > 0 ? 1 : 0;
}

@Override
public List<BankRegister> read() {
	List<BankRegister> blist = jdbcTemplate.query("SELECT * FROM register", new RowMapper<BankRegister>() {
		
		@Override
		public BankRegister mapRow(ResultSet rs, int rowNum) throws SQLException {
			BankRegister b=new BankRegister();
			b.setCid(rs.getString("cid"));
		 	b.setAddress(rs.getString("address"));
		 	b.setFname(rs.getString("fname"));
		 	b.setMobile(rs.getString("mobile"));
		    b.setAcnum(rs.getString("acnum"));
		    b.setType(rs.getString("type"));
			return b;
		}
		
	});

	return blist;
}

@Override
public int update(String cid,String x) {
	String sql = "UPDATE register set block=? WHERE cid=?";
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
public int update1(String cid, String x) {
	String sql = "UPDATE register set block=? WHERE cid=?";
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
public int updatewblock1(String cid, String x) {
	String sql = "UPDATE register set wblock=? WHERE cid=?";
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
public int updatewblock2(String cid, String x) {
	String sql = "UPDATE register set wblock=? WHERE cid=?";
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
public int validate3(String cid, String psswd, String x1) {
	String sql = "select * from register where cid='" + cid +"' and dblock='" + x1+"'";
	 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper());

	    return b.size() > 0 ? 1 : 0;
}

@Override
public int updatedblock1(String cid, String x) {
	String sql = "UPDATE register set dblock=? WHERE cid=?";
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
public int updatedblock2(String cid, String x) {
	String sql = "UPDATE register set dblock=? WHERE cid=?";
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
public int validate4(String cid, String psswd, String x1) {
	String sql = "select * from register where cid='" + cid +"' and tblock='" + x1+"'";
	 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper());

	    return b.size() > 0 ? 1 : 0;
}

@Override
public int updatetblock1(String cid, String x) {
	String sql = "UPDATE register set tblock=? WHERE cid=?";
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
public int updatetblock2(String cid, String x) {
	String sql = "UPDATE register set tblock=? WHERE cid=?";
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
public int validatewithdraw(String cid, String x) {
	String sql = "select * from register where cid='" + cid +"' and wblock='" + x+"'";
	 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper());

	    return b.size() > 0 ? 1 : 0;
}

@Override
public int validatedeposit(String cid, String x) {
	String sql = "select * from register where cid='" + cid +"' and dblock='" + x+"'";
	 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper());

	    return b.size() > 0 ? 1 : 0;
}

@Override
public int validatetransfer(String cid, String x1) {
	String sql = "select * from register where cid='" + cid +"' and tblock='" + x1+"'";
	 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper());

	    return b.size() > 0 ? 1 : 0;
}

@Override
public List<Transfer> display1(String cid) {
	List<Transfer> tList = jdbcTemplate.query("SELECT * FROM transfer WHERE cid=?",
			new Object[] { cid }, new RowMapper<Transfer>() 
			{

				@Override
				public Transfer mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Transfer t=new Transfer();
					t.setCid(rs.getString("cid"));
					t.setAcname(rs.getString("acname"));
					t.setAcnum(rs.getString("acnum"));
					t.setActype(rs.getString("actype"));
					t.setMobile(rs.getString("mobile"));
					return t;
				}
			});
	return tList;
}

@Override
public int enterrecipient(Transfer t) {
	String sql = "INSERT INTO transfer(cid,acnum,acname,actype,mobile) values(?,?,?,?,?)";

	try {

		int counter = jdbcTemplate.update(sql,
				new Object[] {t.getCid(),t.getAcnum(),t.getAcname(),t.getActype(),t.getMobile()});

		return counter;

	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
}

@Override
public List<Transfer> display1(String cid, String acnum) {
	List<Transfer> tList = jdbcTemplate.query("SELECT * FROM transfer WHERE cid=? and acnum=?",
			new Object[] { cid,acnum }, new RowMapper<Transfer>() 
			{

				@Override
				public Transfer mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Transfer t=new Transfer();
					t.setCid(rs.getString("cid"));
					t.setAcname(rs.getString("acname"));
					t.setAcnum(rs.getString("acnum"));
					t.setActype(rs.getString("actype"));
					t.setMobile(rs.getString("mobile"));
					return t;
				}
			});
	return tList;
}

@Override
public int validaterecipient(String accn2, String name, String mobile) {
	String sql = "select * from register where acnum='" + accn2+"' and fname='" + name+"' and mobile='"+mobile+"'";
	 List<BankRegister> b= jdbcTemplate.query(sql, new UserMapper2());

	    return b.size() > 0 ? 1 : 0;
}
class UserMapper2 implements RowMapper<BankRegister> {

public BankRegister mapRow(ResultSet rs, int arg1) throws SQLException {

BankRegister b=new BankRegister();
b.setAcnum(rs.getString("acnum"));
b.setFname(rs.getString("fname"));
b.setMobile(rs.getString("mobile"));
return b;
}
}
}



