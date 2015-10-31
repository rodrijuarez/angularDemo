var app = angular.module('ngdemo.controllers', []);

app.controller('RecetaCreationController', [ '$scope', 'RecetasFactory','$location', function($scope, RecetasFactory,$location) {
    $scope.guardarReceta = function() {
        RecetasFactory.create($scope.receta);
        $location.path('/recetas');
    }
} ]);

app.controller('RecetaDetailController', [ '$scope', 'RecetaFactory','$routeParams','$location', function($scope,RecetaFactory,$routeParams, $location) {
    $scope.actualizarReceta = function() {
        RecetaFactory.update($scope.receta);
        $location.path('/recetas');
    }
    $scope.receta = RecetaFactory.show({id: $routeParams.id})
} ]);

app.controller('RecetaController', [ '$scope', 'RecetaFactory','RecetasFactory','$location', function($scope, RecetaFactory,RecetasFactory,$location) {
    $scope.init = function(){
        $scope.cargarRecetas();
    }
    
    $scope.editReceta = function (recetaId) {
        $location.path('/receta/detalle/' + recetaId);
    };
    
    $scope.cargarRecetas = function(){
        $scope.recetas = RecetasFactory.query();   
    }
    
    $scope.deleteReceta = function(recetaId){
        RecetaFactory.delete({id:recetaId},$scope.cargarRecetas);
    }
    
    $scope.init();
    
} ]);