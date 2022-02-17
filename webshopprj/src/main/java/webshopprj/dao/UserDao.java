package webshopprj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
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
					User user = new User(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("birthdate"),
							rs.getString("phonenum"), rs.getString("email"), rs.getString("authList"), rs.getString("b_item_num"), rs.getInt("t_pay"), rs.getInt("c_point"));
					
					return user;
				}
			};
	// ���� ����� �迭�� �������� ���� �ݹ� �޼��� 
	// ���� ��� rowNum���� ī�����Ͽ�, �Ʒ��� �ݹ� �޼��带 ��� ������ŭ �����Ͽ� rowmapper�� �����Ѵ�.
	// return ���� ���߿� ���ϴ� ���� ���⿡ VO��ü�� return
	// entity ���� ���߿� ���ϴ� ���� �߻��� �� �� ����(ó�� ����, ����Ͻ� ���� ��)


	@Override
	public void add(User user) {
		try {
			jdbcTemplate.update("insert into user(id, pw, name, birthdate, phonenum, email, authlist, b_item_num) values(?, ?, ?, ?, ?, ?, ?, ?)", 
					user.getId(), user.getPw(), user.getName(), user.getBirthdate(), user.getPhonenum(), user.getEmail(), user.getAuthList(), user.getB_item_num());
		} catch(DuplicateKeyException e) {
			throw e;	
			// DuplicateKeyException : primary key �ߺ� �� �߻��ϴ� ����
		}
	}
	
	@Override
	public void update(User user) {
		try {
			jdbcTemplate.update("update user set"
					+ "id=?, pw=?, name=?, birthdate=?, phonenum=?, email=?, authlist = ?, b_item_num=?", 
					user.getId(), user.getPw(), user.getName(), user.getBirthdate(), user.getPhonenum(), user.getEmail(), user.getAuthList(), user.getB_item_num());
		} catch(DataAccessException e) {
			throw e;	
			// DataAccessException : ��Ÿ�ӿ����� �� ������, ����ó���� �� �� �ִ� ���� �����Ǿ� �ִ� ��Ÿ�� Ư�� ��,
			//						������ �����ڿ��� ���� �߰� �� �ذ��� �Ƿ��ϱ� ���� ����ó���̴�.
		}
		
	}

	@Override
	public User get(String id) {
		
		try {
			return this.jdbcTemplate.queryForObject("select * from user where id=?",
					new Object[] {id},	// �Ű������� id�� �Ű����ڷ� ����
					this.userMapper);	// �ݹ����庯���� userMapper�� ����
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
		

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
