package com.biz.memo03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.memo03.model.FileVO;
import com.biz.memo03.model.MemoVO;

public interface MemoDao {
	
	@Select(" SELECT * FROM tbl_memo ORDER BY id ")
	@Results({
		@Result(property="id",column="id"), //2
		@Result(property="files", // 7
				column="id",javaType=List.class, //4
				many=@Many(select="getFiles")) //3
		})
	public List<MemoVO> selectAll();
	
	
	@Select(" SELECT * FROM tbl_memo WHERE id = #{id} ")
	@Results({
		@Result(property="id",column="id"), //2
		@Result(property="files", // 7
				column="id",javaType=List.class, //4
				many=@Many(select="getFiles")) //3
		})
	public MemoVO findById(long id);
	
	
	
	/*
	 *1. tbl_memo에서 데이터를 select
	 *2. tbl_memo 데이터 중에서 id 칼럼의 값을 사용하기 위한 준비
	 *3. getFiles 메서드를 호출
	 *4. 메서드의 매개변수로 id를 parent_id로 전달
	 *5. getFiles는 parent_id를 기준으로 데이터를 select한 후
	 *6. List<FileVO> 로 return
	 *7. 그 결과를 memoVO의 files변수에 저장
	 */
	@Select(" SELECT * FROM tbl_memo WHERE m_auth = #{m_userid} ")
	@Results({
			@Result(property="id",column="id"), //2
			@Result(property="files", // 7
					column="id",javaType=List.class, //4
					many=@Many(select="getFiles")) //3
			})
	public List<MemoVO> selectByuserId(String m_userid); // 1
	
	
	
	@Select(" SELECT * FROM tbl_files WHERE parent_id = #{parent_id} ") // 5
	public List<FileVO> getFiles(long parent_id); // 6
	
	
	
	
	/*
	 * IsertProvider 문장이 실행되기 전에 (before가 true이므로)
	 * statement의 항목을 실행해서 그 결과 값을 id라는 변수에 담아라
	 * 이 때에 이 id의 변수 자료형은 Long형이다.(2개의 table 릴레이션시 사용<참조관계때문>)
	 */
	@SelectKey(statement=" SELECT SEQ_MEMO.NEXTVAL FROM DUAL ", keyProperty="id", before=true, resultType=Long.class)
	@InsertProvider(type=MemoSQL.class, method="memo_insert_sql")
	public int insert(MemoVO memovo);
	@UpdateProvider(type=MemoSQL.class, method="memo_update_sql")
	public int update(MemoVO memovo);
	@Delete(" DELETE FROM tbl_memo WHERE id = #{id} ")
	public int delete(long id);
}
