Homemodule.controller('HomeController',function($scope,HomeService,$location){
  $scope.SignUp = function(){
    HomeService.SignUp($scope.Client).then(function(response){},function(response){})
  }
})
