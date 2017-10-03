/**
 * FriendService
 */

app.factory('FriendService',function($http){
	var friendService={}
	
	friendService.listofsuggestedusers=function(){
		return $http.get("http://localhost:8089/mChatbackend/getsuggestedusers")
		
	}
	
	friendService.friendRequest=function(toId){
	return $http.post("http://localhost:8089/mChatbackend/friendrequest/" +toId)
	
	}
	
	friendService.listOfPendingRequests=function(){
	return $http.get("http://localhost:8089/mChatbackend/getpendingrequests/")
	
	}
	
	
	friendService.getUserDetails=function(fromId){
		return $http.get("http://localhost:8089/mChatbackend/getuserdetails/"+fromId)
		
		}
	
	friendService.updatePendingRequest=function(pendingRequest){
		return $http.put("http://localhost:8089/mChatbackend/updatependingrequest",pendingRequest)
		
	}
	
	friendService.listOfFriends=function(){
		return $http.get("http://localhost:8089/mChatbackend/listoffriends")
	}
	
	return friendService;

})