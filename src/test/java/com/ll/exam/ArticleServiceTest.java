package com.ll.exam;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.article.service.ArticleService;

public class ArticleServiceTest {
	@Test
	public void articleService가_존재한다() {
		ArticleService articleService = Container.getObj(ArticleService.class);
		assertThat(articleService).isNotNull();
	}

	@Test
	public void getArticles() {
		ArticleService articleService = Container.getObj(ArticleService.class);
		List<ArticleDto> articleDtoList = articleService.getArticles();
		assertThat(articleDtoList.size()).isEqualTo(3);
	}

	@Test
	public void getArticleById() {
		ArticleService articleService = Container.getObj(ArticleService.class);
		ArticleDto articleDto = articleService.getArticleById(1);

		assertThat(articleDto.getId()).isEqualTo(1L);
		assertThat(articleDto.getTitle()).isEqualTo("제목1");
		assertThat(articleDto.getBody()).isEqualTo("내용1");
		assertThat(articleDto.getCreatedDate()).isNotNull();
		assertThat(articleDto.getModifiedDate()).isNotNull();
		assertThat(articleDto.isBlind()).isFalse();
	}
}
