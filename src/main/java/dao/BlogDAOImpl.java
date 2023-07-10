package dao;

import dto.BlogDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlogDAOImpl implements BlogDAO{
    // 변수
    private Connection connection;

    public BlogDAOImpl(Connection connection) {
        this.connection = connection;
    }

    // 데이터 저장
    @Override
    public void save(BlogDTO dto) {
        System.out.println("데이터 저장");
        String sql = "INSERT INTO `blog` (`keyword`, `title`, `link`, `description`, `bloggername`, `bloggerlink`, `postdate`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, dto.getKeyword());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getLink());
            pstmt.setString(4, dto.getDescription());
            pstmt.setString(5, dto.getBloggername());
            pstmt.setString(6, dto.getBloggerlink());
            pstmt.setString(7, dto.getPostdate());
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("데이터 삽입 성공!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e) {}
        }

    }
    // 데이터 찾기
    @Override
    public void findAll() {
        String sql = "select * from blog";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            //pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("keyword: " + rs.getString("keyword"));
                System.out.println("title: " + rs.getString("title"));
                System.out.println("link: " + rs.getString("link"));
                System.out.println("description: " + rs.getString("description"));
                System.out.println("bloggername: " + rs.getString("bloggername"));
                System.out.println("bloggerlink: " + rs.getString("bloggerlink"));
                System.out.println("postdate: " + rs.getString("postdate"));
            }
        } catch (Exception e) {
            System.out.println("select 메서드 예외발생");
        } finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
    }

    // 키워드로 데이터 찾기
    @Override
    public void findKeyword(String keyword) {
                String sql = "SELECT * FROM blog WHERE keyword = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, keyword);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("keyword: " + rs.getString("keyword"));
                System.out.println("title: " + rs.getString("title"));
                System.out.println("link: " + rs.getString("link"));
                System.out.println("description: " + rs.getString("description"));
                System.out.println("bloggername: " + rs.getString("bloggername"));
                System.out.println("bloggerlink: " + rs.getString("bloggerlink"));
                System.out.println("postdate: " + rs.getString("postdate"));
            }

        } catch (Exception e) {
            System.out.println("select 메서드 예외발생");
        } finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
    }

    // 데이터 수정
    @Override
    public void update() {

    }

    // 데이터 삭제
    @Override
    public void delete() {

    }
}
