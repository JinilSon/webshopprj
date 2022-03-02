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
	
	@Autowired			// jdbcTemplate bean�� ������
	private JdbcTemplate jdbcTemplate;
	
	public ProdDao() {}
	
	private RowMapper<Product> userMapper = 
			new RowMapper<Product>() {
				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product prod = new Product(rs.getInt("id"), rs.getString("title"), rs.getString("category"), rs.getInt("price"), rs.getString("size"),
							rs.getString("color"), rs.getInt("count"), rs.getString("img"), rs.getString("discription"), rs.getDate("up_date"));
					
					return prod;
				}
			};
	// ���� ����� �迭�� �������� ���� �ݹ� �޼��� 
	// ���� ��� rowNum���� ī�����Ͽ�, �Ʒ��� �ݹ� �޼��带 ��� ������ŭ �����Ͽ� rowmapper�� �����Ѵ�.



	@Override
	public void add(Product prod) {
		try {
			jdbcTemplate.update("insert into product(title, category, price, size, color, count, img, discription) values(?, ?, ?, ?, ?, ?, ?, ?)", 
					prod.getTitle(), prod.getCategory(), prod.getPrice(), prod.getSize(), prod.getColor(), prod.getCount(), prod.getImg(), prod.getDiscription());
		} catch(DuplicateKeyException e) {
			throw e;	
			// DuplicateKeyException : primary key �ߺ� �� �߻��ϴ� ����
		}
	}
	
	@Override
	public void update(Product prod) {
		try {
			jdbcTemplate.update("update product set"
					+ "title=?, category=?, price=?, size=?, color=?, count=?, img=?, discription=?", 
					prod.getTitle(), prod.getCategory(), prod.getPrice(), prod.getSize(), prod.getColor(), prod.getCount(), prod.getImg(), prod.getDiscription());
		} catch(DataAccessException e) {
			throw e;	
			// DataAccessException : ��Ÿ�ӿ����� �� ������, ����ó���� �� �� �ִ� ���� �����Ǿ� �ִ� ��Ÿ�� Ư�� ��,
			//						������ �����ڿ��� ���� �߰� �� �ذ��� �Ƿ��ϱ� ���� ����ó���̴�.
		}
		
	}

	@Override
	public Product get(Integer id) {
		
		return this.jdbcTemplate.queryForObject("select * from product where id=?",
				new Object[] {id},	// �Ű������� id�� �Ű����ڷ� ����
				this.userMapper);	// �ݹ����庯���� userMapper�� ����
	
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
		// ����, ����Ÿ��.class
	}
	
	
	
	

}
