package dao;

import dto.BlogDTO;

public interface BlogDAO {
    // 구현체가 아니라 내 생각을 집어넣는 친구

    // 데이터 저장
    public void save(BlogDTO dto);

    // 데이터 찾기
    public void findAll();

    // 키워드로 데이터 찾기
    public void findKeyword(String keyword);

    // 키워드로 데이터 찾기
//    void findKeyword(BlogDTO dto) throws Exception;

    // 데이터 수정
    public void update();

    // 데이터 삭제
    public void delete();
}
