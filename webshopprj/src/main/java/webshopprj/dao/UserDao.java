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
	
	@Autowired			// jdbcTemplate bean과 연동됨
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
	// 쿼리 결과를 배열로 가져오기 위한 콜백 메서드 
	// 쿼리 결과 rowNum마다 카운팅하여, 아래의 콜백 메서드를 결과 개수만큼 실행하여 rowmapper에 저장한다.
	// return 값은 도중에 변하는 일이 없기에 VO객체로 return
	// entity 값은 도중에 변하는 일이 발생할 수 도 있음(처리 과정, 비즈니스 로직 등)


	@Override
	public void add(User user) {
		try {
			jdbcTemplate.update("insert into user(id, pw, name, birthdate, phonenum, email, authlist, b_item_num) values(?, ?, ?, ?, ?, ?, ?, ?)", 
					user.getId(), user.getPw(), user.getName(), user.getBirthdate(), user.getPhonenum(), user.getEmail(), user.getAuthList(), user.getB_item_num());
		} catch(DuplicateKeyException e) {
			throw e;	
			// DuplicateKeyException : primary key 중복 시 발생하는 예외
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
			// DataAccessException : 런타임예외의 한 종류로, 예외처리로 할 수 있는 것이 한정되어 있는 런타임 특성 상,
			//						빠르게 개발자에게 문제 발견 및 해결을 의뢰하기 위한 예외처리이다.
		}
		
	}

	@Override
	public User get(String id) {
		
		try {
			return this.jdbcTemplate.queryForObject("select * from user where id=?",
					new Object[] {id},	// 매개변수인 id를 매개인자로 전달
					this.userMapper);	// 콜백저장변수인 userMapper에 저장
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
		// 쿼리, 리턴타입.class
	}
	
	
	
	

}
