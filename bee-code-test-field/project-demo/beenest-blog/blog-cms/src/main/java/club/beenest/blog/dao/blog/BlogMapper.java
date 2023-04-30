package club.beenest.blog.dao.blog;

import club.beenest.blog.entity.archive.ArchiveBlog;
import club.beenest.blog.entity.blog.*;
import club.beenest.blog.entity.search.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章分类查询
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface BlogMapper {
    List<Blog> getListByTitleAndCategoryId(String title, Integer categoryId);

    List<SearchBlog> getSearchBlogListByQueryAndIsPublished(String query);

    List<Blog> getIdAndTitleList();

    List<NewBlog> getNewBlogListByIsPublished();

    List<BlogInfo> getBlogInfoListByIsPublished();

    List<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(String categoryName);

    List<BlogInfo> getBlogInfoListByTagNameAndIsPublished(String tagName);

    List<String> getGroupYearMonthByIsPublished();

    List<ArchiveBlog> getArchiveBlogListByYearMonthAndIsPublished(String yearMonth);

    List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend(Integer limitNum);

    List<BlogView> getBlogViewsList();

    int deleteBlogById(Long id);

    int deleteBlogTagByBlogId(Long blogId);

    int saveBlog(Blog blog);

    int saveBlogTag(Long blogId, Long tagId);

    int updateBlogRecommendById(Long blogId, Boolean recommend);

    int updateBlogVisibilityById(Long blogId, BlogVisibility bv);

    int updateBlogTopById(Long blogId, Boolean top);

    int updateViews(Long blogId, Integer views);

    Blog getBlogById(Long id);

    String getTitleByBlogId(Long id);

    BlogDetail getBlogByIdAndIsPublished(Long id);

    String getBlogPassword(Long blogId);

    int updateBlog(Blog blog);

    int countBlog();

    int countBlogByIsPublished();

    int countBlogByCategoryId(Long categoryId);

    int countBlogByTagId(Long tagId);

    Boolean getCommentEnabledByBlogId(Long blogId);

    Boolean getPublishedByBlogId(Long blogId);

    List<CategoryBlogCount> getCategoryBlogCountList();
}
