/**
 * BlogPostService
 */

app.factory('BlogPostService',function($http){
	var blogPostService={};
	
	blogPostService.addBlogPost=function(blogPost){
		return $http.post("http://localhost:8089/mChatbackend/saveblogpost",blogPost)
	}
	
	blogPostService.getBlogPostsWaitingForApproval=function() {
		return $http.get("http://localhost:8089/mChatbackend/getblogposts/"+0)
	}
	
	blogPostService.getBlogPostsApproved=function() {
		return $http.get("http://localhost:8089/mChatbackend/getblogposts/"+1)
	}
	
	blogPostService.getBlogPostById=function(id) {
		return $http.get("http://localhost:8089/mChatbackend/getblogpostbyid/"+id);
	}
	
	
	blogPostService.updateBlogPost=function(blogPost) {
		return $http.put("http://localhost:8089/mChatbackend/updateblogpost",blogPost)
	}
	blogPostService.addComment=function(blogComment){
		console.log(blogComment)
		return $http.post("http://localhost:8089/mChatbackend/addblogcomment",blogComment)
	}
	
	blogPostService.getBlogComments=function(blogPostId){
		return $http.get("http://localhost:8089/mChatbackend/getblogcomments/"+blogPostId)
		
	}

	return blogPostService;
})