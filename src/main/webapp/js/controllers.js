var app = angular.module('ngdemo.controllers', []);

app.controller('RecetaFormController', [ '$scope', 'RecetasFactory', function($scope, RecetasFactory) {
    $scope.guardarReceta = function() {
        RecetasFactory.create($scope.receta);
    }
} ]);

app.controller('RecetaController', [ '$scope', 'RecetaFactory','RecetasFactory', function($scope, RecetaFactory,RecetasFactory) {
    $scope.init = function(){
        $scope.cargarRecetas();
    }
    
    $scope.cargarRecetas = function(){
        $scope.recetas = RecetasFactory.query();   
    }
    
    $scope.deleteReceta = function(recetaId){
        RecetaFactory.delete({id:recetaId},$scope.cargarRecetas);
    }
    
    $scope.init();
    
} ]);