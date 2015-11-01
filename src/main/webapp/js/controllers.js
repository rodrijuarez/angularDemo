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

app.controller('RecetaController', [ 'RecetaFactory','RecetasFactory','$location', function(RecetaFactory,RecetasFactory,$location) {
    var vm = this;
    vm.init = function(){
        vm.cargarRecetas();
    }
    
    vm.editReceta = function (recetaId) {
        $location.path('/receta/detalle/' + recetaId);
    };
    
    vm.cargarRecetas = function(){
        vm.recetas = RecetasFactory.query();   
    }
    
    vm.deleteReceta = function(recetaId){
        RecetaFactory.delete({id:recetaId},vm.cargarRecetas);
    }
    
    vm.init();
    
} ]);