'use strict';

App.controller('PackController', ['$scope', 'PackService', function($scope, PackService) {
          var self = this;
          self.pack={id:null,price:'',number:'',profile:''};
          self.packs=[];
              
          self.fetchAllPacks = function(){
              PackService.fetchAllPacks()
                  .then(
      					       function(d) {
      						        self.packs = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createPack = function(pack){
              PackService.createPack(pack)
		              .then(
                      self.fetchAllPacks, 
				              function(errResponse){
					               console.error('Error while creating Pack.');
				              }	
                  );
          };

         self.updatePack = function(pack, id){
              PackService.updatePack(pack, id)
		              .then(
				              self.fetchAllPacks, 
				              function(errResponse){
					               console.error('Error while updating Pack.');
				              }	
                  );
          };

         self.deletePack = function(id){
              PackService.deletePack(id)
		              .then(
				              self.fetchAllPacks, 
				              function(errResponse){
					               console.error('Error while deleting Pack.');
				              }	
                  );
          };

          self.fetchAllPacks();

          self.submit = function() {
              if(self.pack.id==null){
                  console.log('Saving New Pack', self.pack);    
                  self.createPack(self.pack);
              }else{
                  self.updatePack(self.pack, self.pack.id);
                  console.log('Pack updated with id ', self.pack.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.packs.length; i++){
                  if(self.packs[i].id == id) {
                     self.pack = angular.copy(self.packs[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.pack.id === id) {//clean form if the pack to be deleted is shown there.
                 self.reset();
              }
              self.deletePack(id);
          };

          
          self.reset = function(){             
              self.pack={id:null,price:'',number:'',profile:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
