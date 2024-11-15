package com.springtest.repository;

import com.springtest.entity.Article;
import com.springtest.repository.custom.ArticleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> , ArticleRepositoryCustom {

}
