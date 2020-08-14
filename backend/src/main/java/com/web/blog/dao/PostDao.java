package com.web.blog.dao;

import java.util.List;
import java.util.Optional;

import com.web.blog.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post, String> {
    // Post getUserByEmail(String email);
    // Post getUserByNickname(String nickname);

    
    Post getPostByArticleId(int articleId);

    Post findPostByArticleId(int articleId);
    
    List<Post> getPostByUserId(int userId);
    List<Post> getPostByUserIdAndTemp(int userId,int temp);
    List<Post> getPostByUserIdAndCategoryId(int userId,int categoryId);
    List<Post> getPostByTempAndCategoryIdNotOrderByCategoryIdAscCreateTimeDesc(int userId,int categoryId);

    List<Post> findPostByTempAndWriterOrderByCreateTimeDesc(int temp, String writer);


    Optional<Post> findPostByArticleIdAndTempOrderByCreateTimeDesc(int articleId,int temp);

    Optional<Post> findPostByArticleIdAndTempAndCategoryIdOrderByCreateTimeDesc(int articleId,int temp,int categoryId);

    List<Post> findPostByTitleLikeOrderByCreateTimeDesc(String word);

    List<Post> findPostByTempAndTitleLikeOrderByCreateTimeDesc(int temp , String word);

    List<Post> findPostByTempAndCategoryIdAndTitleLikeOrderByCreateTimeDesc(int temp ,int categoryId, String word);
   List<Post> findPostByTempAndWriterLikeOrderByCreateTimeDesc(int writer , String word);

    List<Post> findPostByTempAndCategoryIdAndWriterLikeOrderByCreateTimeDesc(int temp ,int categoryId, String word);

    // 리스트 출력 
    List<Post> findPostByTempOrderByCreateTimeDesc(int temp);
    
    List<Post> findPostByTempAndCategoryIdOrderByCreateTimeDesc(int temp,int categoryId);
    
    
    List<Post> findPostByUserId(int userId);
    
    // 스트링 토크나이저로 잘라서 한 개 입력했을 때 부터 네 개 입력했을 때 (전체)
    
    List<Post> findPostByAddressLikeOrderByCreateTimeDesc(String st1);
    List<Post> findPostByAddressLikeAndAddressLikeOrderByCreateTimeDesc(String st1, String st2);
    List<Post> findPostByAddressLikeAndAddressLikeAndAddressLikeOrderByCreateTimeDesc(String st1, String st2, String st3);
    List<Post> findPostByAddressLikeAndAddressLikeAndAddressLikeAndAddressLikeOrderByCreateTimeDesc(String st1, String st2, String st3, String st4);
    // 스트링 토크나이저로 잘라서 한 개 입력했을 때 부터 네 개 입력했을 때 (카테고리별)
    
    List<Post> findPostByTempAndCategoryIdAndAddressLikeOrderByCreateTimeDesc(int temp, int categoryId, String st1);
    List<Post> findPostByTempAndCategoryIdAndAddressLikeAndAddressLikeOrderByCreateTimeDesc(int temp, int categoryId, String st1, String st2);
    List<Post> findPostByTempAndCategoryIdAndAddressLikeAndAddressLikeAndAddressLikeOrderByCreateTimeDesc(int temp, int categoryId, String st1, String st2, String st3);
    List<Post> findPostByTempAndCategoryIdAndAddressLikeAndAddressLikeAndAddressLikeAndAddressLikeOrderByCreateTimeDesc(int temp, int categoryId, String st1, String st2, String st3, String st4);
    
    // 메인
    // List<Post> findPostByTempOrderByCreateTimeDesc(int temp);
    List<Post> findPostByTempOrderByEndTimeAsc(int temp);
    List<Post> findPostByTempAndCategoryIdOrderByLikeNumDesc(int temp, int categoryId);;
}
