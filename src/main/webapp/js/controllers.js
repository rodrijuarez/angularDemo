var app = angular.module('ngdemo.controllers', []);

app.controller('RecetaController', [ '$scope', 'RecetaFactory', function($scope, RecetaFactory) {
    $scope.guardarReceta = function(){
        RecetaFactory.create($scope.receta);
    }
} ]);

app.controller('MainController', [ '$scope', function($scope) {
} ]);