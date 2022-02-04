package webshopprj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import webshopprj.entity.User;
import webshopprj.interf.UserDaoInterf;

@Service
public class UserDao implements UserDaoInterf{
	
	@Autowired			// jdbcTemplate bean�� ������
	private JdbcTemplate jdbcTemplate;
	
	public UserDao() {}
	
	private RowMapper<User> userMapper = 
			new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getString("id"));
					user.setPw(rs.getString("pw"));
					user.setName(rs.getString("name"));
					user.setBirthdate(rs.getString("birthdate"));
					user.setPhonenum(rs.getString("phonenum"));
					user.setEmail(rs.getString("email"));
					user.setB_item_num(rs.getString("b_item_num"));
					
					return user;
				}
			};
	// ���� ����� �迭�� �������� ���� �ݹ� �޼��� 
	// ���� ��� rowNum���� ī�����Ͽ�, �Ʒ��� �ݹ� �޼��带 ��� ������ŭ �����Ͽ� rowmapper�� �����Ѵ�.



	@Override
	public void add(User prod) {
		try {
			jdbcTemplate.update("insert into user(id, pw, name, birthdate, phonenum, email, b_item_num) values(?, ?, ?, ?, ?, ?, ?)", 
					prod.getId(), prod.getPw(), prod.getName(), prod.getBirthdate(), prod.getPhonenum(), prod.getEmail(), prod.getB_item_num());
		} catch(DuplicateKeyException e) {
			throw e;	
			// DuplicateKeyException : primary key �ߺ� �� �߻��ϴ� ����
		}
	}
	
	@Override
	public void update(User prod) {
		try {
			jdbcTemplate.update("update user set"
					+ "id=?, pw=?, name=?, birthdate=?, phonenum=?, email=?, b_item_num=?", 
					prod.getId(), prod.getPw(), prod.getName(), prod.getBirthdate(), prod.getPhonenum(), prod.getEmail(), prod.getB_item_num());
		} catch(DataAccessException e) {
			throw e;	
			// DataAccessException : ��Ÿ�ӿ����� �� ������, ����ó���� �� �� �ִ� ���� �����Ǿ� �ִ� ��Ÿ�� Ư�� ��,
			//						������ �����ڿ��� ���� �߰� �� �ذ��� �Ƿ��ϱ� ���� ����ó���̴�.
		}
		
	}

	@Override
	public User get(String id) {
		
		return this.jdbcTemplate.queryForObject("select * from user where id=?",
				new Object[] {id},	// �Ű������� id�� �Ű����ڷ� ����
				this.userMapper);	// �ݹ����庯���� userMapper�� ����
	
	}

	@Override
	public List<User> getAll() {
		return this.jdbcTemplate.query("select * from user order by id", this.userMapper);
		
	}

	@Override
	public void deleteAll() {
		try {
			this.jdbcTemplate.update("truncate table user");
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public int getCount() {
		return this.jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
		// ����, ����Ÿ��.class
	}
	
	
	
	

}
