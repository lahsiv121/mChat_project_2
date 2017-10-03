package com.niit.mChatbackend.Dao;

/*import com.niit.model.BlogPost;
*/

import java.util.List;

import com.niit.mChatbackend.model.BlogComment;
import com.niit.mChatbackend.model.BlogPost;


public interface BlogPostDao 
{
	void saveBlogPost(BlogPost blogPost);
	
	List<BlogPost> getBlogPosts(int approved);

	BlogPost getBlogPostById(int id);
	
	void updateBlogPost(BlogPost blogPost);
	
	void addBlogComment(BlogComment blogComment);
	
	List<BlogComment> getAllBlogComments(int blogPostId);

}
