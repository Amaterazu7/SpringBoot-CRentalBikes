'use strict';

App.factory('PackService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllPacks: function() {
					return $http.get('http://localhost:8080/pack/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching packs');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createPack: function(pack){
					return $http.post('http://localhost:8080/pack/', pack)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating pack');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updatePack: function(pack, id){
					return $http.put('http://localhost:8080/pack/'+id, pack)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating pack');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deletePack: function(id){
					return $http.delete('http://localhost:8080/pack/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting pack');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
