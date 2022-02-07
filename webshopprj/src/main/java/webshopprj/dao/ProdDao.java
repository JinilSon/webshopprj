package webshopprj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import webshopprj.entity.Product;
import webshopprj.interf.ProdDaoInterf;

@Service
public class ProdDao implements ProdDaoInterf{
	
	@Autowired			// jdbcTemplate bean과 연동됨
	private JdbcTemplate jdbcTemplate;
	
	public ProdDao() {}
	
	private RowMapper<Product> userMapper = 
			new RowMapper<Product>() {
				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product prod = new Product();
					prod.setId(rs.getInt("id"));
					prod.setTitle(rs.getString("title"));
					prod.setCategory(rs.getString("category"));
					prod.setPrice(rs.getInt("price"));
					prod.setDiscount(rs.getInt("discount"));
					prod.setPicture(rs.getString("picture"));
					prod.setDiscription(rs.getString("discription"));
					prod.setUp_Date(rs.getDate("up_date"));
					
					return prod;
				}
			};
	// 쿼리 결과를 배열로 가져오기 위한 콜백 메서드 
	// 쿼리 결과 rowNum마다 카운팅하여, 아래의 콜백 메서드를 결과 개수만큼 실행하여 rowmapper에 저장한다.



	@Override
	public void add(Product prod) {
		try {
			jdbcTemplate.update("insert into product(title, category, price, discount, picture, discription) values(?, ?, ?, ?, ?, ?)", 
					prod.getTitle(), prod.getCategory(), prod.getPrice(), prod.getDiscount(), prod.getPicture(), prod.getDiscription());
		} catch(DuplicateKeyException e) {
			throw e;	
			// DuplicateKeyException : primary key 중복 시 발생하는 예외
		}
	}
	
	@Override
	public void update(Product prod) {
		try {
			jdbcTemplate.update("update product set"
					+ "title=?, category=?, price=?, discount=?, picture=?, discription=?", 
					prod.getTitle(), prod.getCategory(), prod.getPrice(), prod.getDiscount(), prod.getPicture(), prod.getDiscription());
		} catch(DataAccessException e) {
			throw e;	
			// DataAccessException : 런타임예외의 한 종류로, 예외처리로 할 수 있는 것이 한정되어 있는 런타임 특성 상,
			//						빠르게 개발자에게 문제 발견 및 해결을 의뢰하기 위한 예외처리이다.
		}
		
	}

	@Override
	public Product get(Integer id) {
		
		return this.jdbcTemplate.queryForObject("select * from product where id=?",
				new Object[] {id},	// 매개변수인 id를 매개인자로 전달
				this.userMapper);	// 콜백저장변수인 userMapper에 저장
	
	}

	@Override
	public List<Product> getAll() {
		return this.jdbcTemplate.query("select * from product order by id", this.userMapper);
		
	}

	@Override
	public void deleteAll() {
		try {
			this.jdbcTemplate.update("truncate table product");
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public int getCount() {
		return this.jdbcTemplate.queryForObject("select count(*) from product", Integer.class);
		// 쿼리, 리턴타입.class
	}
	
	
	
	

}
