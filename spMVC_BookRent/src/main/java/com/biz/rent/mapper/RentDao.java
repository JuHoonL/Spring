package com.biz.rent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rent.model.RentVO;

public interface RentDao {

	@Select(" SELECT * FROM tbl_rent ")
	public List<RentVO> selectAll();
	
	@Select(" SELECT * FROM tbl_rent WHERE rent_seq = #{rent_seq,jdbcType=VARCHAR} ")
	public RentVO findByRentSeq(long rent_seq);
	
	@Select(" SELECT * FROM tbl_rent WHERE book_seq = #{book_seq,jdbcType=VARCHAR} ")
	public List<RentVO> findByBookSeq(long book_seq);
	
	@Select(" SELECT * FROM tbl_rent WHERE user_seq = #{user_seq,jdbcType=VARCHAR} ")
	public List<RentVO> findByUserSeq(long user_seq);
	
	@InsertProvider(type=RentSQL.class, method="rent_insert_sql")
	public int insert(RentVO rentVO);
	
	@UpdateProvider(type=RentSQL.class, method="rent_update_sql")
	public int update(RentVO rentVO);
	
	@Delete(" DELETE FROM tbl_rent WHERE rent_seq = #{rent_seq} ")
	public int delete(long rent_seq);
}
