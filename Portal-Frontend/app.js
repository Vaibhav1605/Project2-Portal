var Homemodule = angular.module('Homemodule',['ngRoute']);

Homemodule.config(function($routeProvider){
  $routeProvider

  .when("/",{
    templateUrl:'Home.html'

  })

  .when("/signup",{
    templateUrl:'SignUp.html'
  })

  .when("/Login",{
    templateUrl:'Login.html'
  })
})
